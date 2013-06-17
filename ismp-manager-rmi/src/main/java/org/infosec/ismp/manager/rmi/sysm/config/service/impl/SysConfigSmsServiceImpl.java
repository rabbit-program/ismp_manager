package org.infosec.ismp.manager.rmi.sysm.config.service.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.sysm.config.dao.SysConfigSmsDao;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigSms;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigSmsService;

/**
 * 
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
public class SysConfigSmsServiceImpl implements SysConfigSmsService {
	
	private SysConfigSmsDao sysConfigSmsDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setSysConfigSmsDao(SysConfigSmsDao sysConfigSmsDao) {
		this.sysConfigSmsDao = sysConfigSmsDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	

	public void add(SysConfigSms sms) throws Exception {
		sysConfigSmsDao.add(sms);
	}

	public void delete(SysConfigSms sms) throws Exception {
		sysConfigSmsDao.delete(sms);
	}

	public void update(SysConfigSms sms) throws Exception {
		sysConfigSmsDao.update(sms);
	}

	public List<SysConfigSms> findAll() throws Exception {
		List<SysConfigSms> list = sysConfigSmsDao.findAll();
		return list;
	}

	public SysConfigSms findById(int id) {
		return sysConfigSmsDao.findById(id);
	}

	public SysConfigSms findByName(String name) {
		return sysConfigSmsDao.findByName(name);
	}

}
