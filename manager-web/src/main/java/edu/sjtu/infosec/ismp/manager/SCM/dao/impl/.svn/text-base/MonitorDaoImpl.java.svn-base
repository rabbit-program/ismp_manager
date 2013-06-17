package edu.sjtu.infosec.ismp.manager.SCM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.sjtu.infosec.ismp.manager.SCM.comm.BaseDaoHibernate;
import edu.sjtu.infosec.ismp.manager.SCM.dao.MonitorDao;
import edu.sjtu.infosec.ismp.manager.SCM.model.Monitor;
import edu.sjtu.infosec.ismp.security.Domain;

public class MonitorDaoImpl extends BaseDaoHibernate implements MonitorDao {
	
	@SuppressWarnings("unchecked")
	public List getMonitorList() {

		StringBuffer hql = new StringBuffer("from Monitor order by id ");
		return getHibernateTemplate().find(hql.toString());
	}

	@SuppressWarnings("unchecked")
	public List getMonitorList(int startResult, int maxResult) {
		String hql = "from Monitor order by id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List getMonitorListByDomain(List<Domain> userDomainList,int startResult, int maxResult) {
		
		if(null == userDomainList || userDomainList.size() <= 0){
			return null;
		}
		
		StringBuffer userDomainStr = new StringBuffer();
		
		///遍历userDomainList,将domain的id组成一个字符串
		for (int i = 0; i < userDomainList.size(); i++) {
			if(i != (userDomainList.size()-1)){
				userDomainStr.append(userDomainList.get(i).getId()).append(",");
			}else{
				userDomainStr.append(userDomainList.get(i).getId());
			}
		}
		
		StringBuffer hql = new StringBuffer("from Monitor a where 1=1 and a.domain.id in (" + userDomainStr + ") ");
		Query query = this.getSession().createQuery(hql.toString());
//		query.setString("userDomainStr", userDomainStr.toString());///cc?:不知道为什么在HQL中这种方式不可以，赋值错误
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		
		return query.list();
	}
	
	public void saveOrUpdateMonitor(Monitor monitor) {
		this.getHibernateTemplate().saveOrUpdate(monitor);
	}

	@SuppressWarnings("unchecked")
	public int getCount() {
		int num = 0;
		List list=getHibernateTemplate().find("from Monitor");
		if (null != list && list.size() > 0) {
			num = list.size();
		}
		return num;
	}

	public int getCountByDomain(List<Domain> userDomainList) {
		
		if(null == userDomainList || userDomainList.size() <= 0){
			return 0;
		}
		
		int num = 0;
		
		StringBuffer userDomainStr = new StringBuffer();
		
		///遍历userDomainList,将domain的id组成一个字符串
		for (int i = 0; i < userDomainList.size(); i++) {
			if(i != (userDomainList.size()-1)){
				userDomainStr.append(userDomainList.get(i).getId()).append(",");
			}else{
				userDomainStr.append(userDomainList.get(i).getId());
			}
		}
		
		StringBuffer hql = new StringBuffer("from Monitor a where 1=1 and a.domain.id in (" + userDomainStr + ") ");
		Query query = this.getSession().createQuery(hql.toString());
//		query.setString("userDomainStr", userDomainStr.toString());///cc?:不知道为什么在HQL中这种方式不可以，赋值错误
		
		if (null != query.list()&& query.list().size() > 0) {
			num = query.list().size();
		}
		return num;
	}

	public Monitor getMonitorByNodeId(Integer nodeId) {
		
		StringBuffer hql = new StringBuffer("from Monitor a where 1 = 1 and a.nodeId = :nodeId");
		Query query = this.getSession().createQuery(hql.toString());
		query.setInteger("nodeId", nodeId);
		Monitor monitor = null;
		if(null != query.list() && query.list().size() > 0){
			monitor = (Monitor) query.list().get(0);
		}
		return monitor;
	}

//	===========================================================
}
