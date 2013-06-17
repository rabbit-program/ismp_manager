package org.infosec.ismp.manager.rmi.sysm.config.service.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.sysm.config.dao.SysConfigDbDao;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigDb;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigDbService;

/**
 * 
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
public class SysConfigDbServiceImpl implements SysConfigDbService {
	
	private SysConfigDbDao sysConfigDbDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setSysConfigDbDao(SysConfigDbDao sysConfigDbDao) {
		this.sysConfigDbDao = sysConfigDbDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	

	public void add(SysConfigDb db) throws Exception {
		sysConfigDbDao.add(db);
	}

	public void delete(SysConfigDb db) throws Exception {
		sysConfigDbDao.delete(db);
	}

	public void update(SysConfigDb db) throws Exception {
		sysConfigDbDao.update(db);
	}

	public List<SysConfigDb> findAll() throws Exception {
		List<SysConfigDb> list = sysConfigDbDao.findAll();
		return list;
	}

	public SysConfigDb findById(int id) {
		return sysConfigDbDao.findById(id);
	}

	public SysConfigDb findByName(String name) {
		return sysConfigDbDao.findByName(name);
	}

}
