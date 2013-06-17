package edu.sjtu.infosec.ismp.manager.EM.dao.impl;

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
import org.infosec.ismp.manager.rmi.tm.manager.model.DomainEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventGetTopoDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.Status;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventGetTopoCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventGetTopoResult;
import edu.sjtu.infosec.ismp.manager.EM.util.PageUtil;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;

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
		String hql = "select tp.ipAddress,tp.netCardCode,tp.name,tp.domain,mb.domainName " +
				"from NodeEntity tp,Domain mb where tp.domain.id = mb.id and tp.ipAddress is not null";// and tp.netCardCode is not null ";
		List<Object> list = getHibernateTemplate().find(hql);
		String hql1 = "select ad.ip,ad.priority from  AssetDeviceBO ad where ad.ip is not null";
		List<Object> list1 = getHibernateTemplate().find(hql1);
		if (list.size() > 0) {
			boolean istrue = false;
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				for (int j = 0; j < list1.size(); j++) {
					Object[] temp = (Object[]) list1.get(j);
					if (obj[0].toString().trim().equals(
							temp[0].toString().trim())) {
						if (temp[1] != null) {
							Object[] oo = new Object[7];
							oo[0] = obj[0];
							oo[1] = obj[1];
							oo[2] = obj[2];
							oo[3] = temp[1];
							oo[4] = 1;
							oo[5] = obj[3];
							oo[6] = obj[4];
							list2.add(oo);
						} else {
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
						istrue = true;
					}
				}
				if (istrue == false) {
					Object[] oo = new Object[7];
					oo[0] = obj[0];
					oo[1] = obj[1];
					oo[2] = obj[2];
					oo[3] = 1;
					oo[4] = 1;
					oo[5] = obj[3];
					oo[6] = obj[4];
					list2.add(oo);
				} else {
					istrue = false;
				}

			}
		}
		return list2;
	}

	/**
	 * 分页获取TOPO设备IP和MAC地址和设备名
	 * 
	 * @return
	 */
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
							List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
							List<DomainEntity> domainList = new ArrayList<DomainEntity>();
							for(Domain d:managerBo){
								Integer[] bureauId = condition.getBureauId();
								for(int i=0;i<bureauId.length;i++){
									if(d.getId().equals(bureauId[i])){
										DomainEntity de = new DomainEntity();
										
										de.setId(d.getId());
										de.setDomainName(d.getDomainName());
										de.setDescription(d.getDescription());
										
//										try {
//											BeanUtils.copyProperties(de,d);
//											
//										} catch (IllegalAccessException e) {
//											// TODO Auto-generated catch block
//											e.printStackTrace();
//										} catch (InvocationTargetException e) {
//											// TODO Auto-generated catch block
//											e.printStackTrace();
//										}
										domainList.add(de);
									}
								}
							}
							criteria.add(Restrictions.in("domain", domainList));
						}
						if (condition.getNetCardCodes() != null
								&& condition.getNetCardCodes().length > 0) {
							criteria.add(Restrictions.in("ipAddress", condition
									.getNetCardCodes()));
						}
						criteria.add(Restrictions.isNotNull("ipAddress"));
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
								Projections.property("ipAddress")).add(
								Projections.property("netCardCode")).add(
								Projections.property("name")).add(
								Projections.property("domain")));
						criteria.setProjection(projectionList);
						criteria.addOrder(Order.asc("domain"));
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
		String hql = "select c.domainName as viewName, sum(b.currValue)  as total_value	"
				+ "from NodeEntity a, Eventmoni b, DomainEntity c "
				+ "where a.ipAddress=b.faciIp and a.domain.id=c.id "
				+ "and b.time between ? and ? ";
		if (bureauId!=null && bureauId > 0) {
			hql = hql + " and b.domain.id=? ";
			obj = new Object[] { starttime, endtime, bureauId};
		}
		hql = hql + " group by a.domain.id";
		List<Object> list = getHibernateTemplate().find(hql, obj);
		return list;
	}
	
	public NodeEntity queryByIpBureauId(final String ip,final Integer bureauId) {
		return (NodeEntity) getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Criteria criteria = session
								.createCriteria(NodeEntity.class);
						criteria.add(Restrictions.eq("ipAddress", ip));
						
						if (bureauId != null) {
							List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
							DomainEntity de = new DomainEntity();
							for(Domain d:managerBo){
									if(d.getId().equals(bureauId)){
										
										de.setId(d.getId());
										de.setDomainName(d.getDomainName());
										de.setDescription(d.getDescription());
//										try {
//											BeanUtils.copyProperties(de,d);
//										} catch (IllegalAccessException e) {
//											// TODO Auto-generated catch block
//											e.printStackTrace();
//										} catch (InvocationTargetException e) {
//											// TODO Auto-generated catch block
//											e.printStackTrace();
//										}
									}
							}
							criteria.add(Restrictions.eq("domain", de));
							
//							ProjectionList projectionList = Projections
//							.projectionList();
//					projectionList.add(Projections.projectionList().add(
//							Projections.property("ipAddress")).add(
//							Projections.property("netCardCode")).add(
//							Projections.property("name")).add(
//							Projections.property("domain")));
//					criteria.setProjection(projectionList);
						}
						NodeEntity res = (NodeEntity) criteria.list().get(0);
						return res;
					}
				});
	}

}
