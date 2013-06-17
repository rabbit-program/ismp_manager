package edu.sjtu.infosec.ismp.manager.GOSP.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.GOSP.dao.LawsAndRulesDao;
import edu.sjtu.infosec.ismp.manager.GOSP.model.LawsAndRules;
import edu.sjtu.infosec.ismp.security.Domain;

public class LawsAndRulesDaoImpl extends HibernateDaoSupport implements LawsAndRulesDao {

	public void add(LawsAndRules lawsAndRules) throws Exception {
		getHibernateTemplate().saveOrUpdate(lawsAndRules);
	}

	public void delete(LawsAndRules lawsAndRules) throws Exception {
		getHibernateTemplate().delete(lawsAndRules);
	}

	public void update(LawsAndRules lawsAndRules) throws Exception {
		getHibernateTemplate().saveOrUpdate(lawsAndRules);
		getHibernateTemplate().flush();
	}

	public List<LawsAndRules> findAll() throws Exception {
		List<LawsAndRules> list = getHibernateTemplate().loadAll(LawsAndRules.class);
		return list;
	}

	public LawsAndRules findById(int id) throws Exception {
		LawsAndRules lawsAndRules = (LawsAndRules)getHibernateTemplate().get(LawsAndRules.class, id);
		return lawsAndRules;
	}

	@SuppressWarnings("unchecked")
	public List<LawsAndRules> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from LawsAndRules lar where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and lar.issueDate>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and lar.issueDate<='"+endRecordTime+"' ";
		}
		
//		hql = hql + " order by lar.issueDate,lar.domain.id";
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<LawsAndRules> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<LawsAndRules> findAllByDomain(List<Domain> domainList)
			throws Exception {
		String hql = "from LawsAndRules lar where 1=1 ";
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (lar.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or lar.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by lar.issueDate,lar.domain.id";
		
		List<LawsAndRules> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<LawsAndRules> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from LawsAndRules lar where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and lar.issueDate>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and lar.issueDate<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (lar.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or lar.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by lar.issueDate,lar.domain.id";
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<LawsAndRules> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from LawsAndRules lar where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and lar.issueDate>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and lar.issueDate<='"+endRecordTime+"' ";
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
		String hql = "select count(id) from LawsAndRules lar where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and lar.issueDate>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and lar.issueDate<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (lar.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or lar.domain.id=" + domain.getId();
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
	public List<LawsAndRules> findAllByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult, int id,
			Domain domain)throws Exception {
		Criteria criteria=this.getSession().createCriteria(LawsAndRules.class);
		if(null!=startRecordTime){	
			criteria.add(Expression.eq("issueDate", startRecordTime));
		}
		if(null!=endRecordTime){
			criteria.add(Expression.eq("uploadTime", endRecordTime));
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
		List<LawsAndRules> lawRulesList = (List<LawsAndRules>)criteria.list();
		return lawRulesList;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<LawsAndRules> findAllByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult, int id, Domain domain)throws Exception {
		Criteria criteria=this.getSession().createCriteria(LawsAndRules.class);
		if(null!=startRecordTime){	
			criteria.add(Expression.eq("issueDate", startRecordTime));
		}
		if(null!=endRecordTime){
			criteria.add(Expression.eq("uploadTime", endRecordTime));
		}
		if(-1 != id){
			criteria.add(Restrictions.eq("domain", domain));
		}
		criteria.add(Restrictions.in("domain", domainList));
		criteria.setFirstResult(startResult);
		criteria.setMaxResults(maxResult);
		List<LawsAndRules> lawRulesList = (List<LawsAndRules>)criteria.list();
		return lawRulesList;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int id) throws Exception {
		
		String hql = "select count(id) from LawsAndRules lar where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and lar.issueDate>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and lar.issueDate<='"+endRecordTime+"' ";
		}
		if(id>0){
			hql = hql + " and lar.domain ="+id;
		}else if(id==-2){
			hql = hql + " and lar.domain is null";
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

		String hql = "select count(id) from LawsAndRules lar where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and lar.issueDate>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and lar.issueDate<='"+endRecordTime+"' ";
		} 
		if(id==-1){
			int i = 0;
			for(Domain domain : domainList){
				if(i == 0){
					hql = hql + " and (lar.domain.id=" + domain.getId();
				}
				if(i > 0){
					hql = hql + " or lar.domain.id=" + domain.getId();
				}
				i++;
			}
			if(i > 0){
				hql = hql + ") ";
			}
		}else if(id>0){
			hql = hql + " and lar.domain ="+id;
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long totalNum = 0;
		if(list != null && list.size()>0){
			totalNum = list.get(0);
		}
		return totalNum;
	}
}
