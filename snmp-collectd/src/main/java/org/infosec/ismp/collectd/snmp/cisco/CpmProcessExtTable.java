package org.infosec.ismp.collectd.snmp.cisco;

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
 * @date 2010-10-20 下午03:31:23
 * 
 */
public class CpmProcessExtTable  extends SnmpTable<CpmProcessExtEntry>{
	
	public CpmProcessExtTable(InetAddress address) {
		super(address, "cpmProcessExtTable", CpmProcessExtEntry.ms_elemList);
		}

	@Override
	protected CpmProcessExtEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		// TODO Auto-generated method stub
		return new CpmProcessExtEntry();
	}


	public CpmProcessExtEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (CpmProcessExtEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}

	public static void main(String[] args) throws Exception {
		SnmpAgentConfig agentConfig = new SnmpAgentConfig(
				InetAddress.getByName("202.120.36.151"));

		CpmProcessExtTable table = new CpmProcessExtTable(agentConfig.getAddress());

		SnmpWalker walker = SnmpUtils.createWalker(agentConfig,
				"SnmpCollectors for test", new CollectionTracker[] { 
						table});
		walker.start();
		walker.waitFor(60 * 1000 * 5);


		System.out.println(table.failed());
		for (CpmProcessExtEntry entrx : table.getEntries()) {
			System.out.println("-----------------------------");
			System.out.println(entrx.getCpmProcExtInvoked());
			System.out.println(entrx.getCpmProcExtMemAllocated());
			System.out.println(entrx.getCpmProcExtPriority());
			System.out.println(entrx.getCpmProcExtRuntime());
			System.out.println(entrx.getCpmProcExtUtil1Min());
			System.out.println(entrx.getCpmProcExtUtil5Min());
			System.out.println(entrx.getCpmProcExtUtil5Sec());
			System.out.println("test       "+entrx.getTest());


			System.out.println("-----------------------------");
		}

	}

}

