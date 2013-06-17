package edu.sjtu.infosec.ismp.manager.BSAM.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.infosec.ismp.manager.rmi.bsam.service.SituationService;
import org.springframework.dao.DataAccessResourceFailureException;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.Constants;
import edu.sjtu.infosec.ismp.manager.BSAM.comm.DateUtil;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.ColorThresholdDao;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineCabinetSituationDao;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineRoomSituationDao;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineSituationDao;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.SecurityAreaSituationDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineCabinetSituation;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineRoomSituation;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineSituation;
import edu.sjtu.infosec.ismp.manager.BSAM.model.SecurityAreaSituation;
import edu.sjtu.infosec.ismp.manager.BSAM.model.SubUnitSituationVO;
import edu.sjtu.infosec.ismp.manager.BSAM.model.SubUnitVO;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineCabinetService;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineRoomService;
import edu.sjtu.infosec.ismp.manager.BSAM.service.SecurityAreaService;
import edu.sjtu.infosec.ismp.manager.BSAM.service.SubUnitSituationService;

public class SubUnitSituationServiceImpl implements SubUnitSituationService {
	
	private static Logger logger = Logger.getLogger(SubUnitSituationServiceImpl.class);
	
	private ColorThresholdDao colorThresholdDao;
	
	private MachineCabinetService machineCabinetService;
	
	private MachineRoomService machineRoomService;
	
	private SecurityAreaService securityAreaService;
	
	private MachineSituationDao machineSituationDao;
	
	private MachineCabinetSituationDao machineCabinetSituationDao;
	
	private MachineRoomSituationDao machineRoomSituationDao;
	
	private SecurityAreaSituationDao securityAreaSituationDao;
	
	private SituationService situationService;///RMI
	
	public void setColorThresholdDao(ColorThresholdDao colorThresholdDao) {
		this.colorThresholdDao = colorThresholdDao;
	}
		
	public void setMachineCabinetService(MachineCabinetService machineCabinetService) {
		this.machineCabinetService = machineCabinetService;
	}

	public void setMachineRoomService(MachineRoomService machineRoomService) {
		this.machineRoomService = machineRoomService;
	}
	
	public void setSecurityAreaService(SecurityAreaService securityAreaService) {
		this.securityAreaService = securityAreaService;
	}
	
	public void setMachineSituationDao(MachineSituationDao machineSituationDao) {
		this.machineSituationDao = machineSituationDao;
	}

	public void setMachineCabinetSituationDao(
			MachineCabinetSituationDao machineCabinetSituationDao) {
		this.machineCabinetSituationDao = machineCabinetSituationDao;
	}

	public void setMachineRoomSituationDao(
			MachineRoomSituationDao machineRoomSituationDao) {
		this.machineRoomSituationDao = machineRoomSituationDao;
	}

	public void setSecurityAreaSituationDao(
			SecurityAreaSituationDao securityAreaSituationDao) {
		this.securityAreaSituationDao = securityAreaSituationDao;
	}

	public void setSituationService(SituationService situationService) {
		this.situationService = situationService;
	}

