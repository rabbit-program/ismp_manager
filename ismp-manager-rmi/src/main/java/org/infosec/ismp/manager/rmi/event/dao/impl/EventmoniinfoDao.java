package org.infosec.ismp.manager.rmi.event.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.rmi.event.dao.IEventmoniinfoDao;
import org.infosec.ismp.manager.rmi.event.dao.Status;
import org.infosec.ismp.manager.rmi.event.dao.queryCondition.EventmoniinfoCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryResult.EventmoniinfoResult;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoniinfo;
import org.infosec.ismp.manager.rmi.event.util.Page;
import org.infosec.ismp.manager.rmi.event.util.PageUtil;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 设备监控信息表的DAO实现
 * @author wudengke 2009-6-29
 *
 */
public class EventmoniinfoDao extends HibernateDaoSupport implements
		IEventmoniinfoDao {

	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	public void add(Eventmoniinfo data) {
		getHibernateTemplate().save(data);

	}

	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void add(List<Eventmoniinfo> data) {
		getHibernateTemplate().saveOrUpdateAll(data);

	}

	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	public void delete(Eventmoniinfo data) {
		getHibernateTemplate().delete(data);

	}

	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	public void delete(List<Serializable> ids) {
		Iterator<Serializable> it = ids.iterator();
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from Eventmoniinfo e where e.id in (");
		while(it.hasNext()){
			buffer.append("?");
			it.next();
			if(it.hasNext()){
				buffer.append(",");
			}
		}
		buffer.append(")");
		
		getHibernateTemplate().bulkUpdate(buffer.toString(),ids.toArray());
	}

	/**
	 * 通过ID查询对象
	 * 
	 * @param id
	 * 
	 */
	public Eventmoniinfo get(Serializable id) {
		return (Eventmoniinfo) getHibernateTemplate().get(Eventmoniinfo.class, id);
	}

	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	public void update(Eventmoniinfo data) {
		getHibernateTemplate().update(data);

	}

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void update(List<Eventmoniinfo> data) {
		getHibernateTemplate().saveOrUpdateAll(data);
	}

	@SuppressWarnings("unchecked")
	public EventmoniinfoResult queryEventmoniinfoByCondition(
			final EventmoniinfoCondition condition) {
		
		return (EventmoniinfoResult) getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				EventmoniinfoResult res = new EventmoniinfoResult();
				Page page = condition.getPage();
				Page p = new Page();
				Criteria criteria = session.createCriteria(Eventmoniinfo.class);
				
				if (condition.getBureauId()!=null && condition.getBureauId()>0) {
					criteria.add(Restrictions.eq("bureauId", condition.getBureauId()));
				}
				
				if (condition.getEventType()!=null && condition.getEventType().length()>0) {
					String str = condition.getEventType();
					criteria.add(Restrictions.like("eventType", "%" + str + "%"));
				}
				
				if (condition.getIpAddress()!=null && condition.getIpAddress().length()>0) {
					String str = condition.getIpAddress();
					criteria.add(Restrictions.eq("ipAddress",str));
				}
				
				if (condition.getStartTime()!=null && condition.getEndTime()!=null) {
					criteria.add(Restrictions.between("time", condition.getStartTime(),
							condition.getEndTime()));
				}else if (condition.getStartTime() != null) {
					criteria.add(Restrictions.ge("time", condition.getStartTime()));
				} else if (condition.getEndTime() != null) {
					criteria.add(Restrictions.le("time", condition.getEndTime()));
				}
				
				//    2010-6-8  --------------------
				criteria.addOrder(Order.desc("time"));
				
//				/------------------------- 
				int totalCount = ((Integer) criteria.setProjection(
						Projections.rowCount()).uniqueResult()).intValue();
				if (totalCount == 0) {
					res.setStatus(Status.NORESULT);
					return res;
				}
				criteria.setProjection(null);
				int startIndex = page.getEveryPage() * (page.getCurrentPage() - 1);
				p.setBeginIndex(startIndex + 1);
				criteria.setFirstResult(startIndex);
				criteria.setMaxResults(page.getEveryPage());
				p = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(),
						totalCount);
				List<Eventmoniinfo> list = criteria.list();
				res.setPage(p);
				res.setResults(list);
				res.setStatus(Status.SUCCESS);
				return res;
			}
		});
		
	}

}
