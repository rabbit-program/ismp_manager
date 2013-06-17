package edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSourceType;
import edu.sjtu.infosec.ismp.security.Domain;

public interface SnmpTrapSourceDao {
	/**
	 * 获得符合HQL条件的SnmpTrapSource
	 * @param HQL
	 * @return
	 * @throws Exception
	 */
	public List<SnmpTrapSource> getAllSnmpTrapSource(SnmpTrapSource snmpTrapSource,List<Domain> domain,Integer pageNo,Integer pageRowNum)throws Exception;
	/**
	 * 获得符合HQL条件的SnmpTrapSource的条数
	 * @param HQL
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
	public Integer addSnmpTrapSource(SnmpTrapSource snmpTrapSource)throws Exception;
	
	/**
	 * 删除	SnmpTrapSource
	 * @param snmpTrapSource
	 * @return
	 * @throws Exception
	 */
	public Integer delSnmpTrapSource(SnmpTrapSource snmpTrapSource)throws Exception;
	
	/**
	 * 修改
	 * @param HQL
	 * @return
	 * @throws Exception
	 */
	public Integer updateSnmpTrapSource(SnmpTrapSource snmpTrapSource)throws Exception;
	
	/**
	 * 加载SnmpTrapSource
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SnmpTrapSource loadObject(String id) throws Exception;
	
	/**
	 * 无条件获得所有SnmpTrapSourceType
	 * @return
	 * @throws Exception
	 */
	public List<SnmpTrapSourceType> getAllSnmpTrapSourceType()throws Exception;
}
