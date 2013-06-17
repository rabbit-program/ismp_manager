package org.infosec.ismp.manager.agent.sitecheck;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * 删除页面检测任务类
 * @author jiel
 *
 */
public class AgentRemoveSiteCheckTask implements AgentTodoTask {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nodeid;
	public AgentRemoveSiteCheckTask(String nodeid) {
		this.nodeid=nodeid;
	}

	@Override
	public String getNodeid() {
		return nodeid;
	}

	@Override
	public Event convertToEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SITECHECK_NODE_DELETE_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(nodeid);
		
		return event;
	}

	/**
	 * 是否是删除任务  如果是删除任务 则返回 true
	 */
	@Override
	public boolean isDelete() {
		return true;
	}

	/**
	 * 任务类型
	 */
	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SITECHECK;
	}

}
