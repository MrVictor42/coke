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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Coke. This utility wraps
 * <code>br.com.victor.coke.service.impl.CokeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author victor
 * @see CokeLocalService
 * @generated
 */
public class CokeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>br.com.victor.coke.service.impl.CokeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Coke addCoke(Coke coke) {
		return getService().addCoke(coke);
	}

	/**
	 * Creates a new coke with the primary key. Does not add the coke to the database.
	 *
	 * @param cokeId the primary key for the new coke
	 * @return the new coke
	 */
	public static Coke createCoke(long cokeId) {
		return getService().createCoke(cokeId);
	}

	public static Coke createCoke(
		String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().createCoke(name, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Coke deleteCoke(Coke coke) {
		return getService().deleteCoke(coke);
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
	public static Coke deleteCoke(long cokeId) throws PortalException {
		return getService().deleteCoke(cokeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Coke fetchCoke(long cokeId) {
		return getService().fetchCoke(cokeId);
	}

	/**
	 * Returns the coke matching the UUID and group.
	 *
	 * @param uuid the coke's UUID
	 * @param groupId the primary key of the group
	 * @return the matching coke, or <code>null</code> if a matching coke could not be found
	 */
	public static Coke fetchCokeByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchCokeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Coke> getAllCokes() {
		return getService().getAllCokes();
	}

	/**
	 * Returns the coke with the primary key.
	 *
	 * @param cokeId the primary key of the coke
	 * @return the coke
	 * @throws PortalException if a coke with the primary key could not be found
	 */
	public static Coke getCoke(long cokeId) throws PortalException {
		return getService().getCoke(cokeId);
	}

	/**
	 * Returns the coke matching the UUID and group.
	 *
	 * @param uuid the coke's UUID
	 * @param groupId the primary key of the group
	 * @return the matching coke
	 * @throws PortalException if a matching coke could not be found
	 */
	public static Coke getCokeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getCokeByUuidAndGroupId(uuid, groupId);
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
	public static List<Coke> getCokes(int start, int end) {
		return getService().getCokes(start, end);
	}

	/**
	 * Returns all the cokes matching the UUID and company.
	 *
	 * @param uuid the UUID of the cokes
	 * @param companyId the primary key of the company
	 * @return the matching cokes, or an empty list if no matches were found
	 */
	public static List<Coke> getCokesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCokesByUuidAndCompanyId(uuid, companyId);
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
	public static List<Coke> getCokesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Coke> orderByComparator) {

		return getService().getCokesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of cokes.
	 *
	 * @return the number of cokes
	 */
	public static int getCokesCount() {
		return getService().getCokesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static Coke updateCoke(Coke coke) {
		return getService().updateCoke(coke);
	}

	public static CokeLocalService getService() {
		return _service;
	}

	private static volatile CokeLocalService _service;

}