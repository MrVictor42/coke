package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.mondayIntegration.services.MondayIntegrationService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 *
 * @author victor
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + CokeConstants.LITTLE_COKE_WEB,
        "mvc.command.name=" + MVCCommandNames.ADD_COKE
    },
    service = MVCRenderCommand.class
)
public class AddCokeMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), renderRequest);
            List<User> userList = _mondayIntegrationService.getUserMondayListDTO(serviceContext);

            renderRequest.setAttribute("userList", userList);

            return "/coke/add_coke.jsp";
        } catch (PortalException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private final Log _log = LogFactoryUtil.getLog(AddCokeMVCRenderCommand.class);

    @Reference
    private MondayIntegrationService _mondayIntegrationService;
}