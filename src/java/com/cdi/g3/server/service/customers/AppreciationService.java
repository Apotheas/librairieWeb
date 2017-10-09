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
import com.cdi.g3.server.domain.company.Employe;
import com.cdi.g3.server.domain.company.EmployeDAO;
import com.cdi.g3.server.domain.customers.Appreciation;
import com.cdi.g3.server.domain.customers.AppreciationDAO;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.domain.orders.OrdersDAO;

import com.cdi.g3.server.service.AbstractService;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Izet
 */
public class AppreciationService extends AbstractService {
    
 
      // ======================================
    // = Attributes =
    // ======================================
    private static final AppreciationDAO _daoAppreciation = new AppreciationDAO();
    private static final EmployeDAO _daoEmploye = new EmployeDAO();
    

    // ======================================
    // = Constructors =
    // ======================================
    public AppreciationService(){
        
    }

    // ======================================
    // = Business methods =
    // ======================================
    public Appreciation createAppreciation( final Appreciation appreciation ) throws CreateException, CheckException {
        final String mname = "createAppreciation";
        Trace.entering( _cname, mname, appreciation );

        if ( appreciation == null )
            throw new CreateException( "Appreciation object is null" );
        
        appreciation.checkData();
//         Appreciation  appreciation1 = null ;
        try {
           _daoAppreciation.findByPrimaryKey(appreciation.getId());
        } catch (ObjectNotFoundException ex) {
             //checkId( appreciation.getId() );
            checkId( appreciation.getId());
             // Creates the object
            _daoAppreciation.insert( appreciation );
            return appreciation;
        }
        Trace.exiting( _cname, mname, appreciation );
        throw new CreateException( "Appreciation object exist" );
        
    }
     public Collection FindAppreciationByChamp(String column, String champ )throws ObjectNotFoundException{
        
        return _daoAppreciation.findAllByChamp(column, champ);
        
     
        
        
        
    }
      
    public Collection findWaitingAppreciate() throws ObjectNotFoundException{
        return _daoAppreciation.selectAllNonModerate();
    }

    public Appreciation findAppreciation( final String appreciationId ) throws FinderException, CheckException {
        final String mname = "findAppreciation";
        Trace.entering( _cname, mname, appreciationId );

        checkId( appreciationId );
        // Finds the object
        final Appreciation appreciation = (Appreciation) _daoAppreciation.findByPrimaryKey( appreciationId );
        Trace.exiting( _cname, mname, appreciation );
        return appreciation;
    }

    public void deleteAppreciation( final String appreciationId ) throws RemoveException, CheckException {
        final String mname = "deleteAppreciation";
        Trace.entering( _cname, mname, appreciationId );

        checkId( appreciationId );

        // Checks if the object exists
        try {
            _daoAppreciation.findByPrimaryKey( appreciationId );
        } catch ( FinderException e ) {
            throw new RemoveException( "Appreciation must exist to be deleted" );
        }

        // Deletes the object
        try {
            _daoAppreciation.remove(appreciationId);
        } catch ( ObjectNotFoundException e ) {
            throw new RemoveException( "Appreciation must exist to be deleted" );
        }
    }

    public void updateAppreciation(Appreciation appreciation  ) throws ObjectNotFoundException {
             
            _daoAppreciation.update( appreciation);
    }

    public Collection findAppreciation() throws FinderException {
        final String mname = "findAppreciation";
        Trace.entering( _cname, mname );

        // Finds all the objects
        final Collection appreciation = _daoAppreciation.findAll();
        
        Trace.exiting( _cname, mname, new Integer( appreciation.size() ) );
        return appreciation;
    }

    // ======================================
    // = Private Methods =
    // ======================================
     private Appreciation setAppreciation(Appreciation appreciation, Appreciation appreciationFinded ){
         return null;
     }

    /**
     * This method returns a unique identifer generated by the system.
     * 
     * @return a unique identifer
     */
    public final String getUniqueId() {
        return _daoAppreciation.getUniqueId();
    }

    

    
    public Collection FindAppreciationByEmployee(String column, String champ )throws ObjectNotFoundException{
       
      Collection listAppreciation = _daoAppreciation.findAllByChamp(column, champ);
      for (Iterator iterator = listAppreciation.iterator() ; iterator.hasNext();){
          Appreciation appreciation = (Appreciation)iterator.next();
          Employe employe = (Employe)  _daoEmploye.findByPrimaryKey(appreciation.getLoginEmployeAppreciate().getId());
          appreciation.setLoginEmployeAppreciate(employe);
      }
     
       
       return listAppreciation;
   }
    
    
    
}