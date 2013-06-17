package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertDailyCenterDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsDailyCenter;

public class VirusAlertDailyCenterDaoImpl extends HibernateDaoSupport implements VirusAlertDailyCenterDao {

	public void addVirusAlertDailyCenter(
			VirusAlertsDailyCenter virusAlertDailyCenter) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertDailyCenter);
	}

	public void deleteVirusAlertDailyCenter(
			VirusAlertsDailyCenter virusAlertDailyCenter) throws Exception {
		getHibernateTemplate().delete(virusAlertDailyCenter);
	}

	public void updateVirusAlertDailyCenter(
			VirusAlertsDailyCenter virusAlertDailyCenter) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertDailyCenter);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsDailyCenter> findAllVirusAlertDailyCenter()
			throws Exception {
		List<VirusAlertsDailyCenter> list = getHibernateTemplate().loadAll(VirusAlertsDailyCenter.class);
		return list;
	}

	public VirusAlertsDailyCenter findVirusAlertDailyCenterById(int id)
			throws Exception {
		VirusAlertsDailyCenter virusAlertDailyCenter = (VirusAlertsDailyCenter)getHibernateTemplate().get(VirusAlertsDailyCenter.class, id);
		return virusAlertDailyCenter;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsDailyCenter> findAllVirusAlertDailyCenter(
			int startResult, int maxResult) throws Exception {
		String hql = "from VirusAlertsDailyCenter order by reportDate desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsDailyCenter> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from VirusAlertsDailyCenter";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

}
