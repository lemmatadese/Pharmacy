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

String medicine;
String product;
String price;

String status;
String brand;
String medecineid;
String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
            String sql = "Insert into ADMINTABEL(MEDICINE,PRODUCT,PRICE,STATUS,BRAND,MEDICINEID, AMOUNT) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, medecineid);
            ps.setString(2, medicine);
            ps.setString(3, product);
             ps.setString(4, price);
            ps.setString(5, status);
            ps.setString(6, brand);
             ps.setString(7, amount);

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
  public void update(String medecineid) throws ClassNotFoundException, SQLException {
       
        
            
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
         
            String sql = " update ADMINTABEL set MEDICINE=?,PRODUCT=?,PRICE=?,STATUS=?,BRAND=?,AMOUNT=? where MEDICINEID=?"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, medicine);
            ps.setString(2, product);
             ps.setString(3, price);
            ps.setString(4, status);
            ps.setString(5, brand);
             ps.setString(6, amount);
            ps.setString(7,medecineid);

            ps.executeUpdate();
            try{
           
        } catch (Exception e) {
        }
    }
    }
