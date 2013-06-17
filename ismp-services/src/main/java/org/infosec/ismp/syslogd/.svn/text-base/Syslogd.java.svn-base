package org.infosec.ismp.syslogd;

import java.lang.reflect.UndeclaredThrowableException;
import java.sql.SQLException;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.springframework.util.Assert;

/**
 * The received messages are converted into XML and sent to eventd
 * </p>
 * <p/>
 * <strong>Note: </strong>Syslogd is a PausableFiber so as to receive control
 * events. However, a 'pause' on Syslogd has no impact on the receiving and
 * processing of traps
 * </p>
 */

public class Syslogd extends AbstractServiceDaemon {
	/**
	 * The name of the logging category for Syslogd.
	 */
	static final String LOG4J_CATEGORY = "ISMP.Syslogd";

	/**
	 * The singlton instance.
	 */
	private static final Syslogd m_singleton = new Syslogd();

	/*
	* @return Syslogd
	*/
	public synchronized static Syslogd getSingleton() {
		return m_singleton;
	}

	private SyslogHandler m_udpEventReceiver;

	private SyslogdConfig m_syslogdConfig;

	public Syslogd() {
		super("ISMP.Syslogd");
	}

	@Override
	protected void onInit() {

		Assert.notNull(m_syslogdConfig, "syslogdConfig is null,please check");
		log().debug("start: Initializing the syslogd config factory");

		try {
			// clear out the known nodes
			SyslogdIPMgr.dataSourceSync();
		} catch (SQLException e) {
			log().error("Failed to load known IP address list", e);
			throw new UndeclaredThrowableException(e);
		}

		SyslogHandler.setSyslogConfig(m_syslogdConfig);
		log().debug("Starting SyslogProcessor");

		m_udpEventReceiver = new SyslogHandler();

	}

	@Override
	protected void onStart() {
		m_udpEventReceiver.start();

		// // start the event reader
		// The Node list is update with new suspects
		// Also this enables the syslogd to act as
		// trapd and see New suspects.

		try {
			BroadcastEventProcessor m_eventReader = new BroadcastEventProcessor();
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

	/**
	 * Returns the singular instance of the syslogd daemon. There can be only
	 * one instance of this service per virtual machine.
	 *
	 * @return Singleton
	 */
	public static Syslogd getInstance() {
		return m_singleton;
	}

	public void setSyslogdConfig(SyslogdConfig syslogdConfig) {
		m_syslogdConfig = syslogdConfig;
	}

}
