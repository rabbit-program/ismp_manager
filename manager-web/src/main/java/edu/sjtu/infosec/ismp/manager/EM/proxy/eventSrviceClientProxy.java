package edu.sjtu.infosec.ismp.manager.EM.proxy;

import java.util.List;

import org.infosec.ismp.manager.rmi.event.IEventReceive;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class eventSrviceClientProxy implements IEventReceive{
	
	private IEventReceive eventSrviceClient;
	OperatorDetails user = null;
	List<Domain> domainList = null;
	/**
     *RMI得到list
     * List<Eventrealdisp>
     */
	public List<Eventmoni> doNewEvents(String str){
		return eventSrviceClient.doNewEvents(str);
	}
	
	/**
	 * RMI得到实时事件列表
	 * List<Eventrealdisp>
	 */
	public List<Eventrealdisp> doRealtimeEvents(String domains){
//		if(srviceClient.getObject() instanceof IEventReceive){
			user = SecurityUserHolder.getCurrentUser();
			domainList = user.getDomainList();
			List<Eventrealdisp> list = eventSrviceClient.doRealtimeEvents(domains);
			for(Eventrealdisp e:list){
				e.setDomain(byDomainName(e.getDomain()));
			}
			return list;
	}
	
	/**
	 * 获取曲线图所需的list
	 * @return
	 */
	public List<Object> getDates(){
		return eventSrviceClient.getDates();
	}
	
	private String byDomainName(String domainId){
		for(Domain d:domainList){
			if(domainId.equals(d.getId().toString())){
				return d.getDomainName();
			}
		}
		return null;
	}

	public IEventReceive getEventSrviceClient() {
		return eventSrviceClient;
	}

	public void setEventSrviceClient(IEventReceive eventSrviceClient) {
		this.eventSrviceClient = eventSrviceClient;
	}

}
