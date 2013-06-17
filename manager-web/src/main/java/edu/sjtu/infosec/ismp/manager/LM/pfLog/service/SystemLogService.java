package edu.sjtu.infosec.ismp.manager.LM.pfLog.service;

import java.sql.Timestamp;
import java.util.List;

import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

/**
 * 日志操作接口
 * 
 * @author 林超
 * 
 */

public interface SystemLogService {

	/**
	 * 存储系统日志
	 * 
	 * @param log
	 */
	void saveSystemLog(SystemLog log);

	void saveSystemLog(String username, String role, String mod,
			String operation, Timestamp time, String control);

	/**
	 * 获取带指定条件的所有日志条数
	 * 
	 * @return
	 */
	Integer getSystemLogCount(SystemLog log, Timestamp startDate, Timestamp endDate);

	/**
	 * 
	 * getPageBySystemLog decription : 获取指定条件和指定起始点和长度的系统日志。分页显示
	 * 
	 * @param systemLog
	 * @param page
	 * @return
	 */
	List<SystemLog> getPageBySystemLog(SystemLog systemLog, Integer pageNo,Integer pageRowNum,
			Timestamp startDate, Timestamp endDate);
}
