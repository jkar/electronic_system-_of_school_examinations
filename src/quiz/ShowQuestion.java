/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author anna
 */
public class ShowQuestion extends javax.swing.JFrame {

    /**
     * Creates new form ShowQuestion
     */
    static int numofq = 1;
    static String testname = null;
    
    static int counter = 0;
    static int limit = 0;
    static ArrayList<Integer> list2 = new ArrayList<Integer>();
    
    public ShowQuestion(){
        initComponents();
        jRadioButton1.setSelected(true);
         if (numofq<2) {
           jButton2.setVisible(false);
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
             
             jLabel2.setText(num);
             jLabel3.setText(tarea);
             jRadioButton1.setText(rb1);
             jRadioButton2.setText(rb2);
             jRadioButton3.setText(rb3);
             jRadioButton4.setText(rb4);
             
             if (im != null) {
                  
             ImageIcon image = new ImageIcon(im); 
             Image nim =  image.getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel4.setIcon(image);
              
              } else {
             jLabel4.setVisible(false);
              }
             
             
             numofq++;
             counter++;
                     
             
             for (int i = 0; i<list2.size(); i++) {
                 System.out.print(list2.get(i));
             }
             System.out.println("");
             
            }
            
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        
    }
    
    public ShowQuestion(String s) {
        initComponents();
        jRadioButton1.setSelected(true);
        
        if (numofq<2) {
           jButton2.setVisible(false);
        }
        
        testname = s;
        Connection con = null;
        PreparedStatement ps = null;
        
        String sql = "select * from question2 where No = " + numofq + " and testname = '" + s + "'";
        //String sql = "select * from question2 where testname = 'test1'";
        //String n = Integer.toString(numofq);
        
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            //ps.setString(1, s);
            //ps.setInt(2, numofq);
            //ps.setString(2, n);
            ResultSet rs = ps.executeQuery(sql);
            
            limit = maxNo(testname);
            
            while(rs.next()){
            String num = Integer.toString(rs.getInt("No"));
            String tarea = rs.getString("texta");
            String rb1 = rs.getString("rbutton1");
            String rb2 =  rs.getString("rbutton2");
            String rb3 =  rs.getString("rbutton3");
            String rb4 =  rs.getString("rbutton4");
            
            byte[] im = rs.getBytes("image"); 
             
             jLabel2.setText(num);
             jLabel3.setText(tarea);
             jRadioButton1.setText(rb1);
             jRadioButton2.setText(rb2);
             jRadioButton3.setText(rb3);
             jRadioButton4.setText(rb4);
             
              if (im != null) {
                  
             ImageIcon image = new ImageIcon(im); 
             Image nim =  image.getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel4.setIcon(image);
              
              } else {
             jLabel4.setVisible(false);
              }
              
             numofq++;
             counter++;
             
            for (int i = 0; i<list2.size(); i++) {
                 System.out.print(list2.get(i));
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Ερώτηση");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jButton1.setText("Επόμενη ερώτηση");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Προηγούμενη ερώτηση");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton1)))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        if (counter < limit) {
            getRadioButton();
            this.dispose();
        ShowQuestion sq = new ShowQuestion();
        sq.setVisible(true);
        sq.setResizable(false);
        } else {
            getRadioButton();
            this.dispose();
           EndOfTest end = new EndOfTest();
           //end.checkAnswers(list2);
           end.setVisible(true);
           end.setResizable(false);
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        numofq -=2;
        counter -=2;
        list2.remove(list2.size()-1);
        this.dispose();
        ShowQuestion sq = new ShowQuestion();
        sq.setVisible(true);
        sq.setResizable(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void getRadioButton() {
        
           if (jRadioButton1.isSelected()) {
        //System.out.println(1);
        list2.add(1);
    } else if (jRadioButton2.isSelected()) {
        //System.out.println(2);
        list2.add(2);
    } else if (jRadioButton3.isSelected()) {
        //System.out.println(3);
        list2.add(3);
    } else if (jRadioButton4.isSelected()) {
        //System.out.println(4);
        list2.add(4);
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
            java.util.logging.Logger.getLogger(ShowQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
