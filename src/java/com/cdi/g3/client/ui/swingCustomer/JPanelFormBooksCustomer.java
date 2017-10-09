/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.client.ui.swingCustomer;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.catalog.Author;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.catalog.Editor;
import com.cdi.g3.server.domain.other.CodeTVA;
import com.cdi.g3.server.service.catalog.CatalogService;
import com.cdi.g3.server.service.other.OtherService;
import com.cdi.g3.server.service.publishing.PublishingService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Apotheas
 */
public class JPanelFormBooksCustomer extends javax.swing.JPanel {

    private DefaultTableModel tabModel = new DefaultTableModel();
    private PublishingService publishingService = new PublishingService();
    private CatalogService catalogService = new CatalogService();
    private OtherService otherService = new OtherService();
    private Vector tvaList = new Vector();
    private Vector authorsList = new Vector();
    private Vector<Author> newAuthorList = new Vector();

    public JPanelFormBooksCustomer() {
        initComponents();
        tabModel.addColumn("ISBN");
        tabModel.addColumn("AUTHOR");
        tabModel.addColumn("EDITOR");
        tabModel.addColumn("TITLE");
        tabModel.addColumn("SUB-TITLE");
        tabModel.addColumn("STOCK");
        tabModel.addColumn("COST");
        jTree.setModel(initAuthorTreeModel());
        jTable.setModel(tabModel);
        jComboBoxTreeView.setModel(initTreeViewModel());
        jComboBoxSearchBy.setModel(initSearchByModel());
        jComboBoxTVA.setModel(initTVAModel());

        tabViewAll();
    }

    //___________SEARCH-BY COMBOBOX MODEL_______________//
    private DefaultComboBoxModel initSearchByModel() {
        return new DefaultComboBoxModel(initSearchVector());
    }

    private Vector initSearchVector() {
        Vector searchList = new Vector();
        searchList.add("Title");
        searchList.add("ISBN");

        return searchList;
    }

    //______________________________________________________//
    //___________UPDATE BY COMBOBOX MODEL_______________//
    private DefaultComboBoxModel initUpdateByModel() {
        return new DefaultComboBoxModel(initSUpdateByVector());
    }

    private Vector initSUpdateByVector() {
        Vector searchList = new Vector();
        searchList.add("Title");
        searchList.add("ISBN");
        return searchList;
    }
    //______________________________________________________//

    //___________TREEVIEW-BY COMBOBOX MODEL_______________//
    private DefaultComboBoxModel initTreeViewModel() {
        return new DefaultComboBoxModel(initTreeViewVector());
    }

    private Vector initTreeViewVector() {
        Vector searchList = new Vector();
        searchList.add("Tree view by :");
        searchList.add("Authors");
        searchList.add("Editors");
         return searchList;
    }

    //___________Authors COMBOBOX MODEL_______________//
    private DefaultComboBoxModel initAuthorsModel() {
        return new DefaultComboBoxModel(initAuthorsVector());
    }

    private Vector initAuthorsVector() {
        try {

            Collection v = publishingService.findAuthorByChamp("NUMISBNBOOK", jTextISBN.getText());
            authorsList.add(v);
        } catch (ObjectNotFoundException ex) {

        }
        return authorsList;
    }
    //______________________________________________________//

    //_______________TVA COMBOBOX MODEL_____________________//
    private DefaultComboBoxModel initTVAModel() {
        return new DefaultComboBoxModel(initTVAVector());
    }

    private Vector initTVAVector() {
        OtherService otherService = new OtherService();
        try {
            Collection v = otherService.findCodeTva();
            tvaList.addAll(v);
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "ERROR LOADING TVA COMBOBOX");
        }
        return tvaList;
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
            Logger.getLogger(JPanelFormBooksCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return root;
    }
    //______________________________________________________//

