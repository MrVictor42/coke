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

package br.com.victor.coke.service.http;

import br.com.victor.coke.service.UserCokeServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>UserCokeServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author victor
 * @generated
 */
public class UserCokeServiceHttp {

	public static br.com.victor.coke.model.UserCoke createUserCoke(
		HttpPrincipal httpPrincipal, long cokeId, long userId, String position,
		int order) {

		try {
			MethodKey methodKey = new MethodKey(
				UserCokeServiceUtil.class, "createUserCoke",
				_createUserCokeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, cokeId, userId, position, order);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (br.com.victor.coke.model.UserCoke)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<br.com.victor.coke.model.UserCoke>
		getUserCokeByCokeId(HttpPrincipal httpPrincipal, long cokeId) {

		try {
			MethodKey methodKey = new MethodKey(
				UserCokeServiceUtil.class, "getUserCokeByCokeId",
				_getUserCokeByCokeIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, cokeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<br.com.victor.coke.model.UserCoke>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static br.com.victor.coke.model.UserCoke deleteUserCokeByUserCokeId(
		HttpPrincipal httpPrincipal, long userCokeId) {

		try {
			MethodKey methodKey = new MethodKey(
				UserCokeServiceUtil.class, "deleteUserCokeByUserCokeId",
				_deleteUserCokeByUserCokeIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userCokeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (br.com.victor.coke.model.UserCoke)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static br.com.victor.coke.model.UserCoke
		getUserCokeByCokeIdAndUserId(
			HttpPrincipal httpPrincipal, long cokeId, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				UserCokeServiceUtil.class, "getUserCokeByCokeIdAndUserId",
				_getUserCokeByCokeIdAndUserIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, cokeId, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (br.com.victor.coke.model.UserCoke)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static br.com.victor.coke.model.UserCoke updateUserCokeOrder(
		HttpPrincipal httpPrincipal, long userCokeId, int order) {

		try {
			MethodKey methodKey = new MethodKey(
				UserCokeServiceUtil.class, "updateUserCokeOrder",
				_updateUserCokeOrderParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userCokeId, order);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (br.com.victor.coke.model.UserCoke)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UserCokeServiceHttp.class);

	private static final Class<?>[] _createUserCokeParameterTypes0 =
		new Class[] {long.class, long.class, String.class, int.class};
	private static final Class<?>[] _getUserCokeByCokeIdParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _deleteUserCokeByUserCokeIdParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getUserCokeByCokeIdAndUserIdParameterTypes3 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _updateUserCokeOrderParameterTypes4 =
		new Class[] {long.class, int.class};

}