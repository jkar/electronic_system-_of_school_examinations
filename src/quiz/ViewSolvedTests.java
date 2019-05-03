/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;




/**
 *
 * @author anna
 */
public class ViewSolvedTests extends javax.swing.JFrame {

    static int t_id;
    String testname;
     static byte[] im = null;
    
    int AM;
    int s_id;
    /**
     * Creates new form ViewSolvedTests
     */
    public ViewSolvedTests() {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        im = r.im;
        ImageIcon image = new ImageIcon(im); 
        Image nim =  image.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(nim);
        jLabel5.setIcon(image);
        
        fillCombo();
        ItemHandler handler = new ItemHandler();
        jComboBox1.addItemListener(handler);
        
        jTextField1.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             setAM();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             setAM();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             setAM();
            }
            
            public void setAM() {
                if (jTextField1.getText().isEmpty()){
                    AM = 0;
                } else {
                AM = Integer.parseInt(jTextField1.getText());
                
                }
                findTid();
                fillCombo3();
            }
            
        });
    }
    
    public ViewSolvedTests(int id) {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        im = r.im;
        ImageIcon image = new ImageIcon(im); 
        Image nim =  image.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(nim);
        jLabel5.setIcon(image);
        
        t_id = id;
        fillCombo();
        ItemHandler handler = new ItemHandler();
        jComboBox1.addItemListener(handler);
        
        //jTextField1.addActionListener(new ActionListener(){
          //  public void actionPerformed(ActionEvent arg) {
          //      AM = Integer.parseInt(arg.toString());
          //      System.out.print("the am" + AM);
          //  }
       // });
        jTextField1.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             setAM();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             setAM();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             setAM();
            }
            
            public void setAM() {
                if (jTextField1.getText().isEmpty()){
                    AM = 0;
                } else {
                  AM = Integer.parseInt(jTextField1.getText());
                
                }
                //jComboBox2.removeAllItems();
                
                findTid();
                fillCombo3();
            }
            
        });
        
        //fillCombo3();
    }
    
     private class ItemHandler implements ItemListener {
        
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == jComboBox1) {
                 //jComboBox2.removeAllItems();
                testname = jComboBox1.getSelectedItem().toString();
                //fillCombo3();
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        ViewTable = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        viewStudentTest = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(585, 329));
        setPreferredSize(new java.awt.Dimension(585, 319));
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLVED TESTS" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(190, 30, 130, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Επιλογή Τεστ:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 30, 160, 22);

        ViewTable.setText(" Πίνακας Αποτελεσμάτων");
        ViewTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewTableActionPerformed(evt);
            }
        });
        getContentPane().add(ViewTable);
        ViewTable.setBounds(360, 30, 210, 23);

        back.setText("Πίσω");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(10, 255, 80, 23);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Δώσε το ΑΜ του μαθητή:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 100, 150, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(190, 100, 150, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Διάλεξε αριθμό προσπάθειας:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 150, 190, 14);

        viewStudentTest.setText("Τεστ Μαθητή");
        viewStudentTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentTestActionPerformed(evt);
            }
        });
        getContentPane().add(viewStudentTest);
        viewStudentTest.setBounds(370, 140, 170, 23);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATTEMPTS" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(190, 140, 150, 20);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 810, 0);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 710, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewTableActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Solved> list = new ArrayList<Solved>();
        
        String testname = jComboBox1.getSelectedItem().toString();
        
         Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        //String sql = "select distinct testname from question2";
        String sql = "select * from test_student where testname = '" + testname + "'";
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                Solved s = new Solved();
                s.id_student = rs.getInt("id_student");
                s.tname = rs.getString("testname");
                s.attempt_no = rs.getInt("attempt_no");
                s.given_answers = rs.getInt("given_answers");
                s.right_answers = rs.getInt("right_answers");
                s.no_of_questions = rs.getInt("no_of_questions");
                s.rate = rs.getDouble("rate");
                list.add(s);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει σύνδεση με τη βάση");
        }
        
        
        for (int i = 0; i<list.size(); i++) {
            String sql2 = "select * from student where id_student = " + list.get(i).id_student + "";
            
             try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            
            while(rs.next()){
                
               list.get(i).fname = rs.getString("fname");
               list.get(i).lname = rs.getString("lname"); 
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει σύνδεση με τη βάση");
        }
            
        }
        fillTemporaryTable(list);
         
        this.dispose();
        TableResults tr = new TableResults(t_id);
        tr.setVisible(true);
        tr.setResizable(false);
    }//GEN-LAST:event_ViewTableActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Teacher t = new Teacher(t_id);
        t.setVisible(true);
        t.setResizable(false);
    }//GEN-LAST:event_backActionPerformed

    private void viewStudentTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStudentTestActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem().equals(null) || jTextField1.getText().isEmpty() || jComboBox2.getSelectedItem().equals("ATTEMPTS") || jComboBox2.getSelectedItem().equals(null)) {
            JOptionPane.showMessageDialog(null, "Υπάρχουν κενά πεδία, συμπλήρωσε όλα τα πεδία");
        } else {
            Connection con = null;
            PreparedStatement ps = null;
            int am = Integer.parseInt(jTextField1.getText().toString());
            String sql = "select id_student from student where AM= '" + am + "'";
            int id = 0;
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while(rs.next()){
            
            id = rs.getInt("id_student");
            
            }
                
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        int at = Integer.parseInt(jComboBox2.getSelectedItem().toString());
        this.dispose();
        String r = "teacher";
        StudentViewTest svt = new StudentViewTest(id,jComboBox1.getSelectedItem().toString(), at, r);
        svt.setVisible(true);
        svt.setResizable(false);
        }
    }//GEN-LAST:event_viewStudentTestActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    public void fillCombo(){
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        //String sql = "select distinct testname from question2 where id_teacher = " + t_id + "";
        String sql = "select testname from test_teacher where id_teacher = " + t_id + "";
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.createStatement();
            
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                String name = rs.getString("testname");
                jComboBox1.addItem(name);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει σύνδεση με τη βάση");
        }
    }
    
    public void fillCombo3() {
         Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "select attempt_no from test_student where id_student='" + s_id + "' and testname='" + testname + "'";
        //String sql = "select * from question2";
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.createStatement();
            //JOptionPane.showMessageDialog(null, "Connected");
            rs = st.executeQuery(sql);
            
            jComboBox2.removeAllItems();
            if (!rs.isBeforeFirst()) {
                jComboBox2.addItem("ATTEMPTS");
            } else {
            
            while(rs.next()){
                String attempts = rs.getString("attempt_no");
                jComboBox2.addItem(attempts);
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει σύνδεση με τη βάση");
        }
        s_id = 0;
    }
    public void findTid() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "select id_student from student where AM='" + AM + "'";
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.createStatement();
            //JOptionPane.showMessageDialog(null, "Connected");
            rs = st.executeQuery(sql);
            
            jComboBox2.removeAllItems();
            jComboBox2.addItem("ATTEMPTS");
             
            while(rs.next()){
                s_id = rs.getInt("id_student");
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει σύνδεση με τη βάση");
        }
    }
    
    public class Solved {
        int id_student;
        String fname;
        String lname;
        String tname;
        int attempt_no;
        int given_answers;
        int right_answers;
        int no_of_questions;
        double rate;
    }
    
    public void fillTemporaryTable(ArrayList<Solved> s){
                Connection con = null;
                Statement st = null;
                
             
                for (int i = 0; i<s.size(); i++) {
                    
                //String sql1 = "insert into temporary (fname,lname,testname,attempt_no,given_answers,right_answers,no_of_questions,rate) values('"+s.get(i).fname+"','"+s.get(i).lname+"','"+s.get(i).tname+"','"+s.get(i).attempt_no+"','"+s.get(i).given_answers+"','"+s.get(i).right_answers+"','"+s.get(i).no_of_questions+"','"+s.get(i).rate+"')";
                String sql1 = "insert into temporary (Όνομα,Επίθετο,Όνομα_Τεστ,Προσπάθεια,Απαντήσεις_Μαθητή,Σωστές_απαντήσεις,Αριθμός_ερωτήσεων,Βαθμός) values('"+s.get(i).fname+"','"+s.get(i).lname+"','"+s.get(i).tname+"','"+s.get(i).attempt_no+"','"+s.get(i).given_answers+"','"+s.get(i).right_answers+"','"+s.get(i).no_of_questions+"','"+s.get(i).rate+"')";
                try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.createStatement();
            st.executeUpdate(sql1);
            //JOptionPane.showMessageDialog(null, "Data inserted");
            this.dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχει σύνδεση με τη βάση");
                 } 
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
            java.util.logging.Logger.getLogger(ViewSolvedTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSolvedTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSolvedTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSolvedTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSolvedTests().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewTable;
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton viewStudentTest;
    // End of variables declaration//GEN-END:variables
}
