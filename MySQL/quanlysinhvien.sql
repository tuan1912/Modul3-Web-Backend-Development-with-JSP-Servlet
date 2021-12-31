create database quanlysinhvien;
use quanlysinhvien;
create table class(
classID int primary key auto_increment,
className varchar(60) not null,
StartDate date not null,
Status bit);
create table subject(
subId int primary key auto_increment,
subName varchar(60) not null,
credit tinyint not null default  1 check (credit>=1),
status bit default 1
);
create table student(
studentId int primary key  auto_increment,
studentName varchar(30) not null,
address varchar(50),
phone varchar(20),
status bit,
classId int not null,
foreign key (classId) references class(classId)
);
create table mark(
markId int primary key auto_increment,
subId int not null,
studentId int not null,
mark float default 0 check (mark between 0 and 100),
examTimes tinyint default 1,
foreign key (subId) references subject(subId),
foreign key (studentId) references student(studentId)
);
insert into class(className, StartDate,status)
values('A1', 20/12/2008,1),
	  ('A2', 22/12/2008,1),
	  ('B3', current_date,0);
insert into student(studentName,address,phone,status,classId)
values('Hung', 'Ha Noi', 0912113113,1,1);
insert into student(studentName,address,status,classId)
values('Hoa', 'Hai Phong', 1, 1);
insert into student(studentName,address,phone,status,classId)
values('Manh', 'HCM', 0123123123,0,2);
insert into subject(subName,credit,status)
values('CF', 5, 1),
	  ('C', 6, 1),
	  ('HDJ', 5, 1),
	  ('RDBMS', 10, 1);
insert into mark(subId,studentId,mark,examTimes)
values(1,1,8,1),(1,2,10,2),(2,1,12,1);





 

