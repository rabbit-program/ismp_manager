package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicQuesKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicQuesKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 问题类型数据字典Dao实现类.
 * 


 */
public class DicQuesKindDaoImpl extends HibernateDaoSupport implements DicQuesKindDao {

    /**
     * 查询问题类型
     * 
     * @param quesKindId
     *            问题类型编号
     * @return 问题类型对象
     **/
    public AsseKnowDicQuesKind find(Integer id) {
        
        AsseKnowDicQuesKind dicQuesKind = null;
        dicQuesKind = (AsseKnowDicQuesKind) getHibernateTemplate()
        .load(AsseKnowDicQuesKind.class, id);
        return dicQuesKind;
    }

    /**
     * 查询问题类型记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 问题类型记录数
     */
    public int getCount(Map paramMap) {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicQuesKind.class);
        
        if(paramMap!=null) {
            if(paramMap.get("quesKindName")!=null) {
              criteria.add(Expression.like("quesKindName", "%"+((String) paramMap.get("quesKindName")).trim()+"%"));
         }
        }
        return 0;//count(criteria);
    }

    /**
     * 查询问题类型
     * @param paramMap
     *            查询条件
     * @return 问题类型列表
     */
    public List listDicQuesKind(Map paramMap) {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicQuesKind.class)
                            .addOrder(Order.asc("id"));
        if(paramMap!=null) {
            if(paramMap.get("quesKindName")!=null) {
              criteria.add(Expression.like("quesKindName", "%"+((String) paramMap.get("quesKindName")).trim()+"%"));
         }
        }
        return criteria.list();
    }

    /**
     * 查询问题类型分页记录.
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicQuesKindPage(Page page, Map paramMap) {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicQuesKind.class)
                            .addOrder(Order.asc("id"))
                            .setFirstResult(page.getBeginIndex())
                            .setMaxResults(page.getEveryPage());
        
        if(paramMap!=null) {
            if(paramMap.get("quesKindName")!=null) {
              criteria.add(Expression.like("quesKindName", "%"+((String) paramMap.get("quesKindName")).trim()+"%"));
         }
        }
        return criteria.list();
    }

    /**
     * 删除问题类型
     * 
     * @param dicQuesKind
     *            问题类型
     */
    public void remove(AsseKnowDicQuesKind dicQuesKind) {
        
        getHibernateTemplate().delete(dicQuesKind);
    }

    /**
     * 保存/更新问题类型
     * 
     * @param dicQuesKind
     *            问题类型
     */
    public void saveOrUpdate(AsseKnowDicQuesKind dicQuesKind) {
        
        getHibernateTemplate().saveOrUpdate(dicQuesKind);
    }

}
