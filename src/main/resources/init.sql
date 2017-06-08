insert into USER(USERID, PASSWORD, USERNAME, EMAIL, GENDER, BIRTHDAY) values ('qwe', 'qwe', 'asd', 'qwe@qwe.com', 'male', '1986-5-5');

insert into LESSON(title, time) values ('A programing language', 10);
insert into LESSON(title, time) values ('B programing language', 10);
insert into LESSON(title, time) values ('C programing language', 10);
insert into LESSON(title, time) values ('D programing language', 10);
insert into LESSON(title, time) values ('E programing language', 10);

insert into COURSE(title, description, startdate, enddate, pax, active) values ('Of Mice and Men', 'Training','2015-6-1', '2017-6-1', 1, 0);
insert into COURSE(title, description, startdate, enddate, pax, active) values ('One Flew Over the Cuckoos Nest', 'Training','2015-6-1', '2017-6-1', 10, 0);
insert into COURSE(title, description, startdate, enddate, pax, active) values ('For Whom the Bell Tolls', 'Training','2015-6-1', '2017-6-1', 15, 0);
insert into COURSE(title, description, startdate, enddate, pax, active) values ('War and Peace', 'Training','2015-6-1', '2017-6-1', 12, 0);
insert into COURSE(title, description, startdate, enddate, pax, active) values ('The Grapes of Wrath', 'Training','2015-6-1', '2017-6-1', 3, 0);
insert into COURSE(title, description, startdate, enddate, pax, active) values ('a', 'Training','2017-6-1', '2017-6-1', 25, 0);
insert into COURSE(title, description, startdate, enddate, pax, active) values ('a', 'Training','2017-6-1', '2017-6-1', 11, 0);
insert into COURSE(title, description, startdate, enddate, pax, active) values ('a', 'Training','2017-6-1', '2017-6-1', 30, 0);
--Enrollment
insert into ENROLLMENT(USERID, COURSEID, STATUS) values ('qwe', 1, 2);
insert into ENROLLMENT(USERID, COURSEID, STATUS) values ('qwe', 2, 0);
insert into ENROLLMENT(USERID, COURSEID, STATUS) values ('qwe', 3, 0);
insert into ENROLLMENT(USERID, COURSEID, STATUS) values ('qwe', 4, 0);
