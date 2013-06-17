package edu.sjtu.infosec.ismp.manager.RAM.web.actions;

import java.sql.Timestamp;
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
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoBusi;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.service.BusinessService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseInfoBusiForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * web层 业务信息录入Action.
 */
public class BusinessAction extends DispatchAction{
	private static Logger logger = Logger.getLogger(BusinessAction.class); 

	//测评项目服务访问接口
    private BusinessService businessService;
    
    //测评项目服务访问接口
    private ProjectService projectService;
    
    private DicSecuLeveService dicSecuLeveService;
    
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}
	
    public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
    public void setDicSecuLeveService(DicSecuLeveService dicSecuLeveService) {
		this.dicSecuLeveService = dicSecuLeveService;
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
     * 业务录入分页
     */
    public ActionForward showBusiness(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
        asseInfoProj.setProgress("prog2");
        projectService.saveOrUpdate(asseInfoProj);
        request.getSession().setAttribute("asseInfoProj", asseInfoProj);
        
		int currPage = 1;
		Double totalPage = 0d;
		int totalNum = 0;
		int startResult = 0;
		int maxResult = 5;
		try{
			//分页定义的相关的基本信息
			String cp=null;
			cp =(String) request.getAttribute("currPage");
			if(cp==null||"".equals(cp)){
				cp = (request.getParameter("currPage")==null)?"1":request.getParameter("currPage");
			}
			if(cp!=null && !cp.equals("")){
				currPage = Integer.parseInt(cp);
			}
			startResult = (currPage-1)*maxResult;
			if(startResult < 0){
				startResult = 0;
			}
			
		

			//分页定义的相关的基本信息
			totalNum=businessService.getCount(asseInfoProj.getDomain());
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
			List<AsseInfoBusi> bussList = new ArrayList<AsseInfoBusi>();
			bussList = businessService.findAll(startResult, maxResult,asseInfoProj.getDomain());
			
			request.setAttribute("bussList", bussList);
			List secuLeve=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", secuLeve);
		}catch(Exception e){
			logger.debug("风险评估--业务录入--访问出错啦！");
			e.printStackTrace();
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
        return mapping.findForward("showBusi");
    }
    
    
    /**
     * 保存新建业务信息
     */
    public ActionForward saveNewBusiness(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	boolean flag=true;
    	AsseInfoBusiForm asseForm = (AsseInfoBusiForm)form;
        AsseInfoBusi business = new AsseInfoBusi();
        AsseInfoProj asse = loadAsseInfoproj(request);
        BeanUtils.copyProperties(business, asseForm);
        request.setAttribute("currPage", "1");
        if(asseForm.getId()==null||asseForm.getId()<=0){
        	business.setId(null);
        }else{
        	flag=false;
        	request.setAttribute("currPage", request.getParameter("currPage"));
        }
        business.setDomain(asse.getDomain());
        try{
            businessService.saveOrUpdate(business);
            System.out.println("asseInfoBusi buildOk:");
            request.setAttribute("asseInfoBusi", business);
            
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
         		log.setOperationDesc("风险评估模块,新增业务信息,ID为:"+business.getId()+",业务名称为:"+business.getBusinessName());
     		}else{
         		log.setOperationDesc("风险评估模块,修改业务信息,ID为:"+business.getId()+",业务名称为:"+business.getBusinessName());
     		}
     		log.setControl("成功");
     		logService.saveSystemLog(log);
     		
        }catch(Exception e){
        	e.printStackTrace();
        }
        return showBusiness(mapping, asseForm, request, response);
    }
    
    /**
     * 删除业务信息
     */
    public ActionForward delBusiness(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String [] businessIds = request.getParameterValues("busiIdSelect");
        for(int i=0;i<businessIds.length;i++) {
            System.out.println("deleted businessId:"+businessIds[i]);
        }
        businessService.remove(businessIds);
        
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
 		for(String str:businessIds){
 			s+=str+",";
 		}
 		log.setOperationDesc("风险评估模块,删除业务信息,ID为:"+s.substring(0,s.length()-1));
 		log.setControl("成功");
 		logService.saveSystemLog(log);
        
        return showBusiness(mapping, form, request, response);
    }
    
}
