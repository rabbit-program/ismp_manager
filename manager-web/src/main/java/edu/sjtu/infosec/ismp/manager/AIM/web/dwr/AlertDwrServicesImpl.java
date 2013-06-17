package edu.sjtu.infosec.ismp.manager.AIM.web.dwr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.infosec.ismp.manager.rmi.aim.service.NewAlertService;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertDwrDao;
import edu.sjtu.infosec.ismp.manager.AIM.dao.NewAlertDao;
import edu.sjtu.infosec.ismp.manager.AIM.dao.SendAlertDao;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertFusionRuleBO;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertFusionRuleServices;
import edu.sjtu.infosec.ismp.manager.AIM.service.SendAlertService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;


public class AlertDwrServicesImpl implements AlertDwrServices {
 	
	//注入dao接口
	private AlertDwrDao alertDwrDao;
	
	private AlertFusionRuleServices alertFusionRuleServices;
	
	private NewAlertDao newAlertDao;
	
	private SendAlertDao sendAlertDao;

	private SendAlertService sendAlertService;
	
	private NewAlertService alertControllerClient;
	
	
	public void setAlertControllerClient(NewAlertService alertControllerClient) {
		this.alertControllerClient = alertControllerClient;
	}

	public void setSendAlertService(SendAlertService sendAlertService) {
		this.sendAlertService = sendAlertService;
	}

	public void setAlertDwrDao(AlertDwrDao alertDwrDao) {
		this.alertDwrDao = alertDwrDao;
	}

	//暴露给DWR 的用于检查
	public int getChecknNewAlertinfoService(String time) {
//		return alertDwrDao.getChecknNewAlertinfoDao(time);
		WebContext webContext = WebContextFactory.get(); 
		HttpSession session = webContext.getSession();
		String maxId="0";
		String o = (String) session.getAttribute("maxId");
		if(o!=null && !o.equals("")){
			maxId = (String)o;
		}
		
		try{
			//从队列中取出告警烦的tempList中
			List<AlertInfoBO> tempList=null;
			if(alertControllerClient!=null){
			Map<String,List<AlertInfoBO>> map =  alertControllerClient.getNewAlert(Long.parseLong(maxId));
//				Map<String,List<AlertInfoBO>> map = new HashMap();
			List returnList = new ArrayList();
			Set entrys = map.entrySet();
			for(Iterator it = entrys.iterator(); it.hasNext(); ){
				Map.Entry entry = (Map.Entry) it.next();
				session.setAttribute("maxId", entry.getKey());
				tempList = (List<AlertInfoBO>)entry.getValue();
			}
			}
			if(tempList!=null){
				return tempList.size();
			}else{
				return 0;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
//		return alertDwrDao.getChecknNewAlertinfoDao(time);
	}

	//用于查询出所有的告警信息，比如 检查到新的告警信息的话就马上调用该方法
	public List getPageListAlertDwrService(int curpage,String pagesize,String status,String type,String subType,String fusioin,String logintime) throws Exception{
		//从队列里面取数据并且分页、
		WebContext webContext = WebContextFactory.get(); 
		HttpSession session = webContext.getSession();
		String maxId="0";
		String o = (String) session.getAttribute("maxId");
		if(o!=null && !o.equals("")){
			maxId = (String)o;
		}
		//从队列中取出告警烦的tempList中
		
		Map<String,List<AlertInfoBO>> map =  alertControllerClient.getNewAlert(Long.parseLong(maxId));
//		Map<String,List<AlertInfoBO>> map = new HashMap();
		//Iterator iterator = map.keySet().iterator();
		List<AlertInfoBO> tempList=null;
		List returnList = new ArrayList();
		Set entrys = map.entrySet();
		for(Iterator it = entrys.iterator(); it.hasNext(); ){
			Map.Entry entry = (Map.Entry) it.next();
			session.setAttribute("maxId", entry.getKey());
			tempList = (List<AlertInfoBO>)entry.getValue();
		}
		map=null;
		//找出符合查询条件的告警放到 returnList中
		if(tempList!=null){
			for(int i=0;i<tempList.size();i++){
				AlertInfoBO alertInfoBO = tempList.get(i);
				boolean flag=true;	//符合条件对象
				if(status.equals("1") || status.equals("0")){
	//				status.equals(alertInfoBO.getStatus().toString());
					if(Integer.parseInt(status)!=alertInfoBO.getStatus()){
						flag = false;
						continue;
					}
				}
				if(type!=null && !type.equals("")){
					if(!type.equals(alertInfoBO.getType())){
						flag = false;
						continue;
					}
				}
				if(subType!=null && !subType.equals("")){
					if(!subType.equals(alertInfoBO.getAlertSubType())){
						flag = false;
						continue;
					}
				}
				
				if(fusioin!=null && !fusioin.equals("") && alertInfoBO.getFusioin()!=null && !alertInfoBO.getFusioin().equals("")){
					if(Integer.parseInt(fusioin) > Integer.parseInt(alertInfoBO.getFusioin())){
						flag = false;
						continue;
					}
				}
				if(flag){
					returnList.add(alertInfoBO);
				}
			}
		}
		if(tempList!=null){
			returnList = tempList.subList((curpage - 1)*Integer.parseInt(pagesize), Integer.parseInt(pagesize));
		}
		tempList=null;
		List list = new ArrayList();
		Page page = new Page();
		int pageSize =0;
		if(pagesize!=null && !pagesize.equals("")){
			pageSize = Integer.parseInt(pagesize);
		}
		PageResult pageResult ;
		if(returnList!=null && returnList.size()< pageSize){
			page.setTotalCount(returnList.size());
			//return returnList;
		}else if(returnList!=null && returnList.size()> pageSize){
			page.setTotalCount(returnList.size());
			//return returnList.subList(curpage*(pageSize), curpage*(pageSize)+pageSize);
		}else{
			page.setTotalCount(0);
		}
		pageResult = new PageResult(page,returnList);
		if(returnList!=null){
			PageUtil.createPage(page, returnList.size());
		}else{
			PageUtil.createPage(page, 0);
		}
		
		list.add(0,pageResult.getPageList());
		list.add(1,pageResult.getPage());
		return list;
		
		
//		return alertDwrDao.getPageListAlertDwrDao(curpage, pagesize, status, type, subType, fusioin,logintime);
	}
	//DWR根据父名称查询子类型给
	public List<AlertTypeBO> getSubTypeByNameService(String parentName) {
		return alertDwrDao.getSubTypeByNameDao(parentName);
	}
	//DWR根据父ID查询子类型给
	public List<AlertTypeBO> getSubTypeByParentId(Integer id) {
		return alertDwrDao.getSubTypeByParentId(id);
	}
	
	public void setAlertFusionRuleServices(
			AlertFusionRuleServices alertFusionRuleServices) {
		this.alertFusionRuleServices = alertFusionRuleServices;
	}
   
	public void saveOrUpdateAlertFustionRule(String fustionTime) {
        AlertFusionRuleBO alertFusionRuleBO=alertFusionRuleServices.getAlertFusionRuleServices();
        if(fustionTime!=null&&fustionTime.trim().length()>0){
           alertFusionRuleBO.setFusionTime(Integer.parseInt(fustionTime));
        }
		alertFusionRuleServices.saveOrUpdateAlertFusionRuleServices(alertFusionRuleBO);
	}

	public List getUserPageListService(String userName, String trueName,int currPage) {
		return alertDwrDao.getUserPageListDao(userName, trueName, currPage);
	}

	public void setNewAlertDao(NewAlertDao newAlertDao) {
		this.newAlertDao = newAlertDao;
	}

}
