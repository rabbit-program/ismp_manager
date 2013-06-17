package org.infosec.ismp.agent.rmi.syslog;
/**
 * Agent上日志源的添加接口
 * @author lianglin
 *
 */
public interface AgentSyslogController {
	/**
	 * 添加一个日志源，指定编码方式
	 * @param nodeid
	 * @param srcip
	 * @param encoding
	 */
     public void addSyslogSource(int nodeid,String srcip,String encoding);
     /**
      * 指定一个日志源，使用默认编码方式
      * @param nodeid
      * @param srcip
      */
     public void addSyslogSource(int nodeid,String srcip);
     
     /**
      * 删除一个指定的日志源
      * @param nodeid
      */
     public void removeSyslogSource(int nodeid);
}
