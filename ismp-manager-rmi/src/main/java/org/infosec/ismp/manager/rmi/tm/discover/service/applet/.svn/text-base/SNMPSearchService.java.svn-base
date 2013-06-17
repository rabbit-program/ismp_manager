package org.infosec.ismp.manager.rmi.tm.discover.service.applet;

import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.SNMPAppletForm;
import org.infosec.ismp.manager.rmi.tm.discover.model.typeSense.DeviceTypeRuler;


/**
 * SNMP搜索Service接口
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public interface SNMPSearchService {
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
	 * @param snmpAppletForm
	 * snmpAppletForm
	 * @return 搜索结果list
	 */
	List<Node> doSearch(SNMPAppletForm snmpAppletForm) throws Exception;
	/**
	 * 通过SNMP获取对应的信息
	 * @param ip
	 * ip
	 * @param port
	 * 端口
	 * @param oid
	 * oid
	 * @param community
	 * 团体名
	 * @param outTime
	 * 超时时间
	 * @return 获取的结果
	 */
	Map<String, String> getSnmpMessage(String ip, int port, String oid, String community, int outTime) throws Exception;
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
	 * 查找所有的匹配规则名
	 */
	List<String> findAllDeviceTypeRulerName() throws Exception;
	/**
	 * 通过匹配规则名称查找对应的规则
	 * @param name
	 * 匹配规则名
	 * @return 规则list
	 */
	List<DeviceTypeRuler> findAllDeviceTypeRulersByName(String name) throws Exception;
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
