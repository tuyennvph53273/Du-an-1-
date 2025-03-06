package Model;


public class Model_Voucher {
    private String IDvoucher;
    private Integer PhanTramGiamGIa;
    private String NgayStart;
    private String NgayEnd;
    private Boolean TrangThaiVC;

    public Model_Voucher() {
    }

    public Model_Voucher(String IDvoucher, Integer PhanTramGiamGIa, String NgayStart, String NgayEnd, Boolean TrangThaiVC) {
        this.IDvoucher = IDvoucher;
        this.PhanTramGiamGIa = PhanTramGiamGIa;
        this.NgayStart = NgayStart;
        this.NgayEnd = NgayEnd;
        this.TrangThaiVC = TrangThaiVC;
    }

    public String getIDvoucher() {
        return IDvoucher;
    }

    public void setIDvoucher(String IDvoucher) {
        this.IDvoucher = IDvoucher;
    }

    public Integer getPhanTramGiamGIa() {
        return PhanTramGiamGIa;
    }

    public void setPhanTramGiamGIa(Integer PhanTramGiamGIa) {
        this.PhanTramGiamGIa = PhanTramGiamGIa;
    }

    public String getNgayStart() {
        return NgayStart;
    }

    public void setNgayStart(String NgayStart) {
        this.NgayStart = NgayStart;
    }

    public String getNgayEnd() {
        return NgayEnd;
    }

    public void setNgayEnd(String NgayEnd) {
        this.NgayEnd = NgayEnd;
    }

    public Boolean getTrangThaiVC() {
        return TrangThaiVC;
    }

    public void setTrangThaiVC(Boolean TrangThaiVC) {
        this.TrangThaiVC = TrangThaiVC;
    }

    @Override
    public String toString() {
        return "Model_Voucher{" + "IDvoucher=" + IDvoucher + ", PhanTramGiamGIa=" + PhanTramGiamGIa + ", NgayStart=" + NgayStart + ", NgayEnd=" + NgayEnd + ", TrangThaiVC=" + TrangThaiVC + '}';
    }
    
}
