
package edu.sjtu.infosec.ismp.manager.ERM.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.ERM.dao.ContinotifyprocDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.ContiNotifyProc;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * ClassName:ContinotifyprocDaoImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   mahonglei
 * @version  
 * @since    Ver 1.1
 * @Date	 2009-6-15		-=
 *
 * @see 	 
 * @deprecated 
 */
public class ContinotifyprocDaoImpl extends HibernateDaoSupport implements ContinotifyprocDao {

	public void delete(ContiNotifyProc persistentInstance) {
		this.getSession().delete(persistentInstance);
	}

	public List findByPageDao(Integer projid, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public int findCountDao(Integer projid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<ContiNotifyProc> findbyid(int startResult,int maxResult,int id) {
			Query query=this.getSession().createQuery("from ContiNotifyProc contiNotifyProc where contiNotifyProc.respInfo = :con");
			query.setEntity("con",  findRespBoById(String.valueOf(id)));
			query.setFirstResult(startResult);
			query.setMaxResults(maxResult);
			return (List<ContiNotifyProc>)query.list();
	}

	public void save(ContiNotifyProc transientInstance) {
		this.getSession().save(transientInstance);
		
	}

	public void update(ContiNotifyProc continotifyproc) {
		this.getSession().update(continotifyproc);
	}

	public RespInfoBO findRespBoById(String id) {
		Query query=this.getSession().createQuery("from RespInfoBO r where r.id=:id");
		query.setString("id", id);
		return (RespInfoBO) query.list().get(0);
	}

	public List<ContiNotifyProc> findByRespInfo(RespInfoBO info) {
		Query query=this.getSession().createQuery("from ContiNotifyProc contiNotifyProc where contiNotifyProc.respInfo = :con");
		query.setEntity("con", info);
		return (List<ContiNotifyProc>)query.list();
	}

	public void deleteNotifyByRespInfo(RespInfoBO resp) {
		Query query=this.getSession().createQuery("delete from ContiNotifyProc c where c.respInfo = :con");
		query.setEntity("con", resp);
		int i=query.executeUpdate();
		//System.out.println("deleteNotifyByRespInfo=="+i);
	}

	public int getCount(String respid) {
		Query query = this.getSession().createQuery("from ContiNotifyProc c where c.respInfo.id=:id");
		query.setInteger("id", Integer.parseInt(respid));
		return query.list().size();
	}

}
