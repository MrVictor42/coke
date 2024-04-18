package br.com.victor.coke.listener;

import br.com.victor.coke.config.monday.MondayConfiguration;
import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.constants.MondayConstants;
import br.com.victor.coke.model.UserCoke;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component(
    configurationPid = MondayConstants.PID_MONDAY_CONFIGURATION,
    immediate = true,
    service = ModelListener.class
)
public class UserCokeModelListener extends BaseModelListener<UserCoke> {

    @Override
    public void onAfterUpdate(UserCoke originalModel, UserCoke userCoke) throws ModelListenerException {
        //            if (userCoke.getOrder() == CokeConstants.NEXT_TO_PAY) {
//                // Supondo que você tenha as informações necessárias do usuário
//                String userId = "39648087"; // ID do usuário no Monday
//
//                // Construir a consulta de mutação
//                String query = "mutation { create_notification (user_id: \"" + userId + "\", target_id: 4265334181, text: \"This is a notification\", target_type: Post) { text } }";
//
//                // Construir o objeto JSON com a consulta
//                JSONObject json = JSONFactoryUtil.createJSONObject();
//                json.put("query", query);
//
//                // URL da API do Monday
//                URL url = new URL("https://api.monday.com/v2");
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//                // Configurações da conexão HTTP
//                conn.setRequestProperty("Accept", "application/json");
//                conn.setRequestProperty("Authorization", _mondayConfiguration.getToken()	);
//                conn.setRequestProperty("API-Version", "2023-10");
//                conn.setRequestProperty("Access-Control-Allow-Origin", "*");
//
//                conn.setRequestMethod("POST");
//                conn.setDoOutput(true);
//
//                // Enviar a consulta como uma solicitação POST
//                try (OutputStream os = conn.getOutputStream()) {
//                    byte[] input = json.toString().getBytes(StandardCharsets.UTF_8);
//                    os.write(input, 0, input.length);
//                }
//
//                // Ler a resposta da solicitação
//                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
//                    StringBuilder response = new StringBuilder();
//                    String responseLine;
//                    while ((responseLine = br.readLine()) != null) {
//                        response.append(responseLine.trim());
//                    }
//                    System.out.println(response.toString());
//                }
//            }

        super.onAfterUpdate(originalModel, userCoke);
    }

    private final Log _log = LogFactoryUtil.getLog(UserCokeModelListener.class);

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _mondayConfiguration = ConfigurableUtil.createConfigurable(MondayConfiguration.class, properties);
    }
    private volatile MondayConfiguration _mondayConfiguration;

    @Reference
    private UserLocalService _userLocalService;
}