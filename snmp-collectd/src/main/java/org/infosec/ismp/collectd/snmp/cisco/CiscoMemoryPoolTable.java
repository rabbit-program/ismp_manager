package org.infosec.ismp.collectd.snmp.cisco;

import java.net.InetAddress;

import org.infosec.ismp.collectd.snmp.SnmpTable;
import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-20 下午04:39:42
 * 
 */
public class CiscoMemoryPoolTable  extends SnmpTable<CiscoMemoryPoolEntry> {
	
	public CiscoMemoryPoolTable(InetAddress address) {
		super(address, "CiscoMemoryPoolTable", CiscoMemoryPoolEntry.ms_elemList);
		}

	@Override
	protected CiscoMemoryPoolEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		// TODO Auto-generated method stub
		return new CiscoMemoryPoolEntry();
	}


	public CiscoMemoryPoolEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (CiscoMemoryPoolEntry entry : getEntries()) {
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

		CiscoMemoryPoolTable table = new CiscoMemoryPoolTable(agentConfig.getAddress());

		SnmpWalker walker = SnmpUtils.createWalker(agentConfig,
				"SnmpCollectors for test", new CollectionTracker[] { 
						table});
		walker.start();
		walker.waitFor(60 * 1000 * 5);


		System.out.println(table.failed());
		for (CiscoMemoryPoolEntry entrx : table.getEntries()) {
			System.out.println("-----------------------------");
			System.out.println(entrx.getCiscoMemoryPoolAlternate());
			System.out.println(entrx.getCiscoMemoryPoolFree());
			System.out.println(entrx.getCiscoMemoryPoolLargestFree());
			System.out.println(entrx.getCiscoMemoryPoolName());
			System.out.println(entrx.getCiscoMemoryPoolUsed());
			System.out.println(entrx.getCiscoMemoryPoolValid());
			System.out.println("-----------------------------");
		}

	}*/

}

