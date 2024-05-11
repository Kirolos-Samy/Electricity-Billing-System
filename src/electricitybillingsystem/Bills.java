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
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Bills extends Users{
    public String bill_id ;
    public int prev_bill_id ;
    public String prev_bill_id_s ;
    public String month ;
    public String year ;
    public String meter_id ;
    public int prev_reading ;
    public int curr_reading ;
    public int consumption ;
    public int tariff ;
    public int unit_price ;
    public int total_bill ;
    public int f_read ;
    public int f_validate ;
    public int f_pay ;
    public int f_collect ;
    
    
    public Bills() {
        createConnection();        
    }
    
    public int checkActive(Bills bill) {
        // Check for active meter 
        try {
            Statement stmt02 = con.createStatement();
            ResultSet res0 = stmt02.executeQuery("select f_stop from customers where meter_id = '" + meter_id + "' ");
            while (res0.next()) {
                if (res0.getInt("f_stop") == 1) {
                    JOptionPane.showMessageDialog(null, "Your meter is stopped .. Please contact the operator ", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public int readingMeter(Bills bill) {

        // Calculate new bill id 
        bill.bill_id = bill.meter_id + bill.year + bill.month;

//            // Check for active meter 
        if (checkActive(bill) == 1) {
//            try {    
//                Statement stmt02 = con.createStatement();           
//                ResultSet res0 = stmt02.executeQuery("select meter_id from customers where f_stop = 1");   
//                if(res0.next()){
//                  JOptionPane.showMessageDialog(null, "Your meter is stopped .. Please contact the opertor ", "ERROR", JOptionPane.ERROR_MESSAGE);
//                  return 0 ;
//                }
//
//            }catch (SQLException ex) {
//                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
//            }

            // Check for repeated month entry 
            try {
                Statement stmt2 = con.createStatement();
                ResultSet res = stmt2.executeQuery("select meter_id from bills where bill_id='" + bill_id + "'");
                if (res.next()) {
                    JOptionPane.showMessageDialog(null, "Repeated month", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                // Calculate last bill id 
                bill.prev_bill_id = Integer.parseInt(bill.bill_id) - 1;
                if (bill.prev_bill_id % 100 == 0) {
                    bill.prev_bill_id = bill.prev_bill_id - 100;
                    bill.prev_bill_id = bill.prev_bill_id + 12;
                }
                bill.prev_bill_id_s = Integer.toString(bill.prev_bill_id);
//                int prev_reading_i ;
//                String prev_reading = "" ;

//                int consumption = 0 ;
//                int tariff = 0 ;  
//                int unit_price = 0  ;
//                int total_bill = 0 ;
                Statement stmt00 = con.createStatement();
                ResultSet rs = stmt00.executeQuery("select curr_reading from BILLS where bill_id ='" + prev_bill_id_s + "' ");
                // Checking if no previous bill for this meter_id
                if (!rs.next()) {
                    bill.prev_reading = 0;
                } // If found calculate the new consumption
                else {
                    bill.prev_reading = rs.getInt("curr_reading");
//                    prev_reading = Integer.toString(prev_reading_i);                    
                    bill.consumption = bill.curr_reading - bill.prev_reading;
                    if (bill.consumption < 500) {
                        bill.tariff = 1;
                        bill.unit_price = 1;
                    } else {
                        bill.tariff = 2;
                        bill.unit_price = 2;
                    }
                    bill.total_bill = bill.consumption * bill.unit_price;
                }

                // Create new record in db for thr new bill 
                PreparedStatement stmt = con.prepareStatement("INSERT INTO BILLS (bill_id, month,year,meter_id,prev_reading,curr_reading,consumption,tariff,unit_price,total_bill) VALUES (?,?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, bill.bill_id);
                stmt.setString(2, bill.month);
                stmt.setString(3, bill.year);
                stmt.setString(4, bill.meter_id);
                stmt.setString(5, Integer.toString(bill.prev_reading));
                stmt.setString(6, Integer.toString(bill.curr_reading));
                stmt.setString(7, Integer.toString(bill.consumption));
                stmt.setString(8, Integer.toString(bill.tariff));
                stmt.setString(9, Integer.toString(bill.unit_price));
                stmt.setString(10, Integer.toString(bill.total_bill));
                stmt.execute();
                JOptionPane.showMessageDialog(null, "Submitted Succesfully", "Done", JOptionPane.INFORMATION_MESSAGE);
//                RefreshButton.doClick();

                stmt.close();
                return 1;
            } catch (SQLException ex) {
                Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return 0;
    }

    public void viewCollectBills(Bills bill, JTable table){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BILLS WHERE F_PAY = 1 AND F_COLLECT = 0");
            while(rs.next()){
                String bill_id = rs.getString("bill_id");
                String month = rs.getString("month");
                String year = rs.getString("year");
                String meter_id = rs.getString("meter_id");
                String prev_reading = rs.getString("prev_reading");
                String curr_reading = rs.getString("curr_reading");
                String consumption = rs.getString("consumption");
                String tariff = rs.getString("tariff");
                String unit_price = rs.getString("unit_price");
                String total_bill = rs.getString("total_bill");
                tableModel.addRow(new Object[]{bill_id,month,year,meter_id,prev_reading,curr_reading,consumption,tariff,unit_price,total_bill});
            }
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    public void viewPrintBills(Bills bill, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BILLS WHERE F_PAY = 1 AND F_COLLECT = 1 AND meter_id ='" +meter_id+ "'  ");
            while (rs.next()) {
                String bill_id = rs.getString("bill_id");
                String month = rs.getString("month");
                String year = rs.getString("year");
                String meter_id = rs.getString("meter_id");
                String consumption = rs.getString("consumption");
                String total_bill = rs.getString("total_bill");
                tableModel.addRow(new Object[]{bill_id, month, year, meter_id, consumption, total_bill});
            }
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public int viewPayBills(Bills bill, JTable table) {

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        int count = 0 ;

        if (checkActive(bill) == 1) {
            try {
                Statement stmt100 = con.createStatement();
                ResultSet rs100 = stmt100.executeQuery("SELECT * FROM BILLS WHERE METER_ID = '" + meter_id + "' AND CONSUMPTION AND F_VALIDATE = 1 AND F_PAY = 0");
//                if (!rs100.next()) {
//                    JOptionPane.showMessageDialog(null, "All bills are paid");
//                    
//                }else{
                while(rs100.next()) {
                    bill.bill_id = rs100.getString("bill_id");
                    bill.month = rs100.getString("month");
                    bill.year = rs100.getString("year");
                    bill.meter_id = rs100.getString("meter_id");
                    bill.prev_reading = rs100.getInt("prev_reading");
                    bill.curr_reading = rs100.getInt("curr_reading");
                    bill.consumption = rs100.getInt("consumption");
                    bill.tariff = rs100.getInt("tariff");
                    bill.unit_price = rs100.getInt("unit_price");
                    bill.total_bill = rs100.getInt("total_bill");
                    tableModel.addRow(new Object[]{bill_id, month, year, meter_id, prev_reading, curr_reading, consumption, tariff, unit_price, total_bill});
                    count ++ ;
                }
                stmt100.close();
//                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return count ;
    }
        
    
    public int payBills(Bills bill) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE BILLS SET f_pay = 1 WHERE bill_id=?");
            stmt.setString(1, bill.bill_id);
            stmt.execute();
            stmt.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(validateReading.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
  
    public String getEmail(Bills bill) {
        String myemail = null;

        try {
            Statement stmt100 = con.createStatement();
            ResultSet rs100 = stmt100.executeQuery("select cus_email from customers where meter_id ='" + meter_id + "'");
            while (rs100.next()) {
                myemail = rs100.getString("cus_email");
            }
            stmt100.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return myemail;
    }

    

    
        
        
}
