package org.infosec.ismp.manager.rmi.tm.discover.service.agent;


//import edu.sjtu.infosec.ismp.base.agent.model.AgentBO;

/**
 * CDP与agent通信的接口
 * @author Wu Guojie
 * @date 2009-6-20
 * @version 1.0
 */
public interface CDPService {
	/**
	 * 获取cdp信息
	 * @param ip
	 * IP
	 * @param port
	 * 端口
	 * @param oid
	 * oid
	 * @param community
	 * 团体名
	 * @param outTime
	 * 超时时间
	 * @param agentIp
	 * agent的IP
	 * @param agentPort
	 * agent的端口
	 * @return cdp信息
	 */
	String cdpGet(String ip, int port, String oid, String community, int outTime) throws Exception;
	/**
	 * 获取cdp信息--表中的一列
	 * @param ip
	 * IP
	 * @param port
	 * 端口
	 * @param oid
	 * oid
	 * @param community
	 * 团体名
	 * @param outTime
	 * 超时时间
	 * @param agentIp
	 * agent的IP
	 * @param agentPort
	 * agent的端口
	 * @return cdp信息
	 */
	String[] cdpGetColumn(String ip, int port, String oid, String community, int outTime) throws Exception;
	/**
	 * 获取cdp信息--表中的所有列
	 * @param ip
	 * IP
	 * @param port
	 * 端口
	 * @param oid
	 * oid
	 * @param community
	 * 团体名
	 * @param outTime
	 * 超时时间
	 * @param agentIp
	 * agent的IP
	 * @param agentPort
	 * agent的端口
	 * @return cdp信息
	 */
	String[][] cdpGetTable(String ip, int port, String oid, String community, int outTime) throws Exception;
	
	/**
	 * 方法说明：获取所有AgentBO列表(数据库的)
	 * @return
	 */
//	List<AgentBO> getAllAgentBO() throws Exception;
	
	/**
	 * 方法说明：获取所有已经向Manager注册的AgentBO列表（邓东和数据库的交际）
	 * @return
	 */
//	List<AgentBO> getAllRegisteredAgentBO() throws Exception;
}
