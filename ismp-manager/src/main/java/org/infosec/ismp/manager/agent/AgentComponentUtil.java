package org.infosec.ismp.manager.agent;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
/**
 * AgentComponent发送事件助手
 * @author lianglin
 *
 */
public class AgentComponentUtil {
	
	private AgentCompSnapShot agent; 
	
	public AgentComponentUtil(AgentCompSnapShot agent){
		this.agent = agent;
	}
	
	public boolean sendPingNode(String nodeid,String ipaddr,long interval,boolean halfIntervalWhenDown){
		Event event = createAddPingNodeEvent(nodeid, ipaddr, interval,
				halfIntervalWhenDown);
		boolean flag = EventSender.sendEvent(agent.ipAddr, agent.port, event);
		return flag;
	}

	private Event createAddPingNodeEvent(String nodeid, String ipaddr,
			long interval, boolean halfIntervalWhenDown) {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.PING_NODE_ADD_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(nodeid);
		event.setIpAddr(ipaddr);
		Parms parms = new Parms();

		Parm parm = new Parm();
		parm.setParmName("interval");
		Value value = new Value();
		value.setContent(String.valueOf(interval));
		parm.setValue(value);
		parms.addParm(parm);
		parm = new Parm();

		parm.setParmName("halfIntervalWhenDown");
		value = new Value();
		value.setContent(String.valueOf(halfIntervalWhenDown));
		parm.setValue(value);
		parms.addParm(parm);
		event.setParams(parms);
		return event;
	}
}
