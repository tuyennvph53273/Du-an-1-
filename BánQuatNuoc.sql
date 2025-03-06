Create database BanQuatNuoc;

Use BanQuatNuoc;

Create table Login(
IDLogin nvarchar(10) Primary Key ,
Username nvarchar(30)  ,
Password nvarchar(30) 
)

Create table NhanVien(
IDNhanvien nvarchar(10) Primary key ,
IDLogin nvarchar(10),
Tennhanvien nvarchar(30) ,
Tuoi int ,
Diachi nvarchar(30),
Gioitinh bit ,
NgayBatDauLam nvarchar(30) ,
TrangThai bit ,
Foreign key(IDLogin) References Login(IDLogin)
)

Create table KhachHang(
IDKhachhang nvarchar(10) Primary key ,
Tenkhachhang nvarchar(30) ,
Tuoi int ,
Gioitinh bit,
Diachi nvarchar(30),
TrangThai bit 
)

Create table SanPham(
IDSanpham nvarchar(10) Primary key ,
TenSanpham nvarchar(30) ,
TrangThai bit 
)

Create table KhuyenMai(
IDKhuyenmai nvarchar(10) Primary key ,
PhanTramKM nvarchar(10) ,
NgayBatDau date ,
NgayKetThuc date ,
TrangThai bit 
)

Create table DongCo(
IDDongCo nvarchar(10) Primary key ,
TenDC nvarchar(30) ,
HangDC nvarchar(30) ,
NgaySanXuat date ,
CongSuat int ,
Chatlieu nvarchar(30) ,
TrangThai bit 
)

Create table BinhChua(
IDBinhChua nvarchar(10) Primary key ,
TenBC nvarchar(30) ,
HangBC nvarchar(30) ,
NgaySanXuat date ,
DungTich int ,
TrangThai bit 
)

Create table CanhQuat(
IDCanhQuat nvarchar(10) Primary key ,
TenCQ nvarchar(30) ,
HangCQ nvarchar(30) ,
NgaySanXuat date ,
CongSuat int ,
Chatlieu nvarchar(30) ,
TrangThai bit 
)

Create table LinhKien(
IDLinhkien nvarchar(10) Primary key ,
TenLinhkien nvarchar(30) ,
IDDongCo nvarchar(10),
IDBinhChua nvarchar(10),
IDCanhQuat nvarchar(10),
Ngaybaohanh date ,
Ngayketthucbaohanh date ,
TrangThai bit 
Foreign key(IDDongCo) References DongCo(IDDongCo),
Foreign key(IDBinhChua) References BinhChua(IDBinhChua),
Foreign key(IDCanhQuat) References CanhQuat(IDCanhQuat),
)



Create table MauSac(
IDMausac nvarchar(10) Primary key ,
Tenmau nvarchar(30) ,
Dodam int ,
TrangThai bit 
)

Create table PhanLoai(
IDLoai nvarchar(10) Primary key ,
Kieudang nvarchar(30) ,
Size nvarchar(50) ,
TrangThai bit 
)

Create table Voucher(
IDVoucher nvarchar(10) Primary key ,
PhanTramGiamGia nvarchar(30) ,
NgayBatDau date ,
NgayKetThuc date ,
TrangThai bit 
)

Create table SanPhamChiTiet(
IDSanPhamCT nvarchar(10) Primary key ,
IDLinhkien nvarchar(10),
IDMausac nvarchar(10),
IDKhuyenmai nvarchar(10),
IDSanpham nvarchar(10),
IDLoai nvarchar(10),
Trongluong int ,
Phamvi nvarchar(30) ,
Tocdogio int ,
Soluong int , 
HangSX nvarchar(30) ,
Giaban decimal(12,0) ,
TrangThai bit ,
Foreign key(IDLinhkien) References LinhKien(IDLinhKien),
Foreign key(IDMausac) References MauSac(IDMausac),
Foreign key(IDKhuyenmai) References KhuyenMai(IDKhuyenmai),
Foreign key(IDSanpham) References SanPham(IDSanpham),
Foreign key(IDLoai) References PhanLoai(IDLoai)
)

Create table HoaDon(
IDHoadon nvarchar(10) Primary key ,
IDKhachhang nvarchar(10),
IDNhanvien nvarchar(10),
IDVoucher nvarchar(10),
NgayMuaHang date ,
Tonggia decimal(12,0) ,
TrangThai bit ,
Foreign key(IDKhachhang) References KhachHang(IDKhachhang),
Foreign key(IDNhanvien) References NhanVien(IDNhanvien),
Foreign key(IDVoucher) References Voucher(IDVoucher)
)

Create table HoaDonChiTiet(
IDHoaDonCT nvarchar(10) Primary key ,
IDSanPhamCT nvarchar(10),
IDHoadon nvarchar(10),
Soluong int ,
Dongia decimal(12,0) ,
TrangThai bit ,
Foreign key(IDSanPhamCT) References SanPhamChiTiet(IDSanPhamCT),
Foreign key(IDHoadon) References HoaDon(IDHoadon)
)

INSERT INTO Login
VALUES 
	('1','Tuyen','123'),
	('2','Luong','456'),
	('3','Duy','789'),
	('4','Nguyen','012')

INSERT INTO NhanVien
VALUES 
	('NV001',1,N'Tuyên',19,N'Bắc Ninh',1,'2024-01-01',1),
	('NV002',2,N'Lương',19,N'Hà Nội',1,'2024-01-04',1),
	('NV003',3,N'Duy', 19,N'Hà Nội',1,'2024-05-06',1),
	('NV004',4,N'Nguyễn',19,N'Hà Nội',1,'2024-13-09',1)

