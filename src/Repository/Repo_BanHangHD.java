package Repository;

import Model.Model_BanHangHD;
import Model.Model_HoaDonCT;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Repo_BanHangHD {

    public ArrayList<Model_BanHangHD> getAllBanHangHD(String idKH) {
        ArrayList<Model_BanHangHD> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
               select hd.IDHoadon,kh.Tenkhachhang , kh.SDT ,  hd.NgayMuaHang  , Sum(spct.Giaban*hdct.Soluong) as Tonggia   
                                          from HoaDon hd
                                          						left join HoaDonChiTiet hdct on hdct.IDHoaDon = hd.IDHoaDon 
                                          						inner join KhachHang kh  on kh.IDkhachHang = hd.IDKhachHang 
                                          						left join SanPhamChiTiet spct on spct.IDSanPhamCT = hdct.IDSanPhamCT
                                         where hd.TrangThai = 0 
                                         group by  hd.IDHoadon, kh.Tenkhachhang , kh.SDT , hd.NgayMuaHang """);
            while (rs.next()) {
                Model_BanHangHD ms = new Model_BanHangHD();
                ms.setIDHoaDon(rs.getString(1));
                ms.setTenKhachHang(rs.getString(2));
                ms.setSDT(rs.getInt(3));
                ms.setThoiDiemTao(rs.getString(4));
                ms.setTongGia(rs.getInt(5));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }

    public ArrayList<Model_BanHangHD> getAllBanHangHDGH() {
        ArrayList<Model_BanHangHD> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
                select hd.IDHoadon,kh.Tenkhachhang , kh.SDT ,  hd.NgayMuaHang  , Sum(spct.Giaban*hdct.Soluong) as Tonggia   
                                          from HoaDon hd
                                          						left join HoaDonChiTiet hdct on hdct.IDHoaDon = hd.IDHoaDon 
                                          						inner join KhachHang kh  on kh.IDkhachHang = hd.IDKhachHang 
                                          						left join SanPhamChiTiet spct on spct.IDSanPhamCT = hdct.IDSanPhamCT
                                         where hd.TrangThai = 0 
                                         group by  hd.IDHoadon, kh.Tenkhachhang , kh.SDT , hd.NgayMuaHang  """);
            while (rs.next()) {
                Model_BanHangHD ms = new Model_BanHangHD();
                ms.setIDHoaDon(rs.getString(1));
                ms.setTenKhachHang(rs.getString(2));
                ms.setSDT(rs.getInt(3));
                ms.setThoiDiemTao(rs.getString(4));
                ms.setTongGia(rs.getInt(5));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }

    public Integer addInfoBangHangHD(String idKH) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     insert into HoaDon
                                (IDHoadon,IDKhachhang,NgayMuaHang,Tonggia,TrangThai)
                                values 
                                ( ? ,?  , GETDATE() , 0 , 0 )""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, taoIDHoaDon(cn));
            ptsm.setString(2, idKH);
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
    public Integer addInfoBangHangHDNoKH() throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO KhachHang
                                              (IDKhachhang,Tenkhachhang,SDT)
                                                                  VALUES 
                                                                        (?,?,null)
                     insert into HoaDon
                                (IDHoadon,IDKhachhang,NgayMuaHang,Tonggia,TrangThai)
                                values 
                                ( ? ,?  , GETDATE() , 0 , 0 )
                                                                  	""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, taoIDKhachHang(cn));
            ptsm.setString(2, taoNameKhachHang(cn));
            ptsm.setString(3, taoIDHoaDon(cn));
            ptsm.setString(4, taoIDKhachHang(cn));
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return row;
    }

    public Integer delereInfoBangHangHD(String idHoaDon) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     delete from HoaDonChiTiet
                     where IDHoadon = ?
                     delete from HoaDon
                     where IDHoadon = ? """;
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, idHoaDon);
            ptsm.setString(2, idHoaDon);
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
    public Integer ThanhToan(String idHoaDon) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     update HoaDon 
                     set TrangThai = 1
                     where IDHoaDon = ? """;
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, idHoaDon);
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public static String taoIDHoaDon(Connection connection) throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(IDHoaDon, 3 , 4) AS nvarchar )) FROM HoaDon";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        int maxId = 0;
        if (resultSet.next()) {
            maxId = resultSet.getInt(1);
        }
        String newId = "HD" + String.format("%03d", maxId + 1);

        return newId;
    }
    public static String taoIDKhachHang(Connection connection) throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(IDKhachhang, 3 , 4) AS nvarchar )) FROM KhachHang";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        int maxId = 0;
        if (resultSet.next()) {
            maxId = resultSet.getInt(1);
        }
        String newId = "KH" + String.format("%03d", maxId + 1);

        return newId;
    }
    public static String taoNameKhachHang(Connection connection) throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(IDKhachhang, 3 , 4) AS nvarchar )) FROM KhachHang";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        int maxId = 0;
        if (resultSet.next()) {
            maxId = resultSet.getInt(1);
        }
        String newId = "KH" + String.format("%03d", maxId + 1)+" "+ "Khách Ẩn Danh ";

        return newId;
    }

}
