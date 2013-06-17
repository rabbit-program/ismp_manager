package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetHardware的Dao接口
 * 
 * @author Breggor
 * 
 */
public interface AssetHardwareDao
{
	/**
	 * 添加assetHardware
	 * 
	 * @param assetHardware
	 * 
	 */
	public void saveAssetHardware(AssetHardwareBO entity);

	/**
	 * 更新assetHardware
	 * 
	 * @param assetHardware
	 * 
	 */
	public void updateAssetHardware(AssetHardwareBO entity);

	/**
	 * 删除assetHardware
	 * 
	 * @param assetHardware
	 * 
	 */
	public void deleteAssetHardware(AssetHardwareBO entity);

	/**
	 * model模糊查询assetHardware
	 * 
	 * @param assetHardware
	 * 
	 */
	List<AssetHardwareBO> getListByAssetHardware(AssetHardwareBO entity);

	/**
	 * ID查询assetHardware
	 * 
	 * @param assetHardware
	 * 
	 */
	AssetHardwareBO getAssetHardware(Serializable entityId);
	/**
	 *统计assetHardware总行数
	 * 
	 * @param assetHardware
	 * 
	 */
	int getCountByAssetHardware(AssetHardwareBO entity);
	/**
	 * 分页查询assetHardware 
	 * 
	 * @param assetHardware
	 * 
	 */
	List<AssetHardwareBO> getPageListByAssetHardware(AssetHardwareBO entity,Page page);
}
