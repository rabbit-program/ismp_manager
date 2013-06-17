package edu.sjtu.infosec.ismp.manager.WSM.service;

import java.util.List;
import edu.sjtu.infosec.ismp.manager.WSM.model.WebMonitorRecords;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 应用层 网站安全检测Manager接口.
 */
public interface WebMonitorRecordsService {
	 /**
     * 保存/更新网站安全检测信息
     */
    void saveOrUpdate(WebMonitorRecords webMonitorRecords);

    /**
     * 删除网站安全检测信息
     */
    void remove(Integer id);

    /**
     * 批量删除网站安全检测信息
     */
    void remove(String[] ids);

    /**
     * 查询网站安全检测
     */
    WebMonitorRecords findById(Integer id);
    
    /**
     * 网站安全检测分页信息
     */
    List<WebMonitorRecords> findAll(int startResult, int maxResult);
    
    List<WebMonitorRecords> findAllByDomain(List<Domain> userDomainList,
			int startResult, int maxResult);

    /**
     * 网站安全检测查询记录总条数
     */
	int getCount();
	
	int getCountByDomain(List<Domain> userDomainList);
	
	/**
	 * 认可
	 * @param nodeId
	 * @return
	 */
	public boolean isChange(String nodeId);
	
	public Object[] findWebStates(String nodeId,Integer timeOut);
	
	public String findOverStates (String nodeId);
	
	/**
	 * 同时保存前后台数据
	 * @param webMonitor
	 */
	public void saveAllMonitor(WebMonitorRecords webMonitor);
	
	/**
	 * 同时删除前后台数据
	 * @param record
	 */
	
	public void removeAllMonitor(WebMonitorRecords record);
	
}
