package org.infosec.ismp.eventd;

import org.springframework.util.Assert;

public class EventIpcManagerFactory {
	/**
	 * The EventIpcManager instance.
	 */
	private static EventIpcManager m_ipcManager;

	/**
	 * This class only has static methods.
	 */
	private EventIpcManagerFactory() {
	}

	/**
	 * Create the singleton instance of this factory
	 */
	public static synchronized void init() {
	}

	/**
	 * Returns an implementation of the default EventIpcManager class
	 */
	public static EventIpcManager getIpcManager() {
		Assert.state(m_ipcManager != null,
				"this factory has not been initialized");
		return m_ipcManager;
	}

	public static void setIpcManager(EventIpcManager ipcManager) {
		Assert.notNull(ipcManager, "argument ipcManager must not be null");
		m_ipcManager = ipcManager;
	}

	/**
	 * This is here for unit testing so we can reset this class before
	 * every test.
	 */
	protected static void reset() {
		m_ipcManager = null;
	}

}
