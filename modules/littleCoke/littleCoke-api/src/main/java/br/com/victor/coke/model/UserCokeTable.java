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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Coke_UserCoke&quot; database table.
 *
 * @author victor
 * @see UserCoke
 * @generated
 */
public class UserCokeTable extends BaseTable<UserCokeTable> {

	public static final UserCokeTable INSTANCE = new UserCokeTable();

	public final Column<UserCokeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserCokeTable, Long> userCokeId = createColumn(
		"userCokeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserCokeTable, Long> cokeId = createColumn(
		"cokeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserCokeTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserCokeTable, String> position = createColumn(
		"position", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserCokeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UserCokeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UserCokeTable, Integer> order = createColumn(
		"order_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private UserCokeTable() {
		super("Coke_UserCoke", UserCokeTable::new);
	}

}