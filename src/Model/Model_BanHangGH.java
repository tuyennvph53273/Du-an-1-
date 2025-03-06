package Model;


public class Model_BanHangGH {
    private String IDHoaDon ; 
    private String IDHoaDonCT ; 
    private String IDSanPhamCT ; 
    private String TenSanPhamCT ; 
    private Integer SoLuongSPGH ; 
    private Integer GiaBan ;

    public Model_BanHangGH() {
    }

    @Override
    public String toString() {
        return "Model_BanHangGH{" + "IDHoaDon=" + IDHoaDon + ", IDHoaDonCT=" + IDHoaDonCT + ", IDSanPhamCT=" + IDSanPhamCT + ", TenSanPhamCT=" + TenSanPhamCT + ", SoLuongSPGH=" + SoLuongSPGH + ", GiaBan=" + GiaBan + '}';
    }

    public String getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(String IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public String getIDHoaDonCT() {
        return IDHoaDonCT;
    }

    public void setIDHoaDonCT(String IDHoaDonCT) {
        this.IDHoaDonCT = IDHoaDonCT;
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

    public Integer getSoLuongSPGH() {
        return SoLuongSPGH;
    }

    public void setSoLuongSPGH(Integer SoLuongSPGH) {
        this.SoLuongSPGH = SoLuongSPGH;
    }

    public Integer getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Integer GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Model_BanHangGH(String IDHoaDon, String IDHoaDonCT, String IDSanPhamCT, String TenSanPhamCT, Integer SoLuongSPGH, Integer GiaBan) {
        this.IDHoaDon = IDHoaDon;
        this.IDHoaDonCT = IDHoaDonCT;
        this.IDSanPhamCT = IDSanPhamCT;
        this.TenSanPhamCT = TenSanPhamCT;
        this.SoLuongSPGH = SoLuongSPGH;
        this.GiaBan = GiaBan;
    }

}
