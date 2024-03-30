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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserCoke}.
 * </p>
 *
 * @author victor
 * @see UserCoke
 * @generated
 */
public class UserCokeWrapper
	extends BaseModelWrapper<UserCoke>
	implements ModelWrapper<UserCoke>, UserCoke {

	public UserCokeWrapper(UserCoke userCoke) {
		super(userCoke);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userCokeId", getUserCokeId());
		attributes.put("cokeId", getCokeId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userCokeId = (Long)attributes.get("userCokeId");

		if (userCokeId != null) {
			setUserCokeId(userCokeId);
		}

		Long cokeId = (Long)attributes.get("cokeId");

		if (cokeId != null) {
			setCokeId(cokeId);
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
	}

	@Override
	public UserCoke cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the coke ID of this user coke.
	 *
	 * @return the coke ID of this user coke
	 */
	@Override
	public long getCokeId() {
		return model.getCokeId();
	}

	/**
	 * Returns the create date of this user coke.
	 *
	 * @return the create date of this user coke
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this user coke.
	 *
	 * @return the modified date of this user coke
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this user coke.
	 *
	 * @return the primary key of this user coke
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user coke ID of this user coke.
	 *
	 * @return the user coke ID of this user coke
	 */
	@Override
	public long getUserCokeId() {
		return model.getUserCokeId();
	}

	/**
	 * Returns the user ID of this user coke.
	 *
	 * @return the user ID of this user coke
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this user coke.
	 *
	 * @return the user uuid of this user coke
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user coke.
	 *
	 * @return the uuid of this user coke
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the coke ID of this user coke.
	 *
	 * @param cokeId the coke ID of this user coke
	 */
	@Override
	public void setCokeId(long cokeId) {
		model.setCokeId(cokeId);
	}

	/**
	 * Sets the create date of this user coke.
	 *
	 * @param createDate the create date of this user coke
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this user coke.
	 *
	 * @param modifiedDate the modified date of this user coke
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this user coke.
	 *
	 * @param primaryKey the primary key of this user coke
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user coke ID of this user coke.
	 *
	 * @param userCokeId the user coke ID of this user coke
	 */
	@Override
	public void setUserCokeId(long userCokeId) {
		model.setUserCokeId(userCokeId);
	}

	/**
	 * Sets the user ID of this user coke.
	 *
	 * @param userId the user ID of this user coke
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this user coke.
	 *
	 * @param userUuid the user uuid of this user coke
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user coke.
	 *
	 * @param uuid the uuid of this user coke
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected UserCokeWrapper wrap(UserCoke userCoke) {
		return new UserCokeWrapper(userCoke);
	}

}