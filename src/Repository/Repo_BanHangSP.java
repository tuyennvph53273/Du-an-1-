package Repository;

import Model.Model_BanHangGH;
import Model.Model_BanHangHD;
import Model.Model_BanHangSP;
import static Repository.Repo_BanHangGH.taoIDHoaDonCT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repo_BanHangSP {

    public ArrayList<Model_BanHangSP> getAllBanHangSP() {
        ArrayList<Model_BanHangSP> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
            select spct.IDSanPhamCT  , sp.TenSanpham ,ms.Tenmau , pl.Kieudang , spct.Soluong , spct.Giaban 
             from SanPhamChiTiet spct 
             inner join SanPham sp on sp.IDSanpham = spct.IDSanpham
             inner join MauSac ms on ms.IDMausac = spct.IDMausac
             inner join PhanLoai pl on pl.IDLoai = spct.IDLoai
             where sp.TrangThai = 1 AND spct.Soluong > 0
             group by spct.IDSanPhamCT  , sp.TenSanpham ,ms.Tenmau , pl.Kieudang , spct.Soluong , spct.Giaban """);
            while (rs.next()) {
                Model_BanHangSP ms = new Model_BanHangSP();
                ms.setIDSanPhamCT(rs.getString(1));
                ms.setTenSanPhamCT(rs.getString(2));
                ms.setMauSac(rs.getString(3));
                ms.setLoai(rs.getString(4)); 
                ms.setSoLuongTon(rs.getInt(5));
                ms.setGiaBan(rs.getInt(6));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
    public ArrayList<Model_BanHangSP> getAllBanHangSPSearch(String tuKhoa) {
        ArrayList<Model_BanHangSP> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select spct.IDSanPhamCT , sp.TenSanpham ,ms.Tenmau , pl.Kieudang , spct.Soluong , spct.Giaban \n" +
"from SanPhamChiTiet spct \n" +
"inner join SanPham sp on sp.IDSanpham = spct.IDSanpham\n" +
"inner join MauSac ms on ms.IDMausac = spct.IDMausac\n" +
"inner join PhanLoai pl on pl.IDLoai = spct.IDLoai\n" +
"where sp.TrangThai = 1  AND spct.Soluong > 0 AND spct.IDSanPhamCT Like '%"+tuKhoa+"%'\n" +
"group by spct.IDSanPhamCT , sp.TenSanpham ,ms.Tenmau , pl.Kieudang , spct.Soluong , spct.Giaban ");
            while (rs.next()) {
                Model_BanHangSP ms = new Model_BanHangSP();
                ms.setIDSanPhamCT(rs.getString(1));
                ms.setTenSanPhamCT(rs.getString(2));
                ms.setMauSac(rs.getString(3));
                ms.setLoai(rs.getString(4)); 
                ms.setSoLuongTon(rs.getInt(5));
                ms.setGiaBan(rs.getInt(6));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
    
  public Integer AddBHSP( String idHoaDon , String idSPCT, Integer soLuong,Integer giaBan,Integer soLuongConLai ) {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                   insert into HoaDonChiTiet
                     (IDHoaDonCT,IDHoadon , IDSanPhamCT,Soluong,Dongia )
                     values 
                     ( ?,?,?,?,?)
                     update SanPhamChiTiet
                     set SoLuong  = ? 
                     where IDSanPhamCT = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, taoIDHoaDonCT(cn));
            ptsm.setString(2, idHoaDon);
            ptsm.setString(3, idSPCT);
            ptsm.setInt(4, soLuong);
            ptsm.setInt(5, giaBan);
            ptsm.setInt(6, soLuongConLai);
            ptsm.setString(7, idSPCT);
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
//  public Integer UpdateBHSP( String idHoaDon , String idSPCT, Integer soLuong,Integer giaBan,Integer soLuongConMoi ) {
//        Integer row = null;
//        Connection cn = DB_conect.getConnection();
//        String sql = """
//                   insert into HoaDonChiTiet
//                     (IDHoaDonCT,IDHoadon , IDSanPhamCT,Soluong,Dongia )
//                     values 
//                     ( ?,?,?,?,?)
//                     update SanPhamChiTiet
//                     set SoLuong  = ? 
//                     where IDSanPhamCT = ?""";
//        try {
//            PreparedStatement ptsm = cn.prepareStatement(sql);
//            ptsm.setString(1, taoIDHoaDonCT(cn));
//            ptsm.setString(2, idHoaDon);
//            ptsm.setString(3, idSPCT);
//            ptsm.setInt(4, soLuong);
//            ptsm.setInt(5, giaBan);
//            ptsm.setInt(6, soLuongConMoi);
//            ptsm.setString(7, idSPCT);
//            row = ptsm.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return row;
//    }
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
