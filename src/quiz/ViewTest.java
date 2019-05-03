/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.Color;
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
public class ViewTest extends javax.swing.JFrame {

    static byte[] img = null;
    static int numofq = 1;
    static int s_id;
    static String testname;
    static int limit;
    
    byte[] ima = null;
    /**
     * Creates new form ViewTest
     */
    public ViewTest() {
        initComponents();
        
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel11.setIcon(image2);
        
        if (numofq == 1) {
            previous.setVisible(false);
        }
        if (numofq == limit) {
            next.setVisible(false);
        }
        
        Connection con = null;
        PreparedStatement ps = null;
        
        String sql = "select * from question2 where No = " + numofq + " and testname = '" + testname + "'";
       
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery(sql);
       
            while(rs.next()){
            String num = Integer.toString(rs.getInt("No"));
            String tarea = rs.getString("texta");
            String rb1 = rs.getString("rbutton1");
            String rb2 =  rs.getString("rbutton2");
            String rb3 =  rs.getString("rbutton3");
            String rb4 =  rs.getString("rbutton4");
            int rightAn = rs.getInt("n_of_ran");
            byte[] im = rs.getBytes("image"); 
            ima = im;
             
             jLabel8.setText(num);
             //jLabel1.setText(tarea);
             //jLabel3.setText(rb1);
             //jLabel4.setText(rb2);
             //jLabel5.setText(rb3);
             //jLabel6.setText(rb4);
              
             jLabel1.setText("<HTML>" + tarea + "</HTML>");
             jLabel3.setText("<HTML>" + rb1 + "</HTML>");
             jLabel4.setText("<HTML>" + rb2 + "</HTML>");
             jLabel5.setText("<HTML>" + rb3 + "</HTML>");
             jLabel6.setText("<HTML>" + rb4 + "</HTML>");
             
               if (rightAn == 1) {
                jLabel3.setForeground(Color.GREEN);
            } else if (rightAn == 2) {
                jLabel4.setForeground(Color.GREEN);
            } else if (rightAn == 3) {
                jLabel5.setForeground(Color.GREEN);
            } else if (rightAn == 4) {
                jLabel6.setForeground(Color.GREEN);
            }
              
                  
             ImageIcon image = new ImageIcon(im); 
             Image nim =  image.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel2.setIcon(image); 
            }    
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        checkNegativeRate();
    }
    
    public ViewTest(int id, String tn) {
        initComponents();
        s_id = id;
        testname = tn;
        
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel11.setIcon(image2);
        
        previous.setVisible(false);
        
        
        Connection con = null;
        PreparedStatement ps = null;
        
        String sql = "select * from question2 where No = " + numofq + " and testname = '" + tn + "'";
       
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery(sql);
            
           
            
            limit = maxNo(testname);
            
           
            while(rs.next()){
            String num = Integer.toString(rs.getInt("No"));
            String tarea = rs.getString("texta");
            String rb1 = rs.getString("rbutton1");
            String rb2 =  rs.getString("rbutton2");
            String rb3 =  rs.getString("rbutton3");
            String rb4 =  rs.getString("rbutton4");
            int rightAn = rs.getInt("n_of_ran");
            byte[] im = rs.getBytes("image"); 
            ima = im;
             
             jLabel8.setText(num);
             //jLabel1.setText(tarea);
             //jLabel3.setText(rb1);
             //jLabel4.setText(rb2);
             //jLabel5.setText(rb3);
             //jLabel6.setText(rb4);
             jLabel1.setText("<HTML>" + tarea + "</HTML>");
             jLabel3.setText("<HTML>" + rb1 + "</HTML>");
             jLabel4.setText("<HTML>" + rb2 + "</HTML>");
             jLabel5.setText("<HTML>" + rb3 + "</HTML>");
             jLabel6.setText("<HTML>" + rb4 + "</HTML>");
             
               if (rightAn == 1) {
                jLabel3.setForeground(Color.GREEN);
            } else if (rightAn == 2) {
                jLabel4.setForeground(Color.GREEN);
            } else if (rightAn == 3) {
                jLabel5.setForeground(Color.GREEN);
            } else if (rightAn == 4) {
                jLabel6.setForeground(Color.GREEN);
            }
                  
             ImageIcon image = new ImageIcon(im); 
             Image nim =  image.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel2.setIcon(image);
              
          
              
             if (limit == 1) {
            
                next.setVisible(false);
             }
            
            }
            
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        checkNegativeRate();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ViewImage = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 690));
        setPreferredSize(new java.awt.Dimension(850, 690));
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(24, 42, 540, 160);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(590, 60, 163, 97);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 260, 760, 60);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 330, 760, 60);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 400, 760, 50);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 460, 760, 50);

        exit.setText("Έξοδος");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(60, 550, 90, 23);

        previous.setText("Προηγούμενη ερώτηση");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });
        getContentPane().add(previous);
        previous.setBounds(260, 550, 180, 23);

        next.setText("Επόμενη ερώτηση");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next);
        next.setBounds(520, 550, 150, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ερώτηση");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 20, 82, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(110, 20, 66, 22);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 580, 680, 14);

        ViewImage.setText("Προβολή εικόνας");
        ViewImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewImageActionPerformed(evt);
            }
        });
        getContentPane().add(ViewImage);
        ViewImage.setBounds(610, 180, 130, 23);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 840, 0);

        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 880, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        numofq = 1;
        testname = null;
        limit = 0;
        this.dispose();
        TeacherChoice tc = new TeacherChoice();
        tc.setVisible(true);
        tc.setResizable(false);
    }//GEN-LAST:event_exitActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        // TODO add your handling code here:
        numofq--;
        this.dispose();
        ViewTest vt = new ViewTest();
        vt.setVisible(true);
        vt.setResizable(false);
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        numofq++;
        this.dispose();
        ViewTest vt = new ViewTest();
        vt.setVisible(true);
        vt.setResizable(false);
    }//GEN-LAST:event_nextActionPerformed

    private void ViewImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewImageActionPerformed
        // TODO add your handling code here:
        ViewImage vi = new ViewImage(ima);
        vi.setVisible(true);
        vi.setResizable(false);
    }//GEN-LAST:event_ViewImageActionPerformed

    public int maxNo(String tn){
        
        int n = 0;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "select No from question2 where testname= '" + tn + "'";
        
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
            String num = Integer.toString(rs.getInt("No"));
            int no = rs.getInt("NO");
            
             n++;
            }
                
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        return n;
         
    }
    
    private void checkNegativeRate() {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "select neg_rate from test_teacher where testname= '" + testname + "'";
        double rate = 0.0;
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
                double r = rs.getDouble("neg_rate");
                rate = r;
            }
                
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        if (rate > 0) {
            jLabel9.setText("*Για κάθε λάθος ερώτηση, αφαιρούνται " + rate + " μονάδες");
        } else {
            jLabel9.setVisible(false);
        }
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
            java.util.logging.Logger.getLogger(ViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewImage;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton next;
    private javax.swing.JButton previous;
    // End of variables declaration//GEN-END:variables
}
