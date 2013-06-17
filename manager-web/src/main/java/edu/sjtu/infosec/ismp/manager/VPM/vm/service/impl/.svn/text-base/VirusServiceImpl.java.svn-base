package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.Virus;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusService;

public class VirusServiceImpl implements VirusService {
	
	private VirusDao virusDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setVirusDao(VirusDao virusDao) {
		this.virusDao = virusDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addVirus(Virus virus) throws Exception {
		virusDao.addVirus(virus);
	}
	public void deleteVirus(Virus virus) throws Exception {
		virusDao.deleteVirus(virus);
	}
	public void updateVirus(Virus virus) throws Exception {
		virusDao.updateVirus(virus);
	}
	public List<Virus> findAllVirus() throws Exception {
		List<Virus> list = virusDao.findAllVirus();
		return list;
	}
	public Virus findVirusById(int id) throws Exception {
		Virus virus = virusDao.findVirusById(id);
		return virus;
	}
	public List<Virus> findAllVirus(int startResult, int maxResult)
			throws Exception {
		List<Virus> list = virusDao.findAllVirus(startResult, maxResult);
		return list;
	}
	public long findAllNum() throws Exception {
		return virusDao.findAllNum();
	}

}
