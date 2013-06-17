package org.infosec.ismp.applet.discover.thread;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.applet.comm.util.HttpInvokerProxyFactoryBeanUtil;
import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.applet.discover.listener.SearchListener;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.PCAppletForm;
import org.infosec.ismp.manager.rmi.tm.discover.service.applet.PCSearchService;

/**
 * PC搜索线程类
 * @author Wu Guojie
 * @date 2009-6-11
 * @version 1.0
 */
public class PCSearchThread extends Thread {
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
	 * 创建pcSearchService
	 */
	PCSearchService pcSearchService = getPCSearchService();

	/**
	 * 远程获取pcSearchService
	 * 
	 * @return PCSearchService实例
	 */
	public PCSearchService getPCSearchService() {
		try {
			PCSearchService service = (PCSearchService) HttpInvokerProxyFactoryBeanUtil
					.getService(ServerConfig.getServerPath()
							+ "/remoting/pcSearchServiceRemoting",
							PCSearchService.class);

			return service;
		} catch (Exception e) {
			listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * pcAppletForm
	 */
	private PCAppletForm pcAppletForm = null;
	/**
	 * 搜索监听器
	 */
	private SearchListener listener = null;

	/**
	 * 构造器
	 * 
	 * @param pcAppletForm
	 *            pcAppletForm
	 * @param listener
	 *            搜索监听器
	 */
	public PCSearchThread(PCAppletForm pcAppletForm,
			SearchListener listener) {
		this.pcAppletForm = pcAppletForm;
		this.listener = listener;
	}

	/**
	 * 停止
	 */
	public void stopped(boolean silent) {
		try {
			if (pcSearchService != null) {
				try {
					pcSearchService.stoppedSearch();
					stopped = true;
				} catch (Exception e1) {
					if (!silent) {
						listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					}
					throw new Exception("远程服务pcSearchService.stoppedSearch不可用！");
				}
			} else {
				if (!silent) {
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
				}
				throw new Exception("未能获取远程服务pcSearchService！");
			}
		} catch (Exception e) {
			listener.remoteServiceExecuteError("停止失败，请重试！");
			e.printStackTrace();
		}
	}

	/**
	 * 是否停止
	 * 
	 * @return 是否停止
	 */
	public boolean isStopped() {
		return stopped;
	}

	/**
	 * 是否在运行
	 * 
	 * @return 是否在运行
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * 获取结果list
	 * 
	 * @return 结果list
	 */
	public List<Node> getList() {
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
	public void run() {
		if (!this.running) {
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
			 * 全局搜索结果
			 */
			String globalSearchMessage = "";

			/**
			 * 开始IP
			 */
			String startIP = "0.0.0.0";
			/**
			 * 结束IP
			 */
			String endIP = "0.0.0.0";
			/**
			 * agent IP
			 */
			String agentIp;
			/**
			 * agent 端口
			 */
			int agentPort;
	        

			try {
				if (pcSearchService == null) {
					listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
					throw new Exception("未能获取远程服务pcSearchService！");
				}
				boolean canStart = false;
				try {
					canStart = pcSearchService.startSearch();
				} catch (Exception e) {
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					throw new Exception("远程服务pcSearchService.startSearch不可用！");
				}
				if (canStart) {
					if (pcAppletForm != null) {
						if(pcAppletForm.getStartIP()!=null && !pcAppletForm.getStartIP().equals("")){
							startIP = pcAppletForm.getStartIP();
						}else{
							listener.inputError("受管PC搜索参数中未传入StartIP！");
							throw new Exception("受管PC搜索参数中未传入StartIP！");
						}
						if(pcAppletForm.getEndIP()!=null && !pcAppletForm.getEndIP().equals("")){
							endIP = pcAppletForm.getEndIP();
						}else{
							listener.inputError("受管PC搜索参数中未传入EndIP！");
							throw new Exception("受管PC搜索参数中未传入EndIP！");
						}
//						if(pcAppletForm.getAgentBO()!=null){
//							if(pcAppletForm.getAgentBO().getIpAddr()!=null && !pcAppletForm.getAgentBO().getIpAddr().equals("")){
//								agentIp = pcAppletForm.getAgentBO().getIpAddr();
//							}else{
//								listener.inputError("受管PC搜索参数中未传入获取参数的Agent的IP地址！");
//								throw new Exception("受管PC搜索参数中未传入获取参数的Agent的IP地址！");
//							}
//							if(pcAppletForm.getAgentBO().getPort()!=null){
//								agentPort = pcAppletForm.getAgentBO().getPort();
//							}else{
//								listener.inputError("受管PC搜索参数中未传入获取参数的Agent的端口！");
//								throw new Exception("受管PC搜索参数中未传入获取参数的Agent的端口！");
//							}
//						}else{
//							listener.inputError("受管PC搜索参数中未传入获取参数的Agent！");
//							throw new Exception("受管PC搜索参数中未传入获取参数的Agent！");
//						}
					} else {
						listener.inputError("受管PC搜索参数未传入！");
						throw new Exception("受管PC搜索参数未传入！");
					}
					/**
					 * 开始IP分割成数组
					 */
					String[] startIPSubs = startIP.split("\\.");
					/**
					 * 结束IP分割成数组
					 */
					String[] endIPSubs = endIP.split("\\.");

					if (startIPSubs.length != 4) {
						listener.inputError("受管PC搜索参数startIP格式不对！");
						throw new Exception("受管PC搜索参数startIP格式不对！");
					} else {
						if (!(startIPSubs[0].matches("\\d{1,3}"))) {
							listener.inputError("受管PC搜索参数startIP第一段格式不对！");
							throw new Exception("受管PC搜索参数startIP第一段格式不对！");
						}
						if (!(startIPSubs[1].matches("\\d{1,3}"))) {
							listener.inputError("受管PC搜索参数startIP第二段格式不对！");
							throw new Exception("受管PC搜索参数startIP第二段格式不对！");
						}
						if (!(startIPSubs[2].matches("\\d{1,3}"))) {
							listener.inputError("受管PC搜索参数startIP第三段格式不对！");
							throw new Exception("受管PC搜索参数startIP第三段格式不对！");
						}
						if (!(startIPSubs[3].matches("\\d{1,3}"))) {
							listener.inputError("受管PC搜索参数startIP第四段格式不对！");
							throw new Exception("受管PC搜索参数startIP第四段格式不对！");
						}
					}
					if (endIPSubs.length != 4) {
						listener.inputError("受管PC搜索参数endIP格式不对！");
						throw new Exception("受管PC搜索参数endIP格式不对！");
					} else {
						if (!(endIPSubs[0].matches("\\d{1,3}"))) {
							listener.inputError("受管PC搜索参数endIP第一段格式不对！");
							throw new Exception("受管PC搜索参数endIP第一段格式不对！");
						}
						if (!(endIPSubs[1].matches("\\d{1,3}"))) {
							listener.inputError("受管PC搜索参数endIP第二段格式不对！");
							throw new Exception("受管PC搜索参数endIP第二段格式不对！");
						}
						if (!(endIPSubs[2].matches("\\d{1,3}"))) {
							listener.inputError("受管PC搜索参数endIP第三段格式不对！");
							throw new Exception("受管PC搜索参数endIP第三段格式不对！");
						}
						if (!(endIPSubs[3].matches("\\d{1,3}"))) {
							listener.inputError("受管PC搜索参数endIP第四段格式不对！");
							throw new Exception("受管PC搜索参数endIP第四段格式不对！");
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
			        	try{
			    			Thread.sleep(10);
			    		}catch(Exception e){
			    			e.printStackTrace();
			    		}
						/**
						 * 本次搜索的消息
						 */
						String thisSearchMessage = "";
			            String currentIp = ip1+"."+ip2+"."+ip3+"."+ip4;
			            
						if (this.stopped) {
							listener.addSearchMessage("您终止了当前搜索！" + "\n");
							break;
						}
						List<Node> pcByAgentList = new ArrayList<Node>();
						try{
//							pcByAgentList = pcSearchService.getAllPcByAgent(agentIp, agentPort);
							pcByAgentList = pcSearchService.getAllPcByAgent();
						}catch(Exception e){
							e.printStackTrace();
							listener.remoteServiceExecuteError("远程服务执行出错，请稍候再试！");
							throw new Exception("远程服务pcSearchService.getAllPcByAgent执行出错，请稍候再试！");
						}
						if(pcByAgentList!=null && pcByAgentList.size()>=0){
							for(Node pc : pcByAgentList){
								if(pc.getIpAddr().equals(currentIp)){
									pc.setNodeType(pcSearchService.getNodeTypeById(3));
									list.add(pc);
									this.setList(list);
									thisSearchMessage = "发现受管PC："+currentIp
														+ "\n"
														+ "**********************"
														+ "\n";
									listener.addSearchMessage(thisSearchMessage);
								}
							}
						}

						Long ipNum = endIPO-startIPO+1;
						int percent = ((i+1)*100)/ipNum.intValue();
						listener.reloadPercentBar(percent);
			            
			            
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
			        
					globalEndTime = System.currentTimeMillis();
					globalAllTime = (globalEndTime - globalStartTime) / 1000;
					/*globalSearchMessage = "本次搜索正常结束：\n开始时间："
							+ new Date(globalStartTime) + "\n" + "结束时间："
							+ new Date(globalEndTime) + "\n" + "共耗时："
							+ globalAllTime + " 秒\n共发现" + list.size() + "个节点";*/
					globalSearchMessage = "\n本次搜索正常结束：\n共发现" + list.size() + "台受管PC。";

					listener.addSearchMessage(globalSearchMessage);
					log = new SystemLog();
//					log.setUsername(pcAppletForm.getUserName());
//					log.setRoleName(pcAppletForm.getRoleName());
					log.setTime(new Timestamp(new Date().getTime()));
					log.setModuleName(SystemModelInfo.MOD_TM_discover);
					log.setOperationDesc("进行受管PC的拓扑发现，共发现" + list.size() + "台受管PC。");
					log.setControl("成功");
//					log.setUsername(pcAppletForm.getUserName());
//					log.setRoleName(pcAppletForm.getRoleName());
//					log.setTime(new Date());
//					log.setModuleName(SystemLogContants.TOPO_MOD);
//					log.setOperationDesc("进行受管PC的拓扑发现，共发现" + list.size() + "台受管PC。");
//					log.setControl("成功");
					pcSearchService.writeToSysLog(log, pcAppletForm.getUserId());
					try{
						pcSearchService.stoppedSearch();
					}catch(Exception e){
						stopped(true);
					}
					listener.onSearchFinished(list);
				} else {
					listener.canSearch(true);
					throw new Exception("有人正在搜索！");
				}
			} catch (Exception e) {
				log = new SystemLog();
//				log.setUsername(pcAppletForm.getUserName());
//				log.setRoleName(pcAppletForm.getRoleName());
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_TM_discover);
				log.setOperationDesc("进行受管PC的拓扑发现。");
				log.setControl("失败");
//				log.setUsername(pcAppletForm.getUserName());
//				log.setRoleName(pcAppletForm.getRoleName());
//				log.setTime(new Date());
//				log.setModuleName(SystemLogContants.TOPO_MOD);
//				log.setOperationDesc("进行受管PC的拓扑发现。");
//				log.setControl("失败");
				pcSearchService.writeToSysLog(log, pcAppletForm.getUserId());
				listener.doSearchError("搜索过程出错，请重新操作！");
				e.printStackTrace();
			}
			this.stopped = true;
			this.running = false;
		} else {
			log = new SystemLog();
//			log.setUsername(pcAppletForm.getUserName());
//			log.setRoleName(pcAppletForm.getRoleName());
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_TM_discover);
			log.setOperationDesc("进行受管PC的拓扑发现。");
			log.setControl("失败");
//			log.setUsername(pcAppletForm.getUserName());
//			log.setRoleName(pcAppletForm.getRoleName());
//			log.setTime(new Date());
//			log.setModuleName(SystemLogContants.TOPO_MOD);
//			log.setOperationDesc("进行受管PC的拓扑发现。");
//			log.setControl("失败");
			pcSearchService.writeToSysLog(log, pcAppletForm.getUserId());
		}
	}

	/**
	 * 保存节点list
	 */
	public void addNodeList(List<Node> list) {
		try {
			if (pcSearchService != null) {
				try {
					pcSearchService.addNodeList(list);
					log = new SystemLog();
//					log.setUsername(pcAppletForm.getUserName());
//					log.setRoleName(pcAppletForm.getRoleName());
					log.setTime(new Timestamp(new Date().getTime()));
					log.setModuleName(SystemModelInfo.MOD_TM_discover);
					log.setOperationDesc("进行受管PC的拓扑发现后，保存选中节点，共保存了" + list.size() + "个节点。");
					log.setControl("成功");
//					log.setUsername(pcAppletForm.getUserName());
//					log.setRoleName(pcAppletForm.getRoleName());
//					log.setTime(new Date());
//					log.setModuleName(SystemLogContants.TOPO_MOD);
//					log.setOperationDesc("进行受管PC的拓扑发现后，保存选中节点，共保存了" + list.size() + "个节点。");
//					log.setControl("成功");
					pcSearchService.writeToSysLog(log, pcAppletForm.getUserId());
					listener.saveDBSuccessed(true);
				} catch (Exception e1) {
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					throw new Exception("远程服务pcSearchService.addNodeList保存节点出错！");
				}
			} else {
				listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
				throw new Exception("未能获取远程服务pcSearchService！");
			}
		} catch (Exception e) {
			log = new SystemLog();
//			log.setUsername(pcAppletForm.getUserName());
//			log.setRoleName(pcAppletForm.getRoleName());
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_TM_discover);
			log.setOperationDesc("进行受管PC的拓扑发现后，保存选中节点。");
			log.setControl("失败");
//			log.setUsername(pcAppletForm.getUserName());
//			log.setRoleName(pcAppletForm.getRoleName());
//			log.setTime(new Date());
//			log.setModuleName(SystemLogContants.TOPO_MOD);
//			log.setOperationDesc("进行受管PC的拓扑发现后，保存选中节点。");
//			log.setControl("失败");
			pcSearchService.writeToSysLog(log, pcAppletForm.getUserId());
			listener.saveDBSuccessed(false);
			e.printStackTrace();
		}
	}
}
