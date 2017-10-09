/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.client.ui.swing;

import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.catalog.Occasion;
import com.cdi.g3.server.domain.catalog.OccasionBook;
import com.cdi.g3.server.service.catalog.OccasionBookService;

import java.util.Collection;
import com.cdi.g3.server.service.catalog.OccasionService;
import java.util.Iterator;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Izet
 */
public class JPanelFormEvents extends JDesktopPane {
DefaultTableModel myModel = new DefaultTableModel();
 Vector EventList = new Vector();
 OccasionService occasionService = new OccasionService();
  
    
 
 
 public JPanelFormEvents() {
         initComponents();
        myModel.addColumn("ISBN");
        myModel.addColumn("TITLE");
        myModel.addColumn("AUTHOR");
        myModel.addColumn("PUBLISHER");
        myModel.addColumn("STOCK");
        jTableEvent.setModel(myModel);
        jComboBoxSelectedEvent.setModel(initSelectedEventModel());
        
        
        
        
    
 }
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanelEvents = new javax.swing.JPanel();
        jPanelNewEvent = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        jButtonCreate = new javax.swing.JButton();
        jTextDiscount = new javax.swing.JTextField();
        jLabelDiscount = new javax.swing.JLabel();
        jLabelStart = new javax.swing.JLabel();
        jTextStart = new javax.swing.JTextField();
        jLabelEnd = new javax.swing.JLabel();
        jTextEnd = new javax.swing.JTextField();
        jPanelManageEvents = new javax.swing.JPanel();
        jScrollPaneManageEvents = new javax.swing.JScrollPane();
        jTableEvent = new javax.swing.JTable();
        jLabelSelectedEvent = new javax.swing.JLabel();
        jComboBoxSelectedEvent = new javax.swing.JComboBox<String>();
        jLabelInsert = new javax.swing.JLabel();
        jTextInsert = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDeleteInsert = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelNewEvent.setBorder(javax.swing.BorderFactory.createTitledBorder("New"));

        jLabelName.setText("Name  :");

