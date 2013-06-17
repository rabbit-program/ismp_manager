package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToSoftwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetToSoftwareService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;


/**
 * AssetToSoftware的service实现类
 * 
 * @author breggor
 * 
 */
public class AssetToSoftwareServiceImpl implements AssetToSoftwareService {
	private AssetToSoftwareDao assetToSoftwareDao;
	
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
	public void setAssetToSoftwareDao(AssetToSoftwareDao vAssetToSoftwareDao) {
		assetToSoftwareDao = vAssetToSoftwareDao;
	}

	/**
	 * @param vAssetToSoftware
	 *            the assetToSoftware to save
	 */
	public void saveAssetToSoftware(AssetToSoftwareBO entity) {
		
		try{
			init();
			assetToSoftwareDao.saveAssetToSoftware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加assetToSoftware");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加assetToSoftware");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void updateAssetToSoftware(AssetToSoftwareBO entity) {
		
		try{
			init();
			assetToSoftwareDao.updateAssetToSoftware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc(" 更新assetToSoftware");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc(" 更新assetToSoftware");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void deleteAssetToSoftware(AssetToSoftwareBO entity) {
		
		try{
			init();
			assetToSoftwareDao.deleteAssetToSoftware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除assetToSoftware");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除assetToSoftware");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public AssetToSoftwareBO getAssetToSoftware(Serializable entityId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("ID查询assetToSoftware");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToSoftwareDao.getAssetToSoftware(entityId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("ID查询assetToSoftware");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetToSoftwareBO> getListByAssetToSoftware(
			AssetToSoftwareBO entity) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("model模糊查询assetToSoftware");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToSoftwareDao.getListByAssetToSoftware(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("model模糊查询assetToSoftware");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetDeviceBO> getListByAssetDevice(Serializable softwareId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("software ID查询AssetDeviceBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToSoftwareDao.getListByAssetDevice(softwareId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("software ID查询AssetDeviceBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetSoftwareBO> getListByAssetSoftware(Serializable deviceId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("Device ID查询AssetSoftwareBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToSoftwareDao.getListByAssetSoftware(deviceId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("Device ID查询AssetSoftwareBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable softwareId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("software ID查询没有关联的AssetDeviceBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToSoftwareDao.getListNotJoinAssetDevice(softwareId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("software ID查询没有关联的AssetDeviceBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetSoftwareBO> getListNotJoinAssetSoftware(
			Serializable deviceId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("Device ID查询没有关联的AssetSoftwareBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToSoftwareDao.getListNotJoinAssetSoftware(deviceId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("Device ID查询没有关联的AssetSoftwareBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public int getCountByAssetSoftware(Serializable deviceId) { 
		return assetToSoftwareDao.getCountByAssetSoftware(deviceId);
	}
	public PageResult getPageListByAssetSoftware(Serializable deviceId,
			Page page) { 
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("Device ID分页查询AssetSoftwareBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			int count = getCountByAssetSoftware(deviceId);
			page = PageUtil.createPage(page, count);
			List list = assetToSoftwareDao.getPageListByAssetSoftware(deviceId, page);
			return new PageResult(page, list);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("Device ID分页查询AssetSoftwareBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

}
