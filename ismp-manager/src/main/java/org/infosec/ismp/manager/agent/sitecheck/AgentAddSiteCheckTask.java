package org.infosec.ismp.manager.agent.sitecheck;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * 页面检测任务
 * @author jiel
 *
 */
public class AgentAddSiteCheckTask implements AgentTodoTask {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SiteCheckNode siteCheckNode;
	public AgentAddSiteCheckTask (SiteCheckNode siteCheckNode){
		this.siteCheckNode=siteCheckNode;
	}

	@Override
	public Event convertToEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SITECHECK_NODE_ADD_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(siteCheckNode.getNodeid());
		event.setIpAddr(siteCheckNode.getUrl());
		Parms parms = new Parms();

		Parm parm = new Parm();
		parm.setParmName("interval");
		Value value = new Value();
		value.setContent(String.valueOf(siteCheckNode.getInterval()));
		parm.setValue(value);
		parms.addParm(parm);
		
		event.setParams(parms);
		return event;
	}

	@Override
	public String getNodeid() {
		return siteCheckNode.getNodeid();
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
