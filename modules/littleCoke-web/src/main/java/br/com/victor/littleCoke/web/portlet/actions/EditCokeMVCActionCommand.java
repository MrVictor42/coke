package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

            actionRequest.setAttribute("cokeId", cokeId);
            sendRedirect(actionRequest, actionResponse);
        } catch (PortalException | IOException e) {
            SessionErrors.add(actionRequest, "serviceErrorDetails", e);
            actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_COKE);
        }
    }

//    @Override
//    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
//        try {
//            long cokeId = ParamUtil.getLong(resourceRequest, CokeConstants.COKE_ID);
//            Coke coke = _cokeService.getCoke(cokeId);
//            List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
//            List<Integer> randomNumbers = new ArrayList<>();
//
//            for (int aux = 0; aux < userCokeList.size(); aux++) {
//                randomNumbers.add(aux + 1);
//            }
//
//            Collections.shuffle(randomNumbers); // Para embaralhar a lista
//
//            for (int aux = 0; aux < userCokeList.size(); aux++) {
//                UserCoke userCoke = userCokeList.get(aux);
//                int order = randomNumbers.get(aux);
//
//                _userCokeService.updateUserCokeOrder(userCoke.getUserCokeId(), order);
//            }
//            SessionMessages.add(resourceRequest, "updatedList");
//        } catch (PortalException e) {
//            _log.error(e.getMessage());
//            SessionErrors.add(resourceRequest, "errorUpdateList");
//        }
//    }

    private final Log _log = LogFactoryUtil.getLog(EditCokeMVCActionCommand.class);

    @Reference
    protected CokeService _cokeService;

    @Reference
    protected UserCokeService _userCokeService;
}