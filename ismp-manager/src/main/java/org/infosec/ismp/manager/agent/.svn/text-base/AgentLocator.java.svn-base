package org.infosec.ismp.manager.agent;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.GetAgentPropertiesByDomain;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.stereotype.Component;

/**
 * Agent的管理、定位类，是Agent的入口类
 * 
 * @author lianglin
 * 
 */
@Component
public class AgentLocator {

	private AgentFileFactory agentFileFactory = AgentFileFactory.getInstance();

	public final static long MAX_REGISTER_TIME_ELAPSE = 10 * 1000 * 3;

	private Map<String, AgentComponent> m_agents = new HashMap<String, AgentComponent>();

	private GetAgentPropertiesByDomain agentFinder = new GetAgentPropertiesByDomain();
	/**
	 * 所有的AgentComponent
	 */
	private Map<String, AgentComponent> agentComps = new HashMap<String, AgentComponent>();

	public List<AgentComponent> getAgentByDomain(String domain) {

		List<AgentComponent> results = new ArrayList<AgentComponent>();
		// if("testDomain".equals(domain)){
		// String agentId= "agent1";
		// AgentComponent agent =findAgentComponetByAgentId(agentId);
		// results.add(agent);
		// }
		System.out.println("domain is : " + domain);
		List<String> agentIds = agentFinder.getAgentNames(domain);
		System.out.println("agentIds is : " + agentIds);
		if (agentIds != null) {
			for (String agentId : agentIds) {
				AgentComponent agent = findAgentComponetByAgentId(agentId);
				results.add(agent);
			}
		}
		return results;
	}

	protected AgentComponent createAgentComponent(String agentId) {
		AgentComponent agentComp = null;
		File file = agentFileFactory.createAgentConfigFile(agentId);
		agentComp = new AgentComponent(agentId);
		agentComp.setTempFile(file);
		return agentComp;
	}

	/**
	 * 对相应的Agent进行注册处理
	 * 
	 * @param agentId
	 * @param uuid
	 * @param ipaddr
	 * @param port
	 */
	public void register(String agentId, String uuid, String ipaddr, int port) {
		log().info("开始一次注册过程");
		AgentComponent agent = findAgentComponetByAgentId(agentId);
		agent.register(uuid, ipaddr, port);
	}

	/**
	 * 检查Agent的注册时间是否超过N倍时间间隔，如果超过，则认为该Agent不在线，或者网络异常
	 */
	public void check() {
		List<AgentComponent> agents = getAllAgentComponent();
		long nowTime = System.currentTimeMillis();
		//FIXME for NPE bug
		for (AgentComponent agent : agents) {
			if (agent.isActive()) {
				long registerTime = agent.getRegisterTime();
				if (nowTime - registerTime > MAX_REGISTER_TIME_ELAPSE) {
					agent.unactive();
				}
			}
		}
	}

	private List<AgentComponent> getAllAgentComponent() {
		List<AgentComponent> agents = new LinkedList<AgentComponent>();
		agents.addAll(m_agents.values());
		return agents;
	}

	public AgentComponent findAgentComponetByAgentId(String agentId) {
		AgentComponent agentComp = m_agents.get(agentId);
		if (agentComp == null) {
			log().info("创建一个新的Agent对象，AgentId是: " + agentId);
			agentComp = createAgentComponent(agentId);
			m_agents.put(agentId, agentComp);
		}
		return agentComp;
	}

	protected void init() {

	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
	
	

}
