package org.infosec.ismp.situation.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.situation.model.MachineCabinetSituation;
import org.infosec.ismp.situation.model.MachineRoomSituation;
import org.infosec.ismp.situation.model.MachineSituation;
import org.infosec.ismp.situation.model.RecordIndex;
import org.infosec.ismp.situation.model.SecurityAreaSituation;
import org.infosec.ismp.situation.model.SituationEvent;
import org.infosec.ismp.situation.service.MachineCabinetSituationService;
import org.infosec.ismp.situation.service.MachineRoomSituationService;
import org.infosec.ismp.situation.service.MachineSituationService;
import org.infosec.ismp.situation.service.RecordIndexService;
import org.infosec.ismp.situation.service.SecurityAreaSituationService;
import org.infosec.ismp.situation.service.SituationEventService;
import org.infosec.ismp.situation.service.impl.SituationPipe;


public class SituationSaveToDB {

	protected final Log log = LogFactory.getLog(getClass());

	// 机房标识 locationIdentify
	public static final Integer JiFang = 1;

	// 机柜标识 locationIdentify
	public static final Integer JiGui = 2;

	// 网络标识 locationIdentify
	public static final Integer WangLuo = 4;

	// 安全域标识 locationIdentify
	public static final Integer AnQuanYu = 8;

	// 主机标识 locationIdentify
	public static final Integer ZhuJi = 16;

	// 攻击威胁指数标识 locationIdentify
	public static final Integer AttackThreatZS = 11;

	// 病毒疫情指数标识 locationIdentify
	public static final Integer VirusYiQingZS = 22;

	// 非法连接指数标识 locationIdentify
	public static final Integer UnValidConnectionZS = 44;
	
	///整体态势指数标识 locationIdentify
	public static final Integer TotalSituation = 88;

	/**
	 * 记录指针类集合
	 */
	private Map<Integer, RecordIndex> ridexMap = new HashMap<Integer, RecordIndex>();

	/**
	 * 根据index序列加入集合
	 * 
	 * @param ri
	 */
	public void setRidexMap(RecordIndex ri) {
		ridexMap.put(ri.getIndex(), ri);
	}

	private MachineCabinetSituationService mcsService;

	private MachineRoomSituationService mrsService;

	private MachineSituationService msService;

	private SecurityAreaSituationService sasService;

	private RecordIndexService riService;
	
	private SituationEventService seService;
	
	private SituationPipe situationPipe; 

	public void setMcsService(MachineCabinetSituationService mcsService) {
		this.mcsService = mcsService;
	}

	public void setMrsService(MachineRoomSituationService mrsService) {
		this.mrsService = mrsService;
	}

	public void setMsService(MachineSituationService msService) {
		this.msService = msService;
	}

	public void setSasService(SecurityAreaSituationService sasService) {
		this.sasService = sasService;
	}

	public void setRiService(RecordIndexService riService) {
		this.riService = riService;
	}
	
	public void setSituationPipe(SituationPipe situationPipe) {
		this.situationPipe = situationPipe;
	}

	public SituationEventService getSeService() {
		return seService;
	}

	public void setSeService(SituationEventService seService) {
		this.seService = seService;
	}

	private SurroundingsInit surroundingsInit;

	public void setSurroundingsInit(SurroundingsInit surroundingsInit) {
		this.surroundingsInit = surroundingsInit;
	}

	/**
	 * 存放前一次主机的攻击威胁指数
	 */
	private Map<String, Float> attackMap = new HashMap<String, Float>();

	/**
	 * 存放前一次主机的病毒疫情指数
	 */
	private Map<String, Float> virusMap = new HashMap<String, Float>();

	/**
	 * 存放前一次主的非法连接指数
	 */
	private Map<String, Float> illicitConnectMap = new HashMap<String, Float>();

	/**
	 * 存放前一次主机的态势值
	 */
	private Map<String, Float> machineMap = new HashMap<String, Float>();

