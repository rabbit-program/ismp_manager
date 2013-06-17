package org.infosec.ismp.situation.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.infosec.ismp.situation.model.Domain;
import org.infosec.ismp.situation.model.Machine;
import org.infosec.ismp.situation.model.MachineCabinet;
import org.infosec.ismp.situation.model.MachineCabinetSituation;
import org.infosec.ismp.situation.model.MachineRoom;
import org.infosec.ismp.situation.model.MachineRoomSituation;
import org.infosec.ismp.situation.model.MachineSituation;
import org.infosec.ismp.situation.model.SecurityAreaSituation;
import org.infosec.ismp.situation.model.SituationEvent;
import org.infosec.ismp.situation.util.SituationUtils;

public class SituationResultCalculate implements Runnable {

	private Map<String, Float> am;// 主机的攻击威胁指数
	private Map<String, Float> vm;// 主机的病毒疫情指数
	private Map<String, Float> im;// 主机的非法连接指数
	private SituationSaveToDB saveToDB;//
	private Map<String, Machine> maMap;// 主机信息Map
	private int index;// 序列号
	private Timestamp time;// 时间　
	private Map<Integer, MachineCabinet> mc;// 机柜信息
	private Map<Integer, MachineRoom> mr;// 机房信息
	private Map<Integer, Domain> sa;// 安全域信息
	private List<SituationEvent> situationEvents;
	
	///构造方法
	public SituationResultCalculate(int vindex, Timestamp vtime,
			Map<String, Float> vam, Map<String, Float> vvm,
			Map<String, Float> vim, SituationSaveToDB vsaveToDB,
			Map<String, Machine> vmaMap, Map<Integer, MachineCabinet> vmc,
			Map<Integer, MachineRoom> vmr,
			Map<Integer, Domain> vsa,
			List<SituationEvent> tempList) {
		this.index = vindex;
		this.time = vtime;
		this.am = vam;
		this.vm = vvm;
		this.im = vim;
		this.saveToDB = vsaveToDB;
		this.maMap = vmaMap;
		this.mr = vmr;
		this.mc = vmc;
		this.sa = vsa;
		this.situationEvents = tempList;
	}

	public void run() {
		Set<String> machineSet = new HashSet<String>();
		if (am != null && am.size() > 0) {
			machineSet.addAll(am.keySet());///am:主机的攻击威胁指数
		}
		if (vm != null && vm.size() > 0) {
			machineSet.addAll(vm.keySet());///vm:主机的病毒疫情指数
		}
		if (im != null && im.size() > 0) {
			machineSet.addAll(im.keySet());///im:主机的非法连接指数
		}
		List<MachineSituation> ms = machineSituationReckon(machineSet);///根据主机攻击态势、病毒态势、非法连接态势计算主机整体态势
		List<MachineCabinetSituation> mcs = machineCabinetSituationReckon(ms);///根据主机态势计算机柜态势
		List<MachineRoomSituation> mrs = machineRoomSituationReckon(ms);///根据主机态势计算机房态势
//		TotalMachineRoomSituation total = totalSituationReckon(mrs);
		List<SecurityAreaSituation> sas = securityAreaSituationReckon(ms);///根据主机态势计算安全域态势
		List<SituationEvent> tempList = removeNoIp(situationEvents,maMap); 
		saveToDB.saveSixSituationToDB(index, ms, mcs, mrs, sas, tempList);///保存态势入库，保存事件入库
	}
	
	///过滤态势事件：只保存生成态势的事件，在主机表中不存在IP的事件不保存，这类事件丢弃
	private List<SituationEvent> removeNoIp(List<SituationEvent> situationEvents, Map<String, Machine> maMap) {
		List<SituationEvent> _list = new ArrayList<SituationEvent>();
		for (SituationEvent situationEvent : situationEvents) {
			if(maMap.containsKey(situationEvent.getEventIP())){
				_list.add(situationEvent);
			}
		}
		return _list;
	}

