package org.infosec.ismp.manager.alert;

import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.infosec.ismp.manager.rmi.aim.service.NewAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewAlertServiceImpl implements NewAlertService {

	public AlertManagerImpl alertManagerImpl;
	
	
	@Autowired(required=true)
	public void setAlertManagerImpl(AlertManagerImpl alertManagerImpl) {
		this.alertManagerImpl = alertManagerImpl;
	}



	@Override
	public Map<String, List<AlertInfoBO>> getNewAlert(Long maxId) {
		return alertManagerImpl.getNewAlert(maxId);
	}

}
