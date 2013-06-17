package edu.sjtu.infosec.ismp.manager.ERM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.model.LinkMan;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface LinkManService {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(LinkMan linkMan) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(LinkMan linkMan) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(LinkMan linkMan) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<LinkMan> findAll() throws Exception;
	/**
	 * 查指定域下的所有
	 * 注意：此方法未实现，如有需要再做
	 * @return 
	 */
	List<LinkMan> findAllByDomain(List<Domain> domainList) throws Exception;

	/**
	 * 通过ID查
	 * @return 
	 */
	LinkMan findById(Integer id);

	/**
	 * 查指定预案下的所有
	 * @return 
	 */
	List<LinkMan> findByRespInfo(RespInfoBO respInfo);
	/**
	 * 查指定预案ID下的所有
	 * @return 
	 */   
	List<LinkMan> findByRespInfoId(Integer id);
	
	void deleteLinkManByRespInfo(RespInfoBO resp);
	
	//获得树
	String getTree(List<LinkMan> linkManList,String basePath,String respname);
	
	//保存
	void saveorupdate(LinkMan linkman);
	//查询出最大的pid
	Integer getMaxPid(Integer respid);
    //检查teamcode是否存在
    boolean checkTeamId(Integer respid, String teamCode);
    
    List<LinkMan> queryByPid(Integer pid,String respid);
    
    void deleteByPid(String s,String respid);
    
    LinkMan findByTeamId(String teamCode,String respid);
    
}
