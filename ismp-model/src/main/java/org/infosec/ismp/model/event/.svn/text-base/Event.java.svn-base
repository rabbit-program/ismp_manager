package org.infosec.ismp.model.event;

import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.poller.config.Service;
import org.infosec.ismp.model.spservicepoller.SpecialService;
import org.infosec.ismp.model.syslog.Syslog;
import org.infosec.ismp.model.syslog.SyslogWrapper;
import org.infosec.ismp.model.syslog.UeiMatch;

/**
 * 
 * 代表系统内部发生的事件，例如增加、删除节点等，便于各个子系统之间的通信。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 * TODO : 根据后面的实现添加具体的内容。
 */
public class Event implements Serializable {
	private String uuid;// 事件唯一id
	private String uei;// universal event id，事件类型代号
	private String time;// event time
	private String source;// 来源于那个服务
	private String host;// from host;
	private String ipAddr;
	private String descr;
	private String nodeid;
	private Parms parms;
	
	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUei() {
		return uei;
	}

	public void setUei(String uei) {
		this.uei = uei;
	}



	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	



	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Parms getParms() {
		return parms;
	}

	public void setParms(Parms parms) {
		this.parms = parms;
	}
	
	public void addParm(Parm parm){
		if(parms==null){
			parms = new Parms();
		}
		this.parms.addParm(parm);
	}

	public static void main(String[] args) throws Exception {
		Event event = new Event();
		event.setUuid("ppppppppppp");
		event.setUei("test/xdfdf/dfdf");
		Syslog log = new Syslog();
		log.setHostname("test");
//		SyslogWrapper wrapper = new SyslogWrapper();
//		wrapper.setSyslog(log);
//		event.setSyslog(wrapper);
		// event.addParam("pp", "dd");
		StringWriter writer = new StringWriter();
		Marshaller.marshal(event, writer);
		System.out.println(writer.toString());
	}

	public void addParam(String parameterName, String vettedValue) {
		if(parms==null){
			parms = new Parms();
		}
		Parm parm = new Parm();
		Value value = new Value();
		value.setContent(vettedValue);
		parm.setValue(value);
		parm.setParmName(parameterName);
		parms.addParm(parm);

	}

	public void marshal(final Writer out) throws MarshalException,
			ValidationException {
		Marshaller.marshal(this, out);
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public Parms getParams() {
		return parms;
	}

	public void setParams(Parms params) {
		this.parms = params;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	
	



//	public SpecialService getSpecialService() {
//		return specialService;
//	}
//
//	public void setSpecialService(SpecialService specialService) {
//		this.specialService = specialService;
//	}
//
//	public UeiMatch getUeiMatch() {
//		return ueiMatch;
//	}
//
//	public void setUeiMatch(UeiMatch ueiMatch) {
//		this.ueiMatch = ueiMatch;
//	}

	
	
	

}
