package edu.sjtu.infosec.ismp.manager.LM.dLog.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.model.PcLog;

public interface PcService {

	/**
	 * 根据sensor唯一标识获得相关日志
	 * @param sensorSequence
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 * @throws Exception
	 */
	public List<PcLog> getPcLogBySensor(String sensorSequence,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 根据sensor唯一标识获得相关日志 的数量
	 * @param sensorSequence
	 * @return
	 * @throws Exception
	 */
	public Integer getPcLogBySensorCount(String sensorSequence)throws Exception;
}
