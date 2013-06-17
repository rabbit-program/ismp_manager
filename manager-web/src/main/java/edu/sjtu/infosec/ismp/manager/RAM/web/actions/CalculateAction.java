package edu.sjtu.infosec.ismp.manager.RAM.web.actions;

import java.awt.Font;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicRiskMatrRule;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseResu;
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
import edu.sjtu.infosec.ismp.manager.RAM.service.AssetService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicRiskMatrRuleService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaAsseResuService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaAsseValueService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaElemResuService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaVTARepoService;
import edu.sjtu.infosec.ismp.manager.RAM.service.LeakScanService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatCVEThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatVulnPoinService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatWarnStriService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ThreAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.service.VulnAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseKnowDynaAsseValueForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * web层 风险计算Action.
 */
public class CalculateAction  extends DispatchAction {
	private static Logger logger = Logger.getLogger(CalculateAction.class); 
    
    /**
     * 知识库静态安全阈值Manager接口
     */
    private StatWarnStriService statWarnStriService;
	/**
     * 项目管理Service接口
     */
    private ProjectService projectService;
    /**
     * 资产录入Service接口
     * 
     **/
    private AssetService assetService;
    /**
     * 动态脆弱点分析Service接口
     */
	private VulnAnalService vulnAnalService;
    /**
     * 威胁分析Service接口
     * 
     **/
	private ThreAnalService threAnalService;
	/**
     * 风险矩阵字典表Service接口
     **/
    private DicRiskMatrRuleService dicRiskMatrRuleService;
    /**
     * 知识库项目动态评估结果Service接口
     **/
    private DynaAsseResuService dynaAsseResuService;
    /**
     * 知识库项目总体评估值Service接口
     **/
    private DynaAsseValueService dynaAsseValueService;
    /**
     * 知识库资产评估要素结果Service接口
     **/
    private DynaElemResuService dynaElemResuService;
	/**
     * 知识库动态V-T-A-R评估报告Service接口
     */
    private DynaVTARepoService dynaVTARepoService;
	/**
     * 静态脆弱点Service接口
     */
    private StatVulnPoinService statVulnPoinService;
    /**
     * 静态威胁Service接口
     */
	private StatThreService statThreService;
	/**
     * 动态漏洞分析Service接口
     **/
	private DynaLeakService dynaLeakService;
    /**
     * 漏洞扫描Service接口
     */
    private LeakScanService leakScanService;
    /**
     * 知识库静态漏洞威胁Service接口
     */
    private StatCVEThreService statCVEThreService;
    
    
    private DynaLeakThreService dynaLeakThreService;
    
