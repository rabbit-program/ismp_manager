package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetPositionDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;


/**
 * AssetPosition的service接口
 * 
 * @author breggor
 * 
 */
public interface AssetPositionService {
	/**
	 * 设置 assetPositionDao
	 * 
	 */
	public void setAssetPositionDao(AssetPositionDao assetPositionDao);

	/**
	 * 保存 assetPosition
	 * 
	 */
	public void saveAssetPosition(AssetPositionBO entity);

	/**
	 * 更新 assetPosition
	 * 
	 */
	public void updateAssetPosition(AssetPositionBO entity);

	/**
	 * 删除assetPosition
	 * 
	 */
	public void deleteAssetPosition(AssetPositionBO entity);

	/**
	 * ID查询 assetPosition
	 * 
	 */
	public AssetPositionBO getAssetPosition(Serializable entityId);

	/**
	 * model模糊查询 assetPosition
	 * 
	 */
	public List<AssetPositionBO> getListByAssetPosition(AssetPositionBO entity);

	/**
	 * 分页查询 assetPosition
	 * 
	 */
	public PageResult getPageListByAssetPosition(AssetPositionBO entity,
			Page page);

	/**
	 * 统计行数 assetPosition
	 * 
	 */
	public int getCounttByAssetPosition(AssetPositionBO entity);

	/**
	 * 根据父节点ID查询父节点集合
	 * 
	 * @param rootId
	 * @return List<AssetPositionBO>
	 */

	List<AssetPositionBO> getChildNodeListByParent(Serializable rootId);

	/**
	 * model模糊查询父节点集合
	 * 
	 * @param rootId
	 * @return List<AssetPositionBO>
	 */

	List<AssetPositionBO> getChildNodeListByParent(AssetPositionBO entity);

	/**
	 * 根据父节点ID查询子节点集合
	 * 
	 * @param rootId
	 * @return Map<Integer, List<AssetPositionBO>>
	 */

	public List<AssetPositionBO> getChildNodeByPosition(Serializable positionId);

	
	List<AssetPositionBO> getChildNodes(Serializable rootId); 

    public boolean getChildPosIdDWR(String nodeName, int posId);
	
	public boolean getChildParentIdDWR(String nodeName, int parentId);
	
	List<AssetPositionBO> getChildPosDWR(int posId);
	
	List<AssetPositionBO> getChildParentDWR(int parentId);

}
