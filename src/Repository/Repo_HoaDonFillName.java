package Repository;

import Model.Model_HoaDonFillName;
import java.sql.*;
import java.util.ArrayList;

public class Repo_HoaDonFillName {

    public ArrayList<Model_HoaDonFillName> getAllHDFillName() {
        ArrayList<Model_HoaDonFillName> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
             select hd.IDHoadon , kh.Tenkhachhang , nv.Tennhanvien,vc.IDVoucher , hd.NgayMuaHang , hd.Tonggia , hd.TrangThai from HoaDon hd
                          left join KhachHang kh on  hd.IDKhachhang = kh.IDKhachhang
                          left join NhanVien nv on  hd.IDNhanvien = nv.IDNhanvien
                          left join Voucher vc on  hd.IDVoucher = vc.IDVoucher
                          group by hd.IDHoadon , kh.Tenkhachhang , nv.Tennhanvien ,vc.IDVoucher, hd.NgayMuaHang , hd.Tonggia , hd.TrangThai
             """);
            while (rs.next()) {
                Model_HoaDonFillName ms = new Model_HoaDonFillName();
                ms.setIDHoaDon(rs.getString(1));
                ms.setTenKhachHang(rs.getString(2));
                ms.setTenNhanVien(rs.getString(3));
                ms.setIDVoucher(rs.getString(4));
                ms.setNgayMuaHang(rs.getString(5));
                ms.setTongGia(rs.getInt(6));
                ms.setTrangThaiHD(rs.getBoolean(7));
                list.add(ms);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public ArrayList<Model_HoaDonFillName> getSearchHD(String tuKhoa) {
        ArrayList<Model_HoaDonFillName> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select hd.IDHoadon , kh.Tenkhachhang , nv.Tennhanvien,vc.IDVoucher , hd.NgayMuaHang , hd.Tonggia , hd.TrangThai from HoaDon hd\n"
                    + "                                                                                    inner join KhachHang kh on  hd.IDKhachhang = kh.IDKhachhang\n"
                    + "                                                                                    inner join NhanVien nv on  hd.IDNhanvien = nv.IDNhanvien\n"
                    + "                                                                                    inner join Voucher vc on  hd.IDVoucher = vc.IDVoucher\n"
                    + "                                                                                    where  IDHoaDon like '%" + tuKhoa + "%'\n"
                    + "                                                                                    group by hd.IDHoadon , kh.Tenkhachhang , nv.Tennhanvien ,vc.IDVoucher, hd.NgayMuaHang , hd.Tonggia , hd.TrangThai");
            while (rs.next()) {
                Model_HoaDonFillName ms = new Model_HoaDonFillName();
                ms.setIDHoaDon(rs.getString(1));
                ms.setTenKhachHang(rs.getString(2));
                ms.setTenNhanVien(rs.getString(3));
                ms.setIDVoucher(rs.getString(4));
                ms.setNgayMuaHang(rs.getString(5));
                ms.setTongGia(rs.getInt(6));
                ms.setTrangThaiHD(rs.getBoolean(7));
                list.add(ms);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

//    public static void main(String[] args) {
//        ArrayList<Model_HoaDonFillName> list = new ArrayList<>();
//        try {
//            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
//             select hd.IDHoadon , kh.Tenkhachhang , nv.Tennhanvien,vc.IDVoucher , hd.NgayMuaHang , hd.Tonggia , hd.TrangThai from HoaDon hd
//             inner join KhachHang kh on  hd.IDKhachhang = kh.IDKhachhang
//             inner join NhanVien nv on  hd.IDNhanvien = nv.IDNhanvien
//             inner join Voucher vc on  hd.IDVoucher = vc.IDVoucher
//             group by hd.IDHoadon , kh.Tenkhachhang , nv.Tennhanvien ,vc.IDVoucher, hd.NgayMuaHang , hd.Tonggia , hd.TrangThai
//             """);
//            while (rs.next()) {
//                Model_HoaDonFillName ms = new Model_HoaDonFillName();
//                ms.setIDHoaDon(rs.getString(1));
//                ms.setTenKhachHang(rs.getString(2));
//                ms.setTenNhanVien(rs.getString(3));
//                ms.setIDVoucher(rs.getString(4));
//                ms.setNgayMuaHang(rs.getString(5));
//                ms.setTongGia(rs.getInt(6));
//                ms.setTrangThaiHD(rs.getBoolean(7));
//                list.add(ms);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        for (Model_HoaDonFillName mn : list) {
//            System.out.println(mn.toString());
//
//        }
//    }
}
