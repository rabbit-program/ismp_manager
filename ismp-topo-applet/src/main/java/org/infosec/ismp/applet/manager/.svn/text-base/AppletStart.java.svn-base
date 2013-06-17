package org.infosec.ismp.applet.manager;

import java.awt.BorderLayout;

import javax.swing.JApplet;

import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.applet.manager.application.MainPane;
import org.infosec.ismp.applet.manager.task.SaveAllTask;
import org.infosec.ismp.applet.manager.utilities.InitUtil;

@SuppressWarnings("deprecation")
public class AppletStart extends JApplet{
	private static final long serialVersionUID = -4387292966840433407L;
	
	static {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			com.birosoft.liquid.LiquidLookAndFeel.setLiquidDecorations(true);
			com.birosoft.liquid.LiquidLookAndFeel.setShowTableGrids(true);
			com.birosoft.liquid.LiquidLookAndFeel.setDefaultRowBackgroundMode(true);
			com.birosoft.liquid.LiquidLookAndFeel.setDefaultTableBackgroundMode(true);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		InitUtil.init();
	}
	
	public void init() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			com.birosoft.liquid.LiquidLookAndFeel.setLiquidDecorations(true);
			com.birosoft.liquid.LiquidLookAndFeel.setShowTableGrids(true);
			com.birosoft.liquid.LiquidLookAndFeel.setDefaultRowBackgroundMode(true);
			com.birosoft.liquid.LiquidLookAndFeel.setDefaultTableBackgroundMode(true);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		String baseURL = getParameter("basePath");
	//	SysInitArgs.WEB_URL_BASE
	//	String baseURL = "http://192.168.9.128:8080/manager-web";
	//	String baseURL = "http://192.168.9.200:80/manager-web";
	//	String baseURL = getParameter("basePath");
		ServerConfig.init(baseURL);
		InitUtil.initDatabaseData();
		this.getContentPane().setLayout(new BorderLayout());
    	this.getContentPane().add(new MainPane(), BorderLayout.CENTER);
	}
	
	public void stop() {
		new SaveAllTask().execute();
	}
}
