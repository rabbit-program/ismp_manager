package org.infosec.ismp.manager.snmp.dao;

import org.infosec.ismp.manager.model.SnmpDeviceNodeEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component
public class SnmpDeviceNodeEntityDao extends HibernateDao<SnmpDeviceNodeEntity, Integer> {


	/**
	 * 根据nodeid删除对应的SnmpDeviceNode
	 * 
	 * @param nodeid
	 */
	public void removeSnmpDeviceNodeByNodeId(String nodeid) {
		String hql = "delete from SnmpDeviceNodeEntity snmp where snmp.nodeid=?";
		batchExecute(hql, nodeid);
	}

}
