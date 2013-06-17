package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToHardwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToHardwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * AssetToHardware的service接口
 * @author breggor
 *
 */
public interface AssetToHardwareService
{
	/**
	 * 设置 assetToHardwareDao
	 * 
	 */
	public void setAssetToHardwareDao(AssetToHardwareDao assetToHardwareDao);

	/**
	 * 保存 assetToHardware
	 * 
	 */
	public void saveAssetToHardware(AssetToHardwareBO entity);
	
	/**
	 * 更新 assetToHardware
	 * 
	 */
	public void updateAssetToHardware(AssetToHardwareBO entity);
	
	/**
	 * 删除 assetToHardware
	 * 
	 */
	public void deleteAssetToHardware(AssetToHardwareBO entity);
	
	/**
	 * ID查询 assetToHardware
	 * 
	 */
	public AssetToHardwareBO getAssetToHardware(Serializable entityId);
	
	/**
	 * model模糊查询 assetToHardware
	 * 
	 */
	public List<AssetToHardwareBO> getListByAssetToHardware(AssetToHardwareBO entity);
	/**
	 * AssetDeviceBO的ID查询没有关联AssetHardwareBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetHardwareBO> getListNotJoinHardware(Serializable assetId);
	/**
	 * AssetDeviceBO的ID查询已关联AssetHardwareBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetHardwareBO> getListByHardware(Serializable assetId);
	/**
	 * AssetDeviceBO的ID分页查询已关联AssetHardwareBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	PageResult getPageListByHardware(Serializable deviceId, Page page);
	/**
	 * AssetDeviceBO的ID查询已关联AssetHardwareBO行数
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	int getCounttByHardware(Serializable deviceId);
	/**
	 * AssetDevice ID查询没有关联的AssetSoftwareBO
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable hardwareId);
	
	/**
	 * AssetHardwareBO ID查询已关联的AssetDeviceBO
	 * @param hardwareId
	 * @return
	 */
	List<AssetDeviceBO> getListByAssetDevice(Serializable hardwareId);
}
