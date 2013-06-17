package edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.impl;

import java.util.List;
import org.hibernate.criterion.Expression;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.SnmpTrapSourceDao;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSourceType;
import edu.sjtu.infosec.ismp.security.Domain;

@SuppressWarnings("deprecation")
public class SnmpTrapSourceDaoImpl extends HibernateDaoSupport implements
		SnmpTrapSourceDao {

	public Integer addSnmpTrapSource(SnmpTrapSource snmpTrapSource)
			throws Exception {
		try{
			this.getSession().save(snmpTrapSource);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}

	public Integer delSnmpTrapSource(SnmpTrapSource snmpTrapSource)
			throws Exception {
		try{
			this.getSession().delete(snmpTrapSource);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SnmpTrapSource> getAllSnmpTrapSource(
			SnmpTrapSource snmpTrapSource, List<Domain> domain, Integer pageNo,
			Integer pageRowNum) throws Exception {
		Criteria criteria = spliceCriteria(snmpTrapSource,domain,pageNo,pageRowNum);
		return criteria.list();
	}

	public Integer getAllSnmpTrapSourceCount(SnmpTrapSource snmpTrapSource,
			List<Domain> domain) throws Exception {
		Criteria criteria = spliceCriteria(snmpTrapSource,domain,null,null);
		criteria.setProjection(Projections.rowCount()); 
		return (Integer)criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<SnmpTrapSourceType> getAllSnmpTrapSourceType() throws Exception {
		Query snmpTrapQuery = this.getSession().createQuery("from SnmpTrapSourceType");
		return snmpTrapQuery.list();
	}

	public SnmpTrapSource loadObject(String id) throws Exception {
		return (SnmpTrapSource) this.getSession().get(SnmpTrapSource.class, Integer.valueOf(id));
	}

	public Integer updateSnmpTrapSource(SnmpTrapSource snmpTrapSource)
			throws Exception {
		try{
			this.getSession().update(snmpTrapSource);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}

	/**
	 * spliceCriteria decription : 带分页功能的多条件查询语句拼接
	 * @param sysLogSource
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 */
	private Criteria spliceCriteria(SnmpTrapSource snmpTrapSource,List<Domain> domain,
			Integer pageNo,Integer pageRowNum) {
		Criteria criteria = getSession().createCriteria(
				SnmpTrapSource.class);

		if (snmpTrapSource != null) {
			// 产生范例对像
			Example example = Example.create(snmpTrapSource);
			// 排除属性为null
			// example.excludeNone();
			// 对String属性都用模糊匹配方式
			example.enableLike(MatchMode.ANYWHERE);
			criteria.add(example);
			
			if(domain.size() > 0)
				criteria.add(Expression.in("domain",domain));
			
			criteria.addOrder(Order.desc("createTime"));
			if(snmpTrapSource.getId() != null) {
				criteria.add(Expression.eq("id", snmpTrapSource.getId()));
			}
		}

		// 添加分页查询条件：起始页
		if (null != pageNo) {
			criteria.setFirstResult(pageNo.intValue());
		}

		// 添加分页查询条件：每页需要显示的数目
		if (null != pageRowNum) {
			criteria.setMaxResults(pageRowNum.intValue());
		}
		return criteria;
	}

}
