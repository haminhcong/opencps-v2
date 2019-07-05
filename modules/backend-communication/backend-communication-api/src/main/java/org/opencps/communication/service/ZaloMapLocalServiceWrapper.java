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

package org.opencps.communication.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ZaloMapLocalService}.
 *
 * @author khoavd
 * @see ZaloMapLocalService
 * @generated
 */
@ProviderType
public class ZaloMapLocalServiceWrapper implements ZaloMapLocalService,
	ServiceWrapper<ZaloMapLocalService> {
	public ZaloMapLocalServiceWrapper(ZaloMapLocalService zaloMapLocalService) {
		_zaloMapLocalService = zaloMapLocalService;
	}

	/**
	* Adds the zalo map to the database. Also notifies the appropriate model listeners.
	*
	* @param zaloMap the zalo map
	* @return the zalo map that was added
	*/
	@Override
	public org.opencps.communication.model.ZaloMap addZaloMap(
		org.opencps.communication.model.ZaloMap zaloMap) {
		return _zaloMapLocalService.addZaloMap(zaloMap);
	}

	@Override
	public org.opencps.communication.model.ZaloMap adminProcessData(
		com.liferay.portal.kernel.json.JSONObject objectData) {
		return _zaloMapLocalService.adminProcessData(objectData);
	}

	@Override
	public org.opencps.communication.model.ZaloMap adminProcessDelete(Long id) {
		return _zaloMapLocalService.adminProcessDelete(id);
	}

	/**
	* Creates a new zalo map with the primary key. Does not add the zalo map to the database.
	*
	* @param zaloMapId the primary key for the new zalo map
	* @return the new zalo map
	*/
	@Override
	public org.opencps.communication.model.ZaloMap createZaloMap(long zaloMapId) {
		return _zaloMapLocalService.createZaloMap(zaloMapId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _zaloMapLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the zalo map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zaloMapId the primary key of the zalo map
	* @return the zalo map that was removed
	* @throws PortalException if a zalo map with the primary key could not be found
	*/
	@Override
	public org.opencps.communication.model.ZaloMap deleteZaloMap(long zaloMapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _zaloMapLocalService.deleteZaloMap(zaloMapId);
	}

	/**
	* Deletes the zalo map from the database. Also notifies the appropriate model listeners.
	*
	* @param zaloMap the zalo map
	* @return the zalo map that was removed
	*/
	@Override
	public org.opencps.communication.model.ZaloMap deleteZaloMap(
		org.opencps.communication.model.ZaloMap zaloMap) {
		return _zaloMapLocalService.deleteZaloMap(zaloMap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _zaloMapLocalService.dynamicQuery();
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
		return _zaloMapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.ZaloMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _zaloMapLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.ZaloMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _zaloMapLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _zaloMapLocalService.dynamicQueryCount(dynamicQuery);
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
		return _zaloMapLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.opencps.communication.model.ZaloMap fetchZaloMap(long zaloMapId) {
		return _zaloMapLocalService.fetchZaloMap(zaloMapId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _zaloMapLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<org.opencps.communication.model.ZaloMap> getByGroupId(
		long groupId) {
		return _zaloMapLocalService.getByGroupId(groupId);
	}

	@Override
	public java.util.List<org.opencps.communication.model.ZaloMap> getByOAId(
		String oAId) {
		return _zaloMapLocalService.getByOAId(oAId);
	}

	@Override
	public org.opencps.communication.model.ZaloMap getByTelNo(String telNo) {
		return _zaloMapLocalService.getByTelNo(telNo);
	}

	@Override
	public org.opencps.communication.model.ZaloMap getByUId(String uId) {
		return _zaloMapLocalService.getByUId(uId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _zaloMapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _zaloMapLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _zaloMapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the zalo map with the primary key.
	*
	* @param zaloMapId the primary key of the zalo map
	* @return the zalo map
	* @throws PortalException if a zalo map with the primary key could not be found
	*/
	@Override
	public org.opencps.communication.model.ZaloMap getZaloMap(long zaloMapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _zaloMapLocalService.getZaloMap(zaloMapId);
	}

	/**
	* Returns a range of all the zalo maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.communication.model.impl.ZaloMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zalo maps
	* @param end the upper bound of the range of zalo maps (not inclusive)
	* @return the range of zalo maps
	*/
	@Override
	public java.util.List<org.opencps.communication.model.ZaloMap> getZaloMaps(
		int start, int end) {
		return _zaloMapLocalService.getZaloMaps(start, end);
	}

	/**
	* Returns the number of zalo maps.
	*
	* @return the number of zalo maps
	*/
	@Override
	public int getZaloMapsCount() {
		return _zaloMapLocalService.getZaloMapsCount();
	}

	@Override
	public org.opencps.communication.model.ZaloMap removeByPrimaryKey(
		long zaloMapId) {
		return _zaloMapLocalService.removeByPrimaryKey(zaloMapId);
	}

	@Override
	public org.opencps.communication.model.ZaloMap updateZaloMap(
		long zaloMapId, long groupId, String uId, String telNo, String oAId,
		int isFollow, String payload)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _zaloMapLocalService.updateZaloMap(zaloMapId, groupId, uId,
			telNo, oAId, isFollow, payload);
	}

	/**
	* Updates the zalo map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param zaloMap the zalo map
	* @return the zalo map that was updated
	*/
	@Override
	public org.opencps.communication.model.ZaloMap updateZaloMap(
		org.opencps.communication.model.ZaloMap zaloMap) {
		return _zaloMapLocalService.updateZaloMap(zaloMap);
	}

	@Override
	public ZaloMapLocalService getWrappedService() {
		return _zaloMapLocalService;
	}

	@Override
	public void setWrappedService(ZaloMapLocalService zaloMapLocalService) {
		_zaloMapLocalService = zaloMapLocalService;
	}

	private ZaloMapLocalService _zaloMapLocalService;
}