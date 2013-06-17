package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDailyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetMonthlyAvailabilityBO;


/**
 * AssetDailyAvailability的Dao接口
 * 
 * @author Breggor
 * 
 */
public interface AssetDailyAvailabilityDao {
	/**
	 * 添加assetDailyAvailability
	 * 
	 * @param assetDailyAvailability
	 * 
	 */
	public void saveAssetDailyAvailability(AssetDailyAvailabilityBO entity);

	/**
	 * 更新assetDailyAvailability
	 * 
	 * @param assetDailyAvailability
	 * 
	 */
	public void updateAssetDailyAvailability(AssetDailyAvailabilityBO entity);

	/**
	 * 删除assetDailyAvailability
	 * 
	 * @param assetDailyAvailability
	 * 
	 */
	public void deleteAssetDailyAvailability(AssetDailyAvailabilityBO entity);

	/**
	 * model模糊查询assetDailyAvailability
	 * 
	 * @param assetDailyAvailability
	 * 
	 */
	List<AssetDailyAvailabilityBO> getListByAssetDailyAvailability(
			AssetDailyAvailabilityBO entity);

	/**
	 * ID查询assetDailyAvailability
	 * 
	 * @param assetDailyAvailability
	 * 
	 */
	AssetDailyAvailabilityBO getAssetDailyAvailability(Serializable entityId);

	/**
	 * 获取某一设备在最近一天内的平均可用性信息
	 * 
	 */
	public AssetMonthlyAvailabilityBO getAverageAssetMonthlyAvailability(
			Integer assetId, Integer type, Timestamp currentDate);

	/**
	 * 获取某天的使用率，以list形势输出
	 * 
	 */
	public List<Integer> getDayChartData(Timestamp date,
			AssetDailyAvailabilityBO entity);

}
