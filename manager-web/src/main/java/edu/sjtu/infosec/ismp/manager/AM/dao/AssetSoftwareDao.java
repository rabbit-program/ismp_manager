package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetSoftware的Dao接口
 * 
 * @author Breggor
 * 
 */
public interface AssetSoftwareDao
{
	/**
	 * 添加assetSoftware
	 * 
	 * @param assetSoftware
	 * 
	 */
	public void saveAssetSoftware(AssetSoftwareBO entity);

	/**
	 * 更新assetSoftware
	 * 
	 * @param assetSoftware
	 * 
	 */
	public void updateAssetSoftware(AssetSoftwareBO entity);

	/**
	 * 删除assetSoftware
	 * 
	 * @param assetSoftware
	 * 
	 */
	public void deleteAssetSoftware(AssetSoftwareBO entity);

	/**
	 * model模糊查询assetSoftware
	 * 
	 * @param assetSoftware
	 * 
	 */
	List<AssetSoftwareBO> getListByAssetSoftware(AssetSoftwareBO entity);

	/**
	 * ID查询assetSoftware
	 * 
	 * @param assetSoftware
	 * 
	 */
	AssetSoftwareBO getAssetSoftware(Serializable entityId);
	/**
	 * 统计AssetSoftwareBO总行数
	 * 
	 * @param assetSoftware
	 * 
	 */
	int getCountByAssetSoftware(AssetSoftwareBO entity);
	/**
	 * 分页查询
	 * @param entity
	 * @return List<AssetSoftwareBO>
	 */
	List<AssetSoftwareBO> getPageListByAssetSoftware(AssetSoftwareBO entity,Page page);
}
