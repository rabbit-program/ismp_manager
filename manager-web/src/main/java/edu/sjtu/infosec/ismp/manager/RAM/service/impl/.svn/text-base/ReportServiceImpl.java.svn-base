package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;

import edu.sjtu.infosec.ismp.manager.RAM.dao.AssetDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.BusinessDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DicCpKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaAsseValueDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaElemResuDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaLeakDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaLeakThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaVTARepoDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.LeakScanDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.StatCVEThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.StatThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.StatVulnPoinDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.ThreAnalDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.VulnAnalDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoBusi;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseValue;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaElemResu;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeakThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVTARepo;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatCVEThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseResuHandOn;
import edu.sjtu.infosec.ismp.manager.RAM.service.ReportService;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 应用层 报表生成Manager实现类.
 */
public class ReportServiceImpl  implements ReportService {

    private AssetDao assetDao;
    
    private DicCpKindDao dicCpKindDao;
    /**
     * 业务信息数据访问对象接口
     */
    private BusinessDao businessDao;
    /** 
     * 知识库项目总体评估值数据访问对象接口
     */
	private DynaAsseValueDao dynaAsseValueDao;
	/** 
     * 知识库资产评估要素结果数据访问对象接口
     */
	private DynaElemResuDao dynaElemResuDao;
	private LeakScanDao leakScanDao;
	
    /**
     * 动态资产漏洞分析数据访问对象接口
     */
    private DynaLeakDao dynaLeakDao;
    
	/**
     * 动态资产漏洞威胁分析数据访问对象接口
     */
	private DynaLeakThreDao dynaLeakThreDao;
	
	/** 
     * 知识库动态V-T-A-R评估报告数据访问对象接口
     */
	private DynaVTARepoDao dynaVTARepoDao;
	/**
     * 动态脆弱点分析数据访问对象接口
     */
	private VulnAnalDao vulnAnalDao;
	/**
     * 动态威胁分析数据访问对象接口
     */
	private ThreAnalDao threAnalDao;
    private StatVulnPoinDao statVulnPoinDao;
    /**
     * 静态威胁数据访问对象接口
     */
    private StatThreDao statThreDao;
	/**
     * 知识库静态漏洞威胁数据访问对象接口
     */
    private StatCVEThreDao statCVEThreDao;
    

    
    public void setAssetDao(AssetDao assetDao) {
		this.assetDao = assetDao;
	}

	public void setDicCpKindDao(DicCpKindDao dicCpKindDao) {
		this.dicCpKindDao = dicCpKindDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}

	public void setDynaAsseValueDao(DynaAsseValueDao dynaAsseValueDao) {
		this.dynaAsseValueDao = dynaAsseValueDao;
	}

	public void setDynaElemResuDao(DynaElemResuDao dynaElemResuDao) {
		this.dynaElemResuDao = dynaElemResuDao;
	}

	public void setLeakScanDao(LeakScanDao leakScanDao) {
		this.leakScanDao = leakScanDao;
	}

	public void setDynaLeakDao(DynaLeakDao dynaLeakDao) {
		this.dynaLeakDao = dynaLeakDao;
	}

	public void setDynaLeakThreDao(DynaLeakThreDao dynaLeakThreDao) {
		this.dynaLeakThreDao = dynaLeakThreDao;
	}

	public void setDynaVTARepoDao(DynaVTARepoDao dynaVTARepoDao) {
		this.dynaVTARepoDao = dynaVTARepoDao;
	}

	public void setVulnAnalDao(VulnAnalDao vulnAnalDao) {
		this.vulnAnalDao = vulnAnalDao;
	}

	public void setThreAnalDao(ThreAnalDao threAnalDao) {
		this.threAnalDao = threAnalDao;
	}

	public void setStatVulnPoinDao(StatVulnPoinDao statVulnPoinDao) {
		this.statVulnPoinDao = statVulnPoinDao;
	}

