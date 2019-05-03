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
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static quiz.ShowQuestion.testname;

/**
 *
 * @author anna
 */
public class DeleteQuestion extends javax.swing.JFrame {

    static byte[] img = null;
    static int numofq = 1;
    static String testname = null;
    
    static int counter = 0;
    static int limit = 0;
    /**
     * Creates new form DeleteQuestion
     */
    public DeleteQuestion() {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel10.setIcon(image2);
        
         if (numofq<2) {
           Previous.setVisible(false);
        }
         if( counter == limit-1) {
             Next.setVisible(false);
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
            //String cn = Integer.toString(rs.getInt("n_of_ran"));
            int rightAn = rs.getInt("n_of_ran");
            byte[] im = rs.getBytes("image"); 
             
             jLabel2.setText(num);
             //jLabel9.setText(tarea);
             //jLabel3.setText(rb1);
             //jLabel4.setText(rb2);
             //jLabel5.setText(rb3);
             //jLabel6.setText(rb4);
             //jLabel7.setText(cn);
             jLabel9.setText("<HTML>" + tarea + "</HTML>");
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
             Image nim =  image.getImage().getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel8.setIcon(image);
              
        
              
             numofq++;
             counter++;
            }  
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
    }
    
    public DeleteQuestion(String s) {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel10.setIcon(image2);
        
         if (numofq<2) {
           Previous.setVisible(false);
        }
         
        
        testname = s;
        Connection con = null;
        PreparedStatement ps = null;
        
        String sql = "select * from question2 where No = " + numofq + " and testname = '" + s + "'";
        
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            ShowQuestion sq = new ShowQuestion();
            limit = sq.maxNo(testname);
            
            while(rs.next()){
            String num = Integer.toString(rs.getInt("No"));
            String tarea = rs.getString("texta");
            String rb1 = rs.getString("rbutton1");
            String rb2 =  rs.getString("rbutton2");
            String rb3 =  rs.getString("rbutton3");
            String rb4 =  rs.getString("rbutton4");
            //String cn = Integer.toString(rs.getInt("n_of_ran"));
            int rightAn = rs.getInt("n_of_ran");
            byte[] im = rs.getBytes("image"); 
             
             jLabel2.setText(num);
             //jLabel9.setText(tarea);
             //jLabel3.setText(rb1);
             //jLabel4.setText(rb2);
             //jLabel5.setText(rb3);
             //jLabel6.setText(rb4);
             //jLabel7.setText(cn);
             jLabel9.setText("<HTML>" + tarea + "</HTML>");
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
             Image nim =  image.getImage().getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel8.setIcon(image);
              
        
              
             numofq++;
             counter++;
            }  
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        if (limit == 1) {
            Next.setVisible(false);
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        Previous = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 560));
        setPreferredSize(new java.awt.Dimension(800, 460));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ερώτηση");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 82, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 20, 66, 22);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(31, 257, 690, 50);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(31, 309, 690, 50);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(31, 361, 690, 60);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(31, 423, 690, 50);

        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(570, 70, 160, 100);

        Delete.setText("Διαγραφή");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        getContentPane().add(Delete);
        Delete.setBounds(530, 500, 110, 23);

        Previous.setText("Προηγούμενη ερώτηση");
        Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousActionPerformed(evt);
            }
        });
        getContentPane().add(Previous);
        Previous.setBounds(170, 500, 180, 23);

        Next.setText("Επόμενη ερώτηση");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        getContentPane().add(Next);
        Next.setBounds(370, 500, 140, 23);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 64, 540, 140);

        exit.setText("Έξοδος");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(50, 500, 90, 23);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 930, 0);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 780, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
       this.dispose();
        DeleteQuestion dq = new DeleteQuestion();
        dq.setVisible(true);
        dq.setResizable(false);
        
    }//GEN-LAST:event_NextActionPerformed

    private void PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousActionPerformed
        // TODO add your handling code here:
        numofq -=2;
        counter -=2;
        this.dispose();
        DeleteQuestion dq = new DeleteQuestion();
        dq.setVisible(true);
        dq.setResizable(false);
    }//GEN-LAST:event_PreviousActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        
        String sql = "DELETE FROM question2 WHERE testname='"+testname+"' AND No= '"+counter+"'";
        String sql2 = "update question2 set No = ? where testname = ? and No = ?";
        String sql3 = "select * from question2 where testname='"+testname+"'";
        String sql4 = "DELETE FROM test_teacher WHERE testname='"+testname+"'";
        
       Connection con = null;
        Statement st = null;
        
        
         try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Η ερώτηση διαγράφηκε");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Η ερώτηση ΔΕΝ διαγράφηκε");
        }
       
         for (int i = counter; i <= limit; i++ ) {
         try{
        PreparedStatement ps = con.prepareStatement(sql2);
         
            ps.setInt(1, i);
            ps.setString(2, testname);
            ps.setInt(3, i+1); 
            ps.executeUpdate();
            ps.close();
             //JOptionPane.showMessageDialog(null, "Τα δεδομένα ανανεώθηκαν");
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
         }
         
         try {
            st = con.prepareStatement(sql3);
            ResultSet rs = st.executeQuery(sql3);
           
            //chekarw an uparxei row m auta ta stoixeia sthn if
            if (rs.isBeforeFirst()) {
                 st.close();
                this.dispose();
                
                } else {
                st = con.createStatement();
                st.executeUpdate(sql4);
                st.close();
            }
            }
          catch (Exception e) {
              e.printStackTrace();
         }
         this.dispose();
         TeacherChoice tc = new TeacherChoice();
         tc.setVisible(true);
         tc.setResizable(false);
    }//GEN-LAST:event_DeleteActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        numofq = 1;
        testname = null;
        counter = 0;
        limit = 0;
        TeacherChoice tc = new TeacherChoice();
        tc.setVisible(true);
        tc.setResizable(false);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Next;
    private javax.swing.JButton Previous;
    private javax.swing.JButton exit;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
