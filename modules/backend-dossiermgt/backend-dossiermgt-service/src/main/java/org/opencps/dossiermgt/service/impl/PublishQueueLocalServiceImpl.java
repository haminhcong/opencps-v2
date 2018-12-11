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

package org.opencps.dossiermgt.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.opencps.dossiermgt.model.PublishQueue;
import org.opencps.dossiermgt.service.base.PublishQueueLocalServiceBaseImpl;

/**
 * The implementation of the publish queue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.opencps.dossiermgt.service.PublishQueueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author huymq
 * @see PublishQueueLocalServiceBaseImpl
 * @see org.opencps.dossiermgt.service.PublishQueueLocalServiceUtil
 */
public class PublishQueueLocalServiceImpl
	extends PublishQueueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link org.opencps.dossiermgt.service.PublishQueueLocalServiceUtil} to access the publish queue local service.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PublishQueue updatePublishQueue(long groupId, long publishQueueId, 
			long dossierId, String serverNo, int status, int retry,
			ServiceContext context) throws PortalException {

		Date now = new Date();

		User userAction = userLocalService.getUser(context.getUserId());

		PublishQueue object = null;

		if (publishQueueId == 0) {

			publishQueueId = counterLocalService.increment(PublishQueue.class.getName());

			object = publishQueuePersistence.create(publishQueueId);

			// Add audit fields
			object.setGroupId(groupId);
			object.setCreateDate(now);
			object.setModifiedDate(now);
			object.setUserId(userAction.getUserId());

			// Add other fields

			object.setDossierId(dossierId);
			object.setServerNo(serverNo);
			object.setStatus(status);
			object.setRetry(retry);
		} else {
		object = publishQueuePersistence.findByPrimaryKey(publishQueueId);

			// Add audit fields
			object.setModifiedDate(now);
			object.setUserId(userAction.getUserId());

			// Add other fields
			object.setDossierId(dossierId);
			object.setServerNo(serverNo);
			object.setStatus(status);
			object.setRetry(retry);
		}

		return publishQueuePersistence.update(object);
	}

	@Indexable(type = IndexableType.DELETE)
	public PublishQueue removePublishQueue(long publishQueueId) throws PortalException {
		PublishQueue publishQueue = publishQueuePersistence.fetchByPrimaryKey(publishQueueId);

		return publishQueuePersistence.remove(publishQueue);
	}	
}