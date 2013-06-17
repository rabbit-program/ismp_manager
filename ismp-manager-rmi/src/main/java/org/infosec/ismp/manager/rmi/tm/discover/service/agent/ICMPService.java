package org.infosec.ismp.manager.rmi.tm.discover.service.agent;


//import edu.sjtu.infosec.ismp.base.agent.model.AgentBO;

/**
 * ICMP与agent通信的接口
 * @author Wu Guojie
 * @date 2009-6-16
 * @version 1.0
 */
public interface ICMPService {
	/**
	 * ping方法
	 * @param ip
	 * IP
	 * @param outTime
	 * 超时时间
	 * @param agentIp
	 * agent的IP
	 * @param agentPort
	 * agent的端口
	 * @return ping结果
	 */
	String ping(String ip, int outTime) throws Exception;
	
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
