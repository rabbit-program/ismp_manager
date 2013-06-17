package edu.sjtu.infosec.ismp.manager.LM.dLog.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.model.PcLog;

public interface PcDao {
	
	/**
	 * 根据sensor唯一标识获得相关日志
	 * @param HQL
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 * @throws Exception
	 */
	public List<PcLog> getPcLogBySensor(String HQL,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 根据sensor唯一标识获得相关日志 的数量
	 * @param HQL
	 * @return
	 * @throws Exception
	 */
	public Integer getPcLogBySensorCount(String HQL)throws Exception;
}
