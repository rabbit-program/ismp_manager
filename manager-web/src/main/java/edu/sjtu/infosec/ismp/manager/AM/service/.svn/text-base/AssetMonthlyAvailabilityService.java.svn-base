package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetMonthlyAvailabilityDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetMonthlyAvailabilityBO;


/**
 * AssetMonthlyAvailability的service接口
 * 
 * @author breggor
 * 
 */
public interface AssetMonthlyAvailabilityService {
	/**
	 * 设置 assetMonthlyAvailabilityDao
	 * 
	 */
	public void setAssetMonthlyAvailabilityDao(
			AssetMonthlyAvailabilityDao assetMonthlyAvailabilityDao);

	/**
	 * 保存 assetMonthlyAvailability
	 * 
	 */
	public void saveAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity);

	/**
	 * 更新 assetMonthlyAvailability
	 * 
	 */
	public void updateAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity);

	/**
	 * 删除 assetMonthlyAvailability
	 * 
	 */
	public void deleteAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity);

	/**
	 * ID查询 assetMonthlyAvailability
	 * 
	 */
	public AssetMonthlyAvailabilityBO getAssetMonthlyAvailability(
			Serializable entityId);

	/**
	 * model模糊查询 assetMonthlyAvailability
	 * 
	 */
	public List<AssetMonthlyAvailabilityBO> getListByAssetMonthlyAvailability(
			AssetMonthlyAvailabilityBO entity);

	/**
	 * 获取某月的使用率，以list形势输出
	 * 
	 */
	public List<Integer> getMonthChartData(Timestamp date,
			AssetMonthlyAvailabilityBO entity);

	public List<Integer> getYearChartData(Timestamp date,
			AssetMonthlyAvailabilityBO entity);
}
