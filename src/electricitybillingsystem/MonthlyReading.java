/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package electricitybillingsystem;

import java.awt.Dimension;
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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DELL
 */
public class MonthlyReading extends Users {

    Connection con ;
        
    public MonthlyReading() {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
        meter_id.setText(umeter_id);
        
//        Bills bill0 = new Bills();
//        Users user0 = new Users();
//        String x = user0.check_meter_id(user0);
//        meter_id.setText(x);
//        System.out.println(x);
    }
    
//    void createConnection(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Elec_Bill","root","root");
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        
//    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        meter_id = new javax.swing.JTextField();
        year = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        curr_reading = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reading of meter ");
        setMinimumSize(new java.awt.Dimension(636, 446));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Meter ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(183, 106, 60, 20);

        meter_id.setEditable(false);
        meter_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meter_idActionPerformed(evt);
            }
        });
        getContentPane().add(meter_id);
        meter_id.setBounds(332, 103, 130, 22);

        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "22", "23", "24", "25", "26", "27", "28" }));
        getContentPane().add(year);
        year.setBounds(400, 160, 60, 22);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(183, 160, 46, 20);

        curr_reading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curr_readingActionPerformed(evt);
            }
        });
        getContentPane().add(curr_reading);
        curr_reading.setBounds(331, 210, 130, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Current Reading");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 210, 120, 20);

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        getContentPane().add(month);
        month.setBounds(330, 160, 60, 22);

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel3.setText("Enter monthly reading");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 20, 220, 40);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 280, 130, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electricitybillingsystem/filo copyrr.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-3, -4, 640, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meter_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meter_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meter_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Submit reading
        Bills bill = new Bills();

        bill.meter_id = meter_id.getText();
        bill.month = (String) month.getSelectedItem();
        bill.year = (String) year.getSelectedItem();
        bill.curr_reading = Integer.parseInt(curr_reading.getText());

        if(bill.readingMeter(bill) == 1){
            initComponents();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void curr_readingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curr_readingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_curr_readingActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        // REFRESH BUTTON
        meter_id.setText("");
        curr_reading.setText("");

    }//GEN-LAST:event_RefreshButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MonthlyReading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonthlyReading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonthlyReading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonthlyReading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonthlyReading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField curr_reading;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField meter_id;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables

}
