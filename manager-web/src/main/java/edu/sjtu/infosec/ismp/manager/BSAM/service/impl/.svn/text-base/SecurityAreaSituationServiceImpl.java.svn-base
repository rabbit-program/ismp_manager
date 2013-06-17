package edu.sjtu.infosec.ismp.manager.BSAM.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.infosec.ismp.manager.rmi.bsam.service.SituationService;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.Constants;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.ColorThresholdDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.SecurityAreaSituationVO;
import edu.sjtu.infosec.ismp.manager.BSAM.service.SecurityAreaSituationService;

public class SecurityAreaSituationServiceImpl implements SecurityAreaSituationService {
	
	private static Logger logger = Logger.getLogger(SecurityAreaSituationServiceImpl.class); 
	
	private ColorThresholdDao colorThresholdDao;
	
	private SituationService situationService;///RMI
	
	public ColorThresholdDao getColorThresholdDao() {
		return colorThresholdDao;
	}

	public void setColorThresholdDao(ColorThresholdDao colorThresholdDao) {
		this.colorThresholdDao = colorThresholdDao;
	}

	public SituationService getSituationService() {
		return situationService;
	}

	public void setSituationService(SituationService situationService) {
		this.situationService = situationService;
	}

	@SuppressWarnings("unchecked")
	public List getSecurityAreaSituation(String userDomainStr) {
		 ///当前时间
		 Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		 ///三分钟之前的时间
		 Timestamp beginTime = new Timestamp(currentTime.getTime() - Constants.T);
		 String[] domainIds = {};
		 if(null != userDomainStr && !"".equals(userDomainStr)){
			 domainIds = userDomainStr.split(",");
		 }	 
		 
		 String errorMessage = "right";
		 List<SecurityAreaSituationVO> securityAreaSituationList = new ArrayList<SecurityAreaSituationVO>();
		 for (int i = 0; i < domainIds.length; i++) {
			 
			 
			 try {
				 ///取得beginTime——endTime时间段内域id为domainIds[i]的安全域态势
				 org.infosec.ismp.manager.rmi.bsam.model.SecurityAreaSituationVO  tempSecurityAreaSituationVO 
				 			= situationService.getSecurityAreaSituationBySecurityAreaId(domainIds[i], beginTime, currentTime);
				 SecurityAreaSituationVO securityAreaSituationVO = new SecurityAreaSituationVO();
				 securityAreaSituationVO.setId(Integer.parseInt(domainIds[i]));
				 securityAreaSituationVO.setTime(null == tempSecurityAreaSituationVO.getTime()?currentTime:tempSecurityAreaSituationVO.getTime());
				 securityAreaSituationVO.setSecurityAreaName(null == tempSecurityAreaSituationVO.getSecurityAreaName()?"":tempSecurityAreaSituationVO.getSecurityAreaName());
				 securityAreaSituationVO.setAttackThreat(null == tempSecurityAreaSituationVO.getAttackThreat()?0f:tempSecurityAreaSituationVO.getAttackThreat());
				 securityAreaSituationVO.setVirusCondition(null == tempSecurityAreaSituationVO.getVirusCondition()?0f:tempSecurityAreaSituationVO.getVirusCondition());
				 securityAreaSituationVO.setInvalidConnection(null == tempSecurityAreaSituationVO.getInvalidConnection()?0f:tempSecurityAreaSituationVO.getInvalidConnection());
				 securityAreaSituationVO.setWholeSituation(null == tempSecurityAreaSituationVO.getWholeSituation()?0f:tempSecurityAreaSituationVO.getWholeSituation());
				 securityAreaSituationList.add(securityAreaSituationVO);
				 
			} catch (Exception e) {
				logger.error("后台调用失败！");
				errorMessage = "error";
			}
			 
		 }
		 
//		 /** 以下模拟RMI返回结果测试 **/
//		 List<SecurityAreaSituationVO> securityAreaSituationList = new ArrayList<SecurityAreaSituationVO>();
//		 for (int i = 0; i < domainIds.length; i++) {
//			 SecurityAreaSituationVO tempSecurityAreaSituationVO = new SecurityAreaSituationVO();
//			 tempSecurityAreaSituationVO.setId(Integer.parseInt(domainIds[i]));
//			 tempSecurityAreaSituationVO.setTime(currentTime);
//			 tempSecurityAreaSituationVO.setAttackThreat(3.5f);
//			 tempSecurityAreaSituationVO.setVirusCondition(4.5f);
//			 tempSecurityAreaSituationVO.setInvalidConnection(5.5f);
//			 tempSecurityAreaSituationVO.setWholeSituation((float)Math.random()*100);///模拟生成100以内随机数
//			 
//			 securityAreaSituationList.add(tempSecurityAreaSituationVO);
//		 }
		 
		 ///取得颜色阈值列表
		 List colorThresholdList = colorThresholdDao.getColorThresholdList();
		 
		 List totalList = new ArrayList();
		 if(null != securityAreaSituationList && null != colorThresholdList){
			 totalList.add(0, securityAreaSituationList);///放入安全域态势列表
			 totalList.add(1, colorThresholdList);///放入颜色阈值列表
			 totalList.add(2, errorMessage);///将错误信息带到前台页面。便于RMI连接失败时给出友好提示。
		 }
		
		 return totalList;
	}
	
}
