/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.model.impl;

import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.CokeModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
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
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

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
 * The base model implementation for the Coke service. Represents a row in the &quot;Coke_Coke&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CokeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CokeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CokeImpl
 * @generated
 */
@JSON(strict = true)
public class CokeModelImpl extends BaseModelImpl<Coke> implements CokeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a coke model instance should use the <code>Coke</code> interface instead.
	 */
	public static final String TABLE_NAME = "Coke_Coke";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"cokeId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cokeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Coke_Coke (uuid_ VARCHAR(75) null,cokeId LONG not null primary key,groupId LONG,name VARCHAR(75) null,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table Coke_Coke";

	public static final String ORDER_BY_JPQL = " ORDER BY coke.cokeId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY Coke_Coke.cokeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

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
	public static final long COKEID_COLUMN_BITMASK = 8L;

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

	public CokeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cokeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCokeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cokeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Coke.class;
	}

	@Override
	public String getModelClassName() {
		return Coke.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Coke, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Coke, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Coke, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Coke)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Coke, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Coke, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Coke)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Coke, Object>> getAttributeGetterFunctions() {
		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Coke, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Coke, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Coke, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Coke, Object>>();

			attributeGetterFunctions.put("uuid", Coke::getUuid);
			attributeGetterFunctions.put("cokeId", Coke::getCokeId);
			attributeGetterFunctions.put("groupId", Coke::getGroupId);
			attributeGetterFunctions.put("name", Coke::getName);
			attributeGetterFunctions.put("companyId", Coke::getCompanyId);
			attributeGetterFunctions.put("userId", Coke::getUserId);
			attributeGetterFunctions.put("createDate", Coke::getCreateDate);
			attributeGetterFunctions.put("modifiedDate", Coke::getModifiedDate);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Coke, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Coke, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Coke, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<Coke, String>)Coke::setUuid);
			attributeSetterBiConsumers.put(
				"cokeId", (BiConsumer<Coke, Long>)Coke::setCokeId);
			attributeSetterBiConsumers.put(
				"groupId", (BiConsumer<Coke, Long>)Coke::setGroupId);
			attributeSetterBiConsumers.put(
				"name", (BiConsumer<Coke, String>)Coke::setName);
			attributeSetterBiConsumers.put(
				"companyId", (BiConsumer<Coke, Long>)Coke::setCompanyId);
			attributeSetterBiConsumers.put(
				"userId", (BiConsumer<Coke, Long>)Coke::setUserId);
			attributeSetterBiConsumers.put(
				"createDate", (BiConsumer<Coke, Date>)Coke::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate", (BiConsumer<Coke, Date>)Coke::setModifiedDate);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

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

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
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

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Coke.class.getName()));
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
			getCompanyId(), Coke.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Coke toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Coke>
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
		CokeImpl cokeImpl = new CokeImpl();

		cokeImpl.setUuid(getUuid());
		cokeImpl.setCokeId(getCokeId());
		cokeImpl.setGroupId(getGroupId());
		cokeImpl.setName(getName());
		cokeImpl.setCompanyId(getCompanyId());
		cokeImpl.setUserId(getUserId());
		cokeImpl.setCreateDate(getCreateDate());
		cokeImpl.setModifiedDate(getModifiedDate());

		cokeImpl.resetOriginalValues();

		return cokeImpl;
	}

	@Override
	public Coke cloneWithOriginalValues() {
		CokeImpl cokeImpl = new CokeImpl();

		cokeImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		cokeImpl.setCokeId(this.<Long>getColumnOriginalValue("cokeId"));
		cokeImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		cokeImpl.setName(this.<String>getColumnOriginalValue("name"));
		cokeImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		cokeImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		cokeImpl.setCreateDate(this.<Date>getColumnOriginalValue("createDate"));
		cokeImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));

		return cokeImpl;
	}

	@Override
	public int compareTo(Coke coke) {
		long primaryKey = coke.getPrimaryKey();

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

		if (!(object instanceof Coke)) {
			return false;
		}

		Coke coke = (Coke)object;

		long primaryKey = coke.getPrimaryKey();

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
	public CacheModel<Coke> toCacheModel() {
		CokeCacheModel cokeCacheModel = new CokeCacheModel();

		cokeCacheModel.uuid = getUuid();

		String uuid = cokeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cokeCacheModel.uuid = null;
		}

		cokeCacheModel.cokeId = getCokeId();

		cokeCacheModel.groupId = getGroupId();

		cokeCacheModel.name = getName();

		String name = cokeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			cokeCacheModel.name = null;
		}

		cokeCacheModel.companyId = getCompanyId();

		cokeCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			cokeCacheModel.createDate = createDate.getTime();
		}
		else {
			cokeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cokeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cokeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return cokeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Coke, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Coke, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Coke, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Coke)this);

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

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Coke>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Coke.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _cokeId;
	private long _groupId;
	private String _name;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Coke, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Coke)this);
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
		_columnOriginalValues.put("cokeId", _cokeId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

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

		columnBitmasks.put("cokeId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("name", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Coke _escapedModel;

}