	/**
	 * 存放前一次机柜的态势值
	 */
	private Map<Integer, Float> machineCabinetMap = new HashMap<Integer, Float>();

	/**
	 * 存放前一次机房的态势值
	 */
	private Map<Integer, Float> machineRommMap = new HashMap<Integer, Float>();

	/**
	 * 存放前一次安全域的态势值
	 */
	private Map<Integer, Float> securityAreaMap = new HashMap<Integer, Float>();

	/**
	 * 存放前一次网络的态势值
	 */
	private Map<String, Float> netMap = new HashMap<String, Float>();

	/**
	 * 存放前一次总态势值
	 */
	private float oldTotalValue = 0;

	private int recordId = 0;

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	///存放态势到数据库
	public void saveSixSituationToDB(int index,
			List<MachineSituation> machineSituations,
			List<MachineCabinetSituation> machineCabinetSituations,
			List<MachineRoomSituation> machineRoomSituations,
			List<SecurityAreaSituation> securityAreaSituations,
			List<SituationEvent> situationEvents) {
		
		Map<String, Integer> color = surroundingsInit.getColorMap();
		int green = color.get("green");
		int yellow = color.get("yellow");
		msService.save(machineSituations);///保存主机态势到数据库。
		situationPipe.addMachineSituations(machineSituations);///将主机态势压入管道，以供RMI抽取
		
		mcsService.save(machineCabinetSituations);///保存机柜态势到数据库。
		situationPipe.addMachineCabinetSiuations(machineCabinetSituations);///将机柜态势压入管道，以供RMI抽取
		
		mrsService.save(machineRoomSituations);///保存机房态势到数据库。
		situationPipe.addMachineRoomSituations(machineRoomSituations);///将机房态势压入管道，以供RMI抽取
		
		sasService.save(securityAreaSituations);///保存安全域态势到数据库。
		situationPipe.addSecurityAreaSituations(securityAreaSituations);///将安全域态势压入管道，以供RMI抽取
		
		seService.save(situationEvents);///保存态势对应事件到数据库
			
		log.info("第" + index + "次运算入数据库！！！！");
	}

	/**
	 * 比较色彩区间
	 * 
	 * @param green
	 * @param yellow
	 * @param value
	 * @return
	 */
	private int colorInterval(int green, int yellow, float value) {
		int res = 1;
		if (value > green) {
			res++;
		}
		if (value > yellow) {
			res++;
		}
		return res;
	}

	/**
	 * 从主机态势中生成攻击威胁指数告警
	 * 
	 * @param dates
	 * @param green
	 * @param yellow
	 * @param alarms
	 * @return
	 */
//	private List<Alarm> queryMachineAttackAlarm(List<MachineSituation> dates,
//			int green, int yellow, List<Alarm> alarms) {
//		for (int i = 0; i < dates.size(); i++) {
//			MachineSituation date = dates.get(i);
//			String ip = date.getIp();
//			float newValue = date.getAttackThreat();
//			if (attackMap.containsKey(ip)) {
//				float oldValue = attackMap.get(ip);
//				int old = colorInterval(green, yellow, oldValue);
//				int newv = colorInterval(green, yellow, newValue);
//				if (newv > old) {
//					Alarm alarm = new Alarm();
//					alarm.setChangedValue(newValue);
//					alarm.setLocation(date.getIp());
//					alarm.setName("攻击威胁指数");
//					alarm.setTime(date.getTime());
//					alarm.setValue(oldValue);
//					alarm.setFlag(AttackThreatZS);
//					alarms.add(alarm);
//				}
//			} else {
//				Alarm alarm = new Alarm();
//				alarm.setChangedValue(newValue);
//				alarm.setLocation(date.getIp());
//				alarm.setName("攻击威胁指数");
//				alarm.setTime(date.getTime());
//				alarm.setValue(0);
//				alarm.setFlag(AttackThreatZS);
//				alarms.add(alarm);
//			}
//			attackMap.put(ip, newValue);
//		}
//		return alarms;
//	}

