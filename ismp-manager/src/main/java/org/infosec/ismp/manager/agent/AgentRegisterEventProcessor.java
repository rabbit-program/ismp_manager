package org.infosec.ismp.manager.agent;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.util.ThreadCategory;

public class AgentRegisterEventProcessor implements EventListener {

	private final AgentLocator m_agentLocator;

	public AgentRegisterEventProcessor(AgentLocator locator) {

		this.m_agentLocator = locator;

		List<String> ueiList = new ArrayList<String>();

		ueiList.add(EventConstants.AGENT_REGIESTER_EVENT_UEI);

		EventIpcManagerFactory.init();
		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueiList);
	}

	@Override
	public String getName() {
		return "ismp.agentRegisterEventProcessor";
	}

	@Override
	public void onEvent(Event event) {
		ThreadCategory log = ThreadCategory.getInstance(getClass());
		String eventUei = event.getUei();
		if (eventUei == null)
			return;

		if (log.isDebugEnabled()) {
			log.debug("event is : " + event);
			log.debug("Received event: " + eventUei);
		}

		if (eventUei.equals(EventConstants.AGENT_REGIESTER_EVENT_UEI)) {
			String nodeId = event.getNodeid();
			String ipAddr = event.getIpAddr();

			Parms parms = event.getParams();

			String portSTr = getValue(parms, "port");
			int port =-1;
			try{
				port = Integer.parseInt(portSTr);
			}catch(Throwable t){
				log.warn("解析端口出错",t);
			}
			
			String uuid = getValue(parms,"uuid");

//			System.out.println("port is : " + portSTr);
//			System.out.println("ipaddr is : " + ipAddr);
//			System.out.println("uuid is : "+uuid);

			m_agentLocator.register(nodeId, uuid, ipAddr, port);
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

}
