package org.infosec.ismp.eventd;

import org.springframework.dao.DataAccessException;

public interface EventdServiceManager {
	/**
	 * Lookup the service ID for a specific service by name.  
	 * 
	 * @param name service name to lookup
	 * 
	 * @return service ID for the given service name or -1 if not found
	 * 
	 * @exception DataAccessException if there is an error accessing the database
	 */
	public abstract int getServiceId(String serviceName)
			throws DataAccessException;

	/**
	 * Synchronize the in-memory cache with the service table in the database.
	 */
	public abstract void dataSourceSync();
}