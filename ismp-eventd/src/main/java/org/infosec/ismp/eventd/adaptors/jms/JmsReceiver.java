package org.infosec.ismp.eventd.adaptors.jms;

import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.util.ThreadCategory;

/**
 * 接受Jms消息。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class JmsReceiver implements Runnable {
	/**
	 * 是否停止标识
	 */
	private volatile boolean m_stop = false;
	/**
	 * 背景线程
	 */
	private Thread m_context;

	/**
	 * 日志类型前缀
	 */
	private String m_logPrefix;

	/**
	 * jms目标地址
	 */
	private final Session m_session;

	private final Destination m_destination;

	private final List<JmsReceivedEvent> m_eventsIn;

	/**
	 * 包内构造器
	 * @param destination
	 */
	JmsReceiver(Session session, Destination destination,
			List<JmsReceivedEvent> exchanges) {
		m_session = session;
		m_destination = destination;
		m_eventsIn = exchanges;
		m_logPrefix = Eventd.LOG4J_CATEGORY;
	}

	/**
	 * stop the current receiver
	 */
	void stop() throws InterruptedException {
		m_stop = true;
		if (m_context != null) {
			if (log().isDebugEnabled()) {
				log().debug(
						"Stopping and joining thread context "
								+ m_context.getName());
			}

			m_context.interrupt();
			m_context.join();

			log().debug("Thread context stopped and joined");
		}
	}

	/**
	 * Return true if this receiver is alive
	 */
	boolean isAlive() {
		return (m_context == null ? false : m_context.isAlive());
	}

	@Override
	public void run() {
		//get context thread
		m_context = Thread.currentThread();

		// Get a log instance
		ThreadCategory.setPrefix(m_logPrefix);

		if (m_stop) {
			log().debug("Stop flag set before thread started, exiting");
			return;
		} else {
			log().debug("Thread context started");
		}

		MessageConsumer consumer;
		try {
			consumer = m_session.createConsumer(m_destination);
		} catch (JMSException e) {
			log().fatal("fatal error :" + e, e);
			return;
		}

		Message msg;

		boolean isTimeout = false;

		while (!m_stop) {
			if (m_context.isInterrupted()) {
				log().debug("Thread context interrupted");
				break;
			}

			try {
				if (log().isDebugEnabled() && !isTimeout) {
					log().debug("Wating on a jms message to arrive");
				}
				msg = consumer.receive(500);
				if (msg == null) {
					isTimeout = true;
					continue;
				} else {
					isTimeout = false;
				}
			} catch (JMSException e) {
				log().warn("an receive message error occur " + e, e);
				break;
			}

			log().debug("Sending received message to processor");

			JmsReceivedEvent je = JmsReceivedEvent.make(msg);
			synchronized (m_eventsIn) {
				m_eventsIn.add(je);
				m_eventsIn.notify();
			}
		}

		log().debug("Thread context exiting");

	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	public void setLogPrefix(String logPrefix) {
		m_logPrefix = logPrefix;
	}

}
