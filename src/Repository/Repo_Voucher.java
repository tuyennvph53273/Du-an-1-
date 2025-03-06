package Repository;

import Model.Model_KhuyenMai;
import Model.Model_Voucher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repo_Voucher {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    // hiển thị 
    public ArrayList<Model_Voucher> getAllVC() {
        ArrayList<Model_Voucher> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
                                                                                    select IDVoucher , PhanTramGiamGia , NgayBatDau , NgayKetThuc , TrangThai from Voucher""");
            while (rs.next()) {
                Model_Voucher ql = new Model_Voucher();
                ql.setIDvoucher(rs.getString(1));
                ql.setPhanTramGiamGIa(rs.getInt(2));
                ql.setNgayStart(rs.getString(3));
                ql.setNgayEnd(rs.getString(4));
                ql.setTrangThaiVC(rs.getBoolean(5));
                list.add(ql);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public Integer addInfoVC(Model_Voucher nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO Voucher
                     VALUES 
                     	(?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDvoucher());
            ptsm.setInt(2, nv.getPhanTramGiamGIa());
            ptsm.setString(3, nv.getNgayStart());
            ptsm.setString(4, nv.getNgayEnd());
            ptsm.setBoolean(5, nv.getTrangThaiVC());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoVC(Model_Voucher nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     	 where IDHoaDonCT=(SELECT IDHoaDonCT FROM HoaDonChiTiet
                                          WHERE IDHoadon=(SELECT IDHoadon FROM HoaDon
                                          					where IDVoucher = ? ))
                                          DELETE FROM HoaDon
                                          where IDHoadon=(SELECT IDHoadon FROM HoaDon
                                          					where IDVoucher = ?)
                                          DELETE FROM Voucher
                                          WHERE IDVoucher = ? """;
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDvoucher());
            ptsm.setString(2, nv.getIDvoucher());
            ptsm.setString(3, nv.getIDvoucher());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }

    public Integer editInfoVC(Model_Voucher nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                    update Voucher 
                     set PhanTramGiamGia = ? , NgayBatDau = ? , NgayKetThuc = ?  , TrangThai = ? 
                     where IDVoucher = ? """;
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setInt(1, nv.getPhanTramGiamGIa());
            ptsm.setString(2, nv.getNgayStart());
            ptsm.setString(3, nv.getNgayEnd());
            ptsm.setBoolean(4, nv.getTrangThaiVC());
            ptsm.setString(5, nv.getIDvoucher());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
// tìm kiếm

    public ArrayList<Model_Voucher> getAllSearchVC(String tuKhoa) {
        ArrayList<Model_Voucher> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from VouCher\n"
                    + "where IDVoucher like '%" + tuKhoa + "%'");
            while (rs.next()) {
                Model_Voucher ql = new Model_Voucher();
                ql.setIDvoucher(rs.getString(1));
                ql.setPhanTramGiamGIa(rs.getInt(2));
                ql.setNgayStart(rs.getString(3));
                ql.setNgayEnd(rs.getString(4));
                ql.setTrangThaiVC(rs.getBoolean(5));
                list.add(ql);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}
