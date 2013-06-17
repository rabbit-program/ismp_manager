package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertMonthlyDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsMonthly;

public class VirusAlertMonthlyDaoImpl extends HibernateDaoSupport implements VirusAlertMonthlyDao {

	public void addVirusAlertMonthly(VirusAlertsMonthly virusAlertMonthly)
			throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertMonthly);
	}

	public void deleteVirusAlertMonthly(VirusAlertsMonthly virusAlertMonthly)
			throws Exception {
		getHibernateTemplate().delete(virusAlertMonthly);
	}

	public void updateVirusAlertMonthly(VirusAlertsMonthly virusAlertMonthly)
			throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertMonthly);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsMonthly> findAllVirusAlertMonthly() throws Exception {
		List<VirusAlertsMonthly> list = getHibernateTemplate().loadAll(VirusAlertsMonthly.class);
		return list;
	}

	public VirusAlertsMonthly findVirusAlertMonthlyById(int id) throws Exception {
		VirusAlertsMonthly virusAlertMonthly = (VirusAlertsMonthly)getHibernateTemplate().get(VirusAlertsMonthly.class, id);
		return virusAlertMonthly;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsMonthly> findAllVirusAlertMonthly(int startResult,
			int maxResult) throws Exception {
		String hql = "from VirusAlertsMonthly order by reportDate desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsMonthly> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from VirusAlertsMonthly";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

}
