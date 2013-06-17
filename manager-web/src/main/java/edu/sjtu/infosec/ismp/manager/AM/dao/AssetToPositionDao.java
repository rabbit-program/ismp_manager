package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToPositionBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetToPosition的Dao接口
 * 
 * @author Breggor
 * 
 * 
 */
public interface AssetToPositionDao
{
	/**
	 * 添加assetToPosition
	 * 
	 * @param assetToPosition
	 * 
	 */
	public void saveAssetToPosition(AssetToPositionBO entity);
	/**
	 * 更新assetToPosition
	 * 
	 * @param assetToPosition
	 * 
	 */
	public void updateAssetToPosition(AssetToPositionBO entity);

	/**
	 * 删除assetToPosition
	 * 
	 * @param assetToPosition
	 * 
	 */
	public void deleteAssetToPosition(AssetToPositionBO entity);

	/**
	 * model模糊查询assetToPosition
	 * 
	 * @param assetToPosition
	 * 
	 */
	List<AssetToPositionBO> getListByAssetToPosition(AssetToPositionBO entity);
	/**
	 * ID查询assetToPosition
	 * 
	 * @param assetToPosition
	 * 
	 */
	AssetToPositionBO getAssetToPosition(Serializable entityId);
	
	
	List<AssetToPositionBO> getPositionIdByDeviceId(Serializable deviceId);
	/**
	 * AssetPositionBO ID查询AssetDeviceBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getListByAssetDevice(Serializable positionId);
	/**
	 * AssetPositionBO ID分页查询
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getPageListByAssetDevice(Serializable positionId,Page page);
	/**
	 * 统计AssetDeviceBO行数 
	 * @param AssetDeviceBO
	 * 
	 */
	 public int getCountByAssetDevice(Serializable positionId);
	/**
	 * AssetPositionBO ID查询没有关联的AssetDeviceBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable positionId);
	/**
	 * AssetDeviceBO ID查询AssetPositionBO
	 * 
	 * @param AssetPositionBO
	 * 
	 */
	List<AssetPositionBO> getListByPosition(Serializable deviceId);
	/**
	 * AssetDeviceBO ID查询没有关联的AssetPositionBO
	 * 
	 * @param AssetPositionBO
	 * 
	 */
	List<AssetPositionBO> getListNotJoinPosition(Serializable deviceId);
	/**
	 * 查询没有关联的AssetDeviceBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getListNotJoinAssetDevice();
}
