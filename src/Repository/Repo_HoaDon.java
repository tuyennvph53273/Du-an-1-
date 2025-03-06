package Repository;

import Model.Model_hoaDon;
import java.sql.*;
import java.util.ArrayList;

public class Repo_HoaDon {

    public ArrayList<Model_hoaDon> getAllHD() {
        ArrayList<Model_hoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
             select IDHoadon , IDKhachhang, IDNhanvien,IDVoucher,NgayMuaHang,Tonggia,TrangThai from HoaDon""");
            while (rs.next()) {
                Model_hoaDon ms = new Model_hoaDon();
                ms.setIDHoaDon(rs.getString(1));
                ms.setIDKhachHang(rs.getString(2));
                ms.setIDNhanVien(rs.getString(3));
                ms.setIDVoucher(rs.getString(4));
                ms.setNgayMuaHang(rs.getString(5));
                ms.setTongGia(rs.getInt(6));
                ms.setTrangThaiHD(rs.getBoolean(7));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
    
//    public static void main(String[] args) {
//        ArrayList<Model_hoaDon> list = new ArrayList<>();
//        try {
//            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
//             select IDHoadon , IDKhachhang, IDNhanvien,IDVoucher,NgayMuaHang,Tonggia,TrangThai from HoaDon""");
//            while (rs.next()) {
//                Model_hoaDon ms = new Model_hoaDon();
//                ms.setIDHoaDon(rs.getString(1));
//                ms.setIDKhachHang(rs.getString(2));
//                ms.setIDNhanVien(rs.getString(3));
//                ms.setIDVoucher(rs.getString(4));
//                ms.setNgayMuaHang(rs.getString(5));
//                ms.setTongGia(rs.getInt(6));
//                ms.setTrangThaiHD(rs.getBoolean(7));
//                list.add(ms);
//            }
//        } catch (SQLException ex) {
//        }
//        for (Model_hoaDon mn : list) {
//            System.out.println(mn.toString());
//        }
//    }

    public Integer addInfoHD(Model_hoaDon nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO HoaDon
                             (IDHoadon , IDKhachhang, IDNhanvien,IDVoucher,NgayMuaHang,Tonggia,TrangThai)
                             VALUES 
                             	(?,?,?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDHoaDon());
            ptsm.setString(2, nv.getIDKhachHang());
            ptsm.setString(3, nv.getIDNhanVien());
            ptsm.setString(4, nv.getIDVoucher());
            ptsm.setString(5, nv.getNgayMuaHang());
            ptsm.setInt(6, nv.getTongGia());
            ptsm.setBoolean(7, nv.getTrangThaiHD());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer editInfoHD(Model_hoaDon nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                    update HoaDon 
                     set  IDKhachhang = ? , IDNhanvien = ? ,IDVoucher = ? ,NgayMuaHang = ? ,Tonggia = ? ,TrangThai = ? 
                     where IDHoadon = ? """;
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(7, nv.getIDHoaDon());
            ptsm.setString(1, nv.getIDKhachHang());
            ptsm.setString(2, nv.getIDNhanVien());
            ptsm.setString(3, nv.getIDVoucher());
            ptsm.setString(4, nv.getNgayMuaHang());
            ptsm.setInt(5, nv.getTongGia());
            ptsm.setBoolean(6, nv.getTrangThaiHD());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoHD(Model_hoaDon nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     DELETE FROM HoaDonChiTiet
                                     WHERE IDHoaDonCT = (SELECT IDHOADONCT FROM HoaDonChiTiet
                                     WHERE IDHoadon = ?)
                                     delete from HoaDon 
                                     where IDHoadon = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDHoaDon());
            ptsm.setString(2, nv.getIDHoaDon());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
}
