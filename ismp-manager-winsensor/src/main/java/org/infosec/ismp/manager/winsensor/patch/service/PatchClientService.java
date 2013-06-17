package org.infosec.ismp.manager.winsensor.patch.service;


/**
 * @author Rocky
 * @version create time: Dec 29, 2010 4:46:33 PM
 *
 */
public interface PatchClientService {

	public void addClient(String sensorId, String sensorIp, String sensorMac, Integer domainId);
}
