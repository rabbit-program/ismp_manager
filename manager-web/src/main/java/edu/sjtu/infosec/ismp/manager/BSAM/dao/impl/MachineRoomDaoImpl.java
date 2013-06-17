package edu.sjtu.infosec.ismp.manager.BSAM.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDaoHibernate;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineRoomDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineRoom;
import edu.sjtu.infosec.ismp.security.Domain;

public class MachineRoomDaoImpl extends BaseDaoHibernate implements MachineRoomDao {
	
	@SuppressWarnings("unchecked")
	public List getMachineRoomList() {
		StringBuffer hql = new StringBuffer("from MachineRoom order by id ");
		return getHibernateTemplate().find(hql.toString());
	}

	@SuppressWarnings("unchecked")
	public List getMachineRoomList(int startResult, int maxResult) {
		String hql = "from MachineRoom order by id ";
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineRoomListByDomain(List<Domain> userDomainList,int startResult, int maxResult) {
		
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
		
		StringBuffer hql = new StringBuffer("from MachineRoom a where 1=1 and a.domain.id in (" + userDomainStr + ") ");
		Query query = this.getSession().createQuery(hql.toString());
//		query.setString("userDomainStr", userDomainStr.toString());///cc?:不知道为什么在HQL中这种方式不可以，赋值错误
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineRoomListByDomain(List<Domain> userDomainList) {
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
		
		StringBuffer hql = new StringBuffer("from MachineRoom a where 1=1 and a.domain.id in (" + userDomainStr + ") ");
		Query query = this.getSession().createQuery(hql.toString());
//		query.setString("userDomainStr", userDomainStr.toString());///cc?:不知道为什么在HQL中这种方式不可以，赋值错误
		
		return query.list();
	}
	
	public void saveOrUpdateMachineRoom(MachineRoom machineRoom) {
		this.getHibernateTemplate().saveOrUpdate(machineRoom);
	}

	@SuppressWarnings("unchecked")
	public int getCount() {
		int num = 0;
		List list=getHibernateTemplate().find("from MachineRoom");
		if (null != list && list.size() > 0) {
			num = list.size();
		}
		return num;
	}

	public int getCountByDomain(List<Domain> userDomainList) {
		
		if(null == userDomainList || userDomainList.size() <= 0){
			return 0;
		}
		
		int num = 0;
		StringBuffer userDomainStr = new StringBuffer();
		
		///遍历userDomainList,将domain的id组成一个字符串
		for (int i = 0; i < userDomainList.size(); i++) {
			if(i != (userDomainList.size()-1)){
				userDomainStr.append(userDomainList.get(i).getId()).append(",");
			}else{
				userDomainStr.append(userDomainList.get(i).getId());
			}
		}
		
		StringBuffer hql = new StringBuffer("from MachineRoom a where 1=1 and a.domain.id in (" + userDomainStr + ") ");
		Query query = this.getSession().createQuery(hql.toString());
//		query.setString("userDomainStr", userDomainStr.toString());///cc?:不知道为什么在HQL中这种方式不可以，赋值错误
		
		if (null != query.list()&& query.list().size() > 0) {
			num = query.list().size();
		}
		return num;
	}
	
	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id,int startResult, int maxResult) {
		/**原生SQL：取得机房的下级单元（即机柜和主机），并且先按照type排序，然后按照id
		select c.id,c.name,c.type from (
			select a.id as id,a.machine_cabinet_name as name,'JiGui' as type from bsam_machine_cabinet a where 1=1 
				and a.machine_room_id = 21
			union
			select b.id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1 
				and b.machine_room_id = 21
		) c order by c.type,c.id
		 **/
		StringBuffer sql = new StringBuffer(" select c.id,c.name,c.type from (  \n");
		sql.append(" select a.id as id,a.machine_cabinet_name as name,'JiGui' as type from bsam_machine_cabinet a where 1=1 \n");
		sql.append(" and a.machine_room_id = ");
		sql.append(id);
		sql.append(" \n union \n");
		sql.append(" select b.id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1  \n");
		sql.append(" and b.machine_room_id = ");
		sql.append(id);
		sql.append(" \n ) c order by c.type,c.id \n");
		Query query = this.getSession().createSQLQuery(sql.toString());
		///分页
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id) {
		/**原生SQL：取得机房的下级单元（即机柜和主机），并且先按照type排序，然后按照id
		select c.id,c.name,c.type from (
			select a.id as id,a.machine_cabinet_name as name,'JiGui' as type from bsam_machine_cabinet a where 1=1 
				and a.machine_room_id = 21
			union
			select b.id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1 
				and b.machine_room_id = 21
		) c order by c.type,c.id
		**/
		StringBuffer sql = new StringBuffer(" select c.id,c.name,c.type from (  \n");
		sql.append(" select a.id as id,a.machine_cabinet_name as name,'JiGui' as type from bsam_machine_cabinet a where 1=1 \n");
		sql.append(" and a.machine_room_id = ");
		sql.append(id);
		sql.append(" \n union \n");
		sql.append(" select b.id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1  \n");
		sql.append(" and b.machine_room_id = ");
		sql.append(id);
		sql.append(" \n ) c order by c.type,c.id \n");
		Query query = this.getSession().createSQLQuery(sql.toString());
		
		return query.list();
	}

	public int getSubUnitCountById(String id) {
		
		StringBuffer sql = new StringBuffer(" select c.id,c.name,c.type from (  \n");
		sql.append(" select a.id as id,a.machine_cabinet_name as name,'JiGui' as type from bsam_machine_cabinet a where 1=1 \n");
		sql.append(" and a.machine_room_id = ");
		sql.append(id);
		sql.append(" \n union \n");
		sql.append(" select b.id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1  \n");
		sql.append(" and b.machine_room_id = ");
		sql.append(id);
		sql.append(" \n ) c order by c.type,c.id \n");
		Query query = this.getSession().createSQLQuery(sql.toString());
		
		int num = 0;
		if (null != query.list()&& query.list().size() > 0) {
			num = query.list().size();
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public List<MachineRoom> getMachineRoomByName(String name) {
		
		StringBuffer hql = new StringBuffer("from MachineRoom a where 1=1 and a.machineRoomName = :name ");
		
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("name", name);
		return query.list();
	}

//	===========================================================
}
