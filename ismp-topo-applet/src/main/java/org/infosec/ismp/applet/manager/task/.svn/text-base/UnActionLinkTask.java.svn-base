package org.infosec.ismp.applet.manager.task;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.LinkModel;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;

/**
 * 去除激活设备
 * @author 肖高峰
 *
 */
public class UnActionLinkTask extends SwingWorker<DeviceEntity, Object>{
	private LinkModel link;
	public UnActionLinkTask(LinkModel link) {
		if(link == null) return;
		this.link = link;
	}
	@Override
	protected DeviceEntity doInBackground() throws Exception {
		return null;
	}
	
	 protected void done() {
		 try {
			get();
			link.setLinkState(0);
			link.putLinkFlowing(false);
			link.putLinkColor(new Color(180,180,180));
			link.putLinkWidth(3);
			link.getAlarmState().clear();
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"后台关闭激活连接发生错误！" , "错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
