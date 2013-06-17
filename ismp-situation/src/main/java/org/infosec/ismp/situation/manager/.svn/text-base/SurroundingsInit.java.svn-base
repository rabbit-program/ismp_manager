package org.infosec.ismp.situation.manager;

import java.util.Map;

import org.infosec.ismp.situation.dao.ColorThresholdDao;
import org.infosec.ismp.situation.dao.MachineCabinetDao;
import org.infosec.ismp.situation.dao.MachineDao;
import org.infosec.ismp.situation.dao.MachineRoomDao;
import org.infosec.ismp.situation.dao.SecurityAreaDao;
import org.infosec.ismp.situation.model.Domain;
import org.infosec.ismp.situation.model.Machine;
import org.infosec.ismp.situation.model.MachineCabinet;
import org.infosec.ismp.situation.model.MachineRoom;
/**
 * 用于封装主机、机柜、机房、安全域。
 * @author Administrator
 *
 */
public class SurroundingsInit {
	
	private MachineDao machineDao;///注入machineDao
	
	private MachineCabinetDao machineCabinetDao;///注入machineCabinetDao
	
	private MachineRoomDao machineRoomDao;///注入machineRoomDao
	
	private SecurityAreaDao securityAreaDao;///注入securityAreaDao
	
	private ColorThresholdDao colorThresholdDao;///注入colorThresholdDao
	
	private Map<String,Machine> maMap;///主机信息
	
	private Map<Integer,MachineCabinet> mcMap;///机柜信息
	
	private Map<Integer,MachineRoom> mrMap;///机房信息
	
	private Map<Integer,Domain> saMap;///安全域信息
	
	private Map<String,Integer> colorMap;///告警颜色对应值
	
	public void setMachineDao(MachineDao machineDao) {
		this.machineDao = machineDao;
	}
	
	public void setMachineCabinetDao(MachineCabinetDao machineCabinetDao) {
		this.machineCabinetDao = machineCabinetDao;
	}
		
	public void setMachineRoomDao(MachineRoomDao machineRoomDao) {
		this.machineRoomDao = machineRoomDao;
	}

	public void setSecurityAreaDao(SecurityAreaDao securityAreaDao) {
		this.securityAreaDao = securityAreaDao;
	}
	
	public void setColorThresholdDao(ColorThresholdDao colorThresholdDao) {
		this.colorThresholdDao = colorThresholdDao;
	}

	public Map<String, Integer> getColorMap() {
		return colorMap;
	}

	public void setColorMap(Map<String, Integer> colorMap) {
		this.colorMap = colorMap;
	}
	
	public Map<Integer, MachineCabinet> getMcMap() {
		return mcMap;
	}
	
	public void setMcMap(Map<Integer, MachineCabinet> mcMap) {
		this.mcMap = mcMap;
	}
	
	public Map<Integer, MachineRoom> getMrMap() {
		return mrMap;
	}

	public void setMrMap(Map<Integer, MachineRoom> mrMap) {
		this.mrMap = mrMap;
	}

	public Map<Integer, Domain> getSaMap() {
		return saMap;
	}

	public void setSaMap(Map<Integer, Domain> saMap) {
		this.saMap = saMap;
	}

	public Map<String, Machine> getMaMap() {
		return maMap;
	}

	public void setMaMap(Map<String, Machine> maMap) {
		this.maMap = maMap;
	}

	public void start() {
		maMap = machineDao.getAllMachine();///获取全部主机信息
		mcMap = machineCabinetDao.getAllMachineCabinet();///获取全部机柜信息
		mrMap = machineRoomDao.getAllMachineRoom();///获取全部机房信息
		saMap = securityAreaDao.getAllSecurityArea();///获取全部安全域信息
		colorMap = colorThresholdDao.get();///获取告警颜色信息
		if (maMap == null && maMap.size()==0) {
			System.out.println("主机信息为空！！！");
		}
		if (mcMap == null && mcMap.size()==0) {
			System.out.println("机柜信息为空！！！");
		}
		if (mrMap == null && mrMap.size()==0) {
			System.out.println("机房信息为空！！！");
		}
		if (saMap == null && saMap.size()==0) {
			System.out.println("安全域信息为空！！！");
		}
		if (colorMap == null && colorMap.size()==0) {
			System.out.println("告警颜色信息为空！！！");
		}
	}

}
