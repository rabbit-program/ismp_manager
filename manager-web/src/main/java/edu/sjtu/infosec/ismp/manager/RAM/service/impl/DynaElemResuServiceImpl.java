package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaElemResuDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaElemResu;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaElemResuService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 知识库资产评估要素结果Manager实现类.
 * 


 */
public class DynaElemResuServiceImpl  implements DynaElemResuService {

	/** 
     * 知识库资产评估要素结果数据访问对象接口
     */
	private DynaElemResuDao dynaElemResuDao;
	
	/**
     * @param vdynaElemResuDao
     * 知识库资产评估要素结果数据访问对象接口(Spring Ioc容器依赖注入)
     */
	public void setDynaElemResuDao(DynaElemResuDao vdynaElemResuDao) {
		this.dynaElemResuDao = vdynaElemResuDao;
	}
	
	/**
     * 批量保存/更新项目资产评估要素
     * @param dynaElemResuList
     *    资产评估要素集合
     **/
	public void batchSaveOrUpdate(List<AsseKnowDynaElemResu> dynaElemResuList) {
		
		dynaElemResuDao.batchSaveOrUpdate(dynaElemResuList);
	}

	
	/**
     * 查询项目资产评估要素
     * @param id
     * 资产评估要素id
     * @return 资产评估要素对象
     **/
	public AsseKnowDynaElemResu find(String id) {
		
		return dynaElemResuDao.find(new Integer(id));
	}

	/**
     * 查询项目资产评估要素记录数
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目资产评估要素记录数
     **/
	public int getCount(String asseInfoProjId) {
		
		return dynaElemResuDao.getCount(new Integer(asseInfoProjId));
	}

	/**
     * 返回项目资产评估要素列表
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目资产评估要素列表
     **/
	public List<AsseKnowDynaElemResu> listDynaElemResu(String asseInfoProjId) {
		
		return dynaElemResuDao.listDynaElemResu(new Integer(asseInfoProjId));
	}

	/**
     * 查询项目资产评估要素分页记录
     * @param page
     * 分页对象
     * @param asseInfoProjId
     * 测评项目id
     * @return 分页记录列表
     **/
	public List<AsseKnowDynaElemResu> listDynaElemResuPage(Integer startResult, 
			Integer maxResult, String asseInfoProjId) {
		List list = dynaElemResuDao.listDynaElemResuPage(startResult,maxResult, new Integer(asseInfoProjId));
        return list;
	}

	/**
     * 删除项目资产评估要素
     * @param dynaElemResu
     *     项目资产评估要素
     **/
	public void remove(AsseKnowDynaElemResu dynaElemResu) {
		
		dynaElemResuDao.remove(dynaElemResu);
	}

	/**
     * 保存/更新项目资产评估要素
     * @param dynaElemResu
     *     项目资产评估要素
     **/
	public void saveOrUpdate(AsseKnowDynaElemResu dynaElemResu) {
		
		dynaElemResuDao.saveOrUpdate(dynaElemResu);
	}

	/**
     * 检查是否已存在该项目资产评估要素列表
     * @param asseInfoProjId
     * 测评项目id
     * @return true/false
     **/
	public boolean checkExit(String asseInfoProjId) {
		
		boolean ret = false;
		if(asseInfoProjId!=null && !"".equals(asseInfoProjId)) {
			List list = listDynaElemResu(asseInfoProjId);
			if(list!=null && list.size()>0) {
				ret = true;
			}
		}
		return ret;
	}

	/**
     * 统计风险值
     * @param asseInfoProjId
     * 测评项目id
     * @return 风险值
     **/
	public List statRiskValue(Integer asseInfoProjId) {
		
		return dynaElemResuDao.statRiskValue(asseInfoProjId);
	}

}
