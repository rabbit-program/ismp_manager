package edu.sjtu.infosec.ismp.manager.LM.dLog.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.LM.dLog.dao.SysLogDao;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLog;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLogFacility;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLogSeverity;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.security.Domain;
@SuppressWarnings({ "unchecked", "deprecation" })
public class SysLogDaoImpl extends HibernateDaoSupport implements SysLogDao {

	
	public List<SysLogFacility> initSysLogFacility() throws Exception {
		return this.getSession().createQuery("from SysLogFacility").list();
	}

	public List<SysLogSeverity> initSysLogSeverity() throws Exception {
		return this.getSession().createQuery("from SysLogSeverity").list();
	}

	public Integer getPageResultRowSum(String HQL) throws Exception {
		Query sysLogQuery = this.getSession().createQuery(HQL);
		if(!sysLogQuery.list().isEmpty()){
			return Integer.parseInt(sysLogQuery.list().get(0).toString());
		}else{
			return 0;
		}
	}

	public List<SysLog> getPageResult(String HQL, Integer pageNo,
			Integer pageRowNum) throws Exception {
		Query sysLogQuery = this.getSession().createQuery(HQL);
		sysLogQuery.setFirstResult(pageNo);
		sysLogQuery.setMaxResults(pageRowNum);
		return sysLogQuery.list();
	}
	
	public List<SysLogSource> getAllSysLogSource(SysLogSource sysLogSource,List<Domain> domain,Integer pageNo,Integer pageRowNum) throws Exception {
		Criteria criteria = spliceCriteria(sysLogSource,domain,pageNo,pageRowNum);
		return criteria.list();
	}

	public Integer getAllSysLogSourceCount(SysLogSource sysLogSource,List<Domain> domain) throws Exception {
		Criteria criteria = spliceCriteria(sysLogSource,domain,null,null);
		criteria.setProjection(Projections.rowCount()); 
		return (Integer)criteria.uniqueResult();
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
}
