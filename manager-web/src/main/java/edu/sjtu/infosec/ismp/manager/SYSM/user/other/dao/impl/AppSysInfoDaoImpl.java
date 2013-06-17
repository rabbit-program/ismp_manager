package edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao.AppSysInfoDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.security.Domain;

public class AppSysInfoDaoImpl extends HibernateDaoSupport implements AppSysInfoDao , Cloneable{

	public void add(AppSysInfo appSysInfo) throws Exception {
		getHibernateTemplate().save(appSysInfo);
	}

	public void delete(AppSysInfo appSysInfo) throws Exception {
		getHibernateTemplate().delete(appSysInfo);
	}

	public void update(AppSysInfo appSysInfo) throws Exception {
		getHibernateTemplate().saveOrUpdate(appSysInfo);
		getHibernateTemplate().flush();
	}

	public List<AppSysInfo> findAll() throws Exception {
		List<AppSysInfo> list = getHibernateTemplate().loadAll(AppSysInfo.class);
		return list;
	}

	public AppSysInfo findById(int id) throws Exception {
		AppSysInfo appSysInfo = (AppSysInfo)getHibernateTemplate().get(AppSysInfo.class, id);
		return appSysInfo;
	}

	public List<AppSysInfo> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		return getConditionsPage(this.getSession().createCriteria(AppSysInfo.class),null);
	}

	public List<AppSysInfo> findAllByDomain(List<Domain> domainList)
			throws Exception {
		return findConditionsInfo(null,domainList, null,null,null);
	}

	public List<AppSysInfo> findAllByDomain(List<Domain> domainList,
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

	public List<AppSysInfo> findConditionsInfo(AppSysInfo syInfo,
			List<Domain> domainList, PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
		Criteria criteria = this.getSession().createCriteria(AppSysInfo.class);
		getCommASInfos(criteria,syInfo,domainList);
		findConditionsDate(criteria,startRecordTime,endRecordTime);
	    int count=findNumConditionsInfo(syInfo, domainList, page, startRecordTime, endRecordTime);
	    page.setPageInfo(PMPageUtil.createPage(page, count));
		return getConditionsPage(criteria,page);
	}
	
    @SuppressWarnings("unchecked")
	private List<AppSysInfo> getConditionsPage(Criteria criteria,PMPage page){
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
	    	List<AppSysInfo> list = criteria.list();
	    	return list;
    }
    private int getNumConditionsPage(Criteria criteria){
    	criteria.setProjection(Projections.rowCount());
    	int listCount = (Integer) criteria.uniqueResult();
    	return listCount;
    }
	private void getCommASInfos(Criteria criteria,AppSysInfo appSysInfo,List<Domain> domainList)
	{
			if(!(appSysInfo == null))
			{
					if(!(appSysInfo.getName()==null) && !(appSysInfo.getName().trim()==""))
					{
						criteria.add(Restrictions.like("name", "%"+appSysInfo.getName()+"%"));
					}
					if(!(appSysInfo.getDomain()==null) && appSysInfo.getDomain().getId() > 0)
					{
						criteria.add(Restrictions.eq("domain.id", appSysInfo.getDomain().getId()));
					}
					if(!(domainList == null) && domainList.size() > 0){
						criteria.add(Restrictions.in("domain", domainList));
					}
					criteria.add(Restrictions.isNotNull("domain.id"));
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

	private int findNumConditionsInfo(AppSysInfo syInfo,
			List<Domain> domainList, PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
			Criteria criteria = this.getSession().createCriteria(AppSysInfo.class);
			getCommASInfos(criteria,syInfo,domainList);
			findConditionsDate(criteria,startRecordTime,endRecordTime);
			return getNumConditionsPage(criteria);
	}
}
