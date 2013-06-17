package edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSourceType;
import edu.sjtu.infosec.ismp.security.Domain;

public interface SysLogSourceService {
	
	/**
	 * 无条件获得所在域下的所有SysLogSource
	 * @return
	 * @throws Exception
	 */
	public List<SysLogSource> getAllSysLogSource(SysLogSource sysLogSource,List<Domain> domain,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 无条件获得所在域下的所有SysLogSource的条数
	 * @return
	 * @throws Exception
	 */
	public Integer getAllSysLogSourceCount(SysLogSource sysLogSource,List<Domain> domain)throws Exception;
	
	/**
	 * 新增	SysLogSource
	 * 
	 * @param sysLogSource
	 * @return
	 * @throws Exception
	 */
	public boolean addSysLogSource(SysLogSource sysLogSource)throws Exception;
	
	/**
	 * 删除	SysLogSource
	 * @param sysLogSource
	 * @return
	 * @throws Exception
	 */
	public boolean delSysLogSource(SysLogSource sysLogSource,TopoWebService topoWebService)throws Exception;
	
	/**
	 * 修改
	 * @param sourceId
	 * @param startCollectSwitch
	 * @return
	 * @throws Exception
	 */
	public boolean updateSysLogSource(SysLogSource sysLogSource)throws Exception;
	
	/**
	 * 无条件获得所有SysLogSourceType
	 * @return
	 * @throws Exception
	 */
	public List<SysLogSourceType> getAllSysLogSourceType()throws Exception;
	
	/**
	 * 加载SysLogSource
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysLogSource loadObject(String id)throws Exception;
}
