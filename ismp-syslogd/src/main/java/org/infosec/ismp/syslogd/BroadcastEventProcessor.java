package org.infosec.ismp.syslogd;

/**
 * syslog模块侦听内部事件的listener，syslog模块的配置修改和重启等命令通过该listener，
 * 是syslogd模块和外部交互的渠道。
 */
import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.util.ThreadCategory;

final class BroadcastEventProcessor implements EventListener {

//	private final Syslogd m_syslogd;

	private final SyslogNodeManager m_nodeManager;

	/**
	 * Create message selector to set to the subscription
	 */
	BroadcastEventProcessor(SyslogNodeManager nodeManager) {

		m_nodeManager = nodeManager;
		List<String> ueiList = new ArrayList<String>();

		// interfaceDeleted
		ueiList.add(EventConstants.SYSLOGD_CONFIG_NODE_ADD_EVENT_UEI);
		ueiList.add(EventConstants.SYSLOGD_CONFIG_NODE_DELETE_EVENT_UEI);

		EventIpcManagerFactory.init();
		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueiList);
	}

	/**
	 * Unsubscribe from eventd
	 */
	public void close() {
		EventIpcManagerFactory.getIpcManager().removeEventListener(this);
	}

	/**
	 * This method is invoked by the EventIpcManager when a new event is
	 * available for processing. Each message is examined for its Universal
	 * Event Identifier and the appropriate action is taking based on each UEI.
	 * 
	 * @param event
	 *            The event
	 */
	@Override
	public void onEvent(Event event) {
		ThreadCategory log = ThreadCategory.getInstance(getClass());
		String eventUei = event.getUei();
		if (eventUei == null)
			return;

		if (log.isDebugEnabled())
			log.debug("Received event: " + eventUei);

		if (eventUei.equals(EventConstants.SYSLOGD_CONFIG_NODE_ADD_EVENT_UEI)) {
			String nodeId = event.getNodeid();
			String ipAddr = event.getIpAddr();

			SyslogNode node = new SyslogNode(nodeId, ipAddr);
			m_nodeManager.addSyslogNode(node);

			if (log.isDebugEnabled()) {
				log.debug("add syslog source to nodeManager : " + node);
			}

		} else if (eventUei
				.equals(EventConstants.SYSLOGD_CONFIG_NODE_DELETE_EVENT_UEI)) {
			
			String nodeId = event.getNodeid();
			m_nodeManager.removeSyslogNode(nodeId);
			if (log.isDebugEnabled()) {
				log.debug("remove syslog source from nodeManager: " + nodeId);
			}

		}
	}

	/**
	 * Return an id for this event listener
	 */
	@Override
	public String getName() {
		return "Syslogd:BroadcastEventProcessor";
	}

//	String getValue(Parms parms, String parmName) {
//		Parm[] parm = parms.getParam();
//		String value = null;
//		if (parm != null && parm.length > 0) {
//			for (int i = 0, count = parm.length; i < count; i++) {
//				if (parm[i].getParmName().equalsIgnoreCase(parmName)) {
//					value = parm[i].getValue().getContent();
//					break;
//				}
//			}
//		}
//
//		return value;
//	}
}
