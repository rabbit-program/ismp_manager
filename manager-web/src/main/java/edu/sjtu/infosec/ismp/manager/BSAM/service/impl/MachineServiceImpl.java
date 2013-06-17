package edu.sjtu.infosec.ismp.manager.BSAM.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineCabinetDao;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineDao;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineRoomDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.Machine;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineCabinet;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineRoom;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.DomainDao;
import edu.sjtu.infosec.ismp.security.Domain;

public class MachineServiceImpl implements MachineService {
	
	private MachineDao machineDao;
	
	private MachineCabinetDao machineCabinetDao;
	
	private MachineRoomDao machineRoomDao;
	
	private DomainDao domainDao;

	public void setMachineDao(MachineDao machineDao) {
		this.machineDao = machineDao;
	}
	
	public void setMachineCabinetDao(MachineCabinetDao machineCabinetDao) {
		this.machineCabinetDao = machineCabinetDao;
	}

	public void setMachineRoomDao(MachineRoomDao machineRoomDao) {
		this.machineRoomDao = machineRoomDao;
	}

	public void setDomainDao(DomainDao domainDao) {
		this.domainDao = domainDao;
	}

	@SuppressWarnings("unchecked")
	public List getMachineList() {
		return machineDao.getMachineList();
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineList(int startResult, int maxResult) {
		return machineDao.getMachineList(startResult, maxResult);
	}
	
	@SuppressWarnings("unchecked")
	public List getMachineListByDomain(List<Domain> userDomainList,int startResult, int maxResult) {
		
//		   x.id,x.description,x.ip,x.machine_name,x.parent_type,
//		   x.weight,x.machine_cabinet_id,x.machine_room_id,x.security_area_id
		
		List<Object[]> tempMachineList = machineDao.getMachineListByDomain(userDomainList, startResult, maxResult);
		List<Machine> machineList = new ArrayList<Machine>();
		///将List<Object[]> tempMachineList解析成List<Machine>
		if(null != tempMachineList && tempMachineList.size() > 0){
			for (int i = 0; i < tempMachineList.size(); i++) {
				Object[] object = (Object[]) tempMachineList.get(i);
				Machine machine = new Machine();
				machine.setId((Integer)object[0]);///id
				machine.setDescription((String)object[1]);///description
				machine.setIp((String)object[2]);///ip
				machine.setMachineName((String)object[3]);///machine_name
				machine.setParentType((String)object[4]);///parent_type
				machine.setWeight((Integer)object[5]);///weight
				
				try {
					if("JiGui".equals((String)object[4])){
						machine.setMachineCabinet((MachineCabinet)machineCabinetDao.getObject(MachineCabinet.class, (Integer)object[6]));
					}else if("JiFang".equals((String)object[4])){
						machine.setMachineRoom((MachineRoom)machineRoomDao.getObject(MachineRoom.class, (Integer)object[7]));
					}else if("AnQuanYu".equals((String)object[4])){
						machine.setDomain(domainDao.findById((Integer)object[8]));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				machineList.add(machine);
			}
		}
		
		return machineList;
	}
	
	public void deleteMachineById(Integer id) {
		machineDao.removeObject(Machine.class, id);
	}
	
	public Machine getMachineById(Integer id) {
		return (Machine) machineDao.getObject(Machine.class, id);
	}
	
	public void saveOrUpdate(Machine machine) {
		machineDao.saveOrUpdate(machine);
	}

	public int getCount() {
		return machineDao.getCount();
	}

	public int getCountByDomain(List<Domain> userDomainList) {
		return machineDao.getCountByDomain(userDomainList);
	}

	@SuppressWarnings("unchecked")
	public List getTopMachineListByWeight(int maxResult) {
		return machineDao.getTopMachineListByWeight(maxResult);
	}

	@SuppressWarnings("unchecked")
	public List getTopMachineListByWeightByDomain(List<Domain> userDomainList,int maxResult) {
//		   x.id,x.description,x.ip,x.machine_name,x.parent_type,
//		   x.weight,x.machine_cabinet_id,x.machine_room_id,x.security_area_id
		
		List<Object[]> tempTopMachineList = machineDao.getTopMachineListByWeightByDomain(userDomainList, maxResult);
		List<Machine> topMachineList = new ArrayList<Machine>();
		///将List<Object[]> tempTopMachineList解析成List<Machine> topMachineList
		if(null != tempTopMachineList && tempTopMachineList.size() > 0){
			for (int i = 0; i < tempTopMachineList.size(); i++) {
				Object[] object = (Object[]) tempTopMachineList.get(i);
				Machine machine = new Machine();
				machine.setId((Integer)object[0]);///id
				machine.setDescription((String)object[1]);///description
				machine.setIp((String)object[2]);///ip
				machine.setMachineName((String)object[3]);///machine_name
				machine.setParentType((String)object[4]);///parent_type
				machine.setWeight((Integer)object[5]);///weight
				
				try {
					if("JiGui".equals((String)object[4])){
						machine.setMachineCabinet((MachineCabinet)machineCabinetDao.getObject(MachineCabinet.class, (Integer)object[6]));
					}else if("JiFang".equals((String)object[4])){
						machine.setMachineRoom((MachineRoom)machineRoomDao.getObject(MachineRoom.class, (Integer)object[7]));
					}else if("AnQuanYu".equals((String)object[4])){
						machine.setDomain(domainDao.findById((Integer)object[8]));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				topMachineList.add(machine);
			}
		}
		
		return topMachineList;
	}
//	====================================================
}
