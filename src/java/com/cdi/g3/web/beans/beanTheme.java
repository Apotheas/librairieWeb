/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.domain.catalog.SubTheme;
import com.cdi.g3.server.domain.catalog.Theme;
import com.cdi.g3.server.service.catalog.ThemeService;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Apotheas
 */
public class beanTheme implements Serializable {
    private static final ThemeService themeService = new ThemeService();
    private Collection<Theme> themes = new ArrayList();
    
    
    
    
    public Collection<SubTheme> getSubList(String nameTheme){
        try {
            return themeService.findAllSubForATheme("NAMETHEME", nameTheme);
        } catch (ObjectNotFoundException ex) {
            System.out.println("SUB NOT FOUND");
        }
        return null;
                
    }
    
    public beanTheme() throws ObjectNotFoundException {
        this.themes = themeService.findAllThemes();
       
    }

    public Collection<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Collection<Theme> themes) {
        this.themes = themes;
    }
    
  
    
}
