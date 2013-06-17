package edu.sjtu.infosec.ismp.manager.TM.discover.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.tm.discover.model.Line;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.SNMPAppletForm;
import org.infosec.ismp.manager.rmi.tm.discover.model.typeSense.DeviceTypeRuler;
import org.infosec.ismp.manager.rmi.tm.discover.service.agent.SNMPService;
import org.infosec.ismp.manager.rmi.tm.discover.service.applet.SNMPSearchService;
import org.springframework.transaction.annotation.Transactional;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.TM.discover.comm.attribute.BaseAttribute;
import edu.sjtu.infosec.ismp.manager.TM.discover.dao.LineDao;
import edu.sjtu.infosec.ismp.manager.TM.discover.dao.NodeDao;
import edu.sjtu.infosec.ismp.manager.TM.discover.dao.NodeTypeDao;
import edu.sjtu.infosec.ismp.manager.TM.discover.dao.typeSense.DeviceTypeRulerDao;
import edu.sjtu.infosec.ismp.security.User;


/**
 * SNMP搜索Service实现类
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public class SNMPSearchServiceImpl implements SNMPSearchService {
	private SNMPService snmpGetService;
	
	public void setSnmpGetService(SNMPService snmpGetService) {
		this.snmpGetService = snmpGetService;
	}
	
	private SystemLogService systemlogservice;

	public void setSystemlogservice(SystemLogService systemlogservice) {
		this.systemlogservice = systemlogservice;
	}

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	

	/**
	 * 节点dao
	 */
	private NodeDao nodeDao;
	/**
	 * 节点类型dao
	 */
	private NodeTypeDao nodeTypeDao;
	/**
	 * 节点间连线dao
	 */
	private LineDao lineDao;
	/**
	 * 匹配规则dao
	 */
	private DeviceTypeRulerDao deviceTypeRulerDao;
	
	/**
     * @param vNodeDao the nodeDao to set
     */
    public void setNodeDao(NodeDao vNodeDao) {
    	nodeDao = vNodeDao;
    }
	/**
     * @param vNodeTypeDao the nodeTypeDao to set
     */
    public void setNodeTypeDao(NodeTypeDao vNodeTypeDao) {
    	nodeTypeDao = vNodeTypeDao;
    }
	/**
     * @param vLineDao the lineDao to set
     */
    public void setLineDao(LineDao vLineDao) {
    	lineDao = vLineDao;
    }
	/**
     * @param vDeviceTypeRulerDao the deviceTypeRulerDao to set
     */
    public void setDeviceTypeRulerDao(DeviceTypeRulerDao vDeviceTypeRulerDao) {
    	deviceTypeRulerDao = vDeviceTypeRulerDao;
    }
    
    

	/**
	 * 搜索
	 * @param snmpAppletForm
	 * snmpAppletForm
	 * @return 搜索结果list
	 */
	public List<Node> doSearch(SNMPAppletForm snmpAppletForm) throws Exception {
		return null;
	}
	

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
	public Map<String, String> getSnmpMessage(String ip, int port, String oid, String community, int outTime) throws Exception {
		/**
		 * 结果map
		 */
		Map<String, String> map = new HashMap<String, String>();
		/**
		 * 耗时
		 */
		double snmpGetTime = 0;
		/**
		 * snmp消息
		 */
		String snmpGetMessage = "";
		
		try{
        	BaseAttribute.setLastActiveTime();
			long startTime = System.currentTimeMillis();
			snmpGetMessage = snmpGetService.snmpGet(ip, port, oid, community, outTime);
			
        	if(snmpGetMessage==null || snmpGetMessage.equals("")){
        		snmpGetMessage = "Messages Get Failed!";
        	}
        	long endTime = System.currentTimeMillis();
        	snmpGetTime = (endTime-startTime)/1000;
	        map.put("snmpGetMessage", snmpGetMessage);
	        map.put("snmpGetTime", snmpGetTime+"");
		    return map;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
//			return null;
		}
	}
	

	/**
	 * 开始搜索
	 */
	public boolean startSearch() throws Exception {
		/**
		 * 实例化全局属性
		 */
		BaseAttribute baseAttribute = BaseAttribute.getInstance();
		if((!baseAttribute.TOPO_SEARCH_STATE_RUNNING) & (baseAttribute.TOPO_SEARCH_RUNNING_COUNT==0)){
			baseAttribute.running();
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 结束搜索
	 */
	public boolean stoppedSearch() throws Exception {
		/**
		 * 实例化全局属性
		 */
		BaseAttribute baseAttribute = BaseAttribute.getInstance();
		if(baseAttribute.TOPO_SEARCH_STATE_RUNNING & (baseAttribute.TOPO_SEARCH_RUNNING_COUNT==1)){
			baseAttribute.stopped();
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 通过id获取节点类型
	 * @param id
	 * id
	 * @return 节点类型
	 */
	 @Transactional
	public NodeType getNodeTypeById(int id) throws Exception {
		/**
		 * 节点类型
		 */
		NodeType nodeType = nodeTypeDao.findNodeTypeById(id);
		return nodeType;
	}

	/**
	 * 将节点list入库
	 * @param list
	 * 节点list
	 */
	 @Transactional
	public void addNodeList(List<Node> list) throws Exception {
		List<Line> lineList = lineDao.findAllLines();
		if(lineList!=null && lineList.size()>0){
			for(Line line : lineList){
				lineDao.deleteLine(line);
			}
		}
		List<Node> nodeList = nodeDao.findAllNodes();
		if(nodeList!=null && nodeList.size()>0){
			for(Node node : nodeList){
				nodeDao.deleteNode(node);
			}
		}
		try{
			if(list!=null && list.size()>0){
				for(Node node : list){
					nodeDao.addNode(node);
				}
			}else{
//				throw new Exception("增加的节点不能为空！");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * 查找所有的匹配规则名
	 */
	 @Transactional
	public List<String> findAllDeviceTypeRulerName() throws Exception {
		List<String> list = deviceTypeRulerDao.findAllDeviceName();
		return list;
	}
	
	/**
	 * 通过匹配规则名称查找对应的规则
	 * @param name
	 * 匹配规则名
	 * @return 规则list
	 */
	 @Transactional
	public List<DeviceTypeRuler> findAllDeviceTypeRulersByName(String name) throws Exception {
		List<DeviceTypeRuler> list = deviceTypeRulerDao.findAllDeviceTypeRulersByDeviceName(name);
		return list;
	}

	/**
	 * 是否有人正在执行搜索功能
	 * @return 是/否
	 */
	public boolean isSearching() throws Exception {
		/**
		 * 实例化全局属性
		 */
		BaseAttribute baseAttribute = BaseAttribute.getInstance();
		return baseAttribute.TOPO_SEARCH_STATE_RUNNING;
	}
	
//	/**
//	 * 方法说明：获取所有AgentBO列表(数据库的)
//	 * @return
//	 */
//	public List<AgentBO> getAllAgentBO() throws Exception{
//		return snmpGetService.getAllAgentBO();
//	}
//	
//	/**
//	 * 方法说明：获取所有已经向Manager注册的AgentBO列表（邓东和数据库的交际）
//	 * @return
//	 */
//	public List<AgentBO> getAllRegisteredAgentBO() throws Exception{
//		return snmpGetService.getAllRegisteredAgentBO();
//	}

	/**
	 * 写日志
	 * @param log
	 * 日志
	 */
	public void writeToSysLog(SystemLog log, int userId) {
		User user = userService.getUserByIdService(userId);
		log.setUsername(user.getUsername());
		log.setRoleName(user.getRoleNames());
		systemlogservice.saveSystemLog(log);
	}
	
	
	
}
