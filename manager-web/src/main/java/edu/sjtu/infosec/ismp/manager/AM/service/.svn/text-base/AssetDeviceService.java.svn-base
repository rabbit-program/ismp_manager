package edu.sjtu.infosec.ismp.manager.AM.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

import jxl.read.biff.BiffException;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.DeviceChartVO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface AssetDeviceService {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(AssetDeviceBO assetDevice) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(AssetDeviceBO assetDevice) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(AssetDeviceBO assetDevice) throws Exception;
	
	
	/**
	 * 资产报表统计 
	 */
	public List<DeviceChartVO> getDeviceChartData(AssetDeviceBO deviceBO);
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<AssetDeviceBO> findAll() throws Exception;
	/**
	 * 根据NodeId得到资产对象
	 * @return
	 * @throws Exception
	 */
	AssetDeviceBO getByNodeId(String nodeid) throws Exception;
	/**
	 * 查指定域下的所有
	 * @return 
	 */
	List<AssetDeviceBO> findAllByDomain(List<Domain> domainList) throws Exception;
	/**
	 * 查未知域下的所有
	 * @return 
	 */
	List<AssetDeviceBO> findAllByUnknowDomain() throws Exception;
	
	
//分页查询开始
	/**
	 * 查指定时间段下的所有（分页）
	 * @return 
	 */
	List<AssetDeviceBO> findAll(Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查指定时间段下的所有数目
	 * @return 
	 */
	long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 查指定域和指定时间段下的所有（分页）
	 * @return 
	 */
	List<AssetDeviceBO> findAllByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查指定域和指定时间段下的所有数目
	 * @return 
	 */
	long findAllNumByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;

	/**
	 * 查未知域和指定时间段下的所有（分页）
	 * @return 
	 */
	List<AssetDeviceBO> findAllByUnknowDomain(Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查未知域和指定时间段下的所有数目
	 * @return 
	 */
	long findAllNumByUnknowDomain(Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
//分页查询结束
	
	
	
	/*
	 * 根据id查询对应应急信息
	 */
	AssetDeviceBO findById(int id);

	/**
	 * 根据条件分页查询
	 * @param assetDeviceBO
	 * @param page
	 * @return
	 * @throws Exception 
	 */
	List<AssetDeviceBO> getPageListByAssetDevice(AssetDeviceBO assetDeviceBO,Page page,List<Integer> list) throws Exception;
	
	/**
	 * 根据查询条件统计个数
	 * @param assetDeviceBO
	 * @return
	 */
	int getCountByAssetDevice(AssetDeviceBO assetDeviceBO);
	
	/**
	 * Excel导入数据
	 */
	public boolean excelImport(InputStream is, Integer assetType)throws BiffException,IOException,Exception;
	
	public boolean excelImport(InputStream is, Integer assetType, Integer locationId)throws BiffException, IOException,Exception;
}
