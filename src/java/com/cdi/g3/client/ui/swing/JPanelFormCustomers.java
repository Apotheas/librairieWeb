/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.client.ui.swing;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.customers.Adress;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.service.customers.AdressService;
import com.cdi.g3.server.service.customers.CustomerService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Apotheas
 */
public class JPanelFormCustomers extends javax.swing.JPanel {

    //public class JPanelFormCustomers extends  JDesktopPane{
    CustomerService serviceCustomer = new CustomerService();
    DefaultComboBoxModel myModelAdressShip = new DefaultComboBoxModel();
    DefaultComboBoxModel myModelAdressBill = new DefaultComboBoxModel();
    DefaultTableModel myModelCustomers = new DefaultTableModel();
    Vector adressBillList = new Vector();
    Vector adressShipList = new Vector();
    Vector customersVector = new Vector();
    Vector statusCustomersVector = new Vector();

    DateFormat df = new SimpleDateFormat("dd-MM-YYYY");

    public JDialog getjDialogAddAdressBill() {
        return jDialogAddAdressShip;
    }

    public DefaultComboBoxModel getMyModelAdress(Collection adresses) {
       return   initAdressShipComboBoxModel(adresses);
    }

    public JDialog getjDialogAddAdressShip() {
        return jDialogAddAdressBill;
    }

    public Vector getCustomersVector() {
        return customersVector;
    }
    

    /**
     * Creates new form Accounts
     */
    public JPanelFormCustomers() {
        initComponents();
        jTableCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//        jTableCustomers1.setAutoCreateRowSorter(true);
        jTableCustomers.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                selectLineTableCustomerActionPerformed(evt);
            }
        });

        jPanelShippingAdress1.setVisible(false);
        jPanelBillingAdress.setVisible(false);        
        jPanelCustomer.setVisible(false);
        jPanelAdress.setVisible(false);
        jPanelShippingAdress1.setVisible(false);
        jPanelBillingAdress.setVisible(false);
        
//        this.jTableCustomers.getColumn("lOGIN").(false);
        

        chargeComboBoxCustomers();
        chargeComboBoxStatusCustomers();
        jComboBoxStatus.setModel(initStatusCustomersComboBoxModel(statusCustomersVector));
        jTableCustomers.setModel(initCustomersTableModel(customersVector));
        jRadioButtonBill.setVisible(false);
        jRadioButtonShip.setVisible(false);
        
        jTextIdAdress.setEnabled(false);
        
        
        
        
