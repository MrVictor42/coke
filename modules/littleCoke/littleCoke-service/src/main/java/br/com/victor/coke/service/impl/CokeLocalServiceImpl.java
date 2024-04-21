/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service.impl;

import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.UserCokeLocalService;
import br.com.victor.coke.service.base.CokeLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * @author victor
 */
@Component(
        property = "model.class.name=br.com.victor.coke.model.Coke",
        service = AopService.class
)
public class CokeLocalServiceImpl extends CokeLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public Coke createCoke(String name, ServiceContext serviceContext) throws PortalException {
        long cokeId = counterLocalService.increment(Coke.class.getName());
        User user = userLocalService.getUser(serviceContext.getUserId());
        Coke coke = createCoke(cokeId);

        coke.setName(name);
        coke.setCompanyId(serviceContext.getCompanyId());
        coke.setUserId(serviceContext.getUserId());
        coke.setUserName(user.getFullName());
        coke.setGroupId(serviceContext.getScopeGroupId());
        coke.setCreateDate(new Date());
        coke.setModifiedDate(new Date());

        coke = super.addCoke(coke);

        return coke;
    }

    @Indexable(type = IndexableType.REINDEX)
    public Coke updateCoke(long cokeId, String name) throws PortalException {
        Coke coke = getCoke(cokeId);

        coke.setName(name);
        coke.setCreateDate(new Date());
        coke.setModifiedDate(new Date());

        return updateCoke(coke);
    }

    @Indexable(type = IndexableType.DELETE)
    public Coke deleteCoke(long cokeId) throws PortalException {
        Coke coke = getCoke(cokeId);

        resourceLocalService.deleteResource(coke, ResourceConstants.SCOPE_INDIVIDUAL);
        assetEntryLocalService.deleteEntry(Coke.class.getName(), coke.getCokeId());

        List<UserCoke> userCokeList = _userCokeLocalService.getUserCokeByCokeId(cokeId);

        userCokeList.forEach(userCoke -> _userCokeLocalService.deleteUserCoke(userCoke));

        return deleteCoke(coke);
    }

    public List<Coke> getAllCokes() {
        return cokeLocalService.getCokes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    @Reference
    private UserCokeLocalService _userCokeLocalService;
}