package org.infosec.ismp.manager.rmi.event.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.rmi.event.dao.IEventGetTopoDao;
import org.infosec.ismp.manager.rmi.event.dao.Status;
import org.infosec.ismp.manager.rmi.event.dao.queryCondition.EventGetTopoCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryResult.EventGetTopoResult;
import org.infosec.ismp.manager.rmi.event.util.Page;
import org.infosec.ismp.manager.rmi.event.util.PageUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 从拓朴数据库取数据
 * 
 * @author wudengke 2009-6-29
 * 
 */
public class EventGetTopoDao extends HibernateDaoSupport implements
		IEventGetTopoDao {

	/**
	 * 获取TOPO设备IP和MAC地址和设备名
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> getTopoInfo() {
		List<Object> list2 = new ArrayList<Object>();
		String hql = "select tp.ipAddress,tp.netCardCode,tp.name,tp.domain.id,tp.domain.domainName " +
			"from NodeEntity tp where tp.ipAddress is not null";// and tp.netCardCode is not null ";
		List<Object> list = getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
							Object[] oo = new Object[7];
							oo[0] = obj[0];
							oo[1] = obj[1];
							oo[2] = obj[2];
							oo[3] = 1;
							oo[4] = 1;
							oo[5] = obj[3];
							oo[6] = obj[4];
							list2.add(oo);
					}
				}
		
		return list2;
	}

	/**
	 * 分页获取TOPO设备IP和MAC地址和设备名
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EventGetTopoResult getTopoInfo(final EventGetTopoCondition condition) {

		return (EventGetTopoResult) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						EventGetTopoResult res = new EventGetTopoResult();
						Page page = condition.getPage();
						Criteria criteria = session
								.createCriteria(NodeEntity.class);
						if (condition.getBureauId() != null
								&& condition.getBureauId().length > 0) {
							criteria.add(Restrictions.in("bureauId", condition
									.getBureauId()));
						}
						if (condition.getNetCardCodes() != null
								&& condition.getNetCardCodes().length > 0) {
							criteria.add(Restrictions.in("deviceIp", condition
									.getNetCardCodes()));
						}
						criteria.add(Restrictions.isNotNull("deviceIp"));
						// criteria.add(Restrictions.isNotNull("netCardCode"));
						int totalCount = ((Integer) criteria.setProjection(
								Projections.rowCount()).uniqueResult())
								.intValue();
						if (totalCount == 0) {
							res.setStatus(Status.NORESULT);
							return res;
						}
						criteria.setProjection(null);
						int startIndex = page.getEveryPage()
								* (page.getCurrentPage() - 1);
						criteria.setFirstResult(startIndex);
						criteria.setMaxResults(page.getEveryPage());
						Page p = PageUtil.createPage(page.getEveryPage(), page
								.getCurrentPage(), totalCount);
						ProjectionList projectionList = Projections
								.projectionList();
						projectionList.add(Projections.projectionList().add(
								Projections.property("deviceIp")).add(
								Projections.property("netCardCode")).add(
								Projections.property("deviceName")).add(
								Projections.property("bureauId")));
						criteria.setProjection(projectionList);
						criteria.addOrder(Order.asc("bureauId"));
						res.setDatas(criteria.list());
						res.setPage(p);
						return res;
					}
				});

	}

	/**
	 * 统计域事件总量
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> StatisticsDomain(Timestamp starttime, Timestamp endtime,Integer bureauId) {
		Object[] obj = new Object[] { starttime, endtime };
		String hql = "select c.viewName as viewName, sum(b.curr_value)  as total_value	"
				+ "from TopoManageDevice a, Eventmoni b, TopoManageView c "
				+ "where a.nodeype=1 and a.deviceIp=b.faci_ip and a.parentViewId=c.viewId "
				+ "and b.time between ? and ? ";
		if (bureauId!=null && bureauId > 0) {
			hql = hql + " and b.bureauId=? ";
			obj = new Object[] { starttime, endtime, bureauId};
		}
		hql = hql + " group by a.parentViewId";
		List<Object> list = getHibernateTemplate().find(hql, obj);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public NodeEntity queryByIpBureauId(final String ip,final Integer bureauId) {
		return (NodeEntity) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(NodeEntity.class);
						criteria.add(Restrictions.eq("deviceIp", ip));
						criteria.add(Restrictions.eq("bureauId", bureauId));
						NodeEntity res = (NodeEntity) criteria.list().get(0);
						return res;
					}
				});
	}

}
