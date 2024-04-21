package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.constants.MondayConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.model.UserCokeModel;
import br.com.victor.coke.model.dto.CokeDTO;
import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.coke.service.mondayIntegration.services.MondayIntegrationService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import br.com.victor.littleCoke.web.util.LittleCokeUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author victor
 */
@Component(
    configurationPid = MondayConstants.PID_MONDAY_CONFIGURATION,
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
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), renderRequest);
            List<User> userList = _mondayIntegrationService.getUserMondayListDTO(serviceContext);
            List<Coke> cokeList = _cokeService.getAllCokes();

            List<CokeDTO> cokeDTOList = new ArrayList<>();
            for(Coke coke : cokeList) {
                CokeDTO cokeDTO = new CokeDTO();
                List<User> usersInUserCokeList = new ArrayList<>();
                List<UserCoke> userCokeInUserList = new ArrayList<>();
                List<User> nextUserList = new ArrayList<>();

                List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
                userList
                        .stream()
                        .filter(user -> userCokeList.stream().anyMatch(userCoke -> userCoke.getUserId() == user.getUserId()))
                        .forEach(user -> {
                            usersInUserCokeList.add(user);

                            UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), user.getUserId());

                            userCokeInUserList.add(userCoke);
                        });

                cokeDTO.setCoke(coke);
                cokeDTO.setInitialDate(LittleCokeUtil.formatDate(coke.getCreateDate()));
                cokeDTO.setUsersInUserCokeList(usersInUserCokeList);

                userCokeInUserList.sort(Comparator.comparing(UserCokeModel::getOrder));

                userCokeInUserList.stream().limit(2).forEach(userCoke -> {
                    try {
                        User user = _userLocalService.getUser(userCoke.getUserId());

                        nextUserList.add(user);
                    } catch (PortalException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                });
                cokeDTO.setUserCokeList(userCokeInUserList);
                cokeDTO.setNextUsersList(nextUserList);

                cokeDTOList.add(cokeDTO);
            }

            renderRequest.setAttribute("cokeDTOList", cokeDTOList);
        } catch (PortalException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return "/view.jsp";
    }

    private final Log _log = LogFactoryUtil.getLog(ViewCokeListMVCRenderCommand.class);

    @Reference
    private MondayIntegrationService _mondayIntegrationService;

    @Reference
    private CokeService _cokeService;

    @Reference
    private UserCokeService _userCokeService;

    @Reference
    private UserLocalService _userLocalService;
}