package edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.Sensor;
import edu.sjtu.infosec.ismp.security.Domain;

public interface PcSourceDao {
	/**
	 * 获得符合HQL条件的Sensor
	 * @param HQL
	 * @return
	 * @throws Exception
	 */
	public List<Sensor> getAllPcSource(Sensor sensor,List<Domain> domain,Integer pageNo,Integer pageRowNum)throws Exception;
	/**
	 * 获得符合HQL条件的Sensor的条数
	 * @param HQL
	 * @return
	 * @throws Exception
	 */
	public Integer getAllPcSourceCount(Sensor sensor,List<Domain> domain)throws Exception;
	
	/**
	 * 修改
	 * @param HQL
	 * @return
	 * @throws Exception
	 */
	public Integer updatePcSource(Sensor sensor)throws Exception;
	
	/**
	 * 加载Sensor
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Sensor loadObject(String id) throws Exception;
	
}
