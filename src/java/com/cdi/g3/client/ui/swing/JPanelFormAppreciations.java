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
import com.cdi.g3.common.utiles.Utility;

import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.company.Employe;
import com.cdi.g3.server.domain.customers.Appreciation;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.service.catalog.CatalogService;
import com.cdi.g3.server.service.company.EmployeService;
import com.cdi.g3.server.service.customers.AppreciationService;
import com.cdi.g3.server.service.customers.CustomerService;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Apotheas
 */
public class JPanelFormAppreciations extends javax.swing.JPanel {

    private DefaultTableModel tabModelWait = new DefaultTableModel();
    private DefaultTableModel tabModelSearch = new DefaultTableModel();
    private EmployeService employeService = new EmployeService();
    private CustomerService customerService = new CustomerService();
    private CatalogService catalogService = new CatalogService();
    private AppreciationService appreciationService = new AppreciationService();
    private Utility utils = new Utility();
    private Vector comments = new Vector();
    private Vector oldComments = new Vector();
    

    public JPanelFormAppreciations() throws ObjectNotFoundException {
        initComponents();
        initColumnWaiting();
        initTabWaiting();
        initColumnSearch();
        jComboBoxStatus.setModel(initStatusByModel());
        jComboBoxSearchBy.setModel(initSearchByModel());
        initTabListener();
    }
    
    //___________SEARCH-BY COMBOBOX MODEL_______________//
    private DefaultComboBoxModel initSearchByModel() {
        return new DefaultComboBoxModel(initSearchVector());
    }
    private Vector initSearchVector() {
        Vector searchList = new Vector();
        searchList.add("Title");
        searchList.add("Customer");
        searchList.add("Moderator");
        return searchList;
    }    
    //______APPRECIATIONS-STATUS COMBOBOX MODEL____________//
    private DefaultComboBoxModel initStatusByModel() {
        return new DefaultComboBoxModel(initStatusVector());
    }
    private Vector initStatusVector() {
        Vector searchList = new Vector();
        searchList.add("Approved");
        searchList.add("Refused");
        return searchList;
    }    
    //___________SelectedSearch COMBOBOX MODEL_______________//
    private DefaultComboBoxModel initSelectedModel(Vector queryList) {
        return new DefaultComboBoxModel(initSeLectedVector(queryList));
    }
    private Vector initSeLectedVector(Vector queryList) {
        return queryList;
    }
    //___________WAITING TABLEAU MODEL_______________________//
    private void initColumnWaiting() {
        tabModelWait.addColumn("DATE");
        tabModelWait.addColumn("TITLE");
        tabModelWait.addColumn("CUSTOMER");
        tabModelWait.addColumn("COMMENT");
        tabModelWait.addColumn("RATE /5");
        tabModelWait.addColumn("IP CUSTOMER");
    }
    private void initTabWaiting() throws ObjectNotFoundException {
        toTab(appreciationService.findWaitingAppreciate(), comments, tabModelWait, 1);
        jTableWaiting.setModel(tabModelWait);
    }
    //___________SEARCH TABLEAU MODEL_______________________//
    private void initColumnSearch() {
        tabModelSearch.addColumn("STATUS");
        tabModelSearch.addColumn("DATE");
        tabModelSearch.addColumn("MODERATOR");
        tabModelSearch.addColumn("TITLE");
        tabModelSearch.addColumn("CUSTOMER");
        tabModelSearch.addColumn("COMMENT");
        tabModelSearch.addColumn("RATE /5");
        tabModelSearch.addColumn("IP CUSTOMER");
    }
    private void initTabSearch(Collection queryList) throws ObjectNotFoundException {
        refreshTabSearch();
        toTab(queryList, oldComments, tabModelSearch, 2);
        jTableView.setModel(tabModelSearch);
    }
    //______________________________________________________//
    
