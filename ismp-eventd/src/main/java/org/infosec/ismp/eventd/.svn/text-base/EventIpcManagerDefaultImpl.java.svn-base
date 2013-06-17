package org.infosec.ismp.eventd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.model.event.EventProxyException;
import org.infosec.ismp.model.event.Events;
import org.infosec.ismp.model.event.Log;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.concurrent.RunnableConsumerThreadPool;
import org.infosec.ismp.util.queue.FifoQueue;
import org.infosec.ismp.util.queue.FifoQueueException;
import org.infosec.ismp.util.queue.FifoQueueImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * An implementation of the EventIpcManager interface that can be used to
 * communicate between services in the same JVM
 * 
 */
public class EventIpcManagerDefaultImpl implements EventIpcManager,
		InitializingBean {
	/**
	 * Hash table of list of event listeners keyed by event UEI
	 */
	private final Map<String, List<EventListener>> m_ueiListeners = new HashMap<String, List<EventListener>>();

	/**
	 * The list of event listeners interested in all events
	 */
	private final List<EventListener> m_listeners = new ArrayList<EventListener>();

	/**
	 * Hash table of event listener threads keyed by the listener's id
	 */
	private final Map<String, ListenerThread> m_listenerThreads = new HashMap<String, ListenerThread>();

	/**
	 * The thread pool handling the events
	 */
	private RunnableConsumerThreadPool m_eventHandlerPool;

	private EventHandler m_eventHandler;

	private Integer m_handlerPoolSize;

	private EventIpcManagerProxy m_eventIpcManagerProxy;

	/**
	 * A thread dedicated to each listener. The events meant for each listener
	 * is added to a dedicated queue when the 'sendNow()' is called. The
	 * ListenerThread reads events off of this queue and sends it to the
	 * appropriate listener
	 */
	private class ListenerThread implements Runnable {
		/**
		 * Listener to which this thread is dedicated
		 */
		private final EventListener m_listener;

		/**
		 * Queue from which events for the listener are to be read
		 */
		private final FifoQueue<Event> m_queue = new FifoQueueImpl<Event>();

		/**
		 * The thread that is running this runnable.
		 */
		private final Thread m_delegateThread;

		/**
		 * If set true then the thread should stop processing as soon as possible.
		 */
		private volatile boolean m_shutdown = true;

		/**
		 * Constructor
		 */
		ListenerThread(EventListener listener) {
			m_listener = listener;
			m_delegateThread = new Thread(this, m_listener.getName());
		}

		public void addEvent(Event event) {
			try {
				m_queue.add(event);
				if (log().isDebugEnabled()) {
					log().debug(
							"Queued event ID " + event.getUei()
									+ " to listener thread: "
									+ m_listener.getName());
				}
			} catch (FifoQueueException e) {
				log().error(
						"Error queueing event " + event.getUei()
								+ " to listener thread " + m_listener.getName()
								+ ": " + e, e);
			} catch (InterruptedException e) {
				log().error(
						"Error queueing event " + event.getUei()
								+ " to listener thread " + m_listener.getName()
								+ ": " + e, e);
			}
		}

		/**
		 * The run method performs the actual work for the runnable. It loops
		 * infinitely until the shutdown flag is set, during which time it
		 * processes queue elements. Each element in the queue should be a
		 * instance of {@link org.opennms.netmgt.xml.event.Event}. After each
		 * event is read, the 'onEvent' method of the listener is invoked.
		 * 
		 */
		@Override
		public void run() {
			if (log().isDebugEnabled()) {
				log().debug(
						"In ListenerThread " + m_listener.getName() + " run");
			}

			while (!m_shutdown) {
				Event event;
				try {
					event = m_queue.remove(500);
					if (event == null) {
						continue;
					}
				} catch (InterruptedException e) {
					m_shutdown = true;
					break;
				} catch (FifoQueueException e) {
					m_shutdown = true;
					break;
				}

				try {
					if (log().isInfoEnabled()) {
						log().info(
								"run: calling onEvent on "
										+ m_listener.getName() + " for event "
										+ event.getUei() + " with time "
										+ event.getTime());
					}

					// Make sure we restore our log4j logging prefix after
					// onEvent is called
					String log4jPrefix = ThreadCategory.getPrefix();
					try {
						m_listener.onEvent(event);
					} finally {
						ThreadCategory.setPrefix(log4jPrefix);
					}
				} catch (Throwable t) {
					log().warn(
							"run: an unexpected error occured during ListenerThread "
									+ m_listener.getName() + " run: " + t, t);
				}
			}
		}

		/**
		 * Starts up the thread.
		 */
		public void start() {
			m_shutdown = false;
			m_delegateThread.start();
		}

		/**
		 * Sets the stop flag in the thread.
		 */
		public void stop() {
			m_shutdown = true;
		}

	}

	public EventIpcManagerDefaultImpl() {
	}

	@Override
	public void send(Event event) throws EventProxyException {
		sendNow(event);
	}

	@Override
	public void send(Log eventLog) throws EventProxyException {
		sendNow(eventLog);
	}

	/**
	 * Called by a service to send an event to other listeners.
	 */
	@Override
	public synchronized void sendNow(Event event) {
		Assert.notNull(event, "event argument cannot be null");

		Events events = new Events();
		events.addEvent(event);

		Log eventLog = new Log();
		eventLog.setEvents(events);

		sendNow(eventLog);
	}

	/**
	 * Called by a service to send a set of events to other listeners.
	 * Creates a new event handler for the event log and queues it to the
	 * event handler thread pool.
	 */
	@Override
	public synchronized void sendNow(Log eventLog) {
		Assert.notNull(eventLog, "eventLog argument cannot be null");

		try {
			m_eventHandlerPool.getRunQueue().add(
					m_eventHandler.createRunnable(eventLog));
		} catch (InterruptedException e) {
			log().warn(
					"Unable to queue event log to the event handler pool queue: "
							+ e, e);

			throw new UndeclaredEventException(e);
		} catch (FifoQueueException e) {
			log().warn(
					"Unable to queue event log to the event handler pool queue: "
							+ e, e);

			throw new UndeclaredEventException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.opennms.netmgt.eventd.EventIpcBroadcaster#broadcastNow(org.opennms.netmgt.xml.event.Event)
	 */
	@Override
	public synchronized void broadcastNow(Event event) {
		if (log().isDebugEnabled()) {
			log().debug(
					"Event ID " + event.getUei() + " to be broadcasted: "
							+ event.getUei());
		}

		if (m_listeners.isEmpty()) {
			log().debug("No listeners interested in all events");
		}

		// Send to listeners interested in receiving all events
		for (EventListener listener : m_listeners) {
			queueEventToListener(event, listener);
		}

		if (event.getUei() == null) {
			if (log().isDebugEnabled()) {
				log().debug(
						"Event ID "
								+ event.getUei()
								+ " does not have a UEI, so skipping UEI matching");
			}
			return;
		}

		/*
		 * Send to listeners who are interested in this event UEI.
		 * Loop to attempt partial wild card "directory" matches.
		 */
		Set<EventListener> sentToListeners = new HashSet<EventListener>();
		for (String uei = event.getUei(); uei.length() > 0;) {
			if (m_ueiListeners.containsKey(uei)) {
				for (EventListener listener : m_ueiListeners.get(uei)) {
					if (!sentToListeners.contains(listener)) {
						queueEventToListener(event, listener);
						sentToListeners.add(listener);
					}
				}
			}

			// Try wild cards: Find / before last character
			int i = uei.lastIndexOf("/", uei.length() - 2);
			if (i > 0) {
				// Split at "/", including the /
				uei = uei.substring(0, i + 1);
			} else {
				// No more wild cards to match
				break;
			}
		}

		if (sentToListeners.isEmpty()) {
			if (log().isDebugEnabled()) {
				log().debug(
						"No listener interested in event ID " + ": "
								+ event.getUei());
			}
		}
	}

	private void queueEventToListener(Event event, EventListener listener) {
		m_listenerThreads.get(listener.getName()).addEvent(event);
	}

	/**
	 * Register an event listener that is interested in all events.
	 * Removes this listener from any UEI-specific matches.
	 */
	@Override
	public synchronized void addEventListener(EventListener listener) {
		Assert.notNull(listener, "listener argument cannot be null");

		createListenerThread(listener);

		addMatchAllForListener(listener);

		// Since we have a match-all listener, remove any specific UEIs
		for (String uei : m_ueiListeners.keySet()) {
			removeUeiForListener(uei, listener);
		}
	}

	/**
	 * Register an event listener interested in the UEIs in the passed list.
	 */
	@Override
	public synchronized void addEventListener(EventListener listener,
			Collection<String> ueis) {
		Assert.notNull(listener, "listener argument cannot be null");
		Assert.notNull(ueis, "ueilist argument cannot be null");

		if (ueis.isEmpty()) {
			log().warn(
					"Not adding event listener "
							+ listener.getName()
							+ " because the ueilist argument contains no entries");
			return;
		}

		if (log().isDebugEnabled()) {
			log().debug(
					"Adding event listener "
							+ listener.getName()
							+ " for UEIs: "
							+ StringUtils
									.collectionToCommaDelimitedString(ueis));
		}

		createListenerThread(listener);

		for (String uei : ueis) {
			addUeiForListener(uei, listener);
		}

		// Since we have a UEI-specific listener, remove the match-all listener
		removeMatchAllForListener(listener);
	}

	/**
	 * Register an event listener interested in the passed UEI.
	 */
	@Override
	public synchronized void addEventListener(EventListener listener, String uei) {
		Assert.notNull(listener, "listener argument cannot be null");
		Assert.notNull(uei, "uei argument cannot be null");

		addEventListener(listener, Collections.singletonList(uei));
	}

	/**
	 * Removes a registered event listener. The UEI list indicates the list of
	 * events the listener is no more interested in.
	 * 
	 * <strong>Note: </strong>The listener thread for this listener is not
	 * stopped until the 'removeEventListener(EventListener listener)' method is
	 * called.
	 */
	@Override
	public synchronized void removeEventListener(EventListener listener,
			Collection<String> ueis) {
		Assert.notNull(listener, "listener argument cannot be null");
		Assert.notNull(ueis, "ueilist argument cannot be null");

		for (String uei : ueis) {
			removeUeiForListener(uei, listener);
		}
	}

	/**
	 * Removes a registered event listener. The UEI indicates one the listener
	 * is no more interested in.
	 * 
	 * <strong>Note: </strong>The listener thread for this listener is not
	 * stopped until the 'removeEventListener(EventListener listener)' method is
	 * called.
	 */
	@Override
	public synchronized void removeEventListener(EventListener listener,
			String uei) {
		Assert.notNull(listener, "listener argument cannot be null");
		Assert.notNull(uei, "uei argument cannot be null");

		removeUeiForListener(uei, listener);
	}

	/**
	 * Removes a registered event listener.
	 * 
	 * <strong>Note: </strong>Only this method stops the listener thread for the
	 * listener passed.
	 */
	@Override
	public synchronized void removeEventListener(EventListener listener) {
		Assert.notNull(listener, "listener argument cannot be null");

		removeMatchAllForListener(listener);

		for (String uei : m_ueiListeners.keySet()) {
			removeUeiForListener(uei, listener);
		}

		// stop and remove the listener thread for this listener
		if (m_listenerThreads.containsKey(listener.getName())) {
			m_listenerThreads.get(listener.getName()).stop();

			m_listenerThreads.remove(listener.getName());
		}
	}

	/**
	 * Create a new queue and listener thread for this listener if one does not
	 * already exist.
	 */
	private void createListenerThread(EventListener listener) {
		if (m_listenerThreads.containsKey(listener.getName())) {
			return;
		}

		ListenerThread listenerThread = new ListenerThread(listener);
		listenerThread.start();

		m_listenerThreads.put(listener.getName(), listenerThread);
	}

	/**
	 * Add to uei listeners.
	 */
	private void addUeiForListener(String uei, EventListener listener) {
		// Ensure there is a list for this UEI
		if (!m_ueiListeners.containsKey(uei)) {
			m_ueiListeners.put(uei, new ArrayList<EventListener>());
		}

		List<EventListener> listenersList = m_ueiListeners.get(uei);
		if (!listenersList.contains(listener)) {
			listenersList.add(listener);
		}
	}

	/**
	 * Remove UEI for this listener.
	 */
	private void removeUeiForListener(String uei, EventListener listener) {
		if (m_ueiListeners.containsKey(uei)) {
			m_ueiListeners.get(uei).remove(listener);
		}
	}

	/**
	 * Add listener to list of listeners listening for all events.
	 */
	private boolean addMatchAllForListener(EventListener listener) {
		return m_listeners.add(listener);
	}

	/**
	 * Remove from list of listeners listening for all events.
	 */
	private boolean removeMatchAllForListener(EventListener listener) {
		return m_listeners.remove(listener);
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	@Override
	public synchronized void afterPropertiesSet() {
		Assert.state(m_eventHandlerPool == null,
				"afterPropertiesSet() has already been called");

		Assert.state(m_eventHandler != null, "eventHandler not set");
		Assert.state(m_handlerPoolSize != null, "handlerPoolSize not set");

		m_eventHandlerPool = new RunnableConsumerThreadPool("EventHandlerPool",
				0.6f, 1.0f, m_handlerPoolSize);
		m_eventHandlerPool.start();

		// If the proxy is set, make this class its delegate.
		if (m_eventIpcManagerProxy != null) {
			m_eventIpcManagerProxy.setDelegate(this);
		}
	}

	public EventHandler getEventHandler() {
		return m_eventHandler;
	}

	public void setEventHandler(EventHandler eventHandler) {
		m_eventHandler = eventHandler;
	}

	public int getHandlerPoolSize() {
		return m_handlerPoolSize;
	}

	public void setHandlerPoolSize(int handlerPoolSize) {
		Assert.state(m_eventHandlerPool == null,
				"handlerPoolSize property cannot be set after afterPropertiesSet() is called");

		m_handlerPoolSize = handlerPoolSize;
	}

	public EventIpcManagerProxy getEventIpcManagerProxy() {
		return m_eventIpcManagerProxy;
	}

	public void setEventIpcManagerProxy(
			EventIpcManagerProxy eventIpcManagerProxy) {
		m_eventIpcManagerProxy = eventIpcManagerProxy;
	}
}
