/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.server.domain.catalog.Book;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author youssef
 */
public class beanPagination implements Serializable {
    private int offset;
    private int recordsPerPage ;
    private int numberColone ;
    private int noOfPages;

    
    public beanPagination() {
        recordsPerPage =6;
        numberColone =3;
    }
    
    
    public Collection getBooksByOffsetAndLength(Collection books)  {
        ArrayList<Book> booksLineOfThePage ;
        Collection<ArrayList> booksByOffsetAndLength = new ArrayList();
        int to = this.offset + this.recordsPerPage;
        if (this.offset > books.size())
            this.offset = books.size();
        if (to > books.size())
            to = books.size();
        for (int i = this.offset; i < to; i=i+numberColone) {
            booksLineOfThePage = new ArrayList();
            int k =i+numberColone;
            if(k> to)
                k=to;                
            for (int j = i; j < k; j++) {
            booksLineOfThePage.add(((ArrayList<Book>) books).get(j));
            }
             booksByOffsetAndLength.add(booksLineOfThePage);
        }
        return booksByOffsetAndLength;
    }

    public Collection getPages(Collection books) {
       List pageNumbers = new ArrayList();
        int pages = books.size() / this.recordsPerPage;
        if (books.size() % this.recordsPerPage != 0) {
            pages = pages + 1;
        } 
        for (int i = 1; i <= pages; i++) {
            pageNumbers.add(new Integer(i));
        }
        return pageNumbers;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getNumberColone() {
        return numberColone;
    }

    public void setNumberColone(int numberColone) {
        this.numberColone = numberColone;
    }

    public int getNoOfPages(Collection books) {
        int pages  =(int) Math.ceil(books.size() * 1.0 / recordsPerPage);  
        
       return pages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }
    
    
    
    
  
}
