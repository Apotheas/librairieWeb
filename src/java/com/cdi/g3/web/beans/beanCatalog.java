/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.service.catalog.CatalogService;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author youssef
 */
public class beanCatalog implements Serializable {
    private static final CatalogService ctatalogService = new CatalogService();
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
        this.booksCatalog = booksCatalog;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
    
    
    

    
    
    }


