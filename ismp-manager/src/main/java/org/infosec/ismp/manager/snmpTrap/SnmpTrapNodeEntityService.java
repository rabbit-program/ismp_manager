package org.infosec.ismp.manager.snmpTrap;

import java.util.List;

import org.infosec.ismp.manager.model.ServiceCheckNodeEntity;
import org.infosec.ismp.manager.model.SnmpTrapNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * SnmpTrapNodeEntityService类  
 * 用于SnmpTrapNodeEntity保存删除等操作
 * @author jiel
 *
 */
@Component
@Transactional
public class SnmpTrapNodeEntityService {
	private SnmpTrapNodeEntityDao m_snmpTrapDao;
	
	@Autowired(required=true)
	public void setSnmpTrapDao(SnmpTrapNodeEntityDao dao){
		this.m_snmpTrapDao=dao;
	}
	/**
	 * 获取所有SnmpTrapNode任务Entity
	 * @return
	 */
	@Transactional
	public List<SnmpTrapNodeEntity> getAll(){
		return m_snmpTrapDao.getAll();
	}
	
	/**
	 * 添加一个SnmpTrapNode
	 * @param entity
	 */
	@Transactional
	public void addSnmpTrapNode(SnmpTrapNodeEntity entity){
		m_snmpTrapDao.save(entity);
	}
	/**
	 * 删除一个SnmpTrapNode
	 * @param nodeid
	 */
	@Transactional
	public void removeSnmpTrapNodeByNodeId(String nodeid){
		m_snmpTrapDao.removeSnmpTrapNodeByNodeId(nodeid);
	}

}
