package org.infosec.ismp.collectd.snmp.tracker;

import java.net.InetAddress;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpStore;
import org.infosec.ismp.collectd.snmp.configuration.Column;
import org.infosec.ismp.collectd.snmp.configuration.Table;
import org.infosec.ismp.snmp.AggregateTracker;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-11-1 下午07:54:09 标量MIB信息获取类
 */
public final class GenericColumnTracker extends AggregateTracker {

	public GenericColumnTracker(InetAddress address, Table table) {
		super(NamedSnmpVar.getTrackersFor(setNamedSnmpVars(table)));
		m_store = new SnmpStore(ms_elemList);
		m_address = address;
		m_table = table;
	}

	public static NamedSnmpVar[] ms_elemList = null;

	private InetAddress m_address;

	private Table m_table;

	private SnmpStore m_store;

	private Map<String, Object> m_map = Collections
			.synchronizedMap(new TreeMap<String, Object>());

	private static NamedSnmpVar[] setNamedSnmpVars(Table table) {
		ms_elemList = new NamedSnmpVar[table.getColumns().size()];
		int ndx = 0;
		if (table != null && table.getColumns() != null) {
			for (Column column : table.getColumns()) {
				ms_elemList[ndx] = new NamedSnmpVar(column.getType(), column
						.getName(), column.getValue());
				ndx++;
			}
		}

		return ms_elemList;
	}

	public Map<String, Object> getStoreResult() {
		if (m_table != null && m_table.getColumns() != null) {
			for (Column column : m_table.getColumns()) {
				if (NamedSnmpVar.SNMPIPADDRESS.equals(Column.valueOf(column
						.getType()))) {
					m_map.put(column.getName(), m_store.getIPAddress(column
							.getValue()));
				} else if (NamedSnmpVar.SNMPUINT32.equals(Column.valueOf(column
						.getType()))) {
					m_map.put(column.getName(), m_store.getUInt32(column
							.getValue()));
				} else if (NamedSnmpVar.SNMPCOUNTER32.equals(Column
						.valueOf(column.getType()))) {
					m_map.put(column.getName(), m_store.getUInt32(column
							.getValue()));
				} else if (NamedSnmpVar.SNMPCOUNTER64.equals(Column
						.valueOf(column.getType()))) {
					m_map.put(column.getName(), m_store.getUInt32(column
							.getValue()));
				} else if (NamedSnmpVar.SNMPINT32.equals(Column.valueOf(column
						.getType()))) {
					m_map.put(column.getName(), m_store.getInt32(column
							.getValue()));
				} else if (NamedSnmpVar.SNMPOBJECTID.equals(Column
						.valueOf(column.getType()))) {
					m_map.put(column.getName(), m_store.getObjectID(column
							.getValue()));
				} else if (NamedSnmpVar.SNMPHEXSTRING.equals(Column
						.valueOf(column.getType()))) {
					m_map.put(column.getName(), m_store.getHexString(column
							.getValue()));
				} else {
					m_map.put(column.getName(), m_store.getDisplayString(column
							.getValue()));
				}
			}
		}
		return m_map;
	}

	@Override
	protected void storeResult(SnmpResult res) {
		m_store.storeResult(res);

	}

	@Override
	protected void reportGenErr(String msg) {
		log().warn(
				"Error retrie ving systemGroup from " + m_address + ". " + msg);
	}

	@Override
	protected void reportNoSuchNameErr(String msg) {
		log().info(
				"Error retrieving systemGroup from " + m_address + ". " + msg);
	}

	public String getTrackerName() {
		return m_table.getName();
	}

	private final ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
