package edu.sjtu.infosec.ismp.manager.GOSP.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.GOSP.dao.SafeStateRecordsDao;
import edu.sjtu.infosec.ismp.manager.GOSP.model.SafeStateRecords;
import edu.sjtu.infosec.ismp.security.Domain;

@SuppressWarnings("deprecation")
public class SafeStateRecordsDaoImpl extends HibernateDaoSupport implements SafeStateRecordsDao {

	public void add(SafeStateRecords safeStateRecords) throws Exception {
		getHibernateTemplate().saveOrUpdate(safeStateRecords);
	}

	public void delete(SafeStateRecords safeStateRecords) throws Exception {
		getHibernateTemplate().delete(safeStateRecords);
	}

	public void update(SafeStateRecords safeStateRecords) throws Exception {
		getHibernateTemplate().saveOrUpdate(safeStateRecords);
		getHibernateTemplate().flush();
	}

	public List<SafeStateRecords> findAll() throws Exception {
		List<SafeStateRecords> list = getHibernateTemplate().loadAll(SafeStateRecords.class);
		return list;
	}

	public SafeStateRecords findById(int id) throws Exception {
		SafeStateRecords safeStateRecords = (SafeStateRecords)getHibernateTemplate().get(SafeStateRecords.class, id);
		return safeStateRecords;
	}

	@SuppressWarnings("unchecked")
	public List<SafeStateRecords> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
//		hql = hql + " order by ssr.lastUpdateTime,ssr.domain.id";
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<SafeStateRecords> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<SafeStateRecords> findAllByDomain(List<Domain> domainList)
			throws Exception {
		String hql = "from SafeStateRecords ssr where 1=1 ";
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ssr.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ssr.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by ssr.lastUpdateTime,ssr.domain.id";
		
		List<SafeStateRecords> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<SafeStateRecords> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ssr.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ssr.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by ssr.lastUpdateTime,ssr.domain.id";
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<SafeStateRecords> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}

		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ssr.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ssr.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
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
	public List<SafeStateRecords> findAllByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult, int id,
			Domain domain) throws Exception {
		Criteria criteria=this.getSession().createCriteria(SafeStateRecords.class);
		if(null!=startRecordTime){	
			criteria.add(Expression.eq("createTime", startRecordTime));
		}
		if(null!=endRecordTime){
			criteria.add(Expression.eq("lastUpdateTime", endRecordTime));
		}
		if(0!=id && -1!=id){
			if(id==-2){
				criteria.add(Expression.isNull("domain"));
			}else{
				criteria.add(Expression.eq("domain", domain));
			}
		}
		
		criteria.setFirstResult(startResult);
		criteria.setMaxResults(maxResult);
		List<SafeStateRecords> netSafeList = (List<SafeStateRecords>)criteria.list();
		return netSafeList;
	}

	@SuppressWarnings("unchecked")
	public List findAllByDomainAndLevel(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		
		String hql = "select ssr.level,count(id) as total from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ssr.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ssr.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " group by ssr.level";
		List levelList = getHibernateTemplate().find(hql);
		return levelList;
	}

	@SuppressWarnings("unchecked")
	public List<SafeStateRecords> findAllByDomainAndPie(
			List<Domain> domainList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		
		String hql = "from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ssr.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ssr.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by ssr.lastUpdateTime,ssr.domain.id";
		List<SafeStateRecords> levelList = getHibernateTemplate().find(hql);
		return levelList;
	}

	@SuppressWarnings("unchecked")
	public List findAllByDomainAndState(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		
		String hql = "select ssr.state,count(id) as total from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ssr.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ssr.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " group by ssr.state";
		List stateList = getHibernateTemplate().find(hql);
		return stateList;
	}

	
	@SuppressWarnings("unchecked")
	public List<SafeStateRecords> findAllByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult, int id, Domain domain)
			throws Exception {
		Criteria criteria=this.getSession().createCriteria(SafeStateRecords.class);
		if(null!=startRecordTime){	
			criteria.add(Expression.eq("createTime", startRecordTime));
		}
		if(null!=endRecordTime){
			criteria.add(Expression.eq("lastUpdateTime", endRecordTime));
		}
		if(-1 != id){
			criteria.add(Restrictions.eq("domain", domain));
		}
		criteria.add(Restrictions.in("domain", domainList));
		criteria.setFirstResult(startResult);
		criteria.setMaxResults(maxResult);
		List<SafeStateRecords> netSafeList = (List<SafeStateRecords>)criteria.list();
		return netSafeList;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int id) throws Exception {

		String hql = "select count(id) from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}
		if(id>0){
			hql = hql + " and ssr.domain ="+id;
		}else if(id==-2){
			hql = hql + " and ssr.domain is null";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long totalNum =0;
		if(list != null && list.size()>0){
			totalNum = list.get(0);
		}
		return totalNum;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime, int id)
			throws Exception {

		String hql = "select count(id) from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		} 
		if(id==-1){
			int i = 0;
			for(Domain domain : domainList){
				if(i == 0){
					hql = hql + " and (ssr.domain.id=" + domain.getId();
				}
				if(i > 0){
					hql = hql + " or ssr.domain.id=" + domain.getId();
				}
				i++;
			}
			if(i > 0){
				hql = hql + ") ";
			}
		}else if(id>0){
			hql = hql + " and ssr.domain ="+id;
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long totalNum = 0;
		if(list != null && list.size()>0){
			totalNum = list.get(0);
		}
		return totalNum;
	}

	@SuppressWarnings("unchecked")
	public List findAllByTimeAndLevel(Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select ssr.level,count(id) as total from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
		hql = hql + " group by ssr.level";
		List levelList = getHibernateTemplate().find(hql);
		return levelList;
	}

	@SuppressWarnings("unchecked")
	public List findAllByTimeAndState(Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		
		String hql = "select ssr.state,count(id) as total from SafeStateRecords ssr where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ssr.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
		hql = hql + " group by ssr.state";
		List stateList = getHibernateTemplate().find(hql);
		return stateList;
	}

}
