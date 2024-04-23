package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.service.CokeService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
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
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.io.IOException;

/**
 *
 * @author victor
 */
@Component(
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

            _cokeService.deleteCoke(cokeId);
            SessionMessages.add(actionRequest, "cokeDeleted");

            renderURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_COKE_LIST);

            actionRequest.setAttribute("cokeId", cokeId);
            sendRedirect(actionRequest, actionResponse);
        } catch (PortalException | IOException e) {
            _log.error(e.getMessage());
            SessionErrors.add(actionRequest, "serviceErrorDetails", e);
            actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.VIEW_COKE_LIST);
        }
    }

    private final Log _log = LogFactoryUtil.getLog(DeleteCokeMVCActionCommand.class);

    @Reference
    protected CokeService _cokeService;
}