package org.infosec.ismp.applet.manager.task;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;

/**
 * 去除激活设备
 * @author 肖高峰
 *
 */
public class UnActionDeviceTask extends SwingWorker<DeviceEntity, Object>{
	private NodeModel node;
	public UnActionDeviceTask(NodeModel node) {
		if(node == null) return;
		this.node = node;
	}
	@Override
	protected DeviceEntity doInBackground() throws Exception {
		ServiceUtil.newInstance().getTopoManagerDeviceService().unActiveDevice(ChangeModelUtil.changeDeviceEntity(node));
		return null;
	}
	
	 protected void done() {
		 try {
			get();
			node.setStatus(0);
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"后台关闭激活设备发生错误！" , "错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
