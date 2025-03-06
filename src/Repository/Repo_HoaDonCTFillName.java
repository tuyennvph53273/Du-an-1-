package Repository;

import Model.Model_hoaDonCTFillName;
import java.util.ArrayList;
import java.sql.*;


public class Repo_HoaDonCTFillName {
     public ArrayList<Model_hoaDonCTFillName> getAllHDCT() {
        ArrayList<Model_hoaDonCTFillName> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
             select hdct.IDHoaDonCT , sp.TenSanpham , hdct.IDHoadon , hdct.Soluong , hdct.Dongia , hdct.TrangThai  from HoaDonChiTiet hdct 
             inner join SanPhamChiTiet spct on hdct.IDSanPhamCT = spct.IDSanPhamCT
             inner join SanPham sp on spct.IDSanpham = sp.IDSanpham
             group by hdct.IDHoaDonCT , sp.TenSanpham , hdct.IDHoadon , hdct.Soluong , hdct.Dongia , hdct.TrangThai""");
            while (rs.next()) {
                Model_hoaDonCTFillName ms = new Model_hoaDonCTFillName();
                ms.setIDHoaDonCT(rs.getString(1));
                ms.setTenSanPham(rs.getString(2));
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
     public ArrayList<Model_hoaDonCTFillName> getAllSearchHDCT(String tuKhoa) {
        ArrayList<Model_hoaDonCTFillName> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select hdct.IDHoaDonCT , sp.TenSanpham , hdct.IDHoadon , hdct.Soluong , hdct.Dongia , hdct.TrangThai  from HoaDonChiTiet hdct \n" +
"inner join SanPhamChiTiet spct on hdct.IDSanPhamCT = spct.IDSanPhamCT\n" +
"inner join SanPham sp on spct.IDSanpham = sp.IDSanpham\n" +
"where IDHoaDonCT like '%"+tuKhoa+"%'\n" +
"group by hdct.IDHoaDonCT , sp.TenSanpham , hdct.IDHoadon , hdct.Soluong , hdct.Dongia , hdct.TrangThai");
            while (rs.next()) {
                Model_hoaDonCTFillName ms = new Model_hoaDonCTFillName();
                ms.setIDHoaDonCT(rs.getString(1));
                ms.setTenSanPham(rs.getString(2));
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
}
