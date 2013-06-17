package edu.sjtu.infosec.ismp.manager.BSAM.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineRoomDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineRoom;
import edu.sjtu.infosec.ismp.manager.BSAM.model.SubUnitVO;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineRoomService;
import edu.sjtu.infosec.ismp.security.Domain;

public class MachineRoomServiceImpl implements MachineRoomService {
	
	private MachineRoomDao machineRoomDao;
	
	public MachineRoomDao getMachineRoomDao() {
		return machineRoomDao;
	}

	public void setMachineRoomDao(MachineRoomDao machineRoomDao) {
		this.machineRoomDao = machineRoomDao;
	}

	@SuppressWarnings("unchecked")
	public List getMachineRoomList() {
		return machineRoomDao.getMachineRoomList();
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineRoomList(int startResult, int maxResult) {
		return machineRoomDao.getMachineRoomList(startResult, maxResult);
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineRoomListByDomain(List<Domain> userDomainList,int startResult, int maxResult) {
		return machineRoomDao.getMachineRoomListByDomain(userDomainList, startResult, maxResult);
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineRoomListByDomain(List<Domain> userDomainList) {
		return machineRoomDao.getMachineRoomListByDomain(userDomainList);
	}
	
	public void deleteMachineRoomById(Integer id) {
		machineRoomDao.removeObject(MachineRoom.class, id);
	}

	public MachineRoom getMachineRoomById(Integer id) {
		return (MachineRoom) machineRoomDao.getObject(MachineRoom.class, id);
	}
	
	public List<MachineRoom> getMachineRoomByName(String name) {
		return machineRoomDao.getMachineRoomByName(name);
	}

	public void saveOrUpdate(MachineRoom machineRoom) {
		machineRoomDao.saveOrUpdateMachineRoom(machineRoom);
	}

	public int getCount() {
		return machineRoomDao.getCount();
	}

	public int getCountByDomain(List<Domain> userDomainList) {
		return machineRoomDao.getCountByDomain(userDomainList);
	}

	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id, int startResult, int maxResult) {
//		select c.id,c.name,c.type from 
		List<Object[]> tempSubUnitList = machineRoomDao.getSubUnitById(id,startResult,maxResult);
		List<SubUnitVO> subUnitList = new ArrayList<SubUnitVO>();
		///将List<Object[]> tempSubUnitList解析成List<SubUnitVO>
		if(null != tempSubUnitList && tempSubUnitList.size() > 0){
			for (int i = 0; i < tempSubUnitList.size(); i++) {
				Object[] object = (Object[]) tempSubUnitList.get(i);
				SubUnitVO subUnitVO = new SubUnitVO();
				subUnitVO.setId((Integer)object[0]);///id
				subUnitVO.setName((String)object[1]);///name
				subUnitVO.setType((String)object[2]);///type
				subUnitList.add(subUnitVO);
			}
		}
		return subUnitList;
	}

	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id) {
//		select c.id,c.name,c.type from 
		List<Object[]> tempSubUnitList = machineRoomDao.getSubUnitById(id);
		List<SubUnitVO> subUnitList = new ArrayList<SubUnitVO>();
		///将List<Object[]> tempSubUnitList解析成List<SubUnitVO>
		if(null != tempSubUnitList && tempSubUnitList.size() > 0){
			for (int i = 0; i < tempSubUnitList.size(); i++) {
				Object[] object = (Object[]) tempSubUnitList.get(i);
				SubUnitVO subUnitVO = new SubUnitVO();
				subUnitVO.setId((Integer)object[0]);///id
				subUnitVO.setName((String)object[1]);///name
				subUnitVO.setType((String)object[2]);///type
				subUnitList.add(subUnitVO);
			}
		}
		return subUnitList;
	}

	public int getSubUnitCountById(String id) {
		return machineRoomDao.getSubUnitCountById(id);
	}

	//	====================================================
	
	

}
