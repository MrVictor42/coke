/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.model.impl;

import br.com.victor.coke.model.Coke;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Coke in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CokeCacheModel implements CacheModel<Coke>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CokeCacheModel)) {
			return false;
		}

		CokeCacheModel cokeCacheModel = (CokeCacheModel)object;

		if (cokeId == cokeCacheModel.cokeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cokeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", cokeId=");
		sb.append(cokeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Coke toEntityModel() {
		CokeImpl cokeImpl = new CokeImpl();

		if (uuid == null) {
			cokeImpl.setUuid("");
		}
		else {
			cokeImpl.setUuid(uuid);
		}

		cokeImpl.setCokeId(cokeId);
		cokeImpl.setGroupId(groupId);

		if (name == null) {
			cokeImpl.setName("");
		}
		else {
			cokeImpl.setName(name);
		}

		cokeImpl.setCompanyId(companyId);
		cokeImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			cokeImpl.setCreateDate(null);
		}
		else {
			cokeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cokeImpl.setModifiedDate(null);
		}
		else {
			cokeImpl.setModifiedDate(new Date(modifiedDate));
		}

		cokeImpl.resetOriginalValues();

		return cokeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		cokeId = objectInput.readLong();

		groupId = objectInput.readLong();
		name = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
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

		objectOutput.writeLong(cokeId);

		objectOutput.writeLong(groupId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long cokeId;
	public long groupId;
	public String name;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;

}