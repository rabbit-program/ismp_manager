package org.infosec.ismp.manager.snmpTrap;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 *SnmpTrap删除任务
 * @author jiel
 *
 */
public class AgentRemoveSnmpTrapTask implements AgentTodoTask {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nodeid;
	public AgentRemoveSnmpTrapTask(String nodeid) {
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
		event.setUei(EventConstants.SNMPTRAP_NODE_DELETE_UEI);
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
		return AgentTodoType.SNMPTRAP;
	}

}
