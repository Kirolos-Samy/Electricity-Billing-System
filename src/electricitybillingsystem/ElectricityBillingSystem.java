package electricitybillingsystem;

//import com.sun.jdi.connect.spi.Connection;

//import com.mysql.cj.xdevapi.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.Statement;

//public class ElectricityBillingSystem {  
//        public static void main(String args[]) throws ClassNotFoundException  
//        {  
//            String name,pass,url;  
//            Connection con = null;  
//            try {  
//                Class.forName("com.mysql.cj.jdbc.Driver");  
//            url="jdbc:mysql://localhost:3306/Elec_Bill";  
//                name="root";  
//                pass="root";  
//                con = (Connection) DriverManager.getConnection(url,name,pass);  
//                System.out.println("Connection created");  
//                con.close();  
//                System.out.println("Connection closed");  
//                }  
//                catch (Exception e) {  
//                System.out.println(e.toString());  
//            }  
//    }  
//}  





public class ElectricityBillingSystem {
    
    Connection con ;

    public static void main(String[] args) throws SQLException {
        ElectricityBillingSystem elec = new ElectricityBillingSystem();
        elec.createConnection();
        new LoginForm().setVisible(true);
//        elec.createTable();
    }
    
//    void createTable(){
//        try {
//            String q = "Create table users2("
//                    + "name varchar(100),"
//                    + "age int,"
//                    + "salary float"
//                    + ");" ;
//            Statement stmt = con.createStatement();
//            stmt.execute(q);
//            System.out.println("Succesfully Created");
//            stmt.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//    }
    
    public void createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Elec_Bill","root","root");
            Statement stmt = (Statement) con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
//            while(rs.next()){
//                String id = rs.getString("user_id");
//                String name = rs.getString("user_name");
//                String role = rs.getString("user_role");
//                System.out.println(id);
//                System.out.println(name);
//                System.out.println(role);
//            }
            System.out.println("Database Connection Success");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
