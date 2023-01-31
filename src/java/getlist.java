import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Dependent
@ManagedBean

@SessionScoped
public class getlist  {

    public List<NewJSFManagedBean> getUserList() {
        List<NewJSFManagedBean> list = new ArrayList<>();
        try {
        
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from ADMINTABEL");
            while (rs.next()) {
                NewJSFManagedBean admin = new NewJSFManagedBean();
                admin.setMedicine(rs.getString("MEDICINE"));
                admin.setProduct(rs.getString("PRODUCT"));
                admin.setPrice(rs.getString("PRICE"));
                admin.setStatus(rs.getString("STATUS"));
                 admin.setBrand(rs.getString("BRAND"));
                 admin.setMedecineid(rs.getString("MEDICINEID"));
                             admin.setAmount(rs.getString("AMOUNT"));


                
                list.add(admin);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;
    }
    
    public List<NewJSFManagedBean> geUserList() {
        List<NewJSFManagedBean> list = new ArrayList<>();
        try {
        
            DBConnection dbcon = new DBConnection();
            Connection con = dbcon.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from COSTUMTABEL");
            while (rs.next()) {
                NewJSFManagedBean admin = new NewJSFManagedBean();
                admin.setMedicine(rs.getString("FRISTNAME"));
                admin.setProduct(rs.getString("LASTNAME"));
                admin.setPrice(rs.getString("EMAIL"));
                admin.setStatus(rs.getString("MEDICINEID"));
                


                
                list.add(admin);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;}

}
