package edu.sjtu.infosec.ismp.manager.VPM.sd.dao.impl;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.sd.dao.SoftwareManagerDao;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.SoftwareInfo;
public class SoftwareManagerDaoImpl extends HibernateDaoSupport implements SoftwareManagerDao  {
	
	//private static Logger logger = Logger.getLogger(SoftwareManagerDaoImpl.class);

	public void del(SoftwareInfo softwareInfo) {
	 String hql = "delete from SoftwareInfo s where s.id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, softwareInfo.getId());
		query.executeUpdate();
	}

	public void save(SoftwareInfo softwareInfo) {
		getHibernateTemplate().save(softwareInfo);
	}

	@SuppressWarnings("unchecked")
	public List<SoftwareInfo> searchAll() {
		return getSession().createQuery("from SoftwareInfo").list();
	}

	@SuppressWarnings("unchecked")
	public List<SoftwareInfo> searchByConditions(SoftwareInfo softwareInfo,PMPage page,Timestamp uploadStartTime,Timestamp uploadEndTime){
		Criteria criteria = getCriteria();
		conditionQuery(softwareInfo,criteria,uploadStartTime,uploadEndTime);
		criteria.setFirstResult(page.getBeginIndex());
	    criteria.setMaxResults(page.getEveryPage());
	   return  criteria.list();
	}
	public Object searchByConditionsCount(SoftwareInfo softwareInfo, PMPage page,
			Timestamp uploadStartTime, Timestamp uploadEndTime) {
			Criteria criteria = getCriteria();
			conditionQuery(softwareInfo,criteria,uploadStartTime,uploadEndTime);
			criteria.setProjection(Projections.count("id"));
		return  criteria.uniqueResult();
	}
	
	private void conditionQuery(SoftwareInfo softwareInfo,Criteria criteria,Timestamp uploadStartTime,Timestamp uploadStopTime){
		if(!(softwareInfo == null))
		{
			if(HtmlFactory.isNotEmpty(softwareInfo.getName()))
			{
				criteria.add(Restrictions.like("name", "%"+softwareInfo.getName()+"%"));
			}
			//软件上传时间 start 
			if(!(uploadStartTime==null) && !(uploadStopTime == null))
			{
				criteria.add(Restrictions.ge("uploadTime", uploadStartTime)).add(Restrictions.le("uploadTime", uploadStopTime));
			}
			if(!(uploadStartTime == null) && uploadStopTime == null)
			{
				criteria.add(Restrictions.ge("uploadTime", uploadStartTime)).add(Restrictions.le("uploadTime", new Date()));
			}
			if(uploadStartTime == null && !(uploadStopTime == null))
			{
				criteria.add(Restrictions.le("uploadTime", uploadStopTime));
			}
			//软件上传时间 stop
			//执行策略
			if(!(softwareInfo.getExecutePolicy().getExecuteCheckTag() == null))
			{ 
				criteria.createCriteria("executePolicy").add(Restrictions.eq("executeCheckTag", softwareInfo.getExecutePolicy().getExecuteCheckTag()));
			}
			//软件类型:
			if( HtmlFactory.isNotEmpty(softwareInfo.getType()))
			{ 
				criteria.add(Restrictions.eq("type", softwareInfo.getType()));
			}
			//软件分发起始日期 start 
			Criteria c = criteria.createCriteria("dispatchPolicy");
			if(!(softwareInfo.getDispatchPolicy().getDispatchStartDate()==null))
			{
				c.add(Restrictions.ge("dispatchStartDate", softwareInfo.getDispatchPolicy().getDispatchStartDate()));
			}
			if(!(softwareInfo.getDispatchPolicy().getDispatchEndDate()==null))
			{
				c.add(Restrictions.le("dispatchStartDate",  softwareInfo.getDispatchPolicy().getDispatchStartDate()));
			}
		    //软件分发起始日期 stop 
			
			//验证策略
			if(!(softwareInfo.getValidatePolicy().getValidateCheckTag() == null))
			{ 
				criteria.createCriteria("validatePolicy").add(Restrictions.eq("validateCheckTag", softwareInfo.getValidatePolicy().getValidateCheckTag()));
			}
			//软件类别
			if(!(softwareInfo.getTypeInfo().getId() == null) && softwareInfo.getTypeInfo().getId() > 0)
			{ 
				criteria.add(Restrictions.eq("typeInfo.id", softwareInfo.getTypeInfo().getId()));
			}
			//分发状 态
			if(!(softwareInfo.getDispatchPolicy().getConsistencyCheckTag()==null))
			{ 
				criteria.createCriteria("dispatchPolicy").add(Restrictions.eq("dispatchCheckTag", softwareInfo.getDispatchPolicy().getConsistencyCheckTag()));
			}
		}
	}
	
	private Criteria getCriteria()
	{
		Session session = this.getSession();
		Criteria criteria= session.createCriteria(SoftwareInfo.class);
		return criteria;
	}

	public SoftwareInfo searchById(Integer id) {
		return (SoftwareInfo) getSession().get(SoftwareInfo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<SoftwareInfo> searchByType(Integer typeId) {
		 String hql = "from SoftwareInfo s where s.typeInfo=?";
			Query query = getSession().createQuery(hql);
			query.setInteger(0, typeId);
	    return query.list();
	}

	public void update(SoftwareInfo softwareInfo) {
		getHibernateTemplate().update(softwareInfo);
	}



	
}