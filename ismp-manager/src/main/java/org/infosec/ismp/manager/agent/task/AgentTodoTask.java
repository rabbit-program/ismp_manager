package org.infosec.ismp.manager.agent.task;

import java.io.Serializable;

import org.infosec.ismp.model.event.Event;

/**
 * 任务接口
 * @author lianglin
 *
 */
public interface AgentTodoTask extends Serializable{
	public enum AgentTodoType{
		PING,SNMP,SITECHECK,SYSLOG,SNMPTRAP,SERVICECHECK,JDBC
	}
	/**
	 * 返回任务的唯一标识
	 * @return
	 */
	public String getNodeid();
	/**
	 * 将任务变成可以发送到远端的事件
	 * @return
	 */
    public Event convertToEvent();
    /**
     * 任务是否是删除任务
     * @return
     */
    public boolean isDelete();
    /**
     * 返回任务的类型
     * @return
     */
    public AgentTodoType getType();
}
