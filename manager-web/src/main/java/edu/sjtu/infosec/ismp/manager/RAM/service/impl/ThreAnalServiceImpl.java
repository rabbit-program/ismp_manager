package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.AssetDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.StatThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.StatVulnPoinDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.ThreAnalDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.VulnAnalDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.RAM.service.ThreAnalService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 动态威胁分析Manager接口实现类.
 */
public class ThreAnalServiceImpl  implements ThreAnalService {

	/**
     * 动态脆弱点分析数据访问对象接口
     */
	private VulnAnalDao vulnAnalDao;
	
	/**
     * setVulnAnalDao
     * @param vulnanalDao 
     * 动态脆弱点分析数据访问对象接口
     **/
	public void setVulnAnalDao(VulnAnalDao vulnanalDao) {
		this.vulnAnalDao = vulnanalDao;
	}
	
	/**
     * 动态威胁分析数据访问对象接口
     */
	private ThreAnalDao threAnalDao;
	
	/**
     * setThreAnalDao
     * @param threanalDao 
     * 动态威胁分析数据访问对象接口
     **/
	public void setThreAnalDao(ThreAnalDao threanalDao) {
		this.threAnalDao = threanalDao;
	}
	
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
     * 静态威胁数据访问对象接口
     */
    private StatThreDao statThreDao;
    
    /**
     * setStatThreDao
     * @param statthreDao 
     * statthreDao
     **/
	public void setStatThreDao(StatThreDao statthreDao) {
		this.statThreDao = statthreDao;
	}

	/**
     * statVulnPoinDao
     **/
    private StatVulnPoinDao statVulnPoinDao;

    /**
     * setStatVulnPoinDao
     * @param statvulnPoinDao
     * 静态脆弱点Dao
     **/
    public void setStatVulnPoinDao(StatVulnPoinDao statvulnPoinDao) {
        this.statVulnPoinDao = statvulnPoinDao;
    }
    
	/**
     * 批量保存/更新动态威胁
     * 
     * @param dynaThres
     * 动态威胁列表
     **/
	public void batchSaveOrUpdate(List<AsseKnowDynaThre> dynaThres) {
		
		threAnalDao.batchSaveOrUpdate(dynaThres);
	}

	/**
     * 检查是否已存在该威胁
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param asseKnowStatThreId
     *            威胁Id
     * @return 是否已存在
     **/
	public boolean checkExitDynaVulnPoint(Integer asseInfoProjId,
			AsseInfoAsse asseInfoAsse, Integer asseKnowStatThreKindId, Integer asseKnowStatThreId) {
		
		return threAnalDao.checkExitDynaVulnPoint(asseInfoProjId, asseInfoAsse, asseKnowStatThreKindId, asseKnowStatThreId);
	}

	/**
     * 查询动态威胁
     * 
     * @param id
     *    动态威胁id
     * @return 动态威胁对象
     **/
	public AsseKnowDynaThre find(String id) {
		
		return threAnalDao.find(new Integer(id));
	}

	/**
     * 查询动态威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态威胁数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse) {
		
		return threAnalDao.getCount(asseInfoProj, asseInfoAsse);
	}

	/**
     * 查询动态威胁分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 分页记录列表
     **/
	public PageResult listDynaThrePage(Page page, AsseInfoProj asseInfoProj,
			AsseInfoAsse asseInfoAsse) {
		
		int totalCount = getCount(asseInfoProj, asseInfoAsse);
        page = PageUtil.createPage(page, totalCount);
        List<AsseKnowDynaThre> list = threAnalDao.listDynaThrePage(page, asseInfoProj, asseInfoAsse);
        return new PageResult(page, list);
	}

	/**
     * 删除动态威胁
     * 
     * @param dynaThre
     * 动态威胁
     **/
	public void remove(AsseKnowDynaThre dynaThre) {
		
		threAnalDao.remove(dynaThre);
	}

	/**
     * 批量删除动态威胁
     * 
     * @param dynaThres
     *    动态威胁列表
     **/
	public void remove(String[] dynaThreIds) {
		List<AsseKnowDynaThre> dynaThres = new ArrayList<AsseKnowDynaThre>();
		for(int i=0;i<dynaThreIds.length;i++) {
			AsseKnowDynaThre dynaThre = new AsseKnowDynaThre();
			dynaThre = find(dynaThreIds[i]);
			dynaThres.add(dynaThre);
		}
		threAnalDao.remove(dynaThres);
	}

