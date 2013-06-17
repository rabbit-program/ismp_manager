package org.infosec.ismp.manager.db.task;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.db.ParamsBuilder;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * 
 * @author guoxianwei
 * @date 2010-12-14 下午04:41:00
 * 
 *       向AGENT发出添加数据库信息采集任务TASK
 * 
 */
public class AgentAddDatabaseTask implements AgentTodoTask {

	private static final long serialVersionUID = -7264712826360277391L;

	private DatabaseNode m_databaseNode;

	public AgentAddDatabaseTask(DatabaseNode databaseNode) {
		this.m_databaseNode = databaseNode;
	}

	@Override
	public String getNodeid() {
		return m_databaseNode.getNodeid();
	}

	@Override
	public Event convertToEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.DB_COLLECT_NODE_ADD_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(m_databaseNode.getNodeid());
		event.setIpAddr(m_databaseNode.getUrl());
		Parms parms = ParamsBuilder.getInstance().buildParams(m_databaseNode);
		event.setParams(parms);
		return event;
	}

	@Override
	public boolean isDelete() {
		return false;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.JDBC;
	}

}
