package org.infosec.ismp.manager.agent.sitecheck;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * 重置页面检测任务
 * @author jiel
 *
 */
public class AgentResetSiteCheckTask implements AgentTodoTask {
	private String nodeid;
	public AgentResetSiteCheckTask(String nodeid) {
		this.nodeid=nodeid;
	}

	@Override
	public Event convertToEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SITECHECK_NODE_RESET_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(nodeid);
		
		return event;
	}

	@Override
	public String getNodeid() {
		return nodeid;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SITECHECK;
	}

	@Override
	public boolean isDelete() {
		return false;
	}

}
