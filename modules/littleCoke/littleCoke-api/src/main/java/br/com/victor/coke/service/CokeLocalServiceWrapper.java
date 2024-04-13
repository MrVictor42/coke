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
 * Provides a wrapper for {@link CokeLocalService}.
 *
 * @author victor
 * @see CokeLocalService
 * @generated
 */
public class CokeLocalServiceWrapper
	implements CokeLocalService, ServiceWrapper<CokeLocalService> {

	public CokeLocalServiceWrapper() {
		this(null);
	}

	public CokeLocalServiceWrapper(CokeLocalService cokeLocalService) {
		_cokeLocalService = cokeLocalService;
	}

	/**
	 * Adds the coke to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CokeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coke the coke
	 * @return the coke that was added
	 */
	@Override
	public br.com.victor.coke.model.Coke addCoke(
		br.com.victor.coke.model.Coke coke) {

		return _cokeLocalService.addCoke(coke);
	}

	/**
	 * Creates a new coke with the primary key. Does not add the coke to the database.
	 *
	 * @param cokeId the primary key for the new coke
	 * @return the new coke
	 */
	@Override
	public br.com.victor.coke.model.Coke createCoke(long cokeId) {
		return _cokeLocalService.createCoke(cokeId);
	}

	@Override
	public br.com.victor.coke.model.Coke createCoke(
		String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _cokeLocalService.createCoke(name, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cokeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the coke from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CokeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coke the coke
	 * @return the coke that was removed
	 */
	@Override
	public br.com.victor.coke.model.Coke deleteCoke(
		br.com.victor.coke.model.Coke coke) {

		return _cokeLocalService.deleteCoke(coke);
	}

	/**
	 * Deletes the coke with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CokeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cokeId the primary key of the coke
	 * @return the coke that was removed
	 * @throws PortalException if a coke with the primary key could not be found
	 */
	@Override
	public br.com.victor.coke.model.Coke deleteCoke(long cokeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cokeLocalService.deleteCoke(cokeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cokeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _cokeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _cokeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cokeLocalService.dynamicQuery();
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

		return _cokeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.victor.coke.model.impl.CokeModelImpl</code>.
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

		return _cokeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.victor.coke.model.impl.CokeModelImpl</code>.
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

		return _cokeLocalService.dynamicQuery(
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

		return _cokeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cokeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public br.com.victor.coke.model.Coke fetchCoke(long cokeId) {
		return _cokeLocalService.fetchCoke(cokeId);
	}

	/**
	 * Returns the coke matching the UUID and group.
	 *
	 * @param uuid the coke's UUID
	 * @param groupId the primary key of the group
	 * @return the matching coke, or <code>null</code> if a matching coke could not be found
	 */
	@Override
	public br.com.victor.coke.model.Coke fetchCokeByUuidAndGroupId(
		String uuid, long groupId) {

		return _cokeLocalService.fetchCokeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cokeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<br.com.victor.coke.model.Coke> getAllCokes() {
		return _cokeLocalService.getAllCokes();
	}

	/**
	 * Returns the coke with the primary key.
	 *
	 * @param cokeId the primary key of the coke
	 * @return the coke
	 * @throws PortalException if a coke with the primary key could not be found
	 */
	@Override
	public br.com.victor.coke.model.Coke getCoke(long cokeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cokeLocalService.getCoke(cokeId);
	}

	/**
	 * Returns the coke matching the UUID and group.
	 *
	 * @param uuid the coke's UUID
	 * @param groupId the primary key of the group
	 * @return the matching coke
	 * @throws PortalException if a matching coke could not be found
	 */
	@Override
	public br.com.victor.coke.model.Coke getCokeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cokeLocalService.getCokeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the cokes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>br.com.victor.coke.model.impl.CokeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @return the range of cokes
	 */
	@Override
	public java.util.List<br.com.victor.coke.model.Coke> getCokes(
		int start, int end) {

		return _cokeLocalService.getCokes(start, end);
	}

	/**
	 * Returns all the cokes matching the UUID and company.
	 *
	 * @param uuid the UUID of the cokes
	 * @param companyId the primary key of the company
	 * @return the matching cokes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<br.com.victor.coke.model.Coke>
		getCokesByUuidAndCompanyId(String uuid, long companyId) {

		return _cokeLocalService.getCokesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of cokes matching the UUID and company.
	 *
	 * @param uuid the UUID of the cokes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of cokes
	 * @param end the upper bound of the range of cokes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching cokes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<br.com.victor.coke.model.Coke>
		getCokesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<br.com.victor.coke.model.Coke> orderByComparator) {

		return _cokeLocalService.getCokesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cokes.
	 *
	 * @return the number of cokes
	 */
	@Override
	public int getCokesCount() {
		return _cokeLocalService.getCokesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _cokeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cokeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cokeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cokeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the coke in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CokeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coke the coke
	 * @return the coke that was updated
	 */
	@Override
	public br.com.victor.coke.model.Coke updateCoke(
		br.com.victor.coke.model.Coke coke) {

		return _cokeLocalService.updateCoke(coke);
	}

	@Override
	public br.com.victor.coke.model.Coke updateCoke(long cokeId, String name)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cokeLocalService.updateCoke(cokeId, name);
	}

	@Override
	public CokeLocalService getWrappedService() {
		return _cokeLocalService;
	}

	@Override
	public void setWrappedService(CokeLocalService cokeLocalService) {
		_cokeLocalService = cokeLocalService;
	}

	private CokeLocalService _cokeLocalService;

}