	public void setStatThreDao(StatThreDao statThreDao) {
		this.statThreDao = statThreDao;
	}

	public void setStatCVEThreDao(StatCVEThreDao statCVEThreDao) {
		this.statCVEThreDao = statCVEThreDao;
	}
    
   /* private ReportSenderWrapper assessmentReportSenderWrapper;
    
	
	public void setAssessmentReportSenderWrapper(ReportSenderWrapper vassessmentReportSenderWrapper) {
		this.assessmentReportSenderWrapper = vassessmentReportSenderWrapper;
	}
	
	//private SendAlertDao sendalertDao;
	
	*/


	

	/**
     * 风险评估分析报告
     * @param asseInfoProj
     * 测评机构
     * @return 
     * 不同风险等级的数量统计饼状图所需数据
     * 重要资产的不同等级风险统计柱状图所需数据
     * 各资产的风险列表
     **/
	@SuppressWarnings("unchecked")
	public Map assessmentAnalysisReport(AsseInfoProj asseInfoProj) {
		
		Map reportMap = new HashMap();
		List riskValuList = dynaElemResuDao.statRiskValue(asseInfoProj.getId());
		Long HighRiskNum = new Long(0);
		Long MiddRiskNum = new Long(0);
		Long LowRiskNum = new Long(0);
        
        if(riskValuList!=null && riskValuList.size()>0) {
            Object[] object = (Object[]) riskValuList.get(0);
               //饼状图所需数据
               HighRiskNum = (Long) object[0];
               MiddRiskNum = (Long) object[1];
               LowRiskNum = (Long) object[2];
               System.out.println("高级别风险个数:"+HighRiskNum);
               System.out.println("中级别风险个数:"+MiddRiskNum);
               System.out.println("低级别风险个数:"+LowRiskNum);
        }
        
        List dynaElemResuList = dynaElemResuDao.listDynaElemResu(asseInfoProj.getId());
        if(dynaElemResuList!=null && dynaElemResuList.size()>0) {
        	//柱状图所需数据
        	double[][] asseData = new double[3][dynaElemResuList.size()];
   	        String[] asseDataRowKeys = {"高风险数目", "中风险数目","低风险数目"};
   	        String[] asseDataColumnKeys = new String[dynaElemResuList.size()];
        	for(int i=0;i<dynaElemResuList.size();i++) {
        		AsseKnowDynaElemResu dynaElemResu = (AsseKnowDynaElemResu) dynaElemResuList.get(i);
        		AsseInfoAsse asseInfo = dynaElemResu.getAsse();
        		asseDataColumnKeys[i] = asseInfo.getAssetName();
        		Integer AsseHighRiskNum = dynaElemResuDao.statHighRiskAsse(asseInfoProj.getId(), asseInfo);
        		Integer AsseMiddRiskNum = dynaElemResuDao.statMiddRiskAsse(asseInfoProj.getId(), asseInfo);
        		Integer AsseLowRiskNum = dynaElemResuDao.statLowRiskAsse(asseInfoProj.getId(), asseInfo);
        		asseData[0][i] = AsseHighRiskNum.doubleValue();
        		asseData[1][i] = AsseMiddRiskNum.doubleValue();
        		asseData[2][i] = AsseLowRiskNum.doubleValue();
        	}
        	reportMap.put("asseData", asseData);
   		    reportMap.put("asseDataRowKeys", asseDataRowKeys);
   		    reportMap.put("asseDataColumnKeys", asseDataColumnKeys);
        }
        //各资产的风险列表
        List repoList = dynaVTARepoDao.listDynaVTARepo(asseInfoProj);
        
        reportMap.put("HighRiskNum", HighRiskNum);
        reportMap.put("MiddRiskNum", MiddRiskNum);
        reportMap.put("LowRiskNum", LowRiskNum);
        reportMap.put("repoList", repoList);
        
		return reportMap;
		
	}

