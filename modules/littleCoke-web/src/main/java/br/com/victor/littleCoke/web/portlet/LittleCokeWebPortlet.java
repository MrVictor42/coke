package br.com.victor.littleCoke.web.portlet;

import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.littleCoke.web.constants.LittleCokeWebPortletKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author victor
 */
@Component(
    property = {
        "com.liferay.portlet.display-category=category.social",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=false",
        "com.liferay.portlet.scopeable=true",
        "javax.portlet.display-name=" + LittleCokeWebPortletKeys.COKE_NAME,
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/coke/view.jsp",
        "javax.portlet.name=" + LittleCokeWebPortletKeys.LITTLE_COKE_WEB,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.supports.mime-type=text/html;"
    },
	service = Portlet.class
)
public class LittleCokeWebPortlet extends MVCPortlet {

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            long cokeId = ParamUtil.getLong(renderRequest, "cokeId");
            List<User> userList = _userLocalService
                    .getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
                    .stream()
                    .filter(user -> !user.getEmailAddress().equalsIgnoreCase("default@liferay.com"))
                    .collect(Collectors.toList());
            List<User> usersInUserCokeList = null;
            List<User> usersNotInUserCokeList = null;

            if(cokeId != 0) {
                Coke coke = _cokeService.getCoke(cokeId);
                List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());

                usersNotInUserCokeList =
                        userList
                                .stream()
                                .filter(user -> userCokeList
                                        .stream()
                                        .noneMatch(userCoke -> userCoke.getUserId() == user.getUserId()))
                                .collect(Collectors.toList());
                usersInUserCokeList =
                        userList
                                .stream()
                                .filter(user -> userCokeList
                                        .stream()
                                        .anyMatch(userCoke -> userCoke.getUserId() == user.getUserId()))
                                .collect(Collectors.toList());

            }

            if(usersNotInUserCokeList == null) {
                renderRequest.setAttribute("userList", userList);
            } else {
                renderRequest.setAttribute("usersNotInUserCokeList", usersNotInUserCokeList);
                renderRequest.setAttribute("usersInUserCokeList", usersInUserCokeList);
            }

            super.render(renderRequest, renderResponse);
        } catch (PortletException | IOException | PortalException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addCoke(ActionRequest request, ActionResponse response) {
        String userName = ParamUtil.getString(request, "name");
        long guestbookId = ParamUtil.getLong(request, "cokeId");
        long entryId = ParamUtil.getLong(request, "userCokeId");
    }

    private final Log _log = LogFactoryUtil.getLog(LittleCokeWebPortlet.class);

    @Reference
    private CokeService _cokeService;

    @Reference
    private UserCokeService _userCokeService;

    @Reference
    private UserLocalService _userLocalService;
}