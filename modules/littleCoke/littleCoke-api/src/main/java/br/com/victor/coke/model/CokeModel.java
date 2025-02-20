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

package br.com.victor.coke.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Coke service. Represents a row in the &quot;Coke_Coke&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>br.com.victor.coke.model.impl.CokeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>br.com.victor.coke.model.impl.CokeImpl</code>.
 * </p>
 *
 * @author victor
 * @see Coke
 * @generated
 */
@ProviderType
public interface CokeModel
	extends BaseModel<Coke>, GroupedModel, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a coke model instance should use the {@link Coke} interface instead.
	 */

	/**
	 * Returns the primary key of this coke.
	 *
	 * @return the primary key of this coke
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this coke.
	 *
	 * @param primaryKey the primary key of this coke
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this coke.
	 *
	 * @return the uuid of this coke
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this coke.
	 *
	 * @param uuid the uuid of this coke
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the coke ID of this coke.
	 *
	 * @return the coke ID of this coke
	 */
	public long getCokeId();

	/**
	 * Sets the coke ID of this coke.
	 *
	 * @param cokeId the coke ID of this coke
	 */
	public void setCokeId(long cokeId);

	/**
	 * Returns the group ID of this coke.
	 *
	 * @return the group ID of this coke
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this coke.
	 *
	 * @param groupId the group ID of this coke
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the name of this coke.
	 *
	 * @return the name of this coke
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this coke.
	 *
	 * @param name the name of this coke
	 */
	public void setName(String name);

	/**
	 * Returns the company ID of this coke.
	 *
	 * @return the company ID of this coke
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this coke.
	 *
	 * @param companyId the company ID of this coke
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this coke.
	 *
	 * @return the user ID of this coke
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this coke.
	 *
	 * @param userId the user ID of this coke
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this coke.
	 *
	 * @return the user uuid of this coke
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this coke.
	 *
	 * @param userUuid the user uuid of this coke
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this coke.
	 *
	 * @return the create date of this coke
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this coke.
	 *
	 * @param createDate the create date of this coke
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this coke.
	 *
	 * @return the modified date of this coke
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this coke.
	 *
	 * @param modifiedDate the modified date of this coke
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user name of this coke.
	 *
	 * @return the user name of this coke
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this coke.
	 *
	 * @param userName the user name of this coke
	 */
	@Override
	public void setUserName(String userName);

	@Override
	public Coke cloneWithOriginalValues();

}