INSERT INTO KhachHang
VALUES 
	('KH001',N'Phú	',19,1,N'Lạng Sơn',1),
	('KH002',N'Phước',19,1,N'Hải Dương',1),
	('KH003',N'Tuyền',19,0,N'Bắc Ninh',1),
	('KH004',N'Phương',19,0	,N'Bắc Ninh',1)

INSERT INTO DongCo
VALUES
	('DC001',N'Động Cơ Senko','Senko','2024-02-13',220,N'Sắt',	1),
	('DC002',N'Động Cơ Lifan','Lifan','2024-02-02',200,N'Sắt',	1),
	('DC003',N'Động Cơ Midea','Midea','2024-02-03',250,N'Sắt',	1),
	('DC004',N'Động Cơ Tefal','Tefal','2024-09-13',150,N'Sắt',	1)

INSERT INTO CanhQuat
VALUES 
	('CQ001',N'Cánh Quạt Toshiba  ','Toshiba  ','2024-04-24',290,N'Đồng',1),
	('CQ002',N'Cánh Quạt Sunhouse ','Sunhouse ','2024-11-03',220,N'Đồng',1),
	('CQ003',N'Cánh Quạt Kangaroo ','Kangaroo ','2024-03-13',140,N'Đồng',1),
	('CQ004',N'Cánh Quạt Panasonic','Panasonic','2024-06-27',200,N'Đồng',1)
	
INSERT INTO BinhChua
VALUES
	('BC001',N'Bình Tefal','Tefal','2024-03-03',2,1),
	('BC002',N'Bình KDK','KDK','2024-03-13',4,1),
	('BC003',N'Bình Toshi','Toshi','2024-08-23',5,1),
	('BC004',N'Bình Lifan','Lifan','2024-05-27',1,1)
	
INSERT INTO MauSac
VALUES
	('MS001',N'Đỏ',20,	1),
	('MS002',N'Xanh',30,	1),
	('MS003',N'Vàng',50,	1),
	('MS004',N'Đen',70,	1)
	INSERT INTO PhanLoai
VALUES
	('L001',N'Treo Tường','53 cm - 128 cm - 46.5 cm	',1	),
	('L002',N'Trần Nhà','30 cm - 100 cm - 40 cm',1),
	('L003',N'Để bàn','43 cm - 48 cm - 25 cm',1),
	('L004',N'Quạt cây','48 cm - 120 cm - 20.5 cm',1)
	
INSERT INTO KhuyenMai
VALUES 
	('KM001',5,'2024-01-10','2024-01-15',1),
	('KM002',10,'2024-01-15','2024-01-20',1),
	('KM003',15,'2024-04-20','2024-04-25',1),
	('KM004',20,'2024-08-14','2024-08-20',1)
	INSERT INTO SanPham
VALUES 
	('SP001',N'Quạt điều hòa Sunhouse SHD7756',1),
	('SP002',N'Quạt điều hòa Boss S-102',1),
	('SP003',N'Quạt điều hòa Kangaroo KG50F64',1),
	('SP004',N'Quạt điều hòa Nagakawa NFC452',1)

	INSERT INTO Voucher
VALUES 
	('VC001',10,'2024-03-03','2024-10-03',1),
	('VC002',15,'2024-07-08','2024-10-08',1),
	('VC003',20,'2024-12-11','2024-12-20',1),
	('VC004',25,'2024-06-11','2024-06-15',1)

	INSERT INTO HoaDon
VALUES 
	('HD001','KH001','NV001','VC001','2024-04-03',400000,	1),
	('HD002','KH002','NV002','VC002','2024-04-13',500000,	1),
	('HD003','KH003','NV003','VC003','2024-08-02',300000,	1),
	('HD004','KH004','NV004','VC003','2024-08-02',200000,	1)

INSERT INTO HoaDonChiTiet
VALUES 
	('HDCT001','SPCT001','HD001',3,	300000,	1),
	('HDCT002','SPCT002','HD002',2,	500000,	1),
	('HDCT003','SPCT003','HD003',1,	200000,	1),
	('HDCT004','SPCT004','HD004',5,	100000, 1)

INSERT INTO LinhKien
VALUES 
	('LK001',N'Linh Kiện Kangaroo ','DC001','BC001','CQ001','2025-04-02	','2026-04-03',	1),
	('LK002',N'Linh Kiện Panasonic','DC002','BC002','CQ002','2025-02-03	','2026-02-03',	1),
	('LK003',N'Linh Kiện Toshiba ','DC003','BC003','CQ003','2025-01-01	','2026-01-01',	1),
	('LK004',N'Linh Kiện Senko','DC004','BC004','CQ004','2025-07-03	','2025-07-03',	1)

INSERT INTO SanPhamChiTiet
VALUES 
	('SPCT001','LK001','MS001','KM001','SP001','L001','30','30m2 - 40m2','10',20,'Senko', 200000,1),
	('SPCT002','LK002','MS002','KM002','SP002','L002','20','30m2 - 40m2','10',15,'Toshiba',250000,1),
	('SPCT003','LK003','MS003','KM003','SP003','L003','50','30m2 - 40m2','10',30,'Kangaroo' ,300000,1),
	('SPCT004','LK004','MS004','KM004','SP004','L004','60','30m2 - 40m2','10',40,'Panasonic',400000,1)




select * from CanhQuat
select * from DongCo
select * from HoaDon
select * from HoaDonChiTiet
select * from KhachHang
select * from KhuyenMai
select * from LinhKien
select * from Login
select * from MauSac
select * from BinhChua
select * from NhanVien
select * from PhanLoai
select * from SanPham
select * from SanPhamChiTiet
select * from Voucher

