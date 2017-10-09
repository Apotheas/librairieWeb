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
import com.cdi.g3.server.domain.company.InfoCompany;
import com.cdi.g3.server.domain.company.InfoCompanyDAO;
import com.cdi.g3.server.service.AbstractService;
import java.util.Collection;

/**
 *
 * @author Izet
 */
public class InfoCompanyService extends AbstractService {
    
 
      // ======================================
    // = Attributes =
    // ======================================
    private static final InfoCompanyDAO _dao = new InfoCompanyDAO();

    // ======================================
    // = Constructors =
    // ======================================
    public InfoCompanyService(){
        
    }

    // ======================================
    // = Business methods =
    // ======================================
    public InfoCompany createInfoCompany( final InfoCompany infoCompany ) throws CreateException, CheckException {
        final String mname = "createInfoCompany";
        Trace.entering( _cname, mname, infoCompany );

        if ( infoCompany == null )
            throw new CreateException( "InfoCompany object is null" );
        
        infoCompany.checkData();
//         InfoCompany  infoCompany1 = null ;
        try {
           _dao.findByPrimaryKey(infoCompany.getId());
        } catch (ObjectNotFoundException ex) {
             //checkId( infoCompany.getId() );
            checkId( infoCompany.getId());
             // Creates the object
            _dao.insert( infoCompany );
            return infoCompany;
        }
        Trace.exiting( _cname, mname, infoCompany );
        throw new CreateException( "InfoCompany object exist" );
        
    }

    public InfoCompany findInfoCompany( final String infoCompanyId ) throws FinderException, CheckException {
        final String mname = "findInfoCompany";
        Trace.entering( _cname, mname, infoCompanyId );

        checkId( infoCompanyId );
        // Finds the object
        final InfoCompany infoCompany = (InfoCompany) _dao.findByPrimaryKey( infoCompanyId );
        Trace.exiting( _cname, mname, infoCompany );
        return infoCompany;
    }

    public void deleteInfoCompany( final String infoCompanyId ) throws RemoveException, CheckException {
        final String mname = "deleteInfoCompany";
        Trace.entering( _cname, mname, infoCompanyId );

        checkId( infoCompanyId );

        // Checks if the object exists
        try {
            _dao.findByPrimaryKey( infoCompanyId );
        } catch ( FinderException e ) {
            throw new RemoveException( "InfoCompany must exist to be deleted" );
        }

        // Deletes the object
        try {
            _dao.remove(infoCompanyId);
        } catch ( ObjectNotFoundException e ) {
            throw new RemoveException( "InfoCompany must exist to be deleted" );
        }
    }

    public void updateInfoCompany(InfoCompany infoCompany  ) throws UpdateException, CheckException {
        final String mname = "updateInfoCompany";
        Trace.entering( _cname, mname, infoCompany );

        if ( infoCompany == null )
            throw new UpdateException( "InfoCompany object is null" );

        checkId( infoCompany.getId() );

       final InfoCompany infoCompanyFinded;

        // Checks if the object exists
        try {
            infoCompanyFinded = (InfoCompany) _dao.findByPrimaryKey( infoCompany.getId() );
        } catch ( FinderException e ) {
            throw new UpdateException( "InfoCompany must exist to be updated" );
        }
        
        infoCompany.checkData();
        infoCompany = setInfoCompany(infoCompany, infoCompanyFinded );
        

        // Updates the object
        try {
            _dao.update( infoCompanyFinded );
        } catch ( ObjectNotFoundException e ) {
            throw new UpdateException( "InfoCompany must exist to be updated" );
        }
    }

    public Collection findInfoCompany() throws FinderException {
        final String mname = "findInfoCompany";
        Trace.entering( _cname, mname );

        // Finds all the objects
        final Collection infoCompany = _dao.findAll();
        
        Trace.exiting( _cname, mname, new Integer( infoCompany.size() ) );
        return infoCompany;
    }

    // ======================================
    // = Private Methods =
    // ======================================
     private InfoCompany setInfoCompany(InfoCompany infoCompany, InfoCompany infoCompanyFinded ){
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