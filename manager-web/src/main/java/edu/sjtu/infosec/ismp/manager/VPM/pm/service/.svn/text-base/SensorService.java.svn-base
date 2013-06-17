package edu.sjtu.infosec.ismp.manager.VPM.pm.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 软件管理与manager通信的接口
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface SensorService {
	/**
	 * 查询某个客户端的所有补丁更新信息
	 * @return 某个客户端的所有补丁更新信息
	 */
	List<PatchUpdateInfo> findAllPatchUpdateInfoBySensorClients(SensorClients sensorClients) throws Exception;
	/**
	 * 查询某个客户端的所有补丁更新信息分页
	 * @return 某个客户端的所有补丁更新信息
	 */
	PageResult findAllPatchUpdateInfoBySensorClients(SensorClients sensorClients, PMPage page) throws Exception;
	/**
	 * 查询某个客户端的所有错误的补丁更新信息
	 * @return 某个客户端的所有错误的补丁更新信息
	 */
	List<PatchUpdateInfo> findAllPatchUpdateFailedBySensorClients(SensorClients sensorClients) throws Exception;
	/**
	 * 查询某个客户端的所有错误的补丁更新信息分页
	 * @return 某个客户端的所有错误的补丁更新信息
	 */
	PageResult findAllPatchUpdateFailedBySensorClients(SensorClients sensorClients, PMPage page) throws Exception;
	/**
	 * 查询某个客户端的所有需要的补丁更新信息
	 * @return 某个客户端的所有需要的补丁更新信息
	 */
	List<PatchUpdateInfo> findAllPatchUpdateNeedBySensorClients(SensorClients sensorClients) throws Exception;
	/**
	 * 查询某个客户端的所有需要的补丁更新信息分页
	 * @return 某个客户端的所有需要的补丁更新信息
	 */
	PageResult findAllPatchUpdateNeedBySensorClients(SensorClients sensorClients, PMPage page) throws Exception;
	/**
	 * 查询某个客户端的所有已安装/不适用的补丁更新信息
	 * @return 某个客户端的所有安装/不适用的补丁更新信息
	 */
	List<PatchUpdateInfo> findAllPatchUpdateOKBySensorClients(SensorClients sensorClients) throws Exception;
	/**
	 * 查询某个客户端的所有已安装/不适用的补丁更新信息分页
	 * @return 某个客户端的所有安装/不适用的补丁更新信息
	 */
	PageResult findAllPatchUpdateOKBySensorClients(SensorClients sensorClients, PMPage page) throws Exception;
	/**
	 * 查询某个客户端的所有没有状态的补丁更新信息
	 * @return 某个客户端的所有没有状态的补丁更新信息
	 */
	List<PatchUpdateInfo> findAllPatchUpdateNoStateBySensorClients(SensorClients sensorClients) throws Exception;
	/**
	 * 查询某个客户端的所有没有状态的补丁更新信息分页
	 * @return 某个客户端的所有没有状态的补丁更新信息
	 */
	PageResult findAllPatchUpdateNoStateBySensorClients(SensorClients sensorClients, PMPage page) throws Exception;
	
	
	

	/**
	 * 查询某个客户端的所有补丁更新信息数目
	 * @return 某个客户端的所有补丁更新信息数目
	 */
	int findAllPatchUpdateInfoNumBySensorClients(SensorClients sensorClients) throws Exception;
	/**
	 * 查询某个客户端的所有错误的补丁更新信息数目
	 * @return 某个客户端的所有错误的补丁更新信息数目
	 */
	int findAllPatchUpdateFailedNumBySensorClients(SensorClients sensorClients) throws Exception;
	/**
	 * 查询某个客户端的所有需要的补丁更新信息数目
	 * @return 某个客户端的所有需要的补丁更新信息数目
	 */
	int findAllPatchUpdateNeedNumBySensorClients(SensorClients sensorClients) throws Exception;
	/**
	 * 查询某个客户端的所有已安装/不适用的补丁更新信息数目
	 * @return 某个客户端的所有安装/不适用的补丁更新信息数目
	 */
	int findAllPatchUpdateOkNumBySensorClients(SensorClients sensorClients) throws Exception;
	/**
	 * 查询某个客户端的所有没有状态的补丁更新信息数目
	 * @return 某个客户端的所有没有状态的补丁更新信息数目
	 */
	int findAllPatchUpdateNoNumStateBySensorClients(SensorClients sensorClients) throws Exception;
	
	
	

	/**
	 * 查询所有补丁信息
	 * @return 所有补丁信息
	 */
	List<PatchInfo> findAllPatchInfo() throws Exception;
	/**
	 * 查询所有已安装/不适用的补丁信息
	 * @return 所有已安装/不适用的补丁信息
	 */
	List<PatchInfo> findAllOkPatchInfo() throws Exception;
	/**
	 * 查询所有补丁信息分页
	 * @return 所有补丁信息
	 */
	PageResult findAllPatchInfo(Page page) throws Exception;
	/**
	 * 查询所有已安装/不适用的补丁信息分页
	 * @return 所有已安装/不适用的补丁信息
	 */
	PageResult findAllOkPatchInfo(Page page) throws Exception;
	
	

	/**
	 * 查询所有补丁信息数目
	 * @return 所有补丁信息数目
	 */
	int findAllPatchInfoNum() throws Exception;
	/**
	 * 查询所有已安装/不适用的补丁信息数目
	 * @return 所有已安装/不适用的补丁信息数目
	 */
	int findAllOkPatchInfoNum() throws Exception;
	
	
	
	/**
	 * 查询指定客户端List中需更新补丁的客户端
	 * @return 指定客户端List中需更新补丁的客户端
	 */
	List<SensorClients> findClientsOfNeedUpdate(List<SensorClients> sensorClientsList) throws Exception;
	/**
	 * 查询指定客户端List中需更新补丁的客户端分页
	 * @return 指定客户端List中需更新补丁的客户端
	 */
	List<SensorClients> findClientsOfNeedUpdate(List<SensorClients> sensorClientsList, int startResult, int maxResult) throws Exception;
	
	
	
	/**
	 * 查询指定客户端List中需更新补丁的客户端数目
	 * @return 指定客户端List中需更新补丁的客户端数目
	 */
	int findClientsNumOfNeedUpdate(List<SensorClients> sensorClientsList) throws Exception;
}
