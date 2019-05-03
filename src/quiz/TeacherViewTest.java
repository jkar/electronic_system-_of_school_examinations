/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.Image;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
//import static quiz.CreateTest.list;
//import static quiz.ShowQuestion.numofq;

/**
 *
 * @author anna
 */
public class TeacherViewTest extends javax.swing.JFrame {
    
    static byte[] img = null;

    private static String testname;
    
    static int numofq = 1;
    static int newQuestionFlag = 0;
    static int counter = 0;
    static int limit = 0;
    static int limit2 = 0;
    static int noq;
    static int deleteq = 0;
    
    // h opws to xa k dokimazw final gia na mhn allazei k ginetai pote null k me petaei
    byte[] ima = null;
    
    static int t_id;
    static double rate;
    static int attempts;
    String textArea;
    //String s = null;
    String s = null;
    String textField1;
    String textField2;
    String textField3;
    String textField4;
    String textField5;
    
    //s auto bazw to test apo th bash dedomenwn
    byte[] im = null;
    
    
    int imagePassed = 0;
    
    //static ArrayList<TeacherViewTest> l1 = new ArrayList<TeacherViewTest>();
    static TeacherViewTest[] array;
    
    static int[] imcounter;
    
    
    
    /**
     * Creates new form TeacherViewTest
     */
    public TeacherViewTest() {
        initComponents();
        
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel5.setIcon(image2);
        
        confirm.setVisible(false);
        Cancel.setVisible(false);
        
        if (numofq >= limit) {
            nextQuestion.setVisible(false);
        }
        
        if (numofq < limit) {
            saveChanges.setVisible(false);
            addQuestion.setVisible(false);
        }
        if (numofq == 1) {
            previousQuestion.setVisible(false);
        }
        
        
        if (array[numofq-1] != null) {
            
            jLabel2.setText(Integer.toString(numofq));
             jTextArea1.setText(array[numofq-1].textArea);
             jTextField1.setText(array[numofq-1].textField1);
             jTextField2.setText(array[numofq-1].textField2);
             jTextField3.setText(array[numofq-1].textField3);
             jTextField4.setText(array[numofq-1].textField4);
             jTextField5.setText(array[numofq-1].textField5);
             
             
             //if (array[numofq-1].s != null) {
             if (imcounter[numofq-1] == 1) {
             //if (imagePassed > 0 ) {
                jTextField6.setText(array[numofq-1].s);
                jLabel_image.setIcon(ResizeImages(array[numofq-1].s));
                
             
             } else if (imcounter[numofq-1] == 2) {
                ImageIcon image = new ImageIcon(array[numofq-1].im); 
                Image nim =  image.getImage().getScaledInstance(jLabel_image.getWidth(), jLabel_image.getHeight(), Image.SCALE_SMOOTH);
                image = new ImageIcon(nim);
                jLabel_image.setIcon(image);
                jTextField6.setText("default_image");
         } 
             else {
                 
                 //edw
                 
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
            byte[] im = rs.getBytes("image"); 
            ima = im;
             
             
             
             if (im != null) {
                  
             ImageIcon image = new ImageIcon(ima); 
             //s = image.toString();
             Image nim =  image.getImage().getScaledInstance(jLabel_image.getWidth(), jLabel_image.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel_image.setIcon(image);
              
              } else {
             jLabel_image.setVisible(false);
             }
                   
             
            }
            
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
               
               
             }
            
        } else {
        
        
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
            String cn = Integer.toString(rs.getInt("n_of_ran"));
            byte[] im = rs.getBytes("image"); 
            //ima = im;
             
             jLabel2.setText(num);
             jTextArea1.setText(tarea);
             jTextField1.setText(rb1);
             jTextField2.setText(rb2);
             jTextField3.setText(rb3);
             jTextField4.setText(rb4);
             jTextField5.setText(cn);
             
             if (im != null) {
                  
             ImageIcon image = new ImageIcon(im); 
             //s = image.toString();
             Image nim =  image.getImage().getScaledInstance(jLabel_image.getWidth(), jLabel_image.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel_image.setIcon(image);
              
              } else {
             jLabel_image.setVisible(false);
             }
            } 
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
                }
        }
    }
    
    public TeacherViewTest(int t, int id) {
        initComponents();
        Role r = new Role();
        r.getBackgroundImage();
        img = r.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel5.setIcon(image2);
        
        t_id = id;
        jLabel2.setText(Integer.toString(numofq));
        nextQuestion.setVisible(false);
        saveChanges.setVisible(false);
        previousQuestion.setVisible(false);
        addQuestion.setVisible(false);
        
    }
    
    public TeacherViewTest(String test, int id, double r, int atts) {
        testname = test;
        t_id = id;
        rate = r;
        attempts = atts;
        initComponents();
        Role r3 = new Role();
        r3.getBackgroundImage();
        img = r3.im;
        ImageIcon image2 = new ImageIcon(img); 
        Image nim2 =  image2.getImage().getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_SMOOTH);
        image2 = new ImageIcon(nim2);
        jLabel5.setIcon(image2);
       
        confirm.setVisible(false);
        Cancel.setVisible(false);
        
        ShowQuestion sq = new ShowQuestion();
        limit = sq.maxNo(testname);
        noq = sq.maxNo(testname);
        
        array = new TeacherViewTest[limit];
        imcounter = new int[limit];
        
         if (numofq >= limit) {
            nextQuestion.setVisible(false);
        }
        if ((numofq < limit)  && (limit) > 1) {
            saveChanges.setVisible(false);
            addQuestion.setVisible(false);
        }
        if (numofq == 1) {
            previousQuestion.setVisible(false);
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
            String cn = Integer.toString(rs.getInt("n_of_ran"));
            byte[] im = rs.getBytes("image");
            //ima = im;
             
             jLabel2.setText(num);
             jTextArea1.setText(tarea);
             jTextField1.setText(rb1);
             jTextField2.setText(rb2);
             jTextField3.setText(rb3);
             jTextField4.setText(rb4);
             jTextField5.setText(cn);
             
             if (im != null) {
                  
             ImageIcon image = new ImageIcon(im); 
             Image nim =  image.getImage().getScaledInstance(jLabel_image.getWidth(), jLabel_image.getHeight(), Image.SCALE_SMOOTH);
             image = new ImageIcon(nim);
             jLabel_image.setIcon(image);
              
              } else {
             jLabel_image.setVisible(false);
              }
             
             
            }
            
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_image = new javax.swing.JLabel();
        attachImage = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nextQuestion = new javax.swing.JButton();
        saveChanges = new javax.swing.JButton();
        previousQuestion = new javax.swing.JButton();
        defaultImage = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        addQuestion = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(935, 539));
        setPreferredSize(new java.awt.Dimension(935, 502));
        getContentPane().setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(179, 64, 496, 109);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ερώτηση");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 82, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 20, 66, 22);

        jLabel_image.setText("icon");
        getContentPane().add(jLabel_image);
        jLabel_image.setBounds(319, 201, 142, 85);

        attachImage.setText("Εισαγωγή εικόνας");
        attachImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachImageActionPerformed(evt);
            }
        });
        getContentPane().add(attachImage);
        attachImage.setBounds(479, 235, 160, 23);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(179, 310, 496, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(179, 336, 496, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(179, 367, 496, 20);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(179, 398, 496, 20);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(456, 425, 51, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Δώσε αριθμό σωστής ερώτησης (1-4)");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(179, 428, 270, 14);

        nextQuestion.setText("Επόμενη ερώτηση");
        nextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionActionPerformed(evt);
            }
        });
        getContentPane().add(nextQuestion);
        nextQuestion.setBounds(460, 468, 160, 23);

        saveChanges.setText("Αποθήκευση αλλαγών");
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesActionPerformed(evt);
            }
        });
        getContentPane().add(saveChanges);
        saveChanges.setBounds(630, 468, 180, 23);

        previousQuestion.setText("Προηγούμενη ερώτηση");
        previousQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQuestionActionPerformed(evt);
            }
        });
        getContentPane().add(previousQuestion);
        previousQuestion.setBounds(260, 468, 190, 23);

        defaultImage.setText("Default εικόνα");
        defaultImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultImageActionPerformed(evt);
            }
        });
        getContentPane().add(defaultImage);
        defaultImage.setBounds(479, 201, 160, 23);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(479, 266, 160, 20);

        addQuestion.setText("Πρόσθεσε ερώτηση");
        addQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQuestionActionPerformed(evt);
            }
        });
        getContentPane().add(addQuestion);
        addQuestion.setBounds(107, 468, 150, 23);

        confirm.setText("Αποδοχή");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm);
        confirm.setBounds(818, 468, 100, 23);

        Cancel.setText("Ακύρωση");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel);
        Cancel.setBounds(828, 420, 90, 23);

        exit.setText("Έξοδος");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(19, 468, 80, 23);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 0, 0, 0);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1020, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void nextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionActionPerformed
        // TODO add your handling code here:
        
         textArea = jTextArea1.getText().toString();
         textField1 = jTextField1.getText().toString();
         textField2 = jTextField2.getText().toString();
         textField3 = jTextField3.getText().toString();
         textField4 = jTextField4.getText().toString();
         textField5 = jTextField5.getText().toString();
         
         //if (imagePassed > 0) {
         if (imcounter[numofq-1] == 1) {
         s =  jTextField6.getText().toString();
         } else if (imcounter[numofq-1] == 2) {
             getIamgeTest();
         }
          
         
                 
         
         
         counter++;
         array[numofq-1] = this;
         numofq++;
         counter++;
         this.dispose();
         
         TeacherViewTest tvt = new TeacherViewTest();
         tvt.setVisible(true);
         tvt.setResizable(false);
        
    }//GEN-LAST:event_nextQuestionActionPerformed

    private void saveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesActionPerformed
        // TODO add your handling code here:
        
        if (newQuestionFlag == 0) {
         textArea = jTextArea1.getText().toString();
         textField1 = jTextField1.getText().toString();
         textField2 = jTextField2.getText().toString();
         textField3 = jTextField3.getText().toString();
         textField4 = jTextField4.getText().toString();
         textField5 = jTextField5.getText().toString();
         
         // if (imagePassed > 0) {
         if (imcounter[numofq-1] == 1) {
         s =  jTextField6.getText().toString();
         //imagePassed = 0;
         } else if (imcounter[numofq-1] == 2) {
             getIamgeTest();
         }
        
        
         array[numofq-1] = this;
         numofq++;
        }
         
         
        if (jTextArea1.getText().isEmpty() || jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Υπάρχουν κενά πεδία, συμπλήρωσε όλα τα πεδία");
        } else {
       
       
       //for (int i=0; i<array.length; i++) {
       for (int i=0; i<noq; i++) {
           int no = i +1;
           
           String tname = array[i].testname;
           String ta = array[i].textArea;
           String tf1 =  array[i].textField1;
           String tf2 = array[i].textField2;
           String tf3 = array[i].textField3;
           String tf4 = array[i].textField4;
           String tf5 = array[i].textField5;
           
             int ans = 0;
           ans = Integer.parseInt(tf5);
           
           
            try {
                //if (imagePassed > 0) {
                if (imcounter[i] == 1)  {
                
               InputStream is = new FileInputStream(new File(array[i].s));
               CreateTest ct = new CreateTest();
               ct.queryUpdate(tname,no,ta,tf1,tf2,tf3,tf4,ans, is);
                } else if (imcounter[i] == 2) {
                    queryUpdate3(tname,no,ta,tf1,tf2,tf3,tf4,ans, array[i].im);
                }
                else {
                    
                    CreateTest ct = new CreateTest();
                    ct.queryUpdate2(tname,no,ta,tf1,tf2,tf3,tf4,ans);
                    
                }
                
                
           } catch (FileNotFoundException ex) {
               Logger.getLogger(CreateTest.class.getName()).log(Level.SEVERE, null, ex);
           }
                    
            }
       
       for (int i = noq; i < array.length; i++) {
           int no = i +1;
           
           String tname = array[i].testname;
           String ta = array[i].textArea;
           String tf1 =  array[i].textField1;
           String tf2 = array[i].textField2;
           String tf3 = array[i].textField3;
           String tf4 = array[i].textField4;
           String tf5 = array[i].textField5;
           
             int ans = 0;
           ans = Integer.parseInt(tf5);
           try {
               if (imcounter[i] == 2) {
                   CreateTest2 ct2 = new CreateTest2();
                   ct2.theQuery5(t_id, tname, no, ta, tf1, tf2, tf3, tf4, ans, array[i].im);
               } else {
               InputStream is = new FileInputStream(new File(array[i].s));
                CreateTest2 ct2 = new CreateTest2(testname, t_id);
           ct2.theQuery4(t_id,tname,no,ta,tf1,tf2,tf3,tf4,ans,is);
               }
           } catch (FileNotFoundException ex) {
               Logger.getLogger(TeacherViewTest.class.getName()).log(Level.SEVERE, null, ex);
           }
              
           
       }
         insertRateAttempt();
         this.dispose();
         PublishTest pt = new PublishTest(t_id, testname);
         pt.setVisible(true);
         pt.setResizable(false);
         
         testname = null;
         numofq = 1;
         newQuestionFlag = 0;
         counter = 0;
         limit = 0;
         limit2 = 0;
         noq = 0;
         deleteq = 0;
         array = null;
         imcounter = null;
         //Teacher t = new Teacher();
         //t.setVisible(true);
        }
          
    }//GEN-LAST:event_saveChangesActionPerformed

    private void attachImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachImageActionPerformed
        // TODO add your handling code here:
        
          JFileChooser chooser = new JFileChooser();
         chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE","jpeg","gif","png");
         chooser.addChoosableFileFilter(filter);
         int result = chooser.showSaveDialog(null);
         if (result == JFileChooser.APPROVE_OPTION) {
             imcounter[numofq-1] = 1;
             File selectedFile = chooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
             jLabel_image.setIcon(ResizeImages(path));
             s = path;
             jTextField6.setText(s);
            
         } 
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("δεν υπάρχουν δεδομένα");
         }
         //ayto mallon prepei na bei sthn 705 seira meta to if(result==..), etsi wste an den ginei epilogh alla apla paththei to button na mh kanei ++
         //san to CreateTest2 ,jButton_attachimageActionPerformed, h metablhth imagePassed
         //imcounter[numofq-1] = 1;
    }//GEN-LAST:event_attachImageActionPerformed

    private void previousQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionActionPerformed
        // TODO add your handling code here:
        

         textArea = jTextArea1.getText().toString();
         textField1 = jTextField1.getText().toString();
         textField2 = jTextField2.getText().toString();
         textField3 = jTextField3.getText().toString();
         textField4 = jTextField4.getText().toString();
         textField5 = jTextField5.getText().toString();
         
         // if (imagePassed > 0) {
         if (imcounter[numofq-1] == 1) {
         s =  jTextField6.getText().toString();
         } else if (imcounter[numofq-1] == 2) {
             getIamgeTest();
         }
         
        array[numofq-1] = this;
        numofq--;
        this.dispose();
         TeacherViewTest tvt = new TeacherViewTest();
         tvt.setVisible(true);
         tvt.setResizable(false);
         
    }//GEN-LAST:event_previousQuestionActionPerformed

    private void defaultImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultImageActionPerformed
        // TODO add your handling code here:
        //imagePassed++;
        imcounter[numofq-1] = 2;
        //s = "C:"+"\\"+"Users"+"\\"+"anna"+"\\"+"Documents"+"\\"+"NetBeansProjects"+"\\"+"quiz"+"\\"+"src"+"\\"+"quiz"+"\\"+"test.jpg";
        //File file = new File("src\\quiz\\test.jpg"); swsto!
        //String path = file.getAbsolutePath(); swsto!
        //s = path; swsto!
        //jTextField6.setText(s); swsto!
        //jLabel_image.setIcon(ResizeImage(s)); swsto!
        getIamgeTest();
        ImageIcon image = new ImageIcon(im); 
        Image nim =  image.getImage().getScaledInstance(jLabel_image.getWidth(), jLabel_image.getHeight(), Image.SCALE_SMOOTH);
        image = new ImageIcon(nim);
        jLabel_image.setIcon(image);
        jTextField6.setText("default_image");
        
        
        
    }//GEN-LAST:event_defaultImageActionPerformed

    private void addQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQuestionActionPerformed
        // TODO add your handling code here:
        
        textArea = jTextArea1.getText().toString();
         textField1 = jTextField1.getText().toString();
         textField2 = jTextField2.getText().toString();
         textField3 = jTextField3.getText().toString();
         textField4 = jTextField4.getText().toString();
         textField5 = jTextField5.getText().toString();
         
         // if (imagePassed > 0) {
         //if (imcounter[numofq-1] > 0) { svsto!
         if (imcounter[numofq-1] == 1) {
         s =  jTextField6.getText().toString();
         //imagePassed = 0;
         } else if (imcounter[numofq-1] == 2) {
            getIamgeTest();
            
         }
        
        
         array[numofq-1] = this;
         
        
        newQuestionFlag++;
        int limit2 = limit + 1;
        TeacherViewTest[] array2 = new TeacherViewTest[limit2];
        int[] imcounter2 = new int[limit2];
        
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        for (int i = 0; i < imcounter.length; i++) {
            imcounter2[i] = imcounter[i];
        }
        int j = array.length;
        limit = limit2;
        array = new TeacherViewTest[limit];
        imcounter = new int[limit];
        
         for (int i = 0; i < j; i++) {
            array[i] = array2[i];
        }
        for (int i = 0; i < j; i++) {
            imcounter[i] = imcounter2[i];
        }
        
         numofq++; 
        
        this.dispose();
         TeacherViewTest tvt = new TeacherViewTest(limit, t_id);
         tvt.setVisible(true);
         tvt.setResizable(false);
        
    }//GEN-LAST:event_addQuestionActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        // TODO add your handling code here:
        
        
        
         textArea = jTextArea1.getText().toString();
         textField1 = jTextField1.getText().toString();
         textField2 = jTextField2.getText().toString();
         textField3 = jTextField3.getText().toString();
         textField4 = jTextField4.getText().toString();
         textField5 = jTextField5.getText().toString();
         
        
         if (imcounter[numofq-1] == 1) {
         s =  jTextField6.getText().toString();
         } else if (imcounter[numofq-1] == 2) {
             getIamgeTest();
         }
         
        
          if (jTextArea1.getText().isEmpty() || jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField5.getText().isEmpty() || jTextField6.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Υπάρχουν κενά πεδία, συμπλήρωσε όλα τα πεδία");
        } else {
       
        
         array[numofq-1] = this;
        
         this.dispose();
         TeacherViewTest tvt = new TeacherViewTest();
         tvt.setVisible(true);
         tvt.setResizable(false);
         //ImageIcon image = new ImageIcon(im); 
        //Image nim =  image.getImage().getScaledInstance(jLabel_image.getWidth(), jLabel_image.getHeight(), Image.SCALE_SMOOTH);
        //image = new ImageIcon(nim);
        //tvt.jLabel_image.setIcon(image);
        //tvt.jTextField6.setText("default_image");
          }
    }//GEN-LAST:event_confirmActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        newQuestionFlag--;
        int limit2 = limit - 1;
        TeacherViewTest[] array2 = new TeacherViewTest[limit2];
        int[] imcounter2 = new int[limit2];
        
        for (int i = 0; i < array.length-1; i++) {
            array2[i] = array[i];
        }
        for (int i = 0; i < imcounter.length-1; i++) {
            imcounter2[i] = imcounter[i];
        }
        int j = array.length-1;
        limit = limit2;
        array = new TeacherViewTest[limit];
        imcounter = new int[limit];
        
         for (int i = 0; i < j; i++) {
            array[i] = array2[i];
        }
        for (int i = 0; i < j; i++) {
            imcounter[i] = imcounter2[i];
        }
        numofq--;
        
        this.dispose();
         TeacherViewTest tvt = new TeacherViewTest();
         tvt.setVisible(true);
         tvt.setResizable(false);
    }//GEN-LAST:event_CancelActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        testname = null;
        numofq = 1;
        newQuestionFlag = 0;
        counter = 0;
        limit = 0;
        limit2 = 0;
        deleteq = 0;
        array = null;
        imcounter = null;
        
        this.dispose();
         Teacher t = new Teacher();
         t.setVisible(true);
         t.setResizable(false);
    }//GEN-LAST:event_exitActionPerformed

     private ImageIcon ResizeImages(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(jLabel_image.getWidth(), jLabel_image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
     
     public void insertRateAttempt() {
         Connection con = null;
        Statement st = null;
        
         try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            String sql1 = "update test_teacher set neg_rate = '"+rate+"', allow_attempts = '"+attempts+"' where testname = '"+testname+"'";
            st = con.createStatement();
            //JOptionPane.showMessageDialog(null, "Connected");
            st.executeUpdate(sql1);
            st.close();
             JOptionPane.showMessageDialog(null, "Τα δεδομένα ανανεώθηκαν");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
     }
     
      private void getIamgeTest() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sql = "select test from images";
        

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
             im = rs.getBytes("test");
            }
            //array[numofq-1].im = image;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ΔΕΝ έιναι σε σύνδεση με τη βάση");
        }
    }
                                        
     public void queryUpdate3(String tname, int n, String t1, String rb1, String rb2, String rb3, String rb4, int ra, byte[] b) {
       
        Connection con = null;
        
        
         try{
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?zeroDateTimeBehavior=convertToNull","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testmaker?useUnicode=true&characterEncoding=utf-8","root","");
            PreparedStatement ps = con.prepareStatement("update question2 set texta = ?,rbutton1 = ?,rbutton2 = ?,rbutton3 = ?,rbutton4 = ?,n_of_ran = ?,image = ? where testname = ? and No = ?");
            //InputStream is = new FileInputStream(new File(s));
            
            ps.setString(1, t1);
            ps.setString(2, rb1);
            ps.setString(3, rb2);
            ps.setString(4, rb3);
            ps.setString(5, rb4);
            ps.setInt(6, ra);
            ps.setBinaryStream(7, new ByteArrayInputStream(b), b.length);
            ps.setString(8, tname);
            ps.setInt(9, n);
            ps.executeUpdate();
            ps.close();
            //JOptionPane.showMessageDialog(null, "Τα δεδομένα ανανεώθηκαν");
            
        } catch (Exception e) {
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(TeacherViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherViewTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherViewTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton addQuestion;
    private javax.swing.JButton attachImage;
    private javax.swing.JButton confirm;
    private javax.swing.JButton defaultImage;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_image;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton nextQuestion;
    private javax.swing.JButton previousQuestion;
    private javax.swing.JButton saveChanges;
    // End of variables declaration//GEN-END:variables
}
