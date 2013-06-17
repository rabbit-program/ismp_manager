package org.infosec.ismp.manager.ping;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

public class AgentAddPingTask implements Serializable, AgentTodoTask {
//	String nodeid;
//	String ipaddr;
//	long interval;
//	boolean halfIntervalWhenDown;
	
	PingNode m_pingNode;
	
	

	public AgentAddPingTask(PingNode pingNode) {
		this.m_pingNode = pingNode;
	}



	@Override
	public String getNodeid() {
		return m_pingNode.getNodeid();
	}



	@Override
	public Event convertToEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.PING_NODE_ADD_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(m_pingNode.getNodeid());
		event.setIpAddr(m_pingNode.getIpaddr());
		Parms parms = new Parms();

		Parm parm = new Parm();
		parm.setParmName("interval");
		Value value = new Value();
		value.setContent(String.valueOf(m_pingNode.getInterval()));
		parm.setValue(value);
		parms.addParm(parm);
		parm = new Parm();

		parm.setParmName("halfIntervalWhenDown");
		value = new Value();
		value.setContent(String.valueOf(m_pingNode.isHalfWhenDown()));
		parm.setValue(value);
		parms.addParm(parm);
		event.setParams(parms);
		return event;
	}



	@Override
	public boolean isDelete() {
		return false;
	}



	@Override
	public AgentTodoType getType() {
		return AgentTodoType.PING;
	}
	
	

}