	/**
	 * 根据machineSet计算主机的态势
	 * @param machineSet
	 * @return
	 */
	private List<MachineSituation> machineSituationReckon(Set<String> machineSet) {
		float rt = 0;
		float rv = 0;
		float rc = 0;
		List<MachineSituation> list = new ArrayList<MachineSituation>();
		Iterator<String> it = machineSet.iterator();
//		am; 主机的攻击威胁指数
//		vm; 主机的病毒疫情指数
//		im; 主机的非法连接指数
		while (it.hasNext()) {
			MachineSituation ms = new MachineSituation();
			String ip = it.next();
			if(maMap.containsKey(ip)){///如果主机列表中存在这个ip则计算态势，如果不存在则丢弃
				if (am.containsKey(ip)) {
					rt = am.get(ip);
				} else {
					rt = 0;
				}
				if (vm.containsKey(ip)) {
					rv = vm.get(ip);
				} else {
					rv = 0;
				}
				if (im.containsKey(ip)) {
					rc = im.get(ip);
				} else {
					rc = 0;
				}
				///得到主机/服务器的总态势指数
				float machineValue = SituationUtils.hostExponential(rt, rv, rc);
				ms.setAttackThreat(rt);///攻击威胁指数
				ms.setInvalidConnection(rc);///非法连接指数
				ms.setIp(ip);///IP地址
				ms.setTime(time);///时间
				ms.setVirusCondition(rv);///病毒疫情指数
				ms.setWholeSituation(machineValue);///整体态势
				Machine machine = maMap.get(ip);
				ms.setMachine(machine);
				list.add(ms);///将MachineSituation放入List<MachineSituation>中
			}
		}
		return list;
	}
	
