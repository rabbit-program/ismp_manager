package org.infosec.ismp.situation.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.infosec.ismp.manager.rmi.bsam.model.MachineSituationVO;
import org.infosec.ismp.manager.rmi.bsam.model.SecurityAreaSituationVO;
import org.infosec.ismp.manager.rmi.bsam.model.SubUnitSituationVO;
import org.infosec.ismp.manager.rmi.bsam.service.SituationService;
import org.infosec.ismp.situation.model.Machine;
import org.infosec.ismp.situation.model.MachineSituation;
import org.infosec.ismp.situation.util.MachineSituationComparator;

public class SituationServiceImpl implements SituationService {
	
	private SituationPipe situationPipe;

	public SituationPipe getSituationPipe() {
		return situationPipe;
	}

	public void setSituationPipe(SituationPipe situationPipe) {
		this.situationPipe = situationPipe;
	}

	@Override
	public SubUnitSituationVO getMachineSituationByMachineId(String machineId,
			Timestamp beginTime, Timestamp endTime) {
		SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
		
		List<org.infosec.ismp.situation.model.MachineSituation>  machineSituationList = situationPipe.getMachineSituation();
		for (org.infosec.ismp.situation.model.MachineSituation machineSituation : machineSituationList) {
			if(machineSituation.getMachine().getId() == Integer.parseInt(machineId)){
				if(machineSituation.getTime().after(beginTime) && machineSituation.getTime().before(endTime)){
					
					subUnitSituationVO.setId(machineSituation.getId());
					subUnitSituationVO.setTime(machineSituation.getTime());
					subUnitSituationVO.setName(machineSituation.getMachine().getMachineName());
					subUnitSituationVO.setType("ZhuJi");
					subUnitSituationVO.setAttackThreat(machineSituation.getAttackThreat());
					subUnitSituationVO.setVirusCondition(machineSituation.getVirusCondition());
					subUnitSituationVO.setInvalidConnection(machineSituation.getInvalidConnection());
					subUnitSituationVO.setWholeSituation(machineSituation.getWholeSituation());
					
				}
			}
		}
		
		return subUnitSituationVO;
	}
	
	@Override
	public SubUnitSituationVO getMachineCabinetSituationByMachineCabinetId(
			String machineCabinetId, Timestamp beginTime, Timestamp endTime) {
		SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
		
		List<org.infosec.ismp.situation.model.MachineCabinetSituation>  machineCabinetSituationList = situationPipe.getMachineCabinetSituation();
		for (org.infosec.ismp.situation.model.MachineCabinetSituation machineCabinetSituation : machineCabinetSituationList) {
			if(machineCabinetSituation.getMachineCabinet().getId() == Integer.parseInt(machineCabinetId)){
				if(machineCabinetSituation.getTime().after(beginTime) && machineCabinetSituation.getTime().before(endTime)){
					
					subUnitSituationVO.setId(machineCabinetSituation.getId());
					subUnitSituationVO.setTime(machineCabinetSituation.getTime());
					subUnitSituationVO.setName(machineCabinetSituation.getMachineCabinet().getMachineCabinetName());
					subUnitSituationVO.setType("JiGui");
					subUnitSituationVO.setAttackThreat(machineCabinetSituation.getAttackThreat());
					subUnitSituationVO.setVirusCondition(machineCabinetSituation.getVirusCondition());
					subUnitSituationVO.setInvalidConnection(machineCabinetSituation.getInvalidConnection());
					subUnitSituationVO.setWholeSituation(machineCabinetSituation.getWholeSituation());
					
				}
			}
		}
		
		return subUnitSituationVO;
	}

