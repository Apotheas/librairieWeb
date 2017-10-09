/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.client.ui.swing;

import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.catalog.Author;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.catalog.Editor;
import com.cdi.g3.server.domain.catalog.SubTheme;
import com.cdi.g3.server.domain.catalog.Theme;
import com.cdi.g3.server.domain.customers.Appreciation;
import com.cdi.g3.server.service.catalog.CatalogService;
import com.cdi.g3.server.service.catalog.ThemeService;
import com.cdi.g3.server.service.publishing.PublishingService;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Apotheas
 */
public class JPanelFormThemes extends javax.swing.JPanel {

    DefaultTableModel tableModel = new DefaultTableModel();
    private ThemeService themeService = new ThemeService();
    private CatalogService catalogService = new CatalogService();
    private PublishingService publishingService = new PublishingService();
    private Vector themeList = new Vector();
    private Vector subThemeList = new Vector();
    private Vector bookList = new Vector();

    public JPanelFormThemes() {
        initComponents();
        initColumnTab();
        jComboBoxSelectedTheme.setModel(initThemeModel());
        jComboBoxSelectedThemeSub.setModel(initThemeModel());
        jComboBoxTreeView.setModel(initTreeViewModel());
        jTree.setModel(initAuthorTreeModel());
        jTableView.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                selectLineWaiting(evt);
            }
        });
    }

    //___________Theme COMBOBOX MODEL_______________//
    private DefaultComboBoxModel initThemeModel() {
        return new DefaultComboBoxModel(initThemeVector());
    }

    private Vector initThemeVector() {
        themeList.removeAllElements();
        Collection v = themeService.findAllThemes();
        themeList.addAll(v);

        return themeList;
    }
    //_______________________________________________//

    //___________sub-Theme COMBOBOX MODEL_______________//
    private DefaultComboBoxModel initSubThemeModel() {
        return new DefaultComboBoxModel(initSubThemeVector());
    }

    private Vector initSubThemeVector() {
        subThemeList.removeAllElements();
        Theme theme = (Theme) jComboBoxSelectedTheme.getSelectedItem();
        Collection v;
        try {
            v = themeService.findAllSubForATheme("NAMETHEMESB", theme.getNameTheme());
            subThemeList.addAll(v);
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "NO SUBTHEME FOR THIS THEME");
        }

        return subThemeList;
    }

    //_______________________________________________//
    //___________TREEVIEW-BY COMBOBOX MODEL_______________//
    private DefaultComboBoxModel initTreeViewModel() {
        return new DefaultComboBoxModel(initTreeViewVector());
    }

    private Vector initTreeViewVector() {
        Vector searchList = new Vector();
        searchList.add("Tree view by :");
        searchList.add("Authors");
        searchList.add("Editors");
        searchList.add("Themes");
        return searchList;
    }

    //________________JTREE Author MODELS___________________//
    private DefaultTreeModel initAuthorTreeModel() {
        return new DefaultTreeModel(initByAuthorTree());
    }

    private DefaultMutableTreeNode initByAuthorTree() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Authors");
        DefaultMutableTreeNode tnAuthors = null;
        DefaultMutableTreeNode tnBook = null;
        try {
            for (Iterator iteratorA = publishingService.FindAllAuthor().iterator(); iteratorA.hasNext();) {
                Author author = (Author) iteratorA.next();
                tnAuthors = new DefaultMutableTreeNode(author);
                root.add(tnAuthors);

                for (Iterator iteratorB = catalogService.FindBooksByChamp("idAuthor", author.getId()).iterator(); iteratorB.hasNext();) {
                    Book book = (Book) iteratorB.next();
                    tnBook = new DefaultMutableTreeNode(book);
                    tnAuthors.add(tnBook);

                }

            }
        } catch (ObjectNotFoundException ex) {

        }
        return root;
    }
    //______________________________________________________//

    //________________JTREE Editor MODELS____________________//
    private DefaultTreeModel initEditorTreeModel() {

        return new DefaultTreeModel(initByEditorTree());
    }

    private DefaultMutableTreeNode initByEditorTree() {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Editors");
        DefaultMutableTreeNode tnEditors = null;
        DefaultMutableTreeNode tnBook = null;
        try {
            for (Iterator iteratorA = publishingService.findAllEditor().iterator(); iteratorA.hasNext();) {
                Editor editor = (Editor) iteratorA.next();
                tnEditors = new DefaultMutableTreeNode(editor);
                root.add(tnEditors);
                try {
                    for (Iterator iteratorB = catalogService.FindBooksByChamp("idEditor", editor.getId()).iterator(); iteratorB.hasNext();) {
                        Book book = (Book) iteratorB.next();
                        tnBook = new DefaultMutableTreeNode(book);
                        tnEditors.add(tnBook);
                    }
                } catch (ObjectNotFoundException ex) {

                }
            }
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(JPanelFormBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return root;
    }

    //______________________________________________________//
    //________________JTREE Theme MODELS____________________//
    private DefaultTreeModel initTreeThemeModel() {

        return new DefaultTreeModel(initByThemeTree());
    }

    private DefaultMutableTreeNode initByThemeTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Themes");
        DefaultMutableTreeNode tnTheme = null;
        DefaultMutableTreeNode tnSubTheme = null;
        DefaultMutableTreeNode tnBook = null;
        for (Iterator iteratorA = themeService.findAllThemes().iterator(); iteratorA.hasNext();) {
            Theme theme = (Theme) iteratorA.next();
            tnTheme = new DefaultMutableTreeNode(theme);
            root.add(tnTheme);
            try {
                for (Iterator iteratorB = themeService.findAllSubForATheme("NAMETHEMESB", theme.getNameTheme()).iterator(); iteratorB.hasNext();) {
                    SubTheme sub = (SubTheme) iteratorB.next();
                    tnSubTheme = new DefaultMutableTreeNode(sub);
                    tnTheme.add(tnSubTheme);
                    for (Iterator iteratorC = catalogService.FindBooksBySub(sub.getNameSubTheme(), theme.getNameTheme()).iterator(); iteratorC.hasNext();) {
                        Book book = (Book) iteratorC.next();
                        tnBook = new DefaultMutableTreeNode(book);
                        tnSubTheme.add(tnBook);
                    }
                }
            } catch (ObjectNotFoundException ex) {
            }
        }
        return root;
    }
    //______________________________________________________//
    private void selectLineWaiting(ListSelectionEvent evt) {
        ListSelectionModel lsm = (ListSelectionModel) evt.getSource();
        if (lsm.isSelectionEmpty()) {
            System.out.println("No rows selected");
        } else {
            int selectedRow = lsm.getMinSelectionIndex();
            Book book = (Book) bookList.get(selectedRow);
            jTextInsert.setText(book.getTitleBook());
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

        jPanelThemes = new javax.swing.JPanel();
        jPanelNewTheme = new javax.swing.JPanel();
        jLabelTheme = new javax.swing.JLabel();
        jTextTheme = new javax.swing.JTextField();
        jButtonCreateTheme = new javax.swing.JButton();
        jPanelManage = new javax.swing.JPanel();
        jScrollPaneManage = new javax.swing.JScrollPane();
        jTableView = new javax.swing.JTable();
        jLabelSelectedTheme = new javax.swing.JLabel();
        jComboBoxSelectedTheme = new javax.swing.JComboBox<>();
        jLabelInsert = new javax.swing.JLabel();
        jTextInsert = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonDeleteInsert = new javax.swing.JButton();
        jComboBoxSelectedSubTheme = new javax.swing.JComboBox<>();
        jLabelSelectedSubTheme = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jComboBoxTreeView = new javax.swing.JComboBox<>();
        jPanelNewSubTheme = new javax.swing.JPanel();
        jLabelSubTheme = new javax.swing.JLabel();
        jTextSubTheme = new javax.swing.JTextField();
        jButtonCreateSubTheme = new javax.swing.JButton();
        jLabelSelectedThemeSub = new javax.swing.JLabel();
        jComboBoxSelectedThemeSub = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        jPanelThemes.setLayout(null);

        jPanelNewTheme.setBorder(javax.swing.BorderFactory.createTitledBorder("New Theme"));

        jLabelTheme.setText("Theme  :");

        jTextTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextThemeActionPerformed(evt);
            }
        });

        jButtonCreateTheme.setText("Create");
        jButtonCreateTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateThemeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNewThemeLayout = new javax.swing.GroupLayout(jPanelNewTheme);
        jPanelNewTheme.setLayout(jPanelNewThemeLayout);
        jPanelNewThemeLayout.setHorizontalGroup(
            jPanelNewThemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewThemeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTheme)
                .addGap(18, 18, 18)
                .addComponent(jTextTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCreateTheme)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelNewThemeLayout.setVerticalGroup(
            jPanelNewThemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewThemeLayout.createSequentialGroup()
                .addGroup(jPanelNewThemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTheme)
                    .addComponent(jTextTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCreateTheme))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanelThemes.add(jPanelNewTheme);
        jPanelNewTheme.setBounds(20, 480, 350, 80);

        jPanelManage.setBorder(javax.swing.BorderFactory.createTitledBorder("Manage"));

        jTableView.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneManage.setViewportView(jTableView);

        jLabelSelectedTheme.setText("Selected Theme :");

        jComboBoxSelectedTheme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSelectedTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectedThemeActionPerformed(evt);
            }
        });

        jLabelInsert.setText("Title :");

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDeleteInsert.setText("Delete");
        jButtonDeleteInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteInsertActionPerformed(evt);
            }
        });

        jComboBoxSelectedSubTheme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "subTheme" }));
        jComboBoxSelectedSubTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectedSubThemeActionPerformed(evt);
            }
        });

        jLabelSelectedSubTheme.setText("Selected subTheme :");

        jTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        jComboBoxTreeView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTreeView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTreeViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelManageLayout = new javax.swing.GroupLayout(jPanelManage);
        jPanelManage.setLayout(jPanelManageLayout);
        jPanelManageLayout.setHorizontalGroup(
            jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneManage)
                    .addGroup(jPanelManageLayout.createSequentialGroup()
                        .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelManageLayout.createSequentialGroup()
                                .addComponent(jLabelSelectedTheme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxSelectedTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelManageLayout.createSequentialGroup()
                                .addComponent(jLabelSelectedSubTheme)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSelectedSubTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
                        .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageLayout.createSequentialGroup()
                                .addComponent(jButtonAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDeleteInsert)
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelManageLayout.createSequentialGroup()
                                .addComponent(jLabelInsert)
                                .addGap(18, 18, 18)
                                .addComponent(jTextInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTreeView, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelManageLayout.setVerticalGroup(
            jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManageLayout.createSequentialGroup()
                .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelManageLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSelectedTheme)
                            .addComponent(jComboBoxSelectedTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSelectedSubTheme)
                            .addComponent(jComboBoxSelectedSubTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelManageLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelInsert)
                            .addComponent(jTextInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdd)
                            .addComponent(jButtonDeleteInsert))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneManage, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
            .addGroup(jPanelManageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxTreeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        jPanelThemes.add(jPanelManage);
        jPanelManage.setBounds(0, 0, 1150, 463);

        jPanelNewSubTheme.setBorder(javax.swing.BorderFactory.createTitledBorder("New SubTheme"));

        jLabelSubTheme.setText("subTheme  :");

        jTextSubTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSubThemeActionPerformed(evt);
            }
        });

        jButtonCreateSubTheme.setText("Create");
        jButtonCreateSubTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateSubThemeActionPerformed(evt);
            }
        });

        jLabelSelectedThemeSub.setText("Selected Theme :");

        jComboBoxSelectedThemeSub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelNewSubThemeLayout = new javax.swing.GroupLayout(jPanelNewSubTheme);
        jPanelNewSubTheme.setLayout(jPanelNewSubThemeLayout);
        jPanelNewSubThemeLayout.setHorizontalGroup(
            jPanelNewSubThemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNewSubThemeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSelectedThemeSub)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSelectedThemeSub, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelSubTheme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextSubTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButtonCreateSubTheme)
                .addGap(14, 14, 14))
        );
        jPanelNewSubThemeLayout.setVerticalGroup(
            jPanelNewSubThemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNewSubThemeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelNewSubThemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSelectedThemeSub)
                    .addComponent(jComboBoxSelectedThemeSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextSubTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSubTheme)
                    .addComponent(jButtonCreateSubTheme))
                .addGap(53, 53, 53))
        );

        jPanelThemes.add(jPanelNewSubTheme);
        jPanelNewSubTheme.setBounds(560, 480, 590, 80);

        add(jPanelThemes, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    private void jTextThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextThemeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextThemeActionPerformed
    private void jButtonDeleteInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteInsertActionPerformed
        if (jTextInsert.getSelectedText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Book book = (Book) catalogService.FindBookByChamp("TITREBOOK", jTextInsert.getText());
                SubTheme sub = (SubTheme) jComboBoxSelectedSubTheme.getSelectedItem();
                try {
                    themeService.deleteBookFromSub(book.getId(), sub.getIdSubTheme());
                    JOptionPane.showMessageDialog(this, " Book delete with success from :  " + sub.getNameSubTheme());
                } catch (DuplicateKeyException ex) {
                    JOptionPane.showMessageDialog(this, " This book wasnt on selected subtheme ");
                }
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, " Book Not in Database ");
            }
        }
    }//GEN-LAST:event_jButtonDeleteInsertActionPerformed
    private void jTextSubThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSubThemeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSubThemeActionPerformed
    private void jComboBoxSelectedThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectedThemeActionPerformed
        clearTab();
        jComboBoxSelectedSubTheme.setModel(initSubThemeModel());
        Theme theme = (Theme) jComboBoxSelectedTheme.getSelectedItem();
        initTableauThemeSettings(theme.getNameTheme());

    }//GEN-LAST:event_jComboBoxSelectedThemeActionPerformed
    private void initColumnTab() {
        tableModel.addColumn("ISBN");
        tableModel.addColumn("AUTHOR");
        tableModel.addColumn("EDITOR");
        tableModel.addColumn("TITLE");
        tableModel.addColumn("SUB-TITLE");
        tableModel.addColumn("STOCK");
        tableModel.addColumn("COST");
    }

    private void clearTab() {
        int lignes = tableModel.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    private void initTableauThemeSettings(String theme) {
        Vector bookAttributes = null;
        bookList.removeAllElements();
        try {
            for (Iterator itarator = catalogService.FindBooksByTheme(theme).iterator(); itarator.hasNext();) {
                Book book = (Book) itarator.next();
                bookAttributes = new Vector();
                bookAttributes.add(book.getNumISBNBook());
                for (Iterator it = publishingService.findAuthorByISBN("NUMISBNBOOK", book.getNumISBNBook()).iterator(); it.hasNext();) {
                    Author author = (Author) it.next();
                    bookAttributes.add(author.toString());
                }
                bookAttributes.add(publishingService.findEditorByChamp("NUMISBNBOOK", book.getNumISBNBook()));
                bookAttributes.add(book.getTitleBook());
                bookAttributes.add(book.getSubTitleBook());
                bookAttributes.add(book.getStockBook());
                bookAttributes.add(book.getUnitCostBook() + " €");
                tableModel.addRow(bookAttributes);
                bookList.add(book);
            }
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "BOOK NOT FOUND");
        }
    }

    private void subTableauSubSettings(String theme, String sub) {
        Vector bookAttributes = null;
        bookList.removeAllElements();
        try {
            for (Iterator itarator = catalogService.FindBooksBySub(theme, sub).iterator(); itarator.hasNext();) {
                Book book = (Book) itarator.next();

                bookAttributes = new Vector();
                bookAttributes.add(book.getNumISBNBook());
                for (Iterator it = publishingService.findAuthorByISBN("NUMISBNBOOK", book.getNumISBNBook()).iterator(); it.hasNext();) {
                    Author author = (Author) it.next();
                    bookAttributes.add(author.toString());
                }
                bookAttributes.add(publishingService.findEditorByChamp("NUMISBNBOOK", book.getNumISBNBook()));
                bookAttributes.add(book.getTitleBook());
                bookAttributes.add(book.getSubTitleBook());
                bookAttributes.add(book.getStockBook());
                bookAttributes.add(book.getUnitCostBook() + " €");
                tableModel.addRow(bookAttributes);
                bookList.add(book);
            }
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "BOOK NOT FOUND");
        }
    }
    private void jComboBoxSelectedSubThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectedSubThemeActionPerformed
        clearTab();
        if (jComboBoxSelectedSubTheme.getSelectedItem() instanceof SubTheme) {
            SubTheme sub = (SubTheme) jComboBoxSelectedSubTheme.getSelectedItem();
            subTableauSubSettings(sub.getNameSubTheme(), sub.getNameTheme());
            jTableView.setModel(tableModel);;
        }
    }//GEN-LAST:event_jComboBoxSelectedSubThemeActionPerformed

    private void jButtonCreateThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateThemeActionPerformed
        boolean verifiedTheme = true;
        verifiedTheme = controlsTheme();
        if (verifiedTheme) {
            Theme theme = new Theme();
            theme.setNameTheme(jTextTheme.getText());
            try {
                themeService.insertTheme(theme);
                JOptionPane.showMessageDialog(this, "New Theme Create with Success ! ");
            } catch (DuplicateKeyException ex) {
                JOptionPane.showMessageDialog(this, "ERROR PRIMARY KEY ALREADY EXIST");
            }
            jComboBoxSelectedTheme.setModel(initThemeModel());
        }
    }//GEN-LAST:event_jButtonCreateThemeActionPerformed

    private void jButtonCreateSubThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateSubThemeActionPerformed
        boolean verifiedSubTheme = true;
        verifiedSubTheme = controlsSubTheme();
        if (verifiedSubTheme) {
            SubTheme subTheme = new SubTheme();
            Theme theme = (Theme) jComboBoxSelectedThemeSub.getSelectedItem();
            subTheme.setNameSubTheme(jTextSubTheme.getText());
            subTheme.setNameTheme(theme.getNameTheme());
            try {
                themeService.insertSubTheme(subTheme);
                JOptionPane.showMessageDialog(this, "New SubTheme Add To : " + theme.getNameTheme() + " with Success ! ");
            } catch (DuplicateKeyException ex) {
                JOptionPane.showMessageDialog(this, "ERROR PRIMARY KEY ALREADY EXIST");
            }
        }
    }//GEN-LAST:event_jButtonCreateSubThemeActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        boolean verifiedInsert = true;
        verifiedInsert = controlInsert();
        SubTheme sub = (SubTheme) jComboBoxSelectedSubTheme.getSelectedItem();
        if (verifiedInsert) {
            Book book = null;
            try {
                book = (Book) catalogService.FindBookByChamp("TITREBOOK", jTextInsert.getText());
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "THIS TITLE DONT BELONG TO AN ISBN");
            }
            try {
                themeService.insertBookToSub(book.getNumISBNBook(), sub.getIdSubTheme());
                JOptionPane.showMessageDialog(this, "Book Add with success to : " + sub.getNameSubTheme());
            } catch (DuplicateKeyException ex) {
                JOptionPane.showMessageDialog(this, "ERROR PRIMARY KEY ALREADY EXIST");
            }
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jComboBoxTreeViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTreeViewActionPerformed
        if (jComboBoxTreeView.getSelectedItem().equals("Authors")) {
            jTree.setModel(initAuthorTreeModel());
        }
        if (jComboBoxTreeView.getSelectedItem().equals("Editors")) {
            jTree.setModel(initEditorTreeModel());
        }
        if (jComboBoxTreeView.getSelectedItem().equals("Themes")) {
            jTree.setModel(initTreeThemeModel());
        }
    }//GEN-LAST:event_jComboBoxTreeViewActionPerformed
    private void jTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeMouseClicked
        DefaultMutableTreeNode tn = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
        if (tn != null) {
            if (tn.getUserObject() instanceof Book) {
                Book book = ((Book) tn.getUserObject());
                jTextInsert.setText(book.getTitleBook());
            }
        }
    }//GEN-LAST:event_jTreeMouseClicked
    private boolean controlInsert() {
        Utility utils = new Utility();
        if (!utils.regexNom(jTextInsert.getText())) {
            if (jTextInsert.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Title  is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        Book book = null;
        try {
            book = (Book) catalogService.FindBookByChamp("TITREBOOK", jTextInsert.getText());
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "THIS TITLE DONT BELONG TO AN EXISTING ISBN");
            return false;
        }

        SubTheme sub = (SubTheme) jComboBoxSelectedSubTheme.getSelectedItem();
        if (themeService.verifIfBookSubExist(sub.getIdSubTheme(), book.getNumISBNBook())) {
        } else {
            JOptionPane.showMessageDialog(this, "Book Already Associate To This SubTheme ", "warning", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean controlsTheme() {
        Utility utils = new Utility();
        if (!utils.regexNom(jTextTheme.getText())) {
            if (jTextTheme.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Theme name is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Theme name is invalid ", "warning", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        if (themeService.VerifIfThemeExist("NAMETHEME", jTextTheme.getText())) {
        } else {
            JOptionPane.showMessageDialog(this, "Theme name already exist ", "warning", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean controlsSubTheme() {
        Utility utils = new Utility();
        if (!utils.regexNom(jTextSubTheme.getText())) {
            if (jTextSubTheme.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "SubTheme name is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "SubTheme name is invalid ", "warning", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        Theme theme = (Theme) jComboBoxSelectedThemeSub.getSelectedItem();
        if (themeService.verifIfSubExist(jTextSubTheme.getText(), theme.getNameTheme())) {
        } else {
            JOptionPane.showMessageDialog(this, "SubTheme name already exist for This Theme ", "warning", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCreateSubTheme;
    private javax.swing.JButton jButtonCreateTheme;
    private javax.swing.JButton jButtonDeleteInsert;
    private javax.swing.JComboBox<String> jComboBoxSelectedSubTheme;
    private javax.swing.JComboBox<String> jComboBoxSelectedTheme;
    private javax.swing.JComboBox<String> jComboBoxSelectedThemeSub;
    private javax.swing.JComboBox<String> jComboBoxTreeView;
    private javax.swing.JLabel jLabelInsert;
    private javax.swing.JLabel jLabelSelectedSubTheme;
    private javax.swing.JLabel jLabelSelectedTheme;
    private javax.swing.JLabel jLabelSelectedThemeSub;
    private javax.swing.JLabel jLabelSubTheme;
    private javax.swing.JLabel jLabelTheme;
    private javax.swing.JPanel jPanelManage;
    private javax.swing.JPanel jPanelNewSubTheme;
    private javax.swing.JPanel jPanelNewTheme;
    private javax.swing.JPanel jPanelThemes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneManage;
    private javax.swing.JTable jTableView;
    private javax.swing.JTextField jTextInsert;
    private javax.swing.JTextField jTextSubTheme;
    private javax.swing.JTextField jTextTheme;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables
}
