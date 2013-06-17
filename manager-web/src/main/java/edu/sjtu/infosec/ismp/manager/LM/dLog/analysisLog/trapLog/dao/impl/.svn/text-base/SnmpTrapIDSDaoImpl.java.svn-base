package edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.dao.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.criterion.Expression;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.dao.SnmpTrapIDSDao;
import edu.sjtu.infosec.ismp.security.Domain;

@SuppressWarnings("deprecation")
public class SnmpTrapIDSDaoImpl extends HibernateDaoSupport implements
		SnmpTrapIDSDao {

	@SuppressWarnings("unchecked")
	public List<?> getSnmpTrapIDSLog(Class clazz, List<Domain> domain,
			String logSourceLogo, Integer pageNo, Integer pageRowNum)
			throws Exception {
		Criteria criteria = spliceCriteria(clazz,domain,logSourceLogo,pageNo,pageRowNum);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public Integer getSnmpTrapIDSLogCount(Class clazz, List<Domain> domain,
			String logSourceLogo) throws Exception {
		Criteria criteria = spliceCriteria(clazz, domain,logSourceLogo, null, null);
		criteria.setProjection(Projections.rowCount()); 
		return (Integer)criteria.uniqueResult();
	}

	/**
	 * spliceCriteria decription : 带分页功能的多条件查询语句拼接
	 * 
	 * @param snmpTrap
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Criteria spliceCriteria(Class clazz, List<Domain> domain,String logSourceLogo,
			Integer pageNo, Integer pageRowNum) {
		try {
			Criteria criteria = getSession().createCriteria(clazz);
			Object newInstance = clazz.newInstance();
			BeanUtils.copyProperty(newInstance, "logSourceSequence", logSourceLogo);
			if (newInstance != null) {
				// 产生范例对像
				Example example = Example.create(newInstance);
				// 排除属性为null
				// example.excludeNone();
				// 对String属性都用模糊匹配方式
				example.enableLike(MatchMode.ANYWHERE);
				criteria.add(example);

				if (domain.size() > 0)
					criteria.add(Expression.in("domain", domain));

				criteria.addOrder(Order.desc("eventTime"));
				// if(newInstance.getId() != null) {
				// criteria.add(Expression.eq("id", newInstance.getId()));
				// }
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
		} catch (Exception e) {
			return null;
		}
	}
}
