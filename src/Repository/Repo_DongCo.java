package Repository;

import Model.Model_DongCo;
import Model.Model_linhKien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repo_DongCo {

    public ArrayList<Model_DongCo> getAllDC() {
        ArrayList<Model_DongCo> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from DongCo");
            while (rs.next()) {
                Model_DongCo ql = new Model_DongCo();
                ql.setIDDongco(rs.getString(1));
                ql.setTenDongco(rs.getString(2));
                ql.setHangDC(rs.getString(3));
                ql.setNgaySXDC(rs.getString(4));
                ql.setCongXDC(rs.getInt(5));
                ql.setChatLieuDC(rs.getString(6));
                ql.setTrangThaiDC(rs.getBoolean(7));
                list.add(ql);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public Integer addInfoDC(Model_DongCo nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "INSERT INTO DongCo\n"
                + "VALUES\n"
                + "	(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDDongco());
            ptsm.setString(2, nv.getTenDongco());
            ptsm.setString(3, nv.getHangDC());
            ptsm.setString(4, nv.getNgaySXDC());
            ptsm.setInt(5, nv.getCongXDC());
            ptsm.setString(6, nv.getChatLieuDC());
            ptsm.setBoolean(7, nv.getTrangThaiDC());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoDC(Model_DongCo nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "DELETE FROM HoaDonChiTiet\n"
                + "where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet\n"
                + "WHERE IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n"
                + "					where IDLinhkien = (select IDLinhkien from LinhKien\n"
                + "					where IDDongCo=?)))\n"
                + "DELETE FROM SanPhamChiTiet\n"
                + "where IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n"
                + "					where IDLinhkien = (select IDLinhkien from LinhKien\n"
                + "					where IDDongCo=?) )\n"
                + "delete from LinhKien\n"
                + "where IDLinhkien = (select IDLinhkien from LinhKien\n"
                + "					where IDDongCo=?)\n"
                + "\n"
                + "delete from DongCo\n"
                + "where IDDongCo =?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDDongco());
            ptsm.setString(2, nv.getIDDongco());
            ptsm.setString(3, nv.getIDDongco());
            ptsm.setString(4, nv.getIDDongco());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }

    public Integer editInfoDC(Model_DongCo nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "update DongCo\n"
                + "Set TenDC = ? ,  HangDC = ?, NgaySanXuat = ?, CongSuat = ?, Chatlieu = ?, TrangThai = ? \n"
                + "Where IDDongCo = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getTenDongco());
            ptsm.setString(2, nv.getHangDC());
            ptsm.setString(3, nv.getNgaySXDC());
            ptsm.setInt(4, nv.getCongXDC());
            ptsm.setString(5, nv.getChatLieuDC());
            ptsm.setString(7, nv.getIDDongco());
            ptsm.setBoolean(6, nv.getTrangThaiDC());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public ArrayList<Model_DongCo> getAllSearchDC(String tuKhoa2) {
        ArrayList<Model_DongCo> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from DongCo\n"
                    + "where IDDongCo  like '%" + tuKhoa2 + "%'");
            while (rs.next()) {
                Model_DongCo ql = new Model_DongCo();
                ql.setIDDongco(rs.getString(1));
                ql.setTenDongco(rs.getString(2));
                ql.setHangDC(rs.getString(3));
                ql.setNgaySXDC(rs.getString(4));
                ql.setCongXDC(rs.getInt(5));
                ql.setChatLieuDC(rs.getString(6));
                ql.setTrangThaiDC(rs.getBoolean(7));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }

}
