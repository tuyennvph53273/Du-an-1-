package Repository;

import Model.Model_BinhChua;
import Model.Model_linhKien;
import Model.Model_sanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repo_Binhchua {

    public ArrayList<Model_BinhChua> getAllBC() {
        ArrayList<Model_BinhChua> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from BinhChua");
            while (rs.next()) {
                Model_BinhChua ql = new Model_BinhChua();
                ql.setIDBinhChua(rs.getString(1));
                ql.setTenBinhChua(rs.getString(2));
                ql.setHangBC(rs.getString(3));
                ql.setNgaySXBC(rs.getString(4));
                ql.setDungTichBC(rs.getInt(5));
                ql.setTrangThaiBC(rs.getBoolean(6));
                list.add(ql);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public Integer addInfoBC(Model_BinhChua nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO BinhChua
                     VALUES 
                     	(?,?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDBinhChua());
            ptsm.setString(2, nv.getTenBinhChua());
            ptsm.setString(3, nv.getHangBC());
            ptsm.setString(4, nv.getNgaySXBC());
            ptsm.setInt(5, nv.getDungTichBC());
            ptsm.setBoolean(6, nv.getTrangThaiBC());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoBC(Model_BinhChua nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "DELETE FROM HoaDonChiTiet\n"
                + "where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet\n"
                + "WHERE IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n"
                + "					where IDLinhkien = (select IDLinhkien from LinhKien\n"
                + "					where IDBinhChua =?)))\n"
                + "DELETE FROM SanPhamChiTiet\n"
                + "where IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n"
                + "					where IDLinhkien = (select IDLinhkien from LinhKien\n"
                + "					where IDBinhChua =?) )\n"
                + "delete from LinhKien\n"
                + "where IDLinhkien = (select IDLinhkien from LinhKien\n"
                + "					where IDBinhChua =?)\n"
                + "\n"
                + "delete from BinhChua\n"
                + "where IDBinhChua =?";

        try {
            Model_sanPham sp = new Model_sanPham();
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDBinhChua());
            ptsm.setString(2, nv.getIDBinhChua());
            ptsm.setString(3, nv.getIDBinhChua());
            ptsm.setString(4, nv.getIDBinhChua());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }

    public Integer editInfoBC(Model_BinhChua nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "Update BinhChua\n"
                + "Set TenBC = ? ,HangBC = ?, NgaySanXuat = ?, DungTich = ?, TrangThai = ?\n"
                + "Where IDBinhChua = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getTenBinhChua());
            ptsm.setString(2, nv.getHangBC());
            ptsm.setString(3, nv.getNgaySXBC());
            ptsm.setInt(4, nv.getDungTichBC());
            ptsm.setBoolean(5, nv.getTrangThaiBC());
            ptsm.setString(6, nv.getIDBinhChua());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public ArrayList<Model_BinhChua> getAllSearchBC(String tuKhoa4) {
        ArrayList<Model_BinhChua> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from BinhChua\n"
                    + "where IDBinhChua  like '%" + tuKhoa4 + "%'");
            while (rs.next()) {
                Model_BinhChua ql = new Model_BinhChua();
                ql.setIDBinhChua(rs.getString(1));
                ql.setTenBinhChua(rs.getString(2));
                ql.setHangBC(rs.getString(3));
                ql.setNgaySXBC(rs.getString(4));
                ql.setDungTichBC(rs.getInt(5));
                ql.setTrangThaiBC(rs.getBoolean(6));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}
