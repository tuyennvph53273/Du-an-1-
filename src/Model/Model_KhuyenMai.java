/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author duong
 */
public class Model_KhuyenMai {

    public static void setRowCount(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private  String IdKhuyenMai;
    private  Integer PhanTramkhuyenmai;
    private String NgayBatDau;
    private String NgayKetThuc;
    private Boolean TrangThaiKM;
    public Model_KhuyenMai() {
    }

    @Override
    public String toString() {
        return "Model_KhuyenMai{" + "IdKhuyenMai=" + IdKhuyenMai + ", PhanTramkhuyenmai=" + PhanTramkhuyenmai + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", TrangThaiKM=" + TrangThaiKM + '}';
    }



    public Model_KhuyenMai(String IdKhuyenMai, Integer PhanTramkhuyenmai, String NgayBatDau, String NgayKetThuc, Boolean TrangThaiKM) {
        this.IdKhuyenMai = IdKhuyenMai;
        this.PhanTramkhuyenmai = PhanTramkhuyenmai;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TrangThaiKM = TrangThaiKM;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public String getIdKhuyenMai() {
        return IdKhuyenMai;
    }

    public void setIdKhuyenMai(String IdKhuyenMai) {
        this.IdKhuyenMai = IdKhuyenMai;
    }

    public Integer getPhanTramkhuyenmai() {
        return PhanTramkhuyenmai;
    }

    public void setPhanTramkhuyenmai(Integer PhanTramkhuyenmai) {
        this.PhanTramkhuyenmai = PhanTramkhuyenmai;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public Boolean getTrangThaiKM() {
        return TrangThaiKM;
    }

    public void setTrangThaiKM(Boolean TrangThaiKM) {
        this.TrangThaiKM = TrangThaiKM;
    }

   
}
