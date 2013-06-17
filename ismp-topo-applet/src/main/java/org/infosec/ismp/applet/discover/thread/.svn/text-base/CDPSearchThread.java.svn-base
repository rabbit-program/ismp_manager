package org.infosec.ismp.applet.discover.thread;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.applet.comm.util.HttpInvokerProxyFactoryBeanUtil;
import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.applet.discover.listener.SearchListener;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.tm.discover.model.Line;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.CDPAppletForm;
import org.infosec.ismp.manager.rmi.tm.discover.model.getMessage.ColumnMessage;
import org.infosec.ismp.manager.rmi.tm.discover.model.getMessage.CommonMessage;
import org.infosec.ismp.manager.rmi.tm.discover.service.applet.CDPSearchService;

/**
 * CDP搜索线程类
 * @author Wu Guojie
 * @date 2009-6-11
 * @version 1.0
 */
public class CDPSearchThread extends Thread {
	SystemLog log = null;
	/**
	 * running state
	 */
	boolean running = false;
	/**
	 * stopped state
	 */
	boolean stopped = false;
	/**
	 * 结果map--节点对应的key为“nodeList”,节点间连接对应的key为“lineList”
	 */
	Map<String,List> map = new HashMap<String,List>();
	/**
	 * 结果list--节点
	 */
	List<Node> nodeList = new ArrayList<Node>();
	/**
	 * 结果list--节点间连接
	 */
	List<Line> lineList = new ArrayList<Line>();
	/**
	 * 创建cdpSearchService
	 */
	CDPSearchService cdpSearchService = getCDPSearchService();
	/**
	 * 远程获取cdpSearchService
	 * @return CDPSearchService实例
	 */
	public CDPSearchService getCDPSearchService(){
		try{
			CDPSearchService service = (CDPSearchService)HttpInvokerProxyFactoryBeanUtil
			.getService(ServerConfig.getServerPath()+"/remoting/cdpSearchServiceRemoting", CDPSearchService.class);
			
			return service;
		}catch(Exception e){
			listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
			return null;
		}
	}
	/**
	 * cdpAppletForm
	 */
	private CDPAppletForm cdpAppletForm = null;
	/**
	 * 搜索监听器
	 */
	private SearchListener listener = null;
	
	/**
	 * 构造器
	 * @param cdpAppletForm
	 * cdpAppletForm
	 * @param listener
	 * 搜索监听器
	 */
	public CDPSearchThread(CDPAppletForm cdpAppletForm, SearchListener listener){
		this.cdpAppletForm = cdpAppletForm;
		this.listener = listener;
	}
	
