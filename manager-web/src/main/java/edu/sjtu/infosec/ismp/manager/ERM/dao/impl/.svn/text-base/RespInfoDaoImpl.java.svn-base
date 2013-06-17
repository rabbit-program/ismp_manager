package edu.sjtu.infosec.ismp.manager.ERM.dao.impl;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.ERM.dao.RespInfoDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespFilePrint;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.DomainDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.impl.DomainDaoImpl;
import edu.sjtu.infosec.ismp.security.Domain;

public class RespInfoDaoImpl extends HibernateDaoSupport implements RespInfoDao {

	public void add(RespInfoBO respInfo) throws Exception {
		getHibernateTemplate().saveOrUpdate(respInfo);
	}

	public void delete(RespInfoBO respInfo) throws Exception {
		getHibernateTemplate().delete(respInfo);
	}

	public void update(RespInfoBO respInfo) throws Exception {
		getHibernateTemplate().saveOrUpdate(respInfo);
		getHibernateTemplate().flush();
	}

	public List<RespInfoBO> findAll() throws Exception {
		List<RespInfoBO> list = getHibernateTemplate().loadAll(RespInfoBO.class);
		return list;
	}

	public RespInfoBO findrespInfoById(int id) {
		RespInfoBO respInfo = (RespInfoBO)getHibernateTemplate().get(RespInfoBO.class, id);
		return respInfo;
	}

