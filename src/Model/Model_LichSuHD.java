package Model;


public class Model_LichSuHD {
     
    private String IDHoaDon;
    private String TenKhachHang;
    private Integer SDT ; 
    private String ThoiDiemTao;
    private Integer TongGia;
    private  Boolean TrangThaiLSHD;

    public Model_LichSuHD() {
    }

    public Model_LichSuHD(String IDHoaDon, String TenKhachHang, Integer SDT, String ThoiDiemTao, Integer TongGia, Boolean TrangThaiLSHD) {
        this.IDHoaDon = IDHoaDon;
        this.TenKhachHang = TenKhachHang;
        this.SDT = SDT;
        this.ThoiDiemTao = ThoiDiemTao;
        this.TongGia = TongGia;
        this.TrangThaiLSHD = TrangThaiLSHD;
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

    public Integer getSDT() {
        return SDT;
    }

    public void setSDT(Integer SDT) {
        this.SDT = SDT;
    }

    public String getThoiDiemTao() {
        return ThoiDiemTao;
    }

    public void setThoiDiemTao(String ThoiDiemTao) {
        this.ThoiDiemTao = ThoiDiemTao;
    }

    public Integer getTongGia() {
        return TongGia;
    }

    public void setTongGia(Integer TongGia) {
        this.TongGia = TongGia;
    }

    public Boolean getTrangThaiLSHD() {
        return TrangThaiLSHD;
    }

    public void setTrangThaiLSHD(Boolean TrangThaiLSHD) {
        this.TrangThaiLSHD = TrangThaiLSHD;
    }

    @Override
    public String toString() {
        return "Model_LichSuHD{" + "IDHoaDon=" + IDHoaDon + ", TenKhachHang=" + TenKhachHang + ", SDT=" + SDT + ", ThoiDiemTao=" + ThoiDiemTao + ", TongGia=" + TongGia + ", TrangThaiLSHD=" + TrangThaiLSHD + '}';
    }
    

}
