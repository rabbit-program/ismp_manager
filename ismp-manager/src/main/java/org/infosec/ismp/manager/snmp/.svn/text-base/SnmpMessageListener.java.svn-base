package org.infosec.ismp.manager.snmp;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.beanutils.PropertyUtils;
import org.infosec.ismp.manager.model.snmp.SnmpDeviceHistoryBaseEntity;
import org.infosec.ismp.manager.model.snmp.SnmpDeviceHistoryBaseStatus;
import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceStatus;
import org.infosec.ismp.manager.snmp.dao.SnmpDeviceHistoryService;
import org.infosec.ismp.manager.threshold.ThresholdAlert;
import org.infosec.ismp.manager.threshold.ThresholdLoader;
import org.infosec.ismp.model.snmp.Results;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guoxianwei
 * @date 2010-12-3 下午05:31:53
 * 
 */
@Component
public class SnmpMessageListener implements MessageListener {

	private MessageProcessor m_processor;
	
	private SnmpDeviceHistoryService m_snmpHistoryService;

	private SnmpDeviceLocator m_snmpDeviceLocator;
	//阈值信息加载
	private ThresholdLoader m_thresholdLoader;
	//阈值告警
	private ThresholdAlert m_thresholdAlert;
    

	@PostConstruct
	public void init(){
		// 加载阈值信息到内存，便于后面产生告警
		m_thresholdLoader.loadThresholds();
	}
	@Override
	public void onMessage(Message message) {
		ObjectMessage msg = (ObjectMessage) message;
		try {
			Results results = (Results) msg.getObject();
			String nodeid = results.getNodeid();
			String type = results.getType();
			if(SnmpDeviceConstants.HOST_RESOURCE.equals(type) || SnmpDeviceConstants.SERVER_RESOURCE.equals(type)){
				log().info(" ---------------host processor excute -------------------");
				SnmpDeviceHistoryBaseStatus baseStatus = m_processor.getHostProcessor().process(results);
				messageProcess(nodeid,baseStatus);
			}else if(SnmpDeviceConstants.WEBLOGIC.equals(type)){
				log().info(" ---------------weblogic processor excute -------------------");
				SnmpDeviceHistoryBaseStatus baseStatus = m_processor.getWeblogicProcessor().process(results);
				messageProcess(nodeid,baseStatus);
			}else{
				log().info(" ---------------network processor excute -------------------");
				SnmpDeviceHistoryBaseStatus baseStatus = m_processor.getNetworkProcessor().process(results);
				messageProcess(nodeid,baseStatus);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	//信息处理
	private void messageProcess(String nodeid,SnmpDeviceHistoryBaseStatus baseStatus){
		if(baseStatus == null)return;
		SnmpDeviceStatus status = new SnmpDeviceStatus();
		copyProperties(status,baseStatus);
		cacheMessage(nodeid, status);
		saveMessage(baseStatus.getSnmpDeviceHistoryBaseEntity());
		createAlert(status);
	}
	//缓存操作
	private void cacheMessage(String nodeid,SnmpDeviceStatus status){
		m_snmpDeviceLocator.cacheSnmpDeviceResult(nodeid, status);
	}
	//入库操作
	private void saveMessage(SnmpDeviceHistoryBaseEntity entity){
		m_snmpHistoryService.saveSnmpDeviceHistory(entity);
	}
	//告警操作
	private void createAlert(SnmpDeviceStatus satus){
		m_thresholdAlert.alert(satus);
	}

	@Autowired(required = true)
	public void setThresholdLoader(ThresholdLoader thresholdLoader) {
		m_thresholdLoader = thresholdLoader;
	}
	@Autowired(required = true)
	public void setProcessor(MessageProcessor processor) {
		m_processor = processor;
	}
	@Autowired(required = true)
	public void setSnmpDeviceLocator(SnmpDeviceLocator snmpDeviceLocator) {
		m_snmpDeviceLocator = snmpDeviceLocator;
	}
	@Autowired(required = true)
	public void setSnmpHistoryService(
			SnmpDeviceHistoryService snmpHistoryService) {
		m_snmpHistoryService = snmpHistoryService;
	}
	@Autowired(required = true)
	public void setThresholdAlert(ThresholdAlert thresholdAlert) {
		m_thresholdAlert = thresholdAlert;
	}
    //属性拷贝
	private void copyProperties(SnmpDeviceStatus status,SnmpDeviceHistoryBaseStatus baseStatus){
		try {
			PropertyUtils.copyProperties(status, baseStatus);
		} catch (Exception e) {
			log().debug("请检查，属性拷贝发生异常",e);
		}
	}
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
