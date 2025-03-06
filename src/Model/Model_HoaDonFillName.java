package Model;


public class Model_HoaDonFillName {
     private String IDHoaDon;
    private String TenKhachHang;
    private String TenNhanVien;
    private String IDVoucher;
    private String ngayMuaHang;
    private Integer TongGia;
    private Boolean TrangThaiHD;

    public Model_HoaDonFillName() {
    }

    public Model_HoaDonFillName(String IDHoaDon, String TenKhachHang, String TenNhanVien, String IDVoucher, String ngayMuaHang, Integer TongGia, Boolean TrangThaiHD) {
        this.IDHoaDon = IDHoaDon;
        this.TenKhachHang = TenKhachHang;
        this.TenNhanVien = TenNhanVien;
        this.IDVoucher = IDVoucher;
        this.ngayMuaHang = ngayMuaHang;
        this.TongGia = TongGia;
        this.TrangThaiHD = TrangThaiHD;
    }

    public String getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(String IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getIDVoucher() {
        return IDVoucher;
    }

    public void setIDVoucher(String IDVoucher) {
        this.IDVoucher = IDVoucher;
    }

    public String getNgayMuaHang() {
        return ngayMuaHang;
    }

    public void setNgayMuaHang(String ngayMuaHang) {
        this.ngayMuaHang = ngayMuaHang;
    }

    public Integer getTongGia() {
        return TongGia;
    }

    public void setTongGia(Integer TongGia) {
        this.TongGia = TongGia;
    }

    public Boolean getTrangThaiHD() {
        return TrangThaiHD;
    }

    public void setTrangThaiHD(Boolean TrangThaiHD) {
        this.TrangThaiHD = TrangThaiHD;
    }

    @Override
    public String toString() {
        return "Model_HoaDonFillName{" + "IDHoaDon=" + IDHoaDon + ", TenKhachHang=" + TenKhachHang + ", TenNhanVien=" + TenNhanVien + ", IDVoucher=" + IDVoucher + ", ngayMuaHang=" + ngayMuaHang + ", TongGia=" + TongGia + ", TrangThaiHD=" + TrangThaiHD + '}';
    }

   
    
}
