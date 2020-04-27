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

package org.opencps.usermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.usermgt.model.TrackClientStatistic;
import org.opencps.usermgt.model.TrackClientStatisticModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TrackClientStatistic service. Represents a row in the &quot;opencps_track_client_statistic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link TrackClientStatisticModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TrackClientStatisticImpl}.
 * </p>
 *
 * @author khoavu
 * @see TrackClientStatisticImpl
 * @see TrackClientStatistic
 * @see TrackClientStatisticModel
 * @generated
 */
@ProviderType
public class TrackClientStatisticModelImpl extends BaseModelImpl<TrackClientStatistic>
	implements TrackClientStatisticModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a track client statistic model instance should use the {@link TrackClientStatistic} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_track_client_statistic";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "trackClientStatisticId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "url", Types.VARCHAR },
			{ "year", Types.INTEGER },
			{ "month", Types.INTEGER },
			{ "day", Types.INTEGER },
			{ "region", Types.VARCHAR },
			{ "desktop", Types.BOOLEAN },
			{ "mobile", Types.BOOLEAN },
			{ "tablet", Types.BOOLEAN },
			{ "total", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("trackClientStatisticId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("url", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("year", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("month", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("day", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("region", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("desktop", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("mobile", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("tablet", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("total", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_track_client_statistic (uuid_ VARCHAR(75) null,trackClientStatisticId LONG not null primary key,createDate DATE null,modifiedDate DATE null,url VARCHAR(512) null,year INTEGER,month INTEGER,day INTEGER,region VARCHAR(512) null,desktop BOOLEAN,mobile BOOLEAN,tablet BOOLEAN,total LONG)";
	public static final String TABLE_SQL_DROP = "drop table opencps_track_client_statistic";
	public static final String ORDER_BY_JPQL = " ORDER BY trackClientStatistic.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_track_client_statistic.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.usermgt.model.TrackClientStatistic"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.usermgt.model.TrackClientStatistic"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.usermgt.model.TrackClientStatistic"),
			true);
	public static final long DAY_COLUMN_BITMASK = 1L;
	public static final long DESKTOP_COLUMN_BITMASK = 2L;
	public static final long MOBILE_COLUMN_BITMASK = 4L;
	public static final long MONTH_COLUMN_BITMASK = 8L;
	public static final long TABLET_COLUMN_BITMASK = 16L;
	public static final long URL_COLUMN_BITMASK = 32L;
	public static final long UUID_COLUMN_BITMASK = 64L;
	public static final long YEAR_COLUMN_BITMASK = 128L;
	public static final long CREATEDATE_COLUMN_BITMASK = 256L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.usermgt.model.TrackClientStatistic"));

	public TrackClientStatisticModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _trackClientStatisticId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTrackClientStatisticId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _trackClientStatisticId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TrackClientStatistic.class;
	}

	@Override
	public String getModelClassName() {
		return TrackClientStatistic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("trackClientStatisticId", getTrackClientStatisticId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("url", getUrl());
		attributes.put("year", getYear());
		attributes.put("month", getMonth());
		attributes.put("day", getDay());
		attributes.put("region", getRegion());
		attributes.put("desktop", isDesktop());
		attributes.put("mobile", isMobile());
		attributes.put("tablet", isTablet());
		attributes.put("total", getTotal());

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

		Long trackClientStatisticId = (Long)attributes.get(
				"trackClientStatisticId");

		if (trackClientStatisticId != null) {
			setTrackClientStatisticId(trackClientStatisticId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer day = (Integer)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		String region = (String)attributes.get("region");

		if (region != null) {
			setRegion(region);
		}

		Boolean desktop = (Boolean)attributes.get("desktop");

		if (desktop != null) {
			setDesktop(desktop);
		}

		Boolean mobile = (Boolean)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		Boolean tablet = (Boolean)attributes.get("tablet");

		if (tablet != null) {
			setTablet(tablet);
		}

		Long total = (Long)attributes.get("total");

		if (total != null) {
			setTotal(total);
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
	public long getTrackClientStatisticId() {
		return _trackClientStatisticId;
	}

	@Override
	public void setTrackClientStatisticId(long trackClientStatisticId) {
		_trackClientStatisticId = trackClientStatisticId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

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

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getUrl() {
		if (_url == null) {
			return "";
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		_columnBitmask |= URL_COLUMN_BITMASK;

		if (_originalUrl == null) {
			_originalUrl = _url;
		}

		_url = url;
	}

	public String getOriginalUrl() {
		return GetterUtil.getString(_originalUrl);
	}

	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_columnBitmask |= YEAR_COLUMN_BITMASK;

		if (!_setOriginalYear) {
			_setOriginalYear = true;

			_originalYear = _year;
		}

		_year = year;
	}

	public int getOriginalYear() {
		return _originalYear;
	}

	@Override
	public int getMonth() {
		return _month;
	}

	@Override
	public void setMonth(int month) {
		_columnBitmask |= MONTH_COLUMN_BITMASK;

		if (!_setOriginalMonth) {
			_setOriginalMonth = true;

			_originalMonth = _month;
		}

		_month = month;
	}

	public int getOriginalMonth() {
		return _originalMonth;
	}

	@Override
	public int getDay() {
		return _day;
	}

	@Override
	public void setDay(int day) {
		_columnBitmask |= DAY_COLUMN_BITMASK;

		if (!_setOriginalDay) {
			_setOriginalDay = true;

			_originalDay = _day;
		}

		_day = day;
	}

	public int getOriginalDay() {
		return _originalDay;
	}

	@Override
	public String getRegion() {
		if (_region == null) {
			return "";
		}
		else {
			return _region;
		}
	}

	@Override
	public void setRegion(String region) {
		_region = region;
	}

	@Override
	public boolean getDesktop() {
		return _desktop;
	}

	@Override
	public boolean isDesktop() {
		return _desktop;
	}

	@Override
	public void setDesktop(boolean desktop) {
		_columnBitmask |= DESKTOP_COLUMN_BITMASK;

		if (!_setOriginalDesktop) {
			_setOriginalDesktop = true;

			_originalDesktop = _desktop;
		}

		_desktop = desktop;
	}

	public boolean getOriginalDesktop() {
		return _originalDesktop;
	}

	@Override
	public boolean getMobile() {
		return _mobile;
	}

	@Override
	public boolean isMobile() {
		return _mobile;
	}

	@Override
	public void setMobile(boolean mobile) {
		_columnBitmask |= MOBILE_COLUMN_BITMASK;

		if (!_setOriginalMobile) {
			_setOriginalMobile = true;

			_originalMobile = _mobile;
		}

		_mobile = mobile;
	}

	public boolean getOriginalMobile() {
		return _originalMobile;
	}

	@Override
	public boolean getTablet() {
		return _tablet;
	}

	@Override
	public boolean isTablet() {
		return _tablet;
	}

	@Override
	public void setTablet(boolean tablet) {
		_columnBitmask |= TABLET_COLUMN_BITMASK;

		if (!_setOriginalTablet) {
			_setOriginalTablet = true;

			_originalTablet = _tablet;
		}

		_tablet = tablet;
	}

	public boolean getOriginalTablet() {
		return _originalTablet;
	}

	@Override
	public long getTotal() {
		return _total;
	}

	@Override
	public void setTotal(long total) {
		_total = total;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TrackClientStatistic.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TrackClientStatistic toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TrackClientStatistic)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TrackClientStatisticImpl trackClientStatisticImpl = new TrackClientStatisticImpl();

		trackClientStatisticImpl.setUuid(getUuid());
		trackClientStatisticImpl.setTrackClientStatisticId(getTrackClientStatisticId());
		trackClientStatisticImpl.setCreateDate(getCreateDate());
		trackClientStatisticImpl.setModifiedDate(getModifiedDate());
		trackClientStatisticImpl.setUrl(getUrl());
		trackClientStatisticImpl.setYear(getYear());
		trackClientStatisticImpl.setMonth(getMonth());
		trackClientStatisticImpl.setDay(getDay());
		trackClientStatisticImpl.setRegion(getRegion());
		trackClientStatisticImpl.setDesktop(isDesktop());
		trackClientStatisticImpl.setMobile(isMobile());
		trackClientStatisticImpl.setTablet(isTablet());
		trackClientStatisticImpl.setTotal(getTotal());

		trackClientStatisticImpl.resetOriginalValues();

		return trackClientStatisticImpl;
	}

	@Override
	public int compareTo(TrackClientStatistic trackClientStatistic) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				trackClientStatistic.getCreateDate());

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

		if (!(obj instanceof TrackClientStatistic)) {
			return false;
		}

		TrackClientStatistic trackClientStatistic = (TrackClientStatistic)obj;

		long primaryKey = trackClientStatistic.getPrimaryKey();

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
		TrackClientStatisticModelImpl trackClientStatisticModelImpl = this;

		trackClientStatisticModelImpl._originalUuid = trackClientStatisticModelImpl._uuid;

		trackClientStatisticModelImpl._setModifiedDate = false;

		trackClientStatisticModelImpl._originalUrl = trackClientStatisticModelImpl._url;

		trackClientStatisticModelImpl._originalYear = trackClientStatisticModelImpl._year;

		trackClientStatisticModelImpl._setOriginalYear = false;

		trackClientStatisticModelImpl._originalMonth = trackClientStatisticModelImpl._month;

		trackClientStatisticModelImpl._setOriginalMonth = false;

		trackClientStatisticModelImpl._originalDay = trackClientStatisticModelImpl._day;

		trackClientStatisticModelImpl._setOriginalDay = false;

		trackClientStatisticModelImpl._originalDesktop = trackClientStatisticModelImpl._desktop;

		trackClientStatisticModelImpl._setOriginalDesktop = false;

		trackClientStatisticModelImpl._originalMobile = trackClientStatisticModelImpl._mobile;

		trackClientStatisticModelImpl._setOriginalMobile = false;

		trackClientStatisticModelImpl._originalTablet = trackClientStatisticModelImpl._tablet;

		trackClientStatisticModelImpl._setOriginalTablet = false;

		trackClientStatisticModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TrackClientStatistic> toCacheModel() {
		TrackClientStatisticCacheModel trackClientStatisticCacheModel = new TrackClientStatisticCacheModel();

		trackClientStatisticCacheModel.uuid = getUuid();

		String uuid = trackClientStatisticCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			trackClientStatisticCacheModel.uuid = null;
		}

		trackClientStatisticCacheModel.trackClientStatisticId = getTrackClientStatisticId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			trackClientStatisticCacheModel.createDate = createDate.getTime();
		}
		else {
			trackClientStatisticCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			trackClientStatisticCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			trackClientStatisticCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		trackClientStatisticCacheModel.url = getUrl();

		String url = trackClientStatisticCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			trackClientStatisticCacheModel.url = null;
		}

		trackClientStatisticCacheModel.year = getYear();

		trackClientStatisticCacheModel.month = getMonth();

		trackClientStatisticCacheModel.day = getDay();

		trackClientStatisticCacheModel.region = getRegion();

		String region = trackClientStatisticCacheModel.region;

		if ((region != null) && (region.length() == 0)) {
			trackClientStatisticCacheModel.region = null;
		}

		trackClientStatisticCacheModel.desktop = isDesktop();

		trackClientStatisticCacheModel.mobile = isMobile();

		trackClientStatisticCacheModel.tablet = isTablet();

		trackClientStatisticCacheModel.total = getTotal();

		return trackClientStatisticCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", trackClientStatisticId=");
		sb.append(getTrackClientStatisticId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", month=");
		sb.append(getMonth());
		sb.append(", day=");
		sb.append(getDay());
		sb.append(", region=");
		sb.append(getRegion());
		sb.append(", desktop=");
		sb.append(isDesktop());
		sb.append(", mobile=");
		sb.append(isMobile());
		sb.append(", tablet=");
		sb.append(isTablet());
		sb.append(", total=");
		sb.append(getTotal());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.opencps.usermgt.model.TrackClientStatistic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trackClientStatisticId</column-name><column-value><![CDATA[");
		sb.append(getTrackClientStatisticId());
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
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>month</column-name><column-value><![CDATA[");
		sb.append(getMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>day</column-name><column-value><![CDATA[");
		sb.append(getDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>region</column-name><column-value><![CDATA[");
		sb.append(getRegion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desktop</column-name><column-value><![CDATA[");
		sb.append(isDesktop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(isMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tablet</column-name><column-value><![CDATA[");
		sb.append(isTablet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>total</column-name><column-value><![CDATA[");
		sb.append(getTotal());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = TrackClientStatistic.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			TrackClientStatistic.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _trackClientStatisticId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _url;
	private String _originalUrl;
	private int _year;
	private int _originalYear;
	private boolean _setOriginalYear;
	private int _month;
	private int _originalMonth;
	private boolean _setOriginalMonth;
	private int _day;
	private int _originalDay;
	private boolean _setOriginalDay;
	private String _region;
	private boolean _desktop;
	private boolean _originalDesktop;
	private boolean _setOriginalDesktop;
	private boolean _mobile;
	private boolean _originalMobile;
	private boolean _setOriginalMobile;
	private boolean _tablet;
	private boolean _originalTablet;
	private boolean _setOriginalTablet;
	private long _total;
	private long _columnBitmask;
	private TrackClientStatistic _escapedModel;
}