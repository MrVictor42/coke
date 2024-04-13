/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service.impl;

import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.base.UserCokeServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author victor
 */
@Component(
	property = {
		"json.web.service.context.name=coke",
		"json.web.service.context.path=UserCoke"
	},
	service = AopService.class
)
public class UserCokeServiceImpl extends UserCokeServiceBaseImpl {

    public UserCoke createUserCoke(long cokeId, long userId, String username, String position, int order) {
        return userCokeLocalService.createUserCoke(cokeId, userId, username, position, order);
    }

    public List<UserCoke> getUserCokeByCokeId(long cokeId) {
        return userCokeLocalService.getUserCokeByCokeId(cokeId);
    }

    public UserCoke deleteUserCokeByUserCokeId(long userCokeId) {
        return userCokeLocalService.deleteUserCokeByUserCokeId(userCokeId);
    }

    public UserCoke getUserCokeByCokeIdAndUserId(long cokeId, long userId) {
        return userCokeLocalService.getUserCokeByCokeIdAndUserId(cokeId, userId);
    }

    public UserCoke updateUserCokeOrder(long userCokeId, int order) {
        return userCokeLocalService.updateUserCokeOrder(userCokeId, order);
    }
}