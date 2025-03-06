package Model;


public class Model_hoaDon {
    private String IDHoaDon;
    private String IDKhachHang;
    private String IDNhanVien;
    private String IDVoucher;
    private String ngayMuaHang;
    private Integer TongGia;
    private Boolean TrangThaiHD;

    public Model_hoaDon() {
    }

    public Model_hoaDon(String IDHoaDon, String IDKhachHang, String IDNhanVien, String IDVoucher, String ngayMuaHang, Integer TongGia, Boolean TrangThaiHD) {
        this.IDHoaDon = IDHoaDon;
        this.IDKhachHang = IDKhachHang;
        this.IDNhanVien = IDNhanVien;
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

    public String getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(String IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
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
        return "Model_hoaDon{" + "IDHoaDon=" + IDHoaDon + ", IDKhachHang=" + IDKhachHang + ", IDNhanVien=" + IDNhanVien + ", IDVoucher=" + IDVoucher + ", ngayMuaHang=" + ngayMuaHang + ", TongGia=" + TongGia + ", TrangThaiHD=" + TrangThaiHD + '}';
    }

    
    
}
