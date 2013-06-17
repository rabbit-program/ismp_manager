 package org.infosec.ismp.manager.syslog.task;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * 删除Syslog任务
 * @author lianglin
 *
 */
public class AgentRemoveSyslogTask implements AgentTodoTask {

	private final String nodeid;
	
	public AgentRemoveSyslogTask(String nodeid) {
		this.nodeid = nodeid;
	}

	@Override
	public String getNodeid() {
		return nodeid;
	}

	@Override
	public Event convertToEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SYSLOGD_CONFIG_NODE_DELETE_EVENT_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(nodeid);
		return event;
	}

	@Override
	public boolean isDelete() {
		return true;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SYSLOG;
	}

}
