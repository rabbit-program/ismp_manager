package org.infosec.ismp.manager.winsensor.event;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.infosec.ismp.manager.rmi.aim.service.AlertManager;
import org.springframework.util.Assert;

/**
 * @author guoxianwei
 * @date 2011-3-9 上午09:50:04
 * 
 */
public class SensorEventd extends AbstractServiceDaemon {
	/**
	 * The name of the logging category for Eventd.
	 */
	static final String LOG4J_CATEGORY = "ISMP.Eventd";

	private EventHandler m_udpEventReceiver;

	public SensorEventd() {
		super("ISMP.Eventd");
	}

	private int m_port;

	private AlertManager m_alertManager;

	@Override
	protected void onInit() {

		Assert.notNull(m_port, "m_syslogPort is null,please check");
		Assert.notNull(m_alertManager, "m_alertManager is null,please check");
		log().debug("start: Initializing the Eventd config factory");
		log().debug("Starting EventProcessor");

		m_udpEventReceiver = new EventHandler(m_alertManager, m_port);

	}

	@Override
	protected void onStart() {
		m_udpEventReceiver.start();

	}

	@Override
	protected void onStop() {
		// shutdown and wait on the background processing thread to exit.
		log().debug("exit: closing communication paths.");

		try {
			log().debug("stop: Closing Eventd message session.");

			log().debug("stop: winsensor event message session closed.");
		} catch (IllegalStateException e) {
			log().debug("stop: The winsensor event session was already closed");
		}

		log().debug("stop: Stopping queue processor.");

		m_udpEventReceiver.stop();
		log().debug("Stopped the winsensor event UDP Receiver");
	}

	public int getPort() {
		return m_port;
	}

	public AlertManager getAlertManager() {
		return m_alertManager;
	}
	public void setPort(int port) {
		m_port = port;
	}
	public void setAlertManager(AlertManager alertManager) {
		m_alertManager = alertManager;
	}

}
