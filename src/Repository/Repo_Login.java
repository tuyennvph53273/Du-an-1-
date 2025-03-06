package Repository;

import Model.Model_login;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repo_Login {

    public boolean checkCredential(String username, String password) {
        String sql = "SELECT Username , Password FROM Login WHERE Username = ? AND Password = ?";
        try (Connection con = DB_conect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Model_login> getAllL() {
        ArrayList<Model_login> list = new ArrayList();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select IDLogin , Username , Password  from Login");
            while (rs.next()) {
                Model_login ql = new Model_login();
                ql.setID(rs.getString(1));
                ql.setUsername(rs.getString(2));
                ql.setPasword(rs.getString(3));
                list.add(ql);
            }
        } catch (SQLException ex) {

        }
        return list;

    }

    public Integer addInfoL(Model_login nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO Login
                     VALUES 
                     	(?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getID());
            ptsm.setString(2, nv.getUsername());
            ptsm.setString(3, nv.getPasword());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoL(Model_login nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     	DELETE FROM HoaDonChiTiet
                        where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet
                        WHERE IDHoadon=(SELECT IDHoaDon FROM HoaDon
                        WHERE IDNhanvien =(SELECT IDNhanvien FROM NhanVien
                        					where IDLogin = ?)))
                        DELETE FROM HoaDon
                        WHERE IDHoadon = (SELECT IDHoaDon FROM HoaDon
                        WHERE IDNhanvien =(SELECT IDNhanvien FROM NhanVien
                        					where IDLogin = ?))
                        DELETE FROM NhanVien
                        where IDNhanvien=(SELECT IDNhanvien FROM NhanVien
                        					where IDLogin =?)
                        DELETE FROM Login
                        WHERE IDLogin = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getID());
            ptsm.setString(2, nv.getID());
            ptsm.setString(3, nv.getID());
            ptsm.setString(4, nv.getID());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }

    public Integer editInfoL(Model_login nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     update Login
                     set Username = ? , Password = ? 
                     where IDLogin = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getUsername());
            ptsm.setString(2, nv.getPasword());
            ptsm.setString(3, nv.getID());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
// tìm kiếm

    public ArrayList<Model_login> getAllSearchL(String tuKhoa) {
        ArrayList<Model_login> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from Login\n"
                    + "where IDLogin like '%" + tuKhoa + "%'");
            while (rs.next()) {
                Model_login ql = new Model_login();
                ql.setID(rs.getString(1));
                ql.setUsername(rs.getString(2));
                ql.setPasword(rs.getString(3));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}
