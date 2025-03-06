package Repository;

import Model.Model_khachHang;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repo_Khachhang {

    public ArrayList<Model_khachHang> getAllKH() {

        ArrayList<Model_khachHang> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select IDKhachhang,Tenkhachhang,Tuoi,Gioitinh,Diachi ,SDT,TrangThai  from KhachHang");
            while (rs.next()) {                
                Model_khachHang mk = new Model_khachHang();
                mk.setMaKH(rs.getString(1));
                mk.setTenKH(rs.getString(2));
                mk.setTuoiKH(rs.getInt(3));
                mk.setGioiTinhKH(rs.getBoolean(4));
                mk.setDiaChi(rs.getString(5));
                mk.setSDT(rs.getInt(6));
                mk.setTrangThaiKH(rs.getBoolean(7));
                list.add(mk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Repo_Khachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Integer addInfoKH(Model_khachHang nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO KhachHang
                     VALUES 
                     	(?,?,?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaKH());
            ptsm.setString(2, nv.getTenKH());
            ptsm.setInt(3, nv.getTuoiKH());
            ptsm.setBoolean(4, nv.getGioiTinhKH());
            ptsm.setString(5, nv.getDiaChi());
            ptsm.setInt(6, nv.getSDT());
            ptsm.setBoolean(7, nv.getTrangThaiKH());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoKH(Model_khachHang nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     	DELETE FROM HoaDonChiTiet
                        where IDHoaDonCT = (SELECT IDHoaDonCT FROM HoaDonChiTiet
                                            Where IDHoaDon = (SELECT IDHoadon FROM HoaDon
                                            where IDKhachHang=?))
                        DELETE FROM HoaDon
                        where IDHoadon=(SELECT IDHoadon FROM HoaDon
                                            where IDKhachHang=?)
                        DELETE FROM khachHang
                        WHERE IDkhachHang = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaKH());
            ptsm.setString(2, nv.getMaKH());
            ptsm.setString(3, nv.getMaKH());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }

    public Integer editInfoKH(Model_khachHang nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     update KhachHang
                     set  Tenkhachhang = ? ,Tuoi = ? ,Gioitinh = ? ,Diachi = ?  ,SDT = ? ,TrangThai = ?  
                     where IDKhachHang = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getTenKH());
            ptsm.setInt(2, nv.getTuoiKH());
            ptsm.setBoolean(3, nv.getGioiTinhKH());            
            ptsm.setString(4, nv.getDiaChi());
            ptsm.setInt(5, nv.getSDT());
            ptsm.setBoolean(6, nv.getTrangThaiKH());
            ptsm.setString(7, nv.getMaKH());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
// tìm kiếm

 public ArrayList<Model_khachHang> getAllSearchKH(String tuKhoa) {

        ArrayList<Model_khachHang> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from KhachHang\n"
                    + "where IDKhachHang like '%" + tuKhoa + "%'");
            while (rs.next()) {                
                Model_khachHang mk = new Model_khachHang();
                mk.setMaKH(rs.getString(1));
                mk.setTenKH(rs.getString(2));
                mk.setTuoiKH(rs.getInt(3));
                mk.setGioiTinhKH(rs.getBoolean(4));
                mk.setDiaChi(rs.getString(5));
                mk.setSDT(rs.getInt(6));
                mk.setTrangThaiKH(rs.getBoolean(7));
                list.add(mk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Repo_Khachhang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
