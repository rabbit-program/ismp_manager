package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicAsseStatDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseStat;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 测评状态数据字典Dao实现类.
 * 


 */
public class DicAsseStatDaoImpl extends HibernateDaoSupport implements DicAsseStatDao {

    /**
     * 查询测评状态
     * 
     * @param asseStatId
     *            测评状态编号
     * @return 测评状态对象
     */
    public AsseKnowDicAsseStat find(String asseStatId) {
        
        return (AsseKnowDicAsseStat) getHibernateTemplate()
        .find("from AsseKnowDicAsseStat dicAsseStat where dicAsseStat.asseStatId = ?", asseStatId);
    }

    /**
     * 查询测评状态记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 测评状态记录数
     */
    public int getCount(Map paramMap) {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicAsseStat.class);
        criteria.setProjection(Projections.rowCount())
                .setMaxResults(1)
                .uniqueResult();
        
        if(paramMap!=null) {
            if(paramMap.get("asseStatName")!=null) {
              criteria.add(Expression.like("asseStatName", "%"+((String) paramMap.get("asseStatName")).trim()+"%"));
        
            }
        }
        return ((Integer) criteria.list().get(0)).intValue();
    }

    /**
     * 查询测评状态
     * @param paramMap
     *            查询条件
     * @return 测评状态列表
     */
    public List listDicAsseStat(Map paramMap) {
        
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicAsseStat.class)
                            .addOrder(Order.asc("id"));
        if(paramMap!=null) {
            if(paramMap.get("asseStatName")!=null) {
              criteria.add(Expression.like("asseStatName", "%"+((String) paramMap.get("assetKindName")).trim()+"%"));
            }
          }
        return criteria.list();
    }

    /**
     * 查询测评状态分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicAsseStatPage(Page page, Map paramMap) {
       
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicAsseStat.class)
                            .addOrder(Order.asc("id"))
                            .setFirstResult(page.getBeginIndex())
                            .setMaxResults(page.getEveryPage());
        
        if(paramMap!=null) {
            if(paramMap.get("asseStatName")!=null) {
              criteria.add(Expression.like("asseStatName", "%"+((String) paramMap.get("assetKindName")).trim()+"%"));
          }
        }
        return criteria.list();
    }

    /**
     * 删除测评状态
     * 
     * @param dicAsseStat
     *            测评状态
     */
    public void remove(AsseKnowDicAsseStat dicAsseStat) {
       
        getHibernateTemplate().delete(dicAsseStat);
    }

    /**
     * 保存/更新测评状态
     * 
     * @param dicAsseStat
     *            测评状态
     */
    public void saveOrUpdate(AsseKnowDicAsseStat dicAsseStat) {
       
        getHibernateTemplate().saveOrUpdate(dicAsseStat);
    }

}
