package edu.sjtu.infosec.ismp.manager.VPM.pm.dao.impl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.pm.dao.SensorClientsDao;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.security.Domain;

public class SensorClientsDaoImpl extends HibernateDaoSupport implements SensorClientsDao{

	@SuppressWarnings("unchecked")
	public LinkedList getSensorInfos(SensorClients sensorClients,
			Integer startResult, Integer maxResult, Date startDate,Date endDate) {
			Criteria criteria = getCriteria();
			getCommSensorClientsInfos(criteria,sensorClients,null);
			getCommSensorClientsInfos(criteria,startDate,endDate,"operateTime");	
	 return getCommSensorClientsInfosPage(criteria,startResult,maxResult);
	}


	/**
	 * 查询条件私有方法
	 * @param doMain 委办局
	 * @param sensorClients 客户端
	 * @param startDate 起始时间
	 * @param endDate 末时间
	 * @return
	 */
	private void getCommSensorClientsInfos(Criteria criteria,List<Integer> doMain,SensorClients sensorClients, Date startDate,Date endDate)
	{
		getCommSensorClientsInfos(criteria,doMain);
		getCommSensorClientsInfos(criteria,sensorClients,null);
	 	getCommSensorClientsInfos(criteria,startDate,endDate,"operateTime");
	}
	/**
	 * 获取查询对象
	 * @return
	 */
	private Criteria getCriteria()
	{
		Session session = this.getSession();
		Criteria criteria= session.createCriteria(SensorClients.class);
		releaseSession(session);
		return criteria;
	}
	
	/**
	 * 根据doMain 查询
	 * @param criteria 对象
	 * @param doMain 集合
	 * @return
	 */
	private void getCommSensorClientsInfos(Criteria criteria,List<Integer> doMain)
	{

			if(!(doMain == null) && !(doMain.isEmpty()))
			{
				criteria.add(Restrictions.in("department", doMain));
			}

	}
	
	/**
	 * 根据日期查询
	 * @param criteria 对象
	 * @param startDate 起始时间
	 * @param endDate 末时间
	 * @return
	 */
	private void getCommSensorClientsInfos(Criteria criteria, Date startDate,Date endDate,String date)
	{
			if(!(startDate==null) && !(endDate == null))
			{
				criteria.add(Restrictions.ge(date, startDate)).add(Restrictions.le(date, endDate));
			}
			if(!(startDate == null) && endDate == null)
			{
				criteria.add(Restrictions.ge(date, startDate)).add(Restrictions.le(date, new Date()));
			}
			if(startDate == null && !(endDate == null))
			{
				criteria.add(Restrictions.le(date, endDate));
			}
	}
	/**
	 * 根据SensorClients 查询
	 * @param criteria 对象
	 * @param sensorClients 对象
 	 * @return
	 */
	private void getCommSensorClientsInfos(Criteria criteria,SensorClients sensorClients,List<Domain> list)
	{
			if(!(sensorClients == null))
			{
				if(!(sensorClients.getName()==null) && !(sensorClients.getName().trim()==""))
				{
					criteria.add(Restrictions.like("name", "%"+sensorClients.getName()+"%"));
				}
				if(!(sensorClients.getSensorIP() == null) && !(sensorClients.getSensorIP().trim()==""))
				{
					criteria.add(Restrictions.like("sensorIP", "%"+sensorClients.getSensorIP()+"%"));
				}
				if(!(sensorClients.getDepartment()==null) && sensorClients.getDepartment().getId() > 0)
				{
					criteria.add(Restrictions.eq("department.id", sensorClients.getDepartment().getId()));
				}
			}
			criteria.add( list == null || list.isEmpty() ? Restrictions.eq("department", null) : Restrictions.in("department", list));
	}
	
