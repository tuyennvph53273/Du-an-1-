package Model;

/**
 *
 * @author Gigabyte
 */
public class Model_login {
    private String ID ; 
    private String Username ; 
    private String Pasword ; 

    public Model_login() {
    }

    public Model_login(String ID, String Username, String Pasword) {
        this.ID = ID;
        this.Username = Username;
        this.Pasword = Pasword;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPasword() {
        return Pasword;
    }

    public void setPasword(String Pasword) {
        this.Pasword = Pasword;
    }
    
}
