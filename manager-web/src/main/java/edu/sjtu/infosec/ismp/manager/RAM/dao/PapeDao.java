package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoPape;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 问卷Dao访问接口.
 * 


 **/
public interface PapeDao  {

    /**
     * 保存/更新问卷问题
     * 
     * @param question
     * 问卷问题
     **/
    void saveOrUpdate(AsseInfoPape question);
    
    /**
     * 批量保存/更新问卷问题
     * 
     * @param question
     * 问卷问题
     **/
    void batchSaveOrUpdate(List questions);
    
    /**
     * 删除问卷问题
     * 
     * @param question
     * 问卷问题
     **/
    void remove(AsseInfoPape question);
    
    /**
     * 批量删除问卷问题
     * 
     * @param questionList
     *     问卷问题对象列表
     **/
    void remove(List<AsseInfoPape> questionList);
    
    /**
     * 查询问卷问题
     * 
     * @param id
     *    问卷问题id
     * @return 问卷问题对象
     **/
    AsseInfoPape find(Integer id);
    AsseInfoPape  findbySecuId(Integer projId,Integer id);
    /**
     * 查询问卷问题数量
     * @param asseInfoProj
     *            测评项目
     * @return 问卷问题数量
     **/
    int getCount(AsseInfoProj asseInfoProj);
    
    /**
     * 查询问卷问题分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @return 分页记录列表
     **/
    List<AsseInfoPape> listAsseInfoPape(Page page,AsseInfoProj asseInfoProj);
    
    /**
     * 查询下一题问题列表
     * @param asseInfoPape
     *            当前问题
     * @return 下一题问题列表
     **/
    List<AsseInfoPape> listNextPapes(AsseInfoPape asseInfoPape);
    
    /**
     * 查询下一题问题
     * @param asseInfoPape
     *   有跳转点的当前问题
     * @return 下一题问题
     **/
    AsseInfoPape getNextJumpAsseInfoPape(AsseInfoPape asseInfoPape);
    
    /**
     * 查询已答问题列表
     * @param asseInfoProjId
     *   项目编号
     * @return 已答问题列表
     **/
    List<AsseInfoPape> listAnsweredPapes(Integer asseInfoProjId);
    
    /**
     * 根据答案查询已答问题列表
     * @param asseInfoProjId
     *   项目编号
     * @param answer
     *   答案
     * @return 已答问题列表
     **/
    List<AsseInfoPape> listPapesByAnswer(Integer asseInfoProjId, String answer);
}
