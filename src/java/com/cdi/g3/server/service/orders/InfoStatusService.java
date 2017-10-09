/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.orders;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.RemoveException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.orders.InfoStatus;
import com.cdi.g3.server.domain.orders.InfoStatusDAO;
import com.cdi.g3.server.service.AbstractService;
import java.util.Collection;

/**
 *
 * @author Izet
 */
public class InfoStatusService extends AbstractService {
    
    
    // ======================================
    // = Attributes =
    // ======================================
    private static final InfoStatusDAO _daoInfoStatus = new InfoStatusDAO();

    // ======================================
    // = Constructors =
    // ======================================
    public InfoStatusService() {

    }

    // ======================================
    // = Business methods =
    // ======================================
    public InfoStatus createInfoStatus(final InfoStatus infoStatus) throws CreateException, CheckException {
        final String mname = "createInfoStatus";
        Trace.entering(_cname, mname, infoStatus);

        if (infoStatus == null) {
            throw new CreateException("InfoStatus object is null");
        }

      
        infoStatus.checkData();
        checkId(infoStatus.getId());
        // Creates the object
        _daoInfoStatus.insert(infoStatus);

        Trace.exiting(_cname, mname, infoStatus);
        return infoStatus;
    }
  public Collection FindAllInfoStatus()throws ObjectNotFoundException{
        return _daoInfoStatus.findAll();
    }
  
    public InfoStatus findInfoStatus(final String infoStatusId) throws FinderException, CheckException {
        final String mname = "findInfoStatus";
        Trace.entering(_cname, mname, infoStatusId);

        checkId(infoStatusId);
        // Finds the object
        final InfoStatus infoStatus = (InfoStatus) _daoInfoStatus.findByPrimaryKey(infoStatusId);
        Trace.exiting(_cname, mname, infoStatus);
        return infoStatus;
    }

//    public InfoStatus findStatusByInfoStatus(final String statusInfoStatus) throws FinderException, CheckException {
//        final String mname = "findStatusByInfoStatus";
//        Trace.entering(_cname, mname, statusInfoStatus);
//
//        checkId(statusInfoStatus);
//        // Finds the object
//        final InfoStatus infoStatus = (InfoStatus) _daoInfoStatus.findByChamp(InfoStatus,statusInfoStatus);
//        Trace.exiting(_cname, mname, infoStatus);
//        return statusInfoStatus;
//    
//    
//    }
    
     public Collection findStatusEmploye() throws ObjectNotFoundException {
         final String mname = "findStatus";
        Trace.entering(_cname, mname);
        // Finds all the objects
        final Collection status = _daoInfoStatus.findAllStatusByCondition("Between 20 and 29");

        Trace.exiting(_cname, mname, new Integer(status.size()));
        return status;
     }
    
    public void deleteInfoStatus(final String infoStatusId) throws RemoveException, CheckException {
        final String mname = "deleteInfoStatus";
        Trace.entering(_cname, mname, infoStatusId);

        checkId(infoStatusId);

        // Checks if the object exists
        try {
            _daoInfoStatus.findByPrimaryKey(infoStatusId);
        } catch (FinderException e) {
            throw new RemoveException("InfoStatus must exist to be deleted");
        }

        // Deletes the object
        try {
            _daoInfoStatus.remove(infoStatusId);
        } catch (ObjectNotFoundException e) {
            throw new RemoveException("InfoStatus must exist to be deleted");
        }
    }

    public void updateInfoStatus(InfoStatus infoStatus) throws UpdateException, CheckException {
        final String mname = "updateInfoStatus";
        Trace.entering(_cname, mname, infoStatus);

        if (infoStatus == null) {
            throw new UpdateException("InfoStatus object is null");
        }
        
        
        checkId(infoStatus.getId());
        final InfoStatus infoStatusFinded;
        // Checks if the object exists
        try {
            infoStatusFinded = (InfoStatus) _daoInfoStatus.findByPrimaryKey(infoStatus.getId());
        } catch (FinderException e) {
            throw new UpdateException("InfoStatus must exist to be updated");
        }
        infoStatus.checkData();        
        infoStatus = setInfoStatus(infoStatus, infoStatusFinded);
        // Updates the object
        try {
            _daoInfoStatus.update(infoStatus);
        } catch (ObjectNotFoundException e) {
            throw new UpdateException("InfoStatus must exist to be updated");
        }
    }
    public Collection findInfoStatus() throws ObjectNotFoundException{
        final String mname = "findInfoStatus";
        Trace.entering(_cname, mname);

        // Finds all the objects
        final Collection infoStatus = _daoInfoStatus.findAll();

        Trace.exiting(_cname, mname, new Integer(infoStatus.size()));
        return infoStatus;
    }
   
  
  
    
    
    
    // ======================================
    // = Private Methods =
    // ======================================
    private InfoStatus setInfoStatus(InfoStatus infoStatus, InfoStatus infoStatusFinded) {
        
       
        infoStatusFinded.setId(infoStatus.getId());
        infoStatusFinded.setValueInfoStatus(infoStatus.getValueInfoStatus());
       
       
        return infoStatusFinded;
    }

    /**
     * This method returns a unique identifer generated by the system.
     *
     * @return a unique identifer
     */
    public final String getUniqueId() {
        return _daoInfoStatus.getUniqueId();
    }

}