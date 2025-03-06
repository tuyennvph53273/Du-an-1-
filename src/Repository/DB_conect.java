package Repository;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gigabyte
 */
public class DB_conect {
    public static void main(String[] args) {
         try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = ("jdbc:sqlserver://localhost:1433;databaseName=BanQuatNuoc;encrypt=true;trustServerCertificate=true");
        Connection conn = DriverManager.getConnection(url, "sa", "08032005");
        if(conn!=null){
            System.out.println("Success");
        }else{
            System.out.println("Failed");
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            String url = ("jdbc:sqlserver://localhost:1433;databaseName=BanQuatNuoc;encrypt=true;trustServerCertificate=true");
            conn = DriverManager.getConnection(url,"sa","08032005");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
