package edu.sjtu.infosec.ismp.manager.AM.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDailyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetRawAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetRawAvailability的Dao接口
 * 
 * @author Breggor
 * 
 */
public interface AssetRawAvailabilityDao {
	/**
	 * 添加assetRawAvailability
	 * 
	 * @param assetRawAvailability
	 * 
	 */
	public void saveAssetRawAvailability(AssetRawAvailabilityBO entity);

	/**
	 * 添加assetRawAvailability列表
	 * 
	 * @param assetRawAvailability
	 * 
	 */
	public void saveAssetRawAvailability(List<AssetRawAvailabilityBO> entities);

	/**
	 * 更新assetRawAvailability
	 * 
	 * @param assetRawAvailability
	 * 
	 */
	public void updateAssetRawAvailability(AssetRawAvailabilityBO entity);

	/**
	 * 删除assetRawAvailability
	 * 
	 * @param assetRawAvailability
	 * 
	 */
	public void deleteAssetRawAvailability(AssetRawAvailabilityBO entity);

	/**
	 * model模糊查询assetRawAvailability
	 * 
	 * @param assetRawAvailability
	 * 
	 */
	List<AssetRawAvailabilityBO> getListByAssetRawAvailability(
			AssetRawAvailabilityBO entity);

	public List<AssetRawAvailabilityBO> getPageListByAssetRawAvailability(
			Page page, AssetRawAvailabilityBO entity);

	/**
	 * ID查询assetRawAvailability
	 * 
	 * @param assetRawAvailability
	 * 
	 */
	AssetRawAvailabilityBO getAssetRawAvailability(Serializable entityId);

	/**
	 * 获取某一设备在最近一小时内的平均可用性信息
	 * 
	 */
	public AssetDailyAvailabilityBO getAverageAssetRawAvailability(
			Integer assetId, Integer type, Timestamp currentDate);

	public List<Integer> getDayChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity);

	public List<Integer> getHourChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity);

	public List<Integer> getMonthChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity);

	public List<Integer> getHourChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity);

	public List<Integer> getDayChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity);

	public List<Integer> getMonthChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity);
	
	//根据委办局统计
	public Integer statisticsByLocId(Integer locId, Integer deviceType);
	
	public Integer getAverAssetRawAval(
			Integer assetId, Integer type, Timestamp currentDate);

}
