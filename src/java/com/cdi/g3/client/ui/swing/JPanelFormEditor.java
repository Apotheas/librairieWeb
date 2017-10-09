package com.cdi.g3.client.ui.swing;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.catalog.Editor;
import com.cdi.g3.server.service.catalog.CatalogService;
import com.cdi.g3.server.service.publishing.PublishingService;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JPanelFormEditor extends javax.swing.JPanel {

    private final DefaultTableModel myModel = new DefaultTableModel();
    private final PublishingService publishingService = new PublishingService();
    private final CatalogService catalogService = new CatalogService();
    private final Vector editorList = new Vector();

    public JPanelFormEditor() {
        initComponents();
        myModel.addColumn("ISBN");
        myModel.addColumn("TITLE");
        myModel.addColumn("SUB-TITLE");
        myModel.addColumn("STOCK");
        myModel.addColumn("COST");
        jTable.setModel(myModel);
        jComboBoxSelectedEditor.setModel(initEditorModel());
    }

    private void clearTab() {
        int lignes = myModel.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            myModel.removeRow(i);
        }
    }

    private void clearField() {
        jTextName.setText(" ");

    }

    //___________EDITORS COMBOBOX MODEL_____________________//
    private DefaultComboBoxModel initEditorModel() {
        return new DefaultComboBoxModel(initEditorsVector());
    }

    private Vector initEditorsVector() {
        try {
            Collection v = publishingService.findAllEditor();
            editorList.addAll(v);
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "ERROR LOADING EDITORS COMBOBOX");
        }
        return editorList;
    }
    //______________________________________________________//

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEditors = new javax.swing.JPanel();
        jPanelInfosEditors = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jLabelName1 = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        jComboBoxStatus = new javax.swing.JComboBox();
        jPanelManageEditors = new javax.swing.JPanel();
        jScrollPaneManageEvents = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabelSelectedEdithor = new javax.swing.JLabel();
        jComboBoxSelectedEditor = new javax.swing.JComboBox<>();
        jButtonUpdateEdithor = new javax.swing.JButton();
        jLabelSearchEditor = new javax.swing.JLabel();
        jTextSearchEditor = new javax.swing.JTextField();
        jButtonSearchEditor = new javax.swing.JButton();

        jPanelInfosEditors.setBorder(javax.swing.BorderFactory.createTitledBorder("infoEditor"));

        jLabelName.setText("   Name  :");

        jLabelName1.setText("  Status   :");

        jTextName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNameActionPerformed(evt);
            }
        });

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Unactive" }));

        javax.swing.GroupLayout jPanelInfosEditorsLayout = new javax.swing.GroupLayout(jPanelInfosEditors);
        jPanelInfosEditors.setLayout(jPanelInfosEditorsLayout);
        jPanelInfosEditorsLayout.setHorizontalGroup(
            jPanelInfosEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfosEditorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelName1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        jPanelInfosEditorsLayout.setVerticalGroup(
            jPanelInfosEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfosEditorsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelInfosEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jLabelName1)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanelManageEditors.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage"));

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

        jLabelSelectedEdithor.setText("Selected Editor  :");

        jComboBoxSelectedEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectedEditorActionPerformed(evt);
            }
        });

        jButtonUpdateEdithor.setText("Update");
        jButtonUpdateEdithor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateEdithorActionPerformed(evt);
            }
        });

        jLabelSearchEditor.setText("Editor  :");

        jTextSearchEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchEditorActionPerformed(evt);
            }
        });

        jButtonSearchEditor.setText("Search");
        jButtonSearchEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchEditorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelManageEditorsLayout = new javax.swing.GroupLayout(jPanelManageEditors);
        jPanelManageEditors.setLayout(jPanelManageEditorsLayout);
        jPanelManageEditorsLayout.setHorizontalGroup(
            jPanelManageEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageEditorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSearchEditor)
                .addGap(18, 18, 18)
                .addComponent(jTextSearchEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSearchEditor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(jLabelSelectedEdithor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSelectedEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageEditorsLayout.createSequentialGroup()
                .addComponent(jScrollPaneManageEvents)
                .addContainerGap())
            .addGroup(jPanelManageEditorsLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButtonUpdateEdithor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelManageEditorsLayout.setVerticalGroup(
            jPanelManageEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageEditorsLayout.createSequentialGroup()
                .addGroup(jPanelManageEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelManageEditorsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelManageEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextSearchEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSearchEditor)
                            .addComponent(jLabelSearchEditor)
                            .addComponent(jComboBoxSelectedEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSelectedEdithor))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageEditorsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonUpdateEdithor)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPaneManageEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelEditorsLayout = new javax.swing.GroupLayout(jPanelEditors);
        jPanelEditors.setLayout(jPanelEditorsLayout);
        jPanelEditorsLayout.setHorizontalGroup(
            jPanelEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditorsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInfosEditors, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelManageEditors, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEditorsLayout.setVerticalGroup(
            jPanelEditorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInfosEditors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelManageEditors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEditors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelEditors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void jComboBoxSelectedEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectedEditorActionPerformed
        clearTab();
        Editor myEditor = ((Editor) jComboBoxSelectedEditor.getSelectedItem());
        jTextSearchEditor.setText(myEditor.getNameEditor());
        jButtonSearchEditor.doClick();
    }//GEN-LAST:event_jComboBoxSelectedEditorActionPerformed
    private void jButtonUpdateEdithorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateEdithorActionPerformed
        boolean verifiedEditor = true;
        verifiedEditor = controls();
        if (verifiedEditor) {
            try {
                Editor myEditor = ((Editor) jComboBoxSelectedEditor.getSelectedItem());
                myEditor.setNameEditor(jTextName.getText());
                int retour = JOptionPane.showConfirmDialog(this,
                        "Etes-Vous Sure de vouloir modifier l'Editeur ? ",
                        "Update",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (retour == JOptionPane.CLOSED_OPTION || retour == JOptionPane.NO_OPTION) {
                    clearTab();
                    clearField();
                } else {
                    publishingService.updateEditor(myEditor);
                    JOptionPane.showMessageDialog(this, " Update Successfull !");
                    clearTab();
                    clearField();
                }
            } catch (UpdateException ex) {
                JOptionPane.showMessageDialog(this, " Error updating editor !");
            } catch (CheckException ex) {
                JOptionPane.showMessageDialog(this, " Editor didnt pass check control !");
            }
        }
    }//GEN-LAST:event_jButtonUpdateEdithorActionPerformed
    private void jTextSearchEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchEditorActionPerformed

    }//GEN-LAST:event_jTextSearchEditorActionPerformed
    private void jButtonSearchEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchEditorActionPerformed
        clearTab();
        clearField();
        Editor myEditor = new Editor();
        try {
            myEditor = publishingService.findEditor("NAMEEDITOR", jTextSearchEditor.getText());
            jTextName.setText(myEditor.getNameEditor());
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, " this Editor isnt in Database ");
        }
        try {
            Vector bookAttributes = null;
            for (Iterator itarator = catalogService.FindBooksByChamp("NAMEEDITOR", jTextSearchEditor.getText()).iterator(); itarator.hasNext();) {
                Book book = (Book) itarator.next();
                bookAttributes = new Vector();
                bookAttributes.add(book.getNumISBNBook());
                bookAttributes.add(book.getTitleBook());
                bookAttributes.add(book.getSubTitleBook());
                bookAttributes.add(book.getStockBook());
                bookAttributes.add(book.getUnitCostBook() + " €");
                myModel.addRow(bookAttributes);
            }
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, " No books for this Editor on Database ");
        }
    }//GEN-LAST:event_jButtonSearchEditorActionPerformed
    private void jTextNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNameActionPerformed
    private boolean controls() {
        Utility utils = new Utility();
        if (!utils.regexNom(jTextName.getText())) {
            if (jTextName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "EDITOR's Name is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "EDITOR's Name is invalid ", "warning", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSearchEditor;
    private javax.swing.JButton jButtonUpdateEdithor;
    private javax.swing.JComboBox<String> jComboBoxSelectedEditor;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JLabel jLabelSearchEditor;
    private javax.swing.JLabel jLabelSelectedEdithor;
    private javax.swing.JPanel jPanelEditors;
    private javax.swing.JPanel jPanelInfosEditors;
    private javax.swing.JPanel jPanelManageEditors;
    private javax.swing.JScrollPane jScrollPaneManageEvents;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextSearchEditor;
    // End of variables declaration//GEN-END:variables
}
