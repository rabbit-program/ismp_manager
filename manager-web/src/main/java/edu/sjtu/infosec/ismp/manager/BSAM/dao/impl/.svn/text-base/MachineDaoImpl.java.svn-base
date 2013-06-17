package edu.sjtu.infosec.ismp.manager.BSAM.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDaoHibernate;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.Machine;
import edu.sjtu.infosec.ismp.security.Domain;

public class MachineDaoImpl extends BaseDaoHibernate implements MachineDao {
	
	@SuppressWarnings("unchecked")
	public List getMachineList() {
		
		StringBuffer hql = new StringBuffer("from Machine");
		return getHibernateTemplate().find(hql.toString());
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineList(int startResult, int maxResult) {
		String hql = "from Machine order by id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineListByDomain(List<Domain> userDomainList,int startResult, int maxResult) {
		
		if(null == userDomainList || userDomainList.size() <= 0){
			return null;
		}
		
		StringBuffer userDomainStr = new StringBuffer();
		
		///遍历userDomainList,将domain的id组成一个字符串
		for (int i = 0; i < userDomainList.size(); i++) {
			if(i != (userDomainList.size()-1)){
				userDomainStr.append(userDomainList.get(i).getId()).append(",");
			}else{
				userDomainStr.append(userDomainList.get(i).getId());
			}
		}
		
		/**原生SQL
		select x.id,x.description,x.ip,x.machine_name,x.parent_type,
			   x.weight,x.machine_cabinet_id,x.machine_room_id,x.security_area_id from (
			select m.* from bsam_machine m 
				left join ismp_domain d on d.id = m.security_area_id where 1=1 and d.id in (1,2,3)
			union 
			select m.* from bsam_machine m 
				left join bsam_machine_cabinet mc on mc.id = m.machine_cabinet_id
				left join bsam_machine_room mr on mr.id = mc.machine_room_id 
				left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (1,2,3)
			union 
			select m.* from bsam_machine m 
				left join bsam_machine_room mr on mr.id = m.machine_room_id 
				left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (1,2,3)
		) x  order by 	x.id
		**/
		
		StringBuffer sql = new StringBuffer(" select x.id,x.description,x.ip,x.machine_name,x.parent_type, \n");
		sql.append(" x.weight,x.machine_cabinet_id,x.machine_room_id,x.security_area_id from (  \n");
		sql.append(" select m.* from bsam_machine m  \n ");
		sql.append(" left join ismp_domain d on d.id = m.security_area_id where 1=1 and d.id in (");
		sql.append(userDomainStr);
		sql.append(")   \n");
		sql.append(" union   \n");
		sql.append(" select m.* from bsam_machine m    \n");
		sql.append(" left join bsam_machine_cabinet mc on mc.id = m.machine_cabinet_id   \n");
		sql.append(" left join bsam_machine_room mr on mr.id = mc.machine_room_id   \n");
		sql.append(" left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (");
		sql.append(userDomainStr);
		sql.append(")   \n");
		sql.append(" union   \n");
		sql.append(" select m.* from bsam_machine m   \n");
		sql.append(" left join bsam_machine_room mr on mr.id = m.machine_room_id   \n");
		sql.append(" left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (");
		sql.append(userDomainStr);
		sql.append(")   \n");
		sql.append(" ) x  order by 	x.id \n");
		
		Query query = this.getSession().createSQLQuery(sql.toString());///这里用原生SQL.
		
//		query.setString("userDomainStr", userDomainStr.toString());///cc?:不知道为什么在HQL中这种方式不可以，赋值错误
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		
		return query.list();
	}
	
	public void saveOrUpdate(Machine machine) {
		getHibernateTemplate().saveOrUpdate(machine);
	}
	
	@SuppressWarnings("unchecked")
	public int getCount() {
		int num = 0;
		List list=getHibernateTemplate().find("from Machine");
		if (null != list && list.size() > 0) {
			num = list.size();
		}
		return num;
	}

	public int getCountByDomain(List<Domain> userDomainList) {
		
		if(null == userDomainList || userDomainList.size() <= 0){
			return 0;
		}
		
		StringBuffer userDomainStr = new StringBuffer();
		
		///遍历userDomainList,将domain的id组成一个字符串
		for (int i = 0; i < userDomainList.size(); i++) {
			if(i != (userDomainList.size()-1)){
				userDomainStr.append(userDomainList.get(i).getId()).append(",");
			}else{
				userDomainStr.append(userDomainList.get(i).getId());
			}
		}
		
		/**原生SQL
		select x.id,x.description,x.ip,x.machine_name,x.parent_type,
			   x.weight,x.security_area_id,x.machine_cabinet_id,x.machine_room_id from (
			select m.* from bsam_machine m 
				left join ismp_domain d on d.id = m.security_area_id where 1=1 and d.id in (1,2,3)
			union 
			select m.* from bsam_machine m 
				left join bsam_machine_cabinet mc on mc.id = m.machine_cabinet_id
				left join bsam_machine_room mr on mr.id = mc.machine_room_id 
				left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (1,2,3)
			union 
			select m.* from bsam_machine m 
				left join bsam_machine_room mr on mr.id = m.machine_room_id 
				left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (1,2,3)
		) x  order by 	x.id
		**/
		
		StringBuffer sql = new StringBuffer(" select x.id,x.description,x.ip,x.machine_name,x.parent_type, \n");
		sql.append(" x.weight,x.security_area_id,x.machine_cabinet_id,x.machine_room_id from (  \n");
		sql.append(" select m.* from bsam_machine m  \n ");
		sql.append(" left join ismp_domain d on d.id = m.security_area_id where 1=1 and d.id in (");
		sql.append(userDomainStr);
		sql.append(")   \n");
		sql.append(" union   \n");
		sql.append(" select m.* from bsam_machine m    \n");
		sql.append(" left join bsam_machine_cabinet mc on mc.id = m.machine_cabinet_id   \n");
		sql.append(" left join bsam_machine_room mr on mr.id = mc.machine_room_id   \n");
		sql.append(" left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (");
		sql.append(userDomainStr);
		sql.append(")   \n");
		sql.append(" union   \n");
		sql.append(" select m.* from bsam_machine m   \n");
		sql.append(" left join bsam_machine_room mr on mr.id = m.machine_room_id   \n");
		sql.append(" left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (");
		sql.append(userDomainStr);
		sql.append(")   \n");
		sql.append(" ) x  order by 	x.id \n");
		
		Query query = this.getSession().createSQLQuery(sql.toString());///因为HQL多表关联需要设置表关系，所以这里用原生SQL.
		
		int num = 0;
		if (null != query.list()&& query.list().size() > 0) {
			num = query.list().size();
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List getTopMachineListByWeight(int maxResult) {
		String hql = "from Machine order by weight desc";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(maxResult);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List getTopMachineListByWeightByDomain(List<Domain> userDomainList,int maxResult) {
		if(null == userDomainList || userDomainList.size() <= 0){
			return null;
		}
		StringBuffer userDomainStr = new StringBuffer();
		
		///遍历userDomainList,将domain的id组成一个字符串
		for (int i = 0; i < userDomainList.size(); i++) {
			if(i != (userDomainList.size()-1)){
				userDomainStr.append(userDomainList.get(i).getId()).append(",");
			}else{
				userDomainStr.append(userDomainList.get(i).getId());
			}
		}
		
		StringBuffer sql = new StringBuffer(" select x.id,x.description,x.ip,x.machine_name,x.parent_type, \n");
		sql.append(" x.weight,x.machine_cabinet_id,x.machine_room_id,x.security_area_id from (  \n");
		sql.append(" select m.* from bsam_machine m  \n ");
		sql.append(" left join ismp_domain d on d.id = m.security_area_id where 1=1 and d.id in (");
		sql.append(userDomainStr);
		sql.append(")   \n");
		sql.append(" union   \n");
		sql.append(" select m.* from bsam_machine m    \n");
		sql.append(" left join bsam_machine_cabinet mc on mc.id = m.machine_cabinet_id   \n");
		sql.append(" left join bsam_machine_room mr on mr.id = mc.machine_room_id   \n");
		sql.append(" left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (");
		sql.append(userDomainStr);
		sql.append(")   \n");
		sql.append(" union   \n");
		sql.append(" select m.* from bsam_machine m   \n");
		sql.append(" left join bsam_machine_room mr on mr.id = m.machine_room_id   \n");
		sql.append(" left join ismp_domain d on d.id = mr.security_area_id where 1=1 and d.id in (");
		sql.append(userDomainStr);
		sql.append(")   \n");
		sql.append(" ) x  order by 	x.weight desc \n");
		
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setMaxResults(maxResult);
		return query.list();
	}
}
