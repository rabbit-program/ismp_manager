package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToSoftwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToSoftwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * AssetToSoftware的service接口
 * @author breggor
 *
 */
public interface AssetToSoftwareService
{
	/**
	 * 设置 assetToSoftwareDao
	 * 
	 */
	public void setAssetToSoftwareDao(AssetToSoftwareDao assetToSoftwareDao);

	/**
	 * 保存 assetToSoftware
	 * 
	 */
	public void saveAssetToSoftware(AssetToSoftwareBO entity);
	/**
	 * 更新 assetToSoftware
	 * 
	 */
	public void updateAssetToSoftware(AssetToSoftwareBO entity);
	/**
	 * 删除 assetToSoftware
	 * 
	 */
	public void deleteAssetToSoftware(AssetToSoftwareBO entity);
	/**
	 * ID查询 assetToSoftware
	 * 
	 */
	public AssetToSoftwareBO getAssetToSoftware(Serializable entityId);
	/**
	 * model模糊查询 assetToSoftware
	 * 
	 */
	public List<AssetToSoftwareBO> getListByAssetToSoftware(AssetToSoftwareBO entity);
	/**
	 * software ID查询AssetDeviceBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getListByAssetDevice(Serializable softwareId);
	/**
	 * Device ID查询AssetSoftwareBO
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	List<AssetSoftwareBO> getListByAssetSoftware(Serializable deviceId);
	/**
	 * Device ID分页查询AssetSoftwareBO
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	PageResult getPageListByAssetSoftware(Serializable deviceId,Page page);
	/**
	 * Device ID统计AssetSoftwareBO行数
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	int getCountByAssetSoftware(Serializable deviceId);
	/**
	 * software ID查询没有关联的AssetDeviceBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable softwareId);
	/**
	 * Device ID查询没有关联的AssetSoftwareBO
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	List<AssetSoftwareBO> getListNotJoinAssetSoftware(Serializable deviceId);
}