        jTextName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNameActionPerformed(evt);
            }
        });

        jButtonCreate.setText("Create");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        jTextDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDiscountActionPerformed(evt);
            }
        });

        jLabelDiscount.setText("Discount :");

        jLabelStart.setText("Start  :");

        jTextStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextStartActionPerformed(evt);
            }
        });

        jLabelEnd.setText("End  :");

        jTextEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNewEventLayout = new javax.swing.GroupLayout(jPanelNewEvent);
        jPanelNewEvent.setLayout(jPanelNewEventLayout);
        jPanelNewEventLayout.setHorizontalGroup(
            jPanelNewEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewEventLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelNewEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelNewEventLayout.createSequentialGroup()
                        .addComponent(jLabelStart)
                        .addGap(18, 18, 18)
                        .addComponent(jTextStart, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNewEventLayout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addGap(18, 18, 18)
                        .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addGroup(jPanelNewEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNewEventLayout.createSequentialGroup()
                        .addComponent(jLabelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelNewEventLayout.createSequentialGroup()
                        .addComponent(jLabelEnd)
                        .addGap(18, 18, 18)
                        .addComponent(jTextEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                        .addComponent(jButtonCreate)
                        .addGap(30, 30, 30))))
        );
        jPanelNewEventLayout.setVerticalGroup(
            jPanelNewEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewEventLayout.createSequentialGroup()
                .addGroup(jPanelNewEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDiscount)
                    .addComponent(jTextDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNewEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNewEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEnd)
                        .addComponent(jTextEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCreate))
                    .addGroup(jPanelNewEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelStart)
                        .addComponent(jTextStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanelManageEvents.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage"));

        jTableEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Title", "Author", "Publisher", "Stock"
            }
        ));
        jScrollPaneManageEvents.setViewportView(jTableEvent);

        jLabelSelectedEvent.setText("Selected Event  :");

        jComboBoxSelectedEvent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Best Sellers", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSelectedEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxSelectedEventMouseClicked(evt);
            }
        });
        jComboBoxSelectedEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectedEventActionPerformed(evt);
            }
        });

        jLabelInsert.setText(" Isbn/Title/Author/Cat  :");

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");

        jButtonDeleteInsert.setText("Delete");
        jButtonDeleteInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteInsertActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete ");

        javax.swing.GroupLayout jPanelManageEventsLayout = new javax.swing.GroupLayout(jPanelManageEvents);
        jPanelManageEvents.setLayout(jPanelManageEventsLayout);
        jPanelManageEventsLayout.setHorizontalGroup(
            jPanelManageEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManageEventsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelManageEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelManageEventsLayout.createSequentialGroup()
                        .addComponent(jLabelSelectedEvent)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelManageEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelManageEventsLayout.createSequentialGroup()
                                .addComponent(jComboBoxSelectedEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelInsert)
                                .addGap(18, 18, 18)
                                .addComponent(jTextInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelManageEventsLayout.createSequentialGroup()
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonDeleteInsert)))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageEventsLayout.createSequentialGroup()
                        .addComponent(jScrollPaneManageEvents)
                        .addContainerGap())))
        );
        jPanelManageEventsLayout.setVerticalGroup(
            jPanelManageEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageEventsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelManageEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSelectedEvent)
                    .addComponent(jComboBoxSelectedEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelInsert)
                    .addComponent(jTextInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanelManageEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonDeleteInsert)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneManageEvents, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelEventsLayout = new javax.swing.GroupLayout(jPanelEvents);
        jPanelEvents.setLayout(jPanelEventsLayout);
        jPanelEventsLayout.setHorizontalGroup(
            jPanelEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEventsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelNewEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelManageEvents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanelEventsLayout.setVerticalGroup(
            jPanelEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEventsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNewEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanelManageEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setLayer(jPanelEvents, javax.swing.JLayeredPane.DEFAULT_LAYER);
    }// </editor-fold>//GEN-END:initComponents
                    
     private void clearTab() {
        int lignes = myModel.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            myModel.removeRow(i);
        }
    }
    

    
    
 private DefaultComboBoxModel initSelectedEventModel() {
        return new DefaultComboBoxModel(initEventVector());
    }
 private Vector initEventVector() {

        try {
            Collection v = occasionService.FindAllOccasion();
            EventList.addAll(v);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(JPanelFormEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return EventList;
    }
    private void jTextNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNameActionPerformed

    private void jButtonDeleteInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteInsertActionPerformed
           final String mname = "jButtonDeleteActionPerformed";

        final String nameOccasion = jTextName.getText();
        if ("".equals(nameOccasion)) {
            JOptionPane.showMessageDialog(this, "You have to enter an occasion login ", "Delete", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Asks if we want to remove the customer
        final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to remove Occasion name " + nameOccasion, "Delete", JOptionPane.YES_NO_OPTION);
        if (anwser == JOptionPane.NO_OPTION) {
            return;
        }

        final OccasionService occasionService = new OccasionService();
        try {
            occasionService.deleteOccasion(nameOccasion);

            JOptionPane.showMessageDialog(this, "Event name " + nameOccasion
                + " is deleted", "info message", JOptionPane.INFORMATION_MESSAGE);

            //            jComboBoxCarnet.setModel(initCarnetModel());
            //            jTree1.setModel(initCarnetTreeModel());
            //            clearFrame();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cannot access the event service", "Error", JOptionPane.ERROR_MESSAGE);
              
            Trace.throwing(_cname, mname, e);
        } // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteInsertActionPerformed

    private void jTextStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextStartActionPerformed

    private void jTextEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEndActionPerformed

    private void jTextDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDiscountActionPerformed

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        final String mname = "jButtonCreateActionPerformed";
         Utility utils = new Utility();
        OccasionService serviceOccasion = new OccasionService();
        Occasion occasion = new Occasion();
        try {
            // Asks if we want to remove the customer
            final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to create occasion "
                + occasion.getId(), "Delete", JOptionPane.YES_NO_OPTION);
            if (anwser == JOptionPane.NO_OPTION) {
                return;
            }
            occasion.setNameOccasion(jTextName.getText());
            try {
                occasion.setDateDebutOccasion(utils.formatStringToSQLDate(jTextStart.getText()));
                occasion.setDateFinOccasion(utils.formatStringToSQLDate(jTextEnd.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur of sql date formatting");
            }           
            occasion.setDiscountOccasion(jTextDiscount.getAlignmentX());
           
            occasion = serviceOccasion.createOccasion(occasion); 
         
                     
            JOptionPane.showMessageDialog(this, "Occasion numOccasion " + occasion.getId()
                + " is created", "info message", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Cannot access the occasion service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jComboBoxSelectedEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxSelectedEventMouseClicked
        Vector bookAttributes = null;
    try {
        for (Iterator itarator = occasionService.FindBooksByChamp("numIsbnbookOB", jComboBoxSelectedEvent.getSelectedItem().toString()).iterator(); itarator.hasNext();) {
            Book book = (Book) itarator.next();
            bookAttributes = new Vector();
            bookAttributes.add(book.getNumISBNBook());
            bookAttributes.add(book.getTitleBook());
            bookAttributes.add(book.getSubTitleBook());
            bookAttributes.add(book.getEditor());
            bookAttributes.add(book.getStockBook());
            bookAttributes.add(book.getUnitCostBook() + " €");
            myModel.addRow(bookAttributes);
        }
    } catch (ObjectNotFoundException ex) {
        Logger.getLogger(JPanelFormEvents.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jComboBoxSelectedEventMouseClicked

    private void jComboBoxSelectedEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectedEventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSelectedEventActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
       final String mname = "jButtonAddActionPerformed";
        
        OccasionBookService serviceOccasionBook = new OccasionBookService();
        OccasionBook occasionBook = new OccasionBook();
        try {
            // Asks if we want to remove the customer
            final int anwser = JOptionPane.showConfirmDialog(this, "Do you want to add occasionBook "
                + occasionBook.getId(), "Delete", JOptionPane.YES_NO_OPTION);
            if (anwser == JOptionPane.NO_OPTION) {
                return;
            }
              occasionBook.setNumIsbnBook(jTextInsert.getText());
            try {
            
               
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur of sql date formatting");
            }           
          occasionBook = serviceOccasionBook.createOccasionBook(occasionBook); 
         
                     
            JOptionPane.showMessageDialog(this, "OccasionBook numOccasion " + occasionBook.getId()
                + " is created", "info message", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Cannot access the occasion service", "Error", JOptionPane.ERROR_MESSAGE);
            Trace.throwing(_cname, mname, e);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed
 protected final transient String _cname = this.getClass().getName();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDeleteInsert;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxSelectedEvent;
    private javax.swing.JLabel jLabelDiscount;
    private javax.swing.JLabel jLabelEnd;
    private javax.swing.JLabel jLabelInsert;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelSelectedEvent;
    private javax.swing.JLabel jLabelStart;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanelEvents;
    private javax.swing.JPanel jPanelManageEvents;
    private javax.swing.JPanel jPanelNewEvent;
    private javax.swing.JScrollPane jScrollPaneManageEvents;
    private javax.swing.JTable jTableEvent;
    private javax.swing.JTextField jTextDiscount;
    private javax.swing.JTextField jTextEnd;
    private javax.swing.JTextField jTextInsert;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextStart;
    // End of variables declaration//GEN-END:variables

   
}
