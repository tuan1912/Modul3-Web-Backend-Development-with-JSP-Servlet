use minitestquanlyhocvien;
create table classroom(
id int primary key auto_increment,
name varchar(20));
create table student(
id int primary key auto_increment,
name varchar(60),
dateOfBirh date,
address varchar(100),
phoneNumber varchar(12),
email varchar(100),
classRoomId int ,
foreign key (classRoomId) references classroom(id));
insert into classroom(name)
values("C0921K1"),("C0821K1"),("C0721K1");
insert into student(name, dateOfBirh, address,phoneNumber,email,classRoomId)
values("Tuan","1992-12-19","Hai Duong",0388059586, "tuan.nguyen191292@gmail.com",1),
("Hien","1992-12-19","Hai Duong",0388059586, "hien.nguyen@gmail.com",1),
("Toan","1992-12-19","Hai Duong",0388059586, "toan.nguyen@gmail.com",2),
("Thang","1992-12-19","Hai Duong",0388059586, "thang.nguyen@gmail.com",3);



