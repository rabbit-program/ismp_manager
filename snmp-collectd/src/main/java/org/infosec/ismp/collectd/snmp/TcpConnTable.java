package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-13 下午03:51:49
 * 
 */
public class TcpConnTable extends SnmpTable<TcpConnEntry> {
	public TcpConnTable(InetAddress address) {
		super(address, "tcpConnTable", TcpConnEntry.ms_elemList);
	}

	@Override
	protected TcpConnEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		return new TcpConnEntry();
	}
	public TcpConnEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (TcpConnEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}
}

