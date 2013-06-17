package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-12 下午02:41:42
 * 
 */
public class IpRouteTable extends SnmpTable<IpRouteEntry> {


	
	public IpRouteTable(InetAddress address) {
		super(address, "ipRouteTable", IpRouteEntry.ms_elemList);
		}

	@Override
	protected IpRouteEntry createTableEntry(SnmpObjId base, SnmpInstId inst,
			Object val) {
		return new IpRouteEntry();
	}
	public IpRouteEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (IpRouteEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}
}

