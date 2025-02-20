package br.com.victor.littleCoke.web.internal.security.permission.resource;

import br.com.victor.coke.constants.CokeConstants;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class CokePermission {

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {
		return _portletResourcePermission.contains(permissionChecker, groupId, actionId);
	}

	@Reference(target = "(resource.name=" + CokeConstants.RESOURCE_NAME + ")", unbind = "-")
	protected void setPortletResourcePermission(PortletResourcePermission portletResourcePermission) {
		_portletResourcePermission = portletResourcePermission;
	}

	private static PortletResourcePermission _portletResourcePermission;
}
