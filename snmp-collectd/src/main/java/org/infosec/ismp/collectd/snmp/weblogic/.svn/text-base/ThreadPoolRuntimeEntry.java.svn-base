package org.infosec.ismp.collectd.snmp.weblogic;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpTableEntry;

/**
 * @author guoxianwei
 * @date 2010-10-27 下午02:51:07
 * 
 */
public class ThreadPoolRuntimeEntry extends SnmpTableEntry
{
	public ThreadPoolRuntimeEntry() {
		super(ms_elemList);
	}
	public static final String THREAD_POOL_RUNTIME_EXE_COUNT_ALIAS = "threadPoolRuntimeExecuteThreadTotalCount";
	public static final String THREAD_POOL_RUNTIME_EXE_IDEL_COUNT_ALIAS = "threadPoolRuntimeExecuteThreadIdleCount";
	public static final String THREAD_POOL_RUNTIME_SHARED_CAPACITY_ALIAS = "threadPoolRuntimeSharedCapacityForWorkManagers";
	public static final String THREAD_POOL_RUNTIME_QUEUE_LENGTH_ALIAS = "threadPoolRuntimeQueueLength";
	public static final String THREAD_POOL_RUNTIME_PENDING_REQUEST_COUNT_ALIAS = "threadPoolRuntimePendingUserRequestCount";
	public static final String THREAD_POOL_RUNTIME_COMPLETE_REQUEST_COUNT_ALIAS = "threadPoolRuntimeCompletedRequestCount";
	public static final String THREAD_POOL_RUNTIME_STANDBY_THREAD_COUNT_ALIAS = "threadPoolRuntimeStandbyThreadCount";

	private static final String THREAD_POOL_RUNTIME_EXE_COUNT = ".1.3.6.1.4.1.140.625.367.1.25";
	private static final String THREAD_POOL_RUNTIME_EXE_IDEL_COUNT = ".1.3.6.1.4.1.140.625.367.1.30";
	private static final String THREAD_POOL_RUNTIME_QUEUE_LENGTH = ".1.3.6.1.4.1.140.625.367.1.35";
	private static final String THREAD_POOL_RUNTIME_PENDING_REQUEST_COUNT = ".1.3.6.1.4.1.140.625.367.1.40";
	private static final String THREAD_POOL_RUNTIME_SHARED_CAPACITY = ".1.3.6.1.4.1.140.625.367.1.45";
	private static final String THREAD_POOL_RUNTIME_COMPLETE_REQUEST_COUNT = ".1.3.6.1.4.1.140.625.367.1.50";
	private static final String THREAD_POOL_RUNTIME_STANDBY_THREAD_COUNT = ".1.3.6.1.4.1.140.625.367.1.60";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		ms_elemList = new NamedSnmpVar[7];
		int ndx = 0;
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,THREAD_POOL_RUNTIME_EXE_COUNT_ALIAS , THREAD_POOL_RUNTIME_EXE_COUNT , 6);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,THREAD_POOL_RUNTIME_EXE_IDEL_COUNT_ALIAS , THREAD_POOL_RUNTIME_EXE_IDEL_COUNT , 7);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,THREAD_POOL_RUNTIME_QUEUE_LENGTH_ALIAS , THREAD_POOL_RUNTIME_QUEUE_LENGTH , 8);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,THREAD_POOL_RUNTIME_PENDING_REQUEST_COUNT_ALIAS , THREAD_POOL_RUNTIME_PENDING_REQUEST_COUNT , 9);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,THREAD_POOL_RUNTIME_SHARED_CAPACITY_ALIAS , THREAD_POOL_RUNTIME_SHARED_CAPACITY , 10);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,THREAD_POOL_RUNTIME_COMPLETE_REQUEST_COUNT_ALIAS , THREAD_POOL_RUNTIME_COMPLETE_REQUEST_COUNT , 11);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,THREAD_POOL_RUNTIME_STANDBY_THREAD_COUNT_ALIAS , THREAD_POOL_RUNTIME_STANDBY_THREAD_COUNT , 13);
	}
	
	public int getThreadPoolRuntimeExecuteThreadTotalCount() {
		return getInt32(THREAD_POOL_RUNTIME_EXE_COUNT);
	}

	public int getThreadPoolRuntimeExecuteThreadIdleCount() {
		return getInt32(THREAD_POOL_RUNTIME_EXE_IDEL_COUNT);
	}

	public int getThreadPoolRuntimeSharedCapacityForWorkManagers() {
		return getInt32(THREAD_POOL_RUNTIME_SHARED_CAPACITY);
	}

	public int getThreadPoolRuntimeQueueLength() {
		return getInt32(THREAD_POOL_RUNTIME_QUEUE_LENGTH);
	}

	public int getThreadPoolRuntimePendingUserRequestCount() {
		return getInt32(THREAD_POOL_RUNTIME_PENDING_REQUEST_COUNT);
	}

	public int getThreadPoolRuntimeCompletedRequestCount() {
		return getInt32(THREAD_POOL_RUNTIME_COMPLETE_REQUEST_COUNT);
	}

	public int getThreadPoolRuntimeStandbyThreadCount() {
		return getInt32(THREAD_POOL_RUNTIME_STANDBY_THREAD_COUNT);
	}


}