	/**
	 * 从主机态势中生成病毒疫情指数告警
	 * 
	 * @param dates
	 * @param green
	 * @param yellow
	 * @param alarms
	 * @return
	 */
//	private List<Alarm> queryMachineVriusAlarm(List<MachineSituation> dates,
//			int green, int yellow, List<Alarm> alarms) {
//		for (int i = 0; i < dates.size(); i++) {
//			MachineSituation date = dates.get(i);
//			String ip = date.getIp();
//			float newValue = date.getVirusCondition();
//			if (virusMap.containsKey(ip)) {
//				float oldValue = virusMap.get(ip);
//				int old = colorInterval(green, yellow, oldValue);
//				int newv = colorInterval(green, yellow, newValue);
//				if (newv > old) {
//					Alarm alarm = new Alarm();
//					alarm.setChangedValue(newValue);
//					alarm.setLocation(date.getIp());
//					alarm.setName("病毒疫情指数");
//					alarm.setTime(date.getTime());
//					alarm.setValue(oldValue);
//					alarm.setFlag(VirusYiQingZS);
//					alarms.add(alarm);
//				}
//			} else {
//				Alarm alarm = new Alarm();
//				alarm.setChangedValue(newValue);
//				alarm.setLocation(date.getIp());
//				alarm.setName("病毒疫情指数");
//				alarm.setTime(date.getTime());
//				alarm.setValue(0);
//				alarm.setFlag(VirusYiQingZS);
//				alarms.add(alarm);
//			}
//			virusMap.put(ip, newValue);
//		}
//		return alarms;
//	}

	/**
	 * 从主机态势中生成非法连接指数告警
	 * 
	 * @param dates
	 * @param green
	 * @param yellow
	 * @param alarms
	 * @return
	 */
//	private List<Alarm> queryMachineillicitConnectAlarm(
//			List<MachineSituation> dates, int green, int yellow,
//			List<Alarm> alarms) {
//		for (int i = 0; i < dates.size(); i++) {
//			MachineSituation date = dates.get(i);
//			String ip = date.getIp();
//			float newValue = date.getInvalidConnection();
//			if (illicitConnectMap.containsKey(ip)) {
//				float oldValue = illicitConnectMap.get(ip);
//				int old = colorInterval(green, yellow, oldValue);
//				int newv = colorInterval(green, yellow, newValue);
//				if (newv > old) {
//					Alarm alarm = new Alarm();
//					alarm.setChangedValue(newValue);
//					alarm.setLocation(date.getIp());
//					alarm.setName("非法连接指数");
//					alarm.setTime(date.getTime());
//					alarm.setValue(oldValue);
//					alarm.setFlag(UnValidConnectionZS);
//					alarms.add(alarm);
//				}
//			} else {
//				Alarm alarm = new Alarm();
//				alarm.setChangedValue(newValue);
//				alarm.setLocation(date.getIp());
//				alarm.setName("非法连接指数");
//				alarm.setTime(date.getTime());
//				alarm.setValue(0);
//				alarm.setFlag(UnValidConnectionZS);
//				alarms.add(alarm);
//			}
//			illicitConnectMap.put(ip, newValue);
//		}
//		return alarms;
//	}

