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
                admin.setFristname(rs.getString("FRISTNAME"));
                admin.setLastname(rs.getString("LASTNAME"));
                admin.setMedicine(rs.getString("MEDICINE"));
                admin.setProduct(rs.getString("PRODUCT"));
                admin.setPrice(rs.getString("PRICE"));
                admin.setStatus(rs.getString("STATUS"));
                 admin.setBrand(rs.getString("BRAND"));
                 admin.setMedecineid(rs.getString("MEDICINEID"));
                //course[1]=rs.getString("COURSE");
                //usr.setCourse(course);
                list.add(admin);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return list;
    }

}
