package org.infosec.ismp.situation.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.infosec.ismp.situation.model.MachineCabinetSituation;
import org.infosec.ismp.situation.model.MachineRoomSituation;
import org.infosec.ismp.situation.model.MachineSituation;
import org.infosec.ismp.situation.model.SecurityAreaSituation;

/**
 * 通道，用于存放数据以便RMI取
 * @author cchang 
 * 2011-2-25 10:54:58
 */
public class SituationPipe {
	
	private static final int MAX_SIZE = 800;
	
	public LinkedList<MachineSituation> machineSituationList = null;
	
	public LinkedList<MachineCabinetSituation> machineCabinetSituationList = null;
	
	public LinkedList<MachineRoomSituation> machineRoomSituationList = null;
	
	public LinkedList<SecurityAreaSituation> securityAreaSituationList = null;
	
	///构造器
	public SituationPipe() {
		machineSituationList = new LinkedList<MachineSituation>();
		machineCabinetSituationList = new LinkedList<MachineCabinetSituation>();
		machineRoomSituationList = new LinkedList<MachineRoomSituation>();
		securityAreaSituationList = new LinkedList<SecurityAreaSituation>();
	}

	public synchronized void addMachineSituations(List<MachineSituation> machineSituations) {
		
		for (MachineSituation machineSituation : machineSituations) {
			if (null != machineSituation) {
				machineSituationList.addFirst(machineSituation);
			}
			if (machineSituationList.size() > MAX_SIZE) {
				machineSituationList.removeLast();
			}
		}
		
	}

	public synchronized void addMachineCabinetSiuations(List<MachineCabinetSituation> machineCabinetSituations) {
		
		for (MachineCabinetSituation machineCabinetSituation : machineCabinetSituations) {
			if (null != machineCabinetSituation) {
				machineCabinetSituationList.addFirst(machineCabinetSituation);		    	    
			}
			if (machineCabinetSituationList.size() > MAX_SIZE) {
				machineCabinetSituationList.removeLast();
			}
		}
	}
	
	public synchronized void addMachineRoomSituations(List<MachineRoomSituation> machineRoomSituations) {
		
		for (MachineRoomSituation machineRoomSituation : machineRoomSituations) {
			if (null != machineRoomSituation) {
				machineRoomSituationList.addFirst(machineRoomSituation);
			}
			if (machineRoomSituationList.size() > MAX_SIZE) {
				machineRoomSituationList.removeLast();
			}
		}
	}
	
	public synchronized void addSecurityAreaSituations(List<SecurityAreaSituation> securityAreaSituations) {
		
		for (SecurityAreaSituation securityAreaSituation : securityAreaSituations) {
			if (null != securityAreaSituation) {
				securityAreaSituationList.addFirst(securityAreaSituation);
			}
			if (securityAreaSituationList.size() > MAX_SIZE) {
				securityAreaSituationList.removeLast();
			}
		}
	}
	
	public synchronized List<MachineSituation> getMachineSituation() {
		List<MachineSituation> results = new ArrayList<MachineSituation>();
		
		for (int i = 0; i < machineSituationList.size(); i++) {
			MachineSituation machineSituation = (MachineSituation) machineSituationList.get(i);
			results.add(machineSituation);
		}
		return results;
	}
	
	public synchronized List<MachineCabinetSituation> getMachineCabinetSituation() {
		List<MachineCabinetSituation> results = new ArrayList<MachineCabinetSituation>();
		
		for (int i = 0; i < machineCabinetSituationList.size(); i++) {
			MachineCabinetSituation machineCabinetSituation = (MachineCabinetSituation) machineCabinetSituationList.get(i);
			results.add(machineCabinetSituation);
		}
		return results;
	}

	public synchronized List<MachineRoomSituation> getMachineRoomSituation() {
		List<MachineRoomSituation> results = new ArrayList<MachineRoomSituation>();
		
		for (int i = 0; i < machineRoomSituationList.size(); i++) {
			MachineRoomSituation machineRoomSituation = (MachineRoomSituation) machineRoomSituationList.get(i);
			results.add(machineRoomSituation);
		}
		return results;
	}
	
	public synchronized List<SecurityAreaSituation> getSecurityAreaSituation() {
		List<SecurityAreaSituation> results = new ArrayList<SecurityAreaSituation>();
		
		for (int i = 0; i < securityAreaSituationList.size(); i++) {
			SecurityAreaSituation securityAreaSituation = (SecurityAreaSituation) securityAreaSituationList.get(i);
			results.add(securityAreaSituation);
		}
		return results;
	}


	
	public synchronized void clearMachineSituation(){
	    machineSituationList.clear();
	}
	
	public synchronized void clearMachineCabinetSituation(){
	    machineCabinetSituationList.clear();
	}
	
	public synchronized void clearMachineRoomSituation(){
	    machineRoomSituationList.clear();
	}
	
	public synchronized void clearSecurityAreaSituation(){
		securityAreaSituationList.clear();
	}
	
}
