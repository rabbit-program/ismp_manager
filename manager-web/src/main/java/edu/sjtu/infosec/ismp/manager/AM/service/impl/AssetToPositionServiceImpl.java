package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToPositionDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetToPositionService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * AssetToPosition的service实现类
 * @author breggor
 *
 */
public class AssetToPositionServiceImpl implements AssetToPositionService
{
	private AssetToPositionDao assetToPositionDao;

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
	public void setAssetToPositionDao(AssetToPositionDao vAssetToPositionDao)
	{
		assetToPositionDao = vAssetToPositionDao;
	}
 
	public void saveAssetToPosition(AssetToPositionBO entity)
	{
		try{
			init();
			assetToPositionDao.saveAssetToPosition(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加assetToPosition");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加assetToPosition");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
		
	}
	public void updateAssetToPosition(AssetToPositionBO entity)
	{
		
		 try{
				init();
				 assetToPositionDao.updateAssetToPosition(entity);
				log.setUsername(username);
				log.setRoleName(rolenames);
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_AM);
				log.setOperationDesc("修改assetToPosition");
				log.setControl("成功");
				systemlogService.saveSystemLog(log);
			}catch(Exception e){
				log.setUsername(username);
				log.setRoleName(rolenames);
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_AM);
				log.setOperationDesc("修改assetToPosition");
				log.setControl("失败");
				systemlogService.saveSystemLog(log);
			}
	}
	public void deleteAssetToPosition(AssetToPositionBO entity)
	{
		 
		 try{
				init();
				assetToPositionDao.deleteAssetToPosition(entity);
				log.setUsername(username);
				log.setRoleName(rolenames);
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_AM);
				log.setOperationDesc("删除assetToPosition");
				log.setControl("成功");
				systemlogService.saveSystemLog(log);
			}catch(Exception e){
				log.setUsername(username);
				log.setRoleName(rolenames);
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_AM);
				log.setOperationDesc("删除assetToPosition");
				log.setControl("失败");
				systemlogService.saveSystemLog(log);
			}
	}
	public AssetToPositionBO getAssetToPosition(Serializable entityId)
	{ 
		
		 try{
				init();
				log.setUsername(username);
				log.setRoleName(rolenames);
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_AM);
				log.setOperationDesc("根据ID 查询assetToPosition");
				log.setControl("成功");
				systemlogService.saveSystemLog(log);
				return assetToPositionDao.getAssetToPosition(entityId);
			}catch(Exception e){
				log.setUsername(username);
				log.setRoleName(rolenames);
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_AM);
				log.setOperationDesc("根据ID 查询assetToPosition");
				log.setControl("失败");
				systemlogService.saveSystemLog(log);
				return null;
			}
	}
	public List<AssetToPositionBO> getListByAssetToPosition(
			AssetToPositionBO entity)
	{ 
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("model模糊查询assetToPosition");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToPositionDao.getListByAssetToPosition(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("model模糊查询assetToPosition");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public List<AssetDeviceBO> getListByAssetDevice(Serializable positionId) { 
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetPositionBO ID查询AssetDeviceBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToPositionDao.getListByAssetDevice(positionId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetPositionBO ID查询AssetDeviceBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public List<AssetPositionBO> getListByPosition(Serializable deviceId) { 
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetDeviceBO ID查询AssetPositionBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToPositionDao.getListByPosition(deviceId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetDeviceBO ID查询AssetPositionBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public int getCountByAssetDevice(Serializable positionId) {
		return assetToPositionDao.getCountByAssetDevice(positionId); 
	}
	public PageResult getPageListByAssetDevice(Serializable positionId,Page page) {  
		
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetPositionBO ID分页查询");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			int count = getCountByAssetDevice(positionId);
			page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), count);
			List list = assetToPositionDao.getPageListByAssetDevice(positionId, page); 
			page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), page.getTotalCount());
			return new PageResult(page, list);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetPositionBO ID分页查询");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable positionId) { 
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc(" AssetPositionBO ID查询没有关联的AssetDeviceBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToPositionDao.getListNotJoinAssetDevice(positionId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc(" AssetPositionBO ID查询没有关联的AssetDeviceBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public List<AssetPositionBO> getListNotJoinPosition(Serializable deviceId) { 
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("AssetDeviceBO ID查询没有关联的AssetPositionBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToPositionDao.getListNotJoinPosition(deviceId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc(" AssetDeviceBO ID查询没有关联的AssetPositionBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetDeviceBO> getListNotJoinAssetDevice() {
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询没有关联的AssetDeviceBO");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetToPositionDao.getListNotJoinAssetDevice();
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询没有关联的AssetDeviceBO");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
}
