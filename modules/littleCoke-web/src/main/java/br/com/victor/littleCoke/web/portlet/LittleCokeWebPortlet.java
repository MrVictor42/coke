package br.com.victor.littleCoke.web.portlet;

import br.com.victor.coke.constatns.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.model.dto.CokeDTO;
import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.littleCoke.web.constants.LittleCokeWebPortletKeys;
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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
            long cokeId = ParamUtil.getLong(renderRequest, CokeConstants.COKE_ID);

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
            renderRequest.setAttribute("cokeId", cokeId);

            super.render(renderRequest, renderResponse);
        } catch (PortletException | IOException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addOrUpdateCoke(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), actionRequest);
            String cokeName = ParamUtil.getString(actionRequest, CokeConstants.NAME);
            long cokeId = ParamUtil.getLong(actionRequest, CokeConstants.COKE_ID);
            long[] associatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_ASSOCIATED);
            long[] notAssociatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_NOT_ASSOCIATED);

            if(cokeId > 0) {
                try {
                    Coke coke = _cokeService.getCoke(cokeId);
                    List<Integer> randomNumbers = new ArrayList<>();
                    List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
                    int newAssociated = 0;

                    if(cokeName != null && !cokeName.isEmpty()) {
                        _cokeService.updateCoke(cokeId, cokeName);
                    } else {
                        _cokeService.updateCoke(cokeId, coke.getName());
                    }

                    for (long associatedId : associatedValues) {
                        UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), associatedId);

                        if (userCoke == null) {
                            newAssociated ++;
                        }
                    }

                    for (long notAssociatedId : notAssociatedValues) {
                        UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), notAssociatedId);

                        if (userCoke != null) {
                            _userCokeService.deleteUserCokeByUserCokeId(userCoke.getUserCokeId());
                        }
                    }

//                    int maxOrder = userCokeList.stream().mapToInt(UserCoke::getOrder).max().orElse(0);
//
//                    for (int aux = 0; aux < newAssociated; aux++) {
//                        randomNumbers.add(maxOrder + aux + 1);
//                    }
//
//                    Collections.shuffle(randomNumbers); // Para embaralhar a lista
//
//                    for (UserCoke userCoke : userCokeList) {
//                        int order = randomNumbers.remove(randomNumbers.size() - 1);
//
//                        _userCokeService.updateUserCokeOrder(userCoke.getUserCokeId(), order);
//                    }
//
//                    // Crie novos associados com 'order' aleatório
//                    for (long associatedId : associatedValues) {
//                        UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), associatedId);
//
//                        if (userCoke == null && !randomNumbers.isEmpty()) {
//                            int order = randomNumbers.remove(randomNumbers.size() - 1);
//                            _userCokeService.createUserCoke(coke.getCokeId(), associatedId, CokeConstants.ASSOCIATED, order);
//                        }
//                    }
                    SessionMessages.add(actionRequest, "updatedLittleCoke");
                } catch (Exception e) {
                    _log.error(e.getMessage());
                    SessionErrors.add(actionRequest, e.getClass().getName());
                    PortalUtil.copyRequestParameters(actionRequest, actionResponse);

                    actionResponse.setRenderParameter("mvcPath", "/coke/edit_coke.jsp");
                }
            } else {
                Coke coke = _cokeService.createCoke(cokeName, serviceContext);

                for(long associated : associatedValues) {
                    System.err.println(associated);

//                    _userCokeService.createUserCoke(coke.getCokeId(), presidentId, CokeConstants.ASSOCIATED, 0);
                }
            }
        } catch (Exception e) {
            _log.error(e.getMessage());
            SessionErrors.add(actionRequest, e.getClass().getName());
            PortalUtil.copyRequestParameters(actionRequest, actionResponse);

            actionResponse.setRenderParameter("mvcPath", "/coke/edit_coke.jsp");
        }
    }


