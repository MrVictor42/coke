package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + CokeConstants.LITTLE_COKE_WEB,
        "mvc.command.name=" + MVCCommandNames.EDIT_COKE
    },
    service = MVCActionCommand.class
)
public class EditCokeMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Coke.class.getName(), actionRequest);
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            PortletURL renderURL = PortletURLFactoryUtil.create(actionRequest, CokeConstants.LITTLE_COKE_WEB, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
            String cokeName = ParamUtil.getString(actionRequest, CokeConstants.NAME);
            long cokeId = ParamUtil.getLong(actionRequest, CokeConstants.COKE_ID);
            long[] associatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_ASSOCIATED);
            long[] notAssociatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_NOT_ASSOCIATED);
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
            }

            SessionMessages.add(actionRequest, "updatedCoke");

            renderURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_COKE_LIST);

            actionRequest.setAttribute("cokeId", cokeId);
            sendRedirect(actionRequest, actionResponse);
        } catch (PortalException | IOException e) {
            _log.error(e.getMessage());
            SessionErrors.add(actionRequest, "serviceErrorDetails", e);
            actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_COKE);
        }
    }

    private final Log _log = LogFactoryUtil.getLog(EditCokeMVCActionCommand.class);

    @Reference
    protected CokeService _cokeService;

    @Reference
    protected UserCokeService _userCokeService;
}