//        jComboBoxCustomers.setSelectedIndex(-1);
//        jComboBoxShip.setModel(initComboAdressShipModel(adressShipList));
//        jComboBoxBill.setModel(initComboAdressBillModel(adressBillList));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAddAdressShip = new javax.swing.JDialog();
        jPanelShippingAdress1 = new javax.swing.JPanel();
        jLabeNameReceiverAdressShipp1 = new javax.swing.JLabel();
        jTextNameReceiverAdressShipp = new javax.swing.JTextField();
        jLabelStreetShipp1 = new javax.swing.JLabel();
        jLabelZipCodeShipp1 = new javax.swing.JLabel();
        jLabelCityShipp1 = new javax.swing.JLabel();
        jTextStreetShipp = new javax.swing.JTextField();
        jTextCityShipp = new javax.swing.JTextField();
        jTextZipCodeShipp = new javax.swing.JTextField();
        jTextNumStreetShipp = new javax.swing.JTextField();
        jLabelNumStreetShipp1 = new javax.swing.JLabel();
        jTextStreet2Shipp = new javax.swing.JTextField();
        jLabelStreet2Shipp1 = new javax.swing.JLabel();
        jTextCountryShipp = new javax.swing.JTextField();
        jLabelCountryShipp1 = new javax.swing.JLabel();
        jTextIdAdressShipp = new javax.swing.JTextField();
        jLabelIdAdressShipp1 = new javax.swing.JLabel();
        jButtonSendAdressShip = new javax.swing.JButton();
        jDialogAddAdressBill = new javax.swing.JDialog();
        jPanelBillingAdress = new javax.swing.JPanel();
        jLabelZipCodeBill1 = new javax.swing.JLabel();
        jTextCityBill = new javax.swing.JTextField();
        jLabelNameReceiverAdressBill1 = new javax.swing.JLabel();
        jTextIdAdressBill = new javax.swing.JTextField();
        jTextNameReceiverAdressBill = new javax.swing.JTextField();
        jTextZipCodeBill = new javax.swing.JTextField();
        jLabelStreetBill1 = new javax.swing.JLabel();
        jLabelIdAdressBill1 = new javax.swing.JLabel();
        jTextStreetBill = new javax.swing.JTextField();
        jLabelCityBill1 = new javax.swing.JLabel();
        jTextNumStreetBill = new javax.swing.JTextField();
        jLabelNumStreetBill1 = new javax.swing.JLabel();
        jTextCountryBill = new javax.swing.JTextField();
        jLabelCountryBill1 = new javax.swing.JLabel();
        jTextStreet2Bill = new javax.swing.JTextField();
        jLabelStreet2Bill1 = new javax.swing.JLabel();
        jButtonSendAdressBill = new javax.swing.JButton();
        buttonGroupAdress = new javax.swing.ButtonGroup();
        jPanelAccounts = new javax.swing.JPanel();
        jTabbedPaneManageAccount = new javax.swing.JTabbedPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxCustomers = new javax.swing.JComboBox();
        jComboBoxSearchCustomer = new javax.swing.JComboBox();
        jLabelSearch1 = new javax.swing.JLabel();
        jTextSearchCustomer = new javax.swing.JTextField();
        jButtonSearchCustomer = new javax.swing.JButton();
        AddCustomer = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCustomers = new javax.swing.JTable();
        jPanelCustomer = new javax.swing.JPanel();
        jComboBoxStatus = new javax.swing.JComboBox<String>();
        jLabelStatus1 = new javax.swing.JLabel();
        jTextPassword = new javax.swing.JTextField();
        jLabelPassword1 = new javax.swing.JLabel();
        jTextCompany = new javax.swing.JTextField();
        jLabelCompany1 = new javax.swing.JLabel();
        jLabelLogin1 = new javax.swing.JLabel();
        jLabelEmail1 = new javax.swing.JLabel();
        jTextLogin = new javax.swing.JTextField();
        jLabelFirstName1 = new javax.swing.JLabel();
        jTextLastName = new javax.swing.JTextField();
        jLabelLastName1 = new javax.swing.JLabel();
        jButtonCreateCustomer = new javax.swing.JButton();
        jComboBoxShip = new javax.swing.JComboBox();
        jComboBoxBill = new javax.swing.JComboBox();
        jButtonAdressShipping = new javax.swing.JButton();
        jButtonAdressBilling = new javax.swing.JButton();
        jTextEmail = new javax.swing.JTextField();
        jTextFirstName = new javax.swing.JTextField();
        jButtonUpdateCustomer = new javax.swing.JButton();
        jRadioButtonShip = new javax.swing.JRadioButton();
        jRadioButtonBill = new javax.swing.JRadioButton();
        jPanelAdress = new javax.swing.JPanel();
        jLabeNameReceiverAdressShipp2 = new javax.swing.JLabel();
        jTextNameReceiverAdress = new javax.swing.JTextField();
        jLabelStreetShipp2 = new javax.swing.JLabel();
        jLabelZipCodeShipp2 = new javax.swing.JLabel();
        jLabelCityShipp2 = new javax.swing.JLabel();
        jTextStreet = new javax.swing.JTextField();
        jTextCity = new javax.swing.JTextField();
        jTextZipCode = new javax.swing.JTextField();
        jTextNumStreet = new javax.swing.JTextField();
        jLabelNumStreetShipp2 = new javax.swing.JLabel();
        jTextStreet2 = new javax.swing.JTextField();
        jLabelStreet2Shipp2 = new javax.swing.JLabel();
        jTextCountry = new javax.swing.JTextField();
        jLabelCountryShipp2 = new javax.swing.JLabel();
        jLabelIdAdressShipp2 = new javax.swing.JLabel();
        jButtonCreateAdressBill = new javax.swing.JButton();
        jButtonCreateAdressShip = new javax.swing.JButton();
        jButtonUpdateAdressBill = new javax.swing.JButton();
        jButtonUptateAdressShip = new javax.swing.JButton();
        jTextIdAdress = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPaneTree1 = new javax.swing.JScrollPane();
        jTreeCustomers = new javax.swing.JTree();

        jPanelShippingAdress1.setBorder(javax.swing.BorderFactory.createTitledBorder("Shipping adress"));

        jLabeNameReceiverAdressShipp1.setText("Last Name  :");

        jLabelStreetShipp1.setText("Street   :");

        jLabelZipCodeShipp1.setText("Zip Code  :");

        jLabelCityShipp1.setText("City  :");

        jTextZipCodeShipp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextZipCodeShippActionPerformed(evt);
            }
        });

        jLabelNumStreetShipp1.setText("Num Street   :");

        jLabelStreet2Shipp1.setText("Street2");

        jLabelCountryShipp1.setText("Country");

        jLabelIdAdressShipp1.setText("Id Adress Ship");

        jButtonSendAdressShip.setText("Send ");
        jButtonSendAdressShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendAdressShipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelShippingAdress1Layout = new javax.swing.GroupLayout(jPanelShippingAdress1);
        jPanelShippingAdress1.setLayout(jPanelShippingAdress1Layout);
        jPanelShippingAdress1Layout.setHorizontalGroup(
            jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShippingAdress1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelShippingAdress1Layout.createSequentialGroup()
                        .addComponent(jLabeNameReceiverAdressShipp1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextNameReceiverAdressShipp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelShippingAdress1Layout.createSequentialGroup()
                        .addComponent(jLabelNumStreetShipp1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextNumStreetShipp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelShippingAdress1Layout.createSequentialGroup()
                        .addComponent(jLabelStreetShipp1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextStreetShipp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelShippingAdress1Layout.createSequentialGroup()
                        .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelZipCodeShipp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelStreet2Shipp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextStreet2Shipp, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jTextZipCodeShipp)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelShippingAdress1Layout.createSequentialGroup()
                        .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCityShipp1)
                            .addComponent(jLabelCountryShipp1)
                            .addComponent(jLabelIdAdressShipp1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextIdAdressShipp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextCountryShipp, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(jTextCityShipp))))
                    .addGroup(jPanelShippingAdress1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSendAdressShip))))
        );
        jPanelShippingAdress1Layout.setVerticalGroup(
            jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShippingAdress1Layout.createSequentialGroup()
                .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeNameReceiverAdressShipp1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNameReceiverAdressShipp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumStreetShipp1)
                    .addComponent(jTextNumStreetShipp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStreetShipp1)
                    .addComponent(jTextStreetShipp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextStreet2Shipp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStreet2Shipp1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextZipCodeShipp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelZipCodeShipp1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCityShipp1)
                    .addComponent(jTextCityShipp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCountryShipp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCountryShipp1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelShippingAdress1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextIdAdressShipp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdAdressShipp1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSendAdressShip)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogAddAdressShip.getContentPane().add(jPanelShippingAdress1, java.awt.BorderLayout.CENTER);

        jPanelBillingAdress.setBorder(javax.swing.BorderFactory.createTitledBorder("Billing adress"));

        jLabelZipCodeBill1.setText("Zip Code  :");

        jLabelNameReceiverAdressBill1.setText("Last Name  :");

        jTextZipCodeBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextZipCodeBillActionPerformed(evt);
            }
        });

        jLabelStreetBill1.setText("Street   :");

        jLabelIdAdressBill1.setText("Id Adress Bill");

        jLabelCityBill1.setText("City  :");

        jLabelNumStreetBill1.setText("Num Street   :");

        jLabelCountryBill1.setText("Country");

        jLabelStreet2Bill1.setText("Street2");

        jButtonSendAdressBill.setText("send");
        jButtonSendAdressBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendAdressBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBillingAdressLayout = new javax.swing.GroupLayout(jPanelBillingAdress);
        jPanelBillingAdress.setLayout(jPanelBillingAdressLayout);
        jPanelBillingAdressLayout.setHorizontalGroup(
            jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBillingAdressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBillingAdressLayout.createSequentialGroup()
                        .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNameReceiverAdressBill1)
                            .addComponent(jLabelNumStreetBill1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextNumStreetBill)
                            .addComponent(jTextNameReceiverAdressBill, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                    .addGroup(jPanelBillingAdressLayout.createSequentialGroup()
                        .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdAdressBill1)
                            .addComponent(jLabelCountryBill1)
                            .addComponent(jLabelCityBill1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCountryBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCityBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextIdAdressBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBillingAdressLayout.createSequentialGroup()
                        .addComponent(jLabelStreetBill1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextStreetBill, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBillingAdressLayout.createSequentialGroup()
                        .addComponent(jLabelStreet2Bill1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextStreet2Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBillingAdressLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSendAdressBill))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBillingAdressLayout.createSequentialGroup()
                        .addComponent(jLabelZipCodeBill1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextZipCodeBill, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelBillingAdressLayout.setVerticalGroup(
            jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBillingAdressLayout.createSequentialGroup()
                .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNameReceiverAdressBill1)
                    .addComponent(jTextNameReceiverAdressBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextNumStreetBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumStreetBill1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(11, 11, 11)
                .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextStreetBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStreetBill1))
                .addGap(9, 9, 9)
                .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextStreet2Bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStreet2Bill1))
                .addGap(7, 7, 7)
                .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextZipCodeBill, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelZipCodeBill1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCityBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCityBill1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCountryBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCountryBill1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBillingAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextIdAdressBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdAdressBill1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSendAdressBill)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogAddAdressBill.getContentPane().add(jPanelBillingAdress, java.awt.BorderLayout.CENTER);

        setLayout(new java.awt.BorderLayout());

        jComboBoxCustomers.setModel(initAdressBillComboBoxModel(customersVector));
        jComboBoxCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxCustomersMouseEntered(evt);
            }
        });
        jComboBoxCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCustomersActionPerformed(evt);
            }
        });

        jComboBoxSearchCustomer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pseudo", "Email" }));

        jLabelSearch1.setText("search by pseudo/email  :");

        jButtonSearchCustomer.setText("search");
        jButtonSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchCustomerActionPerformed(evt);
            }
        });

        AddCustomer.setText("AddCustomer");
        AddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustomerActionPerformed(evt);
            }
        });

        jTableCustomers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableCustomers);

        jPanelCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 14), new java.awt.Color(153, 153, 255))); // NOI18N

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Inactive", "BlackList" }));
        jComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatusActionPerformed(evt);
            }
        });

        jLabelStatus1.setText("Status  :");

        jTextPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPasswordActionPerformed(evt);
            }
        });

        jLabelPassword1.setText("Password  :");

        jTextCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCompanyActionPerformed(evt);
            }
        });

        jLabelCompany1.setText("Company  : ");

        jLabelLogin1.setText("Login  :");

        jLabelEmail1.setText("Email  :");

        jTextLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLoginActionPerformed(evt);
            }
        });

        jLabelFirstName1.setText("First name :");

        jLabelLastName1.setText("Last  name :");

        jButtonCreateCustomer.setText("Create Customer");
        jButtonCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateCustomerActionPerformed(evt);
            }
        });

        jComboBoxShip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxShipActionPerformed(evt);
            }
        });

        jComboBoxBill.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBillActionPerformed(evt);
            }
        });

        jButtonAdressShipping.setText("Add AdressChipping");
        jButtonAdressShipping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdressShippingActionPerformed(evt);
            }
        });

        jButtonAdressBilling.setText("Add AdressBilling");
        jButtonAdressBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdressBillingActionPerformed(evt);
            }
        });

        jTextEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailActionPerformed(evt);
            }
        });

        jButtonUpdateCustomer.setText("Update Customer");
        jButtonUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateCustomerActionPerformed(evt);
            }
        });

        buttonGroupAdress.add(jRadioButtonShip);
        jRadioButtonShip.setText("Adress Ship");

        buttonGroupAdress.add(jRadioButtonBill);
        jRadioButtonBill.setText("Adress Bill");

        javax.swing.GroupLayout jPanelCustomerLayout = new javax.swing.GroupLayout(jPanelCustomer);
        jPanelCustomer.setLayout(jPanelCustomerLayout);
        jPanelCustomerLayout.setHorizontalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCustomerLayout.createSequentialGroup()
                        .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLastName1)
                            .addGroup(jPanelCustomerLayout.createSequentialGroup()
                                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelFirstName1)
                                    .addComponent(jLabelLogin1))
                                .addGap(26, 26, 26)
                                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelCustomerLayout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelCustomerLayout.createSequentialGroup()
                                            .addComponent(jLabelPassword1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelCustomerLayout.createSequentialGroup()
                                            .addComponent(jLabelStatus1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustomerLayout.createSequentialGroup()
                                    .addComponent(jLabelCompany1)
                                    .addGap(33, 33, 33)
                                    .addComponent(jTextCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelCustomerLayout.createSequentialGroup()
                                .addComponent(jButtonAdressBilling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxBill, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCustomerLayout.createSequentialGroup()
                                .addComponent(jButtonAdressShipping)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(jComboBoxShip, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelCustomerLayout.createSequentialGroup()
                        .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCreateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jRadioButtonShip)
                        .addGap(10, 10, 10)
                        .addComponent(jRadioButtonBill)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );
        jPanelCustomerLayout.setVerticalGroup(
            jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomerLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin1)
                    .addComponent(jLabelStatus1)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword1)
                    .addComponent(jLabelEmail1)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCompany1)
                    .addComponent(jLabelFirstName1)
                    .addComponent(jTextFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAdressShipping))
                    .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextLastName)
                        .addComponent(jLabelLastName1)))
                .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCustomerLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButtonCreateCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateCustomer))
                    .addGroup(jPanelCustomerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdressBilling))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonShip)
                            .addComponent(jRadioButtonBill))
                        .addContainerGap())))
        );

        jPanelAdress.setBorder(javax.swing.BorderFactory.createTitledBorder("Adress"));

        jLabeNameReceiverAdressShipp2.setText("Last Name  :");

        jLabelStreetShipp2.setText("Street   :");

        jLabelZipCodeShipp2.setText("Zip Code  :");

        jLabelCityShipp2.setText("City  :");

        jTextZipCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextZipCodeActionPerformed(evt);
            }
        });

        jLabelNumStreetShipp2.setText("Num Street   :");

        jLabelStreet2Shipp2.setText("Street2");

        jLabelCountryShipp2.setText("Country");

        jLabelIdAdressShipp2.setText("Id Adress Ship");

        jButtonCreateAdressBill.setText("Create Adress Bill");
        jButtonCreateAdressBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateAdressBillActionPerformed(evt);
            }
        });

        jButtonCreateAdressShip.setText("Create Adress Ship");
        jButtonCreateAdressShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateAdressShipActionPerformed(evt);
            }
        });

        jButtonUpdateAdressBill.setText("Uptade Adress Bill");
        jButtonUpdateAdressBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateAdressBillActionPerformed(evt);
            }
        });

        jButtonUptateAdressShip.setText("Update Adress Ship");
        jButtonUptateAdressShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUptateAdressShipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdressLayout = new javax.swing.GroupLayout(jPanelAdress);
        jPanelAdress.setLayout(jPanelAdressLayout);
        jPanelAdressLayout.setHorizontalGroup(
            jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdressLayout.createSequentialGroup()
                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUpdateAdressBill, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUptateAdressShip)
                    .addGroup(jPanelAdressLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelAdressLayout.createSequentialGroup()
                                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStreet2Shipp2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabeNameReceiverAdressShipp2)
                                    .addComponent(jLabelNumStreetShipp2))
                                .addGap(31, 31, 31)
                                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextNameReceiverAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextStreet2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(jTextNumStreet))))
                            .addGroup(jPanelAdressLayout.createSequentialGroup()
                                .addComponent(jLabelZipCodeShipp2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAdressLayout.createSequentialGroup()
                                .addComponent(jLabelCountryShipp2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdressLayout.createSequentialGroup()
                        .addComponent(jLabelIdAdressShipp2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextIdAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdressLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCreateAdressShip)
                            .addComponent(jButtonCreateAdressBill, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(jPanelAdressLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCity, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStreetShipp2)
                            .addComponent(jLabelCityShipp2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelAdressLayout.setVerticalGroup(
            jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdressLayout.createSequentialGroup()
                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextNameReceiverAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabeNameReceiverAdressShipp2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdressLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelStreetShipp2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdressLayout.createSequentialGroup()
                        .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextNumStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNumStreetShipp2)
                            .addComponent(jTextStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextStreet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStreet2Shipp2)
                            .addComponent(jLabelCityShipp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelZipCodeShipp2))
                    .addGroup(jPanelAdressLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCountryShipp2))
                .addGap(13, 13, 13)
                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextIdAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdAdressShipp2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdateAdressBill)
                    .addComponent(jButtonCreateAdressBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCreateAdressShip)
                    .addComponent(jButtonUptateAdressShip))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jTextSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSearchCustomer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AddCustomer))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelSearch1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSearch1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchCustomer)
                    .addComponent(AddCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(298, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPaneManageAccount.addTab("Manage", jDesktopPane1);

        jTreeCustomers.setBorder(javax.swing.BorderFactory.createTitledBorder("Profils"));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Status");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Active");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("blue");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("violet");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("red");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("yellow");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("BlackListed");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("basketball");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("soccer");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("football");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hockey");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTreeCustomers.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeCustomersMouseClicked(evt);
            }
        });
        jScrollPaneTree1.setViewportView(jTreeCustomers);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPaneTree1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 788, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTree1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );

        jTabbedPaneManageAccount.addTab("Customers", jPanel2);

        javax.swing.GroupLayout jPanelAccountsLayout = new javax.swing.GroupLayout(jPanelAccounts);
        jPanelAccounts.setLayout(jPanelAccountsLayout);
        jPanelAccountsLayout.setHorizontalGroup(
            jPanelAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneManageAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAccountsLayout.setVerticalGroup(
            jPanelAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountsLayout.createSequentialGroup()
                .addComponent(jTabbedPaneManageAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 102, Short.MAX_VALUE))
        );

        add(jPanelAccounts, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    private void jTextZipCodeShippActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextZipCodeShippActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextZipCodeShippActionPerformed

    private void jTextZipCodeBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextZipCodeBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextZipCodeBillActionPerformed

    private void jButtonSendAdressBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendAdressBillActionPerformed

        final String mname = "jButtonCreateActionPerformed";
        AdressService serviceAdress = new AdressService();
        Adress adressBlling = new Adress();
        try {
            // Asks if we want to remove the customer
            final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to create adressBlling ", "Delete", JOptionPane.YES_NO_OPTION);
            if (anwser == JOptionPane.NO_OPTION) {
                return;
            }
            adressBlling.setNameReceiverAdress(jTextNameReceiverAdressBill.getText());
            adressBlling.setNumAdress(jTextNumStreetBill.getText());
            adressBlling.setNameStreetAdress(jTextStreetBill.getText());
            adressBlling.setNameStreet2Adress(jTextStreet2Bill.getText());
            adressBlling.setZipcodeAdress(jTextZipCodeBill.getText());
            adressBlling.setCityAdress(jTextCityBill.getText());
            adressBlling.setCountryAdress(jTextCountryBill.getText());
            adressBlling.setCustomerBillAdress(new Customer(jTextLogin.getText()));
            adressBlling = serviceAdress.createAdress(adressBlling);
            adressBillList.add(adressBlling);
            // Create the customer
            JOptionPane.showMessageDialog(this, "adressBlling number " + adressBlling.getId()
                    + " is creaeted", "info message", JOptionPane.INFORMATION_MESSAGE);
//            jButtonCreateAdressShip1.setVisible(false);
            jComboBoxBill.setModel(initAdressShipComboBoxModel(adressBillList));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the adress service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }


    }//GEN-LAST:event_jButtonSendAdressBillActionPerformed

    private void jButtonSendAdressShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendAdressShipActionPerformed
        final String mname = "jButtonCreateActionPerformed";
        AdressService serviceAdress = new AdressService();
        Adress adressShipping = new Adress();
        try {
            // Asks if we want to remove the customer
            final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to create adressShipping "
                    + adressShipping.getId(), "Delete", JOptionPane.YES_NO_OPTION);
            if (anwser == JOptionPane.NO_OPTION) {
                return;
            }
            adressShipping.setNameReceiverAdress(jTextNameReceiverAdressShipp.getText());
            adressShipping.setNumAdress(jTextNumStreetShipp.getText());
            adressShipping.setNameStreetAdress(jTextStreetShipp.getText());
            adressShipping.setNameStreet2Adress(jTextStreet2Shipp.getText());
            adressShipping.setZipcodeAdress(jTextZipCodeShipp.getText());
            adressShipping.setCityAdress(jTextCityShipp.getText());
            adressShipping.setCountryAdress(jTextCountryShipp.getText());
            adressShipping.setCustomerShipAdress(new Customer(jTextLogin.getText()));
            adressShipping = serviceAdress.createAdress(adressShipping);
            adressShipList.add(adressShipping);
            // Create the customer
            JOptionPane.showMessageDialog(this, "adressShipping number " + adressShipping.getId()
                    + " is creaeted", "info message", JOptionPane.INFORMATION_MESSAGE);
            jComboBoxShip.setModel(initAdressShipComboBoxModel(adressShipList));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }


    }//GEN-LAST:event_jButtonSendAdressShipActionPerformed
    private void selectLineTableCustomerActionPerformed(ListSelectionEvent evt) {

        if (evt.getValueIsAdjusting()) {
            return;
        }

        ListSelectionModel lsm = (ListSelectionModel) evt.getSource();

        if (lsm.isSelectionEmpty()) {
            System.out.println("No rows selected");
        } else {
            int selectedRow = lsm.getMinSelectionIndex();
            Customer customer = (Customer) customersVector.get(selectedRow);
            jPanelCustomer.setVisible(true);
            jTextEmail.setText(customer.getEmailCustomer());
            jTextFirstName.setText(customer.getFirstNameCustomer());
            jTextLogin.setText(customer.getId());
            jTextLastName.setText(customer.getLastNameCustomer());
            jTextCompany.setText(customer.getNameCompanyCustomer());

            if (customer != null) {
                jComboBoxStatus.setSelectedIndex(customer.getStatusCustomer() - 10);
            }

            adressShipList.clear();
            adressBillList.clear();
            adressShipList.addAll(customer.getListAddressShipping());
            adressBillList.addAll(customer.getListAddressBilling());
            jComboBoxShip.setModel(initAdressShipComboBoxModel(adressShipList));
            jComboBoxBill.setModel(initAdressShipComboBoxModel(adressBillList));

            if (customer.getListAddressShipping().size() > 0) {
                jPanelAdress.setVisible(true);
                jButtonCreateAdressBill.setVisible(false);
                jButtonCreateAdressShip.setVisible(false);
                jButtonUpdateAdressBill.setVisible(false);
                setTextFieldAdress((Adress) adressShipList.elementAt(0));
                jButtonCreateCustomer.setVisible(false);
                jButtonUpdateCustomer.setVisible(true);

                return;

            } else if (customer.getListAddressBilling().size() > 0) {
                jPanelAdress.setVisible(true);
                jButtonCreateAdressBill.setVisible(false);
                jButtonCreateAdressShip.setVisible(false);
                jButtonUptateAdressShip.setVisible(false);
                setTextFieldAdress((Adress) adressBillList.elementAt(0));
                jButtonCreateCustomer.setVisible(false);
                jButtonUpdateCustomer.setVisible(true);
                return;
            } else {
                jPanelAdress.setVisible(false);
                jButtonCreateCustomer.setVisible(false);
                jButtonUpdateCustomer.setVisible(true);
            }

        }
    }


    private void AddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustomerActionPerformed
        jPanelCustomer.setVisible(true);
        jPanelAdress.setVisible(false);
        clearCustomer();
        jButtonCreateCustomer.setVisible(true);
        jButtonUpdateCustomer.setVisible(false);

        jComboBoxShip.setModel(initAdressShipComboBoxModel(adressShipList));
        jComboBoxBill.setModel(initAdressShipComboBoxModel(adressBillList));
    }//GEN-LAST:event_AddCustomerActionPerformed

    private void jButtonSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchCustomerActionPerformed
        final String mname = "jButtonSearchOrdersActionPerformed";
        Vector vOrders = new Vector();
        Collection orders = new ArrayList();

        if (jComboBoxSearchCustomer.getSelectedIndex() == 0) {

            Customer customer = null;
            try {
                customer = serviceCustomer.findCustomer(jTextSearchCustomer.getText());//
                orders.add(customer);

            } catch (FinderException ex) {
                JOptionPane.showMessageDialog(this, "customers id not found", "Warning", JOptionPane.WARNING_MESSAGE);
            } catch (CheckException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
                Trace.throwing(_cname, mname, e);
            }

        }

        if (jComboBoxSearchCustomer.getSelectedIndex() == 1) {
            Customer customer = null;
            try {
                customer = serviceCustomer.findCustomerByEmail("Email", jTextSearchCustomer.getText());//
                orders.add(customer);

            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "customers id not found", "Warning", JOptionPane.WARNING_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
                Trace.throwing(_cname, mname, e);
            }

        }
        vOrders.addAll(orders);
        jTableCustomers.setModel(initCustomersTableModel(vOrders));
    }//GEN-LAST:event_jButtonSearchCustomerActionPerformed

    private void jComboBoxCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCustomersActionPerformed
        customersVector.clear();
        Customer customer = (Customer) jComboBoxCustomers.getSelectedItem();

        customersVector.add(customer);
        jTableCustomers.setModel(initCustomersTableModel(customersVector));

        adressShipList.clear();
        adressShipList.addAll(customer.getListAddressShipping());
        jComboBoxShip.setModel(initAdressShipComboBoxModel(adressShipList));
        Adress adressShipping = (Adress) jComboBoxShip.getSelectedItem();
        if (adressShipping != null) {
            setTextFieldAdress(adressShipping);
            jButtonUpdateAdressBill.setVisible(true);
            jButtonUptateAdressShip.setVisible(false);
            jButtonCreateAdressBill.setVisible(false);
            jButtonCreateAdressShip.setVisible(false);
            jPanelAdress.setVisible(true);
        }

        adressBillList.clear();
        adressBillList.addAll(customer.getListAddressShipping());
        jComboBoxBill.setModel(initAdressShipComboBoxModel(adressBillList));
        Adress adressBilling = (Adress) jComboBoxBill.getSelectedItem();
        if (adressBilling != null) {
            setTextFieldAdress(adressBilling);
            jButtonUpdateAdressBill.setVisible(true);
            jButtonUptateAdressShip.setVisible(false);
            jButtonCreateAdressBill.setVisible(false);
            jButtonCreateAdressShip.setVisible(false);
            jPanelAdress.setVisible(true);
        }


    }//GEN-LAST:event_jComboBoxCustomersActionPerformed

    private void jComboBoxCustomersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxCustomersMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCustomersMouseEntered

    private void jButtonAdressBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdressBillingActionPerformed
        
        clearAdress();
        jPanelAdress.setVisible(true);
        jButtonUpdateAdressBill.setVisible(false);
        jButtonUptateAdressShip.setVisible(false);
        jButtonCreateAdressBill.setVisible(true);
        jButtonCreateAdressShip.setVisible(false);
        jRadioButtonBill.setSelected(true);

        //  Jdialog
        clearBillingAdress();
        JDialog jDialogAdAdressBill = getjDialogAddAdressBill();
        jDialogAddAdressBill.setVisible(true);
        jPanelBillingAdress.setVisible(true);
    }//GEN-LAST:event_jButtonAdressBillingActionPerformed

    private void jButtonAdressShippingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdressShippingActionPerformed
        clearAdress();
        jPanelAdress.setVisible(true);
        jButtonUpdateAdressBill.setVisible(false);
        jButtonUptateAdressShip.setVisible(false);
        jButtonCreateAdressBill.setVisible(false);
        jButtonCreateAdressShip.setVisible(true);
        jPanelAdress.setVisible(true);
        jRadioButtonShip.setSelected(true);

        //  Jdialog
        clearShippingAdress();
        JDialog jDialogAddAdressShip = getjDialogAddAdressShip();
        jDialogAddAdressShip.setVisible(true);
        jPanelShippingAdress1.setVisible(true);
    }//GEN-LAST:event_jButtonAdressShippingActionPerformed

    private void jComboBoxBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBillActionPerformed
        Adress adressShipping = new Adress();
        adressShipping = (Adress) jComboBoxBill.getSelectedItem();
        if (adressShipping != null) {
            setTextFieldAdress(adressShipping);
            jButtonUpdateAdressBill.setVisible(true);
            jButtonUptateAdressShip.setVisible(false);
            jButtonCreateAdressBill.setVisible(false);
            jButtonCreateAdressShip.setVisible(false);
            jPanelAdress.setVisible(true);
        }

    }//GEN-LAST:event_jComboBoxBillActionPerformed

    private void jComboBoxShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxShipActionPerformed

        Adress adressShipping = new Adress();
        adressShipping = (Adress) jComboBoxShip.getSelectedItem();
        if (!adressShipping.equals(null)) {
            setTextFieldAdress(adressShipping);
            jButtonUpdateAdressBill.setVisible(false);
            jButtonUptateAdressShip.setVisible(true);
            jButtonCreateAdressBill.setVisible(false);
            jButtonCreateAdressShip.setVisible(false);
            jPanelAdress.setVisible(true);
        }
    }//GEN-LAST:event_jComboBoxShipActionPerformed

    private void jButtonCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateCustomerActionPerformed
        final String mname = "jButtonCreateActionPerformed";
        Customer customer = null;
        CustomerService serviceCustomer = new CustomerService();
        customer = new Customer(jTextLogin.getText(), jTextFirstName.getText(), jTextLastName.getText(), jTextEmail.getText(), jTextPassword.getText());
           
        try {
            checkId(jTextLogin.getText());
            customer.checkData();
            serviceCustomer.findCustomer(jTextLogin.getText());
            JOptionPane.showMessageDialog(this, jTextLogin.getText() + "already exist", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (ObjectNotFoundException ex) {
            // Asks if we want to create the customer
            
            final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to create customer "
                    + customer.getId() + " " + customer.getLastNameCustomer(), "Delete", JOptionPane.YES_NO_OPTION);
            if (anwser == JOptionPane.NO_OPTION) {
                return;
            }
            try { 
                
                customer = serviceCustomer.createCustomer(customer);
                customersVector.add(customer);
                jTableCustomers.setModel(initCustomersTableModel(customersVector));
            
            JOptionPane.showMessageDialog(this, "Customer number " + customer.getId()
                    + " is creaeted", "info message", JOptionPane.INFORMATION_MESSAGE);
            } catch (CreateException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//              Trace.throwing(_cname, mname, e);
            } catch (CheckException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                
            }
        } catch (CheckException e) {
           JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonCreateCustomerActionPerformed

    private void jTextLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLoginActionPerformed

    private void jTextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEmailActionPerformed

    private void jTextCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCompanyActionPerformed

    private void jTextPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPasswordActionPerformed

    private void jComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStatusActionPerformed

    private void jTreeCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeCustomersMouseClicked
        final String mname = "jTreeCustomersMouseClicked";
        CustomerService serviceCustomer = new CustomerService();
        try {
            Collection customers = serviceCustomer.findCustomers();
            jTreeCustomers.setModel(initCustomersTreeModel(customers));
        } catch (FinderException ex) {
            JOptionPane.showMessageDialog(this, "customers id not found", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }
    }//GEN-LAST:event_jTreeCustomersMouseClicked

    private void jTextZipCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextZipCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextZipCodeActionPerformed

    private void jButtonCreateAdressBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateAdressBillActionPerformed
        final String mname = "jButtonCreateAdressBillActionPerformed";
        
        AdressService serviceAdress = new AdressService();
        Adress adressBilling = new Adress();
        jRadioButtonShip.setSelected(true);
        try {
            adressBilling = setChampsAdress(adressBilling);
            adressBilling.checkData();
            // Asks if we want to remove the customer
            final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to create adressShipping "
                    , "Delete", JOptionPane.YES_NO_OPTION);
            if (anwser == JOptionPane.NO_OPTION) {
                return;
            }
            adressBilling = serviceAdress.createAdress(adressBilling);
            adressBillList.add(adressBilling);
            
            jComboBoxBill.setModel(initAdressBillComboBoxModel(adressShipList));
            
            // Create the customer
            JOptionPane.showMessageDialog(this, "adressBilling number " + adressBilling.getId()
                    + " is creaeted", "info message", JOptionPane.INFORMATION_MESSAGE);
            jComboBoxBill.setModel(initAdressBillComboBoxModel(adressShipList));
        } catch (CheckException e) {
           JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }
        
    }//GEN-LAST:event_jButtonCreateAdressBillActionPerformed

    private void jButtonCreateAdressShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateAdressShipActionPerformed
        final String mname = "jButtonCreateAdressBillActionPerformed";
        
        AdressService serviceAdress = new AdressService();
        Adress adressShipping = new Adress();
        jRadioButtonShip.setSelected(true);
        try {
            adressShipping = setChampsAdress(adressShipping);
            adressShipping.checkData();
            // Asks if we want to remove the customer
            final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to create adressShipping "
                    + adressShipping.getId(), "Delete", JOptionPane.YES_NO_OPTION);
            if (anwser == JOptionPane.NO_OPTION) {
                return;
            }
            adressShipping = serviceAdress.createAdress(adressShipping);
            adressShipList.add(adressShipping);
            jComboBoxShip.setModel(initAdressBillComboBoxModel(adressShipList));
            
            // Create the customer
            JOptionPane.showMessageDialog(this, "adressShipping number " + adressShipping.getId()
                    + " is creaeted", "info message", JOptionPane.INFORMATION_MESSAGE);
            jComboBoxShip.setModel(initAdressBillComboBoxModel(adressShipList));
        } catch (CheckException e) {
           JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }
    }//GEN-LAST:event_jButtonCreateAdressShipActionPerformed

    private void jButtonUpdateAdressBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateAdressBillActionPerformed
        final String mname = "jButtonUpdateAdressBillActionPerformed";
        AdressService serviceAdress = new AdressService();
        jRadioButtonBill.setSelected(true);
       
        // Sets all the Adress data
        Adress adressBilling = new Adress();        
        adressBilling = setChampsAdress(adressBilling);
        adressBilling.setId(jTextIdAdress.getText());
        try {
            // Updates the customer
         serviceAdress.updateAdress(adressBilling);
         chargeComboBoxAdressBilling(adressBilling.getCustomerBillAdress().getId());
            // Create the customer
            JOptionPane.showMessageDialog(this, "adressBilling id " + adressBilling.getId()
                    + " is updated", "info message", JOptionPane.INFORMATION_MESSAGE);

        } catch (CheckException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }
    }//GEN-LAST:event_jButtonUpdateAdressBillActionPerformed

    private void jButtonUptateAdressShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUptateAdressShipActionPerformed
      
        final String mname = "jButtonUptateAdressShipActionPerformed";
        AdressService serviceAdress = new AdressService();
        jRadioButtonShip.setSelected(true);
       
        // Sets all the Adress data
        Adress adressShipping = new Adress();        
        adressShipping = setChampsAdress(adressShipping);
        adressShipping.setId(jTextIdAdress.getText());
        try {
            // Updates the customer
         serviceAdress.updateAdress(adressShipping);
         chargeComboBoxAdressShipping(adressShipping.getCustomerShipAdress().getId());
            // Create the customer
            JOptionPane.showMessageDialog(this, "adressShipping id " + adressShipping.getId()
                    + " is updated", "info message", JOptionPane.INFORMATION_MESSAGE);

        } catch (CheckException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }





