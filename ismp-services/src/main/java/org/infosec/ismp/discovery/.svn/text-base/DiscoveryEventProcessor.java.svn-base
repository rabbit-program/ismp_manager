package org.infosec.ismp.discovery;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.model.event.EventUtils;
import org.infosec.ismp.util.ThreadCategory;

public class DiscoveryEventProcessor implements EventListener {

	private final Discovery discovery;

	public DiscoveryEventProcessor(Discovery discovery) {
		this.discovery = discovery;
	}

	@Override
	public String getName() {
		return "Discovery:DiscoveryEventProcessor";
	}

	@Override
	public void onEvent(Event event) {
		if (event == null)
			return;

		ThreadCategory log = ThreadCategory.getInstance(getClass());

		if (log.isDebugEnabled()) {
			log.debug("DiscoveryEventProcessor: received event,uei = "
					+ event.getUei());
		}

		if (event.getUei().equals(EventConstants.DISC_START_EVENT_UEI)) {// 开始discovery一个范围
			// 从event中取出discovery的范围值
			String beginAddr = EventUtils.getDiscoveryBeginAddr(event);
			String endAddr = EventUtils.getDiscoveryEndAddr(event);
			int retry = 2;
			int timeout = 1000;
		}

	}
}
