package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

/**
 * @author guoxianwei
 * @date 2010-10-13 下午03:39:32
 * 
 */
public class TcpConnEntry extends SnmpTableEntry {

	public TcpConnEntry() {
		super(ms_elemList);
	}

	public static final String TCP_CONNSTATE_ALIAS = "tcpConnState";
	public static final String TCP_CONNLOCALADDRESS_ALIAS = "tcpConnLocalAddress";
	public static final String TCP_CONNLOCALPORT_ALIAS = "tcpConnLocalPort";
	public static final String TCP_CONNREMADDRESS_ALIAS = "tcpConnRemAddress";
	public static final String TCP_CONNREMPORT_ALIAS = "tcpConnRemPort";

	private static final String TCP_CONNSTATE = ".1.3.6.1.2.1.6.13.1.1";
	private static final String TCP_CONNLOCALADDRESS = ".1.3.6.1.2.1.6.13.1.2";
	private static final String TCP_CONNLOCALPORT = ".1.3.6.1.2.1.6.13.1.3";
	private static final String TCP_CONNREMADDRESS = ".1.3.6.1.2.1.6.13.1.4";
	private static final String TCP_CONNREMPORT = ".1.3.6.1.2.1.6.13.1.5";

	public static NamedSnmpVar[] ms_elemList = null;

	static {
		// Changed array size from 7 to 6 because we are no longer going after
		// sysServices...sysServices is not currently being used and it causes
		// the entire SystemGroup collection to fail on at least one version
		// of Linux where it does not exist in the SNMP agent.
		//
		ms_elemList = new NamedSnmpVar[5];
		int ndx = 0;

		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				TCP_CONNSTATE_ALIAS, TCP_CONNSTATE, 1);

		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPIPADDRESS,
				TCP_CONNLOCALADDRESS_ALIAS, TCP_CONNLOCALADDRESS, 2);

		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				TCP_CONNLOCALPORT_ALIAS, TCP_CONNLOCALPORT, 3);
		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPIPADDRESS,
				TCP_CONNREMADDRESS_ALIAS, TCP_CONNREMADDRESS, 4);
		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				TCP_CONNREMPORT_ALIAS, TCP_CONNREMPORT, 5);

	}
	public static final String TABLE_OID = ".1.3.6.1.2.1.6.13.1";
	
	public int getTcpConnState() {
		return getInt32(TCP_CONNSTATE);
	}

	public InetAddress getTcpConnLocalAddress() {
		return getIPAddress(TCP_CONNLOCALADDRESS);
	}

	public int getTcpConnLocalPort() {
		return getInt32(TCP_CONNLOCALPORT);
	}

	public InetAddress getTcpConnRemAddress() {
		return getIPAddress(TCP_CONNREMADDRESS);
	}

	public int getTcpConnRemPort() {
		return getInt32(TCP_CONNREMPORT);
	}   

}

