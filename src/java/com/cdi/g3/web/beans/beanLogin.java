/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;


import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.server.service.customers.CustomerService;
import com.cdi.g3.server.domain.customers.Customer;
import java.beans.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cdi314
 */
public class beanLogin implements Serializable {
    private CustomerService customerService = new CustomerService() ;
    private String login;
    private String password;
    
   
    public beanLogin() {
        
    }
    
   public boolean checkLogin(String login, String password){
        if(login==null) return false;
        if(password==null) return false;
        if(password.trim().isEmpty()) return false;
        if(login.trim().isEmpty()) return false;
        
       Customer customer=null;
        try {
            customer = customerService.authenticate(login, password);
        } catch (FinderException ex) {
            ex.printStackTrace();
            return false;
        } catch (CheckException ex) {
            ex.printStackTrace();
            return false;
        }
        if(login.equals(customer.getId())){
            if(password.equals(customer.getPasswordCustomer())){
                return true;
            }
            
        }
        return false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
   
    
}
