package org.infosec.ismp.situation.common;

import java.io.Serializable;
import java.util.List;

/**
 * Service.
 *
 */
public interface Service {
	
    /**
     * Expose the setDao method for testing purposes
     * @param dao 
     * Dao
     * @param dao
     */
     void setDao(BaseDao dao);

    /**
     * Generic method used to get a all objects of a particular type. 
     * @param clazz 
     * the type of objects 
     * @return List of populated objects
     */
     List getObjects(Class clazz);

    /**
     * Generic method to get an object based on class and identifier. 
     * 
     * @param clazz model class to lookup
     * @param id the identifier (primary key) of the class
     * @return a populated object 
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
     Object getObject(Class clazz, Serializable id);

    /**
     * Generic method to save an object.
     * @param o the object to save
     */
     void saveObject(Object o);

    /**
     * Generic method to delete an object based on class and id
     * @param clazz model class to lookup
     * @param id the identifier of the class
     */
     void removeObject(Class clazz, Serializable id);
}
