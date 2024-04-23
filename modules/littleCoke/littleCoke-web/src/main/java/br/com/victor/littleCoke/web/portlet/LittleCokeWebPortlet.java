package br.com.victor.littleCoke.web.portlet;

import br.com.victor.coke.constants.CokeConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

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

}