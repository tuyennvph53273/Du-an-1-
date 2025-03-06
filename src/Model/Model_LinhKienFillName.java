package Model;

public class Model_LinhKienFillName {

    private String IDLinhKien;
    private String TenLinhKien;
    private String TenDongCo;
    private String TenCanhQuat;
    private String TenBinhChua;
    private String NgayStar;
    private String NgayEnd;
    private Boolean TrangThaiLK;

    public Model_LinhKienFillName() {
    }

    public Model_LinhKienFillName(String IDLinhKien, String TenLinhKien, String TenDongCo, String TenCanhQuat, String TenBinhChua, String NgayStar, String NgayEnd, Boolean TrangThaiLK) {
        this.IDLinhKien = IDLinhKien;
        this.TenLinhKien = TenLinhKien;
        this.TenDongCo = TenDongCo;
        this.TenCanhQuat = TenCanhQuat;
        this.TenBinhChua = TenBinhChua;
        this.NgayStar = NgayStar;
        this.NgayEnd = NgayEnd;
        this.TrangThaiLK = TrangThaiLK;
    }

    @Override
    public String toString() {
        return "Model_LinhKienFillName{" + "IDLinhKien=" + IDLinhKien + ", TenLinhKien=" + TenLinhKien + ", TenDongCo=" + TenDongCo + ", TenCanhQuat=" + TenCanhQuat + ", TenBinhChua=" + TenBinhChua + ", NgayStar=" + NgayStar + ", NgayEnd=" + NgayEnd + ", TrangThaiLK=" + TrangThaiLK + '}';
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

    public String getTenDongCo() {
        return TenDongCo;
    }

    public void setTenDongCo(String TenDongCo) {
        this.TenDongCo = TenDongCo;
    }

    public String getTenCanhQuat() {
        return TenCanhQuat;
    }

    public void setTenCanhQuat(String TenCanhQuat) {
        this.TenCanhQuat = TenCanhQuat;
    }

    public String getTenBinhChua() {
        return TenBinhChua;
    }

    public void setTenBinhChua(String TenBinhChua) {
        this.TenBinhChua = TenBinhChua;
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

    
    
}
