package org.infosec.ismp.manager.snmpTrap;

import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * SnmpTrap添加任务
 * @author jiel
 *
 */
public class AgentAddSnmpTrapNodeTask implements AgentTodoTask {
	private SnmpTrapNode node;
	public AgentAddSnmpTrapNodeTask(SnmpTrapNode node) {
		this.node=node;
		}

	@Override
	public Event convertToEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SNMPTRAP_NODE_ADD_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(node.getNodeid());
		event.setIpAddr(node.getSnmpTrapAddress());
		Parms parms = new Parms();

		Parm parm = new Parm();
		parm.setParmName("SnmpTrapType");
		Value value = new Value();
		value.setContent(String.valueOf(node.getSnmpTrapType()));
		parm.setValue(value);
		parms.addParm(parm);
		event.setParams(parms);
		return event;
	}

	@Override
	public String getNodeid() {
		return node.getNodeid();
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SNMPTRAP;
	}

	@Override
	public boolean isDelete() {
		return false;
	}

}
