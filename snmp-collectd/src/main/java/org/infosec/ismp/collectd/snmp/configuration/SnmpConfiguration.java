package org.infosec.ismp.collectd.snmp.configuration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author g.x.w
 * @date 2010-11-4 下午06:16:46
 * 
 */
public final class SnmpConfiguration {

	private SnmpConfiguration() {
		m_devices = new Vector<Device>();
	}

	private Vector<Device> m_devices;

	public Vector<Device> getDevices() {
		return m_devices;
	}

	public void setDevices(Vector<Device> device) {
		m_devices = device;
	}
	//for test
	public void addDevice(Device device) {
		m_devices.add(device);
	}
	public Iterable<Device> getDeviceCollection(){
		return m_devices;
	}
	public Enumeration<Device> enumerateDevice(){
		return m_devices.elements();
	}
	public int getDeviceCount(){
		
		return m_devices.size();
	}
	public static SnmpConfiguration newSnmpConfiguration(){
		return new SnmpConfiguration();
	}
}

