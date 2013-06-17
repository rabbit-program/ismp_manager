package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetRawAvailabilityDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDailyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceVO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetRawAvailabilityBO;


/**
 * AssetRawAvailability的服务接口
 * 
 * @author zjiajie
 * 
 */
public interface AssetRawAvailabilityService {
	/**
	 * 设置 assetRawAvailabilityDao
	 * 
	 */
	public void setAssetRawAvailabilityDao(
			AssetRawAvailabilityDao assetRawAvailabilityDao);

	/**
	 * 保存 assetRawAvailability
	 * 
	 */
	public void saveAssetRawAvailability(AssetRawAvailabilityBO entity) throws Exception;

	/**
	 * 保存 assetRawAvailability列表
	 * 
	 */
	public void saveAssetRawAvailability(List<AssetRawAvailabilityBO> entities) throws Exception;

	/**
	 * 更新 assetRawAvailability
	 * 
	 */
	public void updateAssetRawAvailability(AssetRawAvailabilityBO entity) throws Exception;

	/**
	 * 删除 assetRawAvailability
	 * 
	 */
	public void deleteAssetRawAvailability(AssetRawAvailabilityBO entity)throws Exception;

	/**
	 * ID查询 assetRawAvailability
	 * 
	 */
	public AssetRawAvailabilityBO getAssetRawAvailability(Serializable entityId)throws Exception;

	/**
	 * model模糊查询assetRawAvailability
	 * 
	 */
	public List<AssetRawAvailabilityBO> getListByAssetRawAvailability (
			AssetRawAvailabilityBO entity)throws Exception;

	/**
	 * 获取某一设备在最近一小时内的平均可用性信息
	 * 
	 */
	public AssetDailyAvailabilityBO getAverageAssetRawAvailability(
			Integer assetId, Integer type, Timestamp currentDate)throws Exception;

	public List<Integer> getDayChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity)throws Exception;

	public List<Integer> getHourChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity)throws Exception;

	public List<Integer> getMonthChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity)throws Exception;

	public List<Integer> getHourChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity)throws Exception;

	public List<Integer> getDayChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity)throws Exception;

	public List<Integer> getMonthChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity)throws Exception;
	
	//根据委办局统计
	public Integer statisticsByLocId(Integer locId, Integer deviceType)throws Exception;
	
	public List<AssetDeviceVO> getListByAssetDeviceVO(List<AssetDeviceBO> deviceList)throws Exception;
	 
}
