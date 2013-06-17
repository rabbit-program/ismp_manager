package org.infosec.ismp.manager.alert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.infosec.ismp.manager.rmi.aim.service.AlertConsumer;
import org.infosec.ismp.manager.rmi.aim.service.AlertManager;
import org.infosec.ismp.util.queue.FifoQueueException;
import org.infosec.ismp.util.queue.FixedLengthQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 实现告警对象的管理
 * 
 * @author lianglin
 * 
 */
@Component
@Transactional
public class AlertManagerImpl implements AlertManager{

	private static final int MAX_LENGTH = 100;
	
	private AlertDao alertDao;
	
	private List<AlertConsumer> m_consumers;
	
	@Autowired(required=true)
	public void setAlertDao(AlertDao alertDao) {
		this.alertDao = alertDao;
	}

	private FixedLengthQueue<AlertPair> alerts = new FixedLengthQueue<AlertPair>(
			MAX_LENGTH);

	public Map<String, List<AlertInfoBO>> getNewAlert(Long maxId) {
		Map<String, List<AlertInfoBO>> value = new HashMap<String, List<AlertInfoBO>>();
		int size = alerts.size();
		long newId = maxId;
		if (size > 0) {
			List<AlertInfoBO> rtvl = new ArrayList<AlertInfoBO>();
			for (int i = 0; i < size; i++) {
				AlertPair pair = alerts.getElement(i);
				long id = pair.getMaxId();
				if (id > maxId) {
					rtvl.add(pair.getAlert());
					if (id > newId) {
						newId = id;
					}
				}
			}
			if (newId > maxId)
				value.put(Long.toString(newId), rtvl);

		}
		return value;

	}

	public void addAlertInfo(AlertInfoBO alert) {
		saveAlertToMemory(alert);
		saveAlertToDB(alert);
	}

	private void saveAlertToMemory(AlertInfoBO alert) {
		AlertPair value = alerts.getLast();
		if (value == null) {
			AlertPair pair = new AlertPair(alert, 0L);
			try {
				alerts.add(pair);
			} catch (FifoQueueException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			long maxId = value.getMaxId();
			long newMaxId = 0;
			if (maxId + 1 < Long.MAX_VALUE)
				newMaxId = maxId + 1;
			AlertPair pair = new AlertPair(alert, newMaxId);
			try {
				alerts.add(pair);
			} catch (FifoQueueException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	@Transactional
	public void saveAlertToDB(AlertInfoBO entity){
		alertDao.save(entity);
	}
	
	public void sendToAlertConsumers(AlertInfoBO entity){
		if(m_consumers!=null){
			for(AlertConsumer consumer:m_consumers){
				consumer.onAlert(entity);
			}
		}
	}
	
	

	@Override
	public void setAlertCousumers(List<AlertConsumer> consumers) {
		this.m_consumers = consumers;
		
	}



	private class AlertPair {
		AlertInfoBO alert;
		long maxId;

		public AlertPair(AlertInfoBO alert, long maxId) {
			this.alert = alert;
			this.maxId = maxId;
		}

		public AlertInfoBO getAlert() {
			return alert;
		}

		public void setAlert(AlertInfoBO alert) {
			this.alert = alert;
		}

		public long getMaxId() {
			return maxId;
		}

		public void setMaxId(long maxId) {
			this.maxId = maxId;
		}

	}
}
