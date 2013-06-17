package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

/**
 * @author guoxianwei
 * @date 2010-10-13 下午06:56:19
 * 
 */
public class UdpEntry extends SnmpTableEntry {
	public UdpEntry() {
		super(ms_elemList);
	}
	
	public static final String UDP_LOCAL_ADDRESS_ALIAS = "udpLocalAddress";
	public static final String UDP_LOCAL_PORT_ALIAS = "udpLocalPort";
	
	public static final String UDP_LOCAL_ADDRESS = ".1.3.6.1.2.1.7.5.1.1";
	public static final String UDP_LOCAL_PORT = ".1.3.6.1.2.1.7.5.1.2";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		// Changed array size from 7 to 6 because we are no longer going after
		// sysServices...sysServices is not currently being used and it causes
		// the entire SystemGroup collection to fail on at least one version
		// of Linux where it does not exist in the SNMP agent.
		//
		ms_elemList = new NamedSnmpVar[2];
		int ndx = 0;

		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPIPADDRESS,
				UDP_LOCAL_ADDRESS_ALIAS, UDP_LOCAL_ADDRESS, 1);

		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				UDP_LOCAL_PORT_ALIAS, UDP_LOCAL_PORT, 2);
	}
	public static final String TABLE_OID = ".1.3.6.1.2.1.7.5.1";
	
	public InetAddress getUdpLocalAddress() {
		return getIPAddress(UDP_LOCAL_ADDRESS);
	}

	public int getUdpLocalPort() {
		return getInt32(UDP_LOCAL_PORT);
	}

}

