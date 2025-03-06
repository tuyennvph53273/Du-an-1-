package Model;


public class Model_BanHangHD {
    
    private String IDHoaDon;
    private String TenKhachHang;
    private Integer SDT ; 
    private String ThoiDiemTao;
    private Integer TongGia;
    private  Boolean TrangThaiBHHD;

    public Model_BanHangHD() {
    }

    public Model_BanHangHD(String IDHoaDon, String TenKhachHang, Integer SDT, String ThoiDiemTao, Integer TongGia, Boolean TrangThaiBHHD) {
        this.IDHoaDon = IDHoaDon;
        this.TenKhachHang = TenKhachHang;
        this.SDT = SDT;
        this.ThoiDiemTao = ThoiDiemTao;
        this.TongGia = TongGia;
        this.TrangThaiBHHD = TrangThaiBHHD;
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

    public Boolean getTrangThaiBHHD() {
        return TrangThaiBHHD;
    }

    public void setTrangThaiBHHD(Boolean TrangThaiBHHD) {
        this.TrangThaiBHHD = TrangThaiBHHD;
    }

    @Override
    public String toString() {
        return "Model_BanHangHD{" + "IDHoaDon=" + IDHoaDon + ", TenKhachHang=" + TenKhachHang + ", SDT=" + SDT + ", ThoiDiemTao=" + ThoiDiemTao + ", TongGia=" + TongGia + ", TrangThaiBHHD=" + TrangThaiBHHD + '}';
    }

    
    
}
