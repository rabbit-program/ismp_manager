package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.KillResultTypeDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.KillResultType;

public class KillResultTypeDaoImpl extends HibernateDaoSupport implements KillResultTypeDao {

	public void addKillResultType(KillResultType killResultType)
			throws Exception {
		getHibernateTemplate().saveOrUpdate(killResultType);
	}

	public void deleteKillResultType(KillResultType killResultType)
			throws Exception {
		getHibernateTemplate().delete(killResultType);
	}

	public void updateKillResultType(KillResultType killResultType)
			throws Exception {
		getHibernateTemplate().saveOrUpdate(killResultType);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<KillResultType> findAllKillResultType() throws Exception {
		List<KillResultType> list = getHibernateTemplate().loadAll(KillResultType.class);
		return list;
	}

	public KillResultType findKillResultTypeById(int id) throws Exception {
		KillResultType killResultType = (KillResultType)getHibernateTemplate().get(KillResultType.class, id);
		return killResultType;
	}

	@SuppressWarnings("unchecked")
	public List<KillResultType> findAllKillResultType(int startResult,
			int maxResult) throws Exception {
		String hql = "from KillResultType order by code";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<KillResultType> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from KillResultType";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

}
