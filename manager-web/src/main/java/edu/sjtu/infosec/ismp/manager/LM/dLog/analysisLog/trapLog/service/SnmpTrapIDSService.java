package edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.service;

import java.util.List;

import edu.sjtu.infosec.ismp.security.Domain;

public interface SnmpTrapIDSService {
	/**
	 * 通过条件得到 SnmpTrapIDS 的Log记录
	 * @param HQL
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<?> getSnmpTrapIDSLog(Class clazz,List<Domain> domain,String logSourceLogo,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 通过条件得到 SnmpTrapIDS 的Log记录的总数
	 * @param HQL
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Integer getSnmpTrapIDSLogCount(Class clazz,List<Domain> domain,String logSourceLogo)throws Exception;
}
