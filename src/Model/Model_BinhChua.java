package Model;


public class Model_BinhChua {
    private String IDBinhChua;
    private String TenBinhChua;
    private String HangBC;
    private String NgaySXBC;
    private Integer dungTichBC;
    private Boolean TrangThaiBC;

    public Model_BinhChua() {
    }

    public Model_BinhChua(String IDBinhChua, String TenBinhChua, String HangBC, String NgaySXBC, Integer dungTichBC, Boolean TrangThaiBC) {
        this.IDBinhChua = IDBinhChua;
        this.TenBinhChua = TenBinhChua;
        this.HangBC = HangBC;
        this.NgaySXBC = NgaySXBC;
        this.dungTichBC = dungTichBC;
        this.TrangThaiBC = TrangThaiBC;
    }

    public String getIDBinhChua() {
        return IDBinhChua;
    }

    public void setIDBinhChua(String IDBinhChua) {
        this.IDBinhChua = IDBinhChua;
    }

    public String getTenBinhChua() {
        return TenBinhChua;
    }

    public void setTenBinhChua(String TenBinhChua) {
        this.TenBinhChua = TenBinhChua;
    }

    public String getHangBC() {
        return HangBC;
    }

    public void setHangBC(String HangBC) {
        this.HangBC = HangBC;
    }

    public String getNgaySXBC() {
        return NgaySXBC;
    }

    public void setNgaySXBC(String NgaySXBC) {
        this.NgaySXBC = NgaySXBC;
    }

    public Integer getDungTichBC() {
        return dungTichBC;
    }

    public void setDungTichBC(Integer dungTichBC) {
        this.dungTichBC = dungTichBC;
    }

    public Boolean getTrangThaiBC() {
        return TrangThaiBC;
    }

    public void setTrangThaiBC(Boolean TrangThaiBC) {
        this.TrangThaiBC = TrangThaiBC;
    }

      
}
