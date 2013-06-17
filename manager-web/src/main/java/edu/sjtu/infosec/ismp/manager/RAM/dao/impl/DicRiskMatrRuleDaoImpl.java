package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicRiskMatrRuleDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicRiskMatrRule;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 风险矩阵数据字典Dao实现类.
 **/
public class DicRiskMatrRuleDaoImpl extends HibernateDaoSupport implements DicRiskMatrRuleDao {

	/**
     * 查询矩阵规则
     * 
     * @param id
     *            矩阵规则id
     * @return 矩阵规则对象
     */
	public AsseKnowDicRiskMatrRule find(Integer id) {
		
		AsseKnowDicRiskMatrRule dicRiskMatrRule = (AsseKnowDicRiskMatrRule) getHibernateTemplate().load(AsseKnowDicRiskMatrRule.class, id);
		return dicRiskMatrRule;
	}

	/**
     * 查询矩阵规则
     * @param asseImpo
     * 资产重要性
     * @param vulnSeri
     * 脆弱点严重性
     * @param threPoss
     * 威胁发生可能性
     * @return 矩阵规则对象
     */
	public AsseKnowDicRiskMatrRule find(String asseImpo, String vulnSeri,
			String threPoss) {
		
		AsseKnowDicRiskMatrRule dicRiskMatrRule = null;
		List list = getSession().createQuery("from AsseKnowDicRiskMatrRule where asseImpo=:asseImpo " +
				                             "and vulnSeri=:vulnSeri "+
				                             "and threPoss=:threPoss ")
		                        .setParameter("asseImpo", asseImpo)
		                        .setParameter("vulnSeri", vulnSeri)
		                        .setParameter("threPoss", threPoss)
				                .list();
		if(list!=null && list.size()>0) {
			dicRiskMatrRule = (AsseKnowDicRiskMatrRule) list.get(0);
		}
		return dicRiskMatrRule;
	}

	/**
     * 查询矩阵规则记录数
     * @return 矩阵规则记录数
     */
	public int getCount() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDicRiskMatrRule.class)
                                        .addOrder(Order.asc("id"));
        return 0;//count(criteria);
	}

	/**
     * 返回所有矩阵规则
     * @return 矩阵规则列表
     */
	public List<AsseKnowDicRiskMatrRule> listAllDicRiskMatrRule() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDicRiskMatrRule.class)
		                                .addOrder(Order.asc("id"));
		return criteria.list();
	}

	/**
     * 查询矩阵规则分页记录
     * 
     * @param page
     *            分页对象
     * @return 分页记录列表
     */
	public List<AsseKnowDicRiskMatrRule> listDicRiskMatrRulePage(Page page) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDicRiskMatrRule.class)
                                        .addOrder(Order.asc("id"));
		if(page!=null) {
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
		}
        return criteria.list();
	}

	/**
     * 删除矩阵规则
     * 
     * @param dicRiskMatrRule
     *            矩阵规则
     */
	public void remove(AsseKnowDicRiskMatrRule dicRiskMatrRule) {
		
		getHibernateTemplate().delete(dicRiskMatrRule);
	}

	/**
     * 保存/更新矩阵规则
     * 
     * @param dicRiskMatrRule
     *            矩阵规则
     */
	public void saveOrUpdate(AsseKnowDicRiskMatrRule dicRiskMatrRule) {
		
		getHibernateTemplate().saveOrUpdate(dicRiskMatrRule);
	}

}
