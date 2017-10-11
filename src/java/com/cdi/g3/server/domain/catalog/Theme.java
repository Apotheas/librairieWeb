/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.service.catalog.ThemeService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Theme extends DomainObject implements Serializable{
    
    private String nameTheme;
    private Collection subThemeList = new ArrayList();
    private ThemeService themeService = new ThemeService();
     
     public Theme(){
        try {
            this.subThemeList = themeService.findAllSubForATheme("NAMETHEME", this.nameTheme);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public Theme(String id){
         nameTheme = id;
         
     }

     
        
    public void checkData() throws CheckException {
        if (getNameTheme()== null || "".equals(getNameTheme())) {
            throw new CheckException("Invalid name theme");
        }
     
    }
     
    
   public Collection<SubTheme> getSubList(String nameTheme){
        try {
            return themeService.findAllSubForATheme("NAMETHEMESB", nameTheme);
        } catch (ObjectNotFoundException ex) {
            System.out.println("ERROR LOADING SUBTHEMES");
        }
        return null;
                
    }
     
     
    public String getNameTheme() {
        return nameTheme;
    }

    public void setNameTheme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    public Collection getSubThemeList() {
        return subThemeList;
    }

    public void setSubThemeList(Collection subThemeList) {
        this.subThemeList = subThemeList;
    }
     
     @Override
    public String getId() {
        return nameTheme;
    }
    @Override
    public void setId(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    @Override
    public String toString() {
        return nameTheme ;
    }
     
}
