package Model;


public class Model_HoaDonCT {
    private String IDHoaDonCT; 
    private String IDSanPhamCT; 
    private String IDHoaDon; 
    private Integer soLuong; 
    private Integer donGia; 
    private Boolean trangThaiHDCT; 

    public Model_HoaDonCT() {
    }

    public Model_HoaDonCT(String IDHoaDonCT, String IDSanPhamCT, String IDHoaDon, Integer soLuong, Integer donGia, Boolean trangThaiHDCT) {
        this.IDHoaDonCT = IDHoaDonCT;
        this.IDSanPhamCT = IDSanPhamCT;
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

    public String getIDSanPhamCT() {
        return IDSanPhamCT;
    }

    public void setIDSanPhamCT(String IDSanPhamCT) {
        this.IDSanPhamCT = IDSanPhamCT;
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
        return "Model_HoaDonCT{" + "IDHoaDonCT=" + IDHoaDonCT + ", IDSanPhamCT=" + IDSanPhamCT + ", IDHoaDon=" + IDHoaDon + ", soLuong=" + soLuong + ", donGia=" + donGia + ", trangThaiHDCT=" + trangThaiHDCT + '}';
    }

    
    
}
