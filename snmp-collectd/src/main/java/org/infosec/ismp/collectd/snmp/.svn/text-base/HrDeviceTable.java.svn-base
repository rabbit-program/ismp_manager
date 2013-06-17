package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-18 下午02:40:46
 * 
 */
public class HrDeviceTable extends SnmpTable<HrDeviceEntry> {
	
	public HrDeviceTable(InetAddress address) {
		super(address, "hrDeviceTable", HrDeviceEntry.ms_elemList);
	}

	@Override
	protected HrDeviceEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		return new HrDeviceEntry();
	}
	public HrDeviceEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (HrDeviceEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}

}

