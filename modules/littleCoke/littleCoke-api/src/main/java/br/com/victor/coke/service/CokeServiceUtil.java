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

import br.com.victor.coke.model.Coke;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Coke. This utility wraps
 * <code>br.com.victor.coke.service.impl.CokeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author victor
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

	public static Coke deleteCoke(long cokeId) throws PortalException {
		return getService().deleteCoke(cokeId);
	}

	public static List<Coke> getAllCokes() {
		return getService().getAllCokes();
	}

	public static Coke getCoke(long cokeId) throws PortalException {
		return getService().getCoke(cokeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CokeService getService() {
		return _service;
	}

	private static volatile CokeService _service;

}