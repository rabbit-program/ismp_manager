package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AM.comm.AssetConstant;
import edu.sjtu.infosec.ismp.manager.AM.dao.AssetPositionDao;
import edu.sjtu.infosec.ismp.manager.AM.dao.AssetRawAvailabilityDao;
import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToPositionDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDailyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceVO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetRawAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetRawAvailabilityService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.DomainDao;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

 
/**
 * AssetRawAvailability的service实现类
 * 
 * @author breggor
 * 
 */
public class AssetRawAvailabilityServiceImpl implements
		AssetRawAvailabilityService {
	private AssetRawAvailabilityDao assetRawAvailabilityDao;
	private DomainDao domainDao;
	private AssetToPositionDao assetToPositionDao;
	private AssetPositionDao assetPositionDao;
	private SystemLogService systemlogService;
	
	SystemLog log;
	String rolenames;
	String username;
	void init(){
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		username = user.getUsername();
		rolenames="";
		for(Role role : user.getRoleList()){
			rolenames = rolenames+role.getName();
		}
		log = new SystemLog();
	}
	
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}
	/**
	 * 实现接口方法
	 */
	
	public void setAssetPositionDao(AssetPositionDao assetPositionDao){
		this.assetPositionDao = assetPositionDao;
	}
	public void setAssetToPositionDao(AssetToPositionDao assetToPositionDao) {
		this.assetToPositionDao = assetToPositionDao;
	}
	
	
	public void setDomainDao(DomainDao domainDao){
		this.domainDao = domainDao;
	}
	public void setAssetRawAvailabilityDao(
			AssetRawAvailabilityDao vAssetRawAvailabilityDao) {
		assetRawAvailabilityDao = vAssetRawAvailabilityDao;
	}

	public void saveAssetRawAvailability(AssetRawAvailabilityBO entity) throws Exception{
		
		try{
			init();
			assetRawAvailabilityDao.saveAssetRawAvailability(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产可用情况操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产可用情况操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void deleteAssetRawAvailability(AssetRawAvailabilityBO entity) throws Exception{
		
		try{
			init();
			assetRawAvailabilityDao.deleteAssetRawAvailability(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产可用情况操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产可用情况操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public void updateAssetRawAvailability(AssetRawAvailabilityBO entity) throws Exception{
		
		try{
			init();
			assetRawAvailabilityDao.updateAssetRawAvailability(entity);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产可用情况操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("修改资产可用情况操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}
	}

	public AssetRawAvailabilityBO getAssetRawAvailability(Serializable entityId) throws Exception{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产可用情况操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.getAssetRawAvailability(entityId);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID得到资产可用情况操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetRawAvailabilityBO> getListByAssetRawAvailability(
			AssetRawAvailabilityBO entity) throws Exception{
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据条件查询资产可用性操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.getListByAssetRawAvailability(entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据条件查询资产可用性操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
		
	}

	public AssetDailyAvailabilityBO getAverageAssetRawAvailability(
			Integer assetId, Integer type, Timestamp currentDate) throws Exception{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取某一设备在最近一小时内的平均可用性信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.getAverageAssetRawAvailability(assetId,
					type, currentDate);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取某一设备在最近一小时内的平均可用性信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public void saveAssetRawAvailability(List<AssetRawAvailabilityBO> entities) throws Exception{
		
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加assetRawAvailability列表");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			assetRawAvailabilityDao.saveAssetRawAvailability(entities);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加assetRawAvailability列表");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
		}

	}

	public List<Integer> getDayChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity) throws Exception{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取网络设备在最近一天内的平均可用性信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.getDayChartDataByNet(date, entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取网络设备在最近一天内的平均可用性信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}

	}

	public List<Integer> getHourChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity) throws Exception{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取网络设备在最近一小时内的平均可用性信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.getHourChartDataByNet(date, entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取网络设备在最近一小时内的平均可用性信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<Integer> getMonthChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity) throws Exception{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取网络设备在最近一月内的平均可用性信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.getMonthChartDataByNet(date, entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取网络设备在最近一月内的平均可用性信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<Integer> getHourChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity) throws Exception{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取在最近一小时内的在线情况信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.getHourChartDataByOnline(date, entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取在最近一小时内的在线情况信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<Integer> getMonthChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity) throws Exception{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取在最近一月内的在线情况信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.getMonthChartDataByOnline(date, entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取在最近一月内的在线情况信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<Integer> getDayChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity) throws Exception{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取在最近一天内的在线情况信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.getDayChartDataByOnline(date, entity);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("获取在最近一天内的在线情况信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public Integer statisticsByLocId(Integer locId, Integer deviceType) throws Exception{
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据域、设备类型统计可用性信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetRawAvailabilityDao.statisticsByLocId(locId, deviceType);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据域、设备类型统计可用性信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	public List<AssetDeviceVO> getListByAssetDeviceVO(List<AssetDeviceBO> deviceList) throws Exception{
		
		
		try{
			init();
			
			AssetDeviceVO deviceVO = null;
			List<AssetDeviceVO> voList = new ArrayList<AssetDeviceVO>();
			if((deviceList != null) &&(!deviceList.isEmpty()))
			{ 
				
				for(AssetDeviceBO dev : deviceList)
				{ 
					deviceVO = new AssetDeviceVO();
					deviceVO.setName(dev.getName());
					deviceVO.setManufacturer(dev.getManufacturer());
					deviceVO.setModel(dev.getModel());
					deviceVO.setRegistrationTime(dev.getRegistrationTime()); 
					
					deviceVO.setValidityPeriod(dev.getValidityPeriod());
					
					//存储利用率
					deviceVO.setAvailHardware(this.getUsedPercent(dev.getId(), AssetConstant.AVAILABILITY_HD)); 
					
					//网络利用率
					deviceVO.setAvailNetwork(this.getUsedPercent(dev.getId(), AssetConstant.AVAILABILITY_Net));
					
					//性能利用率
					deviceVO.setCapability(this.getCapability(dev.getId())); 
					deviceVO.setLocation(getLocation(dev.getLocationId(), dev.getId()));
					voList.add(deviceVO);				
				}
			}
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据域、设备类型统计可用性信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return voList;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据域、设备类型统计可用性信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	private Integer getUsedPercent(Integer assetId, Integer assetType) {
		

		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("统计使用百分比");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			Integer percent = 0;
			if ((assetId != null) && (assetType != null)) {
				percent =  assetRawAvailabilityDao
						.getAverAssetRawAval(assetId, assetType,
								new Timestamp(new Date().getTime()));
				
			}
			return percent;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("统计使用百分比");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	private Integer getCapability(Integer assetId) {
		
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("统计能用百分比");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			Integer percent = 0;
			if (assetId != null) {
				int cpu = assetRawAvailabilityDao
				.getAverAssetRawAval(assetId, AssetConstant.AVAILABILITY_CPU,
						new Timestamp(new Date().getTime())); 
				int mem = assetRawAvailabilityDao.getAverAssetRawAval(assetId, AssetConstant.AVAILABILITY_MEM,
						new Timestamp(new Date().getTime()));
				percent = (int)Math.sqrt(cpu * mem);
			}
			return percent;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("统计能用百分比");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	private String getLocation(Integer locId, Integer deviceId) throws Exception
	{
		
		
		
		

		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据某一域、某一设备类型得到物理位置信息 ");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			Integer percent = 0;
			StringBuffer buffer = new StringBuffer();
			Domain domain = null;
			if(locId != null){
				domain = domainDao.findById(locId);
				buffer.append(domain.getDomainName());
			}
			if(deviceId != null)
			{
				List<AssetToPositionBO> assToPos = assetToPositionDao.getPositionIdByDeviceId(deviceId);
	 			if(assToPos != null)
				{
					for(int i = 0; i < assToPos.size(); i++)
					{
						AssetToPositionBO topos = assToPos.get(i);
						AssetPositionBO assetPositionBO = assetPositionDao.getParentNodeListByChild(topos.getPositionId());
						if(assetPositionBO!=null){
							if(i!=0){
								if(domain!=null){
									buffer.append(";"+domain.getDomainName());
								}
							}
							buffer.append("|"+assetPositionBO.getDescription());
						}
						AssetPositionBO assetPositionBO2 = assetPositionDao.getNodeListById(topos.getPositionId());
						if(assetPositionBO2!=null){
							buffer.append("|"+assetPositionBO2.getDescription());
						}
					}
					 
				}
			}
			return buffer.toString();
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据某一域、某一设备类型得到物理位置信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
}
