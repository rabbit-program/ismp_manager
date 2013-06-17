package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlerts;

public class VirusAlertDaoImpl extends HibernateDaoSupport implements VirusAlertDao {

	public void addVirusAlert(VirusAlerts virusAlert) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlert);
	}

	public void deleteVirusAlert(VirusAlerts virusAlert) throws Exception {
		getHibernateTemplate().delete(virusAlert);
	}

	public void updateVirusAlert(VirusAlerts virusAlert) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlert);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlerts> findAllVirusAlert() throws Exception {
		List<VirusAlerts> list = getHibernateTemplate().loadAll(VirusAlerts.class);
		return list;
	}

	public VirusAlerts findVirusAlertById(int id) throws Exception {
		VirusAlerts virusAlert = (VirusAlerts)getHibernateTemplate().get(VirusAlerts.class, id);
		return virusAlert;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlerts> findAllVirusAlert(int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusAlerts order by virus.lastFindTime desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlerts> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from VirusAlerts where virus is not null";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

}