	/**
     * 各委办局的资产及其重要性报告
     * @param inst
     * 委办局对象
     * @return 
     * 不同重要等级资产统计饼状图所需数据
     * 资产列表
     **/
	@SuppressWarnings("unchecked")
	public Map assetImportanceReport(Domain domain) {
		
		Map reportMap = new HashMap();
		List assetList = assetDao.listAsse(domain);
		reportMap.put("assetList", assetList);
		Long HighAsseImpoNum = assetDao.statHighImpoAsse(domain);
		Long MiddAsseImpoNum = assetDao.statMiddImpoAsse(domain);
		Long LowAsseImpoNum = assetDao.statLowImpoAsse(domain);
		
		reportMap.put("HighAsseImpoNum", HighAsseImpoNum);
		reportMap.put("MiddAsseImpoNum", MiddAsseImpoNum);
		reportMap.put("LowAsseImpoNum", LowAsseImpoNum);
		reportMap.put("assetList", assetList);
		return reportMap;
	}

	/**
     * 保存项目总体评估对象
     * @param dynaAsseValue
     * 项目总体评估对象
     **/
	public void saveOrUpdateDynaAsseValue(AsseKnowDynaAsseValue dynaAsseValue) {
		
		dynaAsseValueDao.saveOrUpdate(dynaAsseValue);
	}

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
	@SuppressWarnings("unchecked")
	public Map threatPossibilityReport(AsseInfoProj asseInfoProj) {
		
		Map reportMap = new HashMap();
		List dynaThreList = new ArrayList();
		List dynaLeakThreList = new ArrayList();
		
		//资产威胁列表
		List dynaThres = threAnalDao.listDynaThre(asseInfoProj.getId());
		if(dynaThres!=null && dynaThres.size()>0) {
			for(int i=0;i<dynaThres.size();i++) {
				Object[] object = new Object[2];
				AsseKnowDynaThre dynaThre = (AsseKnowDynaThre) dynaThres.get(i);
				AsseKnowStatThre statThre = new AsseKnowStatThre();
				if(dynaThre.getAsseKnowStatThreId()!=null) {
				   statThre = statThreDao.find(dynaThre.getAsseKnowStatThreId());
				}
				object[0] = dynaThre;
				object[1] = statThre;
				dynaThreList.add(object);
			}
		}
		
		//漏洞威胁列表
		List dynaLeakThres = dynaLeakThreDao.listDynaLeakThre(asseInfoProj);
		if(dynaLeakThres!=null && dynaLeakThres.size()>0) {
			for(int i=0;i<dynaLeakThres.size();i++) {
				Object[] object = new Object[2];
				AsseKnowDynaLeakThre dynaLeakThre = (AsseKnowDynaLeakThre) dynaLeakThres.get(i);
				AsseKnowStatCVEThre statCVEThre = new AsseKnowStatCVEThre();
				if(dynaLeakThre.getAsseKnowStatCveThreId()!=null 
						&& dynaLeakThre.getAsseKnowStatCveThreId().intValue()!=0) {
					statCVEThre = statCVEThreDao.find(dynaLeakThre.getAsseKnowStatCveThreId());
				}
				object[0] = dynaLeakThre;
				object[1] = statCVEThre;
				dynaLeakThreList.add(object);
			}
		}
		
		Long HighPossDynaThreNum = threAnalDao.statHighPossDynaThre(asseInfoProj.getId());
		Long MiddPossDynaThreNum = threAnalDao.statMiddPossDynaThre(asseInfoProj.getId());
		Long LowPossDynaThreNum = threAnalDao.statLowPossDynaThre(asseInfoProj.getId());
		Long HighPossDynaLeakThreNum = dynaLeakThreDao.statHighPossDynaLeakThre(asseInfoProj.getId());
		Long MiddPossDynaLeakThreNum = dynaLeakThreDao.statMiddPossDynaLeakThre(asseInfoProj.getId());
		Long LowPossDynaLeakThreNum = dynaLeakThreDao.statLowPossDynaLeakThre(asseInfoProj.getId());
		
		//饼图数据
		Long HighThreNum = HighPossDynaThreNum+HighPossDynaLeakThreNum;
		Long MiddThreNum = MiddPossDynaThreNum+MiddPossDynaLeakThreNum;
		Long LowThreNum = LowPossDynaThreNum+LowPossDynaLeakThreNum;
		
		
		List asseList = assetDao.listAsse(asseInfoProj.getDomain());
		if(asseList!=null && asseList.size()>0) {
		 //柱状图数据
	     double[][] asseThreData = new double[3][asseList.size()];
	     String[] asseThreDataRowKeys = {"高可能性威胁数目", "中可能性威胁数目","低可能性威胁数目"};
	     String[] asseThreDataColumnKeys = new String[asseList.size()];
	     for(int i=0;i<asseList.size();i++) {
		      AsseInfoAsse asseInfo = (AsseInfoAsse) asseList.get(i);
		      asseThreDataColumnKeys[i] = asseInfo.getId()+asseInfo.getAssetName();
		      Integer AsseHighPossNum = threAnalDao.statAsseDynaThreNum(asseInfoProj, asseInfo, "H");
		      Integer leakHighPossNum = dynaLeakThreDao.statAsseDynaLeakThreNum(asseInfoProj, asseInfo, "H");
			  asseThreData[0][i]=AsseHighPossNum.doubleValue()+leakHighPossNum.doubleValue();
			  Integer AsseMiddPossNum = threAnalDao.statAsseDynaThreNum(asseInfoProj, asseInfo, "M");
			  Integer leakMiddPossNum = dynaLeakThreDao.statAsseDynaLeakThreNum(asseInfoProj, asseInfo, "M");
			  asseThreData[1][i]=AsseMiddPossNum.doubleValue()+leakMiddPossNum.doubleValue();
			  Integer AsseLowPossNum = threAnalDao.statAsseDynaThreNum(asseInfoProj, asseInfo, "L");
			  Integer leakLowPossNum = dynaLeakThreDao.statAsseDynaLeakThreNum(asseInfoProj, asseInfo, "L");
			  asseThreData[2][i]=AsseLowPossNum.doubleValue()+leakLowPossNum.doubleValue();
	     }
	     reportMap.put("asseThreData", asseThreData);
		 reportMap.put("asseThreDataRowKeys", asseThreDataRowKeys);
		 reportMap.put("asseThreDataColumnKeys", asseThreDataColumnKeys);
		}
		
		reportMap.put("HighThreNum", HighThreNum);
		reportMap.put("MiddThreNum", MiddThreNum);
		reportMap.put("LowThreNum", LowThreNum);
		
		reportMap.put("dynaThreList", dynaThreList);
		reportMap.put("dynaLeakThreList", dynaLeakThreList);
		return reportMap;
	}

