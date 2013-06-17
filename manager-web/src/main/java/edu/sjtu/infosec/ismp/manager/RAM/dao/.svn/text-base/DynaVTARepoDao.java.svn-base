package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVTARepo;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 知识库动态V-T-A-R评估报告Dao访问接口.
 * 


 **/
public interface DynaVTARepoDao  {

	/**
     * 批量保存/更新V-T-A-R评估记录
     * @param dynaVTARepoList
     *    V-T-A-R评估记录集合
     **/
     void batchSaveOrUpdate(List<AsseKnowDynaVTARepo> dynaVTARepoList);
	
	/**
     * 保存/更新项目V-T-A-R评估记录
     * @param dynaVTARepo
     * 项目V-T-A-R评估记录
     **/
     void saveOrUpdate(AsseKnowDynaVTARepo dynaVTARepo);

    /**
     * 删除项目V-T-A-R评估记录
     * @param dynaVTARepo
     * 项目V-T-A-R评估记录
     **/
     void remove(AsseKnowDynaVTARepo dynaVTARepo);

    /**
     * 查询项目V-T-A-R评估记录
     * @param id
     * V-T-A-R评估记录id
     * @return V-T-A-R评估记录对象
     **/
     AsseKnowDynaVTARepo find(Integer id);
     
     
      
    /**
     * 返回项目V-T-A-R评估记录列表
     * @param asseInfoProj
     * 测评项目
     * @return 项目V-T-A-R评估记录列表
     **/
     List<AsseKnowDynaVTARepo> listDynaVTARepo(AsseInfoProj asseInfoProj);

    /**
     * 查询项目V-T-A-R评估记录数
     * @param asseInfoProj
     * 测评项目
     * @return 项目V-T-A-R评估记录数
     **/
     int getCount(AsseInfoProj asseInfoProj);
    
    /**
     * 查询项目V-T-A-R评估记录分页记录
     * @param page
     * 分页对象
     * @param asseInfoProj
     * 测评项目
     * @return 分页记录列表
     **/
     List<AsseKnowDynaVTARepo> listDynaVTARepoPage(Page page, AsseInfoProj asseInfoProj);
     
     List executeHQL(String hql);
}