// TODO add your handling code here:
    }//GEN-LAST:event_jButtonUptateAdressShipActionPerformed

    private void jButtonUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateCustomerActionPerformed
         final String mname = "jButtonUpdateCustomerActionPerformed";
        CustomerService serviceCustomer = new CustomerService();
       
        // Sets all the Customer data
        Customer customer = new Customer(jTextLogin.getText(), jTextFirstName.getText(), jTextLastName.getText()
                , jTextEmail.getText(), jTextPassword.getText());
          
        try {
            // Updates the customer
            serviceCustomer.updateCustomer(customer);
            chargeComboBoxCustomers();
            // Create the customer
            JOptionPane.showMessageDialog(this, "customer login " + customer.getId()
                    + " is updated", "info message", JOptionPane.INFORMATION_MESSAGE);

        } catch (CheckException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }

    }//GEN-LAST:event_jButtonUpdateCustomerActionPerformed

    public void setChampsBillingAdress(Adress adress) {
        jTextNameReceiverAdressBill.setText(adress.getNameReceiverAdress());
        jTextNumStreetBill.setText(adress.getNumAdress());
        jTextStreetBill.setText(adress.getNameStreetAdress());
        jTextStreet2Bill.setText(adress.getNameStreet2Adress());
        jTextZipCodeBill.setText(adress.getZipcodeAdress());
        jTextCityBill.setText(adress.getCityAdress());
        jTextCountryBill.setText(adress.getCountryAdress());
        jTextIdAdressBill.setText(adress.getId());

    }

    public void clearBillingAdress() {
        jTextNameReceiverAdressBill.setText("");
        jTextNumStreetBill.setText("");
        jTextStreetBill.setText("");
        jTextStreet2Bill.setText("");
        jTextZipCodeBill.setText("");
        jTextCityBill.setText("");
        jTextCountryBill.setText("");
        jTextIdAdressBill.setText("");
    }

    public void clearAdress() {
        jTextNameReceiverAdress.setText("");
        jTextNumStreet.setText("");
        jTextStreet.setText("");
        jTextStreet2.setText("");
        jTextZipCode.setText("");
        jTextCity.setText("");
        jTextCountry.setText("");
        jTextIdAdress.setText("");

    }

    public void clearCustomer() {
        jTextLogin.setText("");
        jTextEmail.setText("");
        jTextFirstName.setText("");
        jTextLastName.setText("");
        jTextPassword.setText("");
        jTextCompany.setText("");
        adressShipList.clear();
        adressBillList.clear();
    }

    public Adress setChampsAdress(Adress adress) {
        adress.setNameReceiverAdress(jTextNameReceiverAdress.getText());
        adress.setNumAdress(jTextNumStreet.getText());
        adress.setNameStreetAdress(jTextStreet.getText());
        adress.setNameStreet2Adress(jTextStreet2.getText());
        adress.setZipcodeAdress(jTextZipCode.getText());
        adress.setCityAdress(jTextCity.getText());
        adress.setCountryAdress(jTextCountry.getText());
        if(jRadioButtonBill.isSelected())        
            adress.setCustomerBillAdress(new Customer(jTextLogin.getText()));
        if(jRadioButtonShip.isSelected()) 
            adress.setCustomerShipAdress(new Customer(jTextLogin.getText()));
        return adress;

    }

    public void setTextFieldAdress(Adress adress) {
        jTextNameReceiverAdress.setText(adress.getNameReceiverAdress());
        jTextNumStreet.setText(adress.getNumAdress());
        jTextStreet.setText(adress.getNameStreetAdress());
        jTextStreet2.setText(adress.getNameStreet2Adress());
        jTextZipCode.setText(adress.getZipcodeAdress());
        jTextCity.setText(adress.getCityAdress());
        jTextCountry.setText(adress.getCountryAdress());
        jTextIdAdress.setText(adress.getId());

    }

    public void setChampsShippingAdress(Adress adress) {
        jTextNameReceiverAdressShipp.setText(adress.getNameReceiverAdress());
        jTextNumStreetShipp.setText(adress.getNumAdress());
        jTextStreetShipp.setText(adress.getNameStreetAdress());
        jTextStreet2Shipp.setText(adress.getNameStreet2Adress());
        jTextZipCodeShipp.setText(adress.getZipcodeAdress());
        jTextCityShipp.setText(adress.getCityAdress());
        jTextCountryShipp.setText(adress.getCountryAdress());
        jTextIdAdressShipp.setText(adress.getId());

    }

    public void clearShippingAdress() {
        jTextNameReceiverAdressShipp.setText("");
        jTextNumStreetShipp.setText("");
        jTextStreetShipp.setText("");
        jTextStreet2Bill.setText("");
        jTextZipCodeShipp.setText("");
        jTextCityShipp.setText("");
        jTextCountryShipp.setText("");
        jTextIdAdressShipp.setText("");

    }

    public DefaultComboBoxModel initCustomersComboBoxModel(Collection customers) {
        return new DefaultComboBoxModel(initCustomersVector(customers));
    }

    private Vector initCustomersVector(Collection customers) {
        final String mname = "initCustomersVector";
        Vector v = new Vector();
        v.addAll(customers);
        return v;
    }

    public DefaultComboBoxModel initAdressShipComboBoxModel(Collection adressesChip) {
        return new DefaultComboBoxModel(initAdressShipVector(adressesChip));
    }

    private Vector initAdressShipVector(Collection adressesChip) {
        final String mname = "initAdressChipVector";
        Vector v = new Vector();
        v.addAll(adressesChip);
        return v;
    }

    public DefaultComboBoxModel initAdressBillComboBoxModel(Collection adressesBill) {
        return new DefaultComboBoxModel(initAdressBillVector(adressesBill));
    }

    private Vector initAdressBillVector(Collection adressesBill) {
        final String mname = "initAdressChipVector";
        Vector v = new Vector();
        v.addAll(adressesBill);
        return v;
    }

    public DefaultTreeModel initCustomersTreeModel(Collection customers) {
        return new DefaultTreeModel(initCustomerTree(customers));
    }

    private DefaultMutableTreeNode initCustomerTree(Collection customers) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("mes Customers");
        DefaultMutableTreeNode tnType1 = null;
        DefaultMutableTreeNode tnType2 = null;
        DefaultMutableTreeNode tnType3 = null;
        DefaultMutableTreeNode tnCustomer = null;

        tnType1 = new DefaultMutableTreeNode(
                "Inactive");
        root.add(tnType1);
        tnType2 = new DefaultMutableTreeNode(
                "Active");
        root.add(tnType2);

        tnType3 = new DefaultMutableTreeNode(
                "BlackList");
        root.add(tnType3);

        for (Customer customer : (Collection<Customer>) customers) {
            if (customer.getStatusCustomer() == 10) {
                tnType1.add(new DefaultMutableTreeNode(customer));
            }
            if (customer.getStatusCustomer() == 11) {
                tnType2.add(new DefaultMutableTreeNode(customer));
            }
            if (customer.getStatusCustomer() == 12) {
                tnType3.add(new DefaultMutableTreeNode(customer));
            }
        }
        return root;

    }

    public DefaultTableModel initCustomersTableModel(Collection customers) {
        return new DefaultTableModel(initVectorTableData(customers), initVectorColumnNamesTable());
    }

    private Vector initVectorTableData(Collection customers) {
        final String mname = "initVectorTableData";
        Vector rowDada = new Vector();
        for (Customer customer : (Collection<Customer>) customers) {
            Vector colData = null;
            colData = new Vector();
            colData.add(customer);
            rowDada.add(customer.getVector());
        }

        return rowDada;
    }

    private Vector initVectorColumnNamesTable() {
        Vector<String> columnNames = new Vector();
        columnNames.add("Customer");
        columnNames.add("lOGIN");
        columnNames.add("First Name");
        columnNames.add("Last Name");
        columnNames.add("Email");
        columnNames.add("Comment");
        columnNames.add("Status");
        return columnNames;
    }

    public JComboBox getjComboBoxBill() {
        return jComboBoxBill;
    }

    public JComboBox getjComboBoxShip() {
        return jComboBoxShip;
    }

    public DefaultComboBoxModel initStatusCustomersComboBoxModel(Collection statusCustomers) {
        return new DefaultComboBoxModel(initStatusCustomersVector(statusCustomers));
    }

    private Vector initStatusCustomersVector(Collection statusCustomers) {
        final String mname = "initStatusOrdersVector";
        Vector v = new Vector();
        v.addAll(statusCustomers);
        return v;
    }

    public Collection chargeComboBoxStatusCustomers() {
        final String mname = "chargeComboBoxStatusCustomers";
        CustomerService serviceCustomer = new CustomerService();
        Collection infoStatus = new ArrayList();
        try {
            infoStatus = serviceCustomer.findStatusCustomers();
            statusCustomersVector.clear();
            statusCustomersVector.addAll(infoStatus);
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "status id not found", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }

        return infoStatus;

    }

    public void chargeComboBoxCustomers() {
        final String mname = "chargeComboBoxCustomers";
        CustomerService serviceCustomer = new CustomerService();
        Collection customers = null;
        try {
            customers = serviceCustomer.findCustomers();
            jComboBoxCustomers.setModel(initAdressBillComboBoxModel(customers));
            customersVector.clear();
            customersVector.addAll(customers);
        } catch (FinderException ex) {
            JOptionPane.showMessageDialog(this, "customers id not found", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }

    }
    public void chargeComboBoxAdressBilling( String login) {
        final String mname = "chargeComboBoxAdress";
        AdressService serviceAdress = new AdressService();
        Collection adresses = null;
        try {
            adresses = serviceAdress.findAllAdressBilling(login);
            jComboBoxBill.setModel(initAdressBillComboBoxModel(adresses));
            adressBillList.clear();
            adressBillList.addAll(adresses);
        } catch (FinderException ex) {
            JOptionPane.showMessageDialog(this, "customers id not found", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }

    }
        public void chargeComboBoxAdressShipping( String login) {
        final String mname = "chargeComboBoxAdressShipping";
        AdressService serviceAdress = new AdressService();
        Collection adresses = null;
        try {
            adresses = serviceAdress.findAllAdressShipping(login);
            jComboBoxShip.setModel(initAdressShipComboBoxModel(adresses));
            adressShipList.clear();
            adressShipList.addAll(adresses);
        } catch (FinderException ex) {
            JOptionPane.showMessageDialog(this, "AdressShipping id not found", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the customer service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }

    }
    
    
    
    
    
    
    
    protected void checkId(final String id) throws CheckException {
    	if ( id == null || id.equals("") )
    		throw new CheckException("Id should not be null or empty");    	
    }
    

    protected final transient String _cname = this.getClass().getName();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCustomer;
    private javax.swing.ButtonGroup buttonGroupAdress;
    private javax.swing.JButton jButtonAdressBilling;
    private javax.swing.JButton jButtonAdressShipping;
    private javax.swing.JButton jButtonCreateAdressBill;
    private javax.swing.JButton jButtonCreateAdressShip;
    private javax.swing.JButton jButtonCreateCustomer;
    private javax.swing.JButton jButtonSearchCustomer;
    private javax.swing.JButton jButtonSendAdressBill;
    private javax.swing.JButton jButtonSendAdressShip;
    private javax.swing.JButton jButtonUpdateAdressBill;
    private javax.swing.JButton jButtonUpdateCustomer;
    private javax.swing.JButton jButtonUptateAdressShip;
    private javax.swing.JComboBox jComboBoxBill;
    private javax.swing.JComboBox jComboBoxCustomers;
    private javax.swing.JComboBox jComboBoxSearchCustomer;
    private javax.swing.JComboBox jComboBoxShip;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialogAddAdressBill;
    private javax.swing.JDialog jDialogAddAdressShip;
    private javax.swing.JLabel jLabeNameReceiverAdressShipp1;
    private javax.swing.JLabel jLabeNameReceiverAdressShipp2;
    private javax.swing.JLabel jLabelCityBill1;
    private javax.swing.JLabel jLabelCityShipp1;
    private javax.swing.JLabel jLabelCityShipp2;
    private javax.swing.JLabel jLabelCompany1;
    private javax.swing.JLabel jLabelCountryBill1;
    private javax.swing.JLabel jLabelCountryShipp1;
    private javax.swing.JLabel jLabelCountryShipp2;
    private javax.swing.JLabel jLabelEmail1;
    private javax.swing.JLabel jLabelFirstName1;
    private javax.swing.JLabel jLabelIdAdressBill1;
    private javax.swing.JLabel jLabelIdAdressShipp1;
    private javax.swing.JLabel jLabelIdAdressShipp2;
    private javax.swing.JLabel jLabelLastName1;
    private javax.swing.JLabel jLabelLogin1;
    private javax.swing.JLabel jLabelNameReceiverAdressBill1;
    private javax.swing.JLabel jLabelNumStreetBill1;
    private javax.swing.JLabel jLabelNumStreetShipp1;
    private javax.swing.JLabel jLabelNumStreetShipp2;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelSearch1;
    private javax.swing.JLabel jLabelStatus1;
    private javax.swing.JLabel jLabelStreet2Bill1;
    private javax.swing.JLabel jLabelStreet2Shipp1;
    private javax.swing.JLabel jLabelStreet2Shipp2;
    private javax.swing.JLabel jLabelStreetBill1;
    private javax.swing.JLabel jLabelStreetShipp1;
    private javax.swing.JLabel jLabelStreetShipp2;
    private javax.swing.JLabel jLabelZipCodeBill1;
    private javax.swing.JLabel jLabelZipCodeShipp1;
    private javax.swing.JLabel jLabelZipCodeShipp2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAccounts;
    private javax.swing.JPanel jPanelAdress;
    private javax.swing.JPanel jPanelBillingAdress;
    private javax.swing.JPanel jPanelCustomer;
    private javax.swing.JPanel jPanelShippingAdress1;
    private javax.swing.JRadioButton jRadioButtonBill;
    private javax.swing.JRadioButton jRadioButtonShip;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPaneTree1;
    private javax.swing.JTabbedPane jTabbedPaneManageAccount;
    private javax.swing.JTable jTableCustomers;
    private javax.swing.JTextField jTextCity;
    private javax.swing.JTextField jTextCityBill;
    private javax.swing.JTextField jTextCityShipp;
    private javax.swing.JTextField jTextCompany;
    private javax.swing.JTextField jTextCountry;
    private javax.swing.JTextField jTextCountryBill;
    private javax.swing.JTextField jTextCountryShipp;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextFirstName;
    private javax.swing.JTextField jTextIdAdress;
    private javax.swing.JTextField jTextIdAdressBill;
    private javax.swing.JTextField jTextIdAdressShipp;
    private javax.swing.JTextField jTextLastName;
    private javax.swing.JTextField jTextLogin;
    private javax.swing.JTextField jTextNameReceiverAdress;
    private javax.swing.JTextField jTextNameReceiverAdressBill;
    private javax.swing.JTextField jTextNameReceiverAdressShipp;
    private javax.swing.JTextField jTextNumStreet;
    private javax.swing.JTextField jTextNumStreetBill;
    private javax.swing.JTextField jTextNumStreetShipp;
    private javax.swing.JTextField jTextPassword;
    private javax.swing.JTextField jTextSearchCustomer;
    private javax.swing.JTextField jTextStreet;
    private javax.swing.JTextField jTextStreet2;
    private javax.swing.JTextField jTextStreet2Bill;
    private javax.swing.JTextField jTextStreet2Shipp;
    private javax.swing.JTextField jTextStreetBill;
    private javax.swing.JTextField jTextStreetShipp;
    private javax.swing.JTextField jTextZipCode;
    private javax.swing.JTextField jTextZipCodeBill;
    private javax.swing.JTextField jTextZipCodeShipp;
    private javax.swing.JTree jTreeCustomers;
    // End of variables declaration//GEN-END:variables
}
