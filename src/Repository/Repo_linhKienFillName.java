package Repository;

import Model.Model_LinhKienFillName;
import Model.Model_linhKien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repo_linhKienFillName {

    public ArrayList<Model_LinhKienFillName> getAllLKFillName() {
        ArrayList<Model_LinhKienFillName> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select lk.IDLinhkien , lk.TenLinhkien , dc.TenDC , bc.TenBC , cq.TenCQ , lk.Ngaybaohanh , lk.Ngayketthucbaohanh , lk.TrangThai from LinhKien lk \n"
                    + "Inner join DongCo dc on dc.IDDongCo = lk.IDDongCo\n"
                    + "Inner join BinhChua bc on bc.IDBinhChua = lk.IDBinhChua\n"
                    + "Inner join CanhQuat cq on cq.IDCanhQuat = lk.IDCanhQuat\n"
                    + "group by lk.IDLinhkien , lk.TenLinhkien , dc.TenDC , bc.TenBC , cq.TenCQ , lk.Ngaybaohanh , lk.Ngayketthucbaohanh , lk.TrangThai");
            while (rs.next()) {
                Model_LinhKienFillName ql = new Model_LinhKienFillName();
                ql.setIDLinhKien(rs.getString(1));
                ql.setTenLinhKien(rs.getString(2));
                ql.setTenDongCo(rs.getString(3));
                ql.setTenBinhChua(rs.getString(4));
                ql.setTenCanhQuat(rs.getString(5));
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
