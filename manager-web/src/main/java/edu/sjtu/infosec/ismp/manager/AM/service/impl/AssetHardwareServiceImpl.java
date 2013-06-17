package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetHardwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetHardwareService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * AssetHardwareService的service实现类 
 * @author breggor
 *
 */
public class AssetHardwareServiceImpl implements AssetHardwareService
{
	private AssetHardwareDao assetHardwareDao;

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
	public void setAssetHardwareDao(AssetHardwareDao assetHardwareDao)
	{
		this.assetHardwareDao = assetHardwareDao;
	}

	public void saveAssetHardware(AssetHardwareBO entity)
	{
		
		try{
			init();
			assetHardwareDao.saveAssetHardware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产硬件操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产硬件操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void updateAssetHardware(AssetHardwareBO entity)
	{
		
		try{
			init();
			assetHardwareDao.updateAssetHardware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产硬件操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产硬件操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void deleteAssetHardware(AssetHardwareBO entity)
	{
		
		try{
			init();
			assetHardwareDao.deleteAssetHardware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产硬件操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产硬件操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public AssetHardwareBO getAssetHardware(Serializable entityId)
	{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产硬件操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetHardwareDao.getAssetHardware(entityId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产硬件操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetHardwareBO> getListByAssetHardware(AssetHardwareBO entity)
	{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到资产硬件列表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetHardwareDao.getListByAssetHardware(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到资产硬件列表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public int getCountByAssetHardware(AssetHardwareBO entity) { 
		return assetHardwareDao.getCountByAssetHardware(entity);
	}
	public PageResult getPageListByAssetHardware(AssetHardwareBO entity,
			Page page) { 
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到资产硬件列表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			int totalCount = getCountByAssetHardware(entity);
			page = PageUtil.createPage(page, totalCount);
			List<AssetHardwareBO> list = assetHardwareDao.getPageListByAssetHardware(entity, page); 
			return new PageResult(page, list);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到资产硬件列表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

}
