/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service.impl;

import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.base.UserCokeLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author victor
 */
@Component(
	property = "model.class.name=br.com.victor.coke.model.UserCoke",
	service = AopService.class
)
public class UserCokeLocalServiceImpl extends UserCokeLocalServiceBaseImpl {

    @Indexable(type = IndexableType.REINDEX)
    public UserCoke createUserCoke(long cokeId, long userId, String position) {
        long userCokeId = counterLocalService.increment(UserCoke.class.getName());
        UserCoke userCoke = createUserCoke(userCokeId);

        userCoke.setCokeId(cokeId);
        userCoke.setUserId(userId);
        userCoke.setPosition(position);

        return addUserCoke(userCoke);
    }

    @Indexable(type = IndexableType.DELETE)
    public UserCoke deleteUserCokeByUserCokeId(long userCokeId) {
        try {
            return deleteUserCoke(userCokeId);
        } catch (PortalException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public UserCoke getUserCokeByCokeIdAndUserId(long cokeId, long userId) {
        List<UserCoke> userCokeList = getUserCokeByCokeId(cokeId);

        return userCokeList.stream().filter(userCoke -> userCoke.getUserId() == userId).findAny().orElse(null);
    }

    public List<UserCoke> getUserCokeByCokeId(long cokeId) {
        return userCokePersistence.findBycokeId(cokeId);
    }

    private final Log _log = LogFactoryUtil.getLog(UserCokeLocalServiceImpl.class);
}