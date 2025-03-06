package Model;


public class Model_hoaDonCTFillName {
    private String IDHoaDonCT; 
    private String TenSanPham; 
    private String IDHoaDon; 
    private Integer soLuong; 
    private Integer donGia; 
    private Boolean trangThaiHDCT; 

    public Model_hoaDonCTFillName() {
    }

    public Model_hoaDonCTFillName(String IDHoaDonCT, String TenSanPham, String IDHoaDon, Integer soLuong, Integer donGia, Boolean trangThaiHDCT) {
        this.IDHoaDonCT = IDHoaDonCT;
        this.TenSanPham = TenSanPham;
        this.IDHoaDon = IDHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThaiHDCT = trangThaiHDCT;
    }

    public String getIDHoaDonCT() {
        return IDHoaDonCT;
    }

    public void setIDHoaDonCT(String IDHoaDonCT) {
        this.IDHoaDonCT = IDHoaDonCT;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(String IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    public Boolean getTrangThaiHDCT() {
        return trangThaiHDCT;
    }

    public void setTrangThaiHDCT(Boolean trangThaiHDCT) {
        this.trangThaiHDCT = trangThaiHDCT;
    }

    @Override
    public String toString() {
        return "Model_hoaDonCTFillName{" + "IDHoaDonCT=" + IDHoaDonCT + ", TenSanPham=" + TenSanPham + ", IDHoaDon=" + IDHoaDon + ", soLuong=" + soLuong + ", donGia=" + donGia + ", trangThaiHDCT=" + trangThaiHDCT + '}';
    }
    
    

    
}
