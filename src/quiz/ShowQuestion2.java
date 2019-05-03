/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author anna
 */

    
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;





public class ShowQuestion2 extends javax.swing.JFrame {

    static byte[] img = null;
    static int numofq = 1;
    static String testname = null;
    static int s_id;
    
    
    static int counter = 0;
    static int limit = 0;
    static int[] array;
    static int[] array2;
    
    byte[] ima = null;
    
    /**
     * Creates new form ShowQuestion2
     */
    public ShowQuestion2() {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel7.setIcon(image2);
        
        //jRadioButton1.setSelected(true);
        submit.setVisible(false);
         if (numofq<2) {
           back.setVisible(false);
         }
         if (counter == limit-1) {
             next.setVisible(false);
             submit.setVisible(true);
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
            String rb3 = rs.getString("rbutton3");
            String rb4 = rs.getString("rbutton4");
            byte[] im = rs.getBytes("image"); 
            ima = im;
            
             jLabel2.setText(num);
             //jLabel4.setText(tarea);
             //jRadioButton1.setText(rb1);
             //jRadioButton2.setText(rb2);
             jLabel4.setText("<HTML>" + tarea + "</HTML>");
             jRadioButton1.setText("<HTML>" + rb1 + "</HTML>");
             jRadioButton2.setText("<HTML>" + rb2 + "</HTML>");
             
             if (rb3.isEmpty()) {
                 jRadioButton3.setVisible(false);
             } else {
             jRadioButton3.setText("<HTML>" + rb3 + "</HTML>");
             }
             if (rb4.isEmpty()) {
                jRadioButton4.setVisible(false); 
             } else {
             jRadioButton4.setText("<HTML>" + rb4 + "</HTML>");
            }
             
             if (im != null) {
                  
             ImageIcon image = new ImageIcon(im); 
             Image nim =  image.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel3.setIcon(image);
              
              } else {
             jLabel3.setVisible(false);
              }
             
             
             //numofq++;
             //counter++;
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        
        checkNegativeRate();
        
    }
     public ShowQuestion2(String tn, int id) {
         testname = tn;
         s_id = id;
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel7.setIcon(image2);
        
        submit.setVisible(false);
        if (numofq<2) {
           back.setVisible(false);
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
            array = new int[limit];
            array2 = new int[limit];
           
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
             //jLabel4.setText(tarea);
             //jRadioButton1.setText(rb1);
             //jRadioButton2.setText(rb2);
             jLabel4.setText("<HTML>" + tarea + "</HTML>");
             jRadioButton1.setText("<HTML>" + rb1 + "</HTML>");
             jRadioButton2.setText("<HTML>" + rb2 + "</HTML>");
             
              if (rb3.isEmpty()) {
                 jRadioButton3.setVisible(false);
             } else {
             jRadioButton3.setText("<HTML>" + rb3 + "</HTML>");
              }
               if (rb4.isEmpty()) {
                 jRadioButton4.setVisible(false);
             } else {
             jRadioButton4.setText("<HTML>" + rb4 + "</HTML>");
               }
              if (im != null) {
                  
             ImageIcon image = new ImageIcon(im); 
             Image nim =  image.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel3.setIcon(image);
              
              } else {
             jLabel3.setVisible(false);
              }
              
             if (limit == 1) {
            submit.setVisible(true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        back = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ViewImage = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(760, 600));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ερώτηση");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(74, 19, 82, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(283, 19, 66, 22);

        jLabel3.setText("icon");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(563, 40, 130, 100);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(10, 240, 720, 60);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(10, 310, 720, 60);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(10, 383, 720, 50);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(10, 443, 720, 50);

        back.setText("Προηγούμενη ερώτηση");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(110, 500, 170, 23);

        next.setText("Επόμενη ερώτηση");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next);
        next.setBounds(310, 500, 180, 23);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(21, 65, 520, 110);

        submit.setText("Αποδοχή");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(550, 500, 140, 23);

        exit.setText("Έξοδος");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(10, 500, 80, 23);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 530, 710, 14);

        ViewImage.setText("Προβολή εικόνας");
        ViewImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewImageActionPerformed(evt);
            }
        });
        getContentPane().add(ViewImage);
        ViewImage.setBounds(560, 150, 140, 23);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 960, 0);

        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 850, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        getRadioButton();
        numofq--;
        counter--;
        this.dispose();
        ShowQuestion2 sq = new ShowQuestion2();
        sq.setRadioButton(numofq-1);
        sq.setVisible(true);
        sq.setResizable(false);
    }//GEN-LAST:event_backActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        
              getRadioButton();
              counter++;
        if (counter < limit) {
       if(((array[numofq]) == 1) || ((array[numofq]) == 2) || ((array[numofq]) == 3) || ((array[numofq]) == 4)) { 
           
           this.dispose();
           numofq++;
        ShowQuestion2 sq = new ShowQuestion2();
        sq.setVisible(true);
        sq.setRadioButton(numofq-1);
        sq.setResizable(false);
       } else {
           numofq++;
           this.dispose();
           ShowQuestion2 sq = new ShowQuestion2();
            sq.setVisible(true);
            sq.setResizable(false);
       }
       } else {
            EndOfTest end = new EndOfTest(testname, s_id);
            end.checkAnswers(array);
            end.setVisible(true);
            end.setResizable(false);
       } 

        
        
    }//GEN-LAST:event_nextActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        getRadioButton();
              
        ShowQuestion2 sq2 = this;
        EndConfirmation ec = new EndConfirmation(testname, array,array2, limit, s_id, sq2);
        ec.setVisible(true);
        ec.setResizable(false); 
            
    }//GEN-LAST:event_submitActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        numofq = 1;
        testname = null;
        counter = 0;
        limit = 0;
        array = null;
        array2 = null;
        this.dispose();
        Student s = new Student();
        s.setVisible(true);
        s.setResizable(false);
    }//GEN-LAST:event_exitActionPerformed

    private void ViewImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewImageActionPerformed
        // TODO add your handling code here
        ViewImage vi = new ViewImage(ima);
        vi.setVisible(true);
        vi.setResizable(false);
    }//GEN-LAST:event_ViewImageActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

     private void getRadioButton() {
        
         
         
      if (jRadioButton1.isSelected()) {
        //System.out.println(1);
        array[numofq-1] = 1;
        array2[numofq-1] = 1;
    } else if (jRadioButton2.isSelected()) {
        //System.out.println(2);
        array[numofq-1] = 2;
        array2[numofq-1] = 1;
    } else if (jRadioButton3.isSelected()) {
        //System.out.println(3);
        array[numofq-1] = 3;
        array2[numofq-1] = 1;
    } else if (jRadioButton4.isSelected()) {
        //System.out.println(4);
        array[numofq-1] = 4;
        array2[numofq-1] = 1;
    } else {
        array[numofq-1] = 0;
        array2[numofq-1] = 0;
    }
    }
     
      private void setRadioButton(int n) {
        
   if (array[n] == 1) {
       jRadioButton1.setSelected(true);
   }
    if (array[n] == 2) {
       jRadioButton2.setSelected(true);
   }
     if (array[n] == 3) {
       jRadioButton3.setSelected(true);
   }
      if (array[n] == 4) {
       jRadioButton4.setSelected(true);
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
            jLabel5.setText("*Για κάθε λάθος ερώτηση, αφαιρούνται " + rate + " μονάδες");
        } else {
            jLabel5.setVisible(false);
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
            java.util.logging.Logger.getLogger(ShowQuestion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowQuestion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowQuestion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowQuestion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowQuestion2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewImage;
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton next;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
