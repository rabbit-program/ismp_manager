package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.SysCenterDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.SysCenter;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.SysCenterService;

public class SysCenterServiceImpl implements SysCenterService {
	
	private SysCenterDao sysCenterDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setSysCenterDao(SysCenterDao sysCenterDao) {
		this.sysCenterDao = sysCenterDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addSysCenter(SysCenter sysCenter) throws Exception {
		sysCenterDao.addSysCenter(sysCenter);
	}
	public void deleteSysCenter(SysCenter sysCenter) throws Exception {
		sysCenterDao.deleteSysCenter(sysCenter);
	}
	public void updateSysCenter(SysCenter sysCenter) throws Exception {
		sysCenterDao.updateSysCenter(sysCenter);
	}
	public List<SysCenter> findAllSysCenter() throws Exception {
		List<SysCenter> list = sysCenterDao.findAllSysCenter();
		return list;
	}
	public SysCenter findSysCenterById(int id) throws Exception {
		SysCenter sysCenter = sysCenterDao.findSysCenterById(id);
		return sysCenter;
	}
	public List<SysCenter> findAllSysCenter(int startResult, int maxResult)
			throws Exception {
		List<SysCenter> list = sysCenterDao.findAllSysCenter(startResult, maxResult);
		return list;
	}
	public long findAllNum() throws Exception {
		return sysCenterDao.findAllNum();
	}

}
