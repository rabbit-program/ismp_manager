package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-11 下午01:44:28
 * 
 */
public class HrSWRunTable extends SnmpTable<HrSWRunTableEntry> {

	
	public HrSWRunTable(InetAddress address) {
		super(address, "hrSWRunTable", HrSWRunTableEntry.ms_elemList);
	}

	@Override
	protected HrSWRunTableEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		return new HrSWRunTableEntry();
	}
	public HrSWRunTableEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (HrSWRunTableEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}

	public String getHrSWRunId(int hrSWRunIndex) {
		String hrSWRunID = null;
		if (getEntries() != null) {
			for (HrSWRunTableEntry entry : getEntries()) {
				Integer ndx = entry.getIfIndex();
				if (ndx != null && ndx.intValue() == hrSWRunIndex) {
					hrSWRunID = entry.getHrSWRunId();
					break;
				}
			}
		}
		return hrSWRunID;
	}
}

