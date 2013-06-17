package edu.sjtu.infosec.ismp.manager.VPM.vm.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertStatDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopVirus;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.Virus;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsStat;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;

public class VirusAlertStatDaoImpl extends HibernateDaoSupport implements VirusAlertStatDao {

	public void addVirusAlertStat(VirusAlertsStat virusAlertStat)
			throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertStat);
	}

	public void deleteVirusAlertStat(VirusAlertsStat virusAlertStat)
			throws Exception {
		getHibernateTemplate().delete(virusAlertStat);
	}

	public void updateVirusAlertStat(VirusAlertsStat virusAlertStat)
			throws Exception {
		getHibernateTemplate().saveOrUpdate(virusAlertStat);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findAllVirusAlertStat() throws Exception {
		List<VirusAlertsStat> list = getHibernateTemplate().loadAll(VirusAlertsStat.class);
		return list;
	}

	public VirusAlertsStat findVirusAlertStatById(int id) throws Exception {
		VirusAlertsStat virusAlertStat = (VirusAlertsStat)getHibernateTemplate().get(VirusAlertsStat.class, id);
		return virusAlertStat;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findAllByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<VirusAlertsStat> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findAllByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "from VirusAlertsStat vas ";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " where (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}else{
			hql = hql + " where 1=1 ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<VirusAlertsStat> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByVirusClients(VirusClients virusClients,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusAlertsStat vas ";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " where (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}else{
			hql = hql + " where 1=1 ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findKilledByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		hql = hql +" and vas.killResult.id in (4,6,14,15)";
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<VirusAlertsStat> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findKilledByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "from VirusAlertsStat vas ";
		hql = hql +" where vas.killResult.id in (4,6,14,15)";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " and (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<VirusAlertsStat> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findKilledNumByVirusClients(VirusClients virusClients,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		hql = hql +" and vas.killResult.id in (4,6,14,15)";
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findKilledNumByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusAlertsStat vas ";
		hql = hql +" where vas.killResult.id in (4,6,14,15)";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " and (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findUnkilledByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		hql = hql +" and vas.killResult.id not in (4,6,14,15)";
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<VirusAlertsStat> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findUnkilledByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "from VirusAlertsStat vas ";
		hql = hql +" where vas.killResult.id not in (4,6,14,15)";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " and (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<VirusAlertsStat> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findUnkilledNumByVirusClients(VirusClients virusClients,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		hql = hql +" and vas.killResult.id not in (4,6,14,15)";
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findUnkilledNumByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from VirusAlertsStat vas ";
		hql = hql +" where vas.killResult.id not in (4,6,14,15)";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " and (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findAllVirusAlertStat(int startResult,
			int maxResult) throws Exception {
		String hql = "from VirusAlertsStat order by lastFindTime desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsStat> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findAllByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusAlertsStat vas ";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " where (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}else{
			hql = hql + " where 1=1 ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		hql = hql + " order by vas.lastFindTime desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsStat> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findKilledByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusAlertsStat vas ";
		hql = hql +" where vas.killResult.id in (4,6,14,15)";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " and (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		hql = hql + " order by vas.lastFindTime desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsStat> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findUnkilledByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusAlertsStat vas ";
		hql = hql +" where vas.killResult.id not in (4,6,14,15)";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " and (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		hql = hql + " order by vas.lastFindTime desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsStat> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findAllByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		hql = hql + " order by vas.lastFindTime desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsStat> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findKilledByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		hql = hql +" and vas.killResult.id in (4,6,14,15)";
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		hql = hql + " order by vas.lastFindTime desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsStat> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<VirusAlertsStat> findUnkilledByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		hql = hql +" and vas.killResult.id not in (4,6,14,15)";
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		hql = hql + " order by vas.lastFindTime desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<VirusAlertsStat> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum() throws Exception {
		String hql = "select count(id) from VirusAlertsStat";
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List<TopVirus> findTopVirusCountByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime, int topNum) throws Exception {
		String hql = "select sum(vcount) as virusCount,virus from VirusAlertsStat vas where vas.virusClients.id=" + virusClients.getId();
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		hql = hql + " group by vas.virus.id order by sum(vcount) desc";
//		System.out.println("hql:="+hql);
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(topNum);
		List<Object[]> oList = query.list();
		List<TopVirus> list = null;
		if(oList!=null && oList.size()>0){
			list = new ArrayList<TopVirus>();
			for(Object[] o : oList){
				TopVirus tv = new TopVirus();
				tv.setVirusCount((Long)o[0]);
				tv.setVirus((Virus)o[1]);
				list.add(tv);
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<TopVirus> findTopVirusCountByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int topNum) throws Exception {
		String hql = "select sum(vcount) as virusCount,virus from VirusAlertsStat vas where 1=1 ";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " and (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		hql = hql + " group by vas.virus.id order by sum(vcount) desc";
//		System.out.println("hql:="+hql);
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(topNum);
		List<Object[]> oList = query.list();
		List<TopVirus> list = null;
		if(oList!=null && oList.size()>0){
			list = new ArrayList<TopVirus>();
			for(Object[] o : oList){
				TopVirus tv = new TopVirus();
				tv.setVirusCount((Long)o[0]);
				tv.setVirus((Virus)o[1]);
				list.add(tv);
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<TopClients> findTopClientsCountByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int topNum) throws Exception {
		String hql = "select sum(vcount) as virusCount,virusClients from VirusAlertsStat vas where 1=1 ";
		int i = 0;
		for(VirusClients vc : virusClientsList){
			if(i == 0){
				hql = hql + " and (vas.virusClients.id=" + vc.getId();
			}
			if(i > 0){
				hql = hql + " or vas.virusClients.id=" + vc.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		if(startRecordTime != null){
			hql = hql + " and vas.lastFindTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and vas.lastFindTime<='"+endRecordTime+"' ";
		}
		hql = hql + " group by vas.virusClients.id order by sum(vcount) desc";
//		System.out.println("hql:="+hql);
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(topNum);
		List<Object[]> oList = query.list();
		List<TopClients> list = null;
		if(oList!=null && oList.size()>0){
			list = new ArrayList<TopClients>();
			for(Object[] o : oList){
				TopClients tc = new TopClients();
				tc.setVirusCount((Long)o[0]);
				tc.setVirusClients((VirusClients)o[1]);
				list.add(tc);
			}
		}
		return list;
	}

}
