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
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.catalog.Editor;
import com.cdi.g3.server.domain.company.Employe;
import com.cdi.g3.server.domain.company.EmployeDAO;
import com.cdi.g3.server.domain.company.EmployeRight;
import com.cdi.g3.server.domain.company.EmployeRightDAO;
import com.cdi.g3.server.domain.orders.InfoStatus;
import com.cdi.g3.server.domain.orders.InfoStatusDAO;
import com.cdi.g3.server.domain.other.CodeTVA;
import com.cdi.g3.server.service.AbstractService;
import java.util.Collection;
import java.util.Iterator;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Izet
 */
public class EmployeService extends AbstractService {
    
    
    // ======================================
    // = Attributes =
    // ======================================
    private static final EmployeDAO _daoEmploye = new EmployeDAO();
    private static final EmployeRightDAO _daoEmployeRight = new EmployeRightDAO();
    private static final InfoStatusDAO _infoStatusDAO = new InfoStatusDAO();
  
    // ======================================
    // = Constructors =
    // ======================================
    public EmployeService() {

    }

    // ======================================
    // = Business methods =
    // ======================================
    public Employe createEmploye(final Employe employe) throws CreateException, CheckException {
        final String mname = "createEmploye";
        Trace.entering(_cname, mname, employe);

        if (employe == null) {
            throw new CreateException("Employe object is null");
        }

      
        employe.checkData();
        checkId(employe.getId());
        // Creates the object
        _daoEmploye.insert(employe);

        Trace.exiting(_cname, mname, employe);
        return employe;
    }

    public Employe findEmploye(final String employeId) throws FinderException, CheckException {
        final String mname = "findEmploye";
        Trace.entering(_cname, mname, employeId);

        checkId(employeId);
        // Finds the object
        final Employe employe = (Employe) _daoEmploye.findByPrimaryKey(employeId);
        Trace.exiting(_cname, mname, employe);
        return employe;
    }

//    public Employe findStatusByEmploye(final String statusEmploye) throws FinderException, CheckException {
//        final String mname = "findStatusByEmploye";
//        Trace.entering(_cname, mname, statusEmploye);
//
//        checkId(statusEmploye);
//        // Finds the object
//        final Employe employe = (Employe) _daoEmploye.findByChamp(InfoStatus,statusEmploye);
//        Trace.exiting(_cname, mname, employe);
//        return statusEmploye;
//    
//    
//    }
    
    
    
    public void deleteEmploye(final String employeId) throws RemoveException, CheckException {
        final String mname = "deleteEmploye";
        Trace.entering(_cname, mname, employeId);

        checkId(employeId);

        // Checks if the object exists
        try {
            _daoEmploye.findByPrimaryKey(employeId);
        } catch (FinderException e) {
            throw new RemoveException("Employe must exist to be deleted");
        }

        // Deletes the object
        try {
            _daoEmploye.remove(employeId);
        } catch (ObjectNotFoundException e) {
            throw new RemoveException("Employe must exist to be deleted");
        }
    }

    public void updateEmploye(Employe employe) throws UpdateException, CheckException {
        final String mname = "updateEmploye";
        Trace.entering(_cname, mname, employe);

        if (employe == null) {
            throw new UpdateException("Employe object is null");
        }
        
        
        checkId(employe.getId());
        final Employe employeFinded;
        // Checks if the object exists
        try {
            employeFinded = (Employe) _daoEmploye.findByPrimaryKey(employe.getId());
        } catch (FinderException e) {
            throw new UpdateException("Employe must exist to be updated");
        }
        employe.checkData();        
        employe = setEmploye(employe, employeFinded);
        // Updates the object
        try {
            _daoEmploye.update(employe);
        } catch (ObjectNotFoundException e) {
            throw new UpdateException("Employe must exist to be updated");
        }
    }
    public Collection findAllEmploye() throws FinderException {
        final String mname = "findEmploye";
        Trace.entering(_cname, mname);

        // Finds all the objects
        final Collection employe = _daoEmploye.findAll();

        Trace.exiting(_cname, mname, new Integer(employe.size()));
        return employe;
    }
     public Collection FindAllEmploye()throws ObjectNotFoundException{
        return _daoEmploye.findAll();
    }
  public Collection findStatusEmploye() throws ObjectNotFoundException {
         final String mname = "findStatus";
        Trace.entering(_cname, mname);
        // Finds all the objects
        final Collection status = _infoStatusDAO.findAllStatusByCondition("Between 20 and 29");

        Trace.exiting(_cname, mname, new Integer(status.size()));
        return status;
     }
   

    
    
    
    // ======================================
    // = Private Methods =
    // ======================================
    private Employe setEmploye(Employe employe, Employe employeFinded) {
        
       
        employeFinded.setEmployeRight(employe.getEmployeRight());
        employeFinded.setFirstNameEmploye(employe.getFirstNameEmploye());
        employeFinded.setLastNameEmploye(employe.getLastNameEmploye());
        employeFinded.setEmailEmploye(employe.getEmailEmploye());
        employeFinded.setPasswordEmploye(employe.getPasswordEmploye());
        employeFinded.setInfoStatus(employe.getInfoStatus());
       
        return employeFinded;
    }
   
    /**
     * This method returns a unique identifer generated by the system.
     *
     * @return a unique identifer
     */
    public final String getUniqueId() {
        return _daoEmploye.getUniqueId();
    }
      public Collection FindEmployeByRight(String column, String champ) throws ObjectNotFoundException {
        Collection listEmploye = _daoEmploye.findAllByChamp(column, champ);
       
        return listEmploye;
    }
      
       public Collection FindEmployeByStatus(String column, String champ) throws ObjectNotFoundException {
       Collection listEmploye = _daoEmploye.findAllByStatus(column, champ);
        
        return listEmploye;
    }
       public Employe findEmployeByLogins(String login, String password) throws ObjectNotFoundException{
           return (Employe)_daoEmploye.selectByLogins(login, password);
       }
    }

