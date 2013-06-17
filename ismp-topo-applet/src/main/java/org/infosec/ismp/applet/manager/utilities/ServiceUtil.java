/**
 * 版权所有：上海鹏越惊虹信息技术发展有限公司
 */
package org.infosec.ismp.applet.manager.utilities;

import org.infosec.ismp.applet.comm.util.HttpInvokerProxyFactoryBeanUtil;
import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoManagerService;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;


/**
 * @author 肖高峰
 * 与WEB层的一个服务接受
 */
public class ServiceUtil {
	private static ServiceUtil serviceUtil;
	private ServiceUtil(){};
	
	public static ServiceUtil newInstance() {
		if(serviceUtil == null) {
			serviceUtil = new ServiceUtil();
		}
		return serviceUtil;
	}
	/**
	 * 返回远程设备服务
	 * @return deviceService 远程设备服务
	 */
	public TopoWebService  getWebDeviceService() {
		TopoWebService deviceService=(TopoWebService)HttpInvokerProxyFactoryBeanUtil
		.getService(ServerConfig.getServerPath()+"/remoting/topoManagerWebServiceRemoting", TopoWebService.class);
		return deviceService;
	}
	
	/**
	 * 返回远程设备服务
	 * @return deviceService 远程设备服务
	 */
	public TopoManagerService  getTopoManagerDeviceService() {
		TopoManagerService deviceService=(TopoManagerService)HttpInvokerProxyFactoryBeanUtil
		.getService(ServerConfig.getServerPath()+"/remoting/topoManagerServiceRemoting", TopoManagerService.class);
		return deviceService;
	}
	
}
