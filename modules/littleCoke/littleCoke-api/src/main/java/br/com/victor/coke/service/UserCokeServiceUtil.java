/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.victor.coke.service;

import br.com.victor.coke.model.UserCoke;

import java.util.List;

/**
 * Provides the remote service utility for UserCoke. This utility wraps
 * <code>br.com.victor.coke.service.impl.UserCokeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author victor
 * @see UserCokeService
 * @generated
 */
public class UserCokeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.victor.coke.service.impl.UserCokeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static UserCoke createUserCoke(
		long cokeId, long userId, String position) {

		return getService().createUserCoke(cokeId, userId, position);
	}

	public static UserCoke deleteUserCokeByUserCokeId(long userCokeId) {
		return getService().deleteUserCokeByUserCokeId(userCokeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<UserCoke> getUserCokeByCokeId(long cokeId) {
		return getService().getUserCokeByCokeId(cokeId);
	}

	public static UserCoke getUserCokeByCokeIdAndUserId(
		long cokeId, long userId) {

		return getService().getUserCokeByCokeIdAndUserId(cokeId, userId);
	}

	public static UserCokeService getService() {
		return _service;
	}

	private static volatile UserCokeService _service;

}