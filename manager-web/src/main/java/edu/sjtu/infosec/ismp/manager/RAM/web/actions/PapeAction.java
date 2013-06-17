package edu.sjtu.infosec.ismp.manager.RAM.web.actions;

import java.sql.Timestamp;
import java.util.Arrays;
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
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoPape;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatSecuElem;
import edu.sjtu.infosec.ismp.manager.RAM.service.PapeService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatSecuElemService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseInfoPapeForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * web层 问卷调查Action.
 */
public class PapeAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(PapeAction.class); 

    /**
     * 项目管理Service接口
     */
    private ProjectService projectService;
    
    /**
     * 静态安全要素Service接口
     **/
    private StatSecuElemService statSecuElemService;

    /**
     * 问卷调查Service接口
     **/
    private PapeService papeService;
    
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}

    public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setStatSecuElemService(StatSecuElemService statSecuElemService) {
		this.statSecuElemService = statSecuElemService;
	}

	public void setPapeService(PapeService papeService) {
		this.papeService = papeService;
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
     * 问卷设计前工作
     */
    public ActionForward prePaperDesign(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
        asseInfoProj.setProgress("prog5");
        projectService.saveOrUpdate(asseInfoProj);
        String basePath = request.getContextPath();
        String elemCodess=request.getParameter("elemCodess"); 
        String papeSaveSucc= request.getParameter("papeSaveSucc");
        request.setAttribute("elemCodess", elemCodess);
        request.setAttribute("papeSaveSucc", papeSaveSucc);
        String treeList=getDesignTree(basePath,elemCodess,papeSaveSucc);
        request.setAttribute("treeList", treeList);
        request.getSession().setAttribute("asseInfoProj", asseInfoProj);
        return mapping.findForward("papeDesign");
    }
    
    /**
     * 问卷回答前工作
     */
    public ActionForward prePaperAnswer(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
        asseInfoProj.setProgress("prog6");
        projectService.saveOrUpdate(asseInfoProj);
        request.getSession().setAttribute("asseInfoProj", asseInfoProj);
        String saveAll = request.getParameter("saveAll");
        request.setAttribute("saveAll", saveAll);
        String answerTreeList=getAnswerTree(request.getContextPath(),asseInfoProj.getId().toString(),saveAll);
        request.setAttribute("answerTreeList", answerTreeList);
        return mapping.findForward("papeAnswer");
    }
    
    /**
     * 保存问卷前
     */
    public ActionForward preDesignContent(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		    	String basePath = request.getContextPath();
		        String elemCodess=request.getParameter("elemCodess"); 
		        String papeSaveSucc= request.getParameter("papeSaveSucc");
		        request.setAttribute("elemCodess", elemCodess);
		        request.setAttribute("papeSaveSucc", papeSaveSucc);
		        String treeList=getDesignTree(basePath,elemCodess,papeSaveSucc);
		        request.setAttribute("treeList", treeList);
             String elemCode = request.getParameter("elemCode");
             AsseKnowStatSecuElem statSecuElem = new AsseKnowStatSecuElem();
             if(elemCode !=null) {
                 statSecuElem = statSecuElemService.find(elemCode);
             }
             request.setAttribute("statSecuElem", statSecuElem);
             return mapping.findForward("papeDesign");
    }
    
    /**
     * 问卷调查前
     */
    public ActionForward preAnswerContent(ActionMapping mapping, ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception {
    	   
    	    AsseInfoProj asseInfoProj=(AsseInfoProj) request.getSession().getAttribute("asseInfoProj");
    	    String saveAll = request.getParameter("saveAll");
    	    request.setAttribute("saveAll", saveAll);
    	    String answerTreeList=getAnswerTree(request.getContextPath(),asseInfoProj.getId().toString(),saveAll);
    		request.setAttribute("answerTreeList", answerTreeList);
             String elemCode = request.getParameter("elemCode");
             String papeId = request.getParameter("papeId");
             AsseInfoPape asseInfoPape = new AsseInfoPape();
             if(papeId !=null) {
                 asseInfoPape = papeService.findbySecuId(asseInfoProj.getId(),papeId);
             }
             AsseKnowStatSecuElem statSecuElem = new AsseKnowStatSecuElem();
             if(elemCode !=null) {
                 statSecuElem = statSecuElemService.find(elemCode);
             }
             request.setAttribute("selectedStatSecuElem", statSecuElem);
             request.setAttribute("asseInfoPape", asseInfoPape);
             return mapping.findForward("papeAnswer");
    }
    
    /**
     * 获得问卷设计树AsseKnowStatVulnKind
     * */
    public String  getDesignTree(String basePath,String elemCodess,String papeSaveSucc){
		    List<AsseKnowStatSecuElem> secuElemList =statSecuElemService.listStatSecuElem();
    		String treeList = "d.add(0,-1,'请选择安全要素');";
    		for (AsseKnowStatSecuElem asse : secuElemList) {
    			int pid=0;
    			if(asse.getParentSecuElem()!= null && !"".equals(asse.getParentSecuElem())){
    				pid=asse.getParentSecuElem().getId();
    			}
    			if(asse.getName()==null || "".equals(asse.getName())){
    					treeList = treeList + "d.add(" 
    					+ asse.getId() + ","
    					+ pid + ","
    					+ '"'+"<input type='checkbox' name='questionId' id='questionId' class='noneborder' value='"+asse.getElemCode()+"'  onclick='selectParent(this)' />"+asse.getElemCode() + '"'+","
    					+ '"' + basePath + "/ismp/domain/local/ram/papeManager.do?method=preDesignContent&elemCode=" + asse.getElemCode() + "&elemCodess="+elemCodess+"&papeSaveSucc="+papeSaveSucc+'"'
    					+ ");";
    			}else{
    				treeList = treeList + "d.add(" 
					+ asse.getId() + ","
					+ pid + ","
					+ '"'+"<input type='checkbox' name='parentQuestionId' id='parentQuestionId' class='noneborder' value='"+asse.getElemCode()+"'  onclick='selectChildren(this)' />"+asse.getName() + '"'
	 			    + ");";
    			}
    		}		
    	return treeList;
    }
    
    
    /**
     * 获得问卷调查树AsseKnowStatVulnKind
     * */
    public String  getAnswerTree(String basePath,String asseInfoProjId,String saveAll){
		    List<AsseKnowStatSecuElem> secuElemList =statSecuElemService.listStatSecuElem();
			List list = papeService.listSelectedStatSecuElems(asseInfoProjId);
    		String treeList = "d.add(0,-1,'安全要素');";
    		for (AsseKnowStatSecuElem asse : secuElemList) {
    			int pid=0;
    			if(asse.getParentSecuElem()!= null && !"".equals(asse.getParentSecuElem())){
    				pid=asse.getParentSecuElem().getId();
    			}
    			if(asse.getName()==null || "".equals(asse.getName())){
    				if(list.contains(asse)){
    					treeList = treeList + "d.add(" 
    					+ asse.getId() + ","
    					+ pid + ","
    					+ '"'+"<input type='checkbox' name='questionId' id='questionId'  class='noneborder'  value='"+asse.getElemCode()+"' disabled/>"+asse.getElemCode() + '"'+","
    					+ '"' + basePath + "/ismp/domain/local/ram/papeManager.do?method=preAnswerContent&elemCode="+asse.getElemCode()+"&papeId="+asse.getId()+"&saveAll="+saveAll + '"'
    					+ ");";
    				}
    			}else{
    				treeList = treeList + "d.add(" 
					+ asse.getId() + ","
					+ pid + ","
					+ '"'+asse.getName() + '"'
	 			    + ");";
    			}
    		}		
    	return treeList;
    }
    
    /**
     * 保存问卷
     */
    public ActionForward saveDesignContent(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	   ActionErrors errors = new ActionErrors();
           String elemCodes = request.getParameter("elemCodes");
           System.out.println(elemCodes);
           String s = request.getParameter("elemCodess");
           String elemCodess=null;
           if(s!=null&&s!=""){
               elemCodess=elemCodes+s;
               request.setAttribute("elemCodess",elemCodess);
           }else{
        	   elemCodess=elemCodes;
        	   request.setAttribute("elemCodess",elemCodess);
           }
           String basePath = request.getContextPath();
           AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
        try{
           papeService.batchSaveOrUpdate(elemCodes, asseInfoProj);
           errors.add("saveOk", new ActionMessage("pape.msg.saveOk"));
           saveErrors(request, errors);
           String papeSaveSucc ="ok";
           String treeList=getDesignTree(basePath,elemCodess,papeSaveSucc);
           request.setAttribute("treeList", treeList);
           request.setAttribute("papeSaveSucc",papeSaveSucc);
           
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
    		log.setOperationDesc("风险评估模块,保存问题,问题编码为:"+elemCodes);
    		log.setControl("成功");
    		logService.saveSystemLog(log);
        } catch(Exception e) {
            e.printStackTrace();
        }
           return mapping.findForward("papeDesign");
    }
    
    /**
     * 下一题
     */
    public ActionForward nextQuestion(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
	    AsseInfoProj asseInfoProj=(AsseInfoProj) request.getSession().getAttribute("asseInfoProj");
		
        String elemCode = request.getParameter("elemCode");
        AsseKnowStatSecuElem selectedStatSecuElem = new AsseKnowStatSecuElem();
        if(elemCode !=null) {
            selectedStatSecuElem = statSecuElemService.find(elemCode);
        }
        AsseInfoPape asseInfoPape = new AsseInfoPape();
        AsseInfoPape nextQuestion = new AsseInfoPape();
        AsseInfoPapeForm asseForm = (AsseInfoPapeForm)form;
        BeanUtils.copyProperties(asseInfoPape, asseForm);

        asseInfoPape.setSecuElem(selectedStatSecuElem);
        papeService.saveOrUpdate(asseInfoPape);
        nextQuestion = papeService.getNextQuestion(asseInfoPape);
        String saveAll = null;
        if(nextQuestion.getId()!=null) {
            request.setAttribute("selectedStatSecuElem", nextQuestion.getSecuElem());
            request.setAttribute("asseInfoPape", nextQuestion);
        }else{
        	saveAll="ok";
        	request.setAttribute("saveAll", saveAll);
        	request.setAttribute("asseInfoPape", asseInfoPape);
        	request.setAttribute("selectedStatSecuElem", asseInfoPape.getSecuElem());
        }
        String answerTreeList=getAnswerTree(request.getContextPath(),asseInfoProj.getId().toString(),saveAll);
		request.setAttribute("answerTreeList", answerTreeList);
		
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
		log.setOperationDesc("风险评估模块,回答问题,问题ID为:"+asseInfoPape.getId()+",问题编码为:"+elemCode);
		log.setControl("成功");
		logService.saveSystemLog(log);
		
        return mapping.findForward("papeAnswer");
    }
    
    /**
     * 下一步
     */
    public ActionForward nextStep(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	//String s = request.getContextPath();
    	String cpKind = (String) request.getSession().getAttribute("cpKind");
    	String asseInfoProjId = request.getParameter("asseInfoProjId");
    	String forward = "/ismp/domain/local/ram/leakScanManager.do?method=showLeakScan&projId="+asseInfoProjId;
    	papeService.saveDynaVulnPoint(asseInfoProjId);
    	if("cp1".equals(cpKind)) {
    		forward = "/ismp/domain/local/ram/VulnAnalManager.do?method=showVulnAnal&projId="+asseInfoProjId;
    	}
    	return new ActionForward(forward);
    }
}
