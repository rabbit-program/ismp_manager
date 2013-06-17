package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaAsseValueDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseValue;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaAsseValueService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 知识库项目总体评估值Manager实现类.
 */
public class DynaAsseValueServiceImpl  implements DynaAsseValueService {

	/** 
     * 知识库项目总体评估值数据访问对象接口
     */
	private DynaAsseValueDao dynaAsseValueDao;
	
	/**
     * @param vdynaAsseValueDao
     * 知识库项目总体评估值数据访问对象接口(Spring Ioc容器依赖注入)
     */
	public void setDynaAsseValueDao(DynaAsseValueDao vdynaAsseValueDao) {
		this.dynaAsseValueDao = vdynaAsseValueDao;
	}
	
	/**
     * 查询项目总体评估值
     * @param id
     * 项目总体评估值id
     * @return 项目总体评估值对象
     **/
	public AsseKnowDynaAsseValue findById(String id) {
		
		return dynaAsseValueDao.find(new Integer(id));
	}

	

	/**
     * 查询项目总体评估值
     * @param projCode
     * 测评项目id
     * @return 项目总体评估值对象
     **/
	public AsseKnowDynaAsseValue find(String projCode) {
		
		return dynaAsseValueDao.find(projCode);
	}

	/**
     * 查询项目总体评估值记录数
     * @param projCode
     * 测评项目id
     * @return 项目总体评估值记录数
     **/
	public int getCount(String projCode) {
		
		return dynaAsseValueDao.getCount(projCode);
	}

	/**
     * 返回项目总体评估值
     * @param projCode
     * 测评项目id
     * @return 项目总体评估值列表
     **/
	public List<AsseKnowDynaAsseValue> listDynaAsseValue(String projCode) {
		
		return dynaAsseValueDao.listDynaAsseValue(projCode);
	}

	/**
     * 查询矩阵规则分页记录
     * @param page
     * 分页对象
     * @param projCode
     * 测评项目id
     * @return 分页记录列表
     **/
	public PageResult listDynaAsseValuePage(Page page, String projCode) {
		
		int totalCount = getCount(projCode);
        page = PageUtil.createPage(page, totalCount);
        List list = dynaAsseValueDao.listDynaAsseValuePage(page, projCode);
        return new PageResult(page, list);
	}

	/**
     * 删除矩阵规则
     * @param dynaAsseValue
     *        项目总体评估值
     **/
	public void remove(AsseKnowDynaAsseValue dynaAsseValue) {
		
		dynaAsseValueDao.remove(dynaAsseValue);
	}

	/**
     * 保存/更新项目总体评估值
     * 
     * @param dynaAsseValue
     *        项目总体评估值
     **/
	public void saveOrUpdate(AsseKnowDynaAsseValue dynaAsseValue) {
		
		dynaAsseValueDao.saveOrUpdate(dynaAsseValue);
	}

	/**
     * 检查是否已存在该项目总体评估值
     * @param projCode
     * 测评项目id
     * @return true/false
     **/
	public boolean checkExit(String projCode) {
		
		boolean ret = false;
		if(projCode!=null && !"".equals(projCode)) {
			AsseKnowDynaAsseValue dynaAsseValue = find(projCode);
			if(dynaAsseValue!=null) {
				ret = true;
			}
		}
		return ret;
	}

	public Object[] getExpQuesAndAdvice(String projCode) {
		
		return dynaAsseValueDao.getExpQuesAndAdvice(projCode);
	}

}
