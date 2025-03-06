package View;

import java.sql.*;
import Model.Model_KhuyenMai;
import Model.Model_MauSac;
import Repository.Repo_KhuyenMai;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KhuyenMai extends javax.swing.JFrame {

    Repo_KhuyenMai RepoKM = new Repo_KhuyenMai();
    DefaultTableModel modelKM = new DefaultTableModel();
    int i = 0;

    public KhuyenMai() {
        initComponents();
        modelKM = (DefaultTableModel) tblKhuyenMai.getModel();
        LoadToTableKM();
        setLocationRelativeTo(null);
    }

    void LoadToTableKM() {
        modelKM.setRowCount(0);
        for (Model.Model_KhuyenMai m_cd : RepoKM.getAllLK()) {
            modelKM.addRow(new Object[]{
                m_cd.getIdKhuyenMai(),
                m_cd.getPhanTramkhuyenmai(),
                m_cd.getNgayBatDau(),
                m_cd.getNgayKetThuc(),
                m_cd.getTrangThaiKM() ? "Còn hạn" : "hết hạn"
            });
        }
    }
    
    public Boolean checkKM(){
        if (txtMaKM.getText().trim().equalsIgnoreCase("") || txtGiaTri.getText().trim().equalsIgnoreCase("") || txtThoiGianEnd.getText().trim().equalsIgnoreCase("") || txtThoiGianStart.getText().trim().equalsIgnoreCase("") ) {
            JOptionPane.showMessageDialog( this , "Không được để trống dữ liệu");
         return false;
        }
        for (Model_KhuyenMai ml : RepoKM.getAllLK()) {
            if (txtMaKM.getText().trim().equalsIgnoreCase(ml.getIdKhuyenMai())) {
                JOptionPane.showMessageDialog(this, "Không Được trùng mã Khuyến Mãi");
                return false;
            }
        }
        
        try {
            int a = Integer.parseInt(txtGiaTri.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Phần Trăm Khuyến mãi phải là kiểu số nguyên");
        }
        
        return true;
    }
    public Boolean checkKMEdit(){
        if (txtMaKM.getText().trim().equalsIgnoreCase("") || txtMaKM.getText().trim().equalsIgnoreCase("") || txtThoiGianEnd.getText().trim().equalsIgnoreCase("") || txtThoiGianStart.getText().trim().equalsIgnoreCase("") ) {
            JOptionPane.showMessageDialog( this , "Không được để trống dữ liệu");
         return false;
        }
        
        try {
            int a = Integer.parseInt(txtGiaTri.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Phần Trăm Khuyến mãi phải là kiểu số nguyên");
        }
        
        return true;
    }

    void LoadToTableSearchKM(String tuKhoa) {
        modelKM.setRowCount(0);
        for (Model.Model_KhuyenMai m_cd : RepoKM.getAllSearchM(tuKhoa)) {
            modelKM.addRow(new Object[]{
                m_cd.getIdKhuyenMai(),
                m_cd.getPhanTramkhuyenmai(),
                m_cd.getNgayBatDau(),
                m_cd.getNgayKetThuc(),
                m_cd.getTrangThaiKM() ? "Còn hạn" : "hết hạn"
            });
        }
    }

    void showdataKM() {
        i = tblKhuyenMai.getSelectedRow();
        Model_KhuyenMai ml = RepoKM.getAllLK().get(i);  
        txtMaKM.setText(ml.getIdKhuyenMai());
        txtGiaTri.setText(ml.getPhanTramkhuyenmai() + "");
        txtThoiGianStart.setText(ml.getNgayBatDau());
        txtThoiGianEnd.setText(ml.getNgayBatDau());
        rdoTrangThai.setSelected(ml.getTrangThaiKM());
        rbnhethan.setSelected(!ml.getTrangThaiKM());
    }

    Model_KhuyenMai addrecost() {
        Model_KhuyenMai km = new Model_KhuyenMai();
        km.setIdKhuyenMai(txtMaKM.getText());
        km.setNgayBatDau(txtThoiGianStart.getText());
        km.setNgayKetThuc(txtThoiGianEnd.getText());
        try {
            km.setPhanTramkhuyenmai(Integer.valueOf(txtGiaTri.getText()));
        } catch (NumberFormatException e) {
        }
        km.setTrangThaiKM(rdoTrangThai.isSelected());
        return km;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtGiaTri = new javax.swing.JTextField();
        txtThoiGianStart = new javax.swing.JTextField();
        txtThoiGianEnd = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rdoTrangThai = new javax.swing.JRadioButton();
        rbnhethan = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(222, 242, 242));
        jPanel3.setPreferredSize(new java.awt.Dimension(850, 520));

        jPanel2.setBackground(new java.awt.Color(216, 239, 239));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(342, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Mã khuyến mãi:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Phần trăm khuyến mãi :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Thời gian bắt đầu:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Thời gian kết thúc:");

        txtThoiGianEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianEndActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        btnClear.setText("Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel2.setText("Trạng Thái :");

        buttonGroup1.add(rdoTrangThai);
        rdoTrangThai.setText("Còn Hạn");

        buttonGroup1.add(rbnhethan);
        rbnhethan.setText("Hết Hạn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1)
                                .addGap(57, 57, 57)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaKM, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(txtGiaTri))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(31, 31, 31)
                                .addComponent(btnSua)
                                .addGap(47, 47, 47)
                                .addComponent(btnXoa)
                                .addGap(29, 29, 29)
                                .addComponent(btnClear)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rdoTrangThai)
                        .addGap(27, 27, 27)
                        .addComponent(rbnhethan))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThoiGianStart, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThoiGianEnd)))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtThoiGianStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiGianEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdoTrangThai)
                    .addComponent(rbnhethan))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnClear)
                    .addComponent(btnThem))
                .addGap(36, 36, 36))
        );

        jPanel5.setBackground(new java.awt.Color(216, 239, 239));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setPreferredSize(new java.awt.Dimension(342, 0));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Tìm mã:");

        btnTim.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KM", "Phần trăm Khuyến Mãi", "ngày bắt đầu ", "ngày kết thúc ", "trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Danh Sách Khuyến Mãi");

        btnExit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Left.png"))); // NOI18N
        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Left.png"))); // NOI18N
        jButton1.setText("Come Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cute7.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cute7.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTim)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(btnExit))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(jLabel7)
                    .addComponent(jButton1))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Model_KhuyenMai km = addrecost();
        if (checkKM()==true) {
            try {
            if (RepoKM.addInfoKM(km) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
            LoadToTableKM();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        Model_KhuyenMai km = addrecost();
        try {
            if (RepoKM.deleteInfoLK(km) != null) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            LoadToTableKM();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        Model_KhuyenMai km = addrecost();
        if (checkKMEdit()==true) {
            try {
            if (RepoKM.editInfoKM(km) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
            LoadToTableKM();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtMaKM.setText("");
        txtGiaTri.setText("");
        txtThoiGianEnd.setText("");
        txtThoiGianStart.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String tuKhoa = txtTim.getText();
        LoadToTableSearchKM(tuKhoa);
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        showdataKM();
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
        new TrangChu().setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtThoiGianEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiGianEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThoiGianEndActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      txtTim.setText("");
      LoadToTableKM();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(KhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbnhethan;
    private javax.swing.JRadioButton rdoTrangThai;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtThoiGianEnd;
    private javax.swing.JTextField txtThoiGianStart;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables

}
