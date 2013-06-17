package edu.sjtu.infosec.ismp.manager.BSAM.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDaoHibernate;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineCabinetDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineCabinet;
import edu.sjtu.infosec.ismp.security.Domain;

public class MachineCabinetDaoImpl extends BaseDaoHibernate implements MachineCabinetDao {
	
	@SuppressWarnings("unchecked")
	public List getMachineCabinetList() {
		StringBuffer hql = new StringBuffer("from MachineCabinet");
		return getHibernateTemplate().find(hql.toString());
		
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineCabinetList(int startResult, int maxResult) {
		String hql = "from MachineCabinet order by id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineCabinetListByDomain(List<Domain> userDomainList,int startResult, int maxResult) {
		
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
		
		StringBuffer hql = new StringBuffer("from MachineCabinet a where 1=1 and a.machineRoom.domain.id in (" + userDomainStr + ") ");
		Query query = this.getSession().createQuery(hql.toString());
		
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineCabinetListByDomain(List<Domain> userDomainList) {
		
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
		
		StringBuffer hql = new StringBuffer("from MachineCabinet a where 1=1 and a.machineRoom.domain.id in (" + userDomainStr + ") ");
		Query query = this.getSession().createQuery(hql.toString());
		
		return query.list();
	}
	
	public void saveOrUpdateMachineCabinet(MachineCabinet machineCabinet) {
		getHibernateTemplate().saveOrUpdate(machineCabinet);
	}

	@SuppressWarnings("unchecked")
	public int getCount() {
		int num=0;
		List list=getHibernateTemplate().find("from MachineCabinet");
		if (null != list && list.size() > 0) {
			num = list.size();
		}
		return num;
	}

	public int getCountByDomain(List<Domain> userDomainList) {
		if(null == userDomainList || userDomainList.size() <= 0){
			return 0;
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
		
		StringBuffer hql = new StringBuffer("from MachineCabinet a where 1=1 and a.machineRoom.domain.id in (" + userDomainStr + ") ");
		Query query = this.getSession().createQuery(hql.toString());
		
		int num = 0;
		if (null != query.list()&& query.list().size() > 0) {
			num = query.list().size();
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id, int startResult, int maxResult) {
		StringBuffer hql = new StringBuffer("from Machine a where 1=1 ");
		hql.append(" and a.machineCabinet.id = ");
		hql.append(id);
		hql.append(" order by a.id");
		
		Session session = this.getSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id) {
		StringBuffer hql = new StringBuffer("from Machine a where 1=1 ");
		hql.append(" and a.machineCabinet.id = ");
		hql.append(id);
		hql.append(" order by a.id");
		
		Session session = this.getSession();
		Query query = session.createQuery(hql.toString());
		return query.list();
	}

	public int getSubUnitCountById(String id) {
		StringBuffer hql = new StringBuffer("from Machine a where 1=1 ");
		hql.append(" and a.machineCabinet.id = ");
		hql.append(id);
		hql.append(" order by a.id");
		Session session = this.getSession();
		Query query = session.createQuery(hql.toString());
		int num = 0;
		if (null != query.list()&& query.list().size() > 0) {
			num = query.list().size();
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List<MachineCabinet> getMachineCabinetByName(String name) {
		StringBuffer hql = new StringBuffer("from MachineCabinet a where 1=1 and a.machineCabinetName = :name ");
		
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("name", name);
		return query.list();
	}
	
}
