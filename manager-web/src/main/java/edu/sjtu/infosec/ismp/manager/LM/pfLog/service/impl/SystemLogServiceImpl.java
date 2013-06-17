package edu.sjtu.infosec.ismp.manager.LM.pfLog.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.dao.impl.SystemLogDaoImpl;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
/**
 * systemLogService操作接口的实现。
 * @author 林超
 *
 */
@Component(value="systemlogService")
public class SystemLogServiceImpl implements SystemLogService {

	private SystemLogDaoImpl systemLogDao;
	
	@Autowired(required = true)
	public void setSystemLogDao(SystemLogDaoImpl systemLogDao) {
		this.systemLogDao = systemLogDao;
	}

	@Transactional(readOnly=false)
	public void saveSystemLog(SystemLog log) {
		systemLogDao.save(log);
	} 

	@Transactional(readOnly=false)
	public void saveSystemLog(String username, String role, String mod,
			String operation, Timestamp time, String control) {
		SystemLog log = new SystemLog();
		log.setUsername(username);
		log.setRoleName(role);
		log.setModuleName(mod);
		log.setOperationDesc(operation);
		log.setTime(time);
		log.setControl(control);
//		log.setDomain(domain);
		systemLogDao.save(log);
		
	}


	@Transactional(readOnly=false)
	public List<SystemLog> getPageBySystemLog(SystemLog systemLog,
			Integer pageNo, Integer pageRowNum, Timestamp startDate,
			Timestamp endDate) {
		
		return systemLogDao.getPageBySystemLog(systemLog, pageNo, pageRowNum, startDate, endDate);
	}


	@Transactional(readOnly=false)
	public Integer getSystemLogCount(SystemLog log, Timestamp startDate,
			Timestamp endDate) {
		
		return systemLogDao.getSystemLogCount(log, startDate, endDate);
	}
}
