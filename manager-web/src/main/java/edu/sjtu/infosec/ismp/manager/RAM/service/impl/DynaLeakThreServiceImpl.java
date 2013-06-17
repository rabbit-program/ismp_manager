package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaLeakDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaLeakThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.StatCVEThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeakThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatCVEThre;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakThreService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 动态资产漏洞威胁分析Manager接口实现类.
 * 
 */
public class DynaLeakThreServiceImpl  implements DynaLeakThreService {

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
     * 动态资产漏洞威胁分析数据访问对象接口
     */
	private DynaLeakThreDao dynaLeakThreDao;
	
	
	/**
     * setDynaLeakThreDao
     * @param dynaleakThreDao 
     * dynaLeakThreDao
     **/
	public void setDynaLeakThreDao(DynaLeakThreDao dynaleakThreDao) {
		this.dynaLeakThreDao = dynaleakThreDao;
	}

	/**
     * 知识库静态漏洞威胁数据访问对象接口
     */
    private StatCVEThreDao statCVEThreDao;
    
    /**
     * setStatCVEThreDao
     * @param statcVEThreDao 
     * statCVEThreDao
     **/
    public void setStatCVEThreDao(StatCVEThreDao statcVEThreDao) {
		this.statCVEThreDao = statcVEThreDao;
	}
    
	/**
     * 批量保存/更新动态资产漏洞威胁
     * 
     * @param dynaLeakThreList
     * 动态资产漏洞列表
     **/
	public void batchSaveOrUpdate(List<AsseKnowDynaLeakThre> dynaLeakThreList) {
		
		dynaLeakThreDao.batchSaveOrUpdate(dynaLeakThreList);
	}

	/**
     * 检查是否已存在该资产漏洞威胁
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param asseKnowStatCveThreId
     *      静态威胁Id
     * @return 是否已存在
     **/
	public boolean checkExitDynaLeakThre(Integer asseInfoProjId,
			AsseInfoAsse asseInfoAsse, String asseKnowStatCveThreId) {
		
		return dynaLeakThreDao.checkExitDynaLeakThre(asseInfoProjId, asseInfoAsse, new Integer(asseKnowStatCveThreId));
	}

	/**
     * 查询动态资产漏洞威胁
     * 
     * @param id
     *    动态资产漏洞威胁id
     * @return 动态资产漏洞威胁对象
     **/
	public AsseKnowDynaLeakThre find(String id) {
		
		return dynaLeakThreDao.find(new Integer(id));
	}

	/**
     * 查询动态资产漏洞威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态资产漏洞数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, List<AsseInfoAsse> asseInfoAsse) {
		
		return dynaLeakThreDao.getCount(asseInfoProj, asseInfoAsse);
	}

	/**
     * 查询动态资产漏洞威胁记录
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞记录列表
     **/
	public List<AsseKnowDynaLeakThre> listDynaLeakThre(AsseInfoProj asseInfoProj) {
		
		return dynaLeakThreDao.listDynaLeakThre(asseInfoProj);
	}

	/**
     * 保存/更新动态资产漏洞威胁
     * 
     * @param dynaLeakThre
     * 动态资产漏洞威胁
     **/
	public void saveOrUpdate(AsseKnowDynaLeakThre dynaLeakThre) {
		
		dynaLeakThreDao.saveOrUpdate(dynaLeakThre);
	}

	/**
     * 检查是否已存在该资产漏洞
     * @param asseInfoProj
     *            测评项目
     * @return 是否已存在
     **/
	public boolean checkExitDynaLeakThreList(AsseInfoProj asseInfoProj) {
		
		boolean ret = false;
		List list = listDynaLeakThre(asseInfoProj);
		if(list!=null && list.size()>0) {
			ret = true;
		}
		return ret;
	}

