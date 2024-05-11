/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;


import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
   
public class Users extends javax.swing.JFrame {
    
     public Connection con ;
     public String userid ;
     public String username ;
     public String password ;
     public String userrole ;
     public static String upuser_id ;
     public static String umeter_id ;
     
    public Users() {
//        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();        
    }

    public int login(Users user1){
        
                try {    
                    Statement stmt2 = con.createStatement();           
                    ResultSet rs = stmt2.executeQuery("select user_name from users where user_name='"+username+"'and user_pass='"+password+"' ");   
                    if(!rs.next())
                      JOptionPane.showMessageDialog(null, "Invalid Entry !", "ERROR", JOptionPane.ERROR_MESSAGE);
                    
                }catch (SQLException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {    
                    Statement stmt2 = con.createStatement();           
                    ResultSet rs = stmt2.executeQuery("select user_role from users where user_name='"+username+"'and user_pass='"+password+"' ");
                    while(rs.next()){
                        user1.userrole = rs.getString("user_role");
//                        rolefield.setText(role);
                        if(user1.userrole.equalsIgnoreCase("Admin")){
                            new Admin().setVisible(true);
//                            new LoginForm().setVisible(false);
                            return 1 ;
                        }                    
                        else if(user1.userrole.equalsIgnoreCase("Operator")){
                            new Operator().setVisible(true);
                            return 1 ;
                        }                    
                        else if(user1.userrole.equalsIgnoreCase("Customer")){
                            new customer().setVisible(true);
                            return 1 ;
                        }
                        else if(user1.userrole.equalsIgnoreCase(null)){
                            JOptionPane.showMessageDialog(null,"INVALID ENTRY !!");
                        }
                                              
//                        new LoginForm().setVisible(false);
                        
                    }
                    stmt2.close();
                    
                } catch (SQLException ex) {
                 Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                return 0 ;
        
    }
    
    public void check_meter_id(Users user1) {

        try {
            Statement stmt21 = con.createStatement();
            ResultSet res21 = stmt21.executeQuery("select user_id from users where user_name='" + username + "' ");
            while (res21.next()) {
                userid = res21.getString("user_id");
            }
            stmt21.close();

            Statement stmt22 = con.createStatement();
            ResultSet res22 = stmt22.executeQuery("select meter_id from customers where user_id='" + userid + "' ");
            while (res22.next()) {
                umeter_id = res22.getString("meter_id");
            }
            stmt21.close();

        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

//        return umeter_id;
    }

    public int addUser(Users user) throws SQLException{
        try {
            PreparedStatement stmt11 = con.prepareStatement("INSERT INTO USERS (user_name,user_pass,user_role) VALUES (?,?,?)");
            stmt11.setString(1, user.username);
            stmt11.setString(2, user.password);
            stmt11.setString(3, user.userrole);
            stmt11.execute();
            stmt11.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            return 1 ;
    }

    
    public void viewUsers(Users user , JTable table){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
            while(rs.next()){
                user.username = rs.getString("user_name");
                user.password = rs.getString("user_pass");
                user.userrole = rs.getString("user_role");
                tableModel.addRow(new Object[]{username,password,userrole});
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void editUser(Users user) throws SQLException{
            Statement stmt2 = con.createStatement();
            ResultSet res2 = stmt2.executeQuery("select user_id from users where user_name='" + user.username + "' ");
            while (res2.next()) {
                user.upuser_id = res2.getString("user_id");
            }
            stmt2.close();
        
    }


    public int updateUser(Users user) throws SQLException{
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE Users " +
                                                            " SET   user_pass = ?," +
                                                            "       user_role = ?, " +
                                                            "       user_name = ? " +
                                                            "	WHERE user_id = ? ");
            stmt.setString(1, user.password);
            stmt.setString(2, user.userrole);
            stmt.setString(3, user.username);
            stmt.setString(4, user.upuser_id);
            stmt.executeUpdate();
            stmt.close(); 

            return 1 ;
        } catch (SQLException ex) {
            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 0 ;
    }
    
    
    public int deleteUser(Users user) throws SQLException{
            String sqlc = "DELETE FROM USERS WHERE USER_NAME = ?";
            PreparedStatement stmt = con.prepareStatement(sqlc);
            stmt.setString(1,user.username);
            stmt.executeUpdate();
            return 1 ;
    }


    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Elec_Bill", "root", "root");
            Statement stmt = (Statement) con.createStatement();
            System.out.println("Database Connection Success");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
