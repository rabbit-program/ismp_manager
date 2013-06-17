package org.infosec.ismp.manager.rmi.tm.discover.service.applet;

import java.util.List;

import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.PCAppletForm;


/**
 * PC搜索Service接口
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public interface PCSearchService {
	/**
	 * 开始搜索
	 */
	boolean startSearch() throws Exception;
	/**
	 * 结束搜索
	 */
	boolean stoppedSearch() throws Exception;
	/**
	 * 搜索
	 * @param pcAppletForm
	 * pcAppletForm
	 * @return 搜索结果list
	 */
	List<Node> doSearch(PCAppletForm pcAppletForm) throws Exception;
	/**
	 * 指定Agent管理下的所有PC
	 * @param agentIp
	 * agent的IP
	 * @param agentPort
	 * agent的端口
	 * @return 该Agent管理下的所有PC
	 */
	List<Node> getAllPcByAgent() throws Exception;
	/**
	 * 通过id获取节点类型
	 * @param id
	 * id
	 * @return 节点类型
	 */
	NodeType getNodeTypeById(int id) throws Exception;
	/**
	 * 将节点list入库
	 * @param list
	 * 节点list
	 */
	void addNodeList(List<Node> list) throws Exception;
	/**
	 * 是否有人正在执行搜索功能
	 * @return 是/否
	 */
	boolean isSearching() throws Exception;
	
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
	/**
	 * 写日志
	 * @param log
	 * 日志
	 */
	void writeToSysLog(SystemLog log, int userId);
}