	@Override
	public SubUnitSituationVO getMachineRoomSituationByMachineRoomId(
			String machineRoomId, Timestamp beginTime, Timestamp endTime) {
		SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
		
		List<org.infosec.ismp.situation.model.MachineRoomSituation>  machineRoomSituationList = situationPipe.getMachineRoomSituation();
		for (org.infosec.ismp.situation.model.MachineRoomSituation machineRoomSituation : machineRoomSituationList) {
			if(machineRoomSituation.getMachineRoom().getId() == Integer.parseInt(machineRoomId)){
				if(machineRoomSituation.getTime().after(beginTime) && machineRoomSituation.getTime().before(endTime)){
					
					subUnitSituationVO.setId(machineRoomSituation.getId());
					subUnitSituationVO.setTime(machineRoomSituation.getTime());
					subUnitSituationVO.setName(machineRoomSituation.getMachineRoom().getMachineRoomName());
					subUnitSituationVO.setType("JiFang");
					subUnitSituationVO.setAttackThreat(machineRoomSituation.getAttackThreat());
					subUnitSituationVO.setVirusCondition(machineRoomSituation.getVirusCondition());
					subUnitSituationVO.setInvalidConnection(machineRoomSituation.getInvalidConnection());
					subUnitSituationVO.setWholeSituation(machineRoomSituation.getWholeSituation());
					
				}
			}
		}
		
		return subUnitSituationVO;
	}


	@Override
	public SecurityAreaSituationVO getSecurityAreaSituationBySecurityAreaId(
			String domainId, Timestamp beginTime, Timestamp endTime) {
		SecurityAreaSituationVO securityAreaSituationVO = new SecurityAreaSituationVO();
		List<org.infosec.ismp.situation.model.SecurityAreaSituation>  securityAreaSituationList = situationPipe.getSecurityAreaSituation();
		
		for (org.infosec.ismp.situation.model.SecurityAreaSituation securityAreaSituation : securityAreaSituationList) {
			if(securityAreaSituation.getDomain().getId() == Integer.parseInt(domainId)){
				if(securityAreaSituation.getTime().after(beginTime) && securityAreaSituation.getTime().before(endTime)){
					
					securityAreaSituationVO.setId(securityAreaSituation.getId());
					securityAreaSituationVO.setTime(securityAreaSituation.getTime());
					securityAreaSituationVO.setSecurityAreaName(securityAreaSituation.getDomain().getDomainName());
					securityAreaSituationVO.setAttackThreat(securityAreaSituation.getAttackThreat());
					securityAreaSituationVO.setVirusCondition(securityAreaSituation.getVirusCondition());
					securityAreaSituationVO.setInvalidConnection(securityAreaSituation.getInvalidConnection());
					securityAreaSituationVO.setWholeSituation(securityAreaSituation.getWholeSituation());
					
				}
			}
		}
		return securityAreaSituationVO;
	}

