package org.infosec.ismp.servicecheck;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.infosec.ismp.model.poller.MonitoredService;
import org.infosec.ismp.model.poller.NetworkInterface;

public class ServiceCheckMonitoredService implements MonitoredService {

	private String m_ipAddr;

	public ServiceCheckMonitoredService(String ipAddr) {
		this.m_ipAddr = ipAddr;
	}

	@Override
	public String getSvcName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIpAddr() {
		return m_ipAddr;
	}

	@Override
	public int getNodeId() {
		throw new RuntimeException("not be called");
	}

	@Override
	public String getNodeLabel() {
		throw new RuntimeException("not be called");
	}

	@Override
	public NetworkInterface getNetInterface() {

		return new NetworkInterface() {

			@Override
			public int getType() {
				return TYPE_IPV4;
			}

			@Override
			public Object getAddress() {
				try {
					return InetAddress.getByName(m_ipAddr);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			public Object getAttribute(String property) {
				throw new RuntimeException("not be called");
			}

			@Override
			public Object setAttribute(String property, Object value) {
				throw new RuntimeException("not be called");
			}

		};
	}

	@Override
	public InetAddress getAddress() {
		try {
			return InetAddress.getByName(m_ipAddr);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}

}
