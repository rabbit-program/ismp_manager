package org.infosec.ismp.collectd.snmp.cisco;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpTableEntry;

/**
 * @author guoxianwei
 * @date 2010-10-20 上午10:52:01
 * 
 */
public class CpmProcessEntry  extends SnmpTableEntry{
	

	public CpmProcessEntry() {
		super(ms_elemList);
	}

	public static final String CPM_PROCESS_PID_ALIAS = "cpmProcessPID";
	public static final String CPM_PROCESS_NAME_ALIAS = "cpmProcessName";
	public static final String CPM_PROCESS_USECS_ALIAS = "cpmProcessuSecs";
	public static final String CPM_PROCESS_TIMECREATED_ALIAS = "cpmProcessTimeCreated";
	public static final String CPM_PROCESS_AVERAGEUSECS_ALIAS = "cpmProcessAverageUSecs"; 

	private static final String CPM_PROCESS_PID = ".1.3.6.1.4.1.9.9.109.1.2.1.1.1";
	private static final String CPM_PROCESS_NAME = ".1.3.6.1.4.1.9.9.109.1.2.1.1.2";
	private static final String CPM_PROCESS_USECS = ".1.3.6.1.4.1.9.9.109.1.2.1.1.4";
	private static final String CPM_PROCESS_TIMECREATED = ".1.3.6.1.4.1.9.9.109.1.2.1.1.5";
	private static final String CPM_PROCESS_AVERAGEUSECS = ".1.3.6.1.4.1.9.9.109.1.2.1.1.6";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		ms_elemList = new NamedSnmpVar[5];
		int ndx = 0;

		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROCESS_PID_ALIAS , CPM_PROCESS_PID , 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,CPM_PROCESS_NAME_ALIAS , CPM_PROCESS_NAME , 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROCESS_USECS_ALIAS , CPM_PROCESS_USECS , 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPTIMETICKS,CPM_PROCESS_TIMECREATED_ALIAS , CPM_PROCESS_TIMECREATED , 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,CPM_PROCESS_AVERAGEUSECS_ALIAS , CPM_PROCESS_AVERAGEUSECS , 5);

	}
	public static final String TABLE_OID = ".1.3.6.1.4.1.9.9.109.1.2.1.1"; // start
	
    
	public int getCpmProcessPID() {
		return getInt32(CPM_PROCESS_PID);
	}

	public String getCpmProcessName() {
		return getDisplayString(CPM_PROCESS_NAME);
	}

	public int getCpmProcessuSecs() {
		return getInt32(CPM_PROCESS_USECS);
	}

	public String getCpmProcessTimeCreated() {
		return this.getDisplayString(CPM_PROCESS_TIMECREATED);
	}

	public int getCpmProcessAverageUSecs() {
		return getInt32(CPM_PROCESS_AVERAGEUSECS);
	}     
}

