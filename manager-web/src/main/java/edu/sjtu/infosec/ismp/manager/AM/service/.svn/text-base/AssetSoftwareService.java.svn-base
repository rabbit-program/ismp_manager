package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetSoftwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * AssetSoftware的service接口
 * @author breggor
 *
 */
public interface AssetSoftwareService
{
	/**
	 * 设置 assetSoftwareDao
	 * 
	 */
	public void setAssetSoftwareDao(AssetSoftwareDao assetSoftwareDao);

	/**
	 *保存assetSoftware
	 * 
	 */
	public void saveAssetSoftware(AssetSoftwareBO entity);

	/**
	 *更新assetSoftware
	 * 
	 */
	public void updateAssetSoftware(AssetSoftwareBO entity);

	/**
	 *删除assetSoftware
	 * 
	 */
	public void deleteAssetSoftware(AssetSoftwareBO entity);

	/**
	 *ID查询assetSoftware
	 * 
	 */
	public AssetSoftwareBO getAssetSoftware(Serializable entityId);

	/**
	 *model模糊查询assetSoftware
	 * 
	 */
	public List<AssetSoftwareBO> getListByAssetSoftware(AssetSoftwareBO entity);
	/**
	 * 统计总行数
	 * 
	 */
	public int getCountByAssetSoftware(AssetSoftwareBO entity);
	
	/***
	 * 分页查询
	 * @param entity
	 * @param page
	 * @return
	 */
	public PageResult getPageListByAssetSoftware(AssetSoftwareBO entity, Page page);
}
