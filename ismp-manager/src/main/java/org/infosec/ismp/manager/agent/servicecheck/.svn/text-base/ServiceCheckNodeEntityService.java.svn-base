package org.infosec.ismp.manager.agent.servicecheck;

import java.util.List;

import org.infosec.ismp.manager.model.ServiceCheckNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * ServiceCheckNodeEntityService类  
 * 用于ServiceCheckNodeEntity保存删除等操作
 * @author jiel
 *
 */
@Component
@Transactional
public class ServiceCheckNodeEntityService {
	private ServiceCheckNodeEntityDao m_serviceCheckDao;
	
	@Autowired(required=true)
	public void setServiceCheckDao(ServiceCheckNodeEntityDao dao){
		this.m_serviceCheckDao=dao;
	}
	/**
	 * 获取所有ServiceCheckNode任务Entity
	 * @return
	 */
	@Transactional
	public List<ServiceCheckNodeEntity> getAll(){
		return m_serviceCheckDao.getAll();
	}
	
	/**
	 * 添加一个ServiceCheckNode
	 * @param entity
	 */
	@Transactional
	public void addServiceCheckNode(ServiceCheckNodeEntity entity){
		m_serviceCheckDao.save(entity);
	}
	/**
	 * 删除一个ServiceCheckNode
	 * @param nodeid
	 */
	@Transactional
	public void removeServiceCheckNode(String nodeid){
		m_serviceCheckDao.removeServiceCheckNode(nodeid);
	}

}
