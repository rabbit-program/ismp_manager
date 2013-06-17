package edu.sjtu.infosec.ismp.manager.VPM.pm.web.actions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.SensorClientsService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class DomainTree extends DispatchAction{

	private SensorClientsService sensorClientsService;
 public SensorClientsService getSensorClientsService() {
		return sensorClientsService;
	}

	public void setSensorClientsService(SensorClientsService sensorClientsService) {
		this.sensorClientsService = sensorClientsService;
	}


 public ActionForward getDoMain(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		OperatorDetails user= SecurityUserHolder.getCurrentUser();  
		List<Domain> userDomainList = new ArrayList<Domain>();
		String sid = request.getParameter("sid");
		StringBuffer sbf=new StringBuffer();
		if(user != null)
		{
			userDomainList = user.getDomainList();
			if(HtmlFactory.isNotEmpty(sid)){
			 List<SensorClients> list= sensorClientsService.getSensorInfosByDoMainId(new Integer(sid));
			 String[][] scs={{"id","getId"},{"name","getName"}};
			 String[][] add ={{"isleaf","1"}};
			 for(Iterator<SensorClients> iter = list.iterator();iter.hasNext();){
				 SensorClients sc = iter.next();
				 if(!(sc == null)){
					 Object[][] objs={{sc,scs},{"add",add}};
				     HtmlFactory.getDataArray(objs, sbf);
				 }
			  }
			}else{
				String[][] domains={{"id","getId"},{"name","getDomainName"}};
				String[][] add1 ={{"isleaf","0"}};
				for(Iterator<Domain> ite=userDomainList.iterator();ite.hasNext();){
					Domain domain=ite.next();
					if(!(domain==null)){
						Object[][] objs={{domain,domains},{"add",add1}};
						HtmlFactory.getDataArray(objs, sbf);
					}
				}
			}
		}else{
			userDomainList=null;
		}
		HtmlFactory.flushData(response, sbf);
		return null;
	  }
 public ActionForward getDoMainAll(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		OperatorDetails user= SecurityUserHolder.getCurrentUser();  
		List<Domain> userDomainList = new ArrayList<Domain>();
		StringBuffer sbf=new StringBuffer();
		if(user != null)
		{
			userDomainList = user.getDomainList();
			String[][] domains={{"id","getId"},{"name","getDomainName"}};
			for(Iterator<Domain> ite=userDomainList.iterator();ite.hasNext();){
				Domain domain=ite.next();
				if(!(domain==null)){
					Object[][] objs={{domain,domains}};
					HtmlFactory.getDataArray(objs, sbf);
				}
			}
		}
	  HtmlFactory.flushData(response, sbf);
	 return null;
  }
}
