package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoPape;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 问卷Manager接口.
 * 


 */
public interface PapeService   {

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
    void batchSaveOrUpdate(String elemCode,AsseInfoProj asseInfoProj);
    
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
    AsseInfoPape find(String id);
    AsseInfoPape findbySecuId(Integer projId,String id);
    
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
    PageResult listAsseInfoPape(Page page,AsseInfoProj asseInfoProj);
   
    /**
     * 返回这个测评项目已选安全要素
     * @param asseInfoProjId
     *            测评项目Id
     * @return 已选安全要素列表
     **/
    List listSelectedStatSecuElems(String asseInfoProjId);
    
    /**
     * 返回这个测评项目已选安全要素对应的Pape
     * @param asseInfoProjId
     *            测评项目Id
     * @return 对应PapeMap
     **/
    Map relatedSecuElemPapeMap(String asseInfoProjId);
    
    /**
     * 查询下一题问题
     * @param asseInfoPape
     *            当前问题
     * @return 下一题问题
     **/
    AsseInfoPape getNextQuestion(AsseInfoPape asseInfoPape);
    
    /**
     * 查询已答问题列表
     * @param asseInfoProjId
     *   项目编号
     * @return 已答问题列表
     **/
    List<AsseInfoPape> listAnsweredPapes(String asseInfoProjId);
    
    /**
     * 查询已答问题列表
     * @param asseInfoProjId
     *   项目编号
     * @return 已答问题列表
     **/
    void saveDynaVulnPoint(String asseInfoProjId);
    
    /**
     * 根据问卷查询脆弱点列表
     * @param asseInfoProjId
     *           测评项目Id
    * @return 脆弱点列表
     **/
    List<AsseKnowStatVulnPoin> listVulnPoinByPaper(String asseInfoProjId);
}
