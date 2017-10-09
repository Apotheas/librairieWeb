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
public class PachageShipper extends DomainObject implements Serializable{

    // ======================================
    // =             Attributes             =
    // ======================================
    private String idPachageShipper;
    private Shipper shipper;
    private float costPachageShipper ;
    
   // ======================================
    // =            Constructors            =
    // ======================================
     public PachageShipper() {
         shipper = new Shipper("DHL");
    }

    public PachageShipper(final String id) {
       idPachageShipper = id;
       shipper = new Shipper("DHL");
    } 
    
     public PachageShipper(final String id , Shipper shipper) {
       idPachageShipper = id;
       this.shipper = shipper;
    } 
    
     public PachageShipper(final String id, Shipper shipper, float costPachageShipper) {
       idPachageShipper = id;
       setShipper(shipper);
       setCostPachageShipper(costPachageShipper);
    } 
    
     // ======================================
    // =           Business methods         =
    // ======================================

    public void checkData() throws CheckException {
        if (shipper == null || "".equals(shipper))
            throw new CheckException("Invalid PachageShipper, shipper must be not null");
        
    }

   // ======================================
    // =         Getters and Setters        =
    // ======================================
    
    @Override
    public String getId() {
        return idPachageShipper;
    }
    @Override
    public void setId(String idPachageShipper) {
        this.idPachageShipper = idPachageShipper;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public float getCostPachageShipper() {
        return costPachageShipper;
    }

    public void setCostPachageShipper(float costPachageShipper) {
        this.costPachageShipper = costPachageShipper;
    }

    @Override
    public String toString() {
        return shipper.getId() + " " + costPachageShipper ;
    }
    
    
    
    
    
    
    
}
