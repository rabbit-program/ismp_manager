package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicSecuLeveDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicSecuLeve;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 安全级别数据字典Dao实现类.
 */
public class DicSecuLeveDaoImpl extends HibernateDaoSupport implements DicSecuLeveDao {

    /**
     * 查询安全级别
     * 
     * @param secuLeveId
     *            安全级别编号
     * @return 安全级别对象
     */
    public AsseKnowDicSecuLeve find(String secuLeveId) {
        
        return (AsseKnowDicSecuLeve) getHibernateTemplate()
        .find("from AsseKnowDicSecuLeve dicSecuLeve where dicSecuLeve.secuLeveId = ?", secuLeveId);
    }

    /**
     * 查询安全级别记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 安全级别记录数
     */
    public int getCount(Map paramMap) {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicSecuLeve.class);
        criteria.setProjection(Projections.rowCount())
                .setMaxResults(1)
                .uniqueResult();
        
        if(paramMap!=null) {
            if(paramMap.get("secuLeveName")!=null) {
              criteria.add(Expression.like("secuLeveName", "%"+((String) paramMap.get("secuLeveName")).trim()+"%"));
         }
        }
        return ((Integer) criteria.list().get(0)).intValue();
    }

    /**
     * 查询安全级别
     * @param paramMap
     *            查询条件
     * @return 安全级别列表
     */
    public List listDicSecuLeve(Map paramMap) {
        
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicSecuLeve.class)
                            .addOrder(Order.asc("id"));
        if(paramMap!=null) {
            if(paramMap.get("secuLeveName")!=null) {
              criteria.add(Expression.like("secuLeveName", "%"+((String) paramMap.get("secuLeveName")).trim()+"%"));
         }
        }
        return criteria.list();
    }

    /**
     * 查询安全级别分页记录..
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicSecuLevePage(Page page, Map paramMap) {
        
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicSecuLeve.class)
                            .addOrder(Order.asc("id"))
                            .setFirstResult(page.getBeginIndex())
                            .setMaxResults(page.getEveryPage());
        
        if(paramMap!=null) {
            if(paramMap.get("secuLeveName")!=null) {
              criteria.add(Expression.like("secuLeveName", "%"+((String) paramMap.get("secuLeveName")).trim()+"%"));
         }
        }
        return criteria.list();
    }

    /**
     * 删除安全级别
     * 
     * @param dicSecuLeve
     *            安全级别
     */
    public void remove(AsseKnowDicSecuLeve dicSecuLeve) {
        
        getHibernateTemplate().delete(dicSecuLeve);
    }

    /**
     * 保存/更新安全级别
     */
    public void saveOrUpdate(AsseKnowDicSecuLeve dicSecuLeve) {
        
        getHibernateTemplate().saveOrUpdate(dicSecuLeve);
    }

	public List findAll() {
		return getHibernateTemplate().find("from AsseKnowDicSecuLeve");
	}

}
