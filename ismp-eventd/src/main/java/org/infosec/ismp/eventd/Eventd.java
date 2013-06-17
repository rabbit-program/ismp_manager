package org.infosec.ismp.eventd;

import java.util.ArrayList;
import java.util.Collection;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.infosec.ismp.eventd.adaptors.EventReceiver;
import org.springframework.util.Assert;

/**
 * Eventd负责接收外部（Agent、Manager）传来的相关事件，是系统和外部通信的渠道。
 */
public final class Eventd extends AbstractServiceDaemon {
	/**
	 * The log4j category used to log debug messsages and statements.
	 */
	public static final String LOG4J_CATEGORY = "ISMP.Eventd";

	/**
	 * Reference to the event processor
	 */
	private BroadcastEventProcessor m_receiver;

	/**
	 * All handlers that can receive events to be started/stopped with Eventd.
	 */
	private Collection<EventReceiver> m_eventReceivers;

	/**
	 * Constuctor creates the localhost address(to be used eventually when
	 * eventd originates events during correlation) and the broadcast queue
	 */
	public Eventd() {
		super("ISMP.Eventd");
	}

	@Override
	protected void onInit() {
		// Assert.state(m_eventdServiceManager != null,
		// "property eventdServiceManager must be set");
		Assert.state(m_eventReceivers != null,
				"property eventReceivers must be set");

		m_receiver = new BroadcastEventProcessor(this);
	}

	@Override
	protected void onStart() {
		for (EventReceiver eventReceiver : m_eventReceivers) {
			eventReceiver.start();
		}

		log().debug("Listener threads started");

		log().debug("Eventd running");
	}

	@Override
	protected void onStop() {
		log().debug("calling shutdown on tcp/udp listener threads");

		// Stop listener threads
		for (EventReceiver eventReceiver : m_eventReceivers) {
			eventReceiver.stop();
		}

		if (m_receiver != null) {
			m_receiver.close();
		}

		log().debug("shutdown on tcp/udp listener threads returned");
	}

	public void addEventReceiver(EventReceiver eventReceiver) {
		if (m_eventReceivers == null) {
			m_eventReceivers = new ArrayList<EventReceiver>();
		}
		m_eventReceivers.add(eventReceiver);
	}

	public Collection<EventReceiver> getEventReceivers() {
		return m_eventReceivers;
	}

	public void setEventReceivers(Collection<EventReceiver> eventReceivers) {
		m_eventReceivers = eventReceivers;
	}
}
