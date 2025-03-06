package View;

import Model.Model_BanHangGH;
import Model.Model_BanHangHD;
import Model.Model_BanHangSP;
import Model.Model_SanPhamCT;
import Model.Model_Voucher;
import Model.Model_khachHang;
import Model.Model_nhanvien;
import Model.Model_sanPham;
import Repository.Repo_BanHangGH;
import Repository.Repo_BanHangHD;
import Repository.Repo_BanHangSP;
import Repository.Repo_Khachhang;
import Repository.Repo_SanPham;
import Repository.Repo_Voucher;
import Repository.Repo_sanPhamCT;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gigabyte
 */
public class BanHang extends javax.swing.JFrame {

    Repo_BanHangHD repoBHHD = new Repo_BanHangHD();
    Repo_BanHangSP repoBHSP = new Repo_BanHangSP();
    Repo_BanHangGH repoBHGH = new Repo_BanHangGH();
    Repo_SanPham reposp = new Repo_SanPham();
    Repo_sanPhamCT repospct = new Repo_sanPhamCT();
    Repo_Voucher repoVC = new Repo_Voucher();
    Repo_Khachhang repoKH = new Repo_Khachhang();

    DefaultTableModel modelBHHD = new DefaultTableModel();
    DefaultTableModel modelBHSP = new DefaultTableModel();
    DefaultTableModel modelBHGH = new DefaultTableModel();

    int i = 0;

    public BanHang() {
        initComponents();
        setLocationRelativeTo(null);

        modelBHHD = (DefaultTableModel) tbl_HD.getModel();
        modelBHSP = (DefaultTableModel) tbl_SP.getModel();
        modelBHGH = (DefaultTableModel) tbl_GioH.getModel();
        String idHoaDon = null;

        LoadToTableHD(repoBHHD.getAllBanHangHD(idHoaDon));
        LoadToTableSP(repoBHSP.getAllBanHangSP());
        ShowCBOHD();
    }

    public BanHang(String maKH, String tenKH, String sdt) {
        initComponents();
        txt_maKH.setText(maKH);
        txt_tenKH.setText(tenKH);
        txt_SDT.setText(sdt);
    }
//Phan HoaDOn

    public void LoadToTableHD(ArrayList<Model_BanHangHD> allBanHangHD) {
        modelBHHD.setRowCount(0);
        int stt = 1;
        String idHoaDon = null;
        for (Model_BanHangHD mfn : repoBHHD.getAllBanHangHD(idHoaDon)) {
            modelBHHD.addRow(new Object[]{
                stt++,
                mfn.getIDHoaDon(),
                mfn.getTenKhachHang(),
                "0" + mfn.getSDT(),
                mfn.getThoiDiemTao(),
                mfn.getTongGia()
            });
        }
    }

    public void LoadToTableHDGH() {
        modelBHHD.setRowCount(0);
        int stt = 1;
        for (Model_BanHangHD mfn : repoBHHD.getAllBanHangHDGH()) {
            modelBHHD.addRow(new Object[]{
                stt++,
                mfn.getIDHoaDon(),
                mfn.getTenKhachHang(),
                "0" + mfn.getSDT(),
                mfn.getThoiDiemTao(),
                mfn.getTongGia()
            });
        }
    }
//phan san pham

    public void LoadToTableSP(ArrayList<Model_BanHangSP> allBanHangSP) {
        modelBHSP.setRowCount(0);
        int stt = 1;
        for (Model_BanHangSP mfn : repoBHSP.getAllBanHangSP()) {
            modelBHSP.addRow(new Object[]{
                stt++,
                mfn.getIDSanPhamCT(),
                mfn.getTenSanPhamCT(),
                mfn.getMauSac(),
                mfn.getLoai(),
                mfn.getSoLuongTon(),
                mfn.getGiaBan()
            });
        }
    }

    public void LoadToTableSPGH() {
        modelBHSP.setRowCount(0);
        int stt = 1;
        for (Model_BanHangSP mfn : repoBHSP.getAllBanHangSP()) {
            modelBHSP.addRow(new Object[]{
                stt++,
                mfn.getIDSanPhamCT(),
                mfn.getTenSanPhamCT(),
                mfn.getMauSac(),
                mfn.getLoai(),
                mfn.getSoLuongTon(),
                mfn.getGiaBan()
            });
        }
    }

