
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.DomainObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class SubTheme extends DomainObject implements Serializable{

   private String  idSubTheme ; 
   private String  nameSubTheme ; 
   private String  nameThemeSB ; 
   private Collection listSubTheme = new ArrayList () ; 
   

     // ======================================
    // =           Business methods         =
    // ======================================
    public void checkData() throws CheckException {
       

        if (nameSubTheme == null || "".equals(nameSubTheme)) {
            throw new CheckException("Invalid nameSubTheme, must be insert");
        }

        if (nameThemeSB == null || "".equals(nameThemeSB)) {
            throw new CheckException("Invalid nameTheme, must be insert");
        }

    } 
    // ======================================
    // =            Constructors            =
    // ======================================
    public SubTheme() {
    }

    public SubTheme(String idSubTheme) {
        this.idSubTheme = idSubTheme;
    }

    public SubTheme(String idSubTheme, String nameSubTheme, String nameTheme) {
        this.idSubTheme = idSubTheme;
        this.nameSubTheme = nameSubTheme;
        this.nameThemeSB = nameTheme;
    }
 
    // ======================================
    // =         Getters and Setters        =
    // ======================================
    
    
    @Override
    public String getId() {
        return idSubTheme;
    }
    @Override
    public void setId(String idSubTheme) {
        this.idSubTheme = idSubTheme;
    }
//---------------------------------------------///
   
    
    public String getIdSubTheme() {
        return idSubTheme;
    }

    public void setIdSubTheme(String idSubTheme) {
        this.idSubTheme = idSubTheme;
    }

    public String getNameSubTheme() {
        return nameSubTheme;
    }

    public void setNameSubTheme(String nameSubTheme) {
        this.nameSubTheme = nameSubTheme;
    }

    public String getNameTheme() {
        return nameThemeSB;
    }

    public void setNameTheme(String nameTheme) {
        this.nameThemeSB = nameTheme;
    }

    public Collection getListSubTheme() {
        return listSubTheme;
    }

    public void setListSubTheme(Collection listSubTheme) {
        this.listSubTheme = listSubTheme;
    }

    @Override
    public String toString() {
        return  nameSubTheme ;
    }
    
    
    
    
    
    
    
    
    
}
 