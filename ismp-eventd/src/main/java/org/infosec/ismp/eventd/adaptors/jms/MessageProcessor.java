package org.infosec.ismp.eventd.adaptors.jms;

import java.util.List;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.eventd.adaptors.EventHandler;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.util.ThreadCategory;

public class MessageProcessor implements Runnable {
	/**
	 * The UDP receiver thread.
	 */
	private Thread m_context;

	/**
	 * The list of incomming events.
	 */
	private final List<JmsReceivedEvent> m_eventsIn;

	/**
	 * The list of registered event handlers.
	 */
	private final List<EventHandler> m_handlers;

	/**
	 * The stop flag
	 */
	private volatile boolean m_stop;

	/**
	 * The log prefix
	 */
	private String m_logPrefix;

	MessageProcessor(List<EventHandler> handlers, List<JmsReceivedEvent> in) {
		m_context = null;
		m_stop = false;
		m_eventsIn = in;

		m_handlers = handlers;
		m_logPrefix = Eventd.LOG4J_CATEGORY;
	}

	/**
	 * Returns true if the thread is still alive
	 */
	boolean isAlive() {
		return (m_context == null ? false : m_context.isAlive());
	}

	/**
	 * Stops the current context
	 */
	void stop() throws InterruptedException {
		m_stop = true;
		if (m_context != null) {
			ThreadCategory log = log();
			if (log.isDebugEnabled())
				log.debug("Stopping and joining thread context "
						+ m_context.getName());

			m_context.interrupt();
			m_context.join();

			if (log.isDebugEnabled())
				log.debug("Thread context stopped and joined");
		}
	}

	/**
	 * The event processing execution context.
	 */
	@Override
	public void run() {
		// The runnable context
		m_context = Thread.currentThread();

		// get a logger
		ThreadCategory.setPrefix(m_logPrefix);
		if (m_stop) {
			log().debug("Stop flag set before thread started, exiting");
			return;
		} else {
			log().debug("Thread context started");
		}

		/*
		 * This loop is labeled so that it can be
		 * exited quickly when the thread is interrupted
		 */
		RunLoop: while (!m_stop) {
			log().debug("Waiting on a new datagram to arrive");

			JmsReceivedEvent re = null;
			synchronized (m_eventsIn) {
				// wait for an event to show up. wait in 1/2 second intervals
				while (m_eventsIn.isEmpty()) {
					try {
						m_eventsIn.wait(500);
					} catch (InterruptedException ie) {
						log().debug("Thread interrupted");
						break RunLoop;
					}

					if (m_stop) {
						log().debug("Stop flag is set");
						break RunLoop;
					}
				}
				re = m_eventsIn.remove(0);
			}

			log().debug("A new request has arrived");

			// Convert the Event
			Event[] events = null;
			try {
				if (log().isDebugEnabled()) {
					log().debug("Event from " + re.getDestination());
					log().debug(
							"Unmarshalling Event text {"
									+ System.getProperty("line.separator")
									+ re.getXmlData()
									+ System.getProperty("line.separator")
									+ "}");
				}
				events = re.unmarshal().getEvents().getEvent();
			} catch (MarshalException e) {
				log().warn(
						"Failed to unmarshal the event from "
								+ re.getDestination() + ": " + e, e);
				continue;
			} catch (ValidationException e) {
				log().warn(
						"Failed to validate the event from "
								+ re.getDestination() + ": " + e, e);
				continue;
			}

			if (events == null || events.length == 0) {
				log().debug("The event log record contained no events");
				continue;
			} else if (log().isDebugEnabled()) {
				log().debug("Processing " + events.length + " events");
			}

			// process the event
			synchronized (m_handlers) {
				/*
				 * Get the list of events from the event log.
				 * Also, get an iterator to walk over the set
				 * of event handlers.
				 */
				for (EventHandler handler : m_handlers) {
					// iterate over the list of the events for the received
					// events
					for (int ndx = 0; ndx < events.length; ndx++) {
						try {
							handler.processEvent(events[ndx]);
						} catch (Throwable t) {
							log().warn(
									"Failed to process received UDP event, exception follows",
									t);
						}
					}
				}
			}

			log().debug(
					"event processing complete, forwarding to receipt generator");

		}

		log().debug("Context finished, returning");
	}

	void setLogPrefix(String prefix) {
		m_logPrefix = prefix;
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
