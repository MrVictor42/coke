/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.service.persistence;

import br.com.victor.coke.exception.NoSuchCokeException;
import br.com.victor.coke.model.Coke;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the coke service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CokeUtil
 * @generated
 */
@ProviderType
public interface CokePersistence extends BasePersistence<Coke> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CokeUtil} to access the coke persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cokes
	 */
	public java.util.List<Coke> findByUuid(String uuid);

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
	public java.util.List<Coke> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Coke> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator);

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
	public java.util.List<Coke> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public Coke findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Coke>
				orderByComparator)
		throws NoSuchCokeException;

	/**
	 * Returns the first coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public Coke fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator);

	/**
	 * Returns the last coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public Coke findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Coke>
				orderByComparator)
		throws NoSuchCokeException;

	/**
	 * Returns the last coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public Coke fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator);

	/**
	 * Returns the cokes before and after the current coke in the ordered set where uuid = &#63;.
	 *
	 * @param cokeId the primary key of the current coke
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coke
	 * @throws NoSuchCokeException if a coke with the primary key could not be found
	 */
	public Coke[] findByUuid_PrevAndNext(
			long cokeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Coke>
				orderByComparator)
		throws NoSuchCokeException;

	/**
	 * Removes all the cokes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cokes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the coke where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCokeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public Coke findByUUID_G(String uuid, long groupId)
		throws NoSuchCokeException;

	/**
	 * Returns the coke where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public Coke fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the coke where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public Coke fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the coke where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the coke that was removed
	 */
	public Coke removeByUUID_G(String uuid, long groupId)
		throws NoSuchCokeException;

	/**
	 * Returns the number of cokes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cokes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the cokes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cokes
	 */
	public java.util.List<Coke> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Coke> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Coke> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator);

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
	public java.util.List<Coke> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first coke in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public Coke findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Coke>
				orderByComparator)
		throws NoSuchCokeException;

	/**
	 * Returns the first coke in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public Coke fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator);

	/**
	 * Returns the last coke in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coke
	 * @throws NoSuchCokeException if a matching coke could not be found
	 */
	public Coke findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Coke>
				orderByComparator)
		throws NoSuchCokeException;

	/**
	 * Returns the last coke in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public Coke fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator);

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
	public Coke[] findByUuid_C_PrevAndNext(
			long cokeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Coke>
				orderByComparator)
		throws NoSuchCokeException;

	/**
	 * Removes all the cokes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of cokes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cokes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the coke in the entity cache if it is enabled.
	 *
	 * @param coke the coke
	 */
	public void cacheResult(Coke coke);

	/**
	 * Caches the cokes in the entity cache if it is enabled.
	 *
	 * @param cokes the cokes
	 */
	public void cacheResult(java.util.List<Coke> cokes);

	/**
	 * Creates a new coke with the primary key. Does not add the coke to the database.
	 *
	 * @param cokeId the primary key for the new coke
	 * @return the new coke
	 */
	public Coke create(long cokeId);

	/**
	 * Removes the coke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cokeId the primary key of the coke
	 * @return the coke that was removed
	 * @throws NoSuchCokeException if a coke with the primary key could not be found
	 */
	public Coke remove(long cokeId) throws NoSuchCokeException;

	public Coke updateImpl(Coke coke);

	/**
	 * Returns the coke with the primary key or throws a <code>NoSuchCokeException</code> if it could not be found.
	 *
	 * @param cokeId the primary key of the coke
	 * @return the coke
	 * @throws NoSuchCokeException if a coke with the primary key could not be found
	 */
	public Coke findByPrimaryKey(long cokeId) throws NoSuchCokeException;

	/**
	 * Returns the coke with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cokeId the primary key of the coke
	 * @return the coke, or <code>null</code> if a coke with the primary key could not be found
	 */
	public Coke fetchByPrimaryKey(long cokeId);

	/**
	 * Returns all the cokes.
	 *
	 * @return the cokes
	 */
	public java.util.List<Coke> findAll();

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
	public java.util.List<Coke> findAll(int start, int end);

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
	public java.util.List<Coke> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator);

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
	public java.util.List<Coke> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coke>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cokes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cokes.
	 *
	 * @return the number of cokes
	 */
	public int countAll();

}