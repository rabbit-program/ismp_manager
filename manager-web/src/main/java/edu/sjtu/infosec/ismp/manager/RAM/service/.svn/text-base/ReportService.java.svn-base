package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseValue;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 应用层 报表生成Manager接口.
 * 


 */
public interface ReportService {

	/**
     * 总体报告
     * @param projId
     * 测评机构Id
     * @return 
     * 总风险点个数、高级别风险个数、中级别风险个数、低级别风险个数
     **/
	Map totalReport(Integer projId);
	
	/**
     * 保存项目总体评估对象
     * @param dynaAsseValue
     * 项目总体评估对象
     **/
	void saveOrUpdateDynaAsseValue(AsseKnowDynaAsseValue dynaAsseValue);
	
	/**
     * 查询项目总体评估对象
     * @param projId
     * 测评机构Id
     * @return 项目总体评估对象
     **/
	AsseKnowDynaAsseValue findByProjId(Integer projId);
	
	/**
     * 各委办局业务及支撑资产清单
     * @param inst
     * 委办局对象
     * @return 业务名称、业务重要性和对应资产
     **/
	List businessImportanceReport(Domain domain);
	
	/**
     * 各委办局的资产及其重要性报告
     * @param inst
     * 委办局对象
     * @return 
     * 不同重要等级资产统计饼状图所需数据
     * 资产列表
     **/
	Map assetImportanceReport(Domain domain);
	
	/**
     * 各委办局关键资产的脆弱点及其严重性报告
     * @param inst
     * 测评机构
     * @param asseInfoProj
     * 测评项目
     * @return 
     * 不同严重等级的漏洞数量统计饼状图所需数据
     * 不同资产各等级漏洞数目统计柱状图所需数据
     * 各资产的漏洞列表
     * 各漏洞的详细信息列表
     **/
	Map vulnSeriousReport(AsseInfoProj asseInfoProj);
	
	/**
     * 各委办局面临的威胁及其可能性报告
     * @param projId
     * 测评机构Id
     * @return 
     * 不同可能性等级的威胁数量统计饼状图所需数据
     * 不同资产各等级威胁数目统计柱状图所需数据
     * 各资产的威胁列表
     * 各威胁的详细信息列表
     **/
	Map threatPossibilityReport(AsseInfoProj asseInfoProj);
	
	/**
     * 风险评估分析报告
     * @param asseInfoProj
     * 测评机构
     * @return 
     * 不同风险等级的数量统计饼状图所需数据
     * 重要资产的不同等级风险统计柱状图所需数据
     * 各资产的风险列表
     **/
	Map assessmentAnalysisReport(AsseInfoProj asseInfoProj);
	
	void executeSend(AsseInfoProj asseInfoProj);
	
	void saveAlert(AsseInfoProj asseInfoProj)throws Exception ;
	
	List getDicCpKindList();
}
