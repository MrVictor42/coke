package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
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
        "mvc.command.name=" + MVCCommandNames.VIEW_COKE
    },
    service = MVCRenderCommand.class
)
public class ViewSingleCokeMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        System.err.println("CEASER");
        return "";
    }

    /*
    @Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long assignmentId = ParamUtil.getLong(renderRequest, "assignmentId", 0);

        // Call the service to get the assignment.

        Assignment assignment = null;
        try {
            assignment = _assignmentService.getAssignment(assignmentId);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("EEEEE, MMMMM dd, yyyy", renderRequest.getLocale());

        // Set attributes to the request.
        renderRequest.setAttribute("assignment", assignment);
        renderRequest.setAttribute("dueDate", dateFormat.format(assignment.getDueDate()));
        renderRequest.setAttribute("createDate", dateFormat.format(assignment.getCreateDate()));

        // Set back icon visible.
        PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
        String redirect = renderRequest.getParameter("redirect");
        portletDisplay.setShowBackIcon(true);
        portletDisplay.setURLBack(redirect);

        return "/assignment/view_assignment.jsp";
    }

	@Reference
	private AssignmentService _assignmentService;
     */
}