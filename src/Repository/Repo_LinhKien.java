package Repository;

import Model.Model_linhKien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repo_LinhKien {

    public ArrayList<Model_linhKien> getAllLK() {
        ArrayList<Model_linhKien> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
                                                                                    select IDLinhkien , TenLinhkien , IDDongCo , IDBinhChua , IDCanhQuat , Ngaybaohanh , Ngayketthucbaohanh , TrangThai from LinhKien """);
            while (rs.next()) {
                Model_linhKien ql = new Model_linhKien();
                ql.setIDLinhKien(rs.getString(1));
                ql.setTenLinhKien(rs.getString(2));
                ql.setDongCo(rs.getString(3));
                ql.setBinhChua(rs.getString(4));
                ql.setCanhQuat(rs.getString(5));
                ql.setNgayStar(rs.getString(6));
                ql.setNgayEnd(rs.getString(7));
                ql.setTrangThaiLK(rs.getBoolean(8));
                list.add(ql);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public Integer addInfoLK(Model_linhKien nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO LinhKien
                     VALUES 
                     	(?,?,?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDLinhKien());
            ptsm.setString(2, nv.getTenLinhKien());
            ptsm.setString(3, nv.getDongCo());
            ptsm.setString(4, nv.getBinhChua());
            ptsm.setString(5, nv.getCanhQuat());
            ptsm.setString(6, nv.getNgayStar());
            ptsm.setString(7, nv.getNgayEnd());
            ptsm.setBoolean(8, nv.getTrangThaiLK());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer editInfoLK(Model_linhKien nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "update LinhKien\n"
                + "set TenLinhKien = ? IDDongCo = ? , IDBinhChua=?,IDCanhQuat=?,Ngaybaohanh=?,Ngayketthucbaohanh=?,TrangThai = ?\n"
                + "where IDLinhkien =?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getTenLinhKien());
            ptsm.setString(2, nv.getDongCo());
            ptsm.setString(3, nv.getBinhChua());
            ptsm.setString(4, nv.getCanhQuat());
            ptsm.setString(5, nv.getNgayStar());
            ptsm.setString(6, nv.getNgayEnd());
            ptsm.setBoolean(7, nv.getTrangThaiLK());
            ptsm.setString(8, nv.getIDLinhKien());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoLK(Model_linhKien nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "DELETE FROM HoaDonChiTiet\n"
                + "where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet\n"
                + "WHERE IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n"
                + "					where IDLinhkien =?))\n"
                + "DELETE FROM SanPhamChiTiet\n"
                + "where IDSanPhamCT=(SELECT IDSanPhamCT FROM SanPhamChiTiet\n"
                + "					where IDLinhkien = ?)\n"
                + "delete from LinhKien\n"
                + "where IDLinhkien = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDLinhKien());
            ptsm.setString(2, nv.getIDLinhKien());
            ptsm.setString(3, nv.getIDLinhKien());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }

    public ArrayList<Model_linhKien> getAllSearchLK(String tuKhoa1) {
        ArrayList<Model_linhKien> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select lk.IDLinhkien , lk.TenLinhkien , dc.TenDC , bc.TenBC , cq.TenCQ , lk.Ngaybaohanh , lk.Ngayketthucbaohanh , lk.TrangThai from LinhKien lk \n"
                    + "left join DongCo dc on dc.IDDongCo = lk.IDDongCo\n"
                    + "left join BinhChua bc on bc.IDBinhChua = lk.IDBinhChua\n"
                    + "left join CanhQuat cq on cq.IDCanhQuat = lk.IDCanhQuat\n"
                    + "where IDLinhkien like '%" + tuKhoa1 + "%'");
            while (rs.next()) {
                Model_linhKien ql = new Model_linhKien();
                ql.setIDLinhKien(rs.getString(1));
                ql.setTenLinhKien(rs.getString(2));
                ql.setDongCo(rs.getString(3));
                ql.setBinhChua(rs.getString(4));
                ql.setCanhQuat(rs.getString(5));
                ql.setNgayStar(rs.getString(6));
                ql.setNgayEnd(rs.getString(7));
                ql.setTrangThaiLK(rs.getBoolean(8));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}
