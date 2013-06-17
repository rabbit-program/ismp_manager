package org.infosec.ismp.collectd.snmp.weblogic;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpTableEntry;

/**
 * @author guoxianwei
 * @date 2010-10-27 下午03:59:18
 * 
 */
public class JdbcConnectionPoolRuntimeEntry extends SnmpTableEntry{
	
	public JdbcConnectionPoolRuntimeEntry() {
		super(ms_elemList);
	}
	public static final String ACTIVE_CONNECTIONS_CURRENT_COUNT_ALIAS = "jdbcConnectionPoolRuntimeActiveConnectionsCurrentCount";
	public static final String WAITING_FOR_CONNECTION_CURRENT_COUNT_ALIAS = "jdbcConnectionPoolRuntimeWaitingForConnectionCurrentCount";
	public static final String RUNTIME_MAX_CAPATITY_ALIAS = "jdbcConnectionPoolRuntimeMaxCapacity";
	public static final String RUNTIME_CONNECTION_DELAY_TIME_ALIAS = "jdbcConnectionPoolRuntimeConnectionDelayTime";
	public static final String RUNTIME_LEAKED_CONNECTION_COUNT_ALIAS = "jdbcConnectionPoolRuntimeLeakedConnectionCount";
	public static final String RUNTIME_NUM_AVAILABLE_ALIAS = "jdbcConnectionPoolRuntimeNumAvailable";

	private static final String ACTIVE_CONNECTIONS_CURRENT_COUNT = ".1.3.6.1.4.1.140.625.190.1.25";
	private static final String WAITING_FOR_CONNECTION_CURRENT_COUNT = ".1.3.6.1.4.1.140.625.190.1.30";
	private static final String RUNTIME_MAX_CAPATITY = ".1.3.6.1.4.1.140.625.190.1.60";
	private static final String RUNTIME_CONNECTION_DELAY_TIME = ".1.3.6.1.4.1.140.625.190.1.62";
	private static final String RUNTIME_LEAKED_CONNECTION_COUNT = ".1.3.6.1.4.1.140.625.190.1.68";
	private static final String RUNTIME_NUM_AVAILABLE = ".1.3.6.1.4.1.140.625.190.1.69";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		ms_elemList = new NamedSnmpVar[6];
		int ndx = 0;
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,ACTIVE_CONNECTIONS_CURRENT_COUNT_ALIAS , ACTIVE_CONNECTIONS_CURRENT_COUNT , 6);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,WAITING_FOR_CONNECTION_CURRENT_COUNT_ALIAS , WAITING_FOR_CONNECTION_CURRENT_COUNT , 7);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,RUNTIME_MAX_CAPATITY_ALIAS , RUNTIME_MAX_CAPATITY , 13);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,RUNTIME_CONNECTION_DELAY_TIME_ALIAS , RUNTIME_CONNECTION_DELAY_TIME , 15);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,RUNTIME_LEAKED_CONNECTION_COUNT_ALIAS , RUNTIME_LEAKED_CONNECTION_COUNT , 16);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,RUNTIME_NUM_AVAILABLE_ALIAS , RUNTIME_NUM_AVAILABLE , 20);
	}
	public int getJdbcConnectionPoolRuntimeActiveConnectionsCurrentCount() {
		return getInt32(ACTIVE_CONNECTIONS_CURRENT_COUNT);
	}

	public int getJdbcConnectionPoolRuntimeWaitingForConnectionCurrentCount() {
		return getInt32(WAITING_FOR_CONNECTION_CURRENT_COUNT);
	}

	public int getJdbcConnectionPoolRuntimeMaxCapacity() {
		return getInt32(RUNTIME_MAX_CAPATITY);
	}

	public int getJdbcConnectionPoolRuntimeConnectionDelayTime() {
		return getInt32(RUNTIME_CONNECTION_DELAY_TIME);
	}

	public int getJdbcConnectionPoolRuntimeLeakedConnectionCount() {
		return getInt32(RUNTIME_LEAKED_CONNECTION_COUNT);
	}

	public int getJdbcConnectionPoolRuntimeNumAvailable() {
		return getInt32(RUNTIME_NUM_AVAILABLE);
	}




}

