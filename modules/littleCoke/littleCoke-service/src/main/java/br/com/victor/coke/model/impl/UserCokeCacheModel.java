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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserCoke in entity cache.
 *
 * @author victor
 * @generated
 */
public class UserCokeCacheModel
	implements CacheModel<UserCoke>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserCokeCacheModel)) {
			return false;
		}

		UserCokeCacheModel userCokeCacheModel = (UserCokeCacheModel)object;

		if (userCokeId == userCokeCacheModel.userCokeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userCokeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userCokeId=");
		sb.append(userCokeId);
		sb.append(", cokeId=");
		sb.append(cokeId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", addedBy=");
		sb.append(addedBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserCoke toEntityModel() {
		UserCokeImpl userCokeImpl = new UserCokeImpl();

		if (uuid == null) {
			userCokeImpl.setUuid("");
		}
		else {
			userCokeImpl.setUuid(uuid);
		}

		userCokeImpl.setUserCokeId(userCokeId);
		userCokeImpl.setCokeId(cokeId);
		userCokeImpl.setUserId(userId);
		userCokeImpl.setAddedBy(addedBy);

		if (createDate == Long.MIN_VALUE) {
			userCokeImpl.setCreateDate(null);
		}
		else {
			userCokeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userCokeImpl.setModifiedDate(null);
		}
		else {
			userCokeImpl.setModifiedDate(new Date(modifiedDate));
		}

		userCokeImpl.resetOriginalValues();

		return userCokeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userCokeId = objectInput.readLong();

		cokeId = objectInput.readLong();

		userId = objectInput.readLong();

		addedBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userCokeId);

		objectOutput.writeLong(cokeId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(addedBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long userCokeId;
	public long cokeId;
	public long userId;
	public long addedBy;
	public long createDate;
	public long modifiedDate;

}