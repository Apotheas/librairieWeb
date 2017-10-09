/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.server.domain.DomainObject;
import java.io.Serializable;

/**
 *
 * @author youssef
 */
public class AuthorBook extends DomainObject implements Serializable{


    private String idAuthorBook;
    @Override
    public String getId() {
        return idAuthorBook;
    }
    @Override
    public void setId(String idAuthorBook) {
        this.idAuthorBook = idAuthorBook;
    }
    
    
}
