package org.infosec.ismp.syslogd;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.infosec.ismp.eventd.sender.ObjectJmsSender;
import org.infosec.ismp.model.syslog.RawSyslog;
import org.infosec.ismp.util.ThreadCategory;
import org.springside.modules.utils.SpringContextHolder;

/**
 * This class encapsulates the execution context for processing syslog messsages
 * received via UDP from remote agents. This is a separate event context to
 * allow the event receiver to do minimum work to avoid dropping packets from
 * the agents.
 * 
 * @author <a href="mailto:weave@oculan.com">Brian Weaver </a>
 * @author <a href="http://www.oculan.com">Oculan Corporation </a>
 */
final class SyslogProcessor implements Runnable {

	@SuppressWarnings("unused")
	private BroadcastEventProcessor m_eventReader;

	/**
	 * The UDP receiver thread.
	 */
	private Thread m_context;

	/**
	 * The stop flag
	 */
	private volatile boolean m_stop;

	/**
	 * The log prefix
	 */
	private String m_logPrefix;

	private String m_localAddr;

	public static void setSyslogConfig(SyslogdConfig syslogdConfig) {
		@SuppressWarnings("unused")
		SyslogdConfig m_syslogdConfig = syslogdConfig;
	}

	SyslogProcessor() {
		m_context = null;
		m_stop = false;

		m_logPrefix = Syslogd.LOG4J_CATEGORY;

		try {
			m_localAddr = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException uhE) {
			ThreadCategory log = ThreadCategory.getInstance(getClass());

			m_localAddr = "localhost";
			log.error("Error looking up local hostname; using 'localhost'", uhE);
		}

	}

	/**
	 * Returns true if the thread is still alive
	 */
	boolean isAlive() {
		return (m_context != null && m_context.isAlive());
	}

	/**
	 * Stops the current context
	 */
	void stop() throws InterruptedException {
		m_stop = true;
		if (m_context != null) {
			ThreadCategory log = ThreadCategory.getInstance(getClass());
			if (log.isDebugEnabled())
				log.debug("Stopping and joining thread context "
						+ m_context.getName());

			m_context.interrupt();
			m_context.join();

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
		ThreadCategory log = ThreadCategory.getInstance(getClass());
		boolean isTracing = log.isEnabledFor(ThreadCategory.Level.TRACE);

		if (m_stop) {
			if (isTracing)
				log.trace("Stop flag set before thread started, exiting");
			return;
		} else if (isTracing)
			log.trace("Thread context started");

		while (!m_stop) {

			RawSyslog syslog = null;

			syslog = SyslogHandler.queueManager.getFromQueue();

			if (syslog!=null) {
				try {
					if (isTracing) {
						log.trace("Processing a syslog to event dispatch"
								+ syslog);
						// TODO 记录事件的详细信息，便于调试
					}

					// 送到事件中心
					//EventIpcManagerFactory.getIpcManager().sendNow(event);
					
					// 送到jms中心
//                   System.out.println("send jms is: "+event.getSyslog());
					ObjectJmsSender sender = (ObjectJmsSender)SpringContextHolder.getBean("syslogSender");
					sender.sendSerializableObject(syslog);
				} catch (Throwable t) {
					log.error(
							"Unexpected error processing SyslogMessage - Could not send",
							t);
				}
			}

		}

	}

	void setLogPrefix(String prefix) {
		m_logPrefix = prefix;
	}
	

}
