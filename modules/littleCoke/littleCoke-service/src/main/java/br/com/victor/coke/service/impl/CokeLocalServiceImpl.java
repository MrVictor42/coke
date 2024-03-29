/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service.impl;

import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.base.CokeLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author victor
 */
@Component(
	property = "model.class.name=br.com.victor.coke.model.Coke",
	service = AopService.class
)
public class CokeLocalServiceImpl extends CokeLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public Coke createCoke(String name, ServiceContext serviceContext) {
        long cokeId = counterLocalService.increment(Coke.class.getName());
        Coke coke = createCoke(cokeId);

        coke.setName(name);
        coke.setCompanyId(serviceContext.getCompanyId());
        coke.setUserId(serviceContext.getUserId());
        coke.setGroupId(serviceContext.getScopeGroupId());
        coke.setCreateDate(new Date());
        coke.setModifiedDate(new Date());

        return addCoke(coke);
    }

    @Indexable(type = IndexableType.REINDEX)
    public Coke updateCoke(String name, long cokeId) {
        try {
            Coke coke = getCoke(cokeId);

            coke.setName(name);

            return updateCoke(coke);
        } catch (PortalException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private final Log _log = LogFactoryUtil.getLog(CokeLocalServiceImpl.class);
}