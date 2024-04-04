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
 * Provides a wrapper for {@link UserCokeLocalService}.
 *
 * @author victor
 * @see UserCokeLocalService
 * @generated
 */
public class UserCokeLocalServiceWrapper
	implements ServiceWrapper<UserCokeLocalService>, UserCokeLocalService {

	public UserCokeLocalServiceWrapper() {
		this(null);
	}

	public UserCokeLocalServiceWrapper(
		UserCokeLocalService userCokeLocalService) {

		_userCokeLocalService = userCokeLocalService;
	}

	/**
	 * Adds the user coke to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserCokeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userCoke the user coke
	 * @return the user coke that was added
	 */
	@Override
	public br.com.victor.coke.model.UserCoke addUserCoke(
		br.com.victor.coke.model.UserCoke userCoke) {

		return _userCokeLocalService.addUserCoke(userCoke);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userCokeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user coke with the primary key. Does not add the user coke to the database.
	 *
	 * @param userCokeId the primary key for the new user coke
	 * @return the new user coke
	 */
	@Override
	public br.com.victor.coke.model.UserCoke createUserCoke(long userCokeId) {
		return _userCokeLocalService.createUserCoke(userCokeId);
	}

	@Override
	public br.com.victor.coke.model.UserCoke createUserCoke(
		long cokeId, long userId, String position) {

		return _userCokeLocalService.createUserCoke(cokeId, userId, position);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userCokeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user coke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserCokeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke that was removed
	 * @throws PortalException if a user coke with the primary key could not be found
	 */
	@Override
	public br.com.victor.coke.model.UserCoke deleteUserCoke(long userCokeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userCokeLocalService.deleteUserCoke(userCokeId);
	}

	/**
	 * Deletes the user coke from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserCokeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userCoke the user coke
	 * @return the user coke that was removed
	 */
	@Override
	public br.com.victor.coke.model.UserCoke deleteUserCoke(
		br.com.victor.coke.model.UserCoke userCoke) {

		return _userCokeLocalService.deleteUserCoke(userCoke);
	}

	@Override
	public br.com.victor.coke.model.UserCoke deleteUserCokeByUserCokeId(
		long userCokeId) {

		return _userCokeLocalService.deleteUserCokeByUserCokeId(userCokeId);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userCokeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userCokeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userCokeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userCokeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.victor.coke.model.impl.UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userCokeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.victor.coke.model.impl.UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userCokeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userCokeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _userCokeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public br.com.victor.coke.model.UserCoke fetchUserCoke(long userCokeId) {
		return _userCokeLocalService.fetchUserCoke(userCokeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userCokeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userCokeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userCokeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userCokeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user coke with the primary key.
	 *
	 * @param userCokeId the primary key of the user coke
	 * @return the user coke
	 * @throws PortalException if a user coke with the primary key could not be found
	 */
	@Override
	public br.com.victor.coke.model.UserCoke getUserCoke(long userCokeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userCokeLocalService.getUserCoke(userCokeId);
	}

	@Override
	public java.util.List<br.com.victor.coke.model.UserCoke>
		getUserCokeByCokeId(long cokeId) {

		return _userCokeLocalService.getUserCokeByCokeId(cokeId);
	}

	@Override
	public br.com.victor.coke.model.UserCoke getUserCokeByCokeIdAndUserId(
		long cokeId, long userId) {

		return _userCokeLocalService.getUserCokeByCokeIdAndUserId(
			cokeId, userId);
	}

	/**
	 * Returns a range of all the user cokes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.victor.coke.model.impl.UserCokeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user cokes
	 * @param end the upper bound of the range of user cokes (not inclusive)
	 * @return the range of user cokes
	 */
	@Override
	public java.util.List<br.com.victor.coke.model.UserCoke> getUserCokes(
		int start, int end) {

		return _userCokeLocalService.getUserCokes(start, end);
	}

	/**
	 * Returns the number of user cokes.
	 *
	 * @return the number of user cokes
	 */
	@Override
	public int getUserCokesCount() {
		return _userCokeLocalService.getUserCokesCount();
	}

	/**
	 * Updates the user coke in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserCokeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userCoke the user coke
	 * @return the user coke that was updated
	 */
	@Override
	public br.com.victor.coke.model.UserCoke updateUserCoke(
		br.com.victor.coke.model.UserCoke userCoke) {

		return _userCokeLocalService.updateUserCoke(userCoke);
	}

	@Override
	public UserCokeLocalService getWrappedService() {
		return _userCokeLocalService;
	}

	@Override
	public void setWrappedService(UserCokeLocalService userCokeLocalService) {
		_userCokeLocalService = userCokeLocalService;
	}

	private UserCokeLocalService _userCokeLocalService;

}