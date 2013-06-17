package edu.sjtu.infosec.ismp.manager.LM.dLog.service;

import java.util.List;

import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogInitQueryBean;
import edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogResponseQueryBean;
import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public interface SysLogService {
	
	/**
	 * 初始化sysLogBaseInfoService
	 * 其中包括：产生日志的程序模块---Facility
	 * 			严重性---Severity
	 * 将所得到的数据保存：InitSysLogSeverityAndFacility中的SYSLOGSEVERITY和SYSLOGFACILITY
	 * @throws Exception
	 */
	public void sysLogBaseInfoService()throws Exception;
	
	/**
	 * 初始化查询条件所需的所有基础数据
	 * @return
	 * @throws Exception
	 */
	public SysLogInitQueryBean initQuery()throws Exception;
	
	/**
	 * 返回本次查询的条件字符串
	 * @return
	 * @throws Exception
	 */
	public SysLogResponseQueryBean responseQuery(ActionForm from,OperatorDetails user)throws Exception;
	
	/**
	 * SysLog原始数据的查询
	 * @param sysLogQueryBean
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	public PageBean getSysLog(SysLogResponseQueryBean sysLogQueryBean,Integer pageNo,String initBeginDate,String initEndDate)throws Exception;
	
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
}
