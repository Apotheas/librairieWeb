/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.web.utiles.Item;
import java.beans.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cdi314
 */
public class beanPanier implements Serializable {
    
    Map<String,Item>  map ;
    
    
    public beanPanier() {
        this.map = new HashMap(); 
    }
    
    
    
    public void add(String ref, int quantity){ 
        if(this.map.containsKey(ref)){
            Item i = this.map.get(ref);
            i.delta(quantity);
            
        }else{
            this.map.put(ref, new Item(ref, quantity));
        }
            
    }
    
    public void add(String ref){
        this.add(ref,1);
    }
    
    public void dec(String ref){  
         this.add(ref,-1);
    }
    
    public void del(String ref){ 
        this.map.remove(ref);
    }
    
    public boolean isEmpty(){
        return this.map.isEmpty();
    }
    
    public void clear(){
        this.map.clear();
    }
    
    public int getSize(){
        return this.map.size();
    }
    
    public Collection<Item> list(){
        return this.map.values();
    }
    
    public float getTotalHT(){
      return -1; 
    }
    
    public float getTotalTTC(){
      return -1; 
    }
    
}
