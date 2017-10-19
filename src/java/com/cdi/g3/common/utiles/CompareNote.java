/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.common.utiles;

import com.cdi.g3.server.domain.catalog.Book;
import java.util.Comparator;

/**
 *
 * @author cdi317
 */
public class CompareNote implements Comparator<Book> {
    
    @Override
    public int compare(Book o1, Book o2) {
        String prixo1 = String.valueOf(o1.getMoyenne()) ;
        String prixo2 = String.valueOf(o2.getMoyenne()) ;
        return prixo2.compareTo(prixo1);
    }
    
    
}
