package br.com.victor.littleCoke.web.services;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Component(
    immediate = true,
    service = LittleCokeServices.class
)
public class LittleCokeServices {

    public void sendMessageWhatsapp(String message, long userId) {
        try {
            String messageEncoder = URLEncoder.encode(message, StandardCharsets.UTF_8.toString());
            User user = _userLocalService.getUser(userId);
            String phoneNumber = user.getPhones().stream().findFirst().orElse(null).getNumber();

            if(phoneNumber != null) {
                String urlWhatsApp = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + messageEncoder;
                URL url = new URL(urlWhatsApp);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                try (OutputStream os = conn.getOutputStream()) {
                    os.write(new byte[0]);
                }

                int responseCode = conn.getResponseCode();
                System.out.println("Response Code : " + responseCode);
            } else {
                _log.error("O corno não colocou adicionou um número de telefone!");
            }
        } catch (PortalException | IOException e) {
            _log.error(e.getMessage());
            _log.error("O corno não colocou adicionou um número de telefone!");
        }
    }

    private final Log _log = LogFactoryUtil.getLog(LittleCokeServices.class);

    @Reference
    private UserLocalService _userLocalService;
}