    private DicSecuLeveService dicSecuLeveService;
    
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}
    
    public void setDicSecuLeveService(DicSecuLeveService dicSecuLeveService) {
		this.dicSecuLeveService = dicSecuLeveService;
	}

	public void setDynaLeakThreService(DynaLeakThreService dynaLeakThreService) {
		this.dynaLeakThreService = dynaLeakThreService;
	}

	public void setStatWarnStriService(StatWarnStriService statWarnStriService) {
		this.statWarnStriService = statWarnStriService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

	public void setVulnAnalService(VulnAnalService vulnAnalService) {
		this.vulnAnalService = vulnAnalService;
	}

	public void setThreAnalService(ThreAnalService threAnalService) {
		this.threAnalService = threAnalService;
	}

	public void setDicRiskMatrRuleService(
			DicRiskMatrRuleService dicRiskMatrRuleService) {
		this.dicRiskMatrRuleService = dicRiskMatrRuleService;
	}

	public void setDynaAsseResuService(DynaAsseResuService dynaAsseResuService) {
		this.dynaAsseResuService = dynaAsseResuService;
	}

	public void setDynaAsseValueService(DynaAsseValueService dynaAsseValueService) {
		this.dynaAsseValueService = dynaAsseValueService;
	}

	public void setDynaElemResuService(DynaElemResuService dynaElemResuService) {
		this.dynaElemResuService = dynaElemResuService;
	}

	public void setDynaVTARepoService(DynaVTARepoService dynaVTARepoService) {
		this.dynaVTARepoService = dynaVTARepoService;
	}

	public void setStatVulnPoinService(StatVulnPoinService statVulnPoinService) {
		this.statVulnPoinService = statVulnPoinService;
	}

	public void setStatThreService(StatThreService statThreService) {
		this.statThreService = statThreService;
	}

	public void setDynaLeakService(DynaLeakService dynaLeakService) {
		this.dynaLeakService = dynaLeakService;
	}

	public void setLeakScanService(LeakScanService leakScanService) {
		this.leakScanService = leakScanService;
	}

	public void setStatCVEThreService(StatCVEThreService statCVEThreService) {
		this.statCVEThreService = statCVEThreService;
	}

	/**
     * 往session中加载本次测评项目信息
     */
    private AsseInfoProj loadAsseInfoproj(HttpServletRequest request) {
        
        AsseInfoProj asseInfoProj = null;
        if(request.getSession().getAttribute("asseInfoProj") == null) {
            
            String projId = request.getParameter("projId");
            if(projId != null && !"".equals(projId.trim())) {
             Integer projCode = new Integer(projId);
             asseInfoProj = projectService.find(projCode);
             System.out.println("find asseInfoProj:"+asseInfoProj.toString());
            }
          request.getSession().setAttribute("asseInfoProj", asseInfoProj);
      } else {
          asseInfoProj = (AsseInfoProj) request.getSession().getAttribute("asseInfoProj");  
      }
        return asseInfoProj;
    }
    
	/**
     * 风险计算前数据入库
     */
	public ActionForward preCal(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		    
		    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
		    asseInfoProj.setProgress("prog11");
		    asseInfoProj.setAsseStatus("stat03");
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
			String dateString = formatter.format(new Date());  
			Timestamp time = Timestamp.valueOf(dateString);
		    asseInfoProj.setAsseEndTime(time);
	        projectService.saveOrUpdate(asseInfoProj);
	        request.getSession().setAttribute("asseInfoProj", asseInfoProj);
	        
		    boolean ext1 = dynaAsseResuService.checkExit(asseInfoProj.getId());
		    List<AsseKnowDynaAsseResu> dynaAsseResuList = new ArrayList<AsseKnowDynaAsseResu>();
		    boolean ext2 = dynaElemResuService.checkExit(asseInfoProj.getId().toString());
		    List<AsseKnowDynaElemResu> dynaElemResuList = new ArrayList<AsseKnowDynaElemResu>();
		    boolean ext3 = dynaVTARepoService.checkExit(asseInfoProj);
		    List<AsseKnowDynaVTARepo> dynaVTARepoList = new ArrayList<AsseKnowDynaVTARepo>();
		    
		    boolean ext4 = dynaAsseValueService.checkExit(asseInfoProj.getId().toString());
		    AsseKnowDynaAsseValue dynaAsseValue = null;
		    if(!ext4) {
		    	dynaAsseValue = new AsseKnowDynaAsseValue();
		    	dynaAsseValue.setProjCode(asseInfoProj.getId().toString());
		    	dynaAsseValueService.saveOrUpdate(dynaAsseValue);
		    }else{
		    	dynaAsseValue = dynaAsseValueService.find(asseInfoProj.getId().toString());
		    }
		    AsseKnowDynaVuln dynaVuln = null;
		    AsseKnowDicRiskMatrRule dicRiskMatrRule = null;
		    AsseInfoAsse asseInfoAsse = null;
		    AsseKnowStatVulnPoin statVulnPoin = null;
		    AsseKnowStatThre statThre = null;
		    AsseKnowDynaLeak dynaLeak = null;
		    List<AsseKnowDynaVuln> dynaVulnList = vulnAnalService.listDynaVulnPoint(asseInfoProj.getId().toString());
		    List<AsseKnowDynaLeak> dynaLeakList = dynaLeakService.listDynaLeak(asseInfoProj);
		     if((dynaVulnList!=null && dynaVulnList.size()>0) || (dynaLeakList!=null && dynaLeakList.size()>0) ) {
		    	for(int i=0;i<dynaVulnList.size();i++){
		    		    dynaVuln = dynaVulnList.get(i);
		    		    asseInfoAsse = dynaVuln.getAsse();
		    		   if(asseInfoAsse!=null&&!"".equals(asseInfoAsse)){
		    			   List<AsseKnowDynaThre> dynaThreSet =threAnalService.ListThreByVulnId(dynaVuln.getId());
			    			if(dynaThreSet!=null&&!"".equals(dynaThreSet)&&dynaThreSet.size()>0) {
			    				
			    				if(!ext1) {
			    				for(AsseKnowDynaThre dynaThre:dynaThreSet){
			    			    	 AsseKnowDynaAsseResu dynaAsseResu = new AsseKnowDynaAsseResu();
			    				     dynaAsseResu.setAsse(asseInfoAsse);
			    				     dynaAsseResu.setAsseInfoProjId(asseInfoProj.getId());
			    				     dynaAsseResu.setDynaThre(dynaThre);
			    				     dynaAsseResu.setDynaVuln(dynaVuln);
			    				     if(asseInfoAsse!=null){
				    				     dicRiskMatrRule = dicRiskMatrRuleService.find(asseInfoAsse.getImportance(), dynaVuln.getSeriLeve(), dynaThre.getPossibility());
				    				     dynaAsseResu.setRiskValu(dicRiskMatrRule.getRiskValu());
			    				     }else{
				    				     dynaAsseResu.setRiskValu("L");
			    				     }
			    				     dynaAsseResuList.add(dynaAsseResu);
			    			    }
			    			 }
			    				
			    				if(!ext3) {
			    					for(AsseKnowDynaThre dynaThre:dynaThreSet){
	                                 AsseKnowDynaVTARepo dynaVTARepo = new AsseKnowDynaVTARepo();
	                                 AsseInfoProj asseinfoProj = new AsseInfoProj();
	                                 asseinfoProj = projectService.find(asseInfoProj.getId());
	                                 dynaVTARepo.setAsseInfoProj(asseinfoProj);
	                                 if(asseInfoAsse!=null&&!"".equals(asseInfoAsse)){
	                                	  dynaVTARepo.setAssetId(asseInfoAsse.getId());
	                                      dynaVTARepo.setAsseName(asseInfoAsse.getAssetName());
	                                      dicRiskMatrRule = dicRiskMatrRuleService.find(asseInfoAsse.getImportance(), dynaVuln.getSeriLeve(), dynaThre.getPossibility());
	                                      dynaVTARepo.setRiskValu(dicRiskMatrRule.getRiskValu());
	                                 }
	                                 
	                                 statVulnPoin = statVulnPoinService.find(dynaVuln.getAsseKnowStatVulnPoinId().toString());
	                                 statThre = statThreService.find(dynaThre.getAsseKnowStatThreId().toString());
	                                 dynaVTARepo.setVulnPoinName(statVulnPoin.getDescribe());
	                                 dynaVTARepo.setThreName(statThre.getThreat());
	                                 dynaVTARepo.setSugg(statVulnPoin.getResolve());
	                                 System.out.println(dynaVTARepo.toString());
	                                 dynaVTARepoList.add(dynaVTARepo);
	                                 
			    				}
				    				
				    		}
			    	    }
		    		   }
		    	}
		    	
		    	for(int i=0;i<dynaLeakList.size();i++) {
		    		dynaLeak = dynaLeakList.get(i);
		    		asseInfoAsse = dynaLeak.getAsse();
		    		System.out.println("asdf======="+dynaLeak.getId());
	    		    List<AsseKnowDynaLeakThre> dynaLeakThreSet = dynaLeakThreService.listByDynaLeakId(dynaLeak.getId());
	    		    if(dynaLeakThreSet!=null) {
	    		      if(!ext1) {
	    		    	for(AsseKnowDynaLeakThre dynaLeakThre:dynaLeakThreSet){
	    		    		AsseKnowDynaAsseResu dynaAsseResu = new AsseKnowDynaAsseResu();
	    		    		dynaAsseResu.setAsse(asseInfoAsse);
	    		    		dynaAsseResu.setAsseInfoProjId(asseInfoProj.getId());
	    		    		dynaAsseResu.setDynaLeak(dynaLeak);
	    		    		dynaAsseResu.setDynaLeakThre(dynaLeakThre);
	    		    		String riskValue ="L";
	    		    		try{
	    		    		 dicRiskMatrRule = dicRiskMatrRuleService.find(asseInfoAsse.getImportance(), dynaLeak.getSeriLeve(), dynaLeakThre.getPossibility());
	    		    		 riskValue = dicRiskMatrRule.getRiskValu();
	    		    		}catch(NullPointerException e) {
	    		    		 riskValue = "L";	
	    		    		}
	    		    		dynaAsseResu.setRiskValu(riskValue);
	    				    dynaAsseResuList.add(dynaAsseResu);
	    		    	}
	    		      }
	    		      
	    		      if(!ext3) {
	    		    	  for(AsseKnowDynaLeakThre dynaLeakThre:dynaLeakThreSet){
	    		    		  AsseKnowDynaVTARepo dynaVTARepo = new AsseKnowDynaVTARepo();
                              AsseInfoProj asseinfoProj = new AsseInfoProj();
                              asseinfoProj = projectService.find(asseInfoProj.getId());
                              dynaVTARepo.setAsseInfoProj(asseinfoProj);
                              if(asseInfoAsse != null&&!"".equals(asseInfoAsse)) {
                                 dynaVTARepo.setAssetId(asseInfoAsse.getId());
                                 dynaVTARepo.setAsseName(asseInfoAsse.getAssetName());
                                 dicRiskMatrRule = dicRiskMatrRuleService.find(asseInfoAsse.getImportance(), dynaLeak.getSeriLeve(), dynaLeakThre.getPossibility());
                              }else{
                            	  dynaVTARepo.setAssetId(0);
                                  dynaVTARepo.setAsseName("未知");
                                  dicRiskMatrRule = dicRiskMatrRuleService.find("L", dynaLeak.getSeriLeve(), dynaLeakThre.getPossibility());
                              }
                              if(dicRiskMatrRule !=null) {
                               dynaVTARepo.setRiskValu(dicRiskMatrRule.getRiskValu());
                              }else{
                               dynaVTARepo.setRiskValu("M");  
                              }
                              AsseInfoLeak infoLeak = leakScanService.find(dynaLeak.getInfoLeakId().toString());
                              AsseKnowStatCVEThre statCVEThre = new AsseKnowStatCVEThre();
                              Integer statCveThreId = dynaLeakThre.getAsseKnowStatCveThreId();
                              if(statCveThreId!=null && statCveThreId.intValue()!=0) {
                               statCVEThre = statCVEThreService.findById(statCveThreId.toString());
                              }
                              dynaVTARepo.setVulnPoinName(infoLeak.getLocation());
                              dynaVTARepo.setSugg(infoLeak.getSolution());
                              dynaVTARepo.setThreName(statCVEThre.getThreat());
                              dynaVTARepoList.add(dynaVTARepo);
	    		    	  }
	    		      }
	    		      
	    		    }
		    	}
		    	try{
		    	    dynaAsseResuService.batchSaveOrUpdate(dynaAsseResuList);
                }catch(Exception e){
		    		e.printStackTrace();
		    	}
		    	System.out.println("begin batchSaveOrUpdate dynaVTARepo");
		    	try{
		    	    dynaVTARepoService.batchSaveOrUpdate(dynaVTARepoList);
		    	}catch(Exception e){
		    		e.printStackTrace();
		    	}
		    	System.out.println("end batchSaveOrUpdate dynaVTARepo");
		    	if(!ext2) {
		    	  List riskNumlist = dynaAsseResuService.listRiskNumByAsse(asseInfoProj.getId());
		    	  if(riskNumlist!=null && riskNumlist.size()>0) {
		    		  for(int j=0;j<riskNumlist.size();j++){
		    				Object[] object = (Object[]) riskNumlist.get(j);
		    				Integer asseInfoAsseID = (Integer) object[0];
		    				asseInfoAsse = assetService.findById(asseInfoAsseID.toString());
		    				System.out.print(asseInfoAsseID.intValue()+" ");
		    				BigDecimal High = (BigDecimal) object[1];
		    				BigDecimal Midd = (BigDecimal) object[2];
		    				BigDecimal Low = (BigDecimal) object[3];
		    				System.out.print(High.intValue()+" ");
		    				System.out.print(Midd.intValue()+" ");
		    				System.out.print(Low.intValue());
		    				System.out.println();
		    				AsseKnowDynaElemResu dynaElemResu = new AsseKnowDynaElemResu();
		    				dynaElemResu.setDynaAsseValue(dynaAsseValue);
		    				dynaElemResu.setAsse(asseInfoAsse);
		    				dynaElemResu.setAsseInfoProjId(asseInfoProj.getId());
		    				dynaElemResu.setVulnHighNum(new Integer(High.intValue()));
		    				dynaElemResu.setVulnMiduNum(new Integer(Midd.intValue()));
		    				dynaElemResu.setVulnLowNum(new Integer(Low.intValue()));
		    				String isWarn = statWarnStriService.retIsWarn(new Integer(High.intValue()), new Integer(Midd.intValue()), new Integer(Low.intValue()));
		    				dynaElemResu.setIsWarn(isWarn);
		    				dynaElemResuList.add(dynaElemResu);
		    		  }
		    	  }
		    	            dynaElemResuService.batchSaveOrUpdate(dynaElemResuList);
		    	}
		     }
		    return showListByTag(mapping,form,request,response);
	}
	
	/**
     * 风险计算结果分页
     */
    @SuppressWarnings("unchecked")
	public ActionForward showListByTag(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	request.setAttribute("secuLeve", asseInfoProj.getSecuLeve());
    	AsseKnowDynaAsseValue dynaAsseValue = dynaAsseValueService.find(asseInfoProj.getId().toString());
    	request.setAttribute("dynaAsseValue", dynaAsseValue);
    	
    	 int currPage = 1;
 		Double totalPage = 0d;
 		int totalNum = 0;
 		int startResult = 0;
 		int maxResult = 5;
 		try{
 			//分页定义的相关的基本信息
 			String cp = (request.getParameter("currPage")==null)?"1":request.getParameter("currPage");
 			if(cp!=null && !cp.equals("")){
 				currPage = Integer.parseInt(cp);
 			}
 			startResult = (currPage-1)*maxResult;
 			if(startResult < 0){
 				startResult = 0;
 			}
 			
 			//数据相关的基本信息
 			List<AsseKnowDynaElemResu> calcList = new ArrayList<AsseKnowDynaElemResu>();
 			calcList = dynaElemResuService.listDynaElemResuPage(startResult, maxResult,asseInfoProj.getId().toString());

 			//分页定义的相关的基本信息
 			totalNum=dynaElemResuService.getCount(asseInfoProj.getId().toString());
 			totalPage = Math.ceil((double)totalNum/maxResult);
 			if(totalPage>0 && currPage<=0){
 				currPage = 1;
 			}
 			request.setAttribute("calcList", calcList);
 			request.setAttribute("currPage", currPage);
 			request.setAttribute("totalPage", totalPage.intValue());
 			List dicSecuLeveList=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", dicSecuLeveList);
			
	        List riskValuList = dynaElemResuService.statRiskValue(asseInfoProj.getId());
	        DefaultPieDataset dataSet = new DefaultPieDataset();
	        if(riskValuList!=null && riskValuList.size()>0) {
	         Object[] object = (Object[]) riskValuList.get(0);
	            Long High = 0L;
	            Long Midd = 0L;
	            Long Low = 0L;
	           if(object != null && object.length>0) {
	            if(object[0]!=null)
	             High = (Long) object[0];
	            if(object[1]!=null)
	             Midd = (Long) object[1];
	            if(object[2]!=null)
	             Low = (Long) object[2];
	            }
	            dataSet.setValue("高风险点",High.intValue());
	            dataSet.setValue("中风险点",Midd.intValue());
	            dataSet.setValue("低风险点",Low.intValue());
	        }
	        JFreeChart chart=ChartFactory.createPieChart3D("风险分布图",dataSet,true,true,false);
	        chart.getTitle().setFont(new Font("宋体",Font.PLAIN,18));
            PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
            piePlot.setLabelFont(new Font("宋体",Font.BOLD,12));
            chart.getLegend().setItemFont(new Font("宋体",0,12));
	        PiePlot3D piePlot3D=(PiePlot3D)chart.getPlot();
	        piePlot3D.setStartAngle(150D);
	        piePlot3D.setDirection(Rotation.CLOCKWISE);
	        piePlot3D.setForegroundAlpha(0.5F);
	        piePlot3D.setNoDataMessage("无数据显示");
	        piePlot3D.setCircular(true);
	        piePlot3D.setLabelFont(new Font("宋体",0,18));
	        piePlot3D.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={2}",
	                                     NumberFormat.getNumberInstance(),
	                                     NumberFormat.getPercentInstance()));
	        String filename=ServletUtilities.saveChartAsPNG(chart,700,400,null,request.getSession());
	        String graphURL=request.getContextPath()+"/DisplayChart?filename="+filename;
	        request.setAttribute("graphURL", graphURL);
	        request.setAttribute("filename", filename);
	        System.out.println("calcList.size:"+calcList.size());
 		}catch(Exception e){
			logger.debug("风险评估--业务录入--访问出错啦！");
			e.printStackTrace();
		}
	    return mapping.findForward("cal");
    }
    
    /**
     * 保存专家意见
     */
    public ActionForward saveExpertSuggest(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	    
    	    AsseKnowDynaAsseValueForm dynaAsseValueForm = (AsseKnowDynaAsseValueForm) form;
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	    AsseInfoProj newasseInfoProj = projectService.find(asseInfoProj.getId());
	        newasseInfoProj.setSecuLeve(dynaAsseValueForm.getSecuLeve());
	        projectService.saveOrUpdate(newasseInfoProj);
	        request.getSession().setAttribute("asseInfoProj", newasseInfoProj);
    	    AsseKnowDynaAsseValue dynaAsseValue = dynaAsseValueService.find(asseInfoProj.getId().toString());
    	    dynaAsseValue.setExpertSuggest(dynaAsseValueForm.getExpertSuggest());
    	    dynaAsseValueService.saveOrUpdate(dynaAsseValue);
    	    
    	    //添加日志
     		OperatorDetails user = SecurityUserHolder.getCurrentUser();
     		SystemLog log = new SystemLog();
     		log.setUsername(user.getUsername());
     		List<Role> list=user.getRoleList();
     		String roles="";
     		for(Role role:list){
     			roles+=role.getRole()+",";
     		}
     		log.setRoleName(roles.substring(0,roles.length()-1));
     		log.setTime(new Timestamp(new Date().getTime()));
     		log.setModuleName(SystemModelInfo.MOD_RAM);
     		log.setOperationDesc("风险评估模块,风险计算保存专家意见,ID为:"+dynaAsseValue.getId()+",专家意见为:"+dynaAsseValueForm.getExpertSuggest());
     		log.setControl("成功");
     		logService.saveSystemLog(log);
    	    return showListByTag(mapping,form,request,response);
    }
}
