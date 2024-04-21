package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.CokeService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.util.Date;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + CokeConstants.LITTLE_COKE_WEB,
        "mvc.command.name=" + MVCCommandNames.EDIT_COKE
    },
    service = MVCActionCommand.class
)
public class EditCokeMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), actionRequest);
            long cokeId = ParamUtil.getLong(actionRequest, "cokeId");
//            String title = ParamUtil.getString(actionRequest, "title", StringPool.BLANK);
//            String description = ParamUtil.getString(actionRequest, "description", StringPool.BLANK);
//
//            Date dueDate = ParamUtil.getDate(actionRequest, "dueDate", DateFormatFactoryUtil.getDate(serviceContext.getLocale()));
//
//            // Call the service to update the assignment
//            _assignmentService.updateAssignment(assignmentId, title, description, dueDate, serviceContext);
//            SessionMessages.add(actionRequest, "assignmentUpdated");
            sendRedirect(actionRequest, actionResponse);
        } catch (PortalException | IOException e) {
            SessionErrors.add(actionRequest, "serviceErrorDetails", e);
            actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_COKE);
        }
    }

    @Reference
    protected CokeService _cokeService;
}