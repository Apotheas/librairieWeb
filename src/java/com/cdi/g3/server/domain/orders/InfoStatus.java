/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.orders;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.DomainObject;
import java.io.Serializable;

/**
 *
 * @author youssef
 */
public class InfoStatus extends DomainObject implements Serializable{

    // ======================================
    // =             Attributes             =
    // ======================================
    private String nameInfoStatus;
    private int valueInfoStatus;
    
    // ======================================
    // =            Constructors            =
    // ======================================
     public InfoStatus() {
    }

    public InfoStatus(final String id) {
       nameInfoStatus = id;
    } 
    
     public InfoStatus(final String id, int valueInfoStatus) {
       nameInfoStatus = id;
       setValueInfoStatus(valueInfoStatus);
    } 
    // ======================================
    // =           Business methods         =
    // ======================================

    public void checkData() throws CheckException {
        if (nameInfoStatus == null || "".equals(nameInfoStatus))
            throw new CheckException("Invalid nameInfoStatus");
        
    }

   // ======================================
    // =         Getters and Setters        =
    // ======================================
    
    @Override
    public String getId() {
        return nameInfoStatus;
    }
    @Override
    public void setId(String nameInfoStatus) {
        this.nameInfoStatus = nameInfoStatus;
    }

    public int getValueInfoStatus() {
        return valueInfoStatus;
    }

    public void setValueInfoStatus(int valueInfoStatus) {
        this.valueInfoStatus = valueInfoStatus;
    }

    @Override
    public String toString() {
        return nameInfoStatus;
    }
    
    
    
    
}
