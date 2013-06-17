package org.infosec.ismp.manager.agent.servicecheck;

import java.util.Map;

import org.infosec.ismp.manager.agent.AgentTaskNode;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;

/**
 * ServiceCheck任务对象
 * @author jiel
 *
 */
public class ServiceCheckNode implements AgentTaskNode{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nodeid;
	private String serviceType;
	private Long interval;
	private String ipAddr;
	private Map<String,String> paramMap;



	@Override
	public AgentTodoTask convertToTask() {		
		return new AgentAddServiceCheckTask(this);
	}

	@Override
	public String getNodeid() {
		return nodeid;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SERVICECHECK;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public Long getInterval() {
		return interval;
	}

	public void setInterval(Long interval) {
		this.interval = interval;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}
}
