package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusTypeDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusType;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusTypeService;

public class VirusTypeServiceImpl implements VirusTypeService {
	
	private VirusTypeDao virusTypeDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setVirusTypeDao(VirusTypeDao virusTypeDao) {
		this.virusTypeDao = virusTypeDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addVirusType(VirusType virusType) throws Exception {
		virusTypeDao.addVirusType(virusType);
	}
	public void deleteVirusType(VirusType virusType) throws Exception {
		virusTypeDao.deleteVirusType(virusType);
	}
	public void updateVirusType(VirusType virusType) throws Exception {
		virusTypeDao.updateVirusType(virusType);
	}
	public List<VirusType> findAllVirusType() throws Exception {
		List<VirusType> list = virusTypeDao.findAllVirusType();
		return list;
	}
	public VirusType findVirusTypeById(int id) throws Exception {
		VirusType virusType = virusTypeDao.findVirusTypeById(id);
		return virusType;
	}
	public List<VirusType> findAllVirusType(int startResult, int maxResult)
			throws Exception {
		List<VirusType> list = virusTypeDao.findAllVirusType(startResult, maxResult);
		return list;
	}
	public long findAllNum() throws Exception {
		return virusTypeDao.findAllNum();
	}

}