	@SuppressWarnings("unchecked")
	public List getSubUnitSituation(String subUnitIds) {
		String jiFangIds = "";
		String zhuJiIds = "";
		String jiGuiIds = "";
		///解析传过来的subUnitIds，剥离出机房id(或者是机柜id)和主机id;这里机房id和机柜id不会同时出现。
		if(subUnitIds.contains(",")){
			jiFangIds = subUnitIds.substring(0, subUnitIds.lastIndexOf(","));///机房id
		}
		if(subUnitIds.contains(":")){
			zhuJiIds = subUnitIds.substring(subUnitIds.indexOf(":") + 1, subUnitIds.length());///主机id（散户）
		}
		if(subUnitIds.contains(";")){
			jiGuiIds = subUnitIds.substring(0, subUnitIds.lastIndexOf(";"));///机柜id
		}
		String[] machineRoomIds = {};
		String[] machineIds = {};
		String[] machineCabinetIds = {};
		if(!"".equals(jiFangIds)){
			machineRoomIds = jiFangIds.split(",");///机房id
		}
		if(!"".equals(zhuJiIds)){
			machineIds = zhuJiIds.split(":");///主机id
		}
		if(!"".equals(jiGuiIds)){
			machineCabinetIds = jiGuiIds.split(";");///机柜id
		}
				
		///当前时间
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		///三分钟之前的时间
		Timestamp beginTime = new Timestamp(currentTime.getTime() - Constants.T);
		
		String errorMessage = "right";
		List<SubUnitSituationVO> subUnitSituationList = new ArrayList<SubUnitSituationVO>();
		///通过RMI获取机房态势
		if(null != machineRoomIds && machineRoomIds.length > 0){
			for (int i = 0; i < machineRoomIds.length; i++) {
				
				try {
					///取得beginTime——endTime时间段内机房id为machineRoomIds[i]的机房态势
					org.infosec.ismp.manager.rmi.bsam.model.SubUnitSituationVO tempSubUnitSituationVO 
						 	= situationService.getMachineRoomSituationByMachineRoomId(machineRoomIds[i], beginTime, currentTime);
					SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
					subUnitSituationVO.setId(Integer.parseInt(machineRoomIds[i]));
					subUnitSituationVO.setTime(null == tempSubUnitSituationVO.getTime()?currentTime:tempSubUnitSituationVO.getTime());
					subUnitSituationVO.setAttackThreat(null == tempSubUnitSituationVO.getAttackThreat()?0f:tempSubUnitSituationVO.getAttackThreat());
					subUnitSituationVO.setVirusCondition(null == tempSubUnitSituationVO.getVirusCondition()?0f:tempSubUnitSituationVO.getVirusCondition());
					subUnitSituationVO.setInvalidConnection(null == tempSubUnitSituationVO.getInvalidConnection()?0f:tempSubUnitSituationVO.getInvalidConnection());
					subUnitSituationVO.setWholeSituation(null == tempSubUnitSituationVO.getWholeSituation()?0f:tempSubUnitSituationVO.getWholeSituation());
					subUnitSituationVO.setType(null == tempSubUnitSituationVO.getType()?"JiFang":tempSubUnitSituationVO.getType());///机房标识
					subUnitSituationList.add(subUnitSituationVO);
				} catch (Exception e) {
					logger.error("后台调用失败！");
					errorMessage = "error";
				}
				
			}
		} 
		///通过RMI获取主机态势
		if(null != machineIds && machineIds.length > 0){
			for (int i = 0; i < machineIds.length; i++) {
				
				try {
					///取得beginTime——endTime时间段内机房id为machineIds[i]的主机态势
					org.infosec.ismp.manager.rmi.bsam.model.SubUnitSituationVO tempSubUnitSituationVO 
							= situationService.getMachineSituationByMachineId(machineIds[i], beginTime, currentTime);
					SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
					subUnitSituationVO.setId(Integer.parseInt(machineIds[i]));
					
					subUnitSituationVO.setTime(null == tempSubUnitSituationVO.getTime()?currentTime:tempSubUnitSituationVO.getTime());
					subUnitSituationVO.setAttackThreat(null == tempSubUnitSituationVO.getAttackThreat()?0f:tempSubUnitSituationVO.getAttackThreat());
					subUnitSituationVO.setVirusCondition(null == tempSubUnitSituationVO.getVirusCondition()?0f:tempSubUnitSituationVO.getVirusCondition());
					subUnitSituationVO.setInvalidConnection(null == tempSubUnitSituationVO.getInvalidConnection()?0f:tempSubUnitSituationVO.getInvalidConnection());
					subUnitSituationVO.setWholeSituation(null == tempSubUnitSituationVO.getWholeSituation()?0f:tempSubUnitSituationVO.getWholeSituation());
					subUnitSituationVO.setType(null == tempSubUnitSituationVO.getType()?"ZhuJi":tempSubUnitSituationVO.getType());///主机标识
					subUnitSituationList.add(subUnitSituationVO);
				} catch (Exception e) {
					logger.error("后台调用失败！");
					errorMessage = "error";
				}
				
			}
		}
		///通过RMI获取机柜态势
		if(null != machineCabinetIds && machineCabinetIds.length > 0){
			for (int i = 0; i < machineCabinetIds.length; i++) {
				
				try {
					///取得beginTime——endTime时间段内机柜id为machineCabinetIds[i]的机柜态势
					org.infosec.ismp.manager.rmi.bsam.model.SubUnitSituationVO tempSubUnitSituationVO 
						= situationService.getMachineCabinetSituationByMachineCabinetId(machineCabinetIds[i], beginTime, currentTime);
					SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
					subUnitSituationVO.setId(Integer.parseInt(machineCabinetIds[i]));
					
					subUnitSituationVO.setTime(null == tempSubUnitSituationVO.getTime()?currentTime:tempSubUnitSituationVO.getTime());
					subUnitSituationVO.setAttackThreat(null == tempSubUnitSituationVO.getAttackThreat()?0f:tempSubUnitSituationVO.getAttackThreat());
					subUnitSituationVO.setVirusCondition(null == tempSubUnitSituationVO.getVirusCondition()?0f:tempSubUnitSituationVO.getVirusCondition());
					subUnitSituationVO.setInvalidConnection(null == tempSubUnitSituationVO.getInvalidConnection()?0f:tempSubUnitSituationVO.getInvalidConnection());
					subUnitSituationVO.setWholeSituation(null == tempSubUnitSituationVO.getWholeSituation()?0f:tempSubUnitSituationVO.getWholeSituation());
					subUnitSituationVO.setType(null == tempSubUnitSituationVO.getType()?"JiGui":tempSubUnitSituationVO.getType());///机柜标识
					subUnitSituationList.add(subUnitSituationVO);
				} catch (Exception e) {
					logger.error("后台调用失败！");
					errorMessage = "error";
				}
			}
		}
		
//		/** 以下模拟RMI返回结果测试 **/
//		List<SubUnitSituationVO> subUnitSituationList = new ArrayList<SubUnitSituationVO>();
//		if(null != machineRoomIds && machineRoomIds.length > 0){
//			for (int i = 0; i < machineRoomIds.length; i++) {
//				SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
//				subUnitSituationVO.setId(Integer.parseInt(machineRoomIds[i]));
//				subUnitSituationVO.setTime(currentTime);
//				subUnitSituationVO.setAttackThreat(3.5f);
//				subUnitSituationVO.setVirusCondition(4.5f);
//				subUnitSituationVO.setInvalidConnection(5.5f);
//				subUnitSituationVO.setWholeSituation((float)Math.random()*100);///模拟生成100以内随机数
//				subUnitSituationVO.setType(Constants.JiFang);///机房标识
//				subUnitSituationList.add(subUnitSituationVO);
//			}
//		}
//		if(null != machineIds && machineIds.length > 0){
//			for (int i = 0; i < machineIds.length; i++) {
//				SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
//				subUnitSituationVO.setId(Integer.parseInt(machineIds[i]));
//				subUnitSituationVO.setTime(currentTime);
//				subUnitSituationVO.setAttackThreat(3.5f);
//				subUnitSituationVO.setVirusCondition(4.5f);
//				subUnitSituationVO.setInvalidConnection(5.5f);
//				subUnitSituationVO.setWholeSituation((float)Math.random()*100);///模拟生成100以内随机数
//				
//				subUnitSituationVO.setType(Constants.ZhuJi);///主机标识
//				subUnitSituationList.add(subUnitSituationVO);
//			}
//		}
//		if(null != machineCabinetIds && machineCabinetIds.length > 0){
//			for (int i = 0; i < machineCabinetIds.length; i++) {
//				SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
//				subUnitSituationVO.setId(Integer.parseInt(machineCabinetIds[i]));
//				subUnitSituationVO.setTime(currentTime);
//				subUnitSituationVO.setAttackThreat(3.5f);
//				subUnitSituationVO.setVirusCondition(4.5f);
//				subUnitSituationVO.setInvalidConnection(5.5f);
//				subUnitSituationVO.setWholeSituation((float)Math.random()*100);///模拟生成100以内随机数
//				
//				subUnitSituationVO.setType(Constants.JiGui);///机柜标识
//				subUnitSituationList.add(subUnitSituationVO);
//			}
//		}
		
		 ///取得颜色阈值列表
		 List colorThresholdList = colorThresholdDao.getColorThresholdList();
		 
		 List totalList = new ArrayList();
		 if(null != subUnitSituationList && null != colorThresholdList){
			 totalList.add(0, subUnitSituationList);///放入子单位态势列表
			 totalList.add(1, colorThresholdList);///放入颜色阈值列表
			 totalList.add(2, errorMessage);///将错误信息带到前台页面。便于RMI连接失败时给出友好提示。
		 }
		
		 return totalList;
	}
	
