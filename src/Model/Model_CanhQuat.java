package Model;


public class Model_CanhQuat {
    private String IDCanhQuat;
    private String TenCanhQuat;
    private String HangCQ;
    private String NgaySXCQ;
    private Integer congXCQ;
    private String chatLieuCQ;
    private Boolean TrangThaiCQ;

    public Model_CanhQuat() {
    }

    public Model_CanhQuat(String IDCanhQuat, String TenCanhQuat, String HangCQ, String NgaySXCQ, Integer congXCQ, String chatLieuCQ, Boolean TrangThaiCQ) {
        this.IDCanhQuat = IDCanhQuat;
        this.TenCanhQuat = TenCanhQuat;
        this.HangCQ = HangCQ;
        this.NgaySXCQ = NgaySXCQ;
        this.congXCQ = congXCQ;
        this.chatLieuCQ = chatLieuCQ;
        this.TrangThaiCQ = TrangThaiCQ;
    }

    public String getIDCanhQuat() {
        return IDCanhQuat;
    }

    public void setIDCanhQuat(String IDCanhQuat) {
        this.IDCanhQuat = IDCanhQuat;
    }

    public String getTenCanhQuat() {
        return TenCanhQuat;
    }

    public void setTenCanhQuat(String TenCanhQuat) {
        this.TenCanhQuat = TenCanhQuat;
    }

    public String getHangCQ() {
        return HangCQ;
    }

    public void setHangCQ(String HangCQ) {
        this.HangCQ = HangCQ;
    }

    public String getNgaySXCQ() {
        return NgaySXCQ;
    }

    public void setNgaySXCQ(String NgaySXCQ) {
        this.NgaySXCQ = NgaySXCQ;
    }

    public Integer getCongXCQ() {
        return congXCQ;
    }

    public void setCongXCQ(Integer congXCQ) {
        this.congXCQ = congXCQ;
    }

    public String getChatLieuCQ() {
        return chatLieuCQ;
    }

    public void setChatLieuCQ(String chatLieuCQ) {
        this.chatLieuCQ = chatLieuCQ;
    }

    public Boolean getTrangThaiCQ() {
        return TrangThaiCQ;
    }

    public void setTrangThaiCQ(Boolean TrangThaiCQ) {
        this.TrangThaiCQ = TrangThaiCQ;
    }

    

}
