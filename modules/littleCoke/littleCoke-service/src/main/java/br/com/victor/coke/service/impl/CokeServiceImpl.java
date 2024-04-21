/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service.impl;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.base.CokeServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.List;

/**
 * @author victor
 */
@Component(
	property = {
		"json.web.service.context.name=coke",
		"json.web.service.context.path=Coke"
	},
	service = AopService.class
)
public class CokeServiceImpl extends CokeServiceBaseImpl {

    public Coke createCoke(String name, ServiceContext serviceContext) throws PortalException {
        return cokeLocalService.createCoke(name, serviceContext);
    }

    public Coke deleteCoke(long cokeId) throws PortalException {
        _cokeModelResourcePermission.check(getPermissionChecker(), cokeId, ActionKeys.DELETE);

        return cokeLocalService.deleteCoke(cokeId);
    }

    public Coke getCoke(long cokeId) throws PortalException {
        _cokeModelResourcePermission.check(getPermissionChecker(), cokeId, ActionKeys.VIEW);

        return cokeLocalService.getCoke(cokeId);
    }

    public Coke updateCoke(long cokeId, String name) throws PortalException {
        _cokeModelResourcePermission.check(getPermissionChecker(), cokeId, ActionKeys.UPDATE);

        return cokeLocalService.updateCoke(cokeId, name);
    }

    public List<Coke> getAllCokes() {
        return cokeLocalService.getAllCokes();
    }

    @Reference(
        policy = ReferencePolicy.DYNAMIC,
        policyOption = ReferencePolicyOption.GREEDY,
        target = "(model.class.name=" + CokeConstants.COKE_MODEL + ")"
    )
    private volatile ModelResourcePermission<Coke> _cokeModelResourcePermission;

    @Reference(
        policy = ReferencePolicy.DYNAMIC,
        policyOption = ReferencePolicyOption.GREEDY,
        target = "(resource.name=" + CokeConstants.RESOURCE_NAME +")"
    )
    private volatile PortletResourcePermission _portletResourcePermission;
}