	@Override
	public List<MachineSituationVO> getTopMachineSituation(String userDomainStr,
			String isAll, Timestamp beginTime, Timestamp endTime, Integer topNum) {
		String[] domainIds = {};
		if(null != userDomainStr && !"".equals(userDomainStr)){
			domainIds = userDomainStr.split(",");
		}	 
		
		List<org.infosec.ismp.situation.model.MachineSituation>  machineSituationList = situationPipe.getMachineSituation();
		List<org.infosec.ismp.situation.model.MachineSituation> tempMachineSituationList = new ArrayList<MachineSituation>();
		
		for (MachineSituation machineSituation : machineSituationList) {
			if(machineSituation.getTime().after(beginTime) && machineSituation.getTime().before(endTime)){
				if("1".equals(isAll)){
					tempMachineSituationList.add(machineSituation);
				}else {
					Machine tempMachine = machineSituation.getMachine();
					String tempDomainId = "";
					///取出主机所在的安全域id
					if("AnQuanYu".equals(tempMachine.getParentType())){
						tempDomainId = tempMachine.getDomain().getId() + "";
					}else if("JiGui".equals(tempMachine.getParentType())){
						tempDomainId = tempMachine.getMachineCabinet().getMachineRoom().getDomain().getId() + "";
					}else if("JiFang".equals(tempMachine.getParentType())){
						tempDomainId = tempMachine.getMachineRoom().getDomain().getId() + "";
					}
					///判断此安全域id是否在域权限所属之内。
					for (int i = 0; i < domainIds.length; i++) {
						if(tempDomainId.equals(domainIds[i])){
							///符合域权限，则将此态势重新放入list中。
							tempMachineSituationList.add(machineSituation);
							break;
						}
					}
					
				}
			}
		}
		///此时tempMachineSituationList中的态势已经是符合权限 并且是在规定时间内的态势列表了。下边需要处理的是按照整体态势排序
		///并且将前面的数据放入新的列表中，凑够20名。
		Collections.sort(tempMachineSituationList, new MachineSituationComparator());
		
		List<MachineSituationVO> topMachineSituationList = new ArrayList<MachineSituationVO>();
		
		for (MachineSituation machineSituation : tempMachineSituationList) {
			if(topMachineSituationList.size() < 20){
				
				MachineSituationVO tempMachineSituationVO = new MachineSituationVO();
				tempMachineSituationVO.setId(machineSituation.getId());
				tempMachineSituationVO.setIp(machineSituation.getIp());
				tempMachineSituationVO.setMachineDescription(machineSituation.getMachine().getDescription());
				tempMachineSituationVO.setTime(machineSituation.getTime());
				tempMachineSituationVO.setAttackThreat(machineSituation.getAttackThreat());
				tempMachineSituationVO.setVirusCondition(machineSituation.getVirusCondition());
				tempMachineSituationVO.setInvalidConnection(machineSituation.getInvalidConnection());
				tempMachineSituationVO.setWholeSituation(machineSituation.getWholeSituation());
				tempMachineSituationVO.setMachineName(machineSituation.getMachine().getMachineName());
				if("JiGui".equals(machineSituation.getMachine().getParentType())){
					tempMachineSituationVO.setParentType("机柜");
					tempMachineSituationVO.setParentName(machineSituation.getMachine().getMachineCabinet().getMachineCabinetName());
				}else if("JiFang".equals(machineSituation.getMachine().getParentType())){
					tempMachineSituationVO.setParentType("机房");
					tempMachineSituationVO.setParentName(machineSituation.getMachine().getMachineRoom().getMachineRoomName());
				}else if("AnQuanYu".equals(machineSituation.getMachine().getParentType())){
					tempMachineSituationVO.setParentType("安全域");
					tempMachineSituationVO.setParentName(machineSituation.getMachine().getDomain().getDomainName());
				}
				
				if(!topMachineSituationList.contains(tempMachineSituationVO)){
					topMachineSituationList.add(tempMachineSituationVO);
				}
			}
		}
		
		
//		/** 以下模拟RMI返回结果测试 **/
//		 List<MachineSituationVO> topMachineSituationList = new ArrayList<MachineSituationVO>();
//		 for (int i = 0; i < 20; i++) {
//			 MachineSituationVO tempMachineSituationVO = new MachineSituationVO();
//			 tempMachineSituationVO.setId(i);
//			 tempMachineSituationVO.setIp("192.168.9.121");
//			 tempMachineSituationVO.setMachineDescription("这是主机信息");
//			 tempMachineSituationVO.setTime(new Timestamp(System.currentTimeMillis()));
//			 tempMachineSituationVO.setAttackThreat(3.5f);
//			 tempMachineSituationVO.setVirusCondition(4.5f);
//			 tempMachineSituationVO.setInvalidConnection(5.5f);
//			 tempMachineSituationVO.setWholeSituation((20-i)*5f);///模拟生成100以内随机数
//			 tempMachineSituationVO.setMachineName("模拟主机");
//			 tempMachineSituationVO.setParentName("模拟机房");
//			 tempMachineSituationVO.setParentType("JiFang");
//			 topMachineSituationList.add(tempMachineSituationVO);
//		}
//		/** 以上模拟RMI返回结果测试 **/
		return topMachineSituationList;
	}

}
