package edu.sjtu.infosec.ismp.manager.OSS.pm.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.OSS.pm.dao.DutyScheduleDao;
import edu.sjtu.infosec.ismp.manager.OSS.pm.model.DutySchedule;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.Domain;

public class DutyScheduleDaoImpl extends HibernateDaoSupport implements DutyScheduleDao {

	public void add(DutySchedule dutySchedule) throws Exception {
		
		getHibernateTemplate().save(dutySchedule);
	}

	public void delete(DutySchedule dutySchedule) throws Exception {
		getHibernateTemplate().delete(dutySchedule);
	}

	public List<DutySchedule> findAll() {
		return getHibernateTemplate().loadAll(DutySchedule.class);
	}

	public DutySchedule findById(int id) {
		return getHibernateTemplate().get(DutySchedule.class, id);
	}

	public void update(DutySchedule dutySchedule) throws Exception {
		getHibernateTemplate().update(dutySchedule);
	}

	@SuppressWarnings("unchecked")
	public List<DutySchedule> findConditionsInfo(
			DutySchedule dutySchedule, List<Domain> domainList,
			PMPage page, Timestamp startRecordTime, Timestamp endRecordTime) {
        String hql = getFindSql(dutySchedule,domainList,startRecordTime,endRecordTime);
        Query query = getSession().createQuery(hql);
        query.setFirstResult(page.getBeginIndex());
        query.setMaxResults(page.getEveryPage());
        return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<DutySchedule> findNotPulishedDutySchedule(DutySchedule dutySchedule,
			List<Domain> domainList) {
          String hql = getFindSql(dutySchedule,domainList,null,null);
          Query query = getSession().createQuery(hql);
        return query.list();
	}
	
	private String getFindSql(DutySchedule dutySchedule, List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime){
        String hql ="from DutySchedule r where 1=1"; 
        if(!(domainList == null)){
          for(int i=0;i<domainList.size();i++){
        	 hql +=  (i < 1 ? " and (" : "or ") + "r.domain ="+domainList.get(i).getId() + ((domainList.size()-1) == i ? ") " : " ");
          }
        }
        hql += dutySchedule.getIsPublished() > 0 ? "and isPublished=0" : "";
        hql +=!(startRecordTime == null) ? "or r.lastUpdateTime >= '" + startRecordTime +"'" : ""  ;
        hql +=!(endRecordTime == null) ? "or r.lastUpdateTime <= '" + endRecordTime +"'" : ""  ;  
        return hql;
	}
	public long findRosterByCount(DutySchedule dutySchedule,
			List<Domain> domainList, PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
	        String hql ="select count(r.id) from DutySchedule r where 1=1";
	         for(int i=0;i<domainList.size();i++){
	        	 hql +=  (i < 1 ? " and (" : "or ") + "r.domain ="+domainList.get(i).getId() + ((domainList.size()-1) == i ? ") " : " ");
	         }
	        hql +=!(startRecordTime == null) ? "or r.lastUpdateTime >= '" + startRecordTime +"'" : ""  ;
	        hql +=!(endRecordTime == null) ? "or r.lastUpdateTime <= '" + endRecordTime +"'" : ""  ;  
		 return  (Long) this.getSession().createQuery(hql).uniqueResult();
	}

	public void publishedDutySchedule(List<DutySchedule> dutyScheduleList) {
           String hql ="update DutySchedule d set d.isPublished= 1  where 1 = 0 ";
           for(int i=0;i<dutyScheduleList.size();i++){
        	   hql +=" or d.id ="+dutyScheduleList.get(i).getId();
           }
          Query query =  getSession().createQuery(hql);
          query.executeUpdate();
	}

	public List<DutySchedule> findDutyDate(Timestamp startRecordTime) {
		
		Criteria c = this.getSession().createCriteria(DutySchedule.class);
		

		c.add(Restrictions.ge("endTime", startRecordTime));
		
		return c.list();
		
	}
}
