package edu.sjtu.infosec.ismp.manager.OSS.pm.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.OSS.pm.dao.RosterDao;
import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.Domain;

public class RosterDaoImpl extends HibernateDaoSupport implements RosterDao {

	public void add(Roster roster) throws Exception {
		 getHibernateTemplate().save(roster);
	}

	public void delete(Roster roster) throws Exception {
		getHibernateTemplate().delete(roster);
	}

	public List<Roster> findAll() {
		return getHibernateTemplate().loadAll(Roster.class);
	}

	public Roster findById(int id) {
		return getHibernateTemplate().get(Roster.class, id);
	}

	public void update(Roster roster) throws Exception {
		getHibernateTemplate().saveOrUpdate(roster);
	}

	@SuppressWarnings("unchecked")
	public List<Roster> findConditionsInfo(Roster roster,
			List<Domain> domainList, PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
	        String hql ="from Roster r where 1=1";
	              if(!(roster == null))
	        	     hql += HtmlFactory.isNotEmpty(roster.getName())  ? " and r.name like '%" + roster.getName() +"%'" : "";
	          for(int i=0;i<domainList.size();i++){
	         	 hql +=  (i < 1 ? " and (" : "or ") + "r.domain ="+domainList.get(i).getId() + ((domainList.size()-1) == i ? ") " : " ");
	          }
	         hql +=!(startRecordTime == null) ? "or r.lastUpdateTime >= '" + startRecordTime +"'" : ""  ;
	         hql +=!(endRecordTime == null) ? "or r.lastUpdateTime <= '" + endRecordTime +"' " : ""  ;  
	         hql+="order by id,lastUpdateTime";
             Query query = getSession().createQuery(hql);
             if(!(page == null)){
            	query.setFirstResult(page.getBeginIndex());
            	query.setMaxResults(page.getEveryPage());
             }
          return query.list();
	}
	
	public long findRosterByCount(Roster roster, List<Domain> domainList,
			PMPage page, Timestamp startRecordTime, Timestamp endRecordTime) {
        String hql ="select count(r.id) from Roster r where 1=1";
        if(!(roster == null))
        	  hql += HtmlFactory.isNotEmpty(roster.getName())  ? " and r.name like '%" + roster.getName() +"%'" : "";
         for(int i=0;i<domainList.size();i++){
        	 hql +=  (i < 1 ? " and (" : "or ") + "r.domain ="+domainList.get(i).getId() + ((domainList.size()-1) == i ? ") " : " ");
         }
        hql +=!(startRecordTime == null) ? "or r.lastUpdateTime >= '" + startRecordTime +"'" : ""  ;
        hql +=!(endRecordTime == null) ? "or r.lastUpdateTime <= '" + endRecordTime +"'" : ""  ;  
		
      return  (Long) this.getSession().createQuery(hql).uniqueResult();
	}

	public List<Roster> findLikeAll(Object[] args) {
		Criteria c = this.getSession().createCriteria(Roster.class);
		c.add(Restrictions.not(Restrictions.in("id", args)));
		return c.list();
	}


}
