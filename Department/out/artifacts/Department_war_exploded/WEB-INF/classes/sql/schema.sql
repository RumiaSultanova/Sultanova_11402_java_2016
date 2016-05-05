create table Users(
	ID serial primary key,
	name varchar(40),
	surname varchar(40)
);

create table Companies(
	ID serial primary key,
	name varchar(60),
	address varchar(60),
	admin varchar(30),
	workeebr varchar(25)
);

create table Docs(
	ID serial primary key,
	userID int,
	railwayName varchar(30),
	railwayAdmin varchar(30),
	trainStation int,
	trainDepot int,
	trainRailroad int,
	trainModel varchar(15),
	trainDate date,
	trainEndDate date,
	trainContentType varchar(15),
	trainRepairType varchar(15),
	trainRepairDate varchar(15),

	foreign key (userID) references Users(ID)
);

create table Auth(
	ID serial primary key,
	mail varchar (50),
	password varchar(30),

	foreign key (ID) references Users(ID)
);

create table userCompany(
	userID serial primary key,
	companyID int,

	foreign key (userID) references Users(ID),
	foreign key (companyID) references Companies(ID)
);