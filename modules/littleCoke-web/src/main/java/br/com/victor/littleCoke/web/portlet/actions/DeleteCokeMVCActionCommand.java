package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.service.CokeService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
        long cokeId = ParamUtil.getLong(actionRequest, "cokeId");
//            _cokeService.deleteCoke(cokeId);
//            SessionMessages.add(actionRequest, "cokeDeleted");
    }

    @Reference
    protected CokeService _cokeService;
}