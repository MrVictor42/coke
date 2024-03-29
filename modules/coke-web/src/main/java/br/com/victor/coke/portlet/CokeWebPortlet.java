package br.com.victor.coke.portlet;

import br.com.victor.coke.constants.CokeWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author victor
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.social",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
        "com.liferay.portlet.scopeable=true",
		"javax.portlet.display-name=" + CokeWebPortletKeys.COKE_NAME,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/coke/view.jsp",
		"javax.portlet.name=" + CokeWebPortletKeys.COKE_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class CokeWebPortlet extends MVCPortlet {

}