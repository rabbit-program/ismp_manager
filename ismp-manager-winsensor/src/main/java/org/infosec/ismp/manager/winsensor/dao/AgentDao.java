package org.infosec.ismp.manager.winsensor.dao;

import java.util.List;

import org.infosec.ismp.manager.winsensor.entity.AgentBO;


/**
 * @author Rocky
 * @version create time: Dec 23, 2010 4:14:43 PM
 *
 */
public interface AgentDao {

	public void addAgent(AgentBO agent);
	
	public void updateAgent(AgentBO agent);
	
	public void deleteAgent(AgentBO agent);
	
	public List<AgentBO> getAllAgent();
	
	public AgentBO findByAgentId(String agentId);
}
