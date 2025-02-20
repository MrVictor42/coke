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

package br.com.victor.coke.model.impl;

import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.model.UserCokeModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the UserCoke service. Represents a row in the &quot;Coke_UserCoke&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>UserCokeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserCokeImpl}.
 * </p>
 *
 * @author victor
 * @see UserCokeImpl
 * @generated
 */
@JSON(strict = true)
public class UserCokeModelImpl
	extends BaseModelImpl<UserCoke> implements UserCokeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user coke model instance should use the <code>UserCoke</code> interface instead.
	 */
	public static final String TABLE_NAME = "Coke_UserCoke";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"userCokeId", Types.BIGINT},
		{"cokeId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"position", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"order_", Types.INTEGER},
		{"nextToPay", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userCokeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cokeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("position", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("nextToPay", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Coke_UserCoke (uuid_ VARCHAR(75) null,userCokeId LONG not null primary key,cokeId LONG,userId LONG,position VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,order_ INTEGER,nextToPay BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table Coke_UserCoke";

	public static final String ORDER_BY_JPQL =
		" ORDER BY userCoke.userCokeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Coke_UserCoke.userCokeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COKEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERCOKEID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public UserCokeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userCokeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserCokeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userCokeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserCoke.class;
	}

	@Override
	public String getModelClassName() {
		return UserCoke.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UserCoke, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UserCoke, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserCoke, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((UserCoke)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UserCoke, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UserCoke, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UserCoke)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UserCoke, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UserCoke, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, UserCoke>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			UserCoke.class.getClassLoader(), UserCoke.class,
			ModelWrapper.class);

		try {
			Constructor<UserCoke> constructor =
				(Constructor<UserCoke>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<UserCoke, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<UserCoke, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<UserCoke, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<UserCoke, Object>>();
		Map<String, BiConsumer<UserCoke, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<UserCoke, ?>>();

		attributeGetterFunctions.put("uuid", UserCoke::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<UserCoke, String>)UserCoke::setUuid);
		attributeGetterFunctions.put("userCokeId", UserCoke::getUserCokeId);
		attributeSetterBiConsumers.put(
			"userCokeId", (BiConsumer<UserCoke, Long>)UserCoke::setUserCokeId);
		attributeGetterFunctions.put("cokeId", UserCoke::getCokeId);
		attributeSetterBiConsumers.put(
			"cokeId", (BiConsumer<UserCoke, Long>)UserCoke::setCokeId);
		attributeGetterFunctions.put("userId", UserCoke::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<UserCoke, Long>)UserCoke::setUserId);
		attributeGetterFunctions.put("position", UserCoke::getPosition);
		attributeSetterBiConsumers.put(
			"position", (BiConsumer<UserCoke, String>)UserCoke::setPosition);
		attributeGetterFunctions.put("createDate", UserCoke::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<UserCoke, Date>)UserCoke::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", UserCoke::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<UserCoke, Date>)UserCoke::setModifiedDate);
		attributeGetterFunctions.put("order", UserCoke::getOrder);
		attributeSetterBiConsumers.put(
			"order", (BiConsumer<UserCoke, Integer>)UserCoke::setOrder);
		attributeGetterFunctions.put("nextToPay", UserCoke::getNextToPay);
		attributeSetterBiConsumers.put(
			"nextToPay", (BiConsumer<UserCoke, Boolean>)UserCoke::setNextToPay);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getUserCokeId() {
		return _userCokeId;
	}

	@Override
	public void setUserCokeId(long userCokeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userCokeId = userCokeId;
	}

	@JSON
	@Override
	public long getCokeId() {
		return _cokeId;
	}

	@Override
	public void setCokeId(long cokeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cokeId = cokeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCokeId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("cokeId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getPosition() {
		if (_position == null) {
			return "";
		}
		else {
			return _position;
		}
	}

	@Override
	public void setPosition(String position) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_position = position;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_order = order;
	}

	@JSON
	@Override
	public Boolean getNextToPay() {
		return _nextToPay;
	}

	@Override
	public void setNextToPay(Boolean nextToPay) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_nextToPay = nextToPay;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, UserCoke.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserCoke toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UserCoke>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserCokeImpl userCokeImpl = new UserCokeImpl();

		userCokeImpl.setUuid(getUuid());
		userCokeImpl.setUserCokeId(getUserCokeId());
		userCokeImpl.setCokeId(getCokeId());
		userCokeImpl.setUserId(getUserId());
		userCokeImpl.setPosition(getPosition());
		userCokeImpl.setCreateDate(getCreateDate());
		userCokeImpl.setModifiedDate(getModifiedDate());
		userCokeImpl.setOrder(getOrder());
		userCokeImpl.setNextToPay(getNextToPay());

		userCokeImpl.resetOriginalValues();

		return userCokeImpl;
	}

	@Override
	public UserCoke cloneWithOriginalValues() {
		UserCokeImpl userCokeImpl = new UserCokeImpl();

		userCokeImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		userCokeImpl.setUserCokeId(
			this.<Long>getColumnOriginalValue("userCokeId"));
		userCokeImpl.setCokeId(this.<Long>getColumnOriginalValue("cokeId"));
		userCokeImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		userCokeImpl.setPosition(
			this.<String>getColumnOriginalValue("position"));
		userCokeImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		userCokeImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		userCokeImpl.setOrder(this.<Integer>getColumnOriginalValue("order_"));
		userCokeImpl.setNextToPay(
			this.<Boolean>getColumnOriginalValue("nextToPay"));

		return userCokeImpl;
	}

	@Override
	public int compareTo(UserCoke userCoke) {
		long primaryKey = userCoke.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserCoke)) {
			return false;
		}

		UserCoke userCoke = (UserCoke)object;

		long primaryKey = userCoke.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<UserCoke> toCacheModel() {
		UserCokeCacheModel userCokeCacheModel = new UserCokeCacheModel();

		userCokeCacheModel.uuid = getUuid();

		String uuid = userCokeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			userCokeCacheModel.uuid = null;
		}

		userCokeCacheModel.userCokeId = getUserCokeId();

		userCokeCacheModel.cokeId = getCokeId();

		userCokeCacheModel.userId = getUserId();

		userCokeCacheModel.position = getPosition();

		String position = userCokeCacheModel.position;

		if ((position != null) && (position.length() == 0)) {
			userCokeCacheModel.position = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			userCokeCacheModel.createDate = createDate.getTime();
		}
		else {
			userCokeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			userCokeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			userCokeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		userCokeCacheModel.order = getOrder();

		Boolean nextToPay = getNextToPay();

		if (nextToPay != null) {
			userCokeCacheModel.nextToPay = nextToPay;
		}

		return userCokeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UserCoke, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UserCoke, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserCoke, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((UserCoke)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<UserCoke, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<UserCoke, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserCoke, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((UserCoke)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, UserCoke>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _userCokeId;
	private long _cokeId;
	private long _userId;
	private String _position;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _order;
	private Boolean _nextToPay;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<UserCoke, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((UserCoke)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("userCokeId", _userCokeId);
		_columnOriginalValues.put("cokeId", _cokeId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("position", _position);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("order_", _order);
		_columnOriginalValues.put("nextToPay", _nextToPay);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("order_", "order");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("userCokeId", 2L);

		columnBitmasks.put("cokeId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("position", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("order_", 128L);

		columnBitmasks.put("nextToPay", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private UserCoke _escapedModel;

}