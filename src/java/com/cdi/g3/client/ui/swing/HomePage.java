/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.client.ui.swing;

import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.domain.company.Employe;
import com.cdi.g3.server.domain.customers.Appreciation;
import com.cdi.g3.server.domain.orders.Orders;
import com.cdi.g3.server.service.customers.AppreciationService;
import com.cdi.g3.server.service.orders.OrderService;
import com.cdi.g3.server.service.other.Notifications;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Apotheas
 */
public class HomePage extends javax.swing.JFrame {
 

    public HomePage() throws ObjectNotFoundException {
        initComponents();
        LoginPage loggs = new LoginPage();
        Notifications notifs = new Notifications();
        JPanelFormOrders panelOrders = new JPanelFormOrders();
        JPanelFormBooks panelBooks = new JPanelFormBooks();
        JPanelFormCustomers panelAccounts = new JPanelFormCustomers();
        JPanelFormEvents panelEvents = new JPanelFormEvents();
        JPanelFormThemes panelThemes = new JPanelFormThemes();
        JPanelFormAuthor panelAuthors = new JPanelFormAuthor();
        JPanelFormEmploye panelEmployees = new JPanelFormEmploye();
        JPanelFormKeyWords panelKeyWords = new JPanelFormKeyWords();
        JPanelFormAppreciations panelAppreciations = new JPanelFormAppreciations();
        JPanelFormInfoStatus panelInfoStatus = new JPanelFormInfoStatus();
        JPanelFormCompany panelCompany = new JPanelFormCompany();
        JPanelFormEditor panelEditor = new JPanelFormEditor();

        jInternalFrameOrders.setContentPane(panelOrders);
        jInternalFrameBooks.setContentPane(panelBooks);
        jInternalFrameCustomers.setContentPane(panelAccounts);
        jInternalFrameEvents.setContentPane(panelEvents);
        jInternalFrameThemes.setContentPane(panelThemes);
        jInternalFrameAuthors.setContentPane(panelAuthors);
        jInternalFrameEmployees.setContentPane(panelEmployees);
        jInternalFrameAppreciations.setContentPane(panelAppreciations);
        jInternalFrameKeyWords.setContentPane(panelKeyWords);
        jInternalFrameInfoStatus.setContentPane(panelInfoStatus);
        jInternalFrameCompany.setContentPane(panelCompany);
        jInternalFrameEditors.setContentPane(panelEditor);

        
        JOptionPane.showMessageDialog(this, "------------------Welcome " + loggs.getEmployeLoged().getFirstNameEmploye() + "------------------------"+
                 "\n-There is : " + notifs.initNotifComments()+ " Reviews waiting for moderation-"
                 + "\n-----And : "+ notifs.initNotifOrders() +" Orders waiting to be shipped------");
    }

    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneHomePage = new javax.swing.JTabbedPane();
        jInternalFrameOrders = new javax.swing.JInternalFrame();
        jInternalFrameCustomers = new javax.swing.JInternalFrame();
        jInternalFrameEmployees = new javax.swing.JInternalFrame();
        jInternalFrameBooks = new javax.swing.JInternalFrame();
        jInternalFrameEvents = new javax.swing.JInternalFrame();
        jInternalFrameThemes = new javax.swing.JInternalFrame();
        jInternalFrameAuthors = new javax.swing.JInternalFrame();
        jInternalFrameEditors = new javax.swing.JInternalFrame();
        jInternalFrameKeyWords = new javax.swing.JInternalFrame();
        jInternalFrameAppreciations = new javax.swing.JInternalFrame();
        jInternalFrameInfoStatus = new javax.swing.JInternalFrame();
        jInternalFrameCompany = new javax.swing.JInternalFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 900));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jTabbedPaneHomePage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management System", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        jInternalFrameOrders.setVisible(true);

        javax.swing.GroupLayout jInternalFrameOrdersLayout = new javax.swing.GroupLayout(jInternalFrameOrders.getContentPane());
        jInternalFrameOrders.getContentPane().setLayout(jInternalFrameOrdersLayout);
        jInternalFrameOrdersLayout.setHorizontalGroup(
            jInternalFrameOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameOrdersLayout.setVerticalGroup(
            jInternalFrameOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("Orders", jInternalFrameOrders);

        jInternalFrameCustomers.setBorder(null);
        jInternalFrameCustomers.setVisible(true);

        javax.swing.GroupLayout jInternalFrameCustomersLayout = new javax.swing.GroupLayout(jInternalFrameCustomers.getContentPane());
        jInternalFrameCustomers.getContentPane().setLayout(jInternalFrameCustomersLayout);
        jInternalFrameCustomersLayout.setHorizontalGroup(
            jInternalFrameCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
        );
        jInternalFrameCustomersLayout.setVerticalGroup(
            jInternalFrameCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("Customers", jInternalFrameCustomers);

        jInternalFrameEmployees.setVisible(true);

        javax.swing.GroupLayout jInternalFrameEmployeesLayout = new javax.swing.GroupLayout(jInternalFrameEmployees.getContentPane());
        jInternalFrameEmployees.getContentPane().setLayout(jInternalFrameEmployeesLayout);
        jInternalFrameEmployeesLayout.setHorizontalGroup(
            jInternalFrameEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameEmployeesLayout.setVerticalGroup(
            jInternalFrameEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("Employees", jInternalFrameEmployees);

        jInternalFrameBooks.setVisible(true);

        javax.swing.GroupLayout jInternalFrameBooksLayout = new javax.swing.GroupLayout(jInternalFrameBooks.getContentPane());
        jInternalFrameBooks.getContentPane().setLayout(jInternalFrameBooksLayout);
        jInternalFrameBooksLayout.setHorizontalGroup(
            jInternalFrameBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameBooksLayout.setVerticalGroup(
            jInternalFrameBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("Books", jInternalFrameBooks);

        jInternalFrameEvents.setVisible(true);
        jInternalFrameEvents.getContentPane().setLayout(new javax.swing.OverlayLayout(jInternalFrameEvents.getContentPane()));
        jTabbedPaneHomePage.addTab("Events", jInternalFrameEvents);

        jInternalFrameThemes.setVisible(true);

        javax.swing.GroupLayout jInternalFrameThemesLayout = new javax.swing.GroupLayout(jInternalFrameThemes.getContentPane());
        jInternalFrameThemes.getContentPane().setLayout(jInternalFrameThemesLayout);
        jInternalFrameThemesLayout.setHorizontalGroup(
            jInternalFrameThemesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameThemesLayout.setVerticalGroup(
            jInternalFrameThemesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("Themes", jInternalFrameThemes);

        jInternalFrameAuthors.setVisible(true);

        javax.swing.GroupLayout jInternalFrameAuthorsLayout = new javax.swing.GroupLayout(jInternalFrameAuthors.getContentPane());
        jInternalFrameAuthors.getContentPane().setLayout(jInternalFrameAuthorsLayout);
        jInternalFrameAuthorsLayout.setHorizontalGroup(
            jInternalFrameAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameAuthorsLayout.setVerticalGroup(
            jInternalFrameAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("Authors", jInternalFrameAuthors);

        jInternalFrameEditors.setVisible(true);

        javax.swing.GroupLayout jInternalFrameEditorsLayout = new javax.swing.GroupLayout(jInternalFrameEditors.getContentPane());
        jInternalFrameEditors.getContentPane().setLayout(jInternalFrameEditorsLayout);
        jInternalFrameEditorsLayout.setHorizontalGroup(
            jInternalFrameEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameEditorsLayout.setVerticalGroup(
            jInternalFrameEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("Editors", jInternalFrameEditors);

        jInternalFrameKeyWords.setVisible(true);

        javax.swing.GroupLayout jInternalFrameKeyWordsLayout = new javax.swing.GroupLayout(jInternalFrameKeyWords.getContentPane());
        jInternalFrameKeyWords.getContentPane().setLayout(jInternalFrameKeyWordsLayout);
        jInternalFrameKeyWordsLayout.setHorizontalGroup(
            jInternalFrameKeyWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameKeyWordsLayout.setVerticalGroup(
            jInternalFrameKeyWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("KeyWords", jInternalFrameKeyWords);

        jInternalFrameAppreciations.setVisible(true);

        javax.swing.GroupLayout jInternalFrameAppreciationsLayout = new javax.swing.GroupLayout(jInternalFrameAppreciations.getContentPane());
        jInternalFrameAppreciations.getContentPane().setLayout(jInternalFrameAppreciationsLayout);
        jInternalFrameAppreciationsLayout.setHorizontalGroup(
            jInternalFrameAppreciationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameAppreciationsLayout.setVerticalGroup(
            jInternalFrameAppreciationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("Appreciations", jInternalFrameAppreciations);

        jInternalFrameInfoStatus.setVisible(true);

        javax.swing.GroupLayout jInternalFrameInfoStatusLayout = new javax.swing.GroupLayout(jInternalFrameInfoStatus.getContentPane());
        jInternalFrameInfoStatus.getContentPane().setLayout(jInternalFrameInfoStatusLayout);
        jInternalFrameInfoStatusLayout.setHorizontalGroup(
            jInternalFrameInfoStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameInfoStatusLayout.setVerticalGroup(
            jInternalFrameInfoStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("InfoStatus", jInternalFrameInfoStatus);

        jInternalFrameCompany.setVisible(true);

        javax.swing.GroupLayout jInternalFrameCompanyLayout = new javax.swing.GroupLayout(jInternalFrameCompany.getContentPane());
        jInternalFrameCompany.getContentPane().setLayout(jInternalFrameCompanyLayout);
        jInternalFrameCompanyLayout.setHorizontalGroup(
            jInternalFrameCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jInternalFrameCompanyLayout.setVerticalGroup(
            jInternalFrameCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        jTabbedPaneHomePage.addTab("Company", jInternalFrameCompany);

        getContentPane().add(jTabbedPaneHomePage);

        setSize(new java.awt.Dimension(1200, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrameAppreciations;
    private javax.swing.JInternalFrame jInternalFrameAuthors;
    private javax.swing.JInternalFrame jInternalFrameBooks;
    private javax.swing.JInternalFrame jInternalFrameCompany;
    private javax.swing.JInternalFrame jInternalFrameCustomers;
    private javax.swing.JInternalFrame jInternalFrameEditors;
    private javax.swing.JInternalFrame jInternalFrameEmployees;
    private javax.swing.JInternalFrame jInternalFrameEvents;
    private javax.swing.JInternalFrame jInternalFrameInfoStatus;
    private javax.swing.JInternalFrame jInternalFrameKeyWords;
    private javax.swing.JInternalFrame jInternalFrameOrders;
    private javax.swing.JInternalFrame jInternalFrameThemes;
    private javax.swing.JTabbedPane jTabbedPaneHomePage;
    // End of variables declaration//GEN-END:variables
}
