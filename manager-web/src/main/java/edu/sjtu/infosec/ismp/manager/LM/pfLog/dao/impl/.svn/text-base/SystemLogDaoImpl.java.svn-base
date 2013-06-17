package edu.sjtu.infosec.ismp.manager.LM.pfLog.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 平台日志操作DAO
 * 
 * @author 林超
 * 
 */
@Component
public class SystemLogDaoImpl extends HibernateDao<SystemLog, Long> {

	public List<SystemLog> getPageBySystemLog(SystemLog systemLog,
			Integer pageNo, Integer pageRowNum, Timestamp startDate,
			Timestamp endDate) {
		Criteria criteria = spliceCriteria(systemLog, pageNo, pageRowNum, startDate, endDate);
		return criteria.list();
	}

	public Integer getSystemLogCount(SystemLog log, Timestamp startDate,
			Timestamp endDate) {
		Criteria criteria = spliceCriteria(log, null, null, startDate, endDate);
		criteria.setProjection(Projections.rowCount()); 
		return (Integer) criteria.uniqueResult();
	}

	/**
	 * spliceCriteria decription : 带分页功能的多条件查询语句拼接
	 * 
	 * @param sysLogSource
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 */
	private Criteria spliceCriteria(SystemLog log, Integer pageNo,
			Integer pageRowNum, Timestamp startDate, Timestamp endDate) {
		Criteria criteria = getSession().createCriteria(SystemLog.class);

		if (log != null) {
			// 产生范例对像
//			if(log)
			Example example = Example.create(log);
			// 排除属性为null
			//example.excludeNone();
			// 对String属性都用模糊匹配方式
			example.enableLike(MatchMode.ANYWHERE);
			criteria.add(example);

			criteria.add(Restrictions.between("time", startDate, endDate));

			criteria.addOrder(Order.desc("time"));
			if (log.getId() != null) {
				criteria.add(Expression.eq("id", log.getId()));
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