    private void toTab(Collection queryList, Vector list, DefaultTableModel model, int type) throws ObjectNotFoundException {
        Vector rowAttributes = null;
        for (Iterator it = queryList.iterator(); it.hasNext();) {
            Appreciation comment = (Appreciation) it.next();
            rowAttributes = new Vector();
            if (type == 2) {
                if (comment.getStatusAppreciate() == 40) {
                    rowAttributes.add("Approved");
                } else if (comment.getStatusAppreciate() == 41) {
                    rowAttributes.add("Refused");
                } else {
                    rowAttributes.add("Untreated");
                }
            }
            rowAttributes.add(comment.getDateAppreciate());
            if (type == 2) {
                rowAttributes.add(comment.getLoginEmployeAppreciate().getLoginEmploye());
            }
            Book book = catalogService.FindBookByChamp("NUMISBNBOOK", comment.getNumIsbnBookAppreciate());
            rowAttributes.add(book.getTitleBook());
            rowAttributes.add(comment.getLoginCustomerAppreciate().getLoginCustomer());
            rowAttributes.add(comment.getCommentAppreciate());
            rowAttributes.add(comment.getRatingAppreciate());
            rowAttributes.add(comment.getIpAppreciate());
            list.add(comment);
            model.addRow(rowAttributes);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackgroundAppreciation = new javax.swing.JPanel();
        jPanelSearchBook = new javax.swing.JPanel();
        jLabelTitleISBN = new javax.swing.JLabel();
        jPanelSearchAppreciation = new javax.swing.JPanel();
        jScrollPaneShowAppreciations = new javax.swing.JScrollPane();
        jTableView = new javax.swing.JTable();
        jButtonClear = new javax.swing.JButton();
        jComboBoxSearchBy = new javax.swing.JComboBox<String>();
        jButton1 = new javax.swing.JButton();
        jComboBoxSelected = new javax.swing.JComboBox<String>();
        jPanelTraitment = new javax.swing.JPanel();
        jScrollPaneAppreciationsWaiting = new javax.swing.JScrollPane();
        jTableWaiting = new javax.swing.JTable();
        jPanelManager = new javax.swing.JPanel();
        jComboBoxStatus = new javax.swing.JComboBox<String>();
        jButtonSetStatus = new javax.swing.JButton();
        jLabelAppreciationStatus = new javax.swing.JLabel();
        jLabelAppreciation = new javax.swing.JLabel();
        jLabelCustomerLogin = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jTextDate = new javax.swing.JLabel();
        jLabelIp = new javax.swing.JLabel();
        jTextIp = new javax.swing.JLabel();
        jLabelDate1 = new javax.swing.JLabel();
        jTextModerator = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextComment = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jTextid = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanelBackgroundAppreciation.setLayout(new java.awt.BorderLayout());

        jPanelSearchBook.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Book's Appreciations"));

        jLabelTitleISBN.setText("Search by  : ");

        jPanelSearchAppreciation.setBorder(javax.swing.BorderFactory.createTitledBorder("Appreciations"));

        jTableView.setAutoCreateRowSorter(true);
        jTableView.setModel(tabModelSearch);
        jScrollPaneShowAppreciations.setViewportView(jTableView);

        javax.swing.GroupLayout jPanelSearchAppreciationLayout = new javax.swing.GroupLayout(jPanelSearchAppreciation);
        jPanelSearchAppreciation.setLayout(jPanelSearchAppreciationLayout);
        jPanelSearchAppreciationLayout.setHorizontalGroup(
            jPanelSearchAppreciationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneShowAppreciations, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        jPanelSearchAppreciationLayout.setVerticalGroup(
            jPanelSearchAppreciationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchAppreciationLayout.createSequentialGroup()
                .addComponent(jScrollPaneShowAppreciations, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonClear.setText("clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jComboBoxSearchBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSearchBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSearchByActionPerformed(evt);
            }
        });

        jButton1.setText("View All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxSelected.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxSelectedMouseClicked(evt);
            }
        });
        jComboBoxSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSearchBookLayout = new javax.swing.GroupLayout(jPanelSearchBook);
        jPanelSearchBook.setLayout(jPanelSearchBookLayout);
        jPanelSearchBookLayout.setHorizontalGroup(
            jPanelSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchBookLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelTitleISBN)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jComboBoxSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(75, 75, 75)
                .addComponent(jButtonClear)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchBookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSearchAppreciation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelSearchBookLayout.setVerticalGroup(
            jPanelSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchBookLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelSearchBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitleISBN)
                    .addComponent(jButtonClear)
                    .addComponent(jComboBoxSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jComboBoxSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanelSearchAppreciation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelBackgroundAppreciation.add(jPanelSearchBook, java.awt.BorderLayout.CENTER);

        jPanelTraitment.setBorder(javax.swing.BorderFactory.createTitledBorder("Appreciations waiting for Traitment"));

        jTableWaiting.setAutoCreateRowSorter(true);
        jTableWaiting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idAppreciate", "ISBN ", "loginCustomer", "Appreciation"
            }
        ));
        jScrollPaneAppreciationsWaiting.setViewportView(jTableWaiting);

        javax.swing.GroupLayout jPanelTraitmentLayout = new javax.swing.GroupLayout(jPanelTraitment);
        jPanelTraitment.setLayout(jPanelTraitmentLayout);
        jPanelTraitmentLayout.setHorizontalGroup(
            jPanelTraitmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTraitmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneAppreciationsWaiting, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTraitmentLayout.setVerticalGroup(
            jPanelTraitmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTraitmentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneAppreciationsWaiting, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelBackgroundAppreciation.add(jPanelTraitment, java.awt.BorderLayout.PAGE_START);

        jPanelManager.setBorder(javax.swing.BorderFactory.createTitledBorder("Apreciations Management"));

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Approved", " ", "Item 3", "Item 4" }));

        jButtonSetStatus.setText("Set");
        jButtonSetStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetStatusActionPerformed(evt);
            }
        });

        jLabelAppreciationStatus.setText(" Appreciation Status  :");

        jLabelAppreciation.setText("Appreciation :");

        jLabelCustomerLogin.setText("Customer Login  :");

        jLabelDate.setText("Date  :");

        jLabelIp.setText("Customer IP   :");

        jLabelDate1.setText("Moderator  :");

        jScrollPane2.setViewportView(jTextComment);

        jLabel1.setText("Comment id :");

        javax.swing.GroupLayout jPanelManagerLayout = new javax.swing.GroupLayout(jPanelManager);
        jPanelManager.setLayout(jPanelManagerLayout);
        jPanelManagerLayout.setHorizontalGroup(
            jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelManagerLayout.createSequentialGroup()
                        .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelManagerLayout.createSequentialGroup()
                                .addComponent(jLabelIp)
                                .addGap(18, 18, 18)
                                .addComponent(jTextIp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelManagerLayout.createSequentialGroup()
                                .addComponent(jLabelCustomerLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelManagerLayout.createSequentialGroup()
                                .addComponent(jLabelDate1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextModerator, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelManagerLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextid, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelManagerLayout.createSequentialGroup()
                                .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelManagerLayout.createSequentialGroup()
                        .addComponent(jLabelAppreciationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSetStatus)
                        .addGap(51, 51, 51)
                        .addComponent(jLabelAppreciation)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelManagerLayout.setVerticalGroup(
            jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelManagerLayout.createSequentialGroup()
                        .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAppreciationStatus)
                            .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSetStatus)
                            .addComponent(jLabelAppreciation))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelCustomerLogin)
                                .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextid, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelManagerLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelIp)
                                    .addComponent(jTextIp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelManagerLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanelManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextModerator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBackgroundAppreciation.add(jPanelManager, java.awt.BorderLayout.PAGE_END);

        add(jPanelBackgroundAppreciation, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSetStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetStatusActionPerformed
        LoginPage loggs = new LoginPage();
        if ("Moderator".equals(loggs.getEmployeLoged().getEmployeRight().toString()) || "Admin".equals(loggs.getEmployeLoged().getEmployeRight().toString())) {
            Appreciation comment = null;
            try {
                comment = appreciationService.findAppreciation(jTextid.getText());
            } catch (FinderException ex) {
                Logger.getLogger(JPanelFormAppreciations.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CheckException ex) {
                Logger.getLogger(JPanelFormAppreciations.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (jComboBoxStatus.getSelectedItem().equals("Approved")) {
                comment.setStatusAppreciate(40);
            } else {
                comment.setStatusAppreciate(41);
            }
            comment.setLoginEmployeAppreciate(loggs.getEmployeLoged());
            comment.setModerateAppreciate("1");
            try {
                appreciationService.updateAppreciation(comment);
                JOptionPane.showMessageDialog(this, "Commment ID : " + comment.getId() + " moderate successfully ! ");
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "ERROR MODERATING COMMENT");
            }
            try {
                refreshTabWaiting();
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "NO MORE COMMENTS TO MODERATE ");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Your are not a moderator !");
        }
    }//GEN-LAST:event_jButtonSetStatusActionPerformed
    private void jComboBoxSelectedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSelectedMouseClicked

    }//GEN-LAST:event_jComboBoxSelectedMouseClicked
    public void initComboToCombo(String holder, Collection queryList, Class obj) {
        if (jComboBoxSearchBy.getSelectedItem().equals(holder)) {
            Vector list = new Vector();
            for (Iterator it = queryList.iterator(); it.hasNext();) {
                list.add(obj.cast(it.next()));
            }
            jComboBoxSelected.setModel(initSelectedModel(list));
        }
    }
    public JPanelFormAppreciations(JButton jButton1, JButton jButtonClear, JButton jButtonSearchBook, JButton jButtonSetStatus, JComboBox<String> jComboBoxSearchBy, JComboBox<String> jComboBoxSelected, JComboBox<String> jComboBoxStatus, JLabel jLabelAppreciation, JLabel jLabelAppreciationStatus, JLabel jLabelCustomerLogin, JLabel jLabelDate, JLabel jLabelDate1, JLabel jLabelIp, JLabel jLabelLogin, JLabel jLabelTitleISBN, JPanel jPanelBackgroundAppreciation, JPanel jPanelManager, JPanel jPanelSearchAppreciation, JPanel jPanelSearchBook, JPanel jPanelTraitment, JScrollPane jScrollPane2, JScrollPane jScrollPaneAppreciationsWaiting, JScrollPane jScrollPaneShowAppreciations, JTable jTableView, JTable jTableWaiting, JTextPane jTextComment, JLabel jTextDate, JLabel jTextIp, JLabel jTextModerator, JTextField jTextTitleISBN) {
        this.jButton1 = jButton1;
        this.jButtonClear = jButtonClear;
        this.jButtonSetStatus = jButtonSetStatus;
        this.jComboBoxSearchBy = jComboBoxSearchBy;
        this.jComboBoxSelected = jComboBoxSelected;
        this.jComboBoxStatus = jComboBoxStatus;
        this.jLabelAppreciation = jLabelAppreciation;
        this.jLabelAppreciationStatus = jLabelAppreciationStatus;
        this.jLabelCustomerLogin = jLabelCustomerLogin;
        this.jLabelDate = jLabelDate;
        this.jLabelDate1 = jLabelDate1;
        this.jLabelIp = jLabelIp;
        this.jLabelLogin = jLabelLogin;
        this.jLabelTitleISBN = jLabelTitleISBN;
        this.jPanelBackgroundAppreciation = jPanelBackgroundAppreciation;
        this.jPanelManager = jPanelManager;
        this.jPanelSearchAppreciation = jPanelSearchAppreciation;
        this.jPanelSearchBook = jPanelSearchBook;
        this.jPanelTraitment = jPanelTraitment;
        this.jScrollPane2 = jScrollPane2;
        this.jScrollPaneAppreciationsWaiting = jScrollPaneAppreciationsWaiting;
        this.jScrollPaneShowAppreciations = jScrollPaneShowAppreciations;
        this.jTableView = jTableView;
        this.jTableWaiting = jTableWaiting;
        this.jTextComment = jTextComment;
        this.jTextDate = jTextDate;
        this.jTextIp = jTextIp;
        this.jTextModerator = jTextModerator;
    }
    private void jComboBoxSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectedActionPerformed
        if (jComboBoxSearchBy.getSelectedItem().equals("Title")) {
            Book book = (Book) jComboBoxSelected.getSelectedItem();
            try {
                initTabSearch(appreciationService.FindAppreciationByChamp("TITREBOOK", book.getTitleBook()));
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "NO COMMENT FOUND FOR THIS BOOK");
            }
        }
        if (jComboBoxSearchBy.getSelectedItem().equals("Customer")) {
            Customer customer = (Customer) jComboBoxSelected.getSelectedItem();
            try {
                initTabSearch(appreciationService.FindAppreciationByChamp("LOGINCUSTOMERAPPRECIATE", customer.getLoginCustomer()));
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "NO COMMENT FOUND FOR THIS CUSTOMER");
            }
        }
        if (jComboBoxSearchBy.getSelectedItem().equals("Moderator")) {
            Employe employe = (Employe) jComboBoxSelected.getSelectedItem();
            try {
                initTabSearch(appreciationService.FindAppreciationByEmployee("LOGINEMPLOYEAPPRECIATE", employe.getLoginEmploye()));
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "NO COMMENT FOUND FOR THIS EMPLOYE");
            }
        }
    }//GEN-LAST:event_jComboBoxSelectedActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            initTabSearch(appreciationService.findAppreciation());
        } catch (FinderException ex) {
            JOptionPane.showMessageDialog(this, "DATABASE ERROR NO APPRECIATIONS FOUND FOR ANY BOOKS");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        try {
            refreshTabSearch();
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "DATABASE ERROR NO APPRECIATIONS FOUND FOR ANY BOOKS");
        }
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jComboBoxSearchByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchByActionPerformed
        try {
            initComboToCombo("Title", catalogService.FindAllBooks(), Book.class);
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, " NO BOOKS FOUND ");
        }
          try {
            initComboToCombo("Moderator", employeService.FindEmployeByRight("IDEMPLOYERIGHT", "MODERATOR"), Employe.class);
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, " NO MODERATORS FOUNDS ");
        }
          try {
            initComboToCombo("Customer",customerService.findCustomers(), Customer.class);
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, " NO MODERATORS FOUNDS ");
        } catch (FinderException ex) {
            Logger.getLogger(JPanelFormAppreciations.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }//GEN-LAST:event_jComboBoxSearchByActionPerformed
    private void initTabListener(){
         jTableWaiting.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                selectLineWaiting(evt);
            }
        });
        jTableView.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                selectLineSearch(evt);
            }
        });
    }
    private void selectLineWaiting(ListSelectionEvent evt) {
        ListSelectionModel lsm = (ListSelectionModel) evt.getSource();
        if (lsm.isSelectionEmpty()) {
            System.out.println("No rows selected");
        } else {
            int selectedRow = lsm.getMinSelectionIndex();
            Appreciation comment = (Appreciation) comments.get(selectedRow);
            toField(comment);
        }
    }
    private void selectLineSearch(ListSelectionEvent evt) {
        ListSelectionModel lsm = (ListSelectionModel) evt.getSource();
        if (lsm.isSelectionEmpty()) {
            System.out.println("No rows selected");
        } else {
            int selectedRow = lsm.getMinSelectionIndex();
            Appreciation comment = (Appreciation) oldComments.get(selectedRow);
            toField(comment);
        }
    }
    private void toField(Appreciation comment) {
        jTextComment.setText(comment.getCommentAppreciate());
        jLabelLogin.setText(comment.getLoginCustomerAppreciate().getLoginCustomer());
        jTextDate.setText(comment.getDateAppreciate());
        jTextIp.setText(comment.getIpAppreciate());
        jTextModerator.setText(comment.getLoginEmployeAppreciate().getLoginEmploye());
        jTextid.setText(comment.getIdAppreciate());
        if (comment.getStatusAppreciate() == 40) {
            jComboBoxStatus.getModel().setSelectedItem("Approved");
        } else if (comment.getStatusAppreciate() == 41) {
            jComboBoxStatus.getModel().setSelectedItem("Rejected");
        } else {
            jComboBoxStatus.getModel().setSelectedItem("Untreated");
        }
    }
    private void refreshTabWaiting() throws ObjectNotFoundException {
        comments.removeAllElements();
        int lignes = tabModelWait.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            tabModelWait.removeRow(i);
        }
        initTabWaiting();
    }
    private void refreshTabSearch() throws ObjectNotFoundException {
        int lignes = tabModelSearch.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            tabModelSearch.removeRow(i);
        }
        oldComments.removeAllElements();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSetStatus;
    private javax.swing.JComboBox<String> jComboBoxSearchBy;
    private javax.swing.JComboBox<String> jComboBoxSelected;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAppreciation;
    private javax.swing.JLabel jLabelAppreciationStatus;
    private javax.swing.JLabel jLabelCustomerLogin;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDate1;
    private javax.swing.JLabel jLabelIp;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelTitleISBN;
    private javax.swing.JPanel jPanelBackgroundAppreciation;
    private javax.swing.JPanel jPanelManager;
    private javax.swing.JPanel jPanelSearchAppreciation;
    private javax.swing.JPanel jPanelSearchBook;
    private javax.swing.JPanel jPanelTraitment;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneAppreciationsWaiting;
    private javax.swing.JScrollPane jScrollPaneShowAppreciations;
    private javax.swing.JTable jTableView;
    private javax.swing.JTable jTableWaiting;
    private javax.swing.JTextPane jTextComment;
    private javax.swing.JLabel jTextDate;
    private javax.swing.JLabel jTextIp;
    private javax.swing.JLabel jTextModerator;
    private javax.swing.JLabel jTextid;
    // End of variables declaration//GEN-END:variables
}
