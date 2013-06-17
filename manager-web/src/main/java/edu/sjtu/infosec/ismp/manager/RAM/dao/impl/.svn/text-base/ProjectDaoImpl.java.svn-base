package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.ProjectDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.security.Domain;


/**
 * 数据层 测评项目Dao实现类.
 */
public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

    
    /**
     * 查询测评项目
     */
    public AsseInfoProj find(Integer projCode) {
    	Query query = this.getSession().createQuery("from AsseInfoProj ass where ass.id=:id ");
    	query.setInteger("id", projCode);
        return (AsseInfoProj) query.list().get(0);
    }

    /**
     * 删除测评项目信息
     */
    public void remove(AsseInfoProj project) {
        this.getHibernateTemplate().delete(project);
    }

    /**
     * 保存/更新测评项目信息
     */
    public void saveOrUpdate(AsseInfoProj project) {
    	this.getHibernateTemplate().saveOrUpdate(project);
    }

    /**
     * 查询测评项目分页记录
     */
	public List<AsseInfoProj> findAll(String asseBeginTime, String asseEndTime,int startResult, int maxResult, int offcpers, Domain domain,String assePers, String secuLeve) {
		List<AsseInfoProj> list=null;
		try {
			Criteria criteria=this.getSession().createCriteria(AsseInfoProj.class);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if(null!=asseBeginTime && !"".equals(asseBeginTime)){
				String startTime = asseBeginTime + " 00:00:00" ;
				java.sql.Date tempStartDate = new java.sql.Date(sdf.parse(startTime).getTime());
				criteria.add(Restrictions.ge("asseBeginTime", tempStartDate));
			}
			if(null!=asseEndTime&& !"".equals(asseEndTime)){
				String endTime = asseEndTime + " 24:00:00" ;
				java.sql.Date tempEndDate = new java.sql.Date(sdf.parse(endTime).getTime());
				criteria.add(Restrictions.le("asseEndTime", tempEndDate));
			}
			if(0!=offcpers && -1!=offcpers)
			{
				if(offcpers==-2)
				{
					criteria.add(Restrictions.isNull("domain"));
				}else{
					criteria.add(Restrictions.eq("domain", domain));
				}
			}
			if(null!=assePers && !"".equals(assePers)){
				criteria.add(Restrictions.like("assePers", "%"+assePers+"%"));
			}
			if(null!=secuLeve && !"".equals(secuLeve))
			{
				criteria.add(Restrictions.eq("secuLeve", secuLeve));
			}
				
			criteria.setFirstResult(startResult);
			criteria.setMaxResults(maxResult);
			criteria.addOrder(Order.desc("id"));
			list=(List<AsseInfoProj>)criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<AsseInfoProj> findAllByDomain(List<Domain> domainList,String asseBeginTime, String asseEndTime, int startResult,int maxResult, int offcpers, Domain domain, String assePers,String secuLeve) {
		List<AsseInfoProj> list=null;
		try {
			Criteria criteria=this.getSession().createCriteria(AsseInfoProj.class);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if(null!=asseBeginTime && !"".equals(asseBeginTime)){
				String startTime = asseBeginTime + " 00:00:00" ;
				java.sql.Date tempStartDate = new java.sql.Date(sdf.parse(startTime).getTime());
				criteria.add(Restrictions.ge("asseBeginTime", tempStartDate));
			}
			if(null!=asseEndTime&& !"".equals(asseEndTime)){
				String endTime = asseEndTime + " 24:00:00" ;
				java.sql.Date tempEndDate = new java.sql.Date(sdf.parse(endTime).getTime());
				criteria.add(Restrictions.le("asseEndTime", tempEndDate));
			}
			if(-1!=offcpers){
					criteria.add(Restrictions.eq("domain",domain) );
			}
			if(null!=assePers && !"".equals(assePers)){
				criteria.add(Restrictions.like("assePers", "%"+assePers+"%"));
			}
			if(null!=secuLeve && !"".equals(secuLeve))
			{
				criteria.add(Restrictions.eq("secuLeve", secuLeve));
			}
				
			criteria.add(Restrictions.in("domain",domainList));
			criteria.setFirstResult(startResult);
			criteria.setMaxResults(maxResult);
			criteria.addOrder(Order.desc("id"));
			list=(List<AsseInfoProj>)criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	  /**
     * 查询测评项目记录数  
     */
	public long findAllNum(String asseBeginTime, String asseEndTime,int offcpers, Domain domain, String assePers, String secuLeve) {
		String hql = "select count(id) from AsseInfoProj ri where 1=1  ";
		if(asseBeginTime != null){
			hql = hql + " and ri.asseBeginTime like '%"+asseBeginTime+"%' ";
		}
		if(asseEndTime != null){
			hql = hql + " and ri.asseEndTime like '%"+asseEndTime+"%' ";
		}
		if(assePers!=null&&!"".equals(assePers)){
			hql = hql +" and ri.assePers like '%"+assePers+"%' " ;
		}
		if(secuLeve!=null&&!"".equals(secuLeve)){
			hql = hql +" and ri.secuLeve='"+secuLeve+"' ";
		}
		
		if(offcpers>0){
			hql = hql + " and ri.domain ="+offcpers;
		}else if(offcpers==-2){
			hql = hql + " and ri.domain is null";
		}
		System.out.println("===findAllNum===="+hql);
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	public long findAllNumByDomain(List<Domain> domainList,String asseBeginTime, String asseEndTime, int offcpers,String assePers, String secuLeve) {
		String hql = "select count(id) from AsseInfoProj ri where 1=1 ";
		if(asseBeginTime != null){
			hql = hql + " and ri.asseBeginTime like '%"+asseBeginTime+"%'";
		}
		if(asseEndTime != null){
			hql = hql + " and ri.asseEndTime like '%"+asseEndTime+"%'";
		}
		if(assePers!=null&&!"".equals(assePers)){
			hql = hql +" and ri.assePers like '%"+assePers+"%'";
		}
		if(secuLeve!=null&&!"".equals(secuLeve)){
			hql = hql +" and ri.secuLeve='"+secuLeve+"'";
		}
		
		if(offcpers==-1){
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
		}else if(offcpers>0){
			hql = hql + " and ri.domain ="+offcpers;
		}
		
		System.out.println("findAllNumByDomain"+hql);
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}
}
