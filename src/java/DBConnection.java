
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

class DBConnection {

    
 static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

    //  Database credentials
    static final String USER = "web1";
    static final String PASS = "2127";
    Connection con = null;

    public Connection connMethod() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(DB_URL, USER, PASS);
      if (con != null) {
           System.out.println("Connected database successfully...");
     } else {
           System.out.println("nFailed to connect to Oracle DB");        }
        return con;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
  DBConnection nw=new DBConnection();
  nw.connMethod();
    
}}
    
 









