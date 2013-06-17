package org.infosec.ismp.applet.discover.service;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.applet.comm.util.HttpInvokerProxyFactoryBeanUtil;
import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.applet.discover.listener.SearchListener;
import org.infosec.ismp.applet.discover.thread.PCSearchThread;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.PCAppletForm;
import org.infosec.ismp.manager.rmi.tm.discover.service.applet.PCSearchService;

/**
 * PC搜索方法类service类
 * @author Wu Guojie
 * @date 2009-6-11
 * @version 1.0
 */
public class PCSearchAppletService {
	/**
	 * 搜索线程
	 */
	private static PCSearchThread pcSearchThread = null;
	/**
	 * 搜索方法service
	 */
	private static PCSearchAppletService service = null;
	/**
	 * 构造器
	 */
	private PCSearchAppletService(){}
	/**
	 * 实例化搜索方法service
	 * @return 搜索方法service
	 */
	public static PCSearchAppletService getInstance(){
	    if(service==null){
	        service = new PCSearchAppletService();
	    }
	    return service;
	}
	
	/**
	 * 创建pcSearchService
	 */
	PCSearchService pcSearchService = getPCSearchService();

	/**
	 * 远程获取pcSearchService
	 * @return PCSearchService实例
	 */
	public PCSearchService getPCSearchService(){
		try{
			PCSearchService service = (PCSearchService)HttpInvokerProxyFactoryBeanUtil
			.getService(ServerConfig.getServerPath()+"/remoting/pcSearchServiceRemoting", PCSearchService.class);
			
			return service;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 搜索
	 * @param pcAppletForm
	 * pcAppletForm
	 * @param listener
	 * listener
	 * @return 搜索结果list
	 */
	public List<Node> doSearch(PCAppletForm pcAppletForm, SearchListener listener) {
		pcSearchThread = new PCSearchThread(pcAppletForm, listener);
		pcSearchThread.start();
		/**
		 * 结果list
		 */
		List<Node> list = new ArrayList<Node>();
		list = pcSearchThread.getList();
		return list;
	}
	
	/**
	 * 停止搜索
	 */
	public void stopSearch(boolean silent){
		pcSearchThread.stopped(silent);
	}
	/**
	 * 保存节点
	 */
	public void addNodeList(List<Node> list){
		pcSearchThread.addNodeList(list);
	}
	/**
	 * 是否有人正在执行搜索功能
	 * @return 是/否
	 */
	public boolean isSearching(){
		boolean isSearching = false;
		try{
			if(pcSearchService!=null){
				try{
					isSearching = pcSearchService.isSearching();
				}catch(Exception e1){
					throw new Exception("远程服务pcSearchService不可用！");
				}
			}else{
				throw new Exception("未能获取远程服务pcSearchService！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSearching;
	}
	/**
	 * 是否有人正在执行搜索功能
	 * @param listener
	 * 监听器
	 * @return 是/否
	 */
	public boolean isSearching(SearchListener listener){
		boolean isSearching = false;
		try{
			if(pcSearchService!=null){
				try{
					isSearching = pcSearchService.isSearching();
				}catch(Exception e1){
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					throw new Exception("远程服务pcSearchService.isSearching不可用！");
				}
			}else{
				listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
				throw new Exception("未能获取远程服务pcSearchService！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSearching;
	}
	
	/**
	 * 方法说明：获取所有已经向Manager注册的AgentBO列表（邓东和数据库的交际）
	 * @return
	 */
//	public List<AgentBO> getAllRegisteredAgentBO(){
//		List<AgentBO> list = new ArrayList<AgentBO>();
//		try{
//			list = pcSearchService.getAllRegisteredAgentBO();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return list;
//	}
}
