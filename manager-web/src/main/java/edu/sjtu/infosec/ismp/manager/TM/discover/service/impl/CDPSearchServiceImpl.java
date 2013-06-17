package edu.sjtu.infosec.ismp.manager.TM.discover.service.impl;

import java.util.ArrayList;
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
import org.infosec.ismp.manager.rmi.tm.discover.service.agent.CDPService;
import org.infosec.ismp.manager.rmi.tm.discover.service.applet.CDPSearchService;
import org.springframework.transaction.annotation.Transactional;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.TM.discover.comm.attribute.BaseAttribute;
import edu.sjtu.infosec.ismp.manager.TM.discover.dao.LineDao;
import edu.sjtu.infosec.ismp.manager.TM.discover.dao.NodeDao;
import edu.sjtu.infosec.ismp.manager.TM.discover.dao.NodeTypeDao;
import edu.sjtu.infosec.ismp.security.User;


/**
 * CDP搜索Service实现类
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public class CDPSearchServiceImpl implements CDPSearchService {
	private CDPService cdpGetService;

	public void setCdpGetService(CDPService cdpGetService) {
		this.cdpGetService = cdpGetService;
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
	 * 搜索
	 * @param cdpAppletForm
	 * cdpAppletForm
	 * @return 搜索结果
	 */
	public Map<String, List> doSearch(CDPAppletForm cdpAppletForm) throws Exception {
		return null;
	}

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
	public CommonMessage getCdpMessage(String ip, int port, String oid,
			String community, int outTime) throws Exception {
		/**
		 * 结果
		 */
		CommonMessage result = new CommonMessage();
		/**
		 * 耗时
		 */
		double cdpGetTime = 0;
		/**
		 * snmp消息
		 */
		String cdpGetMessage = "";
		
		try{
        	BaseAttribute.setLastActiveTime();
			long startTime = System.currentTimeMillis();
			cdpGetMessage = cdpGetService.cdpGet(ip, port, oid, community, outTime);
			
        	if(cdpGetMessage==null || cdpGetMessage.equals("")){
        		result.setSuccessful(false);
        	}else{
        		result.setSuccessful(true);
        	}
        	long endTime = System.currentTimeMillis();
        	cdpGetTime = (endTime-startTime)/1000;
        	result.setCostTime(cdpGetTime);
        	result.setMessage(cdpGetMessage);
		    return result;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
//			return null;
		}
	}

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
	public ColumnMessage getCdpColumnMessage(String ip, int port, String oid, String community, int outTime) throws Exception {
		/**
		 * 结果
		 */
		ColumnMessage result = new ColumnMessage();
		/**
		 * 耗时
		 */
		double cdpGetTime = 0;
		/**
		 * cdp消息
		 */
		String[] cdpGetMessage;
		
		try{
        	BaseAttribute.setLastActiveTime();
			long startTime = System.currentTimeMillis();
			cdpGetMessage = cdpGetService.cdpGetColumn(ip, port, oid, community, outTime);
			
        	if(cdpGetMessage==null || cdpGetMessage.length<1){
        		result.setSuccessful(false);
        	}else if(cdpGetMessage.length>0){
        		result.setSuccessful(true);
        		for(int i=0;i<cdpGetMessage.length;i++){
        			if(cdpGetMessage[i]==null || cdpGetMessage[i].equals("")){
        				result.setSuccessful(false);
        				break;
        			}
        		}
        	}else{
        		result.setSuccessful(true);
        	}
        	long endTime = System.currentTimeMillis();
        	cdpGetTime = (endTime-startTime)/1000;
        	result.setCostTime(cdpGetTime);
        	result.setMessage(cdpGetMessage);
		    return result;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
//			return null;
		}
	}

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
	public TableMessage getCdpTableMessage(String ip, int port,
			String oid, String community, int outTime) throws Exception {
		/**
		 * 结果
		 */
		TableMessage result = new TableMessage();
		/**
		 * 耗时
		 */
		double cdpGetTime = 0;
		/**
		 * snmp消息
		 */
		String[][] cdpGetMessage;
		
		try{
        	BaseAttribute.setLastActiveTime();
			long startTime = System.currentTimeMillis();
			cdpGetMessage = cdpGetService.cdpGetTable(ip, port, oid, community, outTime);
			
        	if(cdpGetMessage==null || cdpGetMessage.length<1){
        		result.setSuccessful(false);
        	}else if(cdpGetMessage.length>0){
        		result.setSuccessful(true);
        		for(int i=0;i<cdpGetMessage.length;i++){
        			for(int j=0;j<cdpGetMessage.length;j++){
            			if(cdpGetMessage[i][j]==null || cdpGetMessage[i][j].equals("")){
            				result.setSuccessful(false);
            				break;
            			}
        			}
        			if(!result.isSuccessful()){
        				break;
        			}
        		}
        	}else{
        		result.setSuccessful(true);
        	}
        	long endTime = System.currentTimeMillis();
        	cdpGetTime = (endTime-startTime)/1000;
        	result.setCostTime(cdpGetTime);
        	result.setMessage(cdpGetMessage);
		    return result;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
//			return null;
		}
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
	 * 将节点连接list入库
	 * @param list
	 * 节点连接list
	 */
	 @Transactional
	public void addLineList(List<Line> list) throws Exception {
		List<Line> lineListResult = new ArrayList<Line>();
		List<Node> nodeListResult = new ArrayList<Node>();
		try{
			nodeListResult = nodeDao.findAllNodes();
			for(Line line : list){
				boolean isOkSelfIP = false;
				boolean isOkDestIP = false;
				String selfIP = line.getNodeSelf().getIpAddr();
				String destIP = line.getNodeDest().getIpAddr();
				String selfInterface = line.getNodeSelf().getSelfInterface();
				String destInterface = line.getNodeDest().getSelfInterface();
				for(Node nodeResult : nodeListResult){
    				if(selfIP.equals(nodeResult.getIpAddr())){
    					if(selfInterface!=null){
    						if(nodeResult.getSelfInterface()!=null){
    							if(selfInterface.equals(nodeResult.getSelfInterface())){
    								isOkSelfIP = true;
    								line.setNodeSelf(nodeResult);
    							}
    						}
    					}else{
    						if(nodeResult.getSelfInterface()==null){
            					isOkSelfIP = true;
            					line.setNodeSelf(nodeResult);
    						}
    					}
    				}
    				if(destIP.equals(nodeResult.getIpAddr())){
    					if(destInterface!=null){
    						if(nodeResult.getSelfInterface()!=null){
    							if(destInterface.equals(nodeResult.getSelfInterface())){
    								isOkDestIP = true;
    								line.setNodeDest(nodeResult);
    							}
    						}
    					}else{
    						if(nodeResult.getSelfInterface()==null){
            					isOkDestIP = true;
            					line.setNodeDest(nodeResult);
    						}
    					}
    				}
				}
				if(isOkSelfIP && isOkDestIP){
					lineListResult.add(line);
				}
			}
			if(lineListResult!=null && lineListResult.size()>0){
				for(Line line : lineListResult){
					lineDao.addLine(line);
				}
			}else{
//				throw new Exception("增加的节点连接不能为空！");
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 通过id获取节点类型
	 * @param id
	 * id
	 * @return 节点类型
	 */
	public NodeType getNodeTypeById(int id) throws Exception {
		/**
		 * 节点类型
		 */
		NodeType nodeType = nodeTypeDao.findNodeTypeById(id);
		return nodeType;
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
	
//	/**
//	 * 方法说明：获取所有AgentBO列表(数据库的)
//	 * @return
//	 */
//	public List<AgentBO> getAllAgentBO() throws Exception{
//		return cdpGetService.getAllAgentBO();
//	}
//	
//	/**
//	 * 方法说明：获取所有已经向Manager注册的AgentBO列表（邓东和数据库的交际）
//	 * @return
//	 */
//	public List<AgentBO> getAllRegisteredAgentBO() throws Exception{
//		return cdpGetService.getAllRegisteredAgentBO();
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
