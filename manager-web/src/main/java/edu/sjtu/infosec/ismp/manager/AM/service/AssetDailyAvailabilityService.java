package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetDailyAvailabilityDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDailyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetMonthlyAvailabilityBO;


/**
 * AssetDailyAvailability的服务接口
 * 
 * @author zjiajie
 * 
 */
public interface AssetDailyAvailabilityService {
	/**
	 * 设置 assetDailyAvailabilityDao
	 * 
	 */
	public void setAssetDailyAvailabilityDao(
			AssetDailyAvailabilityDao assetDailyAvailabilityDao);

	/**
	 * 保存 assetDailyAvailability
	 * 
	 */
	public void saveAssetDailyAvailability(AssetDailyAvailabilityBO entity);

	/**
	 * 更新 assetDailyAvailability
	 * 
	 */
	public void updateAssetDailyAvailability(AssetDailyAvailabilityBO entity);

	/**
	 * 删除 assetDailyAvailability
	 * 
	 */
	public void deleteAssetDailyAvailability(AssetDailyAvailabilityBO entity);

	/**
	 * ID查询 assetDailyAvailability
	 * 
	 */
	public AssetDailyAvailabilityBO getAssetDailyAvailability(
			Serializable entityId);

	/**
	 * model模糊查询 assetDailyAvailability
	 * 
	 */
	public List<AssetDailyAvailabilityBO> getListByAssetDailyAvailability(
			AssetDailyAvailabilityBO entity);

	/**
	 * 获取某一设备在最近一天内的平均可用性信息，用于存放在monthly表中
	 * 
	 * @param assetId
	 *            资产id
	 * @param type
	 *            统计类型
	 * @param currentDate
	 *            统计时间
	 * @return
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