	/**
     * 总体报告
     * @param projId
     * 测评机构Id
     * @return 
     * 总风险点个数、高级别风险个数、中级别风险个数、低级别风险个数
     **/
	@SuppressWarnings("unchecked")
	public Map totalReport(Integer projId) {
		
		Map RiskNumMap = new HashMap();
		List riskValuList = dynaElemResuDao.statRiskValue(projId);
		Long HighRiskNum = 0L;
        Long MiddRiskNum = 0L;
        Long LowRiskNum = 0L;
        Long TotalRiskNum = 0L;
        if(riskValuList!=null && riskValuList.size()>0) {
            Object[] object = (Object[]) riskValuList.get(0);
               HighRiskNum = (Long) object[0];
               MiddRiskNum = (Long) object[1];
               LowRiskNum = (Long) object[2];
               TotalRiskNum = HighRiskNum+MiddRiskNum+LowRiskNum;
               System.out.println("总风险点个数:"+TotalRiskNum);
               System.out.println("高级别风险个数:"+HighRiskNum);
               System.out.println("中级别风险个数:"+MiddRiskNum);
               System.out.println("低级别风险个数:"+LowRiskNum);
        }
        
        RiskNumMap.put("TotalRiskNum", TotalRiskNum);
        RiskNumMap.put("HighRiskNum", HighRiskNum);
        RiskNumMap.put("MiddRiskNum", MiddRiskNum);
        RiskNumMap.put("LowRiskNum", LowRiskNum);
        
		return RiskNumMap;
	}

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
	@SuppressWarnings("unchecked")
	public Map vulnSeriousReport( AsseInfoProj asseInfoProj) {
		
		Map reportMap = new HashMap();
		//各资产的漏洞列表
		List dynaLeakList = new ArrayList();
		List dynaLeaks = dynaLeakDao.listDynaLeak(asseInfoProj);
		//动态脆弱点列表
		List dynaVulnList = new ArrayList();
		List dynaVulns = vulnAnalDao.listDynaVulnPoint(asseInfoProj.getId());
		
		if(dynaVulns!=null && dynaVulns.size()>0) {
			for(int i=0;i<dynaVulns.size();i++) {
				Object[] object = new Object[2];
				AsseKnowDynaVuln dynaVuln = (AsseKnowDynaVuln) dynaVulns.get(i);
				AsseKnowStatVulnPoin statVulnPoin = new AsseKnowStatVulnPoin();
				if(dynaVuln.getAsseKnowStatVulnPoinId()!=null) {
				  statVulnPoin = statVulnPoinDao.find(dynaVuln.getAsseKnowStatVulnPoinId());
				}
				object[0] = dynaVuln;
				object[1] = statVulnPoin;
				dynaVulnList.add(object);
			}
		}
		
		if(dynaLeaks!=null && dynaLeaks.size()>0) {
			for(int i=0;i<dynaLeaks.size();i++) {
				Object[] object = new Object[2];
				AsseKnowDynaLeak dynaLeak = (AsseKnowDynaLeak) dynaLeaks.get(i);
				AsseInfoLeak infoLeak = leakScanDao.find(dynaLeak.getInfoLeakId());
				object[0] = dynaLeak;
				object[1] = infoLeak;
				dynaLeakList.add(object);
			}
		}
		
		Long HighSeriDynaVulnNum = vulnAnalDao.statHighSeriDynaVulnPoint(asseInfoProj.getId());
		Long MiddSeriDynaVulnNum = vulnAnalDao.statMiddSeriDynaVulnPoint(asseInfoProj.getId());
		Long LowSeriDynaVulnNum = vulnAnalDao.statLowSeriDynaVulnPoint(asseInfoProj.getId());
		Long HighRiskDynaLeakNum = dynaLeakDao.statHighRiskLeak(asseInfoProj.getId());
		Long MiddRiskDynaLeakNum = dynaLeakDao.statMiddRiskLeak(asseInfoProj.getId());
		Long LowRiskDynaLeakNum = dynaLeakDao.statLowRiskLeak(asseInfoProj.getId());
		//饼图数据
		Long HighVulnNum = HighSeriDynaVulnNum+HighRiskDynaLeakNum;
		Long MiddVulnNum = MiddSeriDynaVulnNum+MiddRiskDynaLeakNum;
		Long LowVulnNum = LowSeriDynaVulnNum+LowRiskDynaLeakNum;
		
		List asseList = assetDao.listAsse(asseInfoProj.getDomain());
		if(asseList!=null && asseList.size()>0) {
		 //柱状图数据
	     double[][] asseVulnData = new double[3][asseList.size()];
	     String[] asseVulnDataRowKeys = {"高严重性漏洞数目", "中严重性漏洞数目","低严重性漏洞数目"};
	     String[] asseVulnDataColumnKeys = new String[asseList.size()];
//	     Object[] distinctAssetNameList = asseDao.listDistinctAssetName(inst);
//	     String[] asseVulnDataColumnKeys = new String[distinctAssetNameList.length];
//	     for(int i=0; i<asseVulnDataColumnKeys.length; i++) {
//	    	 asseVulnDataColumnKeys[i] = (String) distinctAssetNameList[i];
//	     }
	     for(int i=0;i<asseList.size();i++) {
	      AsseInfoAsse asseInfo = (AsseInfoAsse) asseList.get(i);
		  asseVulnDataColumnKeys[i] = asseInfo.getId()+asseInfo.getAssetName();
		  Integer AsseHighSeriNum = vulnAnalDao.statAsseDynaVulnPointNum(asseInfoProj, asseInfo, "H");
		  Integer leakHighSeriNum = dynaLeakDao.statDynaLeakNum(asseInfoProj, asseInfo, "H");
		  System.out.println(AsseHighSeriNum);
		  System.out.println(leakHighSeriNum);
		  asseVulnData[0][i]=AsseHighSeriNum.doubleValue()+leakHighSeriNum.doubleValue();
		  Integer AsseMiddSeriNum = vulnAnalDao.statAsseDynaVulnPointNum(asseInfoProj, asseInfo, "M");
		  Integer leakMiddSeriNum = dynaLeakDao.statDynaLeakNum(asseInfoProj, asseInfo, "M");
		  System.out.println(AsseMiddSeriNum);
		  System.out.println(leakMiddSeriNum);
		  asseVulnData[1][i]=AsseMiddSeriNum.doubleValue()+leakMiddSeriNum.doubleValue();
		  Integer AsseLowSeriNum = vulnAnalDao.statAsseDynaVulnPointNum(asseInfoProj, asseInfo, "L");
		  Integer leakLowSeriNum = dynaLeakDao.statDynaLeakNum(asseInfoProj, asseInfo, "L");
		  System.out.println(AsseLowSeriNum);
		  System.out.println(leakLowSeriNum);
		  asseVulnData[2][i]=AsseLowSeriNum.doubleValue()+leakLowSeriNum.doubleValue();
		  
		 }
		 
	     reportMap.put("asseVulnData", asseVulnData);
		 reportMap.put("asseVulnDataRowKeys", asseVulnDataRowKeys);
		 reportMap.put("asseVulnDataColumnKeys", asseVulnDataColumnKeys);
		}
		
		reportMap.put("HighVulnNum", HighVulnNum);
		reportMap.put("MiddVulnNum", MiddVulnNum);
		reportMap.put("LowVulnNum", LowVulnNum);
		
		reportMap.put("dynaVulnList", dynaVulnList);
		reportMap.put("dynaLeakList", dynaLeakList);
		
		return reportMap;
	}

