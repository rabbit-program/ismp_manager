package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetPositionDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetPositionService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;


/**
 * AssetPositionService的service实现类
 * 
 * @author breggor
 * 
 */

public class AssetPositionServiceImpl implements AssetPositionService {
	private AssetPositionDao assetPositionDao;

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
	public void setAssetPositionDao(AssetPositionDao assetPositionDao) {
		this.assetPositionDao = assetPositionDao;
	}

	public void saveAssetPosition(AssetPositionBO entity) {
		try{
			init();
			assetPositionDao.saveAssetPosition(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加位置操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加位置操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void updateAssetPosition(AssetPositionBO entity) {
		
		try{
			init();
			assetPositionDao.updateAssetPosition(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改位置操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改位置操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void deleteAssetPosition(AssetPositionBO entity) {
		
		try{
			init();
			assetPositionDao.deleteAssetPosition(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产位置操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产位置操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public AssetPositionBO getAssetPosition(Serializable entityId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到位置操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetPositionDao.getAssetPosition(entityId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到位置操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetPositionBO> getListByAssetPosition(AssetPositionBO entity) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据条件查询位置列表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetPositionDao.getListByAssetPosition(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据条件查询位置列表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetPositionBO> getChildNodeByPosition(Serializable positionId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据物理位置得到子节点");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetPositionDao.getChildNodeByPosition(positionId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据物理位置得到子节点");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetPositionBO> getChildNodeListByParent(Serializable rootId) {

		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据物理位置得到子节点");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetPositionDao.getChildNodeListByParent(rootId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据物理位置得到子节点");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
		
	}

	public List<AssetPositionBO> getChildNodeListByParent(AssetPositionBO entity) {

		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据物理位置得到子节点列表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetPositionDao.getChildNodeListByParent(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据物理位置得到子节点列表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
		
	}

	public PageResult getPageListByAssetPosition(AssetPositionBO entity,
			Page page) {
		
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询位置列表并分页");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			int count = getCounttByAssetPosition(entity);
			page = PageUtil.createPage(page, count);
			List list = assetPositionDao.getPageByAssetPosition(entity, page);
			return new PageResult(page, list);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询位置列表并分页");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public int getCounttByAssetPosition(AssetPositionBO entity) {
		return assetPositionDao.getCountByAssetPosition(entity);
	}

	public boolean getChildParentIdDWR(String nodeName, int parentId) {
		return assetPositionDao.getChildNodeByParentId(nodeName, parentId);
	}

	public boolean getChildPosIdDWR(String nodeName, int posId) {
		return assetPositionDao.getChildNodeByPositionId(nodeName, posId);
	}

	public List<AssetPositionBO> getChildNodes(Serializable rootId) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据位置根节点得到子节点");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetPositionDao.getChildNodes(rootId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据位置根节点得到子节点");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetPositionBO> getChildPosDWR(int posId) {
		
		

		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据父节点位置ID查询子节点集合");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			List<AssetPositionBO> posList = null;
			posList = assetPositionDao.getChildNodeByPosition(posId);
			return posList;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据父节点位置ID查询子节点集合");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetPositionBO> getChildParentDWR(int parentId) {
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据父节点位置ID查询子节点集合");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetPositionDao.getChildNodes(parentId); 
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据父节点位置ID查询子节点集合");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

}
