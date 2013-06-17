package org.infosec.ismp.manager.snmpTrap;

import org.infosec.ismp.manager.agent.AgentTaskNode;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;

public class SnmpTrapNode implements AgentTaskNode {
	private String nodeid;
	private String snmpTrapType;
	private String snmpTrapAddress;
	
	public String getSnmpTrapType() {
		return snmpTrapType;
	}

	public void setSnmpTrapType(String snmpTrapType) {
		this.snmpTrapType = snmpTrapType;
	}

	public String getSnmpTrapAddress() {
		return snmpTrapAddress;
	}

	public void setSnmpTrapAddress(String snmpTrapAddress) {
		this.snmpTrapAddress = snmpTrapAddress;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	@Override
	public AgentTodoTask convertToTask() {
		return new AgentAddSnmpTrapNodeTask(this);
	}

	@Override
	public String getNodeid() {
		return nodeid;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SNMPTRAP;
	}

}
