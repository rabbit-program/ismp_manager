package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertMonthlyCenterDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsMonthlyCenter;

public class VirusAlertMonthlyCenterDaoImpl extends HibernateDaoSupport implements VirusAlertMonthlyCenterDao {

	public void addVirusAlertMonthlyCenter(
			VirusAlertsMonthlyCenter virusAlertMonthlyCenter) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertMonthlyCenter);
	}

	public void deleteVirusAlertMonthlyCenter(
			VirusAlertsMonthlyCenter virusAlertMonthlyCenter) throws Exception {
		getHibernateTemplate().delete(virusAlertMonthlyCenter);
	}

	public void updateVirusAlertMonthlyCenter(
			VirusAlertsMonthlyCenter virusAlertMonthlyCenter) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertMonthlyCenter);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsMonthlyCenter> findAllVirusAlertMonthlyCenter()
			throws Exception {
		List<VirusAlertsMonthlyCenter> list = getHibernateTemplate().loadAll(VirusAlertsMonthlyCenter.class);
		return list;
	}

	public VirusAlertsMonthlyCenter findVirusAlertMonthlyCenterById(int id)
			throws Exception {
		VirusAlertsMonthlyCenter virusAlertMonthlyCenter = (VirusAlertsMonthlyCenter)getHibernateTemplate().get(VirusAlertsMonthlyCenter.class, id);
		return virusAlertMonthlyCenter;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsMonthlyCenter> findAllVirusAlertMonthlyCenter(
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusAlertsMonthlyCenter order by reportDate desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsMonthlyCenter> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from VirusAlertsMonthlyCenter";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

}
