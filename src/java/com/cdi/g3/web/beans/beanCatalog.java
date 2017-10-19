/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.utiles.CompareNote;
import com.cdi.g3.common.utiles.ComparePrixAsc;
import com.cdi.g3.common.utiles.ComparePrixDesc;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.service.catalog.CatalogService;
import com.cdi.g3.server.service.catalog.OccasionService;
import com.cdi.g3.server.service.other.OtherService;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youssef
 */
public class beanCatalog implements Serializable {
    private static final CatalogService ctatalogService = new CatalogService();
    private static final OccasionService occasionService = new OccasionService();
     private static final OtherService otherService = new OtherService();
    private Collection<Book> booksCatalog = new ArrayList();
    private Collection<Book> books = new ArrayList();
    
    public beanCatalog() throws ObjectNotFoundException {
        this.booksCatalog = ctatalogService.FindAllBooks();
        
    }
    
    public beanCatalog(Collection bookList) throws ObjectNotFoundException {
        this.books = bookList;
    }

    public Collection<Book> getBooksCatalog() {
        return booksCatalog;
    }

    public void setBooksCatalog(Collection<Book> booksCatalog) {
        this.books = booksCatalog;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
       public void triPrixCroissant() {
        ArrayList booksC = (ArrayList) this.books;
        ComparePrixAsc comp = new ComparePrixAsc();
        Collections.sort(booksC, comp);
        this.books = booksC;
         ArrayList booksD = (ArrayList) this.booksCatalog;
        Collections.sort(booksD, comp);
        this.booksCatalog = booksD;
    }
      public void triPrixDesc() {
        ArrayList booksC = (ArrayList) this.books;
        ComparePrixDesc comp = new ComparePrixDesc();
        Collections.sort(booksC, comp);
        this.books = booksC;
         ArrayList booksD = (ArrayList) this.booksCatalog;
        Collections.sort(booksD, comp);
        this.booksCatalog = booksD;
    }
      public void triNotet() {
        ArrayList booksC = (ArrayList) this.books;
        CompareNote comp = new CompareNote();
        Collections.sort(booksC, comp);
        this.books = booksC;
         ArrayList booksD = (ArrayList) this.booksCatalog;
        Collections.sort(booksD, comp);
        this.booksCatalog = booksD;
    }
     public Collection getBooksbyTheme(String theme) {
        try {
            return ctatalogService.FindBooksByTheme(theme);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(beanCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Collection getBooksbySub(String theme, String sub) {
        try {
            return ctatalogService.FindBooksBySub(theme, sub);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(beanCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
      public Collection getBooksbyKeyWord(String nameKeyWord) {
        try {
            return otherService.findBooksByKeyword("NAMEKEYWORD",nameKeyWord);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(beanCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
      
       public Collection getBooksbyTitle(String titleBook) {
        try {
            return ctatalogService.FindBooksByChampTitre("TITLEBOOK", titleBook);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(beanCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
           public Collection getBooksbyAuthor(String lastNameAuthor) {
        try {
            return ctatalogService.FindBooksByChamp("LASTNAMEAUTHOR",lastNameAuthor);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(beanCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
           
               public Collection getBooksbyEditor(String nameEditor) {
        try {
            return ctatalogService.FindBooksByChamp("NAMEEDITOR",nameEditor);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(beanCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public Collection getBooksbyOccasion(String occasion) {
        try {
            return occasionService.findBooksByEvent(occasion);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(beanCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
     public Book getBook(String numISBN) {
     
   Book book =null ;
        System.out.println("numisbn : " + numISBN);

        try {
            book = ctatalogService.findBook(numISBN);
        } catch (FinderException | CheckException ex) {
            Logger.getLogger(beanCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    return book ;    
 }
     
     
    
    }


