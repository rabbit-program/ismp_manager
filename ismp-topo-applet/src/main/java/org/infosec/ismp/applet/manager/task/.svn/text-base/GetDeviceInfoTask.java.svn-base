package org.infosec.ismp.applet.manager.task;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceInformation;

/**
 * 激活设备
 * @author 肖高峰
 *
 */
public class GetDeviceInfoTask extends SwingWorker<DeviceInformation, Object>{
	private NodeModel node;
	public GetDeviceInfoTask(NodeModel node) {
		if(node == null) return;
		this.node = node;
	}
	@Override
	protected DeviceInformation doInBackground() throws Exception {
		return ServiceUtil.newInstance().getTopoManagerDeviceService().getInformation(ChangeModelUtil.changeDeviceEntity(node));
	}
	
	 protected void done() {
		 try {
			node.setDeviceInfomation(get());
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"获取动态信息发生错误！" , "错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
