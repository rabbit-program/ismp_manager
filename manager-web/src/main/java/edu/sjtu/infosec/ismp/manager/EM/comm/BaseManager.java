package edu.sjtu.infosec.ismp.manager.EM.comm;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * BaseManager.
 *
 */
public class BaseManager implements Manager {

    /**
     * log
     */
    protected final Log log = LogFactory.getLog(getClass());
    
    /**
     * dao
     * Spring Ioc
     */
    protected Dao dao = null;

    /**
     * @see edu.sjtu.infosec.ismp.manager.comm.assessment#setDao(com.wisdom.mss.dao.Dao)
     * @param ddao
     * Dao
     */
    public void setDao(Dao ddao) {
        this.dao = ddao;
    }

    /**
     * @see edu.sjtu.infosec.ismp.manager.comm.assessment#getObject(java.lang.Class, java.io.Serializable)
     * @param clazz
     * Class
     * @param id
     * OID
     * @return Object
     */
    public Object getObject(Class clazz, Serializable id) {
        return dao.getObject(clazz, id);
    }

    /**
     * @see edu.sjtu.infosec.ismp.manager.comm.assessment#getObjects(java.lang.Class)
     * @param clazz
     * Class
     * @return List
     */
    public List getObjects(Class clazz) {
        return dao.getObjects(clazz);
    }

    /**
     * @see edu.sjtu.infosec.ismp.manager.comm.assessment#removeObject(java.lang.Class, java.io.Serializable)
     * @param clazz
     * Class
     * @param id
     * OID
     */
    public void removeObject(Class clazz, Serializable id) {
        dao.removeObject(clazz, id);
    }

    /**
     * @see edu.sjtu.infosec.ismp.manager.comm.assessment#saveObject(java.lang.Object)
     * @param o
     * Object
     */
    public void saveObject(Object o) {
        dao.saveObject(o);
    }
}
