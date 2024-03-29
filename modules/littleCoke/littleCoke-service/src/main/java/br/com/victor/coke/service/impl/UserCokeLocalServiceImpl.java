/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service.impl;

import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.base.UserCokeLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import org.osgi.service.component.annotations.Component;

/**
 * @author victor
 */
@Component(
	property = "model.class.name=br.com.victor.coke.model.UserCoke",
	service = AopService.class
)
public class UserCokeLocalServiceImpl extends UserCokeLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public UserCoke createUserCook(long cokeId, long userId, long addedBy) {
        long userCokeId = counterLocalService.increment(UserCoke.class.getName());
        UserCoke userCoke = createUserCoke(userCokeId);

        userCoke.setCokeId(cokeId);
        userCoke.setUserId(userId);
        userCoke.setAddedBy(addedBy);

        return addUserCoke(userCoke);
    }
}