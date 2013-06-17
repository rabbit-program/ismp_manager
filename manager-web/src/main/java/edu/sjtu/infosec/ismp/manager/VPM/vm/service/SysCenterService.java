package edu.sjtu.infosec.ismp.manager.VPM.vm.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.SysCenter;

/**
 * 病毒管理与managerWEB通信的接口---病毒系统中心端
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface SysCenterService {
	/**
	 * 增
	 * @param sysCenter
	 * 病毒系统中心端
	 */
	void addSysCenter(SysCenter sysCenter) throws Exception;
	/**
	 * 删
	 * @param sysCenter
	 * 病毒系统中心端
	 */
	void deleteSysCenter(SysCenter sysCenter) throws Exception;
	/**
	 * 改
	 * @param sysCenter
	 * 病毒系统中心端
	 */
	void updateSysCenter(SysCenter sysCenter) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 病毒系统中心端List
	 */
	List<SysCenter> findAllSysCenter() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 病毒系统中心端List
	 */
	List<SysCenter> findAllSysCenter(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询病毒系统中心端
	 * @return 病毒系统中心端
	 */
	SysCenter findSysCenterById(int id) throws Exception;

}
