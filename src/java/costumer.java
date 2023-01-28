
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lema
 */
public class costumer {
    public void purchase() throws ClassNotFoundException, SQLException
    {
        DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
                          ResultSet  id;
        id = (ResultSet) con.prepareStatement("select * from ADMINTABEL where MEDICINEID =");

            List<NewJSFManagedBean> list = new ArrayList<>();  
          
        }

    }
    

