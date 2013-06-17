package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

/**
 * @author guoxianwei
 * @date 2010-10-12 下午03:34:49
 * 
 */
public class AtTableEntity extends SnmpTableEntry {

	public AtTableEntity() {
		super(ms_elemList);
	}

	//
	// Lookup strings for specific table entries
	//
	public final static String AT_IF_INDEX_ALIAS = "atIfIndex";
	private static final String AT_IF_INDEX = ".1.3.6.1.2.1.3.1.1.1";

	public final static String AT_PHYS_ADDRESS_ALIAS = "atPhysAddress";
	private static final String AT_PHYS_ADDRESS = ".1.3.6.1.2.1.3.1.1.2";

	public final static String AT_NET_ADDRESS_ALIAS = "atNetAddress";
	private static final String AT_NET_ADDRESS = ".1.3.6.1.2.1.3.1.1.3";

	/**
	 * <P>
	 * The keys that will be supported by default from the TreeMap base class.
	 * Each of the elements in the list are an instance of the SNMP Interface
	 * table. Objects in this list should be used by multiple instances of this
	 * class.
	 * </P>
	 */
	public static NamedSnmpVar[] ms_elemList = null;

	/**
	 * <P>
	 * Initialize the element list for the class. This is class wide data, but
	 * will be used by each instance.
	 * </P>
	 */
	static {
		// Changed array size from 7 to 6 because we are no longer going after
		// sysServices...sysServices is not currently being used and it causes
		// the entire SystemGroup collection to fail on at least one version
		// of Linux where it does not exist in the SNMP agent.
		//
		ms_elemList = new NamedSnmpVar[3];
		int ndx = 0;

		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				AT_IF_INDEX_ALIAS, AT_IF_INDEX, 1);

		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,
				AT_PHYS_ADDRESS_ALIAS, AT_PHYS_ADDRESS, 2);

		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPIPADDRESS,
				AT_NET_ADDRESS_ALIAS, AT_NET_ADDRESS, 3);

	}

	/**
	 * <P>
	 * The SYSTEM_OID is the object identifier that represents the root of the
	 * system information in the MIB forest. Each of the system elements can be
	 * retreived by adding their specific index to the string, and an additional
	 * Zero(0) to signify the single instance item.
	 * </P>
	 */
	public static final String TABLE_OID = ".1.3.6.1.2.1.3.1.1";

	public String getAtPhysAddress() {
		return this.getDisplayString(AT_PHYS_ADDRESS);
	}

	public InetAddress getAtNetAddress() {
		return getIPAddress(AT_NET_ADDRESS);
	}

	public int getAtIfIndex() {
		return getInt32(AT_IF_INDEX);
	}
}
