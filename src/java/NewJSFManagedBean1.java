/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author lema
 */

@Dependent
@ManagedBean
public class NewJSFManagedBean1 {
String fristname;

String lastname;
String address;
String email;
 String medecineid;

    public String getMedecineid() {
        return medecineid;
    }

    public void setMedecineid(String medecineid) {
        this.medecineid = medecineid;
    }
    public String getFristname() {
        return fristname;
    }

    public void setFristname(String fristname) {
        this.fristname = fristname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
   public void profilerInsert() throws ClassNotFoundException, SQLException {
       
        
            
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into COSTUMTABEL(FRISTNAME,LASTNAME,EMAIL,MEDICINEID) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fristname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(8, medecineid);
            ps.executeUpdate();
            try{
           
        } catch (Exception e) {
        }
    }
  public static String delete(int medecineid) throws ClassNotFoundException{
        System.out.println("deleted " + medecineid);
        try {
             DBConnection db=new DBConnection();
            try (Connection connection = db.connMethod()) {
                PreparedStatement stmt=connection.prepareStatement("delete from ADMINTABEL where MEDICINEID = " + medecineid);
                stmt.executeUpdate();
            }
        } catch(SQLException sqlException){
        }
        return "/costumeroperation.xhtml?faces-redirect=true";
    } 
    }
