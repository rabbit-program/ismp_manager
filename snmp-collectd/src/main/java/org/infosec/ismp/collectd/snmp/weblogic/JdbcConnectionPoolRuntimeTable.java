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
 * @date 2010-10-27 下午04:25:29
 * 
 */
public class JdbcConnectionPoolRuntimeTable  extends SnmpTable<JdbcConnectionPoolRuntimeEntry>{
	
	public JdbcConnectionPoolRuntimeTable(InetAddress address) {
		super(address, "JdbcConnectionPoolRuntimeTable", JdbcConnectionPoolRuntimeEntry.ms_elemList);
		}

	@Override
	protected JdbcConnectionPoolRuntimeEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		// TODO Auto-generated method stub
		return new JdbcConnectionPoolRuntimeEntry();
	}


	public JdbcConnectionPoolRuntimeEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (JdbcConnectionPoolRuntimeEntry entry : getEntries()) {
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

		JdbcConnectionPoolRuntimeTable table = new JdbcConnectionPoolRuntimeTable(agentConfig.getAddress());

		SnmpWalker walker = SnmpUtils.createWalker(agentConfig,
				"SnmpCollectors for test", new CollectionTracker[] { 
						table});
		walker.start();
		walker.waitFor(60 * 1000 * 5);


		System.out.println(table.failed());
		for (JdbcConnectionPoolRuntimeEntry entrx : table.getEntries()) {
			System.out.println("-----------------------------");
			System.out.println(entrx.getJdbcConnectionPoolRuntimeActiveConnectionsCurrentCount());
			System.out.println(entrx.getJdbcConnectionPoolRuntimeConnectionDelayTime());
			System.out.println(entrx.getJdbcConnectionPoolRuntimeLeakedConnectionCount());
			System.out.println(entrx.getJdbcConnectionPoolRuntimeMaxCapacity());
			System.out.println(entrx.getJdbcConnectionPoolRuntimeNumAvailable());
			System.out.println(entrx.getJdbcConnectionPoolRuntimeWaitingForConnectionCurrentCount());

			System.out.println("-----------------------------");
		}

	}

}

