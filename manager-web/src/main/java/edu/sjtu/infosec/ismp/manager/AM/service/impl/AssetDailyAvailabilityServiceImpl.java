package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetDailyAvailabilityDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDailyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetMonthlyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDailyAvailabilityService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;


/**
 * AssetDailyAvailability的service实现类
 * 
 * @author breggor
 * 
 */
public class AssetDailyAvailabilityServiceImpl implements
		AssetDailyAvailabilityService {
	private AssetDailyAvailabilityDao assetDailyAvailabilityDao;

	private SystemLogService systemlogService;
	
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
	
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}
	/**
	 * 实现接口方法
	 */
	public void setAssetDailyAvailabilityDao(
			AssetDailyAvailabilityDao assetDailyAvailabilityDao) {
		this.assetDailyAvailabilityDao = assetDailyAvailabilityDao;
	}

	public void saveAssetDailyAvailability(AssetDailyAvailabilityBO entity) {
		
		try{
			init();
			assetDailyAvailabilityDao.saveAssetDailyAvailability(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产可用性操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产可用性操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void deleteAssetDailyAvailability(AssetDailyAvailabilityBO entity) {
		
		try{
			init();
			assetDailyAvailabilityDao.deleteAssetDailyAvailability(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产可用性操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产可用性操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void updateAssetDailyAvailability(AssetDailyAvailabilityBO entity) {
		
		try{
			init();
			assetDailyAvailabilityDao.updateAssetDailyAvailability(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产可用性操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产可用性操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public AssetDailyAvailabilityBO getAssetDailyAvailability(
			Serializable entityId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产可用性");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetDailyAvailabilityDao.getAssetDailyAvailability(entityId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产可用性");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetDailyAvailabilityBO> getListByAssetDailyAvailability(
			AssetDailyAvailabilityBO entity) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据条件查询资产可用性");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetDailyAvailabilityDao.getListByAssetDailyAvailability(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据条件查询资产可用性");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public AssetMonthlyAvailabilityBO getAverageAssetMonthlyAvailability(
			Integer assetId, Integer type, Timestamp currentDate) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据资产ID、类型、时间得到资产月可用性");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetDailyAvailabilityDao.getAverageAssetMonthlyAvailability(assetId, type, currentDate);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据资产ID、类型、时间得到资产月可用性");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<Integer> getDayChartData(Timestamp date,
			AssetDailyAvailabilityBO entity) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("得到日可用性图表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetDailyAvailabilityDao.getDayChartData(date, entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("得到日可用性图表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

}
