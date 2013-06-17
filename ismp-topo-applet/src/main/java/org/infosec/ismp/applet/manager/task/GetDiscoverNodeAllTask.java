package org.infosec.ismp.applet.manager.task;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;

/**
 * 激活设备
 * @author 肖高峰
 *
 */
public class GetDiscoverNodeAllTask extends SwingWorker<List<DeviceEntity>, Object>{
	@Override
	protected List<DeviceEntity> doInBackground() throws Exception {
		return ServiceUtil.newInstance().getWebDeviceService().getTopoDiscoverDeviceAll();
	}
	
	 protected void done() {
		 try {
			get();
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"保存拓扑发现设备发生错误！" , "错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
