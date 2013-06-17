package edu.sjtu.infosec.ismp.manager.RAM.service;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import jxl.read.biff.BiffException;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;

/**
 * 应用层 漏洞扫描Manager接口.
 */
public interface LeakScanService  {

	/**
     * 保存/更新扫描漏洞
     * 漏洞
     **/
    void saveOrUpdate(AsseInfoLeak leak);
    
    /**
     * 批量保存/更新扫描漏洞
     * 漏洞列表
     **/
    void batchSaveOrUpdate(List<AsseInfoLeak> leaks);
    
    /**
     * 删除漏洞
     * 漏洞
     **/
    void remove(AsseInfoLeak leak);
    
    /**
     * 批量删除漏洞
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
    AsseInfoLeak find(String id);
    
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
     * 查询漏洞数量
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞数量
     **/
    int getCount(AsseInfoProj asseInfoProj, String ip);
    
    /**
     * 查询漏洞分页记录
     **/
    List<AsseInfoLeak> findAll(int startResult ,int maxResult,AsseInfoProj asseInfoProj, String ip);
    
    /**
     * 查询漏洞记录
     * @param asseInfoProj
     *            测评项目
     * @return 分页记录列表
     **/
    List<AsseInfoLeak> listAsseInfoLeak(AsseInfoProj asseInfoProj);
    
    /**
     * 检查是否已导入过
     * @param asseInfoProj
     *            测评项目
     * @return true/false
     **/
    boolean checkExit(AsseInfoProj asseInfoProj);
    
    /**
     * 导入扫描报告
     * @param asseInfoProj
     *            测评项目
     * @param inputXml
     *     报告绝对路径
     **/
    void importDataByXmlFile( AsseInfoProj asseInfoProj,InputStream inputXml);

    void importDataByXlsFile( AsseInfoProj asseInfoProj,InputStream inputXls) throws IOException,BiffException;
    
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
     * 判断安全级别
     * @param risk
     *  绿盟xml报告中的risk值
     * @return true/false
     **/
	String retSecuLeve(String risk);
	
	/**
     * 查询IP地址列表
     * @param asseInfoProj
     *            测评项目
     * @return IP地址列表
     **/
    List<String> listIP(AsseInfoProj asseInfoProj);
    
    List<String> listCVEId(AsseInfoProj asseInfoProj);
}
