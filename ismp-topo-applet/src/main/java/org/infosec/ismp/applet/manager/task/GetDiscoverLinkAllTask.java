package org.infosec.ismp.applet.manager.task;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.LinkEntity;

/**
 * 激活设备
 * @author 肖高峰
 *
 */
public class GetDiscoverLinkAllTask extends SwingWorker<List<LinkEntity>, Object>{
	@Override
	protected List<LinkEntity> doInBackground() throws Exception {
		return ServiceUtil.newInstance().getWebDeviceService().getTopoDiscoverLinkAll();
	}
	
	 protected void done() {
		 try {
			get();
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"后台激活设备发生错误！" , "错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
