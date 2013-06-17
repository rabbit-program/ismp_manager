package org.infosec.ismp.manager.rmi.event.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.infosec.ismp.manager.rmi.event.dao.IEventmoniDao;
import org.infosec.ismp.manager.rmi.event.dao.Status;
import org.infosec.ismp.manager.rmi.event.dao.queryCondition.EventmoniCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryResult.EventmoniResult;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.util.Page;
import org.infosec.ismp.manager.rmi.event.util.PageUtil;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 吴登科
 * 
 * 2009.6.1 事件监测表的DAO实现
 * 
 * @author wudengke
 * 
 * 
 */
public class EventmoniDao extends HibernateDaoSupport implements IEventmoniDao {
	
   

	/**
	 * 添加单个对象。
	 * 
	 * @param data
	 *            需要添加的对象。
	 * 
	 */
	public void add(Eventmoni data) {
		getHibernateTemplate().saveOrUpdate(data);
		System.out.println("add(Eventmoni data)");
		getHibernateTemplate().flush();
	}

	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void add(List<Eventmoni> data) {
		getHibernateTemplate().saveOrUpdateAll(data);
		System.out.println("add(List<Eventmoni> data)");
		getHibernateTemplate().flush();
	}

	/**
	 * 删除指定的对象。
	 * 
	 * @param data
	 * 
	 */
	public void delete(Eventmoni data) {
		getHibernateTemplate().delete(data);

	}

	/**
	 * 删除指定的多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void delete(List<Serializable> ids) {
		Iterator<Serializable> it = ids.iterator();
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from Eventmoni e where e.id in (");
		while (it.hasNext()) {
			buffer.append("?");
			it.next();
			if (it.hasNext()) {
				buffer.append(",");
			}
		}
		buffer.append(")");

		getHibernateTemplate().bulkUpdate(buffer.toString(), ids.toArray());

	}

	/**
	 * 通过查询Eventmoni对象
	 * 
	 * @param id
	 * 
	 */
	public Eventmoni get(Serializable id) {
		return (Eventmoni) getHibernateTemplate().get(Eventmoni.class, id);

	}

	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data
	 *            需要修改的对象。
	 * 
	 * 
	 */
	public void update(Eventmoni data) {
		getHibernateTemplate().update(data);

	}

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void update(List<Eventmoni> data) {
		getHibernateTemplate().saveOrUpdateAll(data);

	}

	/**
	 * 通过组合条件进行查询
	 * 
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EventmoniResult queryEventmoniByCondition(
			final EventmoniCondition condition) {
		
		
		return  (EventmoniResult) getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				EventmoniResult res = new EventmoniResult();
				Page page = condition.getPage();
				Page p = new Page();
				Criteria criteria = session.createCriteria(Eventmoni.class);
				
				if (condition.getBureauId() != null
						&& condition.getBureauId() > 0) {
					criteria.add(Restrictions.eq("bureauId", condition
							.getBureauId()));
				}

				// 通过设备名称为条件查询
				if (condition.getFaci_name() != null
						&& condition.getFaci_name().trim().length() > 0) {
					String str = condition.getFaci_name();
					criteria.add(Restrictions.like("faci_name", "%" + str + "%"));
				}

				// 通过多个设备ID查询
				if (condition.getFaci_ids() != null
						&& condition.getFaci_ids().length > 0) {
					criteria.add(Restrictions.in("faci_id", condition.getFaci_ids()));
				}
				
				if (condition.getFaci_ip()!=null && condition.getFaci_ip().length()>0) {
					criteria.add(Restrictions.eq("faci_ip", condition.getFaci_ip()));
				}

				int totalCount = ((Integer) criteria.setProjection(
						Projections.rowCount()).uniqueResult()).intValue();
				if (totalCount == 0) {
					res.setStatus(Status.NORESULT);
					return res;
				}
				criteria.setProjection(null);
				int startIndex = page.getEveryPage() * (page.getCurrentPage() - 1);
				criteria.setFirstResult(startIndex);
				criteria.setMaxResults(page.getEveryPage());
				criteria.addOrder(Order.desc("time"));
				p = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(),
						totalCount);
				List<Eventmoni> list = criteria.list();
				res.setPage(p);
				res.setResults(list);
				res.setStatus(Status.SUCCESS);
				return res;
			}
		});
	}

	/**
	 * 统计所有设备ID在时间段内的事件集合
	 * 
	 * @param starttime
	 * @param endtime
	 * @return 事件监测表信息
	 */
	@SuppressWarnings("unchecked")
	public List<Object> statisticsFaciid(Timestamp starttime, Timestamp endtime, Integer bureauId) {
		Object[] obj = new Object[]{starttime,endtime};
		String hql = "select a.deviceIp as ip, max(b.total_value) as total_value " +
		"from TopoManageDevice a, Eventmoni b "+
		"where a.nodeype=1 and a.deviceIp=b.faci_ip " +
		"and b.time between ? and ? ";
		if (bureauId!=null && bureauId > 0) {
			hql = hql + " and b.bureauId=? ";
			obj = new Object[] {starttime, endtime, bureauId};
		}
		hql = hql + " group by a.deviceIp";
		List<Object> list = getHibernateTemplate().find(hql, obj);
		return list;

	}

	/**
	 * 统计所有设备IP在时间段内的事件集合
	 * 
	 * @param starttime
	 * @param endtime
	 * @return 事件监测表信息
	 */
	@SuppressWarnings("unchecked")
	public List<Object> statisticsFaciip(Timestamp starttime, Timestamp endtime, Integer bureauId) {
		String hql = "select faci_ip as ip, max(total_value)-min(total_value) as total_value " +
				"from Eventmoni where time between ? and ? ";
		if (bureauId!=null && bureauId > 0) {
			hql = hql + " and bureauId=? ";
		}
		hql = hql +  " group by faci_ip order by max(total_value)-min(total_value) desc ";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, starttime);
		query.setParameter(1, endtime);
//		query.setParameter(2, bureauId);
		if (bureauId!=null && bureauId > 0) {
			query.setParameter(2, bureauId);
		}
		query.setFirstResult(0);
		query.setMaxResults(10);
		List<Object> list = query.list();
		return list;

	}

	/**
	 * 通过设备IP查找记录
	 * 
	 * @param faci_ip
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> queryRealTimeList(final String faci_ip,final Integer bureauId) {
		
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Eventmoni.class);
				if (bureauId!=null && bureauId>0) {
					criteria.add(Restrictions.eq("bureauId", bureauId));
				}
				criteria.add(Restrictions.eq("faci_ip", faci_ip));
				ProjectionList proList = Projections.projectionList();
		        proList.add(Projections.groupProperty("time"));   
		        proList.add(Projections.groupProperty("curr_value"));  
		        criteria.setProjection(proList);
				criteria.addOrder(Order.desc("time"));
				criteria.setFirstResult(0);
				criteria.setMaxResults(20);
				List<Object> list = criteria.list();
				return list;
			}
		});
	}

	/**
	 * 获取最新记录的Faci_ip,total_value
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> queryIpTotalByNew() {
		DetachedCriteria dc = DetachedCriteria.forClass(Eventmoni.class);
		dc.setProjection(Projections.max("time"));
		DetachedCriteria query = DetachedCriteria.forClass(Eventmoni.class);
		query.add(Subqueries.propertyEq("time", dc));
		query.setProjection(Projections.projectionList().add(
				Projections.property("faci_ip")).add(
				Projections.property("total_value")).add(Projections.property("bureauId")));
		List<Object> res = getHibernateTemplate().findByCriteria(query);
		return res;
	}

}
