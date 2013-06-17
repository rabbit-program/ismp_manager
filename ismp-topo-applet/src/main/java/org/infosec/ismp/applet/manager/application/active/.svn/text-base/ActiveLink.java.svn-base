package org.infosec.ismp.applet.manager.application.active;

import javax.swing.JOptionPane;

import org.infosec.ismp.applet.manager.model.LinkModel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.task.ActionDeviceTask;
import org.infosec.ismp.applet.manager.task.ActionLinkTask;
import org.infosec.ismp.applet.manager.task.UnActionLinkTask;

public class ActiveLink {
	public static void activeLink(LinkModel link) {
		NodeModel fromNode = (NodeModel)link.getFrom();
		NodeModel toNode = (NodeModel)link.getTo();
		String fromInfo = "";
		String toInfo = "";
		String info = "";
		boolean isAction = true;
		if(fromNode.getStatus() == null || fromNode.getStatus() == 0) {
			fromInfo = fromNode.getName();
			info = fromInfo;
		}
		if(toNode.getStatus() == null || toNode.getStatus() == 0) {
			toInfo = toNode.getName();
			info += " , "+toInfo; 
		}
		if(!fromInfo.equals("") || !toInfo.equals("")) {
			if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, 
					"设备： "+info+" 未监控！\n是否立刻开启？"
					, "提示", JOptionPane.YES_NO_OPTION)) {
					if(!fromInfo.equals("")) {
						new ActionDeviceTask(fromNode).execute();
					}
					if(!toInfo.equals("")) {
						new ActionDeviceTask(toNode).execute();
					}
				} else {
					isAction = false;
				}
		}
		if(isAction) {
			link.setLinkState(1);
			new ActionLinkTask(link).execute();
		}
	}
	
	public static void unActionLink(LinkModel link) {
		link.setLinkState(0);
		new UnActionLinkTask(link).execute();
	}
}
