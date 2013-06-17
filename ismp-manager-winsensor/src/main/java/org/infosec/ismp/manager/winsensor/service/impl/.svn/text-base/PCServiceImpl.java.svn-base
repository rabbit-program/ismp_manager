package org.infosec.ismp.manager.winsensor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.service.agent.PCService;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time: Dec 22, 2010 3:35:01 PM
 *
 */
public class PCServiceImpl implements PCService {
	
	private ManagerSensorServer managerSensorServer;
	
	@Override
	public List<Node> getAllPcByAgent() throws Exception {
		List<CommWinsensorDevice> devices = managerSensorServer.getAllTopoDiscoveryDevices();
		List<Node> nodes = new ArrayList<Node>();
		
		for (CommWinsensorDevice commDevice : devices) {
			Node node = new Node();
			node.setSensorId(commDevice.getSensorId());
			node.setIpAddr(commDevice.getIp());
			node.setMac(commDevice.getMac());
			
			nodes.add(node);
		}
		
		return nodes;
	}

	public void setManagerSensorServer(ManagerSensorServer managerSensorServer) {
		this.managerSensorServer = managerSensorServer;
	}
}
