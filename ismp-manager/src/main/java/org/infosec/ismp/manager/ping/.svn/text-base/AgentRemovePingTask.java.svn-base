 package org.infosec.ismp.manager.ping;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

public class AgentRemovePingTask implements AgentTodoTask{
	private String nodeid ;

	public AgentRemovePingTask(String nodeid) {
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
		event.setUei(EventConstants.PING_NODE_DELETE_UEI);
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
		return AgentTodoType.PING;
	}
	
	

}
