package org.infosec.ismp.manager.rmi.wsm.service;

import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.wsm.model.WebStates;

/**
 * 
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface WebStatesService {
	/**
	 * 新增监测项
	 * @param 
	 * 
	 */
	void addWebMonitor(int domainId, int nodeId, String changeCode) throws Exception;
	/**
	 * 删除监测项
	 * @param 
	 * 
	 */
	void deletWebMonitor(int domainId, int nodeId, String changeCode) throws Exception;
	/**
	 * 获取指定监测项的信息
	 * @param 
	 * 
	 */
	WebStates getWebStateByNodeId(int nodeId) throws Exception;
	/**
	 * 获取指定列表中的监测项的信息
	 * @param 
	 * 
	 */
	List<WebStates> getWebStateByNodeIdList(List<Integer> nodeIdList) throws Exception;
	/**
	 * 获取指定域下的监测项的信息
	 * @param 
	 * 
	 */
	List<WebStates> getWebStateByDomainId(int domainId) throws Exception;
	/**
	 * 获取指定列表中的指定域下的监测项的信息
	 * @param 
	 * 
	 */
	Map<Integer, List<WebStates>> getWebStateByDomainIdList(List<Integer> domainIdList) throws Exception;

}
