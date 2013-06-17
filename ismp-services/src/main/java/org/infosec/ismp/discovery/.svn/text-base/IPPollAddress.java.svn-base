package org.infosec.ismp.discovery;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPPollAddress {
	private final InetAddress m_address;
	private final long m_timeout;

	private final int m_retries;

	public IPPollAddress(String ipaddress, long m_timeout, int m_retries)
			throws UnknownHostException {
		this.m_address = InetAddress.getByName(ipaddress);
		this.m_timeout = m_timeout;
		this.m_retries = m_retries;
	}

	public InetAddress getAddress() {
		return m_address;
	}

	public long getTimeout() {
		return m_timeout;
	}

	public int getRetries() {
		return m_retries;
	}

}
