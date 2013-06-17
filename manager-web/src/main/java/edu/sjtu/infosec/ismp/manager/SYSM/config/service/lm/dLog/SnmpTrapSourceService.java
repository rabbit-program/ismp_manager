package edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSourceType;
import edu.sjtu.infosec.ismp.security.Domain;

public interface SnmpTrapSourceService {
	
	/**
	 * 无条件获得所在域下的所有SnmpTrapSource
	 * @return
	 * @throws Exception
	 */
	public List<SnmpTrapSource> getAllSnmpTrapSource(SnmpTrapSource snmpTrapSource,List<Domain> domain,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 无条件获得所在域下的所有SnmpTrapSource的条数
	 * @return
	 * @throws Exception
	 */
	public Integer getAllSnmpTrapSourceCount(SnmpTrapSource snmpTrapSource,List<Domain> domain)throws Exception;
	
	/**
	 * 新增	SnmpTrapSource
	 * 
	 * @param snmpTrapSource
	 * @return
	 * @throws Exception
	 */
	public boolean addSnmpTrapSource(SnmpTrapSource snmpTrapSource)throws Exception;
	
	/**
	 * 删除	SnmpTrapSource
	 * @param snmpTrapSource
	 * @return
	 * @throws Exception
	 */
	public boolean delSnmpTrapSource(SnmpTrapSource snmpTrapSource,TopoWebService topoWebService)throws Exception;
	
	/**
	 * 修改
	 * @param sourceId
	 * @param startCollectSwitch
	 * @return
	 * @throws Exception
	 */
	public boolean updateSnmpTrapSource(SnmpTrapSource snmpTrapSource)throws Exception;
	
	/**
	 * 无条件获得所有SnmpTrapSourceType
	 * @return
	 * @throws Exception
	 */
	public List<SnmpTrapSourceType> getAllSnmpTrapSourceType()throws Exception;
	
	/**
	 * 加载SnmpTrapSource
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SnmpTrapSource loadObject(String id)throws Exception;
}
