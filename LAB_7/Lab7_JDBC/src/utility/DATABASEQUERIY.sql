DROP DATABASE assignmentdb;
show databases;
DROP DATABASE patienttdb;
show databases;
DROP DATABASE patientdb;
show databases;

CREATE database assignmentdb;
USE assignmentdb;
	CREATE TABLE patient(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(100),
	last_name varchar(100),
	gender varchar(10),
	pateint_type varchar(50),
	age int,
	email varchar(50)
	); 
INSERT INTO patient(name,last_name,gender,pateint_type,age,email) values('Durga Dhana Sree','Chilukuri','Female','Appointment','22','dds@gmail.com');
INSERT INTO patient(name,last_name,gender,pateint_type,age,email) values('rutherford','jame','Male','Appointment','27','ruth@gmail.com');
INSERT INTO patient(name,last_name,gender,pateint_type,age,email) values('Grace','Turie','Female','Walk-in','32','grace@gmail.com');
select*from patient;
DESC patient;


 