	/**
	 * 从主机态势中生成主机整体态势告警
	 * 
	 * @param dates
	 * @param green
	 * @param yellow
	 * @param alarms
	 * @return
	 */
//	private List<Alarm> queryMachineAlarm(List<MachineSituation> dates,
//			int green, int yellow, List<Alarm> alarms) {
//		for (int i = 0; i < dates.size(); i++) {
//			MachineSituation date = dates.get(i);
//			String ip = date.getIp();
//			float newValue = date.getWholeSituation();
//			if (machineMap.containsKey(ip)) {
//				float oldValue = machineMap.get(ip);
//				int old = colorInterval(green, yellow, oldValue);
//				int newv = colorInterval(green, yellow, newValue);
//				if (newv > old) {
//					Alarm alarm = new Alarm();
//					alarm.setChangedValue(newValue);
//					alarm.setLocation(date.getIp());
//					alarm.setName("主机整体态势");
//					alarm.setTime(date.getTime());
//					alarm.setValue(oldValue);
//					alarm.setFlag(ZhuJi);
//					alarms.add(alarm);
//				}
//			} else {
//				Alarm alarm = new Alarm();
//				alarm.setChangedValue(newValue);
//				alarm.setLocation(date.getIp());
//				alarm.setName("整体态势");
//				alarm.setTime(date.getTime());
//				alarm.setValue(0);
//				alarm.setFlag(ZhuJi);
//				alarms.add(alarm);
//			}
//			machineMap.put(ip, newValue);
//		}
//		return alarms;
//	}

	/**
	 * 从机柜态势中生成机柜整体态势告警
	 * 
	 * @param dates
	 * @param green
	 * @param yellow
	 * @param alarms
	 * @return
	 */
//	private List<Alarm> queryMachineCabinetAlarm(
//			List<MachineCabinetSituation> dates, int green, int yellow,
//			List<Alarm> alarms) {
//		for (int i = 0; i < dates.size(); i++) {
//			MachineCabinetSituation date = dates.get(i);
//			int id = date.getMachineCabinetId();
//			float newValue = date.getWholeSituation();
//			if (machineCabinetMap.containsKey(id)) {
//				float oldValue = machineCabinetMap.get(id);
//				int old = colorInterval(green, yellow, oldValue);
//				int newv = colorInterval(green, yellow, newValue);
//				if (newv > old) {
//					Alarm alarm = new Alarm();
//					alarm.setChangedValue(newValue);
//					alarm.setLocation(date.getName());
//					alarm.setName("机柜整体态势");
//					alarm.setTime(date.getTime());
//					alarm.setValue(oldValue);
//					alarm.setFlag(JiGui);
//					alarms.add(alarm);
//				}
//			} else {
//				Alarm alarm = new Alarm();
//				alarm.setChangedValue(newValue);
//				alarm.setLocation(date.getName());
//				alarm.setName("机柜整体态势");
//				alarm.setTime(date.getTime());
//				alarm.setValue(0);
//				alarm.setFlag(JiGui);
//				alarms.add(alarm);
//			}
//			machineCabinetMap.put(id, newValue);
//		}
//		return alarms;
//	}

	/**
	 * 从机房态势中生成机房整体态势告警
	 * 
	 * @param dates
	 * @param green
	 * @param yellow
	 * @param alarms
	 * @return
	 */
//	private List<Alarm> queryMachineRoomAlarm(List<MachineRoomSituation> dates,
//			int green, int yellow, List<Alarm> alarms) {
//		for (int i = 0; i < dates.size(); i++) {
//			MachineRoomSituation date = dates.get(i);
//			Integer name = date.getManagerID();
//			float newValue = date.getWholeSituation();
//			if (machineRommMap.containsKey(name)) {
//				float oldValue = machineRommMap.get(name);
//				int old = colorInterval(green, yellow, oldValue);
//				int newv = colorInterval(green, yellow, newValue);
//				if (newv > old) {
//					Alarm alarm = new Alarm();
//					alarm.setChangedValue(newValue);
//					alarm.setLocation(departmentService.findManagerById(
//							date.getManagerID()).getManagerName());
//					alarm.setName("机房整体态势");
//					alarm.setTime(date.getTime());
//					alarm.setValue(oldValue);
//					alarm.setFlag(JiFang);
//					alarms.add(alarm);
//				}
//			} else {
//				Alarm alarm = new Alarm();
//				alarm.setChangedValue(newValue);
//				alarm.setLocation(departmentService.findManagerById(
//						date.getManagerID()).getManagerName());
//				alarm.setName("机房整体态势");
//				alarm.setTime(date.getTime());
//				alarm.setValue(0);
//				alarm.setFlag(JiFang);
//				alarms.add(alarm);
//			}
//			machineRommMap.put(name, newValue);
//		}
//		return alarms;
//	}

