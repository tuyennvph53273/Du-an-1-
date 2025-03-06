package Repository;

import Model.Model_linhKien;
import Model.Model_phanLoai;
import Model.Model_sanPham;
import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gigabyte
 */
public class Repo_PhanLoai {
    public ArrayList<Model_phanLoai> getAllPL() {
        ArrayList<Model_phanLoai> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from PhanLoai");
            while (rs.next()) {
                Model_phanLoai ql = new Model_phanLoai();
                ql.setIDPhanLoai(rs.getString(1));
                ql.setKieuDang(rs.getString(2));
                ql.setSize(rs.getString(3));
                ql.setTrangThaiPL(rs.getBoolean(4));
                list.add(ql);
            }
        } catch (SQLException ex) {
            
        }
        return list;
    }
    public ArrayList<Model_phanLoai> getAllPLSPCT() {
        ArrayList<Model_phanLoai> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
                                                                                    select * from PhanLoai
                                                                                    where TrangThai = 1""");
            while (rs.next()) {
                Model_phanLoai ql = new Model_phanLoai();
                ql.setIDPhanLoai(rs.getString(1));
                ql.setKieuDang(rs.getString(2));
                ql.setSize(rs.getString(3));
                ql.setTrangThaiPL(rs.getBoolean(4));
                list.add(ql);
            }
        } catch (SQLException ex) {
            
        }
        return list;
    }
    public Integer addInfoPL(Model_phanLoai nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO PhanLoai
                     VALUES 
                     	(?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDPhanLoai());
            ptsm.setString(2, nv.getKieuDang());
            ptsm.setString(3, nv.getSize());
            ptsm.setBoolean(4, nv.getTrangThaiPL());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoPL(Model_phanLoai nv ) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "DELETE FROM HoaDonChiTiet \n" +
"where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet\n" +
"WHERE IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n" +
"					where IDLoai =? ))\n" +
"DELETE FROM SanPhamChiTiet\n" +
"where IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n" +
"					where IDLoai =?)\n" +
"DELETE FROM PhanLoai\n" +
"WHERE IDLoai =?";     

        try {
            PreparedStatement ptsm1 = cn.prepareStatement(sql);
            ptsm1.setString(1, nv.getIDPhanLoai());
            ptsm1.setString(2, nv.getIDPhanLoai());
            ptsm1.setString(3, nv.getIDPhanLoai());
            row = ptsm1.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }

        return row;
    }

    public Integer editInfoPL(Model_phanLoai nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "update PhanLoai\n" +
"set Kieudang = ?,Size = ?,TrangThai=?\n" +
"where IDLoai=?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(4, nv.getIDPhanLoai());
            ptsm.setString(1, nv.getKieuDang());
            ptsm.setString(2, nv.getSize());
            ptsm.setBoolean(3, nv.getTrangThaiPL());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
    public ArrayList<Model_phanLoai> getAllSearchPL(String tuKhoa5) {
        ArrayList<Model_phanLoai> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from PhanLoai\n"
                    + "where IDLoai  like '%" + tuKhoa5 + "%'");
            while (rs.next()) {
                Model_phanLoai ql = new Model_phanLoai();
                ql.setIDPhanLoai(rs.getString(1));
                ql.setKieuDang(rs.getString(2));
                ql.setSize(rs.getString(3));
                ql.setTrangThaiPL(rs.getBoolean(4));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}
