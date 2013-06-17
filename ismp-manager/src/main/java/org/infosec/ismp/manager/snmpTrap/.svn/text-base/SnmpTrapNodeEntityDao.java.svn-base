package org.infosec.ismp.manager.snmpTrap;

import java.util.List;

import org.infosec.ismp.manager.model.ServiceCheckNodeEntity;
import org.infosec.ismp.manager.model.SnmpTrapNodeEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * SnmpTrapNodeEntityDao类
 * @author jiel
 *
 */
@Component
public class SnmpTrapNodeEntityDao extends HibernateDao<SnmpTrapNodeEntity, Integer> {
	
	/**
	 * 根据nodeid删除对应的SiteCheckNodeEntity
	 * 
	 * @param nodeid
	 */
	public void removeSnmpTrapNodeByNodeId(String nodeid) {
		String hql = "delete from SnmpTrapNodeEntity  where nodeid=?";
		batchExecute(hql, nodeid);
	}
}
