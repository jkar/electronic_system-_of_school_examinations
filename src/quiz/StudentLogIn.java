/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author anna
 */
public class StudentLogIn extends javax.swing.JFrame {

    static byte[] im = null;
    String username;
    String password;
    int s_id;
    /**
     * Creates new form StudentLogIn
     */
    public StudentLogIn() {
        initComponents();
        
        Role r = new Role();
        r.getBackgroundImage();
        im = r.im;
        ImageIcon image = new ImageIcon(im); 
        Image nim =  image.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(nim);
        jLabel5.setIcon(image);
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
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        log = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Log in");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(153, 27, 54, 22);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 78, 60, 14);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 116, 60, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(76, 75, 214, 20);

        back.setText("Πίσω");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(74, 199, 80, 23);

        log.setText("Αποδοχή");
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });
        getContentPane().add(log);
        log.setBounds(215, 199, 100, 23);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(74, 113, 216, 20);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 920, 0);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 520, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // πηγαινω στο πισω frame κλεινοντας πρωτα αυτο
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Role r = new Role();
        r.setVisible(true);
        r.setResizable(false);
    }//GEN-LAST:event_backActionPerformed

    //παιρνει τα στοιχεια(username,password) απο τα fields κ τα ελεγχει αν υπαρχουν τα αντιστοιχα στο table student
    //τραβαω συγχρονως κ το id k το περναω σ ολα τα επομενα frame για να χω συνεχεια τα στοιχεια του μαθητη π εκανε log in
    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        // TODO add your handling code here:
        username = jTextField1.getText().toString();
        //password = jTextField2.getText().toString();
        password = jPasswordField1.getText().toString();
        
        if (jTextField1.getText().isEmpty() || jPasswordField1.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Υπάρχουν κενά πεδία, συμπλήρωσε όλα τα πεδία");
        } else {
              Connection con = null;
                PreparedStatement st = null;
                String sql1 = "select * from student where username = '" + username + "' and password = '" + password + "'";
                
                try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.prepareStatement(sql1);
            ResultSet rs = st.executeQuery(sql1);
            //chekarw an uparxei row m auta ta stoixeia sthn if
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                s_id = rs.getInt("id_student");
                
                }
                 this.dispose();
                Student s = new Student(s_id);
                s.setVisible(true);
                s.setResizable(false);
            } else {
                JOptionPane.showMessageDialog(null, "Το Username ή το Password είναι λάθος");
            }
            
            
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει σύνδεση με τη βάση");
                 }
        }
        
    }//GEN-LAST:event_logActionPerformed

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
            java.util.logging.Logger.getLogger(StudentLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton log;
    // End of variables declaration//GEN-END:variables
}
