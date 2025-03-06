package Model;


public class Model_linhKien {
     private String IDLinhKien;
     private String TenLinhKien;
    private String DongCo;
    private String CanhQuat;
    private String BinhChua;
    private String NgayStar;
    private String NgayEnd;
    private Boolean TrangThaiLK;

    public Model_linhKien() {
    }

    public String getIDLinhKien() {
        return IDLinhKien;
    }

    public void setIDLinhKien(String IDLinhKien) {
        this.IDLinhKien = IDLinhKien;
    }

    public String getTenLinhKien() {
        return TenLinhKien;
    }

    public void setTenLinhKien(String TenLinhKien) {
        this.TenLinhKien = TenLinhKien;
    }

    public String getDongCo() {
        return DongCo;
    }

    public void setDongCo(String DongCo) {
        this.DongCo = DongCo;
    }

    public String getCanhQuat() {
        return CanhQuat;
    }

    public void setCanhQuat(String CanhQuat) {
        this.CanhQuat = CanhQuat;
    }

    public String getBinhChua() {
        return BinhChua;
    }

    public void setBinhChua(String BinhChua) {
        this.BinhChua = BinhChua;
    }

    public String getNgayStar() {
        return NgayStar;
    }

    public void setNgayStar(String NgayStar) {
        this.NgayStar = NgayStar;
    }

    public String getNgayEnd() {
        return NgayEnd;
    }

    public void setNgayEnd(String NgayEnd) {
        this.NgayEnd = NgayEnd;
    }

    public Boolean getTrangThaiLK() {
        return TrangThaiLK;
    }

    public void setTrangThaiLK(Boolean TrangThaiLK) {
        this.TrangThaiLK = TrangThaiLK;
    }

    public Model_linhKien(String IDLinhKien, String TenLinhKien, String DongCo, String CanhQuat, String BinhChua, String NgayStar, String NgayEnd, Boolean TrangThaiLK) {
        this.IDLinhKien = IDLinhKien;
        this.TenLinhKien = TenLinhKien;
        this.DongCo = DongCo;
        this.CanhQuat = CanhQuat;
        this.BinhChua = BinhChua;
        this.NgayStar = NgayStar;
        this.NgayEnd = NgayEnd;
        this.TrangThaiLK = TrangThaiLK;
    }

}
