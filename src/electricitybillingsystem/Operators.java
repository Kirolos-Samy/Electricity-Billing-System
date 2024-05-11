/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Operators extends Customers {
    
    public Operators(){
        createConnection();
    }
    
    public void viewBills(Operators oper, JTable table) {

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        try {
            Statement stmt000 = con.createStatement();
            ResultSet res000 = stmt000.executeQuery("select meter_id from customers where region ='"+region+"'");
            while (res000.next()) {
                oper.meter_id = res000.getString("meter_id");
                Statement stmt14 = con.createStatement();
                ResultSet rs14 = stmt14.executeQuery("SELECT * FROM BILLS WHERE METER_ID ='"+meter_id+"'");
                while (rs14.next()) {
                    oper.bill_id = rs14.getString("bill_id");
                    oper.month = rs14.getString("month");
                    oper.year = rs14.getString("year");
                    oper.meter_id = rs14.getString("meter_id");
                    oper.prev_reading = rs14.getInt("prev_reading");
                    oper.curr_reading = rs14.getInt("curr_reading");
                    oper.consumption = rs14.getInt("consumption");
                    oper.tariff = rs14.getInt("tariff");
                    oper.unit_price = rs14.getInt("unit_price");
                    oper.total_bill = rs14.getInt("total_bill");
                    tableModel.addRow(new Object[]{bill_id, month, year, meter_id, prev_reading, curr_reading, consumption, tariff, unit_price, total_bill});
                }
            }
            stmt000.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    
    public void viewMeters(Operators oper, JTable table){

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMERS WHERE F_STOP = 0");
//            if(!rs.next())
//              JOptionPane.showMessageDialog(null, "All bills are paid");
            while(rs.next()){
                oper.meterid = rs.getString("meter_id");
                oper.name = rs.getString("cus_name");
                oper.address = rs.getString("cus_address");
                oper.region = rs.getString("region");
                tableModel.addRow(new Object[]{oper.meterid,oper.name,oper.address,oper.region});
            }
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } 
    
    
    public int stopMeter(Operators operator) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE CUSTOMERS SET f_stop = 1 WHERE meter_id=?");
            stmt.setString(1, operator.meterid);
            stmt.execute();
            stmt.close();
            
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(validateReading.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    

    
}
