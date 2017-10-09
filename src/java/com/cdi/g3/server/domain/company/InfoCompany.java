/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.company;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.DomainObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author youssef
 */
public final class InfoCompany extends DomainObject implements Serializable{
    
    
    // ======================================
    // =             Attributes             =
    // ======================================
   
    
    private String nameInfoCompany;
    private String descriptionInfoCompany;
   
   
   
    private final Collection  listCompany = new ArrayList();
   

    // ======================================
    // =            Constructors            =
    // ======================================
    public InfoCompany() {
    }

    public InfoCompany(final String nameInfoCompanyCompany) {
        setId(nameInfoCompany);
    }

    public InfoCompany(final String nameInfoCompany, final String descriptionInfoCompany) {
        setId(nameInfoCompany);
        setDescriptionInfoCompany(descriptionInfoCompany);
        
       
    }

    // ======================================
    // =           Business methods         =
    // ======================================
    /**
     * This method checks the integrity of the object data.
     *
     * @throws CheckException if data is invalnameInfoCompany
     */
    public void checkData() throws CheckException {
        if (getId() == null || "".equals(getId()))
            throw new CheckException("InvalnameInfoCompany employeRight nameInfoCompany");
        if (getDescriptionInfoCompany() == null || "".equals(getDescriptionInfoCompany()))
            throw new CheckException("InvalnameInfoCompany employeRight  type");
       
    }
    
    // ======================================
    // =         Getters and Setters        =
    // ======================================

    @Override
    public String getId() {
        return nameInfoCompany;
    }
    @Override
    public void setId(String nameInfoCompany) {
        this.nameInfoCompany = nameInfoCompany;
    }

    public String getDescriptionInfoCompany() {
        return descriptionInfoCompany;
    }

    public void setDescriptionInfoCompany(String descriptionInfoCompany) {
        this.descriptionInfoCompany = descriptionInfoCompany;
    }

   
    
    
       public Collection getListCompany() {
        return listCompany;
    }
    
 
    @Override
    public String toString() {
        return  nameInfoCompany +"  "+  descriptionInfoCompany  ;
    }
}
    


