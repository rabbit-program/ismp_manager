package org.infosec.ismp.applet.discover.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.applet.comm.util.HttpInvokerProxyFactoryBeanUtil;
import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.applet.discover.listener.SearchListener;
import org.infosec.ismp.applet.discover.thread.CDPSearchThread;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.CDPAppletForm;
import org.infosec.ismp.manager.rmi.tm.discover.service.applet.CDPSearchService;

/**
 * CDP搜索方法类service类
 * @author Wu Guojie
 * @date 2009-6-11
 * @version 1.0
 */
public class CDPSearchAppletService {
	/**
	 * 搜索线程
	 */
	private static CDPSearchThread cdpSearchThread = null;
	/**
	 * 搜索方法service
	 */
	private static CDPSearchAppletService service = null;
	
	/**
	 * 构造器
	 */
	private CDPSearchAppletService(){}
	/**
	 * 实例化搜索方法service
	 * @return 搜索方法service
	 */
	public static CDPSearchAppletService getInstance(){
	    if(service==null){
	        service = new CDPSearchAppletService();
	    }
	    return service;
	}

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
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 搜索
	 * @param cdpAppletForm
	 * cdpAppletForm
	 * @return 搜索结果list
	 */
	public Map<String,List> doSearch(CDPAppletForm cdpAppletForm, SearchListener listener) {
		cdpSearchThread = new CDPSearchThread(cdpAppletForm, listener);
		cdpSearchThread.start();
		/**
		 * 结果map
		 */
		Map<String,List> map = new HashMap<String,List>();
		map = cdpSearchThread.getMap();
		
		return map;
	}
	
	/**
	 * 停止搜索
	 */
	public void stopSearch(boolean silent){
		cdpSearchThread.stopped(silent);
	}
	/**
	 * 保存节点
	 */
	public void addNodeList(Map<String,List> map){
		cdpSearchThread.addNodeList(map);
	}
	/**
	 * 是否有人正在执行搜索功能
	 * @return 是/否
	 */
	public boolean isSearching(){
		boolean isSearching = false;
		try{
			if(cdpSearchService!=null){
				try{
					isSearching = cdpSearchService.isSearching();
				}catch(Exception e1){
					throw new Exception("远程服务cdpSearchService不可用！");
				}
			}else{
				throw new Exception("未能获取远程服务cdpSearchService！");
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
			if(cdpSearchService!=null){
				try{
					isSearching = cdpSearchService.isSearching();
				}catch(Exception e1){
					listener.remoteServiceExecuteError("远程服务没响应，请稍候再试！");
					throw new Exception("远程服务cdpSearchService.isSearching不可用！");
				}
			}else{
				listener.remoteServiceNotResponse("远程服务没响应，请稍候再试！");
				throw new Exception("未能获取远程服务cdpSearchService！");
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
//			list = cdpSearchService.getAllRegisteredAgentBO();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return list;
//	}
}
