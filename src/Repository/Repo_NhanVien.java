/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Model_nhanvien;
import Repository.DB_conect;
import View.NhanVien;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Repo_NhanVien {
    DB_conect db = new DB_conect();
    public ArrayList<Model_nhanvien> getAllNV() {
        ArrayList<Model_nhanvien> list = new ArrayList();
        try {
            ResultSet rs = db.getConnection().createStatement().executeQuery("select IDNhanvien , IDLogin , Tennhanvien , Tuoi , Diachi , Gioitinh ,SDT, NgayBatDauLam , TrangThai from NhanVien");
            while (rs.next()) {
                Model_nhanvien ql = new Model_nhanvien();
                ql.setIDNhanVien(rs.getString(1));
                ql.setIDLogin(rs.getString(2));
                ql.setTenNhanVien(rs.getString(3));
                ql.setTuoi(rs.getInt(4));
                ql.setDiachi(rs.getString(5));
                ql.setGioitinh(rs.getBoolean(6));
                ql.setSDT(rs.getInt(7));
                ql.setNgaybatdaulam(rs.getString(8));
                ql.setTrangThaiNV(rs.getBoolean(9));
                list.add(ql);
            }
            
        } catch (SQLException ex) {
            
        }
        return list;

    }

    public Integer addInfoNV(Model_nhanvien nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO NhanVien
                     VALUES 
                     	(?,?,?,?,?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDNhanVien());
            ptsm.setString(2, nv.getIDLogin());
            ptsm.setString(3, nv.getTenNhanVien());
            ptsm.setInt(4, nv.getTuoi());
            ptsm.setString(5, nv.getDiachi());
            ptsm.setBoolean(6, nv.getGioitinh());
            ptsm.setInt(7, nv.getSDT());
            ptsm.setString(8, nv.getNgaybatdaulam());
            ptsm.setBoolean(9, nv.getTrangThaiNV());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoNV(Model_nhanvien nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     	DELETE FROM HoaDonChiTiet
                        where IDHoaDonCT = (SELECT IDHoaDonCT FROM HoaDonChiTiet
                        					Where IDHoaDon = (SELECT IDHoadon FROM HoaDon
                        					where IDNhanvien=?))
                        DELETE FROM HoaDon
                        where IDHoadon=(SELECT IDHoadon FROM HoaDon
                        					where IDNhanvien=?)
                        DELETE FROM NhanVien
                        WHERE IDNhanvien = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDNhanVien());
            ptsm.setString(2, nv.getIDNhanVien());
            ptsm.setString(3, nv.getIDNhanVien());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }

    public Integer editInfoNV(Model_nhanvien nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     update NhanVien
                     set   IDLogin = ? , Tennhanvien = ?, Tuoi = ? , Diachi = ?, Gioitinh =?  ,SDT = ? , NgayBatDauLam =? , TrangThai=?
                     where IDNhanVien = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDLogin());
            ptsm.setString(2, nv.getTenNhanVien());
            ptsm.setInt(3, nv.getTuoi());
            ptsm.setString(4, nv.getDiachi());
            ptsm.setBoolean(5, nv.getGioitinh());
            ptsm.setInt(6, nv.getSDT());
            ptsm.setString(7, nv.getNgaybatdaulam());
            ptsm.setBoolean(8, nv.getTrangThaiNV());
            ptsm.setString( 9, nv.getIDNhanVien());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
// tìm kiếm

    public ArrayList<Model_nhanvien> getAllSearchNV(String tuKhoa) {
        ArrayList<Model_nhanvien> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from Nhanvien\n"
                    + "where IDNhanvien like '%" + tuKhoa + "%'");
            while (rs.next()) {
                Model_nhanvien ql = new Model_nhanvien();
                ql.setIDNhanVien(rs.getString(1));
                ql.setIDLogin(rs.getString(2));
                ql.setTenNhanVien(rs.getString(3));
                ql.setTuoi(rs.getInt(4));
                ql.setDiachi(rs.getString(5));
                ql.setGioitinh(rs.getBoolean(6));
                ql.setSDT(rs.getInt(7));
                ql.setNgaybatdaulam(rs.getString(8));
                ql.setTrangThaiNV(rs.getBoolean(9));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }  
}
