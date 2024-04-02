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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserCokeService}.
 *
 * @author victor
 * @see UserCokeService
 * @generated
 */
public class UserCokeServiceWrapper
	implements ServiceWrapper<UserCokeService>, UserCokeService {

	public UserCokeServiceWrapper() {
		this(null);
	}

	public UserCokeServiceWrapper(UserCokeService userCokeService) {
		_userCokeService = userCokeService;
	}

	@Override
	public br.com.victor.coke.model.UserCoke createUserCoke(
		long cokeId, long userId, String position) {

		return _userCokeService.createUserCoke(cokeId, userId, position);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userCokeService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<br.com.victor.coke.model.UserCoke>
		getUserCokeByCokeId(long cokeId) {

		return _userCokeService.getUserCokeByCokeId(cokeId);
	}

	@Override
	public UserCokeService getWrappedService() {
		return _userCokeService;
	}

	@Override
	public void setWrappedService(UserCokeService userCokeService) {
		_userCokeService = userCokeService;
	}

	private UserCokeService _userCokeService;

}