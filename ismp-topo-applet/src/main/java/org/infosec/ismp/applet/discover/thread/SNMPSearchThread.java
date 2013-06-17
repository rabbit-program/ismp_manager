package org.infosec.ismp.applet.discover.thread;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.applet.comm.util.HttpInvokerProxyFactoryBeanUtil;
import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.applet.discover.listener.SearchListener;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.SNMPAppletForm;
import org.infosec.ismp.manager.rmi.tm.discover.model.typeSense.DeviceTypeRuler;
import org.infosec.ismp.manager.rmi.tm.discover.service.applet.SNMPSearchService;
/**
 * SNMP搜索线程类
 * @author Wu Guojie
 * @date 2009-6-11
 * @version 1.0
 */
public class SNMPSearchThread extends Thread {
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
	 * 结果list
	 */
	List<Node> list = new ArrayList<Node>();
	/**
	 * 创建snmpSearchService
	 */
	SNMPSearchService snmpSearchService = getSNMPSearchService();
	/**
	 * 远程获取snmpSearchService
	 * @return SNMPSearchService实例
	 */
	public SNMPSearchService getSNMPSearchService(){
		try{
			SNMPSearchService service = (SNMPSearchService)HttpInvokerProxyFactoryBeanUtil
			.getService(ServerConfig.getServerPath()+"/remoting/snmpSearchServiceRemoting", SNMPSearchService.class);
			
			return service;
		}catch(Exception e){
			listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
			return null;
		}
	}
	/**
	 * snmpAppletForm
	 */
	private SNMPAppletForm snmpAppletForm = null;
	/**
	 * 搜索监听器
	 */
	private SearchListener listener = null;
	
	/**
	 * 构造器
	 * @param snmpAppletForm
	 * snmpAppletForm
	 * @param listener
	 * 搜索监听器
	 */
	public SNMPSearchThread(SNMPAppletForm snmpAppletForm, SearchListener listener){
		this.snmpAppletForm = snmpAppletForm;
		this.listener = listener;
	}
	
