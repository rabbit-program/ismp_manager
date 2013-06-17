package org.infosec.ismp.eventd.adaptors.jms;

import java.util.List;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.eventd.adaptors.EventHandler;
import org.infosec.ismp.eventd.adaptors.EventReceiver;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.util.Assert;

/**
 * 从Jms服务器中接受Event事件。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class JmsEventReceiver implements EventReceiver {
	/**
	 * jms 接受线程
	 */
	private JmsReceiver m_receiver;

	/**
	 * 事件处理器
	 */
	private MessageProcessor m_processor;

	private List<JmsReceivedEvent> m_eventsIn;

	private List<EventHandler> m_eventHandlers;

	/**
	 * The Fiber's status.
	 */
	private volatile int m_status;

	/**
	 * The log prefix
	 */
	private final String m_logPrefix;

	private Session m_session;

	private Destination m_destination;

	private Connection m_connection;

	public JmsEventReceiver(Connection con, Destination destination) {
		m_logPrefix = Eventd.LOG4J_CATEGORY;
		this.m_connection = con;
		this.m_destination = destination;

	}

	@Override
	public void start() {
		assertNotRunning();

		m_status = STARTING;

		try {
			m_connection.start();
			m_session = m_connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			m_receiver = new JmsReceiver(m_session, m_destination, m_eventsIn);
			m_processor = new MessageProcessor(m_eventHandlers, m_eventsIn);

			if (m_logPrefix != null) {
				m_receiver.setLogPrefix(m_logPrefix);
				m_processor.setLogPrefix(m_logPrefix);
			}
		} catch (Exception e) {
			throw new java.lang.reflect.UndeclaredThrowableException(e);
		}

		Thread rThread = new Thread(m_receiver, "JMS Event Receiver["
				+ m_destination + "]");
		Thread pThread = new Thread(m_processor, "JMS Event Processor["
				+ m_destination + "]");

		try {
			rThread.start();
			pThread.start();
		} catch (RuntimeException e) {
			rThread.interrupt();
			pThread.interrupt();

			m_status = STOPPED;

			throw e;
		}

		m_status = RUNNING;

	}

	@Override
	public void stop() {
		if (m_status == STOPPED) {
			return;
		}
		if (m_status == START_PENDING) {
			m_status = STOPPED;
			return;
		}

		m_status = STOP_PENDING;

		try {
			m_receiver.stop();
			m_processor.stop();
			m_connection.close();
		} catch (InterruptedException e) {
			log().warn(
					"The thread was interrupted while attempting to join sub-threads: "
							+ e, e);
		} catch (JMSException e) {
			log().warn("The jms connection error while close  " + e, e);
		}

		m_status = STOPPED;

	}

	@Override
	public String getName() {
		return "Event JMS Receiver[" + m_destination + "]";
	}

	@Override
	public int getStatus() {
		return m_status;
	}

	@Override
	public void init() {
		//do nothing
	}

	@Override
	public void destroy() {
		//do nothing
	}

	/**
	 * Adds a new event handler to receiver. When new events are received the
	 * decoded event is passed to the handler.
	 * 
	 * @param handler
	 *            A reference to an event handler
	 * 
	 */
	@Override
	public void addEventHandler(EventHandler handler) {
		synchronized (m_eventHandlers) {
			if (!m_eventHandlers.contains(handler)) {
				m_eventHandlers.add(handler);
			}
		}
	}

	/**
	 * Removes an event handler from the list of handler called when an event is
	 * received. The handler is removed based upon the method
	 * <code>equals()</code> inherieted from the <code>Object</code> class.
	 * 
	 * @param handler
	 *            A reference to the event handler.
	 * 
	 */
	@Override
	public void removeEventHandler(EventHandler handler) {
		synchronized (m_eventHandlers) {
			m_eventHandlers.remove(handler);
		}
	}

	public List<EventHandler> getEventHandlers() {
		return m_eventHandlers;
	}

	public void setEventHandlers(List<EventHandler> eventHandlers) {
		m_eventHandlers = eventHandlers;
	}

	private void assertNotRunning() {
		Assert.state(m_status == START_PENDING || m_status == STOPPED,
				"The fiber is already running and cannot be modified or started");
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
