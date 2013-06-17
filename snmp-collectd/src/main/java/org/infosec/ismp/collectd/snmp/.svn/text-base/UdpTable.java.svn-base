package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-13 下午07:03:28
 * 
 */
public class UdpTable extends SnmpTable<UdpEntry>{
	public UdpTable(InetAddress address) {
		super(address, "udpTable", AtTableEntity.ms_elemList);
	}

	@Override
	protected UdpEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		return new UdpEntry();
	}
	public UdpEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (UdpEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}
}

