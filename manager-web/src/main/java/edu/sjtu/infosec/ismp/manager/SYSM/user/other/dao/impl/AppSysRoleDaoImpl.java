package edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao.AppSysRoleDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysInfo;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysRole;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.security.Domain;

public class AppSysRoleDaoImpl extends HibernateDaoSupport implements AppSysRoleDao {

	public void add(AppSysRole appSysRole) throws Exception {
		getHibernateTemplate().saveOrUpdate(appSysRole);
	}

	public void delete(AppSysRole appSysRole) throws Exception {
		getHibernateTemplate().delete(appSysRole);
	}

	public void update(AppSysRole appSysRole) throws Exception {
		getHibernateTemplate().saveOrUpdate(appSysRole);
		getHibernateTemplate().flush();
	}

	public List<AppSysRole> findAll() throws Exception {
		List<AppSysRole> list = getHibernateTemplate().loadAll(AppSysRole.class);
		return list;
	}

	public AppSysRole findById(int id) throws Exception {
		AppSysRole appSysRole = (AppSysRole)getHibernateTemplate().get(AppSysRole.class, id);
		return appSysRole;
	}
	
	public List<AppSysRole> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		return getConditionsPage(this.getSession().createCriteria(AppSysRole.class),null);
	}

	public List<AppSysRole> findAllByDomain(List<Domain> domainList)
			throws Exception {
		return findConditionsInfo(null,domainList, null,null,null);
	}

	public List<AppSysRole> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		// TODO Auto-generated method stub
		return findConditionsInfo(null, null,startRecordTime,endRecordTime);
	}
	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		return 0;
	}
	public long findAllNumByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		return 0;
	}
	public List<AppSysRole> findConditionsInfo(AppSysInfo syInfo,
			List<Domain> domainList, PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
		Criteria criteria = this.getSession().createCriteria(AppSysRole.class);
		findConditionsDate(criteria,startRecordTime,endRecordTime);
		return getConditionsPage(criteria,page);
	}
	public List<AppSysRole> findConditionsInfo(AppSysRole appSysRole,PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
		Criteria criteria = this.getSession().createCriteria(AppSysRole.class);
		getCommASInfos(criteria,appSysRole);
		findConditionsDate(criteria,startRecordTime,endRecordTime);
	    int count=findNumConditionsInfo(appSysRole, page, startRecordTime, endRecordTime);
	    page.setPageInfo(PMPageUtil.createPage(page, count));
		return getConditionsPage(criteria,page);
	}
	@SuppressWarnings("unchecked")
	private List<AppSysRole> getConditionsPage(Criteria criteria,PMPage page){
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
	    	List<AppSysRole> list = criteria.list();
	    	return list;
    }
    private int getNumConditionsPage(Criteria criteria){
    	criteria.setProjection(Projections.rowCount());
    	int listCount = (Integer) criteria.uniqueResult();
    	return listCount;
    }
	private void getCommASInfos(Criteria criteria,AppSysRole appSysRole)
	{
			if(!(appSysRole == null))
			{
					if(!(appSysRole.getId()==null) && appSysRole.getId() > 0)
					{
						criteria.add(Restrictions.eq("id", appSysRole.getId()));
					}
					if(!(appSysRole.getAppSys()==null) && appSysRole.getAppSys().getId() > 0)
					{
						criteria.createCriteria("appSys").add(Restrictions.eq("id", appSysRole.getAppSys().getId()));
					}
					if(!(appSysRole.getName()==null) && !(appSysRole.getName().trim()==""))
					{
						criteria.add(Restrictions.like("name", "%"+appSysRole.getName()+"%"));
					}
					if(!(appSysRole.getName() == null) && !(appSysRole.getName() == ""))
					{
						criteria.createCriteria("appSys").add(Restrictions.eq("appSys.name", appSysRole.getName()));
					}
			}
	}
	private void findConditionsDate(Criteria criteria,Timestamp startDate, Timestamp endDate){
		if(!(startDate==null) && !(endDate == null))
		{
			criteria.add(Restrictions.ge("lastChangeTime", startDate)).add(Restrictions.le("lastChangeTime", endDate));
		}
		if(!(startDate == null) && endDate == null)
		{
			criteria.add(Restrictions.ge("lastChangeTime", startDate)).add(Restrictions.le("lastChangeTime", new Date()));
		}
		if(startDate == null && !(endDate == null))
		{
			criteria.add(Restrictions.le("lastChangeTime", endDate));
		}
	}

	private int findNumConditionsInfo(AppSysRole appSysRole,PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
			Criteria criteria = this.getSession().createCriteria(AppSysRole.class);
			getCommASInfos(criteria,appSysRole);
			findConditionsDate(criteria,startRecordTime,endRecordTime);
			return getNumConditionsPage(criteria);
	}

	public List<AppSysRole> findASIById(int asid) throws Exception {
		Criteria criteria = this.getSession().createCriteria(AppSysRole.class);
		criteria.add(Restrictions.eq("appSys.id", asid));
		return criteria.list();
	}
	

}
