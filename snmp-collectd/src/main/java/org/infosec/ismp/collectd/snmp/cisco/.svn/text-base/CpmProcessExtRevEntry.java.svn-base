package org.infosec.ismp.collectd.snmp.cisco;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpTableEntry;

/**
 * @author guoxianwei
 * @date 2010-10-20 下午04:02:30
 * 
 */
public class CpmProcessExtRevEntry extends SnmpTableEntry{
	
	public CpmProcessExtRevEntry() {
		super(ms_elemList);
	}
	public static final String CPM_PROC_EXT_MEMALLOCATEDREV_ALIAS = "cpmProcExtMemAllocatedRev";
	public static final String CPM_PROC_EXT_MEMFREEDREV_ALIAS = "cpmProcExtMemFreedRev";
	public static final String CPM_PROC_EXT_INVOKEDREV_ALIAS = "cpmProcExtInvokedRev";
	public static final String CPM_PROC_EXT_RUNTIMEREV_ALIAS = "cpmProcExtRuntimeRev";
	public static final String CPM_PROC_EXT_UTIL5SECREV_ALIAS = "cpmProcExtUtil5SecRev";
	public static final String CPM_PROC_EXT_UTIL1MINREV_ALIAS = "cpmProcExtUtil1MinRev";
	public static final String CPM_PROC_EXT_UTIL5MINREV_ALIAS = "cpmProcExtUtil5MinRev";
	public static final String CPM_PROC_EXT_PRIORITYREV_ALIAS = "cpmProcExtPriorityRev";

	private static final String CPM_PROC_EXT_MEMALLOCATEDREV = ".1.3.6.1.4.1.9.9.109.1.2.3.1.1";
	private static final String CPM_PROC_EXT_MEMFREEDREV = ".1.3.6.1.4.1.9.9.109.1.2.3.1.2";
	private static final String CPM_PROC_EXT_INVOKEDREV = ".1.3.6.1.4.1.9.9.109.1.2.3.1.3";
	private static final String CPM_PROC_EXT_RUNTIMEREV = ".1.3.6.1.4.1.9.9.109.1.2.3.1.4";
	private static final String CPM_PROC_EXT_UTIL5SECREV = ".1.3.6.1.4.1.9.9.109.1.2.3.1.5";
	private static final String CPM_PROC_EXT_UTIL1MINREV = ".1.3.6.1.4.1.9.9.109.1.2.3.1.6";
	private static final String CPM_PROC_EXT_UTIL5MINREV = ".1.3.6.1.4.1.9.9.109.1.2.3.1.7";
	private static final String CPM_PROC_EXT_PRIORITYREV = ".1.3.6.1.4.1.9.9.109.1.2.3.1.8";
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		ms_elemList = new NamedSnmpVar[8];
		int ndx = 0;
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_MEMALLOCATEDREV_ALIAS , CPM_PROC_EXT_MEMALLOCATEDREV, 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_MEMFREEDREV_ALIAS , CPM_PROC_EXT_MEMFREEDREV , 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_INVOKEDREV_ALIAS , CPM_PROC_EXT_INVOKEDREV , 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_RUNTIMEREV_ALIAS , CPM_PROC_EXT_RUNTIMEREV , 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_UTIL5SECREV_ALIAS , CPM_PROC_EXT_UTIL5SECREV , 5);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_UTIL1MINREV_ALIAS , CPM_PROC_EXT_UTIL1MINREV , 6);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_UTIL5MINREV_ALIAS , CPM_PROC_EXT_UTIL5MINREV , 7);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROC_EXT_PRIORITYREV_ALIAS , CPM_PROC_EXT_PRIORITYREV , 8);

	}
	public static final String TABLE_OID = ".1.3.6.1.4.1.9.9.109.1.2.3.1"; // start
	
	public int getCpmProcExtMemAllocatedRev() {
		return getInt32(CPM_PROC_EXT_MEMALLOCATEDREV);
	}

	public int getCpmProcExtMemFreedRev() {
		return getInt32(CPM_PROC_EXT_MEMFREEDREV);
	}

	public int getCpmProcExtInvokedRev() {
		return getInt32(CPM_PROC_EXT_INVOKEDREV);
	}

	public int getCpmProcExtRuntimeRev() {
		return getInt32(CPM_PROC_EXT_RUNTIMEREV);
	}

	public int getCpmProcExtUtil5SecRev() {
		return getInt32(CPM_PROC_EXT_UTIL5SECREV);
	}

	public int getCpmProcExtUtil1MinRev() {
		return getInt32(CPM_PROC_EXT_UTIL1MINREV);
	}

	public int getCpmProcExtUtil5MinRev() {
		return getInt32(CPM_PROC_EXT_UTIL5MINREV);
	}

	public int getCpmProcExtPriorityRev() {
		return getInt32(CPM_PROC_EXT_PRIORITYREV);
	}

}