	@SuppressWarnings("unchecked")
	public List<RespInfoBO> findAllByDomain(List<Domain> domainList)
			throws Exception {
		String hql = "from RespInfoBO ri where 1=1 ";
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ri.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ri.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by ri.updateTime,ri.domain.id";
		
		List<RespInfoBO> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult,int id,Domain domain,String respname,String sysname,String updatetime) throws Exception {
		Criteria criteria=this.getSession().createCriteria(RespInfoBO.class);
		if(null!=startRecordTime)
		{
			criteria.add(Restrictions.eq("updateTime", startRecordTime));
		}
		if(null!=endRecordTime)
		{
			criteria.add(Restrictions.eq("updateTime", endRecordTime));
		}
		if(-1!=id)
		{
				criteria.add(Restrictions.eq("domain",domain) );
		}
		if(null!=respname && !"".equals(respname))
		{
			criteria.add(Restrictions.eq("name", respname));
		}
		if(null!=sysname && !"".equals(sysname))
		{
			criteria.add(Restrictions.eq("sysName", sysname));
		}
		if(null!=updatetime && !"".equals(updatetime))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String startTime = updatetime + " 00:00:00" ;
			String endTime = updatetime + " 23:59:59" ;
			java.sql.Date tempStartDate = new java.sql.Date(sdf.parse(startTime).getTime());
			java.sql.Date tempEndDate = new java.sql.Date(sdf.parse(endTime).getTime());
			criteria.add(Restrictions.ge("updateTime", tempStartDate));
			criteria.add(Restrictions.le("updateTime", tempEndDate));
		}
		criteria.add(Restrictions.in("domain",domainList));
		criteria.setFirstResult(startResult);
		criteria.setMaxResults(maxResult);
		criteria.addOrder(Order.desc("updateTime"));
		return (List<RespInfoBO>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,int id,String respname,String sysname,String updatetime)
			throws Exception {
		String hql = "select count(id) from RespInfoBO ri where 1=1 ";
		
		if(startRecordTime != null&&!"".equals(startRecordTime)){
			hql = hql + " and ri.updateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null&&!"".equals(endRecordTime)){
			hql = hql + " and ri.updateTime<='"+endRecordTime+"' ";
		}
		
		if(respname!=null&&!"".equals(respname)){
			hql = hql +" and ri.name='"+respname+"'";
		}
		if(sysname!=null&&!"".equals(sysname)){
			hql = hql +" and ri.sysName='"+sysname+"'";
		}
		if(updatetime!=null&&!"".equals(updatetime)){
			/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String startTime = updatetime + " 00:00:00" ;
			java.util.Date tempStartDate = new java.sql.Date(sdf.parse(startTime).getTime());
			*/
			hql = hql +" and ri.updateTime like '%"+updatetime+"%'";
		}
		
		if(id==-1){
			int i = 0;
			for(Domain domain : domainList){
				if(i == 0){
					hql = hql + " and (ri.domain.id=" + domain.getId();
				}
				if(i > 0){
					hql = hql + " or ri.domain.id=" + domain.getId();
				}
				i++;
			}
			if(i > 0){
				hql = hql + ") ";
			}
		}else if(id>0){
			hql = hql + " and ri.domain ="+id;
		}/*else if(id==-2){
			hql = hql + " and ri.domain ="+null;
		}*/
		
		//System.out.println("findAllNumByDomain"+hql);
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List<RespInfoBO> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult,
			int id,Domain domain,String respname,String sysname,String updatetime)
			throws Exception {
		Criteria criteria=this.getSession().createCriteria(RespInfoBO.class);
		if(null!=startRecordTime)
		{
			criteria.add(Expression.eq("updateTime", startRecordTime));
		}
		if(null!=endRecordTime)
		{
			criteria.add(Expression.eq("updateTime", endRecordTime));
		}
		if(0!=id && -1!=id)
		{
			if(id==-2)
			{
				criteria.add(Expression.isNull("domain"));
			}else
			{
				criteria.add(Expression.eq("domain", domain));
			}
		}
		if(null!=respname && !"".equals(respname))
		{
			criteria.add(Expression.eq("name", respname));
		}
		if(null!=sysname && !"".equals(sysname))
		{
			criteria.add(Expression.eq("sysName", sysname));
		}
		if(null!=updatetime && !"".equals(updatetime))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String startTime = updatetime + " 00:00:00" ;
			String endTime = updatetime + " 23:59:59" ;
			java.sql.Date tempStartDate = new java.sql.Date(sdf.parse(startTime).getTime());
			java.sql.Date tempEndDate = new java.sql.Date(sdf.parse(endTime).getTime());
			
//			criteria.add(Restrictions.like("updateTime", "%"+updatetime+"%"));
			criteria.add(Restrictions.ge("updateTime", tempStartDate));
			criteria.add(Restrictions.le("updateTime", tempEndDate));
		}
		criteria.setFirstResult(startResult);
		criteria.setMaxResults(maxResult);
		criteria.addOrder(Order.desc("updateTime"));
		List<RespInfoBO> list=(List<RespInfoBO>)criteria.list();
		return list;

	}
	
	
	@SuppressWarnings("unchecked")
	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime,int id,String respname,String sysname,String updatetime)
			throws Exception {
		String hql = "select count(id) from RespInfoBO ri where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ri.updateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ri.updateTime<='"+endRecordTime+"' ";
		}
		if(respname!=null&&!"".equals(respname)){
			hql = hql +" and ri.name='"+respname+"'";
		}
		if(sysname!=null&&!"".equals(sysname)){
			hql = hql +" and ri.sysName='"+sysname+"'";
		}
		if(updatetime!=null&&!"".equals(updatetime)){
			hql = hql +" and ri.updateTime like '%"+updatetime+"%'";
		}
		if(id>0){
			hql = hql + " and ri.domain ="+id;
		}else if(id==-2){
			hql = hql + " and ri.domain is null";
		}
		//System.out.println("===findAllNum===="+hql);
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	public List<RespFilePrint> findFileContentById(RespInfoBO id) {
		Query query=this.getSession().createQuery("from RespFilePrint r where r.respInfo=:id");
		query.setEntity("id", id);
		return (List<RespFilePrint>)query.list();
	}

	public void saveorupdate(RespFilePrint file) {
		this.getSession().saveOrUpdate(file);
	}

	public void deleteFileByRespInfo(RespInfoBO resp) {
		String hql = "delete from RespFilePrint c where c.respInfo=:resp";
		Query query = this.getSession().createQuery(hql);
		query.setEntity("resp", resp);
		query.executeUpdate();
	}
	

}
