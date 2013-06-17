package org.infosec.ismp.manager.agent.sitecheck;

import org.infosec.ismp.manager.agent.AgentTaskNode;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;
import org.infosec.ismp.model.event.EventConstants;

/**
 * 页面检测任务节点类
 * @author jiel
 *
 */
public class SiteCheckNode implements AgentTaskNode{
	private String nodeid;
	private String url;
	private long interval;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	@Override
	public AgentTodoTask convertToTask() {
		return new AgentAddSiteCheckTask(this);
	}

	@Override
	public String getNodeid() {
		return nodeid;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SITECHECK;
	}

}
