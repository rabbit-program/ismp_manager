package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusTypeDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusType;

public class VirusTypeDaoImpl extends HibernateDaoSupport implements VirusTypeDao {

	public void addVirusType(VirusType virusType) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusType);
	}

	public void deleteVirusType(VirusType virusType) throws Exception {
		getHibernateTemplate().delete(virusType);
	}

	public void updateVirusType(VirusType virusType) throws Exception {
		getHibernateTemplate().saveOrUpdate(virusType);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<VirusType> findAllVirusType() throws Exception {
		List<VirusType> list = getHibernateTemplate().loadAll(VirusType.class);
		return list;
	}

	public VirusType findVirusTypeById(int id) throws Exception {
		VirusType virusType = (VirusType)getHibernateTemplate().get(VirusType.class, id);
		return virusType;
	}

	@SuppressWarnings("unchecked")
	public List<VirusType> findAllVirusType(int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusType order by code";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusType> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from VirusType";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

}
