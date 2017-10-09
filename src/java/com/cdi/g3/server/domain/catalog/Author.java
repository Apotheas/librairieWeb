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
import java.util.Date;

public class Author extends DomainObject implements Serializable {

    private String idAuthor;
    private String lastNameAuthor;
    private String firstNameAuthor;
    private String biographyAuthor;
    private Date birthDateAuthor;
    private Date dieDateAuthor;
    private String commentAuthor;
    private Collection listBook = new ArrayList();
    
    
    //CONSTRUCTORS
    public Author() {}
    
    public Author(String id, String lastNameAuthor) {
        idAuthor = id;
        setLastNameAuthor(lastNameAuthor);
    }
    
    //TO STRING
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Author)){
        return false;
        }
        
        if(!this.getId().equals(((Author)obj).getId())){
         return false;
        } 
        return true;
    }

    @Override
    public String toString() {
        return lastNameAuthor + " " + firstNameAuthor;
    }

    //CONTROLES
    public void checkData() throws CheckException {
        if (getIdAuthor() == null || "".equals(getIdAuthor())) {
            throw new CheckException("Invalid idAuthor");
        }
        if (getLastNameAuthor() == null || "".equals(getLastNameAuthor())) {
            throw new CheckException("Invalid LastName Author");
        }

    }

    //GETTERS AND SETTERS
    public String getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(String idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getLastNameAuthor() {
        return lastNameAuthor;
    }

    public void setLastNameAuthor(String lastNameAuthor) {
        this.lastNameAuthor = lastNameAuthor;
    }

    public String getFirstNameAuthor() {
        return firstNameAuthor;
    }

    public void setFirstNameAuthor(String firstNameAuthor) {
        this.firstNameAuthor = firstNameAuthor;
    }

    public String getBiographyAuthor() {
        return biographyAuthor;
    }

    public void setBiographyAuthor(String biographyAuthor) {
        this.biographyAuthor = biographyAuthor;
    }

    public Date getBirthDateAuthor() {
        return birthDateAuthor;
    }

    public void setBirthDateAuthor(Date birthDateAuthor) {
        this.birthDateAuthor = birthDateAuthor;
    }

    public Date getDieDateAuthor() {
        return dieDateAuthor;
    }

    public void setDieDateAuthor(Date dieDateAuthor) {
        this.dieDateAuthor = dieDateAuthor;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public Collection getListBook() {
        return listBook;
    }

    public void setListBook(Collection listBook) {
        this.listBook = listBook;
    }

    @Override
    public String getId() {
        return idAuthor;
    }

    @Override
    public void setId(String idAuthor) {
        this.idAuthor = idAuthor;
    }

}
