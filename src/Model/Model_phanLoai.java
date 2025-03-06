package Model;

/**
 *
 * @author Gigabyte
 */
public class Model_phanLoai {
    private String IDPhanLoai;
    private String KieuDang;
    private String size;
    private Boolean TrangThaiPL;

    public Model_phanLoai() {
    }

    public Model_phanLoai(String IDPhanLoai, String KieuDang, String size, Boolean TrangThaiPL) {
        this.IDPhanLoai = IDPhanLoai;
        this.KieuDang = KieuDang;
        this.size = size;
        this.TrangThaiPL = TrangThaiPL;
    }

   

    public String getIDPhanLoai() {
        return IDPhanLoai;
    }

    public void setIDPhanLoai(String IDPhanLoai) {
        this.IDPhanLoai = IDPhanLoai;
    }

    public String getKieuDang() {
        return KieuDang;
    }

    public void setKieuDang(String KieuDang) {
        this.KieuDang = KieuDang;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getTrangThaiPL() {
        return TrangThaiPL;
    }

    public void setTrangThaiPL(Boolean TrangThaiPL) {
        this.TrangThaiPL = TrangThaiPL;
    }
    
}
