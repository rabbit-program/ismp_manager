package edu.sjtu.infosec.ismp.manager.VPM.vm.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.Virus;
/**
 * 病毒信息-数据库操作
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface VirusDao {
	/**
	 * 增
	 * @param virus
	 * 病毒信息
	 */
	void addVirus(Virus virus) throws Exception;
	/**
	 * 删
	 * @param virus
	 * 病毒信息
	 */
	void deleteVirus(Virus virus) throws Exception;
	/**
	 * 改
	 * @param virus
	 * 病毒信息
	 */
	void updateVirus(Virus virus) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 病毒信息List
	 */
	List<Virus> findAllVirus() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 病毒信息List
	 */
	List<Virus> findAllVirus(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询病毒信息
	 * @return 病毒信息
	 */
	Virus findVirusById(int id) throws Exception;

}
