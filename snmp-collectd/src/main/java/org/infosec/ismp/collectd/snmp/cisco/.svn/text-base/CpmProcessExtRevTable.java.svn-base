package org.infosec.ismp.collectd.snmp.cisco;

import java.net.InetAddress;

import org.infosec.ismp.collectd.snmp.SnmpTable;
import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-20 下午04:23:21
 * 
 */
public class CpmProcessExtRevTable extends SnmpTable<CpmProcessExtRevEntry> {
	
	public CpmProcessExtRevTable(InetAddress address) {
		super(address, "cpmProcessExtRevTable", CpmProcessExtRevEntry.ms_elemList);
		}

	@Override
	protected CpmProcessExtRevEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		// TODO Auto-generated method stub
		return new CpmProcessExtRevEntry();
	}


	public CpmProcessExtRevEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (CpmProcessExtRevEntry entry : getEntries()) {
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

		CpmProcessExtRevTable table = new CpmProcessExtRevTable(agentConfig.getAddress());

		SnmpWalker walker = SnmpUtils.createWalker(agentConfig,
				"SnmpCollectors for test", new CollectionTracker[] { 
						table});
		walker.start();
		walker.waitFor(60 * 1000 * 5);


		System.out.println(table.failed());
		for (CpmProcessExtRevEntry entrx : table.getEntries()) {
			System.out.println("-----------------------------");
			System.out.println(entrx.getCpmProcExtInvokedRev());
			System.out.println(entrx.getCpmProcExtMemAllocatedRev());
			System.out.println(entrx.getCpmProcExtMemFreedRev());
			System.out.println(entrx.getCpmProcExtPriorityRev());
			System.out.println(entrx.getCpmProcExtRuntimeRev());
			System.out.println(entrx.getCpmProcExtUtil1MinRev());
			System.out.println(entrx.getCpmProcExtUtil5MinRev());
			System.out.println(entrx.getCpmProcExtUtil5SecRev());
			System.out.println("-----------------------------");
		}

	}*/

}

