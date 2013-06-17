package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.AssetDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.StatVulnPoinDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.VulnAnalDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.service.VulnAnalService;

/**
 * 应用层 动态脆弱点分析Manager接口实现类.
 * 


 */
public class VulnAnalServiceImpl  implements VulnAnalService {

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
     * 批量保存/更新动态脆弱点
     * @param paraMaps
     * 参数Map
     * @param asseInfoProj
     * 测评项目
     **/
	public void batchSaveOrUpdate(Map paraMaps, AsseInfoProj asseInfoProj) {
		
		List<AsseKnowDynaVuln> dynaVulnPoints = new ArrayList<AsseKnowDynaVuln>();
		String[] dynaVulnPoinIds = (String[]) paraMaps.get("dynaVulnPoinIds");
		String assetCode = (String) paraMaps.get("assetCode");
		AsseInfoAsse asseInfoAsse = assetDao.find(assetCode);
		for(int i=0;i<dynaVulnPoinIds.length;i++) {
			AsseKnowDynaVuln dynaVulnPoint = vulnAnalDao.find(new Integer(dynaVulnPoinIds[i]));
			dynaVulnPoint.setAsseInfoProjId(asseInfoProj.getId());
			dynaVulnPoint.setAsse(asseInfoAsse);
			dynaVulnPoint.setAsseInfoBusiId(asseInfoAsse.getAsseInfoBusiId());
			dynaVulnPoints.add(dynaVulnPoint);
		}
		vulnAnalDao.batchSaveOrUpdate(dynaVulnPoints);
	}

	/**
     * 查询动态脆弱点
     * 
     * @param id
     *    动态脆弱点id
     * @return 动态脆弱点对象
     **/
	public AsseKnowDynaVuln find(Integer id) {
		
		return vulnAnalDao.find(id);
	}
	
	public Object[] findByDwr(String id) {
		return vulnAnalDao.findByDwr(new Integer(id));
	}

	/**
     * 查询动态脆弱点数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态脆弱点数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse) {
		return vulnAnalDao.getCount(asseInfoProj, asseInfoAsse);
	}
	/**
     * 查询动态脆弱点分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 分页记录列表
     **/
	public List listDynaVulnPoint(int startResult,int maxResult,AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse) {
        List<AsseKnowDynaVuln> list = vulnAnalDao.listDynaVulnPoint(startResult, maxResult, asseInfoProj,asseInfoAsse);
        return list;
	}

	/**
     * 删除动态脆弱点
     * 
     * @param dynaVulnPoint
     * 动态脆弱点
     **/
	public void remove(String dynaVulnPointId) {
		
		AsseKnowDynaVuln dynaVulnPoint = vulnAnalDao.find(new Integer(dynaVulnPointId));
		vulnAnalDao.remove(dynaVulnPoint);
	}

	/**
     * 批量删除动态脆弱点
     * 
     * @param dynaVulnPoints
     *    动态脆弱点列表
     **/
	public void remove(String[] dynaVulnPointIds) {
		
		List<AsseKnowDynaVuln> dynaVulnPoints = new ArrayList<AsseKnowDynaVuln>();
		for(int i=0;i<dynaVulnPointIds.length;i++) {
			AsseKnowDynaVuln dynaVulnPoint = new AsseKnowDynaVuln();
			dynaVulnPoint = vulnAnalDao.find(new Integer(dynaVulnPointIds[i]));
			dynaVulnPoints.add(dynaVulnPoint);
		}
		vulnAnalDao.remove(dynaVulnPoints);
	}

	/**
     * 保存/更新动态脆弱点
     * @param paraMap
     * 参数Map
     * @param dynaVulnPoint
     * 动态脆弱点
     **/
	public void saveOrUpdate(Map paraMap, AsseKnowDynaVuln dynaVulnPoint) {
		
		String assetCode = (String) paraMap.get("assetCode");
		AsseInfoAsse asseInfoAsse = assetDao.find(assetCode);
		dynaVulnPoint.setAsse(asseInfoAsse);
		dynaVulnPoint.setAsseInfoBusiId(asseInfoAsse.getAsseInfoBusiId());
		vulnAnalDao.saveOrUpdate(dynaVulnPoint);
	}

	/**
     * 检查是否已存在该脆弱点
     * @param asseInfoProj
     *            测评项目
     * @param statVulnPoinId
     *          脆弱点Id
     * @return 是否已存在
     **/
	public boolean checkExitDynaVulnPoint(AsseInfoProj asseInfoProj, String assetCode,
			Integer statVulnPoinId) {
		AsseInfoAsse asseInfoAsse = assetDao.find(assetCode);
		return vulnAnalDao.checkExitDynaVulnPoint(asseInfoProj.getId(), asseInfoAsse, statVulnPoinId);
	}

	/**
     * 查询动态脆弱点记录
     * @param asseInfoProj
     * @return 记录列表
     **/
	public List<AsseKnowDynaVuln> listDynaVulnPoint(String asseInfoProjId) {
		
		return vulnAnalDao.listDynaVulnPoint(new Integer(asseInfoProjId));
	}

	/**
     * 查询动态脆弱点记录
     * @param asseInfoProj
     * 测评项目编号
     * @param asseKnowStatVulnKindId
     * 脆弱点类别编号
     * @return 记录列表
     **/
	public List<AsseKnowDynaVuln> listDynaVulnPointByKind(
			String asseInfoProjId, String asseKnowStatVulnKindId) {
		
		return vulnAnalDao.listDynaVulnPointByKind(new Integer(asseInfoProjId), new Integer(asseKnowStatVulnKindId));
	}

	public List listDynaVulnPointByKindDwr(String asseInfoProjId,
			String asseKnowStatVulnKindId) {
		return vulnAnalDao.listDynaVulnPointByKindDwr(asseInfoProjId, asseKnowStatVulnKindId);
	}



}
