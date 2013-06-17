package org.infosec.ismp.ping;

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
 * 处理Pingd关心的事件
 * 
 * @author lianglin
 * 
 */
public class BroadcastEventProcessor implements EventListener {

	private Pingd m_pingd;

	public BroadcastEventProcessor(Pingd pingd) {
		m_pingd = pingd;

		List<String> ueiList = new ArrayList<String>();

		ueiList.add(EventConstants.PING_NODE_ADD_UEI);
		ueiList.add(EventConstants.PING_NODE_DELETE_UEI);

		EventIpcManagerFactory.init();
		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueiList);
	}

	@Override
	public String getName() {
		return "pingd:BroadcastEventProcessor";
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

		if (eventUei.equals(EventConstants.PING_NODE_ADD_UEI)) {
			String nodeId = event.getNodeid();
			String ipAddr = event.getIpAddr();

			Parms parms = event.getParams();

			String intervalStr = getValue(parms, "interval");
			String halfIntervalWhenDownStr = getValue(parms,
					"halfIntervalWhenDown");
//			System.out.println("intervalStr is : " + intervalStr);
//			System.out.println("halfIntervalWhenDownStr is : "
//					+ halfIntervalWhenDownStr);

			long interval = Long.parseLong(intervalStr);
			boolean halfIntervalWhenDown = Boolean
					.parseBoolean(halfIntervalWhenDownStr);

			m_pingd.ping(nodeId, ipAddr, interval, halfIntervalWhenDown);

			if (log.isDebugEnabled()) {
				log.debug("add ping node to pingd : " + nodeId);
			}

		} else if (eventUei.equals(EventConstants.PING_NODE_DELETE_UEI)) {

			String nodeId = event.getNodeid();
			m_pingd.unping(nodeId);
			if (log.isDebugEnabled()) {
				log.debug("remove ping node from pingd: " + nodeId);
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
