package edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.PcSourceDao;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.Sensor;
import edu.sjtu.infosec.ismp.security.Domain;

@SuppressWarnings("deprecation")
public class PcSourceDaoImpl extends HibernateDaoSupport implements PcSourceDao {
	
	@SuppressWarnings("unchecked")
	public List<Sensor> getAllPcSource(Sensor sensor, List<Domain> domain,
			Integer pageNo, Integer pageRowNum) throws Exception {
		Criteria criteria = spliceCriteria(sensor, domain, pageNo, pageRowNum);
		return criteria.list();
	}

	public Integer getAllPcSourceCount(Sensor sensor, List<Domain> domain)
			throws Exception {
		Criteria criteria = spliceCriteria(sensor, domain, null, null);
		criteria.setProjection(Projections.rowCount()); 
		return (Integer)criteria.uniqueResult();
	}

	public Sensor loadObject(String id) throws Exception {
		return (Sensor) this.getSession().get(Sensor.class, Integer.valueOf(id));
	}

	public Integer updatePcSource(Sensor sensor) throws Exception {
		try{
			this.getSession().update(sensor);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}

	/**
	 * spliceCriteria decription : 带分页功能的多条件查询语句拼接
	 * @param sensor
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 */
	private Criteria spliceCriteria(Sensor sensor,List<Domain> domain,
			Integer pageNo,Integer pageRowNum) {
		Criteria criteria = getSession().createCriteria(
				Sensor.class);

		if (sensor != null) {
			// 产生范例对像
			Example example = Example.create(sensor);
			// 排除属性为null
//			example.excludeNone();
			// 排除eventTime
			example.excludeProperty("intervalCollectTime");
			// 对String属性都用模糊匹配方式
			example.enableLike(MatchMode.ANYWHERE);
			criteria.add(example);
			
			if(domain.size() > 0){
				criteria.add(Expression.in("domain",domain));
			}
			
//			criteria.addOrder(Order.asc("domain"));
			criteria.addOrder(Order.desc("startMonitorSwitch"));
			if(sensor.getId() != null) {
				criteria.add(Expression.eq("id", sensor.getId()));
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
