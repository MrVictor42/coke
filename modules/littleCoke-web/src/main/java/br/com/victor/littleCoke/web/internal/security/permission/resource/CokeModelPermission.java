package br.com.victor.littleCoke.web.internal.security.permission.resource;

import br.com.victor.coke.model.Coke;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class CokeModelPermission {

	public static boolean contains(PermissionChecker permissionChecker, Coke coke, String actionId) throws PortalException {
		return _cokeModelResourcePermission.contains(permissionChecker, coke, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long guestbookId, String actionId) throws PortalException {
		return _cokeModelResourcePermission.contains(permissionChecker, guestbookId, actionId);
	}

	@Reference(target = "(model.class.name=br.com.victor.coke.model.Coke)", unbind = "-")
	protected void setEntryModelPermission(ModelResourcePermission<Coke> modelResourcePermission) {
		_cokeModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<Coke> _cokeModelResourcePermission;
}
