/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.company;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.RemoveException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.company.EmployeRight;
import com.cdi.g3.server.domain.company.EmployeRightDAO;
import com.cdi.g3.server.service.AbstractService;
import java.util.Collection;

/**
 *
 * @author Izet
 */
public class EmployeRightService extends AbstractService {
    

      // ======================================
    // = Attributes =
    // ======================================
    private static final EmployeRightDAO _dao = new EmployeRightDAO();

    // ======================================
    // = Constructors =
    // ======================================
    public EmployeRightService(){
        
    }

    // ======================================
    // = Business methods =
    // ======================================
    public EmployeRight createEmployeRight( final EmployeRight employeRight ) throws CreateException, CheckException {
        final String mname = "createEmployeRight";
        Trace.entering( _cname, mname, employeRight );

        if ( employeRight == null )
            throw new CreateException( "EmployeRight object is null" );
        
        employeRight.checkData();
//         EmployeRight  employeRight1 = null ;
        try {
           _dao.findByPrimaryKey(employeRight.getId());
        } catch (ObjectNotFoundException ex) {
             //checkId( employeRight.getId() );
            checkId( employeRight.getId());
             // Creates the object
            _dao.insert( employeRight );
            return employeRight;
        }
        Trace.exiting( _cname, mname, employeRight );
        throw new CreateException( "EmployeRight object exist" );
        
    }
 public Collection FindAllEmployeRight()throws ObjectNotFoundException{
        return _dao.findAll();
    }
    
    
    public EmployeRight findEmployeRight( final String employeRightId ) throws FinderException, CheckException {
        final String mname = "findEmployeRight";
        Trace.entering( _cname, mname, employeRightId );

        checkId( employeRightId );
        // Finds the object
        final EmployeRight employeRight = (EmployeRight) _dao.findByPrimaryKey( employeRightId );
        Trace.exiting( _cname, mname, employeRight );
        return employeRight;
    }

    public void deleteEmployeRight( final String employeRightId ) throws RemoveException, CheckException {
        final String mname = "deleteEmployeRight";
        Trace.entering( _cname, mname, employeRightId );

        checkId( employeRightId );

        // Checks if the object exists
        try {
            _dao.findByPrimaryKey( employeRightId );
        } catch ( FinderException e ) {
            throw new RemoveException( "EmployeRight must exist to be deleted" );
        }

        // Deletes the object
        try {
            _dao.remove(employeRightId);
        } catch ( ObjectNotFoundException e ) {
            throw new RemoveException( "EmployeRight must exist to be deleted" );
        }
    }

    public void updateEmployeRight(EmployeRight employeRight  ) throws UpdateException, CheckException {
        final String mname = "updateEmployeRight";
        Trace.entering( _cname, mname, employeRight );

        if ( employeRight == null )
            throw new UpdateException( "EmployeRight object is null" );

        checkId( employeRight.getId() );

       final EmployeRight employeRightFinded;

        // Checks if the object exists
        try {
            employeRightFinded = (EmployeRight) _dao.findByPrimaryKey( employeRight.getId() );
        } catch ( FinderException e ) {
            throw new UpdateException( "EmployeRight must exist to be updated" );
        }
        
        employeRight.checkData();
        employeRight = setEmployeRight(employeRight, employeRightFinded );
        

        // Updates the object
        try {
            _dao.update( employeRightFinded );
        } catch ( ObjectNotFoundException e ) {
            throw new UpdateException( "EmployeRight must exist to be updated" );
        }
    }

    public Collection findEmployeRight() throws FinderException {
        final String mname = "findEmployeRight";
        Trace.entering( _cname, mname );

        // Finds all the objects
        final Collection employeRight = _dao.findAll();
        
        Trace.exiting( _cname, mname, new Integer( employeRight.size() ) );
        return employeRight;
    }

    // ======================================
    // = Private Methods =
    // ======================================
     private EmployeRight setEmployeRight(EmployeRight employeRight, EmployeRight employeRightFinded ){
         return null;
     }

    /**
     * This method returns a unique identifer generated by the system.
     * 
     * @return a unique identifer
     */
    public final String getUniqueId() {
        return _dao.getUniqueId();
    }

}