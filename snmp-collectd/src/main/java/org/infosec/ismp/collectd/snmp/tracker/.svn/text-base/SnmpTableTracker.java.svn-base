package org.infosec.ismp.collectd.snmp.tracker;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.configuration.Column;
import org.infosec.ismp.collectd.snmp.configuration.Table;
import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

/**
 * @author guoxianwei
 * @date 2010-11-2 下午08:17:10
 * 表结构MIB库信息获取类
 */
public class SnmpTableTracker extends SnmpTable<GenericSnmpTableEntry> {

	private Table m_table = null;

	protected SnmpTableTracker(InetAddress address, Table table) {
		super(address, table.getName(), GenericSnmpTableEntry
				.getNamedSnmpVars(table.getColumns()));
		m_table = table;
	}

	@Override
	protected GenericSnmpTableEntry createTableEntry(SnmpObjId base,
			SnmpInstId inst, Object val) {
		return new GenericSnmpTableEntry();
	}

	public String getTrackerName() {
		return m_table.getName();
	}

	public List<Map<String, Object>> getStoreResult() {
		Set<Entry<SnmpInstId, GenericSnmpTableEntry>> set = this.getEntrySet();
		List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
		if(set!=null){
			for (Entry<SnmpInstId, GenericSnmpTableEntry> entry : set) {
				TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
				GenericSnmpTableEntry tableEntry = entry.getValue();
				if(m_table!=null && m_table.getColumnCollection()!=null){
					for (Column col : m_table.getColumnCollection()) {
						treeMap.put(col.getName(), ParseObject(tableEntry, col));
					}
				}
				list.add(treeMap);
			}
		}

		return list;
	}

	private Serializable ParseObject(GenericSnmpTableEntry tableEntry,
			Column column) {
		if (NamedSnmpVar.SNMPIPADDRESS.equals(Column.valueOf(column.getType()))) {
			return tableEntry.getIPAddress(column.getValue());
		} else if (NamedSnmpVar.SNMPUINT32.equals(Column.valueOf(column
				.getType()))) {
			return tableEntry.getUInt32(column.getValue());
		} else if (NamedSnmpVar.SNMPCOUNTER32.equals(Column.valueOf(column
				.getType()))) {
			return tableEntry.getUInt32(column.getValue());
		} else if (NamedSnmpVar.SNMPCOUNTER64.equals(Column.valueOf(column
				.getType()))) {
			return tableEntry.getUInt32(column.getValue());
		} else if (NamedSnmpVar.SNMPINT32.equals(Column.valueOf(column
				.getType()))) {
			return tableEntry.getInt32(column.getValue());
		} else if (NamedSnmpVar.SNMPOBJECTID.equals(Column.valueOf(column
				.getType()))) {
			return tableEntry.getObjectID(column.getValue());
		} else if (NamedSnmpVar.SNMPHEXSTRING.equals(Column.valueOf(column.getType()))) {
			return tableEntry.getHexString(column.getValue());
		} else {
			return tableEntry.getDisplayString(column.getValue());
		}
	}
}

