/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.catalog;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.customers.Appreciation;
import com.cdi.g3.server.domain.other.CodeTVA;
import com.cdi.g3.server.service.customers.AppreciationService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Book extends DomainObject implements Serializable {

    private String numISBNBook;
    private Editor editor;
    private CodeTVA codeTVA;
    private String titleBook;
    private float unitCostBook;
    private int stockBook;
    private int statusBook;
    private String subTitleBook;
    private String synopsisBook;
    private String pathIconBook;
    private float weightBook;
    private float sizeLargeBook;
    private float sizeLongBook;
    private String commentBook;
    private int moyenne;
    private int nbNote;
    
    private  Collection listSubTheme = new ArrayList();
    private  Collection listAuthor = new ArrayList();
    private  Collection listKeyWord = new ArrayList();
    private  Collection listEvent = new ArrayList();
    private  Collection listAppreciation = new ArrayList();
    private  Collection listOrderLine = new ArrayList();
    
    
    private AppreciationService appreciationService = new AppreciationService();
    
    //CONSTRUCTORS
    public Book() {}
    public Book(final String id) {
        numISBNBook = id;
    }    
    public Book(final String id,final Editor editor,final CodeTVA codeTVA, final String title, final float unitCost, final int stock) {
        numISBNBook = id;
        setEditor(editor);
        setCodeTva(codeTVA);
        setTitleBook(title);
        setUnitCostBook(unitCost);
        setStockBook(stock);
        setMoyenne(getAppList(id));
    }
    
  public int getAppList(String isbn){
        int nbNote=0;
        int somme = 0;
        try {
            for (Iterator it = appreciationService.FindAppreciationByChamp("NUMISBNBOOKAPPRECIATE", isbn).iterator(); it.hasNext();) {
                Appreciation comment = (Appreciation) it.next();
                nbNote +=1;
                somme += Integer.valueOf(comment.getRatingAppreciate()) ;
            }
            setNbNote(nbNote);
            return somme/nbNote;
        } catch (ObjectNotFoundException ex) {
           return -1;
        }
     
        
    }

    public int getNbNote() {
        return nbNote;
    }

    public void setNbNote(int nbNote) {
        this.nbNote = nbNote;
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return titleBook ;
    }
    
   //CONTROLS
    public void checkData() throws CheckException {
        if (getNumISBNBook() == null || "".equals(getNumISBNBook())) {
            throw new CheckException("Invalid ISBN number");
        }
        if (getTitleBook() == null || "".equals(getTitleBook())) {
            throw new CheckException("Invalid Title");
        }
        if (getUnitCostBook() <= 0 || "".equals(getUnitCostBook())) {
            throw new CheckException("Invalid price");
        }
        if (getStockBook() <= 0 || "".equals(getUnitCostBook())) {
            throw new CheckException("Invalid Stock");
        }

    }

    //GETTER 
    public String getNumISBNBook() {
        return numISBNBook;
    }

    public CodeTVA getCodeTva() {
        return codeTVA;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public float getUnitCostBook() {
        return unitCostBook;
    }

    public int getStockBook() {
        return stockBook;
    }

    public int getStatusBook() {
        return statusBook;
    }

    public String getSubTitleBook() {
        return subTitleBook;
    }

    public String getSynopsisBook() {
        return synopsisBook;
    }

    public String getPathIconBook() {
        return pathIconBook;
    }

    public float getWeightBook() {
        return weightBook;
    }

    public float getSizeLargeBook() {
        return sizeLargeBook;
    }

    public float getSizeLongBook() {
        return sizeLongBook;
    }

    public String getCommentBook() {
        return commentBook;
    }

    public Editor getEditor() {
        return editor;
    }
    

    public Collection getListSubTheme() {
        return listSubTheme;
    }

    public Collection getListAuthor() {
        return listAuthor;
    }

    public Collection getListKeyWord() {
        return listKeyWord;
    }

    public CodeTVA getCodeTVA() {
        return codeTVA;
    }

    public Collection getListEvent() {
        return listEvent;
    }

    public Collection getListAppreciation() {
        return listAppreciation;
    }

    public Collection getListOrderLine() {
        return listOrderLine;
    }
    
    
    public void setCodeTVA(CodeTVA codeTVA) {
        this.codeTVA = codeTVA;
    }

    public void setListEvent(Collection listEvent) {
        this.listEvent = listEvent;
    }

    public void setListAppreciation(Collection listAppreciation) {
        this.listAppreciation = listAppreciation;
    }

    //SETTERS
    public void setListOrderLine(Collection listOrderLine) {
        this.listOrderLine = listOrderLine;
    }

    public void setNumISBNBook(String numISBNBook) {
        this.numISBNBook = numISBNBook;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }    
    
    public void setCodeTva(CodeTVA codeTva) {
        this.codeTVA = codeTva;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public void setUnitCostBook(float unitCostBook) {
        this.unitCostBook = unitCostBook;
    }

    public void setStockBook(int stockBook) {
        this.stockBook = stockBook;
    }

    public void setStatusBook(int statusBook) {
        this.statusBook = statusBook;
    }

    public void setSubTitleBook(String subTitleBook) {
        this.subTitleBook = subTitleBook;
    }

    public void setSynopsisBook(String synopsisBook) {
        this.synopsisBook = synopsisBook;
    }

    public void setPathIconBook(String pathIconBook) {
        this.pathIconBook = pathIconBook;
    }

    public void setWeightBook(float weightBook) {
        this.weightBook = weightBook;
    }

    public void setSizeLargeBook(float sizeLargeBook) {
        this.sizeLargeBook = sizeLargeBook;
    }

    public void setSizeLongBook(float sizeLongBook) {
        this.sizeLongBook = sizeLongBook;
    }

    public void setCommentBook(String commentBook) {
        this.commentBook = commentBook;
    }

    public void setListSubTheme(Collection listSubTheme) {
        this.listSubTheme = listSubTheme;
    }

    public void setListAuthor(Collection listAuthor) {
        this.listAuthor = listAuthor;
    }

    public void setListKeyWord(Collection listKeyWord) {
        this.listKeyWord = listKeyWord;
    }   

    public int getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(int moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public String getId() {
        return numISBNBook;
    }

    @Override
    public void setId(String numISBNBook) {
        this.numISBNBook = numISBNBook;
    }

}
