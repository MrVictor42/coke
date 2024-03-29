/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service;

import br.com.victor.coke.model.Coke;

/**
 * Provides the remote service utility for Coke. This utility wraps
 * <code>br.com.victor.coke.service.impl.CokeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CokeService
 * @generated
 */
public class CokeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.victor.coke.service.impl.CokeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Coke createCoke(
		String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().createCoke(name, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Coke updateCoke(String name, long cokeId) {
		return getService().updateCoke(name, cokeId);
	}

	public static CokeService getService() {
		return _service;
	}

	public static void setService(CokeService service) {
		_service = service;
	}

	private static volatile CokeService _service;

}