package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

public class HrStorageTable extends SnmpTable<HrStorageTableEntry> {

    public final static String HR_STORAGE_FIXEDDISK=".1.3.6.1.2.1.25.2.1.4";//硬盘分区
    public final static String HR_STORAGE_COMPACT_DISC=".1.3.6.1.2.1.25.2.1.7";//COMPACT DISC
    public final static String HR_STORAGE_RAM=".1.3.6.1.2.1.25.2.1.2";//Physical memory
    public final static String HR_STORAGE_VIRTUAL_MEMORY=".1.3.6.1.2.1.25.2.1.3";//virtual memory

	public HrStorageTable(InetAddress address) {
		super(address, "hrStorageTable", HrStorageTableEntry.ms_elemList);
	}

	@Override
	protected HrStorageTableEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		return new HrStorageTableEntry();
	}

	public HrStorageTableEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (HrStorageTableEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}

	public String getHrStorageType(int hrStorageIndex) {
		String hrStorageType = null;
		if (getEntries() != null) {
			for (HrStorageTableEntry entry : getEntries()) {
				Integer ndx = entry.getIfIndex();
				if (ndx != null && ndx.intValue() == hrStorageIndex) {
					hrStorageType = entry.getHrStorageType();
					break;
				}
			}
		}
		return hrStorageType;
	}

	public boolean isFixedDisk(int hrStorageIndex){
		String hrStorageType = null;
		if (getEntries() != null) {
			for (HrStorageTableEntry entry : getEntries()) {
				Integer ndx = entry.getIfIndex();
				if (ndx != null && ndx.intValue() == hrStorageIndex) {
					hrStorageType = entry.getHrStorageType();
					break;
				}
			}
		}
		return HR_STORAGE_FIXEDDISK.equals(hrStorageType);
	}

}
