/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.catalog;

import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.domain.catalog.SubTheme;
import com.cdi.g3.server.domain.catalog.SubThmeDAO;
import com.cdi.g3.server.domain.catalog.Theme;
import com.cdi.g3.server.domain.catalog.ThemeDAO;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.swing.MenuItemLayoutHelper;

/**
 *
 * @author Apotheas
 */
public class ThemeService {
    ThemeDAO _ThemeDAO = new ThemeDAO();
    SubThmeDAO _SubDAO = new SubThmeDAO();
    
    public Collection findAllThemes(){
        try { 
            return _ThemeDAO.findAll();
        } catch (ObjectNotFoundException ex) {
            System.out.println("no themes founds");
        }
        return null;
    }
    
    public Collection findAllSubForATheme(String column, String champ) throws ObjectNotFoundException {     
            return _SubDAO.findAllByChamp(column, champ);     
    }
    
    
    public void insertSubTheme(SubTheme subTheme) throws DuplicateKeyException{
        _SubDAO.insert(subTheme);
    }
    public void insertTheme(Theme theme) throws DuplicateKeyException{
        _ThemeDAO.insert(theme);
    }
    
    public boolean VerifIfThemeExist(String column, String champ){
        try {
            _ThemeDAO.findByChamp(column, champ);            
        } catch (ObjectNotFoundException ex) {
            return true;
        }      
       return false;
    }
    
    public boolean verifIfSubExist(String idSubTheme , String idTheme){
        try {
            _SubDAO.VerifiedByChamp(idSubTheme, idTheme);            
        } catch (ObjectNotFoundException ex) {
            return true;
        }      
       return false;
    }
    public boolean verifIfBookSubExist(String idSubTheme , String ISBN){
        try {
            _SubDAO.VerifiedByChampSubBook(idSubTheme, ISBN);            
        } catch (ObjectNotFoundException ex) {
            return true;
        }      
       return false;
    }
    
    public void insertBookToSub(String ISBN, String idSub) throws DuplicateKeyException{
        _SubDAO.associateSubBook(ISBN, idSub);
    }
    public void deleteBookFromSub(String ISBN, String idSub) throws DuplicateKeyException{
        _SubDAO.DeleteBookFromSub(ISBN, idSub);
    }
}
