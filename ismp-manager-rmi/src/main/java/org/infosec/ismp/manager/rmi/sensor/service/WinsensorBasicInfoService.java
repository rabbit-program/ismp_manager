package org.infosec.ismp.manager.rmi.sensor.service;

import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;

/**
 * @author Rocky
 * @version create time：Dec 16, 2010 3:18:38 PM
 * 得到Sensor客户端的各种基本信息
 */
public interface WinsensorBasicInfoService {

	/**
	 * 得到Sensor客户端所在PC的基本信息
	 * @param nodeId 客户端在系统中的唯一标识nodeId
	 * @return 没有则返回null
	 */
	public HostResource getHostResource(String nodeId);
}
