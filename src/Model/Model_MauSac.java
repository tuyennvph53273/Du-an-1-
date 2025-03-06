package Model;

/**
 *
 * @author Gigabyte
 */
public class Model_MauSac {

    private String IDMauSac;
    private String TenMau;
    private String DoDam;
    private Boolean TrangThaiM;

    public Model_MauSac() {
    }

    public Model_MauSac(String IDMauSac, String TenMau, String DoDam, Boolean TrangThaiM) {
        this.IDMauSac = IDMauSac;
        this.TenMau = TenMau;
        this.DoDam = DoDam;
        this.TrangThaiM = TrangThaiM;
    }

    public String getIDMauSac() {
        return IDMauSac;
    }

    public void setIDMauSac(String IDMauSac) {
        this.IDMauSac = IDMauSac;
    }

    public String getTenMau() {
        return TenMau;
    }

    public void setTenMau(String TenMau) {
        this.TenMau = TenMau;
    }

    public String getDoDam() {
        return DoDam;
    }

    public void setDoDam(String DoDam) {
        this.DoDam = DoDam;
    }

    public Boolean getTrangThaiM() {
        return TrangThaiM;
    }

    public void setTrangThaiM(Boolean TrangThaiM) {
        this.TrangThaiM = TrangThaiM;
    }
    
}
