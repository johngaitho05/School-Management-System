/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package School;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import School.Home2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author John YK
 */
public class Fees extends javax.swing.JFrame {
    /**
     * Creates new form filter_staff
     */
    public Fees() {
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        initComponents();
        Toolkit tk= Toolkit.getDefaultToolkit();
            int xsize= (int) tk.getScreenSize().getWidth();
            int ysize= (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        
   }
    public Fees(String d1,String d2) {
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        initComponents();
        Toolkit tk= Toolkit.getDefaultToolkit();
            int xsize= (int) tk.getScreenSize().getWidth();
            int ysize= (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        hover_fees.setForeground(Color.red);
       if (d1.equals("0") && d2.equals("0")){
        String query;
        query="select * from fees";
        try{
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","jnjg5//9");
            PreparedStatement pst=connection.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){

                String admfd = rs.getString("Student_No");
                int amtfd = rs.getInt("Amount_paid");
                String datefd = rs.getString("Date_paid");
                String modefd = rs.getString("Mode_of_payment");
                DefaultTableModel model= (DefaultTableModel)jTable_fees.getModel();
                Object[] row = new Object[4];
                row[0]= admfd;
                row[1]=amtfd;
                row[2]=datefd;
                row[3]=modefd;
                model.addRow(row);
            }
            if (jTable_fees.getRowCount()<1){
                    hover_fees.setText("No data found");
                }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        }else if (d2.equals("0")){
        String query;
        query="select * from fees where Student_No =?";
        try{
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","jnjg5//9");
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setString(1,d1);
            
            ResultSet rs=pst.executeQuery();
            while (rs.next()){

                String admfd = rs.getString("Student_No");
                int amtfd = rs.getInt("Amount_paid");
                String datefd = rs.getString("Date_paid");
                String modefd = rs.getString("Mode_of_payment");
                DefaultTableModel model= (DefaultTableModel)jTable_fees.getModel();
                
                Object[] row = new Object[4];
                row[0]= admfd;
                row[1]=amtfd;
                row[2]=datefd;
                row[3]=modefd;
                model.addRow(row);
                    
            }
            if (jTable_fees.getRowCount()<1){
                    hover_fees.setText("No data found");
                }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }else{
        String query;
        query="select * from fees where Date_paid>=? and Date_paid<=?";
        try{
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","jnjg5//9");
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setString(1,d1);
            pst.setString(2, d2);
            
            ResultSet rs=pst.executeQuery();
            while (rs.next()){

                String admfd = rs.getString("Student_No");
                int amtfd = rs.getInt("Amount_paid");
                String datefd = rs.getString("Date_paid");
                String modefd = rs.getString("Mode_of_payment");
                DefaultTableModel model= (DefaultTableModel)jTable_fees.getModel();
                
                Object[] row = new Object[4];
                row[0]= admfd;
                row[1]=amtfd;
                row[2]=datefd;
                row[3]=modefd;
                model.addRow(row);
                
            }
            if (jTable_fees.getRowCount()<1){
                    hover_fees.setText("No data found");
                }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_fees = new javax.swing.JTable();
        hover_fees = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setText("FINANCIAL DETAILS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 170, -1));

        jButton4.setBackground(new java.awt.Color(51, 255, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 255));
        jButton4.setText("Print report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 710, -1, -1));

        jTable_fees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student number", "Amount paid", "Date paid", "Mode of payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_fees);
        if (jTable_fees.getColumnModel().getColumnCount() > 0) {
            jTable_fees.getColumnModel().getColumn(0).setResizable(false);
            jTable_fees.getColumnModel().getColumn(1).setResizable(false);
            jTable_fees.getColumnModel().getColumn(2).setResizable(false);
            jTable_fees.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 550, 600));

        hover_fees.setEditable(false);
        hover_fees.setBackground(new java.awt.Color(255, 204, 204));
        hover_fees.setBorder(null);
        jPanel1.add(hover_fees, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 190, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Back to home");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1318, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //        dispose();
        MessageFormat header= new MessageFormat(jLabel2.getText());
        MessageFormat footer= new MessageFormat("Page{0,number, integer}");
        dispose();
        try{
            jTable_fees.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s %n", e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new Home().setVisible(true);
        super.dispose();
        
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hover_fees;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_fees;
    // End of variables declaration//GEN-END:variables
}
