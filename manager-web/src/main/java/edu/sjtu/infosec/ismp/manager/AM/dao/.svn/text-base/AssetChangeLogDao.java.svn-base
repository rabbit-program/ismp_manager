package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetChangeLogBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;



public interface AssetChangeLogDao {

	/**
	 * 保存资产变动信息
	 * 
	 * @param entity
	 */
	public void saveAssetChangeLog(AssetChangeLogBO entity);

	/**
	 * 更新资产变动信息
	 * 
	 * @param entity
	 */
	public void updateAssetChangeLog(AssetChangeLogBO entity);

	/**
	 * 删除资产变动信息
	 * 
	 * @param entity
	 */
	public void deleteAssetChangeLog(AssetChangeLogBO entity);

	/**
	 * 根据Id查询资产变动信息
	 * 
	 * @param entityId
	 * @return
	 */
	public AssetChangeLogBO getAssetChangeLog(Serializable entityId);

	/**
	 * 查询所有的资产变动信息
	 * 
	 * @param entity
	 * @return
	 */
	public List<AssetChangeLogBO> getListByAssetChangeLog(
			AssetChangeLogBO entity);
	/**
	 * 分页查询所有的资产变动信息
	 * 
	 * @param entity
	 * @return
	 */
	public List<AssetChangeLogBO> getPageListByAssetChangeLog(
			AssetChangeLogBO entity, Page page);

}