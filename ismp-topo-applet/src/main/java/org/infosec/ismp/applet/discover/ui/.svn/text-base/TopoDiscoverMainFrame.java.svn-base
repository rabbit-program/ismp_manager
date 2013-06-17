package org.infosec.ismp.applet.discover.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.applet.discover.service.CDPSearchAppletService;
import org.infosec.ismp.applet.discover.service.ICMPSearchAppletService;
import org.infosec.ismp.applet.discover.service.PCSearchAppletService;
import org.infosec.ismp.applet.discover.service.SNMPSearchAppletService;


/**
 * TopoDiscoverMainFrame
 * @author sshanshan
 * @date 2009-06-16
 * @version 1.0
 */
public class TopoDiscoverMainFrame extends JFrame{

	/**
	 * 构造函数
	 */
	public TopoDiscoverMainFrame(int userId){
//		String roleName = "";
//		for(String role : roleNameList){
//			if(roleName.equals("")){
//				roleName = role;
//			}else{
//				roleName = roleName + "," +role;
//			}
//		}
		MainPanel mainPanel = new MainPanel(userId, ServerConfig.getServerPath());
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(800,560);
        this.setLocation((screenDimension.width - this.getSize().width) / 2,
                (screenDimension.height - this.getSize().height) / 2);
        this.setTitle("拓扑发现");
        this.setLayout(new BorderLayout());
        this.getContentPane().add(mainPanel,BorderLayout.CENTER);
        this.setVisible(true);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
        	/**
        	 * 关闭窗口时，停止正在运行的icmp，snmp发现操作
        	 */
            public void windowClosing(WindowEvent e) {
            	Thread clossWindowThread = new Thread() {
					public void run() {
		            	ICMPSearchAppletService icmpSearchService = ICMPSearchAppletService.getInstance();
		                if(icmpSearchService!=null&icmpSearchService.isSearching()){
		                	icmpSearchService.stopSearch(true);
		                }
		                SNMPSearchAppletService snmpSearchService = SNMPSearchAppletService.getInstance();
		                if(snmpSearchService!=null&snmpSearchService.isSearching()){
		                	snmpSearchService.stopSearch(true);
		                }
		                CDPSearchAppletService cdpSearchService = CDPSearchAppletService.getInstance();
		                if(cdpSearchService!=null&cdpSearchService.isSearching()){
		                	snmpSearchService.stopSearch(true);
		                }
		                PCSearchAppletService pcSearchService = PCSearchAppletService.getInstance();
		                if(pcSearchService!=null&pcSearchService.isSearching()){
		                	pcSearchService.stopSearch(true);
		                }
					}
				};
				clossWindowThread.start();
                setVisible(false);
                dispose();
            }
        });
	}
	
	
	public static void main(String[] args) {
		String baseURL = "http://192.168.9.99:8080/manager-web";
		ServerConfig.init(baseURL);
		List<String> roleNameList = new ArrayList<String>();
		for(int i=1;i<=5;i++){
			roleNameList.add("role"+i);
		}
		TopoDiscoverMainFrame f = new TopoDiscoverMainFrame(1);
        
    }
	
}
