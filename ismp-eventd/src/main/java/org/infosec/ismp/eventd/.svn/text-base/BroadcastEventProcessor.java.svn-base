package org.infosec.ismp.eventd;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.util.Assert;

/**
 * 外部事件接受模块对内部事件的Listener，根据接受到相关的事件决定是否重启eventd模块等。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class BroadcastEventProcessor implements EventListener {
	private final Eventd m_eventd;

	public BroadcastEventProcessor(Eventd eventd) {
		this.m_eventd = eventd;
		Assert.notNull(m_eventd, " m_eventd must not be null");
		addEventListener();
	}

	/**
	 * Create message selector to set to the subscription
	 */
	private void addEventListener() {
		EventIpcManagerFactory.getIpcManager().addEventListener(this,
				EventConstants.EVENTSCONFIG_CHANGED_EVENT_UEI);
	}

	/**
	 * </p>
	 * Closes the current connections to the event manager if they are
	 * still active. This call may be invoked more than once safely and may be
	 * invoked during object finalization.
	 * </p>
	 * 
	 */
	public synchronized void close() {
		EventIpcManagerFactory.getIpcManager().removeEventListener(this);
	}

	/**
	 * This method may be invoked by the garbage thresholding. Once invoked it
	 * ensures that the <code>close</code> method is called <em>at least</em>
	 * once during the cycle of this object.
	 * 
	 */
	@Override
	protected void finalize() throws Throwable {
		close();
	}

	@Override
	public String getName() {
		return "Eventd:BroadcastEventProcessor";
	}

	/**
	 * This method is invoked by the event manager when a new event is
	 * available for processing.  Each message is examined for its Universal
	 * Event Identifier and the appropriate action is taking based on each UEI.
	 * 
	 * @param event
	 *            The event message.
	 * 
	 */
	@Override
	public void onEvent(Event event) {
		// TODO:根据事件类型做相应的动作
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
