/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.domain.orders.Orders;
import java.util.Date;

/**
 *
 * @author youssef
 */
public class Invoice {
    
    private Orders order;
    private Customer customer;
    private Date dateInvoice;

    public Invoice() {
      
    }
    
    public Invoice(Orders order) {
        this.order = order;
    }
    
     public void checkData() throws CheckException {
        if (order == null || "".equals(order))
            throw new CheckException("Invalid Invoice, order must be not null");
        
    }
    
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }
    
    
    
    
    
    
}
