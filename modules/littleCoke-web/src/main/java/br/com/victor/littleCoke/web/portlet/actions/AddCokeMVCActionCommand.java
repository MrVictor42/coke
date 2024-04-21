package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.CokeLocalService;
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
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.ArrayList;
import java.util.Collections;
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
    service = MVCActionCommand.class
)
public class AddCokeMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), actionRequest);
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String cokeName = ParamUtil.getString(actionRequest, CokeConstants.NAME, StringPool.BLANK);
            long cokeId = ParamUtil.getLong(actionRequest, CokeConstants.COKE_ID, 0);
            long[] associatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_ASSOCIATED);
            long[] notAssociatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_NOT_ASSOCIATED);

            List<Integer> randomOrder = new ArrayList<>();

            for(int aux = 0; aux < associatedValues.length; aux ++) {
                randomOrder.add(aux + 1);
            }

            Collections.shuffle(randomOrder); // Para embaralhar a lista
//            Coke coke = _cokeService.createCoke(cokeName, serviceContext);
//
//            for(int aux = 0; aux < associatedValues.length; aux ++) {
//                int order = randomOrder.get(aux);
//                long userId = associatedValues[aux];
//
//                _userCokeService.createUserCoke(coke.getCokeId(), userId, CokeConstants.ASSOCIATED, order);
//            }

            SessionMessages.add(actionRequest, "cokeAdded");

            /*
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
             */
        } catch (PortalException e) {
            _log.error(e.getMessage());
        }
    }

    private final Log _log = LogFactoryUtil.getLog(AddCokeMVCActionCommand.class);

    @Reference
    private CokeService _cokeService;

    @Reference
    private UserCokeService _userCokeService;
}