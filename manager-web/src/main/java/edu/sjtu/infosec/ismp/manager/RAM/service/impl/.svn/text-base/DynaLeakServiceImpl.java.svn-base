package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.AssetDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaLeakDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.LeakScanDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeak;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 动态资产漏洞分析Manager接口实现类.
 */
public class DynaLeakServiceImpl  implements DynaLeakService {

	/**
     * 资产录入数据访问对象接口
     */
    private AssetDao assetDao;
    
    /**
     * setAssetDao
     * @param assetdao 
     * assetdao
     **/
    public void setAssetDao(AssetDao assetdao) {
        this.assetDao = assetdao;
    }
    
    /**
     * leakScanDao
     * 
     */
	private LeakScanDao leakScanDao;
	
	/**
     * setLeakScanDao
     * @param leakScanDao
     * 漏洞扫描Dao
     **/
	public void setLeakScanDao(LeakScanDao leakScanDao) {
		this.leakScanDao = leakScanDao;
	}
	
    /**
     * 动态资产漏洞分析数据访问对象接口
     */
    private DynaLeakDao dynaLeakDao;
    
    
    /**
     * setDynaLeakDao
     * @param dynaleakDao 
     * dynaLeakDao
     **/
	public void setDynaLeakDao(DynaLeakDao dynaleakDao) {
		this.dynaLeakDao = dynaleakDao;
	}

	/**
     * 批量保存/更新动态资产漏洞
     * 
     * @param dynaLeakList
     * 动态资产漏洞列表
     **/
	public void batchSaveOrUpdate(List<AsseKnowDynaLeak> dynaLeakList) {
		
		dynaLeakDao.batchSaveOrUpdate(dynaLeakList);
	}

	/**
     * 检查是否已存在该资产漏洞
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param pluginId
     *      插件Id
     * @param vulId
     *      漏洞Id
     * @return 是否已存在
     **/
	public boolean checkExitDynaLeak(Integer asseInfoProjId,
			AsseInfoAsse asseInfoAsse, String pluginId, String vulId) {
		
		return dynaLeakDao.checkExitDynaLeak(asseInfoProjId, asseInfoAsse, pluginId, vulId);
	}

	/**
     * 查询动态资产漏洞
     * 
     * @param id
     *    动态资产漏洞id
     * @return 动态资产漏洞对象
     **/
	public AsseKnowDynaLeak find(String id) {
		
		return dynaLeakDao.find(new Integer(id));
	}

	/**
     * 查询动态资产漏洞数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态资产漏洞数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, List<AsseInfoAsse> asseInfoAsse) {
		
		return dynaLeakDao.getCount(asseInfoProj, asseInfoAsse);
	}

	/**
     * 查询动态资产漏洞记录
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞记录列表
     **/
	public List<AsseKnowDynaLeak> listDynaLeak(AsseInfoProj asseInfoProj) {
		
		return dynaLeakDao.listDynaLeak(asseInfoProj);
	}

	/**
     * 查询动态资产漏洞分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 分页记录列表
     **/
	public List<AsseKnowDynaLeak> listDynaLeakPage(int startResult, int maxResult, AsseInfoProj asseInfoProj,List<AsseInfoAsse> asseInfoAsse) {
        List<AsseKnowDynaLeak> list = dynaLeakDao.listDynaLeakPage(startResult,maxResult, asseInfoProj, asseInfoAsse);
        return list;
	}

	/**
     * 保存/更新动态资产漏洞
     * 
     * @param dynaLeak
     * 动态资产漏洞
     **/
	public void saveOrUpdate(AsseKnowDynaLeak dynaLeak) {
		
		dynaLeakDao.saveOrUpdate(dynaLeak);
	}

	/**
     * 检查是否已存在该资产漏洞
     * @param asseInfoProj
     *            测评项目
     * @return 是否已存在
     **/
	public boolean checkExitDynaLeakList(AsseInfoProj asseInfoProj) {
		
		boolean ret = false;
		List list = listDynaLeak(asseInfoProj);
		
		if(list!=null && list.size()>0) {
			ret = true;
		}
		
		return ret;
	}

	/**
     * 保存动态资产漏洞
     * @param asseInfoProj
     *            测评项目
     **/
	public void saveDynaLeak(AsseInfoProj asseInfoProj) {
		
		boolean exit = checkExitDynaLeakList(asseInfoProj);
		if(!exit) {
			List<AsseInfoLeak> leakList = leakScanDao.listAsseInfoLeak(asseInfoProj);
			if(leakList!=null && leakList.size()>0) {
				AsseInfoLeak asseInfoLeak = null;
				List<AsseKnowDynaLeak> dynaLeakList = new ArrayList<AsseKnowDynaLeak>();
				for(int i=0;i<leakList.size();i++) {
					asseInfoLeak = leakList.get(i);
					AsseKnowDynaLeak dynaLeak = new AsseKnowDynaLeak();
					dynaLeak.setAsse(asseInfoLeak.getAsse());
					dynaLeak.setAsseInfoProjId(asseInfoProj.getId());
					dynaLeak.setAsseKnowStatVulnKindId(new Integer(1));
					dynaLeak.setCveId(asseInfoLeak.getCveId());
					dynaLeak.setPluginId(asseInfoLeak.getPluginId());
					dynaLeak.setSeriLeve(asseInfoLeak.getRisk());
					dynaLeak.setInfoLeakId(asseInfoLeak.getId());
					dynaLeak.setLocation(asseInfoLeak.getLocation());
					dynaLeak.setSource("漏洞扫描");
					dynaLeak.setVulId(asseInfoLeak.getKnowId());
					dynaLeakList.add(dynaLeak);
				}
				    dynaLeakDao.batchSaveOrUpdate(dynaLeakList);
			}
		}
		
	}

	/**
     * 漏洞与资产关联
     * @param paraMap
     * 参数Map
     **/
	public void relateLeakToAssert(Map paraMap) {
		List<AsseKnowDynaLeak> dynaLeakList = new ArrayList<AsseKnowDynaLeak>();
		AsseInfoAsse asseInfo = null;
		String assetCode = (String) paraMap.get("assetCodeSelect");
	    String[] dynaLeakIds = (String[]) paraMap.get("dynaLeakIds");
	    String[] secuLeves = (String[]) paraMap.get("secuLeves");

	    for(int i=0;i<dynaLeakIds.length;i++) {
	    	AsseKnowDynaLeak dynaLeak = dynaLeakDao.find(new Integer(dynaLeakIds[i]));
	    	asseInfo = assetDao.find(assetCode);
	    	dynaLeak.setAsse(asseInfo);
	    	dynaLeak.setSeriLeve(secuLeves[i]);
	    	dynaLeakList.add(dynaLeak);
	    }
	    dynaLeakDao.batchSaveOrUpdate(dynaLeakList);
	}

}
