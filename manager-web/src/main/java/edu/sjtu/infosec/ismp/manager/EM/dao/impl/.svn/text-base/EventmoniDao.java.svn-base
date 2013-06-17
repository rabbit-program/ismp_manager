package edu.sjtu.infosec.ismp.manager.EM.dao.impl;

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
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventmoniDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.Status;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventmoniCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventmoniResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoni;
import edu.sjtu.infosec.ismp.manager.EM.util.PageUtil;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;

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

	}

	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void add(List<Eventmoni> data) {
		getHibernateTemplate().saveOrUpdateAll(data);
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
				
				if (condition.getBureauId()!=null && condition.getBureauId()>0){
					List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
					for(Domain d:managerBo){
						if(d.getId().equals(condition.getBureauId())){
							criteria.add(Restrictions.eq("domain", d));
						}
					}
				}

				// 通过设备名称为条件查询
				if (condition.getFaci_name() != null
						&& condition.getFaci_name().trim().length() > 0) {
					String str = condition.getFaci_name();
					criteria.add(Restrictions.like("faciName", "%" + str + "%"));
				}

				// 通过多个设备ID查询
				if (condition.getFaci_ids() != null
						&& condition.getFaci_ids().length > 0) {
					criteria.add(Restrictions.in("faciId", condition.getFaci_ids()));
				}
				
				if (condition.getFaci_ip()!=null && condition.getFaci_ip().length()>0) {
					criteria.add(Restrictions.eq("faciIp", condition.getFaci_ip()));
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
		String hql = "select a.deviceIp as ip, max(b.totalValue) as totalValue " +
		"from TopoManageDevice a, Eventmoni b "+
		"where a.nodeype=1 and a.deviceIp=b.faciIp " +
		"and b.time between ? and ? ";
		if (bureauId!=null && bureauId > 0) {
			hql = hql + " and b.domain=? ";
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
		String hql = "select faciIp as ip, max(totalValue)-min(totalValue) as totalValue " +
				"from Eventmoni where time between ? and ? ";
		if (bureauId!=null && bureauId > 0) {
			hql = hql + " and domain=" + bureauId;
		}
		hql = hql +  " group by faciIp order by max(totalValue)-min(totalValue) desc ";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, starttime);
		query.setParameter(1, endtime);
//		query.setParameter(2, bureauId);
//		if (bureauId!=null && bureauId > 0) {
//			query.setParameter(2, bureauId);
//		}
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
		System.out.println(" faci_ip " +  faci_ip + "   bureauId " + bureauId);
		return getHibernateTemplate().executeFind(new HibernateCallback(){
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(org.infosec.ismp.manager.rmi.event.modle.Eventmoni.class);
				if (bureauId!=null){
					criteria.add(Restrictions.eq("domain", bureauId));
				}
				criteria.add(Restrictions.eq("faciIp", faci_ip));
				ProjectionList proList = Projections.projectionList();
		        proList.add(Projections.groupProperty("time"));   
		        proList.add(Projections.groupProperty("currValue"));  
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
				Projections.property("faciIp")).add(
				Projections.property("totalValue")).add(Projections.property("domain")));
		List<Object> res = getHibernateTemplate().findByCriteria(query);
		return res;
	}

}
