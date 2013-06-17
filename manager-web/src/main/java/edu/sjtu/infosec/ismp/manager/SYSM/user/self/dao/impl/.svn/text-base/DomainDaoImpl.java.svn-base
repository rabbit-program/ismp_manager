package edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.DomainDao;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.security.Domain;

public class DomainDaoImpl extends HibernateDaoSupport implements DomainDao {

	public void add(Domain domain) throws Exception {
		getHibernateTemplate().saveOrUpdate(domain);
	}

	public void delete(Domain domain) throws Exception {
		getHibernateTemplate().delete(domain);
	}

	public void update(Domain domain) throws Exception {
		getHibernateTemplate().saveOrUpdate(domain);
		getHibernateTemplate().flush();
	}
	
	public List<Domain> findAll() throws Exception {
		List<Domain> list = getHibernateTemplate().loadAll(Domain.class);
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from Domain d";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	public Domain findById(int id) throws Exception {
		Domain domain = (Domain)getHibernateTemplate().get(Domain.class, id);
		return domain;
	}
	
	public int getCountByParam(Domain domain) throws Exception {
		Criteria cri = termMaker(domain);
		return ((Integer)cri.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}

	public List<Domain> findByParam(Domain domain,Page page) throws Exception {
		Criteria cri =termMaker(domain);
		if(page!=null){
			cri.setFirstResult(page.getBeginIndex());
			cri.setMaxResults(page.getEveryPage());
		}
		return cri.list();
	}
	
	
	public Criteria termMaker(Domain domain) throws Exception {
		Criteria cri = getSession().createCriteria(Domain.class);
		if(domain.getDomainName()!=null && domain.getDomainName().trim().length()>0){
			
			cri.add(Restrictions.like("domainName", "%"+domain.getDomainName()+"%"));
		}
		if(domain.getDescription()!=null && domain.getDescription().trim().length()>0){
			cri.add(Restrictions.like("description", domain.getDescription()));
		}
		return cri;
	}
	
	//---------------------
	
	public void saveOrUpdateAll(List<Domain> domains) throws Exception{
		getHibernateTemplate().saveOrUpdateAll(domains);
	}
	
	public void deleteAll(List<Domain> domains) throws Exception{
		getHibernateTemplate().deleteAll(domains);
	}
}
