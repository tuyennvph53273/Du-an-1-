package Model;


public class Model_SanPhamCT {
    private String maSPCT; 
    private String IDLinhKien ; 
    private String IDMauSac ; 
    private String IDKhuyenmai ; 
    private String maSP ; 
    private String IDLoai ; 
    private Integer TrongLuong ; 
    private String Phamvigio ; 
    private Integer TocDo ; 
    private Integer soLuong ; 
    private String hangSP ; 
    private Integer giaban ; 
    private Boolean trangThaiSPCT ; 

    @Override
    public String toString() {
        return "Model_SanPhamCT{" + "maSPCT=" + maSPCT + ", maSP=" + maSP + ", IDLinhKien=" + IDLinhKien + ", IDMauSac=" + IDMauSac + ", IDKhuyenmai=" + IDKhuyenmai + ", IDLoai=" + IDLoai + ", TrongLuong=" + TrongLuong + ", Phamvigio=" + Phamvigio + ", TocDo=" + TocDo + ", hangSP=" + hangSP + ", soLuong=" + soLuong + ", giaban=" + giaban + ", trangThaiSPCT=" + trangThaiSPCT + '}';
    }

    public Model_SanPhamCT() {
    }

    public Model_SanPhamCT(String maSPCT, String IDLinhKien, String IDMauSac, String IDKhuyenmai, String maSP, String IDLoai, Integer TrongLuong, String Phamvigio, Integer TocDo, Integer soLuong, String hangSP, Integer giaban, Boolean trangThaiSPCT) {
        this.maSPCT = maSPCT;
        this.IDLinhKien = IDLinhKien;
        this.IDMauSac = IDMauSac;
        this.IDKhuyenmai = IDKhuyenmai;
        this.maSP = maSP;
        this.IDLoai = IDLoai;
        this.TrongLuong = TrongLuong;
        this.Phamvigio = Phamvigio;
        this.TocDo = TocDo;
        this.soLuong = soLuong;
        this.hangSP = hangSP;
        this.giaban = giaban;
        this.trangThaiSPCT = trangThaiSPCT;
    }

    

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getIDLinhKien() {
        return IDLinhKien;
    }

    public void setIDLinhKien(String IDLinhKien) {
        this.IDLinhKien = IDLinhKien;
    }

    public String getIDMauSac() {
        return IDMauSac;
    }

    public void setIDMauSac(String IDMauSac) {
        this.IDMauSac = IDMauSac;
    }

    public String getIDKhuyenmai() {
        return IDKhuyenmai;
    }

    public void setIDKhuyenmai(String IDKhuyenmai) {
        this.IDKhuyenmai = IDKhuyenmai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getIDLoai() {
        return IDLoai;
    }

    public void setIDLoai(String IDLoai) {
        this.IDLoai = IDLoai;
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
