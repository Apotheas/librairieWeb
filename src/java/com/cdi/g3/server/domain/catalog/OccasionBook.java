/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.DomainObject;
import java.io.Serializable;

/**
 *
 * @author Izet
 */
public class OccasionBook extends DomainObject implements Serializable {
    
    private String idOccasionBook;
    private String numIsbnBook;
    private String nameOccasionOb;
    
    
    
       public OccasionBook(){
        
    }
          
    public void checkData() throws CheckException {
        if (getIdOccasionBook()== null || "".equals(getIdOccasionBook())) {
            throw new CheckException("Invalid NameOccasion");
        }}
        

    public String getIdOccasionBook() {
        return idOccasionBook;
    }

    public void setIdOccasionBook(String idOccasionBook) {
        this.idOccasionBook = idOccasionBook;
    }

    public String getNumIsbnBook() {
        return numIsbnBook;
    }

    public void setNumIsbnBook(String numIsbnBook) {
        this.numIsbnBook = numIsbnBook;
    }

    public String getNameOccasionOb() {
        return nameOccasionOb;
    }

    public void setNameOccasionOb(String nameOccasionOb) {
        this.nameOccasionOb = nameOccasionOb;
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

