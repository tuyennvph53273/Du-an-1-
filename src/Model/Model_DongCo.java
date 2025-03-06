package Model;

/**
 *
 * @author Gigabyte
 */
public class Model_DongCo {
    private String IDDongco;
    private String TenDongco;
    private String HangDC;
    private String NgaySXDC;
    private Integer congXDC;
    private String ChatLieuDC;
    private Boolean TrangThaiDC;

    public Model_DongCo() {
    }

    @Override
    public String toString() {
        return "Model_DongCo{" + "IDDongco=" + IDDongco + ", TenDongco=" + TenDongco + ", HangDC=" + HangDC + ", NgaySXDC=" + NgaySXDC + ", congXDC=" + congXDC + ", ChatLieuDC=" + ChatLieuDC + ", TrangThaiDC=" + TrangThaiDC + '}';
    }

    public Model_DongCo(String IDDongco, String TenDongco, String HangDC, String NgaySXDC, Integer congXDC, String ChatLieuDC, Boolean TrangThaiDC) {
        this.IDDongco = IDDongco;
        this.TenDongco = TenDongco;
        this.HangDC = HangDC;
        this.NgaySXDC = NgaySXDC;
        this.congXDC = congXDC;
        this.ChatLieuDC = ChatLieuDC;
        this.TrangThaiDC = TrangThaiDC;
    }

    public String getIDDongco() {
        return IDDongco;
    }

    public void setIDDongco(String IDDongco) {
        this.IDDongco = IDDongco;
    }

    public String getTenDongco() {
        return TenDongco;
    }

    public void setTenDongco(String TenDongco) {
        this.TenDongco = TenDongco;
    }

    public String getHangDC() {
        return HangDC;
    }

    public void setHangDC(String HangDC) {
        this.HangDC = HangDC;
    }

    public String getNgaySXDC() {
        return NgaySXDC;
    }

    public void setNgaySXDC(String NgaySXDC) {
        this.NgaySXDC = NgaySXDC;
    }

    public Integer getCongXDC() {
        return congXDC;
    }

    public void setCongXDC(Integer congXDC) {
        this.congXDC = congXDC;
    }

    public String getChatLieuDC() {
        return ChatLieuDC;
    }

    public void setChatLieuDC(String ChatLieuDC) {
        this.ChatLieuDC = ChatLieuDC;
    }

    public Boolean getTrangThaiDC() {
        return TrangThaiDC;
    }

    public void setTrangThaiDC(Boolean TrangThaiDC) {
        this.TrangThaiDC = TrangThaiDC;
    }

    
    
}
