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
        "mvc.command.name=/",
        "mvc.command.name=" + MVCCommandNames.VIEW_COKE_LIST
    },
    service = MVCRenderCommand.class
)
public class ViewCokeListMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        System.err.println("AAAAAAA");
        return "";
    }

    /*
        	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

		// Add assignment list related attributes.

		addAssignmentListAttributes(renderRequest);

		// Add Clay management toolbar related attributes.

		addManagementToolbarAttributes(renderRequest, renderResponse);

		// Add permission checker.
		renderRequest.setAttribute("assignmentPermission", _assignmentPermission);

		return "/view.jsp";
	}

	private void addAssignmentListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		// Get sorting options.
		// Notice that this doesn't really sort on title because the field is
		// stored in XML. In real world this search would be integrated to the
		// search engine
		// to get localized sort options.
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "title");

		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		// Create comparator
		OrderByComparator<Assignment> comparator = OrderByComparatorFactoryUtil.create("Assignment", orderByCol,
				!("asc").equals(orderByType));
		// Get keywords.
		// Notice that cleaning keywords is not implemented.
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		// Call the service to get the list of assignments.
		List<Assignment> assignments = _assignmentService.getAssignmentsByKeywords(themeDisplay.getScopeGroupId(),
				keywords, start, end, comparator);
		// Set request attributes.
		renderRequest.setAttribute("assignments", assignments);
		renderRequest.setAttribute("assignmentCount",
				_assignmentService.getAssignmentsCountByKeywords(themeDisplay.getScopeGroupId(), keywords));
	}

	private void addManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		AssignmentsManagementToolbarDisplayContext assignmentsManagementToolbarDisplayContext = new AssignmentsManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("assignmentsManagementToolbarDisplayContext",
				assignmentsManagementToolbarDisplayContext);
	}

	@Reference
	protected AssignmentService _assignmentService;

	@Reference
	private Portal _portal;

	@Reference
	protected AssignmentPermission _assignmentPermission;
     */
}