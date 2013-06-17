package org.infosec.ismp.manager.rmi.snmpTrap;

/**
 * 日志的远程操纵接口
 * 
 * @author lianglin
 * 
 */
public interface SnmpTrapController {
	/**
	 * 添加snmpTrap日志源
	 * 
	 * @param agentId
	 * @param domain
	 * @param syslogSourceId
	 * @param syslogType
	 * @param syslogAddress
	 */
	public void addSnmpTrapSource(String domain,
			String nodeId, String snmpTrapType, String snmpTrapAddress);

	/**
	 * 删除一个日志源
    */
	public void removeSnmpTrapSource(String nodeid);
}
