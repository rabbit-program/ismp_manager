package org.infosec.ismp.manager.snmp.task;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.db.ParamsBuilder;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

public class AgentAddSnmpDeviceTask implements Serializable, AgentTodoTask {

	private static final long serialVersionUID = -7264712826360277391L;

	private SnmpDeviceNode m_snmpDeviceNode;

	public AgentAddSnmpDeviceTask(SnmpDeviceNode snmpDeviceNode) {
		this.m_snmpDeviceNode = snmpDeviceNode;
	}

	@Override
	public String getNodeid() {
		return m_snmpDeviceNode.getNodeid();
	}

	@Override
	public Event convertToEvent() {

		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SNMPCOLLECTD_NODE_ADD_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(m_snmpDeviceNode.getNodeid());
		event.setIpAddr(m_snmpDeviceNode.getIpAddr());
		Parms parms = ParamsBuilder.getInstance().buildParams(m_snmpDeviceNode);
		event.setParams(parms);
		return event;
	}

	@Override
	public boolean isDelete() {
		return false;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SNMP;
	}

}
