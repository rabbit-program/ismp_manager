package edu.sjtu.infosec.ismp.manager.BSAM.web.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.Constants;
import edu.sjtu.infosec.ismp.manager.BSAM.comm.DomainComparator;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineCabinet;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineRoom;
import edu.sjtu.infosec.ismp.manager.BSAM.model.SubUnitVO;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineCabinetService;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineRoomService;
import edu.sjtu.infosec.ismp.manager.BSAM.service.SecurityAreaService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class SituationAction extends DispatchAction {
	
	private static Logger logger = Logger.getLogger(SituationAction.class);
	
	private SecurityAreaService securityAreaService;
	
	private MachineRoomService machineRoomService;
	
	private MachineCabinetService machineCabinetService;
	
	private DomainService domainService;
	
    public void setSecurityAreaService(SecurityAreaService securityAreaService) {
		this.securityAreaService = securityAreaService;
	}
    
	public void setMachineRoomService(MachineRoomService machineRoomService) {
		this.machineRoomService = machineRoomService;
	}
	
	public void setMachineCabinetService(MachineCabinetService machineCabinetService) {
		this.machineCabinetService = machineCabinetService;
	}
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	public ActionForward  getSecurityAreaSituationList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

    	String toPage = "securityAreaSituationList";///跳转的页面
		
		List<Domain> userDomainList = null;
		StringBuffer userDomainStr = new StringBuffer();
		try{
			String isAll = (null == request.getParameter("isAll"))?"0":request.getParameter("isAll");///如果为空则赋值为0。
			OperatorDetails user = SecurityUserHolder.getCurrentUser();///取得当前用户。
			if(null != user){
				userDomainList = user.getDomainList();///如果用户不为空，将用户所在的所有域查出赋值到userDomainList。
				
				DomainComparator comparator = new DomainComparator();///新建一个domain比较器
				///将得到的userDomainList按照comparator定义的顺序排序，保证页面每次出现的顺序一致
				Collections.sort(userDomainList,comparator);
				
				///遍历userDomainList,将domain的id组成一个字符串
				for (int i = 0; i < userDomainList.size(); i++) {
					if(i != (userDomainList.size()-1)){
						userDomainStr.append(userDomainList.get(i).getId()).append(",");
					}else{
						userDomainStr.append(userDomainList.get(i).getId());
					}
				}
			}
			request.setAttribute("userDomainStr", userDomainStr.toString());///用户域id
			request.setAttribute("userDomainList", userDomainList);///用户域
			request.setAttribute("isAll", isAll );
		}catch(Exception e){
			toPage = "failed";
			logger.debug("态势分析--态势管理--首页访问出错啦！");
			e.printStackTrace();
		}
		logger.debug("=====toPage======="+toPage);
		
		request.setAttribute("situationMenu", "location");
		return mapping.findForward(toPage);
	}
    
    public ActionForward  getTopMachineSituationList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	
    	String isAll = (null == request.getParameter("isAll"))?"0":request.getParameter("isAll");///如果为空则赋值为0。
    	
    	request.setAttribute("isAll", isAll );
    	request.setAttribute("situationMenu", "topSituation");
    	return mapping.findForward("topMachineSituationList");
    }
    
    public ActionForward  getSubUnitList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	
    	int currPage = 1;
		Double totalPage = 0d;
		int totalNum = 0;
		int startResult = 0;
		int maxResult = 5;
		String toPage = "";
		
		try {
			// 分页定义的相关的基本信息
			String cp = (request.getParameter("currPage") == null) ? "1" : request.getParameter("currPage");
			if (null != cp && !cp.equals("")) {
				currPage = Integer.parseInt(cp);
			}
			startResult = (currPage - 1) * maxResult;
			if (startResult < 0) {
				startResult = 0;
			}
			
			//数据相关的基本信息
			List<SubUnitVO> subUnitList = new ArrayList<SubUnitVO>();
			
			String type = request.getParameter("type");
	    	String id = request.getParameter("id");
	    	StringBuffer subUnitIds = new StringBuffer();
			
	    	if(Constants.AnQuanYu.equals(type)){
	    		String name = "域";
	    		if(null != domainService.findById(Integer.parseInt(id))){
	    			name = domainService.findById(Integer.parseInt(id)).getDomainName();
	    		}
	    		///取得域下的机房和主机(散户)列表   分页
	    		subUnitList = securityAreaService.getSubUnitById(id, startResult, maxResult);
	    		totalNum = securityAreaService.getSubUnitCountById(id);
	    		///拼接subUnit的id，机房用","分隔，机柜用";"分隔，主机用":"分隔。
	    		if(null != subUnitList && subUnitList.size() > 0){
	    			for (int i = 0; i < subUnitList.size(); i++) {
	    				if(Constants.JiFang.equals(subUnitList.get(i).getType())){
	    					subUnitIds.append(subUnitList.get(i).getId() + ",");
	    				}else if(Constants.ZhuJi.equals(subUnitList.get(i).getType())){
	    					subUnitIds.append(":" + subUnitList.get(i).getId());
	    				}
					}
	    		}
	    		request.setAttribute("name", name);
	    		toPage = "securityAreaSubUnitList";///跳转标识
	    	}else if(Constants.JiFang.equals(type)){
	    		String name = "机房";
	    		MachineRoom tempMachineRoom = machineRoomService.getMachineRoomById(Integer.parseInt(id));
	    		if(null != tempMachineRoom){
	    			name = tempMachineRoom.getDomain().getDomainName() + "|" + tempMachineRoom.getMachineRoomName();
	    		}
	    		///取得机房下的机柜和主机列表   分页
	    		subUnitList = machineRoomService.getSubUnitById(id, startResult, maxResult);
	    		totalNum = machineRoomService.getSubUnitCountById(id);
	    		///拼接subUnit的id，机房用","分隔，机柜用";"分隔，主机用":"分隔。
	    		if(null != subUnitList && subUnitList.size() > 0){
	    			for (int i = 0; i < subUnitList.size(); i++) {
	    				if(Constants.JiGui.equals(subUnitList.get(i).getType())){
	    					subUnitIds.append(subUnitList.get(i).getId() + ";");
	    				}else if(Constants.ZhuJi.equals(subUnitList.get(i).getType())){
	    					subUnitIds.append(":" + subUnitList.get(i).getId());
	    				}
					}
	    		}
	    		request.setAttribute("name", name);
	    		toPage = "machineRoomSubUnitList";///跳转标识
	    	}else if(Constants.JiGui.equals(type)){
	    		String name = "机柜";
	    		MachineCabinet tempMachineCabinet = machineCabinetService.getMachineCabinetById(Integer.parseInt(id));
	    		if(null != tempMachineCabinet){
	    			name = tempMachineCabinet.getMachineRoom().getDomain().getDomainName() 
	    				+ "|" + tempMachineCabinet.getMachineRoom().getMachineRoomName()
	    				+ "|" + tempMachineCabinet.getMachineCabinetName();
	    		}
	    		///取得机柜下的主机列表   分页
	    		subUnitList = machineCabinetService.getSubUnitById(id, startResult, maxResult);
	    		totalNum = machineCabinetService.getSubUnitCountById(id);
	    		///拼接subUnit的id，机房用","分隔，机柜用";"分隔，主机用":"分隔。
	    		if(null != subUnitList && subUnitList.size() > 0){
	    			for (int i = 0; i < subUnitList.size(); i++) {
	    				subUnitIds.append(":" + subUnitList.get(i).getId());
					}
	    		}
	    		request.setAttribute("name", name);
	    		toPage = "machineCabinetSubUnitList";///跳转标识
	    	}
	    	
	    	//分页定义的相关的基本信息
			
			totalPage = Math.ceil((double) totalNum / maxResult);
			if (totalPage > 0 && currPage <= 0) {
				currPage = 1;
			}
			
			request.setAttribute("subUnitIds", subUnitIds.toString());
			request.setAttribute("type", type);
			request.setAttribute("id", id);
	    	request.setAttribute("subUnitList", subUnitList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		
		request.setAttribute("situationMenu", "location");
    	return mapping.findForward(toPage);
    }
    
}
