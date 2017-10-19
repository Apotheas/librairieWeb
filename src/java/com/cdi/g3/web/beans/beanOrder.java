/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.domain.orders.Orders;
import com.cdi.g3.server.service.GeneratorInvoice;
import com.cdi.g3.server.service.orders.OrderService;
import java.io.Serializable;

/**
 *
 * @author cdi314
 */
 /* Propriétés du bean */
public class beanOrder implements Serializable{
    OrderService orderService = new OrderService();

    public beanOrder() {
    }
    
    public void print(String orderId) throws FinderException, CheckException{
        Orders order = orderService.findOrder(orderId);
         GeneratorInvoice.printInvoce(order);
    }
    
    
    
}