	/**
     * 保存动态资产漏洞威胁
     * @param asseInfoProj
     *            测评项目
     **/
	public void saveDynaLeakThre(AsseInfoProj asseInfoProj) {
		
		boolean exit = checkExitDynaLeakThreList(asseInfoProj);
		if(!exit) {
			List<AsseKnowDynaLeak> dynaLeakList = dynaLeakDao.listDynaLeak(asseInfoProj);
			if(dynaLeakList!=null && dynaLeakList.size()>0) {
				AsseKnowDynaLeak dynaLeak = null;
				List statCVEThreList = null;
				AsseKnowStatCVEThre statCVEThre = null;
				List<AsseKnowDynaLeakThre> dynaLeakThreList = new ArrayList<AsseKnowDynaLeakThre>();
				for(int i=0;i<dynaLeakList.size();i++) {
					dynaLeak = dynaLeakList.get(i);
					String cveId = dynaLeak.getCveId();
					if(cveId!=null && !"".equals(cveId)){
					 statCVEThreList = statCVEThreDao.find(cveId);
					}
					System.out.println(statCVEThreList);
					if(statCVEThreList==null || statCVEThreList.size()<=0) {
						AsseKnowDynaLeakThre dynaLeakThre = new AsseKnowDynaLeakThre();
						dynaLeakThre.setAsse(dynaLeak.getAsse());
						dynaLeakThre.setAsseInfoProjId(asseInfoProj.getId());
						dynaLeakThre.setDynaLeak(dynaLeak);
						dynaLeakThre.setPossibility(dynaLeak.getSeriLeve());
						dynaLeakThreList.add(dynaLeakThre);
				    }else if(statCVEThreList!=null && statCVEThreList.size()>0){
					  for(int j=0;j<statCVEThreList.size();j++) {
					    statCVEThre = (AsseKnowStatCVEThre) statCVEThreList.get(j);
					    AsseKnowDynaLeakThre dynaLeakThre = new AsseKnowDynaLeakThre();
					    dynaLeakThre.setAsse(dynaLeak.getAsse());
						dynaLeakThre.setAsseInfoProjId(asseInfoProj.getId());
						dynaLeakThre.setDynaLeak(dynaLeak);
						dynaLeakThre.setPossibility(dynaLeak.getSeriLeve());
					    dynaLeakThre.setAsseKnowStatCveThreId(statCVEThre.getId());
						dynaLeakThre.setAsseKnowStatThreKindId(statCVEThre.getThreKind().getId());
						dynaLeakThre.setThreCode(statCVEThre.getThreCode());
						dynaLeakThreList.add(dynaLeakThre);
					  }
				  }
				}
				dynaLeakThreDao.batchSaveOrUpdate(dynaLeakThreList);
			}
		}
	}

	/**
     * 漏洞与威胁关联
     * @param paraMap
     * 参数Map
     * @param asseInfoProj
     *            测评项目
     **/
	public void relateLeakToThre(Map paraMap, AsseInfoProj asseInfoProj) {
		
		List<AsseKnowDynaLeakThre> dynaLeakList = new ArrayList<AsseKnowDynaLeakThre>();
		String[] leakThreIds = (String[]) paraMap.get("leakThreIds");
	    String[] leakThreKindIds = (String[]) paraMap.get("leakThreKindIds");
	    String[] leakCveThreIds = (String[]) paraMap.get("leakCveThreIds");
	    String[] dynaLeakThreLeves = (String[]) paraMap.get("dynaLeakThreLeves");
	    for(int i=0;i<leakThreIds.length;i++) {
	    	AsseKnowDynaLeakThre dynaLeakThre = dynaLeakThreDao.find(new Integer(leakThreIds[i]));
	    	dynaLeakThre.setAsseKnowStatThreKindId(new Integer(leakThreKindIds[i]));
	    	dynaLeakThre.setAsseKnowStatCveThreId(new Integer(leakCveThreIds[i]));
	    	dynaLeakThre.setPossibility(dynaLeakThreLeves[i]);
	    	dynaLeakList.add(dynaLeakThre);
	    }
	    batchSaveOrUpdate(dynaLeakList);
	}


	public List<AsseKnowDynaLeakThre> listDynaLeak(int startResult1,
			int maxResult1, AsseInfoProj asseInfoProj,
			List<AsseInfoAsse> asseInfo) {
        List<AsseKnowDynaLeakThre> list = dynaLeakThreDao.listDynaLeakThrePage(startResult1,maxResult1, asseInfoProj, asseInfo);
        return list;
	}

	public List<AsseKnowDynaLeakThre> listByDynaLeakId(int dynaLeakId) {
		 List<AsseKnowDynaLeakThre> list = dynaLeakThreDao.listByDynaLeakId(dynaLeakId);
		return list;
	}
	
	
	

}
