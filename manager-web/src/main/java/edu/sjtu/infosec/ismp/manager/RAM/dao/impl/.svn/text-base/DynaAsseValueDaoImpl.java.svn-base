package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaAsseValueDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseValue;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 知识库项目总体评估值Dao实现类.
 **/
public class DynaAsseValueDaoImpl extends HibernateDaoSupport implements DynaAsseValueDao {

	/**
     * 查询项目总体评估值
     * @param id
     * 项目总体评估值id
     * @return 项目总体评估值对象
     **/
	public AsseKnowDynaAsseValue find(Integer id) {
		
		AsseKnowDynaAsseValue dynaAsseValue = null;
		dynaAsseValue = (AsseKnowDynaAsseValue) getHibernateTemplate().load(AsseKnowDynaAsseValue.class, id);
		return dynaAsseValue;
	}

	/**
     * 查询项目总体评估值记录数
     * @param projCode
     * 测评项目id
     * @return 项目总体评估值记录数
     **/
	public int getCount(String projCode) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaAsseValue.class)
		                                .addOrder(Order.asc("id"));
		if(projCode!=null && !"".equals(projCode)) {
			criteria.add(Expression.eq("projCode", projCode));
		}
		return 0;//count(criteria);
	}

	/**
     * 返回项目总体评估值
     * @param projCode
     * 测评项目id
     * @return 项目总体评估值列表
     **/
	public List<AsseKnowDynaAsseValue> listDynaAsseValue(String projCode) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaAsseValue.class)
                                        .addOrder(Order.asc("id"));
		if(projCode!=null && !"".equals(projCode)) {
			criteria.add(Expression.eq("projCode", projCode));
		}
		return criteria.list();
	}

	/**
     * 查询矩阵规则分页记录
     * @param page
     * 分页对象
     * @param projCode
     * 测评项目id
     * @return 分页记录列表
     **/
	public List<AsseKnowDynaAsseValue> listDynaAsseValuePage(Page page,String projCode) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaAsseValue.class)
                                        .addOrder(Order.asc("id"));
		if(page!=null) {
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
		}
		if(projCode!=null && !"".equals(projCode)) {
			criteria.add(Expression.eq("projCode", projCode));
		}
        return criteria.list();
	}

	/**
     * 删除矩阵规则
     * @param dynaAsseValue
     *        项目总体评估值
     **/
	public void remove(AsseKnowDynaAsseValue dynaAsseValue) {
		
		getHibernateTemplate().delete(dynaAsseValue);
	}

	/**
     * 保存/更新项目总体评估值
     * 
     * @param dynaAsseValue
     *        项目总体评估值
     **/
	public void saveOrUpdate(AsseKnowDynaAsseValue dynaAsseValue) {
		
		getHibernateTemplate().saveOrUpdate(dynaAsseValue);
	}

	/**
     * 查询项目总体评估值
     * @param projCode
     * 测评项目id
     * @return 项目总体评估值对象
     **/
	public AsseKnowDynaAsseValue find(String projCode) {
		
		AsseKnowDynaAsseValue dynaAsseValue = null;
		List list=getHibernateTemplate().find("from AsseKnowDynaAsseValue where projCode='"+projCode+"' ");
		if(list!=null && list.size()>0) {
			dynaAsseValue = (AsseKnowDynaAsseValue) list.get(0);
		}
		return dynaAsseValue;
	}

	public Object[] getExpQuesAndAdvice(String projCode) {
		 Object[] o = null;
		 List list=getHibernateTemplate().find("select totalAsse,expertSuggest from AsseKnowDynaAsseValue where projCode='"+projCode+"' ");
			if(list!=null && list.size()>0) {
				o = (Object[]) list.get(0);
			}
		return o;
	}

}
