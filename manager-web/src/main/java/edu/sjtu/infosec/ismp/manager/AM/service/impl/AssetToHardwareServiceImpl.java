package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToHardwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetToHardwareService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * AssetToHardware的service实现类
 * @author breggor
 *
 */
public class AssetToHardwareServiceImpl implements AssetToHardwareService
{
	private AssetToHardwareDao assetToHardwareDao;
	
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
	public void setAssetToHardwareDao(AssetToHardwareDao vAssetToHardwareDao)
	{
		assetToHardwareDao = vAssetToHardwareDao;
	}
 
	public void saveAssetToHardware(AssetToHardwareBO entity)
	{
		
		try{
			init();
			assetToHardwareDao.saveAssetToHardware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产到硬件信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产到硬件信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}
	public void updateAssetToHardware(AssetToHardwareBO entity)
	{
		
		try{
			init();
			assetToHardwareDao.updateAssetToHardware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产到硬件信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产到硬件信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}
	public void deleteAssetToHardware(AssetToHardwareBO entity)
	{
		
		try{
			init();
			assetToHardwareDao.deleteAssetToHardware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产到硬件信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产到硬件信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}
	public AssetToHardwareBO getAssetToHardware(Serializable entityId)
	{ 
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产到硬件信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToHardwareDao.getAssetToHardware(entityId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产到硬件信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public List<AssetToHardwareBO> getListByAssetToHardware(
			AssetToHardwareBO entity)
	{ 
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到资产到硬件信息列表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToHardwareDao.getListByAssetToHardware(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到资产到硬件信息列表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
		
	}
	public List<AssetDeviceBO> getListByAssetDevice(Serializable hardwareId) { 
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据硬件ID到资产到硬件信息列表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToHardwareDao.getListByAssetDevice(hardwareId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据硬件ID到资产到硬件信息列表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
		
	}
	public List<AssetHardwareBO> getListByHardware(Serializable assetId) { 
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据资产ID到资产到硬件信息列表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToHardwareDao.getListByHardware(assetId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据资产ID到资产到硬件信息列表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable hardwareId) {  
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetDevice ID查询没有关联的AssetSoftwareBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToHardwareDao.getListNotJoinAssetDevice(hardwareId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetDevice ID查询没有关联的AssetSoftwareBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public List<AssetHardwareBO> getListNotJoinHardware(Serializable assetId) { 
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetDeviceBO的ID查询没有关联AssetHardwareBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToHardwareDao.getListNotJoinHardware(assetId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetDeviceBO的ID查询没有关联AssetHardwareBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public int getCounttByHardware(Serializable deviceId) { 
		return assetToHardwareDao.getCountByHardware(deviceId); 
	}
	public PageResult getPageListByHardware(Serializable deviceId, Page page) { 
		
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetDeviceBO的ID分页查询AssetHardwareBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			int count = assetToHardwareDao.getCountByHardware(deviceId);
			page = PageUtil.createPage(page, count);
			List list = assetToHardwareDao.getPageListByHardware(deviceId, page);
			return new PageResult(page, list);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetDeviceBO的ID分页查询AssetHardwareBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

}
