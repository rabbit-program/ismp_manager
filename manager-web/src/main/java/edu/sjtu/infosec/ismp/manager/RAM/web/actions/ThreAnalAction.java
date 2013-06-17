package edu.sjtu.infosec.ismp.manager.RAM.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
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
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoBusi;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.service.AssetService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicAsseKindService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatThreKindService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ThreAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.service.VulnAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseKnowDynaThreForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;
/**
 * web层 动态威胁分析Action.
 */
public class ThreAnalAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(ThreAnalAction.class); 
    /**
     * 项目管理Manager接口
     */
    private ProjectService projectService;
    /**
     * 资产录入Service接口
     **/
    private AssetService assetService;
    /**
     * 资产类型Service接口
     **/
    private DicAsseKindService dicAsseKindService;
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

	public void setDicAsseKindService(DicAsseKindService dicAsseKindService) {
		this.dicAsseKindService = dicAsseKindService;
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
     * 动态脆弱点分页
     */
    public ActionForward showThreAnal(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
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
			
	        AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
	        asseInfoProj.setProgress("prog9");
	        projectService.saveOrUpdate(asseInfoProj);
	        request.getSession().setAttribute("asseInfoProj", asseInfoProj);
	        
	        String assetKindIdSelect = request.getParameter("assetKindIdSelect");
	        if(assetKindIdSelect==null) {
	        	assetKindIdSelect = (String) request.getAttribute("assetKindIdSelect");
	        }
	        String assetCodeSelect =null;
	        if(request.getParameter("assetCodeSelect")!=null){
				assetCodeSelect = new String(request.getParameter("assetCodeSelect").getBytes("ISO8859-1"), "UTF-8");
	        }

	        if(assetCodeSelect==null) {
	        	assetCodeSelect = (String) request.getAttribute("assetCodeSelect");
	        }
	        AsseInfoAsse asseInfoAsse = null;
	        if(assetKindIdSelect!=null) {
	        	request.setAttribute("assetKindIdSelect", assetKindIdSelect);
	        }
	        if(assetCodeSelect!=null) {
	            asseInfoAsse = assetService.findByAssetCode(assetCodeSelect);
	            request.setAttribute("asseCodeSelect", assetCodeSelect);
	            request.setAttribute("asseInfoAsse", asseInfoAsse);
	        }
	
	        //返回可选资产类别列表
	        List selectedAsseKindList = dicAsseKindService.listDicAsseKindByid();
	        request.setAttribute("selectedAsseKindList", selectedAsseKindList);
	        
	        //返回可选资产列表
	        List assertList = assetService.find(asseInfoProj.getDomain(), null);
	        request.setAttribute("assertList", assertList);
	        
	        //分页定义的相关的基本信息
			totalNum=threAnalService.getCount(asseInfoProj,asseInfoAsse);
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
			List<AsseKnowDynaThre> threAnalList = new ArrayList<AsseKnowDynaThre>();
			threAnalList = threAnalService.findAll(startResult, maxResult,asseInfoProj,asseInfoAsse);
			
			List secuLeve=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", secuLeve);
			
			//返回所有静态威胁类别列表
	        List statThreKindList = statThreKindService.listAllStatThreKind();
	        request.setAttribute("statThreKindList", statThreKindList);
	        
	        //返回所有静态威胁列表
	        List statThreList = statThreService.listAllStatThre();
	        request.setAttribute("statThreList", statThreList);
			
			request.setAttribute("threAnalList", threAnalList);
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalPage", totalPage.intValue());
		}catch(Exception e){
			logger.debug("风险评估--业务录入--访问出错啦！");
			e.printStackTrace();
		}
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
    	return mapping.findForward("thre");
    }
    
    /**
     * 动态威胁与资产关联
     **/
    @SuppressWarnings("unchecked")
	public ActionForward relateToAssert(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	    String assetKindIdSelect = request.getParameter("assetKindIdSelect");
			String assetCodeSelect = new String(request.getParameter("assetCodeSelect").getBytes("ISO8859-1"), "UTF-8");
	        AsseKnowDynaThreForm asseKnowDynaThreForm = (AsseKnowDynaThreForm) form;
	        String[] dynaThreIds = asseKnowDynaThreForm.getDynaThreIds();
	        Map paraMaps = new HashMap();
    	    paraMaps.put("dynaThreIds", dynaThreIds);
    	    paraMaps.put("assetCode", assetCodeSelect);
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
    	    threAnalService.relateToAssert(paraMaps, asseInfoProj);
    	    
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
     		String s = "";
     		for(String str:dynaThreIds){
     			s+=str+",";
     		}
     		log.setOperationDesc("风险评估模块,动态威胁与资产关联,动态威胁ID为:"+s.substring(0,s.length()-1)+",关联资产编号为:"+assetCodeSelect);
     		log.setControl("成功");
     		logService.saveSystemLog(log);
    	    return showThreAnal(mapping,form,request,response);
    }
    
    /**
     * 批量删除动态威胁
     **/
    public ActionForward batchDeleteDynaThre(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	    
    	    String assetKindIdSelect = request.getParameter("assetKindIdSelect");
	        String assetCodeSelect = request.getParameter("assetCodeSelect");
	        request.setAttribute("assetKindIdSelect", assetKindIdSelect);
	        request.setAttribute("assetCodeSelect", assetCodeSelect);
	        AsseKnowDynaThreForm asseKnowDynaThreForm = (AsseKnowDynaThreForm) form;
	        String[] dynaThreIds = asseKnowDynaThreForm.getDynaThreIds();
	        threAnalService.remove(dynaThreIds);
	        
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
     		log.setOperationDesc("风险评估模块,删除动态威胁,ID为:"+s.substring(0,s.length()-1));
     		log.setControl("成功");
     		logService.saveSystemLog(log);
    	    return showThreAnal(mapping,form,request,response);
    }
    
    /**
     * 保存/更新动态威胁
     **/
    public ActionForward saveOrUpdateThre(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)throws Exception{
    		boolean flag = true;
    	    AsseKnowDynaThreForm dynaThreForm = (AsseKnowDynaThreForm) form;
    	    	AsseKnowDynaThre dynaThre = new AsseKnowDynaThre();
	    	    dynaThre.setAsseInfoProjId(dynaThreForm.getAsseInfoProjId());
	    	    dynaThre.setAsseKnowStatThreId(dynaThreForm.getAsseKnowStatThreId());
	    	    dynaThre.setAsseKnowStatThreKindId(dynaThreForm.getAsseKnowStatThreKindId());
	    	    dynaThre.setPossibility(dynaThreForm.getPossibility());
	    	    dynaThre.setThreCode(dynaThreForm.getThreCode());
    	    AsseInfoAsse asseInfoAsse = assetService.findByAssetCode(dynaThreForm.getAssetCode());
    	    Integer asseDynaVulnPoinId = dynaThreForm.getAsseDynaVulnPoinId();
    	    if(asseDynaVulnPoinId!=null && asseDynaVulnPoinId>0) {
    	     AsseKnowDynaVuln asseKnowDynaVuln = vulnAnalService.find(asseDynaVulnPoinId);
    	     asseKnowDynaVuln.setAsse(asseInfoAsse);
    	     dynaThre.setDynaVuln(asseKnowDynaVuln);
    	    }
    	    request.setAttribute("assetKindIdSelect", asseInfoAsse.getAsseKind().getAssetKindId());
   	        request.setAttribute("assetCodeSelect", dynaThreForm.getAssetCode());
   	        dynaThre.setAsse(asseInfoAsse);
   	        
   	        
   	 	    if (dynaThreForm.getId() != null && dynaThreForm.getId()>0) {
   	 	      flag = false;
   	 		  dynaThre.setId(dynaThreForm.getId());
   	    	  threAnalService.saveOrUpdate(dynaThre);
    	    }else{
    	    	if(!threAnalService.checkExitDynaVulnPoint(dynaThreForm.getAsseInfoProjId(), asseInfoAsse, dynaThreForm.getAsseKnowStatThreKindId(), dynaThreForm.getAsseKnowStatThreId())) {
    	    		threAnalService.saveOrUpdate(dynaThre);
       		 	}else{
       			 //该资产关联的脆弱点已存在
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
         		log.setOperationDesc("风险评估模块,新增动态威胁,ID为:"+dynaThre.getId()+",所属项目ID:"+dynaThre.getAsseInfoProjId());
     		}else{
         		log.setOperationDesc("风险评估模块,修改动态威胁,ID为:"+dynaThre.getId()+",资产名称为:"+dynaThre.getAsseInfoProjId());
     		}
     		log.setControl("成功");
     		logService.saveSystemLog(log);
   	 	    
   	        request.setAttribute("asseKnowDynaThre", dynaThre);
   	        return showThreAnal(mapping,form,request,response);
    }
    
}
