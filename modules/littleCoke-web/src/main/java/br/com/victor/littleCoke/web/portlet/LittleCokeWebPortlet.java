package br.com.victor.littleCoke.web.portlet;

import br.com.victor.coke.constatns.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.model.dto.UserRelationDTO;
import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.coke.service.mondayIntegration.MondayIntegrationQuery;
import br.com.victor.coke.service.mondayIntegration.services.MondayIntegrationService;
import br.com.victor.littleCoke.web.constants.LittleCokeWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
import java.util.Collections;
import java.util.List;

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
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
        try {
            List<UserRelationDTO> relationDTOList = new ArrayList<>();
            String query = MondayIntegrationQuery.USERS_QUERY;
            String token = "eyJhbGciOiJIUzI1NiJ9.eyJ0aWQiOjE2ODY3MjgzNiwidWlkIjoxMTY5ODM2MSwiaWFkIjoiMjAyMi0wNy0wNFQxNzoxNzo0NS4wMDBaIiwicGVyIjoibWU6d3JpdGUiLCJhY3RpZCI6NTI3MTMxOSwicmduIjoidXNlMSJ9.y8VA6hbD4qvi5Cj-YN7Tiow2QJ3aPh2ji89ZItE_lwM";
            String apiURL = "https://api.monday.com/v2";

            MondayIntegrationService mondayIntegrationService = new MondayIntegrationService();

            mondayIntegrationService.setToken(token);
            mondayIntegrationService.setApiURL(apiURL);

            JSONObject jsonResponse = mondayIntegrationService.sendRequest(query);

            if(jsonResponse != null) {
                JSONArray jsonArray = jsonResponse.getJSONObject("data").getJSONArray("users");

                if(jsonArray != null) {
                    for(int aux = 0; aux < jsonArray.length(); aux ++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(aux);

                        String name = jsonObject.getString("name");
                        String enabled = jsonObject.getString("enabled");

                        System.err.println(name);
                        System.err.println(enabled);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

//        if (jsonResponse != null) {
//            JsonArray users = jsonResponse.getAsJsonObject("data").getAsJsonArray("users");
//            for (JsonElement userObj : users) {
//                JsonObject user = userObj.getAsJsonObject();
//                String email = user.get("email").getAsString();
//                User userByEmail = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, email);
//
//                if (Validator.isNotNull(userByEmail)) {
//                    UserMondayDTO userMondayDTO = new UserMondayDTO().deserialize(JSONFactoryUtil.createJSONObject(user.toString()));
//                    UserRelationDTO relationDTO = new UserRelationDTO();
//                    relationDTO.setUserId(String.valueOf(userByEmail.getUserId()));
//                    relationDTO.setUserMondayId(userMondayDTO.getId());
//                    relationDTOList.add(relationDTO);
//                }
//            }
//        }


        super.render(renderRequest, renderResponse);

//        try {
//            List<User> userList = _userLocalService
//                    .getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
//                    .stream()
//                    .filter(user -> !user.getEmailAddress().equalsIgnoreCase("default@liferay.com"))
//                    .filter(user -> !user.getEmailAddress().contains("anonymous"))
//                    .collect(Collectors.toList());
//            List<Coke> cokeList = _cokeService.getAllCokes();
//            List<CokeDTO> cokeDTOList = new ArrayList<>();
//
//            if(!cokeList.isEmpty()) {
//                for(Coke coke : cokeList) {
//                    CokeDTO cokeDTO = new CokeDTO();
//                    List<UserCoke> userCokeList = _userCokeService.getUserCokeByCokeId(coke.getCokeId());
//                    List<User> usersInUserCokeList =
//                            userList
//                                    .stream()
//                                    .filter(user -> userCokeList.stream().anyMatch(userCoke -> userCoke.getUserId() == user.getUserId()))
//                                    .collect(Collectors.toList());
//
//                    cokeDTO.setCoke(coke);
//                    cokeDTO.setInitialDate(LittleCokeUtil.formatDate(coke.getCreateDate()));
//                    cokeDTO.setUsersInUserCokeList(usersInUserCokeList);
//
//                    cokeDTOList.add(cokeDTO);
//                }
//            }
//
//            renderRequest.setAttribute("cokeDTOList", cokeDTOList);
//
//            super.render(renderRequest, renderResponse);
//        } catch (PortletException | IOException e) {
//            _log.error(e.getMessage());
//            throw new RuntimeException(e.getMessage());
//        }
    }

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