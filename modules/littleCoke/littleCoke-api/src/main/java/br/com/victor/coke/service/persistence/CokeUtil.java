/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service.persistence;

import br.com.victor.coke.model.Coke;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the coke service. This utility wraps <code>br.com.victor.coke.service.persistence.impl.CokePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CokePersistence
 * @generated
 */
public class CokeUtil {

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
	public static void clearCache(Coke coke) {
		getPersistence().clearCache(coke);
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
	public static Map<Serializable, Coke> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Coke> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Coke> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Coke> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Coke> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Coke update(Coke coke) {
		return getPersistence().update(coke);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Coke update(Coke coke, ServiceContext serviceContext) {
		return getPersistence().update(coke, serviceContext);
	}

	/**
	 * Returns all the cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cokes
	 */
	public static List<Coke> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cokes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CokeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @return the range of matching cokes
	 */
	public static List<Coke> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cokes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CokeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cokes
	 */
	public static List<Coke> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Coke> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cokes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CokeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cokes
	 */
	public static List<Coke> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Coke> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public static Coke findByUuid_First(
			String uuid, OrderByComparator<Coke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public static Coke fetchByUuid_First(
		String uuid, OrderByComparator<Coke> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public static Coke findByUuid_Last(
			String uuid, OrderByComparator<Coke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public static Coke fetchByUuid_Last(
		String uuid, OrderByComparator<Coke> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cokes before and after the current coke in the ordered set where uuid = &#63;.
	 *
	 * @param cokeId the primary key of the current coke
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coke
	 * @throws NoSuchCokeException if a coke with the primary key could not be found
	 */
	public static Coke[] findByUuid_PrevAndNext(
			long cokeId, String uuid, OrderByComparator<Coke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().findByUuid_PrevAndNext(
			cokeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cokes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cokes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the coke where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCokeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public static Coke findByUUID_G(String uuid, long groupId)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the coke where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public static Coke fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the coke where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public static Coke fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the coke where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the coke that was removed
	 */
	public static Coke removeByUUID_G(String uuid, long groupId)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of cokes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cokes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the cokes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cokes
	 */
	public static List<Coke> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the cokes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CokeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @return the range of matching cokes
	 */
	public static List<Coke> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the cokes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CokeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cokes
	 */
	public static List<Coke> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Coke> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cokes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CokeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cokes
	 */
	public static List<Coke> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Coke> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first coke in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public static Coke findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Coke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first coke in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public static Coke fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Coke> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last coke in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public static Coke findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Coke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last coke in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public static Coke fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Coke> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the cokes before and after the current coke in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cokeId the primary key of the current coke
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coke
	 * @throws NoSuchCokeException if a coke with the primary key could not be found
	 */
	public static Coke[] findByUuid_C_PrevAndNext(
			long cokeId, String uuid, long companyId,
			OrderByComparator<Coke> orderByComparator)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			cokeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the cokes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of cokes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cokes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the coke in the entity cache if it is enabled.
	 *
	 * @param coke the coke
	 */
	public static void cacheResult(Coke coke) {
		getPersistence().cacheResult(coke);
	}

	/**
	 * Caches the cokes in the entity cache if it is enabled.
	 *
	 * @param cokes the cokes
	 */
	public static void cacheResult(List<Coke> cokes) {
		getPersistence().cacheResult(cokes);
	}

	/**
	 * Creates a new coke with the primary key. Does not add the coke to the database.
	 *
	 * @param cokeId the primary key for the new coke
	 * @return the new coke
	 */
	public static Coke create(long cokeId) {
		return getPersistence().create(cokeId);
	}

	/**
	 * Removes the coke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cokeId the primary key of the coke
	 * @return the coke that was removed
	 * @throws NoSuchCokeException if a coke with the primary key could not be found
	 */
	public static Coke remove(long cokeId)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().remove(cokeId);
	}

	public static Coke updateImpl(Coke coke) {
		return getPersistence().updateImpl(coke);
	}

	/**
	 * Returns the coke with the primary key or throws a <code>NoSuchCokeException</code> if it could not be found.
	 *
	 * @param cokeId the primary key of the coke
	 * @return the coke
	 * @throws NoSuchCokeException if a coke with the primary key could not be found
	 */
	public static Coke findByPrimaryKey(long cokeId)
		throws br.com.victor.coke.exception.NoSuchCokeException {

		return getPersistence().findByPrimaryKey(cokeId);
	}

	/**
	 * Returns the coke with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cokeId the primary key of the coke
	 * @return the coke, or <code>null</code> if a coke with the primary key could not be found
	 */
	public static Coke fetchByPrimaryKey(long cokeId) {
		return getPersistence().fetchByPrimaryKey(cokeId);
	}

	/**
	 * Returns all the cokes.
	 *
	 * @return the cokes
	 */
	public static List<Coke> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cokes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CokeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @return the range of cokes
	 */
	public static List<Coke> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cokes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CokeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cokes
	 */
	public static List<Coke> findAll(
		int start, int end, OrderByComparator<Coke> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cokes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CokeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cokes
	 */
	public static List<Coke> findAll(
		int start, int end, OrderByComparator<Coke> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cokes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cokes.
	 *
	 * @return the number of cokes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CokePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CokePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CokePersistence _persistence;

}