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

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoBusi;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.RAM.service.AssetService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicAsseKindService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DynaLeakThreService;
import edu.sjtu.infosec.ismp.manager.RAM.service.LeakScanService;
import edu.sjtu.infosec.ismp.manager.RAM.service.PapeService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatVulnKindService;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatVulnPoinService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ThreAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.service.VulnAnalService;
import edu.sjtu.infosec.ismp.manager.RAM.web.form.AsseKnowDynaVulnForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * web层 动态脆弱点分析Action.
 */
public class VulnAnalAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(VulnAnalAction.class);
	/**
	 * 项目管理Manager接口
	 */
	private ProjectService projectService;

	/**
	 * 动态脆弱点分析Service接口
	 */
	private VulnAnalService vulnAnalService;

	/**
	 * 资产录入Service接口
	 * 
	 **/
	private AssetService assetService;

	/**
	 * 静态脆弱点类别Service接口
	 */
	private StatVulnKindService statVulnKindService;

	/**
	 * 静态脆弱点Service接口
	 */
	private StatVulnPoinService statVulnPoinService;

	/**
	 * 资产类型Service接口
	 * 
	 **/
	private DicAsseKindService dicAsseKindService;

	/**
	 * 问卷调查Service接口
	 **/
	private PapeService papeService;

	/**
	 * 威胁分析Service接口
	 * 
	 **/
	private ThreAnalService threAnalService;

	/**
	 * 动态漏洞分析Service接口
	 * 
	 **/
	private DynaLeakService dynaLeakService;

	/**
	 * 动态漏洞威胁分析Service接口
	 * 
	 **/
	private DynaLeakThreService dynaLeakThreService;

	/**
	 * 漏洞扫描Service接口
	 */
	private LeakScanService leakScanService;

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

	public void setVulnAnalService(VulnAnalService vulnAnalService) {
		this.vulnAnalService = vulnAnalService;
	}

	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

	public void setStatVulnKindService(StatVulnKindService statVulnKindService) {
		this.statVulnKindService = statVulnKindService;
	}

	public void setStatVulnPoinService(StatVulnPoinService statVulnPoinService) {
		this.statVulnPoinService = statVulnPoinService;
	}

	public void setDicAsseKindService(DicAsseKindService dicAsseKindService) {
		this.dicAsseKindService = dicAsseKindService;
	}

	public void setPapeService(PapeService papeService) {
		this.papeService = papeService;
	}

	public void setThreAnalService(ThreAnalService threAnalService) {
		this.threAnalService = threAnalService;
	}

	public void setDynaLeakService(DynaLeakService dynaLeakService) {
		this.dynaLeakService = dynaLeakService;
	}

	public void setDynaLeakThreService(DynaLeakThreService dynaLeakThreService) {
		this.dynaLeakThreService = dynaLeakThreService;
	}

	public void setLeakScanService(LeakScanService leakScanService) {
		this.leakScanService = leakScanService;
	}

	/**
	 * 往session中加载本次测评项目信息
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return AsseInfoInst
	 */
	private AsseInfoProj loadAsseInfoproj(HttpServletRequest request) {
		AsseInfoProj asseInfoProj = null;
		if (request.getSession().getAttribute("asseInfoProj") == null) {

			String projId = request.getParameter("projId");
			if (projId != null && !"".equals(projId.trim())) {
				Integer projCode = new Integer(projId);
				asseInfoProj = projectService.find(projCode);
				System.out.println("find asseInfoProj:"
						+ asseInfoProj.toString());
			}
			request.getSession().setAttribute("asseInfoProj", asseInfoProj);
		} else {
			asseInfoProj = (AsseInfoProj) request.getSession().getAttribute(
					"asseInfoProj");
		}
		return asseInfoProj;
	}

	/**
	 * 动态脆弱点分页
	 */
	public ActionForward showVulnAnal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
		asseInfoProj.setProgress("prog8");
		projectService.saveOrUpdate(asseInfoProj);
		request.getSession().setAttribute("asseInfoProj", asseInfoProj);

		String assetKindIdSelect = request.getParameter("assetKindIdSelect");
		if (assetKindIdSelect == null) {
			assetKindIdSelect = (String) request.getAttribute("assetKindIdSelect");
		}
		String assetCodeSelect =null;
		assetCodeSelect = (String) request.getAttribute("assetCodeSelect");
		if (assetCodeSelect == null&&request.getParameter("assetCodeSelect")!=null) {
			assetCodeSelect = new String(request.getParameter("assetCodeSelect").getBytes("ISO8859-1"), "UTF-8");
		}
		AsseKnowDicAsseKind asseKind = null;
		AsseInfoAsse asseInfoAsse = null;
		if (assetKindIdSelect != null) {
			asseKind = assetService.findAsseKind(assetKindIdSelect);
			request.setAttribute("asseKindSelect", assetKindIdSelect);
		}
		if (assetCodeSelect != null) {
			asseInfoAsse = assetService.findByAssetCode(assetCodeSelect);
			request.setAttribute("asseCodeSelect", assetCodeSelect);
			request.setAttribute("asseInfoAsse", asseInfoAsse);
		}
		// 由问卷产生的脆弱点列表
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
			totalNum=vulnAnalService.getCount(asseInfoProj,asseInfoAsse);
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
			List<AsseKnowDynaVuln> vulnAnalList = new ArrayList<AsseKnowDynaVuln>();
			vulnAnalList = vulnAnalService.listDynaVulnPoint(startResult, maxResult,asseInfoProj,asseInfoAsse);
			
			request.setAttribute("vulnAnalList", vulnAnalList);
			List secuLeve=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", secuLeve);
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalPage", totalPage.intValue());
			
			// 返回可选资产类别列表
			List selectedAsseKindList = dicAsseKindService.listDicAsseKindByid();
			System.out.println("selectedAsseKindList.size():"
					+ selectedAsseKindList.size());
			request.setAttribute("selectedAsseKindList", selectedAsseKindList);
			// 返回可选脆弱点类别列表
			Page page1 = new Page();
			page1.setEveryPage(new Integer("5").intValue());
			page1.setCurrentPage(Integer.parseInt("1"));
			List vulnKindList = statVulnKindService.listStatVulnKindPage(page1).getPageList();
			System.out.println("vulnKindList.size():" + vulnKindList.size());
			request.setAttribute("vulnKindList", vulnKindList);
			// 返回可选资产列表
			List assertList = assetService.find(asseInfoProj.getDomain(), null);
			System.out.println("assertList.size():" + assertList.size());
			request.setAttribute("assertList", assertList);

			// 返回所有静态脆弱点
			List allStatVulnPoinList = statVulnPoinService.listAllStatVulnPoin();
			request.setAttribute("allStatVulnPoinList", allStatVulnPoinList);

			List dicSecuLeveList=dicSecuLeveService.findAll();
			request.setAttribute("dicSecuLeveList", dicSecuLeveList);
			
			// 返回漏洞扫描发现的IP列表
			List ipList = leakScanService.listIP(asseInfoProj);
			System.out.println("ipList.size:" + ipList.size());
			request.setAttribute("ipList", ipList);

			// 由漏洞扫描发现的资产
			List<AsseInfoAsse> dynaLeakAsseList = new ArrayList<AsseInfoAsse>();
			if (ipList != null && ipList.size() > 0) {
				for (int i = 0; i < ipList.size(); i++) {
					String ipAdd = (String) ipList.get(i);
					List<AsseInfoAsse> assetInfo = assetService.findByIP(ipAdd);
					if (assetInfo != null) {
						for(AsseInfoAsse asse : assetInfo)
						dynaLeakAsseList.add(asse);
					}
				}
			}

			request.setAttribute("dynaLeakAsseList", dynaLeakAsseList);

			// 由扫描报告导入的漏洞列表
			String ip = request.getParameter("ip");
			List<AsseInfoAsse> asseInfo = null;
			if (ip == null ||"".equals(ip)) {
				ip = (String) request.getAttribute("ip");
			}
			if (ip != null && !"".equals(ip)) {
				ip = request.getParameter("ip");
				request.setAttribute("ipAddress", ip);
				asseInfo= assetService.findByIP(ip);
				if("".equals(asseInfo)){
					asseInfo=null;
				}
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
		

			//分页定义的相关的基本信息
			totalNum1=dynaLeakService.getCount(asseInfoProj,asseInfo);
			totalPage1 = Math.ceil((double)totalNum1/maxResult1);
			if(totalPage1>0 && currPage1<=0){
				currPage1 = 1;
			}
			
			//数据相关的基本信息
			List<AsseKnowDynaLeak> dynaLeakList = new ArrayList<AsseKnowDynaLeak>();
			dynaLeakList = dynaLeakService.listDynaLeakPage(startResult1, maxResult1,asseInfoProj,asseInfo);
			
			request.getSession().setAttribute("dynaLeakList", dynaLeakList);
			request.setAttribute("currPage1", currPage1);
			request.setAttribute("totalPage1", totalPage1.intValue());
		}catch(Exception e){
			logger.debug("风险评估--动态脆弱点分析--访问出错啦！");
			e.printStackTrace();
		}
		
		return mapping.findForward("vuln");
	}

	/**
	 * 动态脆弱点与资产关联
	 **/
	@SuppressWarnings("unchecked")
	public ActionForward relateToAssert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String assetCodeSelect = new String(request.getParameter("assetCodeSelect").getBytes("ISO8859-1"), "UTF-8");
		request.setAttribute("assetCodeSelect", assetCodeSelect);
		AsseKnowDynaVulnForm asseKnowDynaVulnForm = (AsseKnowDynaVulnForm) form;
		String[] dynaVulnPoinIds = asseKnowDynaVulnForm.getDynaVulnPoinIds();
		
		if(dynaVulnPoinIds!=null && !"".equals(dynaVulnPoinIds)){
			Map paraMaps = new HashMap();
			paraMaps.put("dynaVulnPoinIds", dynaVulnPoinIds);
			paraMaps.put("assetCode", assetCodeSelect);
			AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
			vulnAnalService.batchSaveOrUpdate(paraMaps, asseInfoProj);
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
 		String s="";
 		for(String str:dynaVulnPoinIds){
 			s+=str+",";
 		}
 		log.setOperationDesc("风险评估模块,动态脆弱点与资产关联,动态脆弱点ID为:"+s.substring(0,s.length()-1)+",关联资产编号为:"+assetCodeSelect);
 		log.setControl("成功");
 		logService.saveSystemLog(log);
		return showVulnAnal(mapping, form, request, response);
	}

	/**
	 * 漏洞与资产关联
	 **/
	@SuppressWarnings("unchecked")
	public ActionForward relateLeakToAssert(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String assetKindIdSelect = request.getParameter("assetKindIdSelect");
		String assetCodeSelect = new String(request.getParameter("assetCodeSelect").getBytes("ISO8859-1"), "UTF-8");
		String ip = request.getParameter("ip");
		request.setAttribute("ip", ip);
		String[] dynaLeakIds = request.getParameterValues("dynaLeakId");
		String[] secuLeves = request.getParameterValues("secuLeves");

		Map paraMap = new HashMap();
		paraMap.put("secuLeves", secuLeves);
		paraMap.put("dynaLeakIds", dynaLeakIds);
		paraMap.put("assetCodeSelect", assetCodeSelect);
		dynaLeakService.relateLeakToAssert(paraMap);
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
 		for(String str:dynaLeakIds){
 			s+=str+",";
 		}
 		log.setOperationDesc("风险评估模块,漏洞与资产关联,漏洞ID为:"+s.substring(0,s.length()-1)+"关联资产编号为:"+assetCodeSelect);
 		log.setControl("成功");
 		logService.saveSystemLog(log);
		return showVulnAnal(mapping, form, request, response);
	}

	/**
	 * 批量删除动态脆弱点
	 **/
	public ActionForward batchDeleteDynaPoint(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		AsseKnowDynaVulnForm asseKnowDynaVulnForm = (AsseKnowDynaVulnForm) form;
		String[] dynaVulnPoinIds = asseKnowDynaVulnForm.getDynaVulnPoinIds();
		vulnAnalService.remove(dynaVulnPoinIds);
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
 		for(String str:dynaVulnPoinIds){
 			s+=str+",";
 		}
 		log.setOperationDesc("风险评估模块,删除动态脆弱点,ID为:"+s.substring(0,s.length()-1));
 		log.setControl("成功");
 		logService.saveSystemLog(log);
		return showVulnAnal(mapping, form, request, response);
	}

	/**
	 * 保存/更新动态脆弱点
	 */
	@SuppressWarnings("unchecked")
	public ActionForward saveOrUpdatePoint(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		boolean flag=true;
		AsseInfoProj asseInfoProj = loadAsseInfoproj(request);
		AsseKnowDynaVulnForm vuln = (AsseKnowDynaVulnForm) form;
		Map paraMap = new HashMap();
		paraMap.put("assetCode", vuln.getAssetCode());
		AsseKnowDynaVuln dynaVulnPoint = new AsseKnowDynaVuln();
		dynaVulnPoint.setAsseInfoProjId(vuln.getAsseInfoProjId());
		dynaVulnPoint.setAsseKnowStatVulnKindId(vuln.getAsseKnowStatVulnKindId());
		dynaVulnPoint.setAsseKnowStatVulnPoinId(vuln.getAsseKnowStatVulnPoinId());
		dynaVulnPoint.setSeriLeve(vuln.getSeriLeve());
		dynaVulnPoint.setSource(vuln.getSource());
		if (vuln.getId() != null && vuln.getId()>0) {
			flag=false;
			dynaVulnPoint.setId(vuln.getId());
			vulnAnalService.saveOrUpdate(paraMap, dynaVulnPoint);
		} else {
			if (!vulnAnalService.checkExitDynaVulnPoint(asseInfoProj,vuln.getAssetCode(), vuln.getAsseKnowStatVulnPoinId())) {
				dynaVulnPoint.setAsseInfoProjId(asseInfoProj.getId());
				vulnAnalService.saveOrUpdate(paraMap, dynaVulnPoint);
			} else {
				// 该资产关联的脆弱点已存在
				ActionErrors errors = new ActionErrors();
				errors.add("repeatDynaPoint", new ActionMessage("asse.err.dynaPoint.repeat"));
				saveErrors(request, errors);
			}
		}
		request.setAttribute("asseKnowDynaVuln", dynaVulnPoint);
		
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
     		log.setOperationDesc("风险评估模块,新增动态脆弱点,ID为:"+dynaVulnPoint.getId()+",所属项目ID:"+dynaVulnPoint.getAsseInfoProjId());
 		}else{
     		log.setOperationDesc("风险评估模块,修改动态脆弱点,ID为:"+dynaVulnPoint.getId()+",所属项目ID:"+dynaVulnPoint.getAsseInfoProjId());
 		}
 		log.setControl("成功");
 		logService.saveSystemLog(log);
		return showVulnAnal(mapping, form, request, response);
	}

	/**
	 * 下一步
	 */
	public ActionForward nextStep(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String asseInfoProjId = request.getParameter("asseInfoProjId");
		AsseInfoProj asseInfoProj = projectService.find(new Integer(asseInfoProjId));
		try {
			threAnalService.batchSaveDynaThres(asseInfoProjId);
			dynaLeakThreService.saveDynaLeakThre(asseInfoProj);
		} catch (Exception e) {
			e.printStackTrace();
			return showVulnAnal(mapping, form, request, response);
		}
		return new ActionForward("/ismp/domain/local/ram/ThreAnalManager.do?method=showThreAnal&projId=" + asseInfoProjId);
	}
	
	  /**
     * 查看
     */
    public ActionForward look(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	    
    	    String vulnId = request.getParameter("vulnId");
    	    AsseKnowDynaVuln dynaVuln = vulnAnalService.find(new Integer(vulnId));
    	    AsseKnowStatVulnKind vulnKind = statVulnKindService.find(dynaVuln.getAsseKnowStatVulnKindId());
    	    AsseKnowStatVulnPoin vulnPoin = statVulnPoinService.find(dynaVuln.getAsseKnowStatVulnPoinId().toString());
    	    request.setAttribute("dynaVuln", dynaVuln);
    	    request.setAttribute("vulnKind", vulnKind);
    	    request.setAttribute("vulnPoin", vulnPoin);
    	    return mapping.findForward("look");
    }
    
}
