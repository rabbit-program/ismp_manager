package edu.sjtu.infosec.ismp.manager.BSAM.dao.impl;

import java.util.List;

import org.hibernate.Query;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDaoHibernate;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.SecurityAreaDao;

public class SecurityAreaDaoImpl extends BaseDaoHibernate implements SecurityAreaDao{

	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id,int startResult, int maxResult) {
		/**原生SQL：取得域的下级单元（即机房和主机），并且先按照type排序，然后按照id
		select c.id,c.name,c.type from (
			 select a.id as id,a.machine_room_name as name,'JiFang' as type from bsam_machine_room a where 1=1 
			 	and a.security_area_id = 8
			 union
			 select b.id as id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1 
			 	and b.security_area_id = 8
		) c order by c.type,c.id
		 **/
		StringBuffer sql = new StringBuffer(" select c.id,c.name,c.type from (  \n");
		sql.append(" select a.id as id,a.machine_room_name as name,'JiFang' as type from bsam_machine_room a where 1=1 \n");
		sql.append(" and a.security_area_id = ");
		sql.append(id);
		sql.append(" \n union \n");
		sql.append(" select b.id as id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1  \n");
		sql.append(" and b.security_area_id = ");
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
		/**原生SQL：取得域的下级单元（即机房和主机），并且先按照type排序，然后按照id
		select c.id,c.name,c.type from (
			 select a.id as id,a.machine_room_name as name,'JiFang' as type from bsam_machine_room a where 1=1 
			 	and a.security_area_id = 8
			 union
			 select b.id as id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1 
			 	and b.security_area_id = 8
		) c order by c.type,c.id
		**/
		StringBuffer sql = new StringBuffer(" select c.id,c.name,c.type from (  \n");
		sql.append(" select a.id as id,a.machine_room_name as name,'JiFang' as type from bsam_machine_room a where 1=1 \n");
		sql.append(" and a.security_area_id = ");
		sql.append(id);
		sql.append(" \n union \n");
		sql.append(" select b.id as id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1  \n");
		sql.append(" and b.security_area_id = ");
		sql.append(id);
		sql.append(" \n ) c order by c.type,c.id \n");
		Query query = this.getSession().createSQLQuery(sql.toString());
		
		return query.list();
	}

	public int getSubUnitCountById(String id) {
		
		StringBuffer sql = new StringBuffer(" select c.id,c.name,c.type from (  \n");
		sql.append(" select a.id as id,a.machine_room_name as name,'JiFang' as type from bsam_machine_room a where 1=1 \n");
		sql.append(" and a.security_area_id = ");
		sql.append(id);
		sql.append(" \n union \n");
		sql.append(" select b.id as id,b.machine_name as name,'ZhuJi' as type from bsam_machine b where 1=1  \n");
		sql.append(" and b.security_area_id = ");
		sql.append(id);
		sql.append(" \n ) c order by c.type,c.id \n");
		Query query = this.getSession().createSQLQuery(sql.toString());
		
		int num = 0;
		if (null != query.list()&& query.list().size() > 0) {
			num = query.list().size();
		}
		return num;
	}

//	===========================================================
}
