package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaAsseResuDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseResu;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaAsseResuService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 知识库项目动态评估结果Manager实现类.
 */
public class DynaAsseResuServiceImpl  implements DynaAsseResuService {

	/** 
     * 知识库项目动态评估结果数据访问对象接口
     */
	private DynaAsseResuDao dynaAsseResuDao;
	
	/**
     * @param vdicRiskMatrRuleDao
     * 知识库项目动态评估结果数据访问对象接口(Spring Ioc容器依赖注入)
     */
	public void setDynaAsseResuDao(DynaAsseResuDao vdynaAsseResuDao) {
		this.dynaAsseResuDao = vdynaAsseResuDao;
	}
	
	/**
     * 批量保存/更新项目动态评估结果
     * @param dynaAsseResuList
     *     项目动态评估结果集合
     **/
	public void batchSaveOrUpdate(List<AsseKnowDynaAsseResu> dynaAsseResuList) {
		
		dynaAsseResuDao.batchSaveOrUpdate(dynaAsseResuList);
	}

	
	/**
     * 查询项目动态评估结果
     * @param id
     * 动态评估结果id
     * @return 动态评估结果对象
     **/
	public AsseKnowDynaAsseResu find(String id) {
		
		return dynaAsseResuDao.find(new Integer(id));
	}

	/**
     * 查询项目总体评估值记录数
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目总体评估值记录数
     **/
	public int getCount(Integer asseInfoProjId) {
		
		return dynaAsseResuDao.getCount(asseInfoProjId);
	}

	/**
     * 返回项目动态评估结果列表
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目动态评估结果列表
     **/
	public List<AsseKnowDynaAsseResu> listDynaAsseResu(Integer asseInfoProjId) {
		
		return dynaAsseResuDao.listDynaAsseResu(asseInfoProjId);
	}

	/**
     * 查询项目动态评估结果分页记录
     * @param page
     * 分页对象
     * @param asseInfoProjId
     * 测评项目id
     * @return 分页记录列表
     **/
	public PageResult listDynaAsseResuPage(Page page, Integer asseInfoProjId) {
		
		int totalCount = getCount(asseInfoProjId);
        page = PageUtil.createPage(page, totalCount);
        List list = dynaAsseResuDao.listDynaAsseResuPage(page, asseInfoProjId);
        return new PageResult(page, list);
	}

	/**
     * 删除项目动态评估结果
     * @param dynaAsseResu
     *     项目动态评估结果
     **/
	public void remove(AsseKnowDynaAsseResu dynaAsseResu) {
		
		dynaAsseResuDao.remove(dynaAsseResu);
	}

	/**
     * 保存/更新项目动态评估结果
     * @param dynaAsseResu
     *     项目动态评估结果
     **/
	public void saveOrUpdate(AsseKnowDynaAsseResu dynaAsseResu) {
		
		dynaAsseResuDao.saveOrUpdate(dynaAsseResu);
	}

	/**
     * 检查是否已存在该项目动态评估结果列表
     * @param asseInfoProjId
     * 测评项目id
     * @return true/false
     **/
	public boolean checkExit(Integer asseInfoProjId) {
		
		boolean ret = false;
		if(asseInfoProjId!=null) {
		 List list = listDynaAsseResu(asseInfoProjId);
		 if(list!=null && list.size()>0) {
			 ret = true;
		 }
		}
		return ret;
	}

	/**
     * 统计此次项目资产风险值
     * @param asseInfoProjId
     * 测评项目id
     * @return 分页记录列表
     **/
	public List listRiskNumByAsse(Integer asseInfoProjId) {
		
		
		return dynaAsseResuDao.listRiskNumByAsse(asseInfoProjId);
	}

}