	/**
	 * 停止
	 */
	public void stopped(boolean silent){
		try{
			if(cdpSearchService!=null){
				try{
					cdpSearchService.stoppedSearch();
					stopped = true;
				}catch(Exception e1){
					if (!silent) {
						listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					}
					throw new Exception("远程服务cdpSearchService.stoppedSearch不可用！");
				}
			}else{
				if (!silent) {
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
				}
				throw new Exception("未能获取远程服务cdpSearchService！");
			}
		}catch(Exception e){
			listener.remoteServiceExecuteError("停止失败，请重试！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 是否停止
	 * @return 是否停止
	 */
	public boolean isStopped(){
		return stopped;
	}
	
	/**
	 * 是否在运行
	 * @return 是否在运行
	 */
	public boolean isRunning(){
		return running;
	}

	/**
	 * 获取结果map
	 * @return 结果map
	 */
	public Map<String, List> getMap() {
		return map;
	}

	/**
	 * set 结果map
	 * @param map
	 * 结果map
	 */
	public void setMap(Map<String, List> map) {
		this.map = map;
	}

	/**
	 * 获取结果list--节点
	 * @return 结果list--节点
	 */
	public List<Node> getNodeList() {
		return nodeList;
	}

	/**
	 * set 节点list
	 * @param nodeList
	 * 节点list
	 */
	public void setNodeList(List<Node> nodeList) {
		this.nodeList = nodeList;
	}

	/**
	 * 获取结果list--节点间连接
	 * @return 结果list--节点间连接
	 */
	public List<Line> getLineList() {
		return lineList;
	}

	/**
	 * set 节点间连接list
	 * @param lineList
	 * 节点间连接list
	 */
	public void setLineList(List<Line> lineList) {
		this.lineList = lineList;
	}

	/**
	 * 运行
	 */
	public void run(){
		if(!this.running){
			this.stopped = false;
			this.running = true;
			/**
			 * 全局时间
			 */
			Long globalAllTime = 0l;
			/**
			 * 全局开始时间
			 */
			Long globalStartTime = 0l;
			/**
			 * 全局结束时间
			 */
			Long globalEndTime = 0l;
			globalStartTime = System.currentTimeMillis();

			/**
			 * 全局cdp获取结果
			 */
			String globalCDPGetMessage = "";

			/**
			 * 开始IP
			 */
			String startIP = "0.0.0.0";
			/**
			 * 开始端口
			 */
			int startPort = 161;
			/**
			 * 结束端口
			 */
			int endPort = 161;
			/**
			 * 团体名list
			 */
			List<String> communityList = new ArrayList<String>();
			/**
			 * 搜索深度
			 */
			int searchDepth = 0;
			/**
			 * 尝试次数
			 */
			int tryNum = 0;
			/**
			 * 超时时间
			 */
			int outTime = 0;
			/**
			 * agent IP
			 */
			String agentIp;
			/**
			 * agent 端口
			 */
			int agentPort;

			
			try{
				if(cdpSearchService==null){
					listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
					throw new Exception("未能获取远程服务cdpSearchService！");
				}
				boolean canStart = false;
				try{
					canStart = cdpSearchService.startSearch();
				}catch(Exception e){
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					throw new Exception("远程服务cdpSearchService.startSearch不可用！");
				}
				if(canStart){
					if(cdpAppletForm!=null){
						if(cdpAppletForm.getStartIP()!=null && !cdpAppletForm.getStartIP().equals("")){
							startIP = cdpAppletForm.getStartIP();
						}else{
							listener.inputError("CDP搜索参数中未传入StartIP！");
							throw new Exception("CDP搜索参数中未传入StartIP！");
						}
						startPort = cdpAppletForm.getStartPort();
						endPort = cdpAppletForm.getEndPort();
						searchDepth = cdpAppletForm.getSearchDepth();
						if(cdpAppletForm.getCommunityList()!=null && cdpAppletForm.getCommunityList().size()!=0){
							communityList = cdpAppletForm.getCommunityList();
						}else{
							listener.inputError("CDP搜索参数中未传入团体名！");
							throw new Exception("CDP搜索参数中未传入团体名！");
						}
						tryNum = cdpAppletForm.getTryNum();
						outTime = cdpAppletForm.getOutTime()*1000;
//						if(cdpAppletForm.getAgentBO()!=null){
//							if(cdpAppletForm.getAgentBO().getIpAddr()!=null && !cdpAppletForm.getAgentBO().getIpAddr().equals("")){
//								agentIp = cdpAppletForm.getAgentBO().getIpAddr();
//							}else{
//								listener.inputError("CDP搜索参数中未传入获取参数的Agent的IP地址！");
//								throw new Exception("CDP搜索参数中未传入获取参数的Agent的IP地址！");
//							}
//							if(cdpAppletForm.getAgentBO().getPort()!=null){
//								agentPort = cdpAppletForm.getAgentBO().getPort();
//							}else{
//								listener.inputError("CDP搜索参数中未传入获取参数的Agent的端口！");
//								throw new Exception("CDP搜索参数中未传入获取参数的Agent的端口！");
//							}
//						}else{
//							listener.inputError("CDP搜索参数中未传入获取参数的Agent！");
//							throw new Exception("CDP搜索参数中未传入获取参数的Agent！");
//						}
					}else{
						listener.inputError("CDP搜索参数未传入！");
						throw new Exception("CDP搜索参数未传入！");
					}
					/**
					 * 开始IP分割成数组
					 */
					String[] startIPSubs = startIP.split("\\.");
					
					if(startIPSubs.length!=4){
						listener.inputError("CDP搜索参数startIP格式不对！");
						throw new Exception("CDP搜索参数startIP格式不对！");
					}else{
						if(!(startIPSubs[0].matches("\\d{1,3}"))){
							listener.inputError("CDP搜索参数startIP第一段格式不对！");
							throw new Exception("CDP搜索参数startIP第一段格式不对！");
						}
						if(!(startIPSubs[1].matches("\\d{1,3}"))){
							listener.inputError("CDP搜索参数startIP第二段格式不对！");
							throw new Exception("CDP搜索参数startIP第二段格式不对！");
						}
						if(!(startIPSubs[2].matches("\\d{1,3}"))){
							listener.inputError("CDP搜索参数startIP第三段格式不对！");
							throw new Exception("CDP搜索参数startIP第三段格式不对！");
						}
						if(!(startIPSubs[3].matches("\\d{1,3}"))){
							listener.inputError("CDP搜索参数startIP第四段格式不对！");
							throw new Exception("CDP搜索参数startIP第四段格式不对！");
						}
					}
					//搜索算法
					Node centerNode = new Node();
					centerNode.setIpAddr(startIP);
					centerNode.setParentIpAddr("");
					List<Node> neighborNodeList = new ArrayList<Node>();
					neighborNodeList.add(centerNode);
					
					for(int i=0;i<(searchDepth+1);i++){
						if (this.stopped) {
							listener.addSearchMessage("您终止了当前搜索！" + "\n");
							break;
						}
						List<Node> neighborList = new ArrayList<Node>();
						int currentSearchDepth = i+1;
						if(currentSearchDepth<=(searchDepth+1)){
							for(Node neighborNode : neighborNodeList){
								String currentIp = neighborNode.getIpAddr();
								boolean isFindValidPort = false;
								for(int p=startPort; p<(endPort+1); p++){
									if(this.stopped){
										break;
									}
									if(isFindValidPort){
										break;
									}
									int currentPort = p;
									boolean isFindValidCommunity = false;
									for(int c=0; c<communityList.size(); c++){
										if(this.stopped){
											break;
										}
										if(isFindValidCommunity){
											break;
										}
										String currentCommunity = communityList.get(c);
										for(int k=0; k<tryNum; k++){
											if(this.stopped){
												break;
											}
											//Get CDP 信息并进行型别侦测
											String searchTime = "";
											listener.addSearchMessage("\n=================================\nGet from "+currentIp+" : "+p+"\n=================================\n");
//											CommonMessage cdpGlobalRunMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.3.1", currentCommunity, outTime, agentIp, agentPort);
											CommonMessage cdpGlobalRunMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.3.1", currentCommunity, outTime);
											if(cdpGlobalRunMessage != null && cdpGlobalRunMessage.isSuccessful()){
												String cdpGlobalRun = "";
												cdpGlobalRun = cdpGlobalRunMessage.getMessage();
												listener.addSearchMessage(cdpGlobalRun + "\n");
												double costTime = cdpGlobalRunMessage.getCostTime();
												if(costTime>0.001){
													searchTime = costTime+" 秒";
												}else{
													searchTime = "小于1 毫秒";
												}
												listener.addSearchMessage("**********************\n发现节点："+currentIp+"\n耗时：" + searchTime + "\n**********************\n");
												Node node = neighborNode;
												node.setAddDate(new Date());
												node.setCommunity(currentCommunity);
												node.setIpAddr(currentIp);
												node.setLevel(i);
												node.setName("node: "+currentIp);
												node.setPort(currentPort);
												node.setSearchTime(searchTime);
												node.setTryNum(k+1);
												if(node.getNodeType()==null){
													node.setNodeType(cdpSearchService.getNodeTypeById(8));
												}
//												CommonMessage sysDescrMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.1.1", currentCommunity, outTime, agentIp, agentPort);
												CommonMessage sysDescrMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.1.1", currentCommunity, outTime);
												String sysDescr = "";
												if(sysDescrMessage != null && sysDescrMessage.isSuccessful()){
													sysDescr = sysDescrMessage.getMessage();
													listener.addSearchMessage(sysDescr + "\n");
												}
												node.setDescription(sysDescr);
//												CommonMessage ipAdEntNetMaskMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.4.20.1.3", currentCommunity, outTime, agentIp, agentPort);
												CommonMessage ipAdEntNetMaskMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.4.20.1.3", currentCommunity, outTime);
												String ipAdEntNetMask = "";
												if(ipAdEntNetMaskMessage != null && ipAdEntNetMaskMessage.isSuccessful()){
													ipAdEntNetMask = ipAdEntNetMaskMessage.getMessage();
													listener.addSearchMessage(ipAdEntNetMask + "\n");
												}
												node.setNetMask(ipAdEntNetMask);
												
												String cdpCacheAddress = "";
												String cdpCachePlatform = "";
												String cdpCacheCapabilities = "";
												String cdpCacheDevicePort = "";
//												ColumnMessage cdpCacheAddressMessage = cdpSearchService.getCdpColumnMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.2.1.1.4", currentCommunity, outTime, agentIp, agentPort);
												ColumnMessage cdpCacheAddressMessage = cdpSearchService.getCdpColumnMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.2.1.1.4", currentCommunity, outTime);
												if(cdpCacheAddressMessage != null && cdpCacheAddressMessage.isSuccessful() && cdpCacheAddressMessage.getMessage().length>0){
//													ColumnMessage cdpCachePlatformMessage = cdpSearchService.getCdpColumnMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.2.1.1.8", currentCommunity, outTime, agentIp, agentPort);
													ColumnMessage cdpCachePlatformMessage = cdpSearchService.getCdpColumnMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.2.1.1.8", currentCommunity, outTime);
//													ColumnMessage cdpCacheCapabilitiesMessage = cdpSearchService.getCdpColumnMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.2.1.1.9", currentCommunity, outTime, agentIp, agentPort);
													ColumnMessage cdpCacheCapabilitiesMessage = cdpSearchService.getCdpColumnMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.2.1.1.9", currentCommunity, outTime);
//													ColumnMessage cdpCacheDevicePortMessage = cdpSearchService.getCdpColumnMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.2.1.1.7", currentCommunity, outTime, agentIp, agentPort);
													ColumnMessage cdpCacheDevicePortMessage = cdpSearchService.getCdpColumnMessage(currentIp, currentPort, ".1.3.6.1.4.1.9.9.23.1.2.1.1.7", currentCommunity, outTime);
													for(int j=0;j<cdpCacheAddressMessage.getMessage().length;j++){
														cdpCacheAddress = cdpCacheAddressMessage.getMessage()[j];
														String[] cdpCacheAddressSubs = cdpCacheAddress.split(":");
														String cdpCacheAddressSub1 = cdpCacheAddressSubs[0];
														String cdpCacheAddressSub2 = cdpCacheAddressSubs[1];
														String cdpCacheAddressSub3 = cdpCacheAddressSubs[2];
														String cdpCacheAddressSub4 = cdpCacheAddressSubs[3];
														
												        String cdpCacheAddressO = Long.parseLong(cdpCacheAddressSub1,16)+"."+
												        							Long.parseLong(cdpCacheAddressSub2,16)+"."+
												        							Long.parseLong(cdpCacheAddressSub3,16)+"."+
												        							Long.parseLong(cdpCacheAddressSub4,16);
														if(cdpCacheDevicePortMessage != null && cdpCacheDevicePortMessage.isSuccessful() && cdpCacheDevicePortMessage.getMessage().length>j){
															cdpCacheDevicePort = cdpCacheDevicePortMessage.getMessage()[j];
														}
												        if(!cdpCacheAddressO.equals(node.getParentIpAddr())){
															Node neighbor = new Node();
															neighbor.setParentIpAddr(currentIp);
															neighbor.setAddDate(new Date());
															neighbor.setIpAddr(cdpCacheAddressO);
															neighbor.setLevel(currentSearchDepth);
															neighbor.setNodeType(cdpSearchService.getNodeTypeById(8));
															listener.addSearchMessage(cdpCacheAddress + "\n");
															if(cdpCachePlatformMessage != null && cdpCachePlatformMessage.isSuccessful() && cdpCachePlatformMessage.getMessage().length>j){
																cdpCachePlatform = cdpCachePlatformMessage.getMessage()[j];
																listener.addSearchMessage(cdpCachePlatform + "\n");
															}
															if(cdpCacheCapabilitiesMessage != null && cdpCacheCapabilitiesMessage.isSuccessful() && cdpCacheCapabilitiesMessage.getMessage().length>j){
																cdpCacheCapabilities = cdpCacheCapabilitiesMessage.getMessage()[j];
																listener.addSearchMessage(cdpCacheCapabilities + "\n");
															}
															String[] cdpCacheCapabilitiesSubs = cdpCacheCapabilities.split(":");
															cdpCacheCapabilities = cdpCacheCapabilitiesSubs[cdpCacheCapabilitiesSubs.length-1];
															if(cdpCacheCapabilities.equals("28")){
																neighbor.setNodeType(cdpSearchService.getNodeTypeById(6));
															}else if(cdpCacheCapabilities.equals("29")){
																if(cdpCachePlatform.contains("ws") || cdpCachePlatform.contains("WS")){
																	neighbor.setNodeType(cdpSearchService.getNodeTypeById(2));
																}else{
																	neighbor.setNodeType(cdpSearchService.getNodeTypeById(1));
																}
															}
															neighbor.setSelfInterface(cdpCacheDevicePort);
															listener.addSearchMessage(cdpCacheDevicePort + "\n");
															
															neighborList.add(neighbor);
												        }
													}
													if(node.getNodeType()==null || node.getNodeType().getId()==8){
														Node neighbor1 = neighborList.get(0);
														for(int m=startPort; m<(endPort+1); m++){
															if(this.stopped){
																break;
															}
															for(int n=0; n<communityList.size(); n++){
																if(this.stopped){
																	break;
																}
																String neighbor1cdpCacheAddress = "";
																String neighbor1cdpCachePlatform = "";
																String neighbor1cdpCacheCapabilities = "";
																String neighbor1cdpCacheDevicePort = "";
//																ColumnMessage neighbor1cdpCacheAddressMessage = cdpSearchService.getCdpColumnMessage(neighbor1.getIpAddr(), m, ".1.3.6.1.4.1.9.9.23.1.2.1.1.4", communityList.get(n), outTime, agentIp, agentPort);
																ColumnMessage neighbor1cdpCacheAddressMessage = cdpSearchService.getCdpColumnMessage(neighbor1.getIpAddr(), m, ".1.3.6.1.4.1.9.9.23.1.2.1.1.4", communityList.get(n), outTime);
																if(neighbor1cdpCacheAddressMessage!=null && neighbor1cdpCacheAddressMessage.isSuccessful() && neighbor1cdpCacheAddressMessage.getMessage().length>0){
																	for(int l=0;l<neighbor1cdpCacheAddressMessage.getMessage().length;l++){
																		neighbor1cdpCacheAddress = neighbor1cdpCacheAddressMessage.getMessage()[l];
																		String[] neighbor1cdpCacheAddressSubs = neighbor1cdpCacheAddress.split(":");
																		String neighbor1cdpCacheAddressSub1 = neighbor1cdpCacheAddressSubs[0];
																		String neighbor1cdpCacheAddressSub2 = neighbor1cdpCacheAddressSubs[1];
																		String neighbor1cdpCacheAddressSub3 = neighbor1cdpCacheAddressSubs[2];
																		String neighbor1cdpCacheAddressSub4 = neighbor1cdpCacheAddressSubs[3];
																		
																        String neighbor1cdpCacheAddressO = Long.parseLong(neighbor1cdpCacheAddressSub1,16)+"."+
																        									Long.parseLong(neighbor1cdpCacheAddressSub2,16)+"."+
																        									Long.parseLong(neighbor1cdpCacheAddressSub3,16)+"."+
																        									Long.parseLong(neighbor1cdpCacheAddressSub4,16);
																		listener.addSearchMessage(neighbor1cdpCacheAddress + "\n");
																		if(neighbor1cdpCacheAddressO.equals(currentIp)){
//																			ColumnMessage neighbor1cdpCachePlatformMessage = cdpSearchService.getCdpColumnMessage(neighbor1.getIpAddr(), m, ".1.3.6.1.4.1.9.9.23.1.2.1.1.8", communityList.get(n), outTime, agentIp, agentPort);
																			ColumnMessage neighbor1cdpCachePlatformMessage = cdpSearchService.getCdpColumnMessage(neighbor1.getIpAddr(), m, ".1.3.6.1.4.1.9.9.23.1.2.1.1.8", communityList.get(n), outTime);
//																			ColumnMessage neighbor1cdpCacheCapabilitiesMessage = cdpSearchService.getCdpColumnMessage(neighbor1.getIpAddr(), m, ".1.3.6.1.4.1.9.9.23.1.2.1.1.9", communityList.get(n), outTime, agentIp, agentPort);
																			ColumnMessage neighbor1cdpCacheCapabilitiesMessage = cdpSearchService.getCdpColumnMessage(neighbor1.getIpAddr(), m, ".1.3.6.1.4.1.9.9.23.1.2.1.1.9", communityList.get(n), outTime);
//																			ColumnMessage neighbor1cdpCacheDevicePortMessage = cdpSearchService.getCdpColumnMessage(neighbor1.getIpAddr(), m, ".1.3.6.1.4.1.9.9.23.1.2.1.1.7", communityList.get(n), outTime, agentIp, agentPort);
																			ColumnMessage neighbor1cdpCacheDevicePortMessage = cdpSearchService.getCdpColumnMessage(neighbor1.getIpAddr(), m, ".1.3.6.1.4.1.9.9.23.1.2.1.1.7", communityList.get(n), outTime);

																			if(neighbor1cdpCachePlatformMessage != null && neighbor1cdpCachePlatformMessage.isSuccessful() && neighbor1cdpCachePlatformMessage.getMessage().length>l){
																				neighbor1cdpCachePlatform = neighbor1cdpCachePlatformMessage.getMessage()[l];
																				listener.addSearchMessage(neighbor1cdpCachePlatform + "\n");
																			}
																			if(neighbor1cdpCacheCapabilitiesMessage != null && neighbor1cdpCacheCapabilitiesMessage.isSuccessful() && neighbor1cdpCacheCapabilitiesMessage.getMessage().length>l){
																				neighbor1cdpCacheCapabilities = neighbor1cdpCacheCapabilitiesMessage.getMessage()[l];
																				listener.addSearchMessage(neighbor1cdpCacheCapabilities + "\n");
																			}
																			String[] neighbor1cdpCacheCapabilitiesSubs = neighbor1cdpCacheCapabilities.split(":");
																			neighbor1cdpCacheCapabilities = neighbor1cdpCacheCapabilitiesSubs[neighbor1cdpCacheCapabilitiesSubs.length-1];
																			if(neighbor1cdpCacheCapabilities.equals("28")){
																				node.setNodeType(cdpSearchService.getNodeTypeById(6));
																			}else if(neighbor1cdpCacheCapabilities.equals("29")){
																				if(neighbor1cdpCachePlatform.contains("ws") || neighbor1cdpCachePlatform.contains("WS")){
																					node.setNodeType(cdpSearchService.getNodeTypeById(2));
																				}else{
																					node.setNodeType(cdpSearchService.getNodeTypeById(1));
																				}
																			}
																			if(neighbor1cdpCacheDevicePortMessage != null && neighbor1cdpCacheDevicePortMessage.isSuccessful() && neighbor1cdpCacheDevicePortMessage.getMessage().length>l){
																				neighbor1cdpCacheDevicePort = neighbor1cdpCacheDevicePortMessage.getMessage()[l];
																				node.setSelfInterface(neighbor1cdpCacheDevicePort);
																				listener.addSearchMessage(neighbor1cdpCacheDevicePort + "\n");
																			}
																		}
																	}
																}else{
																	if(node.getNodeType()==null || node.getNodeType().getId()==8){
//																		CommonMessage sysServicesMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.1.7", currentCommunity, outTime, agentIp, agentPort);
																		CommonMessage sysServicesMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.1.7", currentCommunity, outTime);
																		String sysServices = "";
																		if(sysServicesMessage!=null && sysServicesMessage.isSuccessful()){
																			sysServices = sysServicesMessage.getMessage();
																			listener.addSearchMessage(sysServices + "\n");
																		}
//																		CommonMessage ipForwardingMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.4.1", currentCommunity, outTime, agentIp, agentPort);
																		CommonMessage ipForwardingMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.4.1", currentCommunity, outTime);
																		String ipForwarding = "";
																		if(ipForwardingMessage!=null && ipForwardingMessage.isSuccessful()){
																			ipForwarding = ipForwardingMessage.getMessage();
																			listener.addSearchMessage(ipForwarding + "\n");
																		}
																		node.setNodeType(cdpSearchService.getNodeTypeById(8));
																		if(((Integer.parseInt(sysServices)&4) == 4)){
																			if(Integer.parseInt(ipForwarding) == 1){
																				node.setNodeType(cdpSearchService.getNodeTypeById(1));
																			}else if(sysDescr.contains("Hardware: x86")){
																				if(sysDescr.contains("Windows")){
																				}
																				node.setNodeType(cdpSearchService.getNodeTypeById(3));
																			}else{
																				node.setNodeType(cdpSearchService.getNodeTypeById(8));
																			}
																		}
																	}
																}
															}
														}
													}
												}else{
													if(node.getNodeType()==null || node.getNodeType().getId()==8){
//														CommonMessage sysServicesMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.1.7", currentCommunity, outTime, agentIp, agentPort);
														CommonMessage sysServicesMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.1.7", currentCommunity, outTime);
														String sysServices = "";
														if(sysServicesMessage!=null && sysServicesMessage.isSuccessful()){
															sysServices = sysServicesMessage.getMessage();
															listener.addSearchMessage(sysServices + "\n");
														}
//														CommonMessage ipForwardingMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.4.1", currentCommunity, outTime, agentIp, agentPort);
														CommonMessage ipForwardingMessage = cdpSearchService.getCdpMessage(currentIp, currentPort, ".1.3.6.1.2.1.4.1", currentCommunity, outTime);
														String ipForwarding = "";
														if(ipForwardingMessage!=null && ipForwardingMessage.isSuccessful()){
															ipForwarding = ipForwardingMessage.getMessage();
															listener.addSearchMessage(ipForwarding + "\n");
														}
														node.setNodeType(cdpSearchService.getNodeTypeById(8));
														if(((Integer.parseInt(sysServices)&4) == 4)){
															if(Integer.parseInt(ipForwarding) == 1){
																node.setNodeType(cdpSearchService.getNodeTypeById(1));
															}else if(sysDescr.contains("Hardware: x86")){
																if(sysDescr.contains("Windows")){
																}
																node.setNodeType(cdpSearchService.getNodeTypeById(3));
															}else{
																node.setNodeType(cdpSearchService.getNodeTypeById(8));
															}
														}
													}
												}
												listener.addSearchMessage("\n=================================\n\n");
												boolean ifHadAddThisNode = false;
												for(Node hadDisNode : nodeList){
													if(ifHadAddThisNode){
														break;
													}else{
//														if(node.getIpAddr().equals(hadDisNode.getIpAddr()) 
//																&& node.getSelfInterface().equals(hadDisNode.getSelfInterface())){
														if(node.getIpAddr().equals(hadDisNode.getIpAddr())){
															ifHadAddThisNode = true;
														}else{
															ifHadAddThisNode = false;
														}
													}
												}
												if(!ifHadAddThisNode){
													nodeList.add(node);
												}
												this.setNodeList(nodeList);
												Node selfNode = null;
												for(Node discoveredNode : nodeList){
													if(discoveredNode.getIpAddr().equals(node.getParentIpAddr())){
														if(discoveredNode.getSelfInterface()!=null && node.getNeighborInterface()!=null){
															if(discoveredNode.getNeighborInterface()!=null && node.getSelfInterface()!=null){
																if(discoveredNode.getSelfInterface().equals(node.getNeighborInterface()) && discoveredNode.getNeighborInterface().equals(node.getSelfInterface())){
																	selfNode = discoveredNode;
																}
															}else{
																if(discoveredNode.getSelfInterface().equals(node.getNeighborInterface())){
																	selfNode = discoveredNode;
																}
															}
														}else{
															if(discoveredNode.getNeighborInterface()!=null && node.getSelfInterface()!=null){
																if(discoveredNode.getNeighborInterface().equals(node.getSelfInterface())){
																	selfNode = discoveredNode;
																}
															}else{
																selfNode = discoveredNode;
															}
														}
													}
												}
												Node destNode = node;
												if(selfNode!=null){
													boolean iIM = true;
													if(lineList!=null || lineList.size()>0){
														for(Line hl:lineList){
															if(hl.getNodeSelf().getIpAddr().equals(selfNode.getIpAddr()) && hl.getNodeDest().getIpAddr().equals(destNode.getIpAddr())){
																iIM = false;
																break;
															}
															if(hl.getNodeSelf().getIpAddr().equals(destNode.getIpAddr()) && hl.getNodeDest().getIpAddr().equals(selfNode.getIpAddr())){
																iIM = false;
																break;
															}
														}
													}
													if(iIM){
														Line line = new Line();
														line.setAddDate(new Date());
														line.setNodeSelf(selfNode);
														line.setNodeDest(destNode);
														lineList.add(line);
														this.setLineList(lineList);
													}
												}
												isFindValidCommunity = true;
												isFindValidPort = true;
											}else{
												break;
											}
											int numerator = 0;
											int denominator = 1;
											numerator = (k+1) + (c*tryNum) + ((p-startPort)*communityList.size()*tryNum) + (i*(endPort-startPort+1)*communityList.size()*tryNum);
											denominator = (searchDepth+1) * (endPort-startPort+1) * communityList.size() * tryNum;
											int percent = (numerator*100)/denominator;
											listener.reloadPercentBar(percent);
										}
									}
								}
							}
						}
						neighborNodeList = neighborList;
					}
					map.put("nodeList", nodeList);
					
					map.put("lineList", lineList);
					this.setMap(map);
					globalEndTime = System.currentTimeMillis();
					globalAllTime = (globalEndTime - globalStartTime)/1000;
					globalCDPGetMessage = "本次搜索正常结束：\n开始时间：" + new Date(globalStartTime) + "\n" + "结束时间：" + new Date(globalEndTime) + "\n" + "共耗时：" + globalAllTime + " 秒\n共发现" + nodeList.size() + "个节点，" + lineList.size() + "条连接。";
					listener.reloadPercentBar(100);
					listener.addSearchMessage(globalCDPGetMessage);
					log = new SystemLog();
//					log.setUsername(cdpAppletForm.getUserName());
//					log.setRoleName(cdpAppletForm.getRoleName());
					log.setTime(new Timestamp(new Date().getTime()));
					log.setModuleName(SystemModelInfo.MOD_TM_discover);
					log.setOperationDesc("进行基于CDP的拓扑发现，共发现" + nodeList.size() + "个节点，" + lineList.size() + "条连接。");
					log.setControl("成功");
//					log.setUsername(cdpAppletForm.getUserName());
//					log.setRoleName(cdpAppletForm.getRoleName());
//					log.setTime(new Date());
//					log.setModuleName(SystemLogContants.TOPO_MOD);
//					log.setOperationDesc("进行基于CDP的拓扑发现，共发现" + nodeList.size() + "个节点，" + lineList.size() + "条连接。");
//					log.setControl("成功");
					cdpSearchService.writeToSysLog(log, cdpAppletForm.getUserId());
					try{
						cdpSearchService.stoppedSearch();
					}catch(Exception e){
						stopped(true);
					}
					listener.onSearchFinished(map);
				}else{
					listener.canSearch(true);
					throw new Exception("有人正在搜索！");
				}
			}catch(Exception e){
				log = new SystemLog();
//				log.setUsername(cdpAppletForm.getUserName());
//				log.setRoleName(cdpAppletForm.getRoleName());
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_TM_discover);
				log.setOperationDesc("进行基于CDP的拓扑发现。");
				log.setControl("失败");
//				log.setUsername(cdpAppletForm.getUserName());
//				log.setRoleName(cdpAppletForm.getRoleName());
//				log.setTime(new Date());
//				log.setModuleName(SystemLogContants.TOPO_MOD);
//				log.setOperationDesc("进行基于CDP的拓扑发现。");
//				log.setControl("失败");
				cdpSearchService.writeToSysLog(log, cdpAppletForm.getUserId());
				listener.doSearchError("搜索过程出错，请重新操作！");
				e.printStackTrace();
			}
			this.stopped = true;
			this.running = false;
		}else{
			log = new SystemLog();
//			log.setUsername(cdpAppletForm.getUserName());
//			log.setRoleName(cdpAppletForm.getRoleName());
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_TM_discover);
			log.setOperationDesc("进行基于CDP的拓扑发现。");
			log.setControl("失败");
//			log.setUsername(cdpAppletForm.getUserName());
//			log.setRoleName(cdpAppletForm.getRoleName());
//			log.setTime(new Date());
//			log.setModuleName(SystemLogContants.TOPO_MOD);
//			log.setOperationDesc("进行基于CDP的拓扑发现。");
//			log.setControl("失败");
			cdpSearchService.writeToSysLog(log, cdpAppletForm.getUserId());
		}
	}

	/**
	 * 保存节点list
	 */
	public void addNodeList(Map<String,List> map) {
		try{
			if(cdpSearchService!=null){
				try{
					cdpSearchService.addNodeList(map.get("nodeList"));
					cdpSearchService.addLineList(map.get("lineList"));
					log = new SystemLog();
//					log.setUsername(cdpAppletForm.getUserName());
//					log.setRoleName(cdpAppletForm.getRoleName());
					log.setTime(new Timestamp(new Date().getTime()));
					log.setModuleName(SystemModelInfo.MOD_TM_discover);
					log.setOperationDesc("进行基于CDP的拓扑发现后，保存选中节点，共保存了" + map.get("nodeList").size() + "个节点。");
					log.setControl("成功");
//					log.setUsername(cdpAppletForm.getUserName());
//					log.setRoleName(cdpAppletForm.getRoleName());
//					log.setTime(new Date());
//					log.setModuleName(SystemLogContants.TOPO_MOD);
//					log.setOperationDesc("进行基于CDP的拓扑发现后，保存选中节点，共保存了" + map.get("nodeList").size() + "个节点。");
//					log.setControl("成功");
					cdpSearchService.writeToSysLog(log, cdpAppletForm.getUserId());
					listener.saveDBSuccessed(true);
				}catch(Exception e1){
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					throw new Exception("远程服务cdpSearchService.addNodeList保存节点出错！");
				}
			}else{
				listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
				throw new Exception("未能获取远程服务cdpSearchService！");
			}
		}catch(Exception e){
			log = new SystemLog();
//			log.setUsername(cdpAppletForm.getUserName());
//			log.setRoleName(cdpAppletForm.getRoleName());
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_TM_discover);
			log.setOperationDesc("进行基于CDP的拓扑发现后，保存选中节点。");
			log.setControl("失败");
//			log.setUsername(cdpAppletForm.getUserName());
//			log.setRoleName(cdpAppletForm.getRoleName());
//			log.setTime(new Date());
//			log.setModuleName(SystemLogContants.TOPO_MOD);
//			log.setOperationDesc("进行基于CDP的拓扑发现后，保存选中节点。");
//			log.setControl("失败");
			cdpSearchService.writeToSysLog(log, cdpAppletForm.getUserId());
			listener.saveDBSuccessed(false);
			e.printStackTrace();
		}
	}
}
