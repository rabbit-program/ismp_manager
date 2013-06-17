package edu.sjtu.infosec.ismp.manager.VPM.pm.dao.impl;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.dao.PatchTacticsDao;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateTactics;
public class PatchTacticsDaoImpl  extends HibernateDaoSupport implements PatchTacticsDao {
	
    /**
     * 根据条件查询 PatchUpdateTactics 返回分页数，即查询条件集合
     * @param patchTactics 对象
     * @param startResult 起始
     * @param maxResult 显示个数
     * @param startDate 起始时间
     * @param endDate 末时间
     * @return
     */
	@SuppressWarnings("unchecked")
	public LinkedList getTacticsInfos(PatchUpdateTactics patchTactics,
			Integer startResult, Integer maxResult, Date startDate, Date endDate) {
		     Criteria criteria = getCriteria();
		     getCommPatchTacticsInfos(criteria,patchTactics);
		     getCommPatchTacticsInfos(criteria,startDate,endDate);
		return getCommPatchTacticsInfos(criteria,startResult,maxResult);
	}

	public String getGlobalPatchUpdateTactics() {
		String hql = "select proValue from DefProConfig dp where dp.proName = 'globalPatchUpdateTactics'";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		return (String)query.uniqueResult();
	}
	
	public void setGlobalPatchUpdateTactics(int patchUpdateTacticsId) {
		String hql = "update DefProConfig dp set dp.proValue =:patchUpdateTacticsId where dp.proName = 'globalPatchUpdateTactics'";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setParameter("patchUpdateTacticsId", String.valueOf(patchUpdateTacticsId));
		query.executeUpdate();
	}
	
	public String getDefAddress() {
		String hql = "select proValue from DefProConfig dp where dp.proName = 'defAddress'";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		return (String)query.uniqueResult();
	}

	public void saveOrUpdatePatchUpdateTactics(
			PatchUpdateTactics patchUpdateTactics) {
	getHibernateTemplate().saveOrUpdate(patchUpdateTactics);
	getHibernateTemplate().flush();
	}
	
    public void delPatchUpdateTactics(int stId){
    	String hql = "delete from PatchUpdateTactics put where put.id =:stId";
		Query query = getSession().createQuery(hql);
		query.setParameter("stId", stId); 
		query.executeUpdate();
	}

	public PatchUpdateTactics getPachStrategyById(int pachStrategyId) {
		String hql = "from PatchUpdateTactics put where put.id =" + pachStrategyId;
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		return (PatchUpdateTactics)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<PatchUpdateTactics> getAllPachStrategy() {
		return getCriteria().list();
	}
	/**
	 * 获取查询对象
	 * @return
	 */
	private Criteria getCriteria()
	{
		Session session = this.getSession();
		Criteria criteria= session.createCriteria(PatchUpdateTactics.class);
		releaseSession(session);
		return criteria;
	}
	/**
	 * 根据日期查询
	 * @param criteria 对象
	 * @param startDate 起始时间
	 * @param endDate 末时间
	 * @return
	 */
	private void getCommPatchTacticsInfos(Criteria criteria, Date startDate,Date endDate)
	{
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
	/**
	 * 根据PatchTactics 查询
	 * @param criteria 对象
	 * @param PatchTactics 对象
 	 * @return
	 */
	private Criteria getCommPatchTacticsInfos(Criteria criteria,PatchUpdateTactics patchTacties)
	{
		if(!(patchTacties == null))
		{
			if(HtmlFactory.isNotEmpty(patchTacties.getName()))
			{
				criteria.add(Restrictions.like("name", "%"+patchTacties.getName()+"%"));
			}
		}
		return criteria;
	}
	/**
	 * 查询分页
	 * @param criteria Criteriad 对象
	 * @param startResult 起始条数
	 * @param maxResult 显示多少条
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private LinkedList getCommPatchTacticsInfos(Criteria criteria,Integer startResult, Integer maxResult)
	{
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
		LinkedList linkList = new LinkedList();
		linkList.addFirst(listCount.get(0));
		linkList.addLast(list); 
		return linkList;
	}


}
