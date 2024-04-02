/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service.impl;

import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.base.CokeServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

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

    public Coke createCoke(String name, ServiceContext serviceContext) {
        return cokeLocalService.createCoke(name, serviceContext);
    }

    public Coke deleteCoke(long cokeId) throws PortalException {
        return cokeLocalService.deleteCoke(cokeId);
    }

    public Coke getCoke(long cokeId) throws PortalException {
        return cokeLocalService.getCoke(cokeId);
    }

    public List<Coke> getAllCokes() {
        return cokeLocalService.getAllCokes();
    }
}