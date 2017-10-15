package com.cdi.g3.web.beans;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.customers.Address;
import com.cdi.g3.server.service.customers.AdressService;
import com.cdi.g3.server.service.customers.CustomerService;
import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author youssef
 */
public class beanAddress implements Serializable {
    private CustomerService customerService;
    private AdressService adressService;
    private Address addressBill;
    private Address addressShip;
    private String resultat;
    private Map<String, String> erreurs;

    public beanAddress() {
        customerService = new CustomerService();
        adressService = new AdressService();
        addressBill = new Address();  
        addressShip = new Address();  
        erreurs = new HashMap<String, String>();
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

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    public Address getAddressBill() {
        return addressBill;
    }

    public void setAddressBill(Address addressBill) {
        this.addressBill = addressBill;
    }

    public Address getAddressShip() {
        return addressShip;
    }

    public void setAddressShip(Address addressShip) {
        this.addressShip = addressShip;
    }

    

    public beanAddress registerAddressBill(String login) throws CreateException, CheckException {

        try {
            customerService.findCustomer(login); 
            if (!Utility.regexCp(addressBill.getZipcodeAdress()));
                this.setErreur("zipcodeAdress", "Enter un code postale valide");
                
            if (!Utility.regexCp(addressBill.getZipcodeAdress()));
                this.setErreur("zipcodeAdress", "Enter un code postale valide");                
            if (addressBill.getNameReceiverAdress()==null || addressBill.getNameReceiverAdress().isEmpty());
                this.setErreur("nameReceiverAdress", "Le nom de receveur ne doit pas étre null");
            if (addressBill.getNumAdress()==null || addressBill.getNumAdress().isEmpty());
                this.setErreur("numAdress", "Le numéro ne doit pas étre null");   
           if (addressBill.getNameReceiverAdress()==null || addressBill.getNameReceiverAdress().isEmpty());
                this.setErreur("nameStreetAdress", "Le nom de voie ne doit pas étre null");   
           if (addressBill.getCityAdress()==null || addressBill.getCityAdress().isEmpty());
                this.setErreur("cityAdress", "Le ville ne doit pas étre null"); 
            if (addressBill.getCountryAdress()==null || addressBill.getCountryAdress().isEmpty());
                this.setErreur("countryAdress", "Le ville ne doit pas étre null");         
                
           
            if (this.getErreurs().isEmpty()) {
                this.setResultat("Succès de l'inscription.");
                adressService.createAdress(addressBill);
            } else {
                this.setResultat("Échec de l'inscription.");
            }     
                
            return this;
        } catch (ObjectNotFoundException ex) {
            this.setErreur("loginCustomer", "problème de rajoter une adresse");
            return this;

        }
        
    }
    
     public beanAddress registerAddressShip(String login) throws CreateException, CheckException {

        try {
            customerService.findCustomer(login); 
            if (!Utility.regexCp(addressShip.getZipcodeAdress()));
                this.setErreur("zipcodeAdress", "Enter un code postale valide");
                
            if (!Utility.regexCp(addressShip.getZipcodeAdress()));
                this.setErreur("zipcodeAdress", "Enter un code postale valide");                
            if (addressShip.getNameReceiverAdress()==null || addressShip.getNameReceiverAdress().isEmpty());
                this.setErreur("nameReceiverAdress", "Le nom de receveur ne doit pas étre null");
            if (addressShip.getNumAdress()==null || addressShip.getNumAdress().isEmpty());
                this.setErreur("numAdress", "Le numéro ne doit pas étre null");   
           if (addressShip.getNameReceiverAdress()==null || addressShip.getNameReceiverAdress().isEmpty());
                this.setErreur("nameStreetAdress", "Le nom de voie ne doit pas étre null");   
           if (addressShip.getCityAdress()==null || addressShip.getCityAdress().isEmpty());
                this.setErreur("cityAdress", "Le ville ne doit pas étre null"); 
            if (addressShip.getCountryAdress()==null || addressShip.getCountryAdress().isEmpty());
                this.setErreur("countryAdress", "Le ville ne doit pas étre null");         
                
           
            if (this.getErreurs().isEmpty()) {
                this.setResultat("Succès de l'inscription.");
                adressService.createAdress(addressShip);
            } else {
                this.setResultat("Échec de l'inscription.");
            }     
                
            return this;
        } catch (ObjectNotFoundException ex) {
            this.setErreur("loginCustomer", "problème de rajoter une adresse");
            return this;

        }
        
    }

}
