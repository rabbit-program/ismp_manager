package edu.sjtu.infosec.ismp.manager.ERM.web.actions.respList;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.service.RespInfoService;
import edu.sjtu.infosec.ismp.manager.ERM.web.form.ShowListForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class RespShowAction extends Action {
	private static Logger logger = Logger.getLogger(RespShowAction.class); 

	/**
	 * 注入 service 接口
	 */
	private RespInfoService respInfoService;
	
	private DomainService domainService;
	
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService){
		this.logService = logService;
	}
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}


	public void setRespInfoService(RespInfoService respInfoService) {
		this.respInfoService = respInfoService;
	}
	
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

    	String toPage = "success";
		int currPage = 1;
		Double totalPage = 0d;
		Long totalNum = 0l;
		int startResult = 0;
		int maxResult = 5;
		Domain domain = null;
		try{
			toPage = "success";
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
		
			ShowListForm show=(ShowListForm)form;
			request.setAttribute("selectid", show.getSelectid());
			request.setAttribute("respname", show.getRespname());
			request.setAttribute("sysname", show.getSysname());
			request.setAttribute("updatetime", show.getUpdatetime());
			//数据相关的基本信息
			List<RespInfoBO> respList = new ArrayList<RespInfoBO>();
			domain = domainService.findById(show.getSelectid());

			//分页定义的相关的基本信息
			if(respList!=null && respList.size()>=0){
				if(isAll.equals("1")){
					totalNum=respInfoService.findAllNum(null,null,show.getSelectid(),show.getRespname(),show.getSysname(),show.getUpdatetime());
				}else{
					totalNum = respInfoService.findAllNumByDomain(userDomainList, null, null,show.getSelectid(),show.getRespname(),show.getSysname(),show.getUpdatetime());
				}
			}
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
			
			if(isAll.equals("1")){
				request.setAttribute("isAll", isAll);
				respList = respInfoService.findAll(null, null, startResult, maxResult,show.getSelectid(),domain,show.getRespname(),show.getSysname(),show.getUpdatetime());
			}else{
				respList = respInfoService.findAllByDomain(userDomainList, null, null, startResult, maxResult,show.getSelectid(),domain,show.getRespname(),show.getSysname(),show.getUpdatetime());
			}
			
			request.setAttribute("udl", userDomainList);
			request.setAttribute("respList", respList);
		}catch(Exception e){
			toPage = "failed";
			logger.debug("应急响应--预案管理--首页访问出错啦！");
			e.printStackTrace();
		}
		logger.debug("=====toPage======="+toPage);
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		
		request.setAttribute("respMenu", "rm");
		
		
		return mapping.findForward(toPage);
	}
}
