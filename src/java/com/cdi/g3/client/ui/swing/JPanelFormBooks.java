/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.client.ui.swing;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.catalog.Author;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.catalog.Editor;
import com.cdi.g3.server.domain.catalog.SubTheme;
import com.cdi.g3.server.domain.catalog.Theme;
import com.cdi.g3.server.domain.other.CodeTVA;
import com.cdi.g3.server.service.catalog.CatalogService;
import com.cdi.g3.server.service.catalog.ThemeService;
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
public class JPanelFormBooks extends javax.swing.JPanel {

    private DefaultTableModel tabModel = new DefaultTableModel();
    private PublishingService publishingService = new PublishingService();
    private ThemeService themeService = new ThemeService();
    private CatalogService catalogService = new CatalogService();
    private OtherService otherService = new OtherService();
    private Vector tvaList = new Vector();
    private Vector authorsList = new Vector();
    private Vector<Author> newAuthorList = new Vector();

    public JPanelFormBooks() {
        initComponents();
        initColumnTab();
        jTree.setModel(initAuthorTreeModel());
        jTable.setModel(tabModel);
        jComboBoxTreeView.setModel(initTreeViewModel());
        jComboBoxSearchBy.setModel(initSearchByModel());
        jComboBoxTVA.setModel(initTVAModel());
        jComboBoxUpdateBy.setModel(initUpdateByModel());
        jButtonUpdate.setVisible(false);
        tabViewAll();
    }
    private void initColumnTab() {
        tabModel.addColumn("ISBN");
        tabModel.addColumn("AUTHOR");
        tabModel.addColumn("EDITOR");
        tabModel.addColumn("TITLE");
        tabModel.addColumn("SUB-TITLE");
        tabModel.addColumn("STOCK");
        tabModel.addColumn("COST");
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jTextImageUrl = new javax.swing.JTextField();
        jTextTitle = new javax.swing.JTextField();
        jTextLargeSize = new javax.swing.JTextField();
        jLabelStock = new javax.swing.JLabel();
        jTextPrice = new javax.swing.JTextField();
        jLabelSynopsis = new javax.swing.JLabel();
        jLabelImageUrl = new javax.swing.JLabel();
        jTextEditor = new javax.swing.JTextField();
        jLabelLongSize = new javax.swing.JLabel();
        jTextLongSize = new javax.swing.JTextField();
        jScrollPaneComment = new javax.swing.JScrollPane();
        jTextComment = new javax.swing.JTextArea();
        jLabelComment = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneSynopsis = new javax.swing.JTextPane();
        jComboBoxTVA = new javax.swing.JComboBox();
        jLabelTVA = new javax.swing.JLabel();
        jLabelTitle1 = new javax.swing.JLabel();
        jTextSubTitle = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jButtonAddAuthor = new javax.swing.JButton();
        jComboBoxAuthors = new javax.swing.JComboBox<>();
        jLabelTVAText = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();
        jButtonCreate = new javax.swing.JButton();
        jPanelUpdate = new javax.swing.JPanel();
        jTextUpdateBook = new javax.swing.JTextField();
        jButtonSearchBook = new javax.swing.JButton();
        jComboBoxUpdateBy = new javax.swing.JComboBox<>();
        jButtonUpdate = new javax.swing.JButton();
        jComboBoxTreeView = new javax.swing.JComboBox<>();

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
                .addContainerGap(420, Short.MAX_VALUE))
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

        jPanelManage.setLayout(null);

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

        jPanelManage.add(jScrollPaneTree);
        jScrollPaneTree.setBounds(6, 38, 210, 598);

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

        jLabelImageUrl.setText("Image url  :");

        jLabelLongSize.setText("Long size  :");

        jTextComment.setColumns(20);
        jTextComment.setRows(5);
        jScrollPaneComment.setViewportView(jTextComment);

        jLabelComment.setText("Comment :");

        jScrollPane1.setViewportView(jTextPaneSynopsis);

