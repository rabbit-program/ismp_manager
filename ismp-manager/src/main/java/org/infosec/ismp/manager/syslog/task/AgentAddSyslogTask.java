package org.infosec.ismp.manager.syslog.task;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

public class AgentAddSyslogTask implements AgentTodoTask {
	
	private SyslogNode m_node;
	
	public AgentAddSyslogTask(SyslogNode node) {
		m_node  = node;
	}

	@Override
	public String getNodeid() {
		return m_node.getNodeid();
	}

	@Override
	public Event convertToEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SYSLOGD_CONFIG_NODE_ADD_EVENT_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(m_node.getNodeid());
		event.setIpAddr(m_node.getIpaddr());
		return event;
	}

	@Override
	public boolean isDelete() {
		return false;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SYSLOG;
	}
	
	

}
