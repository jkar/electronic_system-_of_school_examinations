/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.Image;
import javax.swing.ImageIcon;
import static quiz.CreateTest.list;


/**
 *
 * @author anna
 */
public class Teacher extends javax.swing.JFrame {

    //το περναω σαν static ετσι ωστε αν προχωρησω σ αλλα frame κ ξαναγυρισω το νεο object-frame θα χει το ιδιο t_id
    static int t_id;
    static byte[] im = null;
    /**
     * Creates new form Teacher
     */
    public Teacher(int id) {
        initComponents();
        t_id = id;
        
        Role r = new Role();
        r.getBackgroundImage();
        im = r.im;
        ImageIcon image = new ImageIcon(im); 
        Image nim =  image.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(nim);
        jLabel3.setIcon(image);
       
    }
      public Teacher() {
        initComponents();
        
        Role r = new Role();
        r.getBackgroundImage();
        im = r.im;
        ImageIcon image = new ImageIcon(im); 
        Image nim =  image.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(nim);
        jLabel3.setIcon(image);
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
        createTest = new javax.swing.JButton();
        viewEdit = new javax.swing.JButton();
        viewSolvedTests = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(534, 373));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Μενού");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 60, 57, 22);

        createTest.setText("Δημιουργία Τεστ");
        createTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTestActionPerformed(evt);
            }
        });
        getContentPane().add(createTest);
        createTest.setBounds(150, 130, 220, 23);

        viewEdit.setText("Επεξεργασία / Προβολή Τεστ");
        viewEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEditActionPerformed(evt);
            }
        });
        getContentPane().add(viewEdit);
        viewEdit.setBounds(150, 160, 220, 23);

        viewSolvedTests.setText("Προβολή Απαντημένων Τεστ");
        viewSolvedTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSolvedTestsActionPerformed(evt);
            }
        });
        getContentPane().add(viewSolvedTests);
        viewSolvedTests.setBounds(150, 190, 220, 23);

        back.setText("Πίσω");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(20, 270, 70, 23);

        jLabel2.setMaximumSize(new java.awt.Dimension(1900, 1200));
        jLabel2.setMinimumSize(new java.awt.Dimension(1900, 1200));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 0, 0);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 660, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTestActionPerformed
        // TODO add your handling code here:
        this.dispose();
        NameTest nt = new NameTest(t_id);
        nt.setVisible(true);
        nt.setResizable(false);
        
    }//GEN-LAST:event_createTestActionPerformed

    private void viewEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEditActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        TeacherChoice tc = new TeacherChoice(t_id);
        tc.setVisible(true);
        tc.setResizable(false);
    }//GEN-LAST:event_viewEditActionPerformed

    private void viewSolvedTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSolvedTestsActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewSolvedTests vst = new ViewSolvedTests(t_id);
        vst.setVisible(true);
        vst.setResizable(false);
    }//GEN-LAST:event_viewSolvedTestsActionPerformed

    //μηδενιζω το t_id για να κανει νεο log in ,(αν και δεν χρειαζεται..γιατι θα παρει το επομενο id που θα κανει log in)
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        t_id = 0;
        this.dispose();
        TeachLogIn tli = new TeachLogIn();
        tli.setVisible(true);
        tli.setResizable(false);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton createTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton viewEdit;
    private javax.swing.JButton viewSolvedTests;
    // End of variables declaration//GEN-END:variables
}