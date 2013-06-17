package org.infosec.ismp.situation.common;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Projections;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
* Dao实现类基类.
*
* @version 1.0 11 May 2009
* @author zhou chenye
*/
public class BaseDaoHibernate extends HibernateDaoSupport implements BaseDao{
    
    /**
     * 日志
     */
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * @see com.BaseDao.mss.dao.Dao#saveObject(java.lang.Object)
     * @param o
     * Object
     */
    public void saveObject(Object o) {
        getHibernateTemplate().saveOrUpdate(o);
    }

    /**
     * @see com.BaseDao.mss.dao.Dao#getObject(java.lang.Class, java.io.Serializable)
     * @param clazz
     * class
     * @param id
     * OID
     * @return Object
     */
    public Object getObject(Class clazz, Serializable id) {
        Object o = getHibernateTemplate().get(clazz, id);

        if (o == null) {
            throw new ObjectRetrievalFailureException(clazz, id);
        }

        return o;
    }

    /**
     * @see com.BaseDao.mss.dao.Dao#getObjects(java.lang.Class)
     * @param clazz
     * class
     * @return List
     */
    public List getObjects(Class clazz) {
        return getHibernateTemplate().loadAll(clazz);        
    }

    /**
     * @see com.BaseDao.mss.dao.Dao#removeObject(java.lang.Class, java.io.Serializable)
     * @param clazz
     * class
     * @param id
     * OID
     */
    public void removeObject(Class clazz, Serializable id) {
        getHibernateTemplate().delete(getObject(clazz, id));
    }
  
    
    /**
     * 根据条件统计结果
     * @param criteria  
     * 查询条件
     * @return int
     */
    public int count(Criteria criteria) {
       try {
            int total = ((Integer) criteria.setProjection(
                    Projections.rowCount()).uniqueResult()).intValue();
            criteria.setProjection(null);
            return total;
       } catch (HibernateException e) {
            throw new RuntimeException(e);
       }
    }
}
