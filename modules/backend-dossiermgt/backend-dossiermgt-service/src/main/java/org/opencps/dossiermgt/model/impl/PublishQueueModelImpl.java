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

package org.opencps.dossiermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.dossiermgt.model.PublishQueue;
import org.opencps.dossiermgt.model.PublishQueueModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PublishQueue service. Represents a row in the &quot;opencps_publish_queue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PublishQueueModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PublishQueueImpl}.
 * </p>
 *
 * @author huymq
 * @see PublishQueueImpl
 * @see PublishQueue
 * @see PublishQueueModel
 * @generated
 */
@ProviderType
public class PublishQueueModelImpl extends BaseModelImpl<PublishQueue>
	implements PublishQueueModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a publish queue model instance should use the {@link PublishQueue} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_publish_queue";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "publishQueueId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "dossierId", Types.BIGINT },
			{ "serverNo", Types.VARCHAR },
			{ "status", Types.INTEGER },
			{ "retry", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("publishQueueId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dossierId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("serverNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("retry", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_publish_queue (uuid_ VARCHAR(75) null,publishQueueId LONG not null primary key,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,dossierId LONG,serverNo VARCHAR(255) null,status INTEGER,retry INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table opencps_publish_queue";
	public static final String ORDER_BY_JPQL = " ORDER BY publishQueue.modifiedDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_publish_queue.modifiedDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.PublishQueue"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.PublishQueue"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.PublishQueue"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long STATUS_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.PublishQueue"));

	public PublishQueueModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _publishQueueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublishQueueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishQueueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PublishQueue.class;
	}

	@Override
	public String getModelClassName() {
		return PublishQueue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("publishQueueId", getPublishQueueId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("serverNo", getServerNo());
		attributes.put("status", getStatus());
		attributes.put("retry", getRetry());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long publishQueueId = (Long)attributes.get("publishQueueId");

		if (publishQueueId != null) {
			setPublishQueueId(publishQueueId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		String serverNo = (String)attributes.get("serverNo");

		if (serverNo != null) {
			setServerNo(serverNo);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer retry = (Integer)attributes.get("retry");

		if (retry != null) {
			setRetry(retry);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getPublishQueueId() {
		return _publishQueueId;
	}

	@Override
	public void setPublishQueueId(long publishQueueId) {
		_publishQueueId = publishQueueId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_dossierId = dossierId;
	}

	@Override
	public String getServerNo() {
		if (_serverNo == null) {
			return "";
		}
		else {
			return _serverNo;
		}
	}

	@Override
	public void setServerNo(String serverNo) {
		_serverNo = serverNo;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public int getRetry() {
		return _retry;
	}

	@Override
	public void setRetry(int retry) {
		_retry = retry;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			PublishQueue.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PublishQueue toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PublishQueue)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PublishQueueImpl publishQueueImpl = new PublishQueueImpl();

		publishQueueImpl.setUuid(getUuid());
		publishQueueImpl.setPublishQueueId(getPublishQueueId());
		publishQueueImpl.setGroupId(getGroupId());
		publishQueueImpl.setUserId(getUserId());
		publishQueueImpl.setCreateDate(getCreateDate());
		publishQueueImpl.setModifiedDate(getModifiedDate());
		publishQueueImpl.setDossierId(getDossierId());
		publishQueueImpl.setServerNo(getServerNo());
		publishQueueImpl.setStatus(getStatus());
		publishQueueImpl.setRetry(getRetry());

		publishQueueImpl.resetOriginalValues();

		return publishQueueImpl;
	}

	@Override
	public int compareTo(PublishQueue publishQueue) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				publishQueue.getModifiedDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishQueue)) {
			return false;
		}

		PublishQueue publishQueue = (PublishQueue)obj;

		long primaryKey = publishQueue.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PublishQueueModelImpl publishQueueModelImpl = this;

		publishQueueModelImpl._originalUuid = publishQueueModelImpl._uuid;

		publishQueueModelImpl._originalGroupId = publishQueueModelImpl._groupId;

		publishQueueModelImpl._setOriginalGroupId = false;

		publishQueueModelImpl._setModifiedDate = false;

		publishQueueModelImpl._originalStatus = publishQueueModelImpl._status;

		publishQueueModelImpl._setOriginalStatus = false;

		publishQueueModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PublishQueue> toCacheModel() {
		PublishQueueCacheModel publishQueueCacheModel = new PublishQueueCacheModel();

		publishQueueCacheModel.uuid = getUuid();

		String uuid = publishQueueCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			publishQueueCacheModel.uuid = null;
		}

		publishQueueCacheModel.publishQueueId = getPublishQueueId();

		publishQueueCacheModel.groupId = getGroupId();

		publishQueueCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			publishQueueCacheModel.createDate = createDate.getTime();
		}
		else {
			publishQueueCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			publishQueueCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			publishQueueCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		publishQueueCacheModel.dossierId = getDossierId();

		publishQueueCacheModel.serverNo = getServerNo();

		String serverNo = publishQueueCacheModel.serverNo;

		if ((serverNo != null) && (serverNo.length() == 0)) {
			publishQueueCacheModel.serverNo = null;
		}

		publishQueueCacheModel.status = getStatus();

		publishQueueCacheModel.retry = getRetry();

		return publishQueueCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", publishQueueId=");
		sb.append(getPublishQueueId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append(", serverNo=");
		sb.append(getServerNo());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", retry=");
		sb.append(getRetry());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.PublishQueue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishQueueId</column-name><column-value><![CDATA[");
		sb.append(getPublishQueueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverNo</column-name><column-value><![CDATA[");
		sb.append(getServerNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>retry</column-name><column-value><![CDATA[");
		sb.append(getRetry());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = PublishQueue.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			PublishQueue.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _publishQueueId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _dossierId;
	private String _serverNo;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private int _retry;
	private long _columnBitmask;
	private PublishQueue _escapedModel;
}