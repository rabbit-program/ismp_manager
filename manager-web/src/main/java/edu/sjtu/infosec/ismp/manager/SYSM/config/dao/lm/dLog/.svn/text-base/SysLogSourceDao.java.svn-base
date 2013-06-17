package edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSourceType;
import edu.sjtu.infosec.ismp.security.Domain;

public interface SysLogSourceDao {
	/**
	 * 获得符合HQL条件的SysLogSource
	 * @param HQL
	 * @return
	 * @throws Exception
	 */
	public List<SysLogSource> getAllSysLogSource(SysLogSource sysLogSource,List<Domain> domain,Integer pageNo,Integer pageRowNum)throws Exception;
	/**
	 * 获得符合HQL条件的SysLogSource的条数
	 * @param HQL
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
	public Integer addSysLogSource(SysLogSource sysLogSource)throws Exception;
	
	/**
	 * 删除	SysLogSource
	 * @param sysLogSource
	 * @return
	 * @throws Exception
	 */
	public Integer delSysLogSource(SysLogSource sysLogSource)throws Exception;
	
	/**
	 * 修改
	 * @param HQL
	 * @return
	 * @throws Exception
	 */
	public Integer updateSysLogSource(SysLogSource sysLogSource)throws Exception;
	
	/**
	 * 加载SysLogSource
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysLogSource loadObject(String id) throws Exception;
	
	/**
	 * 无条件获得所有SysLogSourceType
	 * @return
	 * @throws Exception
	 */
	public List<SysLogSourceType> getAllSysLogSourceType()throws Exception;
}
