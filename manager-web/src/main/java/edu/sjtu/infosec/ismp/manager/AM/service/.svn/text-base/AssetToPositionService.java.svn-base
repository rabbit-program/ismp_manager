package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToPositionDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToPositionBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * AssetToPosition的service接口
 * @author breggor
 *
 */
public interface AssetToPositionService
{
	/**
	 * 设置 assetToPositionDao
	 * 
	 */
	public void setAssetToPositionDao(AssetToPositionDao assetToPositionDao);

	/**
	 * 保存 assetToPosition
	 * 
	 */
	public void saveAssetToPosition(AssetToPositionBO entity);
	/**
	 * 更新 assetToPosition
	 * 
	 */
	public void updateAssetToPosition(AssetToPositionBO entity);
	/**
	 * 删除 assetToPosition
	 * 
	 */
	public void deleteAssetToPosition(AssetToPositionBO entity);
	/**
	 * ID查询 assetToPosition
	 * 
	 */
	public AssetToPositionBO getAssetToPosition(Serializable entityId);
	/**
	 * model模糊查询 assetToPosition
	 * 
	 */
	public List<AssetToPositionBO> getListByAssetToPosition(AssetToPositionBO entity);
	/**
	 * AssetDeviceBO ID查询关联的AssetPositionBO
	 * 
	 * @param AssetPositionBO
	 * 
	 */
	List<AssetPositionBO> getListByPosition(Serializable deviceId);
	/**
	 * AssetPositionBO ID查询关联的AssetDeviceBO
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
	PageResult getPageListByAssetDevice(Serializable positionId, Page page);
	
	/**
	 * AssetPositionBO ID 统计行数
	 * @param positionId
	 * @return
	 */
	 public int getCountByAssetDevice(Serializable positionId);
	/**
	 * AssetDeviceBO ID查询没有关联的AssetPositionBO
	 * 
	 * @param AssetPositionBO
	 * 
	 */
	List<AssetPositionBO> getListNotJoinPosition(Serializable deviceId);
	/**
	 * AssetPositionBO ID查询没有关联的AssetDeviceBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable positionId);
	/**
	 * 查询没有关联的AssetDeviceBO
	 * 
	 * @param AssetDeviceBO
	 * 
	 */
	List<AssetDeviceBO> getListNotJoinAssetDevice();
 
}
