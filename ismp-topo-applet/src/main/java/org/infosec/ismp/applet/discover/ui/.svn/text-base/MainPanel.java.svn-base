package org.infosec.ismp.applet.discover.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTabbedPane;

import org.infosec.ismp.applet.discover.thread.ParamPanelInitThread;
/**
 * MainPanel
 * @author sshanshan
 * @date 2009-06-20
 * @version 1.0
 */
public class MainPanel extends JTabbedPane{

	/**
	 * SNMPPanel
	 */
    private SNMPPanel snmpPanel = null;
    /**
     * ICMPPanel
     */
    private ICMPPanel icmpPanel = null;
    /**
     * CDPPanel
     */
    private CDPPanel cdpPanel = null;
    /**
     * PCPanel
     */
    private PCPanel pcPanel = null;
    /**
     * 构造函数
     */
//    public MainPanel(String userName, String roleName, String baseURL) {
    public MainPanel(int userId, String baseURL) {
//    	snmpPanel = new SNMPPanel(userName, roleName);
    	snmpPanel = new SNMPPanel(userId);
//    	icmpPanel = new ICMPPanel(userName, roleName);
    	icmpPanel = new ICMPPanel(userId);
//    	cdpPanel = new CDPPanel(userName, roleName);
    	cdpPanel = new CDPPanel(userId);
//    	pcPanel = new PCPanel(userName, roleName);
    	pcPanel = new PCPanel(userId);
    	
    	ParamPanelInitThread initThread = new ParamPanelInitThread(icmpPanel, snmpPanel, cdpPanel, pcPanel);
    	initThread.start();
//    	SwingUtilities.invokeLater(initThread);
       
        this.addTab("ICMP", icmpPanel);
        this.addTab("SNMP", snmpPanel);
        this.addTab("CDP", cdpPanel);
        this.addTab("PC with Sensor", pcPanel);
        this.addTab("帮助", null);
        this.addMouseListener(new MyMouseListener(this, baseURL));
    }
	class MyMouseListener extends MouseAdapter {
		MainPanel mainPanel = null;
		String baseURL = "";
		public MyMouseListener(){};
		public MyMouseListener(MainPanel mainPanel, String baseURL){
			this.mainPanel = mainPanel;
			this.baseURL = baseURL;
		};
		public void mouseClicked(MouseEvent e){
			if(mainPanel.getSelectedIndex() == 4){
				try {
					Runtime.getRuntime().exec("explorer "+baseURL+"/Help/topoDiscoverHelp.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
	}
}