	/**
     * 查询项目总体评估对象
     * @param projId
     * 测评机构Id
     * @return 项目总体评估对象
     **/
	public AsseKnowDynaAsseValue findByProjId(Integer projId) {
		
		return dynaAsseValueDao.find(projId);
	}

	/**
     * 各委办局业务及支撑资产清单
     * @param inst
     * 委办局对象
     * @return 业务名称、业务重要性和对应资产
     **/
	@SuppressWarnings("unchecked")
	public List businessImportanceReport(Domain domain) {
		
		List reportList = new ArrayList();
		List businessList = businessDao.find(domain);
		List asseList = null;
		AsseInfoBusi asseInfoBusi = null;
		AsseInfoAsse asseInfoAsse = null;
		if(businessList!=null && businessList.size()>0) {
			for(int i=0;i<businessList.size();i++) {
				Object[] objects = new Object[3];
				String assetName = "";
				asseInfoBusi = (AsseInfoBusi) businessList.get(i);
				objects[0] = asseInfoBusi.getBusinessName();
				objects[1] = asseInfoBusi.getImportance();
				asseList = assetDao.listAsse(domain);
				if(asseList!=null && asseList.size()>0) {
					for(int j=0;j<asseList.size();j++) {
						asseInfoAsse = (AsseInfoAsse) asseList.get(j);
					if(asseInfoAsse.getAsseInfoBusiId()!=null){
					  if(asseInfoAsse.getAsseInfoBusiId().intValue() == asseInfoBusi.getId().intValue()) {
						assetName+=asseInfoAsse.getAssetName()+"  ";
					  }
					 }
					}
				}
				objects[2] = assetName;
				reportList.add(objects);
			}
		}
		return reportList;
	}

