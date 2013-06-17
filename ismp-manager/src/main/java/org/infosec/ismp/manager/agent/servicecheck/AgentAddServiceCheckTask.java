package org.infosec.ismp.manager.agent.servicecheck;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * 服务检测添加任务
 * @author jiel
 *
 */
public class AgentAddServiceCheckTask implements AgentTodoTask {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ServiceCheckNode node;
	
	public AgentAddServiceCheckTask (ServiceCheckNode node){
		this.node=node;
	}
	@Override
	public Event convertToEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SERVICECHECK_NODE_ADD_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid(node.getNodeid());
		event.setIpAddr(node.getIpAddr());
		String serviceType = node.getServiceType();
		Parms parms = new Parms();
		Parm parm = new Parm();
		parm.setParmName("interval");
		Value value = new Value();
		value.setContent(String.valueOf(node.getInterval()));
		parm.setValue(value);
		parms.addParm(parm);
		
		parm = new Parm();
		parm.setParmName("serviceType");
		value = new Value();
		value.setContent(serviceType);
		parm.setValue(value);
		parms.addParm(parm);
		
		Map<String,String> paramMap = node.getParamMap();
		Set<String> paramKey = paramMap.keySet();		
		for (Iterator<String> iterator = paramKey.iterator(); iterator.hasNext();) {
			String key = iterator.next();
			parm = new Parm();
			parm.setParmName(key);
			value = new Value();
			value.setContent(paramMap.get(key));
			parm.setValue(value);
			parms.addParm(parm);
		}
		
		event.setParams(parms);
		return event;
	}
	
	
	@Override
	public String getNodeid() {		
		return node.getNodeid();
	}

	/**
	 * 任务类型
	 */
	@Override
	public AgentTodoType getType() {		
		return AgentTodoType.SERVICECHECK;
	}
	/**
	 * 是否是删除任务  如果是删除任务 则返回 true
	 */
	@Override
	public boolean isDelete() {
		return false;
	}

}
