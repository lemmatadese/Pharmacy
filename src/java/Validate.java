//import static DatabaseOperation.getConnection;
//import static DatabaseOperation.stmtObj
import static java.awt.Color.red;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *

 */

@ManagedBean
@RequestScoped
public class Validate implements Serializable {
    private String name;
  
   private String pass;
   
  
  

    public String getName() {
        return name;
    }

 
    public String getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name= name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
 public String validat() throws SQLException, ClassNotFoundException {
        boolean status = validd(name, pass);
        if (status) {
          DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select ADMINNAME	 from ADMINTABLE7 where ADMINNAME=?");
            ps.setString(1, name);   
          
            ResultSet rs = ps.executeQuery();
            rs.next();
            String UserName =rs.getString(1);
            if ("lema".equals(UserName)) {
                return "adminpage.xhtml";
            } else {
                return "loginadmin.xhtml";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username or Passowrd",
                            "Please enter correct username or Password"));
            return "loginadmin.xhtml";
        }
    }
 
    public boolean validd(String adminame, String password) {
        
        boolean check = false;
        try {

            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            PreparedStatement ps = con.prepareStatement("select * from ADMINTABLE7 where ADMINNAME=? and PASSWORD=?");
            ps.setString(1, adminame);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            check = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return check;
    }
    
 

    
}