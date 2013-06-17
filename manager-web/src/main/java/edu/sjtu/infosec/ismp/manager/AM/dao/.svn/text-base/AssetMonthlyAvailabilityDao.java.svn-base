package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetMonthlyAvailabilityBO;


/**
 * AssetMonthlyAvailability的Dao接口
 * 
 * @author Breggor
 * 
 */
public interface AssetMonthlyAvailabilityDao {
	/**
	 * 添加assetMonthlyAvailability
	 * 
	 * @param assetMonthlyAvailability
	 * 
	 */
	public void saveAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity);

	/**
	 * 更新assetMonthlyAvailability
	 * 
	 * @param assetMonthlyAvailability
	 * 
	 */
	public void updateAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity);

	/**
	 * 删除assetMonthlyAvailability
	 * 
	 * @param assetMonthlyAvailability
	 * 
	 */
	public void deleteAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity);

	/**
	 * 查询assetMonthlyAvailability
	 * 
	 * @param assetMonthlyAvailability
	 * 
	 */
	List<AssetMonthlyAvailabilityBO> getListByAssetMonthlyAvailability(
			AssetMonthlyAvailabilityBO entity);

	/**
	 * ID查询assetMonthlyAvailability
	 * 
	 * @param assetMonthlyAvailability
	 * 
	 */
	AssetMonthlyAvailabilityBO getAssetMonthlyAvailability(Serializable entityId);

	/**
	 * 获取某月的使用率，以list形势输出
	 * 
	 */
	public List<Integer> getMonthChartData(Timestamp date, AssetMonthlyAvailabilityBO entity);
	
	public List<Integer> getYearChartData(Timestamp date, AssetMonthlyAvailabilityBO entity);
	
	 
}
