/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.orders;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.customers.Appreciation;
import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author youssef
 */
public class OrderLine extends DomainObject implements Serializable{
    
   // ======================================
    // =             Attributes             =
    // ======================================
    
   private  String idOrderLine;
   private int quantityOrderLine;   
   private float unitCostOrderLine;
   private Orders order;
   private Book book;  
   private float discountOrderLine;
   private float rateTvaOrderLine;
   private  Appreciation appreciation;
   
  // ======================================
    // =            Constructors            =
    // ======================================
    public OrderLine() {
    }

    public OrderLine(final String id) {
       idOrderLine = id;
    } 
	public OrderLine(final String id, int quantityOrderLine, float unitCostOrderLine, Orders order, Book book){
		super();
		idOrderLine = id;
		this.quantityOrderLine = quantityOrderLine;
		this.unitCostOrderLine = unitCostOrderLine;
		this.order = order;
		this.book = book;		
	} 
        public OrderLine(int quantityOrderLine, float unitCostOrderLine, Orders order, Book book){
		super();		
		this.quantityOrderLine = quantityOrderLine;
		this.unitCostOrderLine = unitCostOrderLine;
		this.order = order;
		this.book = book;
		
	} 
        public OrderLine(Book book , int quantityOrderLine, float unitCostOrderLine,float rateTvaOrderLine){
		super();
                this.book = book;
		this.quantityOrderLine = quantityOrderLine;
		this.unitCostOrderLine = unitCostOrderLine;
		this.rateTvaOrderLine = rateTvaOrderLine;
	} 
    // ======================================
    // =           Business methods         =
    // ======================================

    public void checkData() throws CheckException {
        if (order == null || "".equals(order))
            throw new CheckException("Invalid orderLine ");
        if (book == null || "".equals(book))
            throw new CheckException("Invalid orderLine ");
        if (quantityOrderLine <= 0 )
            throw new CheckException("Invalid orderLine quantity");
    }

   // ======================================
    // =         Getters and Setters        =
    // ======================================
     @Override
    public String getId() {
        return idOrderLine;
    }
    @Override
    public void setId(String idOrderLine) {
        this.idOrderLine = idOrderLine;
    }

    public String getIdOrderLine() {
        return idOrderLine;
    }

    public void setIdOrderLine(String idOrderLine) {
        this.idOrderLine = idOrderLine;
    }

    public int getQuantityOrderLine() {
        return quantityOrderLine;
    }

    public void setQuantityOrderLine(int quantityOrderLine) {
        this.quantityOrderLine = quantityOrderLine;
    }

    public float getUnitCostOrderLine() {
        return unitCostOrderLine;
    }

    public void setUnitCostOrderLine(float unitCostOrderLine) {
        this.unitCostOrderLine = unitCostOrderLine;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public float getDiscountOrderLine() {
        return discountOrderLine;
    }

    public void setDiscountOrderLine(float discountOrderLine) {
        this.discountOrderLine = discountOrderLine;
    }

    public float getRateTvaOrderLine() {
        return rateTvaOrderLine;
    }

    public void setRateTvaOrderLine(float rateTvaOrderLine) {
        this.rateTvaOrderLine = rateTvaOrderLine;
    }

    public Appreciation getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Appreciation appreciation) {
        this.appreciation = appreciation;
    }
    
    public Vector getVector() {
        Vector v = new Vector();
        v.add(this);        
        v.add(this.getOrder().getId());
         v.add(this.getBook().getId());
        v.add(this.getQuantityOrderLine());
        v.add(this.getUnitCostOrderLine());
        v.add(this.getDiscountOrderLine());
        v.add(this.getRateTvaOrderLine());
        v.add(this.getAppreciation().getId());        
        return v;
    }
    
    
    
    
    
   

    @Override
    public String toString() {
        return idOrderLine + " " + book ;
    }
    
    
    
}
