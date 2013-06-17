package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.SysCenterDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.SysCenter;

public class SysCenterDaoImpl extends HibernateDaoSupport implements SysCenterDao {

	public void addSysCenter(SysCenter sysCenter) throws Exception {
		getHibernateTemplate().saveOrUpdate(sysCenter);
	}

	public void deleteSysCenter(SysCenter sysCenter) throws Exception {
		getHibernateTemplate().delete(sysCenter);
	}

	public void updateSysCenter(SysCenter sysCenter) throws Exception {
		getHibernateTemplate().saveOrUpdate(sysCenter);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<SysCenter> findAllSysCenter() throws Exception {
		List<SysCenter> list = getHibernateTemplate().loadAll(SysCenter.class);
		return list;
	}

	public SysCenter findSysCenterById(int id) throws Exception {
		SysCenter sysCenter = (SysCenter)getHibernateTemplate().get(SysCenter.class, id);
		return sysCenter;
	}

	@SuppressWarnings("unchecked")
	public List<SysCenter> findAllSysCenter(int startResult, int maxResult)
			throws Exception {
		String hql = "from SysCenter order by parentCenterID,centerID";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<SysCenter> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from SysCenter";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

}