	/**
	 * 停止
	 */
	public void stopped(boolean silent){
		try{
			if(snmpSearchService!=null){
				try{
					snmpSearchService.stoppedSearch();
					stopped = true;
				}catch(Exception e1){
					if (!silent) {
						listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					}
					throw new Exception("远程服务snmpSearchService.stoppedSearch不可用！");
				}
			}else{
				if (!silent) {
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
				}
				throw new Exception("未能获取远程服务snmpSearchService！");
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
	 * 获取结果list
	 * @return 结果list
	 */
	public List<Node> getList(){
		return this.list;
	}
	
	/**
	 * set 结果list
	 * @param list
	 * 结果list
	 */
	public void setList(List<Node> list) {
		this.list = list;
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
			 * 全局snmp获取结果
			 */
			String globalSNMPGetMessage = "";

			/**
			 * 开始IP
			 */
			String startIP = "0.0.0.0";
			/**
			 * 结束IP
			 */
			String endIP = "0.0.0.0";
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
			 * 尝试次数
			 */
			int tryNum = 0;
			/**
			 * 超时时间
			 */
			int outTime = 0;
			/**
			 * 设备类型匹配规则名list
			 */
			List<String> nameList = new ArrayList<String>();
			/**
			 * 设备类型匹配规则list
			 */
	        List<List<DeviceTypeRuler>> deviceRulersList= new ArrayList<List<DeviceTypeRuler>>();
			/**
			 * agent IP
			 */
			String agentIp;
			/**
			 * agent 端口
			 */
			int agentPort;
			/*
			AgentBO agentBO = new AgentBO();
			agentBO.setId(1);
			agentBO.setIpAddr("127.0.0.1");
			agentBO.setPort(20081);
			snmpAppletForm.setAgentBO(agentBO);
*/

			
			try{
				if(snmpSearchService==null){
					listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
					throw new Exception("未能获取远程服务snmpSearchService！");
				}
				boolean canStart = false;
				try{
					canStart = snmpSearchService.startSearch();
				}catch(Exception e){
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					throw new Exception("远程服务snmpSearchService.startSearch不可用！");
				}
				if(canStart){
					nameList = snmpSearchService.findAllDeviceTypeRulerName();
					if(nameList!=null && nameList.size()!=0){
						for(String name : nameList){
							List<DeviceTypeRuler> deviceTypeRulerList= new ArrayList<DeviceTypeRuler>();
							deviceTypeRulerList = snmpSearchService.findAllDeviceTypeRulersByName(name);
							deviceRulersList.add(deviceTypeRulerList);
						}
					}else{
//						throw new Exception("SNMP搜索型别侦测库为空！");
					}
					
					if(snmpAppletForm!=null){
						if(snmpAppletForm.getStartIP()!=null && !snmpAppletForm.getStartIP().equals("")){
							startIP = snmpAppletForm.getStartIP();
						}else{
							listener.inputError("SNMP搜索参数中未传入StartIP！");
							throw new Exception("SNMP搜索参数中未传入StartIP！");
						}
						if(snmpAppletForm.getEndIP()!=null && !snmpAppletForm.getEndIP().equals("")){
							endIP = snmpAppletForm.getEndIP();
						}else{
							listener.inputError("SNMP搜索参数中未传入EndIP！");
							throw new Exception("SNMP搜索参数中未传入EndIP！");
						}
						startPort = snmpAppletForm.getStartPort();
						endPort = snmpAppletForm.getEndPort();
						if(snmpAppletForm.getCommunityList()!=null && snmpAppletForm.getCommunityList().size()!=0){
							communityList = snmpAppletForm.getCommunityList();
						}else{
							listener.inputError("SNMP搜索参数中未传入团体名！");
							throw new Exception("SNMP搜索参数中未传入团体名！");
						}
						tryNum = snmpAppletForm.getTryNum();
						outTime = snmpAppletForm.getOutTime()*1000;
//						if(snmpAppletForm.getAgentBO()!=null){
//							if(snmpAppletForm.getAgentBO().getIpAddr()!=null && !snmpAppletForm.getAgentBO().getIpAddr().equals("")){
//								agentIp = snmpAppletForm.getAgentBO().getIpAddr();
//							}else{
//								listener.inputError("SNMP搜索参数中未传入获取参数的Agent的IP地址！");
//								throw new Exception("SNMP搜索参数中未传入获取参数的Agent的IP地址！");
//							}
//							if(snmpAppletForm.getAgentBO().getPort()!=null){
//								agentPort = snmpAppletForm.getAgentBO().getPort();
//							}else{
//								listener.inputError("SNMP搜索参数中未传入获取参数的Agent的端口！");
//								throw new Exception("SNMP搜索参数中未传入获取参数的Agent的端口！");
//							}
//						}else{
//							listener.inputError("SNMP搜索参数中未传入获取参数的Agent！");
//							throw new Exception("SNMP搜索参数中未传入获取参数的Agent！");
//						}
					}else{
						listener.inputError("SNMP搜索参数未传入！");
						throw new Exception("SNMP搜索参数未传入！");
					}
					/**
					 * 开始IP分割成数组
					 */
					String[] startIPSubs = startIP.split("\\.");
					/**
					 * 结束IP分割成数组
					 */
					String[] endIPSubs = endIP.split("\\.");
					
					if(startIPSubs.length!=4){
						listener.inputError("SNMP搜索参数startIP格式不对！");
						throw new Exception("SNMP搜索参数startIP格式不对！");
					}else{
						if(!(startIPSubs[0].matches("\\d{1,3}"))){
							listener.inputError("SNMP搜索参数startIP第一段格式不对！");
							throw new Exception("SNMP搜索参数startIP第一段格式不对！");
						}
						if(!(startIPSubs[1].matches("\\d{1,3}"))){
							listener.inputError("SNMP搜索参数startIP第二段格式不对！");
							throw new Exception("SNMP搜索参数startIP第二段格式不对！");
						}
						if(!(startIPSubs[2].matches("\\d{1,3}"))){
							listener.inputError("SNMP搜索参数startIP第三段格式不对！");
							throw new Exception("SNMP搜索参数startIP第三段格式不对！");
						}
						if(!(startIPSubs[3].matches("\\d{1,3}"))){
							listener.inputError("SNMP搜索参数startIP第四段格式不对！");
							throw new Exception("SNMP搜索参数startIP第四段格式不对！");
						}
					}
					if(endIPSubs.length!=4){
						listener.inputError("SNMP搜索参数endIP格式不对！");
						throw new Exception("SNMP搜索参数endIP格式不对！");
					}else{
						if(!(endIPSubs[0].matches("\\d{1,3}"))){
							listener.inputError("SNMP搜索参数endIP第一段格式不对！");
							throw new Exception("SNMP搜索参数endIP第一段格式不对！");
						}
						if(!(endIPSubs[1].matches("\\d{1,3}"))){
							listener.inputError("SNMP搜索参数endIP第二段格式不对！");
							throw new Exception("SNMP搜索参数endIP第二段格式不对！");
						}
						if(!(endIPSubs[2].matches("\\d{1,3}"))){
							listener.inputError("SNMP搜索参数endIP第三段格式不对！");
							throw new Exception("SNMP搜索参数endIP第三段格式不对！");
						}
						if(!(endIPSubs[3].matches("\\d{1,3}"))){
							listener.inputError("SNMP搜索参数endIP第四段格式不对！");
							throw new Exception("SNMP搜索参数endIP第四段格式不对！");
						}
					}
			        //开始IP的四段
			        int s1 = Integer.parseInt(startIPSubs[0]);
			        int s2 = Integer.parseInt(startIPSubs[1]);
			        int s3 = Integer.parseInt(startIPSubs[2]);
			        int s4 = Integer.parseInt(startIPSubs[3]);
			        //结束IP的四段
			        int e1 = Integer.parseInt(endIPSubs[0]);
			        int e2 = Integer.parseInt(endIPSubs[1]);
			        int e3 = Integer.parseInt(endIPSubs[2]);
			        int e4 = Integer.parseInt(endIPSubs[3]);
			        
			        //开始IP的四段十六进制
			        String s1H = Integer.toHexString(s1);
			        if(s1H.length()==1){s1H="0"+s1H;}
			        String s2H = Integer.toHexString(s2);
			        if(s2H.length()==1){s2H="0"+s2H;}
			        String s3H = Integer.toHexString(s3);
			        if(s3H.length()==1){s3H="0"+s3H;}
			        String s4H = Integer.toHexString(s4);
			        if(s4H.length()==1){s4H="0"+s4H;}
			        //结束IP的四段十六进制
			        String e1H = Integer.toHexString(e1);
			        if(e1H.length()==1){e1H="0"+e1H;}
			        String e2H = Integer.toHexString(e2);
			        if(e2H.length()==1){e2H="0"+e2H;}
			        String e3H = Integer.toHexString(e3);
			        if(e3H.length()==1){e3H="0"+e3H;}
			        String e4H = Integer.toHexString(e4);
			        if(e4H.length()==1){e4H="0"+e4H;}
			        
			        //十六进制IP
			        String startIPH = s1H+s2H+s3H+s4H;
			        String endIPH = e1H+e2H+e3H+e4H;
			        
			        //十进制IP
			        long startIPO = Long.parseLong(startIPH,16);
			        long endIPO = Long.parseLong(endIPH,16);
			        
			        int ip1 = s1;
			        int ip2 = s2;
			        int ip3 = s3;
			        int ip4 = s4;
			        for(int i=0; i<=(endIPO-startIPO); i++){
			            String currentIp = ip1+"."+ip2+"."+ip3+"."+ip4;
			            
						if(this.stopped){
							listener.addSearchMessage("您终止了当前搜索！"+"\n");
							break;
						}
						boolean isFindValidPort = false;
						for(int p=startPort; p<(endPort+1); p++){
							if(this.stopped){
								break;
							}
							if(isFindValidPort){
								break;
							}
							boolean isFindValidCommunity = false;
							for(int c=0; c<communityList.size(); c++){
								if(this.stopped){
									break;
								}
								if(isFindValidCommunity){
									break;
								}
								String currentCommunity = communityList.get(c);
								/**
								 * 该IP的snmp消息
								 */
								String snmpGetMessage = "";
								/**
								 * snmp消息获取时间
								 */
								String searchTimen = "";
								/**
								 * snmp消息获取返回的结果
								 */
//								Map<String, String> snmpGetReturn = null;
								
								for(int k=0; k<tryNum; k++){
									if(this.stopped){
										break;
									}
									/**
									 * 本次snmpGet的时间
									 */
									double thisAllTime = 0l;
									/**
									 * 本次snmpGet的消息
									 */
									String thisSNMPGetMessage = "";
									String sysDescr = "";
									
									listener.addSearchMessage("\n=================================\nGet from "+currentIp+" : "+p+"\n=================================\n");
//									Map<String, String> snmpGetReturnSysDescr = snmpSearchService.getSnmpMessage(currentIp, p, ".1.3.6.1.2.1.1.1", currentCommunity, outTime, agentIp, agentPort);
									Map<String, String> snmpGetReturnSysDescr = snmpSearchService.getSnmpMessage(currentIp, p, ".1.3.6.1.2.1.1.1", currentCommunity, outTime);
									if(snmpGetReturnSysDescr != null){
										sysDescr = snmpGetReturnSysDescr.get("snmpGetMessage");
										thisSNMPGetMessage = sysDescr;
										thisAllTime = Double.parseDouble(snmpGetReturnSysDescr.get("snmpGetTime"));
										if(thisAllTime>0.001){
											searchTimen = thisAllTime+" 秒";
										}else{
											searchTimen = "小于1 毫秒";
										}
									}
									thisSNMPGetMessage = thisSNMPGetMessage + "\n" + "耗时：" + searchTimen + "\n" + "**********************" + "\n";
									listener.addSearchMessage(thisSNMPGetMessage+"\n\n");
									
//									snmpGetMessage = thisSNMPGetMessage;
									if(!sysDescr.contains("Failed")){
										listener.addSearchMessage("\n发现一个节点，下面进行型别侦测：\n");
										/**
										 * 发现并创建节点，且为其赋值
										 */
										Node node = new Node();
										node.setName("node:" + currentIp);
										node.setIpAddr(currentIp);
										node.setPort(p);
										node.setCommunity(currentCommunity);
										node.setSearchTime(thisAllTime+"");
										node.setNodeType(snmpSearchService.getNodeTypeById(8));
										node.setTryNum(k+1);
										
										boolean isMatchSuccess = false;
										for(List<DeviceTypeRuler> deviceTypeRulerList : deviceRulersList){
											boolean isThisType = false;
											NodeType nodeType = new NodeType();
											for(DeviceTypeRuler deviceTypeRuler : deviceTypeRulerList){
//												Map<String, String> snmpGetReturnByDeviceTypeRuler = snmpSearchService.getSnmpMessage(currentIp, p, deviceTypeRuler.getOid(), currentCommunity, outTime, agentIp, agentPort);
												Map<String, String> snmpGetReturnByDeviceTypeRuler = snmpSearchService.getSnmpMessage(currentIp, p, deviceTypeRuler.getOid(), currentCommunity, outTime);
												String thisSNMPGetMessageByDeviceTypeRuler = "";
												if(snmpGetReturnSysDescr != null){
													thisSNMPGetMessageByDeviceTypeRuler = snmpGetReturnByDeviceTypeRuler.get("snmpGetMessage");
													listener.addSearchMessage(thisSNMPGetMessageByDeviceTypeRuler+"\n");
												}
												if(thisSNMPGetMessageByDeviceTypeRuler.contains(deviceTypeRuler.getKeyChars())){
													isThisType = true;
													nodeType = deviceTypeRuler.getNodeType();
												}else{
													isThisType = false;
                                                    break;
												}
											}
											if(isThisType){
												node.setNodeType(nodeType);
												node.setDescription((nodeType.getDescription()==null)?"":nodeType.getDescription());
												isMatchSuccess = true;
												break;
											}else{
												isMatchSuccess = false;
											}
										}
										if(!isMatchSuccess){
//											Map<String, String> snmpGetReturnSysServices = snmpSearchService.getSnmpMessage(currentIp, p, ".1.3.6.1.2.1.1.7", currentCommunity, outTime, agentIp, agentPort);
											Map<String, String> snmpGetReturnSysServices = snmpSearchService.getSnmpMessage(currentIp, p, ".1.3.6.1.2.1.1.7", currentCommunity, outTime);
											String sysServices = "";
											if(snmpGetReturnSysServices != null){
												sysServices = snmpGetReturnSysServices.get("snmpGetMessage");
												listener.addSearchMessage(sysServices+"\n");
											}
//											Map<String, String> snmpGetReturnIpForwarding = snmpSearchService.getSnmpMessage(currentIp, p, ".1.3.6.1.2.1.4.1", currentCommunity, outTime, agentIp, agentPort);
											Map<String, String> snmpGetReturnIpForwarding = snmpSearchService.getSnmpMessage(currentIp, p, ".1.3.6.1.2.1.4.1", currentCommunity, outTime);
											String ipForwarding = "";
											if(snmpGetReturnIpForwarding != null){
												ipForwarding = snmpGetReturnIpForwarding.get("snmpGetMessage");
												listener.addSearchMessage(ipForwarding+"\n");
											}
											
											if(((Integer.parseInt(sysServices)&4) == 4)){
												node.setDescription("提供三层服务");
												if(Integer.parseInt(ipForwarding) == 1){
													node.setDescription(node.getDescription()+"，具有转发功能");
													node.setNodeType(snmpSearchService.getNodeTypeById(1));
												}else if(sysDescr.contains("Hardware: x86")){
													if(sysDescr.contains("Windows")){
														node.setDescription(node.getDescription()+"，Windows System");
													}
													node.setNodeType(snmpSearchService.getNodeTypeById(3));
												}else{
													node.setDescription(node.getDescription()+"，Routing Switch或其他提供三层服务的设备");
													node.setNodeType(snmpSearchService.getNodeTypeById(8));
												}
											}
										}
										list.add(node);
										this.setList(list);
										isFindValidCommunity = true;
										isFindValidPort = true;
										break;
									}
								}
								
								globalEndTime = System.currentTimeMillis();
								
								Long ipNum = endIPO-startIPO+1;
								int percent = ((i+1)*100)/ipNum.intValue();
								listener.reloadPercentBar(percent);
							}
						}
			            
			            
			            
			            ip4 = ip4+1;
			            if(ip4 > 255){
			                ip3 = ip3+1;
			                ip4 = 0;
			            }
			            if(ip3 > 255){
			                ip2 = ip2+1;
			                ip3 = 0;
			            }
			            if(ip2 > 255){
			                ip1 = ip1+1;
			                ip2 = 0;
			            }
			            if(ip1 > 255){
			                break;
			            }
			        }
					
					globalAllTime = (globalEndTime - globalStartTime)/1000;
					globalSNMPGetMessage = "本次搜索正常结束：\n开始时间：" + new Date(globalStartTime) + "\n" + "结束时间：" + new Date(globalEndTime) + "\n" + "共耗时：" + globalAllTime + " 秒\n共发现" + list.size() + "个节点。";
					
					listener.addSearchMessage(globalSNMPGetMessage);
					log = new SystemLog();
//					log.setUsername(snmpAppletForm.getUserName());
//					log.setRoleName(snmpAppletForm.getRoleName());
					log.setTime(new Timestamp(new Date().getTime()));
					log.setModuleName(SystemModelInfo.MOD_TM_discover);
					log.setOperationDesc("进行基于SNMP的拓扑发现，共发现" + list.size() + "个节点。");
					log.setControl("成功");
//					log.setUsername(snmpAppletForm.getUserName());
//					log.setRoleName(snmpAppletForm.getRoleName());
//					log.setTime(new Date());
//					log.setModuleName(SystemLogContants.TOPO_MOD);
//					log.setOperationDesc("进行基于SNMP的拓扑发现，共发现" + list.size() + "个节点。");
//					log.setControl("成功");
					snmpSearchService.writeToSysLog(log, snmpAppletForm.getUserId());
					try{
						snmpSearchService.stoppedSearch();
					}catch(Exception e){
						stopped(true);
					}
					listener.onSearchFinished(list);
				}else{
					listener.canSearch(true);
					throw new Exception("有人正在搜索！");
				}
			}catch(Exception e){
				log = new SystemLog();
//				log.setUsername(snmpAppletForm.getUserName());
//				log.setRoleName(snmpAppletForm.getRoleName());
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_TM_discover);
				log.setOperationDesc("进行基于SNMP的拓扑发现。");
				log.setControl("失败");
//				log.setUsername(snmpAppletForm.getUserName());
//				log.setRoleName(snmpAppletForm.getRoleName());
//				log.setTime(new Date());
//				log.setModuleName(SystemLogContants.TOPO_MOD);
//				log.setOperationDesc("进行基于SNMP的拓扑发现。");
//				log.setControl("失败");
				snmpSearchService.writeToSysLog(log, snmpAppletForm.getUserId());
				listener.doSearchError("搜索过程出错，请重新操作！");
				e.printStackTrace();
			}
			this.stopped = true;
			this.running = false;
		}else{
			log = new SystemLog();
//			log.setUsername(snmpAppletForm.getUserName());
//			log.setRoleName(snmpAppletForm.getRoleName());
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_TM_discover);
			log.setOperationDesc("进行基于SNMP的拓扑发现。");
			log.setControl("失败");
//			log.setUsername(snmpAppletForm.getUserName());
//			log.setRoleName(snmpAppletForm.getRoleName());
//			log.setTime(new Date());
//			log.setModuleName(SystemLogContants.TOPO_MOD);
//			log.setOperationDesc("进行基于SNMP的拓扑发现。");
//			log.setControl("失败");
			snmpSearchService.writeToSysLog(log, snmpAppletForm.getUserId());
		}
	}

