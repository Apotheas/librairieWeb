/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.customers;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.RemoveException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.customers.Adress;
import com.cdi.g3.server.domain.customers.AdressDAO;
import com.cdi.g3.server.service.AbstractService;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Izet
 */
public class AdressService extends AbstractService {

    // ======================================
    // = Attributes =
    // ======================================
    private static final AdressDAO _daoAdress = new AdressDAO();

    public static AdressDAO getDaoAdress() {
        return _daoAdress;
    }
    
    

    // ======================================
    // = Constructors =
    // ======================================
    public AdressService() {

    }

    // ======================================
    // = Business methods =
    // ======================================
    public Adress createAdress(final Adress adress) throws CreateException, CheckException {
        final String mname = "createAdress";
        Trace.entering(_cname, mname, adress);

        if (adress == null) {
            throw new CreateException("Adress object is null");
        }

        if (adress.getCustomerBillAdress() == null && adress.getListOrdersShipping() == null) {
            throw new CheckException("Invalid Customer for Adress");
        }
        adress.checkData();
//        checkId(adress.getId());
       
        _daoAdress.insert(adress);

        Trace.exiting(_cname, mname, adress);
        return adress;
    }

    public Adress findAdress(final String adressId) throws FinderException, CheckException {
        final String mname = "findAdress";
        Trace.entering(_cname, mname, adressId);

        checkId(adressId);
        // Finds the object
        final Adress adress = (Adress) _daoAdress.findByPrimaryKey(adressId);
        Trace.exiting(_cname, mname, adress);
        return adress;
    }

    public void deleteAdress(final String adressId) throws RemoveException, CheckException {
        final String mname = "deleteAdress";
        Trace.entering(_cname, mname, adressId);

        checkId(adressId);

        // Checks if the object exists
        try {
            _daoAdress.findByPrimaryKey(adressId);
        } catch (FinderException e) {
            throw new RemoveException("Adress must exist to be deleted");
        }

        // Deletes the object
        try {
            _daoAdress.remove(adressId);
        } catch (ObjectNotFoundException e) {
            throw new RemoveException("Adress must exist to be deleted");
        }
    }

    public void updateAdress(Adress adress) throws UpdateException, CheckException {
        final String mname = "updateAdress";
        Trace.entering(_cname, mname, adress);
        
       if (adress == null) {
            throw new UpdateException("Customer object is null");
        }

        checkId(adress.getId());
        // Checks if the object exists
        try {           
           _daoAdress.findByPrimaryKey(adress.getId());
        } catch (FinderException e) {
            throw new UpdateException("Customer must exist to be updated");
        }

        adress.checkData();

        // Updates the object
        try {
            _daoAdress.update(adress);
        } catch (ObjectNotFoundException e) {
            throw new UpdateException("Customer must exist to be updated");
        }
            

    }
    public Collection findAllAdress() throws FinderException {
        final String mname = "findAdress";
        Trace.entering(_cname, mname);

        // Finds all the objects
        final Collection adress = _daoAdress.findAll();

        Trace.exiting(_cname, mname, new Integer(adress.size()));
        return adress;
    }
    
    public Collection findAllAdressShipping(String loginCustomer) throws FinderException {
        final String mname = "findAllAdressShipping";
        Trace.entering(_cname, mname);
        // Finds all the objects
        final Collection listAddressShipping = _daoAdress.findAllByChamp("loginCustomerShipAdress", loginCustomer);
        Trace.exiting(_cname, mname, new Integer(listAddressShipping.size()));
        return listAddressShipping;
    }
    public Adress findAdressShipping(String loginCustomer) throws FinderException {
        final String mname = "findAdressShipping";
        Trace.entering(_cname, mname);
        // Finds all the objects
        final Collection listAddressShipping = _daoAdress.findAllByChamp("loginCustomerShipAdress", loginCustomer);
        ArrayList addressShipping = new ArrayList();
        addressShipping.addAll(listAddressShipping);       
        
        Trace.exiting(_cname, mname, new Integer(listAddressShipping.size()));
        return  (Adress) addressShipping.get(0);
    }
    
    public Collection findAllAdressBilling(String loginCustomer) throws FinderException {
        final String mname = "findAllAdressBilling";
        Trace.entering(_cname, mname);
        // Finds all the objects        
        final Collection listAddressBilling = _daoAdress.findAllByChamp("loginCustomerBillAdress",loginCustomer);
        
        Trace.exiting(_cname, mname, new Integer(listAddressBilling.size()));
        return listAddressBilling;
    }
    
    public Adress findAdressBilling(String loginCustomer) throws FinderException {
        final String mname = "findAllAdressBilling";
        Trace.entering(_cname, mname);
        // Finds all the objects        
        final Collection listAddressBilling = _daoAdress.findAllByChamp("loginCustomerBillAdress",loginCustomer);
        ArrayList addressBilling = new ArrayList();
        addressBilling.addAll(listAddressBilling);
        
        Trace.exiting(_cname, mname, new Integer(listAddressBilling.size()));
        return (Adress) addressBilling.get(0);
        
    }
    
    /**
     * This method returns a unique identifer generated by the system.
     *
     * @return a unique identifer
     */
    public final String getUniqueId() {
        return _daoAdress.getUniqueId();
    }

}
