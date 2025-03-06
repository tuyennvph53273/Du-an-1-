package Model;


public class Model_khachHang {
    private String maKH;
    private String TenKH;
    private Integer TuoiKH;
    private Boolean GioiTinhKH;
    private String DiaChi;
    private Integer SDT;
    private Boolean TrangThaiKH;

    public Model_khachHang() {
    }

    public Model_khachHang(String maKH, String TenKH, Integer TuoiKH, Boolean GioiTinhKH, String DiaChi, Integer SDT, Boolean TrangThaiKH) {
        this.maKH = maKH;
        this.TenKH = TenKH;
        this.TuoiKH = TuoiKH;
        this.GioiTinhKH = GioiTinhKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TrangThaiKH = TrangThaiKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public Integer getTuoiKH() {
        return TuoiKH;
    }

    public void setTuoiKH(Integer TuoiKH) {
        this.TuoiKH = TuoiKH;
    }

    public Boolean getGioiTinhKH() {
        return GioiTinhKH;
    }

    public void setGioiTinhKH(Boolean GioiTinhKH) {
        this.GioiTinhKH = GioiTinhKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Integer getSDT() {
        return SDT;
    }

    public void setSDT(Integer SDT) {
        this.SDT = SDT;
    }

    public Boolean getTrangThaiKH() {
        return TrangThaiKH;
    }

    public void setTrangThaiKH(Boolean TrangThaiKH) {
        this.TrangThaiKH = TrangThaiKH;
    }

    @Override
    public String toString() {
        return "Model_khachHang{" + "maKH=" + maKH + ", TenKH=" + TenKH + ", TuoiKH=" + TuoiKH + ", GioiTinhKH=" + GioiTinhKH + ", DiaChi=" + DiaChi + ", SDT=" + SDT + ", TrangThaiKH=" + TrangThaiKH + '}';
    }
    
    
    
}
