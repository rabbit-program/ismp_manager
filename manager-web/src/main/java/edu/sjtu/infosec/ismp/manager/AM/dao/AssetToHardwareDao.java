package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToHardwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetToHardware的Dao接口
 * 
 * @author Breggor
 * 
 */
public interface AssetToHardwareDao {
	/**
	 * 添加assetToHardware
	 * 
	 * @param assetToHardware
	 * 
	 */
	public void saveAssetToHardware(AssetToHardwareBO entity);

	/**
	 * 更新assetToHardware
	 * 
	 * @param assetToHardware
	 * 
	 */
	public void updateAssetToHardware(AssetToHardwareBO entity);

	/**
	 * 删除assetToHardware
	 * 
	 * @param assetToHardware
	 * 
	 */
	public void deleteAssetToHardware(AssetToHardwareBO entity);

	/**
	 * model模糊查询assetToHardware
	 * 
	 * @param assetToHardware
	 * 
	 */
	List<AssetToHardwareBO> getListByAssetToHardware(AssetToHardwareBO entity);

	/**
	 * ID查询assetToHardware
	 * 
	 * @param assetToHardware
	 * 
	 */
	AssetToHardwareBO getAssetToHardware(Serializable entityId);

	/**
	 * AssetDeviceBO的ID查询AssetHardwareBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetHardwareBO> getListByHardware(Serializable assetId);

	/**
	 * AssetDeviceBO的ID查询AssetHardwareBO行数
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	int getCountByHardware(Serializable deviceId);

	/**
	 * AssetDeviceBO的ID分页查询AssetHardwareBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetHardwareBO> getPageListByHardware(Serializable deviceId, Page page);

	/**
	 * AssetDeviceBO的ID查询没有关联AssetHardwareBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetHardwareBO> getListNotJoinHardware(Serializable assetId);

	/**
	 * Device ID查询AssetSoftwareBO
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	List<AssetDeviceBO> getListByAssetDevice(Serializable hardwareId);

	/**
	 * AssetDevice ID查询没有关联的AssetSoftwareBO
	 * 
	 * @param AssetSoftwareBO
	 * 
	 */
	List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable hardwareId);
}
