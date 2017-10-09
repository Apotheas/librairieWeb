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
public class SubThemeBook extends DomainObject implements Serializable{


    private String idSubThemeBook;
    @Override
    public String getId() {
        return idSubThemeBook;
    }
    @Override
    public void setId(String idSubThemeBook) {
        this.idSubThemeBook = idSubThemeBook;
    }
    
}
