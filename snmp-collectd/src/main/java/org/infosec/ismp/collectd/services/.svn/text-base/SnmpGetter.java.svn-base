package org.infosec.ismp.collectd.services;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.collectd.snmp.ObjIdMonitor;
import org.infosec.ismp.collectd.snmp.tracker.TableTracker;
import org.infosec.ismp.snmp.ColumnTracker;
import org.infosec.ismp.snmp.SnmpAgentConfig;
import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.snmp.SnmpUtils;
import org.infosec.ismp.snmp.SnmpValue;
import org.infosec.ismp.snmp.SnmpWalker;
import org.snmp4j.smi.SMIConstants;

public class SnmpGetter {
	private SnmpAgentConfig m_agentConfig;

	public SnmpGetter(SnmpAgentConfig agentConfig) {
		this.m_agentConfig = agentConfig;
	}

	/**
	 * 返回一个字符串，是标量
	 * 
	 * @param oid
	 * @return
	 */
	public String getSnmpString(String oid) {
		ObjIdMonitor tracker = new ObjIdMonitor(SnmpObjId.get(oid),
				SnmpInstId.INST_ZERO);
		SnmpWalker walker = SnmpUtils.createWalker(m_agentConfig,
				"singSnmpGet", tracker);
		walker.start();
		try {
			walker.waitFor(60 * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!tracker.failed()) {
			SnmpValue value = tracker.getValue();
			if (value != null) {
				if (value.getType() == SMIConstants.SYNTAX_OCTET_STRING) {
					return value.toHexString();
				} else {
					return value.toDisplayString();
				}
			}
		}
		return null;
	}

	/**
	 * 返回表中一列
	 * @param oid
	 * @return
	 */
	public String[] getSnmpArray(String oid) {
		final List<SnmpValue> results = new ArrayList<SnmpValue>();
		ColumnTracker tracker = new ColumnTracker(SnmpObjId.get(oid)) {

			@Override
			protected void storeResult(SnmpResult res) {
				results.add(res.getValue());
			}

		};
		SnmpWalker walker = SnmpUtils.createWalker(m_agentConfig,
				"singSnmpGet", tracker);
		walker.start();
		try {
			walker.waitFor(60 * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (!tracker.failed()) {
			List<String> resultString = new ArrayList<String>();
			if(results!=null){
				for (SnmpValue value : results) {
					if (value.getType() == SMIConstants.SYNTAX_OCTET_STRING) {
						resultString.add(value.toHexString());
					} else {
						resultString.add(value.toDisplayString());
					}
				}
			}
			return resultString.toArray(new String[0]);
		}
		return null;
	}
	
	public String[][] getSnmpTable(String tableOid){
        TableTracker tracker = new TableTracker(SnmpObjId.get(tableOid));
		SnmpWalker walker = SnmpUtils.createWalker(m_agentConfig,
				"singSnmpGet", tracker);
		walker.start();
		try {
			walker.waitFor(60 * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (!tracker.failed()) {
			return tracker.getTable();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		SnmpAgentConfig config = new SnmpAgentConfig();
		config.setAddress(InetAddress.getByName("192.168.9.254"));
		config.setReadCommunity("public");
		config.setVersion(2);

//		final List<SnmpValue> results = new ArrayList<SnmpValue>();

//		ColumnTracker tracker = new ColumnTracker(
//				SnmpObjId.get(".1.3.6.1.2.1.3.1")) {
//
//			@Override
//			protected void storeResult(SnmpResult res) {
//				 System.out.println(res.getAbsoluteInstance());
//				results.add(res.getValue());
//			}
//
//		};
		TableTracker tracker = new TableTracker(SnmpObjId.get(".1.3.6.1.2.1.6.13"));
		SnmpWalker walker = SnmpUtils.createWalker(config, "tableSnmpGet",
				tracker);
		walker.start();
		try {
			walker.waitFor(60 * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (!tracker.failed()) {
			System.out.println("sucessed");
			System.out.println(tracker.getItemCount());
			System.out.println(tracker.getColumnCount());
			tracker.printTable();
		}
	}

}
