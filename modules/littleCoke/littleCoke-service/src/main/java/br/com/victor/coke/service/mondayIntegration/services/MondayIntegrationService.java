package br.com.victor.coke.service.mondayIntegration.services;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MondayIntegrationService {

    private String apiURL;
    private String token;

    public String getApiURL() {
        return apiURL;
    }

    public String getToken() {
        return token;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JSONObject sendRequest(String query) throws JSONException {
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
            if (responseObj.has("error_code")
                    && "ComplexityException".equals(responseObj.getString("error_code"))) {
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

    private final Log _log = LogFactoryUtil.getLog(MondayIntegrationService.class);
}