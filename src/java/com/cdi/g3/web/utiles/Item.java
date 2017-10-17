/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.utiles;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.other.CodeTVA;
import com.cdi.g3.server.service.catalog.CatalogService;
import com.cdi.g3.server.service.other.OtherService;
import java.io.Serializable;

/**
 *
 * @author cdi314
 */
public class Item  implements Serializable{
    CatalogService catalogService = new CatalogService();
    OtherService otherService = new OtherService();
    private String ref;
    private int quantity;
    private float totalLine;    
    private Book book = new Book();
    

    public Item(String ref, int quantity) throws FinderException, CheckException {
        this.ref = ref;
        this.quantity = quantity;
        if (ref != null){
            this.book = catalogService.findBook(ref.trim());  
           CodeTVA codeTVA = otherService.findCodeTVA(this.book.getCodeTVA().getTypeTva());
            this.book.setCodeTVA(codeTVA);
        }        
        this.totalLine = 
        book.getUnitCostBook()*quantity;
        
    }

    public String getRef() {
        return ref;
    }
    

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void delta (int qty){
        this.quantity += qty;
        this.setTotalLine(book.getUnitCostBook()*quantity);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public float getTotalLine() {
        return totalLine;
    }

    public void setTotalLine(float totalLine) {
        this.totalLine = totalLine;
    }
    
    
    
    
    
    
    
}
