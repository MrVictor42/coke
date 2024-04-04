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

package br.com.victor.coke.service.persistence.impl;

import br.com.victor.coke.exception.NoSuchUserCokeException;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.model.UserCokeTable;
import br.com.victor.coke.model.impl.UserCokeImpl;
import br.com.victor.coke.model.impl.UserCokeModelImpl;
import br.com.victor.coke.service.persistence.UserCokePersistence;
import br.com.victor.coke.service.persistence.UserCokeUtil;
import br.com.victor.coke.service.persistence.impl.constants.CokePersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user coke service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author victor
 * @generated
 */
@Component(service = {UserCokePersistence.class, BasePersistence.class})
public class UserCokePersistenceImpl
	extends BasePersistenceImpl<UserCoke> implements UserCokePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserCokeUtil</code> to access the user coke persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserCokeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the user cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user cokes
	 */
	@Override
	public List<UserCoke> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserCoke> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<UserCoke> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserCoke> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<UserCoke> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserCoke> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<UserCoke> list = null;

		if (useFinderCache) {
			list = (List<UserCoke>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserCoke userCoke : list) {
					if (!uuid.equals(userCoke.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERCOKE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserCokeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<UserCoke>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	@Override
	public UserCoke findByUuid_First(
			String uuid, OrderByComparator<UserCoke> orderByComparator)
		throws NoSuchUserCokeException {

		UserCoke userCoke = fetchByUuid_First(uuid, orderByComparator);

		if (userCoke != null) {
			return userCoke;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserCokeException(sb.toString());
	}

	/**
	 * Returns the first user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	@Override
	public UserCoke fetchByUuid_First(
		String uuid, OrderByComparator<UserCoke> orderByComparator) {

		List<UserCoke> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	@Override
	public UserCoke findByUuid_Last(
			String uuid, OrderByComparator<UserCoke> orderByComparator)
		throws NoSuchUserCokeException {

		UserCoke userCoke = fetchByUuid_Last(uuid, orderByComparator);

		if (userCoke != null) {
			return userCoke;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserCokeException(sb.toString());
	}

	/**
	 * Returns the last user coke in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	@Override
	public UserCoke fetchByUuid_Last(
		String uuid, OrderByComparator<UserCoke> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserCoke> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserCoke[] findByUuid_PrevAndNext(
			long userCokeId, String uuid,
			OrderByComparator<UserCoke> orderByComparator)
		throws NoSuchUserCokeException {

		uuid = Objects.toString(uuid, "");

		UserCoke userCoke = findByPrimaryKey(userCokeId);

		Session session = null;

		try {
			session = openSession();

			UserCoke[] array = new UserCokeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userCoke, uuid, orderByComparator, true);

			array[1] = userCoke;

			array[2] = getByUuid_PrevAndNext(
				session, userCoke, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserCoke getByUuid_PrevAndNext(
		Session session, UserCoke userCoke, String uuid,
		OrderByComparator<UserCoke> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERCOKE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserCokeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userCoke)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserCoke> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user cokes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserCoke userCoke :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userCoke);
		}
	}

	/**
	 * Returns the number of user cokes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user cokes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERCOKE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"userCoke.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userCoke.uuid IS NULL OR userCoke.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBycokeId;
	private FinderPath _finderPathWithoutPaginationFindBycokeId;
	private FinderPath _finderPathCountBycokeId;

	/**
	 * Returns all the user cokes where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @return the matching user cokes
	 */
	@Override
	public List<UserCoke> findBycokeId(long cokeId) {
		return findBycokeId(cokeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserCoke> findBycokeId(long cokeId, int start, int end) {
		return findBycokeId(cokeId, start, end, null);
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
	@Override
	public List<UserCoke> findBycokeId(
		long cokeId, int start, int end,
		OrderByComparator<UserCoke> orderByComparator) {

		return findBycokeId(cokeId, start, end, orderByComparator, true);
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
	@Override
	public List<UserCoke> findBycokeId(
		long cokeId, int start, int end,
		OrderByComparator<UserCoke> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycokeId;
				finderArgs = new Object[] {cokeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycokeId;
			finderArgs = new Object[] {cokeId, start, end, orderByComparator};
		}

		List<UserCoke> list = null;

		if (useFinderCache) {
			list = (List<UserCoke>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserCoke userCoke : list) {
					if (cokeId != userCoke.getCokeId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERCOKE_WHERE);

			sb.append(_FINDER_COLUMN_COKEID_COKEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserCokeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cokeId);

				list = (List<UserCoke>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	@Override
	public UserCoke findBycokeId_First(
			long cokeId, OrderByComparator<UserCoke> orderByComparator)
		throws NoSuchUserCokeException {

		UserCoke userCoke = fetchBycokeId_First(cokeId, orderByComparator);

		if (userCoke != null) {
			return userCoke;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cokeId=");
		sb.append(cokeId);

		sb.append("}");

		throw new NoSuchUserCokeException(sb.toString());
	}

	/**
	 * Returns the first user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	@Override
	public UserCoke fetchBycokeId_First(
		long cokeId, OrderByComparator<UserCoke> orderByComparator) {

		List<UserCoke> list = findBycokeId(cokeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	@Override
	public UserCoke findBycokeId_Last(
			long cokeId, OrderByComparator<UserCoke> orderByComparator)
		throws NoSuchUserCokeException {

		UserCoke userCoke = fetchBycokeId_Last(cokeId, orderByComparator);

		if (userCoke != null) {
			return userCoke;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cokeId=");
		sb.append(cokeId);

		sb.append("}");

		throw new NoSuchUserCokeException(sb.toString());
	}

	/**
	 * Returns the last user coke in the ordered set where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	@Override
	public UserCoke fetchBycokeId_Last(
		long cokeId, OrderByComparator<UserCoke> orderByComparator) {

		int count = countBycokeId(cokeId);

		if (count == 0) {
			return null;
		}

		List<UserCoke> list = findBycokeId(
			cokeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserCoke[] findBycokeId_PrevAndNext(
			long userCokeId, long cokeId,
			OrderByComparator<UserCoke> orderByComparator)
		throws NoSuchUserCokeException {

		UserCoke userCoke = findByPrimaryKey(userCokeId);

		Session session = null;

		try {
			session = openSession();

			UserCoke[] array = new UserCokeImpl[3];

			array[0] = getBycokeId_PrevAndNext(
				session, userCoke, cokeId, orderByComparator, true);

			array[1] = userCoke;

			array[2] = getBycokeId_PrevAndNext(
				session, userCoke, cokeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserCoke getBycokeId_PrevAndNext(
		Session session, UserCoke userCoke, long cokeId,
		OrderByComparator<UserCoke> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERCOKE_WHERE);

		sb.append(_FINDER_COLUMN_COKEID_COKEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserCokeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(cokeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userCoke)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserCoke> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user cokes where cokeId = &#63; from the database.
	 *
	 * @param cokeId the coke ID
	 */
	@Override
	public void removeBycokeId(long cokeId) {
		for (UserCoke userCoke :
				findBycokeId(
					cokeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userCoke);
		}
	}

	/**
	 * Returns the number of user cokes where cokeId = &#63;.
	 *
	 * @param cokeId the coke ID
	 * @return the number of matching user cokes
	 */
	@Override
	public int countBycokeId(long cokeId) {
		FinderPath finderPath = _finderPathCountBycokeId;

		Object[] finderArgs = new Object[] {cokeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERCOKE_WHERE);

			sb.append(_FINDER_COLUMN_COKEID_COKEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cokeId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COKEID_COKEID_2 =
		"userCoke.cokeId = ?";

	private FinderPath _finderPathFetchByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns the user coke where userId = &#63; or throws a <code>NoSuchUserCokeException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user coke
	 * @throws NoSuchUserCokeException if a matching user coke could not be found
	 */
	@Override
	public UserCoke findByuserId(long userId) throws NoSuchUserCokeException {
		UserCoke userCoke = fetchByuserId(userId);

		if (userCoke == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUserCokeException(sb.toString());
		}

		return userCoke;
	}

	/**
	 * Returns the user coke where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	@Override
	public UserCoke fetchByuserId(long userId) {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the user coke where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user coke, or <code>null</code> if a matching user coke could not be found
	 */
	@Override
	public UserCoke fetchByuserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByuserId, finderArgs);
		}

		if (result instanceof UserCoke) {
			UserCoke userCoke = (UserCoke)result;

			if (userId != userCoke.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_USERCOKE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<UserCoke> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByuserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"UserCokePersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserCoke userCoke = list.get(0);

					result = userCoke;

					cacheResult(userCoke);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserCoke)result;
		}
	}

	/**
	 * Removes the user coke where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user coke that was removed
	 */
	@Override
	public UserCoke removeByuserId(long userId) throws NoSuchUserCokeException {
		UserCoke userCoke = findByuserId(userId);

		return remove(userCoke);
	}

	/**
	 * Returns the number of user cokes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user cokes
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERCOKE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"userCoke.userId = ?";

	public UserCokePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UserCoke.class);

		setModelImplClass(UserCokeImpl.class);
		setModelPKClass(long.class);

		setTable(UserCokeTable.INSTANCE);
	}

	/**
	 * Caches the user coke in the entity cache if it is enabled.
	 *
	 * @param userCoke the user coke
	 */
	@Override
	public void cacheResult(UserCoke userCoke) {
		entityCache.putResult(
			UserCokeImpl.class, userCoke.getPrimaryKey(), userCoke);

		finderCache.putResult(
			_finderPathFetchByuserId, new Object[] {userCoke.getUserId()},
			userCoke);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user cokes in the entity cache if it is enabled.
	 *
	 * @param userCokes the user cokes
	 */
	@Override
	public void cacheResult(List<UserCoke> userCokes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userCokes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserCoke userCoke : userCokes) {
			if (entityCache.getResult(
					UserCokeImpl.class, userCoke.getPrimaryKey()) == null) {

				cacheResult(userCoke);
			}
		}
	}

	/**
	 * Clears the cache for all user cokes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserCokeImpl.class);

		finderCache.clearCache(UserCokeImpl.class);
	}

	/**
	 * Clears the cache for the user coke.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserCoke userCoke) {
		entityCache.removeResult(UserCokeImpl.class, userCoke);
	}

	@Override
	public void clearCache(List<UserCoke> userCokes) {
		for (UserCoke userCoke : userCokes) {
			entityCache.removeResult(UserCokeImpl.class, userCoke);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserCokeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserCokeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		UserCokeModelImpl userCokeModelImpl) {

		Object[] args = new Object[] {userCokeModelImpl.getUserId()};

		finderCache.putResult(_finderPathCountByuserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByuserId, args, userCokeModelImpl);
	}

	/**
	 * Creates a new user coke with the primary key. Does not add the user coke to the database.
	 *
	 * @param userCokeId the primary key for the new user coke
	 * @return the new user coke
	 */
	@Override
	public UserCoke create(long userCokeId) {
		UserCoke userCoke = new UserCokeImpl();

		userCoke.setNew(true);
		userCoke.setPrimaryKey(userCokeId);

		String uuid = PortalUUIDUtil.generate();

		userCoke.setUuid(uuid);

		return userCoke;
	}

	/**
	 * Removes the user coke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke that was removed
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	@Override
	public UserCoke remove(long userCokeId) throws NoSuchUserCokeException {
		return remove((Serializable)userCokeId);
	}

	/**
	 * Removes the user coke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user coke
	 * @return the user coke that was removed
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	@Override
	public UserCoke remove(Serializable primaryKey)
		throws NoSuchUserCokeException {

		Session session = null;

		try {
			session = openSession();

			UserCoke userCoke = (UserCoke)session.get(
				UserCokeImpl.class, primaryKey);

			if (userCoke == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserCokeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userCoke);
		}
		catch (NoSuchUserCokeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserCoke removeImpl(UserCoke userCoke) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userCoke)) {
				userCoke = (UserCoke)session.get(
					UserCokeImpl.class, userCoke.getPrimaryKeyObj());
			}

			if (userCoke != null) {
				session.delete(userCoke);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userCoke != null) {
			clearCache(userCoke);
		}

		return userCoke;
	}

	@Override
	public UserCoke updateImpl(UserCoke userCoke) {
		boolean isNew = userCoke.isNew();

		if (!(userCoke instanceof UserCokeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userCoke.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userCoke);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userCoke proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserCoke implementation " +
					userCoke.getClass());
		}

		UserCokeModelImpl userCokeModelImpl = (UserCokeModelImpl)userCoke;

		if (Validator.isNull(userCoke.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userCoke.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userCoke.getCreateDate() == null)) {
			if (serviceContext == null) {
				userCoke.setCreateDate(date);
			}
			else {
				userCoke.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!userCokeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userCoke.setModifiedDate(date);
			}
			else {
				userCoke.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userCoke);
			}
			else {
				userCoke = (UserCoke)session.merge(userCoke);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserCokeImpl.class, userCokeModelImpl, false, true);

		cacheUniqueFindersCache(userCokeModelImpl);

		if (isNew) {
			userCoke.setNew(false);
		}

		userCoke.resetOriginalValues();

		return userCoke;
	}

	/**
	 * Returns the user coke with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user coke
	 * @return the user coke
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	@Override
	public UserCoke findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserCokeException {

		UserCoke userCoke = fetchByPrimaryKey(primaryKey);

		if (userCoke == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserCokeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userCoke;
	}

	/**
	 * Returns the user coke with the primary key or throws a <code>NoSuchUserCokeException</code> if it could not be found.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke
	 * @throws NoSuchUserCokeException if a user coke with the primary key could not be found
	 */
	@Override
	public UserCoke findByPrimaryKey(long userCokeId)
		throws NoSuchUserCokeException {

		return findByPrimaryKey((Serializable)userCokeId);
	}

	/**
	 * Returns the user coke with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke, or <code>null</code> if a user coke with the primary key could not be found
	 */
	@Override
	public UserCoke fetchByPrimaryKey(long userCokeId) {
		return fetchByPrimaryKey((Serializable)userCokeId);
	}

	/**
	 * Returns all the user cokes.
	 *
	 * @return the user cokes
	 */
	@Override
	public List<UserCoke> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserCoke> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserCoke> findAll(
		int start, int end, OrderByComparator<UserCoke> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserCoke> findAll(
		int start, int end, OrderByComparator<UserCoke> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UserCoke> list = null;

		if (useFinderCache) {
			list = (List<UserCoke>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERCOKE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERCOKE;

				sql = sql.concat(UserCokeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserCoke>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user cokes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserCoke userCoke : findAll()) {
			remove(userCoke);
		}
	}

	/**
	 * Returns the number of user cokes.
	 *
	 * @return the number of user cokes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERCOKE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userCokeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERCOKE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserCokeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user coke persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindBycokeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycokeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"cokeId"}, true);

		_finderPathWithoutPaginationFindBycokeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycokeId",
			new String[] {Long.class.getName()}, new String[] {"cokeId"}, true);

		_finderPathCountBycokeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycokeId",
			new String[] {Long.class.getName()}, new String[] {"cokeId"},
			false);

		_finderPathFetchByuserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setUserCokeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserCokeUtilPersistence(null);

		entityCache.removeCache(UserCokeImpl.class.getName());
	}

	private void _setUserCokeUtilPersistence(
		UserCokePersistence userCokePersistence) {

		try {
			Field field = UserCokeUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, userCokePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = CokePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CokePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CokePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERCOKE =
		"SELECT userCoke FROM UserCoke userCoke";

	private static final String _SQL_SELECT_USERCOKE_WHERE =
		"SELECT userCoke FROM UserCoke userCoke WHERE ";

	private static final String _SQL_COUNT_USERCOKE =
		"SELECT COUNT(userCoke) FROM UserCoke userCoke";

	private static final String _SQL_COUNT_USERCOKE_WHERE =
		"SELECT COUNT(userCoke) FROM UserCoke userCoke WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userCoke.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserCoke exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserCoke exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserCokePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private UserCokeModelArgumentsResolver _userCokeModelArgumentsResolver;

}