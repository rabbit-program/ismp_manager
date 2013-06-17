package org.infosec.ismp.collectd.snmp.cisco;

import java.net.InetAddress;

import org.infosec.ismp.collectd.snmp.SnmpTable;
import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-20 上午10:36:36
 * 
 */
public final class CpmCPUTotalTable extends SnmpTable<CpmCPUTotalEntry>{
	
	public CpmCPUTotalTable(InetAddress address) {
		super(address, "cpmCPUTotalTable", CpmCPUTotalEntry.ms_elemList);
		}

	@Override
	protected CpmCPUTotalEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		// TODO Auto-generated method stub
		return new CpmCPUTotalEntry();
	}


	public CpmCPUTotalEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (CpmCPUTotalEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}

/*	public static void main(String[] args) throws Exception {
		SnmpAgentConfig agentConfig = new SnmpAgentConfig(
				InetAddress.getByName("202.120.36.151"));

		CpmCPUTotalTable table = new CpmCPUTotalTable(agentConfig.getAddress());

		SnmpWalker walker = SnmpUtils.createWalker(agentConfig,
				"SnmpCollectors for test", new CollectionTracker[] { 
						table});
		walker.start();
		walker.waitFor(60 * 1000 * 5);


		System.out.println(table.failed());
		for (CpmCPUTotalEntry entrx : table.getEntries()) {
			System.out.println("-----------------------------");
			System.out.println(entrx.getCpmCPUTotalPhysicalIndex());
			System.out.println("is fixed disk : " + entrx.getCpmCPUInterruptMonIntervalValue());
			System.out.println(entrx.getCpmCPUMonInterval());
			System.out.println(entrx.getCpmCPUTotal1min());
			System.out.println(entrx.getCpmCPUTotal1minRev());
			System.out.println(entrx.getCpmCPUTotal5min());
			System.out.println("-----------------------------");
		}

	}*/

}

