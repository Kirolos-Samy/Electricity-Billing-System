/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package electricitybillingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class PayBills extends Bills {

    Connection con ;
    Email em = new Email();

    
    public PayBills() {
        initComponents();
        this.setLocationRelativeTo(null);           
        createConnection();
        meter_id1.setText(umeter_id);        
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        viewbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        meter_id1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pay Bills");
        setMinimumSize(new java.awt.Dimension(792, 541));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel4.setText("Pay Bills");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(350, 20, 90, 40);

        viewbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewbutton.setText("View");
        viewbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(viewbutton);
        viewbutton.setBounds(340, 80, 110, 30);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                " Bill_ID", "Month", "Year", "Meter_ID", "Prev_reading", "Curr_reading", "Consumption", "Tariff", "Unit_price", "Total_Bill"
            }
        )
        {
            public boolean isCellEditable(int row ,int column){
                return false ;
            }
        }
    );
    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    jScrollPane1.setViewportView(table);

    getContentPane().add(jScrollPane1);
    jScrollPane1.setBounds(50, 130, 670, 230);

    jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jButton1.setText("Pay Bill");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton1);
    jButton1.setBounds(300, 390, 220, 40);

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel1.setText("Meter ID : ");
    getContentPane().add(jLabel1);
    jLabel1.setBounds(80, 80, 90, 30);

    meter_id1.setEditable(false);
    meter_id1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            meter_id1ActionPerformed(evt);
        }
    });
    getContentPane().add(meter_id1);
    meter_id1.setBounds(180, 80, 130, 30);

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electricitybillingsystem/filo copyrr.jpg"))); // NOI18N
    jLabel3.setText("jLabel3");
    getContentPane().add(jLabel3);
    jLabel3.setBounds(-3, -4, 800, 590);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbuttonActionPerformed

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
//        int count = 0 ;

        Bills bill1 = new Bills();
        bill1.meter_id = meter_id1.getText() ;
        if(bill1.viewPayBills(bill1,table) > 3){
            JOptionPane.showMessageDialog(null, "Please pay !!!!", "!",JOptionPane.ERROR_MESSAGE);
            String x = bill1.getEmail(bill1);
            try {
                em.sendEmail2(x);
            } catch (Exception ex) {
                Logger.getLogger(PayBills.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        bill1.viewPayBills(bill1,table);

    }//GEN-LAST:event_viewbuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // PAY BUTTON
        Bills bill = new Bills();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        bill.bill_id = (String) model.getValueAt(row,0);
        if(bill.payBills(bill) == 1){
            JOptionPane.showMessageDialog(null, "Paid Successfully", "Done",JOptionPane.INFORMATION_MESSAGE);
            model.setRowCount(0);
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void meter_id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meter_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_meter_id1ActionPerformed

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
            java.util.logging.Logger.getLogger(PayBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayBills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField meter_id1;
    private javax.swing.JTable table;
    private javax.swing.JButton viewbutton;
    // End of variables declaration//GEN-END:variables
}
