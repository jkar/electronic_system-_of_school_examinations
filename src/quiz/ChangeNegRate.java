/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static quiz.TeachLogIn.im;

/**
 *
 * @author anna
 */
public class ChangeNegRate extends javax.swing.JFrame {

    String testname;
    int t_id;
    double rate;
    int attempts;
    static byte[] im = null;
    /**
     * Creates new form ChangeNegRate
     */
    public ChangeNegRate() {
        initComponents();
        
        Role r = new Role();
        r.getBackgroundImage();
        im = r.im;
        ImageIcon image = new ImageIcon(im); 
        Image nim =  image.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(nim);
        jLabel6.setIcon(image);
    }
    public ChangeNegRate(String tn, int id) {
        initComponents();
        testname = tn;
        t_id = id;
        setValueRate();
        jLabel2.setVisible(false);
        jSpinner1.setVisible(false);
        jSpinner1.setValue(rate);
        
        Role r = new Role();
        r.getBackgroundImage();
        im = r.im;
        ImageIcon image = new ImageIcon(im); 
        Image nim =  image.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(nim);
        jLabel6.setIcon(image);
        
        
        setValueAttempt();
        jLabel4.setVisible(false);
        jSpinner2.setVisible(false);
        jSpinner2.setValue(attempts);
        
         ItemHandler handler = new ItemHandler();
        jRadioButton1.addItemListener(handler);
        
        ItemHandler2 handler2 = new ItemHandler2();
        jRadioButton2.addItemListener(handler2);
    }
    
    private class ItemHandler implements ItemListener {
        
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == jRadioButton1) {
                jLabel2.setVisible(true);
                jSpinner1.setVisible(true);
            }
        }
    }
      private class ItemHandler2 implements ItemListener {
        
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == jRadioButton2) {
                jLabel4.setVisible(true);
                jSpinner2.setVisible(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jSpinner1 = new javax.swing.JSpinner();
        exit = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(649, 355));
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Αλλαγή αρνητικής Βαθμολογίας;");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(15, 79, 190, 14);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Αρνητικός βαθμός");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(320, 80, 120, 14);

        jRadioButton1.setText("Ναι");
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(224, 75, 50, 23);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 2.0d, 0.1d));
        getContentPane().add(jSpinner1);
        jSpinner1.setBounds(550, 70, 53, 20);

        exit.setText("Έξοδος");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(20, 280, 80, 23);

        submit.setText("Αποδοχή");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(530, 280, 90, 23);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Αλλαγή επιτρεπόμενων προσπαθειών;");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 130, 220, 14);

        jRadioButton2.setText("Ναι");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(224, 120, 50, 23);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Προσπάθειες");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(330, 130, 120, 14);

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(jSpinner2);
        jSpinner2.setBounds(550, 130, 50, 20);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 860, 0);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 740, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        double r = round((Double)jSpinner1.getValue(),1);
        //rate = (Double) jSpinner1.getValue();
        attempts =(int) jSpinner2.getValue();
        rate = r;
        this.dispose();
        TeacherViewTest tvt = new TeacherViewTest(testname, t_id, rate, attempts);
        tvt.setVisible(true);
        tvt.setResizable(false);
    }//GEN-LAST:event_submitActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        //δεν μηδενιζω τα fields γιατι ειναι non static οποτε μολις δημιουργηθει object με το ιδιο ονομα αυτα ξαναειναι default
        this.dispose();
        Teacher t = new Teacher();
        t.setVisible(true);
        t.setResizable(false);
    }//GEN-LAST:event_exitActionPerformed

    private void setValueRate(){
        
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "select * from test_teacher where testname= '" + testname + "'";
        //anti gia null ebala mia protash giati me null m petaei null exception sto if
        String tname="den uparxei auto to test sigoura";
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
            
            rate = rs.getDouble("neg_rate");
             
            }
                
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    
    private void setValueAttempt(){
        
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "select * from test_teacher where testname= '" + testname + "'";
        //anti gia null ebala mia protash giati me null m petaei null exception sto if
        String tname="den uparxei auto to test sigoura";
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
            
            attempts = rs.getInt("allow_attempts");
             
            }
                
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    
     public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
    
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
            java.util.logging.Logger.getLogger(ChangeNegRate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeNegRate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeNegRate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeNegRate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeNegRate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}