/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.server.domain.customers.Address;
import com.cdi.g3.server.service.customers.CustomerService;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.service.customers.AdressService;
import com.cdi.g3.server.service.orders.OrderService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cdi314
 */
public class beanCustomer implements Serializable {
    private OrderService orderService;
    private CustomerService customerService ;
    private AdressService adressService;
    private Customer customer; 
    private Collection addressShipList;
    private Collection addressBillList;
    private Address addressBill;
    private Address addressShip;
    private beanAddress bAddress;
    private String confirmationPassword;
    private String resultat;
    private Map<String, String> erreurs;
    private Collection orderList;
     private String provenance;
    
    public beanCustomer() {
        customer = new Customer();
        bAddress= new  beanAddress();
        addressShipList = new ArrayList();
        addressBillList= new ArrayList();
        addressBill = new  Address();
        addressShip = new  Address();
        customerService = new CustomerService();
        adressService = new AdressService();
        orderService = new OrderService();
        erreurs = new HashMap<String, String>();
    }

    public beanCustomer(String login) throws ObjectNotFoundException, CheckException, FinderException {
        this();
        this.customer = customerService.findCustomer(login);
        this.addressBillList = adressService.findAllAdressBilling(this.customer.getLoginCustomer());
        this.addressShipList = adressService.findAllAdressShipping(this.customer.getLoginCustomer());
        this.addressBill =(Address) ((ArrayList) addressBillList).get(0);
        this.addressShip = (Address) ((ArrayList) addressShipList).get(0);
        this.orderList = orderService.findOrdersByCustomer("LOGINCUSTOMER", this.customer.getLoginCustomer());
    }
    
    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }
    
    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public beanAddress getbAddress() {
        return bAddress;
    }

    public void setbAddress(beanAddress bAddress) {
        this.bAddress = bAddress;
    }

    public Address getAddressBill() {
        return addressBill;
    }

    public Collection getAddressShipList() {
        return addressShipList;
    }

    public void setAddressShipList(Collection addressShipList) {
        this.addressShipList = addressShipList;
    }

    public Collection getAddressBillList() {
        return addressBillList;
    }

    public void setAddressBillList(Collection addressBillList) {
        this.addressBillList = addressBillList;
    }
    
    

    public void setAddressBill(Address addressBill) {
        this.addressBill = addressBill;
    }

    public Address getAddressShip() {
        return addressShip;
    }

    public Collection getOrderList() {
        return orderList;
    }

    public void setOrderList(Collection orderList) {
        this.orderList = orderList;
    }

    public void setAddressShip(Address addressShip) {
        this.addressShip = addressShip;
    }
    
    public Customer getCustomer(String login) {
        return this.customer;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }
    
    public beanCustomer updateCustomer() throws  UpdateException, CheckException, ObjectNotFoundException{
            try {
                validationNom(customer.getLastNameCustomer());
            } catch (Exception e) {
                this.setErreur("lastNameCustomer", e.getMessage());
            }
            customer.setLastNameCustomer(customer.getLastNameCustomer());

            try {
                validationNom(customer.getFirstNameCustomer());
            } catch (Exception e) {
                this.setErreur("firstNameCustomer", e.getMessage());
            }
            customer.setFirstNameCustomer(customer.getFirstNameCustomer());

            if (this.getErreurs().isEmpty()) {
                this.setResultat("Succès de l'inscription.");
                customerService.updateCustomer(this.customer);
                this.setCustomer(customerService.findCustomer(this.customer.getId()));
                
            } else {
                this.setResultat("Échec de l'inscription.");
            }

            return this;
    }
    
    
    
    

    public beanCustomer registerCustomer() throws CreateException, CheckException {

        try {
            customerService.findCustomer(customer.getLoginCustomer());
            this.setErreur("loginCustomer", "Ce login existe déjà, merci de choisir un autre login");
            return this;

        } catch (ObjectNotFoundException ex) {
            try {
                validationNom(customer.getLoginCustomer());
            } catch (Exception e) {
                this.setErreur("loginCustomer", e.getMessage());
            }
            customer.setLoginCustomer(customer.getLoginCustomer());

            try {
                validationEmail(customer.getEmailCustomer());
            } catch (Exception e) {
                this.setErreur("emailCustomer", e.getMessage());
            }
            customer.setEmailCustomer(customer.getEmailCustomer());

            try {
                validationMotsDePasse(customer.getPasswordCustomer(), this.getConfirmationPassword());
            } catch (Exception e) {
                this.setErreur("passwordCustomer", e.getMessage());
                this.setErreur(this.getConfirmationPassword(), null);
            }
            customer.setPasswordCustomer(customer.getPasswordCustomer());

            try {
                validationNom(customer.getLastNameCustomer());
            } catch (Exception e) {
                this.setErreur("lastNameCustomer", e.getMessage());
            }
            customer.setLastNameCustomer(customer.getLastNameCustomer());

            try {
                validationNom(customer.getFirstNameCustomer());
            } catch (Exception e) {
                this.setErreur("firstNameCustomer", e.getMessage());
            }
            customer.setFirstNameCustomer(customer.getFirstNameCustomer());

            if (this.getErreurs().isEmpty()) {
                this.setResultat("Succès de l'inscription.");
                customerService.createCustomer(customer);
            } else {
                this.setResultat("Échec de l'inscription.");
            }

            return this;
        }

    }

    private void validationEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
        if (motDePasse != null && confirmation != null) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }

    private void validationNom(String nom) throws Exception {
        if (nom != null && nom.length() < 3) {
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }

}
