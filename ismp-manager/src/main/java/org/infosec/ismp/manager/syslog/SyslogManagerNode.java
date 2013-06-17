package org.infosec.ismp.manager.syslog;

import java.util.HashSet;
import java.util.Set;

import org.infosec.ismp.manager.agent.AgentComponent;
import org.infosec.ismp.manager.domains.DomainComponent;

@Deprecated
public class SyslogManagerNode {
    private String nodeid;
    private String ipaddr;
    
    private DomainComponent domain;
    
    private Set<AgentComponent> agents = new HashSet<AgentComponent>();
    
	public String getNodeid() {
		return nodeid;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public DomainComponent getDomain() {
		return domain;
	}
	public void setDomain(DomainComponent domain) {
		this.domain = domain;
	}
	public Set<AgentComponent> getAgents() {
		return agents;
	}
	public void setAgents(Set<AgentComponent> agents) {
		this.agents = agents;
	}
	
	public void removeAgent(AgentComponent agent){
		//TODO 
		if(agents.contains(agent)){
			agents.remove(agent);
		}
	}
	
	public void addAgent(AgentComponent agent){
		//TODO
		agents.add(agent);
	}
    
	
    
}
