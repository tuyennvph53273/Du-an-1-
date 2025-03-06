/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author duyphan
 */
public class Model_nhanvien {
    private String IDNhanVien;
    private String IDLogin;
    private String TenNhanVien;
    private Integer Tuoi;
    private String Diachi;
    private Integer SDT;
    private Boolean Gioitinh;
    private String Ngaybatdaulam;
    private Boolean TrangThaiNV;

    public Model_nhanvien() {
    }

    public Model_nhanvien(String IDNhanVien, String IDLogin, String TenNhanVien, Integer Tuoi, String Diachi, Integer SDT, Boolean Gioitinh, String Ngaybatdaulam, Boolean TrangThaiNV) {
        this.IDNhanVien = IDNhanVien;
        this.IDLogin = IDLogin;
        this.TenNhanVien = TenNhanVien;
        this.Tuoi = Tuoi;
        this.Diachi = Diachi;
        this.SDT = SDT;
        this.Gioitinh = Gioitinh;
        this.Ngaybatdaulam = Ngaybatdaulam;
        this.TrangThaiNV = TrangThaiNV;
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public String getIDLogin() {
        return IDLogin;
    }

    public void setIDLogin(String IDLogin) {
        this.IDLogin = IDLogin;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public Integer getTuoi() {
        return Tuoi;
    }

    public void setTuoi(Integer Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public Integer getSDT() {
        return SDT;
    }

    public void setSDT(Integer SDT) {
        this.SDT = SDT;
    }

    public Boolean getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(Boolean Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getNgaybatdaulam() {
        return Ngaybatdaulam;
    }

    public void setNgaybatdaulam(String Ngaybatdaulam) {
        this.Ngaybatdaulam = Ngaybatdaulam;
    }

    public Boolean getTrangThaiNV() {
        return TrangThaiNV;
    }

    public void setTrangThaiNV(Boolean TrangThaiNV) {
        this.TrangThaiNV = TrangThaiNV;
    }

    @Override
    public String toString() {
        return "Model_nhanvien{" + "IDNhanVien=" + IDNhanVien + ", IDLogin=" + IDLogin + ", TenNhanVien=" + TenNhanVien + ", Tuoi=" + Tuoi + ", Diachi=" + Diachi + ", SDT=" + SDT + ", Gioitinh=" + Gioitinh + ", Ngaybatdaulam=" + Ngaybatdaulam + ", TrangThaiNV=" + TrangThaiNV + '}';
    }

   
    
}


