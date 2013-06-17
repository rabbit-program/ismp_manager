package org.infosec.ismp.applet.comm.util;

import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;


/**
 * 远程服务动态创建工具类
 * 
 * @author hzhang
 * @data 2009-6-3
 */
public class HttpInvokerProxyFactoryBeanUtil {
    
	
	/**
	 * 获取服务方法
	 * @param serviceUrl  服务的URL
	 * @param serviceInterf
	 * @return  service
	 */
	public static Object getService(String serviceUrl, Class serviceInterf) {
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceUrl(serviceUrl);
		invoker.setServiceInterface(serviceInterf);
			invoker.afterPropertiesSet();
		
		return invoker.getObject();

	}

}
