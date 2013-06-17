package edu.sjtu.infosec.ismp.manager.BSAM.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineCabinetDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.Machine;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineCabinet;
import edu.sjtu.infosec.ismp.manager.BSAM.model.SubUnitVO;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineCabinetService;
import edu.sjtu.infosec.ismp.security.Domain;

public class MachineCabinetServiceImpl implements MachineCabinetService {
	
	private MachineCabinetDao machineCabinetDao;
	
	public MachineCabinetDao getMachineCabinetDao() {
		return machineCabinetDao;
	}

	public void setMachineCabinetDao(MachineCabinetDao machineCabinetDao) {
		this.machineCabinetDao = machineCabinetDao;
	}

	@SuppressWarnings("unchecked")
	public List getMachineCabinetList() {
		return machineCabinetDao.getMachineCabinetList();
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineCabinetList(int startResult, int maxResult) {
		return machineCabinetDao.getMachineCabinetList(startResult, maxResult);
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineCabinetListByDomain(List<Domain> userDomainList,int startResult, int maxResult) {
		return machineCabinetDao.getMachineCabinetListByDomain(userDomainList, startResult, maxResult);
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineCabinetListByDomain(List<Domain> userDomainList) {
		return machineCabinetDao.getMachineCabinetListByDomain(userDomainList);
	}
	
	public void deleteMachineCabinetById(Integer id) {
		machineCabinetDao.removeObject(MachineCabinet.class, id);
	}

	public MachineCabinet getMachineCabinetById(Integer id) {
		return (MachineCabinet) machineCabinetDao.getObject(MachineCabinet.class, id);
	}
	
	public List<MachineCabinet> getMachineCabinetByName(String name) {
		return machineCabinetDao.getMachineCabinetByName(name);
	}
	
	public void saveOrUpdate(MachineCabinet machineCabinet) {
		machineCabinetDao.saveOrUpdateMachineCabinet(machineCabinet);
	}

	public int getCount() {
		return machineCabinetDao.getCount();
	}

	public int getCountByDomain(List<Domain> userDomainList) {
		return machineCabinetDao.getCountByDomain(userDomainList);
	}

	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id, int startResult, int maxResult) {
		
		List<Machine> tempSubUnitList = machineCabinetDao.getSubUnitById(id,startResult,maxResult);
		List<SubUnitVO> subUnitList = new ArrayList<SubUnitVO>();
		if(null != tempSubUnitList && tempSubUnitList.size() > 0){
			for (int i = 0; i < tempSubUnitList.size(); i++) {
				Machine machine = (Machine) tempSubUnitList.get(i);
				SubUnitVO subUnitVO = new SubUnitVO();
				subUnitVO.setId(machine.getId());///id
				subUnitVO.setName(machine.getMachineName());///name
				subUnitVO.setType("ZhuJi");///type
				subUnitList.add(subUnitVO);
			}
		}
		return subUnitList;
	}
	
	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id) {
		
		List<Machine> tempSubUnitList = machineCabinetDao.getSubUnitById(id);
		List<SubUnitVO> subUnitList = new ArrayList<SubUnitVO>();
		if(null != tempSubUnitList && tempSubUnitList.size() > 0){
			for (int i = 0; i < tempSubUnitList.size(); i++) {
				Machine machine = (Machine) tempSubUnitList.get(i);
				SubUnitVO subUnitVO = new SubUnitVO();
				subUnitVO.setId(machine.getId());///id
				subUnitVO.setName(machine.getMachineName());///name
				subUnitVO.setType("ZhuJi");///type
				subUnitList.add(subUnitVO);
			}
		}
		return subUnitList;
	}

	public int getSubUnitCountById(String id) {
		return machineCabinetDao.getSubUnitCountById(id);
	}

//	====================================================
	
	

}
