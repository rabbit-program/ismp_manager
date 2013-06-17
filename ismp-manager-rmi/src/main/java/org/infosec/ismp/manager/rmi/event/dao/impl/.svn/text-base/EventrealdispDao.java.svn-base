package org.infosec.ismp.manager.rmi.event.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.rmi.event.dao.IEventrealdispDao;
import org.infosec.ismp.manager.rmi.event.dao.Status;
import org.infosec.ismp.manager.rmi.event.dao.queryCondition.EventrealdispCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryCondition.RuleCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryResult.EventrealdispResult;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;
import org.infosec.ismp.manager.rmi.event.util.Page;
import org.infosec.ismp.manager.rmi.event.util.PageUtil;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EventrealdispDao extends HibernateDaoSupport implements
		IEventrealdispDao {

	public void add(Eventrealdisp data) {
		getHibernateTemplate().save(data);

	}

	public void add(List<Eventrealdisp> data) {
		getHibernateTemplate().saveOrUpdateAll(data);

	}

	public void delete(Eventrealdisp data) {
		getHibernateTemplate().delete(data);

	}

	public void delete(List<Serializable> ids) {
		Iterator<Serializable> it = ids.iterator();
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from Eventrealdisp e where e.id in (");
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

	public Eventrealdisp get(Serializable id) {
		return (Eventrealdisp) getHibernateTemplate().get(Eventrealdisp.class,
				id);
	}

	@SuppressWarnings("unchecked")
	public EventrealdispResult queryEventrealdispByCondition(
			final EventrealdispCondition condition) {
		
		return (EventrealdispResult) getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				EventrealdispResult res = new EventrealdispResult();
				Page page = condition.getPage();
				Page p = new Page();
				Criteria criteria = session.createCriteria(Eventrealdisp.class);
				
				if (condition.getBureauId()!=null && condition.getBureauId()>0){
					criteria.add(Restrictions.eq("bureauId", condition.getBureauId()));
				}

				// 查找事件描述符合的字符串
				if (condition.getDescrip() != null
						&& condition.getDescrip().trim().length() > 0) {
					String str = condition.getDescrip();
					criteria.add(Restrictions.like("descrip", "%" + str + "%"));
				}
				
				//事件的源IP地址
				if (condition.getSrc_ip()!=null && condition.getSrc_ip().trim().length()>0) {
					criteria.add(Restrictions.eq("src_ip", condition.getSrc_ip()));
				}
				
				//事件的威胁等级为条件
				if (condition.getThre_rank()!=null && condition.getThre_rank()>0) {
					criteria.add(Restrictions.eq("thre_rank", condition.getThre_rank()));
				}
				
				//事伯的源端口为条件
				if (condition.getSrc_port()!= null && condition.getSrc_port() > 0) {
					criteria
							.add(Restrictions.eq("src_port", condition.getSrc_port()));
				}

				// 事件目的端口为条件
				if (condition.getDest_port()!= null && condition.getDest_port() > 0) {
					criteria
							.add(Restrictions.eq("dest_port", condition.getDest_port()));
				}

				// 数据流方向，向内( 0 ) 或向外 ( 1 )
				if (condition.getDirection() != null) {
					if (condition.getDirection() == true) {
						criteria.add(Restrictions.eq("direction", 0));
					} else {
						criteria.add(Restrictions.eq("direction", 1));
					}
				}

				// 按起始日期时间和结束日期时间查询
				System.out.println("------查询前的-bureauId-------" + condition.getBureauId());
				System.out.println("------查询前的-时间-------" + condition.getStarttime() + "---" + condition.getEndtime());
				
				if (condition.getStarttime() != null && condition.getEndtime() != null) {
					criteria.add(Restrictions.between("time", condition.getStarttime(),
							condition.getEndtime()));
				} else if (condition.getStarttime() != null) {
					criteria.add(Restrictions.ge("time", condition.getStarttime()));
				} else if (condition.getEndtime() != null) {
					criteria.add(Restrictions.le("time", condition.getEndtime()));
				}

				// 事件类型条件查询
				if (condition.getEvent_type() != null
						&& condition.getEvent_type().trim().length() > 0) {
					criteria.add(Restrictions.eq("event_type", condition
							.getEvent_type()));
				}

				// 安全设备IP查询
				if (condition.getFaci_ip() != null
						&& condition.getFaci_ip().trim().length() > 0) {
					criteria.add(Restrictions.eq("faci_ip", condition.getFaci_ip()));
				}

				// 根据安全设备类型查询
				if (condition.getFaci_type() != null
						&& condition.getFaci_type().trim().length() > 0) {
					criteria
							.add(Restrictions.eq("faci_type", condition.getFaci_type()));
				}
				
				//总记录数
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
				criteria.addOrder(Order.desc("time"));
				p = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(),
						totalCount);
				List<Eventrealdisp> list = criteria.list();
				res.setPage(p);
				res.setResults(list);
				res.setStatus(Status.SUCCESS);
				return res;
			}
		});
		
	}

	public void update(Eventrealdisp data) {
		getHibernateTemplate().update(data);

	}

	public void update(List<Eventrealdisp> datas) {
		getHibernateTemplate().saveOrUpdateAll(datas);

	}

	@SuppressWarnings("unchecked")
	public List<Object> staticticsEventType(final Timestamp starttime,
			final Timestamp endtime, final Integer bureauId) {
		
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Eventrealdisp.class);
				if (bureauId != null && bureauId > 0) {
					criteria.add(Restrictions.eq("bureauId", bureauId));
				}
				if (starttime != null && endtime != null) {
					criteria.add(Restrictions.between("time", starttime, endtime));
				} else if (starttime != null) {
					criteria.add(Restrictions.ge("time", starttime));
				} else if (endtime != null) {
					criteria.add(Restrictions.le("time", endtime));
				}
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.groupProperty("event_type"));
				projectionList.add(Projections.rowCount(),"typeorder");
				criteria.setProjection(projectionList);
				criteria.addOrder(Order.desc("typeorder"));
				criteria.setFirstResult(0);
				criteria.setMaxResults(10);
				List<Object> list = criteria.list();
				return list;
			}
		});
		
	}

	@SuppressWarnings("unchecked")
	public List<Object> staticticsSafety(final Timestamp starttime,final  Timestamp endtime,final Integer bureauId) {
		
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Eventrealdisp.class);
				if (bureauId != null && bureauId > 0) {
					criteria.add(Restrictions.eq("bureauId", bureauId));
				}
				if (starttime != null && endtime != null) {
					criteria.add(Restrictions.between("time", starttime, endtime));
				} else if (starttime != null) {
					criteria.add(Restrictions.ge("time", starttime));
				} else if (endtime != null) {
					criteria.add(Restrictions.le("time", endtime));
				}
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.groupProperty("faci_type"));
				projectionList.add(Projections.rowCount(),"fatype");
				criteria.setProjection(projectionList);
				criteria.addOrder(Order.desc("fatype"));
				criteria.setFirstResult(0);
				criteria.setMaxResults(10);
				List<Object> list = criteria.list();
				return list;
			}
		});
		
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Eventrealdisp> queryBycorrrule(final RuleCondition condition){
		DetachedCriteria dc = DetachedCriteria.forClass(Eventrealdisp.class);
		dc.setProjection(Projections.max("time"));
		final Timestamp endtime =  (Timestamp) getHibernateTemplate().findByCriteria(dc).get(0);
		if (endtime==null) {
			return null;
		}
		long time = endtime.getTime();
		long tt = time-condition.getRulelength();
		final Timestamp starttime = new Timestamp((long)tt);
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Eventrealdisp.class);
				if (condition.getBureauId()!=null && condition.getBureauId().length > 0) {
					criteria.add(Restrictions.in("bureauId", condition.getBureauId()));
				}
				criteria.add(Restrictions.between("time", starttime, endtime));
