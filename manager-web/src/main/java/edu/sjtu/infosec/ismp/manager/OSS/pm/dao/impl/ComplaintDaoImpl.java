/**
 * 
 */
package edu.sjtu.infosec.ismp.manager.OSS.pm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.OSS.pm.dao.ComplaintDao;
import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint;

/**
 * @author liuqing
 *
 */
public class ComplaintDaoImpl extends HibernateDaoSupport implements ComplaintDao {

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.dao.ComplaintDao#del(edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint)
	 */
	public void del(Complaint complaint) {
           getHibernateTemplate().delete(complaint);
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.dao.ComplaintDao#save(edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint)
	 */
	public void save(Complaint complaint) {
          getHibernateTemplate().saveOrUpdate(complaint);
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.dao.ComplaintDao#searchAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Complaint> searchAll() {
		return getHibernateTemplate().find("from Complaint");
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.dao.ComplaintDao#searchById(java.lang.Integer)
	 */
	public Complaint searchById(Integer id) {
		Session session = getSession();
		Complaint complaint = (Complaint) session.get(Complaint.class, id);
		releaseSession(session);
		return complaint;
	}
	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.dao.ComplaintDao#update(edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint)
	 */
	public void update(Complaint complaint) {
        getHibernateTemplate().update(complaint);
	}

	@SuppressWarnings("unchecked")
	public List<Complaint>  searchByDomian(Integer domianId) {
		 Session session = getSession();
		 Query query = session.createQuery("from Complaint c where c.domain=?");
		 query.setInteger(0, domianId);
		 List list =   query.list();
		 releaseSession(session);
		 return  list;
	}

	@SuppressWarnings("unchecked")
	public Map<String,String> searchDomainById() {
		Session session = getSession();
		Query query = session.createSQLQuery("SELECT OS.DOMAIN_ID , OS.COMPLAINT_PHONE FROM OSS_PM_DOMAIN_COMPLAINT OS");
		List<Object[]> list = query.list();
		Map<String,String> map = new HashMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i)[0].toString(), list.get(i)[1].toString());
	    }
		releaseSession(session);
		return map;
	}

}
