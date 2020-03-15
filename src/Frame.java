
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Frame extends javax.swing.JFrame {

    private String id;
    private String password;
    private Database database = new Database();
    private boolean login = false;
    public Frame() {    
               
        initComponents();
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
        idArea = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passwordArea = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        informationBox = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("                                       ATM");

        idArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idAreaActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");

        jLabel3.setText("Password:");

        passwordArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordAreaActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(idArea, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(passwordArea))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(informationBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)
                                .addComponent(loginButton)))
                        .addGap(342, 342, 342))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(registerButton)
                        .addGap(129, 129, 129))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationBox)
                    .addComponent(loginButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(registerButton)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idAreaActionPerformed
       /* id = idArea.getText();*/
        idArea.transferFocus();
    }//GEN-LAST:event_idAreaActionPerformed

    private void passwordAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordAreaActionPerformed
       /* password = passwordArea.getText();
        int index = database.searchId(id);
        login(id, password, index);*/
       id = idArea.getText();
        idArea.transferFocus();
        password = passwordArea.getText();
        login(id, password);
        
        if(login)
        {
            AccountFrame account_frame = new AccountFrame(database.searchId(id, password),database.getUsers().get(database.searchId(id, password)),database);
            account_frame.setSize(1000,600);
            account_frame.setTitle(id + "'s Account");
            account_frame.setVisible(true);
            account_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);   
        }
    }//GEN-LAST:event_passwordAreaActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
       
        id = idArea.getText();
        idArea.transferFocus();
        password = passwordArea.getText();
        login(id, password);
        
        if(login)
        {
            AccountFrame account_frame = new AccountFrame(database.searchId(id, password),database.getUsers().get(database.searchId(id, password)),database);
            account_frame.setSize(1000,600);
            account_frame.setTitle(id + "'s Account");
            account_frame.setVisible(true);
            account_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);
            
            
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        RegisterFrame registerFrame = new RegisterFrame();
        registerFrame.setDatabase(database);
        registerFrame.setSize(1000,600);
        registerFrame.setTitle("Register");
        registerFrame.setVisible(true);
        registerFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }//GEN-LAST:event_registerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idArea;
    private javax.swing.JLabel informationBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordArea;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the database
     */
    public Database getDatabase() {
        return database;
    }
    public void setDatabase(Database database) {
        this.database = database;
    }
    
    public void login(String id, String pass ){
        
        if(database.login(id, password))
         {login = true;
         }
          else login = false;
    }
   
}