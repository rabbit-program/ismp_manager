package edu.sjtu.infosec.ismp.manager.LM.dLog.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.dao.PcDao;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.PcLog;
import edu.sjtu.infosec.ismp.manager.LM.dLog.service.PcService;

public class PcServiceImpl implements PcService {
	
	private PcDao pcDao;
	
	public List<PcLog> getPcLogBySensor(String sensorSequence, Integer pageNo,
			Integer pageRowNum) throws Exception {
		StringBuffer HQL = new StringBuffer();
		
		HQL.append("from PcLog where sensorSequence='" + sensorSequence+"'");
		
		System.out.println(HQL.toString());
		return pcDao.getPcLogBySensor(HQL.toString(), pageNo, pageRowNum);
	}

	public Integer getPcLogBySensorCount(String sensorSequence)
			throws Exception {
		StringBuffer HQL = new StringBuffer();
		
		HQL.append("select count(*) from PcLog where sensorSequence='" + sensorSequence+"'");
		System.out.println(HQL.toString());
		return pcDao.getPcLogBySensorCount(HQL.toString());
	}

	public PcDao getPcDao() {
		return pcDao;
	}

	public void setPcDao(PcDao pcDao) {
		this.pcDao = pcDao;
	}

}

