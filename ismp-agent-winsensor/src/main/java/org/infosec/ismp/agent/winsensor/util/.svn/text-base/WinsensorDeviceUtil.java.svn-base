package org.infosec.ismp.agent.winsensor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;

/**
 * @author Rocky
 * @version create time：Dec 6, 2010 10:57:07 PM
 * 
 */
public class WinsensorDeviceUtil {
	
	public static List<CommWinsensorDevice> getCommWinsensorDevice(Collection<WinsensorDeviceBO> devices) {
		List<CommWinsensorDevice> commDevices = new ArrayList<CommWinsensorDevice>();
		
		for (WinsensorDeviceBO device : devices) {
			commDevices.add(device.getCommDevice());
		}
		
		return commDevices;		
	}
}
