package View;

import Model.Model_BinhChua;
import Model.Model_CanhQuat;
import Model.Model_DongCo;
import Model.Model_LinhKienFillName;
import Model.Model_MauSac;
import Model.Model_linhKien;
import Model.Model_phanLoai;
import Repository.DB_conect;
import Repository.Repo_Binhchua;
import Repository.Repo_DongCo;
import Repository.Repo_LinhKien;
import Repository.Repo_MauSac;
import Repository.Repo_PhanLoai;
import Repository.Repo_canhQuat;
import Repository.Repo_linhKienFillName;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLThuocTinh extends javax.swing.JFrame {

    Repo_MauSac repoMS = new Repo_MauSac();
    Repo_LinhKien repoLK = new Repo_LinhKien();
    Repo_DongCo repoDC = new Repo_DongCo();
    Repo_Binhchua repoBC = new Repo_Binhchua();
    Repo_canhQuat repoCQ = new Repo_canhQuat();
    Repo_PhanLoai repoPL = new Repo_PhanLoai();
    Repo_linhKienFillName repoLKFillName = new Repo_linhKienFillName();

    DefaultTableModel modelM = new DefaultTableModel();
    DefaultTableModel modelLK = new DefaultTableModel();
    DefaultTableModel modelDC = new DefaultTableModel();
    DefaultTableModel modelCQ = new DefaultTableModel();
    DefaultTableModel modelBC = new DefaultTableModel();
    DefaultTableModel modelPL = new DefaultTableModel();

    int i = 0;

    public QLThuocTinh() {
        initComponents();
        setLocationRelativeTo(null);

        modelM = (DefaultTableModel) tbl_mausac.getModel();
        modelLK = (DefaultTableModel) tbl_linhKien.getModel();
        modelDC = (DefaultTableModel) tbl_dongco.getModel();
        modelCQ = (DefaultTableModel) tbl_CanhQuat.getModel();
        modelBC = (DefaultTableModel) tbl_BinhChua.getModel();
        modelPL = (DefaultTableModel) tbl_PhanLoai.getModel();

        loadToTableM();
        loadToTableLKFillName(repoLKFillName.getAllLKFillName());
        loadToTableDC();
        loadToTableCQ();
        loadToTableBC();
        loadToTablePL();

        ShowCbo();
    }

    public void ShowCbo() {
        for (Model_DongCo de : repoDC.getAllDC()) {
            if (de.getTenDongco() != null) {
                cbo_DC.addItem(de.getTenDongco());
            }
        }
        for (Model_BinhChua de : repoBC.getAllBC()) {
            if (de.getTenBinhChua() != null) {
                cbo_BC.addItem(de.getTenBinhChua());
            }
        }
        for (Model_CanhQuat de : repoCQ.getAllCQ()) {
            if (de.getTenCanhQuat() != null) {
                cbo_CQ.addItem(de.getTenCanhQuat());
            }
        }
    }

    public Boolean checkM() {
        if (txt_idmau.getText().trim().equalsIgnoreCase("")
                || txt_tenmau.getText().trim().equalsIgnoreCase("")
                || txt_dodam.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        for (Model_MauSac ml : repoMS.getAllM()) {
            if (txt_idmau.getText().trim().equalsIgnoreCase(ml.getIDMauSac())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng mã Mầu sắc");
                return false;
            }
        }
        for (Model_MauSac ml : repoMS.getAllM()) {
            if (txt_tenmau.getText().trim().equalsIgnoreCase(ml.getTenMau())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng tên Mầu sắc");
                return false;
            }
        }
        return true;
    }

    public Boolean checkMEdit() {
        if (txt_idmau.getText().trim().equalsIgnoreCase("")
                || txt_tenmau.getText().trim().equalsIgnoreCase("")
                || txt_dodam.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }

        return true;
    }

    public Boolean checkLK() {
        if (txt_idlinhkien.getText().trim().equalsIgnoreCase("")
                || txt_ngaybatdau.getText().trim().equalsIgnoreCase("")
                || txt_ngayketthuc.getText().trim().equalsIgnoreCase("")
                || txt_TenLK.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        for (Model_linhKien ml : repoLK.getAllLK()) {
            if (txt_idlinhkien.getText().trim().equalsIgnoreCase(ml.getIDLinhKien())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng mã Linh Kiện");
                return false;
            }
        }
        for (Model_linhKien ml : repoLK.getAllLK()) {
            if (txt_TenLK.getText().trim().equalsIgnoreCase(ml.getTenLinhKien())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng tên Linh Kiện");
                return false;
            }
        }
       
        return true;
    }

    public Boolean checkLKEdit() {
        if (txt_idlinhkien.getText().trim().equalsIgnoreCase("")
                || txt_ngaybatdau.getText().trim().equalsIgnoreCase("")
                || txt_ngayketthuc.getText().trim().equalsIgnoreCase("")
                || txt_TenLK.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        return true;
    }

    public Boolean checkDC() {
        if (txt_idDongCo.getText().trim().equalsIgnoreCase("")
                || txt_HangDC.getText().trim().equalsIgnoreCase("")
                || txt_TenDC.getText().trim().equalsIgnoreCase("")
                || txt_NgaySXDC.getText().trim().equalsIgnoreCase("")
                || txt_CongSuatDC.getText().trim().equalsIgnoreCase("")
                || txt_ChatLieuDC.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        for (Model_DongCo ml : repoDC.getAllDC()) {
            if (txt_idDongCo.getText().trim().equalsIgnoreCase(ml.getIDDongco())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng mã Động Cơ");
                return false;
            }
        }
        for (Model_DongCo ml : repoDC.getAllDC()) {
            if (txt_TenDC.getText().trim().equalsIgnoreCase(ml.getTenDongco())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng Tên Động Cơ");
                return false;
            }
        }
        try {
            int a = Integer.parseInt(txt_CongSuatDC.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Công Xuất phải là kiểu số nguyên");
        }

        if (Integer.parseInt(txt_CongSuatDC.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Công Suất Không Được âm");
            return false;
        }
        return true;
    }

    public Boolean checkDCEdit() {
        if (txt_idDongCo.getText().trim().equalsIgnoreCase("")
                || txt_HangDC.getText().trim().equalsIgnoreCase("")
                || txt_TenDC.getText().trim().equalsIgnoreCase("")
                || txt_NgaySXDC.getText().trim().equalsIgnoreCase("")
                || txt_CongSuatDC.getText().trim().equalsIgnoreCase("")
                || txt_ChatLieuDC.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        try {
            int a = Integer.parseInt(txt_CongSuatDC.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Công Xuất phải là kiểu số nguyên");
        }
        for (Model_DongCo ml : repoDC.getAllDC()) {
            if (txt_TenDC.getText().trim().equalsIgnoreCase(ml.getTenDongco())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng Tên Động Cơ");
                return false;
            }
        }

        if (Integer.parseInt(txt_CongSuatDC.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Công Suất Không Được âm");
            return false;
        }
        return true;
    }

    public Boolean checkBC() {
        if (txt_idBinhChua.getText().trim().equalsIgnoreCase("")
                || txt_hangBC.getText().trim().equalsIgnoreCase("")
                || txt_TenBC.getText().trim().equalsIgnoreCase("")
                || txt_ngaySXBC.getText().trim().equalsIgnoreCase("")
                || txt_DTBinhChua.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        for (Model_BinhChua ml : repoBC.getAllBC()) {
            if (txt_idBinhChua.getText().trim().equalsIgnoreCase(ml.getIDBinhChua())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng mã Bình Chứa");
                return false;
            }
        }
        for (Model_BinhChua ml : repoBC.getAllBC()) {
            if (txt_TenBC.getText().trim().equalsIgnoreCase(ml.getTenBinhChua())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng tên Bình Chứa");
                return false;
            }
        }
        try {
            int a = Integer.parseInt(txt_DTBinhChua.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dung Tích Bình chữa Phải  là kiểu số nguyên");
        }
        if (Integer.parseInt(txt_DTBinhChua.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Dung Tích Bình Chứa Không Được Âm");
            return false;
        }
        return true;
    }

    public Boolean checkBCEdit() {
        if (txt_idBinhChua.getText().trim().equalsIgnoreCase("")
                || txt_hangBC.getText().trim().equalsIgnoreCase("")
                || txt_TenBC.getText().trim().equalsIgnoreCase("")
                || txt_ngaySXBC.getText().trim().equalsIgnoreCase("")
                || txt_DTBinhChua.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        try {
            int a = Integer.parseInt(txt_DTBinhChua.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dung Tích Bình chữa Phải  là kiểu số nguyên");
        }
        for (Model_BinhChua ml : repoBC.getAllBC()) {
            if (txt_TenBC.getText().trim().equalsIgnoreCase(ml.getTenBinhChua())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng tên Bình Chứa");
                return false;
            }
        }
        if (Integer.parseInt(txt_DTBinhChua.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Dung Tích Bình Chứa Không Được Âm");
            return false;
        }
        return true;
    }

    public Boolean checkCQ() {
        if (txt_idcanhquat.getText().trim().equalsIgnoreCase("")
                || txt_HangCQ.getText().trim().equalsIgnoreCase("")
                || txt_TenCQ.getText().trim().equalsIgnoreCase("")
                || txt_NgàySXCQ.getText().trim().equalsIgnoreCase("")
                || txt_congXuatCQ.getText().trim().equalsIgnoreCase("")
                || txt_chatLieuCQ.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        for (Model_CanhQuat ml : repoCQ.getAllCQ()) {
            if (txt_idcanhquat.getText().trim().equalsIgnoreCase(ml.getIDCanhQuat())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng mã Cánh Quạt");
                return false;
            }
        }
        for (Model_CanhQuat ml : repoCQ.getAllCQ()) {
            if (txt_TenCQ.getText().trim().equalsIgnoreCase(ml.getTenCanhQuat())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng Tên Cánh Quạt");
                return false;
            }
        }

        try {
            int a = Integer.parseInt(txt_congXuatCQ.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cánh Quạt phải là kiểu số nguyên");
        }
        if (Integer.parseInt(txt_congXuatCQ.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Công Suất Cánh Quạt Không được âm");
            return false;
        }
        return true;
    }

    public Boolean checkCQEdit() {
        if (txt_idcanhquat.getText().trim().equalsIgnoreCase("")
                || txt_HangCQ.getText().trim().equalsIgnoreCase("")
                || txt_TenCQ.getText().trim().equalsIgnoreCase("")
                || txt_NgàySXCQ.getText().trim().equalsIgnoreCase("")
                || txt_congXuatCQ.getText().trim().equalsIgnoreCase("")
                || txt_chatLieuCQ.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        try {
            int a = Integer.parseInt(txt_congXuatCQ.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cánh Quạt phải là kiểu số nguyên");
        }
        if (Integer.parseInt(txt_congXuatCQ.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Công Suất Cánh Quạt Không được âm");
            return false;
        }
        for (Model_CanhQuat ml : repoCQ.getAllCQ()) {
            if (txt_TenCQ.getText().trim().equalsIgnoreCase(ml.getTenCanhQuat())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng Tên Cánh Quạt");
                return false;
            }
        }
        return true;
    }

    public Boolean checkPL() {
        if (txt_idPL.getText().trim().equalsIgnoreCase("")
                || txt_loai.getText().trim().equalsIgnoreCase("")
                || txt_size.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        for (Model_phanLoai ml : repoPL.getAllPL()) {
            if (txt_idPL.getText().trim().equalsIgnoreCase(ml.getIDPhanLoai())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng mã Phân Loại");
                return false;
            }
        }
        for (Model_phanLoai ml : repoPL.getAllPL()) {
            if (txt_loai.getText().trim().equalsIgnoreCase(ml.getKieuDang())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng kiểu dáng Phân Loại");
                return false;
            }
        }
        return true;
    }

    public Boolean checkPLEdit() {
        if (txt_idPL.getText().trim().equalsIgnoreCase("")
                || txt_loai.getText().trim().equalsIgnoreCase("")
                || txt_size.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }
        return true;
    }

    public void loadToTableM() {
        modelM.setRowCount(0);
        for (Model_MauSac mt : repoMS.getAllM()) {
            modelM.addRow(new Object[]{
                mt.getIDMauSac(),
                mt.getTenMau(),
                mt.getDoDam(),
                mt.getTrangThaiM() ? "Còn Màu" : "Hết Màu"
            });
        }
    }

    public void loadToTableSearchM(String s) {
        modelM.setRowCount(0);
        for (Model_MauSac mt : repoMS.getAllSearchM(s)) {
            modelM.addRow(new Object[]{
                mt.getIDMauSac(),
                mt.getTenMau(),
                mt.getDoDam(),
                mt.getTrangThaiM() ? "Còn Màu" : "Hết Màu"
            });
        }
    }

    public void loadToTableDC() {
        modelDC.setRowCount(0);
        for (Model_DongCo mt : repoDC.getAllDC()) {
            modelDC.addRow(new Object[]{
                mt.getIDDongco(),
                mt.getTenDongco(),
                mt.getHangDC(),
                mt.getNgaySXDC(),
                mt.getCongXDC() + "W",
                mt.getChatLieuDC(),
                mt.getTrangThaiDC() ? "Còn Hàng" : "Hết Hàng"
            });
        }
    }

    public void loadToTableCQ() {
        modelCQ.setRowCount(0);
        for (Model_CanhQuat mt : repoCQ.getAllCQ()) {
            modelCQ.addRow(new Object[]{
                mt.getIDCanhQuat(),
                mt.getTenCanhQuat(),
                mt.getHangCQ(),
                mt.getNgaySXCQ(),
                mt.getCongXCQ() + "W",
                mt.getChatLieuCQ(),
                mt.getTrangThaiCQ() ? "Còn Hàng" : "Hết Hàng"
            });
        }
    }

    public void loadToTablePL() {
        modelPL.setRowCount(0);
        for (Model_phanLoai mt : repoPL.getAllPL()) {
            modelPL.addRow(new Object[]{
                mt.getIDPhanLoai(),
                mt.getKieuDang(),
                mt.getSize(),
                mt.getTrangThaiPL() ? "Còn Hàng" : "Hết Hàng"
            });
        }
    }

    public void loadToTableBC() {
        modelBC.setRowCount(0);
        for (Model_BinhChua mt : repoBC.getAllBC()) {
            modelBC.addRow(new Object[]{
                mt.getIDBinhChua(),
                mt.getTenBinhChua(),
                mt.getHangBC(),
                mt.getNgaySXBC(),
                mt.getDungTichBC() + "L",
                mt.getTrangThaiBC() ? "Còn Hàng" : "Hết Hàng"
            });
        }
    }

    public void loadToTableLKFillName(ArrayList<Model_LinhKienFillName> allLKFillName) {
        modelLK.setRowCount(0);
        for (Model_LinhKienFillName mt : repoLKFillName.getAllLKFillName()) {
            modelLK.addRow(new Object[]{
                mt.getIDLinhKien(),
                mt.getTenLinhKien(),
                mt.getTenDongCo(),
                mt.getTenBinhChua(),
                mt.getTenCanhQuat(),
                mt.getNgayStar(),
                mt.getNgayEnd(),
                mt.getTrangThaiLK() ? "Còn Bảo Hành" : "Hết Bảo Hành"
            });
        }
    }

    public String doiDongCo() {
        int index = cbo_DC.getSelectedIndex();
        ArrayList<Model_DongCo> dsp = repoDC.getAllDC();
        Model_DongCo DCDuocChon = dsp.get(index);
        return DCDuocChon.getIDDongco();
    }

    public String doiBinhChua() {
        int index = cbo_BC.getSelectedIndex();
        ArrayList<Model_BinhChua> dsp = repoBC.getAllBC();
        Model_BinhChua BCDuocChon = dsp.get(index);
        return BCDuocChon.getIDBinhChua();
    }

    public String doiCanhQuat() {
        int index = cbo_CQ.getSelectedIndex();
        ArrayList<Model_CanhQuat> dsp = repoCQ.getAllCQ();
        Model_CanhQuat CQDuocChon = dsp.get(index);
        return CQDuocChon.getIDCanhQuat();
    }

    public void loadToTableSearchLK(String s) {
        modelLK.setRowCount(0);
        for (Model_linhKien mt : repoLK.getAllSearchLK(s)) {
            modelLK.addRow(new Object[]{
                mt.getIDLinhKien(),
                mt.getTenLinhKien(),
                mt.getDongCo(),
                mt.getBinhChua(),
                mt.getCanhQuat(),
                mt.getNgayStar(),
                mt.getNgayEnd(),
                mt.getTrangThaiLK() ? "Còn Bảo Hành" : "Hết Bảo Hành"
            });
        }
    }

    public void loadToTableSearchDC(String s) {
        modelDC.setRowCount(0);
        for (Model_DongCo mt : repoDC.getAllSearchDC(s)) {
            modelDC.addRow(new Object[]{
                mt.getIDDongco(),
                mt.getTenDongco(),
                mt.getHangDC(),
                mt.getNgaySXDC(),
                mt.getCongXDC() + "W",
                mt.getChatLieuDC(),
                mt.getTrangThaiDC() ? "Còn Hàng" : "Hết Hàng"
            });
        }
    }

    public void loadToTableSearchCQ(String s) {
        modelCQ.setRowCount(0);
        for (Model_CanhQuat mt : repoCQ.getAllSearchCQ(s)) {
            modelCQ.addRow(new Object[]{
                mt.getIDCanhQuat(),
                mt.getTenCanhQuat(),
                mt.getHangCQ(),
                mt.getNgaySXCQ(),
                mt.getCongXCQ() + "W",
                mt.getChatLieuCQ(),
                mt.getTrangThaiCQ() ? "Còn Hàng" : "Hết Hàng"
            });
        }
    }

    public void loadToTableSearchBC(String s) {
        modelBC.setRowCount(0);
        for (Model_BinhChua mt : repoBC.getAllSearchBC(s)) {
            modelBC.addRow(new Object[]{
                mt.getIDBinhChua(),
                mt.getTenBinhChua(),
                mt.getHangBC(),
                mt.getNgaySXBC(),
                mt.getDungTichBC() + "L",
                mt.getTrangThaiBC() ? "Còn Hàng" : "Hết Hàng"
            });
        }
    }

    public void loadToTableSearchPL(String s) {
        modelPL.setRowCount(0);
        for (Model_phanLoai mt : repoPL.getAllSearchPL(s)) {
            modelPL.addRow(new Object[]{
                mt.getIDPhanLoai(),
                mt.getKieuDang(),
                mt.getSize(),
                mt.getTrangThaiPL() ? "Còn Hàng" : "Hết Hàng"
            });
        }
    }

    public void ShowdataM() {
        i = tbl_mausac.getSelectedRow();
        Model_MauSac ml = repoMS.getAllM().get(i);
        txt_idmau.setText(ml.getIDMauSac());
        txt_tenmau.setText(ml.getTenMau());
        txt_dodam.setText(ml.getDoDam());
        rbo_conhangM.setSelected(ml.getTrangThaiM() ? true : false);
        rbo_HethangM.setSelected(!ml.getTrangThaiM() ? true : false);

    }

    public void ShowdataDC() {
        i = tbl_dongco.getSelectedRow();
        Model_DongCo ml = repoDC.getAllDC().get(i);
        txt_idDongCo.setText(ml.getIDDongco());
        txt_TenDC.setText(ml.getTenDongco());
        txt_HangDC.setText(ml.getHangDC());
        txt_NgaySXDC.setText(ml.getNgaySXDC());
        txt_CongSuatDC.setText(ml.getCongXDC() + "");
        txt_ChatLieuDC.setText(ml.getChatLieuDC());
        rbo_conBHDC.setSelected(ml.getTrangThaiDC() ? true : false);
        rbo_hetBHDC.setSelected(!ml.getTrangThaiDC() ? true : false);

    }

    public void ShowdataCQ() {
        i = tbl_CanhQuat.getSelectedRow();
        Model_CanhQuat ml = repoCQ.getAllCQ().get(i);
        txt_idcanhquat.setText(ml.getIDCanhQuat());
        txt_TenCQ.setText(ml.getTenCanhQuat());
        txt_HangCQ.setText(ml.getHangCQ());
        txt_NgàySXCQ.setText(ml.getNgaySXCQ());
        txt_congXuatCQ.setText(ml.getCongXCQ() + "");
        txt_chatLieuCQ.setText(ml.getChatLieuCQ());
        rbo_conhangCQ.setSelected(ml.getTrangThaiCQ() ? true : false);
        rbo_hethangCQ.setSelected(!ml.getTrangThaiCQ() ? true : false);

    }

    public void ShowdataBC() {
        i = tbl_BinhChua.getSelectedRow();
        Model_BinhChua ml = repoBC.getAllBC().get(i);
        txt_idBinhChua.setText(ml.getIDBinhChua());
        txt_TenBC.setText(ml.getTenBinhChua());
        txt_hangBC.setText(ml.getHangBC());
        txt_ngaySXBC.setText(ml.getNgaySXBC());
        txt_DTBinhChua.setText(ml.getDungTichBC() + "");
        rbo_conhangBC.setSelected(ml.getTrangThaiBC() ? true : false);
        rbo_hethangBC.setSelected(!ml.getTrangThaiBC() ? true : false);

    }

    public void ShowdataPL() {
        i = tbl_PhanLoai.getSelectedRow();
        Model_phanLoai ml = repoPL.getAllPL().get(i);
        txt_idPL.setText(ml.getIDPhanLoai());
        txt_loai.setText(ml.getKieuDang());
        txt_size.setText(ml.getSize());
        rbo_conhangPL.setSelected(ml.getTrangThaiPL() ? true : false);
        rbo_hethangPL.setSelected(!ml.getTrangThaiPL() ? true : false);

    }

    public void ShowdataLK() {
        i = tbl_linhKien.getSelectedRow();
        Model_LinhKienFillName ml = repoLKFillName.getAllLKFillName().get(i);
        txt_idlinhkien.setText(ml.getIDLinhKien());
        txt_TenLK.setText(ml.getTenLinhKien());
        cbo_DC.setSelectedItem(ml.getTenDongCo());
        cbo_CQ.setSelectedItem(ml.getTenCanhQuat());
        cbo_BC.setSelectedItem(ml.getTenBinhChua());
        txt_ngaybatdau.setText(ml.getNgayStar());
        txt_ngayketthuc.setText(ml.getNgayEnd());
        rbo_conhang.setSelected(ml.getTrangThaiLK() ? true : false);
        rbo_hethang.setSelected(!ml.getTrangThaiLK() ? true : false);

    }

    Model_MauSac addRecostM() {
        Model_MauSac a = new Model_MauSac();
        a.setIDMauSac(txt_idmau.getText());
        a.setTenMau(txt_tenmau.getText());
        a.setDoDam(txt_dodam.getText());
        a.setTrangThaiM(rbo_conhangM.isSelected());
        return a;
    }

    Model_linhKien addRecostLK() {
        Model_linhKien a = new Model_linhKien();
        a.setIDLinhKien(txt_idlinhkien.getText());
        a.setTenLinhKien(txt_TenLK.getText());
        a.setDongCo(cbo_DC.getSelectedItem() + "");
        a.setBinhChua(cbo_BC.getSelectedItem() + "");
        a.setCanhQuat(cbo_CQ.getSelectedItem() + "");
        a.setNgayStar(txt_ngaybatdau.getText());
        a.setNgayEnd(txt_ngayketthuc.getText());
        a.setTrangThaiLK(rbo_conhang.isSelected());
        return a;
    }

    Model_DongCo addRecostDC() {
        Model_DongCo a = new Model_DongCo();
        a.setIDDongco(txt_idDongCo.getText());
        a.setTenDongco(txt_TenDC.getText());
        a.setHangDC(txt_HangDC.getText());
        a.setNgaySXDC(txt_NgaySXDC.getText());
        try {
            a.setCongXDC(Integer.valueOf(txt_CongSuatDC.getText()));
        } catch (NumberFormatException e) {

        }
        a.setChatLieuDC(txt_ChatLieuDC.getText());
        a.setTrangThaiDC(rbo_conBHDC.isSelected());
        return a;
    }

    Model_CanhQuat addRecostCQ() {
        Model_CanhQuat a = new Model_CanhQuat();
        a.setIDCanhQuat(txt_idcanhquat.getText());
        a.setTenCanhQuat(txt_TenCQ.getText());
        a.setHangCQ(txt_HangCQ.getText());
        a.setNgaySXCQ(txt_NgàySXCQ.getText());
        try {
            a.setCongXCQ(Integer.parseInt(txt_congXuatCQ.getText()));
        } catch (NumberFormatException e) {
        }
        a.setChatLieuCQ(txt_chatLieuCQ.getText());
        a.setTrangThaiCQ(rbo_conhangCQ.isSelected());
        return a;
    }

    Model_BinhChua addRecostBC() {
        Model_BinhChua a = new Model_BinhChua();
        a.setIDBinhChua(txt_idBinhChua.getText());
        a.setTenBinhChua(txt_TenBC.getText());
        a.setHangBC(txt_hangBC.getText());
        a.setNgaySXBC(txt_ngaySXBC.getText());
        try {
            a.setDungTichBC(Integer.parseInt(txt_DTBinhChua.getText()));
        } catch (NumberFormatException e) {
        }
        a.setTrangThaiBC(rbo_conhangBC.isSelected());
        return a;
    }

    Model_phanLoai addRecostPL() {
        Model_phanLoai a = new Model_phanLoai();
        a.setIDPhanLoai(txt_idPL.getText());
        a.setKieuDang(txt_loai.getText());
        a.setSize(txt_size.getText());
        a.setTrangThaiPL(rbo_conhangPL.isSelected());
        return a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jPanel51 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jTabbedPane25 = new javax.swing.JTabbedPane();
        jPanel52 = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        tbl_linhKien = new javax.swing.JTable();
        jLabel122 = new javax.swing.JLabel();
        txt_idlinhkien = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        btn_ADD = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_refest = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        txt_ngaybatdau = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        txt_ngayketthuc = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        rbo_conhang = new javax.swing.JRadioButton();
        rbo_hethang = new javax.swing.JRadioButton();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cbo_DC = new javax.swing.JComboBox<>();
        cbo_BC = new javax.swing.JComboBox<>();
        cbo_CQ = new javax.swing.JComboBox<>();
        jLabel181 = new javax.swing.JLabel();
        txt_TenLK = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        tbl_dongco = new javax.swing.JTable();
        jLabel141 = new javax.swing.JLabel();
        txt_idDongCo = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        txt_HangDC = new javax.swing.JTextField();
        btn_ADDDC = new javax.swing.JButton();
        btn_UpdateDC = new javax.swing.JButton();
        btn_deleteDC = new javax.swing.JButton();
        btn_refestDC = new javax.swing.JButton();
        txt_searchDC = new javax.swing.JTextField();
        btn_searchDC = new javax.swing.JButton();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        txt_NgaySXDC = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        txt_CongSuatDC = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        txt_ChatLieuDC = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        rbo_conBHDC = new javax.swing.JRadioButton();
        rbo_hetBHDC = new javax.swing.JRadioButton();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel148 = new javax.swing.JLabel();
        txt_TenDC = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        tbl_CanhQuat = new javax.swing.JTable();
        jLabel152 = new javax.swing.JLabel();
        txt_idcanhquat = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        txt_HangCQ = new javax.swing.JTextField();
        btn_ADDCQ = new javax.swing.JButton();
        btn_UpdateCQ = new javax.swing.JButton();
        btn_deleteCQ = new javax.swing.JButton();
        btn_refestCQ = new javax.swing.JButton();
        txt_searchCQ = new javax.swing.JTextField();
        btn_searchCQ = new javax.swing.JButton();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        txt_NgàySXCQ = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        txt_congXuatCQ = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        txt_chatLieuCQ = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        rbo_conhangCQ = new javax.swing.JRadioButton();
        rbo_hethangCQ = new javax.swing.JRadioButton();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel159 = new javax.swing.JLabel();
        txt_TenCQ = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        tbl_BinhChua = new javax.swing.JTable();
        jLabel163 = new javax.swing.JLabel();
        txt_idBinhChua = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        txt_hangBC = new javax.swing.JTextField();
        btn_ADDBC = new javax.swing.JButton();
        btn_UpdateBC = new javax.swing.JButton();
        btn_deleteBC = new javax.swing.JButton();
        btn_refestBC = new javax.swing.JButton();
        txt_searchBC = new javax.swing.JTextField();
        btn_searchBC = new javax.swing.JButton();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        txt_ngaySXBC = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        txt_DTBinhChua = new javax.swing.JTextField();
        jLabel171 = new javax.swing.JLabel();
        rbo_conhangBC = new javax.swing.JRadioButton();
        rbo_hethangBC = new javax.swing.JRadioButton();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel177 = new javax.swing.JLabel();
        txt_TenBC = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        tbl_PhanLoai = new javax.swing.JTable();
        jLabel169 = new javax.swing.JLabel();
        txt_idPL = new javax.swing.JTextField();
        jLabel170 = new javax.swing.JLabel();
        txt_loai = new javax.swing.JTextField();
        btn_ADDPL = new javax.swing.JButton();
        btn_UpdatePL = new javax.swing.JButton();
        btn_deletePL = new javax.swing.JButton();
        btn_refestPL = new javax.swing.JButton();
        txt_searchPL = new javax.swing.JTextField();
        btn_searchPL = new javax.swing.JButton();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        txt_size = new javax.swing.JTextField();
        jLabel178 = new javax.swing.JLabel();
        rbo_conhangPL = new javax.swing.JRadioButton();
        rbo_hethangPL = new javax.swing.JRadioButton();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_moi = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        txt_idmau = new javax.swing.JTextField();
        txt_tenmau = new javax.swing.JTextField();
        jScrollPane26 = new javax.swing.JScrollPane();
        tbl_mausac = new javax.swing.JTable();
        txt_tim = new javax.swing.JTextField();
        btn_tim = new javax.swing.JButton();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        txt_dodam = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        rbo_HethangM = new javax.swing.JRadioButton();
        rbo_conhangM = new javax.swing.JRadioButton();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel51.setBackground(new java.awt.Color(216, 239, 239));

        jLabel121.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel121.setText("QUẢN LÍ THUỘC TÍNH SẢN PHẨM");

        jTabbedPane25.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel52.setBackground(new java.awt.Color(216, 239, 239));

        tbl_linhKien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Linh Kiện", "Tên Linh Kiện", "Tên Động cơ ", "Tên  Bình chứa  ", "Tên Cánh Quạt ", "Ngày bắt đầu bảo hành", "Ngày kết thúc bảo hành", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_linhKien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_linhKienMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(tbl_linhKien);

        jLabel122.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel122.setText("ID Linh  Kiện");

        jLabel123.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel123.setText("Tên  Động cơ");

        btn_ADD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_ADD.setText("Thêm");
        btn_ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ADDActionPerformed(evt);
            }
        });

        btn_Update.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        btn_Update.setText("Sửa");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_refest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_refest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btn_refest.setText("Mới");
        btn_refest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refestActionPerformed(evt);
            }
        });

        btn_search.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btn_search.setText("Tìm");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel124.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel124.setText("Tìm ID:");

        jLabel131.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel131.setText("Tên Cánh Quạt");

        jLabel132.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel132.setText("Tên Bình chứa");

        jLabel133.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel133.setText("Ngày bắt đầu bảo hành");

        jLabel134.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel134.setText("Ngày Kết thúc bảo hành");

        jLabel135.setText("Trạng Thái");

        buttonGroup1.add(rbo_conhang);
        rbo_conhang.setText("Còn Bảo Hành");

        buttonGroup1.add(rbo_hethang);
        rbo_hethang.setText("Hết Bảo Hành");

        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute3.png"))); // NOI18N

        jLabel137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute3.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        jButton2.setText("come back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbo_DC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel181.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel181.setText("Tên Linh  Kiện");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel125, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel137))
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1315, Short.MAX_VALUE)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGap(235, 368, Short.MAX_VALUE)
                        .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addGap(336, 336, 336))
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addGap(380, 380, 380)
                                .addComponent(btn_ADD)
                                .addGap(31, 31, 31)
                                .addComponent(btn_Update)
                                .addGap(31, 31, 31)
                                .addComponent(btn_delete)
                                .addGap(37, 37, 37)
                                .addComponent(btn_refest))
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addGap(537, 537, 537)
                                .addComponent(jLabel135)
                                .addGap(50, 50, 50)
                                .addComponent(rbo_conhang)
                                .addGap(53, 53, 53)
                                .addComponent(rbo_hethang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel52Layout.createSequentialGroup()
                                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel52Layout.createSequentialGroup()
                                        .addGap(399, 399, 399)
                                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel134)
                                            .addComponent(jLabel133)
                                            .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel131)
                                                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel123)
                                                    .addComponent(jLabel132)))))
                                    .addComponent(jLabel181, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel122, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ngaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ngayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_CQ, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_BC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_DC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_TenLK, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_idlinhkien, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 422, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel125))
                    .addComponent(jLabel136)
                    .addComponent(jLabel137))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(jLabel124)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idlinhkien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel122))
                .addGap(18, 18, 18)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TenLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel181))
                .addGap(12, 12, 12)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_DC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel123))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_BC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel132))
                .addGap(9, 9, 9)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_CQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel131))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel133))
                .addGap(12, 12, 12)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134))
                .addGap(30, 30, 30)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbo_conhang)
                    .addComponent(rbo_hethang)
                    .addComponent(jLabel135))
                .addGap(18, 18, 18)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ADD)
                    .addComponent(btn_delete)
                    .addComponent(btn_refest)
                    .addComponent(btn_Update))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane25.addTab("Linh Kiện", jPanel52);

        jPanel53.setBackground(new java.awt.Color(216, 239, 239));

        tbl_dongco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Động cơ", "Tên Động cơ", "Hãng", "Ngày  Sản Xuất", "Công Xuất", "Chất liệu", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dongco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dongcoMouseClicked(evt);
            }
        });
        jScrollPane27.setViewportView(tbl_dongco);

        jLabel141.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel141.setText("ID Động cơ");

        jLabel142.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel142.setText("Hãng");

        btn_ADDDC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ADDDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_ADDDC.setText("Thêm");
        btn_ADDDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ADDDCActionPerformed(evt);
            }
        });

        btn_UpdateDC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_UpdateDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        btn_UpdateDC.setText("Sửa");
        btn_UpdateDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateDCActionPerformed(evt);
            }
        });

        btn_deleteDC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_deleteDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        btn_deleteDC.setText("Xóa");
        btn_deleteDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteDCActionPerformed(evt);
            }
        });

        btn_refestDC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_refestDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btn_refestDC.setText("Mới");
        btn_refestDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refestDCActionPerformed(evt);
            }
        });

        btn_searchDC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_searchDC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btn_searchDC.setText("Tìm");
        btn_searchDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchDCActionPerformed(evt);
            }
        });

        jLabel143.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel143.setText("Tìm ID:");

        jLabel145.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel145.setText("Ngày SX");

        txt_NgaySXDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NgaySXDCActionPerformed(evt);
            }
        });

        jLabel146.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel146.setText("Công Xuất");

        jLabel147.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel147.setText("Chất Liệu");

        jLabel149.setText("Trạng Thái");

        buttonGroup2.add(rbo_conBHDC);
        rbo_conBHDC.setSelected(true);
        rbo_conBHDC.setText("Còn hàng");

        buttonGroup2.add(rbo_hetBHDC);
        rbo_hetBHDC.setText("Hết hàng");
        rbo_hetBHDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbo_hetBHDCActionPerformed(evt);
            }
        });

        jLabel150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute2.png"))); // NOI18N

        jLabel151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute2.png"))); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        jButton4.setText("come back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel148.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel148.setText("Tên Động cơ");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel151)
                .addGap(41, 41, 41))
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 1315, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_searchDC, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_searchDC)
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                                .addComponent(jLabel145)
                                .addGap(18, 18, 18)
                                .addComponent(txt_NgaySXDC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                                .addComponent(jLabel147)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ChatLieuDC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                                .addComponent(jLabel146)
                                .addGap(18, 18, 18)
                                .addComponent(txt_CongSuatDC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                                .addComponent(jLabel142)
                                .addGap(18, 18, 18)
                                .addComponent(txt_HangDC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel53Layout.createSequentialGroup()
                                .addComponent(jLabel149)
                                .addGap(50, 50, 50)
                                .addComponent(rbo_conBHDC)
                                .addGap(53, 53, 53)
                                .addComponent(rbo_hetBHDC, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addComponent(btn_ADDDC)
                        .addGap(29, 29, 29)
                        .addComponent(btn_UpdateDC)
                        .addGap(33, 33, 33)
                        .addComponent(btn_deleteDC)
                        .addGap(37, 37, 37)
                        .addComponent(btn_refestDC))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel148)
                        .addGap(21, 21, 21)
                        .addComponent(txt_TenDC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel141)
                        .addGap(24, 24, 24)
                        .addComponent(txt_idDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(415, 415, 415))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel150))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel144))
                    .addGroup(jPanel53Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel151)))
                .addGap(19, 19, 19)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searchDC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchDC)
                    .addComponent(jLabel143)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(txt_idDongCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(txt_TenDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel142)
                    .addComponent(txt_HangDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel145)
                    .addComponent(txt_NgaySXDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel146)
                    .addComponent(txt_CongSuatDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel147)
                    .addComponent(txt_ChatLieuDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbo_conBHDC)
                    .addComponent(rbo_hetBHDC)
                    .addComponent(jLabel149))
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ADDDC)
                    .addComponent(btn_UpdateDC)
                    .addComponent(btn_deleteDC)
                    .addComponent(btn_refestDC))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane25.addTab("Dộng cơ", jPanel1);

        jPanel54.setBackground(new java.awt.Color(216, 239, 239));

        tbl_CanhQuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Cánh Quạt", "Tên Cánh Quạt", "Hãng Sản Xuất", "Ngày Sản Xuất", "Công Xuất", "Chất Liệu", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_CanhQuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CanhQuatMouseClicked(evt);
            }
        });
        jScrollPane28.setViewportView(tbl_CanhQuat);

        jLabel152.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel152.setText("ID Cánh Quạt");

        jLabel153.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel153.setText("Hãng");

        btn_ADDCQ.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ADDCQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_ADDCQ.setText("Thêm");
        btn_ADDCQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ADDCQActionPerformed(evt);
            }
        });

        btn_UpdateCQ.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_UpdateCQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        btn_UpdateCQ.setText("Sửa");
        btn_UpdateCQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateCQActionPerformed(evt);
            }
        });

        btn_deleteCQ.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_deleteCQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        btn_deleteCQ.setText("Xóa");
        btn_deleteCQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteCQActionPerformed(evt);
            }
        });

        btn_refestCQ.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_refestCQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btn_refestCQ.setText("Mới");
        btn_refestCQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refestCQActionPerformed(evt);
            }
        });

        btn_searchCQ.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_searchCQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btn_searchCQ.setText("Tìm");
        btn_searchCQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchCQActionPerformed(evt);
            }
        });

        jLabel154.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel154.setText("Tìm ID:");

        jLabel156.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel156.setText("Ngày Sản Xuất");

        txt_NgàySXCQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NgàySXCQActionPerformed(evt);
            }
        });

        jLabel157.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel157.setText("Công Xuất");

        jLabel158.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel158.setText("Chất Liệu");

        jLabel160.setText("Trạng Thái");

        buttonGroup3.add(rbo_conhangCQ);
        rbo_conhangCQ.setText("Còn hàng");

        buttonGroup3.add(rbo_hethangCQ);
        rbo_hethangCQ.setText("Hết hàng");

        jLabel161.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute1.png"))); // NOI18N

        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute1.png"))); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        jButton5.setText("come back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel159.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel159.setText("Tên Cánh Quạt");

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1030, Short.MAX_VALUE)
                .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel162)
                .addGap(29, 29, 29))
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane28)
                .addGap(6, 6, 6))
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_searchCQ, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_searchCQ)
                .addGap(26, 26, 26)
                .addComponent(jButton5)
                .addContainerGap(397, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel54Layout.createSequentialGroup()
                                        .addComponent(jLabel156)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_NgàySXCQ, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel54Layout.createSequentialGroup()
                                        .addComponent(jLabel158)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_chatLieuCQ, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel54Layout.createSequentialGroup()
                                        .addComponent(jLabel157)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_congXuatCQ, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel54Layout.createSequentialGroup()
                                        .addComponent(jLabel160)
                                        .addGap(50, 50, 50)
                                        .addComponent(rbo_conhangCQ)
                                        .addGap(53, 53, 53)
                                        .addComponent(rbo_hethangCQ, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel54Layout.createSequentialGroup()
                                        .addComponent(jLabel153)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_HangCQ, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                                .addComponent(btn_ADDCQ)
                                .addGap(29, 29, 29)
                                .addComponent(btn_UpdateCQ)
                                .addGap(33, 33, 33)
                                .addComponent(btn_deleteCQ)
                                .addGap(37, 37, 37)
                                .addComponent(btn_refestCQ)))
                        .addGap(411, 411, 411))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel54Layout.createSequentialGroup()
                                .addComponent(jLabel159)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_TenCQ, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel54Layout.createSequentialGroup()
                                .addComponent(jLabel152)
                                .addGap(21, 21, 21)
                                .addComponent(txt_idcanhquat, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(488, 488, 488))))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel155))
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel161))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel162)))
                .addGap(52, 52, 52)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searchCQ, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchCQ)
                    .addComponent(jLabel154)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(txt_idcanhquat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel159)
                    .addComponent(txt_TenCQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel153)
                    .addComponent(txt_HangCQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel156)
                    .addComponent(txt_NgàySXCQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel157)
                    .addComponent(txt_congXuatCQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel158)
                    .addComponent(txt_chatLieuCQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbo_conhangCQ)
                    .addComponent(rbo_hethangCQ)
                    .addComponent(jLabel160))
                .addGap(26, 26, 26)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ADDCQ)
                    .addComponent(btn_UpdateCQ)
                    .addComponent(btn_deleteCQ)
                    .addComponent(btn_refestCQ))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1327, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane25.addTab("Cánh Quạt", jPanel2);

        jPanel55.setBackground(new java.awt.Color(216, 239, 239));

        tbl_BinhChua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Bình chứa", "Tên Bình Chứa", "Hãng sản Xuất", "Ngày Sản Xuất", "Dung Tích", "Trang Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_BinhChua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_BinhChuaMouseClicked(evt);
            }
        });
        jScrollPane29.setViewportView(tbl_BinhChua);

        jLabel163.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel163.setText("ID Bình Chứa");

        jLabel164.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel164.setText("Hãng");

        btn_ADDBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ADDBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_ADDBC.setText("Thêm");
        btn_ADDBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ADDBCActionPerformed(evt);
            }
        });

        btn_UpdateBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_UpdateBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        btn_UpdateBC.setText("Sửa");
        btn_UpdateBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateBCActionPerformed(evt);
            }
        });

        btn_deleteBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_deleteBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        btn_deleteBC.setText("Xóa");
        btn_deleteBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteBCActionPerformed(evt);
            }
        });

        btn_refestBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_refestBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btn_refestBC.setText("Mới");
        btn_refestBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refestBCActionPerformed(evt);
            }
        });

        btn_searchBC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_searchBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btn_searchBC.setText("Tìm");
        btn_searchBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchBCActionPerformed(evt);
            }
        });

        jLabel165.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel165.setText("Tìm ID:");

        jLabel167.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel167.setText("Ngày SX");

        txt_ngaySXBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaySXBCActionPerformed(evt);
            }
        });

        jLabel168.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel168.setText("Dung Tích");

        jLabel171.setText("Trạng Thái");

        buttonGroup4.add(rbo_conhangBC);
        rbo_conhangBC.setText("Còn hàng");

        buttonGroup4.add(rbo_hethangBC);
        rbo_hethangBC.setText("Hết hàng");

        jLabel172.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jLabel173.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        jButton6.setText("come back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel177.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel177.setText("Tên Bình Chứa");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel173)
                .addGap(41, 41, 41))
            .addComponent(jScrollPane29, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_searchBC, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_searchBC)
                        .addGap(26, 26, 26)
                        .addComponent(jButton6))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel55Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel55Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                                                .addComponent(jLabel167)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_ngaySXBC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                                                .addComponent(jLabel168)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_DTBinhChua, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                                                .addComponent(jLabel171)
                                                .addGap(50, 50, 50)
                                                .addComponent(rbo_conhangBC)
                                                .addGap(53, 53, 53)
                                                .addComponent(rbo_hethangBC, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                                                .addComponent(jLabel164)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_hangBC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel55Layout.createSequentialGroup()
                                        .addComponent(btn_ADDBC)
                                        .addGap(29, 29, 29)
                                        .addComponent(btn_UpdateBC)
                                        .addGap(33, 33, 33)
                                        .addComponent(btn_deleteBC)
                                        .addGap(37, 37, 37)
                                        .addComponent(btn_refestBC))))
                            .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel55Layout.createSequentialGroup()
                                    .addComponent(jLabel177)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_TenBC, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel55Layout.createSequentialGroup()
                                    .addComponent(jLabel163)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_idBinhChua, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(391, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel172))
                    .addGroup(jPanel55Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel166)
                            .addComponent(jLabel173))))
                .addGap(12, 12, 12)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searchBC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchBC)
                    .addComponent(jLabel165)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163)
                    .addComponent(txt_idBinhChua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel177)
                    .addComponent(txt_TenBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(txt_hangBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel167)
                    .addComponent(txt_ngaySXBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel168)
                    .addComponent(txt_DTBinhChua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbo_conhangBC)
                    .addComponent(rbo_hethangBC)
                    .addComponent(jLabel171))
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ADDBC)
                    .addComponent(btn_UpdateBC)
                    .addComponent(btn_deleteBC)
                    .addComponent(btn_refestBC))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1327, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane25.addTab("Bình Chứa", jPanel4);

        jPanel56.setBackground(new java.awt.Color(216, 239, 239));

        tbl_PhanLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IDPhân Loại", "Kiểu dáng", "size", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_PhanLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PhanLoaiMouseClicked(evt);
            }
        });
        jScrollPane30.setViewportView(tbl_PhanLoai);

        jLabel169.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel169.setText("ID Phân Loại");

        jLabel170.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel170.setText("Kiểu Dáng");

        btn_ADDPL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_ADDPL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_ADDPL.setText("Thêm");
        btn_ADDPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ADDPLActionPerformed(evt);
            }
        });

        btn_UpdatePL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_UpdatePL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        btn_UpdatePL.setText("Sửa");
        btn_UpdatePL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdatePLActionPerformed(evt);
            }
        });

        btn_deletePL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_deletePL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        btn_deletePL.setText("Xóa");
        btn_deletePL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletePLActionPerformed(evt);
            }
        });

        btn_refestPL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_refestPL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btn_refestPL.setText("Mới");
        btn_refestPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refestPLActionPerformed(evt);
            }
        });

        btn_searchPL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_searchPL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btn_searchPL.setText("Tìm");
        btn_searchPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchPLActionPerformed(evt);
            }
        });

        jLabel174.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel174.setText("Tìm ID:");

        jLabel176.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel176.setText("Size");

        txt_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sizeActionPerformed(evt);
            }
        });

        jLabel178.setText("Trạng Thái");

        buttonGroup6.add(rbo_conhangPL);
        rbo_conhangPL.setSelected(true);
        rbo_conhangPL.setText("Còn hàng");

        buttonGroup6.add(rbo_hethangPL);
        rbo_hethangPL.setText("Hết hàng");

        jLabel179.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute6.png"))); // NOI18N

        jLabel180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute6.png"))); // NOI18N

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        jButton7.setText("come back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel176)
                        .addGap(18, 18, 18)
                        .addComponent(txt_size, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel178)
                        .addGap(50, 50, 50)
                        .addComponent(rbo_conhangPL)
                        .addGap(53, 53, 53)
                        .addComponent(rbo_hethangPL, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel170)
                        .addGap(18, 18, 18)
                        .addComponent(txt_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                        .addComponent(jLabel169)
                        .addGap(18, 18, 18)
                        .addComponent(txt_idPL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel179, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel180)
                .addGap(41, 41, 41))
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane30, javax.swing.GroupLayout.DEFAULT_SIZE, 1315, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_searchPL, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_searchPL)
                .addGap(26, 26, 26)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ADDPL)
                .addGap(29, 29, 29)
                .addComponent(btn_UpdatePL)
                .addGap(33, 33, 33)
                .addComponent(btn_deletePL)
                .addGap(37, 37, 37)
                .addComponent(btn_refestPL)
                .addGap(412, 412, 412))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel179))
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel175)
                            .addComponent(jLabel180))))
                .addGap(30, 30, 30)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_searchPL, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchPL)
                    .addComponent(jLabel174)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel169)
                    .addComponent(txt_idPL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel170)
                    .addComponent(txt_loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel176)
                    .addComponent(txt_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbo_conhangPL)
                    .addComponent(rbo_hethangPL)
                    .addComponent(jLabel178))
                .addGap(18, 18, 18)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ADDPL)
                    .addComponent(btn_UpdatePL)
                    .addComponent(btn_deletePL)
                    .addComponent(btn_refestPL))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1327, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane25.addTab("Phân Loại", jPanel5);

        jPanel3.setBackground(new java.awt.Color(216, 239, 239));

        btn_moi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_moi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btn_moi.setText("Mới");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_them.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jLabel126.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel126.setText("Tên màu");

        jLabel127.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel127.setText("ID Màu sắc");

        tbl_mausac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Màu Sắc", "Tên Tên Màu", "Độ Đậm", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_mausacMouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(tbl_mausac);

        btn_tim.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_tim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btn_tim.setText("Tìm");
        btn_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timActionPerformed(evt);
            }
        });

        jLabel128.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel128.setText("Tìm ID:");

        jLabel130.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel130.setText("Độ đậm");

        jLabel138.setText("Trạng Thái");

        buttonGroup5.add(rbo_HethangM);
        rbo_HethangM.setText("Hết Màu");
        rbo_HethangM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbo_HethangMActionPerformed(evt);
            }
        });

        buttonGroup5.add(rbo_conhangM);
        rbo_conhangM.setText("Còn Màu");

        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute5.png"))); // NOI18N

        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute5.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        jButton1.setText("come back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 450, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel127)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_idmau, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel126)
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_tenmau, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel130)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_dodam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btn_sua)
                                                        .addComponent(rbo_conhangM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addComponent(rbo_HethangM, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(36, 36, 36)))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel138)
                                        .addGap(274, 274, 274)))
                                .addGap(87, 87, 87))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_them)
                                .addGap(145, 145, 145)
                                .addComponent(btn_xoa)
                                .addGap(37, 37, 37)
                                .addComponent(btn_moi)))
                        .addGap(293, 293, 293)
                        .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane26)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_tim)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel139)
                    .addComponent(jLabel140))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tim)
                    .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel129))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel127)
                            .addComponent(txt_idmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel126)
                            .addComponent(txt_tenmau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel130)
                            .addComponent(txt_dodam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel138)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbo_conhangM)
                                .addComponent(rbo_HethangM)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them)
                            .addComponent(btn_xoa)
                            .addComponent(btn_moi)
                            .addComponent(btn_sua))))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane25.addTab("Màu sắc", jPanel3);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Left.png"))); // NOI18N
        jButton8.setText("Quay Lại Sản Phẩm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addGap(308, 308, 308)
                        .addComponent(jLabel121)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane25))
                .addContainerGap())
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new TrangChu().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        loadToTableBC();
        txt_searchBC.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txt_ngaySXBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaySXBCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaySXBCActionPerformed

    private void btn_searchBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchBCActionPerformed
        String tuKhoa4 = txt_searchBC.getText();
        loadToTableSearchBC(tuKhoa4);
    }//GEN-LAST:event_btn_searchBCActionPerformed

    private void btn_refestBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refestBCActionPerformed
        txt_idBinhChua.setText("");
        txt_TenBC.setText("");
        txt_hangBC.setText("");
        txt_ngaySXBC.setText("");
        txt_DTBinhChua.setText("");
    }//GEN-LAST:event_btn_refestBCActionPerformed

    private void btn_deleteBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteBCActionPerformed
        Model_BinhChua nv = addRecostBC();
        try {
            if (repoBC.deleteInfoBC(nv) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            cbo_BC.removeAllItems();
                cbo_CQ.removeAllItems();
                cbo_DC.removeAllItems();
            loadToTableBC();
            ShowCbo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteBCActionPerformed

    private void btn_UpdateBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateBCActionPerformed
        Model_BinhChua nv = addRecostBC();
        if (checkBCEdit() == true) {
            try {
                if (repoBC.editInfoBC(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
                cbo_BC.removeAllItems();
                cbo_CQ.removeAllItems();
                cbo_DC.removeAllItems();
                loadToTableBC();
                ShowCbo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_UpdateBCActionPerformed

    private void btn_ADDBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ADDBCActionPerformed
        Model_BinhChua nv = addRecostBC();
        if (checkBC() == true) {
            try {
                if (repoBC.addInfoBC(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
                cbo_BC.removeAllItems();
                cbo_CQ.removeAllItems();
                cbo_DC.removeAllItems();
                loadToTableBC();
                ShowCbo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_ADDBCActionPerformed

    private void tbl_BinhChuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BinhChuaMouseClicked
        ShowdataBC();
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_BinhChuaMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        loadToTableCQ();
        txt_searchCQ.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_NgàySXCQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NgàySXCQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NgàySXCQActionPerformed

    private void btn_searchCQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchCQActionPerformed
        String tuKhoa3 = txt_searchCQ.getText();
        loadToTableSearchCQ(tuKhoa3);
    }//GEN-LAST:event_btn_searchCQActionPerformed

    private void btn_refestCQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refestCQActionPerformed
        txt_idcanhquat.setText("");
        txt_TenCQ.setText("");
        txt_HangCQ.setText("");
        txt_NgàySXCQ.setText("");
        txt_congXuatCQ.setText("");
        txt_chatLieuCQ.setText("");
    }//GEN-LAST:event_btn_refestCQActionPerformed

    private void btn_deleteCQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteCQActionPerformed
        Model_CanhQuat nv = addRecostCQ();
        try {
            if (repoCQ.deleteInfoCQ(nv) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            cbo_BC.removeAllItems();
                cbo_CQ.removeAllItems();
                cbo_DC.removeAllItems();
            loadToTableCQ();
            ShowCbo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteCQActionPerformed

    private void btn_UpdateCQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateCQActionPerformed
        Model_CanhQuat nv = addRecostCQ();
        if (checkCQEdit() == true) {
            try {
                if (repoCQ.editInfoCQ(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
                cbo_BC.removeAllItems();
                cbo_CQ.removeAllItems();
                cbo_DC.removeAllItems();
                loadToTableCQ();
                ShowCbo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_UpdateCQActionPerformed

    private void btn_ADDCQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ADDCQActionPerformed
        Model_CanhQuat nv = addRecostCQ();
        if (checkCQ() == true) {
            try {
                if (repoCQ.addInfoCQ(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
                cbo_BC.removeAllItems();
                cbo_CQ.removeAllItems();
                cbo_DC.removeAllItems();
                loadToTableCQ();
                ShowCbo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_ADDCQActionPerformed

    private void tbl_CanhQuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CanhQuatMouseClicked
        ShowdataCQ();
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_CanhQuatMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        loadToTableDC();
        txt_searchDC.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rbo_hetBHDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbo_hetBHDCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbo_hetBHDCActionPerformed

    private void txt_NgaySXDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NgaySXDCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NgaySXDCActionPerformed

    private void btn_searchDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchDCActionPerformed
        // TODO add your handling code here:
        String tuKhoa2 = txt_searchDC.getText();
        loadToTableSearchDC(tuKhoa2);        // TODO add your handling code here:

    }//GEN-LAST:event_btn_searchDCActionPerformed

    private void btn_refestDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refestDCActionPerformed
        txt_idDongCo.setText("");
        txt_TenDC.setText("");
        txt_HangDC.setText("");
        txt_NgaySXDC.setText("");
        txt_CongSuatDC.setText("");
        txt_ChatLieuDC.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refestDCActionPerformed

    private void btn_deleteDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteDCActionPerformed
        Model_DongCo nv = addRecostDC();
        try {
            if (repoDC.deleteInfoDC(nv) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            cbo_BC.removeAllItems();
                cbo_CQ.removeAllItems();
                cbo_DC.removeAllItems();
            loadToTableDC();
            ShowCbo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteDCActionPerformed

    private void btn_UpdateDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateDCActionPerformed
        Model_DongCo nv = addRecostDC();
        if (checkDCEdit() == true) {
            try {
                if (repoDC.editInfoDC(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
               cbo_BC.removeAllItems();
                cbo_CQ.removeAllItems();
                cbo_DC.removeAllItems();
                loadToTableDC();
                ShowCbo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_UpdateDCActionPerformed

    private void btn_ADDDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ADDDCActionPerformed
        Model_DongCo nv = addRecostDC();
        if (checkDC() == true) {
            try {
                if (repoDC.addInfoDC(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
                cbo_BC.removeAllItems();
                cbo_CQ.removeAllItems();
                cbo_DC.removeAllItems();
                loadToTableDC();
                ShowCbo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btn_ADDDCActionPerformed

    private void tbl_dongcoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dongcoMouseClicked
        // TODO add your handling code here:
        ShowdataDC();
    }//GEN-LAST:event_tbl_dongcoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadToTableLKFillName(repoLKFillName.getAllLKFillName());
        txt_search.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String tuKhoa = txt_search.getText();
        loadToTableSearchLK(tuKhoa);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_refestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refestActionPerformed
        txt_idlinhkien.setText("");
        txt_TenLK.setText("");
        txt_ngaybatdau.setText("");
        txt_ngayketthuc.setText("");
    }//GEN-LAST:event_btn_refestActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        Model_linhKien nv = addRecostLK();
        try {
            if (repoLK.deleteInfoLK(nv) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            loadToTableLKFillName(repoLKFillName.getAllLKFillName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        Model_linhKien nv = addRecostLK();
        if (checkLKEdit()) {
            String idDongco = doiDongCo();
            String idBinhChua = doiBinhChua();
            String idCanhQuat = doiCanhQuat();
            String sql = "update LinhKien\n"
                    + "set TenLinhKien = ? IDDongCo= ? , IDBinhChua=?,IDCanhQuat=?,Ngaybaohanh=?,Ngayketthucbaohanh=?,TrangThai = ?\n"
                    + "where IDLinhkien =?";
            try {
                PreparedStatement ptsm = DB_conect.getConnection().prepareStatement(sql);
                ptsm.setString(1, nv.getTenLinhKien());
                ptsm.setString(2, idDongco);
                ptsm.setString(3, idBinhChua);
                ptsm.setString(4, idCanhQuat);
                ptsm.setString(5, nv.getNgayStar());
                ptsm.setString(6, nv.getNgayEnd());
                ptsm.setBoolean(7, nv.getTrangThaiLK());
                ptsm.setString(8, nv.getIDLinhKien());
                ptsm.executeUpdate();
                JOptionPane.showMessageDialog(this, "Sửa Thành công");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, " Sửa Thất bại ");
                e.printStackTrace();
            }
            loadToTableLKFillName(repoLKFillName.getAllLKFillName());
        }
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ADDActionPerformed
        Model_linhKien nv = addRecostLK();
        if (checkLK() == true) {
            String idDongco = doiDongCo();
            String idBinhChua = doiBinhChua();
            String idCanhQuat = doiCanhQuat();
            String sql = """
                     INSERT INTO LinhKien
                        (IDLinhkien , TenLinhkien , IDDongCo , IDBinhChua , IDCanhQuat , Ngaybaohanh , Ngayketthucbaohanh , TrangThai)
                                             VALUES 
                                             	(?,?,?,?,?,?,?,?)""";
            try {
                PreparedStatement ptsm = DB_conect.getConnection().prepareStatement(sql);
                ptsm.setString(1, nv.getIDLinhKien());
                ptsm.setString(2, nv.getTenLinhKien());
                ptsm.setString(3, idDongco);
                ptsm.setString(4, idBinhChua);
                ptsm.setString(5, idCanhQuat);
                ptsm.setString(6, nv.getNgayStar());
                ptsm.setString(7, nv.getNgayEnd());
                ptsm.setBoolean(8, nv.getTrangThaiLK());
                ptsm.executeUpdate();
                JOptionPane.showMessageDialog(this, "Thêm Thành công");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Thêm Thất bại ");
                e.printStackTrace();
            }
            loadToTableLKFillName(repoLKFillName.getAllLKFillName());
        }
    }//GEN-LAST:event_btn_ADDActionPerformed

    private void tbl_linhKienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_linhKienMouseClicked
        ShowdataLK();
    }//GEN-LAST:event_tbl_linhKienMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadToTableM();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbo_HethangMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbo_HethangMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbo_HethangMActionPerformed

    private void btn_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timActionPerformed
        String tuKhoa = txt_tim.getText();
        loadToTableSearchM(tuKhoa);
    }//GEN-LAST:event_btn_timActionPerformed

    private void tbl_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mausacMouseClicked
        ShowdataM();
    }//GEN-LAST:event_tbl_mausacMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        Model_MauSac nv = addRecostM();
        if (checkM() == true) {
            try {
                if (repoMS.addInfoM(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
                loadToTableM();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        Model_MauSac nv = addRecostM();
        if (checkMEdit() == true) {
            try {
                if (repoMS.editInfoM(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
                loadToTableM();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        Model_MauSac nv = addRecostM();
        try {
            if (repoMS.deleteInfoM(nv) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            loadToTableM();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        txt_idmau.setText("");
        txt_tenmau.setText("");
        txt_dodam.setText("");
    }//GEN-LAST:event_btn_moiActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        loadToTablePL();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txt_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sizeActionPerformed
        // TODO add your handling code here:&
    }//GEN-LAST:event_txt_sizeActionPerformed

    private void btn_searchPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchPLActionPerformed
        String tuKhoa5 = txt_searchPL.getText();
        loadToTableSearchPL(tuKhoa5);
    }//GEN-LAST:event_btn_searchPLActionPerformed

    private void btn_refestPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refestPLActionPerformed
        txt_idPL.setText("");
        txt_loai.setText("");
        txt_size.setText("");
    }//GEN-LAST:event_btn_refestPLActionPerformed

    private void btn_deletePLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletePLActionPerformed
        Model_phanLoai nv = addRecostPL();
        try {
            if (repoPL.deleteInfoPL(nv) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            loadToTablePL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_deletePLActionPerformed

    private void btn_UpdatePLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdatePLActionPerformed
        Model_phanLoai nv = addRecostPL();
        if (checkPLEdit() == true) {
            try {
                if (repoPL.editInfoPL(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
                loadToTablePL();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_UpdatePLActionPerformed

    private void btn_ADDPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ADDPLActionPerformed
        Model_phanLoai nv = addRecostPL();
        if (checkPL() == true) {
            try {
                if (repoPL.addInfoPL(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
                loadToTablePL();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_ADDPLActionPerformed

    private void tbl_PhanLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PhanLoaiMouseClicked
        ShowdataPL();
    }//GEN-LAST:event_tbl_PhanLoaiMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       new sanPham().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLThuocTinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLThuocTinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ADD;
    private javax.swing.JButton btn_ADDBC;
    private javax.swing.JButton btn_ADDCQ;
    private javax.swing.JButton btn_ADDDC;
    private javax.swing.JButton btn_ADDPL;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_UpdateBC;
    private javax.swing.JButton btn_UpdateCQ;
    private javax.swing.JButton btn_UpdateDC;
    private javax.swing.JButton btn_UpdatePL;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_deleteBC;
    private javax.swing.JButton btn_deleteCQ;
    private javax.swing.JButton btn_deleteDC;
    private javax.swing.JButton btn_deletePL;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_refest;
    private javax.swing.JButton btn_refestBC;
    private javax.swing.JButton btn_refestCQ;
    private javax.swing.JButton btn_refestDC;
    private javax.swing.JButton btn_refestPL;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_searchBC;
    private javax.swing.JButton btn_searchCQ;
    private javax.swing.JButton btn_searchDC;
    private javax.swing.JButton btn_searchPL;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_tim;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JComboBox<String> cbo_BC;
    private javax.swing.JComboBox<String> cbo_CQ;
    private javax.swing.JComboBox<String> cbo_DC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JTabbedPane jTabbedPane25;
    private javax.swing.JRadioButton rbo_HethangM;
    private javax.swing.JRadioButton rbo_conBHDC;
    private javax.swing.JRadioButton rbo_conhang;
    private javax.swing.JRadioButton rbo_conhangBC;
    private javax.swing.JRadioButton rbo_conhangCQ;
    private javax.swing.JRadioButton rbo_conhangM;
    private javax.swing.JRadioButton rbo_conhangPL;
    private javax.swing.JRadioButton rbo_hetBHDC;
    private javax.swing.JRadioButton rbo_hethang;
    private javax.swing.JRadioButton rbo_hethangBC;
    private javax.swing.JRadioButton rbo_hethangCQ;
    private javax.swing.JRadioButton rbo_hethangPL;
    private javax.swing.JTable tbl_BinhChua;
    private javax.swing.JTable tbl_CanhQuat;
    private javax.swing.JTable tbl_PhanLoai;
    private javax.swing.JTable tbl_dongco;
    private javax.swing.JTable tbl_linhKien;
    private javax.swing.JTable tbl_mausac;
    private javax.swing.JTextField txt_ChatLieuDC;
    private javax.swing.JTextField txt_CongSuatDC;
    private javax.swing.JTextField txt_DTBinhChua;
    private javax.swing.JTextField txt_HangCQ;
    private javax.swing.JTextField txt_HangDC;
    private javax.swing.JTextField txt_NgaySXDC;
    private javax.swing.JTextField txt_NgàySXCQ;
    private javax.swing.JTextField txt_TenBC;
    private javax.swing.JTextField txt_TenCQ;
    private javax.swing.JTextField txt_TenDC;
    private javax.swing.JTextField txt_TenLK;
    private javax.swing.JTextField txt_chatLieuCQ;
    private javax.swing.JTextField txt_congXuatCQ;
    private javax.swing.JTextField txt_dodam;
    private javax.swing.JTextField txt_hangBC;
    private javax.swing.JTextField txt_idBinhChua;
    private javax.swing.JTextField txt_idDongCo;
    private javax.swing.JTextField txt_idPL;
    private javax.swing.JTextField txt_idcanhquat;
    private javax.swing.JTextField txt_idlinhkien;
    private javax.swing.JTextField txt_idmau;
    private javax.swing.JTextField txt_loai;
    private javax.swing.JTextField txt_ngaySXBC;
    private javax.swing.JTextField txt_ngaybatdau;
    private javax.swing.JTextField txt_ngayketthuc;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_searchBC;
    private javax.swing.JTextField txt_searchCQ;
    private javax.swing.JTextField txt_searchDC;
    private javax.swing.JTextField txt_searchPL;
    private javax.swing.JTextField txt_size;
    private javax.swing.JTextField txt_tenmau;
    private javax.swing.JTextField txt_tim;
    // End of variables declaration//GEN-END:variables
}
