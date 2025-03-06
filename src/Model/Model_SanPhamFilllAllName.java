package Model;

public class Model_SanPhamFilllAllName {
     private String maSPCT; 
    private String TenSP ; 
    private String TenLinhKien ; 
    private String TenMauSac ; 
    private String TenKhuyenmai ; 
    private String TenLoai ; 
    private Integer TrongLuong ; 
    private String Phamvigio ; 
    private Integer TocDo ; 
    private String hangSP ; 
    private Integer soLuong ; 
    private Integer giaban ; 
    private Boolean trangThaiSPCT ; 

    public Model_SanPhamFilllAllName() {
    }

    @Override
    public String toString() {
        return "Model_SanPhamFilllAllName{" + "maSPCT=" + maSPCT + ", TenSP=" + TenSP + ", TenLinhKien=" + TenLinhKien + ", TenMauSac=" + TenMauSac + ", TenKhuyenmai=" + TenKhuyenmai + ", TenLoai=" + TenLoai + ", TrongLuong=" + TrongLuong + ", Phamvigio=" + Phamvigio + ", TocDo=" + TocDo + ", hangSP=" + hangSP + ", soLuong=" + soLuong + ", giaban=" + giaban + ", trangThaiSPCT=" + trangThaiSPCT + '}';
    }


    

    public Model_SanPhamFilllAllName(String maSPCT, String TenLinhKien, String TenMauSac, String TenKhuyenmai, String TenSP, String TenLoai, Integer TrongLuong, String Phamvigio, Integer TocDo, String hangSP, Integer soLuong, Integer giaban, Boolean trangThaiSPCT) {
        this.maSPCT = maSPCT;
        this.TenLinhKien = TenLinhKien;
        this.TenMauSac = TenMauSac;
        this.TenKhuyenmai = TenKhuyenmai;
        this.TenSP = TenSP;
        this.TenLoai = TenLoai;
        this.TrongLuong = TrongLuong;
        this.Phamvigio = Phamvigio;
        this.TocDo = TocDo;
        this.hangSP = hangSP;
        this.soLuong = soLuong;
        this.giaban = giaban;
        this.trangThaiSPCT = trangThaiSPCT;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getTenLinhKien() {
        return TenLinhKien;
    }

    public void setTenLinhKien(String TenLinhKien) {
        this.TenLinhKien = TenLinhKien;
    }

    public String getTenMauSac() {
        return TenMauSac;
    }

    public void setTenMauSac(String TenMauSac) {
        this.TenMauSac = TenMauSac;
    }

    public String getTenKhuyenmai() {
        return TenKhuyenmai;
    }

    public void setTenKhuyenmai(String TenKhuyenmai) {
        this.TenKhuyenmai = TenKhuyenmai;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public Integer getTrongLuong() {
        return TrongLuong;
    }

    public void setTrongLuong(Integer TrongLuong) {
        this.TrongLuong = TrongLuong;
    }

    public String getPhamvigio() {
        return Phamvigio;
    }

    public void setPhamvigio(String Phamvigio) {
        this.Phamvigio = Phamvigio;
    }

    public Integer getTocDo() {
        return TocDo;
    }

    public void setTocDo(Integer TocDo) {
        this.TocDo = TocDo;
    }

    public String getHangSP() {
        return hangSP;
    }

    public void setHangSP(String hangSP) {
        this.hangSP = hangSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGiaban() {
        return giaban;
    }

    public void setGiaban(Integer giaban) {
        this.giaban = giaban;
    }

    public Boolean getTrangThaiSPCT() {
        return trangThaiSPCT;
    }

    public void setTrangThaiSPCT(Boolean trangThaiSPCT) {
        this.trangThaiSPCT = trangThaiSPCT;
    }
    

}
