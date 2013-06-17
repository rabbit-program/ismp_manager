package org.infosec.ismp.collectd.snmp.cisco;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpTableEntry;

/**
 * @author guoxianwei
 * @date 2010-10-20 下午03:20:50
 * 
 */
public class CpmProcessExtEntry extends SnmpTableEntry{
	
	public CpmProcessExtEntry() {
		super(ms_elemList);
	}
	
	public static final String CPM_PROC_EXT_MEMALLOCATED_ALIAS = "cpmProcExtMemAllocated";
	public static final String CPM_PROC_EXT_MEMFREED_ALIAS = "cpmProcExtMemFreed";
	public static final String CPM_PROC_EXT_INVOKED_ALIAS = "cpmProcExtInvoked";
	public static final String CPM_PROC_EXT_RUNTIME_ALIAS = "cpmProcExtRuntime";
	public static final String CPM_PROC_EXT_UTIL5SEC_ALIAS = "cpmProcExtUtil5Sec";
	public static final String CPM_PROC_EXT_UTIL1MIN_ALIAS = "cpmProcExtUtil1Min";
	public static final String CPM_PROC_EXT_UTIL5MIN_ALIAS = "cpmProcExtUtil5Min";
	public static final String CPM_PROC_EXT_PRIORITY_ALIAS = "cpmProcExtPriority"; 

	private static final String CPM_PROC_EXT_MEMALLOCATED = ".1.3.6.1.4.1.9.9.109.1.2.2.1.1";
	private static final String CPM_PROC_EXT_MEMFREED = ".1.3.6.1.4.1.9.9.109.1.2.2.1.2";
	private static final String CPM_PROC_EXT_INVOKED = ".1.3.6.1.4.1.9.9.109.1.2.2.1.3";
	private static final String CPM_PROC_EXT_RUNTIME = ".1.3.6.1.4.1.9.9.109.1.2.2.1.4";
	private static final String CPM_PROC_EXT_UTIL5SEC = ".1.3.6.1.4.1.9.9.109.1.2.2.1.5";
	private static final String CPM_PROC_EXT_UTIL1MIN = ".1.3.6.1.4.1.9.9.109.1.2.2.1.6";
	private static final String CPM_PROC_EXT_UTIL5MIN = ".1.3.6.1.4.1.9.9.109.1.2.2.1.7";
	private static final String CPM_PROC_EXT_PRIORITY = ".1.3.6.1.4.1.9.9.109.1.2.2.1.8";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		ms_elemList = new NamedSnmpVar[8];
		int ndx = 0;

		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_MEMALLOCATED_ALIAS , CPM_PROC_EXT_MEMALLOCATED , 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_MEMFREED_ALIAS , CPM_PROC_EXT_MEMFREED , 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_INVOKED_ALIAS , CPM_PROC_EXT_INVOKED , 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_RUNTIME_ALIAS , CPM_PROC_EXT_RUNTIME , 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_UTIL5SEC_ALIAS , CPM_PROC_EXT_UTIL5SEC , 5);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_UTIL1MIN_ALIAS , CPM_PROC_EXT_UTIL1MIN , 6);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_UTIL5MIN_ALIAS , CPM_PROC_EXT_UTIL5MIN , 7);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_PRIORITY_ALIAS , CPM_PROC_EXT_PRIORITY , 8);
	}
	
	public static final String TABLE_OID = ".1.3.6.1.4.1.9.9.109.1.2.2.1"; // start
	
	public int getCpmProcExtMemAllocated() {
		return getInt32(CPM_PROC_EXT_MEMALLOCATED);
	}

	public int getCpmProcExtMemFreed() {
		return getInt32(CPM_PROC_EXT_MEMFREED);
	}

	public int getCpmProcExtInvoked() {
		return getInt32(CPM_PROC_EXT_INVOKED);
	}

	public int getCpmProcExtRuntime() {
		return getInt32(CPM_PROC_EXT_RUNTIME);
	}

	public int getCpmProcExtUtil5Sec() {
		return getInt32(CPM_PROC_EXT_UTIL5SEC);
	}

	public int getCpmProcExtUtil1Min() {
		return getInt32(CPM_PROC_EXT_UTIL1MIN);
	}

	public int getCpmProcExtUtil5Min() {
		return getInt32(CPM_PROC_EXT_UTIL5MIN);
	}

	public int getCpmProcExtPriority() {
		return getInt32(CPM_PROC_EXT_PRIORITY);
	}
	public String getTest(){
		return getValue(CPM_PROC_EXT_PRIORITY_ALIAS).toDisplayString();
	}
	

}

