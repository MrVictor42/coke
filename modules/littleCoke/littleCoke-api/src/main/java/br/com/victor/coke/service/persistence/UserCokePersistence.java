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

import br.com.victor.coke.exception.NoSuchUserCokeException;
import br.com.victor.coke.model.UserCoke;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user coke service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author victor
 * @see UserCokeUtil
 * @generated
 */
@ProviderType
public interface UserCokePersistence extends BasePersistence<UserCoke> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserCokeUtil} to access the user coke persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user cokes
	 */
	public java.util.List<UserCoke> findByUuid(String uuid);

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
	public java.util.List<UserCoke> findByUuid(String uuid, int start, int end);

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
	public java.util.List<UserCoke> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator);

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
	public java.util.List<UserCoke> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	public UserCoke findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
				orderByComparator)
		throws NoSuchUserCokeException;

	/**
	 * Returns the first user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public UserCoke fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator);

	/**
	 * Returns the last user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	public UserCoke findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
				orderByComparator)
		throws NoSuchUserCokeException;

	/**
	 * Returns the last user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public UserCoke fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator);

	/**
	 * Returns the user cokes before and after the current user coke in the ordered set where uuid = &#63;.
	 *
	 * @param userCokeId the primary key of the current user coke
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user coke
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	public UserCoke[] findByUuid_PrevAndNext(
			long userCokeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
				orderByComparator)
		throws NoSuchUserCokeException;

	/**
	 * Removes all the user cokes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user cokes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the user cokes where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @return the matching user cokes
	 */
	public java.util.List<UserCoke> findBycokeId(long cokeId);

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
	public java.util.List<UserCoke> findBycokeId(
		long cokeId, int start, int end);

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
	public java.util.List<UserCoke> findBycokeId(
		long cokeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator);

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
	public java.util.List<UserCoke> findBycokeId(
		long cokeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	public UserCoke findBycokeId_First(
			long cokeId,
			com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
				orderByComparator)
		throws NoSuchUserCokeException;

	/**
	 * Returns the first user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public UserCoke fetchBycokeId_First(
		long cokeId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator);

	/**
	 * Returns the last user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	public UserCoke findBycokeId_Last(
			long cokeId,
			com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
				orderByComparator)
		throws NoSuchUserCokeException;

	/**
	 * Returns the last user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public UserCoke fetchBycokeId_Last(
		long cokeId,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator);

	/**
	 * Returns the user cokes before and after the current user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param userCokeId the primary key of the current user coke
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user coke
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	public UserCoke[] findBycokeId_PrevAndNext(
			long userCokeId, long cokeId,
			com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
				orderByComparator)
		throws NoSuchUserCokeException;

	/**
	 * Removes all the user cokes where cokeId = &#63; from the database.
	 *
	 * @param cokeId the coke ID
	 */
	public void removeBycokeId(long cokeId);

	/**
	 * Returns the number of user cokes where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @return the number of matching user cokes
	 */
	public int countBycokeId(long cokeId);

	/**
	 * Returns the user coke where userId = &#63; or throws a <code>NoSuchUserCokeException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	public UserCoke findByuserId(long userId) throws NoSuchUserCokeException;

	/**
	 * Returns the user coke where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public UserCoke fetchByuserId(long userId);

	/**
	 * Returns the user coke where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	public UserCoke fetchByuserId(long userId, boolean useFinderCache);

	/**
	 * Removes the user coke where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user coke that was removed
	 */
	public UserCoke removeByuserId(long userId) throws NoSuchUserCokeException;

	/**
	 * Returns the number of user cokes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user cokes
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the user coke in the entity cache if it is enabled.
	 *
	 * @param userCoke the user coke
	 */
	public void cacheResult(UserCoke userCoke);

	/**
	 * Caches the user cokes in the entity cache if it is enabled.
	 *
	 * @param userCokes the user cokes
	 */
	public void cacheResult(java.util.List<UserCoke> userCokes);

	/**
	 * Creates a new user coke with the primary key. Does not add the user coke to the database.
	 *
	 * @param userCokeId the primary key for the new user coke
	 * @return the new user coke
	 */
	public UserCoke create(long userCokeId);

	/**
	 * Removes the user coke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke that was removed
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	public UserCoke remove(long userCokeId) throws NoSuchUserCokeException;

	public UserCoke updateImpl(UserCoke userCoke);

	/**
	 * Returns the user coke with the primary key or throws a <code>NoSuchUserCokeException</code> if it could not be found.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	public UserCoke findByPrimaryKey(long userCokeId)
		throws NoSuchUserCokeException;

	/**
	 * Returns the user coke with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke, or <code>null</code> if a user coke with the primary key could not be found
	 */
	public UserCoke fetchByPrimaryKey(long userCokeId);

	/**
	 * Returns all the user cokes.
	 *
	 * @return the user cokes
	 */
	public java.util.List<UserCoke> findAll();

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
	public java.util.List<UserCoke> findAll(int start, int end);

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
	public java.util.List<UserCoke> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator);

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
	public java.util.List<UserCoke> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCoke>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user cokes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user cokes.
	 *
	 * @return the number of user cokes
	 */
	public int countAll();

}