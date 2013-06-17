package org.infosec.ismp.agent.rmi.snmp;

/**
 * Agent上snmp采集数据的添加、删除接口
 * 
 * @author lianglin
 * 
 */
public interface AgentSnmpController {
	/**
	 * 添加一个需要snmp采集数据的设备
	 * @param nodeid
	 * @param ipaddr
	 * @param community
	 * @param snmpVersion
	 * @param interval
	 */
	public void addSnmpCollectDevice(int nodeid, String ipaddr,
			String community, int snmpVersion, long interval);
    /**
     * 删除一个snmp采集数据设备
     * @param nodeid
     */
	public void removeSnmpCollectDevice(int nodeid);
}
