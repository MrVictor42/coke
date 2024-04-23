package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.model.UserCokeModel;
import br.com.victor.coke.model.dto.CokeDTO;
import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.coke.service.mondayIntegration.services.MondayIntegrationService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), renderRequest);
            List<User> userList = _mondayIntegrationService.getUserMondayListDTO(serviceContext);
            long cokeId = ParamUtil.getLong(renderRequest, CokeConstants.COKE_ID, 0);
            Coke coke = _cokeService.getCoke(cokeId);
            List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
            CokeDTO cokeDTO = new CokeDTO();
            List<User> usersInUserCokeList = new ArrayList<>();
            List<UserCoke> userCokeInUserList = new ArrayList<>();
            List<User> usersNotInUserCokeList;
            List<User> nextUserList = new ArrayList<>();
            boolean canDelete = serviceContext.getUserId() == coke.getUserId();

            userList
                    .stream()
                    .filter(user -> userCokeList.stream().anyMatch(userCoke -> userCoke.getUserId() == user.getUserId()))
                    .forEach(user -> {
                        usersInUserCokeList.add(user);

                        UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), user.getUserId());

                        userCokeInUserList.add(userCoke);
                    });

            usersNotInUserCokeList = userList.stream()
                    .filter(userItem -> userCokeList.stream()
                            .noneMatch(userCoke -> userCoke.getUserId() == userItem.getUserId()))
                    .collect(Collectors.toList());

            cokeDTO.setCoke(coke);
            cokeDTO.setUsersInUserCokeList(usersInUserCokeList);
            cokeDTO.setUsersNotInUserCokeList(usersNotInUserCokeList);

            userCokeInUserList.sort(Comparator.comparing(UserCokeModel::getOrder));

            userCokeInUserList.forEach(userCoke -> {
                try {
                    User user = _userLocalService.getUser(userCoke.getUserId());

                    nextUserList.add(user);
                } catch (PortalException e) {
                    throw new RuntimeException(e);
                }
            });
            cokeDTO.setUserCokeList(userCokeInUserList);
            cokeDTO.setNextUsersList(nextUserList);

            renderRequest.setAttribute("cokeDTO", cokeDTO);
            renderRequest.setAttribute("canDelete", canDelete);

            return "/coke/edit_coke.jsp";
        } catch (PortalException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private final Log _log = LogFactoryUtil.getLog(EditCokeMVCRenderCommand.class);

    @Reference
    private MondayIntegrationService _mondayIntegrationService;

    @Reference
    private CokeService _cokeService;

    @Reference
    private UserCokeService _userCokeService;

    @Reference
    private UserLocalService _userLocalService;
}