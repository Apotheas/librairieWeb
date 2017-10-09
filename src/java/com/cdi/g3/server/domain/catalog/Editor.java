package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.server.domain.DomainObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Editor extends DomainObject implements Serializable {

    private String idEditor;
    private String nameEditor;
    private int statusEditor;
    private Collection listBook = new ArrayList();
    
    //CONSTRUCTORS
    public Editor() {}
    public Editor(String id) {
        idEditor = id;
    }
    public Editor(String id, String nameEditor) {
        idEditor = id;
        setNameEditor(nameEditor);
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return nameEditor;
    }

    
    //GETTERS AND SETTERS 
    public String getIdEditor() {
        return idEditor;
    }

    public void setIdEditor(String idEditor) {
        this.idEditor = idEditor;
    }

    public String getNameEditor() {
        return nameEditor;
    }

    public void setNameEditor(String nameEditor) {
        this.nameEditor = nameEditor;
    }

    public int getStatusEditor() {
        return statusEditor;
    }

    public void setStatusEditor(int statusEditor) {
        this.statusEditor = statusEditor;
    }

    public Collection getListBook() {
        return listBook;
    }

    public void setListBook(Collection listBook) {
        this.listBook = listBook;
    }
    
    @Override
    public String getId() {
        return idEditor;
    }

    @Override
    public void setId(String idEditor) {
        this.idEditor = idEditor;
    }
}
