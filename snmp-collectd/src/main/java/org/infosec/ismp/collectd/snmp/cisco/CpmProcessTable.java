package org.infosec.ismp.collectd.snmp.cisco;

import java.net.InetAddress;

import org.infosec.ismp.collectd.snmp.SnmpTable;
import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-20 上午11:11:27
 * 
 */
public class CpmProcessTable extends SnmpTable<CpmProcessEntry>{
	
	public CpmProcessTable(InetAddress address) {
		super(address, "cpmProcessTable", CpmProcessEntry.ms_elemList);
		}

	@Override
	protected CpmProcessEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		// TODO Auto-generated method stub
		return new CpmProcessEntry();
	}


	public CpmProcessEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (CpmProcessEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}
}