	/**
     * 保存/更新动态威胁
     * 
     * @param dynaThre
     * 动态威胁
     **/
	public void saveOrUpdate(AsseKnowDynaThre dynaThre) {
		
		threAnalDao.saveOrUpdate(dynaThre);
	}

	/**
     * 脆弱点分析后，返回该测评项目动态威胁列表
     * @param asseInfoProjId
     *            测评项目Id
     * @return 是否已存在
     **/
	public List listDynaThresByDynaVuln(String asseInfoProjId) {
		
		AsseKnowDynaVuln dynaVuln = null;
		AsseKnowStatVulnPoin statVulnPoin = null;
		AsseKnowStatThre statThre = null;
		List<AsseKnowDynaThre> dynaThreList = new ArrayList<AsseKnowDynaThre>();
		List<AsseKnowDynaVuln> dynaVulnList = vulnAnalDao.listDynaVulnPoint(new Integer(asseInfoProjId));
		if(dynaVulnList!=null && dynaVulnList.size()>0) {
		 for(int i=0;i<dynaVulnList.size();i++) {
			dynaVuln = dynaVulnList.get(i);
			int statKnowVulnPointId = dynaVuln.getAsseKnowStatVulnPoinId();
			statVulnPoin = statVulnPoinDao.find(new Integer(statKnowVulnPointId));
			List<AsseKnowStatThre> statThreList = null;
			if(statVulnPoin!=null && !"".equals(statVulnPoin)){
				statThreList = statThreDao.listStatThreByVulnPoin(statVulnPoin);
			}
			if(statThreList!=null && statThreList.size()>0) {
			 for(int j=0;j<statThreList.size();j++) {
				 statThre = statThreList.get(j);
			     AsseKnowDynaThre dynaThre = new AsseKnowDynaThre();
			     dynaThre.setAsse(dynaVuln.getAsse());
			     dynaThre.setAsseInfoProjId(dynaVuln.getAsseInfoProjId());
			     dynaThre.setDynaVuln(dynaVuln);
			     dynaThre.setAsseKnowStatThreId(statThre.getId());
			     dynaThre.setAsseKnowStatThreKindId(statThre.getThreKind().getId());
			     dynaThre.setThreCode(statThre.getThreCode());
			     dynaThre.setPossibility("L");
			     dynaThreList.add(dynaThre);
			 }
			}
		   }
		}
		return dynaThreList;
	}

	/**
     * 脆弱点分析后，批量保存该测评项目动态威胁点
     * @param asseInfoProjId
     *            测评项目Id
     **/
	@SuppressWarnings("unchecked")
	public void batchSaveDynaThres(String asseInfoProjId) {
		
		List<AsseKnowDynaThre> dynaThresByDynaVulnList = listDynaThresByDynaVuln(asseInfoProjId);
		List<AsseKnowDynaThre> exitDynaThres = threAnalDao.listDynaThre(new Integer(asseInfoProjId));
		List<AsseKnowDynaThre> dynaThreList = new ArrayList<AsseKnowDynaThre>();
		for(int i=0;i<dynaThresByDynaVulnList.size();i++) {
			AsseKnowDynaThre dynaThre = dynaThresByDynaVulnList.get(i);
			if(exitDynaThres!=null && exitDynaThres.size()>0) {
				boolean flag = true;
				for(int j=0;j<exitDynaThres.size();j++) {
					AsseKnowDynaThre exitDynaThre = exitDynaThres.get(j);
					
					if((exitDynaThre.getAsseKnowStatThreId().intValue()==dynaThre.getAsseKnowStatThreId().intValue())
							&&(exitDynaThre.getDynaVuln().equals(dynaThre.getDynaVuln()))) {
						flag = false;
						break;
					}
					
				}
				System.out.println(flag);
				if(flag) {
					dynaThreList.add(dynaThre);
				}
		    }else{
			    dynaThreList.add(dynaThre);
		    }
		}
		//threAnalDao.remove(exitDynaThres);
		threAnalDao.batchSaveOrUpdate(dynaThreList);
	}

