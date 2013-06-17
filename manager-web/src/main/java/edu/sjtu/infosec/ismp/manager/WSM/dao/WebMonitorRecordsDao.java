package edu.sjtu.infosec.ismp.manager.WSM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.WSM.model.WebMonitorRecords;
import edu.sjtu.infosec.ismp.security.Domain;
/**
 * 应用层 网站安全检测Dao接口.
 */
public interface WebMonitorRecordsDao {
	 /**
     * 保存/更新网站安全检测信息
     */
    void saveOrUpdate(WebMonitorRecords webMonitorRecords);

    /**
     * 删除网站安全检测信息
     */
    void remove(WebMonitorRecords webMonitorRecords);

    /**
     * 批量删除网站安全检测信息
     */
	void remove(List<WebMonitorRecords> webMonitorList);

    /**
     * 查询资产网站安全检测
     */
    WebMonitorRecords findById(Integer id);
    
    /**
     * 资产网站安全检测分页信息
     */
    List<WebMonitorRecords> findAll(int startResult, int maxResult);
    
    List<WebMonitorRecords> findAllByDomain(List<Domain> userDomainList,
			int startResult, int maxResult);
    /**
     * 网站安全检测查询记录总条数
     */
	int getCount();

	int getCountByDomain(List<Domain> userDomainList);

	WebMonitorRecords findByNodeId(String nodeId);
	
}
