package org.infosec.ismp.applet.manager.component.panel.view.network;

import org.infosec.ismp.applet.manager.component.panel.view.Info;

/**
 * MAC地址 IP地址 IP地址子网掩码 接口工作状态(true<up可工作>/false<down不可用>) 
 *  流入字节数 流出字节数 流入IP报文数 流出IP报文数 接口文字描述 接口速度 bit/s
 */
public class NetworkStatus extends Info {
	private String portName;
	private String physicalAddress;
	private String ipAddress;
	private String netMask;
	private boolean isUp;
	private long inBytes;
	private long outBytes;
	private long inPackets;
	private long outPackets;
	private String description;
	private long speed;

	public NetworkStatus(String portName) {
		setPortName(portName);
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		String old = this.physicalAddress;
		this.physicalAddress = physicalAddress;
		this.firePropertyChange("physicalAddress", old, physicalAddress);
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		String old = this.ipAddress;
		this.ipAddress = ipAddress;
		this.firePropertyChange("ipAddress", old, ipAddress);
	}

	public String getNetMask() {
		return netMask;
	}

	public void setNetMask(String netMask) {
		String old = this.netMask;
		this.netMask = netMask;
		this.firePropertyChange("netMask", old, netMask);
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		boolean old = isUp;
		this.isUp = isUp;
		this.firePropertyChange("isUp", old, isUp);
	}

	public long getInBytes() {
		return inBytes;
	}

	public void setInBytes(long inBytes) {
		long old = this.inBytes;
		this.inBytes = inBytes;
		this.firePropertyChange("inBytes", new Long(old), new Long(inBytes));
	}

	public long getOutBytes() {
		return outBytes;
	}

	public void setOutBytes(long outBytes) {
		long old = this.outBytes;
		this.outBytes = outBytes;
		this.firePropertyChange("outBytes", new Long(old), new Long(outBytes));
	}

	public long getInPackets() {
		return inPackets;
	}

	public void setInPackets(long inPackets) {
		long old = this.inPackets;
		this.inPackets = inPackets;
		this.firePropertyChange("inPackets", new Long(old), new Long(inPackets));
	}

	public long getOutPackets() {
		return outPackets;
	}

	public void setOutPackets(long outPackets) {
		long old = this.outPackets;
		this.outPackets = outPackets;
		this.firePropertyChange("outPackets", new Long(old), new Long(outPackets));
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		String old = this.description;
		this.description = description;
		this.firePropertyChange("description", old, description);
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		long old = this.speed;
		this.speed = speed;
		this.firePropertyChange("speed", new Long(old), new Long(speed));
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		String old = this.portName;
		this.portName = portName;
		this.firePropertyChange("portName", old, portName);
	}
}
