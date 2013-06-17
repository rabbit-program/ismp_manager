package org.infosec.ismp.snmp;

import java.net.InetAddress;

import org.infosec.ismp.util.ThreadCategory;

public abstract class TrapInformation implements TrapNotification {

	/**
	 * The internet address of the sending agent
	 */
	private final InetAddress m_agent;
	/**
	 * The community string from the actual SNMP packet
	 */
	private final String m_community;
	private final TrapProcessor m_trapProcessor;

	protected TrapInformation(InetAddress agent, String community,
			TrapProcessor trapProcessor) {
		m_agent = agent;
		m_community = community;
		m_trapProcessor = trapProcessor;

	}

	protected abstract InetAddress getTrapAddress();

	/**
	 * Returns the sending agent's internet address
	 */
	protected InetAddress getAgent() {
		return m_agent;
	}

	/**
	 * Returns the SNMP community string from the received packet.
	 */
	protected String getCommunity() {
		return m_community;
	}

	protected void validate() {
		// by default we do nothing;
	}

	protected ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	protected InetAddress getAgentAddress() {
		return getAgent();
	}

	@Override
	public TrapProcessor getTrapProcessor() {
		// We do this here to processing of the data is delayed until it is
		// requested.
		processTrap();
		return m_trapProcessor;
	}

	protected abstract String getVersion();

	protected abstract int getPduLength();

	protected abstract long getTimeStamp();

	protected abstract TrapIdentity getTrapIdentity();

	protected void processTrap() {

		validate();

		m_trapProcessor.setVersion(getVersion());
		m_trapProcessor.setCommunity(getCommunity());
		m_trapProcessor.setAgentAddress(getAgentAddress());
		m_trapProcessor.setTrapAddress(getTrapAddress());

		if (log().isDebugEnabled()) {
			log().debug(
					getVersion() + " trap - trapInterface: " + getTrapAddress());
		}

		// time-stamp
		m_trapProcessor.setTimeStamp(getTimeStamp());

		m_trapProcessor.setTrapIdentity(getTrapIdentity());

		for (int i = 0; i < getPduLength(); i++) {
			processVarBindAt(i);
		} // end for loop
	}

	protected abstract void processVarBindAt(int i);

	protected void processVarBind(SnmpObjId name, SnmpValue value) {
		m_trapProcessor.processVarBind(name, value);
	}

}
