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
public class StudentViewTest extends javax.swing.JFrame {

    static byte[] img = null;
    static int s_id;
    static String testname;
    static int attempt;
    
    static int numofq = 1;
    static int limit;
    
    static String role;
    
    byte[] ima = null;
    /**
     * Creates new form StudentViewTest
     */
    public StudentViewTest() {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel16.getWidth(), jLabel16.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel16.setIcon(image2);
        
        jLabel13.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel15.setVisible(false);
        
        if (numofq<2) {
           previous.setVisible(false);
        }
        if(numofq == limit) {
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
            
            byte[] im = rs.getBytes("image"); 
            ima = im;
             
             jLabel2.setText(num); 
            jLabel3.setText("<HTML>" + tarea + "</HTML>");
            jLabel5.setText("<HTML>" + rb1 + "</HTML>");
            jLabel6.setText("<HTML>" + rb2 + "</HTML>");
            jLabel7.setText("<HTML>" + rb3 + "</HTML>");
            jLabel8.setText("<HTML>" + rb4 + "</HTML>");
                  
             ImageIcon image = new ImageIcon(im); 
             Image nim =  image.getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel4.setIcon(image);
           
            }
             
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        setRightAnswer();
    }
    
    public StudentViewTest(int id, String tn, int at, String role) {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel16.getWidth(), jLabel16.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel16.setIcon(image2);
        
        jLabel13.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel15.setVisible(false);
        
        this.role = role;
        s_id = id;
        testname = tn;
        attempt = at;
        
        if (numofq<2) {
           previous.setVisible(false);
        }
        
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
            
            if (!rs.isBeforeFirst()) {
                jLabel13.setVisible(true);
                
                jLabel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jLabel5.setVisible(false);
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jLabel8.setVisible(false);
                jLabel9.setVisible(false);
                jLabel10.setVisible(false);
                jLabel11.setVisible(false);
                jLabel12.setVisible(false);
                next.setVisible(false);
            }
           
            while(rs.next()){
            String num = Integer.toString(rs.getInt("No"));
            String tarea = rs.getString("texta");
            String rb1 = rs.getString("rbutton1");
            String rb2 =  rs.getString("rbutton2");
            String rb3 =  rs.getString("rbutton3");
            String rb4 =  rs.getString("rbutton4");
            
            byte[] im = rs.getBytes("image"); 
            ima = im;
             
            jLabel2.setText(num);
            jLabel3.setText("<HTML>" + tarea + "</HTML>");
            jLabel5.setText("<HTML>" + rb1 + "</HTML>");
            jLabel6.setText("<HTML>" + rb2 + "</HTML>");
            jLabel7.setText("<HTML>" + rb3 + "</HTML>");
            jLabel8.setText("<HTML>" + rb4 + "</HTML>");;
             
              
                  
             ImageIcon image = new ImageIcon(im); 
             Image nim =  image.getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel4.setIcon(image);
              
             if (limit == 1) {
            
            next.setVisible(false);
        }
            
            }
            
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        setRightAnswer();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ViewImage = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 600));
        setPreferredSize(new java.awt.Dimension(820, 540));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ερώτηση");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 90, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 20, 66, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(13, 41, 770, 110);

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(117, 157, 155, 82);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(108, 263, 690, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(108, 312, 690, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(108, 360, 690, 60);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(108, 426, 690, 50);

        exit.setText("Έξοδος");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(60, 510, 90, 23);

        previous.setText("Προηγούμενη ερώτηση");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });
        getContentPane().add(previous);
        previous.setBounds(240, 510, 180, 23);

        next.setText("Επόμενη ερώτηση");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next);
        next.setBounds(500, 510, 140, 23);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Η απάντησή σου");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 263, 100, 50);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Η απάντησή σου");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 312, 100, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Η απάντησή σου");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 360, 100, 60);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Η απάντησή σου");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 430, 100, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Το τεστ έχει διαγραφεί");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(282, 206, 240, 22);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Δεν δόθηκε απάντηση");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 480, 170, 14);

        ViewImage.setText("Προβολή εικόνας");
        ViewImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewImageActionPerformed(evt);
            }
        });
        getContentPane().add(ViewImage);
        ViewImage.setBounds(334, 172, 160, 23);

        jLabel16.setMaximumSize(new java.awt.Dimension(1900, 1200));
        jLabel16.setMinimumSize(new java.awt.Dimension(1900, 1200));
        jLabel16.setPreferredSize(new java.awt.Dimension(1900, 700));
        getContentPane().add(jLabel16);
        jLabel16.setBounds(0, 0, 1900, 700);

        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 0, 930, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        testname = null;
        attempt = 0;
        numofq = 1;
        this.dispose();
        if (role.equals("student")) {
        Student s = new Student();
        s.setVisible(true);
        } else if (role.equals("teacher")) {
            ViewSolvedTests vst = new ViewSolvedTests();
            vst.setVisible(true);
            vst.setResizable(false);
        }     
    }//GEN-LAST:event_exitActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        // TODO add your handling code here:
        numofq--;
        this.dispose();
        StudentViewTest svt = new StudentViewTest();
        svt.setVisible(true);
        svt.setResizable(false);
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        numofq++;
        this.dispose();
        StudentViewTest svt = new StudentViewTest();
        svt.setVisible(true);
        svt.setResizable(false);
    }//GEN-LAST:event_nextActionPerformed

    private void ViewImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewImageActionPerformed
        // TODO add your handling code here:
        ViewImage vi = new ViewImage(ima);
        vi.setVisible(true);
        vi.setResizable(false);
    }//GEN-LAST:event_ViewImageActionPerformed

    public void setRightAnswer(){
        Connection con = null;
        PreparedStatement ps = null;
        
        String sql = "select * from student_question where id_student = " + s_id + " and testname = '" + testname + "' and attempt_no = " + attempt + " and no_q = " + numofq + "";
       
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
           
            ResultSet rs = ps.executeQuery(sql);
            
            if (!rs.isBeforeFirst()) {
                
                
                jLabel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jLabel5.setVisible(false);
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jLabel8.setVisible(false);
                jLabel9.setVisible(false);
                jLabel10.setVisible(false);
                jLabel11.setVisible(false);
                jLabel12.setVisible(false);
                next.setVisible(false);
            }
            
            while(rs.next()){
                
            int rightAn = rs.getInt("right_an");
            int givenAn = rs.getInt("given_an");
           
             
            if (rightAn == 1) {
                jLabel5.setForeground(Color.GREEN);
            } else if (rightAn == 2) {
                jLabel6.setForeground(Color.GREEN);
            } else if (rightAn == 3) {
                jLabel7.setForeground(Color.GREEN);
            } else if (rightAn == 4) {
                jLabel8.setForeground(Color.GREEN);
            }
            
            if(givenAn == 1) {
                jLabel9.setVisible(true);
            } else if (givenAn == 2) {
                jLabel10.setVisible(true);
            } else if (givenAn == 3) {
                jLabel11.setVisible(true);
            } else if (givenAn == 4) {
                jLabel12.setVisible(true);
            } else {
                jLabel15.setVisible(true);
                        }   
            }
             
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    
    
    
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
            java.util.logging.Logger.getLogger(StudentViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentViewTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewImage;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