	/**
	 * 查询分页
	 * @param criteria Criteriad 对象
	 * @param startResult 起始条数
	 * @param maxResult 显示多少条
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private LinkedList getCommSensorClientsInfosPage(Criteria criteria,Integer startResult, Integer maxResult)
	{
		criteria.add(Restrictions.isNotNull("department.id"));
		criteria.setProjection(Projections.count("id"));
		List listCount = criteria.list();
		if(startResult > -1)
		{
		  criteria.setFirstResult(startResult);
		}
		if(maxResult > -1)
		{
		   criteria.setMaxResults(maxResult);
		}
		criteria.setProjection(null);
		List list = criteria.list();
		List<SensorClients> listSC = new ArrayList<SensorClients>();
		synchronized (listSC) {
			for(Object obj : list)
			{
				Object[] object =(Object[]) obj;
				for(Object ob : object)
				{
					if(ob instanceof SensorClients)
					{
						listSC.add((SensorClients) ob);
					}
				}
			}
		}
		LinkedList linkList = new LinkedList();
		linkList.addFirst(listCount.get(0));
		linkList.addLast(listSC); 
		return linkList;
	}

	@SuppressWarnings("unchecked")
	public LinkedList getSensorInfosByManagerId(
			List<Integer> doMain,SensorClients sensorClients,Integer startResult,
			Integer maxResult, Date startDate,Date endDate) {
		 Criteria criteria = getCriteria();
		 getCommSensorClientsInfos(criteria,doMain,sensorClients,startDate,endDate);
		return getCommSensorClientsInfosPage(criteria,startResult,maxResult);
	}


	public void saveOrUpdateSensorClients(SensorClients sensorClients) {
		getHibernateTemplate().saveOrUpdate(sensorClients);
		getHibernateTemplate().flush();
	}

	public SensorClients getSensorClients(int id) {
		SensorClients sensorClients = (SensorClients)getHibernateTemplate().get(SensorClients.class, id);   
		return sensorClients; 
	}
	
	@SuppressWarnings("unchecked")
	public List<SensorClients> getSensorInfosByManagerId(SensorClients doMainId) {
		 Criteria criteria = getCriteria();
	     getCommSensorClientsInfos(criteria,doMainId,null);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<SensorClients> getUnallocatedSensorInfos() {
		 Criteria criteria = getCriteria();
		 criteria.add(Restrictions.isNull("department"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public LinkedList getSensorInfosByManagerId(SensorClients doMainId,Integer startResult, Integer maxResult,Date startDate,Date endDate) {
		 Criteria criteria = getCriteria();
		 getCommSensorClientsInfos(criteria,doMainId,null);
		 getCommSensorClientsInfos(criteria,startDate,endDate,"operateTime");
		return getCommSensorClientsInfosPage(criteria,startResult,maxResult);
	}

	@SuppressWarnings("unchecked")
	public List<SensorClients> getSensorInfosByDoMainId(Integer domainId) {
		return	this.getCriteria().add(Restrictions.eq("department.id", domainId)).list();
	}


	public LinkedList getSensorInfosAll(List<Domain> list,Integer startResult, Integer maxResult,
			Date startDate, Date endDate) {
	    Criteria criteria = getCriteria();
	    getCommSensorClientsInfos(criteria,null,list);
	    getCommSensorClientsInfos(criteria,startDate,endDate,"operateTime");
	    return   getCommSensorClientsInfosPage(criteria,startResult,maxResult);
	}


	public LinkedList getSensorInfosByTactics(SensorClients sensorClients,
			Integer startResult, Integer maxResult, Date startDate, Date endDate) {
		Criteria criteria = getCriteria();
		getCommSensorClientsInfos(criteria,sensorClients,null);
		if(!(startDate==null) && !(endDate == null))
		{
			criteria.createCriteria("patchUpdateTactics").add(Restrictions.ge("lastChangeTime", startDate)).add(Restrictions.le("lastChangeTime", endDate));
		}
		if(!(startDate == null) && endDate == null)
		{
			criteria.createCriteria("patchUpdateTactics").add(Restrictions.ge("lastChangeTime", startDate)).add(Restrictions.le("lastChangeTime", new Date()));
		}
		if(startDate == null && !(endDate == null))
		{
			criteria.createCriteria("patchUpdateTactics").add(Restrictions.le("lastChangeTime", endDate));
		}
		return  getCommSensorClientsInfosPage(criteria,startResult,maxResult);
		 
	}


	public LinkedList getSensorInfos(List<Domain> list,
			SensorClients sensorClients, Integer startResult,
			Integer maxResult, Date startDate, Date endDate) {
		Criteria criteria = getCriteria();
		getCommSensorClientsInfos(criteria,sensorClients,list);
		getCommSensorClientsInfos(criteria,startDate,endDate,"operateTime");	
        return getCommSensorClientsInfosPage(criteria,startResult,maxResult);
	}
}
