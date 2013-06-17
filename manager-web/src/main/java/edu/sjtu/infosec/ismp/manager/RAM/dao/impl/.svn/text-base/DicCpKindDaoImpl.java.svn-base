package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicCpKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicCpKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 测评类型数据字典Dao实现类.
 * 


 */
public class DicCpKindDaoImpl extends HibernateDaoSupport implements DicCpKindDao{

    /**
     * 查询测评类型
     * 
     * @param cpKindId
     *            测评类型编号
     * @return 测评类型对象
     */
    public AsseKnowDicCpKind find(String cpKindId) {
        
        return (AsseKnowDicCpKind) getHibernateTemplate()
        .find("from AsseKnowDicCpKind dicCpKind where dicCpKind.cpKindId = ?", cpKindId);
    }

    /**
     * 查询测评类型记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 测评类型记录数
     */
    public int getCount(Map paramMap) {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicCpKind.class);
        criteria.setProjection(Projections.rowCount())
                .setMaxResults(1)
                .uniqueResult();
        
        if(paramMap!=null) {
            if(paramMap.get("cpKindName")!=null) {
              criteria.add(Expression.like("cpKindName", "%"+((String) paramMap.get("cpKindName")).trim()+"%"));
          }
        }
        return ((Integer) criteria.list().get(0)).intValue();
    }

    /**
     * 查询测评类型
     * @param paramMap
     *            查询条件
     * @return 测评类型列表
     */
    public List listDicCpKind(Map paramMap) {
        
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicCpKind.class)
                            .addOrder(Order.asc("id"));
        if(paramMap!=null) {
            if(paramMap.get("cpKindName")!=null) {
              criteria.add(Expression.like("cpKindName", "%"+((String) paramMap.get("cpKindName")).trim()+"%"));
         }
        }
        return criteria.list();
    }

    /**
     * 查询测评类型分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicCpKindPage(Page page, Map paramMap) {
        
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicCpKind.class)
                            .addOrder(Order.asc("id"))
                            .setFirstResult(page.getBeginIndex())
                            .setMaxResults(page.getEveryPage());
        
        if(paramMap!=null) {
            if(paramMap.get("cpKindName")!=null) {
              criteria.add(Expression.like("cpKindName", "%"+((String) paramMap.get("cpKindName")).trim()+"%"));
          }
        }
        
        return criteria.list();
    }

    /**
     * 删除测评类型
     * 
     * @param dicCpKind
     *            测评类型
     */
    public void remove(AsseKnowDicCpKind dicCpKind) {
        
        getHibernateTemplate().delete(dicCpKind);
    }

    /**
     * 保存/更新测评类型
     * 
     * @param dicCpKind
     *            测评状态
     */
    public void saveOrUpdate(AsseKnowDicCpKind dicCpKind) {
        
        getHibernateTemplate().saveOrUpdate(dicCpKind);
    }

}
