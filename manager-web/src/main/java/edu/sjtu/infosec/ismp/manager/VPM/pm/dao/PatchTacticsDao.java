package edu.sjtu.infosec.ismp.manager.VPM.pm.dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateTactics;
public interface PatchTacticsDao {

	public LinkedList getTacticsInfos(PatchUpdateTactics patchTactics,Integer startResult, Integer maxResult, Date startDate,Date endDate);
	/**
	 * 
	 * getSensorClients decription : 获得全局策略
	 * 
	 * @param
	 */
	public String getGlobalPatchUpdateTactics();
	/**
	 * 
	 * setGlobalPatchUpdateTactics decription : 设置全局默认策略
	 * 
	 * @param
	 */
	public void setGlobalPatchUpdateTactics(int patchUpdateTacticsId);
	/**
	 * 
	 * getSensorClients decription : 获得平台默认地址
	 * 
	 * @param
	 */
	public String getDefAddress();
	/**
	 * 
	 * getSensorClients decription : 保存策略配置，更新策略表
	 * 
	 * @param
	 */
	public void saveOrUpdatePatchUpdateTactics(PatchUpdateTactics patchUpdateTactics);
	/**
	 * 
	 * getSensorClients decription : 根据ID删除策略
	 * 
	 * @param
	 */
	public void delPatchUpdateTactics(int stId);
	/**
	 * 
	 * getSensorClients decription : 根据Id获得策略信息
	 * 
	 * @param
	 */
	public PatchUpdateTactics getPachStrategyById(int pachStrategyId);
	/**
	 * 
	 * getSensorClients decription : 获得所有补丁策略信息
	 * 
	 * @param
	 */
	public List<PatchUpdateTactics> getAllPachStrategy();
}
