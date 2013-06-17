package org.infosec.ismp.manager.winsensor.patch.service.impl;

import java.util.Date;

import org.infosec.ismp.manager.winsensor.patch.dao.PatchClientDao;
import org.infosec.ismp.manager.winsensor.patch.entity.PatchClientBO;
import org.infosec.ismp.manager.winsensor.patch.service.PatchClientService;

/**
 * @author Rocky
 * @version create time: Dec 29, 2010 4:50:24 PM
 *
 */
public class PatchClientServiceImpl implements PatchClientService {
	
	private PatchClientDao dao;

	@Override
	public void addClient(String sensorId, String sensorIp, String sensorMac,
			Integer domainId) {
		PatchClientBO client = new PatchClientBO();
		
		client.setSensorId(sensorId);
		client.setSensorIp(sensorIp);
		client.setSensorMac(sensorMac);
		client.setDomainId(domainId);
		client.setCreateTime(new Date());
		
		dao.addClient(client);
	}

	public void setDao(PatchClientDao dao) {
		this.dao = dao;
	}
}
