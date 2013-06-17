package org.infosec.ismp.agent.winsensor.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;
import org.infosec.ismp.agent.winsensor.register.WinsensorRegisterInfo;

/**
 * @author Rocky
 * @version create time：Nov 1, 2010 4:26:05 PM
 * 
 */
public class XmlParseUtilTest {
	public WinsensorRegisterInfo parseWinsensorRegisterInfo(String path) {
		WinsensorRegisterInfo registerInfo = null;
		SAXReader reader = new SAXReader();
		reader.setEncoding("UTF-8");
		try {
			Document document = reader.read(new File(path));
			Element root = document.getRootElement();
			String rootName = root.getName();
			if (rootName.equalsIgnoreCase("Request")) {
				registerInfo = new WinsensorRegisterInfo();
				
				Node registerNode = root.selectSingleNode("Register");
				registerInfo.setSensorId(registerNode.selectSingleNode("SensorID").getText());
				registerInfo.setIp(registerNode.selectSingleNode("Ip").getText());
				registerInfo.setMac(registerNode.selectSingleNode("Mac").getText());
				registerInfo.setActiveTime(registerNode.selectSingleNode("AliveTime").getText());
				registerInfo.setName(registerNode.selectSingleNode("Name").getText());
				registerInfo.setWorkGroup(registerNode.selectSingleNode("WorkGroup").getText());
				registerInfo.setWinsensorVersion(registerNode.selectSingleNode("WinSensorVersion").getText());
				registerInfo.setWinsensorServiceVersion(registerNode.selectSingleNode("WinSensorServiceVersion").getText());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return registerInfo;
	}
	
	public void createDutyTest() {
		AgentDutyManagerBO dutyManager = new AgentDutyManagerBO();
		dutyManager.setBeginDate("2011-01-10 19:41:20");
		dutyManager.setEndDate("2011-01-20 19:41:20");
		dutyManager.setComplaintNumber("110");
		
		AgentDutyBO duty1 = new AgentDutyBO();
		duty1.setId(10000);
		duty1.setIsManager(true);
		duty1.setName("Rocky");
		duty1.setSex("男");
		duty1.setEmail("mail.sina.com.cn");
		duty1.setMobilePhone("189");
		duty1.setPhone("88888888");
		duty1.setResponsibility("work");
		dutyManager.getDuties().add(duty1);
		
		AgentDutyBO duty = new AgentDutyBO();
		duty.setId(10001);
		duty.setIsManager(false);
		duty.setName("Jacky");
		duty.setSex("女");
		duty.setEmail("mail.sina.com.cn");
		duty.setMobilePhone("188");
		duty.setPhone("44444444");
		duty.setResponsibility("work");
		dutyManager.getDuties().add(duty);
		
		XmlParseUtil xmlParseUtil = new XmlParseUtil();
		Document document = xmlParseUtil.createDuty(dutyManager);
		
		System.out.println(document.getRootElement().asXML());
	}
	
	public static void main(String[] args) {
		XmlParseUtilTest test = new XmlParseUtilTest();
//		test.parseWinsensorRegisterInfo("d:/register.xml");
		
		test.createDutyTest();
	}
}
