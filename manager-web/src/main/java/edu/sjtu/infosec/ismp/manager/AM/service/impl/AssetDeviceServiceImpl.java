package edu.sjtu.infosec.ismp.manager.AM.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import jxl.CellType;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import edu.sjtu.infosec.ismp.manager.AM.comm.AssetConstant;
import edu.sjtu.infosec.ismp.manager.AM.dao.AssetDeviceDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.DeviceChartVO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class AssetDeviceServiceImpl implements AssetDeviceService {
	
	private AssetDeviceDao assetDeviceDao;
	
	private SystemLogService systemlogService;
	
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}

	public void setAssetDeviceDao(AssetDeviceDao assetDeviceDao) {
		this.assetDeviceDao = assetDeviceDao;
	}

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
	void destory(){
		log=null;
		username=null;
		rolenames=null;
	}
	
	public void add(AssetDeviceBO assetDevice) throws Exception {
		
		try{
			init();
			assetDeviceDao.add(assetDevice);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			destory();
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("添加资产操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			destory();
		}
	}

	public void delete(AssetDeviceBO assetDevice) throws Exception {
		
		
		try{
			init();
			assetDeviceDao.delete(assetDevice);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			destory();
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("删除资产操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			destory();
		}
	}

	public void update(AssetDeviceBO assetDevice) throws Exception {
		
		try{
			init();
			assetDeviceDao.update(assetDevice);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("更新资产操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			destory();
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("更新资产操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			destory();
		}
	}
	
	
	/**
	 * 资产报表统计
	 */
	public List<DeviceChartVO> getDeviceChartData(AssetDeviceBO deviceBO) {
		try{
			init();
			List<DeviceChartVO> entityList = new ArrayList<DeviceChartVO>();

			DeviceChartVO last4Chart = assetDeviceDao.getDeviceChartData(4,
					deviceBO);
			DeviceChartVO last3Chart = assetDeviceDao.getDeviceChartData(3,
					deviceBO);
			DeviceChartVO last2Chart = assetDeviceDao.getDeviceChartData(2,
					deviceBO);
			DeviceChartVO lastChart = assetDeviceDao.getDeviceChartData(1,
					deviceBO);
			DeviceChartVO curChart = assetDeviceDao.getDeviceChartData(0,
					deviceBO);

			entityList.add(last4Chart);
			entityList.add(last3Chart);
			entityList.add(last2Chart);
			entityList.add(lastChart);
			entityList.add(curChart);
			
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("资产报表统计操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			destory();
			return entityList;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("资产报表统计操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			destory();
			return null;
		}
		
		
	}
	
	
	public List<AssetDeviceBO> findAll() throws Exception {
		
		try{
			init();
			List<AssetDeviceBO> list = assetDeviceDao.findAll();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询所有资产操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			destory();
			return list;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询所有资产操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			destory();
			return null;
		}
	}

	public List<AssetDeviceBO> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		
//		return list;
		try{
			init();
			List<AssetDeviceBO> list = assetDeviceDao.findAll(startRecordTime, endRecordTime, startResult, maxResult);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询所有资产分页操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			destory();
			return list;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询所有资产分页操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			destory();
			return null;
		}
	}

	public List<AssetDeviceBO> findAllByDomain(List<Domain> domainList)
			throws Exception {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据域查询资产操作");
			log.setControl("成功");
			if(domainList == null){
				destory();
				return null;
			}else if(domainList.size()<=0){
				destory();
				return null;
			}else{
				List<AssetDeviceBO> list = assetDeviceDao.findAllByDomain(domainList);
				systemlogService.saveSystemLog(log);
				destory();
				return list;
			}
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据域查询资产操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			destory();
			return null;
		}
	}

	public List<AssetDeviceBO> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据域查询分页资产操作");
			log.setControl("成功");
			if(domainList == null){
				return null;
			}else if(domainList.size()<=0){
				return null;
			}else{
				List<AssetDeviceBO> list = assetDeviceDao.findAllByDomain(domainList, startRecordTime, endRecordTime, startResult, maxResult);
				systemlogService.saveSystemLog(log);
				return list;
			}
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据域查询分页资产操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			destory();
			return null;
		}
	}

	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		long num = assetDeviceDao.findAllNum(startRecordTime, endRecordTime);
		return num;
	}

	public long findAllNumByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		if(domainList == null){
			return 0;
		}else if(domainList.size()<=0){
			return 0;
		}else{
			long num = assetDeviceDao.findAllNumByDomain(domainList, startRecordTime, endRecordTime);
			return num;
		}
	}

	public AssetDeviceBO findById(int id) {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID查询资产操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetDeviceDao.findById(id);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("根据ID查询资产操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}



	public List<AssetDeviceBO> findAllByUnknowDomain() throws Exception {
		try{
			init();
			List<AssetDeviceBO> list = assetDeviceDao.findAllByUnknowDomain();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询所有未知域资产操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return list;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询所有未知域资产操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
		
	}



	public List<AssetDeviceBO> findAllByUnknowDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		try{
			init();
			List<AssetDeviceBO> list = assetDeviceDao.findAllByUnknowDomain(startRecordTime, endRecordTime, startResult, maxResult);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询所有未知域资产并分页操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return list;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询所有未知域资产并分页操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}



	public long findAllNumByUnknowDomain(Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		long num = assetDeviceDao.findAllNumByUnknowDomain(startRecordTime, endRecordTime);
		return num;
	}



	public List<AssetDeviceBO> getPageListByAssetDevice(
			AssetDeviceBO assetDeviceBO, Page page,List<Integer> list)  throws Exception{
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询资产并分页操作");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return assetDeviceDao.getPageListByAssetDevice(assetDeviceBO, page,list);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("查询资产并分页操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
		
	}



	public int getCountByAssetDevice(AssetDeviceBO assetDeviceBO) {
		return assetDeviceDao.getCountByAssetDevice(assetDeviceBO);
	}

	public boolean excelImport(InputStream is, Integer assetType)
			throws BiffException, IOException,Exception {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("excel导入操作");
			log.setControl("成功");
			/***********excelImport导出*************/
			List<AssetDeviceBO> entityList = new ArrayList<AssetDeviceBO>();
			Workbook wb = null;
			wb = Workbook.getWorkbook(is);
			Sheet sheet = wb.getSheet(0);
			int rows = sheet.getRows();
			for (int i = 1; i < rows; i++) {
			
				String sn = sheet.getCell(0, i).getContents();
				String name = sheet.getCell(1, i).getContents();
				String ip = sheet.getCell(2, i).getContents();
				String agentIp = sheet.getCell(3, i).getContents();
				String mac = sheet.getCell(4, i).getContents();
				String communityName = sheet.getCell(5, i).getContents();
				String manufacturer = sheet.getCell(6, i).getContents();
				String model = sheet.getCell(7, i).getContents();
				String description = sheet.getCell(8, i).getContents();
				String user = sheet.getCell(9, i).getContents();
				String telephone = sheet.getCell(10, i).getContents();
				String unit = sheet.getCell(11, i).getContents();
				String department = sheet.getCell(12, i).getContents();
				Integer status = null;
				if (sheet.getCell(13, i).getType() == CellType.NUMBER) {
					status = Integer.valueOf((int) ((NumberCell) sheet.getCell(13,
							i)).getValue());
				}
				Timestamp stockTime = null;
				if (sheet.getCell(14, i).getType() == CellType.DATE) {
					stockTime = new Timestamp(((DateCell) sheet.getCell(14, i))
							.getDate().getTime());
				}
				Integer validityPeriod = null;
				if (sheet.getCell(15, i).getType() == CellType.NUMBER) {
					validityPeriod = Integer.valueOf((int) ((NumberCell) sheet
							.getCell(15, i)).getValue());
				}
				Timestamp registrationTime = null;
				if (sheet.getCell(16, i).getType() == CellType.DATE) {
					registrationTime = new Timestamp(((DateCell) sheet.getCell(16,
							i)).getDate().getTime());
				}
			
				Integer priority = null;
				if (sheet.getCell(17, i).getType() == CellType.NUMBER) {
					priority = Integer.valueOf((int) ((NumberCell) sheet.getCell(
							17, i)).getValue());
				}
				Boolean checkAvailable = Boolean.valueOf(sheet.getCell(18, i)
						.getContents());
				String singleCode = RandomStringUtils
						.random(19,
								"abcdefghijkmnlopqrstuvwxyzABCDEFGHIJKMNLOPQRSTUVWXYZ0123456789")
						+ String.valueOf(System.currentTimeMillis());
				AssetDeviceBO entity = new AssetDeviceBO(agentIp, assetType,
						checkAvailable, communityName, department, description, ip,
						priority, mac, manufacturer, model, name, priority,
						registrationTime, singleCode, sn, status, stockTime,
						telephone, unit, user, validityPeriod);
				entityList.add(entity);
			}
			
			wb.close();
			
			// dao操作
			if (entityList.isEmpty()) {
				return false;
			}
			systemlogService.saveSystemLog(log);
			for (AssetDeviceBO bo : entityList) {
				assetDeviceDao.add(bo);
			}
			return true;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("excelImport导入操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return false;
		}
	}
	
	public boolean excelImport(InputStream is, Integer assetType, Integer locationId)
	throws BiffException,IOException,Exception {
		
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("excelImport导入操作");
			log.setControl("成功");
			
			/****************excelImport导出********************/

			List<AssetDeviceBO> entityList = new ArrayList<AssetDeviceBO>();
			Workbook wb = null;
			wb = Workbook.getWorkbook(is);
			Sheet sheet = wb.getSheet(0);
			int rows = sheet.getRows();
			for (int i = 1; i < rows; i++) {
				
				String sn = sheet.getCell(0, i).getContents();
				String name = sheet.getCell(1, i).getContents();
				String ip = sheet.getCell(2, i).getContents();
				String agentIp = sheet.getCell(3, i).getContents();
				String mac = sheet.getCell(4, i).getContents();
				String communityName = sheet.getCell(5, i).getContents();
				String manufacturer = sheet.getCell(6, i).getContents();
				String model = sheet.getCell(7, i).getContents();
				String description = sheet.getCell(8, i).getContents();
				String user = sheet.getCell(9, i).getContents();
				String telephone = sheet.getCell(10, i).getContents();
				String unit = sheet.getCell(11, i).getContents();
				String department = sheet.getCell(12, i).getContents();
				Integer status = null;
				if (sheet.getCell(13, i).getType() == CellType.NUMBER) {
					status = Integer.valueOf((int) ((NumberCell) sheet.getCell(13,
							i)).getValue());
				}
				Timestamp stockTime = null;
				if (sheet.getCell(14, i).getType() == CellType.DATE) {
					stockTime = new Timestamp(((DateCell) sheet.getCell(14, i))
							.getDate().getTime());
				}
				Integer validityPeriod = null;
				if (sheet.getCell(15, i).getType() == CellType.NUMBER) {
					validityPeriod = Integer.valueOf((int) ((NumberCell) sheet
							.getCell(15, i)).getValue());
				}
				Timestamp registrationTime = null;
				if (sheet.getCell(16, i).getType() == CellType.DATE) {
					registrationTime = new Timestamp(((DateCell) sheet.getCell(16,
							i)).getDate().getTime());
				}
				
				Integer priority = null;
				if (sheet.getCell(17, i).getType() == CellType.NUMBER) {
					priority = Integer.valueOf((int) ((NumberCell) sheet.getCell(
							17, i)).getValue());
				}
				Boolean checkAvailable = Boolean.valueOf(sheet.getCell(18, i)
						.getContents());
				String deviceType = sheet.getCell(19, i).getContents();
				String singleCode = RandomStringUtils
				.random(19,
				"abcdefghijkmnlopqrstuvwxyzABCDEFGHIJKMNLOPQRSTUVWXYZ0123456789")
				+ String.valueOf(System.currentTimeMillis());
				if(name != null && !"".equals(name)){
				AssetDeviceBO entity = new AssetDeviceBO(agentIp, assetType,
						checkAvailable, communityName, department, description, ip,
						priority, mac, manufacturer, model, name, priority,
						registrationTime, singleCode, sn, status, stockTime,
						telephone, unit, user, validityPeriod);
				entity.setLocationId(locationId);
				if(deviceType.trim().equals("路由器") || deviceType.trim().equals("router")){
					deviceType = "router";
					entity.setDeviceType(deviceType);
				}else if(deviceType.trim().equals("二层交换机")||deviceType.trim().equals("三层交换机") || deviceType.trim().equals("switch")){
					deviceType = "switch";
					entity.setDeviceType(deviceType);
				}else if(deviceType.trim().equals("PC") || deviceType.trim().equals("pc")){
					deviceType = "pc";
					entity.setDeviceType(deviceType);
				}else if(deviceType.trim().equals("防火墙") || deviceType.trim().equals("firewall")){
					deviceType = "firewall";
					entity.setDeviceType(deviceType);
				}else if(deviceType.trim().equals("服务器") || deviceType.trim().equals("server")){
					deviceType = "server";
					entity.setDeviceType(deviceType);
				}else if(deviceType.trim().equals("IDS") || deviceType.trim().equals("ids")){
					deviceType = "ids";
					entity.setDeviceType(deviceType);
				}
				entityList.add(entity);
				}
			}
			
			wb.close();
			
			// dao操作
			if (entityList.isEmpty()) {
				return false;
			}
			systemlogService.saveSystemLog(log);
			for (AssetDeviceBO bo : entityList) {
				assetDeviceDao.add(bo);
			}
			destory();
			return true;
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AM);
			log.setOperationDesc("excelImport导入操作");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			destory();
			return false;
		}	
	}

	public AssetDeviceBO getByNodeId(String nodeid) throws Exception {
		assetDeviceDao.getByNodeId(nodeid);
		return null;
	}


}