    public void LoadToTableSPGHSearch(String tuKhoa) {
        modelBHSP.setRowCount(0);
        int stt = 1;
        for (Model_BanHangSP mfn : repoBHSP.getAllBanHangSPSearch(tuKhoa)) {
            modelBHSP.addRow(new Object[]{
                stt++,
                mfn.getIDSanPhamCT(),
                mfn.getTenSanPhamCT(),
                mfn.getMauSac(),
                mfn.getLoai(),
                mfn.getSoLuongTon(),
                mfn.getGiaBan()
            });
        }
    }

    public Boolean checkSP() {

        if (txt_maSPCT.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống mã sản SPCT");
            return false;
        }
        return true;
    }
// phan gio hang

    public void LoadToTableGH(ArrayList<Model_BanHangGH> allBanHangGH) {
        modelBHGH.setRowCount(0);
        int stt = 1;
        for (Model_BanHangGH mfn : allBanHangGH) {
            modelBHGH.addRow(new Object[]{
                stt++,
                mfn.getIDSanPhamCT(),
                mfn.getTenSanPhamCT(),
                mfn.getSoLuongSPGH(),
                mfn.getGiaBan(),});
        }
    }

    public void LoadToTableGH(String idHoaDon) {
        modelBHGH.setRowCount(0);
        int stt = 1;
        for (Model_BanHangGH mfn : repoBHGH.getAllBanHangGHSP(idHoaDon)) {
            modelBHGH.addRow(new Object[]{
                stt++,
                mfn.getIDSanPhamCT(),
                mfn.getTenSanPhamCT(),
                mfn.getSoLuongSPGH(),
                mfn.getGiaBan(),});
        }
    }

    public void LoadToTableGHSP(String idHoaDon) {
        modelBHGH.setRowCount(0);
        int stt = 1;
        for (Model_BanHangGH mfn : repoBHGH.getAllBanHangGH(idHoaDon)) {
            modelBHGH.addRow(new Object[]{
                stt++,
                mfn.getIDSanPhamCT(),
                mfn.getTenSanPhamCT(),
                mfn.getSoLuongSPGH(),
                mfn.getGiaBan(),});
        }
    }

    public void ShowCBOHD() {

        for (Model_Voucher kh : repoVC.getAllVC()) {
            if (kh.getPhanTramGiamGIa() != null) {
                cbo_Voucher.addItem(kh.getPhanTramGiamGIa() + "%");
            }
        }
    }

    public void Tienthua() {
        try {
            int tienKhachTra = Integer.parseInt(txt_tienKhachTra.getText());
            int tongGiaTri = Integer.parseInt(lb_tongGiaTT.getText());
            if (tienKhachTra >= tongGiaTri) {
                int tienThua = tienKhachTra - tongGiaTri;
                lb_tienThua.setText(tienThua + "");
            } else {
                JOptionPane.showMessageDialog(this, "Tiền khách trả không đủ!");
            }
        } catch (NumberFormatException ex) {
        }
    }

    void showdataHD() {
        i = tbl_HD.getSelectedRow();
        Model_BanHangHD ml = repoBHHD.getAllBanHangHDGH().get(i);
        lb_maHoaDon.setText(ml.getIDHoaDon());
        lb_ThoiDiem.setText(ml.getThoiDiemTao());
        lb_TongGia.setText(ml.getTongGia() + "");
        lb_tongGiaTT.setText(ml.getTongGia() + "");
        Tienthua();
    }

