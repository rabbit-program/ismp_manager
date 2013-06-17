package edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao.RoleAssignRecordsDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysInfo;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.RoleAssignRecords;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.security.Domain;

public class RoleAssignRecordsDaoImpl extends HibernateDaoSupport implements RoleAssignRecordsDao {

	public void add(RoleAssignRecords roleAssignRecords) throws Exception {
		getHibernateTemplate().saveOrUpdate(roleAssignRecords);
	}

	public void delete(RoleAssignRecords roleAssignRecords) throws Exception {
		getHibernateTemplate().delete(roleAssignRecords);
	}

	public void update(RoleAssignRecords roleAssignRecords) throws Exception {
		getHibernateTemplate().saveOrUpdate(roleAssignRecords);
		getHibernateTemplate().flush();
	}
	
	public List<RoleAssignRecords> findAll() throws Exception {
		List<RoleAssignRecords> list = getHibernateTemplate().loadAll(RoleAssignRecords.class);
		return list;
	}

	public RoleAssignRecords findById(int id) throws Exception {
		RoleAssignRecords roleAssignRecords = (RoleAssignRecords)getHibernateTemplate().get(RoleAssignRecords.class, id);
		return roleAssignRecords;
	}

	public List<RoleAssignRecords> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		return getConditionsPage(this.getSession().createCriteria(AppSysInfo.class),null);
	}

	public List<RoleAssignRecords> findAllByDomain(List<Domain> domainList)
			throws Exception {
		return findConditionsInfo(null,domainList, null,null,null);
	}

	public List<RoleAssignRecords> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		return findConditionsInfo(null,domainList, null,startRecordTime,endRecordTime);
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

	public List<RoleAssignRecords> findConditionsInfo(RoleAssignRecords roleAssignRecords,PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
		Criteria criteria = this.getSession().createCriteria(RoleAssignRecords.class);
		getCommASInfos(criteria,roleAssignRecords);
		findConditionsDate(criteria,startRecordTime,endRecordTime);
	    int count=findNumConditionsInfo(roleAssignRecords,page, startRecordTime, endRecordTime);
	    page.setPageInfo(PMPageUtil.createPage(page, count));
		return getConditionsPage(criteria,page);
	}
	public List<RoleAssignRecords> findConditionsInfo(AppSysInfo syInfo,
			List<Domain> domainList, PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
		Criteria criteria = this.getSession().createCriteria(RoleAssignRecords.class);
		findConditionsDate(criteria,startRecordTime,endRecordTime);
		return getConditionsPage(criteria,page);
	}
	
	@SuppressWarnings("unchecked")
	private List<RoleAssignRecords> getConditionsPage(Criteria criteria,PMPage page){
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
	    	List<RoleAssignRecords> list = criteria.list();
	    	return list;
    }
    private int getNumConditionsPage(Criteria criteria){
    	criteria.setProjection(Projections.rowCount());
    	int listCount = (Integer) criteria.uniqueResult();
    	return listCount;
    }
	private void getCommASInfos(Criteria criteria,RoleAssignRecords roleAssignRecords)
	{
			if(!(roleAssignRecords == null))
			{
					if(!(roleAssignRecords.getUser()==null) && !(roleAssignRecords.getUser().trim()==""))
					{
						criteria.add(Restrictions.like("user", "%"+roleAssignRecords.getUser()+"%"));
					}
					if(!(roleAssignRecords.getOperator()==null) && !(roleAssignRecords.getOperator().trim()==""))
					{
						criteria.add(Restrictions.like("operator", "%"+roleAssignRecords.getOperator()+"%"));
					}
					if(!(roleAssignRecords.getRole() == null) && !(roleAssignRecords.getRole().getName() == null))
					{
						criteria.add(Restrictions.eq("role.name", roleAssignRecords.getRole().getName()));
					}
					if(!(roleAssignRecords.getAppSys() == null) && !(roleAssignRecords.getAppSys().getName() == null))
					{
						criteria.add(Restrictions.eq("appSys.name", roleAssignRecords.getAppSys().getName()));
					}
					if(!(roleAssignRecords.getAppSys() == null) && roleAssignRecords.getAppSys().getId() > 0)
					{
						criteria.add(Restrictions.eq("appSys.id", roleAssignRecords.getAppSys().getId()));
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
	private int findNumConditionsInfo(RoleAssignRecords roleAssignRecords,PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
			Criteria criteria = this.getSession().createCriteria(RoleAssignRecords.class);
			getCommASInfos(criteria,roleAssignRecords);
			findConditionsDate(criteria,startRecordTime,endRecordTime);
			return getNumConditionsPage(criteria);
	}
}
