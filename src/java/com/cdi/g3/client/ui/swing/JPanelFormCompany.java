/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.client.ui.swing;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.server.domain.company.Company;
import com.cdi.g3.server.domain.company.Company;
import com.cdi.g3.server.service.company.CompanyService;
import com.cdi.g3.server.service.company.CompanyService;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Izet
 */
public class JPanelFormCompany extends javax.swing.JPanel {
 DefaultTableModel myModel = new DefaultTableModel();
     CompanyService companyService = new CompanyService();
    Vector companyList = new Vector();
    
    
    public JPanelFormCompany() {
    
         initComponents();
         Company company = new Company();
         
         
   
        
       
            
            
            try {
                CompanyService companyService = new CompanyService();
             try {
                 company = companyService.findCompany(jTextSiret.getText());
             } catch (CheckException ex) {
                 Logger.getLogger(JPanelFormCompany.class.getName()).log(Level.SEVERE, null, ex);
             }
            } catch (FinderException ex) {
                JOptionPane.showMessageDialog(this, "Erreur employe introuvable");
            } 
    
         jTextSiret.setText(company.getId());
         jTextName.setText(company.getNameCompany());
         jTextLogo.setText(company.getLogoCompany());
         jTextMail.setText(company.getMailCompany());
         jTextTelephone.setText(company.getTelephoneCompany());
         jTextFax.setText(company.getFaxCompany());
    }  
    
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAccounts = new javax.swing.JPanel();
        jPanelAccount = new javax.swing.JPanel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jTextLogo = new javax.swing.JTextField();
        jTextFax = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jTextSiret = new javax.swing.JTextField();
        jLabelFirstName = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        jTextTelephone = new javax.swing.JTextField();
        jTextName = new javax.swing.JTextField();
        jLabelCompany = new javax.swing.JLabel();
        jTextMail = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();

        jPanelAccount.setBorder(javax.swing.BorderFactory.createTitledBorder("Company"));

        jLabelEmail.setText("Name  :");

        jLabelLogin.setText("Siret");

        jTextFax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFaxActionPerformed(evt);
            }
        });

        jLabelPassword.setText("Fax  :");

        jTextSiret.setText("33458219400018");
        jTextSiret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSiretActionPerformed(evt);
            }
        });

        jLabelFirstName.setText("Logo url :");

        jLabelLastName.setText("Telephone :");

        jTextName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNameActionPerformed(evt);
            }
        });

        jLabelCompany.setText("Mail  : ");

        jTextMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMailActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAccountLayout = new javax.swing.GroupLayout(jPanelAccount);
        jPanelAccount.setLayout(jPanelAccountLayout);
        jPanelAccountLayout.setHorizontalGroup(
            jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelAccountLayout.createSequentialGroup()
                        .addComponent(jLabelFirstName)
                        .addGap(21, 21, 21)
                        .addComponent(jTextLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAccountLayout.createSequentialGroup()
                        .addComponent(jLabelLastName)
                        .addGap(18, 18, 18)
                        .addComponent(jTextTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAccountLayout.createSequentialGroup()
                        .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextName, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jTextSiret))))
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccountLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCompany)
                            .addComponent(jLabelPassword))
                        .addGap(23, 23, 23)
                        .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFax, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(jTextMail))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))))
        );
        jPanelAccountLayout.setVerticalGroup(
            jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSiret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogin)
                    .addComponent(jLabelPassword)
                    .addComponent(jTextFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCompany)
                    .addComponent(jTextMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFirstName))
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccountLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLastName)
                            .addComponent(jTextTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jButtonUpdate)
                        .addGap(49, 49, 49))))
        );

        javax.swing.GroupLayout jPanelAccountsLayout = new javax.swing.GroupLayout(jPanelAccounts);
        jPanelAccounts.setLayout(jPanelAccountsLayout);
        jPanelAccountsLayout.setHorizontalGroup(
            jPanelAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        jPanelAccountsLayout.setVerticalGroup(
            jPanelAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanelAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(422, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
 
    
    
    
    
    
    
    
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        try {
            Company company  = new Company();       
                   
            
            company.setId(jTextSiret.getText());
            company.setNameCompany(jTextName.getText());
            company.setLogoCompany(jTextLogo.getText());
            company.setMailCompany(jTextMail.getText());
            company.setTelephoneCompany(jTextTelephone.getText());            
            company.setFaxCompany(jTextFax.getText());
            
            
  

            int retour = JOptionPane.showConfirmDialog(this,
                    "Etes-Vous Sure de vouloir modifier la company ? ",
                    "Update",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (retour == JOptionPane.CLOSED_OPTION || retour == JOptionPane.NO_OPTION) {
            clearTab();
            clearField();
            }else{
            companyService.updateCompany(company);            
            JOptionPane.showMessageDialog(this, " Update Successfull !" );
           
            
            }   
        } catch (UpdateException ex) {
            Logger.getLogger(JPanelFormCompany.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CheckException ex) {
            Logger.getLogger(JPanelFormCompany.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JPanelFormCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
    
                                                
    }//GEN-LAST:event_jButtonUpdateActionPerformed
 private void clearField(){
        jTextSiret.setText(" ");
        jTextName.setText(" ");
        jTextLogo.setText(" ");
        jTextMail.setText(" ");
        jTextTelephone.setText(" ");
       jTextFax.setText(" ");
    }
    
    
    private void clearTab() {
        int lignes = myModel.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            myModel.removeRow(i);
        }
        companyList.removeAllElements();
        
    }
    private void jTextFaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFaxActionPerformed

    private void jTextSiretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSiretActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSiretActionPerformed

    private void jTextNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNameActionPerformed

    private void jTextMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelCompany;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JPanel jPanelAccount;
    private javax.swing.JPanel jPanelAccounts;
    private javax.swing.JTextField jTextFax;
    private javax.swing.JTextField jTextLogo;
    private javax.swing.JTextField jTextMail;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextSiret;
    private javax.swing.JTextField jTextTelephone;
    // End of variables declaration//GEN-END:variables
}
