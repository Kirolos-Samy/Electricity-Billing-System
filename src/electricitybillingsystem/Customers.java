/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import electricitybillingsystem.sendEmail.sendEmail; 

public class Customers extends Bills { 
    
    public String meterid ;
    public String name ;
    public String address ;
    public String region ;
    public String email ;
    public String mobile ;
//    public String username ;
//    public String password ;     
    public Icon contract;
    public String password2;
    
    public Customers() {
        this.setLocationRelativeTo(null);
        createConnection();      
        
    }

        Email em = new Email();

    public boolean emailValidate(String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";


        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    boolean mobileValidation(String s) {
        if (s.length() != 11) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) < (int) '0' || (int) s.charAt(i) > (int) '9') {
                return false;
            }
        }
        return true;
    }    

    public static boolean containsNumbers(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        for (int i = 0; i < string.length(); ++i) {
            if (Character.isDigit(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    
    public int Validate(Customers cus1) {

        if (cus1.name.length() < 10 || containsNumbers(cus1.name)) {
            JOptionPane.showMessageDialog(null, " name must be atleast 10 characters and cant contain digits!");
        } else if (cus1.address.equals("")) {
            JOptionPane.showMessageDialog(null, " Address required!");
        } else if (!emailValidate(cus1.email)) {
            JOptionPane.showMessageDialog(null, "Invalid Email!");
        } else if (!mobileValidation(cus1.mobile)) {
            JOptionPane.showMessageDialog(null, "invalid MobileNumber!");
        } else if (cus1.username.equals("") || cus1.username.length() < 5) {
            JOptionPane.showMessageDialog(null, "UserName must be 5 characters or more!");
        } else if (cus1.password.equals("") || cus1.password.length() < 8) {
            JOptionPane.showMessageDialog(null, "password must be atleast 8 characters or more!");
        } else if (!cus1.password.equals(cus1.password2)) {
            JOptionPane.showMessageDialog(null, "password doesnt match!");
        } else if (cus1.contract == null) {
            JOptionPane.showMessageDialog(null, "contract required!");

        } else {
//            JOptionPane.showMessageDialog(null, "Submitted Successfully");
            JOptionPane.showMessageDialog(null, "Submitted Successfully", "Done", JOptionPane.INFORMATION_MESSAGE);

        }

        // code to be executed
        return 1 ;
    }

    
    
    
    
//    public int register(String name,String address,String region,String email,String mobile,String username,String password){
    public int register(Customers cus) throws Exception{
        
            try {

                //CHECKING IF CUSTOMER NAME EXISTS ALREADY
                Statement stmt0 = con.createStatement();           
                ResultSet rs0 = stmt0.executeQuery("select meter_id from customers where cus_name='"+name+"' ");   
                if(rs0.next()){
                  JOptionPane.showMessageDialog(null, "Name already used !", "ERROR", JOptionPane.ERROR_MESSAGE);
                  return -1;
                }
                stmt0.close();
                ///////////////////////////////////////////
                
                //CHECKING IF USER NAME EXISTS ALREADY
                Statement stmt11 = con.createStatement();           
                ResultSet rs11 = stmt11.executeQuery("select user_id from users where user_name='"+username+"' ");   
                if(rs11.next()){
                  JOptionPane.showMessageDialog(null, "Username already used !", "ERROR", JOptionPane.ERROR_MESSAGE);
                  return -1;
                }
                stmt11.close();
                ///////////////////////////////////////////     
                
                PreparedStatement stmt2 = con.prepareStatement("INSERT INTO USERS (user_name,user_pass,user_role) VALUES (?,?,?)");
                stmt2.setString(1, username);
                stmt2.setString(2, password);
                stmt2.setString(3, "Customer");
                stmt2.execute();
                stmt2.close();

                //Adding user_id in customers table to link user with meter_id
                
                Statement stmt3 = con.createStatement();           
                String cuser_id = null ;
                ResultSet res3 = stmt3.executeQuery("select user_id from users where user_name='"+username+"' ");   
                while(res3.next()){
                    cuser_id = res3.getString("user_id");
//                    int cuser_id = res3.getInt("user_id");
                }
                stmt3.close();
                
//                //UPDATE BILLS SET f_validate = 1 WHERE bills.bill_id='10032206';
//                
//                PreparedStatement stmt4 = con.prepareStatement("UPDATE CUSTOMERS SET USER_ID = ? WHERE ");
//                stmt4.setString(1, cuser_id);
//                stmt4.execute();
//                stmt4.close();

                ///////////////////////////////////////////     

                PreparedStatement stmt = con.prepareStatement("INSERT INTO CUSTOMERS (cus_name, cus_address,region,cus_email,cus_mob,user_id) VALUES (?,?,?,?,?,?)");
                stmt.setString(1, name);
                stmt.setString(2, address);
                stmt.setString(3, region);
                stmt.setString(4, email);
                stmt.setString(5, mobile);
                stmt.setString(6, cuser_id);
                stmt.execute();
                stmt.close();
                
                
                Statement stmt1 = con.createStatement();           
                ResultSet rs = stmt1.executeQuery("select meter_id from customers where cus_name='"+name+"' ");
                while(rs.next()){
                    meterid = rs.getString("meter_id");
//                    JOptionPane.showMessageDialog(null, "Your meter id is : '"+meterid+"' ", "Register Done",JOptionPane.INFORMATION_MESSAGE);
                    em.sendEmail(meterid,cus.email);

//                    RefreshButton.doClick();
                }




            } catch (SQLException ex) {
                Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(null, "Name already used !", "ERROR", JOptionPane.ERROR_MESSAGE);                
            }
                return 1 ;
            
    }
    
//    public void createConnection(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Elec_Bill","root","root");
//            Statement stmt = (Statement) con.createStatement();
////            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
////            while(rs.next()){
////                String id = rs.getString("user_id");
////                String name = rs.getString("user_name");
////                String role = rs.getString("user_role");
////                System.out.println(id);
////                System.out.println(name);
////                System.out.println(role);
////            }
//            System.out.println("Database Connection Success");
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }    
    
    
    
    
    
}