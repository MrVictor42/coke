package br.com.victor.littleCoke.web.portlet;

import br.com.victor.littleCoke.web.constants.LittleCokeWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

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
        super.render(renderRequest, renderResponse);
    }
}