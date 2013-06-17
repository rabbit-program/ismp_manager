package org.infosec.ismp.collectd.snmp.cisco;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpTableEntry;

/**
 * @author guoxianwei
 * @date 2010-10-20 下午04:29:26
 * 
 */
public class CiscoMemoryPoolEntry  extends SnmpTableEntry {
	
	public CiscoMemoryPoolEntry() {
		super(ms_elemList);
	}
	
	public static final String CISCO_MEMORY_POOL_NAME_ALIAS = "ciscoMemoryPoolName";
	public static final String CISCO_MEMORY_POOL_ALTERNATE_ALIAS = "ciscoMemoryPoolAlternate";
	public static final String CISCO_MEMORY_POOL_VALID_ALIAS = "ciscoMemoryPoolValid";
	public static final String CISCO_MEMORY_POOL_USED_ALIAS = "ciscoMemoryPoolUsed";
	public static final String CISCO_MEMORY_POOL_FREE_ALIAS = "ciscoMemoryPoolFree";
	public static final String CISCO_MEMORY_POOL_LARGESTFREE_ALIAS = "ciscoMemoryPoolLargestFree";

	private static final String CISCO_MEMORY_POOL_NAME        = ".1.3.6.1.4.1.9.9.48.1.1.1.2";
	private static final String CISCO_MEMORY_POOL_ALTERNATE   = ".1.3.6.1.4.1.9.9.48.1.1.1.3";
	private static final String CISCO_MEMORY_POOL_VALID       = ".1.3.6.1.4.1.9.9.48.1.1.1.4";
	private static final String CISCO_MEMORY_POOL_USED        = ".1.3.6.1.4.1.9.9.48.1.1.1.5";
	private static final String CISCO_MEMORY_POOL_FREE        = ".1.3.6.1.4.1.9.9.48.1.1.1.6";
	private static final String CISCO_MEMORY_POOL_LARGESTFREE = ".1.3.6.1.4.1.9.9.48.1.1.1.7";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		ms_elemList = new NamedSnmpVar[6];
		int ndx = 0;

		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CISCO_MEMORY_POOL_NAME_ALIAS , CISCO_MEMORY_POOL_NAME , 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CISCO_MEMORY_POOL_ALTERNATE_ALIAS , CISCO_MEMORY_POOL_ALTERNATE , 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CISCO_MEMORY_POOL_VALID_ALIAS , CISCO_MEMORY_POOL_VALID , 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CISCO_MEMORY_POOL_USED_ALIAS , CISCO_MEMORY_POOL_USED , 5);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CISCO_MEMORY_POOL_FREE_ALIAS , CISCO_MEMORY_POOL_FREE , 6);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CISCO_MEMORY_POOL_LARGESTFREE_ALIAS , CISCO_MEMORY_POOL_LARGESTFREE , 7);
	}
	public static final String TABLE_OID = ".1.3.6.1.4.1.9.9.48.1.1.1"; // start

	public String getCiscoMemoryPoolName() {
		return getDisplayString(CISCO_MEMORY_POOL_NAME);
	}

	public int getCiscoMemoryPoolAlternate() {
		return getInt32(CISCO_MEMORY_POOL_ALTERNATE);
	}

	public int getCiscoMemoryPoolValid() {
		return getInt32(CISCO_MEMORY_POOL_VALID);
	}

	public int getCiscoMemoryPoolUsed() {
		return getInt32(CISCO_MEMORY_POOL_USED);
	}

	public int getCiscoMemoryPoolFree() {
		return getInt32(CISCO_MEMORY_POOL_FREE);
	}

	public int getCiscoMemoryPoolLargestFree() {
		return getInt32(CISCO_MEMORY_POOL_LARGESTFREE);
	}   

}

