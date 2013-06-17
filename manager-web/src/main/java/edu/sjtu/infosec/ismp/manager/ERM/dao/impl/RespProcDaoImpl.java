package edu.sjtu.infosec.ismp.manager.ERM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.ERM.dao.RespProcDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.ContiRespProc;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.model.SafeThreatenInfo;


public class RespProcDaoImpl extends HibernateDaoSupport implements RespProcDao {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ContiRespProc> findRespProcByrespinfo(int pageNow,int pageSize,String id,String sid) {
		Criteria criteria = getSession().createCriteria(ContiRespProc.class)
												        .addOrder(Order.asc("id"))
												        .setFirstResult(pageNow)
														.setMaxResults(pageSize);
		if(id!=null ) {
			criteria.add(Expression.eq("respInfo.id", Integer.parseInt(id)));
		}
		if(sid!=null &&!"".equals(sid) ) {
			criteria.add(Expression.eq("safeThreaten.id", Integer.parseInt(sid)));
		}
		return criteria.list();
	}

	public List<SafeThreatenInfo> findSafeThreat() {
		Query query=this.getSession().createQuery("from SafeThreatenInfo");
		return (List<SafeThreatenInfo>)query.list();
	}

	public RespInfoBO findRespBoById(String id) {
		Query query=this.getSession().createQuery("from RespInfoBO r where r.id=:id");
		query.setString("id", id);
		return (RespInfoBO) query.uniqueResult();
	}

	public SafeThreatenInfo findSafeThreatenInfoById(String id) {
		Query query=this.getSession().createQuery("from SafeThreatenInfo r where r.id=:id");
		query.setString("id", id);
		return (SafeThreatenInfo) query.list().get(0);
	}

	public List<ContiRespProc> findallByTwoId(RespInfoBO rid,
			SafeThreatenInfo sid) {
		Query query=this.getSession().createQuery("from ContiRespProc c where c.respInfo=:rid and c.safeThreaten=:sid");
		query.setEntity("rid", rid);
		query.setEntity("sid", sid);
		return (List<ContiRespProc>)query.list();
	}

	public void delete(ContiRespProc con) {
		this.getSession().delete(con);
	}

	public void update(ContiRespProc con) {
		String sql="update ContiRespProc s set s.name=:name,s.content=:content where s.id=:id";
		Query query=this.getSession().createQuery(sql);
		query.setInteger("id", con.getId());
		query.setString("name", con.getName());
		query.setString("content",con.getContent());
		query.executeUpdate();
	}

	public void save(ContiRespProc con) {
		this.getSession().save(con);
	}

	public List<SafeThreatenInfo> findSafeNameById(String id) {
		Query query=this.getSession().createQuery("from SafeThreatenInfo s where s.id=:id");
		query.setInteger("id", Integer.parseInt(id));
		return (List<SafeThreatenInfo>)query.list();
		
	}

	public void deleteProcByRespInfo(RespInfoBO resp) {
		Query query=this.getSession().createQuery("delete from ContiRespProc c where c.respInfo=:resp");
		query.setEntity("resp", resp);
		int i=query.executeUpdate();
		//System.out.println("deleteProcByRespInfo==="+i);
	}

	@SuppressWarnings("deprecation")
	public int getCount(String respid,String safeid) {
		
		Criteria criteria = getSession().createCriteria(ContiRespProc.class)
											        .addOrder(Order.asc("id"));
		if(respid!=null ) {
			criteria.add(Expression.eq("respInfo.id", Integer.parseInt(respid)));
		}
		if(safeid!=null &&!"".equals(safeid)) {
			criteria.add(Expression.eq("safeThreaten.id", Integer.parseInt(safeid)));
		}
		return criteria.list().size();
	}
	
}