    public boolean checkTT() {
        if (txt_tienKhachTra.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống tiền khách thanh toán ");
            return false;
        }
        try {
            int a = Integer.parseInt(txt_tienKhachTra.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tiền khách trả phải là kiểu số nguyên");
        }
        if (Integer.parseInt(txt_tienKhachTra.getText()) < Integer.parseInt(lb_tongGiaTT.getText())) {
            JOptionPane.showMessageDialog(this, "Thanh Toán Thất bại Vui Lòng Nhập Đúng Giá Lớn Hơn Hoặc Bằng Tống Giá Thanh Toán ");
            return false;
        }
        return true;
    }

    public boolean checkKH() {
        if (txt_maKH.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Không được để chống mã khách hàng ");
            return false;
        }

        for (Model_khachHang mn : repoKH.getAllKH()) {
            if (txt_maKH.getText().trim().equalsIgnoreCase(mn.getMaKH())) {
                JOptionPane.showMessageDialog(this, "Không được Trùng mã Khách Hàng");
                return false;
            }
        }
        try {
            int a = Integer.parseInt(txt_SDT.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "SDT phải là kiểu số Nguyên");
        }

        if (Integer.parseInt(txt_SDT.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "SDT Không Được Âm ");
            return false;
        }

        return true;
    }

    public boolean checkSL(int soLuong) {
        Model_BanHangSP spct = repoBHSP.getAllBanHangSP().get(tbl_SP.getSelectedRow());
        String idSPCT = spct.getIDSanPhamCT();
        if (soLuong < 0) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải lớn hơn 0");
            return false;
        }
        if (soLuong > spct.getSoLuongTon()) {
            JOptionPane.showMessageDialog(this, "Số Lượng Phải nhỏ hơn số lượng tồn kho ");
            return false;
        }
        return true;
    }

    public void fillData(String MaKH, String TenKH, String SDT) {
        txt_tenKH.setText(TenKH);
        txt_maKH.setText(MaKH);
        txt_SDT.setText(SDT);
    }

