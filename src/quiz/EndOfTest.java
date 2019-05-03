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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static quiz.ViewTest.img;


/**
 *
 * @author anna
 */
public class EndOfTest extends javax.swing.JFrame {

    static byte[] img = null;
    int s_id;
    String testname;
    int givenAns = 0;
    int rightAnswers = 0;
    int numOfAtmps;
    double totalRate;
    /**
     * Creates new form EndOfTest
     */
    
    private ArrayList<Integer> dbList = new ArrayList<Integer>();
    
    public EndOfTest() {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel6.setIcon(image2);
    }
     public EndOfTest(String tn, int id) {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel6.setIcon(image2);
        
        testname = tn;
        s_id = id;
        
    }
    
    public void checkAnswers (int[] l) {
        
        
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "select n_of_ran from question2 where testname= '" + testname + "'";
        
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
            
            dbList.add(rs.getInt("n_of_ran"));
            
             
            }
                
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        
     
        
        for (int i = 0; i<dbList.size(); i++) {
            if (dbList.get(i) == l[i]) {
                rightAnswers++;
            }
            jLabel3.setText("Βρήκες " + rightAnswers + " σωστές από τις " + dbList.size());
        }
        
        
        
    }
    
    public void getGivenAns(int[] a, int lim) {
        
        for (int i = 0; i < lim; i++) {
            givenAns = givenAns + a[i];
        }
        jLabel2.setText("Οι απαντημένες ερωτήσεις είναι " + givenAns);
    }
    
    public void insertResults (int lim) {
        
        numOfAtmps =  maxNo2(testname) + 1;
        
          Connection con = null;
                Statement st = null;
                String sql1 = "insert into test_student (id_student,testname,attempt_no,given_answers,right_answers,no_of_questions,rate) values('"+s_id+"','"+testname+"','"+numOfAtmps+"','"+givenAns+"','"+rightAnswers+"','"+lim+"','"+totalRate+"')";
                
                try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.createStatement();
            st.executeUpdate(sql1);
            //JOptionPane.showMessageDialog(null, "Τα δεδομένα κατοχυρώθηκαν");
            this.dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Τα δεδομένα ΔΕΝ κατοχυρώθηκαν");
                 } 
    }
    
    public void insertQuestionStudent(int lim, int[] ar) {
        
         Connection con = null;
         Statement st = null;
                
                
                try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            for (int i = 0; i < lim; i++) {
                int q = i+1;
                String sql1 = "insert into student_question (id_student,testname,attempt_no,no_q,right_an,given_an) values('"+s_id+"','"+testname+"','"+numOfAtmps+"','"+q+"','"+dbList.get(i)+"','"+ar[i]+"')";
            st = con.createStatement();
            st.executeUpdate(sql1);
            //JOptionPane.showMessageDialog(null, "Τα δεδομένα κατοχυρώθηκαν");
            }
            this.dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Τα δεδομένα ΔΕΝ κατοχυρώθηκαν");
                 }
    }
    
     public int maxNo2(String tn){
        
        int n = 0;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "select attempt_no from test_student where id_student = '" + s_id + "' and testname= '" + tn + "'";
        
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
            String num = Integer.toString(rs.getInt("attempt_no"));
            //int no = rs.getInt("NO");
            
             n++;
            }
                
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        return n;
         
    }
     public void totalRate(int limit) {
         
        Double r = 0.0;
         
         Connection con = null;
        PreparedStatement ps = null;
        String sql = "select neg_rate from test_teacher where testname= '" + testname + "'";
        
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
            r = rs.getDouble("neg_rate");
            }
                
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        //swstes apanthseis dia oles tis apantheis epi to 10 gia na bgei o bathmos
        totalRate = (double) rightAnswers * 10 / limit;
        //briskw tis lathos apanthseis k tis poll/zw me ton suntelesth auto afaireitai meta apto total
        double ra = (double) rightAnswers;
        double ga = (double) givenAns;
        double afairesh = (double) (ga-ra)*r;
        //o telikos bathmos 
        totalRate = totalRate - afairesh;
        totalRate = round(totalRate,2);
        jLabel4.setText("ο βαθμός σου είναι " + totalRate);
     }
     
       public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 350));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Τέλος του Τεστ!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(95, 97, 240, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(138, 176, 240, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(138, 209, 240, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 240, 240, 14);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 640, 0);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 620, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EndOfTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EndOfTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EndOfTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EndOfTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EndOfTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
