/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.customers;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.company.Company;
import com.cdi.g3.server.domain.company.Employe;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author youssef
 */
public class Appreciation extends DomainObject implements Serializable{

   // ======================================
    // =             Attributes             =
    // ======================================
    private String idAppreciate;
    private Employe loginEmployeAppreciate;
    private Customer loginCustomerAppreciate;
    private String idOrderlineAppreciate;
    private String numIsbnBookAppreciate;
    private String commentAppreciate;
    private String ratingAppreciate;
    private String dateAppreciate;
    private String ipAppreciate;
    private String moderateAppreciate;
    private String dateModerateAppreciate;
    private int statusAppreciate;
   

    

    // ======================================
    // =           Business methods         =
    // ======================================
    public void checkData() throws CheckException {
        if (((loginEmployeAppreciate == null || "".equals(loginEmployeAppreciate)))
                && ((loginCustomerAppreciate == null || "".equals(loginCustomerAppreciate)))) {
            throw new CheckException("Invalid loginCustomerBillAdress , must be insert ");
        }

      

        if (commentAppreciate == null || "".equals(commentAppreciate)) {
            throw new CheckException("Invalid commentAppreciate, must be insert");
        }

        if (ratingAppreciate == null || "".equals(ratingAppreciate)) {
            throw new CheckException("Invalid ratingAppreciate , must be insert");
        }

        if (ipAppreciate == null || "".equals(ipAppreciate)) {
            throw new CheckException("Invalid ipAppreciate  , must be insert");
        }

        if (moderateAppreciate == null || "".equals(moderateAppreciate)) {
            throw new CheckException("Invalid moderateAppreciate  , must be insert");
        }

    }

    // ======================================
    // =            Constructors            =
    // ======================================
    public Appreciation() {
    }

    public Appreciation(final String id) {
        idAppreciate = id;
    }

    public Appreciation(final String id,
            Employe loginEmployeAppreciate,
            Customer loginCustomerAppreciate,
            String idOrderlineAppreciate,
            String numIsbnBookAppreciate,
            String commentAppreciate,
            String ratingAppreciate,
            String dateAppreciate,
            String ipAppreciate,
            String moderateAppreciate,
            String dateModerateAppreciate,
            Company nameCompanyReceiverAdress) {
        super();

        idAppreciate = id;
        this.loginEmployeAppreciate = loginEmployeAppreciate;
        this.loginCustomerAppreciate = loginCustomerAppreciate;
        this.idOrderlineAppreciate = idOrderlineAppreciate;
        this.numIsbnBookAppreciate = numIsbnBookAppreciate;
        this.commentAppreciate = commentAppreciate;
        this.ratingAppreciate = ratingAppreciate;
        this.dateAppreciate = dateAppreciate;
        this.ipAppreciate = ipAppreciate;
        this.moderateAppreciate = moderateAppreciate;
        this.dateModerateAppreciate = dateModerateAppreciate;
       
    }

    // ======================================
    // =         Getters and Setters        =
    // ======================================
    @Override
    public String getId() {
        return idAppreciate;
    }
    @Override
    public void setId(String idAppreciate) {
        this.idAppreciate = idAppreciate;
    }

    public String getIdAppreciate() {
        return idAppreciate;
    }

    public void setIdAppreciate(String idAppreciate) {
        this.idAppreciate = idAppreciate;
    }

    public Employe getLoginEmployeAppreciate() {
        return loginEmployeAppreciate;
    }

    public void setLoginEmployeAppreciate(Employe loginEmployeAppreciate) {
        this.loginEmployeAppreciate = loginEmployeAppreciate;
    }

    public Customer getLoginCustomerAppreciate() {
        return loginCustomerAppreciate;
    }

    public void setLoginCustomerAppreciate(Customer loginCustomerAppreciate) {
        this.loginCustomerAppreciate = loginCustomerAppreciate;
    }

    public String getIdOrderlineAppreciate() {
        return idOrderlineAppreciate;
    }

    public void setIdOrderlineAppreciate(String idOrderlineAppreciate) {
        this.idOrderlineAppreciate = idOrderlineAppreciate;
    }

    public String getNumIsbnBookAppreciate() {
        return numIsbnBookAppreciate;
    }

    public void setNumIsbnBookAppreciate(String numIsbnBookAppreciate) {
        this.numIsbnBookAppreciate = numIsbnBookAppreciate;
    }

    public String getCommentAppreciate() {
        return commentAppreciate;
    }

    public void setCommentAppreciate(String commentAppreciate) {
        this.commentAppreciate = commentAppreciate;
    }

    public String getRatingAppreciate() {
        return ratingAppreciate;
    }

    public void setRatingAppreciate(String ratingAppreciate) {
        this.ratingAppreciate = ratingAppreciate;
    }

    public String getDateAppreciate() {
        return dateAppreciate;
    }

    public void setDateAppreciate(String dateAppreciate) {
        this.dateAppreciate = dateAppreciate;
    }

    public String getIpAppreciate() {
        return ipAppreciate;
    }

    public void setIpAppreciate(String ipAppreciate) {
        this.ipAppreciate = ipAppreciate;
    }

    public String getModerateAppreciate() {
        return moderateAppreciate;
    }

    public void setModerateAppreciate(String moderateAppreciate) {
        this.moderateAppreciate = moderateAppreciate;
    }

    public String getDateModerateAppreciate() {
        return dateModerateAppreciate;
    }

    public void setDateModerateAppreciate(String dateModerateAppreciate) {
        this.dateModerateAppreciate = dateModerateAppreciate;
    }

    public int getStatusAppreciate() {
        return statusAppreciate;
    }

    public void setStatusAppreciate(int statusAppreciate) {
        this.statusAppreciate = statusAppreciate;
    }
    

    @Override
    public String toString() {
        return  idAppreciate + loginEmployeAppreciate +  loginCustomerAppreciate 
                + idOrderlineAppreciate +  numIsbnBookAppreciate  
                + commentAppreciate  + ratingAppreciate  
                + dateAppreciate  + ipAppreciate 
                + moderateAppreciate  + dateModerateAppreciate ;
    }
   
    }

  