	/**
	 * 保存节点list
	 */
	public void addNodeList(List<Node> list) {
		try{
			if(snmpSearchService!=null){
				try{
					snmpSearchService.addNodeList(list);
					log = new SystemLog();
//					log.setUsername(snmpAppletForm.getUserName());
//					log.setRoleName(snmpAppletForm.getRoleName());
					log.setTime(new Timestamp(new Date().getTime()));
					log.setModuleName(SystemModelInfo.MOD_TM_discover);
					log.setOperationDesc("进行基于SNMP的拓扑发现后，保存选中节点，共保存了" + list.size() + "个节点。");
					log.setControl("成功");
//					log.setUsername(snmpAppletForm.getUserName());
//					log.setRoleName(snmpAppletForm.getRoleName());
//					log.setTime(new Date());
//					log.setModuleName(SystemLogContants.TOPO_MOD);
//					log.setOperationDesc("进行基于SNMP的拓扑发现后，保存选中节点，共保存了" + list.size() + "个节点。");
//					log.setControl("成功");
					snmpSearchService.writeToSysLog(log, snmpAppletForm.getUserId());
					listener.saveDBSuccessed(true);
				}catch(Exception e1){
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					throw new Exception("远程服务snmpSearchService.addNodeList保存节点出错！");
				}
			}else{
				listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
				throw new Exception("未能获取远程服务snmpSearchService！");
			}
		}catch(Exception e){
			log = new SystemLog();
//			log.setUsername(snmpAppletForm.getUserName());
//			log.setRoleName(snmpAppletForm.getRoleName());
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_TM_discover);
			log.setOperationDesc("进行基于SNMP的拓扑发现后，保存选中节点。");
			log.setControl("失败");
//			log.setUsername(snmpAppletForm.getUserName());
//			log.setRoleName(snmpAppletForm.getRoleName());
//			log.setTime(new Date());
//			log.setModuleName(SystemLogContants.TOPO_MOD);
//			log.setOperationDesc("进行基于SNMP的拓扑发现后，保存选中节点。");
//			log.setControl("失败");
			snmpSearchService.writeToSysLog(log, snmpAppletForm.getUserId());
			listener.saveDBSuccessed(false);
			e.printStackTrace();
		}
	}
}
