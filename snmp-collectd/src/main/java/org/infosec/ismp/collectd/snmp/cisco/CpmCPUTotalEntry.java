package org.infosec.ismp.collectd.snmp.cisco;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpTableEntry;

/**
 * @author guoxianwei
 * @date 2010-10-20 上午09:48:55
 * 
 */
public class CpmCPUTotalEntry extends SnmpTableEntry{
	

	public CpmCPUTotalEntry() {
		super(ms_elemList);
	}
	
	public static final String CPM_CPU_TOTAL_PHYSICALINDEX_ALIAS ="cpmCPUTotalPhysicalIndex";
	public static final String CPM_CPU_TOTAL_5SEC_ALIAS ="cpmCPUTotal5sec";
	public static final String CPM_CPU_TOTAL_1MIN_ALIAS ="cpmCPUTotal1min";
	public static final String CPM_CPU_TOTAL_5MIN_ALIAS ="cpmCPUTotal5min";
	public static final String CPM_CPU_TOTAL_5SECREV_ALIAS ="cpmCPUTotal5secRev";
	public static final String CPM_CPU_TOTAL_1MINREV_ALIAS ="cpmCPUTotal1minRev";
	public static final String CPM_CPU_TOTAL_5MINREV_ALIAS ="cpmCPUTotal5minRev";
	public static final String CPM_CPU_MON_INTERVAL_ALIAS ="cpmCPUMonInterval";
	public static final String CPM_CPU_TOTAL_MON_INTERVALVALUE_ALIAS ="cpmCPUTotalMonIntervalValue";
	public static final String CPM_CPU_INTERRUPT_MON_INTERVALVALUE_ALIAS ="cpmCPUInterruptMonIntervalValue";

	private static final String CPM_CPU_TOTAL_PHYSICALINDEX =".1.3.6.1.4.1.9.9.109.1.1.1.1.2"; 
	private static final String CPM_CPU_TOTAL_5SEC =".1.3.6.1.4.1.9.9.109.1.1.1.1.3"; 
	private static final String CPM_CPU_TOTAL_1MIN =".1.3.6.1.4.1.9.9.109.1.1.1.1.4"; 
	private static final String CPM_CPU_TOTAL_5MIN =".1.3.6.1.4.1.9.9.109.1.1.1.1.5"; 
	private static final String CPM_CPU_TOTAL_5SECREV =".1.3.6.1.4.1.9.9.109.1.1.1.1.6"; 
	private static final String CPM_CPU_TOTAL_1MINREV =".1.3.6.1.4.1.9.9.109.1.1.1.1.7"; 
	private static final String CPM_CPU_TOTAL_5MINREV =".1.3.6.1.4.1.9.9.109.1.1.1.1.8"; 
	private static final String CPM_CPU_MON_INTERVAL =".1.3.6.1.4.1.9.9.109.1.1.1.1.9"; 
	private static final String CPM_CPU_TOTAL_MON_INTERVALVALUE =".1.3.6.1.4.1.9.9.109.1.1.1.1.10";
	private static final String CPM_CPU_INTERRUPT_MON_INTERVALVALUE =".1.3.6.1.4.1.9.9.109.1.1.1.1.11";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		ms_elemList = new NamedSnmpVar[10];
		int ndx = 0;

		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_TOTAL_PHYSICALINDEX_ALIAS , CPM_CPU_TOTAL_PHYSICALINDEX , 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_TOTAL_5SEC_ALIAS , CPM_CPU_TOTAL_5SEC , 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_TOTAL_1MIN_ALIAS , CPM_CPU_TOTAL_1MIN , 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_TOTAL_5MIN_ALIAS , CPM_CPU_TOTAL_5MIN , 5);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_TOTAL_5SECREV_ALIAS , CPM_CPU_TOTAL_5SECREV , 6);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_TOTAL_1MINREV_ALIAS , CPM_CPU_TOTAL_1MINREV , 7);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_TOTAL_5MINREV_ALIAS , CPM_CPU_TOTAL_5MINREV , 8);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_MON_INTERVAL_ALIAS , CPM_CPU_MON_INTERVAL , 9);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_TOTAL_MON_INTERVALVALUE_ALIAS , CPM_CPU_TOTAL_MON_INTERVALVALUE , 10);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_CPU_INTERRUPT_MON_INTERVALVALUE_ALIAS, CPM_CPU_INTERRUPT_MON_INTERVALVALUE, 11);
	}
	public static final String TABLE_OID = ".1.3.6.1.4.1.9.9.109.1.1.1"; // start
	
	public int getCpmCPUTotalPhysicalIndex() {
		return getInt32(CPM_CPU_TOTAL_PHYSICALINDEX);
	}

	public int getCpmCPUTotal5sec() {
		return getInt32(CPM_CPU_TOTAL_5SEC);
	}

	public int getCpmCPUTotal1min() {
		return getInt32(CPM_CPU_TOTAL_1MIN);
	}

	public int getCpmCPUTotal5min() {
		return getInt32(CPM_CPU_TOTAL_5MIN);
	}

	public int getCpmCPUTotal5secRev() {
		return getInt32(CPM_CPU_TOTAL_5SECREV);
	}

	public int getCpmCPUTotal1minRev() {
		return getInt32(CPM_CPU_TOTAL_1MINREV);
	}

	public int getCpmCPUTotal5minRev() {
		return getInt32(CPM_CPU_TOTAL_5MINREV);
	}

	public int getCpmCPUMonInterval() {
		return getInt32(CPM_CPU_MON_INTERVAL);
	}

	public int getCpmCPUTotalMonIntervalValue() {
		return getInt32(CPM_CPU_TOTAL_MON_INTERVALVALUE);
	}

	public int getCpmCPUInterruptMonIntervalValue() {
		return getInt32(CPM_CPU_INTERRUPT_MON_INTERVALVALUE);
	}
}

