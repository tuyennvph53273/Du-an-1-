package View;

import Model.Model_KhuyenMai;
import Model.Model_MauSac;
import Model.Model_SanPhamCT;
import Model.Model_SanPhamFilllAllName;
import Model.Model_linhKien;
import Model.Model_login;
import Model.Model_phanLoai;
import Model.Model_sanPham;
import Repository.DB_conect;
import Repository.Repo_KhuyenMai;
import Repository.Repo_LinhKien;
import Repository.Repo_MauSac;
import Repository.Repo_PhanLoai;
import Repository.Repo_SanPham;
import Repository.Repo_SanPhamCTFillName;
import Repository.Repo_sanPhamCT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class sanPham extends javax.swing.JFrame {

    Repo_SanPham repoSP = new Repo_SanPham();
    Repo_sanPhamCT repoSPCT = new Repo_sanPhamCT();
    Repo_SanPhamCTFillName repoSPCTFillName = new Repo_SanPhamCTFillName();
    Repo_MauSac repoMS = new Repo_MauSac();
    Repo_LinhKien repoLK = new Repo_LinhKien();
    Repo_PhanLoai repoPL = new Repo_PhanLoai();
    Repo_KhuyenMai repoKM = new Repo_KhuyenMai();

    DefaultTableModel modelSP = new DefaultTableModel();
    DefaultTableModel modelSPCT = new DefaultTableModel();
    int i = 0;

    public sanPham() {
        initComponents();
        setLocationRelativeTo(null);
        modelSP = (DefaultTableModel) tbl_SP.getModel();
        modelSPCT = (DefaultTableModel) tbl_ctsp.getModel();
        loadToTableSp();
        loadToTableSpctFillName(repoSPCTFillName.getAllSPCTFillName());
        showCBO();
         for (Model_linhKien de : repoLK.getAllLK()) {
            if (de.getTenLinhKien() != null) {
                cbo_linhkien.addItem(de.getTenLinhKien());
            }
        }
        for (Model_phanLoai de : repoPL.getAllPLSPCT()) {
            if (de.getKieuDang() != null) {
                cbo_loai.addItem(de.getKieuDang());
            }
        }
        for (Model_MauSac de : repoMS.getAllM()) {
            if (de.getTenMau() != null) {
                cbo_mausac.addItem(de.getTenMau());
            }
        }
        for (Model_KhuyenMai de : repoKM.getAllLK()) {
            if (de.getPhanTramkhuyenmai() != null) {
                cbo_Khuyenmai.addItem(de.getPhanTramkhuyenmai() + "%");
            }
        }

    }

    public void showCBO() {
        for (Model_sanPham de : repoSP.getAllSP()) {
            if (de.getTenSP() != null) {
                cbo_sanpham.addItem(de.getTenSP());
            }
        }
    }

    public Boolean checkSPCT() {
        if (txt_maspct.getText().trim().equalsIgnoreCase("")
                || txt_trongluong.getText().trim().equalsIgnoreCase("")
                || txt_phamvi.getText().trim().equalsIgnoreCase("")
                || txt_soluong.getText().trim().equalsIgnoreCase("")
                || txt_tocdo.getText().trim().equalsIgnoreCase("")
                || txt_hang.getText().trim().equalsIgnoreCase("")
                || txt_Nhap.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đủ thông tin ");
            return false;
        }
        for (Model_SanPhamCT sp : repoSPCT.getAllSPCT()) {
            if (txt_maspct.getText().trim().equalsIgnoreCase(sp.getMaSPCT())) {
                JOptionPane.showMessageDialog(this, "Không được trùng mã Sản Phẩm Chi Tiết");
                return false;
            }
        }
        for (Model_SanPhamFilllAllName sp : repoSPCTFillName.getAllSPCTFillName()) {
            if (cbo_sanpham.getSelectedItem().equals(sp.getTenSP())) {
                JOptionPane.showMessageDialog(this, "Không được trùng Tên Sản Phẩm ");
                return false;
            }
        }

        try {

            int a = Integer.parseInt(txt_trongluong.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Trọng Lượng Phải là kiểu số Nguyên");
        }
        if (Integer.parseInt(txt_trongluong.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Trọng Lương không được âm");
            return false;
        }

        try {

            int a = Integer.parseInt(txt_tocdo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tốc độ  Phải là kiểu số Nguyên");
        }
        if (Integer.parseInt(txt_tocdo.getText()) < 0) {
            JOptionPane.showMessageDialog(this, " Tốc độ không được âm");
            return false;
        }
        try {

            int a = Integer.parseInt(txt_soluong.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số Lượng  Phải là kiểu số Nguyên");
        }
        if (Integer.parseInt(txt_soluong.getText()) < 0) {
            JOptionPane.showMessageDialog(this, " Số Lượng không được âm");
            return false;
        }
        try {

            int a = Integer.parseInt(txt_Nhap.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá bán  Phải là kiểu số Nguyên");
        }
        if (Integer.parseInt(txt_Nhap.getText()) < 0) {
            JOptionPane.showMessageDialog(this, " Giá Bán không được âm");
            return false;
        }
        return true;
    }

    public Boolean checkSPCTEdit() {
        if (txt_maspct.getText().trim().equalsIgnoreCase("")
                || txt_trongluong.getText().trim().equalsIgnoreCase("")
                || txt_phamvi.getText().trim().equalsIgnoreCase("")
                || txt_soluong.getText().trim().equalsIgnoreCase("")
                || txt_tocdo.getText().trim().equalsIgnoreCase("")
                || txt_hang.getText().trim().equalsIgnoreCase("")
                || txt_Nhap.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đủ thông tin ");
            return false;
        }

        try {

            int a = Integer.parseInt(txt_trongluong.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Trọng Lượng Phải là kiểu số Nguyên");
        }
        if (Integer.parseInt(txt_trongluong.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Trọng Lương không được âm");
            return false;
        }
        try {

            int a = Integer.parseInt(txt_tocdo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tốc độ  Phải là kiểu số Nguyên");
        }
        if (Integer.parseInt(txt_tocdo.getText()) < 0) {
            JOptionPane.showMessageDialog(this, " Tốc độ không được âm");
            return false;
        }
        try {

            int a = Integer.parseInt(txt_soluong.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số Lượng  Phải là kiểu số Nguyên");
        }
        if (Integer.parseInt(txt_soluong.getText()) < 0) {
            JOptionPane.showMessageDialog(this, " Số Lượng không được âm");
            return false;
        }
        try {

            int a = Integer.parseInt(txt_Nhap.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá bán  Phải là kiểu số Nguyên");
        }
        if (Integer.parseInt(txt_Nhap.getText()) < 0) {
            JOptionPane.showMessageDialog(this, " Giá Bán không được âm");
            return false;
        }
        return true;
    }

    public void loadToTableSpctFillName(ArrayList<Model_SanPhamFilllAllName> allSPCTFillName) {
        modelSPCT.setRowCount(0);
        for (Model_SanPhamFilllAllName sp : repoSPCTFillName.getAllSPCTFillName()) {
            modelSPCT.addRow(new Object[]{
                sp.getMaSPCT(),
                sp.getTenSP(),
                sp.getTenLinhKien(),
                sp.getTenMauSac(),
                sp.getTenKhuyenmai(),
                sp.getTenLoai(),
                sp.getTrongLuong() + "Kg",
                sp.getPhamvigio(),
                sp.getTocDo() + "m/s",
                sp.getSoLuong(),
                sp.getHangSP(),
                sp.getGiaban()
            });
        }
    }

    public void loadToTableSpctFillName() {
        modelSPCT.setRowCount(0);
        for (Model_SanPhamFilllAllName sp : repoSPCTFillName.getAllSPCTFillName()) {
            modelSPCT.addRow(new Object[]{
                sp.getMaSPCT(),
                sp.getTenSP(),
                sp.getTenLinhKien(),
                sp.getTenMauSac(),
                sp.getTenKhuyenmai(),
                sp.getTenLoai(),
                sp.getTrongLuong() + "Kg",
                sp.getPhamvigio(),
                sp.getTocDo() + "m/s",
                sp.getSoLuong(),
                sp.getHangSP(),
                sp.getGiaban()
         
            });
        }
    }

    public void loadToTableSearchSpct(String tuKhoa) {
        modelSPCT.setRowCount(0);
        for (Model_SanPhamFilllAllName sp : repoSPCTFillName.getAllSPCTSearch(tuKhoa)) {
            modelSPCT.addRow(new Object[]{
                sp.getMaSPCT(),
                sp.getTenSP(),
                sp.getTenLinhKien(),
                sp.getTenMauSac(),
                sp.getTenKhuyenmai(),
                sp.getTenLoai(),
                sp.getTrongLuong() + "Kg",
                sp.getPhamvigio(),
                sp.getTocDo() + "m/s",
                sp.getSoLuong(),
                sp.getHangSP(),
                sp.getGiaban(),
            });
        }
    }

    public void ShowDataSPCT() {
        i = tbl_ctsp.getSelectedRow();
        Model_SanPhamFilllAllName a = repoSPCTFillName.getAllSPCTFillName().get(i);
        txt_maspct.setText(a.getMaSPCT());
        cbo_linhkien.setSelectedItem(a.getTenLinhKien());
        cbo_mausac.setSelectedItem(a.getTenMauSac());
        cbo_Khuyenmai.setSelectedIndex(a.getTenKhuyenmai().equals("0")?0:
                                        a.getTenKhuyenmai().equals("10")?1:
                                        a.getTenKhuyenmai().equals("15")?2:
                                        a.getTenKhuyenmai().equals("20")?3:
                                        4);
        cbo_sanpham.setSelectedItem(a.getTenSP());
        cbo_loai.setSelectedItem(a.getTenLoai());
        txt_trongluong.setText(a.getTrongLuong() + "");
        txt_phamvi.setText(a.getPhamvigio());
        txt_tocdo.setText(a.getTocDo() + "");
        txt_soluong.setText(a.getSoLuong() + "");
        txt_hang.setText(a.getHangSP());
        txt_giaban.setText(a.getGiaban() + "");
    }

    public Boolean checkSP() {
        if (txt_maSP.getText().trim().equalsIgnoreCase("") || txt_tenSP.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }

        for (Model_sanPham sp : repoSP.getAllSP()) {
            if (txt_maSP.getText().trim().equalsIgnoreCase(sp.getMaSP())) {
                JOptionPane.showMessageDialog(this, "KHông được trùng mã Sản Phẩm");
                return false;
            }
        }
        for (Model_sanPham sp : repoSP.getAllSP()) {
            if (txt_tenSP.getText().trim().equalsIgnoreCase(sp.getTenSP())) {
                JOptionPane.showMessageDialog(this, "KHông được trùng tên Sản Phẩm");
                return false;
            }
        }

        return true;
    }

    public Boolean checkSPCTSearch() {
        if (txt_timMaSPCT.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống Ô tìm mã SPCT ");
            return false;
        }
        return true;
    }

    public Boolean checkSPEdit() {
        if (txt_maSP.getText().trim().equalsIgnoreCase("") || txt_tenSP.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống dữ liệu");
            return false;
        }

        return true;
    }

    public void loadToTableSp() {
        modelSP.setRowCount(0);
        for (Model_sanPham sp : repoSP.getAllSP()) {
            modelSP.addRow(new Object[]{
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getTrangThaiSP() ? "Còn hàng" : "hết hàng"
            });
        }

    }

    public void loadToTableSearchSp(String s) {
        modelSP.setRowCount(0);
        for (Model_sanPham sp : repoSP.getSearchSP(s)) {
            modelSP.addRow(new Object[]{
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getTrangThaiSP() ? "Còn hàng" : "hết hàng"
            });
        }
    }

    public void ShowDataSP() {
        i = tbl_SP.getSelectedRow();
        Model_sanPham a = repoSP.getAllSP().get(i);
        txt_tenSP.setText(a.getTenSP());
        txt_maSP.setText(a.getMaSP());
        rbo_conSP.setSelected(a.getTrangThaiSP() ? true : false);
        rbo_hetSP.setSelected(!a.getTrangThaiSP() ? true : false);
    }

    Model_sanPham addRecordSP() {
        Model_sanPham a = new Model_sanPham();
        a.setMaSP(txt_maSP.getText());
        a.setTenSP(txt_tenSP.getText());
        a.setTrangThaiSP(rbo_conSP.isSelected());
        return a;
    }

    public String DoiLinhKien() {
        int index = cbo_linhkien.getSelectedIndex();
        ArrayList<Model_linhKien> dsp = repoLK.getAllLK();
        Model_linhKien LKDuocChon = dsp.get(index);
        return LKDuocChon.getIDLinhKien();
    }

    public String DoiMauSac() {
        int index = cbo_mausac.getSelectedIndex();
        ArrayList<Model_MauSac> dsp = repoMS.getAllM();
        Model_MauSac MSDuocChon = dsp.get(index);
        return MSDuocChon.getIDMauSac();
    }

    public String DoiSanPham() {
        int index = cbo_sanpham.getSelectedIndex();
        ArrayList<Model_sanPham> dsp = repoSP.getAllSP();
        Model_sanPham spDuocChon = dsp.get(index);
        return spDuocChon.getMaSP();
    }

    public String DoiKhuyenmai() {
        int index = cbo_Khuyenmai.getSelectedIndex();
        ArrayList<Model_KhuyenMai> dsp = repoKM.getAllLK();
        Model_KhuyenMai spDuocChon = dsp.get(index);
        return spDuocChon.getIdKhuyenMai();
    }

    public String DoiLoai() {
        int index = cbo_loai.getSelectedIndex();
        ArrayList<Model_phanLoai> dsp = repoPL.getAllPL();
        Model_phanLoai spDuocChon = dsp.get(index);
        return spDuocChon.getIDPhanLoai();
    }

    Model_SanPhamCT addRecordSPCT() {
        Model_SanPhamCT a = new Model_SanPhamCT();
        a.setMaSPCT(txt_maspct.getText());
        a.setIDLinhKien(cbo_linhkien.getSelectedItem() + "");
        a.setIDMauSac(cbo_mausac.getSelectedItem() + "");
        a.setIDKhuyenmai(cbo_Khuyenmai.getSelectedItem() + "");
        a.setMaSP(cbo_sanpham.getSelectedItem() + "");
        a.setIDLoai(cbo_loai.getSelectedItem() + "");
        try {
            a.setTrongLuong(Integer.parseInt(txt_trongluong.getText()));
        } catch (NumberFormatException e) {
        }
        a.setPhamvigio(txt_phamvi.getText());
        try {
            a.setTocDo(Integer.parseInt(txt_tocdo.getText()));
        } catch (NumberFormatException e) {
        }
        try {
            a.setSoLuong(Integer.parseInt(txt_soluong.getText()));
        } catch (NumberFormatException e) {
        }
        a.setHangSP(txt_hang.getText());
        try {
            a.setGiaban(Integer.parseInt(txt_giaban.getText()));
        } catch (NumberFormatException e) {
        }
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

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_maSearch = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_SP = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_delete2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txt_maSP = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_tenSP = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        rbo_conSP = new javax.swing.JRadioButton();
        rbo_hetSP = new javax.swing.JRadioButton();
        F5 = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_ctsp = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_trongluong = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_phamvi = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_tocdo = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_hang = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_Nhap = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        cbo_linhkien = new javax.swing.JComboBox<>();
        cbo_mausac = new javax.swing.JComboBox<>();
        cbo_loai = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_maspct = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbo_sanpham = new javax.swing.JComboBox<>();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        cbo_Khuyenmai = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_timMaSPCT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        txt_giaban = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel7.setBackground(new java.awt.Color(216, 239, 239));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setText("Danh Sách Sản Phẩm");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sanpham1.png"))); // NOI18N

        txt_maSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maSearchActionPerformed(evt);
            }
        });

        btn_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btn_search.setText("Tìm");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        tbl_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SPMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_SP);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Mã Sản Phẩm");

        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trasua.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute1.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute2.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute3.png"))); // NOI18N

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_delete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        btn_delete2.setText("Xóa");
        btn_delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete2ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel30.setText("Mã Sản Phẩm: ");

        txt_maSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maSPActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel31.setText("Tên Sản Phẩm: ");

        txt_tenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenSPActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel32.setText("Trạng Thái");

        buttonGroup2.add(rbo_conSP);
        rbo_conSP.setSelected(true);
        rbo_conSP.setText("Còn Hàng");

        buttonGroup2.add(rbo_hetSP);
        rbo_hetSP.setText("Hết Hàng");

        F5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        F5.setText("F5");
        F5.setMaximumSize(new java.awt.Dimension(84, 31));
        F5.setMinimumSize(new java.awt.Dimension(84, 31));
        F5.setPreferredSize(new java.awt.Dimension(84, 31));
        F5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F5ActionPerformed(evt);
            }
        });

        btn_moi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        btn_moi.setText("Mới");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addGap(47, 47, 47)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(rbo_conSP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbo_hetSP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_tenSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(btn_them)
                        .addGap(61, 61, 61)
                        .addComponent(btn_sua)
                        .addGap(55, 55, 55)
                        .addComponent(btn_delete2)
                        .addGap(42, 42, 42)
                        .addComponent(btn_moi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(356, 356, 356)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(txt_maSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btn_search)
                        .addGap(35, 35, 35)
                        .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 486, Short.MAX_VALUE)))
                .addGap(185, 185, 185))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(440, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel13))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(jLabel9)
                                        .addGap(94, 94, 94)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel22)))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_maSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_search)
                                        .addComponent(jLabel21))
                                    .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel6))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel32))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rbo_conSP)
                                            .addComponent(rbo_hetSP))))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_sua)
                                    .addComponent(btn_them)
                                    .addComponent(btn_delete2)
                                    .addComponent(btn_moi))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel7);

        jPanel8.setBackground(new java.awt.Color(216, 239, 239));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Chi Tiết Sản Phẩm");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sanpham1.png"))); // NOI18N

        tbl_ctsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm CT", "Tên Sản Phẩm ", "Tên Linh Kiện", "Tên Mầu sắc ", "Khuyến Mãi", "Loại ", "Trọng Lượng", "Phạm Vi gió", "Tốc Độ Gió", "Số Lượng Tồn Kho", "Hãng Sản Xuất", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ctsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ctspMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_ctsp);

        jLabel1.setText("Sản Phẩm :");

        jLabel3.setText("Linh Kiện :");

        jLabel4.setText("Mầu Sắc :");

        jLabel10.setText(" Loại :");

        jLabel11.setText("Trọng Lượng :");

        jLabel12.setText("Phạm Vi Gió :");

        jLabel25.setText("Tốc Độ Gió :");

        jLabel26.setText("Số Lượng :");

        jLabel27.setText("Hẵng Sản Xuất :");

        jLabel28.setText("Giá Nhập :");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnNew.setText("Mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        cbo_linhkien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_linhkienActionPerformed(evt);
            }
        });

        cbo_mausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_mausacActionPerformed(evt);
            }
        });

        cbo_loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_loaiActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jLabel18.setText("Mã Sản Phẩm CT :");

        cbo_sanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_sanphamActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        cbo_Khuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_KhuyenmaiActionPerformed(evt);
            }
        });

        jLabel19.setText("Khuyến Mãi :");

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tìm mã SP");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Left.png"))); // NOI18N
        jButton2.setText("ComePack");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel33.setText("Giá Bán :");

        txt_giaban.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 642, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(67, 67, 67)))
                .addGap(396, 396, 396)
                .addComponent(jLabel14)
                .addGap(49, 49, 49))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 384, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 129, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbo_sanpham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_linhkien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_mausac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_trongluong, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_Khuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(66, 66, 66)
                        .addComponent(btnEdit)
                        .addGap(57, 57, 57)
                        .addComponent(btnDelete)
                        .addGap(60, 60, 60)
                        .addComponent(btnNew)
                        .addGap(221, 221, 221)
                        .addComponent(jLabel17)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_timMaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_phamvi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_tocdo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_hang, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_maspct, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_Nhap, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(160, 160, 160))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel14))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel16)))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_maspct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cbo_linhkien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_phamvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cbo_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(cbo_Khuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(cbo_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(cbo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(txt_tocdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_timMaSPCT)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txt_hang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txt_Nhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_trongluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnNew)
                            .addComponent(btnDelete))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản Phẩm Chi Tiết", jPanel8);

        jPanel6.setBackground(new java.awt.Color(216, 239, 239));

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        jButton8.setText("Thoát");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new TrangChu().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        this.dispose();
        new QLThuocTinh().setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.dispose();
        new QLThuocTinh().setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        new QLThuocTinh().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Model_SanPhamCT nv = addRecordSPCT();
        try {
            if (repoSPCT.deleteInfoSPCT(nv) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            loadToTableSpctFillName(repoSPCTFillName.getAllSPCTFillName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txt_maspct.setText("");
        txt_trongluong.setText("");
        txt_phamvi.setText("");
        txt_tocdo.setText("");
        txt_soluong.setText("");
        txt_hang.setText("");
        txt_Nhap.setText("");

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Model_SanPhamCT nv = addRecordSPCT();
        if (checkSPCTEdit()) {
            String IDSanPham = DoiSanPham();
            String IDLinhKien = DoiLinhKien();
            String IDPhanLoai = DoiLoai();
            String IDMauSac = DoiMauSac();
            String IDKhuyenMai = DoiKhuyenmai();
            String sql = "update SanPhamChiTiet\n"
                    + "set IDLinhkien = ? , IDMausac=? , IDKhuyenmai = ? , IDSanpham = ? , IDLoai = ? ,Trongluong = ?,Phamvi=? ,Tocdogio=?,Soluong=?,HangSX=?,Giaban=?\n"
                    + "where IDSanPhamCT = ?";
            try {
                PreparedStatement ptsm = DB_conect.getConnection().prepareStatement(sql);
                ptsm.setString(12, nv.getMaSPCT());
                ptsm.setString(1, IDLinhKien);
                ptsm.setString(2, IDMauSac);
                ptsm.setString(3, IDKhuyenMai);
                ptsm.setString(4, IDSanPham);
                ptsm.setString(5, IDPhanLoai);
                ptsm.setInt(6, nv.getTrongLuong());
                ptsm.setString(7, nv.getPhamvigio());
                ptsm.setInt(8, nv.getTocDo());
                ptsm.setInt(9, nv.getSoLuong());
                ptsm.setString(10, nv.getHangSP());
                ptsm.setInt(11, nv.getGiaban());
                ptsm.executeUpdate();
                JOptionPane.showMessageDialog(this, "Sửa Thành công");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Sửa Thất bại ");
                e.printStackTrace();
            }
            loadToTableSpctFillName(repoSPCTFillName.getAllSPCTFillName());
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Model_SanPhamCT nv = addRecordSPCT();
        if (checkSPCT() == true) {
            String IDSanPham = DoiSanPham();
            String IDLinhKien = DoiLinhKien();
            String IDPhanLoai = DoiLoai();
            String IDMauSac = DoiMauSac();
            String IDKhuyenMai = DoiKhuyenmai();
            String sql = "insert into SanPhamChiTiet \n"
                    + "(IDSanPhamCT,IDSanpham, IDLinhkien , IDMausac,IDKhuyenmai,IDLoai,Trongluong,Phamvi,Tocdogio,Soluong,HangSX,Giaban)\n"
                    + "values \n"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ptsm = DB_conect.getConnection().prepareStatement(sql);
                ptsm.setString(1, nv.getMaSPCT());
                ptsm.setString(2, IDSanPham);
                ptsm.setString(3, IDLinhKien);
                ptsm.setString(4, IDMauSac);
                ptsm.setString(5, IDKhuyenMai);
                ptsm.setString(6, IDPhanLoai);
                ptsm.setInt(7, nv.getTrongLuong());
                ptsm.setString(8, nv.getPhamvigio());
                ptsm.setInt(9, nv.getTocDo());
                ptsm.setInt(10, nv.getSoLuong());
                ptsm.setString(11, nv.getHangSP());
                ptsm.setInt(12, nv.getGiaban());
                ptsm.executeUpdate();
                JOptionPane.showMessageDialog(this, "Thêm Thành công");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Thêm Thất bại ");
                e.printStackTrace();
            }
            loadToTableSpctFillName(repoSPCTFillName.getAllSPCTFillName());
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void tbl_ctspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ctspMouseClicked
        ShowDataSPCT();

    }//GEN-LAST:event_tbl_ctspMouseClicked

    private void F5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F5ActionPerformed
        loadToTableSp();
        txt_maSearch.setText("");

    }//GEN-LAST:event_F5ActionPerformed

    private void txt_tenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSPActionPerformed

    private void txt_maSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maSPActionPerformed

    private void btn_delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete2ActionPerformed
        Model_sanPham nv = addRecordSP();
        try {
            if (repoSP.deleteInfoSP(nv) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            cbo_sanpham.removeAllItems();
            loadToTableSp();
            loadToTableSpctFillName(repoSPCTFillName.getAllSPCTFillName());
            showCBO();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_delete2ActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        Model_sanPham nv = addRecordSP();
        if (checkSP() == true) {
            try {
                if (repoSP.addInfoSP(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
                cbo_sanpham.removeAllItems();
                loadToTableSp();
                showCBO();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        Model_sanPham nv = addRecordSP();
        if (checkSPEdit()) {
            try {
                if (repoSP.editInfoSP(nv) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
                cbo_sanpham.removeAllItems();
                loadToTableSp();
                showCBO();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tbl_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPMouseClicked
        // TODO add your handling code here:
        ShowDataSP();
    }//GEN-LAST:event_tbl_SPMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String tuKhoa = txt_maSearch.getText();
        loadToTableSearchSp(tuKhoa);


    }//GEN-LAST:event_btn_searchActionPerformed

    private void txt_maSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maSearchActionPerformed

    private void cbo_linhkienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_linhkienActionPerformed

    }//GEN-LAST:event_cbo_linhkienActionPerformed

    private void cbo_sanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_sanphamActionPerformed

    }//GEN-LAST:event_cbo_sanphamActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        this.dispose();
        new KhuyenMai().setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        txt_maSP.setText("");
        txt_tenSP.setText("");
    }//GEN-LAST:event_btn_moiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checkSPCTSearch() == true) {
            String tuKhoa = txt_timMaSPCT.getText();
            loadToTableSearchSpct(tuKhoa);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadToTableSpctFillName();
        txt_timMaSPCT.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbo_loaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_loaiActionPerformed

    }//GEN-LAST:event_cbo_loaiActionPerformed

    private void cbo_KhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_KhuyenmaiActionPerformed

        try {
            double GiaNhap = Double.parseDouble(txt_Nhap.getText());
            Model_KhuyenMai kh = repoKM.getAllLK().get(cbo_Khuyenmai.getSelectedIndex());
            double giaBan = GiaNhap * (100 - kh.getPhanTramkhuyenmai()) / 100;
            txt_giaban.setText(String.format("%.0f", giaBan));
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_cbo_KhuyenmaiActionPerformed

    private void cbo_mausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_mausacActionPerformed
    }//GEN-LAST:event_cbo_mausacActionPerformed

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
            java.util.logging.Logger.getLogger(sanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton F5;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btn_delete2;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbo_Khuyenmai;
    private javax.swing.JComboBox<String> cbo_linhkien;
    private javax.swing.JComboBox<String> cbo_loai;
    private javax.swing.JComboBox<String> cbo_mausac;
    private javax.swing.JComboBox<String> cbo_sanpham;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbo_conSP;
    private javax.swing.JRadioButton rbo_hetSP;
    private javax.swing.JTable tbl_SP;
    private javax.swing.JTable tbl_ctsp;
    private javax.swing.JTextField txt_Nhap;
    private javax.swing.JTextField txt_giaban;
    private javax.swing.JTextField txt_hang;
    private javax.swing.JTextField txt_maSP;
    private javax.swing.JTextField txt_maSearch;
    private javax.swing.JTextField txt_maspct;
    private javax.swing.JTextField txt_phamvi;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_tenSP;
    private javax.swing.JTextField txt_timMaSPCT;
    private javax.swing.JTextField txt_tocdo;
    private javax.swing.JTextField txt_trongluong;
    // End of variables declaration//GEN-END:variables

}
