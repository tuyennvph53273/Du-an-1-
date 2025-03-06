package Repository;

import Model.Model_SanPhamCT;
import Model.Model_SanPhamFilllAllName;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repo_SanPhamCTFillName {

    public ArrayList<Model_SanPhamFilllAllName> getAllSPCTFillName() {
        ArrayList<Model_SanPhamFilllAllName> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("""
                                                                                     select ct.IDSanPhamCT, sp.TenSanpham, lk.TenLinhkien, ms.Tenmau, km.PhanTramKM ,pl.Kieudang, ct.Trongluong, ct.Phamvi, ct.Tocdogio, ct.Soluong, ct.HangSX, ct.Giaban from SanPhamChiTiet ct
                                                                                                                                                                        inner join SanPham sp on sp.IDSanpham = ct.IDSanpham
                                                                                                                                                                        inner join MauSac ms on ms.IDMausac = ct.IDMausac
                                                                                                                                                                        inner join KhuyenMai km on km.IDKhuyenmai = ct.IDKhuyenmai
                                                                                                                                                                        inner join LinhKien lk on lk.IDLinhkien = ct.IDLinhkien                                                                                                                                                                      
                                                                                                                                                                        inner join PhanLoai pl on pl.IDLoai = ct.IDLoai
                                                                                                                                                                        group by  ct.IDSanPhamCT, sp.TenSanpham, lk.TenLinhkien,km.PhanTramKM, ms.Tenmau, pl.Kieudang, ct.Trongluong, ct.Phamvi, ct.Tocdogio, ct.Soluong, ct.HangSX, ct.Giaban""");
            while (rs.next()) {
                Model_SanPhamFilllAllName ms = new Model_SanPhamFilllAllName();
                ms.setMaSPCT(rs.getString(1));
                ms.setTenSP(rs.getString(2));
                ms.setTenLinhKien(rs.getString(3));
                ms.setTenMauSac(rs.getString(4));
                ms.setTenKhuyenmai(rs.getString(5));
                ms.setTenLoai(rs.getString(6));
                ms.setTrongLuong(rs.getInt(7));
                ms.setPhamvigio(rs.getString(8));
                ms.setTocDo(rs.getInt(9));
                ms.setSoLuong(rs.getInt(10));
                ms.setHangSP(rs.getString(11));
                ms.setGiaban(rs.getInt(12));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }
    public ArrayList<Model_SanPhamFilllAllName> getAllSPCTSearch(String tuKhoa) {
        ArrayList<Model_SanPhamFilllAllName> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("     select ct.IDSanPhamCT, sp.TenSanpham, lk.TenLinhkien, ms.Tenmau, km.PhanTramKM ,pl.Kieudang, ct.Trongluong, ct.Phamvi, ct.Tocdogio, ct.Soluong, ct.HangSX, ct.Giaban from SanPhamChiTiet ct\n" +
"                                                                                    inner join SanPham sp on sp.IDSanpham = ct.IDSanpham\n" +
"                                                                                    inner join MauSac ms on ms.IDMausac = ct.IDMausac\n" +
"                                                                                    inner join KhuyenMai km on km.IDKhuyenmai = ct.IDKhuyenmai\n" +
"                                                                                    inner join LinhKien lk on lk.IDLinhkien = ct.IDLinhkien\n" +
"                                                                                    inner join PhanLoai pl on pl.IDLoai = ct.IDLoai	\n" +
"										     where ct.IDSanPhamCT Like '%"+tuKhoa+"%'\n" +
"                                                                                    group by  ct.IDSanPhamCT, sp.TenSanpham, lk.TenLinhkien,km.PhanTramKM, ms.Tenmau, pl.Kieudang, ct.Trongluong, ct.Phamvi, ct.Tocdogio, ct.Soluong, ct.HangSX, ct.Giaban");
            while (rs.next()) {
                Model_SanPhamFilllAllName ms = new Model_SanPhamFilllAllName();
                ms.setMaSPCT(rs.getString(1));
                ms.setTenSP(rs.getString(2));
                ms.setTenLinhKien(rs.getString(3));
                ms.setTenMauSac(rs.getString(4));
                ms.setTenKhuyenmai(rs.getString(5));
                ms.setTenLoai(rs.getString(6));
                ms.setTrongLuong(rs.getInt(7));
                ms.setPhamvigio(rs.getString(8));
                ms.setTocDo(rs.getInt(9));
                ms.setSoLuong(rs.getInt(10));
                ms.setHangSP(rs.getString(11));
                ms.setGiaban(rs.getInt(12));
                list.add(ms);
            }
        } catch (SQLException ex) {
        }

        return list;
    }

//    public static void main(String[] args) {
//         ArrayList<Model_SanPhamFilllAllName> list = new ArrayList<>();
//         try {
//            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select ct.IDSanPhamCT, sp.TenSanpham, lk.TenLinhkien, ms.Tenmau,ct.IDKhuyenmai ,pl.Kieudang, ct.Trongluong, ct.Phamvi, ct.Tocdogio, ct.Soluong, ct.HangSX, ct.Giaban, ct.TrangThai from SanPhamChiTiet ct\n" +
//"left join SanPham sp on sp.IDSanpham = ct.IDSanpham\n" +
//"left join MauSac ms on ms.IDMausac = ct.IDMausac\n" +
//"left join KhuyenMai km on km.IDKhuyenmai = ct.IDKhuyenmai\n" +
//"left join PhanLoai pl on pl.IDLoai = ct.IDLoai\n" +
//"left join LinhKien lk on lk.IDLinhkien = ct.IDLinhkien\n" +
//"group by  ct.IDSanPhamCT, sp.TenSanpham, lk.TenLinhkien,ct.IDKhuyenmai, ms.Tenmau, pl.Kieudang, ct.Trongluong, ct.Phamvi, ct.Tocdogio, ct.Soluong, ct.HangSX, ct.Giaban, ct.TrangThai");
//            while (rs.next()) {
//                Model_SanPhamFilllAllName ms = new Model_SanPhamFilllAllName();
//                ms.setMaSPCT(rs.getString(1));
//                ms.setTenSP(rs.getString(2));
//                ms.setTenLinhKien(rs.getString(3));
//                ms.setTenMauSac(rs.getString(4));
//                ms.setTenKhuyenmai(rs.getString(5));
//                ms.setTenLoai(rs.getString(6));
//                ms.setTrongLuong(rs.getInt(7));
//                ms.setPhamvigio(rs.getString(8));
//                ms.setTocDo(rs.getInt(9));
//                ms.setSoLuong(rs.getInt(10));
//                ms.setHangSP(rs.getString(11));
//                ms.setGiaban(rs.getInt(12));
//                ms.setTrangThaiSPCT(rs.getBoolean(13));
//                list.add(ms);
//            }
//        } catch (SQLException ex) {          
//        }
//         for (Model_SanPhamFilllAllName mn : list) {
//             System.out.println(mn.toString()
//             );
//        }
//    }
}
