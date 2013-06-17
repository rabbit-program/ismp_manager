package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetChangeLogDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetChangeLogBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetChangeLogService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;



public class AssetChangeLogServiceImpl implements AssetChangeLogService {
	private AssetChangeLogDao assetChangeLogDao;
	
	private SystemLogService systemlogService;
	

	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}

	public void setAssetChangeLogDao(AssetChangeLogDao assetChangeLogDao) {
		this.assetChangeLogDao = assetChangeLogDao;
	}
	
	SystemLog log;
	String rolenames;
	String username;
	void  init(){
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		username = user.getUsername();
		rolenames="";
		for(Role role : user.getRoleList()){
			rolenames = rolenames+role.getName();
		}
		log = new SystemLog();
	}

	/**
	 * 保存资产变动信息
	 * 
	 * @param entity
	 */
	public void saveAssetChangeLog(AssetChangeLogBO entity) {
		
		try{
			init();
			assetChangeLogDao.saveAssetChangeLog(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("进行资产更变保存操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("进行资产更变保存操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	/**
	 * 更新资产变动信息
	 * 
	 * @param entity
	 */
	public void updateAssetChangeLog(AssetChangeLogBO entity) {
		
		try{
			init();
			assetChangeLogDao.updateAssetChangeLog(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("资产更变更新操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("资产更变更新操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	/**
	 * 删除资产变动信息
	 * 
	 * @param entity
	 */
	public void deleteAssetChangeLog(AssetChangeLogBO entity) {
		try{
			init();
			assetChangeLogDao.deleteAssetChangeLog(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("资产更变删除操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("资产更变删除操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	/**
	 * 根据Id查询资产变动信息
	 * 
	 * @param entityId
	 * @return
	 */
	public AssetChangeLogBO getAssetChangeLog(Serializable entityId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产更变信息操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetChangeLogDao.getAssetChangeLog(entityId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产更变信息操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 查询所有的资产变动信息
	 * 
	 * @param entity
	 * @return
	 */
	public List<AssetChangeLogBO> getListByAssetChangeLog(
			AssetChangeLogBO entity) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询资产更变信息操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetChangeLogDao.getListByAssetChangeLog(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询资产更变信息操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	/**
	 * 分页查询所有的资产变动信息
	 */
	public PageResult getPageListByAssetChangeLog(AssetChangeLogBO entity,
			Page page) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询资产更变信息操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			int count = assetChangeLogDao.getListByAssetChangeLog(entity).size(); 
			page = PageUtil.createPage(page, count);
			List list = assetChangeLogDao.getPageListByAssetChangeLog(entity, page);
			return new PageResult(page, list);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询资产更变信息操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
}
