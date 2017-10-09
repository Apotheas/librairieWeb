/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.DomainObject;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author youssef
 */
public class Occasion extends DomainObject implements Serializable{
    
    
    private String nameOccasion;
    private Date dateDebutOccasion;
    private Date dateFinOccasion;
    private Float discountOccasion;
    
     
     
     
     
    public Occasion(){
        
    }
    public Occasion(String id,Date dateDebut,Date dateFin){
        nameOccasion = id;
        setDateDebutOccasion(dateDebut);
        setDateFinOccasion(dateFin);
    } 

    
    
    
    public void checkData() throws CheckException {
        if (getNameOccasion()== null || "".equals(getNameOccasion())) {
            throw new CheckException("Invalid NameOccasion");
        }
        
        

    }
    public String getNameOccasion() {
        return nameOccasion;
    }

    public void setNameOccasion(String nameOccasion) {
        this.nameOccasion = nameOccasion;
    }

    public Date getDateDebutOccasion() {
        return dateDebutOccasion;
    }

    public void setDateDebutOccasion(Date dateDebutOccasion) {
        this.dateDebutOccasion = dateDebutOccasion;
    }

    public Date getDateFinOccasion() {
        return dateFinOccasion;
    }

    public void setDateFinOccasion(Date dateFinOccasion) {
        this.dateFinOccasion = dateFinOccasion;
    }

    public Float getDiscountOccasion() {
        return discountOccasion;
    }

    public void setDiscountOccasion(Float discountOccasion) {
        this.discountOccasion = discountOccasion;
    }
     
    
    
    
    
    
    
    
     @Override
    public String getId() {
        return nameOccasion;
    }
    @Override
    public void setId(String nameOccasion) {
        this.nameOccasion = nameOccasion;
    }

    @Override
    public String toString() {
        return  nameOccasion ;
    }
    
    
    
}
