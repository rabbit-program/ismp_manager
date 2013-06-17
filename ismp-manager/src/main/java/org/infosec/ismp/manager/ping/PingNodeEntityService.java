package org.infosec.ismp.manager.ping;

import java.util.List;

import org.infosec.ismp.manager.model.PingNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PingNodeEntityService {
	private PingNodeEntityDao m_pingDao;

	@Autowired(required = true)
	public void setPingDao(PingNodeEntityDao pingDao) {
		m_pingDao = pingDao;
	}

	@Transactional
	public List<PingNodeEntity> getAll() {
		return m_pingDao.getAll();
	}
	@Transactional
	public void save(PingNodeEntity entity) {
		m_pingDao.save(entity);
		
	}
	@Transactional
	public void removePingNodeByNodeId(String nodeid) {
		m_pingDao.removePingNodeByNodeId(nodeid);
	}
	@Transactional
	public PingNodeEntity getPingNodeEntity(String nodeid){
		return m_pingDao.getPingNodeEntityByNodeid(nodeid);
	}
	@Transactional
	public boolean findExistPingNode(String nodeid) {
		PingNodeEntity entity = getPingNodeEntity(nodeid);
		if(entity!=null)return true;
		return false;
	}
}
