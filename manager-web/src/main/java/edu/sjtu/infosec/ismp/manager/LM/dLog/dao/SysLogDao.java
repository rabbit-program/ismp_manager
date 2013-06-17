package edu.sjtu.infosec.ismp.manager.LM.dLog.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLog;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLogFacility;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLogSeverity;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.security.Domain;

public interface SysLogDao {
	
	/**
	 * 初值化SysLogFacility----产生日志的程序模块	
	 * @return	List<SysLogFacility>
	 * @throws Exception
	 */
	public List<SysLogFacility> initSysLogFacility()throws Exception;
	
	/**
	 * 初值化SysLogSeverity----严重性
	 * @return	List<SysLogSeverity>
	 * @throws Exception
	 */
	public List<SysLogSeverity> initSysLogSeverity()throws Exception;
	
	/**
	 * 得到lm_dlog_syslog表中的数据总数
	 * @return
	 * @throws Exception
	 */
	public Integer getPageResultRowSum(String HQL)throws Exception;
	
	/**
	 * 得到lm_dlog_syslog表中符合HQL条件的数据。并分页
	 * @param HQL
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 * @throws Exception
	 */
	public List<SysLog> getPageResult(String HQL,Integer pageNo,Integer pageRowNum)throws Exception;
	
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
}
