package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaVTARepoDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVTARepo;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaVTARepoService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 知识库动态V-T-A-R评估报告Manager实现类.
 * 


 */
public class DynaVTARepoServiceImpl  implements DynaVTARepoService {

	/** 
     * 知识库动态V-T-A-R评估报告数据访问对象接口
     */
	private DynaVTARepoDao dynaVTARepoDao;
	
	/**
     * @param vdynaVTARepoDao
     * 知识库动态V-T-A-R评估报告数据访问对象接口(Spring Ioc容器依赖注入)
     */
	public void setDynaVTARepoDao(DynaVTARepoDao vdynaVTARepoDao) {
		this.dynaVTARepoDao = vdynaVTARepoDao;
	}
	
	/**
     * 批量保存/更新V-T-A-R评估记录
     * @param dynaVTARepoList
     *    V-T-A-R评估记录集合
     **/
	public void batchSaveOrUpdate(List<AsseKnowDynaVTARepo> dynaVTARepoList) {
		
		dynaVTARepoDao.batchSaveOrUpdate(dynaVTARepoList);
	}

	/**
     * 查询项目V-T-A-R评估记录
     * @param id
     * V-T-A-R评估记录id
     * @return V-T-A-R评估记录对象
     **/
	public AsseKnowDynaVTARepo find(String id) {
		
		return dynaVTARepoDao.find(new Integer(id));
	}

	/**
     * 查询项目V-T-A-R评估记录数
     * @param asseInfoProj
     * 测评项目
     * @return 项目V-T-A-R评估记录数
     **/
	public int getCount(AsseInfoProj asseInfoProj) {
		
		return dynaVTARepoDao.getCount(asseInfoProj);
	}

	/**
     * 返回项目V-T-A-R评估记录列表
     * @param asseInfoProj
     * 测评项目
     * @return 项目V-T-A-R评估记录列表
     **/
	public List<AsseKnowDynaVTARepo> listDynaVTARepo(AsseInfoProj asseInfoProj) {
		
		return dynaVTARepoDao.listDynaVTARepo(asseInfoProj);
	}

	
    
	/**
     * 查询项目V-T-A-R评估记录分页记录
     * @param page
     * 分页对象
     * @param asseInfoProj
     * 测评项目
     * @return 分页记录列表
     **/
	public PageResult listDynaVTARepoPage(Page page, AsseInfoProj asseInfoProj) {
		
		int totalCount = getCount(asseInfoProj);
        page = PageUtil.createPage(page, totalCount);
        List list = dynaVTARepoDao.listDynaVTARepoPage(page, asseInfoProj);
        return new PageResult(page, list);
	}

	/**
     * 删除项目V-T-A-R评估记录
     * @param dynaVTARepo
     * 项目V-T-A-R评估记录
     **/
	public void remove(AsseKnowDynaVTARepo dynaVTARepo) {
		
		dynaVTARepoDao.remove(dynaVTARepo);
	}

	/**
     * 保存/更新项目V-T-A-R评估记录
     * @param dynaVTARepo
     * 项目V-T-A-R评估记录
     **/
	public void saveOrUpdate(AsseKnowDynaVTARepo dynaVTARepo) {
		
		dynaVTARepoDao.saveOrUpdate(dynaVTARepo);
	}

	/**
     * 检查是否已存在该项目资产评估要素列表
     * @param asseInfoProj
     * 测评项目
     * @return true/false
     **/
	public boolean checkExit(AsseInfoProj asseInfoProj) {
		
		boolean ret = false;
		if(asseInfoProj!=null) {
			List list = listDynaVTARepo(asseInfoProj);
			if(list!=null && list.size()>0) {
				ret = true;
			}
		}
		return ret;
	}

	
}
