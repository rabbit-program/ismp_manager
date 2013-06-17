package edu.sjtu.infosec.ismp.manager.VPM.vm.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.KillResultType;
/**
 * 病毒管理与managerWEB通信的接口---病毒查杀结果类型
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface KillResultTypeService {
	/**
	 * 增
	 * @param killResultType
	 * 病毒查杀结果类型
	 */
	void addKillResultType(KillResultType killResultType) throws Exception;
	/**
	 * 删
	 * @param killResultType
	 * 病毒查杀结果类型
	 */
	void deleteKillResultType(KillResultType killResultType) throws Exception;
	/**
	 * 改
	 * @param killResultType
	 * 病毒查杀结果类型
	 */
	void updateKillResultType(KillResultType killResultType) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 病毒查杀结果类型List
	 */
	List<KillResultType> findAllKillResultType() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 病毒查杀结果类型List
	 */
	List<KillResultType> findAllKillResultType(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询病毒查杀结果类型
	 * @return 病毒查杀结果类型
	 */
	KillResultType findKillResultTypeById(int id) throws Exception;

}
