package org.infosec.ismp.servicecheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.util.ThreadCategory;

/**
 * 处理Pingd关心的事件
 * 
 * @author lianglin
 * 
 */
public class BroadcastEventProcessor implements EventListener {

	private ServiceCheck m_serviceCheck;

	public BroadcastEventProcessor(ServiceCheck serviceCheck) {
		m_serviceCheck = serviceCheck;

		List<String> ueiList = new ArrayList<String>();

		ueiList.add(EventConstants.SERVICECHECK_NODE_ADD_UEI);
		ueiList.add(EventConstants.SERVICECHECK_NODE_DELETE_UEI);

		EventIpcManagerFactory.init();
		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueiList);
	}

	@Override
	public String getName() {
		return "serviceCheck:BroadcastEventProcessor";
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

		if (eventUei.equals(EventConstants.SERVICECHECK_NODE_ADD_UEI)) {
			String nodeId = event.getNodeid();
			String ipAddr = event.getIpAddr();

			Parms parms = event.getParams();
			
			String serviceType = getValue(parms, "serviceType");
//			String halfIntervalWhenDownStr = getValue(parms,
//					"halfIntervalWhenDown");
			long interval = Long.parseLong(getValue(parms, "interval"));
			
			HashMap parameters = new HashMap();
			
			Parm[] parm = parms.getParm();
			
			if (parm != null && parm.length > 0) {
				for (int i = 0, count = parm.length; i < count; i++) {
					if(!"serviceType".equalsIgnoreCase(parm[i].getParmName())&&!"interval".equalsIgnoreCase(parm[i].getParmName())){
					parameters.put(parm[i].getParmName(), parm[i].getValue().getContent());
					}					
				}
			}
//			
//			System.out.println("intervalStr is : " + intervalStr);
//			System.out.println("halfIntervalWhenDownStr is : "
//					+ halfIntervalWhenDownStr);
//
//			long interval = Long.parseLong(intervalStr);
//			boolean halfIntervalWhenDown = Boolean
//					.parseBoolean(halfIntervalWhenDownStr);

			m_serviceCheck.addServiceCheck(nodeId, serviceType,interval,ipAddr, parameters);

			if (log.isDebugEnabled()) {
				log.debug("add serviceCheck node to serviceCheck : " + nodeId);
			}

		} else if (eventUei.equals(EventConstants.SERVICECHECK_NODE_DELETE_UEI)) {

			String nodeId = event.getNodeid();
			m_serviceCheck.removeServiceCheck(nodeId);
			if (log.isDebugEnabled()) {
				log.debug("remove serviceCheck node from serviceCheck: " + nodeId);
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
