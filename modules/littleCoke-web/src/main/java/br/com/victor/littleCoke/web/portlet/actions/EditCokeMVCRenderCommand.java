package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.CokeLocalService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 *
 * @author victor
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + CokeConstants.LITTLE_COKE_WEB,
        "mvc.command.name=" + MVCCommandNames.EDIT_COKE
    },
    service = MVCRenderCommand.class
)
public class EditCokeMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        Coke coke = null;
        long cokeId = ParamUtil.getLong(renderRequest, "cokeId", 0);

//        if (assignmentId > 0) {
//            // Call the service to get the assignment for editing.
//            try {
//                assignment = _assignmentService.getAssignment(assignmentId);
//            } catch (PortalException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//        // Set back icon visible.
//        PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
//        portletDisplay.setShowBackIcon(true);
//        String redirect = renderRequest.getParameter("redirect");
//        portletDisplay.setURLBack(redirect);
//
//        // Set assignment to the request attributes.
//        renderRequest.setAttribute("assignment", assignment);
//        renderRequest.setAttribute("assignmentClass", Assignment.class);
//        SessionMessages.add(renderRequest, "assignmentUpdated");

        return "/coke/edit_coke.jsp";
    }

    @Reference
    private CokeLocalService _cokeLocalService;
}