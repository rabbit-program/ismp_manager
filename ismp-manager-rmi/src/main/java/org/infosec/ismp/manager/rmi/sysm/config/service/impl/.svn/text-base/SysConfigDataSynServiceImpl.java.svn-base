package org.infosec.ismp.manager.rmi.sysm.config.service.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.sysm.config.dao.SysConfigDataSynDao;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigDataSyn;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigDataSynService;

/**
 * 
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
public class SysConfigDataSynServiceImpl implements SysConfigDataSynService {
	
	private SysConfigDataSynDao sysConfigDataSynDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setSysConfigDataSynDao(SysConfigDataSynDao sysConfigDataSynDao) {
		this.sysConfigDataSynDao = sysConfigDataSynDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	

	public void add(SysConfigDataSyn dataSyn) throws Exception {
		sysConfigDataSynDao.add(dataSyn);
	}

	public void delete(SysConfigDataSyn dataSyn) throws Exception {
		sysConfigDataSynDao.delete(dataSyn);
	}

	public void update(SysConfigDataSyn dataSyn) throws Exception {
		sysConfigDataSynDao.update(dataSyn);
	}

	public List<SysConfigDataSyn> findAll() throws Exception {
		List<SysConfigDataSyn> list = sysConfigDataSynDao.findAll();
		return list;
	}

	public SysConfigDataSyn findById(int id) {
		return sysConfigDataSynDao.findById(id);
	}

	public SysConfigDataSyn findByName(String name) {
		return sysConfigDataSynDao.findByName(name);
	}

}
