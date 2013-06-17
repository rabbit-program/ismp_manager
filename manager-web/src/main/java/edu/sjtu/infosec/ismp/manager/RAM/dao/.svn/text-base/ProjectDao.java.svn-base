package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 数据层 测评项目Dao访问接口.
 */
public interface ProjectDao  {

    /**
     * 保存/更新测评项目信息
     *            测评项目
     */
     void saveOrUpdate(AsseInfoProj project);

    /**
     * 删除测评项目信息
     *            测评项目
     */
     void remove(AsseInfoProj project);

    /**
     * 查询测评项目
     *            测评项目编号
     */
     AsseInfoProj find(Integer projCode);

/*    *//**
     * 查询历次测评项目
     *            被测机构
     *//*
     List find(AsseInfoInst inst);*/

    /**
     * 查询测评项目记录数
     * @return 测评项目记录数
     */
	List<AsseInfoProj> findAll(String asseBeginTime, String asseEndTime,int startResult, int maxResult, int offcpers, Domain domain,String assePers, String secuLeve);

	List<AsseInfoProj> findAllByDomain(List<Domain> domainList,String asseBeginTime, String asseEndTime, int startResult,int maxResult, int offcpers, Domain domain, String assePers,String secuLeve);

	long findAllNum(String asseBeginTime, String asseEndTime, int offcpers,Domain domain, String assePers, String secuLeve);
	
	long findAllNumByDomain(List<Domain> domainList, String asseBeginTime,String asseEndTime, int offcpers,  String assePers,String secuLeve);

}
