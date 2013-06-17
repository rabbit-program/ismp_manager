package org.infosec.ismp.applet.discover.thread;

import java.util.List;

import javax.swing.SwingUtilities;

import org.infosec.ismp.applet.discover.service.ICMPSearchAppletService;
import org.infosec.ismp.applet.discover.ui.CDPPanel;
import org.infosec.ismp.applet.discover.ui.ICMPPanel;
import org.infosec.ismp.applet.discover.ui.PCPanel;
import org.infosec.ismp.applet.discover.ui.SNMPPanel;

/**
 * 初始化各ParamPanel面板的参数
 * @author Wu Guojie
 * @date 2009-8-12
 * @version 1.0
 */
public class ParamPanelInitThread extends Thread {
    private ICMPPanel icmpPanel = null;
    private SNMPPanel snmpPanel = null;
    private CDPPanel cdpPanel = null;
    private PCPanel pcPanel = null;
	public ParamPanelInitThread(ICMPPanel icmpPanel, SNMPPanel snmpPanel, CDPPanel cdpPanel, PCPanel pcPanel) {
		this.icmpPanel = icmpPanel;
		this.snmpPanel = snmpPanel;
		this.cdpPanel = cdpPanel;
		this.pcPanel = pcPanel;
	}
	public void run() {
		try{
//			System.out.println("正常开始");
//	    	ICMPSearchAppletService icmpSearchService = ICMPSearchAppletService.getInstance();
//	    	final List<AgentBO> agentList = icmpSearchService.getAllRegisteredAgentBO();
//			AgentBO agent1 = new AgentBO();
//			agent1.setIpAddr("2.2.2.2");
//			agent1.setId(2);
//			agent1.setName("222");
//			agent1.setPort(2);
//			agentList.add(agent1);
//			if (agentList != null) {
//				SwingUtilities.invokeLater(new Runnable() {
//					public void run() {
//						icmpPanel.addAgentList(agentList);
//						snmpPanel.addAgentList(agentList);
//						cdpPanel.addAgentList(agentList);
//						pcPanel.addAgentList(agentList);
//					}
//				});
//			}
//			System.out.println("正常结束");
		}catch(Exception e){
//			System.out.println("异常开始");
			e.printStackTrace();
//			System.out.println("异常结束");
		}
	}
}
