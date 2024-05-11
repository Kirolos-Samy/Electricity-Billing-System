/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricitybillingsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Admins extends Customers{
    
    public int sum_consumption ;
    public int reg_consumption ;
    public float reg_per ;
    public int total_coll ;
    
    public Admins(){
        createConnection();
    }
    
    public void viewRegionStat(Admins admin) {
        try {

            Statement stmt0 = con.createStatement();
            ResultSet res11 = stmt0.executeQuery("select sum(consumption) from bills INNER JOIN customers on bills.meter_id = customers.meter_id where customers.region ='"+region+"' ");
            while (res11.next()) {
                admin.reg_consumption = res11.getInt("sum(consumption)");
            }
            stmt0.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
//    public void calc_per(Admins admin){
//        admin.reg_per = (admin.reg_consumption) / (admin.sum_consumption) * 100 ; 
//    }
    
    public void viewTotalCollected(Admins admin){
        try {
            Statement stmt00 = con.createStatement();
            ResultSet res00 = stmt00.executeQuery("select sum(total_bill) from bills where f_collect = 1 ");
            while (res00.next()) {
                admin.total_coll = res00.getInt("sum(total_bill)");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    public void viewStatistics(Admins admin, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        try {
            Statement stmt00 = con.createStatement();
            ResultSet res00 = stmt00.executeQuery("select sum(consumption) from bills");
            while (res00.next()) {
                admin.sum_consumption = res00.getInt("sum(consumption)");
                //Giza, Maadi, Dokky, Ainshams, Helwan
                
                Admins admin1 = new Admins();
                admin1.region = "Giza";
                admin1.viewRegionStat(admin1);
                admin1.reg_per = ((float) admin1.reg_consumption / admin.sum_consumption) * 100;

                Admins admin2 = new Admins();
                admin2.region = "Maadi";
                admin2.viewRegionStat(admin2);
                admin2.reg_per = ((float) admin2.reg_consumption / admin.sum_consumption) * 100;

                Admins admin3 = new Admins();
                admin3.region = "Dokky";
                admin3.viewRegionStat(admin3);
                admin3.reg_per = ((float) admin3.reg_consumption / admin.sum_consumption) * 100;

                Admins admin4 = new Admins();
                admin4.region = "Ainshams";
                admin4.viewRegionStat(admin4);
                admin4.reg_per = ((float) admin4.reg_consumption / admin.sum_consumption) * 100;

                Admins admin5 = new Admins();
                admin5.region = "Helwan";
                admin5.viewRegionStat(admin5);
                admin5.reg_per = ((float) admin5.reg_consumption / admin.sum_consumption) * 100;

                tableModel.addRow(new Object[]{admin1.region, admin1.reg_per});
                tableModel.addRow(new Object[]{admin2.region, admin2.reg_per});
                tableModel.addRow(new Object[]{admin3.region, admin3.reg_per});
                tableModel.addRow(new Object[]{admin4.region, admin4.reg_per});
                tableModel.addRow(new Object[]{admin5.region, admin5.reg_per});
            }
            stmt00.close();
            

//            oper.meter_id = res000.getString("meter_id");
//            Statement stmt14 = con.createStatement();
//            ResultSet rs14 = stmt14.executeQuery("SELECT * FROM BILLS WHERE METER_ID ='"+meter_id+"'");
//            while (rs14.next()) {
//                oper.bill_id = rs14.getString("bill_id");
//                oper.month = rs14.getString("month");
//                oper.year = rs14.getString("year");
//                oper.meter_id = rs14.getString("meter_id");
//                oper.prev_reading = rs14.getInt("prev_reading");
//                oper.curr_reading = rs14.getInt("curr_reading");
//                oper.consumption = rs14.getInt("consumption");
//                oper.tariff = rs14.getInt("tariff");
//                oper.unit_price = rs14.getInt("unit_price");
//                oper.total_bill = rs14.getInt("total_bill");
//                tableModel.addRow(new Object[]{bill_id, month, year, meter_id, prev_reading, curr_reading, consumption, tariff, unit_price, total_bill});
//            }
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
