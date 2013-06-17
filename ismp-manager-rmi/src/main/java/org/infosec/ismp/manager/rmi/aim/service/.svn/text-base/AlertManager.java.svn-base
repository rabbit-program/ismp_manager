package org.infosec.ismp.manager.rmi.aim.service;

import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;

public interface AlertManager {
	public Map<String, List<AlertInfoBO>> getNewAlert(Long maxId);
	public void addAlertInfo(AlertInfoBO alert);
	public void setAlertCousumers(List<AlertConsumer> consumers);
//	public void registerAlertConsumer(AlertConsumer consumer);
}
