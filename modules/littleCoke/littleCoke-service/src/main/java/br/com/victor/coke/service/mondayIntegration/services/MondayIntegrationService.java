package br.com.victor.coke.service.mondayIntegration.services;

import br.com.victor.coke.service.mondayIntegration.MondayIntegrationQuery;
import br.com.victor.coke.service.mondayIntegration.util.MondayIntegrationUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component(
    immediate = true,
    service = MondayIntegrationService.class
)
public class MondayIntegrationService {

    private String apiURL;
    private String token;

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<User> getUserMondayListDTO(ServiceContext serviceContext) {
        try {
            List<User> userList =
                    _userLocalService.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
                            .stream()
                            .filter(user -> !user.getEmailAddress().equalsIgnoreCase("test@liferay.com"))
                            .filter(user -> !user.getEmailAddress().equalsIgnoreCase("default@liferay.com"))
                            .filter(user -> !user.getEmailAddress().contains("anonymous"))
                            .collect(Collectors.toList());
            String query = MondayIntegrationQuery.USERS_QUERY;

            if(!userList.isEmpty()) {
                return userList;
            }

            List<User> userListFinal = new ArrayList<>();
            JSONObject jsonResponse = sendRequest(query);

            if(jsonResponse != null) {
                _log.info("Iniciando a Integração Com o Monday");
                JSONArray jsonArray = jsonResponse.getJSONObject("data").getJSONArray("users");

                if(jsonArray != null) {
                    for(int aux = 0; aux < jsonArray.length(); aux ++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(aux);
                        boolean enabled = jsonObject.getBoolean("enabled");
                        JSONObject account = jsonObject.getJSONObject("account");
                        String email = jsonObject.getString("email");

                        if(account.length() > 0 && email != null) {
                            if(MondayIntegrationUtil.isValidPerson(enabled, email)) {
                                long mondayUserId = jsonObject.getLong("id");
                                String name = jsonObject.getString("name");
                                String defaultPassword = "test";

                                User user = createUser(mondayUserId, email, name, defaultPassword, serviceContext);

                                userListFinal.add(user);
                            }
                        }
                    }
                    _log.info("Encerrando a Integração Com o Monday");
                }
            }
            return userListFinal;
        } catch (JSONException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private JSONObject sendRequest(String query) throws JSONException {
        boolean shouldRetry;
        JSONObject jsonResponse = null;

        do {
            shouldRetry = false; // Assume que não precisará repetir a princípio
            JSONObject requestBody = JSONFactoryUtil.createJSONObject();

            requestBody.put("query", query);

            Response response = _getRequest(token, apiURL).post(Entity.entity(requestBody.toJSONString(), MediaType.APPLICATION_JSON));
            String jsonString = response.readEntity(String.class);

            if (isComplexityException(jsonString)) {
                int waitTime = extractResetTime(jsonString);
                System.out.println("[ERRO DE COMPLEXIDADE DA API, THREAD ESPERANDO " + waitTime + " PARA VOLTAR A PROCESSAR]");
                try {
                    Thread.sleep((waitTime + 1) * 1000L); // Aguarda o tempo recomendado antes de tentar novamente
                    shouldRetry = true; // Marca para tentativa de reenvio
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restaura a interrupção se a thread for interrompida durante o sono
                }
            } else {
                jsonResponse = JSONFactoryUtil.createJSONObject(jsonString); // Processa a resposta se não houver erro de complexidade
            }
        } while (shouldRetry); // Continua tentando enquanto for necessário

        return jsonResponse; // Retorna a resposta JSON processada ou null se houve erro
    }

    private boolean isComplexityException(String jsonResponse) {
        try {
            JSONObject responseObj = JSONFactoryUtil.createJSONObject(jsonResponse);
            if (responseObj.has("error_code") && "ComplexityException".equals(responseObj.getString("error_code"))) {
                return true;
            }
        } catch (Exception e) {
            _log.error("Erro ao verificar ComplexityException: ", e);
        }
        return false;
    }

    // Regex para extrair o número de segundos do texto de complexidade
    private int extractResetTime(String errorMessage) {
        Matcher matcher = Pattern.compile("reset in (\\d+) seconds").matcher(errorMessage);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    private Invocation.Builder _getRequest(String token, String apiURL) {
        MondayAPITarget target = new MondayAPITarget(apiURL, token);

        return target.getNewClient().target(apiURL).request();
    }

    private User createUser(long mondayUserId, String email, String name, String defaultPassword, ServiceContext serviceContext) {
        try {
            long companyId = serviceContext.getCompanyId();
            String firstName = MondayIntegrationUtil.getFirstName(name);
            String lastName = MondayIntegrationUtil.getLastName(name);
            String username = MondayIntegrationUtil.getUserName(name);

            serviceContext.setAddGroupPermissions(true);

            if(!name.equals(email)) {
                return _userLocalService.addUser(
                        0, companyId, false, defaultPassword, defaultPassword, false, username, email,
                        LocaleUtil.BRAZIL, firstName, "", lastName, mondayUserId, 0, true,
                        4, 15, 1912, "", null, null, null,
                        null, false, serviceContext
                );
            }
        } catch (PortalException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    private final Log _log = LogFactoryUtil.getLog(MondayIntegrationService.class);

    @Reference
    private UserLocalService _userLocalService;
}