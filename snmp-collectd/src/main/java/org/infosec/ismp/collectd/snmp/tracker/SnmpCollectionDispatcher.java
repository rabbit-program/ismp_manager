package org.infosec.ismp.collectd.snmp.tracker;

import java.net.InetAddress;
import java.util.Map;

import org.infosec.ismp.collectd.snmp.config.SnmpConfigFactory;
import org.infosec.ismp.collectd.snmp.configuration.Device;
import org.infosec.ismp.collectd.snmp.configuration.Table;
import org.infosec.ismp.snmp.AggregateTracker;

/**
 * @author guoxianwei
 * @date 2010-11-3 下午02:22:24
 * 
 */
public final class SnmpCollectionDispatcher {

	public static Map<String, Object> g_map = null;

	private InetAddress m_address;

//	static Result result = new Result();
	
	
	public SnmpCollectionDispatcher() {
	}

	public SnmpCollectionDispatcher(InetAddress address) {
		
		m_address = address;
	}

	public AggregateTracker[] getAggregateTrackers(String type,String brand) {
		Device device = SnmpConfigFactory.getInstance().getDevice(type,brand);
		if(device==null){
			throw new RuntimeException("目前不支持该类型 : "+type);
		}
		if(device.getParent()!=null && !"".equals(device.getParent())){
			Device parentDevice = SnmpConfigFactory.getInstance().getDevice(device.getParent(),null);
			device.addTables(parentDevice.getTables());
		}
		Iterable<Table> tables = device.getTableCollection();
		AggregateTracker[] trackers = null;
		trackers = new AggregateTracker[device.getTableCount()];
		int idx = 0;
		if(tables!=null){
			for (Table table : tables) {
				AggregateTracker tracker = newSnmpTrackerInstance(m_address, table);

				trackers[idx] = tracker;
				idx++;

			}
		}

		return trackers;

	}
	
	public static AggregateTracker newSnmpTrackerInstance(InetAddress address,Table table){
		if(table.isTable()){
			return new SnmpTableTracker(address,table);
		}else{
			return new GenericColumnTracker(address,table);
		}
	}
	
	public static void main(String[] args) throws Exception{/*
		SnmpConfigFactory.init("d:/File");

		SnmpAgentConfig agentConfig = new SnmpAgentConfig(
				InetAddress.getLocalHost());
		SnmpCollectionDispatcher dispatcher = new SnmpCollectionDispatcher(agentConfig.getAddress());
		AggregateTracker[] tracker = dispatcher.getAggregateTrackers("cisco");
		SnmpWalker walker = SnmpUtils.createWalker(agentConfig,
				"SnmpCollectors for test", tracker);
		walker.start();
		walker.waitFor(60 * 1000 * 5);
		
		for(AggregateTracker tr : tracker){
			if(tr instanceof SnmpTableTracker){
				SnmpTableTracker t = (SnmpTableTracker)tr;
				Map<String,Map<String,Object>> map = t.getStoreResult();
				Set<Entry<String,Map<String,Object>>> treeSet = map.entrySet();

				for(Entry<String,Map<String,Object>> treeEntry : treeSet){
					System.out.println("column-------------"+treeEntry.getKey());
					Map<String,Object> treeMap = treeEntry.getValue();
					for(Entry<String,Object> entry:treeMap.entrySet()){
						 System.out.println("key:"+entry.getKey()+"       value:"+entry.getValue());
					}
				 
				}
			}else{
				GenericColumnTracker t = (GenericColumnTracker)tr;
				System.out.println("column--------------------"+t.getTrackerName());
				result.putAll(t.getStoreResult());
			}

		}
		for(Object obj:result.values()){
			System.out.println("value--------------------"+obj);
		}
		
	*/} 
}

