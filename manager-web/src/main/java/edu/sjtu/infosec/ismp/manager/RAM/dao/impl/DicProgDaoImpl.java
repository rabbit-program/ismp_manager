package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicProgDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicProg;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 评估流程数据字典Dao实现类.
 * 


 */
public class DicProgDaoImpl extends HibernateDaoSupport implements DicProgDao {

    /**
     * 查询评估流程
     * 
     * @param progId
     *            评估流程编号
     * @return 评估流程对象
     */
    public AsseKnowDicProg find(String progId) {
        
        return (AsseKnowDicProg) getHibernateTemplate()
        .find("from AsseKnowDicProg dicProg where dicProg.progId = ?", progId);
    }

    /**
     * 查询评估流程记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 评估流程记录数
     */
    public int getCount(Map paramMap) {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicProg.class);
        criteria.setProjection(Projections.rowCount())
                .setMaxResults(1)
                .uniqueResult();
        
        if(paramMap!=null) {
            if(paramMap.get("progName")!=null) {
              criteria.add(Expression.like("progName", "%"+((String) paramMap.get("progName")).trim()+"%"));
         }
        }
        return ((Integer) criteria.list().get(0)).intValue();
    }

    /**
     * 查询评估流程
     * @param paramMap
     *            查询条件
     * @return 评估流程列表
     */
    public List listDicProg(Map paramMap) {
        
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicProg.class)
                            .addOrder(Order.asc("id"));
        if(paramMap!=null) {
            if(paramMap.get("progName")!=null) {
              criteria.add(Expression.like("progName", "%"+((String) paramMap.get("progName")).trim()+"%"));
          }
        }
        return criteria.list();
    }

    /**
     * 查询评估流程分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicProgPage(Page page, Map paramMap) {
        
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicProg.class)
                            .addOrder(Order.asc("id"))
                            .setFirstResult(page.getBeginIndex())
                            .setMaxResults(page.getEveryPage());
        
        if(paramMap!=null) {
            if(paramMap.get("progName")!=null) {
              criteria.add(Expression.like("progName", "%"+((String) paramMap.get("progName")).trim()+"%"));
          }
        }
        return criteria.list();
    }

    /**
     * 删除评估流程
     * 
     * @param dicProg
     *            评估流程
     */
    public void remove(AsseKnowDicProg dicProg) {
        
        getHibernateTemplate().delete(dicProg);
    }

    /**
     * 保存/更新评估流程
     * 
     * @param dicProg
     *            评估流程
     */
    public void saveOrUpdate(AsseKnowDicProg dicProg) {
        
        getHibernateTemplate().saveOrUpdate(dicProg);
    }

}
