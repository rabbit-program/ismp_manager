package edu.sjtu.infosec.ismp.manager.RAM.web.actions;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.struts.upload.FormFile;

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
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.LeakScanService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseInfoLeakForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;
/**
 * web层 漏洞扫描Action.
 */
public class LeakScanAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(LeakScanAction.class); 

	//项目管理Manager接口
    private ProjectService projectService;
    
    //漏洞扫描Service接口
    private LeakScanService leakScanService;
    
    //动态资产漏洞分析Service接口
    private DynaLeakService dynaLeakService;
    
    //动态资产漏洞威胁分析Service接口
    private DynaLeakThreService dynaLeakThreService;
    
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}
	
    public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setLeakScanService(LeakScanService leakScanService) {
		this.leakScanService = leakScanService;
	}

	public void setDynaLeakService(DynaLeakService dynaLeakService) {
		this.dynaLeakService = dynaLeakService;
	}

	public void setDynaLeakThreService(DynaLeakThreService dynaLeakThreService) {
		this.dynaLeakThreService = dynaLeakThreService;
	}

	// 往session中加载本次测评项目信息
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
     * 风险计算结果分页
     */
    public ActionForward showLeakScan(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	    
    	    AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
	        AsseInfoProj newasseInfoProj = projectService.find(asseInfoProj.getId());
            newasseInfoProj.setProgress("prog7");
            projectService.saveOrUpdate(newasseInfoProj);
            request.getSession().setAttribute("asseInfoProj", newasseInfoProj);
            
            String ip = null;
            if(request.getParameter("ip")!=null) {
            	ip = request.getParameter("ip");
            	request.setAttribute("ipAddress", ip);
            }
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
    			List<AsseInfoLeak>  leakList = new ArrayList<AsseInfoLeak>();
    			leakList = leakScanService.findAll(startResult, maxResult, newasseInfoProj, ip);

    			//分页定义的相关的基本信息
    			totalNum=leakScanService.getCount(newasseInfoProj, ip);
    			totalPage = Math.ceil((double)totalNum/maxResult);
    			if(totalPage>0 && currPage<=0){
    				currPage = 1;
    			}
			    request.setAttribute("leakList", leakList);           
	            List ipList = leakScanService.listIP(newasseInfoProj);
	            request.setAttribute("ipList", ipList);
    		}catch(Exception e){
    			logger.debug("风险评估--漏洞扫描--访问出错啦！");
    			e.printStackTrace();
    		}
    		request.setAttribute("currPage", currPage);
    		request.setAttribute("totalPage", totalPage.intValue());
	        return mapping.findForward("leakScan");
    }
    
    /**
     * 数据导入
     */
    public ActionForward importDataByXmlFile(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	boolean flag = true;
		AsseInfoLeakForm asseInfoLeakForm = (AsseInfoLeakForm) form;
		try {
			FormFile inputXmlFile = asseInfoLeakForm.getInputXmlFile();
			AsseInfoProj asseInfoProj = projectService.find(new Integer(asseInfoLeakForm.getAsseInfoProjId()));
			System.out.println("inputXmlFile name:"+ inputXmlFile.getFileName());
			if (inputXmlFile.getFileName().endsWith("xml")) {
				InputStream inputXml = inputXmlFile.getInputStream();
				try {
					leakScanService.importDataByXmlFile(asseInfoProj, inputXml);
				} catch (Exception e) {
					ActionErrors errors = new ActionErrors();
					errors.add("xmlAnalError", new ActionMessage("asse.err.xmlAnal"));
					saveErrors(request, errors);
				}
			} else if (inputXmlFile.getFileName().endsWith("xls")) {
				flag = false;
				InputStream inputXls = inputXmlFile.getInputStream();
				try {
					leakScanService.importDataByXlsFile(asseInfoProj, inputXls);
				} catch (Exception e) {
					ActionErrors errors = new ActionErrors();
					errors.add("xlsAnalError", new ActionMessage("asse.err.xlsAnal"));
					saveErrors(request, errors);
				}
			} else {
				ActionErrors errors = new ActionErrors();
				errors.add("fileError",new ActionMessage("asse.err.importFile"));
				saveErrors(request, errors);
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
				log.setOperationDesc("风险评估模块,数据导入,导入xml文件");
			}else{
				log.setOperationDesc("风险评估模块,数据导入,导入xls文件");
			}
			log.setControl("成功");
			logService.saveSystemLog(log);
		
    	}catch(Exception e){
    		
    		ActionErrors errors = new ActionErrors();
            errors.add("xmlFormatError", new ActionMessage("asse.err.xmlFormat"));
            saveErrors(request, errors);
    	}
    	return showLeakScan(mapping,form,request,response);
    }
    
    /**
     * 下一步
     */
    public ActionForward nextStep(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	    
    	    String asseInfoProjId = request.getParameter("asseInfoProjId");
    	    String forward = "/ismp/domain/local/ram/VulnAnalManager.do?method=showVulnAnal&projId="+asseInfoProjId;
    	    AsseInfoProj asseInfoProj = projectService.find(new Integer(asseInfoProjId));
    	    try{
    	        dynaLeakService.saveDynaLeak(asseInfoProj);
    	        
    	    }catch(Exception e){
    	    	return showLeakScan(mapping,form,request,response);	
    	    }
    	    
    	    return new ActionForward(forward);
    }
    
    /**
     * 查看
     */
    public ActionForward look(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	    
    	    String leakId = request.getParameter("leakId");
    	    AsseInfoLeak leak=leakScanService.find(leakId);
    	    request.setAttribute("leak", leak);
    	    return mapping.findForward("look");
    }
    
}