	public void saveAlert(AsseInfoProj asseInfoProj) throws Exception {
		
		List<AsseKnowDynaElemResu> dynaElemResuList = dynaElemResuDao.listDynaElemResu(asseInfoProj.getId());
		AsseInfoAsse asseInfoAsse = null;
		Integer priority = new Integer(5);
		String type = "风险评估";
		String subType = "评估报告生成";
		String context = "";
		String source = InetAddress.getByName("localhost").getHostAddress();
		String target = null;
		String category = "任务通知";
		//boolean check = dynaElemResuDao.checkAlertType(type, subType, category);
		//if(check) {
		 for(AsseKnowDynaElemResu dynaElemResu : dynaElemResuList) {
			target = "";
			//if("y".equalsIgnoreCase(dynaElemResu.getIsWarn())) {
				/*AlertInfoBO alertInfo = new AlertInfoBO();
				asseInfoAsse = dynaElemResu.getAsse();
				target += "委办局名称:"+asseInfoProj.getDomain().getDomainName()+String.valueOf((char)13)+String.valueOf((char)10);
				target += "资产编号:"+asseInfoAsse.getAssetCode()+String.valueOf((char)13)+String.valueOf((char)10);
				if(asseInfoAsse.getIp()!=null && !"".equals(asseInfoAsse.getIp())) {
					target += "IP地址:"+asseInfoAsse.getIp()+String.valueOf((char)13)+String.valueOf((char)10);
				}
				context += "测评项目编号:"+asseInfoProj.getId()+String.valueOf((char)13)+String.valueOf((char)10)
		                +"测评项目名称:"+asseInfoProj.getProjName()+String.valueOf((char)13)+String.valueOf((char)10) 
					    +"资产名称:"+asseInfoAsse.getAssetName()+String.valueOf((char)13)+String.valueOf((char)10)
					    +"高风险点:"+dynaElemResu.getVulnHighNum()+"个"+String.valueOf((char)13)+String.valueOf((char)10)
				        +"中风险点:"+dynaElemResu.getVulnMiduNum()+"个"+String.valueOf((char)13)+String.valueOf((char)10)
				        +"低风险点:"+dynaElemResu.getVulnLowNum()+"个"+String.valueOf((char)13)+String.valueOf((char)10);
				alertInfo.setCategory(category);
				alertInfo.setContext(context);
				alertInfo.setPriority(priority);
				alertInfo.setSource(source);
				alertInfo.setSubType(subType);
				alertInfo.setTarget(target);
				alertInfo.setType(type);
				alertInfo.setIfnew(1);
				alertInfo.setStatus(1);
				SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //格式化当前系统日期
				String dateTime = dateFm.format(new java.util.Date());
				alertInfo.setTime(new Timestamp(dateFm.parse(dateTime).getTime()));
				//dynaElemResuDao.sendAlert(alertInfo);
				sendalertDao.sendAlertDao(priority, type, subType, null, context, source, target, category, WebConfigContent.mailAddress, WebConfigContent.mailFrom, WebConfigContent.mailPassword, WebConfigContent.mmsIp, WebConfigContent.mmsPort);
				target="";context="";*/
		  //}
		}
		 
	  //}
	}
	
