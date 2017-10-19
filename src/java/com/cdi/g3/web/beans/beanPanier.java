/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.service.orders.OrderService;
import com.cdi.g3.web.utiles.Item;
import java.beans.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cdi314
 */
public class beanPanier implements Serializable {
    private OrderService orderService = new OrderService();
    Map<String,Item>  map ;
    float tva =5.5f;
    
    public beanPanier() {
        this.map = new HashMap(); 
        
    }
    
    public void add(String ref, int quantity) throws FinderException, CheckException{ 
        if(this.map.containsKey(ref)){
            Item i = this.map.get(ref);
            i.delta(quantity);
        }else{
            this.map.put(ref, new Item(ref, quantity));
        }
            
    }
    
    public void add(String ref) throws FinderException, CheckException{
        this.add(ref,1);
    }
    
    public void dec(String ref) throws FinderException, CheckException{  
         this.add(ref,-1);
    }
    
    public void del(String ref){ 
        this.map.remove(ref);
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
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
        float total=0 ;
        for ( Item item : this.map.values()){
           total += item.getTotalLine();
            
        }
      total = Utility.formatFloatToFloatPrecision (total,2); 
      return total; 
    }
    
    public float getFraisPort(){
        float fraisPort = 0;
        try {
            fraisPort = orderService.findPackagesShipper("1").getCostPachageShipper();
        } catch (FinderException ex) {
            Logger.getLogger(beanPanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fraisPort;
        
     }
    
     
    public float getTotalTTC(){
      float total =0 ;
        for ( Item item : this.map.values()){
           total += item.getTotalLine() + (item.getTotalLine()*item.getBook().getCodeTva().getRateCodeTva())/100;
        }
        total = Utility.formatFloatToFloatPrecision (total,2);        
        return total; 
    }
    
    public String checkOut(String login, Collection<Item>  shoppingCart) throws CreateException, CheckException, FinderException{
        String orderId = orderService.createOrder(login, shoppingCart);
        return orderId;
    }
    
    
}