	/**
	 * 从安全域态势中生成安全域整体态势告警
	 * 
	 * @param dates
	 * @param green
	 * @param yellow
	 * @param alarms
	 * @return
	 */
//	private List<Alarm> querySecurityAreaAlarm(
//			List<SecurityAreaSituation> dates, int green, int yellow,
//			List<Alarm> alarms) {
//		for (int i = 0; i < dates.size(); i++) {
//			SecurityAreaSituation date = dates.get(i);
//			int id = date.getSecurityAreaId();
//			float newValue = date.getWholeSituation();
//			if (securityAreaMap.containsKey(id)) {
//				float oldValue = securityAreaMap.get(id);
//				int old = colorInterval(green, yellow, oldValue);
//				int newv = colorInterval(green, yellow, newValue);
//				if (newv > old) {
//					Alarm alarm = new Alarm();
//					alarm.setChangedValue(newValue);
//					alarm.setLocation(date.getName());
//					alarm.setName("安全域整体态势");
//					alarm.setTime(date.getTime());
//					alarm.setValue(oldValue);
//					alarm.setFlag(AnQuanYu);
//					alarms.add(alarm);
//				}
//			} else {
//				Alarm alarm = new Alarm();
//				alarm.setChangedValue(newValue);
//				alarm.setLocation(date.getName());
//				alarm.setName("安全域整体态势");
//				alarm.setTime(date.getTime());
//				alarm.setValue(0);
//				alarm.setFlag(AnQuanYu);
//				alarms.add(alarm);
//			}
//			securityAreaMap.put(id, newValue);
//		}
//		return alarms;
//	}

	/**
	 * 从网络态势中生成网络整体态势告警
	 * 
	 * @param dates
	 * @param green
	 * @param yellow
	 * @param alarms
	 * @return
	 */
//	private List<Alarm> queryNetAlarm(List<NetSituation> dates, int green,
//			int yellow, List<Alarm> alarms) {
//		for (int i = 0; i < dates.size(); i++) {
//			NetSituation date = dates.get(i);
//			String name = date.getName();
//			float newValue = date.getWholeSituation();
//			if (netMap.containsKey(name)) {
//				float oldValue = netMap.get(name);
//				int old = colorInterval(green, yellow, oldValue);
//				int newv = colorInterval(green, yellow, newValue);
//				if (newv > old) {
//					Alarm alarm = new Alarm();
//					alarm.setChangedValue(newValue);
//					alarm.setLocation(date.getName());
//					alarm.setName("网络整体态势");
//					alarm.setTime(date.getTime());
//					alarm.setValue(oldValue);
//					alarm.setFlag(WangLuo);
//					alarms.add(alarm);
//				}
//			} else {
//				Alarm alarm = new Alarm();
//				alarm.setChangedValue(newValue);
//				alarm.setLocation(date.getName());
//				alarm.setName("网络整体态势");
//				alarm.setTime(date.getTime());
//				alarm.setValue(0);
//				alarm.setFlag(WangLuo);
//				alarms.add(alarm);
//			}
//			netMap.put(name, newValue);
//		}
//		return alarms;
//	}

//	private List<Alarm> queryTotalAlarm(TotalMachineRoomSituation date,
//			int green, int yellow, List<Alarm> alarms) {
//		float newValue = date.getValue();
//		int old = colorInterval(green, yellow, oldTotalValue);
//		int newv = colorInterval(green, yellow, newValue);
//		if (newv > old) {
//			Alarm alarm = new Alarm();
//			alarm.setChangedValue(newValue);
//			alarm.setLocation("总态势");
//			alarm.setName("总态势");
//			alarm.setTime(date.getTime());
//			alarm.setValue(newValue);
//			alarm.setFlag(TotalSituation);
//			alarms.add(alarm);
//		}
//		oldTotalValue = newValue;
//		return alarms;
//	}

}
