/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.other;

import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.util.persistence.AbstractDataAccessObject;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author youssef
 */
public class KeyWordBook extends DomainObject implements Serializable{


    private String idKeyWordBook;
    @Override
    public String getId() {
        return idKeyWordBook;
    }
    @Override
    public void setId(String idKeyWordBook) {
        this.idKeyWordBook = idKeyWordBook;
    }
    
    
}
