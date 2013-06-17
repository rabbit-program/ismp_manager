package org.infosec.ismp.manager.rmi.tm.discover.service.agent;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.discover.model.Node;

/**
 * 拓扑发现模块中，发现PC的接口
 * @author Wu Guojie
 * @date 2009-7-21
 * @version 1.0
 */
public interface PCService {
	/**
	 * 返回当前manager管理的Agent下，所有在线的PC。
	 * @return 返回的node中包含有效数据：sensorId, ipAddress, macAddress.
	 * 				当无数据时，返回empty list(not null).
	 * @throws Exception
	 */
	List<Node> getAllPcByAgent() throws Exception;
}
