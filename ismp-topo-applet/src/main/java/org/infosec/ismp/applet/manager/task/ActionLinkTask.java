package org.infosec.ismp.applet.manager.task;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.LinkModel;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;

import twaver.AlarmSeverity;

/**
 * 激活设备
 * @author 肖高峰
 *
 */
public class ActionLinkTask extends SwingWorker<DeviceEntity, Object>{
	private LinkModel link;
	public ActionLinkTask(LinkModel link) {
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
			link.putLinkFlowing(true);
			link.putLinkFlowingColor(Color.GREEN);
		//	link.getAlarmState().setNewAlarmCount(AlarmSeverity.WARNING, (int)Math.random()*100);
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"后台激活连接发生错误！" , "错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
