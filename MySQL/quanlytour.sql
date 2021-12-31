create database quanlytour;
use quanlytour;
create table thanhpho(
id int primary key auto_increment,
tenThanhPho varchar(20) not null unique) ;
insert into thanhpho(tenThanhPho)
values ('Hai Duong'),('Ha Noi'), ('HCM'),('Hai Phong'),('Da Nang');

create table khachhang(
id int primary key not null auto_increment,
ten varchar(20),
soCanCuoc int(5) unique,
namSinh int(4),
thanhphoId int ,
foreign key (thanhphoId) references thanhpho(id));

insert into khachhang(ten,soCanCuoc,namSinh,thanhphoId)
values('Tuan', 12345, 1992,1),
	  ('Tu', 12432, 1995, 2),
      ('Hai', 28232, 1990, 3),
      ('Hoa', 21432, 1999, 5),
      ('Tai', 38432, 1991, 3),
      ('Toan', 28532, 2005, 2),
      ('Nam', 28432, 2000, 1), 
      ('Tu', 45432, 1992, 4), 
      ('Tai', 21732, 1997, 5),
      ('Hoa', 27932, 1995, 2);
select ten, thanhpho.tenThanhPho, namSinh
from khachhang join thanhpho on khachhang.thanhphoId = thanhpho.id;
create table loaitour(
 id int primary key auto_increment,
tenLoaiTour varchar(20));
insert into loaitour(tenLoaiTour)
values('3 ngay 3 dem'), ('7 ngay 7 dem');
create table diemdendulich(
id int primary key auto_increment,
tenDiemDen varchar(20) unique,
moTa varchar(100),
gia int,
thanhphoId int,
foreign key (thanhphoId) references thanhpho(id));
insert into diemdendulich(tenDiemDen,moTa,gia,thanhphoId)
values('chua Tranh', 'chua', 2000000,1),
      ('dao Co', 'cheo thuyen', 1000000,1),
      ('Ho Hoan Kiem', 'danh lam thang canh', 1000000,2),
      ('Do Son', 'bai tam', 1500000,4),
      ('Bao tang PK-KQ', 'museum', 1000000,2);

create table tour(
id int primary key auto_increment,
loaiTourId int,
diemDenId int,
ngayBatDau date,
ngayKetThuc date,
foreign key (diemDenId) references diemdendulich(id));
insert into tour(loaiTourId, diemDenId,ngayBatDau,ngayKetThuc)
values(1,1,'2021-12-01','2021-12-04'),
(1,2,'2021-12-01','2021-12-04'),
(1,3,'2021-12-01','2021-12-04'),
(1,4,'2021-12-01','2021-12-04'),
(1,5,'2021-12-01','2021-12-04'),
(2,1,'2021-12-01','2021-12-08'),
(2,2,'2021-12-01','2021-12-08'),
(2,3,'2021-12-01','2021-12-08'),
(2,4,'2021-12-01','2021-12-08'),
(2,5,'2021-12-01','2021-12-08'),
(1,1,'2021-12-04','2021-12-08'),
(1,2,'2021-12-04','2021-12-08'),
(1,3,'2021-12-04','2021-12-08'),
(2,4,'2021-12-05','2021-12-12'),
(2,5,'2021-12-05','2021-12-12');
create table hoadondattour(
id int primary key auto_increment,
tourId int,
khachHangId int,
status bit,
foreign key (tourId) references tour(id),
foreign key(khachHangId) references khachhang(id));
insert into hoadondattour( tourId, khachHangId, status)
values(1,1,1),
(2,2,1),
(3,3,1),
(4,4,0),
(5,5,1),
(6,6,1),
(7,7,0),
(8,8,0),
(9,9,1),
(10,10,1);
-- SO LUONG TOUR CUA CAC THANH PHO
select  thanhpho.tenThanhPho,count(tour.id)
from tour join diemdendulich on tour.diemDenId = diemdendulich.id
          join thanhpho on thanhpho.id = diemdendulich.thanhphoId
group by thanhpho.tenThanhPho
;
-- SO LUONG TUA KET THUC THANG 12
select count(tour.id) as soluongtour, ngayKetThuc
from tour
group by ngayKetThuc like '%-12-%' 
having ngayKetThuc like '%-12-%' ;
-- SO LUONG TOUR NGAY BAT DAU THANG 2
select count(tour.id), ngayBatDau
from tour
group by ngayBatDau like '%-02-%'
having ngayBatDau like '%-02-%';
