package edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.sensor.SensorController;


import edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.PcSourceDao;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.Sensor;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.PcSourceService;
import edu.sjtu.infosec.ismp.security.Domain;

public class PcSourceServiceImpl implements PcSourceService {
	
	private PcSourceDao pcSourceDao;
	private SensorController pcController;

	public Sensor loadObject(String id) throws Exception {
		return pcSourceDao.loadObject(id);
	}

	public PcSourceDao getPcSourceDao() {
		return pcSourceDao;
	}

	public void setPcSourceDao(PcSourceDao pcSourceDao) {
		this.pcSourceDao = pcSourceDao;
	}

	public List<Sensor> getAllPcSource(Sensor sensor, List<Domain> domain,
			Integer pageNo, Integer pageRowNum) throws Exception {
		return pcSourceDao.getAllPcSource(sensor, domain, pageNo, pageRowNum);
	}

	public Integer getAllPcSourceCount(Sensor sensor, List<Domain> domain)
			throws Exception {
		return pcSourceDao.getAllPcSourceCount(sensor, domain);
	}


	public boolean updatePcSource(List<String> sourceIdList,String startCollectSwitch,String intervalCollectTime) throws Exception {
		Map<String,Long> sensorMap = new HashMap<String, Long>();
		List<String> delSensorList = new ArrayList<String>();
		
		for(String sourceId:sourceIdList){
			Sensor sensor = this.loadObject(sourceId);
			
			if(intervalCollectTime!=null && intervalCollectTime!=""){
				sensor.setIntervalCollectTime(Long.valueOf(intervalCollectTime));
			}
//			if(startCollectSwitch!=null && startCollectSwitch!=""){
//				sensor.setStartCollectSwitch(Boolean.valueOf(startCollectSwitch));
//			}else{
//				sensor.setStartCollectSwitch(true);
//			}
			
			if(sensor.getStartCollectSwitch()){
				sensorMap.put(sensor.getSensorSequence(), sensor.getIntervalCollectTime());
			}else{
				delSensorList.add(sensor.getSensorSequence());
			}
			
//			pcSourceDao.updatePcSource(sensor);
		}
			
			try{	
				pcController.addSensor(sensorMap);
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	
			try{
				for(String sensorSequence:delSensorList){
					pcController.deleteSensor(sensorSequence);
				}
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	
		return true;
	}

	public SensorController getPcController() {
		return pcController;
	}

	public void setPcController(SensorController pcController) {
		this.pcController = pcController;
	}
	
}