    private void clearTab() {
        int lignes = tabModel.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            tabModel.removeRow(i);
        }
    }

    private void synchTree() {
        jComboBoxTreeView.setModel(initTreeViewModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneConsult1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelConsult1 = new javax.swing.JPanel();
        jLabelSearch1 = new javax.swing.JLabel();
        jTextSearch1 = new javax.swing.JTextField();
        jButtonSearch1 = new javax.swing.JButton();
        jComboBoxSearchBy1 = new javax.swing.JComboBox<>();
        jButtonViewAll1 = new javax.swing.JButton();
        jTabbedPaneStock = new javax.swing.JTabbedPane();
        jPanelConsult = new javax.swing.JPanel();
        jScrollPaneConsult = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabelSearch = new javax.swing.JLabel();
        jTextSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jComboBoxSearchBy = new javax.swing.JComboBox<>();
        jButtonViewAll = new javax.swing.JButton();
        jPanelManage = new javax.swing.JPanel();
        jScrollPaneTree = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanelBook = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelISBN = new javax.swing.JLabel();
        jLabelEditor = new javax.swing.JLabel();
        jLabelPrice = new javax.swing.JLabel();
        jLabelWeight = new javax.swing.JLabel();
        jLabelLargeSize = new javax.swing.JLabel();
        jTextISBN = new javax.swing.JTextField();
        jTextStock = new javax.swing.JTextField();
        jTextWeight = new javax.swing.JTextField();
        jLabelFrontCover = new javax.swing.JLabel();
        jTextTitle = new javax.swing.JTextField();
        jTextLargeSize = new javax.swing.JTextField();
        jLabelStock = new javax.swing.JLabel();
        jTextPrice = new javax.swing.JTextField();
        jLabelSynopsis = new javax.swing.JLabel();
        jTextEditor = new javax.swing.JTextField();
        jLabelLongSize = new javax.swing.JLabel();
        jTextLongSize = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneSynopsis = new javax.swing.JTextPane();
        jComboBoxTVA = new javax.swing.JComboBox();
        jLabelTVA = new javax.swing.JLabel();
        jLabelTitle1 = new javax.swing.JLabel();
        jTextSubTitle = new javax.swing.JTextField();
        jLabelTVAText = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();
        jComboBoxAuthors = new javax.swing.JComboBox<>();
        jComboBoxTreeView = new javax.swing.JComboBox<>();

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Title", "Author", "Publisher", "Price", "Stock"
            }
        ));
        jScrollPaneConsult1.setViewportView(jTable1);

        jPanelConsult1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock Finder", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabelSearch1.setText("Search by   :");

        jTextSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearch1ActionPerformed(evt);
            }
        });

        jButtonSearch1.setText("Search");
        jButtonSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearch1ActionPerformed(evt);
            }
        });

        jComboBoxSearchBy1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "ISBN", "Author", "Editor" }));

        jButtonViewAll1.setText("view All");
        jButtonViewAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewAll1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsult1Layout = new javax.swing.GroupLayout(jPanelConsult1);
        jPanelConsult1.setLayout(jPanelConsult1Layout);
        jPanelConsult1Layout.setHorizontalGroup(
            jPanelConsult1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsult1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabelSearch1)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSearchBy1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSearch1)
                .addGap(118, 118, 118)
                .addComponent(jButtonViewAll1)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanelConsult1Layout.setVerticalGroup(
            jPanelConsult1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsult1Layout.createSequentialGroup()
                .addGroup(jPanelConsult1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch1)
                    .addComponent(jComboBoxSearchBy1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonViewAll1))
                .addGap(541, 541, 541))
        );

        setLayout(new java.awt.BorderLayout());

        jPanelConsult.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock Finder", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTable.setAutoCreateRowSorter(true);
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Title", "Author", "Publisher", "Price", "Stock"
            }
        ));
        jScrollPaneConsult.setViewportView(jTable);

        jLabelSearch.setText("Search by   :");

        jTextSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchActionPerformed(evt);
            }
        });

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jComboBoxSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "ISBN", "Author", "Editor" }));

        jButtonViewAll.setText("view All");
        jButtonViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelConsultLayout = new javax.swing.GroupLayout(jPanelConsult);
        jPanelConsult.setLayout(jPanelConsultLayout);
        jPanelConsultLayout.setHorizontalGroup(
            jPanelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConsultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneConsult)
                .addContainerGap())
            .addGroup(jPanelConsultLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabelSearch)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSearch)
                .addGap(118, 118, 118)
                .addComponent(jButtonViewAll)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanelConsultLayout.setVerticalGroup(
            jPanelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConsultLayout.createSequentialGroup()
                .addGroup(jPanelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch)
                    .addComponent(jComboBoxSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonViewAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneConsult, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneStock.addTab("Consult", jPanelConsult);

        jTree.setBorder(javax.swing.BorderFactory.createTitledBorder("Select"));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Author");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Cremades Bruno");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("blue");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("violet");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("red");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("yellow");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Rolando Izet");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("basketball");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("soccer");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("football");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hockey");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Zerbib Jonathan");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hot dogs");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("pizza");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("ravioli");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("bananas");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeMouseClicked(evt);
            }
        });
        jScrollPaneTree.setViewportView(jTree);

        jPanelBook.setBorder(javax.swing.BorderFactory.createTitledBorder("book"));

        jLabelTitle.setText("Title  :");

        jLabelISBN.setText("Isbn  :");

        jLabelEditor.setText("Editor  :");

        jLabelPrice.setText("Price  :");

        jLabelWeight.setText("Weight  :");

        jLabelLargeSize.setText("Large size :");

        jLabelFrontCover.setText("           Front Cover");

        jLabelStock.setText("Stock  :");

        jLabelSynopsis.setText("Synopsis  :");

        jLabelLongSize.setText("Long size  :");

        jScrollPane1.setViewportView(jTextPaneSynopsis);

        jComboBoxTVA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "general", "Item 2", "Item 3", "Item 4" }));

        jLabelTVA.setText("Tva : ");

        jLabelTitle1.setText("Sub-Title  :");

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jComboBoxAuthors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book's Authors", "" }));

        javax.swing.GroupLayout jPanelBookLayout = new javax.swing.GroupLayout(jPanelBook);
        jPanelBook.setLayout(jPanelBookLayout);
        jPanelBookLayout.setHorizontalGroup(
            jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelBookLayout.createSequentialGroup()
                                    .addComponent(jLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelBookLayout.createSequentialGroup()
                                    .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitle)
                                        .addComponent(jLabelISBN))
                                    .addGap(42, 42, 42)
                                    .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelBookLayout.createSequentialGroup()
                                            .addComponent(jTextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jTextISBN)))
                                .addGroup(jPanelBookLayout.createSequentialGroup()
                                    .addComponent(jLabelEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addComponent(jLabelTVA)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBoxTVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(78, 78, 78)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addComponent(jComboBoxAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE))
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabelTVAText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelWeight)
                                    .addComponent(jLabelLargeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLongSize, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextLongSize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextLargeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addComponent(jLabelSynopsis)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFrontCover, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPrice)
                            .addComponent(jLabelStock))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextStock, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBookLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonClear)
                .addGap(21, 21, 21))
        );
        jPanelBookLayout.setVerticalGroup(
            jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookLayout.createSequentialGroup()
                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFrontCover, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelISBN)
                            .addComponent(jComboBoxAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTitle))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTitle1)
                            .addComponent(jTextSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEditor)
                            .addComponent(jTextEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLargeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextLargeSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLongSize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextLongSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTVAText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelTVA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addComponent(jLabelSynopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jButtonClear)))
                .addGap(22, 22, 22))
        );

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
                .addGap(6, 6, 6)
                .addGroup(jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTreeView, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelManageLayout.setVerticalGroup(
            jPanelManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelManageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxTreeView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTree, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelManageLayout.createSequentialGroup()
                .addComponent(jPanelBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPaneStock.addTab("Details", jPanelManage);

        add(jTabbedPaneStock, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSearchActionPerformed
    private void setBookToField(Book book) throws ObjectNotFoundException {
        authorsList.removeAllElements();
        jTextISBN.setText(book.getId());
        jTextSubTitle.setText(book.getSubTitleBook());
        jTextPrice.setText(String.valueOf(book.getUnitCostBook()));
        jTextTitle.setText(book.getTitleBook());
       
        jTextPaneSynopsis.setText(book.getSynopsisBook());
      
        jTextWeight.setText(String.valueOf(book.getWeightBook()));
        jTextLargeSize.setText(String.valueOf(book.getSizeLargeBook()));
        jTextLongSize.setText(String.valueOf(book.getSizeLongBook()));
        jTextStock.setText(String.valueOf(book.getStockBook()));
        Editor editor = (Editor) publishingService.findEditorByChamp("numisbnbook", book.getId());
        jTextEditor.setText(editor.getNameEditor());
        jComboBoxTVA.getModel().setSelectedItem("reduced");
        jComboBoxTVA.setSelectedItem(book.getCodeTva().getTypeTva());
        jComboBoxAuthors.setModel(initAuthorsModel());

    }
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        clearTab();
        if (jComboBoxSearchBy.getSelectedItem().equals("Title")) {
            searchTableauSettings("TITREBOOK", jTextSearch.getText());
        }
        if (jComboBoxSearchBy.getSelectedItem().equals("ISBN")) {
            searchTableauSettings("NUMISBNBOOK", jTextSearch.getText());
        }


    }//GEN-LAST:event_jButtonSearchActionPerformed
    private void searchTableauSettings(String column, String champ) {
        Vector bookAttributes = null;
        try {
            for (Iterator itarator = catalogService.FindBooksByChamp(column, champ).iterator(); itarator.hasNext();) {
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
                tabModel.addRow(bookAttributes);
            }
        } catch (ObjectNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "BOOK NOT FOUND");
        }

    }
    private void jTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeMouseClicked
        DefaultMutableTreeNode tn = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();

        if (tn != null) {
            if (tn.getUserObject() instanceof Book) {

                Book book = ((Book) tn.getUserObject());
                try {
                    setBookToField(book);
                } catch (ObjectNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Null object or not found " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jTreeMouseClicked

    private void jComboBoxTreeViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTreeViewActionPerformed
        if (jComboBoxTreeView.getSelectedItem().equals("Authors")) {
            jTree.setModel(initAuthorTreeModel());
        }
        if (jComboBoxTreeView.getSelectedItem().equals("Editors")) {
            jTree.setModel(initEditorTreeModel());
        }
    }//GEN-LAST:event_jComboBoxTreeViewActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        clearFlied();

    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewAllActionPerformed
        clearTab();
        tabViewAll();
    }//GEN-LAST:event_jButtonViewAllActionPerformed

    private void jTextSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSearch1ActionPerformed

    private void jButtonSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSearch1ActionPerformed

    private void jButtonViewAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewAll1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonViewAll1ActionPerformed

    private void tabViewAll() {
        Vector bookAttributes = null;
        try {
            for (Iterator itarator = catalogService.FindAllBooks().iterator(); itarator.hasNext();) {
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
                tabModel.addRow(bookAttributes);
            }
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(JPanelFormBooksCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearFlied() {

        jTextEditor.setText("");

        jTextSubTitle.setText("");

        jTextLargeSize.setText("");
        jTextTitle.setText("");
        jTextPaneSynopsis.setText("");
        jTextPrice.setText("");
        jTextStock.setText("");

        jTextWeight.setText("");
        jTextLongSize.setText("");
        jTextISBN.setText("");
        authorsList.removeAllElements();
        jComboBoxAuthors.setModel(initAuthorsModel());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSearch1;
    private javax.swing.JButton jButtonViewAll;
    private javax.swing.JButton jButtonViewAll1;
    private javax.swing.JComboBox<String> jComboBoxAuthors;
    private javax.swing.JComboBox<String> jComboBoxSearchBy;
    private javax.swing.JComboBox<String> jComboBoxSearchBy1;
    private javax.swing.JComboBox jComboBoxTVA;
    private javax.swing.JComboBox<String> jComboBoxTreeView;
    private javax.swing.JLabel jLabelEditor;
    private javax.swing.JLabel jLabelFrontCover;
    private javax.swing.JLabel jLabelISBN;
    private javax.swing.JLabel jLabelLargeSize;
    private javax.swing.JLabel jLabelLongSize;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSearch1;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelSynopsis;
    private javax.swing.JLabel jLabelTVA;
    private javax.swing.JLabel jLabelTVAText;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JLabel jLabelWeight;
    private javax.swing.JPanel jPanelBook;
    private javax.swing.JPanel jPanelConsult;
    private javax.swing.JPanel jPanelConsult1;
    private javax.swing.JPanel jPanelManage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneConsult;
    private javax.swing.JScrollPane jScrollPaneConsult1;
    private javax.swing.JScrollPane jScrollPaneTree;
    private javax.swing.JTabbedPane jTabbedPaneStock;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextEditor;
    private javax.swing.JTextField jTextISBN;
    private javax.swing.JTextField jTextLargeSize;
    private javax.swing.JTextField jTextLongSize;
    private javax.swing.JTextPane jTextPaneSynopsis;
    private javax.swing.JTextField jTextPrice;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JTextField jTextSearch1;
    private javax.swing.JTextField jTextStock;
    private javax.swing.JTextField jTextSubTitle;
    private javax.swing.JTextField jTextTitle;
    private javax.swing.JTextField jTextWeight;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables
}
