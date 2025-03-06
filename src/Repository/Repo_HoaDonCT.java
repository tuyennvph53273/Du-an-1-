package Repository;

import Model.Model_HoaDonCT;
import Model.Model_hoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Repo_HoaDonCT {
    
    public ArrayList<Model_HoaDonCT> getAllHDCT() {
        ArrayList<Model_HoaDonCT> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
             select IDHoaDonCT , IDSanPhamCT , IDHoadon , Soluong, Dongia , TrangThai  from HoaDonChiTiet""");
            while (rs.next()) {
                Model_HoaDonCT ms = new Model_HoaDonCT();
                ms.setIDHoaDonCT(rs.getString(1));
                ms.setIDSanPhamCT(rs.getString(2));
                ms.setIDHoaDon(rs.getString(3));
                ms.setSoLuong(rs.getInt(4));
                ms.setDonGia(rs.getInt(5));
                ms.setTrangThaiHDCT(rs.getBoolean(6));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
    
//    public static void main(String[] args) {
//        ArrayList<Model_hoaDon> list = new ArrayList<>();
//        try {
//            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
//             select IDHoadon , IDKhachhang, IDNhanvien,IDVoucher,NgayMuaHang,Tonggia,TrangThai from HoaDon""");
//            while (rs.next()) {
//                Model_hoaDon ms = new Model_hoaDon();
//                ms.setIDHoaDon(rs.getString(1));
//                ms.setIDKhachHang(rs.getString(2));
//                ms.setIDNhanVien(rs.getString(3));
//                ms.setIDVoucher(rs.getString(4));
//                ms.setNgayMuaHang(rs.getString(5));
//                ms.setTongGia(rs.getInt(6));
//                ms.setTrangThaiHD(rs.getBoolean(7));
//                list.add(ms);
//            }
//        } catch (SQLException ex) {
//        }
//        for (Model_hoaDon mn : list) {
//            System.out.println(mn.toString());
//        }
//    }

    public Integer addInfoHDCT(Model_HoaDonCT nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO HoaDonChiTiet
                                (IDHoaDonCT , IDSanPhamCT , IDHoadon , Soluong, Dongia , TrangThai)
                                VALUES
                                	(?,?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDHoaDonCT());
            ptsm.setString(2, nv.getIDSanPhamCT());
            ptsm.setString(3, nv.getIDHoaDon());
            ptsm.setInt(4, nv.getSoLuong());
            ptsm.setInt(5, nv.getDonGia());
            ptsm.setBoolean(6, nv.getTrangThaiHDCT());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer editInfoHDCT(Model_HoaDonCT nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                    update HoaDonChiTiet 
                     set   IDSanPhamCT = ?  , IDHoadon = ? , Soluong = ? , Dongia = ? , TrangThai = ? 
                     where IDHoaDonCT = ? """;
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(6, nv.getIDHoaDonCT());
            ptsm.setString(1, nv.getIDSanPhamCT());
            ptsm.setString(2, nv.getIDHoaDon());
            ptsm.setInt(3, nv.getSoLuong());
            ptsm.setInt(4, nv.getDonGia());
            ptsm.setBoolean(5, nv.getTrangThaiHDCT());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoHDCT(Model_HoaDonCT nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     DELETE FROM HoaDonChiTiet
                                     WHERE IDHoaDonCT = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getIDHoaDonCT());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
}
