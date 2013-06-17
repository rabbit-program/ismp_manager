package org.infosec.ismp.manager.winsensor.service.impl;

import java.util.List;

import org.infosec.ismp.manager.winsensor.dao.AgentDao;
import org.infosec.ismp.manager.winsensor.entity.AgentBO;
import org.infosec.ismp.manager.winsensor.service.AgentService;

/**
 * @author Rocky
 * @version create time: Dec 23, 2010 4:31:48 PM
 *
 */
public class AgentServiceImpl implements AgentService {
	
	private AgentDao dao;

	@Override
	public void addAgent(AgentBO agent) {
		dao.addAgent(agent);
	}

	@Override
	public void updateAgent(AgentBO agent) {
		dao.updateAgent(agent);
	}

	@Override
	public void deleteAgent(AgentBO agent) {
		dao.deleteAgent(agent);
	}

	@Override
	public List<AgentBO> getAllAgent() {
		return dao.getAllAgent();
	}

	@Override
	public AgentBO findByAgentId(String agentId) {
		return dao.findByAgentId(agentId);
	}

	public AgentDao getDao() {
		return dao;
	}

	public void setDao(AgentDao dao) {
		this.dao = dao;
	}
}
