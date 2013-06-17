package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 漏洞扫描Dao访问接口.
 * 


 **/
public interface LeakScanDao  {

	/**
     * 保存/更新扫描漏洞
     * 
     * @param leak
     * 漏洞
     **/
    void saveOrUpdate(AsseInfoLeak leak);
    
    /**
     * 批量保存/更新扫描漏洞
     * 
     * @param leaks
     * 漏洞列表
     **/
    void batchSaveOrUpdate(List<AsseInfoLeak> leaks);
    
    /**
     * 删除漏洞
     * 
     * @param leak
     * 漏洞
     **/
    void remove(AsseInfoLeak leak);
    
    /**
     * 批量删除漏洞
     * 
     * @param leakList
     *     漏洞列表
     **/
    void remove(List<AsseInfoLeak> leakList);
    
    /**
     * 查询漏洞
     * 
     * @param id
     *    漏洞id
     * @return 漏洞对象
     **/
    AsseInfoLeak find(Integer id);
    
    /**
     * 查询漏洞
     * 
     * @param cveId
     *    cveId
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞对象
     **/
    AsseInfoLeak findByCveId(String cveId,AsseInfoProj asseInfoProj);
    
    /**
     * 查询漏洞
     * 
     * @param pluginId
     *    pluginId
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞对象
     **/
    List findByPluginId(String pluginId,AsseInfoProj asseInfoProj);
    
    /**
     * 查询漏洞
     * 
     * @param vulId
     *    vulId
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞对象
     **/
    List findByVulId(String vulId,AsseInfoProj asseInfoProj);
    
    /**
     * 查询漏洞数量
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞数量
     **/
    int getCount(AsseInfoProj asseInfoProj, String ip);
    
    /**
     * 查询漏洞记录
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞记录列表
     **/
    List<AsseInfoLeak> listAsseInfoLeak(AsseInfoProj asseInfoProj);
    
    /**
     * 查询IP地址列表
     * @param asseInfoProj
     *            测评项目
     * @return IP地址列表
     **/
    List<String> listIP(AsseInfoProj asseInfoProj);
    
    List<String> listCVEId(AsseInfoProj asseInfoProj);
    /**
     * 查询漏洞分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @return 分页记录列表
     **/
	List<AsseInfoLeak> findAll(int startResult, int maxResult,AsseInfoProj asseInfoProj, String ip);
}
