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
public final class Company extends DomainObject implements Serializable{
    

    // ======================================
    // =             Attributes             =
    // ======================================
   
    
    private String siretCompany;
    private String nameCompany;
    private String logoCompany;
    private String telephoneCompany;
    private String faxCompany;
    private String mailCompany;
   
    private final Collection  listAddressCompany = new ArrayList();
    private final Collection  listInfoCompany = new ArrayList();
   

    // ======================================
    // =            Constructors            =
    // ======================================
    public Company() {
    }

    public Company(final String id) {
        setId(id);
    }

    public Company(final String id, final String nameCompany, final String logoCompany) {
        setId(id);
        setLogoCompany(logoCompany);
        setNameCompany(nameCompany);
       
    }

    // ======================================
    // =           Business methods         =
    // ======================================
    /**
     * This method checks the integrity of the object data.
     *
     * @throws CheckException if data is invalid
     */
    public void checkData() throws CheckException {
        if (getId() == null || "".equals(getId()))
            throw new CheckException("Invalid company siret");
        if (getNameCompany() == null || "".equals(getNameCompany()))
            throw new CheckException("Invalid company  name");
        if (getLogoCompany() == null || "".equals(getLogoCompany()))
            throw new CheckException("Invalid company logo");
    }

    // ======================================
    // =         Getters and Setters        =
    // ======================================

   @Override
    public String getId() {
        return siretCompany;
    }
    @Override
    public void setId(String siretCompany) {
        this.siretCompany = siretCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getLogoCompany() {
        return logoCompany;
    }

    public void setLogoCompany(String logoCompany) {
        this.logoCompany = logoCompany;
    }

    public String getTelephoneCompany() {
        return telephoneCompany;
    }

    public void setTelephoneCompany(String telephoneCompany) {
        this.telephoneCompany = telephoneCompany;
    }

    public String getFaxCompany() {
        return faxCompany;
    }

    public void setFaxCompany(String faxCompany) {
        this.faxCompany = faxCompany;
    }

    public String getMailCompany() {
        return mailCompany;
    }

    public void setMailCompany(String mailCompany) {
        this.mailCompany = mailCompany;
    }
  
   public Collection getListAddressCompany() {
        return listAddressCompany;
    }

    public Collection getListInfoCompany() {
        return listInfoCompany;
    }

    @Override
    public String toString() {
        return  siretCompany +"  "+  nameCompany  ;
    }
}
    
    
    
