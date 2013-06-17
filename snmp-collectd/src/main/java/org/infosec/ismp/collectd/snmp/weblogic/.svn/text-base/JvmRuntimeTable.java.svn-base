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
 * @date 2010-10-27 下午04:51:14
 * 
 */
public class JvmRuntimeTable extends SnmpTable<JvmRuntimeEntry> {
	
	public JvmRuntimeTable(InetAddress address) {
		super(address, "JvmRuntimeTable", JvmRuntimeEntry.ms_elemList);
		}

	@Override
	protected JvmRuntimeEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		// TODO Auto-generated method stub
		return new JvmRuntimeEntry();
	}


	public JvmRuntimeEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (JvmRuntimeEntry entry : getEntries()) {
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
		agentConfig.setVersion(2);
		JvmRuntimeTable table = new JvmRuntimeTable(agentConfig.getAddress());

		SnmpWalker walker = SnmpUtils.createWalker(agentConfig,
				"SnmpCollectors for test", new CollectionTracker[] { 
						table});
		walker.start();
		walker.waitFor(60 * 1000 * 5);


		System.out.println(table.failed());
		for (JvmRuntimeEntry entrx : table.getEntries()) {
			System.out.println("-----------------------------");
			System.out.println(entrx.getJvmRuntimeHeapFreeCurrent());
			System.out.println(entrx.getJvmRuntimeHeapSizeCurrent());
			System.out.println(entrx.getJvmRuntimeJavaVersion());
		

			System.out.println("-----------------------------");
		}

	}

}

