package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToSoftwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetToSoftware的Dao接口
 * 
 * @author Breggor
 * 
 */
public interface AssetToSoftwareDao
{
	/**
	 * 添加assetToSoftware
	 * 
	 * @param assetToSoftware
	 * 
	 */
	public void saveAssetToSoftware(AssetToSoftwareBO entity);
	/**
	 * 更新assetToSoftware
	 * 
	 * @param assetToSoftware
	 * 
	 */
	public void updateAssetToSoftware(AssetToSoftwareBO entity);

	/**
	 * 删除assetToSoftware
	 * 
	 * @param assetToSoftware
	 * 
	 */
	public void deleteAssetToSoftware(AssetToSoftwareBO entity);

	/**
	 * model模糊查询assetToSoftware
	 * 
	 * @param assetToSoftware
	 * 
	 */
	List<AssetToSoftwareBO> getListByAssetToSoftware(AssetToSoftwareBO entity);
	/**
	 * ID查询assetToSoftware
	 * 
	 * @param assetToSoftware
	 * 
	 */
	AssetToSoftwareBO getAssetToSoftware(Serializable entityId);
	/**
	 * software ID查询AssetDeviceBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getListByAssetDevice(Serializable softwareId);
	/**
	 * software ID查询没有关联的AssetDeviceBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable softwareId);
	/**
	 * Device ID查询AssetSoftwareBO
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	List<AssetSoftwareBO> getListByAssetSoftware(Serializable deviceId);
	/**
	 * Device ID统计AssetSoftwareBO行数
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	int getCountByAssetSoftware(Serializable deviceId);
	/**
	 * Device ID分页查询AssetSoftwareBO
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	List<AssetSoftwareBO> getPageListByAssetSoftware(Serializable deviceId, Page page);
	/**
	 * Device ID查询没有关联的AssetSoftwareBO
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	List<AssetSoftwareBO> getListNotJoinAssetSoftware(Serializable deviceId);
}
