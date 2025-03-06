package Repository;

import Model.Model_SanPhamCT;
import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;

public class Repo_sanPhamCT {

    public ArrayList<Model_SanPhamCT> getAllSPCT() {
        ArrayList<Model_SanPhamCT> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select IDSanPhamCT,IDSanpham, IDLinhkien , IDMausac,IDKhuyenmai,IDLoai,Trongluong,Phamvi,Tocdogio,Soluong,HangSX,Giaban from SanPhamChiTiet");
            while (rs.next()) {
                Model_SanPhamCT ms = new Model_SanPhamCT();
                ms.setMaSPCT(rs.getString(1));
                ms.setMaSP(rs.getString(2));
                ms.setIDLinhKien(rs.getString(3));
                ms.setIDMauSac(rs.getString(4));
                ms.setIDKhuyenmai(rs.getString(5));
                ms.setIDLoai(rs.getString(6));
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

    public Integer addInfoSPCT(Model_SanPhamCT nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     insert into SanPhamChiTiet 
                                         (IDSanPhamCT,IDSanpham, IDLinhkien , IDMausac,IDKhuyenmai,IDLoai,Trongluong,Phamvi,Tocdogio,Soluong,HangSX,Giaban)
                                         values 
                                         (?,?,?,?,?,?,?,?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaSPCT());
            ptsm.setString(2, nv.getMaSP());
            ptsm.setString(3, nv.getIDLinhKien());
            ptsm.setString(4, nv.getIDMauSac());
            ptsm.setString(5, nv.getIDKhuyenmai());
            ptsm.setString(6, nv.getIDLoai());
            ptsm.setInt(7, nv.getTrongLuong());
            ptsm.setString(8, nv.getPhamvigio());
            ptsm.setInt(9, nv.getTocDo());
            ptsm.setInt(10, nv.getSoLuong());
            ptsm.setString(11, nv.getHangSP());
            ptsm.setInt(12, nv.getGiaban());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer editInfoSPCT(Model_SanPhamCT nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "update SanPhamChiTiet\n"
                + "set IDLinhkien = ? , IDMausac=? , IDKhuyenmai = ? , IDSanpham = ? , IDLoai = ? ,Trongluong = ?,Phamvi=? ,Tocdogio=?,Soluong=?,HangSX=?,Giaban=?\n"
                + "where IDSanPhamCT = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(13, nv.getMaSPCT());
            ptsm.setString(1, nv.getIDLinhKien());
            ptsm.setString(2, nv.getIDMauSac());
            ptsm.setString(3, nv.getIDKhuyenmai());
            ptsm.setString(4, nv.getMaSP());
            ptsm.setString(5, nv.getIDLoai());
            ptsm.setInt(6, nv.getTrongLuong());
            ptsm.setString(7, nv.getPhamvigio());
            ptsm.setInt(8, nv.getTocDo());
            ptsm.setInt(9, nv.getSoLuong());
            ptsm.setString(10, nv.getHangSP());
            ptsm.setInt(11, nv.getGiaban());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoSPCT(Model_SanPhamCT nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     delete from HoaDonChiTiet
                     where IDSanPhamCT = ?
                     delete from SanPhamChiTiet
                     where IDSanPhamCT = ?""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaSPCT());
            ptsm.setString(2, nv.getMaSPCT());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
    
    public Integer getSoLuongTonById(String idSPCT){
        Connection cn = DB_conect.getConnection();
        String sql = "SELECT SoLuong FROM SanPhamChiTiet spct WHERE spct.IdSanPhamCT = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, idSPCT);
            ResultSet rs = ptsm.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
