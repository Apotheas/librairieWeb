/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.utiles;

import java.io.Serializable;

/**
 *
 * @author cdi314
 */
public class Item  implements Serializable{
    
    private String ref;
    private int quantity;

    public Item(String ref, int quantity) {
        this.ref = ref;
        this.quantity = quantity;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void delta (int qty){
        this.quantity += qty;
    }
    
    
    
}
