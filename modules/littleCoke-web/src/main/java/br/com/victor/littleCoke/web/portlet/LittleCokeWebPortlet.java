package br.com.victor.littleCoke.web.portlet;

import br.com.victor.coke.constants.CokeConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author victor
 */
@Component(
    property = {
            "com.liferay.portlet.display-category=category.social",
            "com.liferay.portlet.header-portlet-css=/css/main.css",
            "com.liferay.portlet.css-class-wrapper=coke-portlet",
            "com.liferay.portlet.instanceable=false",
            "com.liferay.portlet.scopeable=true",
            "javax.portlet.display-name=" + CokeConstants.COKE_NAME,
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/view.jsp",
            "javax.portlet.name=" + CokeConstants.LITTLE_COKE_WEB,
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=power-user,user",
            "javax.portlet.supports.mime-type=text/html;"
    },
    service = Portlet.class
)
public class LittleCokeWebPortlet extends MVCPortlet {



    /*

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            String mondayAPI = _mondayConfiguration.getMondayAPI();
            String token = _mondayConfiguration.getToken();
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), renderRequest);

            _mondayIntegrationService.setApiURL(mondayAPI);
            _mondayIntegrationService.setToken(token);

            List<User> userList = _mondayIntegrationService.getUserMondayListDTO(serviceContext);
            List<Coke> cokeList = _cokeService.getAllCokes();
            long cokeId = ParamUtil.getLong(renderRequest, CokeConstants.COKE_ID);

            if(!cokeList.isEmpty() || cokeId == 0) {
                if(cokeId == 0 && cokeList.isEmpty()) {
                    renderRequest.setAttribute("cokeId", cokeId);
                    renderRequest.setAttribute("userList", userList);
                } else {
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

                    renderRequest.setAttribute("cokeId", cokeId);
                    renderRequest.setAttribute("userList", userList);
                    renderRequest.setAttribute("cokeDTOList", cokeDTOList);
                }
            }

            if(cokeId > 0) {
                try {
                    Coke coke = _cokeService.getCoke(cokeId);
                    List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
                    CokeDTO cokeDTO = new CokeDTO();
                    List<User> usersInUserCokeList = new ArrayList<>();
                    List<UserCoke> userCokeInUserList = new ArrayList<>();
                    List<User> usersNotInUserCokeList;
                    List<User> nextUserList = new ArrayList<>();

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
                } catch (PortalException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            super.render(renderRequest, renderResponse);
        } catch (PortletException | IOException | PortalException e) {
            _log.error(e.getMessage());
        }
    }

    public void addOrUpdateCoke(ActionRequest actionRequest, ActionResponse actionResponse) {
        String cokeName = ParamUtil.getString(actionRequest, CokeConstants.NAME);
        long cokeId = ParamUtil.getLong(actionRequest, CokeConstants.COKE_ID);
        long[] associatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_ASSOCIATED);
        long[] notAssociatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_NOT_ASSOCIATED);

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), actionRequest);
            if(cokeId == 0) {
                List<Integer> randomOrder = new ArrayList<>();

                for(int aux = 0; aux < associatedValues.length; aux ++) {
                    randomOrder.add(aux + 1);
                }

                Collections.shuffle(randomOrder); // Para embaralhar a lista
                Coke coke = _cokeService.createCoke(cokeName, serviceContext);

                for(int aux = 0; aux < associatedValues.length; aux ++) {
                    int order = randomOrder.get(aux);
                    long userId = associatedValues[aux];

                    _userCokeService.createUserCoke(coke.getCokeId(), userId, CokeConstants.ASSOCIATED, order);
                }

                SessionMessages.add(actionRequest, "cokeAdded");
            } else {
                Coke coke = _cokeService.getCoke(cokeId);
                coke = _cokeService.updateCoke(coke.getCokeId(), cokeName);

                for (long notAssociatedId : notAssociatedValues) {
                    UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), notAssociatedId);

                    if (userCoke != null) {
                        _userCokeService.deleteUserCokeByUserCokeId(userCoke.getUserCokeId());
                    }
                }

                // Crie uma lista de todos os UserCokes associados
                List<UserCoke> userCokes = new ArrayList<>();
                for(long userId : associatedValues) {
                    UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), userId);
                    if(userCoke != null) {
                        userCokes.add(userCoke);
                    }
                }

                // Ordene a lista pelo campo 'order'
                userCokes.sort(Comparator.comparingInt(UserCoke::getOrder));

                // Reatribua a ordem
                for(int i = 0; i < userCokes.size(); i++) {
                    UserCoke userCoke = userCokes.get(i);
                    userCoke.setOrder(i + 1); // A ordem começa em 1
                    _userCokeService.updateUserCokeOrder(userCoke.getUserCokeId(), userCoke.getOrder());
                }

                // Adicione novos integrantes ao final
                for(long userId : associatedValues) {
                    UserCoke userCoke = _userCokeService.getUserCokeByCokeIdAndUserId(coke.getCokeId(), userId);
                    if(userCoke == null) {
                        int order = userCokes.size() + 1; // A próxima ordem
                        _userCokeService.createUserCoke(coke.getCokeId(), userId, CokeConstants.ASSOCIATED, order);
                    }
                }

                List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());

                if(userCokeList.isEmpty()) {
                    long userId = serviceContext.getUserId();
                    _userCokeService.createUserCoke(coke.getCokeId(), userId, CokeConstants.ASSOCIATED, 1); // Para sempre manter alguem cadastrado
                    _userCokeService.createUserCoke(coke.getCokeId(), userId, CokeConstants.ASSOCIATED, 2); // Para sempre manter alguem cadastrado
                }

                SessionMessages.add(actionRequest, "updatedCoke");
            }
        } catch (PortalException e) {
            _log.error(e.getMessage());
            SessionErrors.add(actionRequest, "errorUpdateCoke");
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
            SessionMessages.add(resourceRequest, "updatedList");
        } catch (PortalException e) {
            _log.error(e.getMessage());
            SessionErrors.add(resourceRequest, "errorUpdateList");
        }
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _mondayConfiguration = ConfigurableUtil.createConfigurable(MondayConfiguration.class, properties);
    }

    private volatile MondayConfiguration _mondayConfiguration;

    private final Log _log = LogFactoryUtil.getLog(LittleCokeWebPortlet.class);

    @Reference
    private CokeService _cokeService;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private UserCokeService _userCokeService;

    @Reference
    private MondayIntegrationService _mondayIntegrationService;

     */
}