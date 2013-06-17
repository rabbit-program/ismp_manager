package edu.sjtu.infosec.ismp.manager.VPM.pm.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.dao.SensorClientsDao;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.SensorClientsService;
import edu.sjtu.infosec.ismp.security.Domain;
public class SensorClientsServiceImpl implements SensorClientsService {

	private SensorClientsDao sensorClientsDao;
	public SensorClientsDao getSensorClientsDao() {
		return sensorClientsDao;
	}
	public void setSensorClientsDao(SensorClientsDao sensorClientsDao) {
		this.sensorClientsDao = sensorClientsDao;
	}

	@SuppressWarnings("unchecked")
	public LinkedList getSensorInfos(SensorClients sensorClients,
			Integer startResult, Integer maxResult, Date startDate, Date endDate) {
		return sensorClientsDao.getSensorInfos(sensorClients, startResult, maxResult, startDate, endDate);
	}
	@SuppressWarnings("unchecked")
	public LinkedList getSensorInfosByManagerId(List<Integer> doMain,
			SensorClients sensorClients, Integer startResult,
			Integer maxResult, Date startDate, Date endDate) {
		return sensorClientsDao.getSensorInfosByManagerId(doMain, sensorClients, startResult, maxResult, startDate, endDate);
	}
	public List<SensorClients> getSensorInfosByManagerId(SensorClients doMainId) {
		return sensorClientsDao.getSensorInfosByManagerId(doMainId);
	}
	@SuppressWarnings("unchecked")
	public LinkedList getSensorInfosByManagerId(SensorClients doMainId,
			Integer startResult, Integer maxResult, Date startDate, Date endDate) {
		return sensorClientsDao.getSensorInfosByManagerId(doMainId, startResult, maxResult, startDate, endDate);
	}
	public List<SensorClients> getUnallocatedSensorInfos() {
		return sensorClientsDao.getUnallocatedSensorInfos();
	}
	public void saveOrUpdateSensorClients(SensorClients sensorClients) {
		sensorClientsDao.saveOrUpdateSensorClients(sensorClients);
	}
	public SensorClients getSensorClients(int id) {
		return sensorClientsDao.getSensorClients(id);
	}
	public List<SensorClients> getSensorInfosByDoMainId(Integer domainId) {
		return sensorClientsDao.getSensorInfosByDoMainId(domainId);
	}
	public LinkedList getSensorInfosAll(List<Domain> list,Integer startResult, Integer maxResult,
			Date startDate, Date endDate) {
		return	sensorClientsDao.getSensorInfosAll(list,startResult, maxResult, startDate, endDate);
		
	}
	public LinkedList getSensorInfosByTactics(SensorClients sensorClients,
			Integer startResult, Integer maxResult, Date startDate, Date endDate) {
		return sensorClientsDao.getSensorInfosByTactics(sensorClients, startResult, maxResult, startDate, endDate);
	}
	public LinkedList getSensorInfos(List<Domain> list,
			SensorClients sensorClients, Integer startResult,
			Integer maxResult, Date startDate, Date endDate) {
		return sensorClientsDao.getSensorInfos(list, sensorClients, startResult, maxResult, startDate, endDate);
	}
}
