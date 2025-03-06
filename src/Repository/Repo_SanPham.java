package Repository;

import Model.Model_sanPham;
import java.util.ArrayList;
import java.sql.*;
import java.sql.SQLException;

public class Repo_SanPham {

    public ArrayList<Model_sanPham> getAllSP() {
        ArrayList<Model_sanPham> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from SanPham");
            while (rs.next()) {
                Model_sanPham ms = new Model_sanPham();
                ms.setMaSP(rs.getString(1));
                ms.setTenSP(rs.getString(2));
                ms.setTrangThaiSP(rs.getBoolean(3));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }
        return list;
    }
            
   
    

    public Integer addInfoSP(Model_sanPham nv) {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                             INSERT INTO SanPham
                             VALUES 
                             	(?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaSP());
            ptsm.setString(2, nv.getTenSP());
            ptsm.setBoolean(3, nv.getTrangThaiSP());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer editInfoSP(Model_sanPham nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "Update SanPham \n"
                + "Set TenSanpham = ?, TrangThai = ?\n"
                + "Where IDSanpham = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(3, nv.getMaSP());
            ptsm.setString(1, nv.getTenSP());
            ptsm.setBoolean(2, nv.getTrangThaiSP());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoSP(Model_sanPham nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "DELETE FROM HoaDonChiTiet\n" +
"where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet\n" +
"WHERE IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n" +
"					where IDSanpham=?))\n" +
"DELETE FROM SanPhamChiTiet\n" +
"where IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n" +
"					where IDSanpham=?)\n" +
"delete from SanPham\n" +
"where IDSanpham=?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaSP());
            ptsm.setString(2, nv.getMaSP());
            ptsm.setString(3, nv.getMaSP());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }
     public ArrayList<Model_sanPham> getSearchSP(String tuKhoa) {
        ArrayList<Model_sanPham> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from SanPham\n" +
                                                                                    "where IDSanpham like '%"+tuKhoa+"%'");
            while (rs.next()) {
                Model_sanPham ms = new Model_sanPham();
                ms.setMaSP(rs.getString(1));
                ms.setTenSP(rs.getString(2));
                ms.setTrangThaiSP(rs.getBoolean(3));
                list.add(ms);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
      
}

