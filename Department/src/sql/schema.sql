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

create table Railway(
	ID serial primary key,
	name varchar(30),
	admin varchar(30)
);

create table Train(
	ID serial primary key,
	station int,
	depot int,
	railroad int,
	model varchar(15),
	date date,
	endDate date,
	contentType varchar(15),
	repairType varchar(15),
	repairDate varchar(15)
);

create table Auth(
	ID serial primary key,
	mail varchar (50),
	password varchar(30),

	foreign key (userID) references Users(ID)
);

create table userCod(
	userID serial primary key,
	docID int,

	foreign key (userID) references Users(ID),
	foreign key (docID) references Documents(ID)
);

create table userCompany(
	userID serial primary key,
	companyID int,

	foreign key (userID) references Users(ID),
	foreign key (docID) references Companies(ID)
);