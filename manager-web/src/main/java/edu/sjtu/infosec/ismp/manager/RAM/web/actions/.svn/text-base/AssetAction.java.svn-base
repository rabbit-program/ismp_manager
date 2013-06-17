package edu.sjtu.infosec.ismp.manager.RAM.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.ERM.model.LinkMan;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoBusi;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.AssetService;
import edu.sjtu.infosec.ismp.manager.RAM.service.BusinessService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicAsseKindService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseInfoAsseForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * web层 资产信息录入Action.
 */
public class AssetAction extends DispatchAction  {
	private static Logger logger = Logger.getLogger(AssetAction.class); 
    
    /**
     * 测评项目服务访问接口
     */
    private ProjectService projectService;
    
    /**
     * 测评项目服务访问接口
     */
    private BusinessService businessService;
    
    /**
     * 资产类型Service接口
     **/
    private DicAsseKindService dicAsseKindService;
    
    /**
     * 资产录入Service接口
     **/
    private AssetService assetService;
    
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

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public void setDicAsseKindService(DicAsseKindService dicAsseKindService) {
		this.dicAsseKindService = dicAsseKindService;
	}

	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
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
     * 资产录入前工作
     */
    public ActionForward preInputAsset(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
        asseInfoProj.setProgress("prog3");
        projectService.saveOrUpdate(asseInfoProj);
        request.getSession().setAttribute("asseInfoProj", asseInfoProj);
        request.getSession().setAttribute("welcome", "yes");
        return showAsse(mapping,form,request,response);
    }
    
    public ActionForward showTopoInfo(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	 AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
         asseInfoProj.setProgress("prog4");
         projectService.saveOrUpdate(asseInfoProj);
         request.getSession().setAttribute("asseInfoProj", asseInfoProj);
         return new ActionForward("/ismp/domain/local/ram/topoInfo.do");
    }
    
    public ActionForward importData(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	    AsseInfoProj AsseInfoProj = loadAsseInfoproj(request);
    	    String asseKindCode = request.getParameter("asseKindCode");
    	    request.setAttribute("asseKindCode", asseKindCode);
    	    assetService.findFromAssetModule(AsseInfoProj.getDomain());
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
         	log.setOperationDesc("风险评估模块从资产管理模块设备基本信息表读取保存数据");
     		log.setControl("成功");
     		logService.saveSystemLog(log);
    	    
    	    
    	    return showAsse(mapping,form,request,response);
    }
    
    /**
     * 资产信息分页
     */
    @SuppressWarnings("unchecked")
	public ActionForward showAsse(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        int currPage = 1;
		Double totalPage = 0d;
		Long totalNum = 0L;
		int startResult = 0;
		int maxResult = 5;
		
        //返回可选资产类别
        List<AsseKnowDicAsseKind> selectedAsseKindList = dicAsseKindService.listDicAsseKind(null);
        String treeList=getTree(selectedAsseKindList,  request.getContextPath());
		try{
	        String asseKindCode = request.getParameter("asseKindCode");
	        if(asseKindCode == null) {
	        	asseKindCode = (String) request.getAttribute("asseKindCode");
	        }
	        System.out.println("asseKindCode:"+asseKindCode);
	        request.setAttribute("asseKindCode", asseKindCode);

	        if(asseKindCode!=null&&!"".equals(asseKindCode)){
		        AsseKnowDicAsseKind asseKind = null;
		        asseKind = dicAsseKindService.find(asseKindCode);
		        request.setAttribute("assekindid", asseKind.getId());
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
				 AsseInfoProj proj=loadAsseInfoproj(request);
	
				//分页定义的相关的基本信息
				totalNum=assetService.getCount(proj.getDomain(),asseKind);
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
				List<AsseInfoAsse> asseList = new ArrayList<AsseInfoAsse>();
				asseList = assetService.findAll(startResult, maxResult, proj.getDomain(),asseKind);
				
				List<AsseInfoBusi> busiList = businessService.find(proj.getDomain());
				List<AsseKnowDicAsseKind> asseKindList = dicAsseKindService.listDicAsseKindByid();
		        request.setAttribute("asseKindList", asseKindList);
		        request.setAttribute("asseList", asseList);
		        request.setAttribute("busiList", busiList);
		        request.setAttribute("welcome", "no");
				List dicSecuLeveList=dicSecuLeveService.findAll();
				request.setAttribute("dicSecuLeveList", dicSecuLeveList);
	        }
		}catch(Exception e){
			logger.debug("风险评估--业务录入--访问出错啦！");
			e.printStackTrace();
		}
		request.setAttribute("treeList", treeList);
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		
        return mapping.findForward("asse");
    }
    
