/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.DomainObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
public class Theme extends DomainObject implements Serializable{
    private String nameTheme;
    private Collection subThemeList = new ArrayList();
    
     
     public Theme(){
         
     }
     public Theme(String id){
         nameTheme = id;
     }

     
        
    public void checkData() throws CheckException {
        if (getNameTheme()== null || "".equals(getNameTheme())) {
            throw new CheckException("Invalid name theme");
        }
     
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
