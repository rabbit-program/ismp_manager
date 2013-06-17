package org.infosec.ismp.syslogd;

import java.lang.reflect.UndeclaredThrowableException;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.springframework.util.Assert;

/**
 * syslog接受模块
 */

public class Syslogd extends AbstractServiceDaemon {
	/**
	 * The name of the logging category for Syslogd.
	 */
	static final String LOG4J_CATEGORY = "ISMP.Syslogd";

	private SyslogHandler m_udpEventReceiver;

	public Syslogd() {
		super("ISMP.Syslogd");
	}

	private int m_syslogPort;

	private SyslogNodeManager m_syslogNodeManager;

	@Override
	protected void onInit() {

		Assert.notNull(m_syslogPort, "m_syslogPort is null,please check");
		Assert.notNull(m_syslogNodeManager,
				"m_syslogNodeManager is null,please check");
		log().debug("start: Initializing the syslogd config factory");
		// SyslogdParserMgrFactory.setSyslogdParserMgr(m_syslogdParserMgr);

		// SyslogHandler.setSyslogConfig(m_syslogdConfig);
		log().debug("Starting SyslogProcessor");

		m_udpEventReceiver = new SyslogHandler(m_syslogPort,
				m_syslogNodeManager);

	}

	@Override
	protected void onStart() {
		m_udpEventReceiver.start();

		try {
			BroadcastEventProcessor m_eventReader = new BroadcastEventProcessor(m_syslogNodeManager);
		} catch (Exception ex) {
			log().error("Failed to setup event reader", ex);
			throw new UndeclaredThrowableException(ex);
		}
	}

	@Override
	protected void onStop() {
		// shutdown and wait on the background processing thread to exit.
		log().debug("exit: closing communication paths.");

		try {
			log().debug("stop: Closing SYSLOGD message session.");

			log().debug("stop: Syslog message session closed.");
		} catch (IllegalStateException e) {
			log().debug("stop: The Syslog session was already closed");
		}

		log().debug("stop: Stopping queue processor.");

		m_udpEventReceiver.stop();
		log().debug("Stopped the Syslog UDP Receiver");
	}

	public int getSyslogPort() {
		return m_syslogPort;
	}

	public void setSyslogPort(int syslogPort) {
		m_syslogPort = syslogPort;
	}

	public void setSyslogNodeManager(SyslogNodeManager syslogNodeManager) {
		m_syslogNodeManager = syslogNodeManager;
	}

}
