 package org.infosec.ismp.manager.snmp.task;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

public class AgentRemoveSnmpDeviceTask implements AgentTodoTask {

	private static final long serialVersionUID = -5403708655488730282L;

	private String m_nodeid;

	public AgentRemoveSnmpDeviceTask(String nodeid) {
		m_nodeid = nodeid;
	}

	@Override
	public String getNodeid() {
		return m_nodeid;
	}

	@Override
	public Event convertToEvent() {

		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SNMPCOLLECTD_NODE_DELETE_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(m_nodeid);

		return event;
	}

	@Override
	public boolean isDelete() {

		return true;
	}

	@Override
	public AgentTodoType getType() {

		return AgentTodoType.SNMP;
	}

}
