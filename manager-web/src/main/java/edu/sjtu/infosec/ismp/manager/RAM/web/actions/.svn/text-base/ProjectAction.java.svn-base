package edu.sjtu.infosec.ismp.manager.RAM.web.actions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicAsseStatService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicCpKindService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseInfoProjForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * web层 项目管理Action.
 */
public class ProjectAction extends DispatchAction{

	private static Logger logger = Logger.getLogger(ProjectAction.class); 
    
   //测评项目服务访问接口
    private ProjectService projectService;
    
	private DomainService domainService;
	
	private DicSecuLeveService dicSecuLeveService;
	
	private DicAsseStatService dicAsseStatService;
    
	private DicCpKindService dicCpKindService;
	
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}
	
    public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	

    public void setDicSecuLeveService(DicSecuLeveService dicSecuLeveService) {
		this.dicSecuLeveService = dicSecuLeveService;
	}

    
	public void setDicAsseStatService(DicAsseStatService dicAsseStatService) {
		this.dicAsseStatService = dicAsseStatService;
	}

	
	public void setDicCpKindService(DicCpKindService dicCpKindService) {
		this.dicCpKindService = dicCpKindService;
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
        }
        request.getSession().setAttribute("asseInfoProj", asseInfoProj);
      } else {
        asseInfoProj = (AsseInfoProj) request.getSession().getAttribute("asseInfoProj");  
      }
        return asseInfoProj;
    }
    
	// 测评项目分页
    public ActionForward showProject(ActionMapping mapping,ActionForm form,HttpServletRequest request,
            HttpServletResponse response) throws Exception{
		int currPage = 1;
		Double totalPage = 0d;
		Long totalNum = 0l;
		int startResult = 0;
		int maxResult = 5;
		Domain domain = null;
		try{
			String isAll = (request.getParameter("isAll")==null)?"0":request.getParameter("isAll");
			System.out.println("---------------isAll:----------"+isAll);
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			
			//分页定义的相关的基本信息
			String cp = (request.getParameter("currPage")==null)?"1":request.getParameter("currPage");
			if(cp!=null && !cp.equals("")){
				currPage = Integer.parseInt(cp);
			}
			startResult = (currPage-1)*maxResult;
			if(startResult < 0){
				startResult = 0;
			}
			
			AsseInfoProjForm show=(AsseInfoProjForm)form;
			request.setAttribute("offcPers", show.getOffcPers());
			request.setAttribute("assePers", show.getAssePers());
			request.setAttribute("secuLeve1", show.getSecuLeve());
			request.setAttribute("asseBeginTime", show.getAsseBeginTime());
			request.setAttribute("asseEndTime", show.getAsseEndTime());
			//数据相关的基本信息
			List<AsseInfoProj> projList = new ArrayList<AsseInfoProj>();
			domain = domainService.findById(show.getOffcPers());
			if(isAll.equals("1")){
				request.setAttribute("isAll", isAll);
				projList = projectService.findAll(show.getAsseBeginTime(), show.getAsseEndTime(), startResult, maxResult,show.getOffcPers(),domain,show.getAssePers(),show.getSecuLeve());
			}else{
				projList = projectService.findAllByDomain(userDomainList, null, null, startResult, maxResult,show.getOffcPers(),domain,show.getAssePers(),show.getSecuLeve());
			}
			
			//分页定义的相关的基本信息
			if(projList!=null && projList.size()>=0){
				if(isAll.equals("1")){
					totalNum=projectService.findAllNum(null,null,show.getOffcPers(),domain,show.getAssePers(),show.getSecuLeve());
				}else{
					totalNum = projectService.findAllNumByDomain(userDomainList, null, null,show.getOffcPers(),show.getAssePers(),show.getSecuLeve());
				}
			}
			totalPage = Math.ceil((double)totalNum/maxResult);
			if(totalPage>0 && currPage<=0){
				currPage = 1;
			}
			
			request.setAttribute("udl", userDomainList);
			request.setAttribute("projList", projList);
			List secuLeve=dicSecuLeveService.findAll();
			request.setAttribute("secuLeve", secuLeve);
			List dicAsseStatList =dicAsseStatService.listDicAsseStat(null);
			request.setAttribute("dicAsseStatList", dicAsseStatList);

		}catch(Exception e){
			logger.debug("风险评估-首页访问出错啦！");
			e.printStackTrace();
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		
		return mapping.findForward("show");
    }
    
    /**
     * 新建项目前
     * 用Token来防止后退重复提交
     */
    public ActionForward preBuildNewProject(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    		String again = request.getParameter("again");
    		if("y".equalsIgnoreCase(again)) {
                 request.getSession().removeAttribute("asseInfoProj");
            }
            OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			request.setAttribute("udl", userDomainList);
			List dicCpKindList=dicCpKindService.listDicCpKind(null);
			request.setAttribute("dicCpKindList", dicCpKindList);
            return mapping.findForward("newProject");
    }
    

    /**
     * 保存新建项目信息
     * 用Token来检验是否重复提交
     */
    public ActionForward saveNewProject(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        AsseInfoProj asseInfoProj = new AsseInfoProj();
        if(isTokenValid(request)) {
        	 resetToken(request);
        }
        try{
         loadAsseInfoproj(request);
         AsseInfoProjForm projForm=(AsseInfoProjForm)form;
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	 Timestamp registerDate= null;
    	 if(projForm.getAsseBeginTime()!=null&&!"".equals(projForm.getAsseBeginTime())){
    		 registerDate = new Timestamp(sdf.parse(projForm.getAsseBeginTime()).getTime()); 
    	 }
		 Domain domain = domainService.findById(projForm.getOffcPers());
		 	 asseInfoProj.setId(projForm.getId());
		 	 asseInfoProj.setAddress(projForm.getAddress());
			 asseInfoProj.setAsseBeginTime(registerDate);
			 asseInfoProj.setAsseComp(projForm.getAsseComp());
			 asseInfoProj.setAssePers(projForm.getAssePers());
			 asseInfoProj.setAsseStatus(projForm.getAsseStatus());
			 asseInfoProj.setCpKind(projForm.getCpKind());
			 asseInfoProj.setLawPers(projForm.getLawPers());
			 asseInfoProj.setLinkway(projForm.getLinkway());
			 asseInfoProj.setPhone(projForm.getPhone());
			 asseInfoProj.setProgress(projForm.getProgress());
			 asseInfoProj.setProjName(projForm.getProjName());
			 asseInfoProj.setSecuLeve(projForm.getSecuLeve());
			 asseInfoProj.setZipcode(projForm.getZipcode());
	         asseInfoProj.setDomain(domain);
         projectService.saveOrUpdate(asseInfoProj);
         request.getSession().setAttribute("asseInfoProj", asseInfoProj);
         System.out.println("asseInfoProj buildOk:");
         System.out.println("saved asseInfoProj:"+asseInfoProj.toString());
         
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
 		log.setOperationDesc("风险评估模块,新增测评项目,ID为:"+asseInfoProj.getId()+",项目名称为:"+asseInfoProj.getProjName());
 		log.setControl("成功");
 		logService.saveSystemLog(log);
         
         
        } catch(Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("cpKind", asseInfoProj.getCpKind());
        return new ActionForward("/ismp/domain/local/ram/businessManager.do?method=showBusiness" );
        
    }
    
    /**
     * 继续测评功能
     */
    public ActionForward contAsse(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
           
        String projId = request.getParameter("projId");
        String progress = request.getParameter("progress");
        String forward = "";
        AsseInfoProj asseInfoProj = null;
        if(projId != null && !"".equals(projId.trim())) {
         Integer projCode = new Integer(projId);
         asseInfoProj = projectService.find(projCode);
         System.out.println("find asseInfoProj:"+asseInfoProj.toString());
        }
           request.getSession().setAttribute("asseInfoProj", asseInfoProj);
           request.getSession().setAttribute("cpKind", asseInfoProj.getCpKind());
           if("prog1".equals(progress)) {
               forward = "/ismp/domain/local/ram/projManager.do?method=preBuildNewProject&projId="+asseInfoProj.getId().toString();
           }else if("prog2".equals(progress)){
               forward = "/ismp/domain/local/ram/businessManager.do?method=showBusiness&projId="+asseInfoProj.getId().toString();
           }else if("prog3".equals(progress)){
               forward = "/ismp/domain/local/ram/AssetManager.do?method=preInputAsset&projId="+asseInfoProj.getId().toString();
           }else if("prog4".equals(progress)){
               forward = "/ismp/domain/local/ram/topoInfo.do?projId="+asseInfoProj.getId().toString();
           }else if("prog5".equals(progress)){
               forward = "/ismp/domain/local/ram/papeManager.do?method=prePaperDesign&projId="+asseInfoProj.getId().toString();
           }else if("prog6".equals(progress)){
               forward = "/ismp/domain/local/ram/papeManager.do?method=prePaperAnswer&projId="+asseInfoProj.getId().toString();
           }else if("prog7".equals(progress)){
               forward = "/ismp/domain/local/ram/leakScanManager.do?method=showLeakScan&projId="+asseInfoProj.getId().toString();
           }else if("prog8".equals(progress)){
               forward = "/ismp/domain/local/ram/VulnAnalManager.do?method=showVulnAnal&projId="+asseInfoProj.getId().toString();
           }else if("prog9".equals(progress)){
               forward = "/ismp/domain/local/ram/ThreAnalManager.do?method=showThreAnal&projId="+asseInfoProj.getId().toString();
           }else if("prog10".equals(progress)){
               forward = "/ismp/domain/local/ram/VulnThreRelaManager.do?method=showVulnThre&projId="+asseInfoProj.getId().toString();
           }else if("prog11".equals(progress)){
               forward = "/ismp/domain/local/ram/CalManager.do?method=preCal&projId="+asseInfoProj.getId().toString();
           }else if("prog12".equals(progress)){
               forward = "/ismp/domain/local/ram/reportManager.do?method=preReport&projId="+asseInfoProj.getId().toString();
           }
           
           return new ActionForward(forward);
    }
}
