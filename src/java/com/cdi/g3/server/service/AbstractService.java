package com.cdi.g3.server.service;

import com.cdi.g3.common.exception.CheckException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * A service is a class that follows the Facade Design Pattern. It gives a set of services
 * Every service class should extend this class.
 */
public abstract class AbstractService {

    // ======================================
    // =             Attributes             =
    // ======================================

    // Used for logging
    protected final transient String _cname = this.getClass().getName();

    // ======================================
    // =            Constructors            =
    // ======================================
    protected AbstractService()  {
    }

    protected void checkId(final String id) throws CheckException {
    	if ( id == null || id.trim().equals("") )
    		throw new CheckException("Id should not be null or empty");    	
    }
}
