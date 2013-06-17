package org.infosec.ismp.trapd;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.util.ThreadCategory;

/**
 * 处理trap关心的事件
 * 
 * @author lianglin
 * 
 */
//@Component
//@Qualifier(value="snmpTrapProcessor")
public class BroadcastEventProcessor implements EventListener {

	private final TrapNodeManager m_nodeManager;
	
	public BroadcastEventProcessor(TrapNodeManager trapNodeManager) {
		
		m_nodeManager = trapNodeManager;
	
		List<String> ueiList = new ArrayList<String>();

		ueiList.add(EventConstants.SNMPTRAP_NODE_ADD_UEI);
		ueiList.add(EventConstants.SNMPTRAP_NODE_DELETE_UEI);

		EventIpcManagerFactory.init();
		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueiList);
	}

	@Override
	public String getName() {
		return "SnmpTrap:BroadcastEventProcessor";
	}

	@Override
	public void onEvent(Event event) {

		ThreadCategory log = ThreadCategory.getInstance(getClass());
		String eventUei = event.getUei();
		if (eventUei == null)
			return;

		if (log.isDebugEnabled()) {
			log.debug("event is : "+event);
			log.debug("Received event: " + eventUei);
		}

		if (eventUei.equals(EventConstants.SNMPTRAP_NODE_ADD_UEI)) {
			String nodeId = event.getNodeid();
			String ipAddr = event.getIpAddr();

			Parms parms = event.getParams();

			String snmpTrapType = getValue(parms, "SnmpTrapType");
			

//			System.out.println("this is snmptrap delete processor...");
//			System.out.println("the nodeid is :"+ nodeId);
//			System.out.println("the ipAddr is :"+ ipAddr);
//			System.out.println("the snmpTrapType is :"+ snmpTrapType);
			
			TrapNode node = new TrapNode(nodeId, ipAddr);
			m_nodeManager.addTrapNode(node);
			if (log.isDebugEnabled()) {
				log.debug("add snmptrap node to snmptrapd : " + nodeId);
			}

		} else if (eventUei.equals(EventConstants.SNMPTRAP_NODE_DELETE_UEI)) {

			String nodeId = event.getNodeid();
//			System.out.println("this is snmptrap delete processor...");
//			System.out.println("the nodeid is :"+ nodeId);
			
			m_nodeManager.removeTrapNode(nodeId);
			if (log.isDebugEnabled()) {
				log.debug("remove snmptrap node from snmptrapd: " + nodeId);
			}

		}

	}

	String getValue(Parms parms, String parmName) {
		Parm[] parm = parms.getParm();
		String value = null;
		if (parm != null && parm.length > 0) {
			for (int i = 0, count = parm.length; i < count; i++) {
				if (parm[i].getParmName().equalsIgnoreCase(parmName)) {
					value = parm[i].getValue().getContent();
					break;
				}
			}
		}

		return value;
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
