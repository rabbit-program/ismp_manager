package edu.sjtu.infosec.ismp.manager.EM.dao.impl;

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
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventrealdispDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.Status;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventrealdispCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.RuleCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventrealdispResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventrealdisp;
import edu.sjtu.infosec.ismp.manager.EM.util.PageUtil;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;

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
					List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
					for(Domain d:managerBo){
						if(d.getId().equals(condition.getBureauId())){
							criteria.add(Restrictions.eq("domain", d));
						}
					}
				}

				// 查找事件描述符合的字符串
				if (condition.getDescrip() != null
						&& condition.getDescrip().trim().length() > 0) {
					String str = condition.getDescrip();
					criteria.add(Restrictions.like("descrip", "%" + str + "%"));
				}
				
				//事件的源IP地址
				if (condition.getSrc_ip()!=null && condition.getSrc_ip().trim().length()>0) {
					criteria.add(Restrictions.eq("srcIp", condition.getSrc_ip()));
				}
				
				//事件的威胁等级为条件
				if (condition.getThre_rank()!=null && condition.getThre_rank()>0) {
					criteria.add(Restrictions.eq("threRank", condition.getThre_rank()));
				}
				
				//事伯的源端口为条件
				if (condition.getSrc_port()!= null && condition.getSrc_port() > 0) {
					criteria
							.add(Restrictions.eq("srcPort", condition.getSrc_port()));
				}

				// 事件目的端口为条件
				if (condition.getDest_port()!= null && condition.getDest_port() > 0) {
					criteria
							.add(Restrictions.eq("destPort", condition.getDest_port()));
				}

				// 数据流方向，向内( 0 ) 或向外 ( 1 )
//				if (condition.getDirection() != null) {
//					if (condition.getDirection() == true) {
//						criteria.add(Restrictions.eq("direction", 0));
//					} else {
//						criteria.add(Restrictions.eq("direction", 1));
//					}
//				}

				// 按起始日期时间和结束日期时间查询
				System.out.println("------查询前的-bureauId-------" + condition.getBureauId());
				System.out.println("------查询前的-时间-------" + condition.getStarttime() + "---" + condition.getEndtime());
				
				if (condition.getStarttime() != null && condition.getEndtime() != null) {
					criteria.add(Restrictions.between("eventTime", condition.getStarttime(),
							condition.getEndtime()));
				} else if (condition.getStarttime() != null) {
					criteria.add(Restrictions.ge("eventTime", condition.getStarttime()));
				} else if (condition.getEndtime() != null) {
					criteria.add(Restrictions.le("eventTime", condition.getEndtime()));
				}

				// 事件类型条件查询
				if (condition.getEvent_type() != null
						&& condition.getEvent_type().trim().length() > 0) {
					criteria.add(Restrictions.eq("eventType", condition
							.getEvent_type()));
				}

				// 安全设备IP查询
				if (condition.getFaci_ip() != null
						&& condition.getFaci_ip().trim().length() > 0) {
					criteria.add(Restrictions.eq("faciIp", condition.getFaci_ip()));
				}

				// 根据安全设备类型查询
				if (condition.getFaci_type() != null
						&& condition.getFaci_type().trim().length() > 0) {
					criteria
							.add(Restrictions.eq("faciType", condition.getFaci_type()));
				}
				//总记录数
				int totalCount = (Integer) criteria.setProjection(
						Projections.rowCount()).uniqueResult();
				if (totalCount == 0) {
					page.setTotalPage(1);
					res.setPage(page);
					res.setStatus(Status.NORESULT);
					return res;
				}
				criteria.setProjection(null);
				int startIndex = page.getEveryPage() * (page.getCurrentPage() - 1);
				p.setBeginIndex(startIndex + 1);
				criteria.setFirstResult(startIndex);
				criteria.setMaxResults(page.getEveryPage());
				criteria.addOrder(Order.desc("eventTime"));
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
					List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
					for(Domain d:managerBo){
						if(d.getId().equals(bureauId)){
							criteria.add(Restrictions.eq("domain", d));
						}
					}
				}
				if (starttime != null && endtime != null) {
					criteria.add(Restrictions.between("eventTime", starttime, endtime));
				} else if (starttime != null) {
					criteria.add(Restrictions.ge("eventTime", starttime));
				} else if (endtime != null) {
					criteria.add(Restrictions.le("eventTime", endtime));
				}
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.groupProperty("eventType"));
				projectionList.add(Projections.rowCount(),"eventType");
				criteria.setProjection(projectionList);
				criteria.addOrder(Order.desc("eventType"));
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
					List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
					for(Domain d:managerBo){
						if(d.getId().equals(bureauId)){
							criteria.add(Restrictions.eq("domain", d));
						}
					}
				}
				if (starttime != null && endtime != null) {
					criteria.add(Restrictions.between("eventTime", starttime, endtime));
				} else if (starttime != null) {
					criteria.add(Restrictions.ge("eventTime", starttime));
				} else if (endtime != null) {
					criteria.add(Restrictions.le("eventTime", endtime));
				}
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.groupProperty("faciType"));
				projectionList.add(Projections.rowCount(),"faciType");
				criteria.setProjection(projectionList);
				criteria.addOrder(Order.desc("faciType"));
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
		dc.setProjection(Projections.max("eventTime"));
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
					
						List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
//						for(Domain d:managerBo){
//							if(d.getId().equals(condition.getBureauId())){
//								criteria.add(Restrictions.eq("domain", d));
//							}
//						}
					
					criteria.add(Restrictions.in("domain", managerBo));
				}
				criteria.add(Restrictions.between("eventTime", starttime, endtime));
//				System.out.println(starttime.toString());
//				System.out.println(endtime.toString());
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.projectionList().add(Projections.property("id")).add(
						Projections.property("eventTime")));
				
				//源IP是否相同
				if (condition.isSrcip_same()) {
					projectionList.add(Projections.groupProperty("srcIp"));
				}else {
					projectionList.add(Projections.property("srcIp"));
				}
				
				//源端口
				projectionList.add(Projections.projectionList().add(
						Projections.property("srcPort")));
				
				//目的端口是否相同
				if (condition.isDestport_same()) {
					projectionList.add(Projections.groupProperty("destPort"));
				}else {
					projectionList.add(Projections.property("destPort"));
				}
				
				// 威胁等级,安全设备类型
				projectionList.add(Projections.projectionList().add(
						Projections.property("threRank")).add(
						Projections.property("faciType")));
				

				//事件类型是否相同
				if (condition.isEventtype_same()) {
					projectionList.add(Projections.groupProperty("eventType"));
				}else {
					projectionList.add(Projections.property("eventType"));
				}

				// 协议类型是否相同
				if (condition.isProtocol_same()) {
					projectionList.add(Projections.groupProperty("prot_type"));
				}else {
					projectionList.add(Projections.property("prot_type"));
				}
				
				
				//目的IP是否相同
				if (condition.isDestip_same()) {
					projectionList.add(Projections.groupProperty("destIp"));
				}else {
					projectionList.add(Projections.property("destIp"));
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
