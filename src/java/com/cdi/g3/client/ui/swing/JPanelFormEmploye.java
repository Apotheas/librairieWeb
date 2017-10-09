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
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.company.Employe;
import com.cdi.g3.server.domain.company.EmployeRight;
import com.cdi.g3.server.domain.customers.Appreciation;
import com.cdi.g3.server.domain.orders.InfoStatus;
import com.cdi.g3.server.service.company.EmployeRightService;
import com.cdi.g3.server.service.company.EmployeService;
import com.cdi.g3.server.service.orders.InfoStatusService;
import com.cdi.g3.server.service.customers.AppreciationService;
import java.util.Collection;

import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @employe Apotheas
 */
public class JPanelFormEmploye extends JDesktopPane {

    DefaultTableModel myModel = new DefaultTableModel();
    EmployeRightService employeRightService = new EmployeRightService();
    AppreciationService appreciationService = new AppreciationService();
    InfoStatusService infoStatusService = new InfoStatusService ();
    EmployeService employeService = new EmployeService();
    Vector appreciationList = new Vector();
    Vector employeRightList = new Vector();
    Vector employeStatusList = new Vector();
    

    public JPanelFormEmploye() {
        initComponents();
        
        myModel.addColumn("LOGINEMPLOYEAPPRECIATE");
        myModel.addColumn("MODERATEAPPRECIATE");
        myModel.addColumn("DATEMODERATEAPPRECIATE");
        myModel.addColumn("COMMENTAPPRECIATE");
        myModel.addColumn("IPEAPPRECIATE");
        jTableModeration.setModel(myModel);
        jTree.setModel(initEmployeRightsTreeModel());
        jComboBoxRights.setModel(initEmployeRightModel());
        jComboBoxStatus.setModel(initEmployeStatusModel());
        jComboBoxTreeView.setModel(initTreeViewModel());

    }
     private DefaultComboBoxModel initTreeViewModel() {
        return new DefaultComboBoxModel(initTreeViewVector());
    }

    private Vector initTreeViewVector() {
        Vector searchList = new Vector();
        searchList.add("Tree view by :");
        searchList.add("EmployeRights");
        searchList.add("EmployeStatus");
        
        return searchList;
    }
     

  

   private void clearTab() {
        int lignes = myModel.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            myModel.removeRow(i);
        }
        appreciationList.removeAllElements();
        
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAccounts = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanelManage = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextSearchEmploye = new javax.swing.JTextField();
        jButtonIUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonEmployeSearch = new javax.swing.JButton();
        jPanelAccount = new javax.swing.JPanel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelRights = new javax.swing.JLabel();
        jComboBoxRights = new javax.swing.JComboBox<String>();
        jTextFirstName = new javax.swing.JTextField();
        jTextLogin = new javax.swing.JTextField();
        jButtonCreate = new javax.swing.JButton();
        jLabelFirstName = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        jTextLastName = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jLabelStatus = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox<String>();
        jTextPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableModeration = new javax.swing.JTable();
        jComboBoxTreeView = new javax.swing.JComboBox();

        setLayout(new java.awt.BorderLayout());