    Model_khachHang addRecostKH() {
        Model_khachHang a = new Model_khachHang();
        a.setMaKH(txt_maKH.getText());
        a.setTenKH(txt_tenKH.getText());
        try {
            a.setSDT(Integer.parseInt(txt_SDT.getText()));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HD = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_GioH = new javax.swing.JTable();
        btn_DeleteGH = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_SP = new javax.swing.JTable();
        btn_xemChiTiet = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_maSPCT = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_maKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_tenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        btn_deleteHD = new javax.swing.JButton();
        btn_SelectKH = new javax.swing.JButton();
        btn_AddKH = new javax.swing.JButton();
        btn_AddHD = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbo_Voucher = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_tienKhachTra = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_ThanhToan = new javax.swing.JButton();
        lb_maHoaDon = new javax.swing.JLabel();
        lb_ThoiDiem = new javax.swing.JLabel();
        lb_TongGia = new javax.swing.JLabel();
        lb_tongGiaTT = new javax.swing.JLabel();
        lb_tienThua = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(216, 239, 239));

        jPanel1.setBackground(new java.awt.Color(216, 239, 239));

        jPanel3.setBackground(new java.awt.Color(216, 239, 239));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 51));
        jLabel1.setText("Quầy bán hàng ");

        jPanel2.setBackground(new java.awt.Color(216, 239, 239));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(4, 0, 0, 0, new java.awt.Color(255, 0, 204)), "Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        tbl_HD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID Hóa Đơn", "Tên Khách Hàng", "SDT", "Thời Điểm Tạo", "Tổng Giá "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_HD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_HDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_HD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(216, 239, 239));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(4, 0, 0, 0, new java.awt.Color(255, 51, 204)), "Giỏ Hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        tbl_GioH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID Sản Phẩm CT", "Tên Sản Phẩm ", "Số Lượng", "Đơn Giá "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_GioH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_GioHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_GioH);

        btn_DeleteGH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Xoa.png"))); // NOI18N
        btn_DeleteGH.setText("Xóa Giỏ Hàng");
        btn_DeleteGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteGHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_DeleteGH)
                .addGap(394, 394, 394))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btn_DeleteGH))
        );

        jPanel5.setBackground(new java.awt.Color(216, 239, 239));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(4, 0, 0, 0, new java.awt.Color(255, 0, 204)), "Sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 51, 51))); // NOI18N

        tbl_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID Sản Phẩm CT", "Tên Sản Phẩm", "Màu Sắc", "Loại ", "Số Lượng Tồn Kho", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane4.setViewportView(tbl_SP);

        btn_xemChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        btn_xemChiTiet.setText("Xem Chi Tiết Sản Phẩm");
        btn_xemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemChiTietActionPerformed(evt);
            }
        });

        jLabel5.setText("Tìm Theo Mã SP : ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        jButton3.setText("Come back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(331, 331, 331)
                                .addComponent(btn_xemChiTiet))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_maSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_xemChiTiet))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Left.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(232, 232, 232))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(216, 239, 239));

        jPanel7.setBackground(new java.awt.Color(216, 239, 239));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 153)), "Thông Tin Khách Hàng ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(255, 102, 51))); // NOI18N

        jLabel2.setText("Mã Khách Hàng ");

        jLabel3.setText("Tên Khách Hàng ");

        jLabel4.setText("SDT");

        btn_deleteHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Xoa.png"))); // NOI18N
        btn_deleteHD.setText("Xóa Hóa Đơn");
        btn_deleteHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteHDActionPerformed(evt);
            }
        });

        btn_SelectKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ChonKhachHnag.png"))); // NOI18N
        btn_SelectKH.setText("Chọn");
        btn_SelectKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectKHActionPerformed(evt);
            }
        });

        btn_AddKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ADDKhachHang.png"))); // NOI18N
        btn_AddKH.setText("Thêm Khách Hàng");
        btn_AddKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddKHActionPerformed(evt);
            }
        });

        btn_AddHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btn_AddHD.setText("Tạo Hóa Đơn");
        btn_AddHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddHDActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btn_AddHD)
                        .addGap(29, 29, 29)
                        .addComponent(btn_deleteHD))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_SelectKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_AddKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_maKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_SelectKH)
                        .addComponent(btn_AddKH))
                    .addComponent(jButton4))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deleteHD)
                    .addComponent(btn_AddHD))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(216, 239, 239));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 153)), "Thông Tin Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        jLabel6.setText("Mã Hóa Đơn");

        jLabel7.setText("Thời Điểm Tạo");

        jLabel8.setText("Vourcher");

        cbo_Voucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_VoucherActionPerformed(evt);
            }
        });

        jLabel9.setText("Tổng Giá ");

        jLabel10.setText("Tổng Giá Thanh Toán");

        jLabel11.setText("Tiền Khách Trả");

        txt_tienKhachTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienKhachTraActionPerformed(evt);
            }
        });

        jLabel12.setText("Tiền Thừa");

        btn_ThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ThanhToan.png"))); // NOI18N
        btn_ThanhToan.setText("Thanh Toán");
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        lb_tongGiaTT.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb_tongGiaTT.setForeground(new java.awt.Color(255, 51, 51));

        lb_tienThua.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lb_tienThua.setForeground(new java.awt.Color(51, 255, 51));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/hoadon.png"))); // NOI18N
        jButton5.setText("Xem Lịch Sửa Giao Dịch");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(45, 45, 45)
                                .addComponent(lb_TongGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_ThoiDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_maHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbo_Voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_tongGiaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_tienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lb_tienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(60, 60, 60))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lb_maHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lb_ThoiDiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lb_TongGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbo_Voucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lb_tongGiaTT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_tienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lb_tienThua))
                .addGap(55, 55, 55)
                .addComponent(btn_ThanhToan)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new TrangChu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_deleteHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteHDActionPerformed
        try {
            String idHoaDon = tbl_HD.getValueAt(tbl_HD.getSelectedRow(), 1).toString();

            if (repoBHHD.delereInfoBangHangHD(idHoaDon) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            ArrayList<Model_BanHangHD> allBanHangHD = null;
            LoadToTableHD(allBanHangHD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteHDActionPerformed

    private void btn_AddHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddHDActionPerformed
        String idKH = txt_maKH.getText();
        if (txt_maKH.getText().trim().equalsIgnoreCase("")) {
            try {
                repoBHHD.addInfoBangHangHDNoKH();
                JOptionPane.showMessageDialog(this, "Tạo Hóa Đơn Thành Công");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Tạo Hóa Đơn Thất Bại");

            }
        } else {
            try {
                repoBHHD.addInfoBangHangHD(idKH);
                JOptionPane.showMessageDialog(this, "Tạo Hóa Đơn Thành Công");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Tạo Hóa Đơn Thất Bại");

            }
        }
        LoadToTableHD(repoBHHD.getAllBanHangHD(idKH));
    }//GEN-LAST:event_btn_AddHDActionPerformed

    private void btn_DeleteGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteGHActionPerformed
        int selectedRowHD = tbl_HD.getSelectedRow();

        int soLuongTon = repospct.getSoLuongTonById(
                tbl_GioH.getValueAt(tbl_GioH.getSelectedRow(), 1).toString()
        );
        String idHoaDonOnTbl = tbl_HD.getValueAt(tbl_HD.getSelectedRow(), 1).toString();
        Model_BanHangGH gh = repoBHGH.getAllBanHangGHSP(idHoaDonOnTbl).get(tbl_GioH.getSelectedRow());
        String idSPCT = tbl_GioH.getValueAt(tbl_GioH.getSelectedRow(), 1).toString();
        int soLuongTonKhoMoi = soLuongTon + gh.getSoLuongSPGH();
        try {
            if (repoBHGH.DeleteInfoGH(idSPCT, idHoaDonOnTbl, soLuongTonKhoMoi) != null) {
                JOptionPane.showMessageDialog(this, " Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            LoadToTableGH(repoBHGH.getAllBanHangGH(idHoaDonOnTbl));
            LoadToTableSPGH();
            LoadToTableHDGH();
            tbl_HD.setRowSelectionInterval(selectedRowHD, selectedRowHD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_DeleteGHActionPerformed

    private void btn_AddKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddKHActionPerformed
        Model_khachHang km = addRecostKH();
        if (checkKH() == true) {
            try {
                if (repoBHGH.addInfoKH(km) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_AddKHActionPerformed

    private void btn_xemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xemChiTietActionPerformed
        this.dispose();
        new XemSPCT().setVisible(true);
    }//GEN-LAST:event_btn_xemChiTietActionPerformed

    private void btn_SelectKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectKHActionPerformed
        new ChoseKhachHang(this).setVisible(true);
    }//GEN-LAST:event_btn_SelectKHActionPerformed

    private void tbl_HDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HDMouseClicked

        String idHoaDon = tbl_HD.getValueAt(
                tbl_HD.getSelectedRow(),
                1).toString();
        showdataHD();
        LoadToTableGH(repoBHGH.getAllBanHangGH(idHoaDon));
    }//GEN-LAST:event_tbl_HDMouseClicked

    private void tbl_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPMouseClicked
        int selectedRowHD = tbl_HD.getSelectedRow();
        Model_BanHangHD hd = repoBHHD.getAllBanHangHDGH().get(tbl_HD.getSelectedRow());
        String idHoaDon = hd.getIDHoaDon();
        Model_BanHangSP spct = repoBHSP.getAllBanHangSP().get(tbl_SP.getSelectedRow());
        String idSPCT = spct.getIDSanPhamCT();
        int soLuong = 0;
        boolean isValid = false;
        while (!isValid) {
            String input = JOptionPane.showInputDialog("Nhập số lượng sản phẩm :");
            if (input == null) {
                break;
            }
            try {
                soLuong = Integer.parseInt(input);
                if (soLuong > 0 && soLuong <= spct.getSoLuongTon()) {
                    isValid = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên không âm và nhỏ hơn hoặc bằng số lượng tồn kho!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên!");
            }
        }

        int giaBan = spct.getGiaBan();
        int soLuongConLai = Integer.valueOf(spct.getSoLuongTon()) - soLuong;

        if (isValid && repoBHSP.AddBHSP(idHoaDon, idSPCT, soLuong, giaBan, soLuongConLai) != null) {
            JOptionPane.showMessageDialog(this, "Thêm Sản Phẩm Thành Công ");
            LoadToTableGHSP(idHoaDon);
            LoadToTableSPGH();
            LoadToTableHDGH();
            tbl_HD.setRowSelectionInterval(selectedRowHD, selectedRowHD);
        }
    }//GEN-LAST:event_tbl_SPMouseClicked

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        if (checkTT() == true) {
            try {
                String idHoaDon = tbl_HD.getValueAt(tbl_HD.getSelectedRow(), 1).toString();

                if (repoBHHD.ThanhToan(idHoaDon) != null) {
                    JOptionPane.showMessageDialog(this, "Thanh Toán  thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thanh Toán thất bại");
                }
                ArrayList<Model_BanHangHD> allBanHangHD = null;
                LoadToTableHD(allBanHangHD);
                tbl_GioH.removeAll();
                lb_maHoaDon.setText("");
                lb_ThoiDiem.setText("");
                lb_TongGia.setText("");
                lb_tongGiaTT.setText("");
                lb_tienThua.setText("");
                txt_tienKhachTra.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (checkSP() == true) {
            String tuKhoa = txt_maSPCT.getText();
            LoadToTableSPGHSearch(tuKhoa);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        LoadToTableSPGH();
        txt_maSPCT.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txt_maKH.setText("");
        txt_tenKH.setText("");
        txt_SDT.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new LichSuMuaHang().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_tienKhachTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienKhachTraActionPerformed
//        Tienthua();
    }//GEN-LAST:event_txt_tienKhachTraActionPerformed
    private void cbo_VoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_VoucherActionPerformed
        Model_BanHangHD ml = repoBHHD.getAllBanHangHDGH().get(i);
        Model_Voucher kh = repoVC.getAllVC().get(cbo_Voucher.getSelectedIndex());
        lb_tongGiaTT.setText((ml.getTongGia() * (100 - kh.getPhanTramGiamGIa()) / 100) + "");

    }//GEN-LAST:event_cbo_VoucherActionPerformed

    private void tbl_GioHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_GioHMouseClicked

//        Model_BanHangHD hd = repoBHHD.getAllBanHangHDGH().get(tbl_HD.getSelectedRow());
//        String idHoaDon = hd.getIDHoaDon();
//        Model_BanHangSP spct = repoBHSP.getAllBanHangSP().get(tbl_SP.getSelectedRow());
//        String idSPCT = spct.getIDSanPhamCT();
//        Model_BanHangGH gh = repoBHGH.getAllBanHangGHSP().get(tbl_GioH.getSelectedRow());
//        gh.getIDSanPhamCT();
//        int soLuong = 0;
//        boolean isValid = false;
//        while (!isValid) {
//            String input = JOptionPane.showInputDialog("Nhập số lượng sản phẩm :");
//            if (input == null) {
//                break;
//            }
//            try {
//                soLuong = Integer.parseInt(input);
//                if (soLuong > 0 && soLuong <= spct.getSoLuongTon()) {
//                    isValid = true;
//                } else {
//                    JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên không âm và nhỏ hơn hoặc bằng số lượng tồn kho!");
//                }
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên!");
//            }
//        }
//
//        int soLuongConLai = Integer.valueOf(spct.getSoLuongTon()) + soLuong;
//
//        if (isValid && repoBHSP.AddBHSP(idHoaDon, idSPCT, soLuong soLuongConLai) != null) {
//            JOptionPane.showMessageDialog(this, "Thêm Sản Phẩm Thành Công ");
//            LoadToTableGHSP(idHoaDon);
//            LoadToTableSPGH();
//            LoadToTableHDGH();
//        }               
//        

    }//GEN-LAST:event_tbl_GioHMouseClicked

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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AddHD;
    private javax.swing.JButton btn_AddKH;
    private javax.swing.JButton btn_DeleteGH;
    private javax.swing.JButton btn_SelectKH;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_deleteHD;
    private javax.swing.JButton btn_xemChiTiet;
    private javax.swing.JComboBox<String> cbo_Voucher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lb_ThoiDiem;
    private javax.swing.JLabel lb_TongGia;
    private javax.swing.JLabel lb_maHoaDon;
    private javax.swing.JLabel lb_tienThua;
    private javax.swing.JLabel lb_tongGiaTT;
    private javax.swing.JTable tbl_GioH;
    private javax.swing.JTable tbl_HD;
    private javax.swing.JTable tbl_SP;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_maSPCT;
    private javax.swing.JTextField txt_tenKH;
    private javax.swing.JTextField txt_tienKhachTra;
    // End of variables declaration//GEN-END:variables
}
