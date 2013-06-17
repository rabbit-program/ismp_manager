package org.infosec.ismp.agent.winsensor;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;

/**
 * @author Rocky
 * @version create time：Nov 12, 2010 11:01:38 AM
 * 
 */
public class SensorServerTest {
	
	private List<WinsensorDeviceBO> allLegalMonitorDevices = new ArrayList<WinsensorDeviceBO>();
	
	private Hashtable<WinsensorDeviceBO, WinsensorClient> allCurrentMonitoringWinsensorClient = 
		new Hashtable<WinsensorDeviceBO, WinsensorClient>();
	
	public void testVariableStorage() {
		initLegalMinitorDevices();
		initCurrentMonitoringWinsensorClient();
		WinsensorDeviceBO device = findDeviceFromLegalMonitorDevicesList("1111111111");
		device.setIpAddress("192.168.9.1");
		
		System.out.println("device's ip address: " + device.getIpAddress() + " nodeId: " + device.getNodeId());
		System.out.println("***********************************");
		
		for (WinsensorDeviceBO winsensorDevice : allLegalMonitorDevices) {
			System.out.println("allLegalMonitorDevices winsensorDevice's ip address: " + winsensorDevice.getIpAddress() 
					+ " nodeId: " + winsensorDevice.getNodeId());
		}
		System.out.println("***********************************");
		
		Iterator<WinsensorDeviceBO>iterator = allCurrentMonitoringWinsensorClient.keySet().iterator();
		while (iterator.hasNext()) {
			WinsensorDeviceBO it = iterator.next();
			System.out.println("allCurrentMonitoringWinsensorClient winsensorDevice's ip address: " 
					+ it.getIpAddress() + " nodeId: " + it.getNodeId());
		}
	}
	
	public void initLegalMinitorDevices() {
		WinsensorDeviceBO deviceOne = new WinsensorDeviceBO();
		deviceOne.setNodeId("1000");
		deviceOne.setIpAddress("192.168.9.100");
		deviceOne.setSensorId("1111111111");
		
		WinsensorDeviceBO deviceTwo = new WinsensorDeviceBO();
		deviceTwo.setNodeId("2000");
		deviceTwo.setIpAddress("192.168.9.200");
		deviceTwo.setSensorId("2222222222");
		
		allLegalMonitorDevices.add(deviceOne);
		allLegalMonitorDevices.add(deviceTwo);
	}
	
	public WinsensorDeviceBO findDeviceFromLegalMonitorDevicesList(String sensorId) {
		WinsensorDeviceBO device = null;
		for (int i = 0; i < allLegalMonitorDevices.size(); i++) {
			if (sensorId.equals(allLegalMonitorDevices.get(i).getSensorId())) {
				device = allLegalMonitorDevices.get(i);
			}
		}

		return device;
	}
	
	public void initCurrentMonitoringWinsensorClient() {
		for (WinsensorDeviceBO device : allLegalMonitorDevices) {
			WinsensorClient client = new WinsensorClient();
			allCurrentMonitoringWinsensorClient.put(device, client);
			System.out.println("Last register time: " + client.getLastRegisterTime() + " off-line times is: " 
					+ client.getRegisterOfflineTimes());
		}
	}
	
	private class WinsensorClient {
		private int registerOfflineTimes;

		private long lastRegisterTime;

		public WinsensorClient() {
			setLastRegisterTime(System.currentTimeMillis());
			setRegisterOfflineTimes(0);
		}

		public int getRegisterOfflineTimes() {
			return registerOfflineTimes;
		}

		public void setRegisterOfflineTimes(int registerOfflineTimes) {
			this.registerOfflineTimes = registerOfflineTimes;
		}

		public long getLastRegisterTime() {
			return lastRegisterTime;
		}

		public void setLastRegisterTime(long lastRegisterTime) {
			this.lastRegisterTime = lastRegisterTime;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SensorServerTest test = new SensorServerTest();
		test.testVariableStorage();
	}

}