	public String getInitValues(Integer id, String flag) 
			throws DataAccessResourceFailureException, IllegalStateException, ParseException {
		
		String colorRange = "ColorRange{red:80;yellow:60;green:40}";///取得颜色范围值
		
		String subNodes = "";
		if("ZhuJi".equals(flag)){
			subNodes = getZhuJiSubNodeValue(id,flag);///取得子节点
		}else {
			subNodes = getSubNodeValue(id,flag);///取得子节点
		}
		
		String historyValue = findHistoryValue(null, null, id, flag, 0);///取得历史值
		
		return colorRange + " " + subNodes + " " + historyValue;///拼接字符串返回
	}
	
	private String getZhuJiSubNodeValue(Integer id,String flag) {
		String subNodes = "SubNodes{攻击威胁:0;病毒疫情:0;非法连接:0}";
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());///当前时间
		Timestamp beginTime = new Timestamp(currentTime.getTime() - Constants.T);///三分钟之前的时间
		///RMI：根据主机的id和当前时间查找该主机的三分钟内最新态势
		org.infosec.ismp.manager.rmi.bsam.model.SubUnitSituationVO tempSubUnitSituationVO 
				= situationService.getMachineSituationByMachineId(id+"", beginTime, currentTime);
		
//		/** 以下模拟RMI返回结果测试srart **/
//		MachineSituation machineSituation = new MachineSituation();
//		machineSituation.setAttackThreat((float)Math.random()*100);///模拟生成100以内随机数
//		machineSituation.setInvalidConnection((float)Math.random()*100);///模拟生成100以内随机数
//		machineSituation.setVirusCondition((float)Math.random()*100);///模拟生成100以内随机数
//		/** 以上模拟RMI返回结果测试end **/
		
