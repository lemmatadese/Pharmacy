/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
String amount="";

String medicine;
String lastname;
String fristname;

String address;
String email;
 String medecineid;
  String product;
String price;

String status;
String brand;

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
            ps.setString(4, medecineid);
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
  public void buy(String medicine1,String amount1) throws ClassNotFoundException, SQLException {
         
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            String sql="select * from ADMINTABEL where medecineid=?";
               PreparedStatement ps1 = con.prepareStatement(sql);
               ps1.setString(1, medecineid);
                           ResultSet rs=ps1.executeQuery();
                           if(rs.next()){
                           String s=rs.getString(1);
                           Integer num=Integer.parseInt(s);
                          System.out.println("the problem is ..........");
                           Integer value=Integer.parseInt(amount1);
                           if(num<value){
                               System.out.println("not enougn amount");
                           } else{
                         value-=num;
                      value=Math.abs(value);
                          amount+=value;
                          
                            
                 sql="update ADMINTABEL set AMOUNT=? where MEDICINEID=? ";  
                 PreparedStatement ps=con.prepareStatement(sql);
                      ps.setString(1,medecineid );

                       ps.setString(2, amount);
           
             ps.setString(3,medecineid );


            ps.executeUpdate();}
}
    }}
