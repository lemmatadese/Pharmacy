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
public class NewJSFManagedBean {
String fristname;

String lastname;
String medicine;
String product;
String price;

String status;
String brand;
String medecineid;

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

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMedecineid() {
        return medecineid;
    }

    public void setMedecineid(String medecineid) {
        this.medecineid = medecineid;
    }


    
   public void profilerInsert() throws ClassNotFoundException, SQLException {
       
        
            
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql = "Insert into ADMINTABEL(FRISTNAME,LASTNAME,MEDICINE,PRODUCT,PRICE,STATUS,BRAND,MEDICINEID) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fristname);
            ps.setString(2, lastname);
            ps.setString(3, medicine);
            ps.setString(4, product);
            ps.setString(5, price);
             ps.setString(6, status);
            ps.setString(7, brand);
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
        return "/adminpage.xhtml?faces-redirect=true";
    } 
    }