	/**
	 * 根据主机的态势计算机柜的态势。
	 * @param dates
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<MachineCabinetSituation> machineCabinetSituationReckon(List<MachineSituation> dates) {
		List<MachineCabinetSituation> list = new ArrayList<MachineCabinetSituation>();
		Map<Integer, MachineCabinetSituation> mcsMap = new HashMap<Integer, MachineCabinetSituation>();
		Iterator<MachineSituation> it = dates.iterator();
		while (it.hasNext()) {///循环遍历主机的态势列表
			MachineSituation ms = it.next();///取出态势列表中的每个态势(MachineSituation)
			String ip = ms.getIp();///取出IP
			if (maMap.containsKey(ip)) {///如果主机列表中存在这个IP
				Machine machine = maMap.get(ip);///根据这个IP获取相应的主机
				MachineCabinet machineCabinet = machine.getMachineCabinet();
				if(null != machineCabinet){
					int mcsId = machineCabinet.getId();///获取这个主机所在的机柜id
					if (mcsMap.containsKey(mcsId)) {///如果机柜态势集合中存在这个机柜
						MachineCabinetSituation date = mcsMap.get(mcsId);///得到这个机柜的态势表记录
						float wholdValue = date.getWholeSituation();///得到这个机柜的整体态势
						///重新计算这个机柜的整体态势(算法：(主机整体态势*主机权重)的累加和)
						wholdValue = wholdValue + ms.getWholeSituation()* machine.getWeight();///累加上这个主机的整体态势
						date.setWholeSituation(wholdValue);///重新set这个机柜的整体态势
						
						float attackValue = date.getAttackThreat();
						attackValue = attackValue + ms.getAttackThreat()* machine.getWeight();
						date.setAttackThreat(attackValue);
						
						float virusValue = date.getVirusCondition();
						virusValue = virusValue + ms.getVirusCondition()* machine.getWeight();
						date.setVirusCondition(virusValue);
						
						float invalidValue = date.getInvalidConnection();
						invalidValue = invalidValue + ms.getInvalidConnection()* machine.getWeight();
						date.setInvalidConnection(invalidValue);
						
						date.addCount(machine.getWeight());
						mcsMap.put(mcsId, date);///将计算好的机柜态势放入机柜态势集合Map<Integer, MachineCabinetSituation> mcsMap
					} else {///如果机柜态势集合中不存在这个机柜
						MachineCabinetSituation date = new MachineCabinetSituation();///新建一条机柜态势记录
//						date.setMachineCabinetId(machine.getMachineCabinetId());///设定机柜态势记录的机柜id
						date.setMachineCabinet(machine.getMachineCabinet());///设定机柜态势记录的机柜id
						date.setMachineCabinetName(machine.getMachineCabinet().getMachineCabinetName());///设定机柜态势记录的机柜name
						date.setTime(ms.getTime());///设定机柜态势记录的时间
						date.setAttackThreat(ms.getAttackThreat());
						date.setVirusCondition(ms.getVirusCondition());
						date.setInvalidConnection(ms.getInvalidConnection());
						date.setWholeSituation(ms.getWholeSituation());///设定机柜态势记录的整体态势
						date.addCount(machine.getWeight());
						mcsMap.put(mcsId, date);///将计算好的机柜态势放入机柜态势集合
					}
				}
				
			} 
//			else {///如果主机列表中不存在这个IP
//				if (mcsMap.containsKey(1)) {///如果机柜态势集合中存在   id为1 的机柜
//					MachineCabinetSituation date = mcsMap.get(1);///取出 id为1 的机柜的态势表记录
//					float value = date.getWholeSituation();///得到 id为1 的机柜 的整体态势
//					///重新计算id为1 的机柜的整体态势(算法：(主机整体态势*主机权重)的累加和)
//					value = value + ms.getWholeSituation() * 1;///累加上id为1 的机柜的整体态势
//					date.setWholeSituation(value);///重新setid为1 的机柜的整体态势
//					date.addCount(1);
//					mcsMap.put(1, date);///将计算好的机柜态势放入机柜态势集合
//				} else {///如果机柜态势集合中不存在   id为1 的机柜
//					MachineCabinetSituation date = new MachineCabinetSituation();///新建一条机柜态势记录
//					date.setMachineCabinetId(1);///设定机柜态势记录的机柜id为1
//					date.setMachineCabinetName("默认机柜");///设定机柜态势记录的机柜name为 默认机柜
//					date.setTime(ms.getTime());///设定机柜态势记录的时间
//					date.setWholeSituation(ms.getWholeSituation());///设定机柜态势记录的整体态势
//					date.addCount(1);
//					mcsMap.put(1, date);///将计算好的机柜态势放入机柜态势集合
//				}
//			}

		}
		Iterator<Entry<Integer, MachineCabinetSituation>> its = mcsMap.entrySet().iterator();
		while (its.hasNext()) {
			Map.Entry entry = (Map.Entry) its.next();
			MachineCabinetSituation date = (MachineCabinetSituation) entry.getValue();
			int i = date.getCount();
			float attackValue = date.getAttackThreat() / i;
			float virusValue = date.getVirusCondition() / i;
			float invalidValie = date.getInvalidConnection() / i;
			float wholeValue = date.getWholeSituation() / i;
			date.setAttackThreat(attackValue);
			date.setVirusCondition(virusValue);
			date.setInvalidConnection(invalidValie);
			date.setWholeSituation(wholeValue);
			list.add(date);
		}
		return list;
	}
	
	/**
	 * 根据主机的态势计算机房的态势。
	 * @param dates
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<MachineRoomSituation> machineRoomSituationReckon(List<MachineSituation> dates) {
		List<MachineRoomSituation> list = new ArrayList<MachineRoomSituation>();
		Map<Integer, MachineRoomSituation> mrsMap = new HashMap<Integer, MachineRoomSituation>();
		Iterator<MachineSituation> it = dates.iterator();
		while (it.hasNext()) {///循环遍历主机的态势列表
			MachineSituation ms = it.next();///取出态势列表中的每个态势(MachineSituation)
			String ip = ms.getIp();///取出IP
			if (maMap.containsKey(ip)) {///如果主机列表中存在这个IP
				Machine machine = maMap.get(ip);///根据这个IP获取相应的主机
				MachineRoom machineRoom = machine.getMachineRoom();
				if(null != machineRoom){
					if(null != machineRoom.getId()){
						if (mrsMap.containsKey(machine.getMachineRoom().getId())) {
							MachineRoomSituation mrs = mrsMap.get(machine.getMachineRoom().getId());
							///攻击态势
							float attackValue = mrs.getAttackThreat();
							attackValue = attackValue + ms.getAttackThreat() * machine.getWeight();
							mrs.setAttackThreat(attackValue);
							///病毒态势
							float virusValue = mrs.getVirusCondition();
							virusValue = virusValue + ms.getVirusCondition() * machine.getWeight();
							mrs.setVirusCondition(virusValue);
							///非法连接态势
							float invalidValue = mrs.getInvalidConnection();
							invalidValue = invalidValue + ms.getInvalidConnection()* machine.getWeight();
							mrs.setInvalidConnection(invalidValue);
							///整体态势
							float wholeValue = mrs.getWholeSituation();
							wholeValue = wholeValue + ms.getWholeSituation() * machine.getWeight();
							mrs.setWholeSituation(wholeValue);
							
							mrs.addCount(machine.getWeight());///权重累加
							mrsMap.put(machine.getMachineRoom().getId(), mrs);
						}else {
							MachineRoomSituation mrs = new MachineRoomSituation();
//							mrs.setMachineRoomId(machine.getMachineRoomId());
							mrs.setMachineRoom(machine.getMachineRoom());
							mrs.setMachineRoomName(machine.getMachineRoom().getMachineRoomName());
							mrs.setTime(ms.getTime());
							mrs.setAttackThreat(ms.getAttackThreat());
							mrs.setVirusCondition(ms.getVirusCondition());
							mrs.setInvalidConnection(ms.getInvalidConnection());
							mrs.setWholeSituation(ms.getWholeSituation());
							mrs.addCount(machine.getWeight());
							mrsMap.put(machine.getMachineRoom().getId(), mrs);
						}
					}else{
						if(null != machine.getMachineCabinet()){
							MachineCabinet cabinet = mc.get(machine.getMachineCabinet().getId());
							if(mrsMap.containsKey(cabinet.getMachineRoom().getId())){
								MachineRoomSituation mrs = mrsMap.get(cabinet.getMachineRoom().getId());
								///攻击态势
								float attackValue = mrs.getAttackThreat();
								attackValue = attackValue + ms.getAttackThreat() * machine.getWeight();
								mrs.setAttackThreat(attackValue);
								///病毒态势
								float virusValue = mrs.getVirusCondition();
								virusValue = virusValue + ms.getVirusCondition() * machine.getWeight();
								mrs.setVirusCondition(virusValue);
								///非法连接态势
								float invalidValue = mrs.getInvalidConnection();
								invalidValue = invalidValue + ms.getInvalidConnection()* machine.getWeight();
								mrs.setInvalidConnection(invalidValue);
								///整体态势
								float wholeValue = mrs.getWholeSituation();
								wholeValue = wholeValue + ms.getWholeSituation() * machine.getWeight();
								mrs.setWholeSituation(wholeValue);
								
								mrs.addCount(machine.getWeight());///权重累加
								mrsMap.put(machine.getMachineRoom().getId(), mrs);
							}else{
								MachineRoomSituation mrs = new MachineRoomSituation();
//								mrs.setMachineRoomId(cabinet.getMachineRoomId());
								mrs.setMachineRoom(cabinet.getMachineRoom());
								mrs.setMachineRoomName(cabinet.getMachineRoom().getMachineRoomName());
								mrs.setTime(ms.getTime());
								mrs.setAttackThreat(ms.getAttackThreat());
								mrs.setVirusCondition(ms.getVirusCondition());
								mrs.setInvalidConnection(ms.getInvalidConnection());
								mrs.setWholeSituation(ms.getWholeSituation());
								mrs.addCount(machine.getWeight());
								mrsMap.put(machine.getMachineRoom().getId(), mrs);
							}
						}
					}
				}
				
			}
		}
		Iterator<Entry<Integer, MachineRoomSituation>> its = mrsMap.entrySet().iterator();
		while (its.hasNext()) {
			Map.Entry entry = (Map.Entry) its.next();
			MachineRoomSituation date = (MachineRoomSituation) entry.getValue();
			int i = date.getCount();
			float attackValue = date.getAttackThreat() / i;
			float virusValue = date.getVirusCondition() / i;
			float invalidValie = date.getInvalidConnection() / i;
			float wholeValue = date.getWholeSituation() / i;
			date.setAttackThreat(attackValue);
			date.setVirusCondition(virusValue);
			date.setInvalidConnection(invalidValie);
			date.setWholeSituation(wholeValue);
			list.add(date);
		}
		return list;
	}
	
//	/**
//	 * 根据机柜的态势计算机房的态势
//	 * @param dates
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	private List<MachineRoomSituation> machineRoomSituationReckon(List<MachineCabinetSituation> dates) {
//		List<MachineRoomSituation> list = new ArrayList<MachineRoomSituation>();
//		Map<Integer, MachineRoomSituation> mcsMap = new HashMap<Integer, MachineRoomSituation>();
//		Iterator<MachineCabinetSituation> it = dates.iterator();
//		while (it.hasNext()) {///循环遍历机柜的态势列表
//			MachineCabinetSituation ms = it.next();///取出机柜态势集合中的每个态势(MachineCabinetSituation)
//			int id = ms.getMachineCabinetId();
//			MachineCabinet machineCabinet = mc.get(id);
//			if (mcsMap.containsKey(machineCabinet.getMachineRoomId())) {
//				MachineRoomSituation mrs = mcsMap.get(machineCabinet.getMachineRoomId());
//				float value = mrs.getWholeSituation();
//				value = value + ms.getWholeSituation();
//				mrs.setWholeSituation(value);
//				mrs.addCount();
//				mcsMap.put(machineCabinet.getMachineRoomId(), mrs);
//			} else {
//				MachineRoomSituation mrs = new MachineRoomSituation();
//				mrs.setMachineRoomId(machineCabinet.getMachineRoomId());
//				mrs.setMachineRoomName(machineCabinet.getMachineRoomName());
//				mrs.setTime(ms.getTime());
//				mrs.setWholeSituation(ms.getWholeSituation());
//				mrs.addCount();
//				mcsMap.put(machineCabinet.getMachineRoomId(), mrs);
//			}
//		}
//		Iterator<Entry<Integer, MachineRoomSituation>> its = mcsMap.entrySet().iterator();
//		while (its.hasNext()) {
//			Map.Entry entry = (Map.Entry) its.next();
//			MachineRoomSituation date = (MachineRoomSituation) entry.getValue();
//			int i = date.getCount();
//			float value = date.getWholeSituation() / i;
//			date.setWholeSituation(value);
//			list.add(date);
//		}
//		return list;
//	}
	/**
	 * 根据主机的态势计算安全域的态势。
	 * @param dates
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<SecurityAreaSituation> securityAreaSituationReckon(List<MachineSituation> dates) {
		List<SecurityAreaSituation> list = new ArrayList<SecurityAreaSituation>();
		Map<Integer, SecurityAreaSituation> sasMap = new HashMap<Integer, SecurityAreaSituation>();
		Iterator<MachineSituation> it = dates.iterator();
		while (it.hasNext()) {
			MachineSituation ms = it.next();
			String ip = ms.getIp();
			if (maMap.containsKey(ip)) {
				Machine machine = maMap.get(ip);
				int tempSecurityAreaId = 0;
				Domain domain = null;
				String tempSecurityAreaName = "";
				
				if(null != machine.getDomain() && 0 != machine.getDomain().getId()){
					tempSecurityAreaId = machine.getDomain().getId();
					tempSecurityAreaName = machine.getDomain().getDomainName();
					domain = machine.getDomain();
				}else if( null != machine.getMachineRoom() && 0 != machine.getMachineRoom().getId()){
					if(null != mr.get(machine.getMachineRoom().getId()).getDomain()){
						tempSecurityAreaId = mr.get(machine.getMachineRoom().getId()).getDomain().getId();
						tempSecurityAreaName = mr.get(machine.getMachineRoom().getId()).getDomain().getDomainName();
						domain = mr.get(machine.getMachineRoom().getId()).getDomain();
					}
				}else if(null != machine.getMachineCabinet() && 0 != machine.getMachineCabinet().getId()){
					if(null != mr.get(mc.get(machine.getMachineCabinet().getId()).getMachineRoom().getId()).getDomain()){
						tempSecurityAreaId = mr.get(mc.get(machine.getMachineCabinet().getId()).getMachineRoom().getId()).getDomain().getId();
						tempSecurityAreaName = mr.get(mc.get(machine.getMachineCabinet().getId()).getMachineRoom().getId()).getDomain().getDomainName();
						domain = mr.get(mc.get(machine.getMachineCabinet().getId()).getMachineRoom().getId()).getDomain();
					}
				}
				if(sasMap.containsKey(tempSecurityAreaId)){
					SecurityAreaSituation sas = sasMap.get(tempSecurityAreaId);
					///攻击态势
					float attackValue = sas.getAttackThreat();
					attackValue = attackValue + ms.getAttackThreat() * machine.getWeight();
					sas.setAttackThreat(attackValue);
					///病毒态势
					float virusValue = sas.getVirusCondition();
					virusValue = virusValue + ms.getVirusCondition() * machine.getWeight();
					sas.setVirusCondition(virusValue);
					///非法连接态势
					float invalidValue = sas.getInvalidConnection();
					invalidValue = invalidValue + ms.getInvalidConnection() * machine.getWeight();
					sas.setInvalidConnection(invalidValue);
					///整体态势
					float wholeValue = sas.getWholeSituation();
					wholeValue = wholeValue + ms.getWholeSituation() * machine.getWeight();
					sas.setWholeSituation(wholeValue);
					
					sas.addCount(machine.getWeight());///权重累加
					sasMap.put(tempSecurityAreaId, sas);
				}else{
					SecurityAreaSituation sas = new SecurityAreaSituation();
//					sas.setSecurityAreaId(tempSecurityAreaId);
					sas.setDomain(domain);
					sas.setSecurityAreaName(tempSecurityAreaName);
					sas.setTime(ms.getTime());
					sas.setAttackThreat(ms.getAttackThreat());
					sas.setVirusCondition(ms.getVirusCondition());
					sas.setInvalidConnection(ms.getInvalidConnection());
					sas.setWholeSituation(ms.getWholeSituation());
					
					sas.addCount(machine.getWeight());///权重累加
					sasMap.put(tempSecurityAreaId, sas);
				}
			} 
		}
		Iterator<Entry<Integer, SecurityAreaSituation>> its = sasMap.entrySet().iterator();
		while (its.hasNext()) {
			Map.Entry entry = (Map.Entry) its.next();
			SecurityAreaSituation date = (SecurityAreaSituation) entry.getValue();
			int i = date.getCount();
			float attackValue = date.getAttackThreat() / i;
			float virusValue = date.getVirusCondition() / i;
			float invalidValie = date.getInvalidConnection() / i;
			float wholeValue = date.getWholeSituation() / i;
			date.setAttackThreat(attackValue);
			date.setVirusCondition(virusValue);
			date.setInvalidConnection(invalidValie);
			date.setWholeSituation(wholeValue);
			list.add(date);
		}
		return list;
	}

}
