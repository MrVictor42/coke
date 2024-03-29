create index IX_5BA67359 on Coke_Coke (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6AB5FC1B on Coke_Coke (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_44606585 on Coke_UserCoke (cokeId);
create index IX_D509AFE4 on Coke_UserCoke (uuid_[$COLUMN_LENGTH:75$]);