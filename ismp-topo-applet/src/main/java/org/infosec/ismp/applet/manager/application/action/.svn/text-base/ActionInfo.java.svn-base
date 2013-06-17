package org.infosec.ismp.applet.manager.application.action;

import javax.swing.JOptionPane;

import org.infosec.ismp.applet.manager.application.active.ActiveDevice;
import org.infosec.ismp.applet.manager.component.panel.HostDeviceInfoPanel;
import org.infosec.ismp.applet.manager.component.panel.OtherNetworkDeviceInfoPanel;
import org.infosec.ismp.applet.manager.component.panel.SensorInfoPanel;
import org.infosec.ismp.applet.manager.component.panel.database.OraclePanel;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;
import org.infosec.ismp.applet.manager.component.panel.weblogic.WeblogicPanel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.model.TopoServerModel;

/**
 * 获得信息面板
 * @author 肖高峰
 *
 */
public class ActionInfo {
	
	public static void actionDeviceInfo(NodeModel node) {
		if(isActive(node)) {
			if(node instanceof TopoServerModel) {
				new HostDeviceInfoPanel(node);
			} else {
				new OtherNetworkDeviceInfoPanel(node);
			}
		}
	}
	
	public static void actionSensorInfo(NodeModel node) {
		if(isActive(node)) {
			new SensorInfoPanel(node);
		}
	}
	public static void actionDatabaseInfo(NodeModel node) {
		if(isActive(node)) {
			OraclePanel o = new OraclePanel(node);
			SJTUUtils.showCompoentInFrame(o,node);
		}
	}
	
	public static void actionWeblogicInfo(NodeModel node) {
		if(isActive(node)) {
			SJTUUtils.showCompoentInFrame(new WeblogicPanel(node),node);
		}
	}
	
	private static boolean isActive(NodeModel node) {
		boolean isAction = true;
		if(node.getStatus() == null || node.getStatus().equals(0)) {
			if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, 
					"设备： "+node.getName()+" 未监控！\n是否立刻开启？"
					, "提示", JOptionPane.YES_NO_OPTION)) {
				ActiveDevice.activeDevice(node);	
			} else {
				isAction = false;
			}
		}
		return isAction;
	}
	
}
