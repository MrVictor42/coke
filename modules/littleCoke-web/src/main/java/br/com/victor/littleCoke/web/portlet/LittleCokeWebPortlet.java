package br.com.victor.littleCoke.web.portlet;

import br.com.victor.coke.service.CokeService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.coke.service.UserCokeServiceUtil;
import br.com.victor.littleCoke.web.constants.LittleCokeWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;

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
        "javax.portlet.supports.mime-type=text/html"
    },
	service = Portlet.class
)
public class LittleCokeWebPortlet extends MVCPortlet {

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        System.err.println("Chegamos");

        long cokeId = 0;

        renderRequest.setAttribute("userCokeId", 0);
        renderRequest.setAttribute("cokeId", cokeId);

        super.render(renderRequest, renderResponse);
    }

    public void addCoke(ActionRequest request, ActionResponse response) {
        String userName = ParamUtil.getString(request, "name");
        long guestbookId = ParamUtil.getLong(request, "cokeId");
        long entryId = ParamUtil.getLong(request, "userCokeId");
    }

    @Reference
    private CokeService _cokeService;

    @Reference
    private UserCokeService _userCokeService;
}