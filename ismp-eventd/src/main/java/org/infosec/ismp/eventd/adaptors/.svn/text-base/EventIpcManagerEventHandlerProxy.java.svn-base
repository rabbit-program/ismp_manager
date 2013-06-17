package org.infosec.ismp.eventd.adaptors;

import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventReceipt;

/**
 * 将收到的外部事件转发给事件中心
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class EventIpcManagerEventHandlerProxy implements EventHandler {

	public EventIpcManagerEventHandlerProxy() {
	}

	@Override
	public boolean processEvent(Event event) {
		//
		EventIpcManagerFactory.getIpcManager().broadcastNow(event);
		return true;
	}

	@Override
	public void receiptSent(EventReceipt event) {
		// do nothing
	}

}
