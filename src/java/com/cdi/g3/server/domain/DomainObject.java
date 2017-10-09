
package com.cdi.g3.server.domain;


/**
 * Every domain object should extend this abstract class.
 */
public abstract class DomainObject {

    // ======================================
    // =             Attributes             =
    // ======================================

    // Every domain object has a unique identifier.
	public abstract String getId();
	public abstract void setId(String id); 

}
