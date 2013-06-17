package org.infosec.ismp.applet.comm;

import org.infosec.ismp.applet.manager.task.GetDiscoverLinkAllTask;
import org.infosec.ismp.applet.manager.task.GetDiscoverNodeAllTask;

public class TopoDiscoverService {
	/**
	 * 显示拓扑发现数据
	 */
	public static void displayTopoDiscover() throws Exception {
		new GetDiscoverNodeAllTask().execute();
		new GetDiscoverLinkAllTask().execute();
	}
}
