package org.infosec.ismp.applet.manager.component.button;

import twaver.Node;
import twaver.TUIManager;

@SuppressWarnings("serial")
public class TopoLayout extends Node{
	/**浮动文字提示*/
	private String tip = "拓扑布局";
	
	static {
		TUIManager.registerIcon(TopoLayout.class, "/org/infosec/ismp/applet/manager/model/image/layout.gif");
	}
	public TopoLayout() {
		setName(tip);
	}
}
