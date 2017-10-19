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
public class ComparePrixAsc implements Comparator<Book> {
    
    @Override
    public int compare(Book o1, Book o2) {

        return new Float(o1.getUnitCostBook()).compareTo( new Float(o2.getUnitCostBook()));
        
    }
    
    
}
