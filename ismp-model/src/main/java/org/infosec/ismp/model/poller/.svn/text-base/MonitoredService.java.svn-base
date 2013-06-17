package org.infosec.ismp.model.poller;

import java.net.InetAddress;

public interface MonitoredService {

	/**
	 * Returns the svcName associated with this monitored service
	 * @return the svcName
	 */
	public abstract String getSvcName();

	/**
	 * Returns the ipAddr string associated with this monitored service
	 * @return the ipAddr string
	 */
	public abstract String getIpAddr();

	/**
	 * Returns the nodeId of the node that this service is associated with
	 * @return the nodeid
	 */
	public abstract int getNodeId();

	/**
	 * Returns the label of the node that this service is associated with
	 * @return the nodelabel
	 */
	public abstract String getNodeLabel();

	/**
	 * Returns the Netinterface object for this service.  This netinterface object is
	 * guarenteed to be the same each time init or poll is called
	 * @return the Netinterface
	 */
	public abstract NetworkInterface getNetInterface();

	/**
	 * Returns the InetAddress associated with the service
	 * @return the InetAddress
	 */
	public abstract InetAddress getAddress();

}