		if (null != tempSubUnitSituationVO) {
			String firPart = "SubNodes{";
			String lastPart = "}";
			
			Float attackThreat = (null == tempSubUnitSituationVO.getAttackThreat()?0f:tempSubUnitSituationVO.getAttackThreat());
			Float virusCondition = (null == tempSubUnitSituationVO.getVirusCondition()?0f:tempSubUnitSituationVO.getVirusCondition());
			Float invalidConnection = (null == tempSubUnitSituationVO.getInvalidConnection()?0f:tempSubUnitSituationVO.getInvalidConnection());
			String data = "攻击威胁:"
					+ attackThreat.intValue() + ";病毒疫情:"
					+ virusCondition.intValue()
					+ ";非法连接:"
					+ invalidConnection.intValue();
			subNodes = firPart + data + lastPart;
		}
		return subNodes;
	}
	
	@SuppressWarnings("unchecked")
	private String getSubNodeValue(Integer id,String flag) {
		
		List<SubUnitVO> subs = new ArrayList<SubUnitVO>();
		
		if("AnQuanYu".equals(flag)){
			subs = securityAreaService.getSubUnitById(id + "");
		}else if("JiFang".equals(flag)){
			subs = machineRoomService.getSubUnitById(id + "");
		}else if("JiGui".equals(flag)){
			subs = machineCabinetService.getSubUnitById(id + "");
		}else if("ZhiJi".equals(flag)){
			
		}
		String subNodes = "SubNodes{默认子单位:0}";
		if (subs != null && subs.size() > 0) {
			Timestamp currentTime = null;
			Timestamp beginTime = null;
			
			String firPart = "SubNodes{";
			String lastPart = "}";
			String data = "";
			SubUnitVO subUnitVO = null;
//			SubUnitSituationVO subUnitSituationVO = null;
			
			Float value = 0f;
			if (subs.size() > 1) {///子单位列表大于1台的时候
				for (int i = 0; i < subs.size() - 1; i++) {
					subUnitVO = (SubUnitVO) subs.get(i);///取得子单位列表中的一个子单位
					currentTime = new Timestamp(System.currentTimeMillis());///当前时间
					beginTime = new Timestamp(currentTime.getTime() - Constants.T);///三分钟之前的时间
					///RMI:根据子单位的id和当前时间查找该子单位的三分钟内最新态势,并且将该子单位三分钟内最新整体态势赋值给value
					if("AnQuanYu".equals(subUnitVO.getType())){
						value = situationService.getSecurityAreaSituationBySecurityAreaId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
					}else if("JiFang".equals(subUnitVO.getType())){
						value = situationService.getMachineRoomSituationByMachineRoomId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
					}else if("JiGui".equals(subUnitVO.getType())){
						value = situationService.getMachineCabinetSituationByMachineCabinetId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
					}else if("ZhuJi".equals(subUnitVO.getType())){
						value = situationService.getMachineSituationByMachineId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
					}
//					/** 以下模拟RMI返回结果测试srart **/
//					value = (float)Math.random()*100;///模拟生成100以内随机数
//					/** 以上模拟RMI返回结果测试end **/
					if(null == value){
						value = 0f;
					}
					///拼接字符串
					data += subUnitVO.getName() + ":" + value.intValue() + ";";
					value = 0f;
				}
				///该子单位列表中最后一个子单位
				subUnitVO = (SubUnitVO) subs.get(subs.size() - 1);
				///当前时间
				currentTime = new Timestamp(System.currentTimeMillis());
				beginTime = new Timestamp(currentTime.getTime() - Constants.T);///三分钟之前的时间
				///RMI:根据子单位的id和当前时间查找该子单位的三分钟内最新态势,并且将该子单位三分钟内最新整体态势赋值给value
				if("AnQuanYu".equals(subUnitVO.getType())){
					value = situationService.getSecurityAreaSituationBySecurityAreaId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
				}else if("JiFang".equals(subUnitVO.getType())){
					value = situationService.getMachineRoomSituationByMachineRoomId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
				}else if("JiGui".equals(subUnitVO.getType())){
					value = situationService.getMachineCabinetSituationByMachineCabinetId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
				}else if("ZhuJi".equals(subUnitVO.getType())){
					value = situationService.getMachineSituationByMachineId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
				}
//				/** 以下模拟RMI返回结果测试srart **/
//				value = (float)Math.random()*100;///模拟生成100以内随机数
//				/** 以上模拟RMI返回结果测试end **/
				if(null == value){
					value = 0f;
				}
				///拼接字符串
				data += subUnitVO.getName() + ":" + value.intValue();
				
			}else {///子单位列表小于等于1台的时候
				subUnitVO = (SubUnitVO) subs.get(0);///取得唯一的子单位
				currentTime = new Timestamp(System.currentTimeMillis());///当前时间
				beginTime = new Timestamp(currentTime.getTime() - Constants.T);///三分钟之前的时间
				///RMI:根据子单位的id和当前时间查找该子单位的三分钟内最新态势,并且将该子单位三分钟内最新整体态势赋值给value
				if("AnQuanYu".equals(subUnitVO.getType())){
					value = situationService.getSecurityAreaSituationBySecurityAreaId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
				}else if("JiFang".equals(subUnitVO.getType())){
					value = situationService.getMachineRoomSituationByMachineRoomId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
				}else if("JiGui".equals(subUnitVO.getType())){
					value = situationService.getMachineCabinetSituationByMachineCabinetId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
				}else if("ZhuJi".equals(subUnitVO.getType())){
					value = situationService.getMachineSituationByMachineId(subUnitVO.getId() + "", beginTime, currentTime).getWholeSituation();
				}
//				/** 以下模拟RMI返回结果测试srart **/
//				value = (float)Math.random()*100;///模拟生成100以内随机数
//				/** 以上模拟RMI返回结果测试end **/
				if(null == value){
					value = 0f;
				}
				///拼接字符串
				data = subUnitVO.getName() + ":" + value.intValue();
			}
			subNodes = firPart + data + lastPart;
		}
		
		return subNodes;
	}
	
	private String findHistoryValue(String beginTime, String endTime,Integer id,String flag, Integer firstIndex) 
			throws DataAccessResourceFailureException, IllegalStateException, ParseException{
		///解析开始时间
		if (beginTime != null && beginTime.length() <= 16) {
			beginTime += ":00";
			String[] time1 = beginTime.split("-");
			if (time1[1].length() != 2) {
				beginTime = time1[0] + "-" + "0" + time1[1] + "-" + time1[2];
			}
		}
		///解析结束时间
		if (endTime != null && endTime.length() <= 16) {
			endTime += ":00";
			String[] time2 = endTime.split("-");
			if (time2[1].length() != 2) {
				endTime = time2[0] + "-" + "0" + time2[1] + "-" + time2[2];
			}
		}

		String beginTime1 = beginTime;
		String endTime1 = endTime;
		String historyValue = "HistoryValue{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}";
		if (endTime == null && beginTime == null) {
			Date aDate = new Date();
			beginTime1 = DateUtil.getDate(aDate);
			long dateTickets = aDate.getTime();
			dateTickets -= Constants.T;
			Timestamp t = new Timestamp(dateTickets);
			endTime1 = t.toLocaleString();
		}
		
		List<SubUnitSituationVO> list = new ArrayList<SubUnitSituationVO>();
		if("AnQuanYu".equals(flag)){
			///取得该安全域在beginTime1——endTime1时间段历史态势列表
			List<SecurityAreaSituation> securityAreaSituationList = securityAreaSituationDao.getHistoryValue(beginTime1, endTime1, id, firstIndex);
			for (SecurityAreaSituation securityAreaSituation : securityAreaSituationList) {
				///将每个安全域态势封装成subUnitSituationVO方便后面统一调用
				SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
				subUnitSituationVO.setId(securityAreaSituation.getId());
				subUnitSituationVO.setName(securityAreaSituation.getDomain().getDomainName());
				subUnitSituationVO.setTime(securityAreaSituation.getTime());
				subUnitSituationVO.setType("AnQuanYu");
				subUnitSituationVO.setWholeSituation(securityAreaSituation.getWholeSituation());
				list.add(subUnitSituationVO);///将封存后的态势装入list
			}
		}else if("JiFang".equals(flag)){
			///取得该机房在beginTime1——endTime1时间段历史态势列表
			List<MachineRoomSituation> machineRoomSituationList = machineRoomSituationDao.getHistoryValue(beginTime1, endTime1, id, firstIndex);
			for (MachineRoomSituation machineRoomSituation : machineRoomSituationList) {
				///将每个机房态势封装成subUnitSituationVO方便后面统一调用
				SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
				subUnitSituationVO.setId(machineRoomSituation.getId());
				subUnitSituationVO.setName(machineRoomSituation.getMachineRoom().getMachineRoomName());
				subUnitSituationVO.setTime(machineRoomSituation.getTime());
				subUnitSituationVO.setType("JiFang");
				subUnitSituationVO.setWholeSituation(machineRoomSituation.getWholeSituation());
				list.add(subUnitSituationVO);///将封存后的态势装入list
			}
		}else if("JiGui".equals(flag)){
			///取得该机柜在beginTime1——endTime1时间段历史态势列表
			List<MachineCabinetSituation> machineCabinetSituationList = machineCabinetSituationDao.getHistoryValue(beginTime1, endTime1, id, firstIndex);
			for (MachineCabinetSituation machineCabinetSituation : machineCabinetSituationList) {
				///将每个机柜态势封装成subUnitSituationVO方便后面统一调用
				SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
				subUnitSituationVO.setId(machineCabinetSituation.getId());
				subUnitSituationVO.setName(machineCabinetSituation.getMachineCabinet().getMachineCabinetName());
				subUnitSituationVO.setTime(machineCabinetSituation.getTime());
				subUnitSituationVO.setType("JiGui");
				subUnitSituationVO.setWholeSituation(machineCabinetSituation.getWholeSituation());
				list.add(subUnitSituationVO);///将封存后的态势装入list
			}
		}else if("ZhuJi".equals(flag)){
			///取得该主机在beginTime1——endTime1时间段历史态势列表
			List<MachineSituation> machineSituationList = machineSituationDao.getHistoryValue(beginTime1, endTime1, id, firstIndex);
			for (MachineSituation machineSituation : machineSituationList) {
				///将每个主机态势封装成subUnitSituationVO方便后面统一调用
				SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
				subUnitSituationVO.setId(machineSituation.getId());
				subUnitSituationVO.setName(machineSituation.getMachine().getMachineName());
				subUnitSituationVO.setTime(machineSituation.getTime());
				subUnitSituationVO.setType("ZhuJi");
				subUnitSituationVO.setWholeSituation(machineSituation.getWholeSituation());
				list.add(subUnitSituationVO);///将封存后的态势装入list
			}
		}
		if (null != list && list.size() > 0) {
			String firPart = "HistoryValue{";
			String lastPart = "}";
			String data = "";
			SubUnitSituationVO subUnitSituationVO = null;
			if (list.size() > 1) {
				for (int i = 0; i < list.size() - 1; i++) {
					subUnitSituationVO = list.get(i);
					data += subUnitSituationVO.getWholeSituation().intValue() + ",";///提取整体态势拼接字符串
				}
				subUnitSituationVO = list.get(list.size() - 1);
				data += subUnitSituationVO.getWholeSituation().intValue();///提取整体态势拼接字符串
			}else {
				subUnitSituationVO = list.get(0);
				data += subUnitSituationVO.getWholeSituation().intValue();///提取整体态势拼接字符串
			}
			historyValue = firPart + data + lastPart;
		}
		
		return historyValue;
	}

	public String getCurrentValues(Integer id, String flag) {
		String node = "Node:" + 0;
		SubUnitSituationVO subUnitSituationVO = getCurrentNode(id, flag);///根据id, flag取得该subUnit的态势展示对象
		if (subUnitSituationVO != null) {
			node = "Node:" + subUnitSituationVO.getWholeSituation().intValue();///从态势展示对象中取得整体态势
		}
		String subNodes = "";
		if("ZhuJi".equals(flag)){
			subNodes = getZhuJiSubNodeValue(id,flag);///取得子节点
		}else {
			subNodes = getSubNodeValue(id,flag);///根据id,flag取得子节点
		}
		return node + " " + subNodes;///拼接态势信息字符串返回
	}
	
	private SubUnitSituationVO getCurrentNode(Integer id, String flag){
		///根据子单位的id和当前时间查找该子单位的三分钟内最新态势,并且将该子单位三分钟内最新整体态势赋值给value
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		Timestamp beginTime = new Timestamp(currentTime.getTime() - Constants.T);///三分钟之前的时间
		SubUnitSituationVO subUnitSituationVO = new SubUnitSituationVO();
		
//		/** 以下模拟RMI返回结果测试srart **/
//		subUnitSituationVO.setWholeSituation((float)Math.random()*100);///模拟生成100以内随机数
//		/** 以上模拟RMI返回结果测试end **/
		
		///RMI
		if("AnQuanYu".equals(flag)){
			org.infosec.ismp.manager.rmi.bsam.model.SecurityAreaSituationVO tempSecurityAreaSituationVO = situationService.getSecurityAreaSituationBySecurityAreaId(id + "", beginTime, currentTime);
			/** 其实这里只需要持久WholeSituation的值即可 **/
			subUnitSituationVO.setId(tempSecurityAreaSituationVO.getId());///这个id不是subUnit的id是subUnitSituation的id
			subUnitSituationVO.setName(tempSecurityAreaSituationVO.getSecurityAreaName());
			subUnitSituationVO.setTime(tempSecurityAreaSituationVO.getTime());
			subUnitSituationVO.setType("AnQuanYu");
			subUnitSituationVO.setWholeSituation(null == tempSecurityAreaSituationVO.getWholeSituation()?0f:tempSecurityAreaSituationVO.getWholeSituation());
		}else if("JiFang".equals(flag)){
			org.infosec.ismp.manager.rmi.bsam.model.SubUnitSituationVO tempSubUnitSituationVO = situationService.getMachineRoomSituationByMachineRoomId(id + "", beginTime, currentTime);
			/** 其实这里只需要持久WholeSituation的值即可 **/
			subUnitSituationVO.setId(tempSubUnitSituationVO.getId());///这个id不是subUnit的id是subUnitSituation的id
			subUnitSituationVO.setName(tempSubUnitSituationVO.getName());
			subUnitSituationVO.setTime(tempSubUnitSituationVO.getTime());
			subUnitSituationVO.setType(tempSubUnitSituationVO.getType());
			subUnitSituationVO.setWholeSituation(null == tempSubUnitSituationVO.getWholeSituation()?0f:tempSubUnitSituationVO.getWholeSituation());
		}else if("JiGui".equals(flag)){
			org.infosec.ismp.manager.rmi.bsam.model.SubUnitSituationVO tempSubUnitSituationVO = situationService.getMachineCabinetSituationByMachineCabinetId(id + "", beginTime, currentTime);
			/** 其实这里只需要持久WholeSituation的值即可 **/
			subUnitSituationVO.setId(tempSubUnitSituationVO.getId());///这个id不是subUnit的id是subUnitSituation的id
			subUnitSituationVO.setName(tempSubUnitSituationVO.getName());
			subUnitSituationVO.setTime(tempSubUnitSituationVO.getTime());
			subUnitSituationVO.setType(tempSubUnitSituationVO.getType());
			subUnitSituationVO.setWholeSituation(null == tempSubUnitSituationVO.getWholeSituation()?0f:tempSubUnitSituationVO.getWholeSituation());
		}else if("ZhuJi".equals(flag)){
			org.infosec.ismp.manager.rmi.bsam.model.SubUnitSituationVO tempSubUnitSituationVO = situationService.getMachineSituationByMachineId(id + "", beginTime, currentTime);
			/** 其实这里只需要持久WholeSituation的值即可 **/
			subUnitSituationVO.setId(tempSubUnitSituationVO.getId());///这个id不是subUnit的id是subUnitSituation的id
			subUnitSituationVO.setName(tempSubUnitSituationVO.getName());
			subUnitSituationVO.setTime(tempSubUnitSituationVO.getTime());
			subUnitSituationVO.setType(tempSubUnitSituationVO.getType());
			subUnitSituationVO.setWholeSituation(null == tempSubUnitSituationVO.getWholeSituation()?0f:tempSubUnitSituationVO.getWholeSituation());
		}else {
			subUnitSituationVO.setWholeSituation(0f);
		}
		return subUnitSituationVO;
	}

	public String getHistoryValue(String beginTime, String endTime, Integer id,String flag, Integer firstIndex)
			throws DataAccessResourceFailureException, IllegalStateException,ParseException {
		
		String colorRange = "ColorRange{red:80;yellow:60;green:40}";///取得颜色范围值
		firstIndex = (firstIndex == null) ? 0 : firstIndex;
		String historyValue = findHistoryValue(beginTime, endTime,id,flag, firstIndex);///取得历史态势
		return colorRange + " " + historyValue;
	}
}