        jTree.setBorder(javax.swing.BorderFactory.createTitledBorder("Profils"));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Rights");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Admin");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("blue");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("violet");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("red");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("yellow");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Manager");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("basketball");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("soccer");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("football");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hockey");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTree);

        jPanelManage.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage"));

        jLabel18.setText("pseudo/email  :");

        jTextSearchEmploye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchEmployeActionPerformed(evt);
            }
        });

        jButtonIUpdate.setText("Update");
        jButtonIUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonEmployeSearch.setText("search");
        jButtonEmployeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmployeSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelManageLayout = new javax.swing.GroupLayout(jPanelManage);
        jPanelManage.setLayout(jPanelManageLayout);
        jPanelManageLayout.setHorizontalGroup(
            jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManageLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jTextSearchEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEmployeSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jButtonIUpdate)
                .addGap(18, 18, 18)
                .addComponent(jButtonDelete)
                .addGap(22, 22, 22))
        );
        jPanelManageLayout.setVerticalGroup(
            jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextSearchEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIUpdate)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonEmployeSearch))
                .addGap(35, 35, 35))
        );

        jPanelAccount.setBorder(javax.swing.BorderFactory.createTitledBorder("Account"));

        jLabelEmail.setText("Password");

        jLabelLogin.setText("Login  : ");

        jLabelRights.setText("Rights  :");

        jComboBoxRights.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Manager", "Item 3", "Item 4" }));
        jComboBoxRights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRightsActionPerformed(evt);
            }
        });

        jTextLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLoginActionPerformed(evt);
            }
        });

        jButtonCreate.setText("Create");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        jLabelFirstName.setText("First name :");

        jLabelLastName.setText("Last  name :");

        jTextLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLastNameActionPerformed(evt);
            }
        });

        jLabelStatus.setText("Status  :");

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Item 3", "Item 4" }));
        jComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatusActionPerformed(evt);
            }
        });

        jLabel2.setText("Email");

        javax.swing.GroupLayout jPanelAccountLayout = new javax.swing.GroupLayout(jPanelAccount);
        jPanelAccount.setLayout(jPanelAccountLayout);
        jPanelAccountLayout.setHorizontalGroup(
            jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelAccountLayout.createSequentialGroup()
                        .addComponent(jLabelFirstName)
                        .addGap(21, 21, 21)
                        .addComponent(jTextFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAccountLayout.createSequentialGroup()
                        .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLogin)
                            .addComponent(jLabelEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelAccountLayout.createSequentialGroup()
                        .addComponent(jLabelLastName)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jTextLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAccountLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountLayout.createSequentialGroup()
                        .addComponent(jLabelRights)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxRights, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountLayout.createSequentialGroup()
                        .addComponent(jLabelStatus)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCreate, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(47, 47, 47))
        );
        jPanelAccountLayout.setVerticalGroup(
            jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccountLayout.createSequentialGroup()
                        .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRights)
                            .addComponent(jComboBoxRights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelEmail))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelStatus)
                                .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelLogin)
                        .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFirstName))
                .addGap(18, 18, 18)
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLastName)
                    .addComponent(jTextLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCreate))
                .addGap(18, 18, 18)
                .addGroup(jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(210, 210, 210))
        );

        jTableModeration.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTableModeration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableModeration);

        jComboBoxTreeView.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTreeView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTreeViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAccountsLayout = new javax.swing.GroupLayout(jPanelAccounts);
        jPanelAccounts.setLayout(jPanelAccountsLayout);
        jPanelAccountsLayout.setHorizontalGroup(
            jPanelAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTreeView, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelAccountsLayout.setVerticalGroup(
            jPanelAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccountsLayout.createSequentialGroup()
                        .addComponent(jPanelManage, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(jPanelAccountsLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jComboBoxTreeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4))))
        );

        add(jPanelAccounts, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEmployeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmployeSearchActionPerformed
           
        
        clearTab();
        
        try {                                             
            Employe employe= null;
            
            
            try {
                EmployeService employeService = new EmployeService();
                employe = employeService.findEmploye(jTextSearchEmploye.getText());
            } catch (FinderException ex) {
                JOptionPane.showMessageDialog(this, "Erreur employe introuvable");
            } 
            
            
            jTextLogin.setText(employe.getId());
            jTextEmail.setText(String.valueOf(employe.getEmailEmploye()));
            jTextFirstName.setText(employe.getFirstNameEmploye());
            jTextLastName.setText(employe.getLastNameEmploye());
            jTextPassword.setText(employe.getPasswordEmploye());
            jTextEmail.setText(employe.getEmailEmploye());
            
         
        
        }
             
           catch (CheckException ex) {
                Logger.getLogger(JPanelFormEmploye.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            try{
            Vector v = null;
            
            for (Iterator itarator =appreciationService.FindAppreciationByEmployee("loginEmployeAppreciate", jTextSearchEmploye.getText()).iterator() ; itarator.hasNext();){
               Appreciation appreciation = (Appreciation)itarator.next();
                v = new Vector();
                v.add(appreciation.getId());
                v.add(appreciation.getModerateAppreciate());
                v.add(appreciation.getDateModerateAppreciate());
                v.add(appreciation.getCommentAppreciate());
                v.add(appreciation.getIpAppreciate());
                
                appreciationList.addAll(v);
            }            
            myModel.addRow(appreciationList);
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Cet employe n'a pas de moderation");
        }
                                                     
    }//GEN-LAST:event_jButtonEmployeSearchActionPerformed

                                  
     private DefaultTreeModel initEmployeRightsTreeModel() {

        return new DefaultTreeModel(initByEmployeRightTree());
    }

    private DefaultMutableTreeNode initByEmployeRightTree() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("EmployeRight");
        DefaultMutableTreeNode tnEmployeRight = null;
        DefaultMutableTreeNode tnEmploye = null;

        try {
            for (Iterator iteratorA = employeRightService.FindAllEmployeRight().iterator(); iteratorA.hasNext();) {
                EmployeRight employeRight = (EmployeRight) iteratorA.next();
                tnEmployeRight = new DefaultMutableTreeNode(employeRight);
                root.add(tnEmployeRight);
                
                  for (Iterator iteratorB = employeService.FindEmployeByRight("idEmployeRight", employeRight.getId()).iterator(); iteratorB.hasNext();) {
                    Employe employe = (Employe) iteratorB.next();
                    tnEmploye = new DefaultMutableTreeNode(employe);
                    tnEmployeRight.add(tnEmploye);
                }
             

            }
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(JPanelFormBooks.class.getName()).log(Level.SEVERE, null, ex);
        }

        return root;
    }
    
   // ______________________________________________________//

   // ________________JTREE STATUS MODELS____________________//
    private DefaultTreeModel initStatusTreeModel()  {
      

        return new DefaultTreeModel(initByStatusTree());
    }

    private DefaultMutableTreeNode initByStatusTree()  {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Status");
        DefaultMutableTreeNode tnInfoStatus = null;
        DefaultMutableTreeNode tnEmploye = null;
        try {
            for (Iterator iteratorA = infoStatusService.findStatusEmploye().iterator(); iteratorA.hasNext();) {
                InfoStatus infoStatus = (InfoStatus) iteratorA.next();
                tnInfoStatus = new DefaultMutableTreeNode(infoStatus);
                root.add(tnInfoStatus);
                  
                for (Iterator iteratorB = employeService.FindEmployeByStatus("nameInfoStatus", infoStatus.getId()).iterator(); iteratorB.hasNext();) {
                    Employe employe = (Employe) iteratorB.next();
                    tnEmploye = new DefaultMutableTreeNode(employe);
                    tnInfoStatus.add(tnEmploye);
                }
                  
            }
        } catch (ObjectNotFoundException ex) {
            
        }

        return root;
    }
    
    
    private void jTextSearchEmployeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchEmployeActionPerformed
        
    }//GEN-LAST:event_jTextSearchEmployeActionPerformed

    private void jButtonIUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIUpdateActionPerformed
      try {
            Employe employe  = new Employe();       
                   
             employe.setEmployeRight((EmployeRight)jComboBoxRights.getSelectedItem());

            employe.setLoginEmploye(jTextLogin.getText());
            employe.setFirstNameEmploye(jTextFirstName.getText());
            employe.setLastNameEmploye(jTextLastName.getText());
            employe.setEmailEmploye(jTextEmail.getText());            
            employe.setPasswordEmploye(jTextPassword.getText());
            employe.setInfoStatus((InfoStatus)jComboBoxStatus.getSelectedItem());
            
  

            int retour = JOptionPane.showConfirmDialog(this,
                    "Etes-Vous Sure de vouloir modifier l'employe ? ",
                    "Update",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (retour == JOptionPane.CLOSED_OPTION || retour == JOptionPane.NO_OPTION) {
            clearTab();
            clearField();
            }else{
            employeService.updateEmploye(employe);            
            JOptionPane.showMessageDialog(this, " Update Successfull !" );
            clearTab();
            clearField();
            }   
        } catch (UpdateException ex) {
            Logger.getLogger(JPanelFormEmploye.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CheckException ex) {
            Logger.getLogger(JPanelFormEmploye.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JPanelFormEmploye.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_jButtonIUpdateActionPerformed

    private void jComboBoxRightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRightsActionPerformed
        


        
        
    }//GEN-LAST:event_jComboBoxRightsActionPerformed

    private void jComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStatusActionPerformed

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        final String mname = "jButtonCreateActionPerformed";
        EmployeService serviceEmploye = new EmployeService();
        Employe employe = new Employe();
        try {
            // Asks if we want to remove the customer
            final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to create employe "
                + employe.getId(), "Delete", JOptionPane.YES_NO_OPTION);
            if (anwser == JOptionPane.NO_OPTION) {
                return;
            }
            employe.setLoginEmploye(jTextLogin.getText());
            employe.setEmployeRight((EmployeRight) jComboBoxRights.getSelectedItem());
            employe.setFirstNameEmploye(jTextFirstName.getText());
            employe.setLastNameEmploye(jTextLastName.getText());
            employe.setEmailEmploye(jTextEmail.getText()); 
            employe.setPasswordEmploye(jTextPassword.getText());
            employe.setInfoStatus((InfoStatus)jComboBoxStatus.getSelectedItem());
            employe = serviceEmploye.createEmploye(employe); 
         
                     
            JOptionPane.showMessageDialog(this, "Employe numEmploye " + employe.getId()
                + " is created", "info message", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Cannot access the employe service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }
                                               
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
           final String mname = "jButtonDeleteActionPerformed";

        final String loginEmploye = jTextSearchEmploye.getText();
        if ("".equals(loginEmploye)) {
            JOptionPane.showMessageDialog(this, "You have to enter an employe login ", "Delete", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Asks if we want to remove the customer
        final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to remove employe login " + loginEmploye, "Delete", JOptionPane.YES_NO_OPTION);
        if (anwser == JOptionPane.NO_OPTION) {
            return;
        }

        final EmployeService serviceEmploye = new EmployeService();
        try {
            serviceEmploye.deleteEmploye(loginEmploye);

            JOptionPane.showMessageDialog(this, "Employe login " + loginEmploye
                + " is deleted", "info message", JOptionPane.INFORMATION_MESSAGE);

            //            jComboBoxCarnet.setModel(initCarnetModel());
            //            jTree1.setModel(initCarnetTreeModel());
            //            clearFrame();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the employe service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        } // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLoginActionPerformed

    private void jTextLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLastNameActionPerformed

    private void jComboBoxTreeViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTreeViewActionPerformed
          if (jComboBoxTreeView.getSelectedItem().equals("EmployeRights")) {
            jTree.setModel(initEmployeRightsTreeModel());
        }
        if (jComboBoxTreeView.getSelectedItem().equals("EmployeStatus")) {
            jTree.setModel(initStatusTreeModel());
        }
    }//GEN-LAST:event_jComboBoxTreeViewActionPerformed

    private void jTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeMouseClicked
       DefaultMutableTreeNode tn = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();

        if (tn != null) {
            if (tn.getUserObject() instanceof Employe) {

                Employe employe = ((Employe) tn.getUserObject());
                try {
                    setEmployeToField(employe);
                } catch (ObjectNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Null object or not found " + ex.getMessage());
                }               
            }
        }
    }//GEN-LAST:event_jTreeMouseClicked
 private DefaultComboBoxModel initEmployeRightModel() {
        return new DefaultComboBoxModel(initRightVector());
    }
  private DefaultComboBoxModel initEmployeStatusModel() {
        return new DefaultComboBoxModel(initStatusVector());
    }
 
    private Vector initRightVector() {

        try {
            Collection v = employeRightService.FindAllEmployeRight();
            employeRightList.addAll(v);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(JPanelFormEmploye.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeRightList;
    }
    private Vector initStatusVector() {

        try {
            Collection<InfoStatus> v = infoStatusService.findStatusEmploye();
            employeStatusList.addAll(v);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(JPanelFormEmploye.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeStatusList;
    }
    
         private void setEmployeToField(Employe employe) throws ObjectNotFoundException {
        jTextLogin.setText(employe.getId());
        jTextPassword.setText(employe.getPasswordEmploye());
        jTextEmail.setText(employe.getEmailEmploye());
        jTextFirstName.setText(employe.getFirstNameEmploye());
        jTextLastName.setText(employe.getLastNameEmploye());
        jComboBoxRights.setSelectedItem(employe.getEmployeRight().getTypeEmployeRight());
        jComboBoxStatus.setSelectedItem(employe.getInfoStatus().getId());
    }
    
    private void clearField(){
        jTextLogin.setText(" ");
        jTextPassword.setText(" ");
        jTextEmail.setText(" ");
        jTextFirstName.setText(" ");
        jTextLastName.setText(" ");
       
    }
 protected final transient String _cname = this.getClass().getName();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEmployeSearch;
    private javax.swing.JButton jButtonIUpdate;
    private javax.swing.JComboBox<String> jComboBoxRights;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JComboBox jComboBoxTreeView;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelRights;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JPanel jPanelAccount;
    private javax.swing.JPanel jPanelAccounts;
    private javax.swing.JPanel jPanelManage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableModeration;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextFirstName;
    private javax.swing.JTextField jTextLastName;
    private javax.swing.JTextField jTextLogin;
    private javax.swing.JTextField jTextPassword;
    private javax.swing.JTextField jTextSearchEmploye;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables
}
