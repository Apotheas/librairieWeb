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
public final class EmployeRight extends DomainObject implements Serializable{


    // ======================================
    // =             Attributes             =
    // ======================================
   
    
    private String idEmployeRight;
    private String typeEmployeRight;
   
   
   
    private final Collection  listEmploye = new ArrayList();
   

    // ======================================
    // =            Constructors            =
    // ======================================
    public EmployeRight() {
    }

    public EmployeRight(final String id) {
        setId(id);
    }

    public EmployeRight(final String id, final String typeEmployeRight) {
        setId(id);
        setTypeEmployeRight(typeEmployeRight);
        
       
    }

    EmployeRight(EmployeRight employeRight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            throw new CheckException("Invalid employeRight id");
        if (getTypeEmployeRight() == null || "".equals(getTypeEmployeRight()))
            throw new CheckException("Invalid employeRight  type");
       
    }



    // ======================================
    // =         Getters and Setters        =
    // ======================================

    @Override
    public String getId() {
        return idEmployeRight;
    }
    @Override
    public void setId(String idEmployeRight) {
        this.idEmployeRight = idEmployeRight;
    }

    public void setIdEmployeRight(String idEmployeRight) {
        this.idEmployeRight = idEmployeRight;
    }

    public String getTypeEmployeRight() {
        return typeEmployeRight;
    }

    public void setTypeEmployeRight(String typeEmployeRight) {
        this.typeEmployeRight = typeEmployeRight;
    }
    
    
       public Collection getListEmploye() {
        return listEmploye;
    }
   
 
    @Override
    public String toString() {
        return  idEmployeRight  ;
    }
}
    