	public String getTree(List<AsseKnowDicAsseKind> AsseKnowList, String basePath) {
		String treeList = "d.add(0,-1,'资产类别');";
		List<Integer> PidList = new ArrayList<Integer>();
		for (AsseKnowDicAsseKind asse : AsseKnowList) {
			PidList.add(asse.getAsse_kind_id());
		}
		for (AsseKnowDicAsseKind asse : AsseKnowList) {
			int pid=0;
			if(asse.getAsse_kind_id()!= null && !"".equals(asse.getAsse_kind_id())){
				pid=asse.getAsse_kind_id();
			}
			if(pid==0&&PidList.contains(asse.getId())){
				treeList = treeList + "d.add(" 
				+ asse.getId() + ","
				+ pid + ","
				+ "'" + asse.getAssetKindName() + "',"
				+ "'" + basePath + "/ismp/domain/local/ram/AssetManager.do?method=preInputAsset"+ "'"
				+ ");";
			}else{
				treeList = treeList + "d.add(" 
				+ asse.getId() + ","
				+ pid + ","
				+ "'" + asse.getAssetKindName() + "',"
				+ "'" + basePath + "/ismp/domain/local/ram/AssetManager.do?method=showAsse&asseKindCode=" + asse.getAssetKindId() + "'"
				+ ");";
			}
		}		
		return treeList;
	}
    
    /**
     * 保存/更新资产信息
     */
    public ActionForward saveAsse(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        boolean flag=true;
        AsseInfoAsse asseInfoAsse = new AsseInfoAsse();
        AsseInfoAsseForm asseInfoAsseForm = (AsseInfoAsseForm) form;
        BeanUtils.copyProperties(asseInfoAsse, asseInfoAsseForm);
        if(asseInfoAsseForm.getAsseKindId()!=null&&!"".equals(asseInfoAsseForm.getAsseKindId())){
        	 AsseKnowDicAsseKind asseKind = dicAsseKindService.findById(asseInfoAsseForm.getAsseKindId());
             asseInfoAsse.setAsseKind(asseKind);
        }
        AsseInfoProj proj=loadAsseInfoproj(request);
        asseInfoAsse.setAsseInfoProjId(proj.getId());
        asseInfoAsse.setDomain(proj.getDomain());
        request.setAttribute("currPage", "1");
        if(asseInfoAsseForm.getId()==null||asseInfoAsseForm.getId()<=0){
        	asseInfoAsse.setId(null);
        }else{
        	flag=false;
        	request.setAttribute("currPage", request.getParameter("currPage"));
        }
        try{
	        assetService.saveOrUpdate(asseInfoAsse);
	        System.out.println("asseInfoAsse buildOk:");
	        
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
         		log.setOperationDesc("风险评估模块,新增资产,ID为:"+asseInfoAsse.getId()+",资产名称为:"+asseInfoAsse.getAssetName());
     		}else{
         		log.setOperationDesc("风险评估模块,修改资产,ID为:"+asseInfoAsse.getId()+",资产名称为:"+asseInfoAsse.getAssetName());
     		}
     		log.setControl("成功");
     		logService.saveSystemLog(log);
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        request.setAttribute("asseInfoAsse", asseInfoAsse);
        return showAsse(mapping,form,request,response);
    }
    
    /**
     * 删除资产信息
     */
    public ActionForward delAsse(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String [] asseCodes = request.getParameterValues("asseCodeSelect");
        for(int i=0;i<asseCodes.length;i++) {
            System.out.println("deleted asseCodes:"+asseCodes[i]);
        }
        try{
            assetService.remove(asseCodes);
            
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
     		for(String str:asseCodes){
     			s+=str+",";
     		}
     		log.setOperationDesc("风险评估模块,删除资产信息,ID为:"+s.substring(0,s.length()-1));
     		log.setControl("成功");
     		logService.saveSystemLog(log);
        }catch(Exception e){
        	e.printStackTrace();
        }
        String asseKindCode=(String) request.getAttribute("asseKindCode");
        request.removeAttribute("asseInfoAsse");
        return showAsse(mapping,form,request,response);
    }
}
