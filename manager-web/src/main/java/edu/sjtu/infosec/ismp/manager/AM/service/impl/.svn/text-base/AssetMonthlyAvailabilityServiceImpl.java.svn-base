package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetMonthlyAvailabilityDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetMonthlyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetMonthlyAvailabilityService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;


/**
 * AssetMonthlyAvailability的service实现类
 * 
 * @author breggor
 * 
 */
public class AssetMonthlyAvailabilityServiceImpl implements
		AssetMonthlyAvailabilityService {
	private AssetMonthlyAvailabilityDao assetMonthlyAvailabilityDao;

	private SystemLogService systemlogService;
	
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}
	
	SystemLog log;
	String rolenames;
	String username;
	void init(){
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		username = user.getUsername();
		rolenames="";
		for(Role role : user.getRoleList()){
			rolenames = rolenames+role.getName();
		}
		log = new SystemLog();
	}
	/**
	 * 实现接口方法
	 */
	public void setAssetMonthlyAvailabilityDao(
			AssetMonthlyAvailabilityDao vAssetMonthlyAvailabilityDao) {
		assetMonthlyAvailabilityDao = vAssetMonthlyAvailabilityDao;
	}

	public void saveAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity) {
		
		try{
			init();
			assetMonthlyAvailabilityDao.saveAssetMonthlyAvailability(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产月可用性");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产月可用性");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void deleteAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity) {
		
		try{
			init();
			assetMonthlyAvailabilityDao.deleteAssetMonthlyAvailability(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产月可用性");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产月可用性");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void updateAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity) {
		try{
			init();
			assetMonthlyAvailabilityDao.updateAssetMonthlyAvailability(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产月可用性");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产月可用性");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public List<AssetMonthlyAvailabilityBO> getListByAssetMonthlyAvailability(
			AssetMonthlyAvailabilityBO entity) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产月可用性");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetMonthlyAvailabilityDao.getListByAssetMonthlyAvailability(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产月可用性");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public AssetMonthlyAvailabilityBO getAssetMonthlyAvailability(
			Serializable entityId) {
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产月可用性");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetMonthlyAvailabilityDao
			.getAssetMonthlyAvailability(entityId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产月可用性");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
		
	}

	public List<Integer> getMonthChartData(Timestamp date,
			AssetMonthlyAvailabilityBO entity) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取某月的使用率");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetMonthlyAvailabilityDao.getMonthChartData(date, entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取某月的使用率");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<Integer> getYearChartData(Timestamp date,
			AssetMonthlyAvailabilityBO entity) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取某年的使用率");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetMonthlyAvailabilityDao.getYearChartData(date, entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取某年的使用率");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

}
