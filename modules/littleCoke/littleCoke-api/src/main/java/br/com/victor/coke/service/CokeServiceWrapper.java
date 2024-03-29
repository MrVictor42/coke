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
 * Provides a wrapper for {@link CokeService}.
 *
 * @author victor
 * @see CokeService
 * @generated
 */
public class CokeServiceWrapper
	implements CokeService, ServiceWrapper<CokeService> {

	public CokeServiceWrapper() {
		this(null);
	}

	public CokeServiceWrapper(CokeService cokeService) {
		_cokeService = cokeService;
	}

	@Override
	public br.com.victor.coke.model.Coke createCoke(
		String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cokeService.createCoke(name, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cokeService.getOSGiServiceIdentifier();
	}

	@Override
	public br.com.victor.coke.model.Coke updateCoke(String name, long cokeId) {
		return _cokeService.updateCoke(name, cokeId);
	}

	@Override
	public CokeService getWrappedService() {
		return _cokeService;
	}

	@Override
	public void setWrappedService(CokeService cokeService) {
		_cokeService = cokeService;
	}

	private CokeService _cokeService;

}