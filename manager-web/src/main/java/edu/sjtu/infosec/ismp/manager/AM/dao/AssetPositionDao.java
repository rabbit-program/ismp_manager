package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetPosition的Dao接口
 * 
 * @author Breggor
 * 
 */
public interface AssetPositionDao {
	/**
	 * 添加assetPosition
	 * 
	 * @param assetPosition
	 * 
	 */
	public void saveAssetPosition(AssetPositionBO entity);

	/**
	 * 更新assetPosition
	 * 
	 * @param assetPosition
	 * 
	 */
	public void updateAssetPosition(AssetPositionBO entity);

	/**
	 * 删除assetPosition
	 * 
	 * @param assetPosition
	 * 
	 */
	public void deleteAssetPosition(AssetPositionBO entity);

	/**
	 * model模糊查询assetPosition
	 * 
	 * @param assetPosition
	 * 
	 */
	List<AssetPositionBO> getListByAssetPosition(AssetPositionBO entity);

	/**
	 * ID查询assetPosition
	 * 
	 * @param assetPosition
	 * 
	 */
	AssetPositionBO getAssetPosition(Serializable entityId); 
	/**
	 * 分页查询assetPosition
	 * 
	 * @param assetPosition
	 * 
	 */
	List<AssetPositionBO> getPageByAssetPosition(AssetPositionBO entity,
			Page page);

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
	 * 统计AssetPositionBO行数
	 * 
	 * @param rootId
	 * @return List<AssetPositionBO>
	 */

	int getCountByAssetPosition(AssetPositionBO entity);

	/**
	 * 根据父节点ID查询子节点集合
	 * 
	 * @param rootId
	 * @return Map<Integer, List<AssetPositionBO>>
	 */

	List<AssetPositionBO> getChildNodeByPosition(Serializable positionId);

	List<AssetPositionBO> getChildNodes(Serializable rootId);

	public boolean getChildNodeByPositionId(String nodeName, int posId);

	public boolean getChildNodeByParentId(String nodeName, int parentId);
	/**
	 * 根据节点ID查询父节点信息
	 * 
	 * 
	 */
	AssetPositionBO getParentNodeListByChild(Serializable entityId);
	
	/**
	 * 根据节点ID查询节点信息
	 * 
	 * 
	 */
	AssetPositionBO getNodeListById(Serializable entityId);
}
