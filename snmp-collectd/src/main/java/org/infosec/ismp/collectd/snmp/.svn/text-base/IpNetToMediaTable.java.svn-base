package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-12 下午03:56:18
 * 
 */
public class IpNetToMediaTable  extends SnmpTable<IpNetToMediaEntry>{

	
	protected IpNetToMediaTable(InetAddress address) {
		super(address, "ipNetToMediaTable", IpNetToMediaEntry.ms_elemList);
		}

	@Override
	protected IpNetToMediaEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		// TODO Auto-generated method stub
		return new IpNetToMediaEntry();
	}


	public IpNetToMediaEntry getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (IpNetToMediaEntry entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}
}

