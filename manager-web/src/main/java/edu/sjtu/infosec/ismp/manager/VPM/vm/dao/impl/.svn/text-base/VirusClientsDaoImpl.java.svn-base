package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusClientsDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 病毒客户端-数据库操作
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public class VirusClientsDaoImpl extends HibernateDaoSupport implements VirusClientsDao {

	public void addVirusClients(VirusClients virusClients) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusClients);
		
	}

	public void deleteVirusClients(VirusClients virusClients) throws Exception {
		getHibernateTemplate().delete(virusClients);
		
	}

	public void updateVirusClients(VirusClients virusClients) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusClients);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClients() throws Exception {
		List<VirusClients> list = getHibernateTemplate().loadAll(VirusClients.class);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByDepartment(Domain department)
			throws Exception {
		String hql = "from VirusClients vc where vc.department.id=" + department.getId();
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByDepartmentList(
			List<Domain> departmentList) throws Exception {
		String hql = "from VirusClients vc where 1=1 ";
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
//			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}

//		hql = hql + " order by vc.clientIP";
		
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByName(String name,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByNameAndDepartmentList(
			String name, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
//			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByRecordTime(
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "from VirusClients vc ";
		if(startRecordTime != null){
			hql = hql + " where vc.recordTime>='"+startRecordTime+"' ";
			if(endRecordTime != null){
				hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
			}
		}else{
			if(endRecordTime != null){
				hql = hql + " where vc.recordTime<='"+endRecordTime+"' ";
			}
		}
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByRecordTimeAndDepartmentList(
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "from VirusClients vc ";
		boolean isWhere = false;
		if(startRecordTime != null){
			isWhere = true;
			hql = hql + " where vc.recordTime>='"+startRecordTime+"' ";
			if(endRecordTime != null){
				hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
			}
		}else{
			if(endRecordTime != null){
				isWhere = true;
				hql = hql + " where vc.recordTime<='"+endRecordTime+"' ";
			}
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				if(isWhere){
					hql = hql + " and (";
				}else{
					hql = hql + " where (";
				}
				hql = hql + " vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
//			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
//		System.out.println("查询语句：="+hql);
		List<VirusClients> list = getHibernateTemplate().find(hql);
//		System.out.println("----------------------------"+list.size());
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findVirusClientsByClientId(String clientID,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "from VirusClients vc where vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findVirusClientsByClientIdAndDepartmentList(
			String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "from VirusClients vc where vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
//			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByNameAndClientId(String name,
			String clientID, Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "' and vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByNameAndClientIdAndDepartmentList(
			String name, String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "' and vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
//			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	public VirusClients findVirusClientsById(int id) throws Exception {
		VirusClients virusClients = (VirusClients)getHibernateTemplate().get(VirusClients.class, id);
		return virusClients;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByDepartmentListExceptUnknow(
			List<Domain> departmentList) throws Exception {
		String hql = "from VirusClients vc where 1=1 ";
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
//			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<VirusClients> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClients(int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusClients order by department,clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByDepartment(
			Domain department, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusClients vc where vc.department.id=" + department.getId() + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByDepartmentList(
			List<Domain> departmentList, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusClients vc where 1=1 ";
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByDepartmentListExceptUnknow(
			List<Domain> departmentList, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusClients vc where 1=1 ";
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
//			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByName(String name,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByNameAndClientId(String name,
			String clientID, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "' and vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByNameAndClientIdAndDepartmentList(
			String name, String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "' and vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByNameAndDepartmentList(
			String name, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByRecordTime(
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusClients vc ";
		if(startRecordTime != null){
			hql = hql + " where vc.recordTime>='"+startRecordTime+"' ";
			if(endRecordTime != null){
				hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
			}
		}else{
			if(endRecordTime != null){
				hql = hql + " where vc.recordTime<='"+endRecordTime+"' ";
			}
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByRecordTimeAndDepartmentList(
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusClients vc ";
		boolean isWhere = false;
		if(startRecordTime != null){
			isWhere = true;
			hql = hql + " where vc.recordTime>='"+startRecordTime+"' ";
			if(endRecordTime != null){
				hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
			}
		}else{
			if(endRecordTime != null){
				isWhere = true;
				hql = hql + " where vc.recordTime<='"+endRecordTime+"' ";
			}
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				if(isWhere){
					hql = hql + " and (";
				}else{
					hql = hql + " where (";
				}
				hql = hql + " vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findVirusClientsByClientId(String clientID,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusClients vc where vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findVirusClientsByClientIdAndDepartmentList(
			String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusClients vc where vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from VirusClients";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDepartment(Domain department)
			throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.department.id=" + department.getId();
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDepartmentList(List<Domain> departmentList)
			throws Exception {
		String hql = "select count(id) from VirusClients vc where 1=1 ";
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDepartmentListExceptUnknow(
			List<Domain> departmentList) throws Exception {
		String hql = "select count(id) from VirusClients vc where 1=1 ";
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
//			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByClientId(String clientID,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByClientIdAndDepartmentList(String clientID,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByName(String name, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.name=" + "'" + name + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByNameAndDepartmentList(String name,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.name=" + "'" + name + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByNameAndClientId(String name, String clientID,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.name=" + "'" + name + "' and vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByNameAndClientIdAndDepartmentList(String name,
			String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.name=" + "'" + name + "' and vc.clientID=" + "'" + clientID + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByRecordTime(Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusClients vc ";
		if(startRecordTime != null){
			hql = hql + " where vc.recordTime>='"+startRecordTime+"' ";
			if(endRecordTime != null){
				hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
			}
		}else{
			if(endRecordTime != null){
				hql = hql + " where vc.recordTime<='"+endRecordTime+"' ";
			}
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByRecordTimeAndDepartmentList(
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusClients vc ";
		boolean isWhere = false;
		if(startRecordTime != null){
			isWhere = true;
			hql = hql + " where vc.recordTime>='"+startRecordTime+"' ";
			if(endRecordTime != null){
				hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
			}
		}else{
			if(endRecordTime != null){
				isWhere = true;
				hql = hql + " where vc.recordTime<='"+endRecordTime+"' ";
			}
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				if(isWhere){
					hql = hql + " and (";
				}else{
					hql = hql + " where (";
				}
				hql = hql + " vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	/**
	 *  病毒客户端的查询方法------多条件查询-添加（客户端IP）查询用法到的方法
	 *  
	 *  2010-06-30
	 */
	@SuppressWarnings("unchecked")
	public long findAllNumByClientIPAndDepartmentList(String clientIP,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.clientIP=" + "'" + clientIP + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByClientIdAndDepartmentList(String clientID,
			String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.clientID=" + "'" + clientID + "'and vc.clientIP=" + "'" + clientIP + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByNameAndClientIdAndDepartmentList(String name,
			String clientID, String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.name=" + "'" + name + "' and vc.clientID=" + "'" + clientID + "'and vc.clientIP=" + "'" + clientIP + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByNameAndDepartmentList(String name, String clientIP,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusClients vc where vc.name=" + "'" + name + "'and vc.clientIP=" +"'"+ clientIP + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByClientIPAndDepartmentList(
			String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusClients vc where vc.clientIP=" + "'" + clientIP + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByNameAndClientIdAndDepartmentList(
			String name, String clientID, String clientIP,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "' and vc.clientID=" + "'" + clientID + "'and vc.clientIP=" + "'" + clientIP + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findAllVirusClientsByNameAndDepartmentList(
			String name, String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusClients vc where vc.name=" + "'" + name + "'and vc.clientIP=" + "'" + clientIP + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusClients> findVirusClientsByClientIdAndDepartmentList(
			String clientID, String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusClients vc where vc.clientID=" + "'" + clientID + "'and vc.clientIP=" + "'" + clientIP + "'";
		if(startRecordTime != null){
			hql = hql + " and vc.recordTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vc.recordTime<='"+endRecordTime+"' ";
		}
		int i = 0;
		for(Domain dep : departmentList){
			if(i == 0){
				hql = hql + " and (vc.department.id=" + dep.getId();
			}
			if(i > 0){
				hql = hql + " or vc.department.id=" + dep.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + " or vc.department.id is null";
			hql = hql + ") ";
		}
		hql = hql + " order by vc.department,vc.clientIP";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusClients> list = query.list();
		return list;
	}

	
	/**
	 * 获取查询对象
	 * @return
	 */
	private Criteria getCriteria()
	{
		Session session = this.getSession();
		Criteria criteria= session.createCriteria(VirusClients.class);
		releaseSession(session);
		return criteria;
	}
	public LinkedList<Object> queryAllVirusClients(List<Domain> departmentList,VirusClients virusClients,
			int startResult, int maxResult, Date startRecordTime,
			Date endRecordTime) {
		Criteria criteria = getCriteria();
		findByVirusClients(criteria,virusClients,departmentList);
		findByVirusClientsDate(criteria,startRecordTime,endRecordTime,"recordTime");	
		return queryVirusClientsPage(criteria,startResult,maxResult);
	}
	private void findByVirusClients(Criteria criteria,VirusClients virusClients,List<Domain> departmentList){
		if(HtmlFactory.isNotEmpty(virusClients.getName())){
			criteria.add(Restrictions.like("name", "%"+virusClients.getName()+"%"));
		}
		if(HtmlFactory.isNotEmpty(virusClients.getClientID())){
			criteria.add(Restrictions.like("clientID", "%"+virusClients.getClientID()+"%"));
		}
		if(HtmlFactory.isNotEmpty(virusClients.getClientIP())){
			criteria.add(Restrictions.like("clientIP", "%"+virusClients.getClientIP()+"%"));
		}
		criteria.add( departmentList == null || departmentList.isEmpty() ? Restrictions.eq("department", null) : Restrictions.in("department", departmentList));
	}
	private void findByVirusClientsDate(Criteria criteria, Date startDate,Date endDate,String date)
	{
			if(!(startDate==null) && !(endDate == null))
			{
				criteria.add(Restrictions.ge(date, startDate)).add(Restrictions.le(date, endDate));
			}
			if(!(startDate == null) && endDate == null)
			{
				criteria.add(Restrictions.ge(date, startDate)).add(Restrictions.le(date, new Date()));
			}
			if(startDate == null && !(endDate == null))
			{
				criteria.add(Restrictions.le(date, endDate));
			}
	}
	@SuppressWarnings("unchecked")
	private LinkedList<Object> queryVirusClientsPage(Criteria criteria,Integer startResult, Integer maxResult)
	{
		criteria.setProjection(Projections.rowCount());	
		Object objCount = (Integer)criteria.uniqueResult();
		criteria.setFirstResult(startResult);
		criteria.setMaxResults(maxResult);
		criteria.setProjection(null);
		List iters = criteria.list();
		List<Object> list = new ArrayList<Object>();
		synchronized (list) {
			for(Iterator iter = iters.iterator();iter.hasNext();){
				Object[] obj = (Object[]) iter.next();
				list.add(obj[4]);
			}
		}
		LinkedList<Object> linkList = new LinkedList<Object>();
		linkList.addFirst(objCount);
		linkList.addLast(list); 
		return linkList;
	}

	public VirusClients getVirusClientsById(Integer vcid) {
		return (VirusClients)getHibernateTemplate().get(VirusClients.class, vcid);
	}

	public boolean delQueryVirusClientsById(Integer vcid) {
		try {
			getHibernateTemplate().delete(getVirusClientsById(vcid));
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

}
