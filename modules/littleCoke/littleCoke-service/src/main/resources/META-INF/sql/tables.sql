create table Coke_Coke (
	uuid_ VARCHAR(75) null,
	cokeId LONG not null primary key,
	groupId LONG,
	name VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table Coke_UserCoke (
	uuid_ VARCHAR(75) null,
	userCokeId LONG not null primary key,
	cokeId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);