//				System.out.println(starttime.toString());
//				System.out.println(endtime.toString());
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.projectionList().add(Projections.property("id")).add(
						Projections.property("time")));
				
				//源IP是否相同
				if (condition.isSrcip_same()) {
					projectionList.add(Projections.groupProperty("src_ip"));
				}else {
					projectionList.add(Projections.property("src_ip"));
				}
				
				//源端口
				projectionList.add(Projections.projectionList().add(
						Projections.property("src_port")));
				
				//目的端口是否相同
				if (condition.isDestport_same()) {
					projectionList.add(Projections.groupProperty("dest_port"));
				}else {
					projectionList.add(Projections.property("dest_port"));
				}
				
				// 威胁等级,安全设备类型
				projectionList.add(Projections.projectionList().add(
						Projections.property("thre_rank")).add(
						Projections.property("faci_type")));
				

				//事件类型是否相同
				if (condition.isEventtype_same()) {
					projectionList.add(Projections.groupProperty("event_type"));
				}else {
					projectionList.add(Projections.property("event_type"));
				}

				// 协议类型是否相同
				if (condition.isProtocol_same()) {
					projectionList.add(Projections.groupProperty("prot_type"));
				}else {
					projectionList.add(Projections.property("prot_type"));
				}
				
				
				//目的IP是否相同
				if (condition.isDestip_same()) {
					projectionList.add(Projections.groupProperty("dest_ip"));
				}else {
					projectionList.add(Projections.property("dest_ip"));
				}
				
				//描述
				projectionList.add(Projections.projectionList().add(
						Projections.property("descrip")));
				if (condition.isDestip_same() || condition.isDestport_same()
						|| condition.isEventtype_same() || condition.isProtocol_same()
						|| condition.isSrcip_same()) {
					projectionList.add(Projections.rowCount());
				}
				
				criteria.setProjection(projectionList);
				List<Eventrealdisp> list = (List<Eventrealdisp>) criteria.list();
				return list;
			}
		});
		
	}
	
}
