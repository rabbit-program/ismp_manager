package edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.SysLogSourceDao;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSourceType;
import edu.sjtu.infosec.ismp.security.Domain;

@SuppressWarnings("deprecation")
public class SysLogSourceDaoImpl extends HibernateDaoSupport implements SysLogSourceDao {

	public Integer addSysLogSource(SysLogSource sysLogSource) throws Exception {
		try{
			this.getSession().save(sysLogSource);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SysLogSource> getAllSysLogSource(SysLogSource sysLogSource,List<Domain> domain,Integer pageNo,Integer pageRowNum) throws Exception {
		Criteria criteria = spliceCriteria(sysLogSource,domain,pageNo,pageRowNum);
		return criteria.list();
	}

	/**
	 * spliceCriteria decription : 带分页功能的多条件查询语句拼接
	 * @param sysLogSource
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 */
	private Criteria spliceCriteria(SysLogSource sysLogSource,List<Domain> domain,
			Integer pageNo,Integer pageRowNum) {
		Criteria criteria = getSession().createCriteria(
				SysLogSource.class);

		if (sysLogSource != null) {
			// 产生范例对像
			Example example = Example.create(sysLogSource);
			// 排除属性为null
			// example.excludeNone();
			// 对String属性都用模糊匹配方式
			example.enableLike(MatchMode.ANYWHERE);
			criteria.add(example);
			
			if(domain.size() > 0)
				criteria.add(Expression.in("domain",domain));
			
			criteria.addOrder(Order.desc("createTime"));
			if(sysLogSource.getId() != null) {
				criteria.add(Expression.eq("id", sysLogSource.getId()));
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

	
	@SuppressWarnings("unchecked")
	public List<SysLogSourceType> getAllSysLogSourceType() throws Exception {
		Query sysLogQuery = this.getSession().createQuery("from SysLogSourceType");
		return sysLogQuery.list();
	}

	public Integer delSysLogSource(SysLogSource sysLogSource) throws Exception {
		try{
			this.getSession().delete(sysLogSource);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}

	public Integer getAllSysLogSourceCount(SysLogSource sysLogSource,
			List<Domain> domain) throws Exception {
		Criteria criteria = spliceCriteria(sysLogSource,domain,null,null);
		criteria.setProjection(Projections.rowCount()); 
		return (Integer)criteria.uniqueResult();
	}

	public Integer updateSysLogSource(SysLogSource sysLogSource) throws Exception {
		try{
			this.getSession().update(sysLogSource);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}

	public SysLogSource loadObject(String id) throws Exception {
		return (SysLogSource) this.getSession().get(SysLogSource.class, Integer.valueOf(id));
	}
}
