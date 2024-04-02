package br.com.victor.littleCoke.web.portlet;

import br.com.victor.coke.constatns.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.littleCoke.web.constants.LittleCokeWebPortletKeys;
import br.com.victor.littleCoke.web.dto.CokeDTO;
import br.com.victor.littleCoke.web.util.LittleCokeUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
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
            List<User> userList = _userLocalService
                    .getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
                    .stream()
                    .filter(user -> !user.getEmailAddress().equalsIgnoreCase("default@liferay.com"))
                    .filter(user -> !user.getEmailAddress().contains("anonymous"))
                    .collect(Collectors.toList());
            List<Coke> cokeList = _cokeService.getAllCokes();
            List<CokeDTO> cokeDTOList = new ArrayList<>();

            if(!cokeList.isEmpty()) {
                for(Coke coke : cokeList) {
                    CokeDTO cokeDTO = new CokeDTO();
                    List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
                    List<User> usersInUserCokeList =
                            userList
                                    .stream()
                                    .filter(user -> userCokeList.stream().anyMatch(userCoke -> userCoke.getUserId() == user.getUserId()))
                                    .collect(Collectors.toList());

                    cokeDTO.setCoke(coke);
                    cokeDTO.setInitialDate(LittleCokeUtil.formatDate(coke.getCreateDate()));
                    cokeDTO.setUsersInUserCokeList(usersInUserCokeList);

                    cokeDTOList.add(cokeDTO);
                }
            }

            renderRequest.setAttribute("cokeDTOList", cokeDTOList);

            super.render(renderRequest, renderResponse);
        } catch (PortletException | IOException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addCoke(ActionRequest request, ActionResponse response) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), request);
            String name = ParamUtil.getString(request, CokeConstants.NAME);
            long cokeId = ParamUtil.getLong(request, CokeConstants.COKE_ID);

            // Criar método para remover os usuários, provavelmente é só excluir o userCoke

            if(cokeId > 0) {
                List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(cokeId);

                boolean permitted = userCokeList.stream().anyMatch(userCoke -> userCoke.getUserId() == serviceContext.getUserId());

                if (permitted) {
                    System.err.println("Chegamos");
                }

            } else {
                String[] consagratedValues = request.getParameterMap().get(CokeConstants.CONSAGRATED);

                if (consagratedValues != null && consagratedValues.length == 2) {
                    try {
                        long presidentId = Long.parseLong(consagratedValues[0]);
                        long vicePresidentId = Long.parseLong(consagratedValues[1]);

                        Coke coke = _cokeService.createCoke(name, serviceContext);

                        // Cadastro do Presidente e do Vice Presidente
                        _userCokeService.createUserCoke(coke.getCokeId(), presidentId, CokeConstants.PRESIDENT);
                        _userCokeService.createUserCoke(coke.getCokeId(), vicePresidentId, CokeConstants.VICE_PRESIDENT);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao analisar o presidenteId ou vicePresident");
                    }
                } else {
                    return;
                }
            }
        } catch (PortalException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private final Log _log = LogFactoryUtil.getLog(LittleCokeWebPortlet.class);

    @Reference
    private CokeService _cokeService;

    @Reference
    private UserCokeService _userCokeService;

    @Reference
    private UserLocalService _userLocalService;
}