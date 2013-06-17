package edu.sjtu.infosec.ismp.manager.GOSP.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.GOSP.dao.GospKnowledgeBaseDao;
import edu.sjtu.infosec.ismp.manager.GOSP.model.GospKnowledgeBase;
import edu.sjtu.infosec.ismp.security.Domain;

public class GospKnowledgeBaseDaoImpl extends HibernateDaoSupport implements GospKnowledgeBaseDao {

	public void add(GospKnowledgeBase knowledgeBase) throws Exception {
		getHibernateTemplate().saveOrUpdate(knowledgeBase);
	}

	public void delete(GospKnowledgeBase knowledgeBase) throws Exception {
		getHibernateTemplate().delete(knowledgeBase);
	}

	public void update(GospKnowledgeBase knowledgeBase) throws Exception {
		getHibernateTemplate().saveOrUpdate(knowledgeBase);
		getHibernateTemplate().flush();
	}

	public List<GospKnowledgeBase> findAll() throws Exception {
		List<GospKnowledgeBase> list = getHibernateTemplate().loadAll(GospKnowledgeBase.class);
		return list;
	}

	public GospKnowledgeBase findById(int id) throws Exception {
		GospKnowledgeBase knowledgeBase = (GospKnowledgeBase)getHibernateTemplate().get(GospKnowledgeBase.class, id);
		return knowledgeBase;
	}

	@SuppressWarnings("unchecked")
	public List<GospKnowledgeBase> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from GospKnowledgeBase kb where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and kb.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and kb.lastUpdateTime<='"+endRecordTime+"' ";
		}
		// hql = hql + " order by kb.lastUpdateTime,kb.domain.id";
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<GospKnowledgeBase> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<GospKnowledgeBase> findAllByDomain(List<Domain> domainList)
			throws Exception {
		String hql = "from GospKnowledgeBase kb where 1=1 ";
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (kb.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or kb.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by kb.lastUpdateTime,kb.domain.id";
		
		List<GospKnowledgeBase> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<GospKnowledgeBase> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from GospKnowledgeBase kb where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and kb.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and kb.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (kb.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or kb.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by kb.lastUpdateTime,kb.domain.id";
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<GospKnowledgeBase> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from GospKnowledgeBase kb where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and kb.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and kb.lastUpdateTime<='"+endRecordTime+"' ";
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
		String hql = "select count(id) from GospKnowledgeBase kb where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and kb.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and kb.lastUpdateTime<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (kb.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or kb.domain.id=" + domain.getId();
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<GospKnowledgeBase> findAllByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult, int id,
			Domain domain) throws Exception {
		Criteria criteria=this.getSession().createCriteria(GospKnowledgeBase.class);
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
		List<GospKnowledgeBase> knowledgeBaseList = (List<GospKnowledgeBase>)criteria.list();
		return knowledgeBaseList;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<GospKnowledgeBase> findAllByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult, int id, Domain domain)
			throws Exception {
		Criteria criteria=this.getSession().createCriteria(GospKnowledgeBase.class);
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
		List<GospKnowledgeBase> knowledgeBaseList = (List<GospKnowledgeBase>)criteria.list();
		return knowledgeBaseList;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int id) throws Exception {
		
		String hql = "select count(id) from GospKnowledgeBase kb where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and kb.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and kb.lastUpdateTime<='"+endRecordTime+"' ";
		}
		if(id>0){
			hql = hql + " and kb.domain ="+id;
		}else if(id==-2){
			hql = hql + " and kb.domain is null";
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

		String hql = "select count(id) from GospKnowledgeBase kb where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and kb.lastUpdateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and kb.lastUpdateTime<='"+endRecordTime+"' ";
		} 
		if(id==-1){
			int i = 0;
			for(Domain domain : domainList){
				if(i == 0){
					hql = hql + " and (kb.domain.id=" + domain.getId();
				}
				if(i > 0){
					hql = hql + " or kb.domain.id=" + domain.getId();
				}
				i++;
			}
			if(i > 0){
				hql = hql + ") ";
			}
		}else if(id>0){
			hql = hql + " and kb.domain ="+id;
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long totalNum = 0;
		if(list != null && list.size()>0){
			totalNum = list.get(0);
		}
		return totalNum;
	}

}
