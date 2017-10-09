/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.catalog;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.RemoveException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.catalog.BookDAO;
import com.cdi.g3.server.domain.catalog.OccasionDAO;
import com.cdi.g3.server.domain.catalog.Occasion;
import com.cdi.g3.server.service.AbstractService;
import java.util.Collection;
import java.util.Iterator;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Izet
 */
public class OccasionService extends AbstractService {
    
    
    // ======================================
    // = Attributes =
    // ======================================
    private static final OccasionDAO _daoOccasion = new OccasionDAO();
    private static final   BookDAO  _bookDao = new BookDAO();
  
    // ======================================
    // = Constructors =
    // ======================================
    public OccasionService() {

    }

    // ======================================
    // = Business methods =
    // ======================================
    public Occasion createOccasion(final Occasion occasion) throws CreateException, CheckException {
        final String mname = "createOccasion";
        Trace.entering(_cname, mname, occasion);

        if (occasion == null) {
            throw new CreateException("Occasion object is null");
        }

      
        occasion.checkData();
        checkId(occasion.getId());
        // Creates the object
        _daoOccasion.insert(occasion);

        Trace.exiting(_cname, mname, occasion);
        return occasion;
    }

    public Occasion findOccasion(final String occasionId) throws FinderException, CheckException {
        final String mname = "findOccasion";
        Trace.entering(_cname, mname, occasionId);

        checkId(occasionId);
        // Finds the object
        final Occasion occasion = (Occasion) _daoOccasion.findByPrimaryKey(occasionId);
        Trace.exiting(_cname, mname, occasion);
        return occasion;
    }

//    public Occasion findStatusByOccasion(final String statusOccasion) throws FinderException, CheckException {
//        final String mname = "findStatusByOccasion";
//        Trace.entering(_cname, mname, statusOccasion);
//
//        checkId(statusOccasion);
//        // Finds the object
//        final Occasion occasion = (Occasion) _daoOccasion.findByChamp(InfoStatus,statusOccasion);
//        Trace.exiting(_cname, mname, occasion);
//        return statusOccasion;
//    
//    
//    }
    
    
     public Collection FindBooksByChamp(String column, String champ) throws ObjectNotFoundException {
        Collection listBook = _bookDao.findAllByChamp(column, champ);
        
        return listBook;
    }
    public void deleteOccasion(final String occasionId) throws RemoveException, CheckException {
        final String mname = "deleteOccasion";
        Trace.entering(_cname, mname, occasionId);

        checkId(occasionId);

        // Checks if the object exists
        try {
            _daoOccasion.findByPrimaryKey(occasionId);
        } catch (FinderException e) {
            throw new RemoveException("Occasion must exist to be deleted");
        }

        // Deletes the object
        try {
            _daoOccasion.remove(occasionId);
        } catch (ObjectNotFoundException e) {
            throw new RemoveException("Occasion must exist to be deleted");
        }
    }

    public void updateOccasion(Occasion occasion) throws UpdateException, CheckException {
        final String mname = "updateOccasion";
        Trace.entering(_cname, mname, occasion);

        if (occasion == null) {
            throw new UpdateException("Occasion object is null");
        }
        
        
        checkId(occasion.getId());
        final Occasion occasionFinded;
        // Checks if the object exists
        try {
            occasionFinded = (Occasion) _daoOccasion.findByPrimaryKey(occasion.getId());
        } catch (FinderException e) {
            throw new UpdateException("Occasion must exist to be updated");
        }
        occasion.checkData();        
        occasion = setOccasion(occasion, occasionFinded);
        // Updates the object
        try {
            _daoOccasion.update(occasion);
        } catch (ObjectNotFoundException e) {
            throw new UpdateException("Occasion must exist to be updated");
        }
    }
    public Collection findAllOccasion() throws FinderException {
        final String mname = "findOccasion";
        Trace.entering(_cname, mname);

        // Finds all the objects
        final Collection occasion = _daoOccasion.findAll();

        Trace.exiting(_cname, mname, new Integer(occasion.size()));
        return occasion;
    }
     public Collection FindAllOccasion()throws ObjectNotFoundException{
        return _daoOccasion.findAll();
    }
 
   

    
    
    
    // ======================================
    // = Private Methods =
    // ======================================
    private Occasion setOccasion(Occasion occasion, Occasion occasionFinded) {
        
       
        occasionFinded.setId(occasion.getId());
        occasionFinded.setDateDebutOccasion(occasion.getDateDebutOccasion());
        occasionFinded.setDateFinOccasion(occasion.getDateFinOccasion());
        occasionFinded.setDiscountOccasion(occasion.getDiscountOccasion());
        
       
        return occasionFinded;
    }
   
    /**
     * This method returns a unique identifer generated by the system.
     *
     * @return a unique identifer
     */
    public final String getUniqueId() {
        return _daoOccasion.getUniqueId();
    }
   
    }

