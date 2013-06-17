package edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.Sensor;
import edu.sjtu.infosec.ismp.security.Domain;

public interface PcSourceService {
	
	/**
	 * 无条件获得所在域下的所有Sensor
	 * @return
	 * @throws Exception
	 */
	public List<Sensor> getAllPcSource(Sensor sensor,List<Domain> domain,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 无条件获得所在域下的所有Sensor的条数
	 * @return
	 * @throws Exception
	 */
	public Integer getAllPcSourceCount(Sensor sensor,List<Domain> domain)throws Exception;
	/**
	 * 修改
	 * @param sourceId
	 * @param startCollectSwitch
	 * @return
	 * @throws Exception
	 */
	public boolean updatePcSource(List<String> sourceIdList,String startCollectSwitch,String intervalCollectTime)throws Exception;
	
	/**
	 * 加载SysLogSource
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Sensor loadObject(String id)throws Exception;
}
