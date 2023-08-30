create table "User"(
    id serial primary key,
    firstName varchar(100),
    lastName varchar(100),
    email varchar(150),
    password varchar(150),
    userType varchar(150)
);

create table Admin(
    id serial primary key,
    firstName varchar(100),
    lastName varchar(100),
    email varchar(150),
    password varchar(150),
    gender char(1)
);

create table Client (
	id serial primary key,
	firstName varchar(50),
	lastName varchar(50),
	email varchar(50),
	gender char(1),
	password varchar(50)
);

create table Appointment (
	id serial primary key,
	appointmentDate DATE,
	location varchar(50),
	description varchar(50),
	appointmentType varchar(50)
);

create table Make(
    id serial primary key,
    id_client int,
    id_appointment int
);