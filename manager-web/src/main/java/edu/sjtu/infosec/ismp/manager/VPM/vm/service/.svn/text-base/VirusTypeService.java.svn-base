package edu.sjtu.infosec.ismp.manager.VPM.vm.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusType;

/**
 * 病毒管理与managerWEB通信的接口---病毒类型
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface VirusTypeService {
	/**
	 * 增
	 * @param virusType
	 * 病毒类型
	 */
	void addVirusType(VirusType virusType) throws Exception;
	/**
	 * 删
	 * @param virusType
	 * 病毒类型
	 */
	void deleteVirusType(VirusType virusType) throws Exception;
	/**
	 * 改
	 * @param virusType
	 * 病毒类型
	 */
	void updateVirusType(VirusType virusType) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 病毒类型List
	 */
	List<VirusType> findAllVirusType() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 病毒类型List
	 */
	List<VirusType> findAllVirusType(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询病毒类型
	 * @return 病毒类型
	 */
	VirusType findVirusTypeById(int id) throws Exception;

}
