package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.config.coke.CokeConfiguration;
import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.CokeLocalService;
import br.com.victor.coke.service.CokeService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 *
 * @author victor
 */
@Component(
    configurationPid = CokeConstants.PID_COKE_CONFIGURATION,
    immediate = true,
    property = {
        "javax.portlet.name=" + CokeConstants.LITTLE_COKE_WEB,
        "mvc.command.name=" + MVCCommandNames.DELETE_COKE
    },
    service = MVCActionCommand.class
)
public class DeleteCokeMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            PortletURL renderURL = PortletURLFactoryUtil.create(actionRequest, CokeConstants.LITTLE_COKE_WEB, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
            long cokeId = ParamUtil.getLong(actionRequest, CokeConstants.COKE_ID);

            URL url = new URL(_cokeConfiguration.getWebhookDiscordAPI());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            Coke coke = _cokeLocalService.getCoke(cokeId);

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

            jsonObject.put("username", "Coquinha BOT");
            jsonObject.put("avatar_url", _cokeConfiguration.getAvatarURLDiscord());
            jsonObject.put("content", "O Portlet " + coke.getName() + " Foi Excluido Com Sucesso. Parabéns aos Envolvidos");

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

            _cokeService.deleteCoke(cokeId);
            SessionMessages.add(actionRequest, "cokeDeleted");
            renderURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_COKE_LIST);

            sendRedirect(actionRequest, actionResponse);
        } catch (PortalException | IOException e) {
            _log.error(e.getMessage());
            SessionErrors.add(actionRequest, "serviceErrorDetails", e);
            actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.VIEW_COKE_LIST);
        }
    }

    private final Log _log = LogFactoryUtil.getLog(DeleteCokeMVCActionCommand.class);

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _cokeConfiguration = ConfigurableUtil.createConfigurable(CokeConfiguration.class, properties);
    }
    private volatile CokeConfiguration _cokeConfiguration;

    @Reference
    private CokeLocalService _cokeLocalService;

    @Reference
    protected CokeService _cokeService;
}