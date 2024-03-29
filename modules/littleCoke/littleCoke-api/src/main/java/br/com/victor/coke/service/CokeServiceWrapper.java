/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CokeService}.
 *
 * @author Brian Wing Shun Chan
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