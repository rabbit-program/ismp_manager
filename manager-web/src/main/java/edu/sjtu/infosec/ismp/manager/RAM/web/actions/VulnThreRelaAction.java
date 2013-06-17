package edu.sjtu.infosec.ismp.manager.RAM.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeakThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.RAM.service.AssetService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.LeakScanService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatCVEThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatThreKindService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatVulnKindService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatVulnPoinService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ThreAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.service.VulnAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseKnowDynaThreForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;
/**
 * web层 脆弱点与威胁关联Action.
 */
public class VulnThreRelaAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(VulnThreRelaAction.class);
    /**
     * 项目管理Manager接口
     */
    private ProjectService projectService;
    /**
     * 资产录入Service接口
     **/
    private AssetService assetService;
    /**
     * 动态脆弱点分析Service接口
     */
	private VulnAnalService vulnAnalService;
    /**
     * 威胁分析Service接口
     **/
	private ThreAnalService threAnalService;
	/**
     * 静态威胁类别Service接口
     */
	private StatThreKindService statThreKindService;
	/**
     * 静态威胁Service接口
     */
	private StatThreService statThreService;
	/**
     * 静态脆弱点类别Service接口
     */
    private StatVulnKindService statVulnKindService;
	/**
     * 静态脆弱点Service接口
     */
    private StatVulnPoinService statVulnPoinService;
    /**
     * 漏洞威胁Service接口
     */
    private DynaLeakThreService dynaLeakThreService;
    /**
     * 漏洞扫描Service接口
     */
    private LeakScanService leakScanService;
    /**
     * 知识库静态漏洞威胁Service接口
     */
    private StatCVEThreService statCVEThreService;
    
	private DicSecuLeveService dicSecuLeveService;
	
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}
	
    public void setDicSecuLeveService(DicSecuLeveService dicSecuLeveService) {
		this.dicSecuLeveService = dicSecuLeveService;
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

	public void setStatThreKindService(StatThreKindService statThreKindService) {
		this.statThreKindService = statThreKindService;
	}

	public void setStatThreService(StatThreService statThreService) {
		this.statThreService = statThreService;
	}

	public void setStatVulnKindService(StatVulnKindService statVulnKindService) {
		this.statVulnKindService = statVulnKindService;
	}

	public void setStatVulnPoinService(StatVulnPoinService statVulnPoinService) {
		this.statVulnPoinService = statVulnPoinService;
	}

	public void setDynaLeakThreService(DynaLeakThreService dynaLeakThreService) {
		this.dynaLeakThreService = dynaLeakThreService;
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
     * 脆弱点威胁关联分页
     */
    @SuppressWarnings("unchecked")
	public ActionForward showVulnThre(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
        asseInfoProj.setProgress("prog10");
        projectService.saveOrUpdate(asseInfoProj);
        request.getSession().setAttribute("asseInfoProj", asseInfoProj);
    	
        String vulnKindIdSelect = request.getParameter("vulnKindIdSelect");
        if(vulnKindIdSelect==null) {
        	vulnKindIdSelect = (String) request.getAttribute("vulnKindIdSelect");
        }
        String vulnIdSelect = request.getParameter("vulnIdSelect");
        if(vulnIdSelect==null) {
        	vulnIdSelect = (String) request.getAttribute("vulnIdSelect");
        }
        
        AsseKnowDynaVuln vulnPoint = null;
        if(vulnKindIdSelect!=null) {
        	request.setAttribute("vulnKindSelect", vulnKindIdSelect);
        }
        if(vulnIdSelect!=null && !"".equals(vulnIdSelect)) {
        	vulnPoint = vulnAnalService.find(new Integer(vulnIdSelect));
            request.setAttribute("vulnSelect", vulnIdSelect);
            request.setAttribute("vulnPoint", vulnPoint);
        }
        //返回动态威胁列表
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
			

			//分页定义的相关的基本信息
			totalNum=threAnalService.getCount(asseInfoProj,vulnIdSelect);
			totalPage = Math.ceil((double)totalNum/maxResult);
			if(totalPage>0 && currPage<=0){
				currPage = 1;
			}
			if(currPage>totalPage){
				currPage=totalPage.intValue();
				startResult = (currPage-1)*maxResult;
				if(startResult < 0){
					startResult = 0;
				}
			}
			//数据相关的基本信息
			List<AsseKnowDynaThre> vulnThreAnalList = new ArrayList<AsseKnowDynaThre>();
			vulnThreAnalList = threAnalService.listAllByVuln(startResult, maxResult,asseInfoProj,vulnIdSelect);
			
			request.setAttribute("vulnThreAnalList", vulnThreAnalList);
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalPage", totalPage.intValue());
			 //返回可选资产列表
	        List assertList = assetService.find(asseInfoProj.getDomain(), null);
	        request.setAttribute("assertList", assertList);
	        
	        //返回所有静态威胁类别列表
	        List statThreKindList = statThreKindService.listAllStatThreKind();
	        request.setAttribute("statThreKindList", statThreKindList);
	        
	        //返回所有静态威胁列表
	        List statThreList = statThreService.listAllStatThre();
	        request.setAttribute("statThreList", statThreList);
	        
	        //返回所有静态漏洞威胁列表
	        String cveIdScale = "0";
	        List<String> cveIdList = leakScanService.listCVEId(asseInfoProj);
	        System.out.println("cveIdList:"+cveIdList);
	        List statCveThreList = null;
	        
	        statCveThreList = statCVEThreService.listStatCVEThreByCVEIdScale(cveIdList);
	        
	        request.setAttribute("statCveThreList", statCveThreList);
	        System.out.println(statCveThreList.size());
	        //返回所有静态脆弱点类别列表
	        List statVulnKindList = statVulnKindService.listAllStatVulnKinds();
	        request.setAttribute("statVulnKindList", statVulnKindList);
	        
	        List dicSecuLeveList=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", dicSecuLeveList);
	        //返回所有动态脆弱点列表
	        List dynaVulnList = vulnAnalService.listDynaVulnPoint(asseInfoProj.getId().toString());
	        request.setAttribute("dynaVulnList", dynaVulnList);
	        
	        //返回漏洞扫描发现的IP列表
	        List ipList = leakScanService.listIP(asseInfoProj);
	        System.out.println("ipList.size:"+ipList.size());
	        request.setAttribute("ipList", ipList);
	        
	      //返回漏洞威胁列表
	        String ip = request.getParameter("ip");
	        List<AsseInfoAsse> asseInfo = null;
	        if(ip == null) {
	       	    ip = (String) request.getAttribute("ip");
	        }
	        if(ip!=null && !"".equals(ip)) {
	        	request.setAttribute("ipAddress", ip);
	        	asseInfo = assetService.findByIP(ip);
	        }
	        
	        int currPage1 = 1;
			Double totalPage1 = 0d;
			int totalNum1 = 0;
			int startResult1 = 0;
			int maxResult1 = 5;
			//分页定义的相关的基本信息
			String cp1 = (request.getParameter("currPage1")==null)?"1":request.getParameter("currPage1");
			if(cp1!=null && !cp1.equals("")){
				currPage1 = Integer.parseInt(cp1);
			}
			startResult1 = (currPage1-1)*maxResult1;
			if(startResult1 < 0){
				startResult1 = 0;
			}
			
			//数据相关的基本信息
			List<AsseKnowDynaLeakThre> leakThreList = new ArrayList<AsseKnowDynaLeakThre>();
			leakThreList = dynaLeakThreService.listDynaLeak(startResult1, maxResult1,asseInfoProj,asseInfo);

			//分页定义的相关的基本信息
			totalNum1=dynaLeakThreService.getCount(asseInfoProj,asseInfo);
			totalPage1 = Math.ceil((double)totalNum1/maxResult1);
			if(totalPage1>0 && currPage1<=0){
				currPage1 = 1;
			}
				
	        request.getSession().setAttribute("leakThreList", leakThreList);
			request.setAttribute("currPage1", currPage1);
			request.setAttribute("totalPage1", totalPage1.intValue());
	        
		}catch(Exception e){
			logger.debug("风险评估--脆弱性威胁关联--访问出错啦！");
			e.printStackTrace();
		}
        
    	return mapping.findForward("dynaVuln");
    }
    
    /**
     * 动态威胁与动态脆弱点关联
     **/
    @SuppressWarnings("unchecked")
	public ActionForward relateToVuln(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	String vulnKindIdSelect = request.getParameter("vulnKindIdSelect");
        String vulnIdSelect = request.getParameter("vulnIdSelect");
        String ip = request.getParameter("ip");
    	request.setAttribute("ip", ip);
        request.setAttribute("vulnKindIdSelect", vulnKindIdSelect);
        request.setAttribute("vulnIdSelect", vulnIdSelect);
        AsseKnowDynaThreForm asseKnowDynaThreForm = (AsseKnowDynaThreForm) form;
        String[] dynaThreIds = asseKnowDynaThreForm.getDynaThreIds();
        Map paraMaps = new HashMap();
	    paraMaps.put("dynaThreIds", dynaThreIds);
	    paraMaps.put("vulnId", vulnIdSelect);
	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
	    threAnalService.relateToVuln(paraMaps, asseInfoProj);
	    
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
 		String s="";
 		for(String str:dynaThreIds){
 			s+=str+",";
 		}
 		log.setOperationDesc("风险评估模块,动态威胁与动态脆弱点关联,动态威胁ID为:"+s.substring(0,s.length()-1)+"动态脆弱点ID为:"+vulnIdSelect);
 		log.setControl("成功");
 		logService.saveSystemLog(log);
    	return showVulnThre(mapping,form,request,response);
    }
    
    /**
     * 保存/更新动态威胁
     **/
    @SuppressWarnings("null")
	public ActionForward saveOrUpdateThre(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)throws Exception{
    	boolean flag = true;
    	AsseKnowDynaThreForm asseKnowDynaThreForm = (AsseKnowDynaThreForm) form;
		AsseKnowDynaThre asseKnowDynaThre = new AsseKnowDynaThre();
		asseKnowDynaThre.setAsseInfoProjId(asseKnowDynaThreForm.getAsseInfoProjId());
		asseKnowDynaThre.setAsseKnowStatThreId(asseKnowDynaThreForm.getAsseKnowStatThreId());
		asseKnowDynaThre.setAsseKnowStatThreKindId(asseKnowDynaThreForm.getAsseKnowStatThreKindId());
		asseKnowDynaThre.setPossibility(asseKnowDynaThreForm.getPossibility());
		asseKnowDynaThre.setThreCode(asseKnowDynaThreForm.getThreCode());
		AsseInfoAsse asseInfoAsse = assetService.findByAssetCode(asseKnowDynaThreForm.getAssetCode());
		Integer asseDynaVulnPoinId = asseKnowDynaThreForm.getAsseDynaVulnPoinId();
		if (asseDynaVulnPoinId != null && !"".equals(asseDynaVulnPoinId)) {
			AsseKnowDynaVuln asseKnowDynaVuln = vulnAnalService.find(asseDynaVulnPoinId);
			asseKnowDynaThre.setAsse(asseKnowDynaVuln.getAsse());
			asseKnowDynaThre.setDynaVuln(asseKnowDynaVuln);
		}

		if (asseKnowDynaThreForm.getId() != null&& asseKnowDynaThreForm.getId() > 0) {
			flag=false;
			asseKnowDynaThre.setId(asseKnowDynaThreForm.getId());
			threAnalService.saveOrUpdate(asseKnowDynaThre);
		} else {
			if (!threAnalService.checkExitDynaVulnPoint(asseKnowDynaThreForm.getAsseInfoProjId(), asseInfoAsse, asseKnowDynaThreForm.getAsseKnowStatThreKindId(), asseKnowDynaThreForm.getAsseKnowStatThreId())) {
				asseKnowDynaThre.setId(null);
				threAnalService.saveOrUpdate(asseKnowDynaThre);
			} else {
				// 该资产关联的脆弱点已存在
				ActionErrors errors = new ActionErrors();
				errors.add("repeatDynaThre", new ActionMessage("asse.err.dynaThre.repeat"));
				saveErrors(request, errors);
			}
		}
	    
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
 		if(flag){
     		log.setOperationDesc("风险评估模块,新增动态威胁,ID为:"+asseKnowDynaThre.getId()+",所属项目ID:"+asseKnowDynaThre.getAsseInfoProjId());
 		}else{
     		log.setOperationDesc("风险评估模块,修改动态威胁,ID为:"+asseKnowDynaThre.getId()+",所属项目ID:"+asseKnowDynaThre.getAsseInfoProjId());
 		}
 		log.setControl("成功");
 		logService.saveSystemLog(log);
	    request.setAttribute("asseKnowDynaThre", asseKnowDynaThre);
	    return showVulnThre(mapping,form,request,response);
    	    
    }
    
    /**
     * 漏洞与威胁关联
     **/
    @SuppressWarnings("unchecked")
	public ActionForward relateLeakToThre(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)throws Exception{
    	
    	String vulnKindIdSelect = request.getParameter("vulnKindIdSelect");
        String vulnIdSelect = request.getParameter("vulnIdSelect");
        String ip = request.getParameter("ip");
    	request.setAttribute("ip", ip);
        request.setAttribute("vulnKindIdSelect", vulnKindIdSelect);
        request.setAttribute("vulnIdSelect", vulnIdSelect);
        String[] leakThreIds = request.getParameterValues("leakThreId");
	    for(int i=0;i<leakThreIds.length;i++) {
	    	System.out.println("leakThreIds["+i+"]:"+leakThreIds[i]);
	    }
	    int indexArray[] = new int[leakThreIds.length];
	    List leakThreList = (List) request.getSession().getAttribute("leakThreList");
	    AsseKnowDynaLeakThre dynaLeakThre = null;
	    for(int m=0;m<leakThreIds.length;m++) {
   	     for(int i=0;i<leakThreList.size();i++) {
   	    	dynaLeakThre = (AsseKnowDynaLeakThre) leakThreList.get(i);
   	    	 if(leakThreIds[m].equals(dynaLeakThre.getId().toString())) {
   	    		 indexArray[m] = i;
   	    	 }
   	     }
   	    }
	    
   	    for(int i=0;i<indexArray.length;i++) {
   	    	System.out.println(indexArray[i]);
   	    }
   	    
   	    String[] leakThreKindIds = request.getParameterValues("leakThreKindId");
   	    String[] leakThreKindIds1 = new String[leakThreIds.length];
   	    for(int i=0;i<indexArray.length;i++) {
   	    	leakThreKindIds1[i] = leakThreKindIds[indexArray[i]];
	    	
	    }
	    for(int i=0;i<leakThreKindIds1.length;i++) {
	    	System.out.println("leakThreKindIds1["+i+"]:"+leakThreKindIds1[i]);
	    }
   	 
   	    String[] leakCveThreIds = request.getParameterValues("leakCveThreId");
   	    String[] leakCveThreIds1 = new String[leakThreIds.length];
   	    for(int i=0;i<indexArray.length;i++) {
   	    	leakCveThreIds1[i] = leakCveThreIds[indexArray[i]];
	    	
	    }
	    for(int i=0;i<leakCveThreIds1.length;i++) {
	    	System.out.println("leakCveThreIds1["+i+"]:"+leakCveThreIds1[i]);
	    }
   	
   	    String[] dynaLeakThreLeves = request.getParameterValues("dynaLeakThreLeve");
   	    String[] dynaLeakThreLeves1 = new String[leakThreIds.length];
   	    for(int i=0;i<indexArray.length;i++) {
   	    	dynaLeakThreLeves1[i] = dynaLeakThreLeves[indexArray[i]];
	    	
	    }
	    for(int i=0;i<dynaLeakThreLeves1.length;i++) {
	    	System.out.println("dynaLeakThreLeves1["+i+"]:"+dynaLeakThreLeves1[i]);
	    }
   	    
	    Map paraMap = new HashMap();
	    paraMap.put("leakThreIds", leakThreIds);
	    paraMap.put("leakThreKindIds", leakThreKindIds1);
	    paraMap.put("leakCveThreIds", leakCveThreIds1);
	    paraMap.put("dynaLeakThreLeves", dynaLeakThreLeves1);
	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
	    dynaLeakThreService.relateLeakToThre(paraMap, asseInfoProj);
	    
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
 		String s="";
 		for(String str:leakThreIds){
 			s+=str+",";
 		}
 		log.setOperationDesc("风险评估模块,漏洞与威胁关联,漏洞ID为:"+s.substring(0,s.length()-1)+",威胁ID为:"+vulnIdSelect);
 		log.setControl("成功");
 		logService.saveSystemLog(log);
	    
	    
	    return showVulnThre(mapping,form,request,response);
    }
    
    public ActionForward look(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)throws Exception{
    	
    	String dynaVulnThreId = request.getParameter("dynaVulnThreId");
    	AsseKnowDynaThre dynaThre = threAnalService.find(dynaVulnThreId);
    	Integer asseKnowStatVulnPoinId = dynaThre.getDynaVuln().getAsseKnowStatVulnPoinId();
    	AsseKnowStatVulnPoin statVulnPoin = statVulnPoinService.find(asseKnowStatVulnPoinId.toString());
    	AsseKnowStatThre statThre = statThreService.find(dynaThre.getAsseKnowStatThreId().toString());
    	request.setAttribute("dynaThre", dynaThre);
    	request.setAttribute("statVulnPoin", statVulnPoin);
    	request.setAttribute("statThre", statThre);
    	
	    return mapping.findForward("look");
    }
    
}
