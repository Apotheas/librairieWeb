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
public class Shipper extends DomainObject implements Serializable{

    // ======================================
    // =             Attributes             =
    // ======================================
    private String nameShipper;
    private String commentShipper;
    
     // ======================================
    // =            Constructors            =
    // ======================================
    public Shipper(final String nameShipper) {
       this.nameShipper = nameShipper;
    } 
    
    // ======================================
    // =           Business methods         =
    // ======================================

    public void checkData() throws CheckException {
        if (nameShipper == null || "".equals(nameShipper))
            throw new CheckException("Invalid nameInfoStatus");
        
    }

   // ======================================
    // =         Getters and Setters        =
    // ======================================
    
    @Override
    public String getId() {
        return nameShipper;
    }
    @Override
    public void setId(String nameShipper) {
        this.nameShipper = nameShipper;
    }

    public String getCommentShipper() {
        return commentShipper;
    }

    public void setCommentShipper(String commentShipper) {
        this.commentShipper = commentShipper;
    }

    @Override
    public String toString() {
        return  nameShipper ;
    }
    
    
    
}
