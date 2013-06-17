package org.infosec.ismp.manager.domains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.agent.AgentComponent;
import org.infosec.ismp.manager.agent.AgentLocator;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 管理所有的域,是Domain的所有
 * 
 * @author lianglin
 * 
 */
@Component
public class DomainLocator {
	
	private AgentLocator m_agentLocator;
	
	@Autowired(required=true)
	public void setAgentLocator(AgentLocator agentLocator) {
		m_agentLocator = agentLocator;
	}

	/**
	 * 所有的域对象和域id
	 */
	private Map<String, DomainComponent> m_domains = new HashMap<String, DomainComponent>();

	/**
	 * 通过域唯一标识获得该域
	 * 
	 * @param domain
	 * @return
	 */
	protected DomainComponent getDomain(String domain) {
		return m_domains.get(domain);
	}
	
	/**
	 * 获取所有域
	 * @return
	 */
	public List<DomainComponent> getAllDomains(){
		List<DomainComponent> list= new ArrayList<DomainComponent>();
		list.addAll(m_domains.values());
		return list;
	}

	public DomainComponent createDomainIfNessary(String domain) {
		DomainComponent domainComp = getDomain(domain);
		if (domainComp == null) {
			domainComp = new DomainComponent(domain);
			List<AgentComponent> agentComponents = m_agentLocator.getAgentByDomain(domain);
			log().info("域标识为:"+domain+"的域，对应的Agent对象是 ："+agentComponents);
			domainComp.setAgentComponents(agentComponents);
			m_domains.put(domain, domainComp);
		}
		return domainComp;
	}
	
	
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
