package Repository;

import Model.Model_MauSac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repo_MauSac {

    public ArrayList<Model_MauSac> getAllM() {
        ArrayList<Model_MauSac> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from MauSac");
            while (rs.next()) {
                Model_MauSac ql = new Model_MauSac();
                ql.setIDMauSac(rs.getString(1));
                ql.setTenMau(rs.getString(2));
                ql.setDoDam(rs.getString(3));
                ql.setTrangThaiM(rs.getBoolean(4));
                list.add(ql);
            }
        } catch (SQLException ex) {

        }
        return list;
    }
    public Integer addInfoM(Model_MauSac nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO MauSac
                     VALUES 
                     	(?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDMauSac());
            ptsm.setString(2, nv.getTenMau());
            ptsm.setString(3, nv.getDoDam());
            ptsm.setBoolean(4, nv.getTrangThaiM());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer editInfoM(Model_MauSac nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "Update MauSac \n"
                + "Set Tenmau = ?, Dodam = ?, TrangThai = ? \n"
                + "Where IDMausac = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getTenMau());
            ptsm.setString(2, nv.getDoDam());
            ptsm.setBoolean(3, nv.getTrangThaiM());
            ptsm.setString(4, nv.getIDMauSac());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
    public Integer deleteInfoM(Model_MauSac nv ) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "DELETE FROM HoaDonChiTiet\n" +
"where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet\n" +
"WHERE IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n" +
"					where IDMausac=? ))\n" +
"DELETE FROM SanPhamChiTiet\n" +
"where IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n" +
"					where IDMausac=? )\n" +
"DELETE FROM MauSac\n" +
"WHERE IDMausac =?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDMauSac());
            ptsm.setString(2, nv.getIDMauSac());
            ptsm.setString(3, nv.getIDMauSac());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }
    public ArrayList<Model_MauSac> getAllSearchM(String tuKhoa) {
        ArrayList<Model_MauSac> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from MauSac\n"
                    + "where IDMausac like '%" + tuKhoa + "%'");
            while (rs.next()) {
                Model_MauSac ql = new Model_MauSac();
                ql.setIDMauSac(rs.getString(1));
                ql.setTenMau(rs.getString(2));
                ql.setDoDam(rs.getString(3));
                ql.setTrangThaiM(rs.getBoolean(4));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }

}