	/**
     * 批量进行威胁与资产关联
     * @param paraMaps
     * 参数Map
     * @param asseInfoProj
     * 测评项目
     **/
	public void relateToAssert(Map paraMaps, AsseInfoProj asseInfoProj) {
		
		List<AsseKnowDynaThre> dynaThreList = new ArrayList<AsseKnowDynaThre>();
		String[] dynaThreIds = (String[]) paraMaps.get("dynaThreIds");
		String assetCode = (String) paraMaps.get("assetCode");
		AsseInfoAsse asseInfoAsse = assetDao.find(assetCode);
		for(int i=0;i<dynaThreIds.length;i++) {
			AsseKnowDynaThre dynaThre = threAnalDao.find(new Integer(dynaThreIds[i]));
		    AsseKnowDynaVuln asseKnowDynaVuln = dynaThre.getDynaVuln();
	        asseKnowDynaVuln.setAsse(asseInfoAsse);
	        dynaThre.setDynaVuln(asseKnowDynaVuln);
			dynaThre.setAsse(asseInfoAsse);
			dynaThre.setAsseInfoProjId(asseInfoProj.getId());
			dynaThreList.add(dynaThre);
		}
		threAnalDao.batchSaveOrUpdate(dynaThreList);
	}

	/**
     * 查询脆弱点威胁关联分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param dynaVulnPointId
     *       动态脆弱点Id
     * @return 分页记录列表
     **/
	public PageResult listDynaVulnThrePage(Page page,
			AsseInfoProj asseInfoProj, String dynaVulnPointId) {
		    
		    AsseKnowDynaVuln dynaVulnPoint = null;
		    if(dynaVulnPointId!=null && !"".equals(dynaVulnPointId)) {
		         dynaVulnPoint = vulnAnalDao.find(new Integer(dynaVulnPointId));
		    }
	        int totalCount = getCount(asseInfoProj, dynaVulnPointId);
            page = PageUtil.createPage(page, totalCount);
		    List<AsseKnowDynaThre> list = threAnalDao.listDynaVulnThrePage(page, asseInfoProj, dynaVulnPoint);
		    return new PageResult(page, list);
	}

	/**
     * 查询动态威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param dynaVulnPointId
     *       动态脆弱点Id
     * @return 动态威胁数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, String dynaVulnPointId) {
		
		AsseKnowDynaVuln dynaVulnPoint = null;
		if(dynaVulnPointId!=null && !"".equals(dynaVulnPointId)) {
		     dynaVulnPoint = vulnAnalDao.find(new Integer(dynaVulnPointId));
		}
		return threAnalDao.getCount(asseInfoProj, dynaVulnPoint);
	}

	/**
     * 批量进行动态威胁与动态脆弱点关联
     * @param paraMaps
     * 参数Map
     * @param asseInfoProj
     * 测评项目
     **/
	public void relateToVuln(Map paraMaps, AsseInfoProj asseInfoProj) {
		
		List<AsseKnowDynaThre> dynaThreList = new ArrayList<AsseKnowDynaThre>();
		String[] dynaThreIds = (String[]) paraMaps.get("dynaThreIds");
		String vulnId = (String) paraMaps.get("vulnId");
		AsseKnowDynaVuln dynaVuln = vulnAnalDao.find(new Integer(vulnId));
		for(int i=0;i<dynaThreIds.length;i++) {
			AsseKnowDynaThre dynaThre = threAnalDao.find(new Integer(dynaThreIds[i]));
			dynaThre.setDynaVuln(dynaVuln);
			dynaThre.setAsse(dynaVuln.getAsse());
			dynaThre.setAsseInfoProjId(asseInfoProj.getId());
			dynaThreList.add(dynaThre);
		}
		threAnalDao.batchSaveOrUpdate(dynaThreList);
	}

	public Object[] findByDwr(String id) {
		
		return threAnalDao.findByDwr(id);
	}

	public List<AsseKnowDynaThre> findAll(int startResult, int maxResult,
			AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse) {
		List<AsseKnowDynaThre> list = threAnalDao.findAll(startResult,maxResult, asseInfoProj, asseInfoAsse);
		return list;
	}

	public List<AsseKnowDynaThre> listAllByVuln(int startResult, int maxResult,
			AsseInfoProj asseInfoProj, String vulnIdSelect) {
		AsseKnowDynaVuln dynaVulnPoint = null;
	    if(vulnIdSelect!=null && !"".equals(vulnIdSelect)) {
	         dynaVulnPoint = vulnAnalDao.find(new Integer(vulnIdSelect));
	    }
	    List<AsseKnowDynaThre> list = threAnalDao.listAllByVuln(startResult,maxResult, asseInfoProj, dynaVulnPoint);
		return list;
	}

	public List<AsseKnowDynaThre> ListThreByVulnId(int vulnId) {
		 List<AsseKnowDynaThre> list = threAnalDao.ListThreByVulnId(vulnId);
		return list;
	}


}
