package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertDailyDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsDaily;

public class VirusAlertDailyDaoImpl extends HibernateDaoSupport implements VirusAlertDailyDao {

	public void addVirusAlertDaily(VirusAlertsDaily virusAlertDaily)
			throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertDaily);
	}

	public void deleteVirusAlertDaily(VirusAlertsDaily virusAlertDaily)
			throws Exception {
		getHibernateTemplate().delete(virusAlertDaily);
	}

	public void updateVirusAlertDaily(VirusAlertsDaily virusAlertDaily)
			throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertDaily);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsDaily> findAllVirusAlertDaily() throws Exception {
		List<VirusAlertsDaily> list = getHibernateTemplate().loadAll(VirusAlertsDaily.class);
		return list;
	}

	public VirusAlertsDaily findVirusAlertDailyById(int id) throws Exception {
		VirusAlertsDaily virusAlertDaily = (VirusAlertsDaily)getHibernateTemplate().get(VirusAlertsDaily.class, id);
		return virusAlertDaily;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsDaily> findAllVirusAlertDaily(int startResult,
			int maxResult) throws Exception {
		String hql = "from VirusAlertsDaily order by reportDate desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsDaily> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from VirusAlertsDaily";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

}
