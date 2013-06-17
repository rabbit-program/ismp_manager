package edu.sjtu.infosec.ismp.manager.ERM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.ERM.dao.LinkManDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.LinkMan;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.security.Domain;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	public void add(LinkMan linkMan) throws Exception {
		getHibernateTemplate().saveOrUpdate(linkMan);
	}
   
	public void delete(LinkMan linkMan) throws Exception {
		getHibernateTemplate().delete(linkMan);
	}

	public void update(LinkMan linkMan) throws Exception {
		getHibernateTemplate().saveOrUpdate(linkMan);
		getHibernateTemplate().flush();
	}

	public List<LinkMan> findAll() throws Exception {
		List<LinkMan> list = getHibernateTemplate().loadAll(LinkMan.class);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<LinkMan> findAllByDomain(List<Domain> domainList)
			throws Exception {
		String hql = "from LinkMan lm where 1=1 ";
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (lm.respInfo.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or lm.respInfo.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}

		List<LinkMan> list = getHibernateTemplate().find(hql);
		return list;
	}

	public LinkMan findById(int id) {
		LinkMan linkMan = (LinkMan)getHibernateTemplate().get(LinkMan.class, id);
		return linkMan;
	}

	public List<LinkMan> findByRespInfo(RespInfoBO respInfo) {
		return findByRespInfoId(respInfo.getId());
	}

	@SuppressWarnings("unchecked")
	public List<LinkMan> findByRespInfoId(int id) {
		String hql = "from LinkMan lm where lm.respInfo.id="+id;
		List<LinkMan> list = getHibernateTemplate().find(hql);
		return list;
	}

	public void deleteLinkManByRespInfo(RespInfoBO resp) {
		Query query=this.getSession().createQuery("delete from LinkMan c where c.respInfo=:resp");
		query.setEntity("resp", resp);
		int i=query.executeUpdate();
	}

	public void saveorupdate(LinkMan linkman) {
		getHibernateTemplate().saveOrUpdate(linkman);
	}

	public boolean checkTeamId(Integer respid, String teamCode) {
		boolean exit = false;
		String hql = "from LinkMan c where c.respInfo.id=:respid and c.teamCode=:teamCode";
		Query query=this.getSession().createQuery(hql);
		query.setInteger("respid", respid);
		query.setString("teamCode", teamCode);
		List list = query.list();
		if(list!=null && list.size()>0) {
			exit = true;
		}
		return exit;
	}

	public Integer getMaxPid(Integer respid) {
		Integer maxPid = new Integer(0);
		List maxPidList = getHibernateTemplate().find("select max(pid) from LinkMan c where c.respInfo.id = ?", respid);
		Integer i=(Integer) maxPidList.get(0);
		if(i!=null) {
			maxPid = (Integer) maxPidList.get(0);
		}
		return maxPid;
	}

	public void deleteByPid(String s,String respid) {
		String hql = "delete from LinkMan c where c.respInfo.id =:respid and c.pid in ("+s+")";
		Query query = this.getSession().createQuery(hql);
		query.setInteger("respid", Integer.parseInt(respid));
		query.executeUpdate();
	}

	public List<LinkMan> queryByPid(Integer pid,String respid) {
		String hql = "from LinkMan c where c.fid=:pid and c.respInfo.id=:respid";
		Query query = this.getSession().createQuery(hql);
		query.setInteger("pid", pid);
		query.setInteger("respid", Integer.parseInt(respid));
		List<LinkMan> list = (List<LinkMan>)query.list();
		return list;
	}

	public LinkMan findByTeamId(String teamCode,String respid) {
		String hql = "from LinkMan c where c.teamCode=:teamCode and c.respInfo.id=:respid";
		Query query = this.getSession().createQuery(hql);
		query.setString("teamCode", teamCode);
		query.setInteger("respid", Integer.parseInt(respid));
		return (LinkMan) query.uniqueResult();
	}
}
