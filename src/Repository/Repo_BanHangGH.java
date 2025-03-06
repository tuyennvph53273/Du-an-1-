package Repository;

import Model.Model_BanHangGH;
import Model.Model_BanHangHD;
import Model.Model_BanHangSP;
import Model.Model_khachHang;
import java.sql.*;
import java.util.ArrayList;

public class Repo_BanHangGH {
    
    public ArrayList<Model_BanHangGH> getAllBanHangGH(String idHoaDon) {
        ArrayList<Model_BanHangGH> list = new ArrayList<>();
        String sql = """
                   SELECT 
                          spct.IDSanPhamCT,
                         sp.TenSanpham,
                         SUM(hdct.Soluong) AS TongSoLuong,
                         SUM(spct.Giaban * hdct.Soluong) AS TongGia
                     FROM
                         HoaDonChiTiet hdct
                     INNER JOIN SanPhamChiTiet spct ON spct.IDSanPhamCT = hdct.IDSanPhamCT
                     INNER JOIN SanPham sp ON sp.IDSanpham = spct.IDSanpham
                     WHERE
                         hdct.IDHoadon = ?
                     GROUP BY
                          spct.IDSanPhamCT,
                         sp.TenSanpham;
                     """;
        try (Connection con = DB_conect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<Model_BanHangGH> allBanHangGH = new ArrayList<>();
            ps.setString(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Model_BanHangGH ms = new Model_BanHangGH();
                ms.setIDSanPhamCT(rs.getString(1));
                ms.setTenSanPhamCT(rs.getString(2));
                ms.setSoLuongSPGH(rs.getInt(3));
                ms.setGiaBan(rs.getInt(4));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }
        return list;
    }

    public ArrayList<Model_BanHangGH> getAllBanHangGHSP(String idHoaDon) {
        ArrayList<Model_BanHangGH> list = new ArrayList<>();
        try {
            PreparedStatement ps = DB_conect
                    .getConnection()
                    .prepareStatement("""
                    SELECT 
                            spct.IDSanPhamCT,
                           sp.TenSanpham,
                           SUM(hdct.Soluong) AS TongSoLuong,
                           SUM(spct.Giaban * hdct.Soluong) AS TongGia
                       FROM
                           HoaDonChiTiet hdct
                       INNER JOIN SanPhamChiTiet spct ON spct.IDSanPhamCT = hdct.IDSanPhamCT
                       INNER JOIN SanPham sp ON sp.IDSanpham = spct.IDSanpham
                       WHERE
                           hdct.IDHoadon = ?
                       GROUP BY
                            spct.IDSanPhamCT,
                           sp.TenSanpham;
                    """);
            ps.setString(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Model_BanHangGH ms = new Model_BanHangGH();
                ms.setIDSanPhamCT(rs.getString(1));
                ms.setTenSanPhamCT(rs.getString(2));
                ms.setSoLuongSPGH(rs.getInt(3));
                ms.setGiaBan(rs.getInt(4));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }
        return list;
    }
    public Integer addInfoKH(Model_khachHang nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO KhachHang
                         (IDKhachhang,Tenkhachhang,SDT)
                                             VALUES 
                                             	(?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaKH());
            ptsm.setString(2, nv.getTenKH());
            ptsm.setInt(3, nv.getSDT());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
    public Integer DeleteInfoGH(String idSPCT , String idHoaDon ,Integer soLuongTonKhoMoi) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                    delete HoaDonChiTiet 
                    where IDSanPhamCT = ?  AND IDHoadon = ?                  
                    update SanPhamChiTiet
                    set SoLuong  = ? 
                    where IDSanPhamCT = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, idSPCT);
            ptsm.setString(2, idHoaDon);
            ptsm.setInt(3, soLuongTonKhoMoi);
            ptsm.setString(4, idSPCT);
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
    public static String taoIDHoaDonCT(Connection connection) throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(IDHoaDonCT, 5 , 4) AS nvarchar )) FROM HoaDonChiTiet";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        int maxId = 0;
        if (resultSet.next()) {
            maxId = resultSet.getInt(1);
        }

        String newId = "HDCT" + String.format("%03d", maxId + 1);

        return newId;
    }


}
