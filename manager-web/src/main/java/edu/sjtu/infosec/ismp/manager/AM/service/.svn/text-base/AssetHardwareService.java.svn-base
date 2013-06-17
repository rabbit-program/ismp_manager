package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetHardwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 *  AssetHardware的service接口
 * @author breggor
 *
 */
public interface AssetHardwareService
{
	/**
	 * 设置assetDeviceDao
	 */
	public void setAssetHardwareDao(AssetHardwareDao assetHardwareDao);

	/**
	 *保存 assetHardware
	 * 
	 */
	public void saveAssetHardware(AssetHardwareBO entity);

	/**
	 *更新 assetHardware
	 * 
	 */
	public void updateAssetHardware(AssetHardwareBO entity);

	/**
	 *删除 assetHardware
	 * 
	 */
	public void deleteAssetHardware(AssetHardwareBO entity);

	/**
	 *ID查询 assetHardware
	 * 
	 */
	public AssetHardwareBO getAssetHardware(Serializable entityId);

	/**
	 *model模糊查询 assetHardware
	 * 
	 */
	public List<AssetHardwareBO> getListByAssetHardware(AssetHardwareBO entity);
	/**
	 *统计assetHardware总行数
	 * 
	 */
	public int getCountByAssetHardware(AssetHardwareBO entity);
	/**
	 *统计assetHardware总行数
	 * 
	 */
	public PageResult getPageListByAssetHardware(AssetHardwareBO entity, Page page);
}
