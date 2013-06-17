package org.infosec.ismp.manager.rmi.tm.discover.service.applet;

import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.tm.discover.model.Line;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.CDPAppletForm;
import org.infosec.ismp.manager.rmi.tm.discover.model.getMessage.ColumnMessage;
import org.infosec.ismp.manager.rmi.tm.discover.model.getMessage.CommonMessage;
import org.infosec.ismp.manager.rmi.tm.discover.model.getMessage.TableMessage;


/**
 * CDP搜索Service接口
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public interface CDPSearchService {
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
	 * @param cdpAppletForm
	 * cdpAppletForm
	 * @return 搜索结果
	 */
	Map<String,List> doSearch(CDPAppletForm cdpAppletForm) throws Exception;
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
	CommonMessage getCdpMessage(String ip, int port, String oid, String community, int outTime) throws Exception;
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
	ColumnMessage getCdpColumnMessage(String ip, int port, String oid, String community, int outTime) throws Exception;
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
	TableMessage getCdpTableMessage(String ip, int port, String oid, String community, int outTime) throws Exception;
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
	 * 将节点连接list入库
	 * @param list
	 * 节点连接list
	 */
	void addLineList(List<Line> list) throws Exception;
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
