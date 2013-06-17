package edu.sjtu.infosec.ismp.manager.VPM.pm.web.actions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigDbService;
import org.springframework.remoting.RemoteLookupFailureException;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClentsPatchUpdateInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.SensorClientsService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.SensorService;
import edu.sjtu.infosec.ismp.manager.comm.comm.conn.jdbc.JdbcSensorClient;
import edu.sjtu.infosec.ismp.manager.comm.comm.conn.jdbc.ReadProp;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class StatisticsAction extends DispatchAction{

	private SensorClientsService sensorClientsService;
	private SensorService sensorService;
	private DomainService  domainService;
	private SystemLogService systemlogservice;
	private SysConfigDbService sysConfigDbService;
	
	/**
	 * @param systemlogservice the systemlogservice to set
	 */
	public void setSystemlogservice(SystemLogService systemlogservice) {
		 JdbcSensorClient.list.add(sysConfigDbService);
	}
	/**
	 * @param sysConfigDbService the sysConfigDbService to set
	 */
	public void setSysConfigDbService(SysConfigDbService sysConfigDbService) {
		this.sysConfigDbService = sysConfigDbService;
	}
	public DomainService getDomainService() {
		return domainService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	public SensorClientsService getSensorClientsService() {
		return sensorClientsService;
	}
	public void setSensorClientsService(SensorClientsService sensorClientsService) {
		this.sensorClientsService = sensorClientsService;
	}
	public SensorService getSensorService() {
		return sensorService;
	}
	public void setSensorService(SensorService sensorService) {
		this.sensorService = sensorService;
	}
	/**
	 * 查询所有域下的补丁数
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward getCountDomainAll(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    try {
				OperatorDetails user= SecurityUserHolder.getCurrentUser();  
				//根据User 脚色权限查询委办局
				List<Domain> userDomainList = new ArrayList<Domain>();
				if(user != null)
				{
					userDomainList = user.getDomainList();
				}else{
					userDomainList=null;
				}
				StringBuffer sbf= new StringBuffer();
				PMPage page= HtmlFactory.getPage(request);
				LinkedList linkList = sensorClientsService.getSensorInfosAll(userDomainList,page.getBeginIndex(), page.getEveryPage(), null, null);
				Domain dom = new Domain();
				dom.setDomainName("全部委办局");
				getCountLinke(request,linkList,sbf,page,dom);   
				HtmlFactory.flushData(response, sbf);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	private void getCountLinke(HttpServletRequest request,LinkedList linkList,StringBuffer sbf,PMPage page,Domain department){
    	try{
		        page= HtmlFactory.getPage(request);
	 			//可供更新的补丁数
				int allPachInfoNum = sensorService.findAllPatchInfoNum();
	 			//共有多少台计算机
	 			int allComputerNum= (Integer) linkList.getFirst();;
	 			//分页
	 			page = PMPageUtil.createPage(page, allComputerNum);
	 			//需更新的计算机
	 			List<SensorClients> sensorClientsList = (List<SensorClients>) linkList.getLast(); 
	 			//客户需要的数量更新
	 			int clientsNumOfNeedUpdate = sensorService.findClientsNumOfNeedUpdate(sensorClientsList);
	 			List<SensorClentsPatchUpdateInfo> patchUpdateList = new ArrayList<SensorClentsPatchUpdateInfo>();
	 			for(SensorClients sc:sensorClientsList){
	 				SensorClentsPatchUpdateInfo patchUpdateInfo = new SensorClentsPatchUpdateInfo();
	 				patchUpdateInfo.setId(sc.getId());
	 				patchUpdateInfo.setName(sc.getName());
	 				//错误的更新数
	 			    int allPatchUpdateFailedNUm = sensorService.findAllPatchUpdateFailedNumBySensorClients(sc);
	 			    patchUpdateInfo.setAllPatchUpdateFailedNUm(allPatchUpdateFailedNUm);
	 				//需更新的补丁数
	 				int allPatchUpdateNeedNum = sensorService.findAllPatchUpdateNeedNumBySensorClients(sc);
	 				patchUpdateInfo.setAllPatchUpdateNeedNum(allPatchUpdateNeedNum);
	 				//已更新的补丁数
	 				int allPatchUpdateOkNum = sensorService.findAllPatchUpdateOkNumBySensorClients(sc);
	 				patchUpdateInfo.setAllPatchUpdateOkNum(allPatchUpdateOkNum);
	 				patchUpdateList.add(patchUpdateInfo);
	 			} 
		      for(SensorClentsPatchUpdateInfo s : patchUpdateList){
		    	  HtmlFactory.getDataArray(s,sbf,"CDOMAINALL");
		      }
		      String[][] clientDomain ={{"cname",department.getDomainName()},{"allPachInfoNum",allPachInfoNum+""},{"allComputerNum",allComputerNum+""},{"clientsNumOUpdate",clientsNumOfNeedUpdate+""}};
		      Object[][] objs={{"add",clientDomain}};
		      HtmlFactory.getDataArray(objs, sbf,"CDOMAIN");
		      HtmlFactory.getDataArray(page, sbf,"PAGE");
 		}
 		catch(RemoteLookupFailureException rlfe){
 			System.out.println("RMI连接出错:java.rmi.ConnectException");
 		}catch(NumberFormatException e1){
 			e1.printStackTrace();
 		}catch(Exception e){
 			e.printStackTrace();
 		}
	}
	
	//@SuppressWarnings({ "unused", "unchecked" })
	public ActionForward getCountDomain(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    String doid =request.getParameter("sdid");
		    if(HtmlFactory.isNotEmpty(doid) && !doid.equals("-1")){
		    	StringBuffer sbf= new StringBuffer();
		    	SensorClients sensor = new SensorClients();
		    	Domain department= null;
		    	PMPage page = HtmlFactory.getPage(request);
		    	try{
				      department= domainService.findById(Integer.valueOf(doid));
				      sensor.setDepartment(department);
			 		  LinkedList linkList = sensorClientsService.getSensorInfos(sensor, page.getBeginIndex(), page.getEveryPage(), null, null);
			 		  getCountLinke(request,linkList,sbf,page,department);
		 		}catch(Exception e){
		 			e.printStackTrace();
		 		}
		 		HtmlFactory.flushData(response, sbf);
		    }else if(doid.equals("-1")){
		    	return	getCountDomainAll(mapping,form,request,response);
		    }
		return null;
	}
	@SuppressWarnings("unchecked")
	public ActionForward getCountSensor(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
				//点击客户端
				String scid= request.getParameter("scid");
				if(HtmlFactory.isNotEmpty(scid)){
					StringBuffer sbf = new StringBuffer();
					PMPage page =null;
					try{
						SensorClients sensorClients = sensorClientsService.getSensorClients(new Integer(scid));
						page= HtmlFactory.getPage(request);
						if(sensorClients.getDepartment()!=null && sensorClients.getDepartment().getDomainName() !=null){
							request.setAttribute("managerName", sensorClients.getDepartment().getDomainName());
						}else{
							request.setAttribute("managerName", "未分配");
						}
						//补丁总数
						Integer allPatchUpdateInfoNum = sensorService.findAllPatchUpdateInfoNumBySensorClients(sensorClients);
						//已安装补丁数
						Integer allPatchUpdateOkNum = sensorService.findAllPatchUpdateOkNumBySensorClients(sensorClients);
						//安装失败补丁数
						Integer allPatchUpdateFailedNum = sensorService.findAllPatchUpdateFailedNumBySensorClients(sensorClients);
						//需要更新补丁数
						Integer allPatchUpdateNeedNum = sensorService.findAllPatchUpdateNeedNumBySensorClients(sensorClients);
						//未知状态的补丁数
						Integer allPatchUpdateNoNum = sensorService.findAllPatchUpdateNoNumStateBySensorClients(sensorClients);
						//补丁名称 rs --> List ---> PatchUpdateInfo
						PageResult rs = sensorService.findAllPatchUpdateInfoBySensorClients(sensorClients,page);
						String[][] clientInfo = {{ "name", sensorClients.getName() },{ "ip", sensorClients.getSensorIP() },
						{ "doMain",sensorClients.getDepartment().getDomainName() } ,{"allPatchUpdateInfoNum",allPatchUpdateInfoNum.toString()},
						{"allPatchUpdateOkNum",allPatchUpdateOkNum.toString()},{"allPatchUpdateFailedNum",allPatchUpdateFailedNum.toString()},
						{"allPatchUpdateNeedNum",allPatchUpdateNeedNum.toString()},{"allPatchUpdateNoNum",allPatchUpdateNoNum.toString()}};
						Object[][] objs={{"add",clientInfo}};
						HtmlFactory.getDataArray(objs, sbf,"CLIENT");
						String[][] pValue={{"2","需要更新"},{"3","需要更新"},{"6","需要更新"},{"1","已安装/不适用的更新"},{"4","已安装/不适用的更新"},{"5","包含错误的更新"}};
						Object[][] puInfo ={{"state","getState",pValue}};
						String[][] pinfos={{"patchName","getDefaultTitle"},{"uptype","getUpdateType"},{"desc","getDefaultDescription"}};
						for(Iterator<PatchUpdateInfo> li = rs.getPageList().iterator();li.hasNext();){
							PatchUpdateInfo  patchUpdateInfo = li.next();
							Object[][] upInfoobjs ={{patchUpdateInfo,puInfo},{patchUpdateInfo.getPatchInfo(),pinfos}};
							HtmlFactory.getDataArray(upInfoobjs, sbf,"PATCHINFO");
						}
						HtmlFactory.getDataArray(rs.getPmpage(), sbf,"PAGE");
						HtmlFactory.flushData(response, sbf);
					}
					catch(RemoteLookupFailureException rlfe){
						System.out.println("RMI连接出错:java.rmi.ConnectException");
					}
					catch(Exception e){
						e.printStackTrace();
					}	
				}
				
		return null;
	}
}
