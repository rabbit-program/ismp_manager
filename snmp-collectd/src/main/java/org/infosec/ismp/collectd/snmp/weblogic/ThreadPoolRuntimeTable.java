package org.infosec.ismp.collectd.snmp.weblogic;

import java.net.InetAddress;

import org.infosec.ismp.collectd.snmp.SnmpTable;
import org.infosec.ismp.snmp.CollectionTracker;
import org.infosec.ismp.snmp.SnmpAgentConfig;
import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;
import org.infosec.ismp.snmp.SnmpUtils;
import org.infosec.ismp.snmp.SnmpWalker;

/**
 * @author guoxianwei
 * @date 2010-10-27 下午03:25:01
 * 
 */
public class ThreadPoolRuntimeTable extends SnmpTable<ThreadPoolRuntimeEntry>{
	
	public ThreadPoolRuntimeTable(InetAddress address) {
		super(address, "threadPoolRuntimeTable", ThreadPoolRuntimeEntry.ms_elemList);
		}

	@Override
	protected ThreadPoolRuntimeEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		// TODO Auto-generated method stub
		return new ThreadPoolRuntimeEntry();
	}


	public ThreadPoolRuntimeEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (ThreadPoolRuntimeEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}

	public static void main(String[] args) throws Exception {
		SnmpAgentConfig agentConfig = new SnmpAgentConfig(
				InetAddress.getByName("192.168.9.85"));

		ThreadPoolRuntimeTable table = new ThreadPoolRuntimeTable(agentConfig.getAddress());

		SnmpWalker walker = SnmpUtils.createWalker(agentConfig,
				"SnmpCollectors for test", new CollectionTracker[] { 
						table});
		walker.start();
		walker.waitFor(60 * 1000 * 5);


		System.out.println(table.failed());
		for (ThreadPoolRuntimeEntry entrx : table.getEntries()) {
			System.out.println("-----------------------------");
			System.out.println(entrx.getThreadPoolRuntimeCompletedRequestCount());
			System.out.println(entrx.getThreadPoolRuntimeExecuteThreadIdleCount());
			System.out.println(entrx.getThreadPoolRuntimeExecuteThreadTotalCount());
			System.out.println(entrx.getThreadPoolRuntimeQueueLength());
			System.out.println(entrx.getThreadPoolRuntimePendingUserRequestCount());
			System.out.println(entrx.getThreadPoolRuntimeSharedCapacityForWorkManagers());
			System.out.println(entrx.getThreadPoolRuntimeStandbyThreadCount());

			System.out.println("-----------------------------");
		}

	}

}

