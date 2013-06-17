package org.infosec.ismp.manager.ping;

import org.infosec.ismp.manager.model.PingResultEntity;
import org.infosec.ismp.manager.rmi.scm.model.PollStatus;
import org.infosec.ismp.manager.rmi.scm.service.OnLineServiceMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * ping rmi的实现
 * @author lianglin
 *
 */
@Component
public class PingServiceRmiImpl implements OnLineServiceMonitor{

	private PingLocator m_pingLocator;
	
	
	@Autowired(required=true)
	public void setPingLocator(PingLocator pingLocator) {
		m_pingLocator = pingLocator;
	}



	@Override
	public void addDevice(String domainId, String nodeid, String ipaddr,
			long interval, boolean flag) {
		m_pingLocator.addPingNode(domainId, nodeid, ipaddr, interval, flag);
		
	}



	@Override
	public void removeDevice(String nodeid) {
		m_pingLocator.removePingNode(nodeid);
	}



	@Override
	public PollStatus getPingStatus(String nodeid) {
		PingResultEntity entity = m_pingLocator.getPingStatus(nodeid);
		if(entity==null){
			return PollStatus.unknown();
		}else{
			if ("UP".equalsIgnoreCase(entity.getStatus())){
				return PollStatus.available((double)entity.getResponseTime());
			}else{
				return PollStatus.unavailable();
			}
		}
	}



	


	/**
	 * 即时获取目标地址PING状态
	 * @param ipAddr IP地址
	 * @return
	 */
	@Override	
	public PollStatus getDirectPingStauts(String domain,String ipAddr) {	
		return m_pingLocator.ping(domain, ipAddr);
	}
	
	/**
	 * 即时获取目标地址available状态
	 * @param domain
	 * @param ipAddr
	 * @param port
	 * @param community
	 * @param version
	 * @return
	 */
	public boolean isSnmpAvailable(String domain,String ipAddr,int port,String community,int version){
		return m_pingLocator.isSnmpAvailable(domain,ipAddr,port,community,version);
	}
	

}
