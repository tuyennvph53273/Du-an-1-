package Model;


public class Model_BanHangSP {
    private String IDSanPhamCT ; 
    private String TenSanPhamCT ; 
    private String MauSac ; 
    private String Loai ; 
    private Integer SoLuongTon ; 
    private Integer GiaBan ; 

    public Model_BanHangSP() {
    }

    public Model_BanHangSP(String IDSanPhamCT, String TenSanPhamCT, String MauSac, String Loai, Integer SoLuongTon, Integer GiaBan) {
        this.IDSanPhamCT = IDSanPhamCT;
        this.TenSanPhamCT = TenSanPhamCT;
        this.MauSac = MauSac;
        this.Loai = Loai;
        this.SoLuongTon = SoLuongTon;
        this.GiaBan = GiaBan;
    }

    public String getIDSanPhamCT() {
        return IDSanPhamCT;
    }

    public void setIDSanPhamCT(String IDSanPhamCT) {
        this.IDSanPhamCT = IDSanPhamCT;
    }

    public String getTenSanPhamCT() {
        return TenSanPhamCT;
    }

    public void setTenSanPhamCT(String TenSanPhamCT) {
        this.TenSanPhamCT = TenSanPhamCT;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public Integer getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(Integer SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    public Integer getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Integer GiaBan) {
        this.GiaBan = GiaBan;
    }

    @Override
    public String toString() {
        return "Model_BanHangSP{" + "IDSanPhamCT=" + IDSanPhamCT + ", TenSanPhamCT=" + TenSanPhamCT + ", MauSac=" + MauSac + ", Loai=" + Loai + ", SoLuongTon=" + SoLuongTon + ", GiaBan=" + GiaBan + '}';
    }
    
    
}
