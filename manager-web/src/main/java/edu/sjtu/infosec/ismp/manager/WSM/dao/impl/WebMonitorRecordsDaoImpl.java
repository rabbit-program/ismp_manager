package edu.sjtu.infosec.ismp.manager.WSM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.WSM.dao.WebMonitorRecordsDao;
import edu.sjtu.infosec.ismp.manager.WSM.model.WebMonitorRecords;
import edu.sjtu.infosec.ismp.security.Domain;

public class WebMonitorRecordsDaoImpl extends HibernateDaoSupport implements WebMonitorRecordsDao {

	@SuppressWarnings("unchecked")
	public List<WebMonitorRecords> findAll(int startResult, int maxResult) {
		Criteria criteria = getSession().createCriteria(WebMonitorRecords.class, "webMonitor")
														.addOrder(Order.asc("id"))
														.setFirstResult(startResult)
														.setMaxResults(maxResult);
		return criteria.list();
	}

	
	@SuppressWarnings("unchecked")
	public WebMonitorRecords findById(Integer id) {
		WebMonitorRecords webMonitorRecords = null;
	        List webMonitorList = getHibernateTemplate().find("from WebMonitorRecords  where id = "+id);
	        if(webMonitorList!=null && webMonitorList.size()>0) {
	        	webMonitorRecords = (WebMonitorRecords) webMonitorList.get(0);
	        }
	    return webMonitorRecords;
	}

	public void remove(WebMonitorRecords webMonitorRecords) {
		getHibernateTemplate().delete(webMonitorRecords);
	}

	public void remove(List<WebMonitorRecords> webMonitorList) {
        getHibernateTemplate().deleteAll(webMonitorList);
	}

	public void saveOrUpdate(WebMonitorRecords webMonitorRecords) {
		getHibernateTemplate().saveOrUpdate(webMonitorRecords);
	}


	@SuppressWarnings("unchecked")
	public int getCount() {
		int num=0;
		List list=getHibernateTemplate().find("from WebMonitorRecords");
		if(list!=null&&list.size()>0){
			num=list.size();
		}
		return num;
	}


	@SuppressWarnings({ "unchecked" })
	public List<WebMonitorRecords> findAllByDomain(List<Domain> userDomainList,
			int startResult, int maxResult) {
		Criteria criteria = getSession().createCriteria(WebMonitorRecords.class, "webMonitor")
												.addOrder(Order.asc("id"))
												.setFirstResult(startResult)
												.setMaxResults(maxResult);
		if(userDomainList!=null){
			criteria.add(Restrictions.in("webMonitor.domain", userDomainList));
		}
		return criteria.list();
	}


	public int getCountByDomain(List<Domain> userDomainList) {
		Criteria criteria = getSession().createCriteria(WebMonitorRecords.class, "webMonitor")
															.addOrder(Order.asc("id"));
		if(userDomainList!=null){
			criteria.add(Restrictions.in("webMonitor.domain", userDomainList));
		}
		return criteria.list().size();
	}


	@SuppressWarnings("unchecked")
	public WebMonitorRecords findByNodeId(String nodeId) {
		WebMonitorRecords records=null;
		List list=getHibernateTemplate().find("from WebMonitorRecords where nodeId='"+nodeId+"'");
		if(list!=null&&list.size()>0){
			records=(WebMonitorRecords) list.get(0);
		}
		return records;
	}

}
