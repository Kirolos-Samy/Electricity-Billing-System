/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DELL
 */
public class AddUserForm extends javax.swing.JFrame {

    /**
     * Creates new form AddUserForm
     */
    Connection con ;

    
    public AddUserForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
    }
    
    void createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Elec_Bill","root","root");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        user_role = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user_name_text = new javax.swing.JTextField();
        user_password_text = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Add User");
        setMinimumSize(new java.awt.Dimension(760, 465));
        setResizable(false);
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                formInputMethodTextChanged(evt);
            }
        });
        getContentPane().setLayout(null);

        table.setBackground(new java.awt.Color(0, 51, 102));
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Password", "Role"
            }
        )
        {
            public boolean isCellEditable(int row ,int column){
                return false ;
            }
        }

    );
    jScrollPane1.setViewportView(table);

    getContentPane().add(jScrollPane1);
    jScrollPane1.setBounds(287, 81, 452, 296);

    jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    jButton1.setText("Update");
    jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton1);
    jButton1.setBounds(156, 278, 113, 54);

    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel3.setText("Name : ");
    getContentPane().add(jLabel3);
    jLabel3.setBounds(38, 124, 88, 20);

    user_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Operator", "Admin" }));
    user_role.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            user_roleActionPerformed(evt);
        }
    });
    getContentPane().add(user_role);
    user_role.setBounds(144, 226, 125, 22);

    jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel4.setText("Password :");
    getContentPane().add(jLabel4);
    jLabel4.setBounds(38, 175, 88, 20);

    jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel5.setText("Role : ");
    getContentPane().add(jLabel5);
    jLabel5.setBounds(38, 226, 88, 20);
    getContentPane().add(user_name_text);
    user_name_text.setBounds(144, 124, 125, 22);
    getContentPane().add(user_password_text);
    user_password_text.setBounds(144, 175, 125, 22);

    jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("User Controls");
    getContentPane().add(jLabel1);
    jLabel1.setBounds(66, 8, 164, 43);

    jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electricitybillingsystem/155.jpg"))); // NOI18N
    jButton2.setText("Add");
    jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton2);
    jButton2.setBounds(40, 278, 110, 54);

    jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    jButton4.setText("Delete");
    jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton4);
    jButton4.setBounds(530, 390, 98, 33);

    jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    jButton5.setText("Edit");
    jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton5);
    jButton5.setBounds(400, 390, 98, 33);

    jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
    jButton3.setText("View");
    jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
    getContentPane().add(jButton3);
    jButton3.setBounds(403, 15, 229, 33);

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electricitybillingsystem/filo copy 3rr.jpg"))); // NOI18N
    jLabel2.setText("jLabel2");
    getContentPane().add(jLabel2);
    jLabel2.setBounds(0, 0, 760, 460);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //UPDATE
        Users user = new Users();
        user.username = user_name_text.getText();
        user.password = user_password_text.getText();
        user.userrole = (String) user_role.getSelectedItem();

        try {
            if(user.updateUser(user)==1){
                JOptionPane.showMessageDialog(null, "Update Completed", "Done",JOptionPane.INFORMATION_MESSAGE);
                jButton3.doClick();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void user_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_roleActionPerformed
        // DELETE
    }//GEN-LAST:event_user_roleActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // DELETE BUTTON
        try {
            Users user = new Users();
            int row = table.getSelectedRow();
            user.username = table.getValueAt(row,0).toString();
            if(user.deleteUser(user)==1){
            JOptionPane.showMessageDialog(null, "User deleted Successfully", "Done",JOptionPane.INFORMATION_MESSAGE);
            jButton3.doClick();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // EDIT BUTTON
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Users user1 = new Users();
        int row = table.getSelectedRow();
        user1.username = (String) model.getValueAt(row,0);
        user1.password = (String) model.getValueAt(row,1);
        user1.userrole = (String) model.getValueAt(row,2);
        user_name_text.setText(user1.username);
        user_password_text.setText(user1.password);
        user_role.setSelectedItem(user1.userrole);
        try {
            user1.editUser(user1);
        } catch (SQLException ex) {
            Logger.getLogger(AddUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            // ADD BUTTON
            Users user1 = new Users();            
            user1.username = user_name_text.getText();
            user1.password = user_password_text.getText();
            user1.userrole = (String) user_role.getSelectedItem();
            try {
            if(user1.addUser(user1)==1){
            JOptionPane.showMessageDialog(null, "User added Successfully ", "Done",JOptionPane.INFORMATION_MESSAGE);
            jButton3.doClick();

            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //        try {
            //            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Elec_Bill","root","root");
            //            Statement stmt = (Statement) con.createStatement();
            //            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
            //            while(rs.next()){
                //                String id = rs.getString("user_id");
                //                String name = rs.getString("user_name");
                //                String role = rs.getString("user_role");
                //            }
            //
            //        } catch (SQLException ex) {
            //            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
            //        }

        //        try {
            //            String id = user_id.getText();
            //            String name = user_name.getText();
            //            String pass = user_password.getText();
            ////            String role = user_role.getText();
            //            String role = (String) user_role.getSelectedItem();
            //            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Elec_Bill","root","root");
            //            PreparedStatement stmt = con.prepareStatement("INSERT INTO USERS VALUES (?,?,?,?)");
            //            stmt.setString(1, id);
            //            stmt.setString(2, name);
            //            stmt.setString(3, pass);
            //            stmt.setString(4, role);
            ////            stmt.setString(5, role2);
            //            stmt.execute();
            //            System.out.println("Insertion Completed !");
            //            user_id.setText("");
            //            user_name.setText("");
            //            user_password.setText("");
            //            stmt.close();
            //        } catch (SQLException ex) {
            //            Logger.getLogger(ElectricityBillingSystem.class.getName()).log(Level.SEVERE, null, ex);
            //        }
        //
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // VIEW BUTTON
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        Users user1 = new Users();
        user1.viewUsers(user1, table);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField user_name_text;
    private javax.swing.JPasswordField user_password_text;
    private javax.swing.JComboBox<String> user_role;
    // End of variables declaration//GEN-END:variables
}