package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-10-12 上午10:07:04
 * 
 */
public class AtTable extends SnmpTable<AtTableEntity> {


	
	public AtTable(InetAddress address) {
		super(address, "atTable", AtTableEntity.ms_elemList);
	}

	@Override
	protected AtTableEntity createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		return new AtTableEntity();
	}
	public AtTableEntity getEntry(int ifIndex) {
		if (getEntries() == null) {
			return null;
		}

		for (AtTableEntity entry : getEntries()) {
			Integer ndx = entry.getIfIndex();
			if (ndx != null && ndx.intValue() == ifIndex) {
				return entry;
			}
		}

		return null;
	}


}

