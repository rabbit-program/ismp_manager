package org.infosec.ismp.situation.common;

import java.io.Serializable;
import java.util.List;

/**
 * BaseDao.
 *
 */
public interface BaseDao {

    /**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     * @param clazz 
     * the type of objects (a.k.a. while table) to get data from
     * @return List of populated objects
     */
     List getObjects(Class clazz);

    /**
     * Generic method to get an object based on class and identifier. An 
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param clazz model class to lookup
     * @param id the identifier (primary key) of the class
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
     Object getObject(Class clazz, Serializable id);

    /**
     * Generic method to save an object - handles both update and insert.
     * @param o the object to save
     */
     void saveObject(Object o);

    /**
     * Generic method to delete an object based on class and id
     * @param clazz model class to lookup
     * @param id the identifier (primary key) of the class
     */
     void removeObject(Class clazz, Serializable id);
}