        jComboBoxTVA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "general", "Item 2", "Item 3", "Item 4" }));

        jLabelTVA.setText("Tva : ");

        jLabelTitle1.setText("Sub-Title  :");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Author"));

        jLabel1.setText("First Name :");

        jLabel2.setText("Last Name :");

        jButtonAddAuthor.setText("Add");
        jButtonAddAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAuthorActionPerformed(evt);
            }
        });

        jComboBoxAuthors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book's Author", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jComboBoxAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonCreate.setText("Create");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBookLayout = new javax.swing.GroupLayout(jPanelBook);
        jPanelBook.setLayout(jPanelBookLayout);
        jPanelBookLayout.setHorizontalGroup(
            jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabelImageUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextImageUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabelTVA)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBoxTVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTVAText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addComponent(jLabelComment)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPaneComment, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addComponent(jLabelSynopsis)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90)
                        .addComponent(jButtonClear))
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
                                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelWeight)
                                    .addComponent(jLabelLargeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLongSize, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextLongSize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextLargeSize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFrontCover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBookLayout.createSequentialGroup()
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPrice)
                            .addComponent(jLabelStock))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextStock, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonCreate, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelBookLayout.setVerticalGroup(
            jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookLayout.createSequentialGroup()
                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFrontCover, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelISBN))
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
                                    .addComponent(jTextWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                            .addComponent(jTextPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCreate)
                            .addComponent(jButtonClear))
                        .addGap(24, 24, 24))
                    .addGroup(jPanelBookLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelImageUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextImageUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelTVA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxTVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTVAText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelComment, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPaneComment, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelBookLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelSynopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 34, Short.MAX_VALUE))))
        );

        jPanelManage.add(jPanelBook);
        jPanelBook.setBounds(240, 0, 890, 524);

        jPanelUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder("Update"));

        jTextUpdateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUpdateBookActionPerformed(evt);
            }
        });

        jButtonSearchBook.setText("Search");
        jButtonSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchBookActionPerformed(evt);
            }
        });

        jComboBoxUpdateBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUpdateBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUpdateByActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUpdateLayout = new javax.swing.GroupLayout(jPanelUpdate);
        jPanelUpdate.setLayout(jPanelUpdateLayout);
        jPanelUpdateLayout.setHorizontalGroup(
            jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jComboBoxUpdateBy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextUpdateBook, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSearchBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                .addComponent(jButtonUpdate)
                .addGap(40, 40, 40))
        );
        jPanelUpdateLayout.setVerticalGroup(
            jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextUpdateBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchBook)
                    .addComponent(jComboBoxUpdateBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdate))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanelManage.add(jPanelUpdate);
        jPanelUpdate.setBounds(240, 530, 890, 106);

        jComboBoxTreeView.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTreeView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTreeViewActionPerformed(evt);
            }
        });
        jPanelManage.add(jComboBoxTreeView);
        jComboBoxTreeView.setBounds(6, 6, 120, 26);

        jTabbedPaneStock.addTab("Manage", jPanelManage);

        add(jTabbedPaneStock, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSearchActionPerformed
    private void clearTab() {
        int lignes = tabModel.getRowCount();
        for (int i = lignes - 1; i >= 0; i--) {
            tabModel.removeRow(i);
        }
    }
    private void jButtonSearchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchBookActionPerformed
        if (jComboBoxUpdateBy.getSelectedItem().equals("Title")) {
            try {
                Book book = null;
                book = catalogService.FindBookByChamp("TITREBOOK", jTextUpdateBook.getText());
                setBookToField(book);

            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "ERROR BOOK NOT IN DATABASE");
            }
        }
        if (jComboBoxUpdateBy.getSelectedItem().equals("ISBN")) {
            try {
                Book book = null;
                book = catalogService.FindBookByChamp("NUMISBNBOOK", jTextUpdateBook.getText());
                setBookToField(book);

            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "ERROR BOOK NOT IN DATABASE");
            }
        }
    }//GEN-LAST:event_jButtonSearchBookActionPerformed

    private void jTextUpdateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUpdateBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUpdateBookActionPerformed
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        clearTab();
        if (jComboBoxSearchBy.getSelectedItem().equals("Title")) {
            viewTabSetter("TITREBOOK", jTextSearch.getText());
        }
        if (jComboBoxSearchBy.getSelectedItem().equals("ISBN")) {
            viewTabSetter("NUMISBNBOOK", jTextSearch.getText());
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed
    private void viewTabSetter(String column, String champ) {
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
        if (jComboBoxTreeView.getSelectedItem().equals("Themes")) {
            jTree.setModel(initTreeThemeModel());
        }
    }//GEN-LAST:event_jComboBoxTreeViewActionPerformed
    private void jComboBoxUpdateByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUpdateByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUpdateByActionPerformed
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        clearFlied();
        jButtonUpdate.setVisible(false);
        jButtonCreate.setVisible(true);
    }//GEN-LAST:event_jButtonClearActionPerformed
    private void jButtonViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewAllActionPerformed
        clearTab();
        tabViewAll();
    }//GEN-LAST:event_jButtonViewAllActionPerformed
    private void jButtonAddAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAuthorActionPerformed
        boolean verifiedAuthor = true;
        verifiedAuthor = controlesAuthor();
        if (verifiedAuthor) {
            Author author = null;
            boolean trouve = false;
            try {
                author = publishingService.findAuthorOByChamp("LASTNAMEAUTHOR", jTextFieldLastName.getText());
                if (authorsList.contains(author)) {
                    trouve = true;
                }
                if (trouve == false) {
                    authorsList.add(author);
                } else {
                    JOptionPane.showMessageDialog(this, "Author already add");
                }
            } catch (ObjectNotFoundException ex) {
                int retour = JOptionPane.showConfirmDialog(this,
                        "AUTHOR NOT IN DATABASE, DO YOU WANT TO CREATE IT ? ",
                        "New Author",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (retour == JOptionPane.YES_OPTION) {
                    author = new Author();
                    author.setLastNameAuthor(jTextFieldLastName.getText());
                    author.setFirstNameAuthor(jTextFieldFirstName.getText());
                    authorsList.add(author);
                    publishingService.createAuthor(author);
                    JOptionPane.showMessageDialog(this, "NEW AUTHOR ADDED IN DATABASE");
                }
            }
            jComboBoxAuthors.setModel(initAuthorsModel());
        }
    }//GEN-LAST:event_jButtonAddAuthorActionPerformed
    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        boolean verifiedBook = true;
        verifiedBook = controlsBook();
        if (verifiedBook) {
            Book book = new Book();
            book.setWeightBook(Float.valueOf(jTextWeight.getText()));
            book.setUnitCostBook(Float.valueOf(jTextPrice.getText()));
            book.setSizeLargeBook(Float.valueOf(jTextLargeSize.getText()));
            book.setSizeLongBook(Float.valueOf(jTextLongSize.getText()));
            book.setStockBook(Integer.valueOf(jTextStock.getText()));
            book.setCodeTVA((CodeTVA) jComboBoxTVA.getSelectedItem());
            book.setTitleBook(jTextTitle.getText());
            book.setSubTitleBook(jTextSubTitle.getText());
            book.setSynopsisBook(jTextPaneSynopsis.getText());
            book.setCommentBook(jTextComment.getText());
            book.setPathIconBook(jTextImageUrl.getText());
            book.setNumISBNBook(jTextISBN.getText());
            try {
                Editor editor = publishingService.findEditor("NAMEEDITOR", jTextEditor.getText());
                book.setEditor(editor);
            } catch (ObjectNotFoundException ex) {
                int retour = JOptionPane.showConfirmDialog(this,
                        "EDITOR NOT IN DATABASE, DO YOU WANT TO ADD IT ? ",
                        "New Editor",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (retour == JOptionPane.YES_OPTION) {
                    Editor editor = new Editor();
                    editor.setNameEditor(jTextEditor.getText());
                    publishingService.createEditor(editor);
                    book.setEditor(editor);
                    JOptionPane.showMessageDialog(this, "NEW EDITOR ADD IN DATABASE");
                }
            }
            try {
                catalogService.createBook(book);
                JOptionPane.showMessageDialog(this, "Book Add with success in database");

            } catch (FinderException | CheckException ex) {
                JOptionPane.showMessageDialog(this, "FinderException | CheckException" + ex.getMessage());
            }
            for (Iterator it = authorsList.iterator(); it.hasNext();) {
                Author author = (Author) it.next();
                try {
                    publishingService.insertAuthorBook(book.getId(), author.getId());
                    JOptionPane.showMessageDialog(this, book.getTitleBook() + " Associate to author : " + author.getLastNameAuthor() + " " + author.getFirstNameAuthor() + " with success !");
                } catch (DuplicateKeyException ex) {
                    JOptionPane.showMessageDialog(this, "Author Already associate to this book");
                }
            }
        }
    }//GEN-LAST:event_jButtonCreateActionPerformed
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        int retour = JOptionPane.showConfirmDialog(this,
                "YOU ARE ABOUT TO UPDATE THE BOOK ",
                "Update book",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (retour == JOptionPane.YES_OPTION) {
            Book book = new Book();
            book.setWeightBook(Float.valueOf(jTextWeight.getText()));
            book.setUnitCostBook(Float.valueOf(jTextPrice.getText()));
            book.setSizeLargeBook(Float.valueOf(jTextLargeSize.getText()));
            book.setSizeLongBook(Float.valueOf(jTextLongSize.getText()));
            book.setStockBook(Integer.valueOf(jTextStock.getText()));
            book.setCodeTVA((CodeTVA) jComboBoxTVA.getSelectedItem());
            book.setTitleBook(jTextTitle.getText());
            book.setSubTitleBook(jTextSubTitle.getText());
            book.setSynopsisBook(jTextPaneSynopsis.getText());
            book.setCommentBook(jTextComment.getText());
            book.setPathIconBook(jTextImageUrl.getText());
            book.setNumISBNBook(jTextISBN.getText());
            try {
                Editor editor = publishingService.findEditor("NAMEEDITOR", jTextEditor.getText());
                book.setEditor(editor);
            } catch (ObjectNotFoundException ex) {
                int retour2 = JOptionPane.showConfirmDialog(this,
                        "EDITOR NOT IN DATABASE, DO YOU WANT TO ADD IT ? ",
                        "New Editor",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (retour2 == JOptionPane.YES_OPTION) {
                    Editor editor = new Editor();
                    editor.setNameEditor(jTextEditor.getText());
                    publishingService.createEditor(editor);
                    book.setEditor(editor);
                    JOptionPane.showMessageDialog(this, "NEW EDITOR ADD IN DATABASE");
                }
            }
            try {
                catalogService.updateBook(book);
                JOptionPane.showMessageDialog(this, "Book update successful ! ");
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "book not found, cannot update it ");
            }
        }
        jComboBoxTreeView.setModel(initTreeViewModel());
    }//GEN-LAST:event_jButtonUpdateActionPerformed
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
            Logger.getLogger(JPanelFormBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setBookToField(Book book) throws ObjectNotFoundException {
        authorsList.removeAllElements();
        jTextISBN.setText(book.getId());
        jTextSubTitle.setText(book.getSubTitleBook());
        jTextPrice.setText(String.valueOf(book.getUnitCostBook()));
        jTextTitle.setText(book.getTitleBook());
        jTextImageUrl.setText(book.getPathIconBook());
        jTextPaneSynopsis.setText(book.getSynopsisBook());
        jTextComment.setText(book.getCommentBook());
        jTextWeight.setText(String.valueOf(book.getWeightBook()));
        jTextLargeSize.setText(String.valueOf(book.getSizeLargeBook()));
        jTextLongSize.setText(String.valueOf(book.getSizeLongBook()));
        jTextStock.setText(String.valueOf(book.getStockBook()));
        Editor editor = (Editor) publishingService.findEditorByChamp("numisbnbook", book.getId());
        jTextEditor.setText(editor.getNameEditor());
        jComboBoxTVA.getModel().setSelectedItem("reduced");
        jComboBoxTVA.setSelectedItem(book.getCodeTva().getTypeTva());
        jComboBoxAuthors.setModel(initAuthorsModel());
        jButtonUpdate.setVisible(true);
        jButtonCreate.setVisible(false);
    }
    private void clearFlied() {
        jTextComment.setText("");
        jTextEditor.setText("");
        jTextFieldFirstName.setText("");
        jTextFieldLastName.setText("");
        jTextImageUrl.setText("");
        jTextSubTitle.setText("");
        jTextUpdateBook.setText("");
        jTextLargeSize.setText("");
        jTextTitle.setText("");
        jTextPaneSynopsis.setText("");
        jTextPrice.setText("");
        jTextStock.setText("");
        jTextComment.setText("");
        jTextWeight.setText("");
        jTextLongSize.setText("");
        jTextISBN.setText("");
        authorsList.removeAllElements();
        jComboBoxAuthors.setModel(initAuthorsModel());
    }
    private boolean controlesAuthor() {
        Utility utils = new Utility();
        if (!utils.regexNom(jTextFieldLastName.getText())) {
            if (jTextFieldLastName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Last name author is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Last name Author invalid ", "warning", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        if (!jTextFieldFirstName.getText().isEmpty()) {
            if (!utils.regexNom(jTextFieldFirstName.getText())) {
                JOptionPane.showMessageDialog(this, "First name Author invalid ", "warning", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    private boolean controlsBook() {
        Utility utils = new Utility();
        if (!utils.regexIsbn(jTextISBN.getText())) {
            if (jTextISBN.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ISBN  is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "ISBN is invalid !  ", "warning", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        if (!utils.regexNom(jTextTitle.getText())) {
            if (jTextTitle.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Title is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Title is invalid !  ", "warning", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        if (!jTextSubTitle.getText().isEmpty()) {
            if (!utils.regexNom(jTextSubTitle.getText())) {
                JOptionPane.showMessageDialog(this, "subtitle invalid ", "warning", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (!utils.regexNom(jTextEditor.getText())) {
            if (jTextISBN.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "EDITOR Name  is mandatory ", "Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "EDITOR Name is invalid !  ", "warning", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        if (jTextWeight.getText().isEmpty()) {
            jTextWeight.setText("0.0");
        }
        if (jTextLargeSize.getText().isEmpty()) {
            jTextLargeSize.setText("0.0");
        }
        if (jTextLongSize.getText().isEmpty()) {
            jTextLongSize.setText("0.0");
        }
        if (jTextStock.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cannot Update or create A null Stock  ", "warning", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jTextPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "PRICE CANNOT BE NULL ! THIS IS NOT A CHARITY STORE ", "warning", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddAuthor;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSearchBook;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonViewAll;
    private javax.swing.JComboBox<String> jComboBoxAuthors;
    private javax.swing.JComboBox<String> jComboBoxSearchBy;
    private javax.swing.JComboBox jComboBoxTVA;
    private javax.swing.JComboBox<String> jComboBoxTreeView;
    private javax.swing.JComboBox<String> jComboBoxUpdateBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelComment;
    private javax.swing.JLabel jLabelEditor;
    private javax.swing.JLabel jLabelFrontCover;
    private javax.swing.JLabel jLabelISBN;
    private javax.swing.JLabel jLabelImageUrl;
    private javax.swing.JLabel jLabelLargeSize;
    private javax.swing.JLabel jLabelLongSize;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelSynopsis;
    private javax.swing.JLabel jLabelTVA;
    private javax.swing.JLabel jLabelTVAText;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JLabel jLabelWeight;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBook;
    private javax.swing.JPanel jPanelConsult;
    private javax.swing.JPanel jPanelManage;
    private javax.swing.JPanel jPanelUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneComment;
    private javax.swing.JScrollPane jScrollPaneConsult;
    private javax.swing.JScrollPane jScrollPaneTree;
    private javax.swing.JTabbedPane jTabbedPaneStock;
    private javax.swing.JTable jTable;
    private javax.swing.JTextArea jTextComment;
    private javax.swing.JTextField jTextEditor;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextISBN;
    private javax.swing.JTextField jTextImageUrl;
    private javax.swing.JTextField jTextLargeSize;
    private javax.swing.JTextField jTextLongSize;
    private javax.swing.JTextPane jTextPaneSynopsis;
    private javax.swing.JTextField jTextPrice;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JTextField jTextStock;
    private javax.swing.JTextField jTextSubTitle;
    private javax.swing.JTextField jTextTitle;
    private javax.swing.JTextField jTextUpdateBook;
    private javax.swing.JTextField jTextWeight;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables
}
