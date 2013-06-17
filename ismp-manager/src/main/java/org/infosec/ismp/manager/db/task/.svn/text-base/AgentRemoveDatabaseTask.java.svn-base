 package org.infosec.ismp.manager.db.task;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
/**
 * 
 * @author guoxianwei
 * @date 2010-12-14 下午04:41:00
 * 
 *       向AGENT删除数据库信息采集任务TASK
 * 
 */
public class AgentRemoveDatabaseTask implements AgentTodoTask {

	private static final long serialVersionUID = -5403708655488730282L;

	private String m_nodeid;

	public AgentRemoveDatabaseTask(String nodeid) {
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
		event.setUei(EventConstants.DB_COLLECT_NODE_DELETE_UEI);
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
		return AgentTodoType.JDBC;
	}

}
