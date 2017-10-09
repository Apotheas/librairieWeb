/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.client.ui.swing;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.catalog.Author;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.service.catalog.CatalogService;
import com.cdi.g3.server.service.publishing.PublishingService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Apotheas
 */
public class JPanelFormAuthor extends javax.swing.JPanel {

    private final DefaultTableModel tabModel = new DefaultTableModel();
    private final PublishingService publishingService = new PublishingService();
    private final CatalogService catalogService = new CatalogService();
    private final Vector authorList = new Vector();
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public JPanelFormAuthor() {
        initComponents();
        tabModel.addColumn("ISBN");
        tabModel.addColumn("TITLE");
        tabModel.addColumn("SUB-TITLE");
        tabModel.addColumn("EDITOR");
        tabModel.addColumn("STOCK");
        tabModel.addColumn("COST");
        jTable.setModel(tabModel);
        jComboBoxSelectedAuthor.setModel(initAuthorsModel());
    }

    private void clearTab() {
        int lignes = tabModel.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            tabModel.removeRow(i);
        }
    }

    private void clearField() {
        jTextBiography.setText(" ");
        jTextBirthDate.setText(" ");
        jTextComment.setText(" ");
        jTextDeathDate.setText(" ");
        jTextFirstName.setText(" ");
        jTextLastName.setText(" ");
        jTextSearchAuthor.setText(" ");
    }

    //________________Authors COMBOBOX MODEL________________//
    private DefaultComboBoxModel initAuthorsModel() {
        return new DefaultComboBoxModel(initAuthorsVector());
    }

    private Vector initAuthorsVector() {
        try {
            Collection v = publishingService.FindAllAuthor();
            authorList.addAll(v);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(JPanelFormAuthor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authorList;
    }
    //______________________________________________________//

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAuthors = new javax.swing.JPanel();
        jPanelNewAuthor = new javax.swing.JPanel();
        jLabelFirstName = new javax.swing.JLabel();
        jTextFirstName = new javax.swing.JTextField();
        jLabelLastName = new javax.swing.JLabel();
        jTextLastName = new javax.swing.JTextField();
        jLabelBirthDate = new javax.swing.JLabel();
        jTextBirthDate = new javax.swing.JTextField();
        jLabelDeathDate = new javax.swing.JLabel();
        jTextDeathDate = new javax.swing.JTextField();
        jLabelComment = new javax.swing.JLabel();
        jLabelBiography = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextBiography = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextComment = new javax.swing.JTextPane();
        jPanelManageAuthors = new javax.swing.JPanel();
        jScrollPaneManageEvents = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabelSelectedAuthor = new javax.swing.JLabel();
        jComboBoxSelectedAuthor = new javax.swing.JComboBox<>();
        jButtonUpdateAuthor = new javax.swing.JButton();
        jLabelSearchAuthor = new javax.swing.JLabel();
        jTextSearchAuthor = new javax.swing.JTextField();
        jButtonSearchAuthor = new javax.swing.JButton();

        jPanelNewAuthor.setBorder(javax.swing.BorderFactory.createTitledBorder("Infos Selected Author"));

        jLabelFirstName.setText("First Name  :");

        jTextFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFirstNameActionPerformed(evt);
            }
        });

        jLabelLastName.setText("Last Name  :");

        jTextLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLastNameActionPerformed(evt);
            }
        });

        jLabelBirthDate.setText("Birth Date  :");

        jTextBirthDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBirthDateActionPerformed(evt);
            }
        });

        jLabelDeathDate.setText("Death Date  :");

        jTextDeathDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDeathDateActionPerformed(evt);
            }
        });

        jLabelComment.setText("Comment :");

        jLabelBiography.setText("Biography  :");

        jScrollPane1.setViewportView(jTextBiography);

        jScrollPane2.setViewportView(jTextComment);

        javax.swing.GroupLayout jPanelNewAuthorLayout = new javax.swing.GroupLayout(jPanelNewAuthor);
        jPanelNewAuthor.setLayout(jPanelNewAuthorLayout);
        jPanelNewAuthorLayout.setHorizontalGroup(
            jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addComponent(jLabelFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addComponent(jLabelBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addComponent(jLabelComment, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addGap(77, 77, 77)
                .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelDeathDate, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabelLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBiography, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextDeathDate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanelNewAuthorLayout.setVerticalGroup(
            jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFirstName)
                            .addComponent(jTextFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBirthDate)
                            .addComponent(jTextBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLastName)
                            .addComponent(jTextLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDeathDate)
                            .addComponent(jTextDeathDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanelNewAuthorLayout.createSequentialGroup()
                        .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelNewAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNewAuthorLayout.createSequentialGroup()
                                    .addComponent(jLabelComment)
                                    .addGap(37, 37, 37))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelBiography))
                        .addGap(0, 37, Short.MAX_VALUE))))
        );

        jPanelManageAuthors.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage"));

        jTable.setAutoCreateRowSorter(true);
        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneManageEvents.setViewportView(jTable);

        jLabelSelectedAuthor.setText("Selected Author  :");

        jComboBoxSelectedAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectedAuthorActionPerformed(evt);
            }
        });

        jButtonUpdateAuthor.setText("Update");
        jButtonUpdateAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateAuthorActionPerformed(evt);
            }
        });

        jLabelSearchAuthor.setText(" Author  :");

        jTextSearchAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchAuthorActionPerformed(evt);
            }
        });

        jButtonSearchAuthor.setText("Search");
        jButtonSearchAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelManageAuthorsLayout = new javax.swing.GroupLayout(jPanelManageAuthors);
        jPanelManageAuthors.setLayout(jPanelManageAuthorsLayout);
        jPanelManageAuthorsLayout.setHorizontalGroup(
            jPanelManageAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageAuthorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSearchAuthor)
                .addGap(18, 18, 18)
                .addComponent(jTextSearchAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSearchAuthor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSelectedAuthor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxSelectedAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageAuthorsLayout.createSequentialGroup()
                .addComponent(jScrollPaneManageEvents)
                .addContainerGap())
            .addGroup(jPanelManageAuthorsLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButtonUpdateAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelManageAuthorsLayout.setVerticalGroup(
            jPanelManageAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageAuthorsLayout.createSequentialGroup()
                .addGroup(jPanelManageAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelManageAuthorsLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabelSearchAuthor)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageAuthorsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelManageAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelManageAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelSelectedAuthor)
                                .addComponent(jComboBoxSelectedAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelManageAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextSearchAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonSearchAuthor)))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdateAuthor)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPaneManageEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelAuthorsLayout = new javax.swing.GroupLayout(jPanelAuthors);
        jPanelAuthors.setLayout(jPanelAuthorsLayout);
        jPanelAuthorsLayout.setHorizontalGroup(
            jPanelAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAuthorsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelManageAuthors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelNewAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelAuthorsLayout.setVerticalGroup(
            jPanelAuthorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAuthorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelNewAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelManageAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAuthors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFirstNameActionPerformed

    private void jTextLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLastNameActionPerformed

    private void jTextBirthDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBirthDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBirthDateActionPerformed

    private void jTextDeathDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDeathDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDeathDateActionPerformed

    private void jTextSearchAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSearchAuthorActionPerformed

    private void jButtonSearchAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchAuthorActionPerformed
        clearTab();
        Collection<Author> listAuthor = new ArrayList();
        try {
            listAuthor = publishingService.findAuthorByChamp("lastnameAuthor", jTextSearchAuthor.getText());
            for (Author author : listAuthor) {
                jTextLastName.setText(author.getLastNameAuthor());
                jTextFirstName.setText(author.getFirstNameAuthor());
                jTextBirthDate.setText(df.format(author.getBirthDateAuthor()));
                jTextBiography.setText(author.getBiographyAuthor());
                jTextComment.setText(author.getCommentAuthor());
                if (author.getDieDateAuthor() != null) {
                    jTextDeathDate.setText(df.format(author.getDieDateAuthor()));
                } else {
                    jTextDeathDate.setText("");
                }
            }
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "this Author isnt in Database");
        }
        try {
            Vector bookAttributes = null;
            for (Iterator itarator = catalogService.FindBooksByChamp("lastNameAuthor", jTextSearchAuthor.getText()).iterator(); itarator.hasNext();) {
                Book book = (Book) itarator.next();
                bookAttributes = new Vector();
                bookAttributes.add(book.getNumISBNBook());
                bookAttributes.add(book.getTitleBook());
                bookAttributes.add(book.getSubTitleBook());
                bookAttributes.add(book.getEditor());
                bookAttributes.add(book.getStockBook());
                bookAttributes.add(book.getUnitCostBook() + " €");
                tabModel.addRow(bookAttributes);
            }
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No books for this Author in Database");
        }
    }//GEN-LAST:event_jButtonSearchAuthorActionPerformed
    private void jComboBoxSelectedAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectedAuthorActionPerformed
        Author myAuthor = ((Author) jComboBoxSelectedAuthor.getSelectedItem());
        jTextSearchAuthor.setText(myAuthor.getLastNameAuthor());
        jButtonSearchAuthor.doClick();
    }//GEN-LAST:event_jComboBoxSelectedAuthorActionPerformed

    private void jButtonUpdateAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateAuthorActionPerformed
        Utility utils = new Utility();
        boolean verifiedAuthor = true;
        verifiedAuthor = controls();
        if (verifiedAuthor) {
            try {
                Author myAuthor = ((Author) jComboBoxSelectedAuthor.getSelectedItem());
                myAuthor.setLastNameAuthor(jTextLastName.getText());
                myAuthor.setFirstNameAuthor(jTextFirstName.getText());
                myAuthor.setCommentAuthor(jTextComment.getText());
                myAuthor.setBiographyAuthor(jTextBiography.getText());
                try {
                    if (!jTextBirthDate.getText().equals("")) {
                        myAuthor.setBirthDateAuthor(utils.formatStringToSQLDate(jTextBirthDate.getText()));
                    }
                    if (!jTextDeathDate.getText().equals("")) {
                        myAuthor.setDieDateAuthor(utils.formatStringToSQLDate(jTextDeathDate.getText()));
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erreur of sql date formatting");
                }

                int retour = JOptionPane.showConfirmDialog(this,
                        "Etes-Vous Sure de vouloir modifier l'autheur ? ",
                        "Update",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (retour == JOptionPane.CLOSED_OPTION || retour == JOptionPane.NO_OPTION) {
                    clearTab();
                    clearField();
                } else {
                    publishingService.updateAuthor(myAuthor);
                    JOptionPane.showMessageDialog(this, " Update Successfull !");
                    clearTab();
                    clearField();
                }
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Author not found ");
            } catch (UpdateException ex) {
                JOptionPane.showMessageDialog(this, "Error Updating Author to database");
            } catch (CheckException ex) {
                JOptionPane.showMessageDialog(this, "Error didnt pass the check control");
            }
        }


    }//GEN-LAST:event_jButtonUpdateAuthorActionPerformed
    private boolean controls() {
        Utility utils = new Utility();
        if (!utils.regexNom(jTextLastName.getText())) {
            if (jTextLastName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "AUTHOR's Name is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "AUTHOR's Name is invalid ", "warning", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        if (!jTextFirstName.getText().isEmpty()) {
            if (!utils.regexNom(jTextFirstName.getText())) {
                JOptionPane.showMessageDialog(this, "First name Author invalid ", "warning", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (!jTextBirthDate.getText().isEmpty()) {
            if (!utils.regexDate(jTextBirthDate.getText())) {
                JOptionPane.showMessageDialog(this, "birthDate invalid! format : YYYY-MM-DD ", "warning", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (!jTextDeathDate.getText().isEmpty()) {
            if (!utils.regexDate(jTextDeathDate.getText())) {
                JOptionPane.showMessageDialog(this, "DeathDate invalid! format : YYYY-MM-DD ", "warning", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSearchAuthor;
    private javax.swing.JButton jButtonUpdateAuthor;
    private javax.swing.JComboBox<String> jComboBoxSelectedAuthor;
    private javax.swing.JLabel jLabelBiography;
    private javax.swing.JLabel jLabelBirthDate;
    private javax.swing.JLabel jLabelComment;
    private javax.swing.JLabel jLabelDeathDate;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelSearchAuthor;
    private javax.swing.JLabel jLabelSelectedAuthor;
    private javax.swing.JPanel jPanelAuthors;
    private javax.swing.JPanel jPanelManageAuthors;
    private javax.swing.JPanel jPanelNewAuthor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneManageEvents;
    private javax.swing.JTable jTable;
    private javax.swing.JTextPane jTextBiography;
    private javax.swing.JTextField jTextBirthDate;
    private javax.swing.JTextPane jTextComment;
    private javax.swing.JTextField jTextDeathDate;
    private javax.swing.JTextField jTextFirstName;
    private javax.swing.JTextField jTextLastName;
    private javax.swing.JTextField jTextSearchAuthor;
    // End of variables declaration//GEN-END:variables
}
