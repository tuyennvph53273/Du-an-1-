/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Model.Model_KhuyenMai;
import Repository.DB_conect;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repo_KhuyenMai {
   Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;  
    
    
    // hiển thị 
     public ArrayList<Model_KhuyenMai> getAllLK(){
     ArrayList<Model_KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select IDKhuyenmai , PhanTramKM , NgayBatDau , NgayKetThuc , TrangThai from KhuyenMai");
            while (rs.next()) {
                Model_KhuyenMai ql = new Model_KhuyenMai();
                ql.setIdKhuyenMai(rs.getString(1));
                ql.setPhanTramkhuyenmai(rs.getInt(2));
                ql.setNgayBatDau(rs.getString(3));
                ql.setNgayKetThuc(rs.getString(4));
                ql.setTrangThaiKM(rs.getBoolean(5));
                list.add(ql);
            }
        } catch (SQLException ex) {

        }
        return list;
     }
    
     
  
     
   public Integer addInfoKM(Model_KhuyenMai nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO KhuyenMai
                     VALUES 
                     	(?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIdKhuyenMai());
            ptsm.setInt(2, nv.getPhanTramkhuyenmai());
            ptsm.setString(3, nv.getNgayBatDau());
            ptsm.setString(4, nv.getNgayKetThuc());
            ptsm.setBoolean(5, nv.getTrangThaiKM());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
    public Integer deleteInfoLK(Model_KhuyenMai nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     	DELETE FROM HoaDonChiTiet
                     where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet
                     WHERE IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet
                     					where IDKhuyenMai = ? ))
                     DELETE FROM SanPhamChiTiet
                     where IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet
                     					where IDKhuyenMai = ?)
                     DELETE FROM KhuyenMai
                     WHERE IDKhuyenMai = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIdKhuyenMai());
            ptsm.setString(2, nv.getIdKhuyenMai());
            ptsm.setString(3, nv.getIdKhuyenMai());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }

    
     public Integer editInfoKM(Model_KhuyenMai nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     update KhuyenMai
                     set PhanTramKM = ? , NgayBatDau = ? , NgayKetThuc = ? , TrangThai = ?
                     where IDKhuyenmai = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setInt(1, nv.getPhanTramkhuyenmai());
            ptsm.setString(2, nv.getNgayBatDau());
            ptsm.setString(3, nv.getNgayKetThuc());
            ptsm.setBoolean(4, nv.getTrangThaiKM());
            ptsm.setString(5, nv.getIdKhuyenMai());          
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
// tìm kiếm
     
     public ArrayList<Model_KhuyenMai> getAllSearchM(String tuKhoa) {
        ArrayList<Model_KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from KhuyenMai\n"
                    + "where IDKhuyenMai like '%" + tuKhoa + "%'");
            while (rs.next()) {
                Model_KhuyenMai ql = new Model_KhuyenMai();
                ql.setIdKhuyenMai(rs.getString(1));
                ql.setPhanTramkhuyenmai(rs.getInt(2));
                ql.setNgayBatDau(rs.getString(3));
                ql.setNgayKetThuc(rs.getString(4));
                ql.setTrangThaiKM(rs.getBoolean(5));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}


    