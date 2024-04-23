package br.com.victor.littleCoke.web.portlet.actions;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.littleCoke.web.constants.MVCCommandNames;
import com.liferay.petra.string.StringPool;
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
            PortletURL renderURL = PortletURLFactoryUtil.create(actionRequest, CokeConstants.LITTLE_COKE_WEB, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
            String cokeName = ParamUtil.getString(actionRequest, CokeConstants.NAME, StringPool.BLANK);
            long[] associatedValues = ParamUtil.getLongValues(actionRequest, CokeConstants.REQUEST_ASSOCIATED);

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

            renderURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_COKE_LIST);
            actionResponse.sendRedirect(renderURL.toString());
        } catch (Exception e) {
            SessionErrors.add(actionRequest, "errorAddCoke");
            _log.error("Error while processing addCoke action", e);
        }
    }

    private final Log _log = LogFactoryUtil.getLog(AddCokeMVCActionCommand.class);

    @Reference
    private CokeService _cokeService;

    @Reference
    private UserCokeService _userCokeService;
}