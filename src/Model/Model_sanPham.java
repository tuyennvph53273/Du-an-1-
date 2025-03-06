package Model;


public class Model_sanPham {
    private String maSP ; 
    private String tenSP ; 
    private Boolean TrangThaiSP;

    public Model_sanPham() {
    }

    public Model_sanPham(String maSP, String tenSP, Boolean TrangThaiSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.TrangThaiSP = TrangThaiSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Boolean getTrangThaiSP() {
        return TrangThaiSP;
    }

    public void setTrangThaiSP(Boolean TrangThaiSP) {
        this.TrangThaiSP = TrangThaiSP;
    }
    
}
