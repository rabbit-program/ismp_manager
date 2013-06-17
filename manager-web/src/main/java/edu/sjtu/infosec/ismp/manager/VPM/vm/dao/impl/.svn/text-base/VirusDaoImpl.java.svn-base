package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.Virus;

public class VirusDaoImpl extends HibernateDaoSupport implements VirusDao {

	public void addVirus(Virus virus) throws Exception {
		getHibernateTemplate().saveOrUpdate(virus);
	}

	public void deleteVirus(Virus virus) throws Exception {
		getHibernateTemplate().delete(virus);
	}

	public void updateVirus(Virus virus) throws Exception {
		getHibernateTemplate().saveOrUpdate(virus);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<Virus> findAllVirus() throws Exception {
		List<Virus> list = getHibernateTemplate().loadAll(Virus.class);
		return list;
	}

	public Virus findVirusById(int id) throws Exception {
		Virus virus = (Virus)getHibernateTemplate().get(Virus.class, id);
		return virus;
	}

	@SuppressWarnings("unchecked")
	public List<Virus> findAllVirus(int startResult, int maxResult)
			throws Exception {
		String hql = "from Virus order by lastFindTime desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<Virus> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from Virus";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

}
