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

package br.com.victor.coke.service.persistence;

import br.com.victor.coke.model.UserCoke;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user coke service. This utility wraps <code>br.com.victor.coke.service.persistence.impl.UserCokePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author victor
 * @see UserCokePersistence
 * @generated
 */
public class UserCokeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserCoke userCoke) {
		getPersistence().clearCache(userCoke);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserCoke> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserCoke> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserCoke> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserCoke> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserCoke> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserCoke update(UserCoke userCoke) {
		return getPersistence().update(userCoke);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserCoke update(
		UserCoke userCoke, ServiceContext serviceContext) {

		return getPersistence().update(userCoke, serviceContext);
	}

	/**
	 * Returns all the user cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user cokes
	 */
	public static List<UserCoke> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user cokes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @return the range of matching user cokes
	 */
	public static List<UserCoke> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user cokes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user cokes
	 */
	public static List<UserCoke> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserCoke> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user cokes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user cokes
	 */
	public static List<UserCoke> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserCoke> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	public static UserCoke findByUuid_First(
			String uuid, OrderByComparator<UserCoke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchUserCokeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public static UserCoke fetchByUuid_First(
		String uuid, OrderByComparator<UserCoke> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	public static UserCoke findByUuid_Last(
			String uuid, OrderByComparator<UserCoke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchUserCokeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public static UserCoke fetchByUuid_Last(
		String uuid, OrderByComparator<UserCoke> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user cokes before and after the current user coke in the ordered set where uuid = &#63;.
	 *
	 * @param userCokeId the primary key of the current user coke
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user coke
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	public static UserCoke[] findByUuid_PrevAndNext(
			long userCokeId, String uuid,
			OrderByComparator<UserCoke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchUserCokeException {

		return getPersistence().findByUuid_PrevAndNext(
			userCokeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the user cokes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user cokes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the user cokes where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @return the matching user cokes
	 */
	public static List<UserCoke> findBycokeId(long cokeId) {
		return getPersistence().findBycokeId(cokeId);
	}

	/**
	 * Returns a range of all the user cokes where cokeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param cokeId the coke ID
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @return the range of matching user cokes
	 */
	public static List<UserCoke> findBycokeId(long cokeId, int start, int end) {
		return getPersistence().findBycokeId(cokeId, start, end);
	}

	/**
	 * Returns an ordered range of all the user cokes where cokeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param cokeId the coke ID
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user cokes
	 */
	public static List<UserCoke> findBycokeId(
		long cokeId, int start, int end,
		OrderByComparator<UserCoke> orderByComparator) {

		return getPersistence().findBycokeId(
			cokeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user cokes where cokeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param cokeId the coke ID
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user cokes
	 */
	public static List<UserCoke> findBycokeId(
		long cokeId, int start, int end,
		OrderByComparator<UserCoke> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycokeId(
			cokeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	public static UserCoke findBycokeId_First(
			long cokeId, OrderByComparator<UserCoke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchUserCokeException {

		return getPersistence().findBycokeId_First(cokeId, orderByComparator);
	}

	/**
	 * Returns the first user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public static UserCoke fetchBycokeId_First(
		long cokeId, OrderByComparator<UserCoke> orderByComparator) {

		return getPersistence().fetchBycokeId_First(cokeId, orderByComparator);
	}

	/**
	 * Returns the last user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	public static UserCoke findBycokeId_Last(
			long cokeId, OrderByComparator<UserCoke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchUserCokeException {

		return getPersistence().findBycokeId_Last(cokeId, orderByComparator);
	}

	/**
	 * Returns the last user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public static UserCoke fetchBycokeId_Last(
		long cokeId, OrderByComparator<UserCoke> orderByComparator) {

		return getPersistence().fetchBycokeId_Last(cokeId, orderByComparator);
	}

	/**
	 * Returns the user cokes before and after the current user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param userCokeId the primary key of the current user coke
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user coke
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	public static UserCoke[] findBycokeId_PrevAndNext(
			long userCokeId, long cokeId,
			OrderByComparator<UserCoke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchUserCokeException {

		return getPersistence().findBycokeId_PrevAndNext(
			userCokeId, cokeId, orderByComparator);
	}

	/**
	 * Removes all the user cokes where cokeId = &#63; from the database.
	 *
	 * @param cokeId the coke ID
	 */
	public static void removeBycokeId(long cokeId) {
		getPersistence().removeBycokeId(cokeId);
	}

	/**
	 * Returns the number of user cokes where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @return the number of matching user cokes
	 */
	public static int countBycokeId(long cokeId) {
		return getPersistence().countBycokeId(cokeId);
	}

	/**
	 * Caches the user coke in the entity cache if it is enabled.
	 *
	 * @param userCoke the user coke
	 */
	public static void cacheResult(UserCoke userCoke) {
		getPersistence().cacheResult(userCoke);
	}

	/**
	 * Caches the user cokes in the entity cache if it is enabled.
	 *
	 * @param userCokes the user cokes
	 */
	public static void cacheResult(List<UserCoke> userCokes) {
		getPersistence().cacheResult(userCokes);
	}

	/**
	 * Creates a new user coke with the primary key. Does not add the user coke to the database.
	 *
	 * @param userCokeId the primary key for the new user coke
	 * @return the new user coke
	 */
	public static UserCoke create(long userCokeId) {
		return getPersistence().create(userCokeId);
	}

	/**
	 * Removes the user coke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke that was removed
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	public static UserCoke remove(long userCokeId)
		throws br.com.victor.coke.exception.NoSuchUserCokeException {

		return getPersistence().remove(userCokeId);
	}

	public static UserCoke updateImpl(UserCoke userCoke) {
		return getPersistence().updateImpl(userCoke);
	}

	/**
	 * Returns the user coke with the primary key or throws a <code>NoSuchUserCokeException</code> if it could not be found.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	public static UserCoke findByPrimaryKey(long userCokeId)
		throws br.com.victor.coke.exception.NoSuchUserCokeException {

		return getPersistence().findByPrimaryKey(userCokeId);
	}

	/**
	 * Returns the user coke with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke, or <code>null</code> if a user coke with the primary key could not be found
	 */
	public static UserCoke fetchByPrimaryKey(long userCokeId) {
		return getPersistence().fetchByPrimaryKey(userCokeId);
	}

	/**
	 * Returns all the user cokes.
	 *
	 * @return the user cokes
	 */
	public static List<UserCoke> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user cokes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @return the range of user cokes
	 */
	public static List<UserCoke> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user cokes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user cokes
	 */
	public static List<UserCoke> findAll(
		int start, int end, OrderByComparator<UserCoke> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user cokes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user cokes
	 */
	public static List<UserCoke> findAll(
		int start, int end, OrderByComparator<UserCoke> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user cokes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user cokes.
	 *
	 * @return the number of user cokes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserCokePersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserCokePersistence _persistence;

}