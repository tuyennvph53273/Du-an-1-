package Repository;

import Model.Model_BanHangHD;
import Model.Model_LichSuHD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repo_LichSuHD {

    public ArrayList<Model_LichSuHD> getAllBanHangHD(String idKH) {
        ArrayList<Model_LichSuHD> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
                select hd.IDHoadon,kh.Tenkhachhang , kh.SDT ,   getDate() as ThoiDiemTao  , Sum(spct.Giaban*hdct.Soluong)as Tonggia  , hd.TrangThai 
                                                                                   from HoaDon hd
                                                                                   						left join HoaDonChiTiet hdct on hdct.IDHoaDon = hd.IDHoaDon 
                                                                                   						inner join KhachHang kh  on kh.IDkhachHang = hd.IDKhachHang 
                                                                                   						left join SanPhamChiTiet spct on spct.IDSanPhamCT = hdct.IDSanPhamCT
                                                                                  group by  hd.IDHoadon, kh.Tenkhachhang , kh.SDT ,hd.TrangThai """);
            while (rs.next()) {
                Model_LichSuHD ms = new Model_LichSuHD();
                ms.setIDHoaDon(rs.getString(1));
                ms.setTenKhachHang(rs.getString(2));
                ms.setSDT(rs.getInt(3));
                ms.setThoiDiemTao(rs.getString(4));
                ms.setTongGia(rs.getInt(5));
                ms.setTrangThaiLSHD(rs.getBoolean(6));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }

    public ArrayList<Model_LichSuHD> getAllBanHangHDGH() {
        ArrayList<Model_LichSuHD> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
                select hd.IDHoadon,kh.Tenkhachhang , kh.SDT ,   getDate() as ThoiDiemTao  ,  Sum(spct.Giaban*hdct.Soluong) as Tonggia  , hd.TrangThai 
                                                           from HoaDon hd
                                                           						left join HoaDonChiTiet hdct on hdct.IDHoaDon = hd.IDHoaDon 
                                                           						inner join KhachHang kh  on kh.IDkhachHang = hd.IDKhachHang 
                                                           						left join SanPhamChiTiet spct on spct.IDSanPhamCT = hdct.IDSanPhamCT
                                                          group by  hd.IDHoadon, kh.Tenkhachhang , kh.SDT ,hd.TrangThai """);
            while (rs.next()) {
                Model_LichSuHD ms = new Model_LichSuHD();
                ms.setIDHoaDon(rs.getString(1));
                ms.setTenKhachHang(rs.getString(2));
                ms.setSDT(rs.getInt(3));
                ms.setThoiDiemTao(rs.getString(4));
                ms.setTongGia(rs.getInt(5));
                ms.setTrangThaiLSHD(rs.getBoolean(6));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}
