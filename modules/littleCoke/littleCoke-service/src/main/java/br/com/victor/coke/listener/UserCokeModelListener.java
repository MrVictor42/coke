package br.com.victor.coke.listener;

import br.com.victor.coke.config.coke.CokeConfiguration;
import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.CokeLocalService;
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
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component(
    configurationPid = CokeConstants.PID_COKE_CONFIGURATION,
    immediate = true,
    service = ModelListener.class
)
public class UserCokeModelListener extends BaseModelListener<UserCoke> {

    @Override
    public void onAfterUpdate(UserCoke originalModel, UserCoke userCoke) throws ModelListenerException {
        if(_cokeConfiguration.getAvatarURLDiscord().isEmpty() || _cokeConfiguration.getWebhookDiscordAPI().isEmpty()) {
            _log.error("Insira o avatar do seu boot do discord e a api do webhook nas configurações e tente novament");

            return;
        }

        if(userCoke.getNextToPay()) {
            try {
                URL url = new URL(_cokeConfiguration.getWebhookDiscordAPI());
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
                User user = _userLocalService.getUser(userCoke.getUserId());
                Coke coke = _cokeLocalService.getCoke(userCoke.getCokeId());

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

                jsonObject.put("username", "Coquinha BOT");
                jsonObject.put("avatar_url", _cokeConfiguration.getAvatarURLDiscord());
                jsonObject.put("content", "Para as pessoas da bancada: " + coke.getName() + " ,hoje é o dia do cidadão ou cidadã pagar, e essa pessoa é: " + user.getFullName());

                byte[] input = jsonObject.toJSONString().getBytes(StandardCharsets.UTF_8);
                httpURLConnection.setFixedLengthStreamingMode(input.length);
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                httpURLConnection.connect();

                try(OutputStream os = httpURLConnection.getOutputStream()) {
                    os.write(input, 0, input.length);
                }

                int code = httpURLConnection.getResponseCode();

                if (code == HttpURLConnection.HTTP_FORBIDDEN) {
                    System.out.println("Erro 403: Acesso negado. Verifique se o seu token de webhook é válido.");
                }
            } catch (IOException | PortalException e) {
                _log.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        super.onAfterUpdate(originalModel, userCoke);
    }

    private final Log _log = LogFactoryUtil.getLog(UserCokeModelListener.class);

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _cokeConfiguration = ConfigurableUtil.createConfigurable(CokeConfiguration.class, properties);
    }
    private volatile CokeConfiguration _cokeConfiguration;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private CokeLocalService _cokeLocalService;
}