package org.infosec.ismp.applet.manager.application.active;

import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.task.ActionDeviceTask;
import org.infosec.ismp.applet.manager.task.UnActionDeviceTask;

public class ActiveDevice {
	public static void activeDevice(NodeModel node) {
		node.setStatus(1);
		new ActionDeviceTask(node).execute();
	}
	
	public static void unActionDevice(NodeModel node) {
		node.setStatus(0);
		new UnActionDeviceTask(node).execute();
	}
	
}
