package com.cdi.g3.server.service.customers;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.RemoveException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.customers.Address;
import com.cdi.g3.server.domain.customers.AddressDAO;
import com.cdi.g3.server.domain.customers.Appreciation;
import com.cdi.g3.server.domain.customers.AppreciationDAO;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.domain.customers.CustomerDAO;
import com.cdi.g3.server.domain.orders.InfoStatusDAO;
import com.cdi.g3.server.domain.orders.Orders;
import com.cdi.g3.server.domain.orders.OrdersDAO;
import com.cdi.g3.server.service.AbstractService;
import java.util.Collection;
import java.util.Iterator;


/**
 * This class is a facade for all customer services.
 */
public final class CustomerService extends AbstractService {

    // ======================================
    // = Attributes =
    // ======================================
    private static final CustomerDAO _daoCustomer = new CustomerDAO();
//  private static final AddressDAO _daoAdress = new AddressDAO();
    private static final AdressService serviceAdress = new AdressService();
    private static final AppreciationDAO _daoAppreciation = new AppreciationDAO();
    private static final OrdersDAO _daoOrder = new OrdersDAO();
    private static final InfoStatusDAO _infoStatusDAO = new InfoStatusDAO();


    // ======================================
    // = Constructors =
    // ======================================
    public CustomerService() {

    }

    // ======================================
    // = Business methods =
    // ======================================
    public Customer authenticate(final String customerId, final String password) throws FinderException, CheckException {
        final String mname = "authenticate";
        Trace.entering(_cname, mname, new Object[]{customerId, password});

        checkId(customerId);
        if (password == null || "".equals(password))
            throw new CheckException("Invalid password");        
        // Finds the object
        final Customer customer = (Customer)_daoCustomer.findByPrimaryKey(customerId);
        // Check if it's the right password, if not, a CheckException is thrown
        customer.matchPassword(password);
        
        Trace.exiting(_cname, mname, customer);
        return customer;
    }
    
    
    
    public Customer createCustomer(final Customer customer) throws CreateException, CheckException {
        final String mname = "createCustomer";
        Trace.entering(_cname, mname, customer);

        if (customer == null) {
            throw new CreateException("Customer object is null");
        }
        customer.checkData();
        //checkId( customer.getId() );
        checkId(customer.getId());

//        // Creates all the adressBilling linked with the customer
//        for (Iterator iterator = customer.getListAddressBilling().iterator(); iterator.hasNext();) {
//            final Address adressBilling = (Address) iterator.next();
//            adressBilling.checkData();            
//            adressBilling.setCustomerBillAdress(customer);
//            serviceAdress.getDaoAdress().insert(adressBilling);
//        }
//        
//        // Creates all the adressShipping linked with the customer
//        for (Iterator iterator = customer.getListAddressShipping().iterator(); iterator.hasNext();) {
//            final Address adressShipping = (Address) iterator.next();
//            adressShipping.checkData();  
//            adressShipping.setCustomerShipAdress(customer);
//            serviceAdress.getDaoAdress().insert(adressShipping);
//        }
    
        // Creates the object
        _daoCustomer.insert(customer);

        Trace.exiting(_cname, mname, customer);
        return customer;
    }

    public Customer findCustomer(final String customerId) throws ObjectNotFoundException, CheckException {
        final String mname = "findCustomer";
        Trace.entering(_cname, mname, customerId);

        checkId(customerId);
        // Finds the object
        final Customer customer = (Customer) _daoCustomer.findByPrimaryKey(customerId);       
        
        // RetreCollectionives the data for all the customer adress shipping//        
         try {
            final Collection  listAddressShipping = serviceAdress.getDaoAdress().findAllByChamp("loginCustomerShipAdress", customer.getLoginCustomer());
            customer.setlistAddressShipping(listAddressShipping);
         } 
           catch( ObjectNotFoundException e) {}
//        }        
        
        // Retreives the data for all the customer adress billing
        try {
        final Collection listAddressBilling;
        listAddressBilling = serviceAdress.getDaoAdress().findAllByChamp("loginCustomerBillAdress", customer.getLoginCustomer());
        customer.setlistAddressBilling(listAddressBilling);
          } 
           catch( ObjectNotFoundException e) {}          
        
        Trace.exiting(_cname, mname, customer);
        return customer;        
    }
    

    public void deleteCustomer(final String customerId) throws RemoveException, CheckException {
        final String mname = "deleteCustomer";
        Trace.entering(_cname, mname, customerId);

        checkId(customerId);

        // Checks if the object exists
        try {
            _daoCustomer.findByPrimaryKey(customerId);
        } catch (FinderException e) {
            throw new RemoveException("Customer must exist to be deleted");
        }

        // Deletes the object
        try {
            _daoCustomer.remove(customerId);
        } catch (ObjectNotFoundException e) {
            throw new RemoveException("Customer must exist to be deleted");
        }
    }

    public void updateCustomer(Customer customer) throws UpdateException, CheckException {
        final String mname = "updateCustomer";
        Trace.entering(_cname, mname, customer);

        if (customer == null) {
            throw new UpdateException("Customer object is null");
        }
        checkId(customer.getId());

//        final Customer customerFinded;

        // Checks if the object exists
        try {
            //customerFinded = (Customer) _daoCustomer.findByPrimaryKey(customer.getId());
           _daoCustomer.findByPrimaryKey(customer.getId());
        } catch (FinderException e) {
            throw new UpdateException("Customer must exist to be updated");
        }

        customer.checkData();
//        customer = setCustomer(customer, customerFinded);

        // Updates the object
        try {
            _daoCustomer.update(customer);
        } catch (ObjectNotFoundException e) {
            throw new UpdateException("Customer must exist to be updated");
        }
    }

    public Collection findCustomers() throws FinderException {
        final String mname = "findCustomers";
        Trace.entering(_cname, mname);

        // Finds all the objects
        final Collection customers = _daoCustomer.findAll();

        Trace.exiting(_cname, mname, new Integer(customers.size()));
        return customers;
    }
    
    public Customer findCustomerByEmail(String column, String champ) throws ObjectNotFoundException {
        final String mname = "findCustomerByNumEmail";
        Trace.entering(_cname, mname);
        return   (Customer) _daoCustomer.findByChamp(column, champ);
        
    }
    
    public Collection findStatusCustomers() throws ObjectNotFoundException {
         final String mname = "findStatus";
        Trace.entering(_cname, mname);
        // Finds all the objects
        final Collection status = _infoStatusDAO.findAllStatusByCondition("Between 10 and 19 order by valueInfoStatus");

        Trace.exiting(_cname, mname, new Integer(status.size()));
        return status;
     }
    public Customer findCustomerByLogins(String login, String password) throws ObjectNotFoundException{
          return (Customer)_daoCustomer.selectByLogins(login, password);

      }

    // ======================================
    // = Private Methods =
    // ======================================
    

    /**
     * This method returns a unique identifer generated by the system.
     *
     * @return a unique identifer
     */
    public final String getUniqueId() {
        return _daoCustomer.getUniqueId();
    }

}
