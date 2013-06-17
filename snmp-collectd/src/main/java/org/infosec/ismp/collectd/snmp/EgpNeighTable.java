package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-14 下午02:37:12
 * 
 */
public class EgpNeighTable extends SnmpTable<EgpNeighEntry> {
	public EgpNeighTable(InetAddress address) {
		super(address, "egpNeighTable", EgpNeighEntry.ms_elemList);
	}

	@Override
	protected EgpNeighEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		return new EgpNeighEntry();
	}
	public EgpNeighEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (EgpNeighEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}
}

