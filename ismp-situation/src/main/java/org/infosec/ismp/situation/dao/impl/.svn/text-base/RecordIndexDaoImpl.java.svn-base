package org.infosec.ismp.situation.dao.impl;

import java.util.List;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.RecordIndexDao;
import org.infosec.ismp.situation.model.RecordIndex;

public class RecordIndexDaoImpl extends BaseDaoHibernate implements RecordIndexDao {

	public List<RecordIndex> getAll() {
		List<RecordIndex> list = this.getHibernateTemplate().find("from RecordIndex order by id desc limit 1");
		return list;
	}

//	public List getMachineList() {
////		StringBuffer sql = new StringBuffer();
////		sql.append("select a.*,b.machine_cabinet_name from bsam_machine a  \n");
////		sql.append(" left join bsam_machine_cabinet b on b.id = a.machine_cabinet_id  \n ");
////		return HibernateUtil.getSQL2MapList(sql.toString());
//		StringBuffer hql = new StringBuffer("from Machine");
//		
//		List list = this.getHibernateTemplate().find(hql.toString());
//		return list;
//		
//	}
	
}
