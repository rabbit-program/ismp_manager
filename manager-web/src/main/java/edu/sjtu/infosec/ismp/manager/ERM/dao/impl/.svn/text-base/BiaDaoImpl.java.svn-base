package edu.sjtu.infosec.ismp.manager.ERM.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.ERM.dao.BiaDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.ContiBia;
import edu.sjtu.infosec.ismp.manager.ERM.model.PriorityLevel;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;

public class BiaDaoImpl extends HibernateDaoSupport implements BiaDao {

	public List<ContiBia> findBiaById(RespInfoBO resp) {
		Query query=this.getSession().createQuery("from ContiBia c where c.respInfo=:resp");
		query.setEntity("resp", resp);
		return (List<ContiBia>)query.list();
	}

	public List<RespInfoBO> findRespBoById(String id) {
		Query query=this.getSession().createQuery("from RespInfoBO r where r.id=:id");
		query.setString("id", id);
		return (List<RespInfoBO>)query.list();
	}

	public void saveorupdate(ContiBia contibia) {
		this.getSession().saveOrUpdate(contibia);
	}

	public PriorityLevel findPriByid(int id) {
		Query query=this.getSession().createQuery("from PriorityLevel p where p.id=:id");
		query.setInteger("id", id);
		List<PriorityLevel>  list=(List<PriorityLevel>)query.list();
		return list.get(0);
	}

	public List<PriorityLevel> findPrior() {
		Query query=this.getSession().createQuery("from PriorityLevel");
		return (List<PriorityLevel>)query.list();
	}

	public void deleteBiaByRespInfo(RespInfoBO resp) {
		String hql = "delete from ContiBia c where c.respInfo=:resp";
		Query query = this.getSession().createQuery(hql);
		query.setEntity("resp", resp);
		query.executeUpdate();
	}

}