//    public void addOrUpdateCoke(ActionRequest actionRequest) {
//        try {
//            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), actionRequest);
//            String name = ParamUtil.getString(actionRequest, CokeConstants.NAME);
//            long cokeId = ParamUtil.getLong(actionRequest, CokeConstants.COKE_ID);
//
//            if(cokeId > 0) {
//                try {
//                    Coke coke = _cokeService.getCoke(cokeId);
//                    long[] associatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_ASSOCIATED);
//                    long[] notAssociatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_NOT_ASSOCIATED);
//                    List<Integer> randomNumbers = new ArrayList<>();
//                    List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
//                    int maxOrder = userCokeList.stream().mapToInt(UserCoke::getOrder).max().orElse(0);
//                    int newAssociated = 0;
//
//                    for (long associatedId : associatedValues) {
//                        UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), associatedId);
//
//                        if (userCoke == null) {
//                            newAssociated ++;
//                        }
//                    }
//
//                    for (long notAssociatedId : notAssociatedValues) {
//                        UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), notAssociatedId);
//
//                        if (userCoke != null) {
//                            _userCokeService.deleteUserCokeByUserCokeId(userCoke.getUserCokeId());
//                        }
//                    }
//
//                    for (int aux = 0; aux < newAssociated; aux++) {
//                        randomNumbers.add(aux + 1);
//                    }
//
//                    Collections.shuffle(randomNumbers); // Para embaralhar a lista
//
//                    for (int aux = 0; aux < userCokeList.size(); aux++) {
//                        UserCoke userCoke = userCokeList.get(aux);
//                        int order = randomNumbers.get(aux);
//
//                        _userCokeService.updateUserCokeOrder(userCoke.getUserCokeId(), order);
//                    }
////
////                    for (long associatedId : associatedValues) {
////                        UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), associatedId);
////
////                        if (userCoke == null) {
////                            _userCokeService.createUserCoke(coke.getCokeId(), associatedId, CokeConstants.ASSOCIATED, 0);
////                        }
////                    }
//
//                    /*
//
////                            _userCokeService.createUserCoke(coke.getCokeId(), associatedId, CokeConstants.ASSOCIATED, 0);
//
//                            /*
//                                        long cokeId = ParamUtil.getLong(resourceRequest, CokeConstants.COKE_ID);
//            Coke coke = _cokeService.getCoke(cokeId);
//            List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
//
//            for (int aux = 0; aux < userCokeList.size(); aux++) {
//                randomNumbers.add(aux + 1);
//            }
//
//
//            for (int aux = 0; aux < userCokeList.size(); aux++) {
//                UserCoke userCoke = userCokeList.get(aux);
//                int order = randomNumbers.get(aux);
//
//                _userCokeService.updateUserCokeOrder(userCoke.getUserCokeId(), order);
//            }
//                             */
//
//
//
//                    SessionMessages.add(actionRequest, "updatedCoke");
//                } catch (PortalException e) {
//                    _log.error(e.getMessage());
//                    throw new RuntimeException(e.getMessage());
//                }
//            }

            /*

        if (entryId > 0) {
            try {
                _guestbookEntryLocalService.updateGuestbookEntry(
                    serviceContext.getUserId(), guestbookId, entryId, userName,
                    email, message, serviceContext
                );

                response.setRenderParameter("guestbookId", Long.toString(guestbookId));
                SessionMessages.add(request, "entryAdded");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());

                SessionErrors.add(request, e.getClass().getName());
                PortalUtil.copyRequestParameters(request, response);

                response.setRenderParameter("mvcPath", "/guestbook/edit_entry.jsp");
            }
        }
        else {
            try {
                _guestbookEntryLocalService.addGuestbookEntry(
                    serviceContext.getUserId(), guestbookId, userName, email,
                    message, serviceContext
                );

                response.setRenderParameter("guestbookId", Long.toString(guestbookId));
            }
            catch (Exception e) {
                System.out.println(e.getMessage());

                PortalUtil.copyRequestParameters(request, response);

                response.setRenderParameter("mvcPath", "/guestbook/edit_entry.jsp");
            }
        }
    }
             */
//        } catch (PortalException e) {
//            _log.error(e.getMessage());
//            throw new RuntimeException(e.getMessage());
//        }
//    }

    public void updateCoke(ActionRequest actionRequest, ActionResponse actionResponse) {
        long cokeId = ParamUtil.getLong(actionRequest, CokeConstants.COKE_ID);

        if (cokeId > 0) {
            try {
                Coke coke = _cokeService.getCoke(cokeId);
                long[] associatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_ASSOCIATED);
                long[] notAssociatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_NOT_ASSOCIATED);

                for (long associatedId : associatedValues) {
                    UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), associatedId);

                    if (userCoke == null) {
                        _userCokeService.createUserCoke(coke.getCokeId(), associatedId, CokeConstants.ASSOCIATED, 0);
                    }
                }

                for (long notAssociatedId : notAssociatedValues) {
                    UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), notAssociatedId);

                    if (userCoke != null) {
                        _userCokeService.deleteUserCokeByUserCokeId(userCoke.getUserCokeId());
                    }
                }
            } catch (PortalException e) {
                _log.error(e.getMessage());
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public void addCoke(ActionRequest request, ActionResponse response) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), request);
            String name = ParamUtil.getString(request, CokeConstants.NAME);
            long cokeId = ParamUtil.getLong(request, CokeConstants.COKE_ID);

            // Criar método para remover os usuários, provavelmente é só excluir o userCoke

            if (cokeId > 0) {
                List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(cokeId);

                boolean permitted = userCokeList.stream().anyMatch(userCoke -> userCoke.getUserId() == serviceContext.getUserId());

                if (permitted) {
                    System.err.println("Chegamos");
                }

            } else {
                String[] associatedValues = request.getParameterMap().get(CokeConstants.REQUEST_ASSOCIATED);

                if (associatedValues != null && associatedValues.length == 2) {
                    try {
                        long presidentId = Long.parseLong(associatedValues[0]);
                        long vicePresidentId = Long.parseLong(associatedValues[1]);

                        Coke coke = _cokeService.createCoke(name, serviceContext);

                        // Cadastro do Presidente e do Vice Presidente
                        _userCokeService.createUserCoke(coke.getCokeId(), presidentId, CokeConstants.ASSOCIATED, 0);
                        _userCokeService.createUserCoke(coke.getCokeId(), vicePresidentId, CokeConstants.ASSOCIATED, 0);
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

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        try {
            long cokeId = ParamUtil.getLong(resourceRequest, CokeConstants.COKE_ID);
            Coke coke = _cokeService.getCoke(cokeId);
            List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
            List<Integer> randomNumbers = new ArrayList<>();

            for (int aux = 0; aux < userCokeList.size(); aux++) {
                randomNumbers.add(aux + 1);
            }

            Collections.shuffle(randomNumbers); // Para embaralhar a lista

            for (int aux = 0; aux < userCokeList.size(); aux++) {
                UserCoke userCoke = userCokeList.get(aux);
                int order = randomNumbers.get(aux);

                _userCokeService.updateUserCokeOrder(userCoke.getUserCokeId(), order);
            }
        } catch (PortalException e) {
            _log.error(e.getMessage());
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