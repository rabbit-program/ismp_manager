package org.infosec.ismp.manager.rmi.event.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.rmi.event.dao.IEventcorrruleDao;
import org.infosec.ismp.manager.rmi.event.dao.queryResult.EventcorrruleResult;
import org.infosec.ismp.manager.rmi.event.modle.Eventcorrrule;
import org.infosec.ismp.manager.rmi.event.util.Page;
import org.infosec.ismp.manager.rmi.event.util.PageUtil;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 关联规则表的DAO实现
 * @author wudengke 2009-6-29
 *
 */
public class EventcorrruleDao extends HibernateDaoSupport implements
		IEventcorrruleDao {

	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	public void add(Eventcorrrule data) {
		getHibernateTemplate().save(data);
	}

	/**
	 * 添加多个对象。
	 * 
	 * @param datas
	 * 
	 */
	public void add(List<Eventcorrrule> datas) {
		getHibernateTemplate().saveOrUpdateAll(datas);

	}

	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	public void delete(Eventcorrrule data) {
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
		buffer.append("delete from Eventcorrrule e where e.id in (");
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
	 * 通过查询Eventcorrrule对象
	 * 
	 * @param id
	 * 
	 */
	public Eventcorrrule get(Serializable id) {
		return (Eventcorrrule) getHibernateTemplate().get(Eventcorrrule.class, id);
	}


	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	public void update(Eventcorrrule data) {
		getHibernateTemplate().update(data);
	}

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void update(List<Eventcorrrule> data) {
		getHibernateTemplate().saveOrUpdateAll(data);

	}

	/**
	 * 根据分页显示所有规则
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EventcorrruleResult queryAllByPage(final Page page,final String userName) {
		
		return (EventcorrruleResult) getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				EventcorrruleResult res = new EventcorrruleResult();
				Criteria criteria = session.createCriteria(Eventcorrrule.class);
				if (userName != null && userName.length() > 0) {
					criteria.add(Restrictions.eq("userName", userName));
				}
				int totalCount = ((Integer) criteria.setProjection(Projections.rowCount())
		                .uniqueResult()).intValue();
				criteria.setProjection(null);
				int startIndex = page.getEveryPage() * (page.getCurrentPage() - 1);
				criteria.setFirstResult(startIndex);
				criteria.setMaxResults(page.getEveryPage());
				Page p = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), totalCount);
				List<Eventcorrrule> list = criteria.list();
				res.setEvcors(list);
				res.setPage(p);
				return res;
			}
		});
		
	}
	
	/**
	 * 根据多个ID查询记录
	 * @param ruleids
	 * @return　List　Eventcorrrule
	 */
	@SuppressWarnings("unchecked")
	public List<Eventcorrrule> queryEventcorule(final String[] ruleids) {
		
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Eventcorrrule.class);
				Integer[] ints = new Integer[ruleids.length];
				for(int i = 0; i < ints.length; i ++){
					ints[i] = Integer.parseInt(ruleids[i]);
				}
				criteria.add(Restrictions.in("id", ints));
				List<Eventcorrrule> list = criteria.list();
				return list;
			}
		});		
	}
}