	@SuppressWarnings("unchecked")
	public void executeSend(AsseInfoProj asseInfoProj) {
		
		HashMap reportMap = new HashMap();
		AsseKnowDynaAsseValue dynaAsseValue = dynaAsseValueDao.find(asseInfoProj.getId().toString());
		reportMap.put("orgCode", asseInfoProj.getDomain().getId());
		reportMap.put("instName", asseInfoProj.getDomain().getDomainName());
		reportMap.put("projId", asseInfoProj.getId());
		//各资产的评估要素列表
        List dynaElemResuList = dynaElemResuDao.listDynaElemResu(asseInfoProj.getId());
        //各资产的风险列表
        List repoList = dynaVTARepoDao.listDynaVTARepo(asseInfoProj);
        AsseInfoAsse asseInfoAsse = null;
        AsseResuHandOn handOnResult = new AsseResuHandOn();
        handOnResult.setAsseBeginTime(asseInfoProj.getAsseBeginTime());
        handOnResult.setAsseComp(asseInfoProj.getAsseComp());
        handOnResult.setAsseEndTime(asseInfoProj.getAsseEndTime());
        handOnResult.setAssePers(asseInfoProj.getAssePers());
        handOnResult.setExpertSuggest(dynaAsseValue.getExpertSuggest());
        handOnResult.setDomain(asseInfoProj.getDomain());
        handOnResult.setProjId(asseInfoProj.getId());
        handOnResult.setProjName(asseInfoProj.getProjName());
        handOnResult.setSecuLeve(asseInfoProj.getSecuLeve());
        
        if(dynaElemResuList!=null && dynaElemResuList.size()>0) {
        	AsseKnowDynaElemResu dynaElemResu = null;
        	int vulnHighNum = 0;
        	int vulnMiduNum = 0;
        	int vulnLowNum = 0;
        	for(int i=0;i<dynaElemResuList.size();i++) {
        		dynaElemResu = (AsseKnowDynaElemResu) dynaElemResuList.get(i);
        		asseInfoAsse = dynaElemResu.getAsse();
        		vulnHighNum += dynaElemResu.getVulnHighNum().intValue();
        		vulnMiduNum += dynaElemResu.getVulnMiduNum().intValue();
        		vulnLowNum += dynaElemResu.getVulnLowNum().intValue();
        	}
        	handOnResult.setVulnHighNum(new Integer(vulnHighNum));
        	handOnResult.setVulnMiduNum(new Integer(vulnMiduNum));
        	handOnResult.setVulnLowNum(new Integer(vulnLowNum));
        }
        if(repoList!=null && repoList.size()>0) {
        	AsseKnowDynaVTARepo dynaVTARepo = null;
           int vulnHighIPNum = 0;
    	   int vulnMiduIPNum = 0;
    	   int vulnLowIPNum = 0;
    	   for(int i=0;i<repoList.size();i++) {
    		   dynaVTARepo = (AsseKnowDynaVTARepo) repoList.get(i);
    		   asseInfoAsse = assetDao.find(dynaVTARepo.getAssetId());
    		   if(asseInfoAsse.getIp()!=null) {
    			   if(dynaVTARepo.getRiskValu().equals("H")) {
    				   vulnHighIPNum += 1;
    			   }else if(dynaVTARepo.getRiskValu().equals("M")) {
    				   vulnMiduIPNum += 1;
    			   }else if(dynaVTARepo.getRiskValu().equals("L")) {
    				   vulnLowIPNum += 1;
    			   }
    		   }
    	   }
    	   handOnResult.setVulnHighIPNum(new Integer(vulnHighIPNum));
    	   handOnResult.setVulnMiduIPNum(new Integer(vulnMiduIPNum));
    	   handOnResult.setVulnLowIPNum(new Integer(vulnLowIPNum));
        }
        reportMap.put("handOnResult", handOnResult);
       // assessmentReportSenderWrapper.executeSend(reportMap);
	}

	public List getDicCpKindList() {
		
		return dicCpKindDao.listDicCpKind(null);
	}
}
