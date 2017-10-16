/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.domain.catalog.Occasion;
import com.cdi.g3.server.service.catalog.OccasionService;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Apotheas
 */
public class beanEvent implements Serializable {
     private static final OccasionService occasionService = new OccasionService();
    private Collection<Occasion> occasions = new ArrayList();
   
    
    public beanEvent() throws ObjectNotFoundException {
        this.occasions = occasionService.FindAllOccasion();
    }

    public Collection<Occasion> getOccasions() {
        return occasions;
    }

    public void setOccasions(Collection<Occasion> occasions) {
        this.occasions = occasions;
    }
    
    
}
