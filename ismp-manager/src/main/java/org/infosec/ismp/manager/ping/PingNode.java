package org.infosec.ismp.manager.ping;

import org.infosec.ismp.manager.agent.AgentTaskNode;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;

public class PingNode implements AgentTaskNode {
	String nodeid;
	String ipaddr;
	long interval;
	boolean halfWhenDown;

	@Override
	public AgentTodoTask convertToTask() {
		return new AgentAddPingTask(this);
	}

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

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public boolean isHalfWhenDown() {
		return halfWhenDown;
	}

	public void setHalfWhenDown(boolean halfWhenDown) {
		this.halfWhenDown = halfWhenDown;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.PING;
	}
	
	

	
}
