package Repository;

import Model.Model_CanhQuat;
import Model.Model_linhKien;
import Model.Model_sanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repo_canhQuat {

    public ArrayList<Model_CanhQuat> getAllCQ() {
        ArrayList<Model_CanhQuat> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from CanhQuat");
            while (rs.next()) {
                Model_CanhQuat ql = new Model_CanhQuat();
                ql.setIDCanhQuat(rs.getString(1));
                ql.setTenCanhQuat(rs.getString(2));
                ql.setHangCQ(rs.getString(3));
                ql.setNgaySXCQ(rs.getString(4));
                ql.setCongXCQ(rs.getInt(5));
                ql.setChatLieuCQ(rs.getString(6));
                ql.setTrangThaiCQ(rs.getBoolean(7));
                list.add(ql);
            }
        } catch (SQLException ex) {

        }
        return list;
    }
    public Integer addInfoCQ(Model_CanhQuat nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO CanhQuat
                     VALUES 
                     	(?,?,?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDCanhQuat());
            ptsm.setString(2, nv.getTenCanhQuat());
            ptsm.setString(3, nv.getHangCQ());
            ptsm.setString(4, nv.getNgaySXCQ());
            ptsm.setInt(5, nv.getCongXCQ());
            ptsm.setString(6, nv.getChatLieuCQ());
            ptsm.setBoolean(7, nv.getTrangThaiCQ());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoCQ(Model_CanhQuat nv ) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "DELETE FROM HoaDonChiTiet\n" +
"where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet\n" +
"WHERE IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n" +
"					where IDLinhkien = (select IDLinhkien from LinhKien\n" +
"					where IDCanhQuat =?)))\n" +
"DELETE FROM SanPhamChiTiet\n" +
"where IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n" +
"					where IDLinhkien = (select IDLinhkien from LinhKien\n" +
"					where IDCanhQuat =?) )\n" +
"delete from LinhKien\n" +
"where IDLinhkien = (select IDLinhkien from LinhKien\n" +
"					where IDCanhQuat =?)\n" +
"\n" +
"delete from CanhQuat\n" +
"where IDCanhQuat =?";

        try {
            Model_sanPham sp = new Model_sanPham();
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDCanhQuat());
            ptsm.setString(2, nv.getIDCanhQuat());
            ptsm.setString(3, nv.getIDCanhQuat());
            ptsm.setString(4, nv.getIDCanhQuat());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
      
        return row;
    }

    public Integer editInfoCQ(Model_CanhQuat nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "Update CanhQuat\n"
                + "Set TenCQ = ? ,  HangCQ = ?, NgaySanXuat = ?, CongSuat = ?, Chatlieu = ?, TrangThai = ? \n"
                + "Where IDCanhQuat = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getTenCanhQuat());
            ptsm.setString(2, nv.getHangCQ());
            ptsm.setString(3, nv.getNgaySXCQ());
            ptsm.setInt(4, nv.getCongXCQ());
            ptsm.setString(5, nv.getChatLieuCQ());
            ptsm.setString(7, nv.getIDCanhQuat());
            ptsm.setBoolean(6, nv.getTrangThaiCQ());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
    public ArrayList<Model_CanhQuat> getAllSearchCQ(String tuKhoa3) {
        ArrayList<Model_CanhQuat> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from CanhQuat\n"
                    + "where IDCanhQuat  like '%" + tuKhoa3 + "%'");
            while (rs.next()) {
                Model_CanhQuat ql = new Model_CanhQuat();
                ql.setIDCanhQuat(rs.getString(1));
                ql.setTenCanhQuat(rs.getString(2));
                ql.setHangCQ(rs.getString(3));
                ql.setNgaySXCQ(rs.getString(4));
                ql.setCongXCQ(rs.getInt(5));
                ql.setChatLieuCQ(rs.getString(6));
                ql.setTrangThaiCQ(rs.getBoolean(7));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}
