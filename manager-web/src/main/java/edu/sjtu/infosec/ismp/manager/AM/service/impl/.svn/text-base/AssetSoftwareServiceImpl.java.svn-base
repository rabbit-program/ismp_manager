package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetSoftwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetSoftwareService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * AssetSoftware的service实现类
 * @author breggor
 *
 */
public class AssetSoftwareServiceImpl implements AssetSoftwareService
{
	private AssetSoftwareDao assetSoftwareDao;

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
	public void setAssetSoftwareDao(AssetSoftwareDao assetSoftwareDao)
	{
		this.assetSoftwareDao = assetSoftwareDao;
	}

	public void saveAssetSoftware(AssetSoftwareBO entity)
	{
		try{
			init();
			assetSoftwareDao.saveAssetSoftware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加软件信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加软件信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
		
	}

	public void updateAssetSoftware(AssetSoftwareBO entity)
	{
		
		try{
			init();
			assetSoftwareDao.updateAssetSoftware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改软件信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改软件信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void deleteAssetSoftware(AssetSoftwareBO entity)
	{
		
		try{
			init();
			assetSoftwareDao.deleteAssetSoftware(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除软件信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除软件信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public AssetSoftwareBO getAssetSoftware(Serializable entityId)
	{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到软件信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetSoftwareDao.getAssetSoftware(entityId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到软件信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetSoftwareBO> getListByAssetSoftware(AssetSoftwareBO entity)
	{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到软件信息列表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetSoftwareDao.getListByAssetSoftware(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到软件信息列表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	public int getCountByAssetSoftware(AssetSoftwareBO entity) { 
		return assetSoftwareDao.getCountByAssetSoftware(entity);
	}
	public PageResult getPageListByAssetSoftware(AssetSoftwareBO entity,
			Page page) { 
		
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到软件信息列表并分页显示");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			int totalCount = getCountByAssetSoftware(entity);
			page = PageUtil.createPage(page, totalCount);
			List<AssetSoftwareBO> list = assetSoftwareDao.getPageListByAssetSoftware(entity, page);
			return new PageResult(page, list);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据查询条件得到软件信息列表并分页显示");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

}
