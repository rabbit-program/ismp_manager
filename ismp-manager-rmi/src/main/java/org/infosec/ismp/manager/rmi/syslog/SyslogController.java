package org.infosec.ismp.manager.rmi.syslog;

/**
 * 日志的远程操纵接口
 * 
 * @author lianglin
 * 
 */
public interface SyslogController {
	/**
	 * 添加syslog日志源
	 * 
	 * @param agentId
	 * @param domain
	 * @param syslogSourceId
	 * @param syslogType
	 * @param syslogAddress
	 */
	public void addSyslogSource(String domain,
			String nodeId, String syslogType, String syslogAddress);

	/**
	 * 删除一个日志源
    */
	public void removeSyslogSource(String nodeid);
}
